package com.myscript.nebo.dms.edit_languages;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class LegacyLanguageNameHelper {
    private static final Map<String, String> CUSTOM_DISPLAY_NAMES;
    private ArrayList<String> mLanguageKeys = new ArrayList<>();
    private Map<String, Integer> mCountriesCountLanguages = new HashMap();

    static {
        HashMap map = new HashMap();
        CUSTOM_DISPLAY_NAMES = map;
        map.put("zh_CN", "中文（简体，中国）");
        map.put("zh_HK", "中文（繁體，中國香港）");
        map.put("zh_TW", "中文（繁體，中國台灣）");
        map.put("mk_MK", "Mакедонски");
    }

    public void buildLanguagesInfo(Set<String> set) {
        buildLanguagesInfo(convertToArrayList(set));
    }

    public void buildLanguagesInfo(List<String> list) {
        this.mLanguageKeys.clear();
        this.mCountriesCountLanguages.clear();
        this.mLanguageKeys.addAll(list);
        this.mCountriesCountLanguages.putAll(buildCountriesCountList());
    }

    public List<String> getLanguageKeys() {
        return this.mLanguageKeys;
    }

    private ArrayList<String> convertToArrayList(Set<String> set) {
        ArrayList<String> arrayList = new ArrayList<>(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public String getDisplayLanguage(String str) {
        String str2 = CUSTOM_DISPLAY_NAMES.get(str);
        return str2 != null ? str2 : getDisplayLanguage(str, null);
    }

    public String getDisplayLanguage(String str, Locale locale) {
        Locale locale2 = getLocale(str);
        if (locale == null) {
            locale = locale2;
        }
        return isMultipleCountriesLanguage(str) ? String.format("%s (%s)", capitalizedDisplayLanguage(locale2, locale), locale2.getDisplayCountry(locale)) : capitalizedDisplayLanguage(locale2, locale);
    }

    private int getCountriesCount(String str) {
        Integer num = this.mCountriesCountLanguages.get(str.split("_")[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean isMultipleCountriesLanguage(String str) {
        return getCountriesCount(str) > 1;
    }

    public static Locale getLocale(String str) {
        String[] strArrSplit = str.split("_");
        String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
        String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
        String str4 = strArrSplit.length > 2 ? strArrSplit[2] : "";
        if ("sr".equals(str2)) {
            return new Locale.Builder().setLanguage("sr").setRegion("RS").setScript(str3).build();
        }
        return new Locale(str2, str3, str4);
    }

    private Map<String, Integer> buildCountriesCountList() {
        HashMap map = new HashMap();
        ArrayList<String> arrayList = this.mLanguageKeys;
        if (arrayList == null) {
            return null;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String str = it.next().split("_")[0];
            if (map.get(str) == null) {
                map.put(str, 1);
            } else {
                map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
            }
        }
        return map;
    }

    public static String capitalizedDisplayLanguage(Locale locale, Locale locale2) {
        String displayLanguage = locale.getDisplayLanguage(locale2);
        if (TextUtils.isEmpty(displayLanguage)) {
            return locale.getLanguage();
        }
        return displayLanguage.substring(0, 1).toUpperCase(locale2) + displayLanguage.substring(1);
    }

    public boolean isLanguageAvailable(String str) {
        return this.mLanguageKeys.contains(str);
    }
}
