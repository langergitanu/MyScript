package com.survicate.surveys.presentation.page;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.SurveyActivity;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.presentation.base.SurveyPointFragment;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import com.survicate.surveys.presentation.cta.CallToActionUtil;
import com.survicate.surveys.presentation.date.DateQuestionViewModel;
import com.survicate.surveys.presentation.date.micro.MicroDatePickerFragment;
import com.survicate.surveys.utils.SurvicateLocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\b\u0010'\u001a\u00020\u0015H\u0002J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "pageView", "Lcom/survicate/surveys/presentation/page/SurveyPageView;", "getPageView", "()Lcom/survicate/surveys/presentation/page/SurveyPageView;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "getSurveyViewModel", "()Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "pageViewModel", "Lcom/survicate/surveys/presentation/page/SurveyPageViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "surveyPoint$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "createPageViewModel", "wireDatePickerRequests", "showDatePicker", "pointId", "", "selectedDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "bindPage", "drawStatusBarColor", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "setupListeners", "rebuildPage", "onStop", "onDestroyView", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPageFragment extends Fragment {
    private SurveyPageViewModel pageViewModel;

    /* JADX INFO: renamed from: surveyPoint$delegate, reason: from kotlin metadata */
    private final Lazy surveyPoint;

    public SurveyPageFragment() {
        super(C8369R.layout.fragment_micro_survey_page);
        this.surveyPoint = LazyKt.lazy(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.surveyPoint_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final SurveyPageView getPageView() {
        View viewFindViewById = requireView().findViewById(C8369R.id.fragment_micro_survey_page_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (SurveyPageView) viewFindViewById;
    }

    private final SurveyViewModel getSurveyViewModel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.survicate.surveys.SurveyActivity");
        SurveyViewModel surveyViewModel = ((SurveyActivity) fragmentActivityRequireActivity).getSurveyViewModel();
        if (surveyViewModel != null) {
            return surveyViewModel;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final SurveyPoint getSurveyPoint() {
        return (SurveyPoint) this.surveyPoint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurveyPoint surveyPoint_delegate$lambda$0(SurveyPageFragment surveyPageFragment) {
        Parcelable parcelable;
        Bundle bundleRequireArguments = surveyPageFragment.requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundleRequireArguments.getParcelable(SurveyPointFragment.SURVEY_POINT_ARG, SurveyPoint.class);
        } else {
            Parcelable parcelable2 = bundleRequireArguments.getParcelable(SurveyPointFragment.SURVEY_POINT_ARG);
            if (!(parcelable2 instanceof SurveyPoint)) {
                parcelable2 = null;
            }
            parcelable = (SurveyPoint) parcelable2;
        }
        SurveyPoint surveyPoint = (SurveyPoint) parcelable;
        if (surveyPoint != null) {
            return surveyPoint;
        }
        throw new IllegalStateException("SurveyPoint argument is missing.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        createPageViewModel();
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        SurveyPageViewModel surveyPageViewModel2 = null;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Theme surveyTheme = surveyPageViewModel.getSurveyTheme(contextRequireContext);
        if (surveyTheme == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        SurveyPageView pageView = getPageView();
        SurveyPageViewModel surveyPageViewModel3 = this.pageViewModel;
        if (surveyPageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
        } else {
            surveyPageViewModel2 = surveyPageViewModel3;
        }
        pageView.inject(surveyPageViewModel2.getViewDependencies(), surveyTheme.getColorScheme());
        bindPage();
        drawStatusBarColor(surveyTheme.getColorScheme());
        setupListeners();
    }

    private final void createPageViewModel() {
        final SurveyPageViewModel surveyPageViewModelEnterPage$survicate_sdk_release = getSurveyViewModel().enterPage$survicate_sdk_release(getSurveyPoint());
        surveyPageViewModelEnterPage$survicate_sdk_release.setOnValidationChanged(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.createPageViewModel$lambda$3$lambda$1(this.f$0, surveyPageViewModelEnterPage$survicate_sdk_release);
            }
        });
        surveyPageViewModelEnterPage$survicate_sdk_release.setOnOpenLinkRequested(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurveyPageFragment.createPageViewModel$lambda$3$lambda$2(this.f$0, (ButtonLinkCtaSettings) obj);
            }
        });
        this.pageViewModel = surveyPageViewModelEnterPage$survicate_sdk_release;
        wireDatePickerRequests();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPageViewModel$lambda$3$lambda$1(SurveyPageFragment surveyPageFragment, SurveyPageViewModel surveyPageViewModel) {
        surveyPageFragment.getPageView().updateValidationState(surveyPageViewModel.getValidationState());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPageViewModel$lambda$3$lambda$2(SurveyPageFragment surveyPageFragment, ButtonLinkCtaSettings linkSettings) {
        Intrinsics.checkNotNullParameter(linkSettings, "linkSettings");
        Context contextRequireContext = surveyPageFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        CallToActionUtil.openCtaLink(linkSettings, contextRequireContext);
        return Unit.INSTANCE;
    }

    private final void wireDatePickerRequests() {
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        for (final QuestionViewModel questionViewModel : surveyPageViewModel.getQuestionViewModels()) {
            if (questionViewModel instanceof DateQuestionViewModel) {
                ((DateQuestionViewModel) questionViewModel).setOnShowDatePickerRequested(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SurveyPageFragment.wireDatePickerRequests$lambda$4(this.f$0, questionViewModel, (SurvicateLocalDate) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wireDatePickerRequests$lambda$4(SurveyPageFragment surveyPageFragment, QuestionViewModel questionViewModel, SurvicateLocalDate selectedDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        surveyPageFragment.showDatePicker(((DateQuestionViewModel) questionViewModel).getPointId(), selectedDate);
        return Unit.INSTANCE;
    }

    private final void showDatePicker(long pointId, SurvicateLocalDate selectedDate) {
        MicroDatePickerFragment microDatePickerFragmentNewInstance = MicroDatePickerFragment.INSTANCE.newInstance(selectedDate, pointId);
        microDatePickerFragmentNewInstance.setTargetFragment(this, 100);
        microDatePickerFragmentNewInstance.show(getParentFragmentManager(), "datePicker");
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Parcelable parcelable;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1 && data != null) {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) data.getParcelableExtra(MicroDatePickerFragment.SELECTED_DATE, SurvicateLocalDate.class);
            } else {
                Parcelable parcelableExtra = data.getParcelableExtra(MicroDatePickerFragment.SELECTED_DATE);
                if (!(parcelableExtra instanceof SurvicateLocalDate)) {
                    parcelableExtra = null;
                }
                parcelable = (SurvicateLocalDate) parcelableExtra;
            }
            SurvicateLocalDate survicateLocalDate = (SurvicateLocalDate) parcelable;
            if (survicateLocalDate == null) {
                return;
            }
            long longExtra = data.getLongExtra(MicroDatePickerFragment.POINT_ID, -1L);
            SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
            if (surveyPageViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
                surveyPageViewModel = null;
            }
            List<QuestionViewModel> questionViewModels = surveyPageViewModel.getQuestionViewModels();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : questionViewModels) {
                if (obj2 instanceof DateQuestionViewModel) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((DateQuestionViewModel) next).getPointId() == longExtra) {
                    obj = next;
                    break;
                }
            }
            DateQuestionViewModel dateQuestionViewModel = (DateQuestionViewModel) obj;
            if (dateQuestionViewModel != null) {
                dateQuestionViewModel.onDateSelected(survicateLocalDate);
            }
        }
    }

    private final void bindPage() {
        SurveyPageView pageView = getPageView();
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        SurveyPageViewModel surveyPageViewModel2 = null;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        pageView.bindData(surveyPageViewModel.getBindingData(contextRequireContext));
        SurveyPageView pageView2 = getPageView();
        SurveyPageViewModel surveyPageViewModel3 = this.pageViewModel;
        if (surveyPageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel3 = null;
        }
        pageView2.updateValidationState(surveyPageViewModel3.getValidationState());
        SurveyPageViewModel surveyPageViewModel4 = this.pageViewModel;
        if (surveyPageViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
        } else {
            surveyPageViewModel2 = surveyPageViewModel4;
        }
        surveyPageViewModel2.savePageState();
    }

    private final void drawStatusBarColor(ColorScheme colorScheme) {
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        int answer = surveyPageViewModel.isFullScreen() ? colorScheme.getAnswer() : 0;
        Window window = requireActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(answer);
    }

    private final void setupListeners() {
        SurveyPageView pageView = getPageView();
        pageView.setOnCloseSurveyClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$6(this.f$0);
            }
        });
        pageView.setOnSubmitClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$7(this.f$0);
            }
        });
        pageView.setOnBackClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$8(this.f$0);
            }
        });
        pageView.setOnPoweredByClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$9(this.f$0);
            }
        });
        pageView.setOnDisclaimerToggle(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$10(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        pageView.setOnLanguageSelected(new Function1() { // from class: com.survicate.surveys.presentation.page.SurveyPageFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurveyPageFragment.setupListeners$lambda$12$lambda$11(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$6(SurveyPageFragment surveyPageFragment) {
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.onSurveyClosed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$7(SurveyPageFragment surveyPageFragment) {
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.onSubmit();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$8(SurveyPageFragment surveyPageFragment) {
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.onBack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$9(SurveyPageFragment surveyPageFragment) {
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        FragmentActivity fragmentActivityRequireActivity = surveyPageFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        surveyPageViewModel.onPoweredByClick(fragmentActivityRequireActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$10(SurveyPageFragment surveyPageFragment, boolean z) {
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.onDisclaimerToggle(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$12$lambda$11(SurveyPageFragment surveyPageFragment, String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        SurveyPageViewModel surveyPageViewModel = surveyPageFragment.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.onLanguageSelected(langCode);
        surveyPageFragment.rebuildPage();
        return Unit.INSTANCE;
    }

    private final void rebuildPage() {
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        SurveyPageViewModel surveyPageViewModel2 = null;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.dispose();
        SurveyPageViewModel surveyPageViewModel3 = this.pageViewModel;
        if (surveyPageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
        } else {
            surveyPageViewModel2 = surveyPageViewModel3;
        }
        surveyPageViewModel2.savePageState();
        createPageViewModel();
        bindPage();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.savePageState();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SurveyPageViewModel surveyPageViewModel = this.pageViewModel;
        if (surveyPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            surveyPageViewModel = null;
        }
        surveyPageViewModel.dispose();
        super.onDestroyView();
    }
}
