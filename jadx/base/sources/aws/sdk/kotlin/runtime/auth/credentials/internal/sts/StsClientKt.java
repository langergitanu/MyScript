package aws.sdk.kotlin.runtime.auth.credentials.internal.sts;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0000\u001a-\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0080H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u0010*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0080H¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"ServiceId", "", "SdkVersion", "ServiceApiVersion", "withConfig", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "assumeRole", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Builder;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assumeRoleWithWebIdentity", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityResponse;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Builder;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsClientKt {
    public static final String SdkVersion = "1.6.17";
    public static final String ServiceApiVersion = "2011-06-15";
    public static final String ServiceId = "STS";

    public static final StsClient withConfig(StsClient stsClient, Function1<? super StsClient.Config.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(stsClient, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        StsClient.Config.Builder builder = stsClient.getConfig().toBuilder();
        block.invoke(builder);
        return new DefaultStsClient(builder.build());
    }

    public static final Object assumeRole(StsClient stsClient, Function1<? super AssumeRoleRequest.Builder, Unit> function1, Continuation<? super AssumeRoleResponse> continuation) {
        AssumeRoleRequest.Builder builder = new AssumeRoleRequest.Builder();
        function1.invoke(builder);
        return stsClient.assumeRole(builder.build(), continuation);
    }

    private static final Object assumeRole$$forInline(StsClient stsClient, Function1<? super AssumeRoleRequest.Builder, Unit> function1, Continuation<? super AssumeRoleResponse> continuation) {
        AssumeRoleRequest.Builder builder = new AssumeRoleRequest.Builder();
        function1.invoke(builder);
        return stsClient.assumeRole(builder.build(), continuation);
    }

    public static final Object assumeRoleWithWebIdentity(StsClient stsClient, Function1<? super AssumeRoleWithWebIdentityRequest.Builder, Unit> function1, Continuation<? super AssumeRoleWithWebIdentityResponse> continuation) {
        AssumeRoleWithWebIdentityRequest.Builder builder = new AssumeRoleWithWebIdentityRequest.Builder();
        function1.invoke(builder);
        return stsClient.assumeRoleWithWebIdentity(builder.build(), continuation);
    }

    private static final Object assumeRoleWithWebIdentity$$forInline(StsClient stsClient, Function1<? super AssumeRoleWithWebIdentityRequest.Builder, Unit> function1, Continuation<? super AssumeRoleWithWebIdentityResponse> continuation) {
        AssumeRoleWithWebIdentityRequest.Builder builder = new AssumeRoleWithWebIdentityRequest.Builder();
        function1.invoke(builder);
        return stsClient.assumeRoleWithWebIdentity(builder.build(), continuation);
    }
}
