package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.ErrorMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/ClientTimeoutException;", "Laws/smithy/kotlin/runtime/ClientException;", "", "message", "", "cause", "", "retryable", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Z)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ClientTimeoutException extends ClientException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientTimeoutException(String message, Throwable cause, boolean z) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        getSdkErrorMetadata().getAttributes().set(ErrorMetadata.INSTANCE.getRetryable(), Boolean.valueOf(z));
    }
}
