package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.compose.runtime.GapComposerKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClientKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.AccessDeniedException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.AccessToken;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequestBody;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponseBody;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SingleFlightGroup;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020#H\u0082@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020#H\u0082@¢\u0006\u0002\u0010,J \u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u00105\u001a\u00020#2\u0006\u0010+\u001a\u00020#H\u0082@¢\u0006\u0002\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/LoginTokenProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "loginSessionName", "", TtmlNode.TAG_REGION, "refreshBufferWindow", "Lkotlin/time/Duration;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "cacheDirectory", "client", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLaws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/time/Clock;Ljava/lang/String;Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLoginSessionName", "()Ljava/lang/String;", "getRegion", "getRefreshBufferWindow-UwyO8pc", "()J", "J", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getClock", "()Laws/smithy/kotlin/runtime/time/Clock;", "getCacheDirectory", "getClient", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "sfg", "Laws/smithy/kotlin/runtime/util/SingleFlightGroup;", "Laws/sdk/kotlin/runtime/auth/credentials/LoginToken;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "attemptRefresh", "oldToken", "(Laws/sdk/kotlin/runtime/auth/credentials/LoginToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeToken", "", "refreshed", "throwTokenExpired", "", "cause", "", "message", "refreshToken", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginTokenProvider implements CredentialsProvider {
    private final String cacheDirectory;
    private final SigninClient client;
    private final Clock clock;
    private final HttpClientEngine httpClient;
    private final String loginSessionName;
    private final PlatformProvider platformProvider;
    private final long refreshBufferWindow;
    private final String region;
    private final SingleFlightGroup<LoginToken> sfg;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$attemptRefresh$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider", m1609f = "LoginTokenProvider.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {134, TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1612m = "attemptRefresh", m1613n = {"oldToken", "$this$attemptRefresh_u24lambda_u241", "$i$a$-runCatching-LoginTokenProvider$attemptRefresh$result$1", "oldToken", "result", "refreshed", "$i$a$-onSuccess-LoginTokenProvider$attemptRefresh$3"}, m1614nl = {134, TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$3", "I$0"}, m1616v = 2)
    static final class C30121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30121(Continuation<? super C30121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProvider.this.attemptRefresh(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$getToken$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider", m1609f = "LoginTokenProvider.kt", m1610i = {0, 1, 1}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, 124}, m1612m = "getToken", m1613n = {"attributes", "attributes", "token"}, m1614nl = {118, GapComposerKt.nodeKey}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 2)
    static final class C30131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30131(Continuation<? super C30131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProvider.this.getToken(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$refreshToken$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider", m1609f = "LoginTokenProvider.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {455}, m1612m = "refreshToken", m1613n = {"oldToken", "$this$use$iv", "client", "$this$createOAuth2Token$iv", "$completion$iv", "$i$f$use", "closed$iv", "$i$a$-use-LoginTokenProvider$refreshToken$3", "$i$f$createOAuth2Token"}, m1614nl = {166}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
    static final class C30141 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C30141(Continuation<? super C30141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProvider.this.refreshToken(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$resolve$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider", m1609f = "LoginTokenProvider.kt", m1610i = {0}, m1611l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1612m = "resolve", m1613n = {"attributes"}, m1614nl = {106}, m1615s = {"L$0"}, m1616v = 2)
    static final class C30151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C30151(Continuation<? super C30151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProvider.this.resolve(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$writeToken$1 */
    /* JADX INFO: compiled from: LoginTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider", m1609f = "LoginTokenProvider.kt", m1610i = {0, 0, 0, 0}, m1611l = {152}, m1612m = "writeToken", m1613n = {"refreshed", "cacheKey", "filepath", "contents"}, m1614nl = {153}, m1615s = {"L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C30161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30161(Continuation<? super C30161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginTokenProvider.this.writeToken(null, this);
        }
    }

    public /* synthetic */ LoginTokenProvider(String str, String str2, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock, String str3, SigninClient signinClient, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, httpClientEngine, platformProvider, clock, str3, signinClient);
    }

    private LoginTokenProvider(String loginSessionName, String str, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock, String cacheDirectory, SigninClient client) {
        Intrinsics.checkNotNullParameter(loginSessionName, "loginSessionName");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        Intrinsics.checkNotNullParameter(client, "client");
        this.loginSessionName = loginSessionName;
        this.region = str;
        this.refreshBufferWindow = j;
        this.httpClient = httpClientEngine;
        this.platformProvider = platformProvider;
        this.clock = clock;
        this.cacheDirectory = cacheDirectory;
        this.client = client;
        this.sfg = new SingleFlightGroup<>();
    }

    public final String getLoginSessionName() {
        return this.loginSessionName;
    }

    public final String getRegion() {
        return this.region;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginTokenProvider(String str, String str2, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock, String str3, SigninClient signinClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        String str4 = (i & 2) != 0 ? null : str2;
        if ((i & 4) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(300, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(str, str4, duration, (i & 8) != 0 ? null : httpClientEngine, (i & 16) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 32) != 0 ? Clock.System.INSTANCE : clock, str3, signinClient, null);
    }

    /* JADX INFO: renamed from: getRefreshBufferWindow-UwyO8pc, reason: not valid java name and from getter */
    public final long getRefreshBufferWindow() {
        return this.refreshBufferWindow;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final String getCacheDirectory() {
        return this.cacheDirectory;
    }

    public final SigninClient getClient() {
        return this.client;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        C30151 c30151;
        if (continuation instanceof C30151) {
            c30151 = (C30151) continuation;
            if ((c30151.label & Integer.MIN_VALUE) != 0) {
                c30151.label -= Integer.MIN_VALUE;
            } else {
                c30151 = new C30151(continuation);
            }
        }
        Object objSingleFlight = c30151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSingleFlight);
            SingleFlightGroup<LoginToken> singleFlightGroup = this.sfg;
            LoginTokenProvider$resolve$token$1 loginTokenProvider$resolve$token$1 = new LoginTokenProvider$resolve$token$1(this, attributes, null);
            c30151.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30151.label = 1;
            objSingleFlight = singleFlightGroup.singleFlight(loginTokenProvider$resolve$token$1, c30151);
            if (objSingleFlight == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSingleFlight);
        }
        LoginToken loginToken = (LoginToken) objSingleFlight;
        return CredentialsExtKt.credentials(loginToken.getAccessKeyId(), loginToken.getSecretAccessKey(), loginToken.getSessionToken(), loginToken.getExpiresAt(), "LOGIN", loginToken.getAccountId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getToken(Attributes attributes, Continuation<? super LoginToken> continuation) {
        C30131 c30131;
        Exception e;
        final LoginToken loginToken;
        if (continuation instanceof C30131) {
            c30131 = (C30131) continuation;
            if ((c30131.label & Integer.MIN_VALUE) != 0) {
                c30131.label -= Integer.MIN_VALUE;
            } else {
                c30131 = new C30131(continuation);
            }
        }
        Object loginTokenFromCache = c30131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(loginTokenFromCache);
            String str = this.loginSessionName;
            PlatformProvider platformProvider = this.platformProvider;
            String str2 = this.cacheDirectory;
            c30131.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30131.label = 1;
            loginTokenFromCache = LoginTokenProviderKt.readLoginTokenFromCache(str, platformProvider, str2, c30131);
            if (loginTokenFromCache != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            loginToken = (LoginToken) c30131.L$1;
            try {
                ResultKt.throwOnFailure(loginTokenFromCache);
                return (LoginToken) loginTokenFromCache;
            } catch (Exception e2) {
                e = e2;
                if (this.clock.getNow().compareTo(loginToken.getExpiresAt()) >= 0) {
                    loginToken = null;
                }
                if (loginToken == null) {
                    CoroutineContext context = c30131.getContext();
                    Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LoginTokenProvider.getToken$lambda$2$0(loginToken, this);
                        }
                    };
                    LogLevel logLevel = LogLevel.Debug;
                    String qualifiedName = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
                    if (qualifiedName == null) {
                        throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                    }
                    CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
                    return loginToken;
                }
                throwTokenExpired$default(this, e, null, 2, null);
                throw new KotlinNothingValueException();
            }
        }
        attributes = (Attributes) c30131.L$0;
        ResultKt.throwOnFailure(loginTokenFromCache);
        LoginToken loginToken2 = (LoginToken) loginTokenFromCache;
        if (this.clock.getNow().compareTo(loginToken2.getExpiresAt().m12288minusLRDsOJo(this.refreshBufferWindow)) < 0) {
            CoroutineContext context2 = c30131.getContext();
            Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginTokenProvider.getToken$lambda$0(this.f$0);
                }
            };
            LogLevel logLevel2 = LogLevel.Debug;
            String qualifiedName2 = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
            if (qualifiedName2 == null) {
                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
            }
            CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName2, null, function02);
            return loginToken2;
        }
        try {
            c30131.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30131.L$1 = loginToken2;
            c30131.label = 2;
            Object objAttemptRefresh = attemptRefresh(loginToken2, c30131);
            if (objAttemptRefresh != coroutine_suspended) {
                loginTokenFromCache = objAttemptRefresh;
                loginToken = loginToken2;
                return (LoginToken) loginTokenFromCache;
            }
            return coroutine_suspended;
        } catch (Exception e3) {
            e = e3;
            loginToken = loginToken2;
            if (this.clock.getNow().compareTo(loginToken.getExpiresAt()) >= 0) {
            }
            if (loginToken == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getToken$lambda$0(LoginTokenProvider loginTokenProvider) {
        return "using cached token for login-session: " + loginTokenProvider.loginSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getToken$lambda$2$0(LoginToken loginToken, LoginTokenProvider loginTokenProvider) {
        return "cached token is not refreshable but still valid until " + loginToken.getExpiresAt() + " for login-session: " + loginTokenProvider.loginSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object attemptRefresh(LoginToken loginToken, Continuation<? super LoginToken> continuation) {
        C30121 c30121;
        Object objM14499constructorimpl;
        final LoginToken loginToken2;
        Object obj;
        LoginToken loginToken3;
        Throwable thM14502exceptionOrNullimpl;
        if (continuation instanceof C30121) {
            c30121 = (C30121) continuation;
            if ((c30121.label & Integer.MIN_VALUE) != 0) {
                c30121.label -= Integer.MIN_VALUE;
            } else {
                c30121 = new C30121(continuation);
            }
        }
        Object objRefreshToken = c30121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30121.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(objRefreshToken);
            CoroutineContext context = c30121.getContext();
            Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginTokenProvider.attemptRefresh$lambda$0(this.f$0);
                }
            };
            LogLevel logLevel = LogLevel.Debug;
            String qualifiedName = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
            }
            CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
            Result.Companion companion2 = Result.INSTANCE;
            LoginTokenProvider loginTokenProvider = this;
            c30121.L$0 = loginToken;
            c30121.L$1 = SpillingKt.nullOutSpilledVariable(this);
            c30121.I$0 = 0;
            c30121.label = 1;
            objRefreshToken = refreshToken(loginToken, c30121);
            if (objRefreshToken == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30121.I$0;
                obj = c30121.L$2;
                Object obj2 = c30121.L$1;
                loginToken3 = (LoginToken) c30121.L$0;
                ResultKt.throwOnFailure(objRefreshToken);
                loginToken2 = loginToken3;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
                if (thM14502exceptionOrNullimpl != null) {
                    return obj;
                }
                if (this.clock.getNow().compareTo(loginToken2.getExpiresAt()) >= 0) {
                    CoroutineContext context2 = c30121.getContext();
                    Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LoginTokenProvider.attemptRefresh$lambda$3$0();
                        }
                    };
                    LogLevel logLevel2 = LogLevel.Error;
                    String qualifiedName2 = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
                    if (qualifiedName2 == null) {
                        throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                    }
                    CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName2, thM14502exceptionOrNullimpl, function02);
                    throwTokenExpired$default(this, thM14502exceptionOrNullimpl, null, 2, null);
                    throw new KotlinNothingValueException();
                }
                CoroutineContext context3 = c30121.getContext();
                Function0 function03 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LoginTokenProvider.attemptRefresh$lambda$3$1(loginToken2, this);
                    }
                };
                LogLevel logLevel3 = LogLevel.Debug;
                String qualifiedName3 = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
                if (qualifiedName3 == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context3, logLevel3, qualifiedName3, null, function03);
                return loginToken2;
            }
            int i3 = c30121.I$0;
            loginToken = (LoginToken) c30121.L$0;
            ResultKt.throwOnFailure(objRefreshToken);
        }
        objM14499constructorimpl = Result.m14499constructorimpl((LoginToken) objRefreshToken);
        Object obj3 = objM14499constructorimpl;
        loginToken2 = loginToken;
        obj = obj3;
        if (Result.m14506isSuccessimpl(obj)) {
            LoginToken loginToken4 = (LoginToken) obj;
            c30121.L$0 = loginToken2;
            c30121.L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c30121.L$2 = obj;
            c30121.L$3 = SpillingKt.nullOutSpilledVariable(loginToken4);
            c30121.I$0 = 0;
            c30121.label = 2;
            if (writeToken(loginToken4, c30121) != coroutine_suspended) {
                loginToken3 = loginToken2;
                loginToken2 = loginToken3;
            }
            return coroutine_suspended;
        }
        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
        if (thM14502exceptionOrNullimpl != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$0(LoginTokenProvider loginTokenProvider) {
        return "attempting to refresh token for login-session: " + loginTokenProvider.loginSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$3$0() {
        return "token refresh failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$3$1(LoginToken loginToken, LoginTokenProvider loginTokenProvider) {
        return "refresh token failed, original token is still valid until " + loginToken.getExpiresAt() + " for login-session: " + loginTokenProvider.loginSessionName + ", re-using";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeToken(LoginToken loginToken, Continuation<? super Unit> continuation) throws Exception {
        C30161 c30161;
        final String str;
        String qualifiedName;
        if (continuation instanceof C30161) {
            c30161 = (C30161) continuation;
            if ((c30161.label & Integer.MIN_VALUE) != 0) {
                c30161.label -= Integer.MIN_VALUE;
            } else {
                c30161 = new C30161(continuation);
            }
        }
        Object obj = c30161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30161.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c30161.L$2;
            try {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } catch (Exception e) {
                e = e;
                CoroutineContext context = c30161.getContext();
                Exception exc = e;
                Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LoginTokenProvider.writeToken$lambda$0(str);
                    }
                };
                LogLevel logLevel = LogLevel.Debug;
                qualifiedName = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
                if (qualifiedName != null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, exc, function0);
                throw e;
            }
        }
        ResultKt.throwOnFailure(obj);
        String loginCacheFilename = LoginTokenProviderKt.getLoginCacheFilename(this.loginSessionName);
        String strNormalizePath = AwsConfigLoaderKt.normalizePath(SsoTokenProviderKt.filepath(this.platformProvider, this.cacheDirectory, loginCacheFilename), this.platformProvider);
        byte[] bArrSerializeLoginToken = LoginTokenProviderKt.serializeLoginToken(loginToken);
        try {
            PlatformProvider platformProvider = this.platformProvider;
            c30161.L$0 = SpillingKt.nullOutSpilledVariable(loginToken);
            c30161.L$1 = SpillingKt.nullOutSpilledVariable(loginCacheFilename);
            c30161.L$2 = strNormalizePath;
            c30161.L$3 = SpillingKt.nullOutSpilledVariable(bArrSerializeLoginToken);
            c30161.label = 1;
            if (platformProvider.writeFile(strNormalizePath, bArrSerializeLoginToken, c30161) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Exception e2) {
            e = e2;
            str = strNormalizePath;
            CoroutineContext context2 = c30161.getContext();
            Exception exc2 = e;
            Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginTokenProvider.writeToken$lambda$0(str);
                }
            };
            LogLevel logLevel2 = LogLevel.Debug;
            qualifiedName = Reflection.getOrCreateKotlinClass(LoginTokenProvider.class).getQualifiedName();
            if (qualifiedName != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeToken$lambda$0(String str) {
        return "failed to write refreshed token back to disk at " + str;
    }

    private final Void throwTokenExpired(Throwable cause, String message) {
        if (message == null) {
            message = "Login token for login-session: " + this.loginSessionName + " is expired";
        }
        throw new InvalidLoginTokenException(message, cause);
    }

    static /* synthetic */ Void throwTokenExpired$default(LoginTokenProvider loginTokenProvider, Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return loginTokenProvider.throwTokenExpired(th, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0112 A[Catch: all -> 0x004e, TryCatch #3 {all -> 0x004e, blocks: (B:12:0x0049, B:26:0x00ad, B:31:0x010e, B:33:0x0112, B:35:0x011d, B:37:0x0121, B:39:0x0125, B:41:0x0129, B:42:0x0137, B:43:0x0138, B:44:0x0139, B:45:0x0147, B:46:0x0148, B:47:0x0154, B:48:0x0155, B:49:0x0163, B:50:0x0164), top: B:64:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0164 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #3 {all -> 0x004e, blocks: (B:12:0x0049, B:26:0x00ad, B:31:0x010e, B:33:0x0112, B:35:0x011d, B:37:0x0121, B:39:0x0125, B:41:0x0129, B:42:0x0137, B:43:0x0138, B:44:0x0139, B:45:0x0147, B:46:0x0148, B:47:0x0154, B:48:0x0155, B:49:0x0163, B:50:0x0164), top: B:64:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshToken(LoginToken loginToken, Continuation<? super LoginToken> continuation) throws Throwable {
        C30141 c30141;
        Closeable closeable;
        final LoginToken loginToken2 = loginToken;
        if (continuation instanceof C30141) {
            c30141 = (C30141) continuation;
            if ((c30141.label & Integer.MIN_VALUE) != 0) {
                c30141.label -= Integer.MIN_VALUE;
            } else {
                c30141 = new C30141(continuation);
            }
        }
        Object obj = c30141.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30141.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SigninClient signinClientWithConfig = SigninClientKt.withConfig(this.client, new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LoginTokenProvider.refreshToken$lambda$0(loginToken2, (SigninClient.Config.Builder) obj2);
                    }
                });
                try {
                    SigninClient signinClient = signinClientWithConfig;
                    try {
                        CreateOAuth2TokenRequest.Builder builder = new CreateOAuth2TokenRequest.Builder();
                        builder.tokenInput(new Function1<CreateOAuth2TokenRequestBody.Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$refreshToken$3$result$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(CreateOAuth2TokenRequestBody.Builder builder2) {
                                invoke2(builder2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(CreateOAuth2TokenRequestBody.Builder tokenInput) {
                                Intrinsics.checkNotNullParameter(tokenInput, "$this$tokenInput");
                                tokenInput.setClientId(loginToken2.getClientId());
                                tokenInput.setGrantType("refresh_token");
                                tokenInput.setRefreshToken(loginToken2.getRefreshToken());
                            }
                        });
                        CreateOAuth2TokenRequest createOAuth2TokenRequestBuild = builder.build();
                        c30141.L$0 = loginToken2;
                        c30141.L$1 = signinClientWithConfig;
                        c30141.L$2 = SpillingKt.nullOutSpilledVariable(signinClient);
                        c30141.L$3 = SpillingKt.nullOutSpilledVariable(signinClient);
                        c30141.L$4 = SpillingKt.nullOutSpilledVariable(c30141);
                        c30141.I$0 = 0;
                        c30141.I$1 = 0;
                        c30141.I$2 = 0;
                        c30141.I$3 = 0;
                        c30141.label = 1;
                        Object objCreateOAuth2Token = signinClient.createOAuth2Token(createOAuth2TokenRequestBuild, c30141);
                        if (objCreateOAuth2Token == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        closeable = signinClientWithConfig;
                        obj = objCreateOAuth2Token;
                    } catch (Exception e) {
                        e = e;
                        if (!(e instanceof AccessDeniedException)) {
                            OAuth2ErrorCode error = ((AccessDeniedException) e).getError();
                            if (error instanceof OAuth2ErrorCode.AuthcodeExpired) {
                                Unit unit = Unit.INSTANCE;
                                throwTokenExpired(e, "Unable to complete the login process due to an expired authorization code. Please reauthenticate using 'aws login'.");
                                throw new KotlinNothingValueException();
                            }
                            if (error instanceof OAuth2ErrorCode.TokenExpired) {
                                throwTokenExpired(e, "Your session has expired. Please reauthenticate.");
                                throw new KotlinNothingValueException();
                            }
                            if (error instanceof OAuth2ErrorCode.UserCredentialsChanged) {
                                Unit unit2 = Unit.INSTANCE;
                                throwTokenExpired(e, "Unable to refresh credentials because of a change in your password. Please reauthenticate with your new password.");
                                throw new KotlinNothingValueException();
                            }
                            if (error instanceof OAuth2ErrorCode.InsufficientPermissions) {
                                Unit unit3 = Unit.INSTANCE;
                                throwTokenExpired(e, "Unable to refresh credentials due to insufficient permissions. You may be missing permission for the 'CreateOAuth2Token' action.");
                                throw new KotlinNothingValueException();
                            }
                            throw e;
                        }
                        throw e;
                    }
                } catch (Throwable th) {
                    th = th;
                    coroutine_suspended = signinClientWithConfig;
                    Throwable th2 = th;
                    try {
                        coroutine_suspended.close();
                        throw th2;
                    } catch (Throwable th3) {
                        ExceptionsKt.addSuppressed(th2, th3);
                        throw th2;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30141.I$3;
                int i3 = c30141.I$2;
                int i4 = c30141.I$1;
                int i5 = c30141.I$0;
                closeable = (Closeable) c30141.L$1;
                loginToken2 = (LoginToken) c30141.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    if (!(e instanceof AccessDeniedException)) {
                    }
                }
            }
            LoginToken loginToken3 = loginToken2;
            CreateOAuth2TokenResponse createOAuth2TokenResponse = (CreateOAuth2TokenResponse) obj;
            CreateOAuth2TokenResponseBody tokenOutput = createOAuth2TokenResponse.getTokenOutput();
            Intrinsics.checkNotNull(tokenOutput);
            AccessToken accessToken = tokenOutput.getAccessToken();
            Intrinsics.checkNotNull(accessToken);
            String accessKeyId = accessToken.getAccessKeyId();
            String secretAccessKey = createOAuth2TokenResponse.getTokenOutput().getAccessToken().getSecretAccessKey();
            String sessionToken = createOAuth2TokenResponse.getTokenOutput().getAccessToken().getSessionToken();
            Instant now = this.clock.getNow();
            Duration.Companion companion = Duration.INSTANCE;
            LoginToken loginTokenCopy$default = LoginToken.copy$default(loginToken3, accessKeyId, secretAccessKey, sessionToken, null, null, now.m12289plusLRDsOJo(DurationKt.toDuration(createOAuth2TokenResponse.getTokenOutput().getExpiresIn(), DurationUnit.SECONDS)), createOAuth2TokenResponse.getTokenOutput().getRefreshToken(), null, null, null, 920, null);
            closeable.close();
            return loginTokenCopy$default;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshToken$lambda$0(LoginToken loginToken, SigninClient.Config.Builder withConfig) {
        Intrinsics.checkNotNullParameter(withConfig, "$this$withConfig");
        withConfig.getInterceptors().add(new DpopInterceptor(loginToken.getDpopKey()));
        return Unit.INSTANCE;
    }
}
