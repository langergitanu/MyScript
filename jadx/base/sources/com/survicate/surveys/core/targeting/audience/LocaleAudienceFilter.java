package com.survicate.surveys.core.targeting.audience;

import com.survicate.surveys.core.providers.LocaleProvider;
import com.survicate.surveys.core.utils.LocaleUtils;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocaleAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/LocaleAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "values", "", "", "exclude", "", "localeProvider", "Lcom/survicate/surveys/core/providers/LocaleProvider;", "<init>", "(Ljava/util/List;ZLcom/survicate/surveys/core/providers/LocaleProvider;)V", "isSatisfied", "matchesExactly", "expectedLocale", "currentLocale", "matchesLanguage", "matchesChineseVariant", "matchesNorwegianVariant", "hasRegion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LocaleAudienceFilter implements AudienceFilter {
    private final boolean exclude;
    private final LocaleProvider localeProvider;
    private final List<String> values;

    public LocaleAudienceFilter(List<String> values, boolean z, LocaleProvider localeProvider) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.values = values;
        this.exclude = z;
        this.localeProvider = localeProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        boolean z;
        String twoPartLocale = LocaleUtils.INSTANCE.getTwoPartLocale(this.localeProvider.getDeviceLanguage());
        List<String> list = this.values;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            for (String str : list) {
                if (matchesExactly(str, twoPartLocale) || matchesLanguage(str, twoPartLocale) || matchesChineseVariant(str, twoPartLocale) || matchesNorwegianVariant(str, twoPartLocale)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return this.exclude ? !z : z;
    }

    private final boolean matchesExactly(String expectedLocale, String currentLocale) {
        return StringsKt.equals(expectedLocale, currentLocale, true);
    }

    private final boolean matchesLanguage(String expectedLocale, String currentLocale) {
        if (!hasRegion(currentLocale) || hasRegion(expectedLocale)) {
            return false;
        }
        return StringsKt.equals(expectedLocale, StringsKt.substringBefore$default(currentLocale, "-", (String) null, 2, (Object) null), true);
    }

    private final boolean matchesChineseVariant(String expectedLocale, String currentLocale) {
        if (!StringsKt.startsWith$default(expectedLocale, "zh", false, 2, (Object) null)) {
            return false;
        }
        String lowerCase = currentLocale.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = expectedLocale.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase2, "zh-tw") || Intrinsics.areEqual(lowerCase2, "zh-hant")) {
            return LocaleUtils.INSTANCE.getTraditionalChineseVariants().contains(lowerCase);
        }
        if (Intrinsics.areEqual(lowerCase2, "zh") || Intrinsics.areEqual(lowerCase2, "zh-hans")) {
            return LocaleUtils.INSTANCE.getSimplifiedChineseVariants().contains(lowerCase);
        }
        return false;
    }

    private final boolean matchesNorwegianVariant(String expectedLocale, String currentLocale) {
        if (!StringsKt.equals(expectedLocale, "no", true)) {
            return false;
        }
        String lowerCase = StringsKt.substringBefore$default(currentLocale, "-", (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return LocaleUtils.INSTANCE.getNorwegianVariants().contains(lowerCase);
    }

    private final boolean hasRegion(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "-", false, 2, (Object) null);
    }
}
