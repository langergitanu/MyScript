package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.p011io.HashingByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.HashingSource;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.p011io.SdkSourceKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0013\u001a\f\u0010\u0014\u001a\u0004\u0018\u00010\u0004*\u00020\u0001\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007\"\u001e\u0010\u0018\u001a\u00020\u0019*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"toHttpBody", "Laws/smithy/kotlin/runtime/http/HttpBody;", "", "", "Laws/smithy/kotlin/runtime/content/ByteStream;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "contentLength", "", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/http/HttpBody;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "(Laws/smithy/kotlin/runtime/io/SdkSource;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/http/HttpBody;", "toHashingBody", "hashFunction", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "(Laws/smithy/kotlin/runtime/http/HttpBody;Laws/smithy/kotlin/runtime/hashing/HashFunction;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/http/HttpBody;", "toCompletingBody", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "readAll", "(Laws/smithy/kotlin/runtime/http/HttpBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteStream", "toSdkByteReadChannel", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isEligibleForAwsChunkedStreaming", "", "isEligibleForAwsChunkedStreaming$annotations", "(Laws/smithy/kotlin/runtime/http/HttpBody;)V", "(Laws/smithy/kotlin/runtime/http/HttpBody;)Z", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpBodyKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1 */
    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.HttpBodyKt", m1609f = "HttpBody.kt", m1610i = {0, 0, 1}, m1611l = {249, 253}, m1612m = "readAll", m1613n = {"$this$readAll", "readChan", "$this$readAll"}, m1614nl = {250, PDFACompliance.e_PDFA2_4_4}, m1615s = {"L$0", "L$1", "L$0"}, m1616v = 2)
    static final class C36921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C36921(Continuation<? super C36921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpBodyKt.readAll(null, this);
        }
    }

    @InternalApi
    public static /* synthetic */ void isEligibleForAwsChunkedStreaming$annotations(HttpBody httpBody) {
    }

    public static final HttpBody toHttpBody(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return HttpBody.INSTANCE.fromBytes(bArr);
    }

    public static final HttpBody toHttpBody(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toHttpBody(StringsKt.encodeToByteArray(str));
    }

    @InternalApi
    public static final HttpBody toHttpBody(ByteStream byteStream) {
        Intrinsics.checkNotNullParameter(byteStream, "<this>");
        if (byteStream instanceof ByteStream.Buffer) {
            return new ByteStreamBufferHttpBody((ByteStream.Buffer) byteStream);
        }
        if (byteStream instanceof ByteStream.ChannelStream) {
            return new ByteStreamChannelHttpBody((ByteStream.ChannelStream) byteStream);
        }
        if (byteStream instanceof ByteStream.SourceStream) {
            return new ByteStreamSourceHttpBody((ByteStream.SourceStream) byteStream);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ HttpBody toHttpBody$default(SdkByteReadChannel sdkByteReadChannel, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return toHttpBody(sdkByteReadChannel, l);
    }

    @InternalApi
    public static final HttpBody toHttpBody(SdkByteReadChannel sdkByteReadChannel, Long l) {
        Intrinsics.checkNotNullParameter(sdkByteReadChannel, "<this>");
        return new HttpBody.ChannelContent(l, sdkByteReadChannel) { // from class: aws.smithy.kotlin.runtime.http.HttpBodyKt.toHttpBody.1
            final /* synthetic */ SdkByteReadChannel $ch;
            private final Long contentLength;
            private final boolean isOneShot = true;

            {
                this.$ch = sdkByteReadChannel;
                this.contentLength = l;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            public Long getContentLength() {
                return this.contentLength;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            /* JADX INFO: renamed from: isOneShot, reason: from getter */
            public boolean getIsOneShot() {
                return this.isOneShot;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent
            /* JADX INFO: renamed from: readFrom, reason: from getter */
            public SdkByteReadChannel get$ch() {
                return this.$ch;
            }
        };
    }

    @InternalApi
    public static final HttpBody toHttpBody(SdkSource sdkSource, Long l) {
        Intrinsics.checkNotNullParameter(sdkSource, "<this>");
        return new HttpBody.SourceContent(l, sdkSource) { // from class: aws.smithy.kotlin.runtime.http.HttpBodyKt.toHttpBody.2
            final /* synthetic */ SdkSource $this_toHttpBody;
            private final Long contentLength;
            private final boolean isOneShot = true;

            {
                this.$this_toHttpBody = sdkSource;
                this.contentLength = l;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            public Long getContentLength() {
                return this.contentLength;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            /* JADX INFO: renamed from: isOneShot, reason: from getter */
            public boolean getIsOneShot() {
                return this.isOneShot;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
            /* JADX INFO: renamed from: readFrom, reason: from getter */
            public SdkSource get$this_toHttpBody() {
                return this.$this_toHttpBody;
            }
        };
    }

    public static /* synthetic */ HttpBody toHttpBody$default(SdkSource sdkSource, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return toHttpBody(sdkSource, l);
    }

    @InternalApi
    public static final HttpBody toHashingBody(HttpBody httpBody, HashFunction hashFunction, Long l) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        Intrinsics.checkNotNullParameter(hashFunction, "hashFunction");
        if (httpBody instanceof HttpBody.SourceContent) {
            return toHttpBody(new HashingSource(hashFunction, ((HttpBody.SourceContent) httpBody).get$this_toHttpBody()), l);
        }
        if (httpBody instanceof HttpBody.ChannelContent) {
            return toHttpBody(new HashingByteReadChannel(hashFunction, ((HttpBody.ChannelContent) httpBody).get$ch()), l);
        }
        throw new ClientException("HttpBody type is not supported");
    }

    @InternalApi
    public static final HttpBody toCompletingBody(HttpBody httpBody, CompletableDeferred<String> deferred) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        if (httpBody instanceof HttpBody.SourceContent) {
            SdkSource sdkSource = ((HttpBody.SourceContent) httpBody).get$this_toHttpBody();
            Intrinsics.checkNotNull(sdkSource, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.io.HashingSource");
            return toHttpBody(new CompletingSource(deferred, (HashingSource) sdkSource), httpBody.getContentLength());
        }
        if (!(httpBody instanceof HttpBody.ChannelContent)) {
            throw new ClientException("HttpBody type is not supported");
        }
        SdkByteReadChannel sdkByteReadChannel = ((HttpBody.ChannelContent) httpBody).get$ch();
        Intrinsics.checkNotNull(sdkByteReadChannel, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.io.HashingByteReadChannel");
        return toHttpBody(new CompletingByteReadChannel(deferred, (HashingByteReadChannel) sdkByteReadChannel), httpBody.getContentLength());
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        if (r6 == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        if (r6 == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readAll(HttpBody httpBody, Continuation<? super byte[]> continuation) {
        C36921 c36921;
        if (continuation instanceof C36921) {
            c36921 = (C36921) continuation;
            if ((c36921.label & Integer.MIN_VALUE) != 0) {
                c36921.label -= Integer.MIN_VALUE;
            } else {
                c36921 = new C36921(continuation);
            }
        }
        Object toByteArray = c36921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36921.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(toByteArray);
                return ((SdkBuffer) toByteArray).readByteArray();
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(toByteArray);
            return (byte[]) toByteArray;
        }
        ResultKt.throwOnFailure(toByteArray);
        if (httpBody instanceof HttpBody.Empty) {
            return null;
        }
        if (httpBody instanceof HttpBody.Bytes) {
            return ((HttpBody.Bytes) httpBody).getBytes();
        }
        if (httpBody instanceof HttpBody.ChannelContent) {
            SdkByteReadChannel sdkByteReadChannel = ((HttpBody.ChannelContent) httpBody).get$ch();
            c36921.L$0 = SpillingKt.nullOutSpilledVariable(httpBody);
            c36921.L$1 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
            c36921.label = 1;
            toByteArray = SdkByteReadChannelKt.readToBuffer(sdkByteReadChannel, c36921);
        } else {
            if (!(httpBody instanceof HttpBody.SourceContent)) {
                throw new NoWhenBranchMatchedException();
            }
            SdkSource sdkSource = ((HttpBody.SourceContent) httpBody).get$this_toHttpBody();
            c36921.L$0 = SpillingKt.nullOutSpilledVariable(httpBody);
            c36921.label = 2;
            toByteArray = SdkSourceKt.readToByteArray(sdkSource, c36921);
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ByteStream toByteStream(HttpBody httpBody) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        if (httpBody instanceof ByteStreamHttpBody) {
            return ((ByteStreamHttpBody) httpBody).getStream();
        }
        if (httpBody instanceof HttpBody.Empty) {
            return null;
        }
        if (httpBody instanceof HttpBody.Bytes) {
            return new ByteStream.Buffer() { // from class: aws.smithy.kotlin.runtime.http.HttpBodyKt.toByteStream.1
                private final Long contentLength;

                {
                    this.contentLength = this.$body.getContentLength();
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                public Long getContentLength() {
                    return this.contentLength;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream.Buffer
                /* JADX INFO: renamed from: bytes */
                public byte[] getAsBytes() {
                    return ((HttpBody.Bytes) this.$body).getBytes();
                }
            };
        }
        if (httpBody instanceof HttpBody.ChannelContent) {
            return new ByteStream.ChannelStream() { // from class: aws.smithy.kotlin.runtime.http.HttpBodyKt.toByteStream.2
                private final Long contentLength;
                private final boolean isOneShot;

                {
                    this.contentLength = this.$body.getContentLength();
                    this.isOneShot = this.$body.getIsOneShot();
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                public Long getContentLength() {
                    return this.contentLength;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                /* JADX INFO: renamed from: isOneShot, reason: from getter */
                public boolean getIsOneShot() {
                    return this.isOneShot;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream.ChannelStream
                public SdkByteReadChannel readFrom() {
                    return ((HttpBody.ChannelContent) this.$body).get$ch();
                }
            };
        }
        if (httpBody instanceof HttpBody.SourceContent) {
            return new ByteStream.SourceStream() { // from class: aws.smithy.kotlin.runtime.http.HttpBodyKt.toByteStream.3
                private final Long contentLength;
                private final boolean isOneShot;

                {
                    this.contentLength = this.$body.getContentLength();
                    this.isOneShot = this.$body.getIsOneShot();
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                public Long getContentLength() {
                    return this.contentLength;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream
                /* JADX INFO: renamed from: isOneShot, reason: from getter */
                public boolean getIsOneShot() {
                    return this.isOneShot;
                }

                @Override // aws.smithy.kotlin.runtime.content.ByteStream.SourceStream
                public SdkSource readFrom() {
                    return ((HttpBody.SourceContent) this.$body).get$this_toHttpBody();
                }
            };
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ SdkByteReadChannel toSdkByteReadChannel$default(HttpBody httpBody, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = null;
        }
        return toSdkByteReadChannel(httpBody, coroutineScope);
    }

    @InternalApi
    public static final SdkByteReadChannel toSdkByteReadChannel(HttpBody httpBody, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        if (httpBody instanceof HttpBody.Empty) {
            return null;
        }
        if (httpBody instanceof HttpBody.Bytes) {
            return SdkByteChannelKt.SdkByteReadChannel$default(((HttpBody.Bytes) httpBody).getBytes(), 0, 0, 6, null);
        }
        if (httpBody instanceof HttpBody.ChannelContent) {
            return ((HttpBody.ChannelContent) httpBody).get$ch();
        }
        if (httpBody instanceof HttpBody.SourceContent) {
            return SdkSourceKt.toSdkByteReadChannel(((HttpBody.SourceContent) httpBody).get$this_toHttpBody(), coroutineScope);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isEligibleForAwsChunkedStreaming(HttpBody httpBody) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        if ((!(httpBody instanceof HttpBody.SourceContent) && !(httpBody instanceof HttpBody.ChannelContent)) || httpBody.getContentLength() == null) {
            return false;
        }
        if (httpBody.getIsOneShot()) {
            return true;
        }
        Long contentLength = httpBody.getContentLength();
        Intrinsics.checkNotNull(contentLength);
        return contentLength.longValue() > 1048576;
    }
}
