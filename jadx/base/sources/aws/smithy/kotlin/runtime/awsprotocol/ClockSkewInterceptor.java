package aws.smithy.kotlin.runtime.awsprotocol;

import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import aws.smithy.kotlin.runtime.time.ParseException;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: ClockSkewInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005:\u0001\u0011B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0096@¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/ClockSkewInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "<init>", "()V", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", WebViewMessageType.CONTEXT, "modifyBeforeSigning", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "Lkotlin/Result;", "modifyBeforeAttemptCompletion-gIAlu-s", "(Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyBeforeAttemptCompletion", "Companion", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ClockSkewInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    private static final List<String> CLOCK_SKEW_ERROR_CODES;
    private static final long CLOCK_SKEW_THRESHOLD;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> POSSIBLE_CLOCK_SKEW_ERROR_CODES;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _currentSkew$FU;
    private volatile /* synthetic */ Object _currentSkew = null;

    /* JADX INFO: compiled from: ClockSkewInterceptor.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u000b\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/ClockSkewInterceptor$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/time/Instant;", "serverTime", "", "errorCode", "", "isSkewed$aws_protocol_core", "(Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;)Z", "isSkewed", "Lkotlin/time/Duration;", "CLOCK_SKEW_THRESHOLD", "J", "getCLOCK_SKEW_THRESHOLD-UwyO8pc", "()J", "", "CLOCK_SKEW_ERROR_CODES", "Ljava/util/List;", "POSSIBLE_CLOCK_SKEW_ERROR_CODES", "aws-protocol-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCLOCK_SKEW_THRESHOLD-UwyO8pc, reason: not valid java name */
        public final long m12142getCLOCK_SKEW_THRESHOLDUwyO8pc() {
            return ClockSkewInterceptor.CLOCK_SKEW_THRESHOLD;
        }

        public final boolean isSkewed$aws_protocol_core(Instant instant, Instant serverTime, String errorCode) {
            Intrinsics.checkNotNullParameter(instant, "<this>");
            Intrinsics.checkNotNullParameter(serverTime, "serverTime");
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (ClockSkewInterceptor.CLOCK_SKEW_ERROR_CODES.contains(errorCode)) {
                return true;
            }
            return ClockSkewInterceptor.POSSIBLE_CLOCK_SKEW_ERROR_CODES.contains(errorCode) && Duration.m15855compareToLRDsOJo(Duration.m15862getAbsoluteValueUwyO8pc(InstantKt.until(instant, serverTime)), m12142getCLOCK_SKEW_THRESHOLDUwyO8pc()) >= 0;
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        return super.modifyBeforeDeserialization(protocolResponseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeRetryLoop(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext, Continuation<? super Object> continuation) {
        return super.modifyBeforeSerialization(requestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeTransmit(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterAttempt(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterAttempt(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterDeserialization(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterDeserialization(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterExecution(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterExecution(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSerialization(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSerialization(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterTransmit(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readAfterTransmit(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeAttempt(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeAttempt(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readBeforeDeserialization(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeExecution(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeExecution(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeSerialization(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeTransmit(protocolRequestInterceptorContext);
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        CLOCK_SKEW_THRESHOLD = DurationKt.toDuration(4, DurationUnit.MINUTES);
        CLOCK_SKEW_ERROR_CODES = CollectionsKt.listOf((Object[]) new String[]{"RequestTimeTooSkewed", "RequestExpired", "RequestInTheFuture"});
        POSSIBLE_CLOCK_SKEW_ERROR_CODES = CollectionsKt.listOf((Object[]) new String[]{"InvalidSignatureException", "SignatureDoesNotMatch", "AuthFailure"});
        _currentSkew$FU = AtomicReferenceFieldUpdater.newUpdater(ClockSkewInterceptor.class, Object.class, "_currentSkew");
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        CoroutineContext context = continuation.get$context();
        String qualifiedName = Reflection.getOrCreateKotlinClass(ClockSkewInterceptor.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger = CoroutineContextLogExtKt.logger(context, qualifiedName);
        final Duration duration = (Duration) this._currentSkew;
        if (duration != null) {
            duration.getRawValue();
            Logger.info$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ClockSkewInterceptor.modifyBeforeSigning$lambda$0$0(duration);
                }
            }, 1, null);
            protocolRequestInterceptorContext.getExecutionContext().set(HttpOperationContext.INSTANCE.getClockSkew(), duration);
        }
        protocolRequestInterceptorContext.getExecutionContext().set(HttpOperationContext.INSTANCE.getClockSkewApproximateSigningTime(), Instant.INSTANCE.now());
        return protocolRequestInterceptorContext.getProtocolRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeSigning$lambda$0$0(Duration duration) {
        return "applying clock skew " + ((Object) Duration.m15896toStringimpl(duration.getRawValue())) + " to client";
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        r0 = aws.smithy.kotlin.runtime.http.response.HttpResponseKt.header(r0, "Date");
     */
    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        final String strHeader;
        final Instant instantFromIso8601;
        CoroutineContext context = continuation.get$context();
        String qualifiedName = Reflection.getOrCreateKotlinClass(ClockSkewInterceptor.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger = CoroutineContextLogExtKt.logger(context, qualifiedName);
        HttpResponse protocolResponse = responseInterceptorContext.getProtocolResponse();
        if (protocolResponse != null && strHeader != null) {
            try {
                final Instant instantFromRfc5322 = Instant.INSTANCE.fromRfc5322(strHeader);
                if (instantFromRfc5322 != null) {
                    String str = responseInterceptorContext.getProtocolRequest().getHeaders().get("Date");
                    if (str == null || (instantFromIso8601 = Instant.INSTANCE.fromRfc5322(str)) == null) {
                        String str2 = responseInterceptorContext.getProtocolRequest().getHeaders().get("x-amz-date");
                        if (str2 != null) {
                            instantFromIso8601 = Instant.INSTANCE.fromIso8601(str2);
                        } else {
                            instantFromIso8601 = (Instant) AttributesKt.get(responseInterceptorContext.getExecutionContext(), HttpOperationContext.INSTANCE.getClockSkewApproximateSigningTime());
                        }
                    }
                    Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(responseInterceptorContext.mo12149getResponsed1pmJ48());
                    SdkBaseException sdkBaseException = thM14502exceptionOrNullimpl instanceof SdkBaseException ? (SdkBaseException) thM14502exceptionOrNullimpl : null;
                    if (sdkBaseException == null) {
                        return responseInterceptorContext.mo12149getResponsed1pmJ48();
                    }
                    String str3 = (String) sdkBaseException.getSdkErrorMetadata().getAttributes().getOrNull(ServiceErrorMetadata.INSTANCE.getErrorCode());
                    if (str3 != null && INSTANCE.isSkewed$aws_protocol_core(instantFromIso8601, instantFromRfc5322, str3)) {
                        final long jUntil = InstantKt.until(instantFromIso8601, instantFromRfc5322);
                        Logger.warn$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ClockSkewInterceptor.modifyBeforeAttemptCompletion_gIAlu_s$lambda$4$0(instantFromIso8601, jUntil, instantFromRfc5322);
                            }
                        }, 1, null);
                        _currentSkew$FU.getAndSet(this, Duration.m15854boximpl(jUntil));
                        responseInterceptorContext.getExecutionContext().set(HttpOperationContext.INSTANCE.getClockSkew(), Duration.m15854boximpl(jUntil));
                        sdkBaseException.getSdkErrorMetadata().getAttributes().set(ErrorMetadata.INSTANCE.getRetryable(), Boxing.boxBoolean(true));
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m14499constructorimpl(ResultKt.createFailure(sdkBaseException));
                    }
                    return responseInterceptorContext.mo12149getResponsed1pmJ48();
                }
            } catch (ParseException e) {
                logger.debug(e, new Function0() { // from class: aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ClockSkewInterceptor.modifyBeforeAttemptCompletion_gIAlu_s$lambda$0$0();
                    }
                });
                Logger.warn$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ClockSkewInterceptor.modifyBeforeAttemptCompletion_gIAlu_s$lambda$0$1(strHeader);
                    }
                }, 1, null);
                return responseInterceptorContext.mo12149getResponsed1pmJ48();
            }
        }
        Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClockSkewInterceptor.modifyBeforeAttemptCompletion_gIAlu_s$lambda$1$0();
            }
        }, 1, null);
        return responseInterceptorContext.mo12149getResponsed1pmJ48();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeAttemptCompletion_gIAlu_s$lambda$0$0() {
        return "Error while parsing \"Date\" header from service response";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeAttemptCompletion_gIAlu_s$lambda$0$1(String str) {
        return "Service returned malformed \"Date\" header value \"" + str + "\", skipping skew calculation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeAttemptCompletion_gIAlu_s$lambda$1$0() {
        return "service did not return \"Date\" header, skipping skew calculation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeAttemptCompletion_gIAlu_s$lambda$4$0(Instant instant, long j, Instant instant2) {
        return "client clock (" + instant + ") is skewed " + ((Object) Duration.m15896toStringimpl(j)) + " from the server (" + instant2 + "), applying correction";
    }
}
