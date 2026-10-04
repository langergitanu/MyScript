package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignatureType;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignedBodyHeader;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAlgorithm;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningResult;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.HeaderValue;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: EventStreamSigning.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a:\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0080@¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\t*\u00020\u0004H\u0002¨\u0006\u0013"}, m1599d2 = {"sign", "Lkotlinx/coroutines/flow/Flow;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "signPayload", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningResult;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "configBuilder", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "prevSignature", "", "messagePayload", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;[B[BLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "truncateSubsecs", "Laws/smithy/kotlin/runtime/time/Instant;", "newEventStreamSigningConfig", "aws-event-stream"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EventStreamSigningKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$signPayload$1 */
    /* JADX INFO: compiled from: EventStreamSigning.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt", m1609f = "EventStreamSigning.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "signPayload", m1613n = {"$this$signPayload", "configBuilder", "prevSignature", "messagePayload", "clock", "dt", "config"}, m1614nl = {77}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, m1616v = 2)
    static final class C36611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C36611(Continuation<? super C36611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventStreamSigningKt.signPayload(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$sign$1 */
    /* JADX INFO: compiled from: EventStreamSigning.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Laws/smithy/kotlin/runtime/awsprotocol/eventstream/Message;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$sign$1", m1609f = "EventStreamSigning.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, m1611l = {44, 49, 63, 64}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "messages", "signer", "initialSignature", "credentialsProvider", "prevSignature", "$this$flow", "messages", "signer", "initialSignature", "credentialsProvider", "prevSignature", "configBuilder", "$this$flow", "messages", "signer", "initialSignature", "credentialsProvider", "prevSignature", "configBuilder", "$this$flow", "messages", "signer", "initialSignature", "credentialsProvider", "prevSignature", "configBuilder", "endFrame"}, m1614nl = {47, 63, 64, 65}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, m1616v = 2)
    static final class C36601 extends SuspendLambda implements Function2<FlowCollector<? super Message>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExecutionContext $context;
        final /* synthetic */ Flow<Message> $this_sign;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36601(Flow<Message> flow, ExecutionContext executionContext, Continuation<? super C36601> continuation) {
            super(2, continuation);
            this.$this_sign = flow;
            this.$context = executionContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C36601 c36601 = new C36601(this.$this_sign, this.$context, continuation);
            c36601.L$0 = obj;
            return c36601;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Message> flowCollector, Continuation<? super Unit> continuation) {
            return ((C36601) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x01c4, code lost:
        
            if (r7.emit(r2.getOutput(), r21) != r1) goto L35;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0183  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CredentialsProvider credentialsProvider;
            Ref.ObjectRef objectRef;
            Flow<Message> flow;
            CompletableDeferred completableDeferred;
            AwsSigner awsSigner;
            Ref.ObjectRef objectRef2;
            T t;
            AwsSigningConfig.Builder builder;
            AwsSigner awsSigner2;
            Ref.ObjectRef objectRef3;
            CompletableDeferred completableDeferred2;
            Flow<Message> flow2;
            Object objSignPayload$default;
            Flow<Message> flow3;
            AwsSigner awsSigner3;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Message> flow4 = this.$this_sign;
                AwsSigner awsSigner4 = (AwsSigner) this.$context.getOrNull(AwsSigningAttributes.INSTANCE.getSigner());
                if (awsSigner4 == null) {
                    throw new IllegalStateException("No signer was found in context".toString());
                }
                CompletableDeferred completableDeferred3 = (CompletableDeferred) this.$context.getOrNull(AwsSigningAttributes.INSTANCE.getRequestSignature());
                if (completableDeferred3 == null) {
                    throw new IllegalStateException("expected initial HTTP signature deferred to be set before message signing commences".toString());
                }
                credentialsProvider = (CredentialsProvider) this.$context.getOrNull(AwsSigningAttributes.INSTANCE.getCredentialsProvider());
                if (credentialsProvider == null) {
                    throw new IllegalStateException("No credentials provider was found in context".toString());
                }
                objectRef = new Ref.ObjectRef();
                this.L$0 = flowCollector;
                this.L$1 = flow4;
                this.L$2 = awsSigner4;
                this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred3);
                this.L$4 = credentialsProvider;
                this.L$5 = objectRef;
                this.L$6 = objectRef;
                this.label = 1;
                Object objAwait = completableDeferred3.await(this);
                if (objAwait != coroutine_suspended) {
                    flow = flow4;
                    completableDeferred = completableDeferred3;
                    awsSigner = awsSigner4;
                    objectRef2 = objectRef;
                    t = objAwait;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                objectRef = (Ref.ObjectRef) this.L$6;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.L$5;
                credentialsProvider = (CredentialsProvider) this.L$4;
                CompletableDeferred completableDeferred4 = (CompletableDeferred) this.L$3;
                AwsSigner awsSigner5 = (AwsSigner) this.L$2;
                Flow<Message> flow5 = (Flow) this.L$1;
                ResultKt.throwOnFailure(obj);
                flow = flow5;
                completableDeferred = completableDeferred4;
                awsSigner = awsSigner5;
                objectRef2 = objectRef4;
                t = obj;
            } else {
                if (i == 2) {
                    AwsSigningConfig.Builder builder2 = (AwsSigningConfig.Builder) this.L$6;
                    objectRef3 = (Ref.ObjectRef) this.L$5;
                    credentialsProvider = (CredentialsProvider) this.L$4;
                    completableDeferred2 = (CompletableDeferred) this.L$3;
                    AwsSigner awsSigner6 = (AwsSigner) this.L$2;
                    flow2 = (Flow) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    builder = builder2;
                    awsSigner2 = awsSigner6;
                    this.L$0 = flowCollector;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(flow2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(awsSigner2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(objectRef3);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                    this.label = 3;
                    objSignPayload$default = EventStreamSigningKt.signPayload$default(awsSigner2, builder, (byte[]) objectRef3.element, new byte[0], null, this, 8, null);
                    if (objSignPayload$default != coroutine_suspended) {
                        flow3 = flow2;
                        awsSigner3 = awsSigner2;
                        AwsSigningResult awsSigningResult = (AwsSigningResult) objSignPayload$default;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(flow3);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(awsSigner3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(objectRef3);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(awsSigningResult);
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                AwsSigningConfig.Builder builder3 = (AwsSigningConfig.Builder) this.L$6;
                objectRef3 = (Ref.ObjectRef) this.L$5;
                credentialsProvider = (CredentialsProvider) this.L$4;
                completableDeferred2 = (CompletableDeferred) this.L$3;
                awsSigner3 = (AwsSigner) this.L$2;
                flow3 = (Flow) this.L$1;
                ResultKt.throwOnFailure(obj);
                builder = builder3;
                objSignPayload$default = obj;
                AwsSigningResult awsSigningResult2 = (AwsSigningResult) objSignPayload$default;
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(flow3);
                this.L$2 = SpillingKt.nullOutSpilledVariable(awsSigner3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
                this.L$5 = SpillingKt.nullOutSpilledVariable(objectRef3);
                this.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                this.L$7 = SpillingKt.nullOutSpilledVariable(awsSigningResult2);
                this.label = 4;
            }
            objectRef.element = t;
            AwsSigningConfig.Builder builderNewEventStreamSigningConfig = EventStreamSigningKt.newEventStreamSigningConfig(this.$context);
            this.L$0 = flowCollector;
            this.L$1 = SpillingKt.nullOutSpilledVariable(flow);
            this.L$2 = awsSigner;
            this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred);
            this.L$4 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
            this.L$5 = objectRef2;
            this.L$6 = builderNewEventStreamSigningConfig;
            this.label = 2;
            if (flow.collect(new AnonymousClass1(builderNewEventStreamSigningConfig, credentialsProvider, awsSigner, objectRef2, flowCollector), this) != coroutine_suspended) {
                builder = builderNewEventStreamSigningConfig;
                awsSigner2 = awsSigner;
                objectRef3 = objectRef2;
                completableDeferred2 = completableDeferred;
                flow2 = flow;
                this.L$0 = flowCollector;
                this.L$1 = SpillingKt.nullOutSpilledVariable(flow2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(awsSigner2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(completableDeferred2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
                this.L$5 = SpillingKt.nullOutSpilledVariable(objectRef3);
                this.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                this.label = 3;
                objSignPayload$default = EventStreamSigningKt.signPayload$default(awsSigner2, builder, (byte[]) objectRef3.element, new byte[0], null, this, 8, null);
                if (objSignPayload$default != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$sign$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: EventStreamSigning.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Message> $$this$flow;
            final /* synthetic */ AwsSigningConfig.Builder $configBuilder;
            final /* synthetic */ CredentialsProvider $credentialsProvider;
            final /* synthetic */ Ref.ObjectRef<byte[]> $prevSignature;
            final /* synthetic */ AwsSigner $signer;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(AwsSigningConfig.Builder builder, CredentialsProvider credentialsProvider, AwsSigner awsSigner, Ref.ObjectRef<byte[]> objectRef, FlowCollector<? super Message> flowCollector) {
                this.$configBuilder = builder;
                this.$credentialsProvider = credentialsProvider;
                this.$signer = awsSigner;
                this.$prevSignature = objectRef;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x00ed, code lost:
            
                if (r2.emit((aws.smithy.kotlin.runtime.awsprotocol.eventstream.Message) r3, r6) != r0) goto L29;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Message message, Continuation<? super Unit> continuation) throws IOException {
                EventStreamSigningKt$sign$1$1$emit$1 eventStreamSigningKt$sign$1$1$emit$1;
                SdkBuffer sdkBuffer;
                Object objResolve$default;
                Message message2;
                AwsSigningConfig.Builder builder;
                SdkBuffer sdkBuffer2;
                Message message3;
                if (continuation instanceof EventStreamSigningKt$sign$1$1$emit$1) {
                    eventStreamSigningKt$sign$1$1$emit$1 = (EventStreamSigningKt$sign$1$1$emit$1) continuation;
                    if ((eventStreamSigningKt$sign$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        eventStreamSigningKt$sign$1$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        eventStreamSigningKt$sign$1$1$emit$1 = new EventStreamSigningKt$sign$1$1$emit$1(this, continuation);
                    }
                }
                EventStreamSigningKt$sign$1$1$emit$1 eventStreamSigningKt$sign$1$1$emit$12 = eventStreamSigningKt$sign$1$1$emit$1;
                Object obj = eventStreamSigningKt$sign$1$1$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = eventStreamSigningKt$sign$1$1$emit$12.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    sdkBuffer = new SdkBuffer();
                    message.encode(sdkBuffer);
                    AwsSigningConfig.Builder builder2 = this.$configBuilder;
                    CredentialsProvider credentialsProvider = this.$credentialsProvider;
                    eventStreamSigningKt$sign$1$1$emit$12.L$0 = SpillingKt.nullOutSpilledVariable(message);
                    eventStreamSigningKt$sign$1$1$emit$12.L$1 = sdkBuffer;
                    eventStreamSigningKt$sign$1$1$emit$12.L$2 = builder2;
                    eventStreamSigningKt$sign$1$1$emit$12.label = 1;
                    objResolve$default = IdentityProvider.resolve$default(credentialsProvider, null, eventStreamSigningKt$sign$1$1$emit$12, 1, null);
                    if (objResolve$default != coroutine_suspended) {
                        message2 = message;
                        builder = builder2;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    builder = (AwsSigningConfig.Builder) eventStreamSigningKt$sign$1$1$emit$12.L$2;
                    SdkBuffer sdkBuffer3 = (SdkBuffer) eventStreamSigningKt$sign$1$1$emit$12.L$1;
                    Message message4 = (Message) eventStreamSigningKt$sign$1$1$emit$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    message2 = message4;
                    objResolve$default = obj;
                    sdkBuffer = sdkBuffer3;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    sdkBuffer2 = (SdkBuffer) eventStreamSigningKt$sign$1$1$emit$12.L$1;
                    message3 = (Message) eventStreamSigningKt$sign$1$1$emit$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    AwsSigningResult awsSigningResult = (AwsSigningResult) obj;
                    this.$prevSignature.element = (T) awsSigningResult.getSignature();
                    FlowCollector<Message> flowCollector = this.$$this$flow;
                    Object output = awsSigningResult.getOutput();
                    eventStreamSigningKt$sign$1$1$emit$12.L$0 = SpillingKt.nullOutSpilledVariable(message3);
                    eventStreamSigningKt$sign$1$1$emit$12.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer2);
                    eventStreamSigningKt$sign$1$1$emit$12.L$2 = SpillingKt.nullOutSpilledVariable(awsSigningResult);
                    eventStreamSigningKt$sign$1$1$emit$12.label = 3;
                }
                builder.setCredentials((Credentials) objResolve$default);
                AwsSigner awsSigner = this.$signer;
                AwsSigningConfig.Builder builder3 = this.$configBuilder;
                byte[] bArr = this.$prevSignature.element;
                byte[] byteArray = sdkBuffer.readByteArray();
                eventStreamSigningKt$sign$1$1$emit$12.L$0 = SpillingKt.nullOutSpilledVariable(message2);
                eventStreamSigningKt$sign$1$1$emit$12.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
                eventStreamSigningKt$sign$1$1$emit$12.L$2 = null;
                eventStreamSigningKt$sign$1$1$emit$12.label = 2;
                Object objSignPayload$default = EventStreamSigningKt.signPayload$default(awsSigner, builder3, bArr, byteArray, null, eventStreamSigningKt$sign$1$1$emit$12, 8, null);
                if (objSignPayload$default != coroutine_suspended) {
                    SdkBuffer sdkBuffer4 = sdkBuffer;
                    obj = objSignPayload$default;
                    sdkBuffer2 = sdkBuffer4;
                    message3 = message2;
                    AwsSigningResult awsSigningResult2 = (AwsSigningResult) obj;
                    this.$prevSignature.element = (T) awsSigningResult2.getSignature();
                    FlowCollector<Message> flowCollector2 = this.$$this$flow;
                    Object output2 = awsSigningResult2.getOutput();
                    eventStreamSigningKt$sign$1$1$emit$12.L$0 = SpillingKt.nullOutSpilledVariable(message3);
                    eventStreamSigningKt$sign$1$1$emit$12.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer2);
                    eventStreamSigningKt$sign$1$1$emit$12.L$2 = SpillingKt.nullOutSpilledVariable(awsSigningResult2);
                    eventStreamSigningKt$sign$1$1$emit$12.label = 3;
                }
                return coroutine_suspended;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Message) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    @InternalApi
    public static final Flow<Message> sign(Flow<Message> flow, ExecutionContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowKt.flow(new C36601(flow, context, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object signPayload(AwsSigner awsSigner, AwsSigningConfig.Builder builder, byte[] bArr, final byte[] bArr2, Clock clock, Continuation<? super AwsSigningResult<Message>> continuation) {
        C36611 c36611;
        final Instant instant;
        if (continuation instanceof C36611) {
            c36611 = (C36611) continuation;
            if ((c36611.label & Integer.MIN_VALUE) != 0) {
                c36611.label -= Integer.MIN_VALUE;
            } else {
                c36611 = new C36611(continuation);
            }
        }
        Object obj = c36611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Instant instantTruncateSubsecs = truncateSubsecs(clock.getNow());
            builder.setSigningDate(instantTruncateSubsecs);
            AwsSigningConfig awsSigningConfigBuild = builder.build();
            c36611.L$0 = SpillingKt.nullOutSpilledVariable(awsSigner);
            c36611.L$1 = SpillingKt.nullOutSpilledVariable(builder);
            c36611.L$2 = SpillingKt.nullOutSpilledVariable(bArr);
            c36611.L$3 = bArr2;
            c36611.L$4 = SpillingKt.nullOutSpilledVariable(clock);
            c36611.L$5 = instantTruncateSubsecs;
            c36611.L$6 = SpillingKt.nullOutSpilledVariable(awsSigningConfigBuild);
            c36611.label = 1;
            Object objSignChunk = awsSigner.signChunk(bArr2, bArr, awsSigningConfigBuild, c36611);
            if (objSignChunk == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objSignChunk;
            instant = instantTruncateSubsecs;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            instant = (Instant) c36611.L$5;
            bArr2 = (byte[]) c36611.L$3;
            ResultKt.throwOnFailure(obj);
        }
        byte[] signature = ((AwsSigningResult) obj).getSignature();
        final byte[] bArrDecodeHexBytes = HexKt.decodeHexBytes(StringsKt.decodeToString(signature));
        return new AwsSigningResult(MessageKt.buildMessage(new Function1() { // from class: aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return EventStreamSigningKt.signPayload$lambda$1(instant, bArrDecodeHexBytes, bArr2, (MessageBuilder) obj2);
            }
        }), signature);
    }

    public static /* synthetic */ Object signPayload$default(AwsSigner awsSigner, AwsSigningConfig.Builder builder, byte[] bArr, byte[] bArr2, Clock clock, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            clock = Clock.System.INSTANCE;
        }
        return signPayload(awsSigner, builder, bArr, bArr2, clock, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPayload$lambda$1(Instant instant, byte[] bArr, byte[] bArr2, MessageBuilder buildMessage) {
        Intrinsics.checkNotNullParameter(buildMessage, "$this$buildMessage");
        buildMessage.addHeader(":date", new HeaderValue.Timestamp(instant));
        buildMessage.addHeader(":chunk-signature", new HeaderValue.ByteArray(bArr));
        buildMessage.setPayload(bArr2);
        return Unit.INSTANCE;
    }

    private static final Instant truncateSubsecs(Instant instant) {
        return Instant.INSTANCE.fromEpochSeconds(instant.getEpochSeconds(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AwsSigningConfig.Builder newEventStreamSigningConfig(ExecutionContext executionContext) {
        AwsSigningConfig.Builder builder = new AwsSigningConfig.Builder();
        builder.setAlgorithm(AwsSigningAlgorithm.SIGV4);
        builder.setSignatureType(AwsSignatureType.HTTP_REQUEST_EVENT);
        ExecutionContext executionContext2 = executionContext;
        builder.setRegion((String) AttributesKt.get(executionContext2, AwsSigningAttributes.INSTANCE.getSigningRegion()));
        builder.setService((String) AttributesKt.get(executionContext2, AwsSigningAttributes.INSTANCE.getSigningService()));
        builder.setUseDoubleUriEncode(false);
        builder.setNormalizeUriPath(true);
        builder.setSignedBodyHeader(AwsSignedBodyHeader.NONE);
        return builder;
    }
}
