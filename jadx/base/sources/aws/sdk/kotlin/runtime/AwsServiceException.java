package aws.sdk.kotlin.runtime;

import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/AwsServiceException;", "Laws/smithy/kotlin/runtime/ServiceException;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "sdkErrorMetadata", "Laws/sdk/kotlin/runtime/AwsErrorMetadata;", "getSdkErrorMetadata", "()Laws/sdk/kotlin/runtime/AwsErrorMetadata;", "aws-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class AwsServiceException extends ServiceException {
    private final AwsErrorMetadata sdkErrorMetadata;

    public AwsServiceException() {
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    public AwsServiceException(String str) {
        super(str);
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    public AwsServiceException(String str, Throwable th) {
        super(str, th);
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    public AwsServiceException(Throwable th) {
        super(th);
        this.sdkErrorMetadata = new AwsErrorMetadata();
    }

    @Override // aws.smithy.kotlin.runtime.ServiceException, aws.smithy.kotlin.runtime.SdkBaseException
    public AwsErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }
}
