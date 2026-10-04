package aws.sdk.kotlin.runtime.auth.credentials.internal.signin;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProviderKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth.DefaultSigninAuthSchemeProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth.SigninAuthSchemeProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.DefaultSigninEndpointProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.endpoints.SigninEndpointProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponse;
import aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory;
import aws.sdk.kotlin.runtime.config.AwsSdkClientConfig;
import aws.sdk.kotlin.runtime.config.endpoints.ResolversKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.runtime.http.retries.AwsRetryPolicy;
import aws.sdk.kotlin.runtime.region.DefaultRegionProviderChain;
import aws.sdk.kotlin.runtime.region.ValidateRegionKt;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig;
import aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor;
import aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.RetryClientConfig;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfigImpl;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig;
import aws.smithy.kotlin.runtime.http.config.EngineFactory;
import aws.smithy.kotlin.runtime.http.config.HttpClientConfig;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfig;
import aws.smithy.kotlin.runtime.http.config.TimeoutConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.telemetry.GlobalTelemetryProviderKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryConfig;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.util.DslFactory;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: SigninClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "Laws/smithy/kotlin/runtime/client/SdkClient;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "getConfig", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "createOAuth2Token", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponse;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Builder", "Config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SigninClient extends SdkClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static Builder builder() {
        return INSTANCE.builder();
    }

    Object createOAuth2Token(CreateOAuth2TokenRequest createOAuth2TokenRequest, Continuation<? super CreateOAuth2TokenResponse> continuation);

    @Override // aws.smithy.kotlin.runtime.client.SdkClient
    Config getConfig();

    /* JADX INFO: compiled from: SigninClient.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0014J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\rH\u0094@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Companion;", "Laws/sdk/kotlin/runtime/config/AbstractAwsSdkClientFactory;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Builder;", "<init>", "()V", "builder", "finalizeConfig", "", "finalizeEnvironmentalConfig", "sharedConfig", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "activeProfile", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Builder;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion extends AbstractAwsSdkClientFactory<Config, Config.Builder, SigninClient, Builder> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory
        public /* bridge */ /* synthetic */ Object finalizeEnvironmentalConfig(SdkClient.Builder builder, LazyAsyncValue lazyAsyncValue, LazyAsyncValue lazyAsyncValue2, Continuation continuation) {
            return finalizeEnvironmentalConfig((Builder) builder, (LazyAsyncValue<AwsSharedConfig>) lazyAsyncValue, (LazyAsyncValue<ConfigSection>) lazyAsyncValue2, (Continuation<? super Unit>) continuation);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientFactory
        @JvmStatic
        public Builder builder() {
            return new Builder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientFactory
        public void finalizeConfig(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            super.finalizeConfig(builder);
            builder.getConfig().getInterceptors().add(0, new ClockSkewInterceptor());
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Object finalizeEnvironmentalConfig(Builder builder, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, LazyAsyncValue<ConfigSection> lazyAsyncValue2, Continuation<? super Unit> continuation) {
            SigninClient$Companion$finalizeEnvironmentalConfig$1 signinClient$Companion$finalizeEnvironmentalConfig$1;
            Config.Builder config;
            Url endpointUrl;
            Config.Builder builder2;
            if (continuation instanceof SigninClient$Companion$finalizeEnvironmentalConfig$1) {
                signinClient$Companion$finalizeEnvironmentalConfig$1 = (SigninClient$Companion$finalizeEnvironmentalConfig$1) continuation;
                if ((signinClient$Companion$finalizeEnvironmentalConfig$1.label & Integer.MIN_VALUE) != 0) {
                    signinClient$Companion$finalizeEnvironmentalConfig$1.label -= Integer.MIN_VALUE;
                } else {
                    signinClient$Companion$finalizeEnvironmentalConfig$1 = new SigninClient$Companion$finalizeEnvironmentalConfig$1(this, continuation);
                }
            }
            SigninClient$Companion$finalizeEnvironmentalConfig$1 signinClient$Companion$finalizeEnvironmentalConfig$12 = signinClient$Companion$finalizeEnvironmentalConfig$1;
            Object objResolveEndpointUrl$default = signinClient$Companion$finalizeEnvironmentalConfig$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = signinClient$Companion$finalizeEnvironmentalConfig$12.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objResolveEndpointUrl$default);
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$0 = builder;
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$1 = lazyAsyncValue;
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                signinClient$Companion$finalizeEnvironmentalConfig$12.label = 1;
                if (super.finalizeEnvironmentalConfig(builder, lazyAsyncValue, lazyAsyncValue2, (Continuation<? super Unit>) signinClient$Companion$finalizeEnvironmentalConfig$12) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                builder2 = (Config.Builder) signinClient$Companion$finalizeEnvironmentalConfig$12.L$3;
                ResultKt.throwOnFailure(objResolveEndpointUrl$default);
                endpointUrl = (Url) objResolveEndpointUrl$default;
                config = builder2;
                config.setEndpointUrl(endpointUrl);
                return Unit.INSTANCE;
            }
            lazyAsyncValue2 = (LazyAsyncValue) signinClient$Companion$finalizeEnvironmentalConfig$12.L$2;
            lazyAsyncValue = (LazyAsyncValue) signinClient$Companion$finalizeEnvironmentalConfig$12.L$1;
            builder = (Builder) signinClient$Companion$finalizeEnvironmentalConfig$12.L$0;
            ResultKt.throwOnFailure(objResolveEndpointUrl$default);
            LazyAsyncValue<AwsSharedConfig> lazyAsyncValue3 = lazyAsyncValue;
            config = builder.getConfig();
            endpointUrl = builder.getConfig().getEndpointUrl();
            if (endpointUrl == null) {
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$0 = SpillingKt.nullOutSpilledVariable(builder);
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                signinClient$Companion$finalizeEnvironmentalConfig$12.L$3 = config;
                signinClient$Companion$finalizeEnvironmentalConfig$12.label = 2;
                objResolveEndpointUrl$default = ResolversKt.resolveEndpointUrl$default(lazyAsyncValue3, SigninClientKt.ServiceId, "SIGNIN", "signin", null, signinClient$Companion$finalizeEnvironmentalConfig$12, 16, null);
                if (objResolveEndpointUrl$default != coroutine_suspended) {
                    builder2 = config;
                    endpointUrl = (Url) objResolveEndpointUrl$default;
                    config = builder2;
                }
                return coroutine_suspended;
            }
            config.setEndpointUrl(endpointUrl);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SigninClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Builder;", "Laws/smithy/kotlin/runtime/client/AbstractSdkClientBuilder;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "<init>", "()V", "config", "getConfig", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "newClient", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder extends AbstractSdkClientBuilder<Config, Config.Builder, SigninClient> {
        private final Config.Builder config = new Config.Builder();

        @Override // aws.smithy.kotlin.runtime.client.SdkClient.Builder
        public Config.Builder getConfig() {
            return this.config;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder
        public SigninClient newClient(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new DefaultSigninClient(config);
        }
    }

    /* JADX INFO: compiled from: SigninClient.kt */
    @Metadata(m1598d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0002[\\B\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010R\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010%\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R6\u00103\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020704j\u0002`80\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R\u0014\u0010:\u001a\u00020;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010IR\u0016\u0010L\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0012R\u0011\u0010N\u001a\u00020O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0012\u0010S\u001a\u00020TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u00020XX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006]"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig;", "Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig;", "Laws/smithy/kotlin/runtime/http/config/HttpClientConfig;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "Laws/smithy/kotlin/runtime/client/RetryClientConfig;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryConfig;", "Laws/smithy/kotlin/runtime/http/config/TimeoutConfig;", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;)V", "clientName", "", "getClientName", "()Ljava/lang/String;", TtmlNode.TAG_REGION, "getRegion", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "attemptTimeout", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "()Ljava/util/List;", "authSchemes", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "callTimeout", "getCallTimeout-FghU774", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "endpointProvider", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;", "getEndpointProvider", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;", "endpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getEndpointUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "interceptors", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "useDualStack", "", "getUseDualStack", "()Z", "useFips", "getUseFips", "applicationId", "getApplicationId", "authSchemeProvider", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProvider;", "getAuthSchemeProvider", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProvider;", "toBuilder", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config implements AwsSdkClientConfig, CredentialsProviderConfig, HttpAuthConfig, HttpClientConfig, HttpEngineConfig, RetryClientConfig, RetryStrategyClientConfig, SdkClientConfig, TelemetryConfig, TimeoutConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final /* synthetic */ HttpEngineConfig $$delegate_0;
        private final /* synthetic */ RetryStrategyClientConfig $$delegate_1;
        private final String applicationId;
        private final Duration attemptTimeout;
        private final List<AuthSchemeId> authSchemePreference;
        private final SigninAuthSchemeProvider authSchemeProvider;
        private final List<AuthScheme> authSchemes;
        private final Duration callTimeout;
        private final String clientName;
        private final CredentialsProvider credentialsProvider;
        private final SigninEndpointProvider endpointProvider;
        private final Url endpointUrl;
        private final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors;
        private final LogMode logMode;
        private final String region;
        private final RegionProvider regionProvider;
        private final RetryPolicy<Object> retryPolicy;
        private final TelemetryProvider telemetryProvider;
        private final boolean useDualStack;
        private final boolean useFips;

        public /* synthetic */ Config(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig
        public HttpClientEngine getHttpClient() {
            return this.$$delegate_0.getHttpClient();
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig
        public RetryStrategy getRetryStrategy() {
            return this.$$delegate_1.getRetryStrategy();
        }

        private Config(Builder builder) {
            this.$$delegate_0 = builder.buildHttpEngineConfig();
            this.$$delegate_1 = builder.buildRetryStrategyClientConfig();
            this.clientName = builder.getClientName();
            String region = builder.getRegion();
            region = region == null ? (String) BuildersKt__BuildersKt.runBlocking$default(null, new SigninClient$Config$region$1(builder, null), 1, null) : region;
            this.region = region != null ? ValidateRegionKt.validateRegion(region) : null;
            DefaultRegionProviderChain regionProvider = builder.getRegionProvider();
            this.regionProvider = regionProvider == null ? new DefaultRegionProviderChain(null, null, null, 7, null) : regionProvider;
            this.attemptTimeout = builder.getAttemptTimeout();
            this.authSchemePreference = builder.getAuthSchemePreference();
            this.authSchemes = builder.getAuthSchemes();
            this.callTimeout = builder.getCallTimeout();
            CredentialsProvider credentialsProvider = builder.getCredentialsProvider();
            this.credentialsProvider = credentialsProvider == null ? ManagedCredentialsProviderKt.manage(new DefaultChainCredentialsProvider(null, null, getHttpClient(), getRegion(), 3, null)) : credentialsProvider;
            DefaultSigninEndpointProvider endpointProvider = builder.getEndpointProvider();
            this.endpointProvider = endpointProvider == null ? new DefaultSigninEndpointProvider() : endpointProvider;
            this.endpointUrl = builder.getEndpointUrl();
            this.interceptors = builder.getInterceptors();
            LogMode.Default logMode = builder.getLogMode();
            this.logMode = logMode == null ? LogMode.Default.INSTANCE : logMode;
            AwsRetryPolicy retryPolicy = builder.getRetryPolicy();
            this.retryPolicy = retryPolicy == null ? AwsRetryPolicy.INSTANCE.getDefault() : retryPolicy;
            TelemetryProvider telemetryProvider = builder.getTelemetryProvider();
            this.telemetryProvider = telemetryProvider == null ? GlobalTelemetryProviderKt.getGlobal(TelemetryProvider.INSTANCE) : telemetryProvider;
            Boolean useDualStack = builder.getUseDualStack();
            this.useDualStack = useDualStack != null ? useDualStack.booleanValue() : false;
            Boolean useFips = builder.getUseFips();
            this.useFips = useFips != null ? useFips.booleanValue() : false;
            this.applicationId = builder.getApplicationId();
            DefaultSigninAuthSchemeProvider authSchemeProvider = builder.getAuthSchemeProvider();
            this.authSchemeProvider = authSchemeProvider == null ? new DefaultSigninAuthSchemeProvider(null, getAuthSchemePreference(), 1, null) : authSchemeProvider;
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig
        public String getClientName() {
            return this.clientName;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public String getRegion() {
            return this.region;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public RegionProvider getRegionProvider() {
            return this.regionProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig
        /* JADX INFO: renamed from: getAttemptTimeout-FghU774, reason: not valid java name and from getter */
        public Duration getAttemptTimeout() {
            return this.attemptTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig
        public List<AuthSchemeId> getAuthSchemePreference() {
            return this.authSchemePreference;
        }

        @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig
        public List<AuthScheme> getAuthSchemes() {
            return this.authSchemes;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig
        /* JADX INFO: renamed from: getCallTimeout-FghU774, reason: not valid java name and from getter */
        public Duration getCallTimeout() {
            return this.callTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig
        public CredentialsProvider getCredentialsProvider() {
            return this.credentialsProvider;
        }

        public final SigninEndpointProvider getEndpointProvider() {
            return this.endpointProvider;
        }

        public final Url getEndpointUrl() {
            return this.endpointUrl;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig
        public List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors() {
            return this.interceptors;
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig
        public LogMode getLogMode() {
            return this.logMode;
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig
        public RetryPolicy<Object> getRetryPolicy() {
            return this.retryPolicy;
        }

        @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig
        public TelemetryProvider getTelemetryProvider() {
            return this.telemetryProvider;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public boolean getUseDualStack() {
            return this.useDualStack;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public boolean getUseFips() {
            return this.useFips;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public String getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: compiled from: SigninClient.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config invoke(Function1<? super Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder builder = new Builder();
                block.invoke(builder);
                return builder.build();
            }
        }

        public final SigninAuthSchemeProvider getAuthSchemeProvider() {
            return this.authSchemeProvider;
        }

        public final Builder toBuilder() {
            Builder builder = new Builder();
            builder.setClientName(getClientName());
            builder.setRegion(getRegion());
            builder.setRegionProvider(getRegionProvider());
            builder.mo12049setAttemptTimeoutBwNAW2A(getAttemptTimeout());
            builder.setAuthSchemePreference(getAuthSchemePreference());
            builder.setAuthSchemes(getAuthSchemes());
            builder.mo12050setCallTimeoutBwNAW2A(getCallTimeout());
            builder.setCredentialsProvider(getCredentialsProvider());
            builder.setEndpointProvider(this.endpointProvider);
            builder.setEndpointUrl(this.endpointUrl);
            builder.setHttpClient(getHttpClient());
            builder.setInterceptors(CollectionsKt.toMutableList((Collection) getInterceptors()));
            builder.setLogMode(getLogMode());
            builder.setRetryPolicy(getRetryPolicy());
            builder.setRetryStrategy(getRetryStrategy());
            builder.setTelemetryProvider(getTelemetryProvider());
            builder.setUseDualStack(Boolean.valueOf(getUseDualStack()));
            builder.setUseFips(Boolean.valueOf(getUseFips()));
            builder.setApplicationId(getApplicationId());
            builder.setAuthSchemeProvider(this.authSchemeProvider);
            return builder;
        }

        /* JADX INFO: compiled from: SigninClient.kt */
        @Metadata(m1598d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\b\u0012\u0004\u0012\u00020\t0\b2\u00020\n2\u00020\u000bB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010q\u001a\u00020\tH\u0016J\t\u0010r\u001a\u00020sH\u0097\u0001J\t\u0010t\u001a\u00020uH\u0097\u0001J\"\u0010v\u001a\u00020w2\u0017\u0010x\u001a\u0013\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020w0y¢\u0006\u0002\b{H\u0096\u0001JK\u0010v\u001a\u00020w\"\b\b\u0000\u0010|*\u00020z\"\b\b\u0001\u0010}*\u00020~2\u0013\u0010\u007f\u001a\u000f\u0012\u0004\u0012\u0002H|\u0012\u0004\u0012\u0002H}0\u0080\u00012\u0017\u0010x\u001a\u0013\u0012\u0004\u0012\u0002H|\u0012\u0004\u0012\u00020w0y¢\u0006\u0002\b{H\u0096\u0001J$\u0010\u0081\u0001\u001a\u00020w2\u0018\u0010x\u001a\u0014\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020w0y¢\u0006\u0002\b{H\u0096\u0001JQ\u0010\u0081\u0001\u001a\u00020w\"\t\b\u0000\u0010|*\u00030\u0083\u0001\"\n\b\u0001\u0010\u0084\u0001*\u00030\u0085\u00012\u0015\u0010\u0086\u0001\u001a\u0010\u0012\u0004\u0012\u0002H|\u0012\u0005\u0012\u0003H\u0084\u00010\u0087\u00012\u0017\u0010x\u001a\u0013\u0012\u0004\u0012\u0002H|\u0012\u0004\u0012\u00020w0y¢\u0006\u0002\b{H\u0096\u0001R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020+0$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001c\u0010.\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001c\u00101\u001a\u0004\u0018\u000102X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR<\u0010C\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0Ej\u0002`I0DX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010SX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010^\u001a\u0004\u0018\u00010_X\u0096\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001e\u0010e\u001a\u0004\u0018\u00010_X\u0096\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\u001c\u0010h\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0011\"\u0004\bj\u0010\u0013R\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001e\u0010v\u001a\u0004\u0018\u00010~X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u0090\u0001"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config$Builder;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig$Builder;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig$Builder;", "Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/HttpClientConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig$Builder;", "Laws/smithy/kotlin/runtime/client/RetryClientConfig$Builder;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig$Builder;", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient$Config;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/TimeoutConfig$Builder;", "<init>", "()V", "clientName", "", "getClientName", "()Ljava/lang/String;", "setClientName", "(Ljava/lang/String;)V", TtmlNode.TAG_REGION, "getRegion", "setRegion", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "setRegionProvider", "(Laws/smithy/kotlin/runtime/client/region/RegionProvider;)V", "attemptTimeout", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "setAttemptTimeout-BwNAW2A", "(Lkotlin/time/Duration;)V", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "()Ljava/util/List;", "setAuthSchemePreference", "(Ljava/util/List;)V", "authSchemes", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "setAuthSchemes", "callTimeout", "getCallTimeout-FghU774", "setCallTimeout-BwNAW2A", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "setCredentialsProvider", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;)V", "endpointProvider", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;", "getEndpointProvider", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;", "setEndpointProvider", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/endpoints/SigninEndpointProvider;)V", "endpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getEndpointUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "setEndpointUrl", "(Laws/smithy/kotlin/runtime/net/url/Url;)V", "interceptors", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "setInterceptors", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "setLogMode", "(Laws/smithy/kotlin/runtime/client/LogMode;)V", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "setRetryPolicy", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;)V", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "useDualStack", "", "getUseDualStack", "()Ljava/lang/Boolean;", "setUseDualStack", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useFips", "getUseFips", "setUseFips", "applicationId", "getApplicationId", "setApplicationId", "authSchemeProvider", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProvider;", "getAuthSchemeProvider", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProvider;", "setAuthSchemeProvider", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeProvider;)V", "build", "buildHttpEngineConfig", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "buildRetryStrategyClientConfig", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "httpClient", "", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "Lkotlin/ExtensionFunctionType;", "B", ExifInterface.LONGITUDE_EAST, "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "engineFactory", "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "R", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "factory", "Laws/smithy/kotlin/runtime/util/DslFactory;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "setHttpClient", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "setRetryStrategy", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder implements AwsSdkClientConfig.Builder, CredentialsProviderConfig.Builder, HttpAuthConfig.Builder, HttpClientConfig.Builder, HttpEngineConfig.Builder, RetryClientConfig.Builder, RetryStrategyClientConfig.Builder, SdkClientConfig.Builder<Config>, TelemetryConfig.Builder, TimeoutConfig.Builder {
            private String applicationId;
            private Duration attemptTimeout;
            private List<AuthSchemeId> authSchemePreference;
            private SigninAuthSchemeProvider authSchemeProvider;
            private Duration callTimeout;
            private CredentialsProvider credentialsProvider;
            private SigninEndpointProvider endpointProvider;
            private Url endpointUrl;
            private LogMode logMode;
            private String region;
            private RegionProvider regionProvider;
            private RetryPolicy<Object> retryPolicy;
            private TelemetryProvider telemetryProvider;
            private Boolean useDualStack;
            private Boolean useFips;
            private final /* synthetic */ HttpEngineConfigImpl.BuilderImpl $$delegate_0 = new HttpEngineConfigImpl.BuilderImpl();
            private final /* synthetic */ RetryStrategyClientConfigImpl.BuilderImpl $$delegate_1 = new RetryStrategyClientConfigImpl.BuilderImpl();
            private String clientName = SigninClientKt.ServiceId;
            private List<? extends AuthScheme> authSchemes = CollectionsKt.emptyList();
            private List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = new ArrayList();

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            @InternalApi
            public HttpEngineConfig buildHttpEngineConfig() {
                return this.$$delegate_0.buildHttpEngineConfig();
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            @InternalApi
            public RetryStrategyClientConfig buildRetryStrategyClientConfig() {
                return this.$$delegate_1.buildRetryStrategyClientConfig();
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public HttpClientEngine getHttpClient() {
                return this.$$delegate_0.getHttpClient();
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public RetryStrategy getRetryStrategy() {
                return this.$$delegate_1.getRetryStrategy();
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public <B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> void httpClient(EngineFactory<? extends B, E> engineFactory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_0.httpClient(engineFactory, block);
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public void httpClient(Function1<? super HttpClientEngineConfig.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_0.httpClient(block);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public <B extends RetryStrategy.Config.Builder, R extends RetryStrategy> void retryStrategy(DslFactory<? extends B, ? extends R> factory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_1.retryStrategy(factory, block);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public void retryStrategy(Function1<? super StandardRetryStrategy.Config.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_1.retryStrategy(block);
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public void setHttpClient(HttpClientEngine httpClientEngine) {
                this.$$delegate_0.setHttpClient(httpClientEngine);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public void setRetryStrategy(RetryStrategy retryStrategy) {
                this.$$delegate_1.setRetryStrategy(retryStrategy);
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public String getClientName() {
                return this.clientName;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public void setClientName(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.clientName = str;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public String getRegion() {
                return this.region;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setRegion(String str) {
                this.region = str;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public RegionProvider getRegionProvider() {
                return this.regionProvider;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setRegionProvider(RegionProvider regionProvider) {
                this.regionProvider = regionProvider;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: getAttemptTimeout-FghU774, reason: not valid java name and from getter */
            public Duration getAttemptTimeout() {
                return this.attemptTimeout;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: setAttemptTimeout-BwNAW2A, reason: not valid java name */
            public void mo12049setAttemptTimeoutBwNAW2A(Duration duration) {
                this.attemptTimeout = duration;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public List<AuthSchemeId> getAuthSchemePreference() {
                return this.authSchemePreference;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public void setAuthSchemePreference(List<AuthSchemeId> list) {
                this.authSchemePreference = list;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public List<AuthScheme> getAuthSchemes() {
                return this.authSchemes;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public void setAuthSchemes(List<? extends AuthScheme> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.authSchemes = list;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: getCallTimeout-FghU774, reason: not valid java name and from getter */
            public Duration getCallTimeout() {
                return this.callTimeout;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: setCallTimeout-BwNAW2A, reason: not valid java name */
            public void mo12050setCallTimeoutBwNAW2A(Duration duration) {
                this.callTimeout = duration;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig.Builder
            public CredentialsProvider getCredentialsProvider() {
                return this.credentialsProvider;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig.Builder
            public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
                this.credentialsProvider = credentialsProvider;
            }

            public final SigninEndpointProvider getEndpointProvider() {
                return this.endpointProvider;
            }

            public final void setEndpointProvider(SigninEndpointProvider signinEndpointProvider) {
                this.endpointProvider = signinEndpointProvider;
            }

            public final Url getEndpointUrl() {
                return this.endpointUrl;
            }

            public final void setEndpointUrl(Url url) {
                this.endpointUrl = url;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig.Builder
            public List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors() {
                return this.interceptors;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig.Builder
            public void setInterceptors(List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.interceptors = list;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public LogMode getLogMode() {
                return this.logMode;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public void setLogMode(LogMode logMode) {
                this.logMode = logMode;
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig.Builder
            public RetryPolicy<Object> getRetryPolicy() {
                return this.retryPolicy;
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig.Builder
            public void setRetryPolicy(RetryPolicy<Object> retryPolicy) {
                this.retryPolicy = retryPolicy;
            }

            @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig.Builder
            public TelemetryProvider getTelemetryProvider() {
                return this.telemetryProvider;
            }

            @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig.Builder
            public void setTelemetryProvider(TelemetryProvider telemetryProvider) {
                this.telemetryProvider = telemetryProvider;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public Boolean getUseDualStack() {
                return this.useDualStack;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setUseDualStack(Boolean bool) {
                this.useDualStack = bool;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public Boolean getUseFips() {
                return this.useFips;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setUseFips(Boolean bool) {
                this.useFips = bool;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public String getApplicationId() {
                return this.applicationId;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setApplicationId(String str) {
                this.applicationId = str;
            }

            public final SigninAuthSchemeProvider getAuthSchemeProvider() {
                return this.authSchemeProvider;
            }

            public final void setAuthSchemeProvider(SigninAuthSchemeProvider signinAuthSchemeProvider) {
                this.authSchemeProvider = signinAuthSchemeProvider;
            }

            @Override // aws.smithy.kotlin.runtime.util.Buildable
            public Config build() {
                return new Config(this, null);
            }
        }
    }
}
