package com.revenuecat.purchases.p036ui.revenuecatui.components.ktx;

import androidx.compose.p004ui.text.intl.Locale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.revenuecat.purchases.p036ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: Localization.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\b\u001a\u0004\u0018\u00010\n*\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000f\u001a:\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aX\u0010\u001b\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001a\u001a:\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010\u001a\u001aX\u0010!\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001a\u001aF\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0014*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0016\u0010&\u001a\u00020'*\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\f\u0010&\u001a\u00020'*\u00020\u0005H\u0000\u001a\f\u0010*\u001a\u00020\u0005*\u00020'H\u0000\u001a\u0016\u0010*\u001a\u00020\u0005*\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0011\u0010-\u001a\u00020\n*\u00020'H\u0000¢\u0006\u0002\u0010.\u001a\u0011\u0010-\u001a\u00020\n*\u00020\u0005H\u0000¢\u0006\u0002\u0010/\u001a:\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u0011*\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001a\u001aX\u00104\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002010\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u001c0\u0011*\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b5\u0010\u001a\u001a\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007*$\b\u0000\u00109\"\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, m1599d2 = {"scriptByRegion", "", "", "fallbackLanguages", "", "Ljava/util/Locale;", "getFallbackLanguages", "(Ljava/util/Locale;)Ljava/util/List;", "getBestMatch", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "localeId", "getBestMatch-64pKzr8", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "", "(Ljava/util/Set;Ljava/lang/String;)Ljava/lang/String;", "image", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ktx/LocalizationDictionary;", SubscriberAttributeKt.JSON_NAME_KEY, "image-7v81vok", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "imageForAllLocales", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "imageForAllLocales-7v81vok", TypedValues.Custom.S_STRING, "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "string-7v81vok", "stringForAllLocales", "stringForAllLocales-7v81vok", "stringForAllLocalesOrEmpty", "stringForAllLocalesOrEmpty-7v81vok", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "toComposeLocale", "Landroidx/compose/ui/text/intl/Locale;", "toComposeLocale-_KYeFs0", "(Ljava/lang/String;)Landroidx/compose/ui/text/intl/Locale;", "toJavaLocale", "toJavaLocale-_KYeFs0", "(Ljava/lang/String;)Ljava/util/Locale;", "toLocaleId", "(Landroidx/compose/ui/text/intl/Locale;)Ljava/lang/String;", "(Ljava/util/Locale;)Ljava/lang/String;", MimeTypes.BASE_TYPE_VIDEO, "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "video-7v81vok", "videoForAllLocales", "videoForAllLocales-7v81vok", "withFallbackLanguages", "withFallbackLanguages-_KYeFs0", "(Ljava/lang/String;)Ljava/util/List;", "LocalizationDictionary", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class LocalizationKt {
    private static final Map<String, String> scriptByRegion = MapsKt.mapOf(TuplesKt.m1606to("CN", "Hans"), TuplesKt.m1606to("SG", "Hans"), TuplesKt.m1606to("MY", "Hans"), TuplesKt.m1606to("TW", "Hant"), TuplesKt.m1606to("HK", "Hant"), TuplesKt.m1606to("MO", "Hant"));

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: string-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13899string7v81vok(NonEmptyMap string, String key) {
        Intrinsics.checkNotNullParameter(string, "$this$string");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = string.get(LocalizationKey.m13833boximpl(key));
        String str = null;
        Object[] objArr = 0;
        String strM13821unboximpl = obj instanceof LocalizationData.Text ? ((LocalizationData.Text) obj).m13821unboximpl() : null;
        if (strM13821unboximpl != null) {
            return new Result.Success(strM13821unboximpl);
        }
        return new Result.Error(new PaywallValidationError.MissingStringLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: image-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13897image7v81vok(NonEmptyMap image, String key) {
        Intrinsics.checkNotNullParameter(image, "$this$image");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = image.get(LocalizationKey.m13833boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeImageUrls themeImageUrlsM13812unboximpl = obj instanceof LocalizationData.Image ? ((LocalizationData.Image) obj).m13812unboximpl() : null;
        if (themeImageUrlsM13812unboximpl != null) {
            return new Result.Success(themeImageUrlsM13812unboximpl);
        }
        return new Result.Error(new PaywallValidationError.MissingImageLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: video-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13904video7v81vok(NonEmptyMap video, String key) {
        Intrinsics.checkNotNullParameter(video, "$this$video");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = video.get(LocalizationKey.m13833boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeVideoUrls themeVideoUrlsM13830unboximpl = obj instanceof LocalizationData.Video ? ((LocalizationData.Video) obj).m13830unboximpl() : null;
        if (themeVideoUrlsM13830unboximpl != null) {
            return new Result.Success(themeVideoUrlsM13830unboximpl);
        }
        return new Result.Error(new PaywallValidationError.MissingVideoLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: toComposeLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ Locale m13902toComposeLocale_KYeFs0(String toComposeLocale) {
        Intrinsics.checkNotNullParameter(toComposeLocale, "$this$toComposeLocale");
        return new Locale(StringsKt.replace$default(toComposeLocale, '_', Soundex.SILENT_MARKER, false, 4, (Object) null));
    }

    /* JADX INFO: renamed from: toJavaLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ java.util.Locale m13903toJavaLocale_KYeFs0(String toJavaLocale) {
        Intrinsics.checkNotNullParameter(toJavaLocale, "$this$toJavaLocale");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(StringsKt.replace$default(toJavaLocale, '_', Soundex.SILENT_MARKER, false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(value.replace('_', '-'))");
        return localeForLanguageTag;
    }

    public static final /* synthetic */ String toLocaleId(java.util.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return LocaleId.m13798constructorimpl(StringsKt.replace$default(languageTag, Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
    }

    public static final /* synthetic */ String toLocaleId(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return LocaleId.m13798constructorimpl(StringsKt.replace$default(locale.toLanguageTag(), Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
    }

    public static final /* synthetic */ java.util.Locale toJavaLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(locale.toLanguageTag());
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(toLanguageTag())");
        return localeForLanguageTag;
    }

    public static final /* synthetic */ Locale toComposeLocale(java.util.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return new Locale(languageTag);
    }

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ Object m13895getBestMatch64pKzr8(Map getBestMatch, String localeId) {
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        String strM13896getBestMatch64pKzr8 = m13896getBestMatch64pKzr8(getBestMatch.keySet(), localeId);
        if (strM13896getBestMatch64pKzr8 != null) {
            return getBestMatch.get(LocaleId.m13797boximpl(strM13896getBestMatch64pKzr8));
        }
        return null;
    }

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ String m13896getBestMatch64pKzr8(Set getBestMatch, String localeId) {
        LocaleId localeIdM13797boximpl;
        Object next;
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        if (getBestMatch.contains(LocaleId.m13797boximpl(localeId))) {
            return localeId;
        }
        Iterator<T> it = m13906withFallbackLanguages_KYeFs0(localeId).iterator();
        while (true) {
            if (!it.hasNext()) {
                localeIdM13797boximpl = null;
                break;
            }
            java.util.Locale locale = (java.util.Locale) it.next();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String it2 = locale.getScript();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it2 == null) {
                it2 = scriptByRegion.get(country);
            }
            Intrinsics.checkNotNullExpressionValue(language, "language");
            String strM13798constructorimpl = LocaleId.m13798constructorimpl(language);
            String strM13798constructorimpl2 = it2 != null ? LocaleId.m13798constructorimpl(language + '_' + it2) : null;
            String strM13798constructorimpl3 = it2 != null ? LocaleId.m13798constructorimpl(language + '_' + it2 + '_' + country) : null;
            String localeId2 = toLocaleId(locale);
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(LocaleId.m13797boximpl(localeId2));
            if (strM13798constructorimpl3 != null) {
                listCreateListBuilder.add(LocaleId.m13797boximpl(strM13798constructorimpl3));
            }
            if (strM13798constructorimpl2 != null) {
                listCreateListBuilder.add(LocaleId.m13797boximpl(strM13798constructorimpl2));
            }
            listCreateListBuilder.add(LocaleId.m13797boximpl(strM13798constructorimpl));
            Iterator it3 = CollectionsKt.build(listCreateListBuilder).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                if (getBestMatch.contains(LocaleId.m13797boximpl(((LocaleId) next).m13803unboximpl()))) {
                    break;
                }
            }
            LocaleId localeId3 = (LocaleId) next;
            String strM13803unboximpl = localeId3 != null ? localeId3.m13803unboximpl() : null;
            if (strM13803unboximpl == null) {
                Set set = getBestMatch;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator it4 = set.iterator();
                while (it4.hasNext()) {
                    arrayList.add(m13903toJavaLocale_KYeFs0(((LocaleId) it4.next()).m13803unboximpl()));
                }
                ArrayList arrayList2 = arrayList;
                Iterator it5 = arrayList2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it5.next();
                    java.util.Locale locale2 = (java.util.Locale) next2;
                    if (Intrinsics.areEqual(locale2.getLanguage(), language) && Intrinsics.areEqual(locale2.getScript(), it2)) {
                        break;
                    }
                }
                java.util.Locale locale3 = (java.util.Locale) next2;
                if (locale3 != null) {
                    strM13803unboximpl = toLocaleId(locale3);
                } else {
                    Iterator it6 = arrayList2.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it6.next();
                        if (Intrinsics.areEqual(((java.util.Locale) next3).getLanguage(), language)) {
                            break;
                        }
                    }
                    java.util.Locale locale4 = (java.util.Locale) next3;
                    strM13803unboximpl = locale4 != null ? toLocaleId(locale4) : null;
                }
            }
            localeIdM13797boximpl = strM13803unboximpl != null ? LocaleId.m13797boximpl(strM13803unboximpl) : null;
            if (localeIdM13797boximpl != null) {
                break;
            }
        }
        if (localeIdM13797boximpl != null) {
            return localeIdM13797boximpl.m13803unboximpl();
        }
        return null;
    }

    /* JADX INFO: renamed from: withFallbackLanguages-_KYeFs0, reason: not valid java name */
    private static final List<java.util.Locale> m13906withFallbackLanguages_KYeFs0(String str) {
        java.util.Locale localeM13903toJavaLocale_KYeFs0 = m13903toJavaLocale_KYeFs0(str);
        List<java.util.Locale> fallbackLanguages = getFallbackLanguages(localeM13903toJavaLocale_KYeFs0);
        if (!fallbackLanguages.isEmpty()) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(localeM13903toJavaLocale_KYeFs0);
            listCreateListBuilder.addAll(fallbackLanguages);
            return CollectionsKt.build(listCreateListBuilder);
        }
        return CollectionsKt.listOf(localeM13903toJavaLocale_KYeFs0);
    }

    private static final List<java.util.Locale> getFallbackLanguages(java.util.Locale locale) {
        String language = locale.getLanguage();
        if (!Intrinsics.areEqual(language, "nb") && !Intrinsics.areEqual(language, "nn")) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf(new java.util.Locale("no", locale.getCountry(), locale.getVariant()));
    }

    /* JADX INFO: renamed from: stringForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13900stringForAllLocales7v81vok(NonEmptyMap stringForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(stringForAllLocales, "$this$stringForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = stringForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM13803unboximpl = ((LocaleId) entry.getKey()).m13803unboximpl();
            Result.Error errorM13899string7v81vok = m13899string7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM13899string7v81vok instanceof Result.Success)) {
                if (errorM13899string7v81vok instanceof Result.Error) {
                    errorM13899string7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingStringLocalization(key, strM13803unboximpl, null), new PaywallValidationError.MissingStringLocalization[0]));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            linkedHashMap.put(key2, errorM13899string7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(stringForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, stringForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((String) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.m1606to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (String) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    /* JADX INFO: renamed from: stringForAllLocalesOrEmpty-7v81vok, reason: not valid java name */
    public static final /* synthetic */ NonEmptyMap m13901stringForAllLocalesOrEmpty7v81vok(NonEmptyMap stringForAllLocalesOrEmpty, String key) {
        Object value;
        Intrinsics.checkNotNullParameter(stringForAllLocalesOrEmpty, "$this$stringForAllLocalesOrEmpty");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = stringForAllLocalesOrEmpty.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM13803unboximpl = ((LocaleId) entry.getKey()).m13803unboximpl();
            Result resultM13899string7v81vok = m13899string7v81vok((NonEmptyMap) entry.getValue(), key);
            if (resultM13899string7v81vok instanceof Result.Success) {
                value = ((Result.Success) resultM13899string7v81vok).getValue();
            } else if (resultM13899string7v81vok instanceof Result.Error) {
                Logger.INSTANCE.m1587w(new PaywallValidationError.MissingStringLocalization(key, strM13803unboximpl, null).getMessage());
                value = "";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            linkedHashMap.put(key2, (String) value);
        }
        return NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(stringForAllLocalesOrEmpty.getEntry().getKey(), MapsKt.getValue(linkedHashMap, stringForAllLocalesOrEmpty.getEntry().getKey())), linkedHashMap);
    }

    /* JADX INFO: renamed from: imageForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13898imageForAllLocales7v81vok(NonEmptyMap imageForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(imageForAllLocales, "$this$imageForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = imageForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM13803unboximpl = ((LocaleId) entry.getKey()).m13803unboximpl();
            Result.Error errorM13897image7v81vok = m13897image7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM13897image7v81vok instanceof Result.Success)) {
                if (errorM13897image7v81vok instanceof Result.Error) {
                    errorM13897image7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingImageLocalization(key, strM13803unboximpl, null), new PaywallValidationError.MissingImageLocalization[0]));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            linkedHashMap.put(key2, errorM13897image7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(imageForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, imageForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeImageUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.m1606to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (ThemeImageUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    /* JADX INFO: renamed from: videoForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m13905videoForAllLocales7v81vok(NonEmptyMap videoForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(videoForAllLocales, "$this$videoForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = videoForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM13803unboximpl = ((LocaleId) entry.getKey()).m13803unboximpl();
            Result.Error errorM13904video7v81vok = m13904video7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(errorM13904video7v81vok instanceof Result.Success)) {
                if (errorM13904video7v81vok instanceof Result.Error) {
                    errorM13904video7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingVideoLocalization(key, strM13803unboximpl, null), new PaywallValidationError.MissingVideoLocalization[0]));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            linkedHashMap.put(key2, errorM13904video7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(videoForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, videoForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result.Success success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeVideoUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.m1606to(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (ThemeVideoUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }
}
