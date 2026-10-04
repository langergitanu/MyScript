package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0080@¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"resolveCacheDir", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "signinClient", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "providedRegion", "providedHttpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginCredentialsProviderKt {
    public static final String resolveCacheDir(PlatformProvider platformProvider) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        String str = platformProvider.getenv("AWS_LOGIN_IN_CACHE_DIRECTORY");
        return str == null ? SsoTokenProviderKt.filepath(platformProvider, "~", ".aws", "login", "cache") : str;
    }

    public static final Object signinClient(final String str, final HttpClientEngine httpClientEngine, Continuation<? super SigninClient> continuation) {
        return SigninClient.INSTANCE.fromEnvironment(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.LoginCredentialsProviderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoginCredentialsProviderKt.signinClient$lambda$0(str, httpClientEngine, (SigninClient.Config.Builder) obj);
            }
        }, continuation);
    }

    public static /* synthetic */ Object signinClient$default(String str, HttpClientEngine httpClientEngine, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            httpClientEngine = null;
        }
        return signinClient(str, httpClientEngine, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signinClient$lambda$0(String str, HttpClientEngine httpClientEngine, SigninClient.Config.Builder fromEnvironment) {
        Intrinsics.checkNotNullParameter(fromEnvironment, "$this$fromEnvironment");
        fromEnvironment.setRegion(str);
        fromEnvironment.setHttpClient(httpClientEngine);
        return Unit.INSTANCE;
    }
}
