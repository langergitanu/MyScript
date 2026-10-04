package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.runtime.AwsServiceException;
import kotlin.Metadata;

/* JADX INFO: compiled from: S3Exception.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3Exception;", "Laws/sdk/kotlin/runtime/AwsServiceException;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "sdkErrorMetadata", "Laws/sdk/kotlin/services/s3/model/S3ErrorMetadata;", "getSdkErrorMetadata", "()Laws/sdk/kotlin/services/s3/model/S3ErrorMetadata;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class S3Exception extends AwsServiceException {
    private final S3ErrorMetadata sdkErrorMetadata;

    public S3Exception() {
        this.sdkErrorMetadata = new S3ErrorMetadata();
    }

    public S3Exception(String str) {
        super(str);
        this.sdkErrorMetadata = new S3ErrorMetadata();
    }

    public S3Exception(String str, Throwable th) {
        super(str, th);
        this.sdkErrorMetadata = new S3ErrorMetadata();
    }

    public S3Exception(Throwable th) {
        super(th);
        this.sdkErrorMetadata = new S3ErrorMetadata();
    }

    @Override // aws.sdk.kotlin.runtime.AwsServiceException, aws.smithy.kotlin.runtime.ServiceException, aws.smithy.kotlin.runtime.SdkBaseException
    public S3ErrorMetadata getSdkErrorMetadata() {
        return this.sdkErrorMetadata;
    }
}
