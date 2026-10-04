package aws.smithy.kotlin.runtime.auth.awssigning.internal;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignatureType;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningResult;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.DeferredHeadersKt;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: AwsChunkedReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001)B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000f*\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010 J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020#H\u0082@¢\u0006\u0002\u0010$J\f\u0010%\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010&\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010'\u001a\u00020\u0013*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader;", "", "stream", "Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "signingConfig", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "previousSignature", "", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;[BLaws/smithy/kotlin/runtime/http/DeferredHeaders;)V", "chunk", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "getChunk$aws_signing_common", "()Laws/smithy/kotlin/runtime/io/SdkBuffer;", "hasLastChunkBeenSent", "", "getHasLastChunkBeenSent$aws_signing_common", "()Z", "setHasLastChunkBeenSent$aws_signing_common", "(Z)V", "ensureValidChunk", "ensureValidChunk$aws_signing_common", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFinalChunk", "readChunk", "(Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignedChunk", "data", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnsignedChunk", "getTrailingHeadersChunk", "Laws/smithy/kotlin/runtime/http/Headers;", "(Laws/smithy/kotlin/runtime/http/Headers;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChunkSigningConfig", "toTrailingHeadersSigningConfig", "isUnsigned", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;)Z", "Stream", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedReader {
    private final SdkBuffer chunk;
    private boolean hasLastChunkBeenSent;
    private byte[] previousSignature;
    private final AwsSigner signer;
    private final AwsSigningConfig signingConfig;
    private final Stream stream;
    private final DeferredHeaders trailingHeaders;

    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/internal/AwsChunkedReader$Stream;", "", "isClosedForRead", "", "read", "", "sink", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "limit", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Stream {
        boolean isClosedForRead();

        Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader$getFinalChunk$1 */
    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader", m1609f = "AwsChunkedReader.kt", m1610i = {2, 3}, m1611l = {98, 98, 102, 102}, m1612m = "getFinalChunk", m1613n = {"lastChunk", "lastChunk"}, m1614nl = {98, 98, 102, HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1615s = {"L$0", "L$0"}, m1616v = 2)
    static final class C36551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C36551(Continuation<? super C36551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedReader.this.getFinalChunk(this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader$getSignedChunk$1 */
    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader", m1609f = "AwsChunkedReader.kt", m1610i = {0, 1, 1, 1}, m1611l = {140, 145}, m1612m = "getSignedChunk", m1613n = {"data", "data", "bodyBuffer", "chunkBody"}, m1614nl = {143, 146}, m1615s = {"L$0", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36561(Continuation<? super C36561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedReader.this.getSignedChunk(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader$getTrailingHeadersChunk$1 */
    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader", m1609f = "AwsChunkedReader.kt", m1610i = {0}, m1611l = {201}, m1612m = "getTrailingHeadersChunk", m1613n = {"trailingHeaders"}, m1614nl = {202}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C36571(Continuation<? super C36571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedReader.this.getTrailingHeadersChunk(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader$getUnsignedChunk$1 */
    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader", m1609f = "AwsChunkedReader.kt", m1610i = {0}, m1611l = {176}, m1612m = "getUnsignedChunk", m1613n = {"data"}, m1614nl = {178}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36581 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C36581(Continuation<? super C36581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedReader.this.getUnsignedChunk(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader$readChunk$1 */
    /* JADX INFO: compiled from: AwsChunkedReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedReader", m1609f = "AwsChunkedReader.kt", m1610i = {0, 0, 0}, m1611l = {118}, m1612m = "readChunk", m1613n = {"$this$readChunk", "sink", "remaining"}, m1614nl = {119}, m1615s = {"L$0", "L$1", "J$0"}, m1616v = 2)
    static final class C36591 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C36591(Continuation<? super C36591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwsChunkedReader.this.readChunk(null, this);
        }
    }

    public AwsChunkedReader(Stream stream, AwsSigner signer, AwsSigningConfig signingConfig, byte[] previousSignature, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(previousSignature, "previousSignature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        this.stream = stream;
        this.signer = signer;
        this.signingConfig = signingConfig;
        this.previousSignature = previousSignature;
        this.trailingHeaders = trailingHeaders;
        this.chunk = new SdkBuffer();
    }

    /* JADX INFO: renamed from: getChunk$aws_signing_common, reason: from getter */
    public final SdkBuffer getChunk() {
        return this.chunk;
    }

    /* JADX INFO: renamed from: getHasLastChunkBeenSent$aws_signing_common, reason: from getter */
    public final boolean getHasLastChunkBeenSent() {
        return this.hasLastChunkBeenSent;
    }

    public final void setHasLastChunkBeenSent$aws_signing_common(boolean z) {
        this.hasLastChunkBeenSent = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        if (r15 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        if (r15 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009c, code lost:
    
        if (r15 == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object ensureValidChunk$aws_signing_common(Continuation<? super Boolean> continuation) throws IOException {
        AwsChunkedReader$ensureValidChunk$1 awsChunkedReader$ensureValidChunk$1;
        SdkBuffer sdkBuffer;
        SdkBuffer sdkBuffer2;
        if (continuation instanceof AwsChunkedReader$ensureValidChunk$1) {
            awsChunkedReader$ensureValidChunk$1 = (AwsChunkedReader$ensureValidChunk$1) continuation;
            if ((awsChunkedReader$ensureValidChunk$1.label & Integer.MIN_VALUE) != 0) {
                awsChunkedReader$ensureValidChunk$1.label -= Integer.MIN_VALUE;
            } else {
                awsChunkedReader$ensureValidChunk$1 = new AwsChunkedReader$ensureValidChunk$1(this, continuation);
            }
        }
        Object signedChunk$default = awsChunkedReader$ensureValidChunk$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = awsChunkedReader$ensureValidChunk$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(signedChunk$default);
            if (this.chunk.getSize() > 0) {
                return Boxing.boxBoolean(true);
            }
            sdkBuffer = null;
            if (!this.stream.isClosedForRead() || !this.hasLastChunkBeenSent) {
                if (isUnsigned(this.signingConfig)) {
                    awsChunkedReader$ensureValidChunk$1.label = 1;
                    signedChunk$default = getUnsignedChunk$default(this, null, awsChunkedReader$ensureValidChunk$1, 1, null);
                } else {
                    awsChunkedReader$ensureValidChunk$1.label = 2;
                    signedChunk$default = getSignedChunk$default(this, null, awsChunkedReader$ensureValidChunk$1, 1, null);
                }
                return coroutine_suspended;
            }
            if (sdkBuffer != null) {
            }
            if (sdkBuffer != null) {
            }
            return Boxing.boxBoolean(this.chunk.getSize() > 0);
        }
        if (i == 1) {
            ResultKt.throwOnFailure(signedChunk$default);
            sdkBuffer2 = (SdkBuffer) signedChunk$default;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(signedChunk$default);
                sdkBuffer2 = (SdkBuffer) signedChunk$default;
                this.hasLastChunkBeenSent = true;
                sdkBuffer = sdkBuffer2;
                if (sdkBuffer != null) {
                    SdkBufferedSink.writeUtf8$default(sdkBuffer, "\r\n", 0, 0, 6, null);
                }
                if (sdkBuffer != null) {
                    Boxing.boxLong(this.chunk.writeAll(sdkBuffer));
                }
                return Boxing.boxBoolean(this.chunk.getSize() > 0);
            }
            ResultKt.throwOnFailure(signedChunk$default);
            sdkBuffer2 = (SdkBuffer) signedChunk$default;
        }
        if (sdkBuffer2 == null) {
            if (!this.stream.isClosedForRead()) {
                throw new IllegalStateException("Expected underlying reader to be closed".toString());
            }
            awsChunkedReader$ensureValidChunk$1.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer2);
            awsChunkedReader$ensureValidChunk$1.label = 3;
            signedChunk$default = getFinalChunk(awsChunkedReader$ensureValidChunk$1);
        }
        sdkBuffer = sdkBuffer2;
        if (sdkBuffer != null) {
        }
        if (sdkBuffer != null) {
        }
        return Boxing.boxBoolean(this.chunk.getSize() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFinalChunk(Continuation<? super SdkBuffer> continuation) throws IOException {
        C36551 c36551;
        SdkBuffer sdkBuffer;
        AwsChunkedReader awsChunkedReader;
        SdkBuffer sdkBuffer2;
        if (continuation instanceof C36551) {
            c36551 = (C36551) continuation;
            if ((c36551.label & Integer.MIN_VALUE) != 0) {
                c36551.label -= Integer.MIN_VALUE;
            } else {
                c36551 = new C36551(continuation);
            }
        }
        Object signedChunk = c36551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36551.label;
        if (i == 0) {
            ResultKt.throwOnFailure(signedChunk);
            if (isUnsigned(this.signingConfig)) {
                SdkBuffer sdkBuffer3 = new SdkBuffer();
                c36551.label = 1;
                signedChunk = getUnsignedChunk(sdkBuffer3, c36551);
                if (signedChunk != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            SdkBuffer sdkBuffer4 = new SdkBuffer();
            c36551.label = 2;
            signedChunk = getSignedChunk(sdkBuffer4, c36551);
            if (signedChunk != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sdkBuffer2 = (SdkBuffer) c36551.L$0;
                ResultKt.throwOnFailure(signedChunk);
                sdkBuffer2.writeAll((SdkBuffer) signedChunk);
                return sdkBuffer2;
            }
            awsChunkedReader = (AwsChunkedReader) c36551.L$1;
            sdkBuffer = (SdkBuffer) c36551.L$0;
            ResultKt.throwOnFailure(signedChunk);
            c36551.L$0 = sdkBuffer;
            c36551.L$1 = null;
            c36551.label = 4;
            signedChunk = awsChunkedReader.getTrailingHeadersChunk((Headers) signedChunk, c36551);
            if (signedChunk != coroutine_suspended) {
                sdkBuffer2 = sdkBuffer;
                sdkBuffer2.writeAll((SdkBuffer) signedChunk);
                return sdkBuffer2;
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(signedChunk);
        SdkBuffer sdkBuffer5 = (SdkBuffer) signedChunk;
        if (sdkBuffer5 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (this.trailingHeaders.isEmpty()) {
            return sdkBuffer5;
        }
        DeferredHeaders deferredHeaders = this.trailingHeaders;
        c36551.L$0 = sdkBuffer5;
        c36551.L$1 = this;
        c36551.label = 3;
        Object headers = DeferredHeadersKt.toHeaders(deferredHeaders, c36551);
        if (headers != coroutine_suspended) {
            sdkBuffer = sdkBuffer5;
            signedChunk = headers;
            awsChunkedReader = this;
            c36551.L$0 = sdkBuffer;
            c36551.L$1 = null;
            c36551.label = 4;
            signedChunk = awsChunkedReader.getTrailingHeadersChunk((Headers) signedChunk, c36551);
            if (signedChunk != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0060 -> B:12:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readChunk(Stream stream, Continuation<? super SdkBuffer> continuation) {
        C36591 c36591;
        SdkBuffer sdkBuffer;
        long j;
        if (continuation instanceof C36591) {
            c36591 = (C36591) continuation;
            if ((c36591.label & Integer.MIN_VALUE) != 0) {
                c36591.label -= Integer.MIN_VALUE;
            } else {
                c36591 = new C36591(continuation);
            }
        }
        Object obj = c36591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sdkBuffer = new SdkBuffer();
            j = 65536;
            if (j > 0) {
            }
            if (sdkBuffer.getSize() != 0) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c36591.J$0;
            SdkBuffer sdkBuffer2 = (SdkBuffer) c36591.L$1;
            Stream stream2 = (Stream) c36591.L$0;
            ResultKt.throwOnFailure(obj);
            C36591 c365912 = c36591;
            SdkBuffer sdkBuffer3 = sdkBuffer2;
            stream = stream2;
            C36591 c365913 = c365912;
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue == -1) {
                j -= jLongValue;
                sdkBuffer = sdkBuffer3;
                c36591 = c365913;
                if (j > 0) {
                    c36591.L$0 = stream;
                    c36591.L$1 = sdkBuffer;
                    c36591.J$0 = j;
                    c36591.label = 1;
                    Object obj2 = stream.read(sdkBuffer, j, c36591);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c365912 = c36591;
                    sdkBuffer3 = sdkBuffer;
                    obj = obj2;
                    C36591 c3659132 = c365912;
                    long jLongValue2 = ((Number) obj).longValue();
                    if (jLongValue2 == -1) {
                        sdkBuffer = sdkBuffer3;
                    }
                }
                if (sdkBuffer.getSize() != 0) {
                    return null;
                }
                return sdkBuffer;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getSignedChunk(SdkBuffer sdkBuffer, Continuation<? super SdkBuffer> continuation) throws IOException {
        C36561 c36561;
        SdkBuffer sdkBuffer2;
        SdkBuffer sdkBuffer3;
        byte[] byteArray;
        byte[] bArr;
        if (continuation instanceof C36561) {
            c36561 = (C36561) continuation;
            if ((c36561.label & Integer.MIN_VALUE) != 0) {
                c36561.label -= Integer.MIN_VALUE;
            } else {
                c36561 = new C36561(continuation);
            }
        }
        Object chunk = c36561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(chunk);
            if (sdkBuffer == null) {
                Stream stream = this.stream;
                c36561.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                c36561.label = 1;
                chunk = readChunk(stream, c36561);
                if (chunk != coroutine_suspended) {
                    sdkBuffer3 = sdkBuffer;
                }
                return coroutine_suspended;
            }
            sdkBuffer2 = sdkBuffer;
            sdkBuffer3 = sdkBuffer2;
            if (sdkBuffer2 == null && (byteArray = sdkBuffer2.readByteArray()) != null) {
                AwsSigner awsSigner = this.signer;
                byte[] bArr2 = this.previousSignature;
                AwsSigningConfig chunkSigningConfig = toChunkSigningConfig(this.signingConfig);
                c36561.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer3);
                c36561.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer2);
                c36561.L$2 = byteArray;
                c36561.label = 2;
                chunk = awsSigner.signChunk(byteArray, bArr2, chunkSigningConfig, c36561);
                if (chunk != coroutine_suspended) {
                    bArr = byteArray;
                    byte[] signature = ((AwsSigningResult) chunk).getSignature();
                    this.previousSignature = signature;
                    SdkBuffer sdkBuffer4 = new SdkBuffer();
                    SdkBuffer sdkBuffer5 = sdkBuffer4;
                    String string = Integer.toString(bArr.length, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    SdkBufferedSink.writeUtf8$default(sdkBuffer5, string, 0, 0, 6, null);
                    SdkBufferedSink.writeUtf8$default(sdkBuffer5, Literals.COMMENT_2, 0, 0, 6, null);
                    SdkBufferedSink.writeUtf8$default(sdkBuffer5, "chunk-signature=", 0, 0, 6, null);
                    SdkBufferedSink.write$default(sdkBuffer5, signature, 0, 0, 6, null);
                    SdkBufferedSink.writeUtf8$default(sdkBuffer5, "\r\n", 0, 0, 6, null);
                    SdkBufferedSink.write$default(sdkBuffer5, bArr, 0, 0, 6, null);
                    return sdkBuffer4;
                }
                return coroutine_suspended;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bArr = (byte[]) c36561.L$2;
            ResultKt.throwOnFailure(chunk);
            byte[] signature2 = ((AwsSigningResult) chunk).getSignature();
            this.previousSignature = signature2;
            SdkBuffer sdkBuffer42 = new SdkBuffer();
            SdkBuffer sdkBuffer52 = sdkBuffer42;
            String string2 = Integer.toString(bArr.length, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            SdkBufferedSink.writeUtf8$default(sdkBuffer52, string2, 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer52, Literals.COMMENT_2, 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer52, "chunk-signature=", 0, 0, 6, null);
            SdkBufferedSink.write$default(sdkBuffer52, signature2, 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer52, "\r\n", 0, 0, 6, null);
            SdkBufferedSink.write$default(sdkBuffer52, bArr, 0, 0, 6, null);
            return sdkBuffer42;
        }
        sdkBuffer3 = (SdkBuffer) c36561.L$0;
        ResultKt.throwOnFailure(chunk);
        sdkBuffer2 = (SdkBuffer) chunk;
        return sdkBuffer2 == null ? null : null;
    }

    static /* synthetic */ Object getSignedChunk$default(AwsChunkedReader awsChunkedReader, SdkBuffer sdkBuffer, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkBuffer = null;
        }
        return awsChunkedReader.getSignedChunk(sdkBuffer, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getUnsignedChunk(SdkBuffer sdkBuffer, Continuation<? super SdkBuffer> continuation) throws IOException {
        C36581 c36581;
        if (continuation instanceof C36581) {
            c36581 = (C36581) continuation;
            if ((c36581.label & Integer.MIN_VALUE) != 0) {
                c36581.label -= Integer.MIN_VALUE;
            } else {
                c36581 = new C36581(continuation);
            }
        }
        Object chunk = c36581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36581.label;
        if (i == 0) {
            ResultKt.throwOnFailure(chunk);
            if (sdkBuffer == null) {
                Stream stream = this.stream;
                c36581.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                c36581.label = 1;
                chunk = readChunk(stream, c36581);
                if (chunk == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SdkBuffer sdkBuffer2 = new SdkBuffer();
            SdkBuffer sdkBuffer3 = sdkBuffer2;
            String string = Long.toString(sdkBuffer.getSize(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, string, 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, "\r\n", 0, 0, 6, null);
            sdkBuffer2.writeAll(sdkBuffer);
            return sdkBuffer2;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(chunk);
        sdkBuffer = (SdkBuffer) chunk;
        if (sdkBuffer == null) {
            return null;
        }
        SdkBuffer sdkBuffer22 = new SdkBuffer();
        SdkBuffer sdkBuffer32 = sdkBuffer22;
        String string2 = Long.toString(sdkBuffer.getSize(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        SdkBufferedSink.writeUtf8$default(sdkBuffer32, string2, 0, 0, 6, null);
        SdkBufferedSink.writeUtf8$default(sdkBuffer32, "\r\n", 0, 0, 6, null);
        sdkBuffer22.writeAll(sdkBuffer);
        return sdkBuffer22;
    }

    static /* synthetic */ Object getUnsignedChunk$default(AwsChunkedReader awsChunkedReader, SdkBuffer sdkBuffer, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkBuffer = null;
        }
        return awsChunkedReader.getUnsignedChunk(sdkBuffer, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getTrailingHeadersChunk(Headers headers, Continuation<? super SdkBuffer> continuation) throws IOException {
        C36571 c36571;
        if (continuation instanceof C36571) {
            c36571 = (C36571) continuation;
            if ((c36571.label & Integer.MIN_VALUE) != 0) {
                c36571.label -= Integer.MIN_VALUE;
            } else {
                c36571 = new C36571(continuation);
            }
        }
        Object objSignChunkTrailer = c36571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSignChunkTrailer);
            AwsSigner awsSigner = this.signer;
            byte[] bArr = this.previousSignature;
            AwsSigningConfig trailingHeadersSigningConfig = toTrailingHeadersSigningConfig(this.signingConfig);
            c36571.L$0 = headers;
            c36571.label = 1;
            objSignChunkTrailer = awsSigner.signChunkTrailer(headers, bArr, trailingHeadersSigningConfig, c36571);
            if (objSignChunkTrailer == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            headers = (Headers) c36571.L$0;
            ResultKt.throwOnFailure(objSignChunkTrailer);
        }
        byte[] signature = ((AwsSigningResult) objSignChunkTrailer).getSignature();
        this.previousSignature = signature;
        SdkBuffer sdkBuffer = new SdkBuffer();
        AwsChunkedUtilKt.writeTrailers(sdkBuffer, headers);
        if (!isUnsigned(this.signingConfig)) {
            AwsChunkedUtilKt.writeTrailerSignature(sdkBuffer, StringsKt.decodeToString(signature));
        }
        return sdkBuffer;
    }

    private final AwsSigningConfig toChunkSigningConfig(AwsSigningConfig awsSigningConfig) {
        AwsSigningConfig.Builder builder = awsSigningConfig.toBuilder();
        builder.setSignatureType(AwsSignatureType.HTTP_REQUEST_CHUNK);
        builder.setHashSpecification(HashSpecification.CalculateFromPayload.INSTANCE);
        return builder.build();
    }

    private final AwsSigningConfig toTrailingHeadersSigningConfig(AwsSigningConfig awsSigningConfig) {
        AwsSigningConfig.Builder builder = awsSigningConfig.toBuilder();
        builder.setSignatureType(AwsSignatureType.HTTP_REQUEST_TRAILING_HEADERS);
        builder.setHashSpecification(HashSpecification.CalculateFromPayload.INSTANCE);
        return builder.build();
    }

    private final boolean isUnsigned(AwsSigningConfig awsSigningConfig) {
        return Intrinsics.areEqual(awsSigningConfig.getHashSpecification(), HashSpecification.StreamingUnsignedPayloadWithTrailers.INSTANCE);
    }
}
