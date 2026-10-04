package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model;

import aws.sdk.kotlin.runtime.AwsServiceException;
import kotlin.Metadata;

/* JADX INFO: compiled from: SsoException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/model/SsoException;", "Laws/sdk/kotlin/runtime/AwsServiceException;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class SsoException extends AwsServiceException {
    public SsoException() {
    }

    public SsoException(String str) {
        super(str);
    }

    public SsoException(String str, Throwable th) {
        super(str, th);
    }

    public SsoException(Throwable th) {
        super(th);
    }
}
