package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth.SigninAuthSchemeParameters;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.AuthSchemeResolver;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigninAuthSchemeProviderAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProviderAdapter;", "Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;)V", "resolve", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "request", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigninAuthSchemeProviderAdapter implements AuthSchemeResolver {
    private final SigninClient.Config config;

    public SigninAuthSchemeProviderAdapter(SigninClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.AuthSchemeResolver
    public Object resolve(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super List<? extends AuthOption>> continuation) {
        SigninAuthSchemeParameters.Companion companion = SigninAuthSchemeParameters.INSTANCE;
        SigninAuthSchemeParameters.Builder builder = new SigninAuthSchemeParameters.Builder();
        builder.setOperationName((String) AttributesKt.get(operationRequest.getContext(), SdkClientOption.INSTANCE.getOperationName()));
        return this.config.getAuthSchemeProvider().resolveAuthScheme(builder.build(), continuation);
    }
}
