package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorDetails;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorMetadataKt;
import aws.sdk.kotlin.services.p010s3.model.ProgressEvent;
import aws.sdk.kotlin.services.p010s3.model.RecordsEvent;
import aws.sdk.kotlin.services.p010s3.model.S3Exception;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentEventStream;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentResponse;
import aws.sdk.kotlin.services.p010s3.model.StatsEvent;
import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.FrameDecoderKt;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.Message;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.MessageType;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.ResponseHeadersKt;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: SelectObjectContentOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\f¨\u0006\r"}, m1599d2 = {"throwSelectObjectContentError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeSelectObjectContentOperationBody", "", "builder", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentResponse$Builder;", "(Laws/sdk/kotlin/services/s3/model/SelectObjectContentResponse$Builder;Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectObjectContentOperationDeserializerKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt$deserializeSelectObjectContentOperationBody$1 */
    /* JADX INFO: compiled from: SelectObjectContentOperationDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt", m1609f = "SelectObjectContentOperationDeserializer.kt", m1610i = {0, 0, 0}, m1611l = {80}, m1612m = "deserializeSelectObjectContentOperationBody", m1613n = {"builder", NotificationCompat.CATEGORY_CALL, "chan"}, m1614nl = {PDFACompliance.e_PDFA8_1}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C36021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36021(Continuation<? super C36021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectObjectContentOperationDeserializerKt.deserializeSelectObjectContentOperationBody(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwSelectObjectContentError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        S3ErrorDetails s3ErrorResponse;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            if (bArr == null) {
                if (Intrinsics.areEqual(httpCall.getResponse().getStatus(), HttpStatusCode.INSTANCE.getNotFound())) {
                    s3ErrorResponse = new S3ErrorDetails("NotFound", null, null, null, 14, null);
                } else {
                    s3ErrorResponse = new S3ErrorDetails(httpCall.getResponse().getStatus().toString(), null, null, null, 14, null);
                }
            } else {
                s3ErrorResponse = S3ErrorMetadataKt.parseS3ErrorResponse(bArr);
            }
            s3ErrorResponse.getCode();
            S3Exception s3Exception = new S3Exception(s3ErrorResponse.getMessage());
            S3ErrorMetadataKt.setS3ErrorMetadata(s3Exception, httpResponseWithPayload, s3ErrorResponse);
            throw s3Exception;
        } catch (Exception unused) {
            S3Exception s3Exception2 = new S3Exception("Failed to parse response as restXml error");
            S3ErrorMetadataKt.setS3ErrorMetadata(s3Exception2, httpCallCopy$default.getResponse(), null);
            throw s3Exception2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deserializeSelectObjectContentOperationBody(SelectObjectContentResponse.Builder builder, HttpCall httpCall, Continuation<? super Unit> continuation) {
        C36021 c36021;
        if (continuation instanceof C36021) {
            c36021 = (C36021) continuation;
            if ((c36021.label & Integer.MIN_VALUE) != 0) {
                c36021.label -= Integer.MIN_VALUE;
            } else {
                c36021 = new C36021(continuation);
            }
        }
        Object objDecodeFrames = c36021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36021.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDecodeFrames);
            SdkByteReadChannel sdkByteReadChannel = HttpBodyKt.toSdkByteReadChannel(httpCall.getResponse().getBody(), httpCall);
            if (sdkByteReadChannel == null) {
                return Unit.INSTANCE;
            }
            c36021.L$0 = builder;
            c36021.L$1 = SpillingKt.nullOutSpilledVariable(httpCall);
            c36021.L$2 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel);
            c36021.label = 1;
            objDecodeFrames = FrameDecoderKt.decodeFrames(sdkByteReadChannel, c36021);
            if (objDecodeFrames == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            builder = (SelectObjectContentResponse.Builder) c36021.L$0;
            ResultKt.throwOnFailure(objDecodeFrames);
        }
        final Flow flow = (Flow) objDecodeFrames;
        builder.setPayload(new Flow<SelectObjectContentEventStream>() { // from class: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt$deserializeSelectObjectContentOperationBody$$inlined$map$1

            /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt$deserializeSelectObjectContentOperationBody$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt$deserializeSelectObjectContentOperationBody$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializerKt$deserializeSelectObjectContentOperationBody$$inlined$map$1$2", m1609f = "SelectObjectContentOperationDeserializer.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {50}, m1612m = "emit", m1613n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m1614nl = {49}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    SelectObjectContentEventStream records;
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
                        Message message = (Message) obj;
                        MessageType messageTypeType = ResponseHeadersKt.type(message);
                        if (!(messageTypeType instanceof MessageType.Event)) {
                            if (messageTypeType instanceof MessageType.Exception) {
                                MessageType.Exception exception = (MessageType.Exception) messageTypeType;
                                exception.getShapeType();
                                throw new S3Exception("error processing event stream, unrecognized errorType: " + exception.getShapeType());
                            }
                            if (messageTypeType instanceof MessageType.Error) {
                                MessageType.Error error = (MessageType.Error) messageTypeType;
                                throw new S3Exception("error processing event stream: errorCode=" + error.getErrorCode() + "; message=" + error.getMessage());
                            }
                            if (messageTypeType instanceof MessageType.SdkUnknown) {
                                throw new ClientException("unrecognized event stream message `:message-type`: " + ((MessageType.SdkUnknown) messageTypeType).getMessageType());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        String shapeType = ((MessageType.Event) messageTypeType).getShapeType();
                        switch (shapeType.hashCode()) {
                            case -1547717086:
                                if (!shapeType.equals("Records")) {
                                    records = SelectObjectContentEventStream.SdkUnknown.INSTANCE;
                                } else {
                                    RecordsEvent.Builder builder = new RecordsEvent.Builder();
                                    builder.setPayload(message.getPayload());
                                    records = new SelectObjectContentEventStream.Records(builder.build());
                                }
                                break;
                            case -936434099:
                                if (shapeType.equals("Progress")) {
                                    ProgressEvent.Builder builder2 = new ProgressEvent.Builder();
                                    builder2.setDetails(ProgressPayloadDeserializerKt.deserializeProgressPayload(message.getPayload()));
                                    records = new SelectObjectContentEventStream.Progress(builder2.build());
                                    break;
                                }
                                break;
                            case 69819:
                                if (shapeType.equals("End")) {
                                    records = new SelectObjectContentEventStream.End(EndEventPayloadDeserializerKt.deserializeEndEventPayload(message.getPayload()));
                                    break;
                                }
                                break;
                            case 2106194:
                                if (shapeType.equals("Cont")) {
                                    records = new SelectObjectContentEventStream.Cont(ContinuationEventPayloadDeserializerKt.deserializeContinuationEventPayload(message.getPayload()));
                                    break;
                                }
                                break;
                            case 80204927:
                                if (shapeType.equals("Stats")) {
                                    StatsEvent.Builder builder3 = new StatsEvent.Builder();
                                    builder3.setDetails(StatsPayloadDeserializerKt.deserializeStatsPayload(message.getPayload()));
                                    records = new SelectObjectContentEventStream.Stats(builder3.build());
                                    break;
                                }
                                break;
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(records, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super SelectObjectContentEventStream> flowCollector, Continuation continuation2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
