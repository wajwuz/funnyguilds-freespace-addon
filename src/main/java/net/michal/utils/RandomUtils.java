package net.michal.utils;

import org.apache.commons.lang.Validate;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomInt(final int min, final int max) throws IllegalArgumentException {
        Validate.isTrue(max > min, "Max can't be smaller than min!");

        return random.nextInt(max - min + 1) + min;
    }
}
