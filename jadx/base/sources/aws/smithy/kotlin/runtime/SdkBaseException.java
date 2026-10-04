package aws.smithy.kotlin.runtime;

import kotlin.Metadata;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\nB\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/SdkBaseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "", "message", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "Laws/smithy/kotlin/runtime/ErrorMetadata;", "sdkErrorMetadata", "Laws/smithy/kotlin/runtime/ErrorMetadata;", "getSdkErrorMetadata", "()Laws/smithy/kotlin/runtime/ErrorMetadata;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class SdkBaseException extends RuntimeException {
    private final ErrorMetadata sdkErrorMetadata;

    public SdkBaseException() {
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public SdkBaseException(String str) {
        super(str);
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public SdkBaseException(String str, Throwable th) {
        super(str, th);
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public SdkBaseException(Throwable th) {
        super(th);
        this.sdkErrorMetadata = new ErrorMetadata();
    }

    public ErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }
}
