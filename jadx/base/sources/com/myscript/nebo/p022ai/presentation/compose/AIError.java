package com.myscript.nebo.p022ai.presentation.compose;

import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011B'\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u0082\u0001\u0005\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError;", "", "errorTitle", "", "errorDescription", "errorImage", "<init>", "(III)V", "getErrorTitle", "()I", "getErrorDescription", "getErrorImage", "QuotaError", "ContextLimit", "NotEnoughText", "ServerError", "NetworkError", "Companion", "Lcom/myscript/nebo/ai/presentation/compose/AIError$ContextLimit;", "Lcom/myscript/nebo/ai/presentation/compose/AIError$NetworkError;", "Lcom/myscript/nebo/ai/presentation/compose/AIError$NotEnoughText;", "Lcom/myscript/nebo/ai/presentation/compose/AIError$QuotaError;", "Lcom/myscript/nebo/ai/presentation/compose/AIError$ServerError;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AIError {
    public static final int $stable = 0;
    private static final int NO_DRAWABLE = 0;
    private final int errorDescription;
    private final int errorImage;
    private final int errorTitle;

    public /* synthetic */ AIError(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    private AIError(int i, int i2, int i3) {
        this.errorTitle = i;
        this.errorDescription = i2;
        this.errorImage = i3;
    }

    public /* synthetic */ AIError(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3, null);
    }

    public final int getErrorTitle() {
        return this.errorTitle;
    }

    public final int getErrorDescription() {
        return this.errorDescription;
    }

    public final int getErrorImage() {
        return this.errorImage;
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError$QuotaError;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QuotaError extends AIError {
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
            return 1483213096;
        }

        public String toString() {
            return "QuotaError";
        }

        private QuotaError() {
            super(C6091R.string.ai_quota_exceeded_title, C6091R.string.ai_quota_exceeded_description, 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError$ContextLimit;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ContextLimit extends AIError {
        public static final int $stable = 0;
        public static final ContextLimit INSTANCE = new ContextLimit();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContextLimit)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 736077828;
        }

        public String toString() {
            return "ContextLimit";
        }

        private ContextLimit() {
            super(C6091R.string.ai_context_limit_title, C6091R.string.ai_context_limit_description, 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError$NotEnoughText;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NotEnoughText extends AIError {
        public static final int $stable = 0;
        public static final NotEnoughText INSTANCE = new NotEnoughText();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotEnoughText)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 636743736;
        }

        public String toString() {
            return "NotEnoughText";
        }

        private NotEnoughText() {
            super(C6091R.string.ai_not_enough_text_title, C6091R.string.ai_not_enough_text_description, 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError$ServerError;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ServerError extends AIError {
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
            return 1145307341;
        }

        public String toString() {
            return "ServerError";
        }

        private ServerError() {
            super(C6091R.string.ai_server_error_title, C6091R.string.ai_server_error_description, 0, 4, null);
        }
    }

    /* JADX INFO: compiled from: AIContainerViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIError$NetworkError;", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NetworkError extends AIError {
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
            return -406519502;
        }

        public String toString() {
            return "NetworkError";
        }

        private NetworkError() {
            super(C6091R.string.ai_no_network_title, C6091R.string.ai_no_network_description, 0, 4, null);
        }
    }
}
