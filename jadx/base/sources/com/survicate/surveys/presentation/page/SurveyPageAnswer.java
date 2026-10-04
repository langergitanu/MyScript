package com.survicate.surveys.presentation.page;

import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageAnswer;", "", "pointAnswers", "", "Lcom/survicate/surveys/presentation/page/SurveyPageAnswer$PointAnswer;", "disclaimerAccepted", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getPointAnswers", "()Ljava/util/List;", "getDisclaimerAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/survicate/surveys/presentation/page/SurveyPageAnswer;", "equals", "other", "hashCode", "", "toString", "", "PointAnswer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPageAnswer {
    private final Boolean disclaimerAccepted;
    private final List<PointAnswer> pointAnswers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPageAnswer copy$default(SurveyPageAnswer surveyPageAnswer, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = surveyPageAnswer.pointAnswers;
        }
        if ((i & 2) != 0) {
            bool = surveyPageAnswer.disclaimerAccepted;
        }
        return surveyPageAnswer.copy(list, bool);
    }

    public final List<PointAnswer> component1() {
        return this.pointAnswers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }

    public final SurveyPageAnswer copy(List<PointAnswer> pointAnswers, Boolean disclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointAnswers, "pointAnswers");
        return new SurveyPageAnswer(pointAnswers, disclaimerAccepted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPageAnswer)) {
            return false;
        }
        SurveyPageAnswer surveyPageAnswer = (SurveyPageAnswer) other;
        return Intrinsics.areEqual(this.pointAnswers, surveyPageAnswer.pointAnswers) && Intrinsics.areEqual(this.disclaimerAccepted, surveyPageAnswer.disclaimerAccepted);
    }

    public int hashCode() {
        int iHashCode = this.pointAnswers.hashCode() * 31;
        Boolean bool = this.disclaimerAccepted;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "SurveyPageAnswer(pointAnswers=" + this.pointAnswers + ", disclaimerAccepted=" + this.disclaimerAccepted + ')';
    }

    public SurveyPageAnswer(List<PointAnswer> pointAnswers, Boolean bool) {
        Intrinsics.checkNotNullParameter(pointAnswers, "pointAnswers");
        this.pointAnswers = pointAnswers;
        this.disclaimerAccepted = bool;
    }

    public final List<PointAnswer> getPointAnswers() {
        return this.pointAnswers;
    }

    public final Boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }

    /* JADX INFO: compiled from: SurveyPageAnswer.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageAnswer$PointAnswer;", "", "pointId", "", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "<init>", "(JLjava/util/List;)V", "getPointId", "()J", "getAnswers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class PointAnswer {
        private final List<SurveyAnswer> answers;
        private final long pointId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PointAnswer copy$default(PointAnswer pointAnswer, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = pointAnswer.pointId;
            }
            if ((i & 2) != 0) {
                list = pointAnswer.answers;
            }
            return pointAnswer.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPointId() {
            return this.pointId;
        }

        public final List<SurveyAnswer> component2() {
            return this.answers;
        }

        public final PointAnswer copy(long pointId, List<SurveyAnswer> answers) {
            Intrinsics.checkNotNullParameter(answers, "answers");
            return new PointAnswer(pointId, answers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PointAnswer)) {
                return false;
            }
            PointAnswer pointAnswer = (PointAnswer) other;
            return this.pointId == pointAnswer.pointId && Intrinsics.areEqual(this.answers, pointAnswer.answers);
        }

        public int hashCode() {
            return (Long.hashCode(this.pointId) * 31) + this.answers.hashCode();
        }

        public String toString() {
            return "PointAnswer(pointId=" + this.pointId + ", answers=" + this.answers + ')';
        }

        public PointAnswer(long j, List<SurveyAnswer> answers) {
            Intrinsics.checkNotNullParameter(answers, "answers");
            this.pointId = j;
            this.answers = answers;
        }

        public final long getPointId() {
            return this.pointId;
        }

        public final List<SurveyAnswer> getAnswers() {
            return this.answers;
        }
    }
}
