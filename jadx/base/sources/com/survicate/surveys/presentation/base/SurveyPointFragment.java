package com.survicate.surveys.presentation.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.survicate.surveys.SurveyActivity;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.helpers.ViewDependencies;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&R\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurveyPointFragment;", "Landroidx/fragment/app/Fragment;", "layoutId", "", "<init>", "(I)V", "pointDisplayer", "Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getPointDisplayer", "()Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", "setPointDisplayer", "(Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class SurveyPointFragment extends Fragment {
    public static final String SURVEY_POINT_ARG = "SURVEY_POINT";
    protected SurveyPointDisplayer<? extends SurveyPoint> pointDisplayer;

    public abstract void onViewCreated(View view, ViewDependencies viewDependencies, DisplayEngine displayEngine, ColorScheme colorScheme);

    public SurveyPointFragment(int i) {
        super(i);
    }

    protected final SurveyPointDisplayer<? extends SurveyPoint> getPointDisplayer() {
        SurveyPointDisplayer<? extends SurveyPoint> surveyPointDisplayer = this.pointDisplayer;
        if (surveyPointDisplayer != null) {
            return surveyPointDisplayer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pointDisplayer");
        return null;
    }

    protected final void setPointDisplayer(SurveyPointDisplayer<? extends SurveyPoint> surveyPointDisplayer) {
        Intrinsics.checkNotNullParameter(surveyPointDisplayer, "<set-?>");
        this.pointDisplayer = surveyPointDisplayer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundleRequireArguments.getParcelable(SURVEY_POINT_ARG, SurveyPoint.class);
        } else {
            Parcelable parcelable2 = bundleRequireArguments.getParcelable(SURVEY_POINT_ARG);
            if (!(parcelable2 instanceof SurveyPoint)) {
                parcelable2 = null;
            }
            parcelable = (SurveyPoint) parcelable2;
        }
        SurveyPoint surveyPoint = (SurveyPoint) parcelable;
        if (surveyPoint == null) {
            throw new IllegalStateException("SurveyPoint argument is missing.");
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.survicate.surveys.SurveyActivity");
        SurveyActivity surveyActivity = (SurveyActivity) fragmentActivityRequireActivity;
        DisplayEngine displayEngine = surveyActivity.getDisplayEngine();
        if (displayEngine == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        SurveyViewModel surveyViewModel = surveyActivity.getSurveyViewModel();
        if (surveyViewModel == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        setPointDisplayer(surveyPoint.getDisplayer(displayEngine, surveyViewModel));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Theme surveyTheme = displayEngine.getSurveyTheme(contextRequireContext);
        if (surveyTheme == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        onViewCreated(view, getPointDisplayer().getViewDependencies(), displayEngine, surveyTheme.getColorScheme());
    }
}
