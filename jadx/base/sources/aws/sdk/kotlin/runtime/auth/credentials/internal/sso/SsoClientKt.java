package aws.sdk.kotlin.runtime.auth.credentials.internal.sso;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.SsoClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.GetRoleCredentialsRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.GetRoleCredentialsResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SsoClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0000\u001a-\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0080H¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"ServiceId", "", "SdkVersion", "ServiceApiVersion", "withConfig", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/SsoClient;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/SsoClient$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "getRoleCredentials", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/model/GetRoleCredentialsResponse;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/model/GetRoleCredentialsRequest$Builder;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/SsoClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoClientKt {
    public static final String SdkVersion = "1.6.17";
    public static final String ServiceApiVersion = "2019-06-10";
    public static final String ServiceId = "SSO";

    public static final SsoClient withConfig(SsoClient ssoClient, Function1<? super SsoClient.Config.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(ssoClient, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        SsoClient.Config.Builder builder = ssoClient.getConfig().toBuilder();
        block.invoke(builder);
        return new DefaultSsoClient(builder.build());
    }

    public static final Object getRoleCredentials(SsoClient ssoClient, Function1<? super GetRoleCredentialsRequest.Builder, Unit> function1, Continuation<? super GetRoleCredentialsResponse> continuation) {
        GetRoleCredentialsRequest.Builder builder = new GetRoleCredentialsRequest.Builder();
        function1.invoke(builder);
        return ssoClient.getRoleCredentials(builder.build(), continuation);
    }

    private static final Object getRoleCredentials$$forInline(SsoClient ssoClient, Function1<? super GetRoleCredentialsRequest.Builder, Unit> function1, Continuation<? super GetRoleCredentialsResponse> continuation) {
        GetRoleCredentialsRequest.Builder builder = new GetRoleCredentialsRequest.Builder();
        function1.invoke(builder);
        return ssoClient.getRoleCredentials(builder.build(), continuation);
    }
}
