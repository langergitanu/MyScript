package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.ClientException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/RetryCapacityExceededException;", "Laws/smithy/kotlin/runtime/ClientException;", "", "message", "<init>", "(Ljava/lang/String;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetryCapacityExceededException extends ClientException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryCapacityExceededException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
