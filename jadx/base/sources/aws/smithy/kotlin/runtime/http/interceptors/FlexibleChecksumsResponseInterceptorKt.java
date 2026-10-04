package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.p011io.HashingByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.HashingSource;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/HttpBody;", "", "expectedChecksum", "toChecksumValidatingBody", "(Laws/smithy/kotlin/runtime/http/HttpBody;Ljava/lang/String;)Laws/smithy/kotlin/runtime/http/HttpBody;", "expected", "actual", "", "validateAndThrow", "(Ljava/lang/String;Ljava/lang/String;)V", "", "CHECKSUM_HEADER_VALIDATION_PRIORITY_LIST", "Ljava/util/List;", "getCHECKSUM_HEADER_VALIDATION_PRIORITY_LIST", "()Ljava/util/List;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FlexibleChecksumsResponseInterceptorKt {
    private static final List<String> CHECKSUM_HEADER_VALIDATION_PRIORITY_LIST = CollectionsKt.listOf((Object[]) new String[]{"x-amz-checksum-crc32c", "x-amz-checksum-crc32", "x-amz-checksum-sha1", "x-amz-checksum-sha256"});

    public static final List<String> getCHECKSUM_HEADER_VALIDATION_PRIORITY_LIST() {
        return CHECKSUM_HEADER_VALIDATION_PRIORITY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpBody toChecksumValidatingBody(HttpBody httpBody, String str) {
        if (httpBody instanceof HttpBody.SourceContent) {
            SdkSource sdkSource = ((HttpBody.SourceContent) httpBody).get$this_toHttpBody();
            Intrinsics.checkNotNull(sdkSource, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.io.HashingSource");
            return HttpBodyKt.toHttpBody(new ChecksumValidatingSource(str, (HashingSource) sdkSource), httpBody.getContentLength());
        }
        if (!(httpBody instanceof HttpBody.ChannelContent)) {
            throw new ClientException("HttpBody type is not supported");
        }
        SdkByteReadChannel sdkByteReadChannel = ((HttpBody.ChannelContent) httpBody).get$ch();
        Intrinsics.checkNotNull(sdkByteReadChannel, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.io.HashingByteReadChannel");
        return HttpBodyKt.toHttpBody(new ChecksumValidatingByteReadChannel(str, (HashingByteReadChannel) sdkByteReadChannel), httpBody.getContentLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateAndThrow(String str, String str2) {
        if (!Intrinsics.areEqual(str, str2)) {
            throw new ChecksumMismatchException("Checksum mismatch. Expected " + str + " but was " + str2);
        }
    }
}
