package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.ImagePosition;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.HtmlTextUtil;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroQuestionHeader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "containerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "introductionTextView", "Landroid/widget/TextView;", "titleTextView", "answerRequiredTextView", "imageView", "Lcom/survicate/surveys/presentation/widget/MicroSurveyPointImage;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "inject", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "data", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getRegularFontConfig", "Lcom/survicate/surveys/utils/HtmlTextUtil$FontConfig;", "getBoldFontConfig", "positionSurveyPointImageView", "position", "Lcom/survicate/surveys/entities/survey/questions/ImagePosition;", "positionImageAboveIntroduction", "positionImageBelowTitle", "getDefaultAnswerRequiredLabel", "", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroQuestionHeader extends FrameLayout {
    private final TextView answerRequiredTextView;
    private final ConstraintLayout containerView;
    private final MicroSurveyPointImage imageView;
    private final TextView introductionTextView;
    private final TextView titleTextView;
    private ViewDependencies viewDependencies;

    /* JADX INFO: compiled from: MicroQuestionHeader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImagePosition.values().length];
            try {
                iArr[ImagePosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImagePosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroQuestionHeader(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroQuestionHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroQuestionHeader(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroQuestionHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_question_header, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_question_header_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.containerView = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_question_header_introduction);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.introductionTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_question_header_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_question_header_answer_required_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById4;
        this.answerRequiredTextView = textView;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_question_header_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.imageView = (MicroSurveyPointImage) viewFindViewById5;
        textView.setFocusable(AccessibilityUtils.isTalkbackEnabled(context));
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.imageView.inject(viewDependencies, colorScheme);
        this.introductionTextView.setTypeface(provideFont(FontType.REGULAR));
        TextView textView = this.introductionTextView;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(microDrawableFactory, context, 0.0f, 2, null));
        TextViewExtensionsKt.setHtmlTextColor(this.introductionTextView, colorScheme.getQuestion());
        this.titleTextView.setTypeface(provideFont(FontType.BOLD));
        TextView textView2 = this.titleTextView;
        MicroDrawableFactory microDrawableFactory2 = MicroDrawableFactory.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView2.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(microDrawableFactory2, context2, 0.0f, 2, null));
        TextViewExtensionsKt.setHtmlTextColor(this.titleTextView, colorScheme.getQuestion());
        this.answerRequiredTextView.setTypeface(provideFont(FontType.BOLD));
        this.answerRequiredTextView.setTextColor(colorScheme.getQuestion());
    }

    public final void bindData(QuestionHeaderBindingData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextViewExtensionsKt.setHtmlTextOrHide(this.introductionTextView, data.getSurveyPointIntroduction(), getRegularFontConfig());
        TextViewExtensionsKt.setHtmlTextOrHide(this.titleTextView, data.getSurveyPointTitle(), getBoldFontConfig());
        this.answerRequiredTextView.setVisibility(data.getShowAnswerRequiredLabel() ? 0 : 8);
        if (data.getShowAnswerRequiredLabel()) {
            TextView textView = this.answerRequiredTextView;
            String answerRequiredLabel = data.getAnswerRequiredLabel();
            if (answerRequiredLabel.length() == 0) {
                answerRequiredLabel = getDefaultAnswerRequiredLabel();
            }
            textView.setText(answerRequiredLabel);
        }
        MicroSurveyPointImage microSurveyPointImage = this.imageView;
        SurveyPointImageBindingData imageBindingData = data.getImageBindingData();
        microSurveyPointImage.setVisibility((imageBindingData != null ? imageBindingData.getSurveyPointImage() : null) != null ? 0 : 8);
        SurveyPointImageBindingData imageBindingData2 = data.getImageBindingData();
        if ((imageBindingData2 != null ? imageBindingData2.getSurveyPointImage() : null) != null) {
            positionSurveyPointImageView(data.getImageBindingData().getSurveyPointImage().getPosition());
            this.imageView.bindData(data.getImageBindingData());
        }
    }

    private final HtmlTextUtil.FontConfig getRegularFontConfig() {
        Typeface typefaceProvideFont;
        Typeface typefaceProvideFont2;
        Typeface typefaceProvideFont3 = provideFont(FontType.BOLD);
        if (typefaceProvideFont3 == null || (typefaceProvideFont = provideFont(FontType.REGULAR_ITALIC)) == null || (typefaceProvideFont2 = provideFont(FontType.BOLD_ITALIC)) == null) {
            return null;
        }
        return new HtmlTextUtil.FontConfig(typefaceProvideFont3, typefaceProvideFont, typefaceProvideFont2);
    }

    private final HtmlTextUtil.FontConfig getBoldFontConfig() {
        Typeface typefaceProvideFont;
        Typeface typefaceProvideFont2;
        Typeface typefaceProvideFont3 = provideFont(FontType.BOLD);
        if (typefaceProvideFont3 == null || (typefaceProvideFont = provideFont(FontType.BOLD_ITALIC)) == null || (typefaceProvideFont2 = provideFont(FontType.BOLD_ITALIC)) == null) {
            return null;
        }
        return new HtmlTextUtil.FontConfig(typefaceProvideFont3, typefaceProvideFont, typefaceProvideFont2);
    }

    private final void positionSurveyPointImageView(ImagePosition position) {
        int i = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i == 1) {
            positionImageAboveIntroduction();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            positionImageBelowTitle();
        }
    }

    private final void positionImageAboveIntroduction() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.containerView);
        this.imageView.setPadding(0, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_xs), 0, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_md));
        constraintSet.connect(this.imageView.getId(), 3, this.containerView.getId(), 3);
        constraintSet.connect(this.imageView.getId(), 4, this.introductionTextView.getId(), 3);
        constraintSet.connect(this.introductionTextView.getId(), 3, this.imageView.getId(), 4);
        constraintSet.connect(this.titleTextView.getId(), 4, this.answerRequiredTextView.getId(), 3);
        constraintSet.connect(this.answerRequiredTextView.getId(), 3, this.titleTextView.getId(), 4);
        constraintSet.applyTo(this.containerView);
    }

    private final void positionImageBelowTitle() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.containerView);
        this.imageView.setPadding(0, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_xxxl), 0, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_xs));
        constraintSet.connect(this.imageView.getId(), 3, this.titleTextView.getId(), 4);
        constraintSet.connect(this.imageView.getId(), 4, this.answerRequiredTextView.getId(), 3);
        constraintSet.connect(this.introductionTextView.getId(), 3, this.containerView.getId(), 3);
        constraintSet.connect(this.titleTextView.getId(), 4, this.imageView.getId(), 3);
        constraintSet.connect(this.answerRequiredTextView.getId(), 3, this.imageView.getId(), 4);
        constraintSet.applyTo(this.containerView);
    }

    private final String getDefaultAnswerRequiredLabel() {
        String string = getContext().getString(C8369R.string.survicate_answer_required_label);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final Typeface provideFont(FontType fontType) {
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return fontProvider.provideFont(context, fontType);
    }
}
