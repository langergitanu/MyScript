package com.survicate.surveys.presentation.base;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointViewAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurveyPointViewAnswer;", "", "answer", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "disclaimerAccepted", "", "<init>", "(Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;Ljava/lang/Boolean;)V", "answers", "", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getAnswers", "()Ljava/util/List;", "getDisclaimerAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPointViewAnswer {
    private final List<SurveyAnswer> answers;
    private final Boolean disclaimerAccepted;

    public final List<SurveyAnswer> getAnswers() {
        return this.answers;
    }

    public final Boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }

    public SurveyPointViewAnswer(SurveyAnswer answer, Boolean bool) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.answers = CollectionsKt.listOf(answer);
        this.disclaimerAccepted = bool;
    }

    public SurveyPointViewAnswer(List<SurveyAnswer> answers, Boolean bool) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        List<SurveyAnswer> list = answers;
        this.answers = list.isEmpty() ? CollectionsKt.listOf(new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null)) : list;
        this.disclaimerAccepted = bool;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.presentation.base.SurveyPointViewAnswer");
        SurveyPointViewAnswer surveyPointViewAnswer = (SurveyPointViewAnswer) other;
        return Intrinsics.areEqual(this.answers, surveyPointViewAnswer.answers) && Intrinsics.areEqual(this.disclaimerAccepted, surveyPointViewAnswer.disclaimerAccepted);
    }

    public int hashCode() {
        int iHashCode = this.answers.hashCode() * 31;
        Boolean bool = this.disclaimerAccepted;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
