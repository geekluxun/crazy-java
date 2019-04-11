package com.geekluxun.effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// Builder pattern for class hierarchies (Page 14)

// Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    /**
     * 使用了保护性拷贝
     *
     * @param builder
     */
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
