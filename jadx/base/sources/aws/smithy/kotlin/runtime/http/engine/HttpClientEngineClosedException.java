package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.ClientException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineClosedException;", "Laws/smithy/kotlin/runtime/ClientException;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpClientEngineClosedException extends ClientException {
    private final Throwable cause;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpClientEngineClosedException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpClientEngineClosedException(Throwable th) {
        super("HttpClientEngine already closed");
        this.cause = th;
    }

    public /* synthetic */ HttpClientEngineClosedException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
