package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.utils.AccessibilityUtils;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MicroProgressBar.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroProgressBar;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "root", "Landroid/view/View;", "progressGuideline", "Landroidx/constraintlayout/widget/Guideline;", "background", "progress", "inject", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "setProgressValue", "currentProgressInPercents", "", "updateContentDescription", "progressFraction", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroProgressBar extends FrameLayout {
    private final View background;
    private final View progress;
    private final Guideline progressGuideline;
    private final View root;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_progress_bar, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_progress_bar_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.root = viewFindViewById;
        viewFindViewById.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        viewFindViewById.setClipToOutline(true);
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_progress_bar_guideline);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.progressGuideline = (Guideline) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_progress_bar_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.background = viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_progress_bar_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.progress = viewFindViewById4;
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityUtils.ProgressBarRoleAccessibilityDelegate());
    }

    public final void inject(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.progress.setBackgroundColor(colorScheme.getProgressBar());
        this.background.setBackgroundColor(ColorHelper.getArgbValue(colorScheme.getQuestion(), MicroColorControlOpacity.ProgressBarBackground.getOpacityValue()));
    }

    public final void setProgressValue(double currentProgressInPercents) {
        double dCoerceIn = RangesKt.coerceIn(currentProgressInPercents / ((double) 100), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d);
        ViewGroup.LayoutParams layoutParams = this.progressGuideline.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.guidePercent = (float) dCoerceIn;
        }
        updateContentDescription(dCoerceIn);
    }

    private final void updateContentDescription(double progressFraction) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(0);
        setContentDescription(percentInstance.format(progressFraction));
    }
}
