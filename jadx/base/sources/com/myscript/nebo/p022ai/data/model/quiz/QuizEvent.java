package com.myscript.nebo.p022ai.data.model.quiz;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "", "<init>", "()V", "Info", "Question", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent$Info;", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent$Question;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class QuizEvent {
    public static final int $stable = 0;

    public /* synthetic */ QuizEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: QuizEvent.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent$Info;", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "info", "Lcom/myscript/nebo/ai/data/model/quiz/QuizInfo;", "<init>", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizInfo;)V", "getInfo", "()Lcom/myscript/nebo/ai/data/model/quiz/QuizInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Info extends QuizEvent {
        public static final int $stable = 0;
        private final QuizInfo info;

        public static /* synthetic */ Info copy$default(Info info, QuizInfo quizInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                quizInfo = info.info;
            }
            return info.copy(quizInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final QuizInfo getInfo() {
            return this.info;
        }

        public final Info copy(QuizInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return new Info(info);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Info) && Intrinsics.areEqual(this.info, ((Info) other).info);
        }

        public int hashCode() {
            return this.info.hashCode();
        }

        public String toString() {
            return "Info(info=" + this.info + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Info(QuizInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        public final QuizInfo getInfo() {
            return this.info;
        }
    }

    private QuizEvent() {
    }

    /* JADX INFO: compiled from: QuizEvent.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent$Question;", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "question", "Lcom/myscript/nebo/ai/data/model/quiz/QuizResponse;", "<init>", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizResponse;)V", "getQuestion", "()Lcom/myscript/nebo/ai/data/model/quiz/QuizResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Question extends QuizEvent {
        public static final int $stable = 8;
        private final QuizResponse question;

        public static /* synthetic */ Question copy$default(Question question, QuizResponse quizResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                quizResponse = question.question;
            }
            return question.copy(quizResponse);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final QuizResponse getQuestion() {
            return this.question;
        }

        public final Question copy(QuizResponse question) {
            Intrinsics.checkNotNullParameter(question, "question");
            return new Question(question);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Question) && Intrinsics.areEqual(this.question, ((Question) other).question);
        }

        public int hashCode() {
            return this.question.hashCode();
        }

        public String toString() {
            return "Question(question=" + this.question + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Question(QuizResponse question) {
            super(null);
            Intrinsics.checkNotNullParameter(question, "question");
            this.question = question;
        }

        public final QuizResponse getQuestion() {
            return this.question;
        }
    }
}
