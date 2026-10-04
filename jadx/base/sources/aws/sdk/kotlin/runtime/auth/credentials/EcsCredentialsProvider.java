package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.engine.CloseableHttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.DefaultHttpEngineKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.operation.EndpointResolver;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.HostAddress;
import aws.smithy.kotlin.runtime.net.HostResolver;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.google.android.gms.common.internal.ImagesContract;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import okhttp3.internal.p041ws.WebSocketProtocol;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: EcsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001f\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0082@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0016\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0019J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u00020\u0015H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/EcsCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "hostResolver", "Laws/smithy/kotlin/runtime/net/HostResolver;", "<init>", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/net/HostResolver;)V", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "manageEngine", "", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAuthToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAuthTokenFromFile", ClientCookie.PATH_ATTR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateRelativeUri", "Laws/smithy/kotlin/runtime/net/url/Url;", "relativeUri", "validateFullUri", "uri", "close", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EcsCredentialsProvider implements CloseableCredentialsProvider {
    private final HostResolver hostResolver;
    private final HttpClientEngine httpClient;
    private final boolean manageEngine;
    private final PlatformProvider platformProvider;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$loadAuthToken$1 */
    /* JADX INFO: compiled from: EcsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider", m1609f = "EcsCredentialsProvider.kt", m1610i = {0, 0}, m1611l = {115}, m1612m = "loadAuthToken", m1613n = {"it", "$i$a$-let-EcsCredentialsProvider$loadAuthToken$token$1"}, m1614nl = {115}, m1615s = {"L$0", "I$0"}, m1616v = 2)
    static final class C30021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C30021(Continuation<? super C30021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EcsCredentialsProvider.this.loadAuthToken(this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$loadAuthTokenFromFile$1 */
    /* JADX INFO: compiled from: EcsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider", m1609f = "EcsCredentialsProvider.kt", m1610i = {0}, m1611l = {WebSocketProtocol.PAYLOAD_SHORT}, m1612m = "loadAuthTokenFromFile", m1613n = {ClientCookie.PATH_ATTR}, m1614nl = {127}, m1615s = {"L$0"}, m1616v = 2)
    static final class C30031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C30031(Continuation<? super C30031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EcsCredentialsProvider.this.loadAuthTokenFromFile(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: EcsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider", m1609f = "EcsCredentialsProvider.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {79, 85, 100}, m1612m = "resolve", m1613n = {"attributes", "logger", "attributes", "logger", "authToken", "relativeUri", "fullUri", "attributes", "logger", "authToken", "relativeUri", "fullUri", ImagesContract.URL, "op", "client"}, m1614nl = {80, 86, 101}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, m1616v = 2)
    static final class C30041 extends ContinuationImpl {
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

        C30041(Continuation<? super C30041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EcsCredentialsProvider.this.resolve(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$validateFullUri$1 */
    /* JADX INFO: compiled from: EcsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider", m1609f = "EcsCredentialsProvider.kt", m1610i = {0, 0}, m1611l = {170}, m1612m = "validateFullUri", m1613n = {"uri", ImagesContract.URL}, m1614nl = {PDFACompliance.e_PDFA1_7_1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30051(Continuation<? super C30051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EcsCredentialsProvider.this.validateFullUri(null, this);
        }
    }

    public EcsCredentialsProvider() {
        this(null, null, null, 7, null);
    }

    public EcsCredentialsProvider(PlatformProvider platformProvider, CloseableHttpClientEngine closeableHttpClientEngine, HostResolver hostResolver) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(hostResolver, "hostResolver");
        this.platformProvider = platformProvider;
        this.hostResolver = hostResolver;
        this.manageEngine = closeableHttpClientEngine == null;
        this.httpClient = closeableHttpClientEngine == null ? DefaultHttpEngineKt.DefaultHttpEngine$default(null, 1, null) : closeableHttpClientEngine;
    }

    public /* synthetic */ EcsCredentialsProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine, HostResolver hostResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 2) != 0 ? null : httpClientEngine, (i & 4) != 0 ? HostResolver.INSTANCE.getDefault() : hostResolver);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public /* synthetic */ EcsCredentialsProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 2) != 0 ? null : httpClientEngine);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EcsCredentialsProvider(PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        this(platformProvider, httpClientEngine, HostResolver.INSTANCE.getDefault());
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Exception {
        C30041 c30041;
        Attributes attributes2;
        Logger logger;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Attributes attributes3;
        final Url urlValidateRelativeUri;
        Logger logger2;
        if (continuation instanceof C30041) {
            c30041 = (C30041) continuation;
            if ((c30041.label & Integer.MIN_VALUE) != 0) {
                c30041.label -= Integer.MIN_VALUE;
            } else {
                c30041 = new C30041(continuation);
            }
        }
        Object objRoundTrip = c30041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRoundTrip);
            CoroutineContext coroutineContext = c30041.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(EcsCredentialsProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger3 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            c30041.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30041.L$1 = logger3;
            c30041.label = 1;
            Object objLoadAuthToken = loadAuthToken(c30041);
            if (objLoadAuthToken != coroutine_suspended) {
                attributes2 = attributes;
                logger = logger3;
                objRoundTrip = objLoadAuthToken;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            Logger logger4 = (Logger) c30041.L$1;
            attributes2 = (Attributes) c30041.L$0;
            ResultKt.throwOnFailure(objRoundTrip);
            logger = logger4;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                logger2 = (Logger) c30041.L$1;
                try {
                    ResultKt.throwOnFailure(objRoundTrip);
                    final Credentials credentials = (Credentials) objRoundTrip;
                    Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EcsCredentialsProvider.resolve$lambda$3(credentials);
                        }
                    }, 1, null);
                    return AwsBusinessMetricsUtilsKt.withBusinessMetric(credentials, AwsBusinessMetric.Credentials.CREDENTIALS_HTTP);
                } catch (Exception e) {
                    e = e;
                    Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EcsCredentialsProvider.resolve$lambda$2();
                        }
                    }, 1, null);
                    if (e instanceof CredentialsProviderException) {
                        throw new CredentialsProviderException("Failed to get credentials from container metadata service", e);
                    }
                    throw e;
                }
            }
            str6 = (String) c30041.L$4;
            str5 = (String) c30041.L$3;
            str4 = (String) c30041.L$2;
            logger = (Logger) c30041.L$1;
            attributes3 = (Attributes) c30041.L$0;
            ResultKt.throwOnFailure(objRoundTrip);
            String str7 = str5;
            urlValidateRelativeUri = (Url) objRoundTrip;
            str = str4;
            attributes2 = attributes3;
            str3 = str6;
            str2 = str7;
            SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
            SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(Credentials.class));
            sdkHttpOperationBuilder.setSerializeWith(new EcsCredentialsSerializer(str));
            sdkHttpOperationBuilder.setDeserializeWith(new EcsCredentialsDeserializer());
            sdkHttpOperationBuilder.setOperationName("EcsCredentialsProvider");
            sdkHttpOperationBuilder.setServiceName("EcsContainerMetadata");
            sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolver() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$resolve$op$1$1
                @Override // aws.smithy.kotlin.runtime.http.operation.EndpointResolver
                public final Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation2) {
                    return new Endpoint(urlValidateRelativeUri, null, 2, null);
                }
            });
            SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
            Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EcsCredentialsProvider.resolve$lambda$1();
                }
            }, 1, null);
            SdkHttpClient sdkHttpClient = new SdkHttpClient(this.httpClient);
            try {
                Unit unit = Unit.INSTANCE;
                c30041.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                c30041.L$1 = logger;
                c30041.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c30041.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                c30041.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                c30041.L$5 = SpillingKt.nullOutSpilledVariable(urlValidateRelativeUri);
                c30041.L$6 = SpillingKt.nullOutSpilledVariable(sdkHttpOperationBuild);
                c30041.L$7 = SpillingKt.nullOutSpilledVariable(sdkHttpClient);
                c30041.label = 3;
                objRoundTrip = SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, sdkHttpClient, unit, c30041);
                if (objRoundTrip != coroutine_suspended) {
                    logger2 = logger;
                    final Credentials credentials2 = (Credentials) objRoundTrip;
                    Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EcsCredentialsProvider.resolve$lambda$3(credentials2);
                        }
                    }, 1, null);
                    return AwsBusinessMetricsUtilsKt.withBusinessMetric(credentials2, AwsBusinessMetric.Credentials.CREDENTIALS_HTTP);
                }
                return coroutine_suspended;
            } catch (Exception e2) {
                e = e2;
                logger2 = logger;
                Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EcsCredentialsProvider.resolve$lambda$2();
                    }
                }, 1, null);
                if (e instanceof CredentialsProviderException) {
                }
            }
        }
        str = (String) objRoundTrip;
        str2 = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsContainerCredentialsRelativeUri(), this.platformProvider);
        str3 = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsContainerCredentialsFullUri(), this.platformProvider);
        if (str2 == null || StringsKt.isBlank(str2)) {
            if (str3 == null || StringsKt.isBlank(str3)) {
                throw new ProviderConfigurationException("Container credentials URI not set", null, 2, null);
            }
            c30041.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
            c30041.L$1 = logger;
            c30041.L$2 = str;
            c30041.L$3 = SpillingKt.nullOutSpilledVariable(str2);
            c30041.L$4 = SpillingKt.nullOutSpilledVariable(str3);
            c30041.label = 2;
            Object objValidateFullUri = validateFullUri(str3, c30041);
            if (objValidateFullUri != coroutine_suspended) {
                Attributes attributes4 = attributes2;
                str4 = str;
                objRoundTrip = objValidateFullUri;
                str5 = str2;
                str6 = str3;
                attributes3 = attributes4;
                String str72 = str5;
                urlValidateRelativeUri = (Url) objRoundTrip;
                str = str4;
                attributes2 = attributes3;
                str3 = str6;
                str2 = str72;
                SdkHttpOperation.Companion companion2 = SdkHttpOperation.INSTANCE;
                SdkHttpOperationBuilder sdkHttpOperationBuilder2 = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(Credentials.class));
                sdkHttpOperationBuilder2.setSerializeWith(new EcsCredentialsSerializer(str));
                sdkHttpOperationBuilder2.setDeserializeWith(new EcsCredentialsDeserializer());
                sdkHttpOperationBuilder2.setOperationName("EcsCredentialsProvider");
                sdkHttpOperationBuilder2.setServiceName("EcsContainerMetadata");
                sdkHttpOperationBuilder2.getExecution().setEndpointResolver(new EndpointResolver() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$resolve$op$1$1
                    @Override // aws.smithy.kotlin.runtime.http.operation.EndpointResolver
                    public final Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation2) {
                        return new Endpoint(urlValidateRelativeUri, null, 2, null);
                    }
                });
                SdkHttpOperation sdkHttpOperationBuild2 = sdkHttpOperationBuilder2.build();
                Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EcsCredentialsProvider.resolve$lambda$1();
                    }
                }, 1, null);
                SdkHttpClient sdkHttpClient2 = new SdkHttpClient(this.httpClient);
                Unit unit2 = Unit.INSTANCE;
                c30041.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                c30041.L$1 = logger;
                c30041.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c30041.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                c30041.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                c30041.L$5 = SpillingKt.nullOutSpilledVariable(urlValidateRelativeUri);
                c30041.L$6 = SpillingKt.nullOutSpilledVariable(sdkHttpOperationBuild2);
                c30041.L$7 = SpillingKt.nullOutSpilledVariable(sdkHttpClient2);
                c30041.label = 3;
                objRoundTrip = SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild2, sdkHttpClient2, unit2, c30041);
                if (objRoundTrip != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        urlValidateRelativeUri = validateRelativeUri(str2);
        SdkHttpOperation.Companion companion22 = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder22 = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(Credentials.class));
        sdkHttpOperationBuilder22.setSerializeWith(new EcsCredentialsSerializer(str));
        sdkHttpOperationBuilder22.setDeserializeWith(new EcsCredentialsDeserializer());
        sdkHttpOperationBuilder22.setOperationName("EcsCredentialsProvider");
        sdkHttpOperationBuilder22.setServiceName("EcsContainerMetadata");
        sdkHttpOperationBuilder22.getExecution().setEndpointResolver(new EndpointResolver() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$resolve$op$1$1
            @Override // aws.smithy.kotlin.runtime.http.operation.EndpointResolver
            public final Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation2) {
                return new Endpoint(urlValidateRelativeUri, null, 2, null);
            }
        });
        SdkHttpOperation sdkHttpOperationBuild22 = sdkHttpOperationBuilder22.build();
        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.EcsCredentialsProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EcsCredentialsProvider.resolve$lambda$1();
            }
        }, 1, null);
        SdkHttpClient sdkHttpClient22 = new SdkHttpClient(this.httpClient);
        Unit unit22 = Unit.INSTANCE;
        c30041.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
        c30041.L$1 = logger;
        c30041.L$2 = SpillingKt.nullOutSpilledVariable(str);
        c30041.L$3 = SpillingKt.nullOutSpilledVariable(str2);
        c30041.L$4 = SpillingKt.nullOutSpilledVariable(str3);
        c30041.L$5 = SpillingKt.nullOutSpilledVariable(urlValidateRelativeUri);
        c30041.L$6 = SpillingKt.nullOutSpilledVariable(sdkHttpOperationBuild22);
        c30041.L$7 = SpillingKt.nullOutSpilledVariable(sdkHttpClient22);
        c30041.label = 3;
        objRoundTrip = SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild22, sdkHttpClient22, unit22, c30041);
        if (objRoundTrip != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$1() {
        return "retrieving container credentials";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$2() {
        return "failed to obtain credentials from container metadata service";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$3(Credentials credentials) {
        StringBuilder sb = new StringBuilder("obtained credentials from container metadata service; expiration=");
        Instant expiration = credentials.getExpiration();
        return sb.append(expiration != null ? expiration.format(TimestampFormat.ISO_8601) : null).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAuthToken(Continuation<? super String> continuation) {
        C30021 c30021;
        String str;
        if (continuation instanceof C30021) {
            c30021 = (C30021) continuation;
            if ((c30021.label & Integer.MIN_VALUE) != 0) {
                c30021.label -= Integer.MIN_VALUE;
            } else {
                c30021 = new C30021(continuation);
            }
        }
        Object objLoadAuthTokenFromFile = c30021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30021.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadAuthTokenFromFile);
            String str2 = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsContainerAuthorizationTokenFile(), this.platformProvider);
            if (str2 != null) {
                c30021.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                c30021.I$0 = 0;
                c30021.label = 1;
                objLoadAuthTokenFromFile = loadAuthTokenFromFile(str2, c30021);
                if (objLoadAuthTokenFromFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsContainerAuthorizationToken(), this.platformProvider);
            if (str == null) {
                return null;
            }
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "\r\n", false, 2, (Object) null)) {
                return str;
            }
            throw new CredentialsProviderException("Token contains illegal line break sequence.", null, 2, null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c30021.I$0;
        ResultKt.throwOnFailure(objLoadAuthTokenFromFile);
        str = (String) objLoadAuthTokenFromFile;
        if (str == null) {
            str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsContainerAuthorizationToken(), this.platformProvider);
            if (str == null) {
            }
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "\r\n", false, 2, (Object) null)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAuthTokenFromFile(String str, Continuation<? super String> continuation) {
        C30031 c30031;
        String strDecodeToString;
        if (continuation instanceof C30031) {
            c30031 = (C30031) continuation;
            if ((c30031.label & Integer.MIN_VALUE) != 0) {
                c30031.label -= Integer.MIN_VALUE;
            } else {
                c30031 = new C30031(continuation);
            }
        }
        Object fileOrNull = c30031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileOrNull);
            PlatformProvider platformProvider = this.platformProvider;
            c30031.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c30031.label = 1;
            fileOrNull = platformProvider.readFileOrNull(str, c30031);
            if (fileOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(fileOrNull);
        }
        byte[] bArr = (byte[]) fileOrNull;
        if (bArr == null || (strDecodeToString = StringsKt.decodeToString(bArr)) == null) {
            throw new CredentialsProviderException("Could not read token file.", null, 2, null);
        }
        return strDecodeToString;
    }

    private final Url validateRelativeUri(String relativeUri) {
        try {
            return Url.Companion.parse$default(Url.INSTANCE, "http://169.254.170.2" + relativeUri, null, 2, null);
        } catch (Exception e) {
            throw new ProviderConfigurationException("Invalid relativeUri `" + relativeUri + '`', e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object validateFullUri(String str, Continuation<? super Url> continuation) {
        C30051 c30051;
        Url url;
        Throwable th;
        String str2 = str;
        if (continuation instanceof C30051) {
            c30051 = (C30051) continuation;
            if ((c30051.label & Integer.MIN_VALUE) != 0) {
                c30051.label -= Integer.MIN_VALUE;
            } else {
                c30051 = new C30051(continuation);
            }
        }
        Object obj = c30051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Url url2 = Url.Companion.parse$default(Url.INSTANCE, str2, null, 2, null);
                if (!Intrinsics.areEqual(url2.getScheme(), Scheme.INSTANCE.getHTTPS())) {
                    Host host = url2.getHost();
                    if (host instanceof Host.IpAddress) {
                        Set set = EcsCredentialsProviderKt.allowedAddrs;
                        Host host2 = url2.getHost();
                        Intrinsics.checkNotNull(host2, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.net.Host.IpAddress");
                        if (!set.contains(((Host.IpAddress) host2).getAddress())) {
                            throw new ProviderConfigurationException("The container credentials full URI (" + str2 + ") has an invalid host. Host can only be one of [" + CollectionsKt.joinToString$default(EcsCredentialsProviderKt.allowedAddrs, null, null, null, 0, null, null, 63, null) + "].", null, 2, null);
                        }
                    } else {
                        if (!(host instanceof Host.Domain)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        try {
                            HostResolver hostResolver = this.hostResolver;
                            String string = url2.getHost().toString();
                            c30051.L$0 = str2;
                            c30051.L$1 = url2;
                            c30051.label = 1;
                            Object objResolve = hostResolver.resolve(string, c30051);
                            if (objResolve == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url = url2;
                            obj = objResolve;
                        } catch (Throwable th2) {
                            th = th2;
                            throw new ProviderConfigurationException("The container credentials full URI (" + str2 + ") is specified via a hostname whose IP address(es) could not be resolved. " + th.getMessage(), th);
                        }
                    }
                }
                return url2;
            } catch (Exception e) {
                throw new ProviderConfigurationException("Invalid fullUri `" + str2 + '`', e);
            }
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Url url3 = (Url) c30051.L$1;
        String str3 = (String) c30051.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            url = url3;
            str2 = str3;
        } catch (Throwable th3) {
            th = th3;
            str2 = str3;
            throw new ProviderConfigurationException("The container credentials full URI (" + str2 + ") is specified via a hostname whose IP address(es) could not be resolved. " + th.getMessage(), th);
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            List list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return url;
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((HostAddress) it.next()).getAddress().isLoopBack()) {
                }
            }
            return url;
        }
        throw new ProviderConfigurationException("The container credentials full URI (" + str2 + ") is specified via a hostname whose IP address(es) do not resolve to the loopback device.", null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.manageEngine) {
            CloseableKt.closeIfCloseable(this.httpClient);
        }
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
