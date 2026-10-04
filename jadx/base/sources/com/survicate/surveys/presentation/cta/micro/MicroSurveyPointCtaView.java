package com.survicate.surveys.presentation.cta.micro;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.base.DebouncingOnClickListener;
import com.survicate.surveys.presentation.base.micro.MicroSurveyPointFragmentUtilsKt;
import com.survicate.surveys.presentation.widget.MicroDisclaimerView;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSubmitView;
import com.survicate.surveys.presentation.widget.MicroSubmitViewKt;
import com.survicate.surveys.presentation.widget.MicroSurveyFooter;
import com.survicate.surveys.presentation.widget.MicroSurveyHeader;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.presentation.widget.SubmitViewConfiguration;
import com.survicate.surveys.presentation.widget.SubmitViewState;
import com.survicate.surveys.presentation.widget.SurveyHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import com.survicate.surveys.utils.SurvicateViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointCtaView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00105\u001a\u00020\fH\u0002J\u0016\u00106\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J\u0018\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010>J\u0012\u0010?\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010@\u001a\u00020\fH\u0002J\u0006\u0010A\u001a\u00020BR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onCloseSurveyClick", "Lkotlin/Function0;", "", "getOnCloseSurveyClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseSurveyClick", "(Lkotlin/jvm/functions/Function0;)V", "onLanguageSelected", "Lkotlin/Function1;", "", "getOnLanguageSelected", "()Lkotlin/jvm/functions/Function1;", "setOnLanguageSelected", "(Lkotlin/jvm/functions/Function1;)V", "onSubmitClick", "getOnSubmitClick", "setOnSubmitClick", "onBackClick", "getOnBackClick", "setOnBackClick", "onPoweredByClick", "getOnPoweredByClick", "setOnPoweredByClick", "bindingData", "Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaView$BindingData;", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "cardView", "Landroidx/cardview/widget/CardView;", "containerView", "Landroid/view/ViewGroup;", "surveyHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroSurveyHeader;", "surveyFooterView", "Lcom/survicate/surveys/presentation/widget/MicroSurveyFooter;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "submitView", "Lcom/survicate/surveys/presentation/widget/MicroSubmitView;", "disclaimerView", "Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;", "setupListeners", "inject", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "data", "savedState", "Landroid/os/Bundle;", "bindDisclaimer", "updateSubmitState", "getCurrentValidationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "BindingData", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointCtaView extends FrameLayout {
    private BindingData bindingData;
    private final CardView cardView;
    private final ViewGroup containerView;
    private final MicroDisclaimerView disclaimerView;
    private Function0<Unit> onBackClick;
    private Function0<Unit> onCloseSurveyClick;
    private Function1<? super String, Unit> onLanguageSelected;
    private Function0<Unit> onPoweredByClick;
    private Function0<Unit> onSubmitClick;
    private final MicroQuestionHeader questionHeaderView;
    private final MicroSubmitView submitView;
    private final MicroSurveyFooter surveyFooterView;
    private final MicroSurveyHeader surveyHeaderView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointCtaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_cta, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_card);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.cardView = (CardView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2;
        this.containerView = viewGroup;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_survey_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.surveyHeaderView = (MicroSurveyHeader) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_question_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_disclaimer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.disclaimerView = (MicroDisclaimerView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_submit);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.submitView = (MicroSubmitView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_cta_footer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.surveyFooterView = (MicroSurveyFooter) viewFindViewById7;
        SurvicateViewUtils.INSTANCE.applySafeContentPaddings(viewGroup);
        setupListeners();
    }

    public final Function0<Unit> getOnCloseSurveyClick() {
        return this.onCloseSurveyClick;
    }

    public final void setOnCloseSurveyClick(Function0<Unit> function0) {
        this.onCloseSurveyClick = function0;
    }

    public final Function1<String, Unit> getOnLanguageSelected() {
        return this.onLanguageSelected;
    }

    public final void setOnLanguageSelected(Function1<? super String, Unit> function1) {
        this.onLanguageSelected = function1;
    }

    public final Function0<Unit> getOnSubmitClick() {
        return this.onSubmitClick;
    }

    public final void setOnSubmitClick(Function0<Unit> function0) {
        this.onSubmitClick = function0;
    }

    public final Function0<Unit> getOnBackClick() {
        return this.onBackClick;
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        this.onBackClick = function0;
    }

    public final Function0<Unit> getOnPoweredByClick() {
        return this.onPoweredByClick;
    }

    public final void setOnPoweredByClick(Function0<Unit> function0) {
        this.onPoweredByClick = function0;
    }

    private final DisclaimerSettings getDisclaimerSettings() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getPointSettings().getDisclaimerSettings();
    }

    private final void setupListeners() {
        this.surveyHeaderView.setOnCloseButtonListener(new DebouncingOnClickListener() { // from class: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView.setupListeners.1
            @Override // com.survicate.surveys.presentation.base.DebouncingOnClickListener
            public void doClick(View v) {
                Function0<Unit> onCloseSurveyClick = MicroSurveyPointCtaView.this.getOnCloseSurveyClick();
                if (onCloseSurveyClick != null) {
                    onCloseSurveyClick.invoke();
                }
            }
        });
        this.surveyHeaderView.setOnLanguageSelected(new Function1() { // from class: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyPointCtaView.setupListeners$lambda$0(this.f$0, (String) obj);
            }
        });
        this.surveyFooterView.setOnPoweredByClick(new Function0() { // from class: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointCtaView.setupListeners$lambda$1(this.f$0);
            }
        });
        this.submitView.setOnSubmitClick(new Function0() { // from class: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointCtaView.setupListeners$lambda$2(this.f$0);
            }
        });
        this.submitView.setOnBackClick(new Function0() { // from class: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointCtaView.setupListeners$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(MicroSurveyPointCtaView microSurveyPointCtaView, String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        Function1<? super String, Unit> function1 = microSurveyPointCtaView.onLanguageSelected;
        if (function1 != null) {
            function1.invoke(langCode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(MicroSurveyPointCtaView microSurveyPointCtaView) {
        Function0<Unit> function0 = microSurveyPointCtaView.onPoweredByClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$2(MicroSurveyPointCtaView microSurveyPointCtaView) {
        Function0<Unit> function0 = microSurveyPointCtaView.onSubmitClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$3(MicroSurveyPointCtaView microSurveyPointCtaView) {
        Function0<Unit> function0 = microSurveyPointCtaView.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.containerView.getBackground().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(colorScheme.getBackground(), BlendModeCompat.SRC_IN));
        this.surveyHeaderView.inject(viewDependencies, colorScheme);
        this.surveyFooterView.inject(colorScheme);
        this.questionHeaderView.inject(viewDependencies, colorScheme);
        this.submitView.inject(viewDependencies, colorScheme);
        this.disclaimerView.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData data, Bundle savedState) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bindingData = data;
        boolean z = !data.isFullScreen();
        MicroSurveyPointFragmentUtilsKt.adjustCardHeightToPresentationStyle(this.cardView, z);
        SurvicateViewUtils.INSTANCE.applySafeCardMargins(this.cardView, z);
        this.surveyHeaderView.bindData(data.getSurveyHeaderBindingData());
        this.surveyFooterView.setVisibility(data.isFooterVisible() ? 0 : 8);
        this.questionHeaderView.bindData(data.getQuestionHeaderBindingData());
        bindDisclaimer(savedState);
        updateSubmitState();
    }

    private final void bindDisclaimer(Bundle savedState) {
        this.disclaimerView.bindData(new MicroDisclaimerView.BindingData(getDisclaimerSettings()), savedState);
        this.disclaimerView.setVisibility(getDisclaimerSettings() != null ? 0 : 8);
        this.disclaimerView.setOnCheckboxToggle(new C84331(this));
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaView$bindDisclaimer$1 */
    /* JADX INFO: compiled from: MicroSurveyPointCtaView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84331 extends FunctionReferenceImpl implements Function0<Unit> {
        C84331(Object obj) {
            super(0, obj, MicroSurveyPointCtaView.class, "updateSubmitState", "updateSubmitState()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((MicroSurveyPointCtaView) this.receiver).updateSubmitState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitState() {
        SubmitViewState.Companion companion = SubmitViewState.INSTANCE;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        this.submitView.setState(MicroSubmitViewKt.create(companion, bindingData.getSubmitViewConfig(), getCurrentValidationState()));
    }

    public final QuestionValidationState getCurrentValidationState() {
        QuestionValidationStateBuilder questionValidationStateBuilder = QuestionValidationStateBuilder.INSTANCE;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return questionValidationStateBuilder.buildCtaValidationState(bindingData.getPointSettings(), this.disclaimerView.isDisclaimerAccepted());
    }

    /* JADX INFO: compiled from: MicroSurveyPointCtaView.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "surveyHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "submitViewConfig", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "isFooterVisible", "", "isFullScreen", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;ZZ)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "getSurveyHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getSubmitViewConfig", "()Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "()Z", "pointSettings", "Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;", "getPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final boolean isFooterVisible;
        private final boolean isFullScreen;
        private final CtaSettings pointSettings;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SubmitViewConfiguration submitViewConfig;
        private final SurveyHeaderBindingData surveyHeaderBindingData;
        private final SurveyCtaSurveyPoint surveyPoint;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyCtaSurveyPoint surveyCtaSurveyPoint, SurveyHeaderBindingData surveyHeaderBindingData, QuestionHeaderBindingData questionHeaderBindingData, SubmitViewConfiguration submitViewConfiguration, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyCtaSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                surveyHeaderBindingData = bindingData.surveyHeaderBindingData;
            }
            if ((i & 4) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 8) != 0) {
                submitViewConfiguration = bindingData.submitViewConfig;
            }
            if ((i & 16) != 0) {
                z = bindingData.isFooterVisible;
            }
            if ((i & 32) != 0) {
                z2 = bindingData.isFullScreen;
            }
            boolean z3 = z;
            boolean z4 = z2;
            return bindingData.copy(surveyCtaSurveyPoint, surveyHeaderBindingData, questionHeaderBindingData, submitViewConfiguration, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyCtaSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SurveyHeaderBindingData getSurveyHeaderBindingData() {
            return this.surveyHeaderBindingData;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SubmitViewConfiguration getSubmitViewConfig() {
            return this.submitViewConfig;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsFooterVisible() {
            return this.isFooterVisible;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsFullScreen() {
            return this.isFullScreen;
        }

        public final BindingData copy(SurveyCtaSurveyPoint surveyPoint, SurveyHeaderBindingData surveyHeaderBindingData, QuestionHeaderBindingData questionHeaderBindingData, SubmitViewConfiguration submitViewConfig, boolean isFooterVisible, boolean isFullScreen) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(surveyHeaderBindingData, "surveyHeaderBindingData");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(submitViewConfig, "submitViewConfig");
            return new BindingData(surveyPoint, surveyHeaderBindingData, questionHeaderBindingData, submitViewConfig, isFooterVisible, isFullScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.surveyHeaderBindingData, bindingData.surveyHeaderBindingData) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData) && Intrinsics.areEqual(this.submitViewConfig, bindingData.submitViewConfig) && this.isFooterVisible == bindingData.isFooterVisible && this.isFullScreen == bindingData.isFullScreen;
        }

        public int hashCode() {
            return (((((((((this.surveyPoint.hashCode() * 31) + this.surveyHeaderBindingData.hashCode()) * 31) + this.questionHeaderBindingData.hashCode()) * 31) + this.submitViewConfig.hashCode()) * 31) + Boolean.hashCode(this.isFooterVisible)) * 31) + Boolean.hashCode(this.isFullScreen);
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", surveyHeaderBindingData=" + this.surveyHeaderBindingData + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ", submitViewConfig=" + this.submitViewConfig + ", isFooterVisible=" + this.isFooterVisible + ", isFullScreen=" + this.isFullScreen + ')';
        }

        public BindingData(SurveyCtaSurveyPoint surveyPoint, SurveyHeaderBindingData surveyHeaderBindingData, QuestionHeaderBindingData questionHeaderBindingData, SubmitViewConfiguration submitViewConfig, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(surveyHeaderBindingData, "surveyHeaderBindingData");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(submitViewConfig, "submitViewConfig");
            this.surveyPoint = surveyPoint;
            this.surveyHeaderBindingData = surveyHeaderBindingData;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.submitViewConfig = submitViewConfig;
            this.isFooterVisible = z;
            this.isFullScreen = z2;
            this.pointSettings = surveyPoint.getCtaSettings();
        }

        public final SurveyCtaSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final SurveyHeaderBindingData getSurveyHeaderBindingData() {
            return this.surveyHeaderBindingData;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final SubmitViewConfiguration getSubmitViewConfig() {
            return this.submitViewConfig;
        }

        public final boolean isFooterVisible() {
            return this.isFooterVisible;
        }

        public final boolean isFullScreen() {
            return this.isFullScreen;
        }

        public final CtaSettings getPointSettings() {
            return this.pointSettings;
        }
    }
}
