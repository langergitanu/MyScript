package com.survicate.surveys.presentation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointImage.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u00020\u0016*\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSurveyPointImage;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "root", "Landroid/view/ViewGroup;", "imageView", "Landroid/widget/ImageView;", "descriptionTextView", "Landroid/widget/TextView;", "progressBarContainer", "progressBarView", "Landroid/widget/ProgressBar;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "inject", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "data", "Lcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;", "onLoadingComplete", "isSuccess", "", "animateHeightToMatchView", "Landroid/view/View;", "targetView", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointImage extends FrameLayout {
    private final TextView descriptionTextView;
    private final ImageView imageView;
    private final ViewGroup progressBarContainer;
    private final ProgressBar progressBarView;
    private final ViewGroup root;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointImage(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointImage(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_image, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.micro_survey_point_image_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.root = (ViewGroup) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.micro_survey_point_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        this.imageView = imageView;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.micro_survey_point_image_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.micro_survey_point_image_progress_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.progressBarContainer = (ViewGroup) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.micro_survey_point_image_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.progressBarView = (ProgressBar) viewFindViewById5;
        imageView.setClipToOutline(true);
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        TextView textView = this.descriptionTextView;
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setTypeface(fontProvider.provideFont(context, FontType.REGULAR));
        this.descriptionTextView.setTextColor(colorScheme.getQuestion());
        this.progressBarView.setIndeterminateTintList(ColorStateList.valueOf(colorScheme.getProgressBar()));
        this.progressBarView.setIndeterminateTintMode(PorterDuff.Mode.SRC_IN);
    }

    public final void bindData(SurveyPointImageBindingData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getSurveyPointImage() == null) {
            return;
        }
        this.progressBarContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), C8369R.anim.survicate_rotate));
        this.progressBarContainer.setVisibility(0);
        this.descriptionTextView.setText(data.getSurveyPointImage().getImage().getDescription());
        this.imageView.setContentDescription(data.getSurveyPointImage().getImage().getDescription());
        String url = data.getSurveyPointImage().getImage().getUrl();
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        viewDependencies.getImageLoader().loadSurveyPointImage(getContext(), this.imageView, url, new C84741(this));
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.widget.MicroSurveyPointImage$bindData$1 */
    /* JADX INFO: compiled from: MicroSurveyPointImage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84741 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        C84741(Object obj) {
            super(1, obj, MicroSurveyPointImage.class, "onLoadingComplete", "onLoadingComplete(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            ((MicroSurveyPointImage) this.receiver).onLoadingComplete(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadingComplete(boolean isSuccess) {
        this.progressBarContainer.clearAnimation();
        this.descriptionTextView.setVisibility(!isSuccess ? 0 : 8);
        this.imageView.setVisibility(isSuccess ? 0 : 8);
        this.progressBarContainer.setVisibility(8);
        animateHeightToMatchView(this.root, isSuccess ? this.imageView : this.descriptionTextView);
    }

    private final void animateHeightToMatchView(final View view, final View view2) {
        if (view2.isLaidOut() && !view2.isLayoutRequested()) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(view.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_survey_point_image_container_height), view2.getMeasuredHeight());
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new C8473x8478861d(view));
            valueAnimatorOfInt.start();
            return;
        }
        view2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.survicate.surveys.presentation.widget.MicroSurveyPointImage$animateHeightToMatchView$$inlined$doOnLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view3.removeOnLayoutChangeListener(this);
                ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(view.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_survey_point_image_container_height), view2.getMeasuredHeight());
                valueAnimatorOfInt2.setDuration(300L);
                valueAnimatorOfInt2.addUpdateListener(new C8473x8478861d(view));
                valueAnimatorOfInt2.start();
            }
        });
    }
}
