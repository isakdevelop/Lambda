package com.dennis.api.proxy;

import java.util.Objects;
import java.util.function.Function;

public class TypeProxy <T> {
    // 뮤터블을 임뮤터블로 리턴
    public static Function<?, String> string = String :: valueOf;

    public static Function<String, Integer> replaceInt = Integer::valueOf;
    public static Function<String, Double> replaceDouble = Double::valueOf;
    public static Function<String, Float> replaceFloat = Float::valueOf;
    public static Function<String, Long> replaceLong = Long::valueOf;

}
