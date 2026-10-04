package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsChunkedByteReadChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011¨\u0006#"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsChunkedByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "delegate", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "signingConfig", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "previousSignature", "", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;[BLaws/smithy/kotlin/runtime/http/DeferredHeaders;)V", "chunkReader", "Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader;", "isClosedForRead", "", "()Z", "availableForRead", "", "getAvailableForRead", "()I", "read", "", "sink", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "limit", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "cause", "", "closedCause", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForWrite", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedByteReadChannel implements SdkByteReadChannel {
    private final AwsChunkedReader chunkReader;
    private final SdkByteReadChannel delegate;
    private byte[] previousSignature;
    private final AwsSigner signer;
    private final AwsSigningConfig signingConfig;
    private final DeferredHeaders trailingHeaders;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedByteReadChannel$read$1 */
    /* JADX INFO: compiled from: AwsChunkedByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedByteReadChannel", m1609f = "AwsChunkedByteReadChannel.kt", m1610i = {0, 0}, m1611l = {50}, m1612m = "read", m1613n = {"sink", "limit"}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1615s = {"L$0", "J$0"}, m1616v = 2)
    static final class C36391 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C36391(Continuation<? super C36391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedByteReadChannel.this.read(null, 0L, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        return this.delegate.cancel(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.delegate.isClosedForWrite();
    }

    public AwsChunkedByteReadChannel(SdkByteReadChannel delegate, AwsSigner signer, AwsSigningConfig signingConfig, byte[] previousSignature, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(previousSignature, "previousSignature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        this.delegate = delegate;
        this.signer = signer;
        this.signingConfig = signingConfig;
        this.previousSignature = previousSignature;
        this.trailingHeaders = trailingHeaders;
        this.chunkReader = new AwsChunkedReader(AwsChunkedByteReadChannelKt.asStream(delegate), signer, signingConfig, this.previousSignature, trailingHeaders);
    }

    public /* synthetic */ AwsChunkedByteReadChannel(SdkByteReadChannel sdkByteReadChannel, AwsSigner awsSigner, AwsSigningConfig awsSigningConfig, byte[] bArr, DeferredHeaders deferredHeaders, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkByteReadChannel, awsSigner, awsSigningConfig, bArr, (i & 16) != 0 ? DeferredHeaders.INSTANCE.getEmpty() : deferredHeaders);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.chunkReader.getChunk().getSize() == 0 && this.chunkReader.getHasLastChunkBeenSent() && this.delegate.isClosedForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return ((int) this.chunkReader.getChunk().getSize()) + this.delegate.getAvailableForRead();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws IOException {
        C36391 c36391;
        if (continuation instanceof C36391) {
            c36391 = (C36391) continuation;
            if ((c36391.label & Integer.MIN_VALUE) != 0) {
                c36391.label -= Integer.MIN_VALUE;
            } else {
                c36391 = new C36391(continuation);
            }
        }
        Object objEnsureValidChunk$aws_signing_common = c36391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objEnsureValidChunk$aws_signing_common);
            if (j < 0) {
                throw new IllegalArgumentException(("Invalid limit (" + j + ") must be >= 0L").toString());
            }
            AwsChunkedReader awsChunkedReader = this.chunkReader;
            c36391.L$0 = sdkBuffer;
            c36391.J$0 = j;
            c36391.label = 1;
            objEnsureValidChunk$aws_signing_common = awsChunkedReader.ensureValidChunk$aws_signing_common(c36391);
            if (objEnsureValidChunk$aws_signing_common == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c36391.J$0;
            sdkBuffer = (SdkBuffer) c36391.L$0;
            ResultKt.throwOnFailure(objEnsureValidChunk$aws_signing_common);
        }
        return !((Boolean) objEnsureValidChunk$aws_signing_common).booleanValue() ? Boxing.boxLong(-1L) : Boxing.boxLong(this.chunkReader.getChunk().read(sdkBuffer, j));
    }
}
