package aws.sdk.kotlin.runtime.auth.credentials.internal.sts;

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.auth.StsAuthSchemeProviderAdapter;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.auth.StsIdentityProviderConfigAdapter;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.endpoints.internal.EndpointResolverAdapter;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationDeserializer;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleOperationSerializer;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleWithWebIdentityOperationDeserializer;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde.AssumeRoleWithWebIdentityOperationSerializer;
import aws.sdk.kotlin.runtime.config.AwsSdkClientOption;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.interceptors.AwsSpanInterceptor;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.BusinessMetricsInterceptor;
import aws.sdk.kotlin.runtime.http.middleware.AwsRetryHeaderMiddleware;
import aws.sdk.kotlin.runtime.http.middleware.RecursionDetection;
import aws.sdk.kotlin.runtime.http.middleware.UserAgent;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerJVMKt;
import aws.smithy.kotlin.runtime.awsprotocol.AwsAttributes;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.auth.AnonymousAuthScheme;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthScheme;
import aws.smithy.kotlin.runtime.http.middleware.MutateHeaders;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.OperationAuthConfig;
import aws.smithy.kotlin.runtime.http.operation.OperationMetrics;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.operation.SdkOperationTelemetry;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkManagedGroup;
import aws.smithy.kotlin.runtime.p011io.SdkManagedGroupKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DefaultStsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/DefaultStsClient;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient$Config;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient$Config;)V", "getConfig", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/StsClient$Config;", "managedResources", "Laws/smithy/kotlin/runtime/io/SdkManagedGroup;", "client", "Laws/smithy/kotlin/runtime/http/SdkHttpClient;", "identityProviderConfig", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/StsIdentityProviderConfigAdapter;", "configuredAuthSchemes", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "authSchemeAdapter", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/StsAuthSchemeProviderAdapter;", "telemetryScope", "", "opMetrics", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "awsUserAgentMetadata", "Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", "assumeRole", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assumeRoleWithWebIdentity", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityResponse;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "mergeServiceDefaults", "ctx", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultStsClient implements StsClient {
    private final StsAuthSchemeProviderAdapter authSchemeAdapter;
    private final AwsUserAgentMetadata awsUserAgentMetadata;
    private final SdkHttpClient client;
    private final StsClient.Config config;
    private final Map<AuthSchemeId, AuthScheme> configuredAuthSchemes;
    private final StsIdentityProviderConfigAdapter identityProviderConfig;
    private final SdkManagedGroup managedResources;
    private final OperationMetrics opMetrics;
    private final String telemetryScope;

    public DefaultStsClient(StsClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.managedResources = new SdkManagedGroup(null, 1, null);
        this.client = new SdkHttpClient(getConfig().getHttpClient());
        this.identityProviderConfig = new StsIdentityProviderConfigAdapter(getConfig());
        List<AuthScheme> authSchemes = getConfig().getAuthSchemes();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(authSchemes, 10)), 16));
        for (Object obj : authSchemes) {
            linkedHashMap.put(AuthSchemeId.m12116boximpl(((AuthScheme) obj).getSchemeId()), obj);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        AuthSchemeId authSchemeIdM12116boximpl = AuthSchemeId.m12116boximpl(AuthSchemeId.INSTANCE.m12124getAwsSigV4DepwgT4());
        if (mutableMap.get(authSchemeIdM12116boximpl) == null) {
            mutableMap.put(authSchemeIdM12116boximpl, new SigV4AuthScheme(DefaultAwsSignerJVMKt.getDefaultAwsSigner(), "sts"));
        }
        AuthSchemeId authSchemeIdM12116boximpl2 = AuthSchemeId.m12116boximpl(AuthSchemeId.INSTANCE.m12123getAnonymousDepwgT4());
        if (mutableMap.get(authSchemeIdM12116boximpl2) == null) {
            mutableMap.put(authSchemeIdM12116boximpl2, AnonymousAuthScheme.INSTANCE);
        }
        this.configuredAuthSchemes = MapsKt.toMap(mutableMap);
        this.authSchemeAdapter = new StsAuthSchemeProviderAdapter(getConfig());
        this.telemetryScope = "aws.sdk.kotlin.runtime.auth.credentials.internal.sts";
        this.opMetrics = new OperationMetrics("aws.sdk.kotlin.runtime.auth.credentials.internal.sts", getConfig().getTelemetryProvider());
        SdkManagedGroupKt.addIfManaged(this.managedResources, getConfig().getHttpClient());
        SdkManagedGroupKt.addIfManaged(this.managedResources, getConfig().getCredentialsProvider());
        this.awsUserAgentMetadata = AwsUserAgentMetadata.INSTANCE.fromEnvironment(new ApiMetadata(StsClientKt.ServiceId, "1.6.17"), getConfig().getApplicationId());
    }

    @Override // aws.smithy.kotlin.runtime.client.SdkClient
    public StsClient.Config getConfig() {
        return this.config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient
    public Object assumeRole(AssumeRoleRequest assumeRoleRequest, Continuation<? super AssumeRoleResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(AssumeRoleRequest.class), Reflection.getOrCreateKotlinClass(AssumeRoleResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new AssumeRoleOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new AssumeRoleOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("AssumeRole");
        sdkHttpOperationBuilder.setServiceName(StsClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        MutateHeaders mutateHeaders = new MutateHeaders(null, null, null, 7, null);
        mutateHeaders.setIfMissing("Content-Type", "application/x-www-form-urlencoded");
        sdkHttpOperationBuild.install(mutateHeaders);
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, 0 == true ? 1 : 0));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, assumeRoleRequest, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient
    public Object assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest, Continuation<? super AssumeRoleWithWebIdentityResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(AssumeRoleWithWebIdentityRequest.class), Reflection.getOrCreateKotlinClass(AssumeRoleWithWebIdentityResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new AssumeRoleWithWebIdentityOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new AssumeRoleWithWebIdentityOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("AssumeRoleWithWebIdentity");
        sdkHttpOperationBuilder.setServiceName(StsClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        MutateHeaders mutateHeaders = new MutateHeaders(null, null, null, 7, null);
        mutateHeaders.setIfMissing("Content-Type", "application/x-www-form-urlencoded");
        sdkHttpOperationBuild.install(mutateHeaders);
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, 0 == true ? 1 : 0));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, assumeRoleWithWebIdentityRequest, continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.managedResources.unshareAll();
    }

    private final void mergeServiceDefaults(ExecutionContext ctx) {
        ExecutionContext executionContext = ctx;
        AttributesKt.putIfAbsentNotNull(executionContext, HttpOperationContext.INSTANCE.getAttemptTimeout(), getConfig().getAttemptTimeout());
        AttributesKt.putIfAbsentNotNull(executionContext, HttpOperationContext.INSTANCE.getCallTimeout(), getConfig().getCallTimeout());
        AttributesKt.putIfAbsent(executionContext, SdkClientOption.INSTANCE.getClientName(), getConfig().getClientName());
        AttributesKt.putIfAbsent(executionContext, SdkClientOption.INSTANCE.getLogMode(), getConfig().getLogMode());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsAttributes.INSTANCE.getRegion(), getConfig().getRegion());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsSigningAttributes.INSTANCE.getSigningRegion(), getConfig().getRegion());
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getSigningService(), "sts");
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getCredentialsProvider(), getConfig().getCredentialsProvider());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsSdkClientOption.INSTANCE.getApplicationId(), getConfig().getApplicationId());
    }
}
