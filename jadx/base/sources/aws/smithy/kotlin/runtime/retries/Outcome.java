package aws.smithy.kotlin.runtime.retries;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Outcome.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u000b\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/Outcome;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "getAttempts", "()I", "attempts", "Response", "Exception", "Laws/smithy/kotlin/runtime/retries/Outcome$Exception;", "Laws/smithy/kotlin/runtime/retries/Outcome$Response;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Outcome<T> {
    public /* synthetic */ Outcome(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getAttempts();

    private Outcome() {
    }

    /* JADX INFO: compiled from: Outcome.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\tJ\u0011\u0010\u0015\u001a\u00020\u0014HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/Outcome$Response;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/retries/Outcome;", "", "attempts", "response", "<init>", "(ILjava/lang/Object;)V", "component1", "()I", "component2", "()Ljava/lang/Object;", "copy", "(ILjava/lang/Object;)Laws/smithy/kotlin/runtime/retries/Outcome$Response;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getAttempts", "Ljava/lang/Object;", "getResponse", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Response<T> extends Outcome<T> {
        private final int attempts;
        private final T response;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, int i, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                i = response.attempts;
            }
            if ((i2 & 2) != 0) {
                obj = response.response;
            }
            return response.copy(i, obj);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAttempts() {
            return this.attempts;
        }

        public final T component2() {
            return this.response;
        }

        public final Response<T> copy(int attempts, T response) {
            return new Response<>(attempts, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.attempts == response.attempts && Intrinsics.areEqual(this.response, response.response);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.attempts) * 31;
            T t = this.response;
            return iHashCode + (t == null ? 0 : t.hashCode());
        }

        public String toString() {
            return "Response(attempts=" + this.attempts + ", response=" + this.response + ')';
        }

        public Response(int i, T t) {
            super(null);
            this.attempts = i;
            this.response = t;
        }

        @Override // aws.smithy.kotlin.runtime.retries.Outcome
        public int getAttempts() {
            return this.attempts;
        }

        public final T getResponse() {
            return this.response;
        }
    }

    /* JADX INFO: compiled from: Outcome.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\nJ\u0011\u0010\u0016\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\f¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/Outcome$Exception;", "Laws/smithy/kotlin/runtime/retries/Outcome;", "", "", "attempts", "", "exception", "<init>", "(ILjava/lang/Throwable;)V", "component1", "()I", "component2", "()Ljava/lang/Throwable;", "copy", "(ILjava/lang/Throwable;)Laws/smithy/kotlin/runtime/retries/Outcome$Exception;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getAttempts", "Ljava/lang/Throwable;", "getException", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Exception extends Outcome {
        private final int attempts;
        private final Throwable exception;

        public static /* synthetic */ Exception copy$default(Exception exception, int i, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = exception.attempts;
            }
            if ((i2 & 2) != 0) {
                th = exception.exception;
            }
            return exception.copy(i, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAttempts() {
            return this.attempts;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        public final Exception copy(int attempts, Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Exception(attempts, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Exception)) {
                return false;
            }
            Exception exception = (Exception) other;
            return this.attempts == exception.attempts && Intrinsics.areEqual(this.exception, exception.exception);
        }

        public int hashCode() {
            return (Integer.hashCode(this.attempts) * 31) + this.exception.hashCode();
        }

        public String toString() {
            return "Exception(attempts=" + this.attempts + ", exception=" + this.exception + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Exception(int i, Throwable exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.attempts = i;
            this.exception = exception;
        }

        @Override // aws.smithy.kotlin.runtime.retries.Outcome
        public int getAttempts() {
            return this.attempts;
        }

        public final Throwable getException() {
            return this.exception;
        }
    }
}
