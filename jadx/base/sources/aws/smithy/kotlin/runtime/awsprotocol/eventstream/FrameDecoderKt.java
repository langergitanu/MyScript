package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FrameDecoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005¨\u0006\b"}, m1599d2 = {"decodeFrames", "Lkotlinx/coroutines/flow/Flow;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "chan", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPrelude", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FrameDecoderKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameDecoderKt$readPrelude$1 */
    /* JADX INFO: compiled from: FrameDecoder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameDecoderKt", m1609f = "FrameDecoder.kt", m1610i = {0, 0, 0}, m1611l = {50}, m1612m = "readPrelude", m1613n = {"chan", "dest", "remaining"}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1615s = {"L$0", "L$1", "J$0"}, m1616v = 2)
    static final class C36631 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C36631(Continuation<? super C36631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FrameDecoderKt.readPrelude(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameDecoderKt$decodeFrames$2 */
    /* JADX INFO: compiled from: FrameDecoder.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameDecoderKt$decodeFrames$2", m1609f = "FrameDecoder.kt", m1610i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m1611l = {27, 32, 38}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$flow", "messageBuf", "prelude", "limit", "$this$flow", "messageBuf", "prelude", "message", "limit"}, m1614nl = {28, 33, 40}, m1615s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
    static final class C36622 extends SuspendLambda implements Function2<FlowCollector<? super Message>, Continuation<? super Unit>, Object> {
        final /* synthetic */ SdkByteReadChannel $chan;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36622(SdkByteReadChannel sdkByteReadChannel, Continuation<? super C36622> continuation) {
            super(2, continuation);
            this.$chan = sdkByteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C36622 c36622 = new C36622(this.$chan, continuation);
            c36622.L$0 = obj;
            return c36622;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Message> flowCollector, Continuation<? super Unit> continuation) {
            return ((C36622) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00bc -> B:17:0x0042). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IOException {
            SdkBuffer sdkBuffer;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    sdkBuffer = (SdkBuffer) obj;
                    if (sdkBuffer != null) {
                    }
                } else {
                    if (i == 2) {
                        int totalLen = this.I$0;
                        Prelude preludeDecode = (Prelude) this.L$2;
                        sdkBuffer = (SdkBuffer) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Message messageDecode = Message.INSTANCE.decode(sdkBuffer);
                            this.L$0 = flowCollector;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(preludeDecode);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(messageDecode);
                            this.I$0 = totalLen;
                            this.label = 3;
                            if (flowCollector.emit(messageDecode, this) != coroutine_suspended) {
                                if (this.$chan.isClosedForRead()) {
                                    this.L$0 = flowCollector;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.label = 1;
                                    obj = FrameDecoderKt.readPrelude(this.$chan, this);
                                    if (obj != coroutine_suspended) {
                                        sdkBuffer = (SdkBuffer) obj;
                                        if (sdkBuffer != null) {
                                            return Unit.INSTANCE;
                                        }
                                        preludeDecode = Prelude.INSTANCE.decode(sdkBuffer.peek());
                                        totalLen = preludeDecode.getTotalLen() - 12;
                                        this.L$0 = flowCollector;
                                        this.L$1 = sdkBuffer;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(preludeDecode);
                                        this.I$0 = totalLen;
                                        this.label = 2;
                                        if (SdkByteReadChannelKt.readFully(this.$chan, sdkBuffer, totalLen, this) != coroutine_suspended) {
                                            Message messageDecode2 = Message.INSTANCE.decode(sdkBuffer);
                                            this.L$0 = flowCollector;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(preludeDecode);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(messageDecode2);
                                            this.I$0 = totalLen;
                                            this.label = 3;
                                            if (flowCollector.emit(messageDecode2, this) != coroutine_suspended) {
                                            }
                                        }
                                    }
                                } else {
                                    return Unit.INSTANCE;
                                }
                            }
                            return coroutine_suspended;
                        } catch (Exception e) {
                            throw new EventStreamFramingException("failed to read message from channel", e);
                        }
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            if (this.$chan.isClosedForRead()) {
            }
        }
    }

    @InternalApi
    public static final Object decodeFrames(SdkByteReadChannel sdkByteReadChannel, Continuation<? super Flow<Message>> continuation) {
        return FlowKt.flow(new C36622(sdkByteReadChannel, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0067 -> B:23:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readPrelude(SdkByteReadChannel sdkByteReadChannel, Continuation<? super SdkBuffer> continuation) {
        C36631 c36631;
        SdkBuffer sdkBuffer;
        long j;
        SdkByteReadChannel sdkByteReadChannel2;
        Object obj;
        if (continuation instanceof C36631) {
            c36631 = (C36631) continuation;
            if ((c36631.label & Integer.MIN_VALUE) != 0) {
                c36631.label -= Integer.MIN_VALUE;
            } else {
                c36631 = new C36631(continuation);
            }
        }
        Object obj2 = c36631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            sdkBuffer = new SdkBuffer();
            j = 12;
            sdkByteReadChannel2 = sdkByteReadChannel;
            if (j > 0) {
                c36631.L$0 = sdkByteReadChannel2;
                c36631.L$1 = sdkBuffer;
                c36631.J$0 = j;
                c36631.label = 1;
                obj = sdkByteReadChannel2.read(sdkBuffer, j, c36631);
                if (obj != coroutine_suspended) {
                }
            }
            if (j != 12) {
            }
            if (j > 0) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c36631.J$0;
            sdkBuffer = (SdkBuffer) c36631.L$1;
            SdkByteReadChannel sdkByteReadChannel3 = (SdkByteReadChannel) c36631.L$0;
            ResultKt.throwOnFailure(obj2);
            long jLongValue = ((Number) obj2).longValue();
            if (jLongValue == -1) {
                j -= jLongValue;
                sdkByteReadChannel2 = sdkByteReadChannel3;
                if (j > 0 && !sdkByteReadChannel2.isClosedForRead()) {
                    c36631.L$0 = sdkByteReadChannel2;
                    c36631.L$1 = sdkBuffer;
                    c36631.J$0 = j;
                    c36631.label = 1;
                    obj = sdkByteReadChannel2.read(sdkBuffer, j, c36631);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sdkByteReadChannel3 = sdkByteReadChannel2;
                    obj2 = obj;
                    long jLongValue2 = ((Number) obj2).longValue();
                    if (jLongValue2 == -1) {
                        sdkByteReadChannel2 = sdkByteReadChannel3;
                    }
                }
                if (j != 12 && sdkByteReadChannel2.isClosedForRead()) {
                    return null;
                }
                if (j > 0) {
                    return sdkBuffer;
                }
                throw new EventStreamFramingException("failed to read event stream message prelude from channel: read: " + sdkBuffer.getSize() + " bytes, expected " + j + " more bytes", null, 2, null);
            }
        }
    }
}
