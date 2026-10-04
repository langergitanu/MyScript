package com.survicate.surveys.core.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocaleUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/core/utils/LocaleUtils;", "", "<init>", "()V", "LANGUAGE_SEPARATOR", "", "CHINESE_BASE_CODE", "CHINESE_TRADITIONAL", "CHINESE_TRADITIONAL_BY_SCRIPT", "CHINESE_SIMPLIFIED", "CHINESE_SIMPLIFIED_BY_SCRIPT", "traditionalChineseVariants", "", "getTraditionalChineseVariants", "()Ljava/util/List;", "simplifiedChineseVariants", "getSimplifiedChineseVariants", "NORWEGIAN_BACKEND_CODE", "norwegianVariants", "getNorwegianVariants", "getTwoPartLocale", "locale", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LocaleUtils {
    public static final String CHINESE_BASE_CODE = "zh";
    public static final String CHINESE_SIMPLIFIED = "zh";
    public static final String CHINESE_SIMPLIFIED_BY_SCRIPT = "zh-hans";
    public static final String CHINESE_TRADITIONAL = "zh-tw";
    public static final String CHINESE_TRADITIONAL_BY_SCRIPT = "zh-hant";
    public static final String LANGUAGE_SEPARATOR = "-";
    public static final String NORWEGIAN_BACKEND_CODE = "no";
    public static final LocaleUtils INSTANCE = new LocaleUtils();
    private static final List<String> traditionalChineseVariants = CollectionsKt.listOf((Object[]) new String[]{"zh-tw", "zh-hant", "zh-hk", "zh-mo"});
    private static final List<String> simplifiedChineseVariants = CollectionsKt.listOf((Object[]) new String[]{"zh", "zh-hans", "zh-cn", "zh-sg"});
    private static final List<String> norwegianVariants = CollectionsKt.listOf((Object[]) new String[]{"no", "nb", "nn"});

    private LocaleUtils() {
    }

    public final List<String> getTraditionalChineseVariants() {
        return traditionalChineseVariants;
    }

    public final List<String> getSimplifiedChineseVariants() {
        return simplifiedChineseVariants;
    }

    public final List<String> getNorwegianVariants() {
        return norwegianVariants;
    }

    public final String getTwoPartLocale(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return CollectionsKt.joinToString$default(CollectionsKt.take(StringsKt.split$default((CharSequence) locale, new String[]{"-"}, false, 0, 6, (Object) null), 2), "-", null, null, 0, null, null, 62, null);
    }
}
