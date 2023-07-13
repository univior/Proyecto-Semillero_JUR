package com.lulobank.factory;

import com.github.javafaker.Faker;

import net.bytebuddy.asm.Advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateImageDataFactory {

    private static final Faker FAKER = new Faker();

    public static final String id_favourites = String.valueOf(FAKER.random().nextInt(232365209 , 232365211));

    static List <String> IMAGE_ID = Arrays.asList("9ccXTANkb8","9ccXTANkb9","9ccXTANkb10","9ccXTANkb11","9ccXTANkb12","9ccXTANkb13",
            "9ccXTANkb14","9ccXTANkb15","9ccXTANkb16","9ccXTANkb17");

    public static final String id = IMAGE_ID.get (FAKER.random().nextInt(1,10));

 public static final List<String> image_id = Arrays.asList("9ccXTANkb20","9ccXTANkb21","9ccXTANkb22","9ccXTANkb23");
 //public static final String idImage = idImage.get(FAKER.random().nextInt(1,4));

    public static final String SUB_ID_FAVOURITES = String.valueOf(FAKER.random().nextInt(223, 523));





    }


