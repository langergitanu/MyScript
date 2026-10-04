package aws.smithy.kotlin.runtime.awsprotocol;

import kotlin.Metadata;

/* JADX INFO: compiled from: ProtocolErrors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/AwsErrorDetails;", "", "", "getCode", "()Ljava/lang/String;", "code", "getMessage", "message", "getRequestId", "requestId", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AwsErrorDetails {
    String getCode();

    String getMessage();

    String getRequestId();
}
