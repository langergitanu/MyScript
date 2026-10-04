package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.p011io.EOFException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseLengthValidationInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody;", "", "expectedContentLength", "toLengthValidatingBody", "(Laws/smithy/kotlin/runtime/http/HttpBody;J)Laws/smithy/kotlin/runtime/http/HttpBody;", "expected", "actual", "", "validateContentLength", "(JLjava/lang/Long;)V", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResponseLengthValidationInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    @InternalApi
    public static final HttpBody toLengthValidatingBody(HttpBody httpBody, long j) throws EOFException {
        if (httpBody instanceof HttpBody.SourceContent) {
            return HttpBodyKt.toHttpBody(new LengthValidatingSource(((HttpBody.SourceContent) httpBody).get$this_toHttpBody(), j), httpBody.getContentLength());
        }
        if (httpBody instanceof HttpBody.ChannelContent) {
            return HttpBodyKt.toHttpBody(new LengthValidatingByteReadChannel(((HttpBody.ChannelContent) httpBody).get$ch(), j), httpBody.getContentLength());
        }
        if (httpBody instanceof HttpBody.Bytes) {
            validateContentLength(j, httpBody.getContentLength());
            return httpBody;
        }
        if (!Intrinsics.areEqual(httpBody, HttpBody.Empty.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        validateContentLength(j, 0L);
        return httpBody;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateContentLength(long j, Long l) throws EOFException {
        if (l != null && j == l.longValue()) {
            return;
        }
        if (l != null && j > l.longValue()) {
            throw new EOFException("Expected " + j + " bytes but received " + l.longValue() + " bytes. The connection may have been closed prematurely.");
        }
        throw new EOFException("Expected " + j + " bytes but received " + l + " bytes.");
    }
}
