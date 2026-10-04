package aws.smithy.kotlin.runtime.retries.policy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryDirective.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "", "<init>", "()V", "TerminateAndSucceed", "TerminateAndFail", "RetryError", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$RetryError;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$TerminateAndFail;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$TerminateAndSucceed;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class RetryDirective {
    public /* synthetic */ RetryDirective(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RetryDirective() {
    }

    /* JADX INFO: compiled from: RetryDirective.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$TerminateAndSucceed;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "<init>", "()V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class TerminateAndSucceed extends RetryDirective {
        public static final TerminateAndSucceed INSTANCE = new TerminateAndSucceed();

        private TerminateAndSucceed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: RetryDirective.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$TerminateAndFail;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "<init>", "()V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class TerminateAndFail extends RetryDirective {
        public static final TerminateAndFail INSTANCE = new TerminateAndFail();

        private TerminateAndFail() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: RetryDirective.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$RetryError;", "Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "reason", "<init>", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;)V", "component1", "()Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "copy", "(Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective$RetryError;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/retries/policy/RetryErrorType;", "getReason", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class RetryError extends RetryDirective {
        private final RetryErrorType reason;

        public static /* synthetic */ RetryError copy$default(RetryError retryError, RetryErrorType retryErrorType, int i, Object obj) {
            if ((i & 1) != 0) {
                retryErrorType = retryError.reason;
            }
            return retryError.copy(retryErrorType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RetryErrorType getReason() {
            return this.reason;
        }

        public final RetryError copy(RetryErrorType reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new RetryError(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RetryError) && this.reason == ((RetryError) other).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "RetryError(reason=" + this.reason + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RetryError(RetryErrorType reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final RetryErrorType getReason() {
            return this.reason;
        }
    }
}
