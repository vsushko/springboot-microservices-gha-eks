package com.vsushko.core.storecore.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonUtils.
 *
 * @author vsushko
 */
public final class JsonUtils {

    private JsonUtils() {

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
