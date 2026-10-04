package com.myscript.nebo.p022ai.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NeboAIClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError;", "", "<init>", "()V", "NetworkError", "ServerError", "QuotaError", "ContextLimitError", "UnknownError", "Lcom/myscript/nebo/ai/data/AIClientError$ContextLimitError;", "Lcom/myscript/nebo/ai/data/AIClientError$NetworkError;", "Lcom/myscript/nebo/ai/data/AIClientError$QuotaError;", "Lcom/myscript/nebo/ai/data/AIClientError$ServerError;", "Lcom/myscript/nebo/ai/data/AIClientError$UnknownError;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AIClientError {
    public static final int $stable = 0;

    public /* synthetic */ AIClientError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError$NetworkError;", "Lcom/myscript/nebo/ai/data/AIClientError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NetworkError extends AIClientError {
        public static final int $stable = 0;
        public static final NetworkError INSTANCE = new NetworkError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1322045839;
        }

        public String toString() {
            return "NetworkError";
        }

        private NetworkError() {
            super(null);
        }
    }

    private AIClientError() {
    }

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError$ServerError;", "Lcom/myscript/nebo/ai/data/AIClientError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ServerError extends AIClientError {
        public static final int $stable = 0;
        public static final ServerError INSTANCE = new ServerError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1808510894;
        }

        public String toString() {
            return "ServerError";
        }

        private ServerError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError$QuotaError;", "Lcom/myscript/nebo/ai/data/AIClientError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuotaError extends AIClientError {
        public static final int $stable = 0;
        public static final QuotaError INSTANCE = new QuotaError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuotaError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1504606759;
        }

        public String toString() {
            return "QuotaError";
        }

        private QuotaError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError$ContextLimitError;", "Lcom/myscript/nebo/ai/data/AIClientError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ContextLimitError extends AIClientError {
        public static final int $stable = 0;
        public static final ContextLimitError INSTANCE = new ContextLimitError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContextLimitError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1097195141;
        }

        public String toString() {
            return "ContextLimitError";
        }

        private ContextLimitError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClientError$UnknownError;", "Lcom/myscript/nebo/ai/data/AIClientError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class UnknownError extends AIClientError {
        public static final int $stable = 0;
        public static final UnknownError INSTANCE = new UnknownError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1673121237;
        }

        public String toString() {
            return "UnknownError";
        }

        private UnknownError() {
            super(null);
        }
    }
}
