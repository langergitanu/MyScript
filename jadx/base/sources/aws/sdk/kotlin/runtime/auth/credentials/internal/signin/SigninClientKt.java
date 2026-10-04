package aws.sdk.kotlin.runtime.auth.credentials.internal.signin;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigninClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0000\u001a-\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0080H¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"ServiceId", "", "SdkVersion", "ServiceApiVersion", "withConfig", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "createOAuth2Token", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequest$Builder;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigninClientKt {
    public static final String SdkVersion = "1.6.17";
    public static final String ServiceApiVersion = "2023-01-01";
    public static final String ServiceId = "Signin";

    public static final SigninClient withConfig(SigninClient signinClient, Function1<? super SigninClient.Config.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(signinClient, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        SigninClient.Config.Builder builder = signinClient.getConfig().toBuilder();
        block.invoke(builder);
        return new DefaultSigninClient(builder.build());
    }

    public static final Object createOAuth2Token(SigninClient signinClient, Function1<? super CreateOAuth2TokenRequest.Builder, Unit> function1, Continuation<? super CreateOAuth2TokenResponse> continuation) {
        CreateOAuth2TokenRequest.Builder builder = new CreateOAuth2TokenRequest.Builder();
        function1.invoke(builder);
        return signinClient.createOAuth2Token(builder.build(), continuation);
    }

    private static final Object createOAuth2Token$$forInline(SigninClient signinClient, Function1<? super CreateOAuth2TokenRequest.Builder, Unit> function1, Continuation<? super CreateOAuth2TokenResponse> continuation) {
        CreateOAuth2TokenRequest.Builder builder = new CreateOAuth2TokenRequest.Builder();
        function1.invoke(builder);
        return signinClient.createOAuth2Token(builder.build(), continuation);
    }
}
