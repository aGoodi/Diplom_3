package main;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }
}
