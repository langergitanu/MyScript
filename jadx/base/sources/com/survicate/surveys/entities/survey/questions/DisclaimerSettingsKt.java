package com.survicate.surveys.entities.survey.questions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisclaimerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"getCheckboxStateToSend", "", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "isAccepted", "(Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Z)Ljava/lang/Boolean;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisclaimerSettingsKt {
    public static final Boolean getCheckboxStateToSend(DisclaimerSettings disclaimerSettings, boolean z) {
        Intrinsics.checkNotNullParameter(disclaimerSettings, "<this>");
        if (disclaimerSettings.getCheckboxVisible()) {
            return Boolean.valueOf(z);
        }
        return null;
    }
}
