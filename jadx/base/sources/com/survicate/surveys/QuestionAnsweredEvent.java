package com.survicate.surveys;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/QuestionAnsweredEvent;", "", "responseUuid", "", "visitorUuid", "surveyId", "surveyName", "questionId", "", "questionText", "answer", "Lcom/survicate/surveys/SurvicateAnswer;", "panelAnswerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/survicate/surveys/SurvicateAnswer;Ljava/lang/String;)V", "getResponseUuid", "()Ljava/lang/String;", "getVisitorUuid", "getSurveyId", "getSurveyName", "getQuestionId", "()J", "getQuestionText", "getAnswer", "()Lcom/survicate/surveys/SurvicateAnswer;", "getPanelAnswerUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class QuestionAnsweredEvent {
    private final SurvicateAnswer answer;
    private final String panelAnswerUrl;
    private final long questionId;
    private final String questionText;
    private final String responseUuid;
    private final String surveyId;
    private final String surveyName;
    private final String visitorUuid;

    public static /* synthetic */ QuestionAnsweredEvent copy$default(QuestionAnsweredEvent questionAnsweredEvent, String str, String str2, String str3, String str4, long j, String str5, SurvicateAnswer survicateAnswer, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = questionAnsweredEvent.responseUuid;
        }
        if ((i & 2) != 0) {
            str2 = questionAnsweredEvent.visitorUuid;
        }
        if ((i & 4) != 0) {
            str3 = questionAnsweredEvent.surveyId;
        }
        if ((i & 8) != 0) {
            str4 = questionAnsweredEvent.surveyName;
        }
        if ((i & 16) != 0) {
            j = questionAnsweredEvent.questionId;
        }
        if ((i & 32) != 0) {
            str5 = questionAnsweredEvent.questionText;
        }
        if ((i & 64) != 0) {
            survicateAnswer = questionAnsweredEvent.answer;
        }
        if ((i & 128) != 0) {
            str6 = questionAnsweredEvent.panelAnswerUrl;
        }
        String str7 = str6;
        String str8 = str5;
        long j2 = j;
        String str9 = str3;
        String str10 = str4;
        return questionAnsweredEvent.copy(str, str2, str9, str10, j2, str8, survicateAnswer, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResponseUuid() {
        return this.responseUuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVisitorUuid() {
        return this.visitorUuid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSurveyName() {
        return this.surveyName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getQuestionId() {
        return this.questionId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQuestionText() {
        return this.questionText;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SurvicateAnswer getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPanelAnswerUrl() {
        return this.panelAnswerUrl;
    }

    public final QuestionAnsweredEvent copy(String responseUuid, String visitorUuid, String surveyId, String surveyName, long questionId, String questionText, SurvicateAnswer answer, String panelAnswerUrl) {
        Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
        Intrinsics.checkNotNullParameter(visitorUuid, "visitorUuid");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(surveyName, "surveyName");
        Intrinsics.checkNotNullParameter(questionText, "questionText");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(panelAnswerUrl, "panelAnswerUrl");
        return new QuestionAnsweredEvent(responseUuid, visitorUuid, surveyId, surveyName, questionId, questionText, answer, panelAnswerUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionAnsweredEvent)) {
            return false;
        }
        QuestionAnsweredEvent questionAnsweredEvent = (QuestionAnsweredEvent) other;
        return Intrinsics.areEqual(this.responseUuid, questionAnsweredEvent.responseUuid) && Intrinsics.areEqual(this.visitorUuid, questionAnsweredEvent.visitorUuid) && Intrinsics.areEqual(this.surveyId, questionAnsweredEvent.surveyId) && Intrinsics.areEqual(this.surveyName, questionAnsweredEvent.surveyName) && this.questionId == questionAnsweredEvent.questionId && Intrinsics.areEqual(this.questionText, questionAnsweredEvent.questionText) && Intrinsics.areEqual(this.answer, questionAnsweredEvent.answer) && Intrinsics.areEqual(this.panelAnswerUrl, questionAnsweredEvent.panelAnswerUrl);
    }

    public int hashCode() {
        return (((((((((((((this.responseUuid.hashCode() * 31) + this.visitorUuid.hashCode()) * 31) + this.surveyId.hashCode()) * 31) + this.surveyName.hashCode()) * 31) + Long.hashCode(this.questionId)) * 31) + this.questionText.hashCode()) * 31) + this.answer.hashCode()) * 31) + this.panelAnswerUrl.hashCode();
    }

    public String toString() {
        return "QuestionAnsweredEvent(responseUuid=" + this.responseUuid + ", visitorUuid=" + this.visitorUuid + ", surveyId=" + this.surveyId + ", surveyName=" + this.surveyName + ", questionId=" + this.questionId + ", questionText=" + this.questionText + ", answer=" + this.answer + ", panelAnswerUrl=" + this.panelAnswerUrl + ')';
    }

    public QuestionAnsweredEvent(String responseUuid, String visitorUuid, String surveyId, String surveyName, long j, String questionText, SurvicateAnswer answer, String panelAnswerUrl) {
        Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
        Intrinsics.checkNotNullParameter(visitorUuid, "visitorUuid");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(surveyName, "surveyName");
        Intrinsics.checkNotNullParameter(questionText, "questionText");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(panelAnswerUrl, "panelAnswerUrl");
        this.responseUuid = responseUuid;
        this.visitorUuid = visitorUuid;
        this.surveyId = surveyId;
        this.surveyName = surveyName;
        this.questionId = j;
        this.questionText = questionText;
        this.answer = answer;
        this.panelAnswerUrl = panelAnswerUrl;
    }

    public final String getResponseUuid() {
        return this.responseUuid;
    }

    public final String getVisitorUuid() {
        return this.visitorUuid;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final String getSurveyName() {
        return this.surveyName;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final String getQuestionText() {
        return this.questionText;
    }

    public final SurvicateAnswer getAnswer() {
        return this.answer;
    }

    public final String getPanelAnswerUrl() {
        return this.panelAnswerUrl;
    }
}
