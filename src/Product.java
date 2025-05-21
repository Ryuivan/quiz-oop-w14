import java.util.UUID;

public abstract class Product {
    protected String id;
    protected String name;
    protected Double price;
    protected Integer stock;

    public Product(String id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract String displayInfo();

    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int qty) throws Exception {
        if (qty > stock) throw new Exception("Stok tidak cukup.");
        stock -= qty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
