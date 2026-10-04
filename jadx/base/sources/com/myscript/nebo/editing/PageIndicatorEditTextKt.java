package com.myscript.nebo.editing;

import kotlin.Metadata;

/* JADX INFO: compiled from: PageIndicatorEditText.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"numberOfDigits", "", "getNumberOfDigits", "(I)I", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageIndicatorEditTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int getNumberOfDigits(int i) {
        if (i == 0) {
            return 1;
        }
        return ((int) Math.log10(Math.abs(i))) + 1;
    }
}
