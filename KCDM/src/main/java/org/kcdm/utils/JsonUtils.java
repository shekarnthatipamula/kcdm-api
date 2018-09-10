/*
 * Copyright (c) 2017. Niranta Services and Solutions Pvt. Ltd.
 */

package org.kcdm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Hari Krishna Ganji <harikrishna.ganji@niranta.in>
 */
public class JsonUtils {

    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'";

    private static Gson gson;

    private static ObjectMapper objectMapper;

    public static Gson getGsonInstance() {
        if(null == gson) {
            gson = (new GsonBuilder())
                    .setPrettyPrinting()
                    .setDateFormat(ISO_DATE_FORMAT)
                    .create();
        }

        return gson;
    }

    public static ObjectMapper getJacksonInstance() {
        if(null == objectMapper) {
            objectMapper = new ObjectMapper();

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        }

        return objectMapper;
    }
}
