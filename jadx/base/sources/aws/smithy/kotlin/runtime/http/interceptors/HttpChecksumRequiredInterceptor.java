package aws.smithy.kotlin.runtime.http.interceptors;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HttpChecksumRequiredInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0096@¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0082@¢\u0006\u0004\b\u000b\u0010\tJ&\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0096@¢\u0006\u0004\b\f\u0010\tJ+\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/HttpChecksumRequiredInterceptor;", "Laws/smithy/kotlin/runtime/http/interceptors/CachingChecksumInterceptor;", "<init>", "()V", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", WebViewMessageType.CONTEXT, "modifyBeforeSigning", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "calculateHttpChecksumRequiredChecksum", "calculateChecksum", "checksum", "applyHttpChecksumRequiredChecksum", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Ljava/lang/String;)Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "applyChecksum", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpChecksumRequiredInterceptor extends CachingChecksumInterceptor {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.HttpChecksumRequiredInterceptor$calculateHttpChecksumRequiredChecksum$1 */
    /* JADX INFO: compiled from: HttpChecksumRequiredInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.HttpChecksumRequiredInterceptor", m1609f = "HttpChecksumRequiredInterceptor.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {63, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m1612m = "calculateHttpChecksumRequiredChecksum", m1613n = {WebViewMessageType.CONTEXT, "req", "checksumAlgorithmName", "checksumAlgorithm", "channel", WebViewMessageType.CONTEXT, "req", "checksumAlgorithmName", "checksumAlgorithm"}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 67}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C37151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C37151(Continuation<? super C37151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpChecksumRequiredInterceptor.this.calculateHttpChecksumRequiredChecksum(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.HttpChecksumRequiredInterceptor$modifyBeforeSigning$1 */
    /* JADX INFO: compiled from: HttpChecksumRequiredInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.HttpChecksumRequiredInterceptor", m1609f = "HttpChecksumRequiredInterceptor.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {42, 44}, m1612m = "modifyBeforeSigning", m1613n = {WebViewMessageType.CONTEXT, "checksumAlgorithmName", "checksumAlgorithm", WebViewMessageType.CONTEXT, "checksumAlgorithmName", "checksumAlgorithm"}, m1614nl = {48, 45}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C37161(Continuation<? super C37161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpChecksumRequiredInterceptor.this.modifyBeforeSigning(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
    
        if (r8 == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.interceptors.CachingChecksumInterceptor, aws.smithy.kotlin.runtime.client.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        C37161 c37161;
        if (continuation instanceof C37161) {
            c37161 = (C37161) continuation;
            if ((c37161.label & Integer.MIN_VALUE) != 0) {
                c37161.label -= Integer.MIN_VALUE;
            } else {
                c37161 = new C37161(continuation);
            }
        }
        Object objCalculateHttpChecksumRequiredChecksum = c37161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37161.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCalculateHttpChecksumRequiredChecksum);
            if (ChecksumInterceptorUtilsKt.getDefaultChecksumAlgorithmName(protocolRequestInterceptorContext) == null) {
                return protocolRequestInterceptorContext.getProtocolRequest();
            }
            String defaultChecksumAlgorithmName = ChecksumInterceptorUtilsKt.getDefaultChecksumAlgorithmName(protocolRequestInterceptorContext);
            Intrinsics.checkNotNull(defaultChecksumAlgorithmName);
            final HashFunction hashFunctionOrThrow = HashFunctionKt.toHashFunctionOrThrow(defaultChecksumAlgorithmName);
            if (HttpBodyKt.isEligibleForAwsChunkedStreaming(protocolRequestInterceptorContext.getProtocolRequest().getBody())) {
                CoroutineContext coroutineContext = c37161.get$context();
                String qualifiedName = Reflection.getOrCreateKotlinClass(HttpChecksumRequiredInterceptor.class).getQualifiedName();
                if (qualifiedName != null) {
                    Logger.debug$default(CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName), null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.HttpChecksumRequiredInterceptor$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HttpChecksumRequiredInterceptor.modifyBeforeSigning$lambda$0(hashFunctionOrThrow);
                        }
                    }, 1, null);
                    return ChecksumInterceptorUtilsKt.calculateAwsChunkedStreamingChecksum(protocolRequestInterceptorContext, hashFunctionOrThrow);
                }
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            if (protocolRequestInterceptorContext.getProtocolRequest().getBody() instanceof HttpBody.Bytes) {
                c37161.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
                c37161.L$1 = SpillingKt.nullOutSpilledVariable(defaultChecksumAlgorithmName);
                c37161.L$2 = SpillingKt.nullOutSpilledVariable(hashFunctionOrThrow);
                c37161.label = 1;
                Object objModifyBeforeSigning = super.modifyBeforeSigning(protocolRequestInterceptorContext, c37161);
                if (objModifyBeforeSigning != coroutine_suspended) {
                    return objModifyBeforeSigning;
                }
            } else {
                c37161.L$0 = protocolRequestInterceptorContext;
                c37161.L$1 = SpillingKt.nullOutSpilledVariable(defaultChecksumAlgorithmName);
                c37161.L$2 = SpillingKt.nullOutSpilledVariable(hashFunctionOrThrow);
                c37161.label = 2;
                objCalculateHttpChecksumRequiredChecksum = calculateHttpChecksumRequiredChecksum(protocolRequestInterceptorContext, c37161);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objCalculateHttpChecksumRequiredChecksum);
            return objCalculateHttpChecksumRequiredChecksum;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        protocolRequestInterceptorContext = (ProtocolRequestInterceptorContext) c37161.L$0;
        ResultKt.throwOnFailure(objCalculateHttpChecksumRequiredChecksum);
        return applyHttpChecksumRequiredChecksum(protocolRequestInterceptorContext, (String) objCalculateHttpChecksumRequiredChecksum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeSigning$lambda$0(HashFunction hashFunction) {
        return "Calculating checksum during transmission using: " + Reflection.getOrCreateKotlinClass(hashFunction.getClass()).getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c1, code lost:
    
        if (r10 == r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateHttpChecksumRequiredChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super String> continuation) {
        C37151 c37151;
        HttpRequestBuilder httpRequestBuilder;
        HashFunction hashFunction;
        byte[] bArr;
        if (continuation instanceof C37151) {
            c37151 = (C37151) continuation;
            if ((c37151.label & Integer.MIN_VALUE) != 0) {
                c37151.label -= Integer.MIN_VALUE;
            } else {
                c37151 = new C37151(continuation);
            }
        }
        C37151 c371512 = c37151;
        Object objRollingHash$default = c371512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c371512.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(objRollingHash$default);
                return Base64Kt.encodeBase64String((byte[]) objRollingHash$default);
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hashFunction = (HashFunction) c371512.L$3;
            httpRequestBuilder = (HttpRequestBuilder) c371512.L$1;
            ResultKt.throwOnFailure(objRollingHash$default);
            bArr = (byte[]) objRollingHash$default;
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (httpRequestBuilder.getBody().getIsOneShot()) {
                httpRequestBuilder.setBody(HttpBodyKt.toHttpBody(bArr));
            }
            return Base64Kt.encodeBase64String(HashFunctionKt.hash(bArr, hashFunction));
        }
        ResultKt.throwOnFailure(objRollingHash$default);
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(protocolRequestInterceptorContext.getProtocolRequest());
        String defaultChecksumAlgorithmName = ChecksumInterceptorUtilsKt.getDefaultChecksumAlgorithmName(protocolRequestInterceptorContext);
        Intrinsics.checkNotNull(defaultChecksumAlgorithmName);
        HashFunction hashFunctionOrThrow = HashFunctionKt.toHashFunctionOrThrow(defaultChecksumAlgorithmName);
        if (builder.getBody().getContentLength() == null && !builder.getBody().getIsOneShot()) {
            SdkByteReadChannel sdkByteReadChannel$default = HttpBodyKt.toSdkByteReadChannel$default(builder.getBody(), null, 1, null);
            Intrinsics.checkNotNull(sdkByteReadChannel$default);
            c371512.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
            c371512.L$1 = SpillingKt.nullOutSpilledVariable(builder);
            c371512.L$2 = SpillingKt.nullOutSpilledVariable(defaultChecksumAlgorithmName);
            c371512.L$3 = SpillingKt.nullOutSpilledVariable(hashFunctionOrThrow);
            c371512.L$4 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel$default);
            c371512.label = 1;
            objRollingHash$default = SdkByteReadChannelKt.rollingHash$default(sdkByteReadChannel$default, hashFunctionOrThrow, 0L, c371512, 2, null);
        } else {
            HttpBody body = builder.getBody();
            c371512.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
            c371512.L$1 = builder;
            c371512.L$2 = SpillingKt.nullOutSpilledVariable(defaultChecksumAlgorithmName);
            c371512.L$3 = hashFunctionOrThrow;
            c371512.label = 2;
            Object all = HttpBodyKt.readAll(body, c371512);
            if (all != coroutine_suspended) {
                httpRequestBuilder = builder;
                objRollingHash$default = all;
                hashFunction = hashFunctionOrThrow;
                bArr = (byte[]) objRollingHash$default;
                if (bArr == null) {
                }
                if (httpRequestBuilder.getBody().getIsOneShot()) {
                }
                return Base64Kt.encodeBase64String(HashFunctionKt.hash(bArr, hashFunction));
            }
        }
        return coroutine_suspended;
    }

    @Override // aws.smithy.kotlin.runtime.http.interceptors.CachingChecksumInterceptor
    public Object calculateChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super String> continuation) {
        return calculateHttpChecksumRequiredChecksum(protocolRequestInterceptorContext, continuation);
    }

    private final HttpRequest applyHttpChecksumRequiredChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> context, String checksum) {
        String defaultChecksumAlgorithmName = ChecksumInterceptorUtilsKt.getDefaultChecksumAlgorithmName(context);
        Intrinsics.checkNotNull(defaultChecksumAlgorithmName);
        String strResolveChecksumAlgorithmHeaderName = HashFunctionKt.resolveChecksumAlgorithmHeaderName(defaultChecksumAlgorithmName);
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(context.getProtocolRequest());
        HttpRequestBuilderKt.header(builder, strResolveChecksumAlgorithmHeaderName, checksum);
        return builder.build();
    }

    @Override // aws.smithy.kotlin.runtime.http.interceptors.CachingChecksumInterceptor
    public HttpRequest applyChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> context, String checksum) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checksum, "checksum");
        return applyHttpChecksumRequiredChecksum(context, checksum);
    }
}
