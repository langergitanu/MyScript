package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.PlannedRemoval;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannelKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: FrameEncoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007\u001a \u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0087@¢\u0006\u0002\u0010\b\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"encode", "Lkotlinx/coroutines/flow/Flow;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", "asEventStreamHttpBody", "Laws/smithy/kotlin/runtime/http/HttpBody;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FrameEncoderKt {
    @PlannedRemoval(major = 1, minor = 7)
    @Deprecated(message = "This overload takes a `CoroutineScope` argument which is now ignored. This overload will be removed in minor version 1.7.", replaceWith = @ReplaceWith(expression = "asEventStreamHttpBody()", imports = {}))
    @InternalApi
    public static final Object asEventStreamHttpBody(Flow<SdkBuffer> flow, CoroutineScope coroutineScope, Continuation<? super HttpBody> continuation) {
        return asEventStreamHttpBody(flow, continuation);
    }

    @InternalApi
    public static final Object asEventStreamHttpBody(Flow<SdkBuffer> flow, Continuation<? super HttpBody> continuation) {
        return new C36643(continuation.get$context(), SdkByteChannelKt.SdkByteChannel$default(true, 0, 2, null), flow);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$asEventStreamHttpBody$3 */
    /* JADX INFO: compiled from: FrameEncoder.kt */
    @Metadata(m1598d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"aws/smithy/kotlin/runtime/awsprotocol/eventstream/FrameEncoderKt$asEventStreamHttpBody$3", "Laws/smithy/kotlin/runtime/http/HttpBody$ChannelContent;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isOneShot", "", "()Z", "isDuplex", "job", "Lkotlinx/coroutines/Job;", "readFrom", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "aws-event-stream"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C36643 extends HttpBody.ChannelContent {
        final /* synthetic */ SdkByteChannel $ch;
        final /* synthetic */ CoroutineContext $ctx;
        final /* synthetic */ Flow<SdkBuffer> $encodedMessages;
        private final Long contentLength;
        private Job job;
        private final boolean isOneShot = true;
        private final boolean isDuplex = true;

        C36643(CoroutineContext coroutineContext, SdkByteChannel sdkByteChannel, Flow<SdkBuffer> flow) {
            this.$ctx = coroutineContext;
            this.$ch = sdkByteChannel;
            this.$encodedMessages = flow;
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

        @Override // aws.smithy.kotlin.runtime.http.HttpBody
        /* JADX INFO: renamed from: isDuplex, reason: from getter */
        public boolean getIsDuplex() {
            return this.isDuplex;
        }

        @Override // aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent
        /* JADX INFO: renamed from: readFrom */
        public SdkByteReadChannel get$ch() {
            if (this.job == null) {
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.$ctx), null, null, new FrameEncoderKt$asEventStreamHttpBody$3$readFrom$1(this.$encodedMessages, this.$ch, null), 3, null);
                this.job = jobLaunch$default;
                if (jobLaunch$default != null) {
                    final SdkByteChannel sdkByteChannel = this.$ch;
                    jobLaunch$default.invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$asEventStreamHttpBody$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FrameEncoderKt.C36643.readFrom$lambda$0(sdkByteChannel, (Throwable) obj);
                        }
                    });
                }
            }
            return this.$ch;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit readFrom$lambda$0(SdkByteChannel sdkByteChannel, Throwable th) {
            sdkByteChannel.close(th);
            return Unit.INSTANCE;
        }
    }

    @InternalApi
    public static final Flow<SdkBuffer> encode(final Flow<Message> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return new Flow<SdkBuffer>() { // from class: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$encode$$inlined$map$1

            /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$encode$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final class C36662<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$encode$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameEncoderKt$encode$$inlined$map$1$2", m1609f = "FrameEncoder.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {50}, m1612m = "emit", m1613n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m1614nl = {49}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C36662.this.emit(null, this);
                    }
                }

                public C36662(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) throws IOException {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        SdkBuffer sdkBuffer = new SdkBuffer();
                        ((Message) obj).encode(sdkBuffer);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(sdkBuffer, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SdkBuffer> flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new C36662(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }
}
