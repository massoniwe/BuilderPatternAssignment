import java.util.List;

public interface PizzaBuilder {
    PizzaBuilder reset();
    PizzaBuilder setSize(String size);
    PizzaBuilder setDough(String dough);
    PizzaBuilder setSauce(String sauce);
    PizzaBuilder setToppings(List<String> toppings);
    PizzaBuilder setCheese(boolean hasExtraCheese);
}
