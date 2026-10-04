package com.survicate.surveys.presentation.base.micro;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointFragmentUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"adjustCardHeightToPresentationStyle", "", "Landroidx/cardview/widget/CardView;", "isDialog", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointFragmentUtilsKt {
    public static final void adjustCardHeightToPresentationStyle(CardView cardView, boolean z) {
        Intrinsics.checkNotNullParameter(cardView, "<this>");
        CardView cardView2 = cardView;
        ViewGroup.LayoutParams layoutParams = cardView2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = z ? -2 : -1;
        cardView2.setLayoutParams(marginLayoutParams);
    }
}
