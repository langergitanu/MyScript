package aws.smithy.kotlin.runtime.retries;

import aws.smithy.kotlin.runtime.ClientException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B7\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/RetryException;", "Laws/smithy/kotlin/runtime/ClientException;", "", "message", "", "cause", "", "attempts", "", "lastResponse", "lastException", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;Ljava/lang/Throwable;)V", "toString", "()Ljava/lang/String;", "I", "getAttempts", "()I", "Ljava/lang/Object;", "getLastResponse", "()Ljava/lang/Object;", "Ljava/lang/Throwable;", "getLastException", "()Ljava/lang/Throwable;", "Laws/smithy/kotlin/runtime/retries/RetryFailureException;", "Laws/smithy/kotlin/runtime/retries/TimedOutException;", "Laws/smithy/kotlin/runtime/retries/TooManyAttemptsException;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class RetryException extends ClientException {
    private final int attempts;
    private final Throwable lastException;
    private final Object lastResponse;

    public /* synthetic */ RetryException(String str, Throwable th, int i, Object obj, Throwable th2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th, i, obj, th2);
    }

    private RetryException(String str, Throwable th, int i, Object obj, Throwable th2) {
        super(str, th);
        this.attempts = i;
        this.lastResponse = obj;
        this.lastException = th2;
    }

    public final int getAttempts() {
        return this.attempts;
    }

    public final Object getLastResponse() {
        return this.lastResponse;
    }

    public final Throwable getLastException() {
        return this.lastException;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName());
        sb.append("(message=");
        sb.append(getMessage());
        sb.append(",attempts=");
        sb.append(this.attempts);
        if (this.lastException != null) {
            sb.append(",lastException=");
            sb.append(this.lastException);
        } else if (this.lastResponse != null) {
            sb.append(",lastResponse=");
            sb.append(this.lastResponse);
        }
        sb.append(")");
        return sb.toString();
    }
}
