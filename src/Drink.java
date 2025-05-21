public class Drink extends Product {
    private Integer size;

    public Drink(String id, String name, Double price, Integer stock, Integer size) {
        super("D" + id, name, price, stock);
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String displayInfo() {
        return String.format("""
                ID      : %s
                Name    : %s
                Price   : Rp. %.2f
                Size    : %d ml
                Stock   : %d
                """, getId(), getName(), getPrice(), getSize(), getStock());
    }
}
