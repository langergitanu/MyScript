package aws.sdk.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.CharRange;

/* JADX INFO: compiled from: RecursionDetection.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"ENV_FUNCTION_NAME", "", "ENV_TRACE_ID", "HEADER_TRACE_ID", "encoding", "Laws/smithy/kotlin/runtime/text/encoding/PercentEncoding;", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RecursionDetectionKt {
    public static final String ENV_FUNCTION_NAME = "AWS_LAMBDA_FUNCTION_NAME";
    public static final String ENV_TRACE_ID = "_X_AMZN_TRACE_ID";
    public static final String HEADER_TRACE_ID = "X-Amzn-Trace-Id";
    private static final PercentEncoding encoding = new PercentEncoding("trace header", CollectionsKt.toSet(new CharRange((char) 32, (char) 127)), null, 4, null);
}
