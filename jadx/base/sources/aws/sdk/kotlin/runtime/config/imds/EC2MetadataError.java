package aws.sdk.kotlin.runtime.config.imds;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.AwsServiceException;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImdsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/EC2MetadataError;", "Laws/sdk/kotlin/runtime/AwsServiceException;", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "message", "", "<init>", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;Ljava/lang/String;)V", "getStatus", "()Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EC2MetadataError extends AwsServiceException {
    private final HttpStatusCode status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EC2MetadataError(HttpStatusCode status, String message) {
        super(message);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = status;
    }

    public final HttpStatusCode getStatus() {
        return this.status;
    }
}
