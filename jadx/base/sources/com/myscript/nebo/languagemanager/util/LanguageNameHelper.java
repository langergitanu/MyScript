package com.myscript.nebo.languagemanager.util;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageNameHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0013j\b\u0012\u0004\u0012\u00020\b`\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/util/LanguageNameHelper;", "", "currentDeviceLocale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "languagesKeys", "", "", "countriesCountLanguages", "", "", "buildLanguagesInfo", "", "languageKeys", "", UserMetadata.KEYDATA_FILENAME, "", "convertToArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDisplayLanguage", "languageKey", "forceFullDisplay", "", "uiLocale", "getCountriesCount", "isMultipleCountriesLanguage", "buildCountriesCountList", "", "getLocale", "capitalizedDisplayLanguage", "locale", "isFilteredLanguageAccepted", SearchIntents.EXTRA_QUERY, "Companion", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageNameHelper {
    private final Map<String, Integer> countriesCountLanguages;
    private final Locale currentDeviceLocale;
    private final List<String> languagesKeys;
    private static final Map<String, String> CUSTOM_DISPLAY_NAMES = MapsKt.mapOf(TuplesKt.m1606to("zh_CN", "中文（简体，中国）"), TuplesKt.m1606to("zh_HK", "中文（繁體，中國香港）"), TuplesKt.m1606to("zh_TW", "中文（繁體，中國台灣）"), TuplesKt.m1606to("mk_MK", "Mакедонски"));

    public LanguageNameHelper(Locale currentDeviceLocale) {
        Intrinsics.checkNotNullParameter(currentDeviceLocale, "currentDeviceLocale");
        this.currentDeviceLocale = currentDeviceLocale;
        this.languagesKeys = new ArrayList();
        this.countriesCountLanguages = new LinkedHashMap();
    }

    public final void buildLanguagesInfo(Set<String> languageKeys) {
        Intrinsics.checkNotNullParameter(languageKeys, "languageKeys");
        buildLanguagesInfo(convertToArrayList(CollectionsKt.toSet(languageKeys)));
    }

    public final void buildLanguagesInfo(List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.languagesKeys.clear();
        this.countriesCountLanguages.clear();
        this.languagesKeys.addAll(keys);
        this.countriesCountLanguages.putAll(buildCountriesCountList());
    }

    private final ArrayList<String> convertToArrayList(Set<String> languageKeys) {
        ArrayList<String> arrayList = new ArrayList<>(languageKeys.size());
        Iterator<String> it = languageKeys.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static /* synthetic */ String getDisplayLanguage$default(LanguageNameHelper languageNameHelper, String str, boolean z, Locale locale, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            locale = null;
        }
        return languageNameHelper.getDisplayLanguage(str, z, locale);
    }

    public final String getDisplayLanguage(String languageKey, boolean forceFullDisplay, Locale uiLocale) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        String str = CUSTOM_DISPLAY_NAMES.get(languageKey);
        if (str != null) {
            return str;
        }
        Locale locale = getLocale(languageKey);
        if (uiLocale == null) {
            uiLocale = locale;
        }
        String strCapitalizedDisplayLanguage = capitalizedDisplayLanguage(locale, uiLocale);
        if (!forceFullDisplay && !isMultipleCountriesLanguage(languageKey)) {
            return strCapitalizedDisplayLanguage;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%s (%s)", Arrays.copyOf(new Object[]{strCapitalizedDisplayLanguage, locale.getDisplayCountry(uiLocale)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    private final int getCountriesCount(String languageKey) {
        Integer num = this.countriesCountLanguages.get(((String[]) StringsKt.split$default((CharSequence) languageKey, new String[]{"_"}, false, 0, 6, (Object) null).toArray(new String[0]))[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final boolean isMultipleCountriesLanguage(String languageKey) {
        return getCountriesCount(languageKey) > 1;
    }

    private final Map<String, Integer> buildCountriesCountList() {
        HashMap map = new HashMap();
        Iterator<String> it = this.languagesKeys.iterator();
        while (it.hasNext()) {
            String str = ((String[]) StringsKt.split$default((CharSequence) it.next(), new String[]{"_"}, false, 0, 6, (Object) null).toArray(new String[0]))[0];
            if (map.get(str) == null) {
                map.put(str, 1);
            } else {
                Object obj = map.get(str);
                Intrinsics.checkNotNull(obj);
                map.put(str, Integer.valueOf(((Number) obj).intValue() + 1));
            }
        }
        return map;
    }

    private final Locale getLocale(String languageKey) {
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) languageKey, new String[]{"_"}, false, 0, 6, (Object) null).toArray(new String[0]);
        String str = strArr.length > 0 ? strArr[0] : "";
        String str2 = 1 < strArr.length ? strArr[1] : "";
        String str3 = 2 < strArr.length ? strArr[2] : "";
        if (Intrinsics.areEqual("sr", str)) {
            Locale localeBuild = new Locale.Builder().setLanguage("sr").setRegion("RS").setScript(str2).build();
            Intrinsics.checkNotNull(localeBuild);
            return localeBuild;
        }
        return new Locale(str, str2, str3);
    }

    private final String capitalizedDisplayLanguage(Locale locale, Locale uiLocale) {
        String displayLanguage = locale.getDisplayLanguage(uiLocale);
        Intrinsics.checkNotNull(displayLanguage);
        if (displayLanguage.length() == 0) {
            String language = locale.getLanguage();
            Intrinsics.checkNotNull(language);
            return language;
        }
        String strSubstring = displayLanguage.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String upperCase = strSubstring.toUpperCase(uiLocale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String strSubstring2 = displayLanguage.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return upperCase + strSubstring2;
    }

    public final boolean isFilteredLanguageAccepted(String query, String languageKey) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        String lowerCase = query.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = getDisplayLanguage$default(this, languageKey, false, null, 6, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.startsWith$default(lowerCase2, lowerCase, false, 2, (Object) null)) {
            return true;
        }
        String lowerCase3 = getDisplayLanguage$default(this, languageKey, false, this.currentDeviceLocale, 2, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return StringsKt.startsWith$default(lowerCase3, lowerCase, false, 2, (Object) null);
    }
}
