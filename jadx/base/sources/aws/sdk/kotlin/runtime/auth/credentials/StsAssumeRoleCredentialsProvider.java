package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.arns.Arn;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumedRoleUser;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.RegionDisabledException;
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
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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

/* JADX INFO: compiled from: StsAssumeRoleCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBS\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\u0010J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u0006H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StsAssumeRoleCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "bootstrapCredentialsProvider", "assumeRoleParameters", "Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleParameters;", TtmlNode.TAG_REGION, "", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleParameters;Ljava/lang/String;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "roleArn", "roleSessionName", "externalId", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLaws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBootstrapCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getAssumeRoleParameters", "()Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleParameters;", "getRegion", "()Ljava/lang/String;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsAssumeRoleCredentialsProvider implements CredentialsProvider {
    private final AssumeRoleParameters assumeRoleParameters;
    private final CredentialsProvider bootstrapCredentialsProvider;
    private final HttpClientEngine httpClient;
    private final String region;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: StsAssumeRoleCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider", m1609f = "StsAssumeRoleCredentialsProvider.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m1611l = {104, 208}, m1612m = "resolve", m1613n = {"attributes", "logger", "provider", "telemetry", "attributes", "logger", "provider", "telemetry", "client", "$this$assumeRole$iv", "$i$f$assumeRole"}, m1614nl = {113, TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
    static final class C30311 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C30311(Continuation<? super C30311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StsAssumeRoleCredentialsProvider.this.resolve(null, this);
        }
    }

    public /* synthetic */ StsAssumeRoleCredentialsProvider(CredentialsProvider credentialsProvider, String str, String str2, String str3, String str4, long j, HttpClientEngine httpClientEngine, DefaultConstructorMarker defaultConstructorMarker) {
        this(credentialsProvider, str, str2, str3, str4, j, httpClientEngine);
    }

    public StsAssumeRoleCredentialsProvider(CredentialsProvider bootstrapCredentialsProvider, AssumeRoleParameters assumeRoleParameters, String str, HttpClientEngine httpClientEngine) {
        Intrinsics.checkNotNullParameter(bootstrapCredentialsProvider, "bootstrapCredentialsProvider");
        Intrinsics.checkNotNullParameter(assumeRoleParameters, "assumeRoleParameters");
        this.bootstrapCredentialsProvider = bootstrapCredentialsProvider;
        this.assumeRoleParameters = assumeRoleParameters;
        this.region = str;
        this.httpClient = httpClientEngine;
    }

    public /* synthetic */ StsAssumeRoleCredentialsProvider(CredentialsProvider credentialsProvider, AssumeRoleParameters assumeRoleParameters, String str, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(credentialsProvider, assumeRoleParameters, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : httpClientEngine);
    }

    public final CredentialsProvider getBootstrapCredentialsProvider() {
        return this.bootstrapCredentialsProvider;
    }

    public final AssumeRoleParameters getAssumeRoleParameters() {
        return this.assumeRoleParameters;
    }

    public final String getRegion() {
        return this.region;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StsAssumeRoleCredentialsProvider(CredentialsProvider credentialsProvider, String str, String str2, String str3, String str4, long j, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        String str5 = (i & 4) != 0 ? null : str2;
        String str6 = (i & 8) != 0 ? null : str3;
        String str7 = (i & 16) != 0 ? null : str4;
        if ((i & 32) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(900, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(credentialsProvider, str, str5, str6, str7, duration, (i & 64) != 0 ? null : httpClientEngine, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private StsAssumeRoleCredentialsProvider(CredentialsProvider bootstrapCredentialsProvider, String roleArn, String str, String str2, String str3, long j, HttpClientEngine httpClientEngine) {
        this(bootstrapCredentialsProvider, new AssumeRoleParameters(roleArn, str2, str3, j, null, null, null, null, null, null, null, 2032, null), str, httpClientEngine);
        Intrinsics.checkNotNullParameter(bootstrapCredentialsProvider, "bootstrapCredentialsProvider");
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01bf A[Catch: all -> 0x004f, TryCatch #3 {all -> 0x004f, blocks: (B:13:0x004a, B:36:0x015b, B:53:0x01b3, B:55:0x01bf, B:56:0x01e1, B:57:0x01e2, B:58:0x01eb), top: B:63:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e2 A[Catch: all -> 0x004f, TryCatch #3 {all -> 0x004f, blocks: (B:13:0x004a, B:36:0x015b, B:53:0x01b3, B:55:0x01bf, B:56:0x01e1, B:57:0x01e2, B:58:0x01eb), top: B:63:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Throwable {
        C30311 c30311;
        final Attributes attributes2;
        Logger logger;
        TelemetryProvider telemetryProvider;
        StsAssumeRoleCredentialsProvider stsAssumeRoleCredentialsProvider;
        StsClient stsClient;
        StsClient stsClient2;
        final aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Credentials credentials;
        String arn;
        if (continuation instanceof C30311) {
            c30311 = (C30311) continuation;
            if ((c30311.label & Integer.MIN_VALUE) != 0) {
                c30311.label -= Integer.MIN_VALUE;
            } else {
                c30311 = new C30311(continuation);
            }
        }
        Object objAssumeRole = c30311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30311.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAssumeRole);
                CoroutineContext coroutineContext = c30311.get$context();
                String qualifiedName = Reflection.getOrCreateKotlinClass(StsAssumeRoleCredentialsProvider.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
                }
                Logger logger2 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
                Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StsAssumeRoleCredentialsProvider.resolve$lambda$0();
                    }
                }, 1, null);
                final TelemetryProvider telemetryProvider2 = TelemetryProviderContextKt.getTelemetryProvider(c30311.get$context());
                StsClient.Companion companion = StsClient.INSTANCE;
                attributes2 = attributes;
                Function1 function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StsAssumeRoleCredentialsProvider.resolve$lambda$1(this.f$0, telemetryProvider2, attributes2, (StsClient.Config.Builder) obj);
                    }
                };
                c30311.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                c30311.L$1 = logger2;
                c30311.L$2 = this;
                c30311.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider2);
                c30311.label = 1;
                Object objFromEnvironment = companion.fromEnvironment(function1, c30311);
                if (objFromEnvironment != coroutine_suspended) {
                    logger = logger2;
                    objAssumeRole = objFromEnvironment;
                    telemetryProvider = telemetryProvider2;
                    stsAssumeRoleCredentialsProvider = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30311.I$0;
                stsClient2 = (StsClient) c30311.L$4;
                logger = (Logger) c30311.L$1;
                try {
                    try {
                        ResultKt.throwOnFailure(objAssumeRole);
                        AssumeRoleResponse assumeRoleResponse = (AssumeRoleResponse) objAssumeRole;
                        stsClient2.close();
                        credentials = assumeRoleResponse.getCredentials();
                        if (credentials != null) {
                            throw new CredentialsProviderException("STS credentials must not be null", null, 2, null);
                        }
                        AssumedRoleUser assumedRoleUser = assumeRoleResponse.getAssumedRoleUser();
                        String accountId = (assumedRoleUser == null || (arn = assumedRoleUser.getArn()) == null) ? null : Arn.INSTANCE.parse(arn).getAccountId();
                        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StsAssumeRoleCredentialsProvider.resolve$lambda$5(credentials);
                            }
                        }, 1, null);
                        return AwsBusinessMetricsUtilsKt.withBusinessMetric(CredentialsExtKt.credentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken(), credentials.getExpiration(), "AssumeRoleProvider", accountId), AwsBusinessMetric.Credentials.CREDENTIALS_STS_ASSUME_ROLE);
                    } catch (Exception e) {
                        e = e;
                        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StsAssumeRoleCredentialsProvider.resolve$lambda$3();
                            }
                        }, 1, null);
                        if (!(e instanceof RegionDisabledException)) {
                            throw new ProviderConfigurationException("STS is not activated in the requested region (" + stsClient2.getConfig().getRegion() + "). Please check your configuration and activate STS in the target region if necessary", e);
                        }
                        throw new CredentialsProviderException("failed to assume role from STS", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    stsClient2.close();
                    throw th;
                }
            }
            TelemetryProvider telemetryProvider3 = (TelemetryProvider) c30311.L$3;
            StsAssumeRoleCredentialsProvider stsAssumeRoleCredentialsProvider2 = (StsAssumeRoleCredentialsProvider) c30311.L$2;
            Logger logger3 = (Logger) c30311.L$1;
            attributes2 = (Attributes) c30311.L$0;
            ResultKt.throwOnFailure(objAssumeRole);
            telemetryProvider = telemetryProvider3;
            logger = logger3;
            stsAssumeRoleCredentialsProvider = stsAssumeRoleCredentialsProvider2;
            AssumeRoleRequest.Builder builder = new AssumeRoleRequest.Builder();
            AssumeRoleParameters assumeRoleParameters = stsAssumeRoleCredentialsProvider.getAssumeRoleParameters();
            builder.setRoleArn(assumeRoleParameters.getRoleArn());
            builder.setExternalId(assumeRoleParameters.getExternalId());
            String roleSessionName = assumeRoleParameters.getRoleSessionName();
            if (roleSessionName == null) {
                roleSessionName = StsAssumeRoleCredentialsProviderKt.defaultSessionName$default(null, 1, null);
            }
            builder.setRoleSessionName(roleSessionName);
            builder.setDurationSeconds(Boxing.boxInt((int) Duration.m15870getInWholeSecondsimpl(assumeRoleParameters.getDuration())));
            builder.setPolicyArns(assumeRoleParameters.getConvertedPolicyArns$aws_config());
            builder.setPolicy(assumeRoleParameters.getPolicy());
            builder.setTags(assumeRoleParameters.getConvertedTags$aws_config());
            builder.setTransitiveTagKeys(assumeRoleParameters.getTransitiveTagKeys());
            builder.setSerialNumber(assumeRoleParameters.getSerialNumber());
            builder.setTokenCode(assumeRoleParameters.getTokenCode());
            builder.setSourceIdentity(assumeRoleParameters.getSourceIdentity());
            AssumeRoleRequest assumeRoleRequestBuild = builder.build();
            c30311.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
            c30311.L$1 = logger;
            c30311.L$2 = SpillingKt.nullOutSpilledVariable(stsAssumeRoleCredentialsProvider);
            c30311.L$3 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
            c30311.L$4 = stsClient;
            c30311.L$5 = SpillingKt.nullOutSpilledVariable(stsClient);
            c30311.I$0 = 0;
            c30311.label = 2;
            objAssumeRole = stsClient.assumeRole(assumeRoleRequestBuild, c30311);
            if (objAssumeRole != coroutine_suspended) {
                stsClient2 = stsClient;
                AssumeRoleResponse assumeRoleResponse2 = (AssumeRoleResponse) objAssumeRole;
                stsClient2.close();
                credentials = assumeRoleResponse2.getCredentials();
                if (credentials != null) {
                }
            }
            return coroutine_suspended;
        } catch (Exception e2) {
            e = e2;
            stsClient2 = stsClient;
            Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsAssumeRoleCredentialsProvider$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StsAssumeRoleCredentialsProvider.resolve$lambda$3();
                }
            }, 1, null);
            if (!(e instanceof RegionDisabledException)) {
            }
        } catch (Throwable th2) {
            th = th2;
            stsClient2 = stsClient;
            stsClient2.close();
            throw th;
        }
        stsClient = (StsClient) objAssumeRole;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0() {
        return "retrieving assumed credentials";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolve$lambda$1(StsAssumeRoleCredentialsProvider stsAssumeRoleCredentialsProvider, TelemetryProvider telemetryProvider, Attributes attributes, StsClient.Config.Builder fromEnvironment) {
        Intrinsics.checkNotNullParameter(fromEnvironment, "$this$fromEnvironment");
        String str = stsAssumeRoleCredentialsProvider.region;
        if (str == null) {
            str = "aws-global";
        }
        fromEnvironment.setRegion(str);
        fromEnvironment.setCredentialsProvider(stsAssumeRoleCredentialsProvider.bootstrapCredentialsProvider);
        fromEnvironment.setHttpClient(stsAssumeRoleCredentialsProvider.httpClient);
        fromEnvironment.setTelemetryProvider(telemetryProvider);
        fromEnvironment.setLogMode((LogMode) attributes.getOrNull(SdkClientOption.INSTANCE.getLogMode()));
        fromEnvironment.setApplicationId((String) attributes.getOrNull(AwsSdkClientOption.INSTANCE.getApplicationId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$3() {
        return "sts refused to grant assumed role credentials";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$5(aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Credentials credentials) {
        return "obtained assumed credentials; expiration=" + credentials.getExpiration().format(TimestampFormat.ISO_8601);
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
