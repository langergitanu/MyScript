package com.survicate.surveys.utils.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0005"}, m1599d2 = {"ifNullOrEmpty", "", "defaultValue", "ifNullOrBlank", "ifNullOrBlankNullable", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class StringExtensionsKt {
    public static final String ifNullOrEmpty(String str, String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String str2 = str;
        return (str2 == null || str2.length() == 0) ? defaultValue : str;
    }

    public static final String ifNullOrBlank(String str, String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String str2 = str;
        return (str2 == null || StringsKt.isBlank(str2)) ? defaultValue : str;
    }

    public static final String ifNullOrBlankNullable(String str, String str2) {
        String str3 = str;
        return (str3 == null || StringsKt.isBlank(str3)) ? str2 : str;
    }
}
