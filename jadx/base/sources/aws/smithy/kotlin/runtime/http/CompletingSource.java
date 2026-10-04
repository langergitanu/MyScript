package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.HashingSource;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/CompletingSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "hashingSource", "Laws/smithy/kotlin/runtime/io/HashingSource;", "<init>", "(Lkotlinx/coroutines/CompletableDeferred;Laws/smithy/kotlin/runtime/io/HashingSource;)V", "read", "", "sink", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "limit", "close", "", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompletingSource implements SdkSource {
    private final CompletableDeferred<String> deferred;
    private final HashingSource hashingSource;

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.hashingSource.close();
    }

    public CompletingSource(CompletableDeferred<String> deferred, HashingSource hashingSource) {
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        Intrinsics.checkNotNullParameter(hashingSource, "hashingSource");
        this.deferred = deferred;
        this.hashingSource = hashingSource;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = this.hashingSource.read(sink, limit);
        if (j == -1) {
            this.deferred.complete(Base64Kt.encodeBase64String(this.hashingSource.digest()));
        }
        return j;
    }
}
