package aws.smithy.kotlin.runtime.awsprotocol;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import com.revenuecat.purchases.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResponseUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001d\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "", "payload", "withPayload", "(Laws/smithy/kotlin/runtime/http/response/HttpResponse;[B)Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "expected", "", "matches", "(Laws/smithy/kotlin/runtime/http/HttpStatusCode;Laws/smithy/kotlin/runtime/http/HttpStatusCode;)Z", "", "code", "sanitizeErrorType", "(Ljava/lang/String;)Ljava/lang/String;", "X_AMZN_REQUEST_ID_HEADER", "Ljava/lang/String;", "aws-protocol-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResponseUtilsKt {
    public static final String X_AMZN_REQUEST_ID_HEADER = "x-amz-request-id";

    @InternalApi
    public static final HttpResponse withPayload(HttpResponse httpResponse, byte[] bArr) {
        HttpBody.Empty emptyFromBytes;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        if (bArr == null || (emptyFromBytes = HttpBody.INSTANCE.fromBytes(bArr)) == null) {
            emptyFromBytes = HttpBody.Empty.INSTANCE;
        }
        return HttpResponseKt.HttpResponse(httpResponse.getStatus(), httpResponse.getHeaders(), emptyFromBytes);
    }

    @InternalApi
    public static final boolean matches(HttpStatusCode httpStatusCode, HttpStatusCode httpStatusCode2) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<this>");
        if (Intrinsics.areEqual(httpStatusCode2, httpStatusCode)) {
            return true;
        }
        if (httpStatusCode2 == null && HttpStatusCodeKt.isSuccess(httpStatusCode)) {
            return true;
        }
        return (httpStatusCode2 != null ? HttpStatusCodeKt.category(httpStatusCode2) : null) == HttpStatusCodeKt.category(httpStatusCode);
    }

    @InternalApi
    public static final String sanitizeErrorType(String str) {
        String strSubstringAfter$default;
        if (str == null || (strSubstringAfter$default = StringsKt.substringAfter$default(str, Literals.COMMENT_1, (String) null, 2, (Object) null)) == null) {
            return null;
        }
        return StringsKt.substringBefore$default(strSubstringAfter$default, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
    }
}
