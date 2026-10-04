package aws.smithy.kotlin.runtime.http.interceptors;

import androidx.compose.runtime.GapComposerKt;
import androidx.media3.container.MdtaMetadataEntry;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannelKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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
import kotlin.text.StringsKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: FlexibleChecksumsRequestInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000e\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082@¢\u0006\u0004\b\u0013\u0010\u000fJ&\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0096@¢\u0006\u0004\b\u0014\u0010\u000fJ+\u0010\u0016\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0018\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u0006*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010 \u001a\u00020\u001f*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/FlexibleChecksumsRequestInterceptor;", "Laws/smithy/kotlin/runtime/http/interceptors/CachingChecksumInterceptor;", "", "requestChecksumRequired", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "requestChecksumCalculation", "", "requestChecksumAlgorithm", "<init>", "(ZLaws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;Ljava/lang/String;)V", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", WebViewMessageType.CONTEXT, "modifyBeforeSigning", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "resolveChecksumAlgorithm", "(ZLaws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;Ljava/lang/String;Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;)Laws/smithy/kotlin/runtime/hashing/HashFunction;", "calculateFlexibleChecksumsChecksum", "calculateChecksum", "checksum", "applyFlexibleChecksumsChecksum", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Ljava/lang/String;)Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "applyChecksum", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "logger", "userProvidedChecksumHeader", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/telemetry/logging/Logger;)Ljava/lang/String;", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "headerName", "", "removeAllChecksumHeadersExcept", "(Laws/smithy/kotlin/runtime/http/HeadersBuilder;Ljava/lang/String;)V", "Z", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "Ljava/lang/String;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FlexibleChecksumsRequestInterceptor extends CachingChecksumInterceptor {
    private final String requestChecksumAlgorithm;
    private final RequestHttpChecksumConfig requestChecksumCalculation;
    private final boolean requestChecksumRequired;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$calculateFlexibleChecksumsChecksum$1 */
    /* JADX INFO: compiled from: FlexibleChecksumsRequestInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor", m1609f = "FlexibleChecksumsRequestInterceptor.kt", m1610i = {0, 0, 0, 0, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA1_2_2, GapComposerKt.nodeKey}, m1612m = "calculateFlexibleChecksumsChecksum", m1613n = {WebViewMessageType.CONTEXT, "req", "checksumAlgorithm", "channel", WebViewMessageType.CONTEXT, "req", "checksumAlgorithm"}, m1614nl = {GapComposerKt.nodeKey, WebSocketProtocol.PAYLOAD_SHORT}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C37121(Continuation<? super C37121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlexibleChecksumsRequestInterceptor.this.calculateFlexibleChecksumsChecksum(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$modifyBeforeSigning$1 */
    /* JADX INFO: compiled from: FlexibleChecksumsRequestInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor", m1609f = "FlexibleChecksumsRequestInterceptor.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {75, 77}, m1612m = "modifyBeforeSigning", m1613n = {WebViewMessageType.CONTEXT, "logger", "checksumAlgorithm", "$i$a$-let-FlexibleChecksumsRequestInterceptor$modifyBeforeSigning$3", WebViewMessageType.CONTEXT, "logger", "checksumAlgorithm", "$i$a$-let-FlexibleChecksumsRequestInterceptor$modifyBeforeSigning$3"}, m1614nl = {77, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C37131 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C37131(Continuation<? super C37131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlexibleChecksumsRequestInterceptor.this.modifyBeforeSigning(null, this);
        }
    }

    public FlexibleChecksumsRequestInterceptor(boolean z, RequestHttpChecksumConfig requestHttpChecksumConfig, String str) {
        this.requestChecksumRequired = z;
        this.requestChecksumCalculation = requestHttpChecksumConfig;
        this.requestChecksumAlgorithm = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00eb, code lost:
    
        if (r10 == r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0107, code lost:
    
        if (r10 == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.interceptors.CachingChecksumInterceptor, aws.smithy.kotlin.runtime.client.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        C37131 c37131;
        if (continuation instanceof C37131) {
            c37131 = (C37131) continuation;
            if ((c37131.label & Integer.MIN_VALUE) != 0) {
                c37131.label -= Integer.MIN_VALUE;
            } else {
                c37131 = new C37131(continuation);
            }
        }
        Object objCalculateFlexibleChecksumsChecksum = c37131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37131.label;
        if (i != 0) {
            if (i == 1) {
                int i2 = c37131.I$0;
                ResultKt.throwOnFailure(objCalculateFlexibleChecksumsChecksum);
                return (HttpRequest) objCalculateFlexibleChecksumsChecksum;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c37131.I$0;
            protocolRequestInterceptorContext = (ProtocolRequestInterceptorContext) c37131.L$0;
            ResultKt.throwOnFailure(objCalculateFlexibleChecksumsChecksum);
            return applyFlexibleChecksumsChecksum(protocolRequestInterceptorContext, (String) objCalculateFlexibleChecksumsChecksum);
        }
        ResultKt.throwOnFailure(objCalculateFlexibleChecksumsChecksum);
        CoroutineContext coroutineContext = c37131.get$context();
        String qualifiedName = Reflection.getOrCreateKotlinClass(FlexibleChecksumsRequestInterceptor.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
        String strUserProvidedChecksumHeader = userProvidedChecksumHeader(protocolRequestInterceptorContext.getProtocolRequest(), logger);
        if (strUserProvidedChecksumHeader != null) {
            Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FlexibleChecksumsRequestInterceptor.modifyBeforeSigning$lambda$0$0();
                }
            }, 1, null);
            removeAllChecksumHeadersExcept(HttpRequestKt.toBuilder(protocolRequestInterceptorContext.getProtocolRequest()).getHeaders(), strUserProvidedChecksumHeader);
            return protocolRequestInterceptorContext.getProtocolRequest();
        }
        final HashFunction hashFunctionResolveChecksumAlgorithm = resolveChecksumAlgorithm(this.requestChecksumRequired, this.requestChecksumCalculation, this.requestChecksumAlgorithm, protocolRequestInterceptorContext);
        if (hashFunctionResolveChecksumAlgorithm != null) {
            if (HttpBodyKt.isEligibleForAwsChunkedStreaming(protocolRequestInterceptorContext.getProtocolRequest().getBody())) {
                Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FlexibleChecksumsRequestInterceptor.modifyBeforeSigning$lambda$1$0(hashFunctionResolveChecksumAlgorithm);
                    }
                }, 1, null);
                return ChecksumInterceptorUtilsKt.calculateAwsChunkedStreamingChecksum(protocolRequestInterceptorContext, hashFunctionResolveChecksumAlgorithm);
            }
            if (protocolRequestInterceptorContext.getProtocolRequest().getBody() instanceof HttpBody.Bytes) {
                c37131.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
                c37131.L$1 = SpillingKt.nullOutSpilledVariable(logger);
                c37131.L$2 = SpillingKt.nullOutSpilledVariable(hashFunctionResolveChecksumAlgorithm);
                c37131.I$0 = 0;
                c37131.label = 1;
                objCalculateFlexibleChecksumsChecksum = super.modifyBeforeSigning(protocolRequestInterceptorContext, c37131);
            } else {
                c37131.L$0 = protocolRequestInterceptorContext;
                c37131.L$1 = SpillingKt.nullOutSpilledVariable(logger);
                c37131.L$2 = SpillingKt.nullOutSpilledVariable(hashFunctionResolveChecksumAlgorithm);
                c37131.I$0 = 0;
                c37131.label = 2;
                objCalculateFlexibleChecksumsChecksum = calculateFlexibleChecksumsChecksum(protocolRequestInterceptorContext, c37131);
            }
            return coroutine_suspended;
        }
        Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FlexibleChecksumsRequestInterceptor.modifyBeforeSigning$lambda$2();
            }
        }, 1, null);
        return protocolRequestInterceptorContext.getProtocolRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeSigning$lambda$0$0() {
        return "Checksum was supplied via header: skipping checksum calculation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeSigning$lambda$1$0(HashFunction hashFunction) {
        return "Calculating checksum during transmission using: " + Reflection.getOrCreateKotlinClass(hashFunction.getClass()).getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeSigning$lambda$2() {
        return "Checksum wasn't provided, selected, or isn't required: skipping checksum calculation";
    }

    private final HashFunction resolveChecksumAlgorithm(boolean requestChecksumRequired, RequestHttpChecksumConfig requestChecksumCalculation, String requestChecksumAlgorithm, ProtocolRequestInterceptorContext<Object, HttpRequest> context) {
        HashFunction hashFunctionOrThrow;
        HashFunction hashFunctionOrThrow2;
        if (requestChecksumAlgorithm != null && (hashFunctionOrThrow2 = HashFunctionKt.toHashFunctionOrThrow(requestChecksumAlgorithm)) != null) {
            if (!HashFunctionKt.isSupportedForFlexibleChecksums(hashFunctionOrThrow2)) {
                hashFunctionOrThrow2 = null;
            }
            if (hashFunctionOrThrow2 != null) {
                return hashFunctionOrThrow2;
            }
        }
        String defaultChecksumAlgorithmName = ChecksumInterceptorUtilsKt.getDefaultChecksumAlgorithmName(context);
        if (defaultChecksumAlgorithmName == null || (hashFunctionOrThrow = HashFunctionKt.toHashFunctionOrThrow(defaultChecksumAlgorithmName)) == null || !((requestChecksumRequired || requestChecksumCalculation == RequestHttpChecksumConfig.WHEN_SUPPORTED) && HashFunctionKt.isSupportedForFlexibleChecksums(hashFunctionOrThrow))) {
            return null;
        }
        return hashFunctionOrThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        if (r11 == r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateFlexibleChecksumsChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super String> continuation) {
        C37121 c37121;
        HttpRequestBuilder httpRequestBuilder;
        HashFunction hashFunction;
        byte[] bArr;
        if (continuation instanceof C37121) {
            c37121 = (C37121) continuation;
            if ((c37121.label & Integer.MIN_VALUE) != 0) {
                c37121.label -= Integer.MIN_VALUE;
            } else {
                c37121 = new C37121(continuation);
            }
        }
        C37121 c371212 = c37121;
        Object objRollingHash$default = c371212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c371212.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(objRollingHash$default);
                return Base64Kt.encodeBase64String((byte[]) objRollingHash$default);
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hashFunction = (HashFunction) c371212.L$2;
            httpRequestBuilder = (HttpRequestBuilder) c371212.L$1;
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
        HashFunction hashFunctionResolveChecksumAlgorithm = resolveChecksumAlgorithm(this.requestChecksumRequired, this.requestChecksumCalculation, this.requestChecksumAlgorithm, protocolRequestInterceptorContext);
        Intrinsics.checkNotNull(hashFunctionResolveChecksumAlgorithm);
        if (builder.getBody().getContentLength() == null && !builder.getBody().getIsOneShot()) {
            SdkByteReadChannel sdkByteReadChannel$default = HttpBodyKt.toSdkByteReadChannel$default(builder.getBody(), null, 1, null);
            Intrinsics.checkNotNull(sdkByteReadChannel$default);
            c371212.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
            c371212.L$1 = SpillingKt.nullOutSpilledVariable(builder);
            c371212.L$2 = SpillingKt.nullOutSpilledVariable(hashFunctionResolveChecksumAlgorithm);
            c371212.L$3 = SpillingKt.nullOutSpilledVariable(sdkByteReadChannel$default);
            c371212.label = 1;
            objRollingHash$default = SdkByteReadChannelKt.rollingHash$default(sdkByteReadChannel$default, hashFunctionResolveChecksumAlgorithm, 0L, c371212, 2, null);
        } else {
            HttpBody body = builder.getBody();
            c371212.L$0 = SpillingKt.nullOutSpilledVariable(protocolRequestInterceptorContext);
            c371212.L$1 = builder;
            c371212.L$2 = hashFunctionResolveChecksumAlgorithm;
            c371212.label = 2;
            Object all = HttpBodyKt.readAll(body, c371212);
            if (all != coroutine_suspended) {
                httpRequestBuilder = builder;
                objRollingHash$default = all;
                hashFunction = hashFunctionResolveChecksumAlgorithm;
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
        return calculateFlexibleChecksumsChecksum(protocolRequestInterceptorContext, continuation);
    }

    private final HttpRequest applyFlexibleChecksumsChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> context, String checksum) {
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(context.getProtocolRequest());
        HashFunction hashFunctionResolveChecksumAlgorithm = resolveChecksumAlgorithm(this.requestChecksumRequired, this.requestChecksumCalculation, this.requestChecksumAlgorithm, context);
        Intrinsics.checkNotNull(hashFunctionResolveChecksumAlgorithm);
        String strResolveChecksumAlgorithmHeaderName = HashFunctionKt.resolveChecksumAlgorithmHeaderName(hashFunctionResolveChecksumAlgorithm);
        builder.getHeaders().set(strResolveChecksumAlgorithmHeaderName, checksum);
        removeAllChecksumHeadersExcept(builder.getHeaders(), strResolveChecksumAlgorithmHeaderName);
        BusinessMetricsUtilsKt.emitBusinessMetric(context.getExecutionContext(), HashFunctionKt.toBusinessMetric(hashFunctionResolveChecksumAlgorithm));
        return builder.build();
    }

    @Override // aws.smithy.kotlin.runtime.http.interceptors.CachingChecksumInterceptor
    public HttpRequest applyChecksum(ProtocolRequestInterceptorContext<Object, HttpRequest> context, String checksum) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checksum, "checksum");
        return applyFlexibleChecksumsChecksum(context, checksum);
    }

    private final String userProvidedChecksumHeader(HttpRequest httpRequest, Logger logger) {
        Object obj;
        Iterator<T> it = httpRequest.getHeaders().names().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (StringsKt.startsWith(str, "x-amz-checksum-", true)) {
                boolean zEquals = StringsKt.equals(str, "x-amz-checksum-md5", true);
                if (zEquals) {
                    Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FlexibleChecksumsRequestInterceptor.userProvidedChecksumHeader$lambda$0$0$0();
                        }
                    }, 1, null);
                }
                if (!zEquals) {
                    obj = next;
                    break;
                }
            }
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String userProvidedChecksumHeader$lambda$0$0$0() {
        return "MD5 checksum was supplied via header, MD5 is not a supported algorithm, ignoring header";
    }

    private final void removeAllChecksumHeadersExcept(HeadersBuilder headersBuilder, String str) {
        Set<String> setNames = headersBuilder.names();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setNames) {
            String str2 = (String) obj;
            if (StringsKt.startsWith(str2, "x-amz-checksum-", true) && !StringsKt.equals(str2, str, true)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            headersBuilder.remove((String) it.next());
        }
    }
}
