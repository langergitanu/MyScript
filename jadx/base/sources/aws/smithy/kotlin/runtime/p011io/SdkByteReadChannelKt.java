package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.p011io.internal.SdkDispatchers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.http2.Http2Stream;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: SdkByteReadChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013\u001a&\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0003H\u0087@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "byteCount", "", "readFully", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Laws/smithy/kotlin/runtime/io/SdkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readToBuffer", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/SdkSink;", "readAll", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Laws/smithy/kotlin/runtime/io/SdkSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;", "Laws/smithy/kotlin/runtime/io/SdkSource;", FirebaseAnalytics.Param.SOURCE, "writeAll", "(Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;Laws/smithy/kotlin/runtime/io/SdkSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "hashFunction", "bufferSize", "", "rollingHash", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Laws/smithy/kotlin/runtime/hashing/HashFunction;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkByteReadChannelKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readFully$1 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0, 0, 0}, m1611l = {BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "readFully", m1613n = {"$this$readFully", "sink", "byteCount", "remaining"}, m1614nl = {77}, m1615s = {"L$0", "L$1", "J$0", "J$1"}, m1616v = 2)
    static final class C37541 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37541(Continuation<? super C37541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkByteReadChannelKt.readFully(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA9_1}, m1612m = "readRemaining", m1613n = {"$this$readRemaining", "sink"}, m1614nl = {PDFACompliance.e_PDFA9_2}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C37551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37551(Continuation<? super C37551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkByteReadChannelKt.readRemaining(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readToBuffer$1 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0}, m1611l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1612m = "readToBuffer", m1613n = {"$this$readToBuffer", "buffer"}, m1614nl = {104}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C37561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37561(Continuation<? super C37561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkByteReadChannelKt.readToBuffer(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$rollingHash$1 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {146, 147}, m1612m = "rollingHash", m1613n = {"$this$rollingHash", "hashFunction", "buffer", "bufferSize", "$this$rollingHash", "hashFunction", "buffer", "bufferSize"}, m1614nl = {147, 149}, m1615s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"}, m1616v = 2)
    static final class C37571 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C37571(Continuation<? super C37571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkByteReadChannelKt.rollingHash(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0059 -> B:21:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFully(SdkByteReadChannel sdkByteReadChannel, SdkBuffer sdkBuffer, long j, Continuation<? super Unit> continuation) throws EOFException {
        C37541 c37541;
        long j2;
        if (continuation instanceof C37541) {
            c37541 = (C37541) continuation;
            if ((c37541.label & Integer.MIN_VALUE) != 0) {
                c37541.label -= Integer.MIN_VALUE;
            } else {
                c37541 = new C37541(continuation);
            }
        }
        Object obj = c37541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37541.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j2 = j;
            if (j <= 0) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c37541.J$1;
            long j4 = c37541.J$0;
            SdkBuffer sdkBuffer2 = (SdkBuffer) c37541.L$1;
            SdkByteReadChannel sdkByteReadChannel2 = (SdkByteReadChannel) c37541.L$0;
            ResultKt.throwOnFailure(obj);
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue == -1) {
                long j5 = j3 - jLongValue;
                sdkByteReadChannel = sdkByteReadChannel2;
                j2 = j4;
                j = j5;
                sdkBuffer = sdkBuffer2;
                if (j <= 0) {
                    c37541.L$0 = sdkByteReadChannel;
                    c37541.L$1 = sdkBuffer;
                    c37541.J$0 = j2;
                    c37541.J$1 = j;
                    c37541.label = 1;
                    obj = sdkByteReadChannel.read(sdkBuffer, j, c37541);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sdkBuffer2 = sdkBuffer;
                    long j6 = j2;
                    sdkByteReadChannel2 = sdkByteReadChannel;
                    j3 = j;
                    j4 = j6;
                    long jLongValue2 = ((Number) obj).longValue();
                    if (jLongValue2 == -1) {
                        throw new EOFException("Unexpected EOF: expected " + j3 + " more bytes; consumed: " + (j4 - j3));
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object readRemaining(aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel r7, aws.smithy.kotlin.runtime.p011io.SdkBuffer r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt.C37551
            if (r0 == 0) goto L14
            r0 = r9
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1 r0 = (aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt.C37551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1 r0 = new aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readRemaining$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            aws.smithy.kotlin.runtime.io.SdkBuffer r7 = (aws.smithy.kotlin.runtime.p011io.SdkBuffer) r7
            java.lang.Object r8 = r0.L$0
            aws.smithy.kotlin.runtime.io.SdkByteReadChannel r8 = (aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L52
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
        L40:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r9 = r7.read(r8, r4, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            boolean r9 = r7.isClosedForRead()
            if (r9 == 0) goto L40
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt.readRemaining(aws.smithy.kotlin.runtime.io.SdkByteReadChannel, aws.smithy.kotlin.runtime.io.SdkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readToBuffer(SdkByteReadChannel sdkByteReadChannel, Continuation<? super SdkBuffer> continuation) {
        C37561 c37561;
        if (continuation instanceof C37561) {
            c37561 = (C37561) continuation;
            if ((c37561.label & Integer.MIN_VALUE) != 0) {
                c37561.label -= Integer.MIN_VALUE;
            } else {
                c37561 = new C37561(continuation);
            }
        }
        Object obj = c37561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37561.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SdkBuffer sdkBuffer = (SdkBuffer) c37561.L$1;
            ResultKt.throwOnFailure(obj);
            return sdkBuffer;
        }
        ResultKt.throwOnFailure(obj);
        SdkBuffer sdkBuffer2 = new SdkBuffer();
        c37561.L$0 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
        c37561.L$1 = sdkBuffer2;
        c37561.label = 1;
        return readRemaining(sdkByteReadChannel, sdkBuffer2, c37561) == coroutine_suspended ? coroutine_suspended : sdkBuffer2;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readAll$2 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readAll$2", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0}, m1611l = {114}, m1612m = "invokeSuspend", m1613n = {"bufferedSink", "totalWritten"}, m1614nl = {115}, m1615s = {"L$0", "J$0"}, m1616v = 2)
    static final class C37532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ SdkSink $sink;
        final /* synthetic */ SdkByteReadChannel $this_readAll;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37532(SdkSink sdkSink, SdkByteReadChannel sdkByteReadChannel, Continuation<? super C37532> continuation) {
            super(2, continuation);
            this.$sink = sdkSink;
            this.$this_readAll = sdkByteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37532(this.$sink, this.$this_readAll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C37532) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003e -> B:12:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IOException {
            long j;
            SdkBufferedSink sdkBufferedSinkBuffer;
            long jLongValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j = 0;
                sdkBufferedSinkBuffer = SdkIoKt.buffer(this.$sink);
                this.L$0 = sdkBufferedSinkBuffer;
                this.J$0 = j;
                this.label = 1;
                obj = this.$this_readAll.read(sdkBufferedSinkBuffer.getBuffer(), Http2Stream.EMIT_BUFFER_SIZE, this);
                if (obj == coroutine_suspended) {
                }
                jLongValue = ((Number) obj).longValue();
                if (jLongValue != -1) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                sdkBufferedSinkBuffer = (SdkBufferedSink) this.L$0;
                ResultKt.throwOnFailure(obj);
                jLongValue = ((Number) obj).longValue();
                if (jLongValue != -1) {
                    j += jLongValue;
                    sdkBufferedSinkBuffer.emit();
                    this.L$0 = sdkBufferedSinkBuffer;
                    this.J$0 = j;
                    this.label = 1;
                    obj = this.$this_readAll.read(sdkBufferedSinkBuffer.getBuffer(), Http2Stream.EMIT_BUFFER_SIZE, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jLongValue = ((Number) obj).longValue();
                    if (jLongValue != -1) {
                        sdkBufferedSinkBuffer.emit();
                        return Boxing.boxLong(j);
                    }
                }
            }
        }
    }

    public static final Object readAll(SdkByteReadChannel sdkByteReadChannel, SdkSink sdkSink, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(SdkDispatchers.INSTANCE.getIO(), new C37532(sdkSink, sdkByteReadChannel, null), continuation);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$writeAll$2 */
    /* JADX INFO: compiled from: SdkByteReadChannel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$writeAll$2", m1609f = "SdkByteReadChannel.kt", m1610i = {0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_3_3}, m1612m = "invokeSuspend", m1613n = {"buffer", "totalRead", "rc"}, m1614nl = {135}, m1615s = {"L$0", "J$0", "J$1"}, m1616v = 2)
    static final class C37582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
        final /* synthetic */ SdkSource $source;
        final /* synthetic */ SdkByteWriteChannel $this_writeAll;
        long J$0;
        long J$1;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37582(SdkSource sdkSource, SdkByteWriteChannel sdkByteWriteChannel, Continuation<? super C37582> continuation) {
            super(2, continuation);
            this.$source = sdkSource;
            this.$this_writeAll = sdkByteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37582(this.$source, this.$this_writeAll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((C37582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            long j;
            SdkBuffer sdkBuffer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j = 0;
                sdkBuffer = new SdkBuffer();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                SdkBuffer sdkBuffer2 = (SdkBuffer) this.L$0;
                ResultKt.throwOnFailure(obj);
                sdkBuffer = sdkBuffer2;
            }
            do {
                long j2 = this.$source.read(sdkBuffer, Http2Stream.EMIT_BUFFER_SIZE);
                if (j2 == -1) {
                    return Boxing.boxLong(j);
                }
                j += j2;
                this.L$0 = sdkBuffer;
                this.J$0 = j;
                this.J$1 = j2;
                this.label = 1;
            } while (SdkByteWriteChannel.write$default(this.$this_writeAll, sdkBuffer, 0L, this, 2, null) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    public static final Object writeAll(SdkByteWriteChannel sdkByteWriteChannel, SdkSource sdkSource, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(SdkDispatchers.INSTANCE.getIO(), new C37582(sdkSource, sdkByteWriteChannel, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ae -> B:27:0x00b2). Please report as a decompilation issue!!! */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object rollingHash(SdkByteReadChannel sdkByteReadChannel, HashFunction hashFunction, long j, Continuation<? super byte[]> continuation) {
        C37571 c37571;
        long j2;
        SdkBuffer sdkBuffer;
        C37571 c375712;
        SdkByteReadChannel sdkByteReadChannel2;
        HashFunction hashFunction2;
        SdkByteReadChannel sdkByteReadChannel3;
        SdkBuffer sdkBuffer2;
        HashFunction hashFunction3;
        if (continuation instanceof C37571) {
            c37571 = (C37571) continuation;
            if ((c37571.label & Integer.MIN_VALUE) != 0) {
                c37571.label -= Integer.MIN_VALUE;
            } else {
                c37571 = new C37571(continuation);
            }
        }
        Object toByteArray = c37571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(toByteArray);
            j2 = j;
            sdkBuffer = new SdkBuffer();
            c375712 = c37571;
            sdkByteReadChannel2 = sdkByteReadChannel;
            hashFunction2 = hashFunction;
            if (!sdkByteReadChannel2.isClosedForRead()) {
            }
        } else {
            if (i == 1) {
                j2 = c37571.J$0;
                SdkBuffer sdkBuffer3 = (SdkBuffer) c37571.L$2;
                HashFunction hashFunction4 = (HashFunction) c37571.L$1;
                sdkByteReadChannel3 = (SdkByteReadChannel) c37571.L$0;
                ResultKt.throwOnFailure(toByteArray);
                sdkBuffer2 = sdkBuffer3;
                hashFunction3 = hashFunction4;
                c37571.L$0 = sdkByteReadChannel3;
                c37571.L$1 = hashFunction3;
                c37571.L$2 = sdkBuffer2;
                c37571.L$3 = hashFunction3;
                c37571.J$0 = j2;
                c37571.label = 2;
                toByteArray = SdkSourceKt.readToByteArray(sdkBuffer2, c37571);
                if (toByteArray != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = c37571.J$0;
            HashFunction hashFunction5 = (HashFunction) c37571.L$3;
            SdkBuffer sdkBuffer4 = (SdkBuffer) c37571.L$2;
            HashFunction hashFunction6 = (HashFunction) c37571.L$1;
            SdkByteReadChannel sdkByteReadChannel4 = (SdkByteReadChannel) c37571.L$0;
            ResultKt.throwOnFailure(toByteArray);
            c375712 = c37571;
            hashFunction2 = hashFunction6;
            sdkByteReadChannel3 = sdkByteReadChannel4;
            HashFunction hashFunction7 = hashFunction5;
            sdkBuffer = sdkBuffer4;
            HashFunction.update$default(hashFunction7, (byte[]) toByteArray, 0, 0, 6, null);
            sdkByteReadChannel2 = sdkByteReadChannel3;
            if (!sdkByteReadChannel2.isClosedForRead()) {
                c375712.L$0 = sdkByteReadChannel2;
                c375712.L$1 = hashFunction2;
                c375712.L$2 = sdkBuffer;
                c375712.L$3 = null;
                c375712.J$0 = j2;
                c375712.label = 1;
                if (sdkByteReadChannel2.read(sdkBuffer, j2, c375712) != coroutine_suspended) {
                    SdkBuffer sdkBuffer5 = sdkBuffer;
                    hashFunction3 = hashFunction2;
                    c37571 = c375712;
                    sdkBuffer2 = sdkBuffer5;
                    sdkByteReadChannel3 = sdkByteReadChannel2;
                    c37571.L$0 = sdkByteReadChannel3;
                    c37571.L$1 = hashFunction3;
                    c37571.L$2 = sdkBuffer2;
                    c37571.L$3 = hashFunction3;
                    c37571.J$0 = j2;
                    c37571.label = 2;
                    toByteArray = SdkSourceKt.readToByteArray(sdkBuffer2, c37571);
                    if (toByteArray != coroutine_suspended) {
                        hashFunction7 = hashFunction3;
                        sdkBuffer = sdkBuffer2;
                        c375712 = c37571;
                        hashFunction2 = hashFunction7;
                        HashFunction.update$default(hashFunction7, (byte[]) toByteArray, 0, 0, 6, null);
                        sdkByteReadChannel2 = sdkByteReadChannel3;
                        if (!sdkByteReadChannel2.isClosedForRead()) {
                            return hashFunction2.digest();
                        }
                    }
                }
                return coroutine_suspended;
            }
        }
    }

    public static /* synthetic */ Object rollingHash$default(SdkByteReadChannel sdkByteReadChannel, HashFunction hashFunction, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 8192;
        }
        return rollingHash(sdkByteReadChannel, hashFunction, j, continuation);
    }
}
