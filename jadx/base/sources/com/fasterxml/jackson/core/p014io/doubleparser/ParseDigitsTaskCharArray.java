package com.fasterxml.jackson.core.p014io.doubleparser;

import java.math.BigInteger;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class ParseDigitsTaskCharArray {
    static final int RECURSION_THRESHOLD = 400;

    private ParseDigitsTaskCharArray() {
    }

    static BigInteger parseDigitsIterative(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        BigSignificand bigSignificand = new BigSignificand(FastIntegerMath.estimateNumBits(i3));
        int i4 = (i3 & 7) + i;
        int iTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i4);
        boolean z = iTryToParseUpTo7Digits >= 0;
        bigSignificand.add(iTryToParseUpTo7Digits);
        while (i4 < i2) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(cArr, i4);
            z &= iTryToParseEightDigits >= 0;
            bigSignificand.fma(100000000, iTryToParseEightDigits);
            i4 += 8;
        }
        if (!z) {
            throw new NumberFormatException("illegal syntax");
        }
        return bigSignificand.toBigInteger();
    }

    static BigInteger parseDigitsRecursive(char[] cArr, int i, int i2, Map<Integer, BigInteger> map) {
        if (i2 - i <= 400) {
            return parseDigitsIterative(cArr, i, i2);
        }
        int iSplitFloor16 = FastIntegerMath.splitFloor16(i, i2);
        return parseDigitsRecursive(cArr, iSplitFloor16, i2, map).add(FftMultiplier.multiply(parseDigitsRecursive(cArr, i, iSplitFloor16, map), map.get(Integer.valueOf(i2 - iSplitFloor16))));
    }
}
