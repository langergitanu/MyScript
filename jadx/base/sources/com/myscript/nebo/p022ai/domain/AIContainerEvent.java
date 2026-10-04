package com.myscript.nebo.p022ai.domain;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIContainerEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001e\bf\u0018\u00002\u00020\u0001:\u001d\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "", "SummarizeClick", "ExplainClick", "QuizClick", "UpdateAvailableActions", "ExplainClose", "SummarizeCurrentPage", "SummarizeAllPages", "SummarizeSelectPages", "ShortenResult", "SummarizeClose", "QuizCurrentPage", "QuizAllPages", "QuizSelectPages", "QuizDisclaimerAccepted", "QuizDisclaimerDismissed", "CloseQuiz", "TrueOrFalseClick", "MultipleChoiceClick", "AnswerQuestionClick", "NextQuestionClick", "QuizTryAgainClick", "HideNoteClick", "NextQuestionsClick", "CloseResultCard", "TryAgainClick", "CopyResult", "AddToNote", "AIButtonPositionChanged", "FabClickHook", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AIContainerEvent {

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$SummarizeClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SummarizeClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final SummarizeClick INSTANCE = new SummarizeClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummarizeClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2152528;
        }

        public String toString() {
            return "SummarizeClick";
        }

        private SummarizeClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$ExplainClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ExplainClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final ExplainClick INSTANCE = new ExplainClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExplainClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1324946426;
        }

        public String toString() {
            return "ExplainClick";
        }

        private ExplainClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizClick INSTANCE = new QuizClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 8329130;
        }

        public String toString() {
            return "QuizClick";
        }

        private QuizClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$UpdateAvailableActions;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class UpdateAvailableActions implements AIContainerEvent {
        public static final int $stable = 0;
        public static final UpdateAvailableActions INSTANCE = new UpdateAvailableActions();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateAvailableActions)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -590217530;
        }

        public String toString() {
            return "UpdateAvailableActions";
        }

        private UpdateAvailableActions() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$ExplainClose;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ExplainClose implements AIContainerEvent {
        public static final int $stable = 0;
        public static final ExplainClose INSTANCE = new ExplainClose();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExplainClose)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1324952682;
        }

        public String toString() {
            return "ExplainClose";
        }

        private ExplainClose() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$SummarizeCurrentPage;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SummarizeCurrentPage implements AIContainerEvent {
        public static final int $stable = 0;
        public static final SummarizeCurrentPage INSTANCE = new SummarizeCurrentPage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummarizeCurrentPage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 905270224;
        }

        public String toString() {
            return "SummarizeCurrentPage";
        }

        private SummarizeCurrentPage() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$SummarizeAllPages;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SummarizeAllPages implements AIContainerEvent {
        public static final int $stable = 0;
        public static final SummarizeAllPages INSTANCE = new SummarizeAllPages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummarizeAllPages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1176039291;
        }

        public String toString() {
            return "SummarizeAllPages";
        }

        private SummarizeAllPages() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$SummarizeSelectPages;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SummarizeSelectPages implements AIContainerEvent {
        public static final int $stable = 0;
        public static final SummarizeSelectPages INSTANCE = new SummarizeSelectPages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummarizeSelectPages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 505195600;
        }

        public String toString() {
            return "SummarizeSelectPages";
        }

        private SummarizeSelectPages() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$ShortenResult;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ShortenResult implements AIContainerEvent {
        public static final int $stable = 0;
        public static final ShortenResult INSTANCE = new ShortenResult();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShortenResult)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1076376935;
        }

        public String toString() {
            return "ShortenResult";
        }

        private ShortenResult() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$SummarizeClose;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SummarizeClose implements AIContainerEvent {
        public static final int $stable = 0;
        public static final SummarizeClose INSTANCE = new SummarizeClose();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummarizeClose)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2146272;
        }

        public String toString() {
            return "SummarizeClose";
        }

        private SummarizeClose() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizCurrentPage;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizCurrentPage implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizCurrentPage INSTANCE = new QuizCurrentPage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizCurrentPage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1652826038;
        }

        public String toString() {
            return "QuizCurrentPage";
        }

        private QuizCurrentPage() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizAllPages;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizAllPages implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizAllPages INSTANCE = new QuizAllPages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizAllPages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -97499839;
        }

        public String toString() {
            return "QuizAllPages";
        }

        private QuizAllPages() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizSelectPages;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizSelectPages implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizSelectPages INSTANCE = new QuizSelectPages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizSelectPages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2052900662;
        }

        public String toString() {
            return "QuizSelectPages";
        }

        private QuizSelectPages() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizDisclaimerAccepted;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizDisclaimerAccepted implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizDisclaimerAccepted INSTANCE = new QuizDisclaimerAccepted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizDisclaimerAccepted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1286169472;
        }

        public String toString() {
            return "QuizDisclaimerAccepted";
        }

        private QuizDisclaimerAccepted() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizDisclaimerDismissed;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizDisclaimerDismissed implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizDisclaimerDismissed INSTANCE = new QuizDisclaimerDismissed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizDisclaimerDismissed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -801178640;
        }

        public String toString() {
            return "QuizDisclaimerDismissed";
        }

        private QuizDisclaimerDismissed() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$CloseQuiz;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CloseQuiz implements AIContainerEvent {
        public static final int $stable = 0;
        public static final CloseQuiz INSTANCE = new CloseQuiz();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseQuiz)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1897721828;
        }

        public String toString() {
            return "CloseQuiz";
        }

        private CloseQuiz() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$TrueOrFalseClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class TrueOrFalseClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final TrueOrFalseClick INSTANCE = new TrueOrFalseClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrueOrFalseClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1017171391;
        }

        public String toString() {
            return "TrueOrFalseClick";
        }

        private TrueOrFalseClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$MultipleChoiceClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class MultipleChoiceClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final MultipleChoiceClick INSTANCE = new MultipleChoiceClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultipleChoiceClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1223817966;
        }

        public String toString() {
            return "MultipleChoiceClick";
        }

        private MultipleChoiceClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$AnswerQuestionClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "answer", "", "<init>", "(Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AnswerQuestionClick implements AIContainerEvent {
        public static final int $stable = 0;
        private final String answer;

        public static /* synthetic */ AnswerQuestionClick copy$default(AnswerQuestionClick answerQuestionClick, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answerQuestionClick.answer;
            }
            return answerQuestionClick.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnswer() {
            return this.answer;
        }

        public final AnswerQuestionClick copy(String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            return new AnswerQuestionClick(answer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnswerQuestionClick) && Intrinsics.areEqual(this.answer, ((AnswerQuestionClick) other).answer);
        }

        public int hashCode() {
            return this.answer.hashCode();
        }

        public String toString() {
            return "AnswerQuestionClick(answer=" + this.answer + ")";
        }

        public AnswerQuestionClick(String answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            this.answer = answer;
        }

        public final String getAnswer() {
            return this.answer;
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$NextQuestionClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NextQuestionClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final NextQuestionClick INSTANCE = new NextQuestionClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NextQuestionClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1561538950;
        }

        public String toString() {
            return "NextQuestionClick";
        }

        private NextQuestionClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$QuizTryAgainClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuizTryAgainClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final QuizTryAgainClick INSTANCE = new QuizTryAgainClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuizTryAgainClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 194494021;
        }

        public String toString() {
            return "QuizTryAgainClick";
        }

        private QuizTryAgainClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$HideNoteClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class HideNoteClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final HideNoteClick INSTANCE = new HideNoteClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HideNoteClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 585891211;
        }

        public String toString() {
            return "HideNoteClick";
        }

        private HideNoteClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$NextQuestionsClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NextQuestionsClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final NextQuestionsClick INSTANCE = new NextQuestionsClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NextQuestionsClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1795470217;
        }

        public String toString() {
            return "NextQuestionsClick";
        }

        private NextQuestionsClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$CloseResultCard;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CloseResultCard implements AIContainerEvent {
        public static final int $stable = 0;
        public static final CloseResultCard INSTANCE = new CloseResultCard();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseResultCard)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1349023972;
        }

        public String toString() {
            return "CloseResultCard";
        }

        private CloseResultCard() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$TryAgainClick;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class TryAgainClick implements AIContainerEvent {
        public static final int $stable = 0;
        public static final TryAgainClick INSTANCE = new TryAgainClick();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TryAgainClick)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 143872538;
        }

        public String toString() {
            return "TryAgainClick";
        }

        private TryAgainClick() {
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$CopyResult;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CopyResult implements AIContainerEvent {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ CopyResult copy$default(CopyResult copyResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = copyResult.text;
            }
            return copyResult.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final CopyResult copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new CopyResult(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CopyResult) && Intrinsics.areEqual(this.text, ((CopyResult) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "CopyResult(text=" + this.text + ")";
        }

        public CopyResult(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$AddToNote;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AddToNote implements AIContainerEvent {
        public static final int $stable = 0;
        private final String text;

        public static /* synthetic */ AddToNote copy$default(AddToNote addToNote, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = addToNote.text;
            }
            return addToNote.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final AddToNote copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new AddToNote(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AddToNote) && Intrinsics.areEqual(this.text, ((AddToNote) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "AddToNote(text=" + this.text + ")";
        }

        public AddToNote(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$AIButtonPositionChanged;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "targetRect", "Landroid/graphics/Rect;", "<init>", "(Landroid/graphics/Rect;)V", "getTargetRect", "()Landroid/graphics/Rect;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AIButtonPositionChanged implements AIContainerEvent {
        public static final int $stable = 8;
        private final Rect targetRect;

        public static /* synthetic */ AIButtonPositionChanged copy$default(AIButtonPositionChanged aIButtonPositionChanged, Rect rect, int i, Object obj) {
            if ((i & 1) != 0) {
                rect = aIButtonPositionChanged.targetRect;
            }
            return aIButtonPositionChanged.copy(rect);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Rect getTargetRect() {
            return this.targetRect;
        }

        public final AIButtonPositionChanged copy(Rect targetRect) {
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            return new AIButtonPositionChanged(targetRect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AIButtonPositionChanged) && Intrinsics.areEqual(this.targetRect, ((AIButtonPositionChanged) other).targetRect);
        }

        public int hashCode() {
            return this.targetRect.hashCode();
        }

        public String toString() {
            return "AIButtonPositionChanged(targetRect=" + this.targetRect + ")";
        }

        public AIButtonPositionChanged(Rect targetRect) {
            Intrinsics.checkNotNullParameter(targetRect, "targetRect");
            this.targetRect = targetRect;
        }

        public final Rect getTargetRect() {
            return this.targetRect;
        }
    }

    /* JADX INFO: compiled from: AIContainerEvent.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/domain/AIContainerEvent$FabClickHook;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class FabClickHook implements AIContainerEvent {
        public static final int $stable = 0;
        public static final FabClickHook INSTANCE = new FabClickHook();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FabClickHook)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1093646509;
        }

        public String toString() {
            return "FabClickHook";
        }

        private FabClickHook() {
        }
    }
}
