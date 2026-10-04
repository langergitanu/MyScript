package com.myscript.android.utils;

import android.os.Build;
import android.os.SystemClock;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002¨\u0006\t"}, m1599d2 = {"setHtml", "", "Landroid/widget/TextView;", "stringRes", "", "html", "", "prependBullet", "clearLastHoveredView", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextViewExt {
    public static final void setHtml(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String string = textView.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setHtml(textView, string);
    }

    public static final void setHtml(TextView textView, String html) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(html, "html");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinksClickable(true);
        textView.setText(Html.fromHtml(html, 0));
    }

    public static final void prependBullet(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        CharSequence text = textView.getText();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new BulletSpan(textView.getContext().getResources().getDimensionPixelSize(C6014R.dimen.bullet_list_gapWidth)), 0, text.length(), 0);
        textView.setText(spannableString);
    }

    public static final void clearLastHoveredView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = MANUFACTURER.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "samsung", false, 2, (Object) null)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            textView.onHoverEvent(MotionEvent.obtain(jUptimeMillis, ((long) 100) + jUptimeMillis, 10, 0.0f, 0.0f, 0));
        }
    }
}
