package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: FrameEncoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1", m1609f = "FrameEncoder.kt", m1610i = {}, m1611l = {65}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {68}, m1615s = {}, m1616v = 2)
final class FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SdkByteChannel $ch;
    final /* synthetic */ Flow<SdkBuffer> $encodedMessages;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1(Flow<SdkBuffer> flow, SdkByteChannel sdkByteChannel, Continuation<? super FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1> continuation) {
        super(2, continuation);
        this.$encodedMessages = flow;
        this.$ch = sdkByteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1(this.$encodedMessages, this.$ch, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<SdkBuffer> flow = this.$encodedMessages;
            final SdkByteChannel sdkByteChannel = this.$ch;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((SdkBuffer) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(SdkBuffer sdkBuffer, Continuation<? super Unit> continuation) {
                    Object objWrite$default = SdkByteWriteChannel.write$default(sdkByteChannel, sdkBuffer, 0L, continuation, 2, null);
                    return objWrite$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrite$default : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
