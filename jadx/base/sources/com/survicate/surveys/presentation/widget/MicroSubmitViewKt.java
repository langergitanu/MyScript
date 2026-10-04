package com.survicate.surveys.presentation.widget;

import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.presentation.widget.SubmitViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSubmitView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m1599d2 = {"create", "Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "Lcom/survicate/surveys/presentation/widget/SubmitViewState$Factory;", "configuration", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSubmitViewKt {
    public static final SubmitViewState create(SubmitViewState.Companion companion, SubmitViewConfiguration configuration, QuestionValidationState validationState) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(validationState, "validationState");
        if (configuration.getHasNavigationButtons() && !configuration.isFirstPointForFirstTime()) {
            return new SubmitViewState.Navigation(!configuration.isFirstSurveyPoint(), configuration.getBackButtonText(), validationState.isSuccess(), configuration.getSubmitButtonText(), configuration.getForceCenter());
        }
        if (validationState.getHideDefaultSubmitButton()) {
            return SubmitViewState.Hidden.INSTANCE;
        }
        return new SubmitViewState.Submit(validationState.isSuccess(), configuration.getSubmitButtonText(), configuration.getForceCenter());
    }
}
