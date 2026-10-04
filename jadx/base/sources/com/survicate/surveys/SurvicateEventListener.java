package com.survicate.surveys;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateEventListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateEventListener;", "", "<init>", "()V", "onSurveyDisplayed", "", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/SurveyDisplayedEvent;", "onQuestionAnswered", "Lcom/survicate/surveys/QuestionAnsweredEvent;", "onSurveyClosed", "Lcom/survicate/surveys/SurveyClosedEvent;", "onSurveyCompleted", "Lcom/survicate/surveys/SurveyCompletedEvent;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public class SurvicateEventListener {
    public void onQuestionAnswered(QuestionAnsweredEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onSurveyClosed(SurveyClosedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onSurveyCompleted(SurveyCompletedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void onSurveyDisplayed(SurveyDisplayedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
