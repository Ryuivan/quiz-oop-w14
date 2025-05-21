public class Food extends Product {

    private boolean isVegetarian;

    public Food(String id, String name, Double price, Integer stock, boolean isVegetarian) {
        super("F" + id, name, price, stock);
        this.isVegetarian = isVegetarian;
    }

    public String getVegetarian() {
        if (isVegetarian) {
            return "Vegetarian";
        } else {
            return "Not Vegetarian";
        }
    }

    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String displayInfo() {
        return String.format("""
                ID      : %s
                Name    : %s (%s)
                Price   : Rp. %.2f
                Stock   : %d
                """, getId(), getName(), getVegetarian(), getPrice(), getStock());
    }
}
