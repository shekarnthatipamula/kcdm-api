package org.kcdm;

import com.github.javafaker.Faker;

public class FakerBuilder {
    private static Faker faker=null;
    public static Faker getFaker(){
        if(faker==null){
            faker=new Faker();
        }
        return faker;
    }
}
