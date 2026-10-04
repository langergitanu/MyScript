package aws.smithy.kotlin.runtime.http.operation;

import kotlin.Metadata;

/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/TimeoutScope;", "", "", "getDescription", "()Ljava/lang/String;", "description", "Call", "Attempt", "Laws/smithy/kotlin/runtime/http/operation/TimeoutScope$Attempt;", "Laws/smithy/kotlin/runtime/http/operation/TimeoutScope$Call;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TimeoutScope {
    String getDescription();

    /* JADX INFO: compiled from: Timeouts.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0083\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u00020\tHÖ\u0081\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fHÖ\u0081\u0004¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/TimeoutScope$Call;", "Laws/smithy/kotlin/runtime/http/operation/TimeoutScope;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "description", "Ljava/lang/String;", "getDescription", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Call implements TimeoutScope {
        public static final Call INSTANCE = new Call();
        private static final String description = "Call";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Call)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1468093288;
        }

        public String toString() {
            return "Call";
        }

        private Call() {
        }

        @Override // aws.smithy.kotlin.runtime.http.operation.TimeoutScope
        public String getDescription() {
            return description;
        }
    }

    /* JADX INFO: compiled from: Timeouts.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0007J\u0011\u0010\u0011\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/TimeoutScope$Attempt;", "Laws/smithy/kotlin/runtime/http/operation/TimeoutScope;", "", "attempt", "<init>", "(I)V", "component1", "()I", "copy", "(I)Laws/smithy/kotlin/runtime/http/operation/TimeoutScope$Attempt;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getAttempt", "description", "Ljava/lang/String;", "getDescription", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Attempt implements TimeoutScope {
        private final int attempt;
        private final String description;

        public static /* synthetic */ Attempt copy$default(Attempt attempt, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = attempt.attempt;
            }
            return attempt.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAttempt() {
            return this.attempt;
        }

        public final Attempt copy(int attempt) {
            return new Attempt(attempt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Attempt) && this.attempt == ((Attempt) other).attempt;
        }

        public int hashCode() {
            return Integer.hashCode(this.attempt);
        }

        public String toString() {
            return "Attempt(attempt=" + this.attempt + ')';
        }

        public Attempt(int i) {
            this.attempt = i;
            this.description = "Attempt #" + i;
        }

        public final int getAttempt() {
            return this.attempt;
        }

        @Override // aws.smithy.kotlin.runtime.http.operation.TimeoutScope
        public String getDescription() {
            return this.description;
        }
    }
}
