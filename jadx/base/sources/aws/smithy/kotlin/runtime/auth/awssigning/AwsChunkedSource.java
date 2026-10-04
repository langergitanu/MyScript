package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.PlannedRemoval;
import aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: AwsChunkedSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsChunkedSource;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "delegate", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "signingConfig", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "previousSignature", "", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkSource;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;[BLaws/smithy/kotlin/runtime/http/DeferredHeaders;Lkotlin/coroutines/CoroutineContext;)V", "(Laws/smithy/kotlin/runtime/io/SdkSource;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;[BLaws/smithy/kotlin/runtime/http/DeferredHeaders;)V", "chunkReader", "Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader;", "read", "", "sink", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "limit", "close", "", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedSource implements SdkSource {
    private final AwsChunkedReader chunkReader;
    private final CoroutineContext coroutineContext;
    private final SdkSource delegate;

    public AwsChunkedSource(SdkSource delegate, AwsSigner signer, AwsSigningConfig signingConfig, byte[] previousSignature, DeferredHeaders trailingHeaders, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(previousSignature, "previousSignature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.delegate = delegate;
        this.coroutineContext = coroutineContext;
        this.chunkReader = new AwsChunkedReader(AwsChunkedSourceKt.asStream(delegate), signer, signingConfig, previousSignature, trailingHeaders);
    }

    public /* synthetic */ AwsChunkedSource(SdkSource sdkSource, AwsSigner awsSigner, AwsSigningConfig awsSigningConfig, byte[] bArr, DeferredHeaders deferredHeaders, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkSource, awsSigner, awsSigningConfig, bArr, (i & 16) != 0 ? DeferredHeaders.INSTANCE.getEmpty() : deferredHeaders, coroutineContext);
    }

    public /* synthetic */ AwsChunkedSource(SdkSource sdkSource, AwsSigner awsSigner, AwsSigningConfig awsSigningConfig, byte[] bArr, DeferredHeaders deferredHeaders, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkSource, awsSigner, awsSigningConfig, bArr, (i & 16) != 0 ? DeferredHeaders.INSTANCE.getEmpty() : deferredHeaders);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PlannedRemoval(major = 1, minor = 7)
    @Deprecated(message = "This overload causes `runBlocking` to be called without a CoroutineContext which leads to forgetting logging context. This overload will be removed in minor version 1.7.", replaceWith = @ReplaceWith(expression = "AwsChunkedSource(delegate, signer, signingConfig, previousSignature, trailingHeaders, coroutineContext)", imports = {"kotlin.coroutines.coroutineContext"}))
    public AwsChunkedSource(SdkSource delegate, AwsSigner signer, AwsSigningConfig signingConfig, byte[] previousSignature, DeferredHeaders trailingHeaders) {
        this(delegate, signer, signingConfig, previousSignature, trailingHeaders, EmptyCoroutineContext.INSTANCE);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(previousSignature, "previousSignature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource
    public long read(SdkBuffer sink, long limit) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (limit < 0) {
            throw new IllegalArgumentException(("Invalid limit (" + limit + ") must be >= 0L").toString());
        }
        if (((Boolean) BuildersKt.runBlocking(this.coroutineContext, new AwsChunkedSource$read$isChunkValid$1(this, null))).booleanValue()) {
            return this.chunkReader.getChunk().read(sink, limit);
        }
        return -1L;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }
}
