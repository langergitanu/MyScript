package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.SsoClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.SsoClientKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.GetRoleCredentialsRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.GetRoleCredentialsResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.RoleCredentials;
import aws.sdk.kotlin.runtime.config.AwsSdkClientOption;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.InstantKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SsoCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J\n\u0010$\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/SsoCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "accountId", "", "roleName", "startUrl", "ssoRegion", "ssoSessionName", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/time/Clock;)V", "getAccountId", "()Ljava/lang/String;", "getRoleName", "getStartUrl", "getSsoRegion", "getSsoSessionName", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "ssoTokenProvider", "Laws/sdk/kotlin/runtime/auth/credentials/SsoTokenProvider;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "legacyLoadTokenFile", "Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoCredentialsProvider implements CredentialsProvider {
    private final String accountId;
    private final Clock clock;
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final String roleName;
    private final String ssoRegion;
    private final String ssoSessionName;
    private final SsoTokenProvider ssoTokenProvider;
    private final String startUrl;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider$legacyLoadTokenFile$1 */
    /* JADX INFO: compiled from: SsoCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider", m1609f = "SsoCredentialsProvider.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_4_2}, m1612m = "legacyLoadTokenFile", m1613n = {}, m1614nl = {143}, m1615s = {}, m1616v = 2)
    static final class C30231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C30231(Continuation<? super C30231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoCredentialsProvider.this.legacyLoadTokenFile(this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: SsoCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider", m1609f = "SsoCredentialsProvider.kt", m1610i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, m1611l = {PDFACompliance.e_PDFA9_4, 97, 101, 155}, m1612m = "resolve", m1613n = {"attributes", "logger", "attributes", "logger", "attributes", "logger", "token", "telemetry", "attributes", "logger", "token", "telemetry", "client", "$this$getRoleCredentials$iv", "$i$f$getRoleCredentials"}, m1614nl = {96, PDFACompliance.e_PDFA9_2, 110, 119}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
    static final class C30241 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C30241(Continuation<? super C30241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoCredentialsProvider.this.resolve(null, this);
        }
    }

    public SsoCredentialsProvider(String accountId, String roleName, String startUrl, String ssoRegion, String str, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock) {
        SsoTokenProvider ssoTokenProvider;
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(startUrl, "startUrl");
        Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.accountId = accountId;
        this.roleName = roleName;
        this.startUrl = startUrl;
        this.ssoRegion = ssoRegion;
        this.ssoSessionName = str;
        this.httpClient = httpClientEngine;
        this.platformProvider = platformProvider;
        this.clock = clock;
        if (str != null) {
            ssoTokenProvider = new SsoTokenProvider(str, startUrl, ssoRegion, 0L, httpClientEngine, platformProvider, clock, 8, null);
        } else {
            ssoTokenProvider = null;
        }
        this.ssoTokenProvider = ssoTokenProvider;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getRoleName() {
        return this.roleName;
    }

    public final String getStartUrl() {
        return this.startUrl;
    }

    public final String getSsoRegion() {
        return this.ssoRegion;
    }

    public final String getSsoSessionName() {
        return this.ssoSessionName;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public /* synthetic */ SsoCredentialsProvider(String str, String str2, String str3, String str4, String str5, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : httpClientEngine, (i & 64) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 128) != 0 ? Clock.System.INSTANCE : system);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c5, code lost:
    
        if (r3 == r2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        if (r3 == r2) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Throwable {
        C30241 c30241;
        Logger logger;
        Object objLegacyLoadTokenFile;
        Object objResolve;
        BearerToken bearerToken;
        final Attributes attributes2;
        final TelemetryProvider telemetryProvider;
        Logger logger2;
        SsoClient ssoClient;
        SsoClient ssoClient2;
        RoleCredentials roleCredentials;
        if (continuation instanceof C30241) {
            c30241 = (C30241) continuation;
            if ((c30241.label & Integer.MIN_VALUE) != 0) {
                c30241.label -= Integer.MIN_VALUE;
            } else {
                c30241 = new C30241(continuation);
            }
        }
        Object roleCredentials2 = c30241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30241.label;
        if (i == 0) {
            ResultKt.throwOnFailure(roleCredentials2);
            CoroutineContext coroutineContext = c30241.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(SsoCredentialsProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            if (this.ssoTokenProvider != null) {
                Logger.trace$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoCredentialsProvider.resolve$lambda$0(this.f$0);
                    }
                }, 1, null);
                SsoTokenProvider ssoTokenProvider = this.ssoTokenProvider;
                c30241.L$0 = attributes;
                c30241.L$1 = SpillingKt.nullOutSpilledVariable(logger);
                c30241.label = 1;
                objResolve = ssoTokenProvider.resolve(attributes, c30241);
            } else {
                Logger.trace$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoCredentialsProvider.resolve$lambda$1();
                    }
                }, 1, null);
                c30241.L$0 = attributes;
                c30241.L$1 = SpillingKt.nullOutSpilledVariable(logger);
                c30241.label = 2;
                objLegacyLoadTokenFile = legacyLoadTokenFile(c30241);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            Logger logger3 = (Logger) c30241.L$1;
            Attributes attributes3 = (Attributes) c30241.L$0;
            ResultKt.throwOnFailure(roleCredentials2);
            logger = logger3;
            attributes = attributes3;
            objResolve = roleCredentials2;
            bearerToken = (BearerToken) objResolve;
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = c30241.I$0;
                    ssoClient2 = (SsoClient) c30241.L$4;
                    try {
                        try {
                            ResultKt.throwOnFailure(roleCredentials2);
                            GetRoleCredentialsResponse getRoleCredentialsResponse = (GetRoleCredentialsResponse) roleCredentials2;
                            ssoClient2.close();
                            roleCredentials = getRoleCredentialsResponse.getRoleCredentials();
                            if (roleCredentials != null) {
                                throw new CredentialsProviderException("Expected SSO roleCredentials to not be null", null, 2, null);
                            }
                            String accessKeyId = roleCredentials.getAccessKeyId();
                            if (accessKeyId == null) {
                                throw new IllegalStateException("Expected accessKeyId in SSO roleCredentials response".toString());
                            }
                            String secretAccessKey = roleCredentials.getSecretAccessKey();
                            if (secretAccessKey != null) {
                                Credentials credentials = CredentialsExtKt.credentials(accessKeyId, secretAccessKey, roleCredentials.getSessionToken(), InstantKt.fromEpochMilliseconds(Instant.INSTANCE, roleCredentials.getExpiration()), SsoClientKt.ServiceId, this.accountId);
                                if (this.ssoTokenProvider != null) {
                                    return AwsBusinessMetricsUtilsKt.withBusinessMetric(credentials, AwsBusinessMetric.Credentials.CREDENTIALS_SSO);
                                }
                                return AwsBusinessMetricsUtilsKt.withBusinessMetric(credentials, AwsBusinessMetric.Credentials.CREDENTIALS_SSO_LEGACY);
                            }
                            throw new IllegalStateException("Expected secretAccessKey in SSO roleCredentials response".toString());
                        } catch (Exception e) {
                            e = e;
                            throw new CredentialsNotLoadedException("GetRoleCredentials operation failed", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        ssoClient2.close();
                        throw th;
                    }
                }
                telemetryProvider = (TelemetryProvider) c30241.L$3;
                bearerToken = (BearerToken) c30241.L$2;
                logger2 = (Logger) c30241.L$1;
                attributes2 = (Attributes) c30241.L$0;
                ResultKt.throwOnFailure(roleCredentials2);
                ssoClient = (SsoClient) roleCredentials2;
                try {
                    GetRoleCredentialsRequest.Builder builder = new GetRoleCredentialsRequest.Builder();
                    builder.setAccountId(getAccountId());
                    builder.setRoleName(getRoleName());
                    builder.setAccessToken(bearerToken.getToken());
                    GetRoleCredentialsRequest getRoleCredentialsRequestBuild = builder.build();
                    c30241.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                    c30241.L$1 = SpillingKt.nullOutSpilledVariable(logger2);
                    c30241.L$2 = SpillingKt.nullOutSpilledVariable(bearerToken);
                    c30241.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
                    c30241.L$4 = ssoClient;
                    c30241.L$5 = SpillingKt.nullOutSpilledVariable(ssoClient);
                    c30241.I$0 = 0;
                    c30241.label = 4;
                    roleCredentials2 = ssoClient.getRoleCredentials(getRoleCredentialsRequestBuild, c30241);
                    if (roleCredentials2 != coroutine_suspended) {
                        ssoClient2 = ssoClient;
                        GetRoleCredentialsResponse getRoleCredentialsResponse2 = (GetRoleCredentialsResponse) roleCredentials2;
                        ssoClient2.close();
                        roleCredentials = getRoleCredentialsResponse2.getRoleCredentials();
                        if (roleCredentials != null) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e2) {
                    e = e2;
                    ssoClient2 = ssoClient;
                    throw new CredentialsNotLoadedException("GetRoleCredentials operation failed", e);
                } catch (Throwable th2) {
                    th = th2;
                    ssoClient2 = ssoClient;
                    ssoClient2.close();
                    throw th;
                }
            }
            Logger logger4 = (Logger) c30241.L$1;
            Attributes attributes4 = (Attributes) c30241.L$0;
            ResultKt.throwOnFailure(roleCredentials2);
            logger = logger4;
            attributes = attributes4;
            objLegacyLoadTokenFile = roleCredentials2;
            bearerToken = (BearerToken) objLegacyLoadTokenFile;
        }
        attributes2 = attributes;
        telemetryProvider = TelemetryProviderContextKt.getTelemetryProvider(c30241.get$context());
        SsoClient.Companion companion = SsoClient.INSTANCE;
        Function1 function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoCredentialsProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SsoCredentialsProvider.resolve$lambda$2(this.f$0, telemetryProvider, attributes2, (SsoClient.Config.Builder) obj);
            }
        };
        c30241.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
        c30241.L$1 = SpillingKt.nullOutSpilledVariable(logger);
        c30241.L$2 = bearerToken;
        c30241.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
        c30241.label = 3;
        Object objFromEnvironment = companion.fromEnvironment(function1, c30241);
        if (objFromEnvironment != coroutine_suspended) {
            logger2 = logger;
            roleCredentials2 = objFromEnvironment;
            ssoClient = (SsoClient) roleCredentials2;
            GetRoleCredentialsRequest.Builder builder2 = new GetRoleCredentialsRequest.Builder();
            builder2.setAccountId(getAccountId());
            builder2.setRoleName(getRoleName());
            builder2.setAccessToken(bearerToken.getToken());
            GetRoleCredentialsRequest getRoleCredentialsRequestBuild2 = builder2.build();
            c30241.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
            c30241.L$1 = SpillingKt.nullOutSpilledVariable(logger2);
            c30241.L$2 = SpillingKt.nullOutSpilledVariable(bearerToken);
            c30241.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
            c30241.L$4 = ssoClient;
            c30241.L$5 = SpillingKt.nullOutSpilledVariable(ssoClient);
            c30241.I$0 = 0;
            c30241.label = 4;
            roleCredentials2 = ssoClient.getRoleCredentials(getRoleCredentialsRequestBuild2, c30241);
            if (roleCredentials2 != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0(SsoCredentialsProvider ssoCredentialsProvider) {
        return "Attempting to load token using token provider for sso-session: `" + ssoCredentialsProvider.ssoSessionName + '`';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$1() {
        return "Attempting to load token from file using legacy format";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolve$lambda$2(SsoCredentialsProvider ssoCredentialsProvider, TelemetryProvider telemetryProvider, Attributes attributes, SsoClient.Config.Builder fromEnvironment) {
        Intrinsics.checkNotNullParameter(fromEnvironment, "$this$fromEnvironment");
        fromEnvironment.setRegion(ssoCredentialsProvider.ssoRegion);
        fromEnvironment.setHttpClient(ssoCredentialsProvider.httpClient);
        fromEnvironment.setTelemetryProvider(telemetryProvider);
        fromEnvironment.setLogMode((LogMode) attributes.getOrNull(SdkClientOption.INSTANCE.getLogMode()));
        fromEnvironment.setApplicationId((String) attributes.getOrNull(AwsSdkClientOption.INSTANCE.getApplicationId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object legacyLoadTokenFile(Continuation<? super SsoToken> continuation) {
        C30231 c30231;
        if (continuation instanceof C30231) {
            c30231 = (C30231) continuation;
            if ((c30231.label & Integer.MIN_VALUE) != 0) {
                c30231.label -= Integer.MIN_VALUE;
            } else {
                c30231 = new C30231(continuation);
            }
        }
        Object tokenFromCache = c30231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(tokenFromCache);
            String str = this.startUrl;
            PlatformProvider platformProvider = this.platformProvider;
            c30231.label = 1;
            tokenFromCache = SsoTokenProviderKt.readTokenFromCache(str, platformProvider, c30231);
            if (tokenFromCache == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(tokenFromCache);
        }
        SsoToken ssoToken = (SsoToken) tokenFromCache;
        if (this.clock.getNow().compareTo(ssoToken.getExpiration()) <= 0) {
            return ssoToken;
        }
        throw new ProviderConfigurationException("The SSO session has expired. To refresh this SSO session run `aws sso login` with the corresponding profile.", null, 2, null);
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
