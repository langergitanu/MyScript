package com.survicate.surveys.presentation.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.base.DebouncingOnClickListener;
import com.survicate.surveys.presentation.base.micro.MicroSurveyPointFragmentUtilsKt;
import com.survicate.surveys.presentation.page.PageItem;
import com.survicate.surveys.presentation.widget.MicroDisclaimerView;
import com.survicate.surveys.presentation.widget.MicroSubmitView;
import com.survicate.surveys.presentation.widget.MicroSubmitViewKt;
import com.survicate.surveys.presentation.widget.MicroSurveyFooter;
import com.survicate.surveys.presentation.widget.MicroSurveyHeader;
import com.survicate.surveys.presentation.widget.SubmitViewConfiguration;
import com.survicate.surveys.presentation.widget.SubmitViewState;
import com.survicate.surveys.presentation.widget.SurveyHeaderBindingData;
import com.survicate.surveys.utils.SurvicateViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001SB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010>\u001a\u00020\fH\u0002J\b\u0010?\u001a\u00020\fH\u0002J\u0016\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020&J\u0010\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020&H\u0002J\u0010\u0010H\u001a\u00020\f2\u0006\u0010F\u001a\u00020&H\u0002J\u0010\u0010I\u001a\u00020\f2\u0006\u0010F\u001a\u00020&H\u0002J\u0010\u0010J\u001a\u00020\f2\u0006\u0010F\u001a\u00020&H\u0002J\u0010\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\"H\u0002J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010F\u001a\u00020&H\u0002J\b\u0010P\u001a\u00020\fH\u0002J\u000e\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020*R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u0014\u0010<\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006T"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onCloseSurveyClick", "Lkotlin/Function0;", "", "getOnCloseSurveyClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseSurveyClick", "(Lkotlin/jvm/functions/Function0;)V", "onLanguageSelected", "Lkotlin/Function1;", "", "getOnLanguageSelected", "()Lkotlin/jvm/functions/Function1;", "setOnLanguageSelected", "(Lkotlin/jvm/functions/Function1;)V", "onSubmitClick", "getOnSubmitClick", "setOnSubmitClick", "onBackClick", "getOnBackClick", "setOnBackClick", "onPoweredByClick", "getOnPoweredByClick", "setOnPoweredByClick", "onDisclaimerToggle", "", "getOnDisclaimerToggle", "setOnDisclaimerToggle", "bindingData", "Lcom/survicate/surveys/presentation/page/SurveyPageView$BindingData;", "adapter", "Lcom/survicate/surveys/presentation/page/SurveyPageAdapter;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "cardView", "Landroidx/cardview/widget/CardView;", "containerView", "Landroid/view/ViewGroup;", "surveyHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroSurveyHeader;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "wrapperView", "disclaimerView", "Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;", "submitView", "Lcom/survicate/surveys/presentation/widget/MicroSubmitView;", "footerView", "Lcom/survicate/surveys/presentation/widget/MicroSurveyFooter;", "isUsingCenteringLayout", "Ljava/lang/Boolean;", "isLandscape", "()Z", "setupContentWindowInsets", "setupListeners", "inject", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "data", "bindCardView", "bindSurveyHeader", "bindContent", "bindDisclaimerState", "updateLayoutManager", "isFullScreen", "buildPageItems", "", "Lcom/survicate/surveys/presentation/page/PageItem;", "bindSubmitState", "updateValidationState", "state", "BindingData", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPageView extends FrameLayout {
    private SurveyPageAdapter adapter;
    private BindingData bindingData;
    private final CardView cardView;
    private final ViewGroup containerView;
    private final MicroDisclaimerView disclaimerView;
    private final MicroSurveyFooter footerView;
    private Boolean isUsingCenteringLayout;
    private Function0<Unit> onBackClick;
    private Function0<Unit> onCloseSurveyClick;
    private Function1<? super Boolean, Unit> onDisclaimerToggle;
    private Function1<? super String, Unit> onLanguageSelected;
    private Function0<Unit> onPoweredByClick;
    private Function0<Unit> onSubmitClick;
    private final RecyclerView recyclerView;
    private final MicroSubmitView submitView;
    private final MicroSurveyHeader surveyHeaderView;
    private QuestionValidationState validationState;
    private final ViewGroup wrapperView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurveyPageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurveyPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SurveyPageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.validationState = new QuestionValidationState(true, false);
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_page, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_page_card);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.cardView = (CardView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_page_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.containerView = (ViewGroup) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_survey_page_survey_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.surveyHeaderView = (MicroSurveyHeader) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_survey_page_recycler);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.recyclerView = (RecyclerView) viewFindViewById4;
        this.wrapperView = (ViewGroup) viewInflate.findViewById(C8369R.id.view_micro_survey_page_wrapper);
        this.disclaimerView = (MicroDisclaimerView) viewInflate.findViewById(C8369R.id.view_micro_survey_page_disclaimer);
        this.submitView = (MicroSubmitView) viewInflate.findViewById(C8369R.id.view_micro_survey_page_submit);
        this.footerView = (MicroSurveyFooter) viewInflate.findViewById(C8369R.id.view_micro_survey_page_footer);
        setupContentWindowInsets();
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

    public final Function1<Boolean, Unit> getOnDisclaimerToggle() {
        return this.onDisclaimerToggle;
    }

    public final void setOnDisclaimerToggle(Function1<? super Boolean, Unit> function1) {
        this.onDisclaimerToggle = function1;
    }

    private final boolean isLandscape() {
        return this.wrapperView == null;
    }

    private final void setupContentWindowInsets() {
        SurvicateViewUtils.INSTANCE.applySafeContentPaddings(this.containerView);
        if (isLandscape()) {
            return;
        }
        List<? extends View> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new FrameLayout[]{this.disclaimerView, this.submitView, this.footerView});
        SurvicateViewUtils survicateViewUtils = SurvicateViewUtils.INSTANCE;
        ViewGroup viewGroup = this.wrapperView;
        Intrinsics.checkNotNull(viewGroup);
        survicateViewUtils.applyKeyboardMargin(viewGroup, listListOfNotNull);
    }

    private final void setupListeners() {
        this.surveyHeaderView.setOnCloseButtonListener(new DebouncingOnClickListener() { // from class: com.survicate.surveys.presentation.page.SurveyPageView.setupListeners.1
            @Override // com.survicate.surveys.presentation.base.DebouncingOnClickListener
            public void doClick(View v) {
                Function0<Unit> onCloseSurveyClick = SurveyPageView.this.getOnCloseSurveyClick();
                if (onCloseSurveyClick != null) {
                    onCloseSurveyClick.invoke();
                }
            }
        });
        this.surveyHeaderView.setOnLanguageSelected(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurveyPageView.setupListeners$lambda$0(this.f$0, (String) obj);
            }
        });
        MicroSubmitView microSubmitView = this.submitView;
        if (microSubmitView != null) {
            microSubmitView.setOnSubmitClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.setupListeners$lambda$1(this.f$0);
                }
            });
        }
        MicroSubmitView microSubmitView2 = this.submitView;
        if (microSubmitView2 != null) {
            microSubmitView2.setOnBackClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.setupListeners$lambda$2(this.f$0);
                }
            });
        }
        MicroSurveyFooter microSurveyFooter = this.footerView;
        if (microSurveyFooter != null) {
            microSurveyFooter.setOnPoweredByClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.setupListeners$lambda$3(this.f$0);
                }
            });
        }
        MicroDisclaimerView microDisclaimerView = this.disclaimerView;
        if (microDisclaimerView != null) {
            microDisclaimerView.setOnCheckboxToggle(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.setupListeners$lambda$4(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(SurveyPageView surveyPageView, String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        Function1<? super String, Unit> function1 = surveyPageView.onLanguageSelected;
        if (function1 != null) {
            function1.invoke(langCode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onSubmitClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$2(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$3(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onPoweredByClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$4(SurveyPageView surveyPageView) {
        Function1<? super Boolean, Unit> function1 = surveyPageView.onDisclaimerToggle;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(surveyPageView.disclaimerView.isChecked()));
        }
        return Unit.INSTANCE;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.containerView.getBackground().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(colorScheme.getBackground(), BlendModeCompat.SRC_IN));
        this.surveyHeaderView.inject(viewDependencies, colorScheme);
        MicroDisclaimerView microDisclaimerView = this.disclaimerView;
        if (microDisclaimerView != null) {
            microDisclaimerView.inject(viewDependencies, colorScheme);
        }
        MicroSubmitView microSubmitView = this.submitView;
        if (microSubmitView != null) {
            microSubmitView.inject(viewDependencies, colorScheme);
        }
        MicroSurveyFooter microSurveyFooter = this.footerView;
        if (microSurveyFooter != null) {
            microSurveyFooter.inject(colorScheme);
        }
        SurveyPageAdapter surveyPageAdapter = new SurveyPageAdapter(viewDependencies, colorScheme);
        this.adapter = surveyPageAdapter;
        surveyPageAdapter.setOnDisclaimerToggle(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurveyPageView.inject$lambda$5(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        SurveyPageAdapter surveyPageAdapter2 = null;
        this.recyclerView.setItemAnimator(null);
        RecyclerView recyclerView = this.recyclerView;
        SurveyPageAdapter surveyPageAdapter3 = this.adapter;
        if (surveyPageAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            surveyPageAdapter2 = surveyPageAdapter3;
        }
        recyclerView.setAdapter(surveyPageAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inject$lambda$5(SurveyPageView surveyPageView, boolean z) {
        BindingData bindingData = surveyPageView.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        surveyPageView.bindingData = BindingData.copy$default(bindingData, null, null, false, false, null, null, z, 63, null);
        Function1<? super Boolean, Unit> function1 = surveyPageView.onDisclaimerToggle;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    public final void bindData(BindingData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bindingData = data;
        bindCardView(data);
        bindSurveyHeader(data);
        bindContent(data);
    }

    private final void bindCardView(BindingData data) {
        boolean z = !data.isFullScreen();
        MicroSurveyPointFragmentUtilsKt.adjustCardHeightToPresentationStyle(this.cardView, z);
        SurvicateViewUtils.INSTANCE.applySafeCardMargins(this.cardView, z);
    }

    private final void bindSurveyHeader(BindingData data) {
        this.surveyHeaderView.bindData(data.getSurveyHeaderBindingData());
    }

    private final void bindContent(BindingData data) {
        SurveyPageAdapter surveyPageAdapter = null;
        if (isLandscape()) {
            SurveyPageAdapter surveyPageAdapter2 = this.adapter;
            if (surveyPageAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                surveyPageAdapter2 = null;
            }
            surveyPageAdapter2.setOnSubmitClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.bindContent$lambda$6(this.f$0);
                }
            });
            SurveyPageAdapter surveyPageAdapter3 = this.adapter;
            if (surveyPageAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                surveyPageAdapter3 = null;
            }
            surveyPageAdapter3.setOnBackClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.bindContent$lambda$7(this.f$0);
                }
            });
            SurveyPageAdapter surveyPageAdapter4 = this.adapter;
            if (surveyPageAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                surveyPageAdapter4 = null;
            }
            surveyPageAdapter4.setOnPoweredByClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageView.bindContent$lambda$8(this.f$0);
                }
            });
        } else {
            MicroSurveyFooter microSurveyFooter = this.footerView;
            if (microSurveyFooter != null) {
                microSurveyFooter.setVisibility(data.isFooterVisible() ? 0 : 8);
            }
            bindDisclaimerState(data);
            bindSubmitState();
        }
        updateLayoutManager(data.isFullScreen());
        SurveyPageAdapter surveyPageAdapter5 = this.adapter;
        if (surveyPageAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            surveyPageAdapter = surveyPageAdapter5;
        }
        surveyPageAdapter.submitList(buildPageItems(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindContent$lambda$6(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onSubmitClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindContent$lambda$7(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindContent$lambda$8(SurveyPageView surveyPageView) {
        Function0<Unit> function0 = surveyPageView.onPoweredByClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final void bindDisclaimerState(BindingData data) {
        DisclaimerSettings disclaimerSettings = data.getDisclaimerSettings();
        if (disclaimerSettings == null) {
            MicroDisclaimerView microDisclaimerView = this.disclaimerView;
            if (microDisclaimerView != null) {
                microDisclaimerView.setVisibility(8);
                return;
            }
            return;
        }
        MicroDisclaimerView microDisclaimerView2 = this.disclaimerView;
        if (microDisclaimerView2 != null) {
            microDisclaimerView2.setVisibility(0);
        }
        MicroDisclaimerView microDisclaimerView3 = this.disclaimerView;
        if (microDisclaimerView3 != null) {
            microDisclaimerView3.bindData(new MicroDisclaimerView.BindingData(disclaimerSettings), BundleKt.bundleOf(TuplesKt.m1606to(MicroDisclaimerView.IS_CHECKBOX_CHECKED, Boolean.valueOf(data.getDisclaimerAccepted()))));
        }
    }

    private final void updateLayoutManager(boolean isFullScreen) {
        LinearLayoutManager linearLayoutManager;
        boolean z = isLandscape() && isFullScreen;
        if (Intrinsics.areEqual(Boolean.valueOf(z), this.isUsingCenteringLayout)) {
            return;
        }
        this.isUsingCenteringLayout = Boolean.valueOf(z);
        RecyclerView recyclerView = this.recyclerView;
        if (z) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            linearLayoutManager = new CenteringLinearLayoutManager(context, new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageView$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SurveyPageView.updateLayoutManager$lambda$9(this.f$0, ((Integer) obj).intValue()));
                }
            });
        } else {
            linearLayoutManager = new LinearLayoutManager(getContext());
        }
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateLayoutManager$lambda$9(SurveyPageView surveyPageView, int i) {
        SurveyPageAdapter surveyPageAdapter = surveyPageView.adapter;
        if (surveyPageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            surveyPageAdapter = null;
        }
        return surveyPageAdapter.isQuestionPosition(i);
    }

    private final List<PageItem> buildPageItems(BindingData data) {
        List<QuestionViewModel> questionViewModels = data.getQuestionViewModels();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(questionViewModels, 10));
        Iterator<T> it = questionViewModels.iterator();
        while (it.hasNext()) {
            arrayList.add(new PageItem.Question((QuestionViewModel) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        if (!isLandscape()) {
            return arrayList2;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(arrayList2);
        if (data.getDisclaimerSettings() != null) {
            listCreateListBuilder.add(new PageItem.Disclaimer(data.getDisclaimerSettings(), data.getDisclaimerAccepted()));
        }
        listCreateListBuilder.add(new PageItem.Submit(data.getSubmitViewConfig(), this.validationState));
        if (data.isFooterVisible()) {
            listCreateListBuilder.add(PageItem.Footer.INSTANCE);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final void bindSubmitState() {
        SubmitViewState.Companion companion = SubmitViewState.INSTANCE;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        SubmitViewState submitViewStateCreate = MicroSubmitViewKt.create(companion, bindingData.getSubmitViewConfig(), this.validationState);
        MicroSubmitView microSubmitView = this.submitView;
        if (microSubmitView != null) {
            microSubmitView.setState(submitViewStateCreate);
        }
    }

    public final void updateValidationState(QuestionValidationState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(this.validationState, state)) {
            return;
        }
        this.validationState = state;
        if (isLandscape()) {
            SurveyPageAdapter surveyPageAdapter = this.adapter;
            if (surveyPageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                surveyPageAdapter = null;
            }
            surveyPageAdapter.updateSubmitValidationState(state);
            return;
        }
        bindSubmitState();
    }

    /* JADX INFO: compiled from: SurveyPageView.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JW\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageView$BindingData;", "", "surveyHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "submitViewConfig", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "isFooterVisible", "", "isFullScreen", "questionViewModels", "", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "disclaimerAccepted", "<init>", "(Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;ZZLjava/util/List;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Z)V", "getSurveyHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "getSubmitViewConfig", "()Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "()Z", "getQuestionViewModels", "()Ljava/util/List;", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisclaimerAccepted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final boolean disclaimerAccepted;
        private final DisclaimerSettings disclaimerSettings;
        private final boolean isFooterVisible;
        private final boolean isFullScreen;
        private final List<QuestionViewModel> questionViewModels;
        private final SubmitViewConfiguration submitViewConfig;
        private final SurveyHeaderBindingData surveyHeaderBindingData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyHeaderBindingData surveyHeaderBindingData, SubmitViewConfiguration submitViewConfiguration, boolean z, boolean z2, List list, DisclaimerSettings disclaimerSettings, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyHeaderBindingData = bindingData.surveyHeaderBindingData;
            }
            if ((i & 2) != 0) {
                submitViewConfiguration = bindingData.submitViewConfig;
            }
            if ((i & 4) != 0) {
                z = bindingData.isFooterVisible;
            }
            if ((i & 8) != 0) {
                z2 = bindingData.isFullScreen;
            }
            if ((i & 16) != 0) {
                list = bindingData.questionViewModels;
            }
            if ((i & 32) != 0) {
                disclaimerSettings = bindingData.disclaimerSettings;
            }
            if ((i & 64) != 0) {
                z3 = bindingData.disclaimerAccepted;
            }
            DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
            boolean z4 = z3;
            List list2 = list;
            boolean z5 = z;
            return bindingData.copy(surveyHeaderBindingData, submitViewConfiguration, z5, z2, list2, disclaimerSettings2, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyHeaderBindingData getSurveyHeaderBindingData() {
            return this.surveyHeaderBindingData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SubmitViewConfiguration getSubmitViewConfig() {
            return this.submitViewConfig;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsFooterVisible() {
            return this.isFooterVisible;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsFullScreen() {
            return this.isFullScreen;
        }

        public final List<QuestionViewModel> component5() {
            return this.questionViewModels;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final DisclaimerSettings getDisclaimerSettings() {
            return this.disclaimerSettings;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDisclaimerAccepted() {
            return this.disclaimerAccepted;
        }

        public final BindingData copy(SurveyHeaderBindingData surveyHeaderBindingData, SubmitViewConfiguration submitViewConfig, boolean isFooterVisible, boolean isFullScreen, List<? extends QuestionViewModel> questionViewModels, DisclaimerSettings disclaimerSettings, boolean disclaimerAccepted) {
            Intrinsics.checkNotNullParameter(surveyHeaderBindingData, "surveyHeaderBindingData");
            Intrinsics.checkNotNullParameter(submitViewConfig, "submitViewConfig");
            Intrinsics.checkNotNullParameter(questionViewModels, "questionViewModels");
            return new BindingData(surveyHeaderBindingData, submitViewConfig, isFooterVisible, isFullScreen, questionViewModels, disclaimerSettings, disclaimerAccepted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyHeaderBindingData, bindingData.surveyHeaderBindingData) && Intrinsics.areEqual(this.submitViewConfig, bindingData.submitViewConfig) && this.isFooterVisible == bindingData.isFooterVisible && this.isFullScreen == bindingData.isFullScreen && Intrinsics.areEqual(this.questionViewModels, bindingData.questionViewModels) && Intrinsics.areEqual(this.disclaimerSettings, bindingData.disclaimerSettings) && this.disclaimerAccepted == bindingData.disclaimerAccepted;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.surveyHeaderBindingData.hashCode() * 31) + this.submitViewConfig.hashCode()) * 31) + Boolean.hashCode(this.isFooterVisible)) * 31) + Boolean.hashCode(this.isFullScreen)) * 31) + this.questionViewModels.hashCode()) * 31;
            DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
            return ((iHashCode + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31) + Boolean.hashCode(this.disclaimerAccepted);
        }

        public String toString() {
            return "BindingData(surveyHeaderBindingData=" + this.surveyHeaderBindingData + ", submitViewConfig=" + this.submitViewConfig + ", isFooterVisible=" + this.isFooterVisible + ", isFullScreen=" + this.isFullScreen + ", questionViewModels=" + this.questionViewModels + ", disclaimerSettings=" + this.disclaimerSettings + ", disclaimerAccepted=" + this.disclaimerAccepted + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BindingData(SurveyHeaderBindingData surveyHeaderBindingData, SubmitViewConfiguration submitViewConfig, boolean z, boolean z2, List<? extends QuestionViewModel> questionViewModels, DisclaimerSettings disclaimerSettings, boolean z3) {
            Intrinsics.checkNotNullParameter(surveyHeaderBindingData, "surveyHeaderBindingData");
            Intrinsics.checkNotNullParameter(submitViewConfig, "submitViewConfig");
            Intrinsics.checkNotNullParameter(questionViewModels, "questionViewModels");
            this.surveyHeaderBindingData = surveyHeaderBindingData;
            this.submitViewConfig = submitViewConfig;
            this.isFooterVisible = z;
            this.isFullScreen = z2;
            this.questionViewModels = questionViewModels;
            this.disclaimerSettings = disclaimerSettings;
            this.disclaimerAccepted = z3;
        }

        public final SurveyHeaderBindingData getSurveyHeaderBindingData() {
            return this.surveyHeaderBindingData;
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

        public final List<QuestionViewModel> getQuestionViewModels() {
            return this.questionViewModels;
        }

        public final DisclaimerSettings getDisclaimerSettings() {
            return this.disclaimerSettings;
        }

        public final boolean getDisclaimerAccepted() {
            return this.disclaimerAccepted;
        }
    }
}
