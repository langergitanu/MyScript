package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmokeTestsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/SmokeTestsFailureException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "<init>", "(Ljava/lang/String;)V", "()V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SmokeTestsFailureException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmokeTestsFailureException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public SmokeTestsFailureException() {
        this("Smoke test failed with HTTP status code in the inclusive range: 400-599");
    }
}
