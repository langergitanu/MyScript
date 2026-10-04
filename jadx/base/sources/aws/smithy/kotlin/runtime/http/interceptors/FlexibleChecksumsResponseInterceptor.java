package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00162\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005:\u0001\u0016B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00042\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/FlexibleChecksumsResponseInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "", "responseValidationRequired", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "responseChecksumValidation", "<init>", "(ZLaws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;)V", "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", WebViewMessageType.CONTEXT, "modifyBeforeDeserialization", "(Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "checksum", "ignoreChecksum", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;)Z", "Z", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class FlexibleChecksumsResponseInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    private final ResponseHttpChecksumConfig responseChecksumValidation;
    private final boolean responseValidationRequired;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<String> ChecksumHeaderValidated = new AttributeKey<>("ChecksumHeaderValidated");

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor$modifyBeforeDeserialization$1 */
    /* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor", m1609f = "FlexibleChecksumsResponseInterceptor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {85}, m1612m = "modifyBeforeDeserialization$suspendImpl", m1613n = {"$this", WebViewMessageType.CONTEXT, "logger", "checksumHeader", "serviceChecksumValue", "checksumAlgorithm", "bodyType", "configuredToVerifyChecksum"}, m1614nl = {84}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, m1616v = 2)
    static final class C37141 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C37141(Continuation<? super C37141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlexibleChecksumsResponseInterceptor.modifyBeforeDeserialization$suspendImpl(FlexibleChecksumsResponseInterceptor.this, (ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse>) null, (Continuation<? super HttpResponse>) this);
        }
    }

    public boolean ignoreChecksum(String checksum, ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> context) {
        Intrinsics.checkNotNullParameter(checksum, "checksum");
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        return modifyBeforeDeserialization$suspendImpl(this, protocolResponseInterceptorContext, continuation);
    }

    public FlexibleChecksumsResponseInterceptor(boolean z, ResponseHttpChecksumConfig responseHttpChecksumConfig) {
        this.responseValidationRequired = z;
        this.responseChecksumValidation = responseHttpChecksumConfig;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    public /* bridge */ Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12026modifyBeforeAttemptCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
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
    public /* bridge */ Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeSigning(protocolRequestInterceptorContext, continuation);
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

    /* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/FlexibleChecksumsResponseInterceptor$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "ChecksumHeaderValidated", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getChecksumHeaderValidated", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<String> getChecksumHeaderValidated() {
            return FlexibleChecksumsResponseInterceptor.ChecksumHeaderValidated;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object modifyBeforeDeserialization$suspendImpl(FlexibleChecksumsResponseInterceptor flexibleChecksumsResponseInterceptor, ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        C37141 c37141;
        Object next;
        ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext2;
        String str;
        HashFunction hashFunction;
        HashFunction hashFunction2;
        if (continuation instanceof C37141) {
            c37141 = (C37141) continuation;
            if ((c37141.label & Integer.MIN_VALUE) != 0) {
                c37141.label -= Integer.MIN_VALUE;
            } else {
                c37141 = flexibleChecksumsResponseInterceptor.new C37141(continuation);
            }
        }
        Object all = c37141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(all);
            int i2 = (flexibleChecksumsResponseInterceptor.responseValidationRequired || flexibleChecksumsResponseInterceptor.responseChecksumValidation == ResponseHttpChecksumConfig.WHEN_SUPPORTED) ? 1 : 0;
            if (i2 == 0) {
                return protocolResponseInterceptorContext.getProtocolResponse();
            }
            CoroutineContext coroutineContext = c37141.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(FlexibleChecksumsResponseInterceptor.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            Iterator<T> it = FlexibleChecksumsResponseInterceptorKt.getCHECKSUM_HEADER_VALIDATION_PRIORITY_LIST().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (protocolResponseInterceptorContext.getProtocolResponse().getHeaders().contains((String) next)) {
                    break;
                }
            }
            final String str2 = (String) next;
            if (str2 == null) {
                Logger.info$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FlexibleChecksumsResponseInterceptor.modifyBeforeDeserialization$lambda$1$0();
                    }
                }, 1, null);
                return protocolResponseInterceptorContext.getProtocolResponse();
            }
            String str3 = protocolResponseInterceptorContext.getProtocolResponse().getHeaders().get(str2);
            Intrinsics.checkNotNull(str3);
            String str4 = str3;
            if (flexibleChecksumsResponseInterceptor.ignoreChecksum(str4, protocolResponseInterceptorContext)) {
                return protocolResponseInterceptorContext.getProtocolResponse();
            }
            protocolResponseInterceptorContext.getExecutionContext().set(ChecksumHeaderValidated, str2);
            HashFunction hashFunctionOrThrow = HashFunctionKt.toHashFunctionOrThrow(StringsKt.removePrefix(str2, (CharSequence) "x-amz-checksum-"));
            HttpBody body = protocolResponseInterceptorContext.getProtocolResponse().getBody();
            if (body instanceof HttpBody.Bytes) {
                Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FlexibleChecksumsResponseInterceptor.modifyBeforeDeserialization$lambda$2(str2);
                    }
                }, 1, null);
                HttpBody body2 = protocolResponseInterceptorContext.getProtocolResponse().getBody();
                c37141.L$0 = SpillingKt.nullOutSpilledVariable(flexibleChecksumsResponseInterceptor);
                c37141.L$1 = protocolResponseInterceptorContext;
                c37141.L$2 = SpillingKt.nullOutSpilledVariable(logger);
                c37141.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                c37141.L$4 = str4;
                c37141.L$5 = hashFunctionOrThrow;
                c37141.L$6 = SpillingKt.nullOutSpilledVariable(body);
                c37141.L$7 = hashFunctionOrThrow;
                c37141.I$0 = i2;
                c37141.label = 1;
                all = HttpBodyKt.readAll(body2, c37141);
                if (all == coroutine_suspended) {
                    return coroutine_suspended;
                }
                protocolResponseInterceptorContext2 = protocolResponseInterceptorContext;
                str = str4;
                hashFunction = hashFunctionOrThrow;
                hashFunction2 = hashFunction;
            } else {
                if ((body instanceof HttpBody.SourceContent) || (body instanceof HttpBody.ChannelContent)) {
                    Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsResponseInterceptor$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FlexibleChecksumsResponseInterceptor.modifyBeforeDeserialization$lambda$3(str2);
                        }
                    }, 1, null);
                    return HttpResponseKt.copy$default(protocolResponseInterceptorContext.getProtocolResponse(), null, null, FlexibleChecksumsResponseInterceptorKt.toChecksumValidatingBody(HttpBodyKt.toHashingBody(protocolResponseInterceptorContext.getProtocolResponse().getBody(), hashFunctionOrThrow, protocolResponseInterceptorContext.getProtocolResponse().getBody().getContentLength()), str4), 3, null);
                }
                throw new IllegalStateException("HTTP body type '" + body + "' is not supported for flexible checksums.");
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c37141.I$0;
            HashFunction hashFunction3 = (HashFunction) c37141.L$7;
            HashFunction hashFunction4 = (HashFunction) c37141.L$5;
            str = (String) c37141.L$4;
            ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext3 = (ProtocolResponseInterceptorContext) c37141.L$1;
            ResultKt.throwOnFailure(all);
            hashFunction2 = hashFunction3;
            hashFunction = hashFunction4;
            protocolResponseInterceptorContext2 = protocolResponseInterceptorContext3;
        }
        byte[] bArr = (byte[]) all;
        if (bArr == null) {
            bArr = new byte[0];
        }
        HashFunction.update$default(hashFunction2, bArr, 0, 0, 6, null);
        FlexibleChecksumsResponseInterceptorKt.validateAndThrow(str, Base64Kt.encodeBase64String(hashFunction.digest()));
        return protocolResponseInterceptorContext2.getProtocolResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeDeserialization$lambda$1$0() {
        return "Checksum validation was requested but the response headers didn't contain a valid checksum.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeDeserialization$lambda$2(String str) {
        return "Validating checksum before deserialization from " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeDeserialization$lambda$3(String str) {
        return "Validating checksum after deserialization from " + str;
    }
}
