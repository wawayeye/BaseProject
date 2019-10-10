package com.tuandai.baseproject.util;

import java.util.UUID;

public class CommonUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
