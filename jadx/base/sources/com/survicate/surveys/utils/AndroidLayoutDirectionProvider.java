package com.survicate.surveys.utils;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutDirectionProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/utils/AndroidLayoutDirectionProvider;", "Lcom/survicate/surveys/utils/LayoutDirectionProvider;", "<init>", "()V", "getLayoutDirection", "", "languageTag", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidLayoutDirectionProvider implements LayoutDirectionProvider {
    @Override // com.survicate.surveys.utils.LayoutDirectionProvider
    public int getLayoutDirection(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Locale localeForLanguageTag = Locale.forLanguageTag(languageTag);
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
        return TextUtils.getLayoutDirectionFromLocale(localeForLanguageTag);
    }
}
