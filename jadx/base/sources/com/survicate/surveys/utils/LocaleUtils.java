package com.survicate.surveys.utils;

import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocaleUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fJ(\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J(\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J(\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0002J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002J\f\u0010'\u001a\u00020\u0015*\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Lcom/survicate/surveys/utils/LocaleUtils;", "", "<init>", "()V", "LANGUAGE_SEPARATOR", "", "CHINESE_BASE_CODE", "CHINESE_TRADITIONAL_BACKEND_CODE", "CHINESE_TRADITIONAL_BY_SCRIPT", "CHINESE_SIMPLIFIED_BACKEND_CODE", "CHINESE_SIMPLIFIED_BY_SCRIPT", "traditionalChineseVariants", "", "getTraditionalChineseVariants", "()Ljava/util/List;", "simplifiedChineseVariants", "getSimplifiedChineseVariants", "NORWEGIAN_BACKEND_CODE", "norwegianVariants", "getNorwegianVariants", "traditionalChineseBackendLocale", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "simplifiedChineseBackendLocale", "findMatchingTranslation", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "surveyId", "locale", "translations", "findChineseVariantTranslation", "findNorwegianVariantTranslation", "findBaseLanguageTranslation", "findIgnoringCase", "getTwoPartLocale", "getDisplayName", "languageTag", "getTalkbackName", "getLocalizedName", "displayLocale", "asLanguageOption", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LocaleUtils {
    public static final String CHINESE_BASE_CODE = "zh";
    public static final String CHINESE_SIMPLIFIED_BACKEND_CODE = "zh";
    public static final String CHINESE_SIMPLIFIED_BY_SCRIPT = "zh-hans";
    public static final String CHINESE_TRADITIONAL_BACKEND_CODE = "zh-tw";
    public static final String CHINESE_TRADITIONAL_BY_SCRIPT = "zh-hant";
    public static final String LANGUAGE_SEPARATOR = "-";
    public static final String NORWEGIAN_BACKEND_CODE = "no";
    public static final LocaleUtils INSTANCE = new LocaleUtils();
    private static final List<String> traditionalChineseVariants = CollectionsKt.listOf((Object[]) new String[]{"zh-tw", "zh-hant", "zh-hk", "zh-mo"});
    private static final List<String> simplifiedChineseVariants = CollectionsKt.listOf((Object[]) new String[]{"zh", "zh-hans", "zh-cn", "zh-sg"});
    private static final List<String> norwegianVariants = CollectionsKt.listOf((Object[]) new String[]{"no", "nb", "nn"});
    private static final Locale traditionalChineseBackendLocale = Locale.forLanguageTag("zh-tw");
    private static final Locale simplifiedChineseBackendLocale = Locale.forLanguageTag("zh");

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

    public final SurveyTranslation findMatchingTranslation(String surveyId, String locale, List<SurveyTranslation> translations) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(translations, "translations");
        String twoPartLocale = getTwoPartLocale(locale);
        SurveyTranslation surveyTranslationFindIgnoringCase = findIgnoringCase(surveyId, twoPartLocale, translations);
        if (surveyTranslationFindIgnoringCase != null) {
            return surveyTranslationFindIgnoringCase;
        }
        SurveyTranslation surveyTranslationFindChineseVariantTranslation = findChineseVariantTranslation(surveyId, twoPartLocale, translations);
        if (surveyTranslationFindChineseVariantTranslation != null) {
            return surveyTranslationFindChineseVariantTranslation;
        }
        SurveyTranslation surveyTranslationFindNorwegianVariantTranslation = findNorwegianVariantTranslation(surveyId, twoPartLocale, translations);
        return surveyTranslationFindNorwegianVariantTranslation != null ? surveyTranslationFindNorwegianVariantTranslation : findBaseLanguageTranslation(surveyId, twoPartLocale, translations);
    }

    private final SurveyTranslation findChineseVariantTranslation(String surveyId, String locale, List<SurveyTranslation> translations) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = locale.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!StringsKt.startsWith$default(lowerCase, "zh", false, 2, (Object) null)) {
            return null;
        }
        if (traditionalChineseVariants.contains(lowerCase)) {
            SurveyTranslation surveyTranslationFindIgnoringCase = findIgnoringCase(surveyId, "zh-tw", translations);
            return surveyTranslationFindIgnoringCase == null ? findIgnoringCase(surveyId, "zh-hant", translations) : surveyTranslationFindIgnoringCase;
        }
        if (!simplifiedChineseVariants.contains(lowerCase)) {
            return null;
        }
        SurveyTranslation surveyTranslationFindIgnoringCase2 = findIgnoringCase(surveyId, "zh", translations);
        return surveyTranslationFindIgnoringCase2 == null ? findIgnoringCase(surveyId, "zh-hans", translations) : surveyTranslationFindIgnoringCase2;
    }

    private final SurveyTranslation findNorwegianVariantTranslation(String surveyId, String locale, List<SurveyTranslation> translations) {
        String strSubstringBefore$default = StringsKt.substringBefore$default(locale, "-", (String) null, 2, (Object) null);
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strSubstringBefore$default.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (norwegianVariants.contains(lowerCase)) {
            return findIgnoringCase(surveyId, "no", translations);
        }
        return null;
    }

    private final SurveyTranslation findBaseLanguageTranslation(String surveyId, String locale, List<SurveyTranslation> translations) {
        return findIgnoringCase(surveyId, StringsKt.substringBefore$default(locale, "-", (String) null, 2, (Object) null), translations);
    }

    private final SurveyTranslation findIgnoringCase(String surveyId, String locale, List<SurveyTranslation> translations) {
        Object next;
        Iterator<T> it = translations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SurveyTranslation surveyTranslation = (SurveyTranslation) next;
            if (Intrinsics.areEqual(surveyTranslation.getId(), surveyId) && StringsKt.equals(surveyTranslation.getLanguageCode(), locale, true)) {
                break;
            }
        }
        return (SurveyTranslation) next;
    }

    public final String getTwoPartLocale(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return CollectionsKt.joinToString$default(CollectionsKt.take(StringsKt.split$default((CharSequence) locale, new String[]{"-"}, false, 0, 6, (Object) null), 2), "-", null, null, 0, null, null, 62, null);
    }

    public final String getDisplayName(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Locale localeForLanguageTag = Locale.forLanguageTag(languageTag);
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
        Locale localeAsLanguageOption = asLanguageOption(localeForLanguageTag);
        return getLocalizedName(localeAsLanguageOption, localeAsLanguageOption);
    }

    public final String getTalkbackName(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Locale localeForLanguageTag = Locale.forLanguageTag(languageTag);
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
        Locale localeAsLanguageOption = asLanguageOption(localeForLanguageTag);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return getLocalizedName(localeAsLanguageOption, locale);
    }

    private final String getLocalizedName(Locale locale, Locale displayLocale) {
        String displayName = locale.getDisplayName(displayLocale);
        Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
        if (displayName.length() <= 0) {
            return displayName;
        }
        StringBuilder sbAppend = new StringBuilder().append((Object) CharsKt.titlecase(displayName.charAt(0), displayLocale));
        String strSubstring = displayName.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    private final Locale asLanguageOption(Locale locale) {
        if (Intrinsics.areEqual(locale, traditionalChineseBackendLocale)) {
            Locale localeForLanguageTag = Locale.forLanguageTag("zh-hant");
            Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
            return localeForLanguageTag;
        }
        if (!Intrinsics.areEqual(locale, simplifiedChineseBackendLocale)) {
            return locale;
        }
        Locale localeForLanguageTag2 = Locale.forLanguageTag("zh-hans");
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
        return localeForLanguageTag2;
    }
}
