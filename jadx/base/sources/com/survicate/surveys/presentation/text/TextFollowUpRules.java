package com.survicate.surveys.presentation.text;

import kotlin.Metadata;

/* JADX INFO: compiled from: TextFollowUpRules.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/TextFollowUpRules;", "", "<init>", "()V", "isFollowUpAvailable", "", "followUpLimit", "", "followUpQuestionCount", "answerItemCount", "areCurrentAnswersProvided", "followUpEditsRemaining", "(Ljava/lang/Integer;Ljava/lang/Integer;IZLjava/lang/Integer;)Z", "isFollowUpEnabled", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextFollowUpRules {
    public static final TextFollowUpRules INSTANCE = new TextFollowUpRules();

    private TextFollowUpRules() {
    }

    public final boolean isFollowUpAvailable(Integer followUpLimit, Integer followUpQuestionCount, int answerItemCount, boolean areCurrentAnswersProvided, Integer followUpEditsRemaining) {
        if (isFollowUpEnabled(followUpLimit, followUpQuestionCount) && followUpQuestionCount != null) {
            boolean z = answerItemCount == followUpQuestionCount.intValue() + 1;
            boolean z2 = (followUpEditsRemaining != null ? followUpEditsRemaining.intValue() : 0) > 0;
            if (!z && areCurrentAnswersProvided && z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isFollowUpEnabled(Integer followUpLimit, Integer followUpQuestionCount) {
        return (followUpLimit == null || followUpQuestionCount == null || followUpQuestionCount.intValue() <= 0) ? false : true;
    }
}
