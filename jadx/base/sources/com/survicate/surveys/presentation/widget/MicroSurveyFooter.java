package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyFooter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSurveyFooter;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onPoweredByClick", "Lkotlin/Function0;", "", "getOnPoweredByClick", "()Lkotlin/jvm/functions/Function0;", "setOnPoweredByClick", "(Lkotlin/jvm/functions/Function0;)V", "poweredByText", "Landroid/widget/TextView;", "poweredByLogo", "Landroid/widget/ImageView;", "clickableArea", "Landroid/view/View;", "inject", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyFooter extends FrameLayout {
    private final View clickableArea;
    private Function0<Unit> onPoweredByClick;
    private final ImageView poweredByLogo;
    private final TextView poweredByText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyFooter(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyFooter(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.layout_micro_powered_by_survicate, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.layout_micro_powered_by_survicate_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.poweredByText = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.layout_micro_powered_by_survicate_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.poweredByLogo = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.layout_micro_powered_by_clickable_area);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.clickableArea = viewFindViewById3;
        viewFindViewById3.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(MicroDrawableFactory.INSTANCE, context, 0.0f, 2, null));
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.widget.MicroSurveyFooter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicroSurveyFooter._init_$lambda$0(this.f$0, view);
            }
        });
    }

    public final Function0<Unit> getOnPoweredByClick() {
        return this.onPoweredByClick;
    }

    public final void setOnPoweredByClick(Function0<Unit> function0) {
        this.onPoweredByClick = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MicroSurveyFooter microSurveyFooter, View view) {
        Function0<Unit> function0 = microSurveyFooter.onPoweredByClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void inject(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int contrastColor = ColorHelper.INSTANCE.getContrastColor(colorScheme.getBackground());
        this.poweredByText.setTextColor(contrastColor);
        this.poweredByText.setTypeface(ResourcesCompat.getFont(getContext(), C8369R.font.open_sans_regular));
        this.poweredByLogo.setColorFilter(contrastColor, PorterDuff.Mode.SRC_IN);
    }
}
