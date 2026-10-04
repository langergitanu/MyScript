package com.myscript.nebo.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: compiled from: StringExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"generateRandom", "", "maxLength", "", "common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StringExtKt {
    public static final String generateRandom(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(i);
        int iNextInt = Random.INSTANCE.nextInt(i);
        if (iNextInt >= 0) {
            int i2 = 0;
            while (true) {
                sb.append(str.charAt(Random.INSTANCE.nextInt(str.length())));
                if (i2 == iNextInt) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
