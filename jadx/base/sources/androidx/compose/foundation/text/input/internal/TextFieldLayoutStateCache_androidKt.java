package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.text.style.TextDirection;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldLayoutStateCache.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "(Landroidx/compose/ui/text/intl/Locale;)I", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale locale) {
        byte bResolve;
        if (Build.VERSION.SDK_INT >= 28) {
            bResolve = DigitDirectionalityApi28.INSTANCE.resolve(locale);
        } else {
            bResolve = DigitDirectionalityApi24.INSTANCE.resolve(locale);
        }
        if (bResolve == 1 || bResolve == 2) {
            return TextDirection.INSTANCE.m10916getRtls_7Xco();
        }
        return TextDirection.INSTANCE.m10915getLtrs_7Xco();
    }
}
