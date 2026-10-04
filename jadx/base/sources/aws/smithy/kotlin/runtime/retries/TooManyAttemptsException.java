package aws.smithy.kotlin.runtime.retries;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/TooManyAttemptsException;", "Laws/smithy/kotlin/runtime/retries/RetryException;", "", "message", "", "cause", "", "attempts", "", "lastResponse", "lastException", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;Ljava/lang/Throwable;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooManyAttemptsException extends RetryException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooManyAttemptsException(String message, Throwable th, int i, Object obj, Throwable th2) {
        super(message, th, i, obj, th2, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
