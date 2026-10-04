package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import android.content.res.Configuration;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: LocaleHelpers.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0000¨\u0006\u0006"}, m1599d2 = {"createLocaleFromString", "Ljava/util/Locale;", "localeString", "", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class LocaleHelpersKt {
    public static final Locale createLocaleFromString(String localeString) {
        List listSplit$default;
        Intrinsics.checkNotNullParameter(localeString, "localeString");
        String str = localeString;
        if (StringsKt.contains$default((CharSequence) str, Soundex.SILENT_MARKER, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, '_', false, 2, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) str, Soundex.SILENT_MARKER, false, 2, (Object) null)) {
                listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{Soundex.SILENT_MARKER}, false, 2, 2, (Object) null);
            } else {
                listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'_'}, false, 2, 2, (Object) null);
            }
            if (listSplit$default.size() >= 2) {
                return new Locale((String) listSplit$default.get(0), (String) listSplit$default.get(1));
            }
            return new Locale((String) listSplit$default.get(0));
        }
        return new Locale(localeString);
    }

    public static final LayoutDirection toLayoutDirection(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        if (configuration.getLayoutDirection() == 1) {
            return LayoutDirection.Rtl;
        }
        return LayoutDirection.Ltr;
    }
}
