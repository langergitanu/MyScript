package com.myscript.nebo.languagemanager.util;

import android.content.Context;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: LocaleListUtil.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"deviceLocales", "", "Ljava/util/Locale;", "Landroid/content/Context;", "getDeviceLocales", "(Landroid/content/Context;)Ljava/util/List;", "asLanguageKey", "", "getAsLanguageKey", "(Ljava/util/Locale;)Ljava/lang/String;", "asLanguageKeys", "getAsLanguageKeys", "(Ljava/util/List;)Ljava/util/List;", "language-manager_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LocaleListUtilKt {
    public static final List<Locale> getDeviceLocales(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        Intrinsics.checkNotNullExpressionValue(locales, "getLocales(...)");
        ArrayList arrayList = new ArrayList();
        int size = locales.size();
        for (int i = 0; i < size; i++) {
            Locale locale = locales.get(i);
            arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
        }
        return arrayList;
    }

    public static final String getAsLanguageKey(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        if (!Intrinsics.areEqual(locale.getLanguage(), "sr")) {
            locale = new Locale(locale.getLanguage(), locale.getCountry());
        }
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return StringsKt.replace$default(languageTag, Soundex.SILENT_MARKER, '_', false, 4, (Object) null);
    }

    public static final List<String> getAsLanguageKeys(List<Locale> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<Locale> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(getAsLanguageKey((Locale) it.next()));
        }
        return arrayList;
    }
}
