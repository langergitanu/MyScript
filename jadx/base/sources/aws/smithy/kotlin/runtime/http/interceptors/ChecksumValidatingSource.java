package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.p011io.HashingSource;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/ChecksumValidatingSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "", "expectedChecksum", "Laws/smithy/kotlin/runtime/io/HashingSource;", "hashingSource", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/io/HashingSource;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;J)J", "", "close", "()V", "Ljava/lang/String;", "Laws/smithy/kotlin/runtime/io/HashingSource;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ChecksumValidatingSource implements SdkSource {
    private final String expectedChecksum;
    private final HashingSource hashingSource;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.hashingSource.close();
    }

    public ChecksumValidatingSource(String expectedChecksum, HashingSource hashingSource) {
        Intrinsics.checkNotNullParameter(expectedChecksum, "expectedChecksum");
        Intrinsics.checkNotNullParameter(hashingSource, "hashingSource");
        this.expectedChecksum = expectedChecksum;
        this.hashingSource = hashingSource;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = this.hashingSource.read(sink, limit);
        if (j == -1) {
            FlexibleChecksumsResponseInterceptorKt.validateAndThrow(this.expectedChecksum, Base64Kt.encodeBase64String(this.hashingSource.digest()));
        }
        return j;
    }
}
