# Builder Pattern Implementation — Pizza Domain

## Overview
This project is a Java implementation of the **Builder Creational Design Pattern** applied to a Pizza domain. It demonstrates how to construct complex objects step-by-step using both a manual fluent interface and pre-configured recipes managed by a Director.

## Architecture & Components
* **Product (`Pizza`)**: A domain class representing the complex object being built with internal state (size, dough, sauce, toppings, extra cheese).
* **Builder Interface (`PizzaBuilder`)**: Declares step-by-step construction methods, state reset capabilities, and the final `build()` method.
* **Concrete Builder (`ConcretePizzaBuilder`)**: Implements `PizzaBuilder`, manages local build state, enforces state validation, and returns the constructed `Pizza`.
* **Director (`ChefDirector`)**: Defines specific recipe sequences (`makeMargherita`, `makePepperoni`) using the `PizzaBuilder` abstraction.
* **Client (`Main`)**: Demonstrates and tests director-based construction, manual fluent API construction, and exception handling during invalid states.

---

## Clean Code Principles Applied

### 1. Validated Construction (Fail-Fast Principle)
**Justification**: Objects should never be instantiated in an invalid or incomplete state. The `build()` method validates required properties (`size` and `sauce`) before instantiating the `Pizza` object, throwing an `IllegalStateException` if mandatory criteria are missing.

```java
// BEFORE (Unvalidated creation risking broken objects):
public Pizza build() {
    return new Pizza(size, dough, sauce, toppings, hasExtraCheese);
}

// AFTER (Clean Code validation):
@Override
public Pizza build() {
    if (size == null || size.isEmpty()) {
        throw new IllegalStateException("Pizza size is required!");
    }
    if (sauce == null || sauce.isEmpty()) {
        throw new IllegalStateException("Pizza sauce is required!");
    }
    return new Pizza(size, dough, sauce, toppings, hasExtraCheese);
}

2. Fluent API & Method Chaining
Justification: Builder setters return this (the builder instance), enabling natural method chaining. This avoids repetitive references to the builder variable and improves code readability.
// BEFORE (Verbose step-by-step calls):
ConcretePizzaBuilder builder = new ConcretePizzaBuilder();
builder.setSize("Small");
builder.setDough("Thin");
builder.setSauce("Barbecue");
Pizza pizza = builder.build();

// AFTER (Fluent method chaining):
Pizza customPizza = builder.reset()
        .setSize("Small")
        .setDough("Thin")
        .setSauce("Barbecue")
        .setCheese(true)
        .build();


3. Dependency Inversion Principle (DIP) / Abstraction
Justification: High-level modules like ChefDirector depend on the PizzaBuilder interface rather than concrete implementations (ConcretePizzaBuilder). This decouples recipe definitions from specific builder implementations.
// BEFORE (Tightly coupled to concrete implementation):
public void makeMargherita(ConcretePizzaBuilder builder) { ... }

// AFTER (Clean abstraction dependency):
public void makeMargherita(PizzaBuilder builder) {
    builder.reset()
           .setSize("Medium")
           .setDough("Thin")
           .setSauce("Tomato")
           .setToppings(List.of("Mozzarella", "Basil"))
           .setCheese(true);
}

4. Single Responsibility Principle (SRP)
Justification: Responsibilities are isolated across distinct classes:

Pizza: Holds domain state and formatting (toString).

ConcretePizzaBuilder: Accumulates parameters and enforces validation rules.

ChefDirector: Coordinates reusable recipe construction steps

// Isolated recipe configuration in ChefDirector:
public class ChefDirector {
    public void makePepperoni(PizzaBuilder builder) {
        builder.reset()
               .setSize("Large")
               .setDough("Standard")
               .setSauce("Tomato")
               .setToppings(List.of("Mozzarella", "Pepperoni", "Oregano"))
               .setCheese(false);
    }
}
5. Intention-Revealing Names & Explicit Overrides
Justification: Variable names, methods, and parameters clearly state their intent without needing inline comments (hasExtraCheese, makeMargherita, reset). Explicit @Override annotations ensure compiler enforcement of interface contracts.
@Override
public PizzaBuilder setCheese(boolean hasExtraCheese) {
    this.hasExtraCheese = hasExtraCheese;
    return this;
}
