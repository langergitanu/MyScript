package com.survicate.surveys.utils.extensions;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.utils.HtmlTextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextViewExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\nH\u0000\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\u0013H\u0001¨\u0006\u0014"}, m1599d2 = {"setTextOrHide", "", "Landroid/widget/TextView;", "text", "", "setHtmlTextOrHide", "fontConfig", "Lcom/survicate/surveys/utils/HtmlTextUtil$FontConfig;", "setHtmlTextColor", "color", "", "applyQuestionOptionStyle", "isSelected", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "fontProvider", "Lcom/survicate/surveys/presentation/theming/FontProvider;", "allowInnerScrolling", "Landroid/widget/EditText;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextViewExtensionsKt {
    public static final void setTextOrHide(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String str2 = str;
        textView.setVisibility((str2 == null || StringsKt.isBlank(str2)) ? 8 : 0);
        textView.setText(str2);
    }

    public static final void setHtmlTextOrHide(TextView textView, String text, HtmlTextUtil.FontConfig fontConfig) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        textView.setVisibility(StringsKt.isBlank(text) ? 8 : 0);
        textView.setText(HtmlTextUtil.INSTANCE.getStyledText(text, fontConfig));
        textView.setClickable(true);
        textView.setLinksClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final void setHtmlTextColor(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(i);
        textView.setLinkTextColor(i);
    }

    public static final void applyQuestionOptionStyle(TextView textView, boolean z, ColorScheme colorScheme, FontProvider fontProvider) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(fontProvider, "fontProvider");
        if (z) {
            TextViewCompat.setTextAppearance(textView, C8369R.style.Widget_Survicate_QuestionOption_Text_Micro_Selected);
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTypeface(fontProvider.provideFont(context, FontType.BOLD));
        } else {
            TextViewCompat.setTextAppearance(textView, C8369R.style.Widget_Survicate_QuestionOption_Text_Micro);
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView.setTypeface(fontProvider.provideFont(context2, FontType.REGULAR));
        }
        textView.setTextColor(colorScheme.getAnswer());
    }

    public static final void allowInnerScrolling(final EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.survicate.surveys.utils.extensions.TextViewExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TextViewExtensionsKt.allowInnerScrolling$lambda$0(editText, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean allowInnerScrolling$lambda$0(EditText editText, View view, MotionEvent motionEvent) {
        boolean z = editText.canScrollVertically(-1) || editText.canScrollVertically(1);
        boolean z2 = motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3;
        ViewParent parent = editText.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z && !z2);
        }
        return false;
    }
}
