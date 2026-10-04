package com.survicate.surveys.presentation.base.micro;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.survicate.surveys.SurveyActivity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurveyPointFragment;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0012\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/micro/MicroSurveyPointFragment;", "Lcom/survicate/surveys/presentation/base/SurveyPointFragment;", "layoutId", "", "<init>", "(I)V", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "getSurveyViewModel", "()Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "requireSurveyViewModel", "onViewCreated", "", "view", "Landroid/view/View;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "drawStatusBarColor", "statusColor", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class MicroSurveyPointFragment extends SurveyPointFragment {
    public MicroSurveyPointFragment(int i) {
        super(i);
    }

    protected final SurveyViewModel getSurveyViewModel() {
        return requireSurveyViewModel();
    }

    private final SurveyViewModel requireSurveyViewModel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.survicate.surveys.SurveyActivity");
        SurveyViewModel surveyViewModel = ((SurveyActivity) fragmentActivityRequireActivity).getSurveyViewModel();
        if (surveyViewModel != null) {
            return surveyViewModel;
        }
        throw new IllegalStateException("SurveyViewModel is not initialized".toString());
    }

    @Override // com.survicate.surveys.presentation.base.SurveyPointFragment
    public void onViewCreated(View view, ViewDependencies viewDependencies, DisplayEngine displayEngine, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        drawStatusBarColor(!displayEngine.isSurveyFullScreen() ? 0 : colorScheme.getAnswer());
    }

    private final void drawStatusBarColor(int statusColor) {
        Window window = requireActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(statusColor);
    }
}
