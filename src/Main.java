import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    public static void seedProducts() {
        Integer id = 1;

        products.add(new Food(String.valueOf(id++), "Nasi Goreng", 15000.0, 10, false));
        products.add(new Food(String.valueOf(id++), "Salad Sayur", 12000.0, 8, true));
        products.add(new Food(String.valueOf(id++), "Bakso", 17000.0, 5, false));
        products.add(new Food(String.valueOf(id++), "Tahu Isi", 8000.0, 12, true));

        products.add(new Drink(String.valueOf(id++), "Es Teh Manis", 5000.0, 20, 300));
        products.add(new Drink(String.valueOf(id++), "Kopi Hitam", 7000.0, 15, 250));
        products.add(new Drink(String.valueOf(id++), "Susu Coklat", 9000.0, 10, 350));
        products.add(new Drink(String.valueOf(id++), "Air Mineral", 3000.0, 30, 600));
    }

    public static void printMenu() {
        System.out.println("Welcome to my restaurant!");
        System.out.println("=========================");
        System.out.println("1. View all products");
        System.out.println("2. Insert new product");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product");
        System.out.println("5. Buy product");
        System.out.println("0. Exit");
    }

    public static void printChooseProductTypeMenu() {
        System.out.println("Choose product type");
        System.out.println("1. Food");
        System.out.println("2. Drink");
    }

    public static Product getProductById(String id) {
        if (products.isEmpty()) {
            return null;
        }

        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        return null;
    }

    public static void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("There are no products");
            return;
        }

        for (Product p : products) {
            System.out.println(p.displayInfo());
            System.out.println("-----------------------");
        }
    }

    public static void insertProduct() {
        try {
            printChooseProductTypeMenu();
            System.out.println("Enter product type: ");
            Integer productTypeChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            Double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter product stock: ");
            Integer stock = scanner.nextInt();
            scanner.nextLine();

            boolean isVegetarian = false;

            if (productTypeChoice == 1) {
                System.out.print("Vegetarian (Yes/No): ");
                String vegetarian = scanner.nextLine();

                if (vegetarian.equalsIgnoreCase("yes")) {
                    isVegetarian = true;
                }

                products.add(new Food(String.valueOf(products.size() + 1), name, price, stock, isVegetarian));
            } else {
                System.out.print("Size (ml): ");
                Integer size = scanner.nextInt();
                scanner.nextLine();

                products.add(new Drink(String.valueOf(products.size() + 1), name, price, stock, size));
            }

            System.out.println("Product added successfully!");
        } catch (Exception exception) {
            System.out.println("Invalid input");
        }
    }

    public static void editProduct() {
        try {
            viewAllProducts();
            System.out.print("Enter product ID: ");
            String id = scanner.nextLine();

            Product product = getProductById(id);

            if (product == null) {
                System.out.println("Product not found");
                return;
            }

            System.out.print("Enter product name [" + product.getName() + "]: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price [" + product.getPrice() + "]: ");
            Double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter product stock [" + product.getStock() + "]: ");
            Integer stock = scanner.nextInt();
            scanner.nextLine();

            if (product instanceof Food food) {
                System.out.print("Vegetarian (Yes/No) [" + food.getVegetarian() + "]: ");
                String vegetarian = scanner.nextLine();

                food.setVegetarian(vegetarian.equalsIgnoreCase("yes"));
                food.setName(name);
                food.setPrice(price);
                food.setStock(stock);
            } else if (product instanceof Drink drink) {
                System.out.print("Size (ml) [" + drink.getSize() + "]: ");
                Integer size = scanner.nextInt();
                scanner.nextLine();

                drink.setSize(size);
                drink.setPrice(price);
                drink.setStock(stock);
                drink.setName(name);
            }

            System.out.println("Product edited successfully!");
        } catch (Exception exception) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteProduct() {
        try {
            viewAllProducts();

            System.out.print("Enter product ID: ");
            String id = scanner.nextLine();
            Product product = getProductById(id);

            if (product == null) {
                System.out.println("Product not found");
                return;
            }

            products.remove(product);

            System.out.println("Product deleted successfully!");
        } catch (Exception exception) {
            System.out.println("Invalid input");
        }
    }

    public static void buyProduct() {
        try {
            viewAllProducts();

            System.out.print("Enter product ID: ");
            String id = scanner.nextLine();

            Product product = getProductById(id);

            if (product == null) {
                System.out.println("Product not found");
                return;
            }

            if (!product.isAvailable()) {
                System.out.println("Product is not available");
                return;
            }

            System.out.print("Enter quantity: ");
            Integer quantity = scanner.nextInt();
            scanner.nextLine();

            if (product.getStock() < quantity) {
                System.out.println("Product is too low on stock");
                return;
            }

            System.out.print("Enter your money: ");
            Double money = scanner.nextDouble();
            scanner.nextLine();

            if (product.getPrice() * quantity > money) {
                System.out.println("Not enough money");
                return;
            }

            product.reduceStock(quantity);

            System.out.println("Product has been purchased successfully");
        } catch (Exception exception) {
            System.out.println("Invalid input");
        }
    }

    public static void main(String[] args) {
        seedProducts();

        while (true) {
            try {
                printMenu();
                System.out.print("Choose an option: ");
                Integer choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        viewAllProducts();
                        break;

                    case 2:
                        insertProduct();
                        break;

                    case 3:
                        editProduct();
                        break;

                    case 4:
                        deleteProduct();
                        break;

                    case 5:
                        buyProduct();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception exception) {
                System.out.println("Invalid input");
            }
        }
    }

}