package aws.smithy.kotlin.runtime.content;

import androidx.media3.extractor.p007ts.PsExtractor;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import aws.smithy.kotlin.runtime.p011io.SdkSourceKt;
import aws.smithy.kotlin.runtime.p011io.internal.SdkDispatchers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ByteStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u0011\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0014\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u0017\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/ByteStream;", "", "toByteArray", "(Laws/smithy/kotlin/runtime/content/ByteStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "decodeToString", "", "cancel", "(Laws/smithy/kotlin/runtime/content/ByteStream;)V", "", "bufferSize", "Lkotlinx/coroutines/flow/Flow;", "toFlow", "(Laws/smithy/kotlin/runtime/content/ByteStream;J)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "contentLength", "toByteStream", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Long;)Laws/smithy/kotlin/runtime/content/ByteStream;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;J)Lkotlinx/coroutines/flow/Flow;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "(Laws/smithy/kotlin/runtime/io/SdkSource;J)Lkotlinx/coroutines/flow/Flow;", "asByteStream", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/content/ByteStream;", "([B)Laws/smithy/kotlin/runtime/content/ByteStream;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ByteStreamKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamKt$decodeToString$1 */
    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt", m1609f = "ByteStream.kt", m1610i = {0}, m1611l = {101}, m1612m = "decodeToString", m1613n = {"$this$decodeToString"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C36841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C36841(Continuation<? super C36841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteStreamKt.decodeToString(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamKt$toByteArray$1 */
    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt", m1609f = "ByteStream.kt", m1610i = {0, 0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA9_4, 98}, m1612m = "toByteArray", m1613n = {"$this$toByteArray", "stream", "chan", "$this$toByteArray", "stream"}, m1614nl = {PDFACompliance.e_PDFA9_5, 99}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, m1616v = 2)
    static final class C36851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36851(Continuation<? super C36851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteStreamKt.toByteArray(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteStream byteStream, Continuation<? super byte[]> continuation) throws IOException {
        C36851 c36851;
        SdkByteReadChannel sdkByteReadChannel;
        if (continuation instanceof C36851) {
            c36851 = (C36851) continuation;
            if ((c36851.label & Integer.MIN_VALUE) != 0) {
                c36851.label -= Integer.MIN_VALUE;
            } else {
                c36851 = new C36851(continuation);
            }
        }
        Object obj = c36851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteStream instanceof ByteStream.Buffer) {
                return ((ByteStream.Buffer) byteStream).getAsBytes();
            }
            if (byteStream instanceof ByteStream.ChannelStream) {
                SdkByteReadChannel from = ((ByteStream.ChannelStream) byteStream).readFrom();
                c36851.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
                c36851.L$1 = SpillingKt.nullOutSpilledVariable(byteStream);
                c36851.L$2 = from;
                c36851.label = 1;
                Object toBuffer = SdkByteReadChannelKt.readToBuffer(from, c36851);
                if (toBuffer != coroutine_suspended) {
                    obj = toBuffer;
                    sdkByteReadChannel = from;
                }
            } else {
                if (!(byteStream instanceof ByteStream.SourceStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                SdkSource from2 = ((ByteStream.SourceStream) byteStream).readFrom();
                c36851.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
                c36851.L$1 = SpillingKt.nullOutSpilledVariable(byteStream);
                c36851.label = 2;
                Object toByteArray = SdkSourceKt.readToByteArray(from2, c36851);
                if (toByteArray != coroutine_suspended) {
                    return toByteArray;
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        sdkByteReadChannel = (SdkByteReadChannel) c36851.L$2;
        ResultKt.throwOnFailure(obj);
        byte[] byteArray = ((SdkBuffer) obj).readByteArray();
        if (sdkByteReadChannel.isClosedForRead()) {
            return byteArray;
        }
        throw new IllegalStateException("failed to read all bytes from ByteStream, more data still expected".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object decodeToString(ByteStream byteStream, Continuation<? super String> continuation) throws IOException {
        C36841 c36841;
        if (continuation instanceof C36841) {
            c36841 = (C36841) continuation;
            if ((c36841.label & Integer.MIN_VALUE) != 0) {
                c36841.label -= Integer.MIN_VALUE;
            } else {
                c36841 = new C36841(continuation);
            }
        }
        Object byteArray = c36841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(byteArray);
            c36841.L$0 = SpillingKt.nullOutSpilledVariable(byteStream);
            c36841.label = 1;
            byteArray = toByteArray(byteStream, c36841);
            if (byteArray == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(byteArray);
        }
        return StringsKt.decodeToString((byte[]) byteArray);
    }

    public static final void cancel(ByteStream byteStream) throws IOException {
        Intrinsics.checkNotNullParameter(byteStream, "<this>");
        if (byteStream instanceof ByteStream.Buffer) {
            ((ByteStream.Buffer) byteStream).getAsBytes();
        } else if (byteStream instanceof ByteStream.ChannelStream) {
            ((ByteStream.ChannelStream) byteStream).readFrom().cancel(null);
        } else {
            if (!(byteStream instanceof ByteStream.SourceStream)) {
                throw new NoWhenBranchMatchedException();
            }
            ((ByteStream.SourceStream) byteStream).readFrom().close();
        }
    }

    public static /* synthetic */ Flow toFlow$default(ByteStream byteStream, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 8192;
        }
        return toFlow(byteStream, j);
    }

    public static final Flow<byte[]> toFlow(ByteStream byteStream, long j) {
        Intrinsics.checkNotNullParameter(byteStream, "<this>");
        if (byteStream instanceof ByteStream.Buffer) {
            return FlowKt.flowOf(((ByteStream.Buffer) byteStream).getAsBytes());
        }
        if (byteStream instanceof ByteStream.ChannelStream) {
            return toFlow(((ByteStream.ChannelStream) byteStream).readFrom(), j);
        }
        if (byteStream instanceof ByteStream.SourceStream) {
            return FlowKt.flowOn(toFlow(((ByteStream.SourceStream) byteStream).readFrom(), j), SdkDispatchers.INSTANCE.getIO());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ ByteStream toByteStream$default(Flow flow, CoroutineScope coroutineScope, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return toByteStream(flow, coroutineScope, l);
    }

    public static final ByteStream toByteStream(Flow<byte[]> flow, CoroutineScope scope, Long l) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final SdkByteChannel sdkByteChannelSdkByteChannel$default = SdkByteChannelKt.SdkByteChannel$default(true, 0, 2, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ByteStreamKt$toByteStream$job$1(flow, l, new Ref.LongRef(), sdkByteChannelSdkByteChannel$default, null), 3, null).invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.content.ByteStreamKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteStreamKt.toByteStream$lambda$0(sdkByteChannelSdkByteChannel$default, (Throwable) obj);
            }
        });
        return new ByteStream.ChannelStream(l, sdkByteChannelSdkByteChannel$default) { // from class: aws.smithy.kotlin.runtime.content.ByteStreamKt.toByteStream.2
            final /* synthetic */ SdkByteChannel $ch;
            private final Long contentLength;
            private final boolean isOneShot = true;

            {
                this.$ch = sdkByteChannelSdkByteChannel$default;
                this.contentLength = l;
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
                return this.$ch;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toByteStream$lambda$0(SdkByteChannel sdkByteChannel, Throwable th) {
        sdkByteChannel.close(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamKt$toFlow$1 */
    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt$toFlow$1", m1609f = "ByteStream.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2}, m1611l = {172, 176, SensibleDefaults.X_OFFSET}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "chan", "sink", "$this$flow", "chan", "sink", "bytes", "rc", "$this$flow", "chan", "sink"}, m1614nl = {PDFACompliance.e_PDFA1_7_3, 179, PDFACompliance.e_PDFA1_8_2}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36881 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $bufferSize;
        final /* synthetic */ SdkByteReadChannel $this_toFlow;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36881(SdkByteReadChannel sdkByteReadChannel, long j, Continuation<? super C36881> continuation) {
            super(2, continuation);
            this.$this_toFlow = sdkByteReadChannel;
            this.$bufferSize = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C36881 c36881 = new C36881(this.$this_toFlow, this.$bufferSize, continuation);
            c36881.L$0 = obj;
            return c36881;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super byte[]> flowCollector, Continuation<? super Unit> continuation) {
            return ((C36881) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d6, code lost:
        
            if (r1.emit(r8.readByteArray(), r16) == r2) goto L29;
         */
        /* JADX WARN: Path cross not found for [B:22:0x008d, B:13:0x005b], limit reached: 30 */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00ab A[PHI: r3 r8
          0x00ab: PHI (r3v2 aws.smithy.kotlin.runtime.io.SdkByteReadChannel) = (r3v5 aws.smithy.kotlin.runtime.io.SdkByteReadChannel), (r3v6 aws.smithy.kotlin.runtime.io.SdkByteReadChannel) binds: [B:19:0x0081, B:14:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x00ab: PHI (r8v1 aws.smithy.kotlin.runtime.io.SdkBuffer) = (r8v2 aws.smithy.kotlin.runtime.io.SdkBuffer), (r8v3 aws.smithy.kotlin.runtime.io.SdkBuffer) binds: [B:19:0x0081, B:14:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:13:0x005b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a8 -> B:13:0x005b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IOException {
            SdkByteReadChannel sdkByteReadChannel;
            SdkBuffer sdkBuffer;
            Object obj2;
            long jLongValue;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sdkByteReadChannel = this.$this_toFlow;
                sdkBuffer = new SdkBuffer();
            } else {
                if (i == 1) {
                    SdkBuffer sdkBuffer2 = (SdkBuffer) this.L$2;
                    SdkByteReadChannel sdkByteReadChannel2 = (SdkByteReadChannel) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    sdkBuffer = sdkBuffer2;
                    sdkByteReadChannel = sdkByteReadChannel2;
                    obj2 = obj;
                    jLongValue = ((Number) obj2).longValue();
                    if (jLongValue == -1) {
                        long size = sdkBuffer.getSize();
                        long j = this.$bufferSize;
                        if (size >= j) {
                            byte[] byteArray = sdkBuffer.readByteArray(j);
                            this.L$0 = flowCollector;
                            this.L$1 = sdkByteReadChannel;
                            this.L$2 = sdkBuffer;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(byteArray);
                            this.J$0 = jLongValue;
                            this.label = 2;
                            if (flowCollector.emit(byteArray, this) != coroutine_suspended) {
                            }
                        }
                    } else {
                        if (sdkBuffer.getSize() > 0) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                            this.L$3 = null;
                            this.label = 3;
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                SdkBuffer sdkBuffer3 = (SdkBuffer) this.L$2;
                SdkByteReadChannel sdkByteReadChannel3 = (SdkByteReadChannel) this.L$1;
                ResultKt.throwOnFailure(obj);
                sdkBuffer = sdkBuffer3;
                sdkByteReadChannel = sdkByteReadChannel3;
            }
            if (!sdkByteReadChannel.isClosedForRead()) {
                this.L$0 = flowCollector;
                this.L$1 = sdkByteReadChannel;
                this.L$2 = sdkBuffer;
                this.L$3 = null;
                this.label = 1;
                obj2 = sdkByteReadChannel.read(sdkBuffer, this.$bufferSize, this);
                if (obj2 != coroutine_suspended) {
                    jLongValue = ((Number) obj2).longValue();
                    if (jLongValue == -1) {
                    }
                }
            }
            return coroutine_suspended;
        }
    }

    private static final Flow<byte[]> toFlow(SdkByteReadChannel sdkByteReadChannel, long j) {
        return FlowKt.flow(new C36881(sdkByteReadChannel, j, null));
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamKt$toFlow$2 */
    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt$toFlow$2", m1609f = "ByteStream.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1}, m1611l = {PsExtractor.AUDIO_STREAM, 196}, m1612m = "invokeSuspend", m1613n = {"$this$flow", FirebaseAnalytics.Param.SOURCE, "sink", "bytes", "rc", "$this$flow", FirebaseAnalytics.Param.SOURCE, "sink"}, m1614nl = {195, 198}, m1615s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36892 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $bufferSize;
        final /* synthetic */ SdkSource $this_toFlow;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36892(SdkSource sdkSource, long j, Continuation<? super C36892> continuation) {
            super(2, continuation);
            this.$this_toFlow = sdkSource;
            this.$bufferSize = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C36892 c36892 = new C36892(this.$this_toFlow, this.$bufferSize, continuation);
            c36892.L$0 = obj;
            return c36892;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super byte[]> flowCollector, Continuation<? super Unit> continuation) {
            return ((C36892) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        
            if (r0.emit(r2.readByteArray(), r12) == r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IOException {
            SdkBuffer sdkBuffer;
            SdkSource sdkSource;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SdkSource sdkSource2 = this.$this_toFlow;
                sdkBuffer = new SdkBuffer();
                sdkSource = sdkSource2;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                sdkBuffer = (SdkBuffer) this.L$2;
                sdkSource = (SdkSource) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            while (true) {
                long j = sdkSource.read(sdkBuffer, this.$bufferSize);
                if (j != -1) {
                    long size = sdkBuffer.getSize();
                    long j2 = this.$bufferSize;
                    if (size >= j2) {
                        byte[] byteArray = sdkBuffer.readByteArray(j2);
                        this.L$0 = flowCollector;
                        this.L$1 = sdkSource;
                        this.L$2 = sdkBuffer;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(byteArray);
                        this.J$0 = j;
                        this.label = 1;
                        if (flowCollector.emit(byteArray, this) == coroutine_suspended) {
                            break;
                        }
                    }
                } else if (sdkBuffer.getSize() > 0) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(sdkSource);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                    this.L$3 = null;
                    this.label = 2;
                }
            }
            return coroutine_suspended;
        }
    }

    private static final Flow<byte[]> toFlow(SdkSource sdkSource, long j) {
        return FlowKt.flow(new C36892(sdkSource, j, null));
    }

    public static final ByteStream asByteStream(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return ByteStream.INSTANCE.fromString(str);
    }

    public static final ByteStream asByteStream(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ByteStream.INSTANCE.fromBytes(bArr);
    }
}
