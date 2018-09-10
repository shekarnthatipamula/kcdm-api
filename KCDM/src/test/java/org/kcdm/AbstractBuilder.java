package org.kcdm;

import com.github.javafaker.Faker;

public abstract class AbstractBuilder<M> {
    public static Faker getFaker(){
        return FakerBuilder.getFaker();
    }
    public abstract M build();

}
