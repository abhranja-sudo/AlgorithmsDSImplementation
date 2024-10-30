package com.ar50645.OOD;


import java.util.ArrayList;
import java.util.List;


public enum Size {
    SMALL(8),
    MEDIUM(10),
    LARGE(12);
    Size(int price) {
        this.price = price;
    }
    private final int price;
}


public enum CrustType {
    THIN(0),
    THICK(2),
    CHEESE_BURST(3);
    private final int price;
    CrustType(int price) {
        this.price = price;
    }
}

public enum Toppings {
    MUSHROOMS,
    PEPPERS,
    ONIONS,
    OLIVES
    private final int price;
    Toppings(int price) {
        this.price = price;
    }
}

class Pizza {
    private final Size size;
    private final List<Toppings> toppings;
    private final CrustType crustType;

    Pizza(PizzaBuilder builder) {
        size = builder.size;
        toppings = builder.toppings;
        crustType = builder.crustType;
    }

    PizzaBuilder getBuilder() {
        return new PizzaBuilder();
    }
    public static class PizzaBuilder {
        private Size size;
        private List<Toppings> toppings = new ArrayList<>();
        private CrustType crustType;

        PizzaBuilder withSize(Size size) {
            this.size = size;
            return this;
        }

        PizzaBuilder withTopping(Toppings topping) {
            this.toppings.add(topping);
            return this;
        }

        PizzaBuilder withCrustType(CrustType crustType) {
            this.crustType = crustType;
            return this;
        }

        Pizza build() {
            return new Pizza(this);
        }

    }

    interface DiscountStrategy {
        double applyDiscount(double amount);
    }

    class BulkOrderDiscount implements DiscountStrategy {
        public double applyDiscount(double amount) {
            return 0.10 * amount;
        }
    }

    class HappyHourDiscount implements DiscountStrategy {
        public double applyDiscount(Order order) {
            return 0.15 * amount;
        }
    }


    public class Order {
        private final
    }

}
