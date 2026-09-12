import java.util.List;

public class Pizza {
    private final String size;
    private final String dough;
    private final String sauce;
    private final List<String> toppings;
    private final boolean hasExtraCheese;

    public Pizza(String size, String dough, String sauce, List<String> toppings, boolean hasExtraCheese){
        this.size = size;
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = toppings;
        this.hasExtraCheese = hasExtraCheese;
    }

    @Override
    public String toString() {
        return "Pizza: " + size + ", dough: " + dough + ", sauce: " + sauce +
                ", toppings: " + toppings + ", extra cheese: " + hasExtraCheese;
    }
}
