import java.util.List;
import java.util.ArrayList;

public class ConcretePizzaBuilder implements PizzaBuilder{
    private String size;
    private String dough = "Standard";
    private String sauce;
    private List<String> toppings = new ArrayList<>();
    private boolean hasExtraCheese = false;

    @Override
    public PizzaBuilder reset() {
        this.size=null;
        this.dough="Standard";
        this.sauce=null;
        this.toppings=new ArrayList<>();
        this.hasExtraCheese=false;
        return this;
    }
    @Override
    public PizzaBuilder setSize(String size){
        this.size=size;
        return this;
    }
    @Override
    public PizzaBuilder setDough(String dough){
        this.dough=dough;
        return this;
    }
    @Override
    public PizzaBuilder setSauce(String sauce){
        this.sauce=sauce;
        return this;
    }
    @Override
    public PizzaBuilder setToppings(List<String> toppings){
        this.toppings=toppings;
        return this;
    }
    @Override
    public PizzaBuilder setCheese(boolean hasExtraCheese){
        this.hasExtraCheese=hasExtraCheese;
        return this;
    }
    @Override
    public Pizza build(){

    }
}
