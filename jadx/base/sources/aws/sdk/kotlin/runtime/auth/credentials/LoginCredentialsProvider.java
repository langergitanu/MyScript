package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: LoginCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/LoginCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "loginSession", "", TtmlNode.TAG_REGION, "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/time/Clock;)V", "getLoginSession", "()Ljava/lang/String;", "getRegion", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "cacheDirectory", "client", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginCredentialsProvider implements CloseableCredentialsProvider {
    private final String cacheDirectory;
    private final SigninClient client;
    private final Clock clock;
    private final HttpClientEngine httpClient;
    private final String loginSession;
    private final PlatformProvider platformProvider;
    private final String region;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.LoginCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: LoginCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginCredentialsProvider", m1609f = "LoginCredentialsProvider.kt", m1610i = {0, 0, 0}, m1611l = {79}, m1612m = "resolve", m1613n = {"attributes", "logger", "loginTokenProvider"}, m1614nl = {PDFACompliance.e_PDFA8_1}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C30111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C30111(Continuation<? super C30111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginCredentialsProvider.this.resolve(null, this);
        }
    }

    public LoginCredentialsProvider(String loginSession, String str, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock) {
        Intrinsics.checkNotNullParameter(loginSession, "loginSession");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.loginSession = loginSession;
        this.region = str;
        this.httpClient = httpClientEngine;
        this.platformProvider = platformProvider;
        this.clock = clock;
        this.cacheDirectory = LoginCredentialsProviderKt.resolveCacheDir(platformProvider);
        this.client = (SigninClient) BuildersKt__BuildersKt.runBlocking$default(null, new LoginCredentialsProvider$client$1(this, null), 1, null);
    }

    public final String getLoginSession() {
        return this.loginSession;
    }

    public final String getRegion() {
        return this.region;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public /* synthetic */ LoginCredentialsProvider(String str, String str2, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : httpClientEngine, (i & 8) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 16) != 0 ? Clock.System.INSTANCE : system);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        C30111 c30111;
        if (continuation instanceof C30111) {
            c30111 = (C30111) continuation;
            if ((c30111.label & Integer.MIN_VALUE) != 0) {
                c30111.label -= Integer.MIN_VALUE;
            } else {
                c30111 = new C30111(continuation);
            }
        }
        Object objResolve = c30111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolve);
            CoroutineContext coroutineContext = c30111.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(LoginCredentialsProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            LoginTokenProvider loginTokenProvider = new LoginTokenProvider(this.loginSession, this.region, 0L, this.httpClient, this.platformProvider, this.clock, this.cacheDirectory, this.client, 4, null);
            Logger.trace$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginCredentialsProvider$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoginCredentialsProvider.resolve$lambda$0(this.f$0);
                }
            }, 1, null);
            c30111.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30111.L$1 = SpillingKt.nullOutSpilledVariable(logger);
            c30111.L$2 = SpillingKt.nullOutSpilledVariable(loginTokenProvider);
            c30111.label = 1;
            objResolve = loginTokenProvider.resolve(attributes, c30111);
            if (objResolve == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolve);
        }
        return AwsBusinessMetricsUtilsKt.withBusinessMetric((Credentials) objResolve, AwsBusinessMetric.Credentials.CREDENTIALS_LOGIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0(LoginCredentialsProvider loginCredentialsProvider) {
        return "Attempting to load token using token provider for login-session: `" + loginCredentialsProvider.loginSession + '`';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.client.close();
    }
}
