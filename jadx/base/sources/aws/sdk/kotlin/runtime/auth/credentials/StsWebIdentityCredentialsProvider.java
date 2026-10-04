package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.arns.Arn;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumedRoleUser;
import aws.sdk.kotlin.runtime.config.AwsSdkClientOption;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
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
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: StsWebIdentityCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBO\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u0011J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\n\u0010\u001f\u001a\u00020\u0005H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StsWebIdentityCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "webIdentityParameters", "Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleWithWebIdentityParameters;", TtmlNode.TAG_REGION, "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleWithWebIdentityParameters;Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "roleArn", "webIdentityTokenFilePath", "roleSessionName", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLaws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWebIdentityParameters", "()Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleWithWebIdentityParameters;", "getRegion", "()Ljava/lang/String;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "Companion", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StsWebIdentityCredentialsProvider implements CredentialsProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final String region;
    private final AssumeRoleWithWebIdentityParameters webIdentityParameters;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: StsWebIdentityCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider", m1609f = "StsWebIdentityCredentialsProvider.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {115, 120, 199}, m1612m = "resolve", m1613n = {"attributes", "logger", "provider", "params", "attributes", "logger", "provider", "params", "token", "telemetry", "attributes", "logger", "provider", "params", "token", "telemetry", "client", "$this$assumeRoleWithWebIdentity$iv", "$i$f$assumeRoleWithWebIdentity"}, m1614nl = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, TsExtractor.TS_STREAM_TYPE_AC3, 143}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, m1616v = 2)
    static final class C30321 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C30321(Continuation<? super C30321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StsWebIdentityCredentialsProvider.this.resolve(null, this);
        }
    }

    public /* synthetic */ StsWebIdentityCredentialsProvider(String str, String str2, String str3, String str4, long j, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, j, platformProvider, httpClientEngine);
    }

    public StsWebIdentityCredentialsProvider(AssumeRoleWithWebIdentityParameters webIdentityParameters, String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        Intrinsics.checkNotNullParameter(webIdentityParameters, "webIdentityParameters");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.webIdentityParameters = webIdentityParameters;
        this.region = str;
        this.platformProvider = platformProvider;
        this.httpClient = httpClientEngine;
    }

    public final AssumeRoleWithWebIdentityParameters getWebIdentityParameters() {
        return this.webIdentityParameters;
    }

    public final String getRegion() {
        return this.region;
    }

    public /* synthetic */ StsWebIdentityCredentialsProvider(AssumeRoleWithWebIdentityParameters assumeRoleWithWebIdentityParameters, String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assumeRoleWithWebIdentityParameters, str, (i & 4) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 8) != 0 ? null : httpClientEngine);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StsWebIdentityCredentialsProvider(String str, String str2, String str3, String str4, long j, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        String str5 = (i & 8) != 0 ? null : str4;
        if ((i & 16) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(900, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(str, str2, str3, str5, duration, (i & 32) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 64) != 0 ? null : httpClientEngine, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private StsWebIdentityCredentialsProvider(String roleArn, String webIdentityTokenFilePath, String str, String str2, long j, PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        this(new AssumeRoleWithWebIdentityParameters(roleArn, webIdentityTokenFilePath, str2, j, null, null, null, 112, null), str, platformProvider, httpClientEngine);
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
        Intrinsics.checkNotNullParameter(webIdentityTokenFilePath, "webIdentityTokenFilePath");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
    }

    /* JADX INFO: compiled from: StsWebIdentityCredentialsProvider.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StsWebIdentityCredentialsProvider$Companion;", "", "<init>", "()V", "fromEnvironment", "Laws/sdk/kotlin/runtime/auth/credentials/StsWebIdentityCredentialsProvider;", "roleArn", "", "webIdentityTokenFilePath", TtmlNode.TAG_REGION, "roleSessionName", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "fromEnvironment-TUY-ock", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLaws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)Laws/sdk/kotlin/runtime/auth/credentials/StsWebIdentityCredentialsProvider;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromEnvironment-TUY-ock$default, reason: not valid java name */
        public static /* synthetic */ StsWebIdentityCredentialsProvider m12043fromEnvironmentTUYock$default(Companion companion, String str, String str2, String str3, String str4, long j, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            if ((i & 16) != 0) {
                Duration.Companion companion2 = Duration.INSTANCE;
                j = DurationKt.toDuration(900, DurationUnit.SECONDS);
            }
            if ((i & 32) != 0) {
                platformProvider = PlatformProvider.INSTANCE.getSystem();
            }
            if ((i & 64) != 0) {
                httpClientEngine = null;
            }
            return companion.m12044fromEnvironmentTUYock(str, str2, str3, str4, j, platformProvider, httpClientEngine);
        }

        /* JADX INFO: renamed from: fromEnvironment-TUY-ock, reason: not valid java name */
        public final StsWebIdentityCredentialsProvider m12044fromEnvironmentTUYock(String roleArn, String webIdentityTokenFilePath, String region, String roleSessionName, long duration, PlatformProvider platformProvider, HttpClientEngine httpClient) {
            Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
            EnvironmentSetting<String> awsRoleArn = AwsSdkSetting.INSTANCE.getAwsRoleArn();
            Object obj = roleArn;
            if (roleArn == null) {
                Object objResolve = EnvironmentSettingKt.resolve(awsRoleArn, platformProvider);
                obj = objResolve;
                if (objResolve == null) {
                    throw new ProviderConfigurationException("Required field `roleArn` could not be automatically inferred for StsWebIdentityCredentialsProvider. Either explicitly pass a value, set the environment variable `" + awsRoleArn.getEnvVar() + "`, or set the JVM system property `" + awsRoleArn.getSysProp() + '`', null, 2, null);
                }
            }
            String str = (String) obj;
            EnvironmentSetting<String> awsWebIdentityTokenFile = AwsSdkSetting.INSTANCE.getAwsWebIdentityTokenFile();
            Object obj2 = webIdentityTokenFilePath;
            if (webIdentityTokenFilePath == null) {
                Object objResolve2 = EnvironmentSettingKt.resolve(awsWebIdentityTokenFile, platformProvider);
                obj2 = objResolve2;
                if (objResolve2 == null) {
                    throw new ProviderConfigurationException("Required field `webIdentityTokenFilePath` could not be automatically inferred for StsWebIdentityCredentialsProvider. Either explicitly pass a value, set the environment variable `" + awsWebIdentityTokenFile.getEnvVar() + "`, or set the JVM system property `" + awsWebIdentityTokenFile.getSysProp() + '`', null, 2, null);
                }
            }
            String str2 = (String) obj2;
            if (region == null) {
                region = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRegion(), platformProvider);
            }
            return new StsWebIdentityCredentialsProvider(str, str2, region, roleSessionName, duration, platformProvider, httpClient, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x014b A[Catch: all -> 0x01fb, Exception -> 0x01fe, TryCatch #4 {Exception -> 0x01fe, all -> 0x01fb, blocks: (B:39:0x0126, B:41:0x014b, B:42:0x0155), top: B:75:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Throwable {
        C30321 c30321;
        final Attributes attributes2;
        AssumeRoleWithWebIdentityParameters assumeRoleWithWebIdentityParameters;
        Logger logger;
        final StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider;
        String strDecodeToString;
        final TelemetryProvider telemetryProvider;
        String str;
        Attributes attributes3;
        StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider2;
        StsClient stsClient;
        StsClient stsClient2;
        String roleSessionName;
        final aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Credentials credentials;
        String arn;
        Arn arn2;
        if (continuation instanceof C30321) {
            c30321 = (C30321) continuation;
            if ((c30321.label & Integer.MIN_VALUE) != 0) {
                c30321.label -= Integer.MIN_VALUE;
            } else {
                c30321 = new C30321(continuation);
            }
        }
        Object objAssumeRoleWithWebIdentity = c30321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30321.label;
        String accountId = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objAssumeRoleWithWebIdentity);
            CoroutineContext coroutineContext = c30321.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(StsAssumeRoleCredentialsProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger2 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StsWebIdentityCredentialsProvider.resolve$lambda$0();
                }
            }, 1, null);
            AssumeRoleWithWebIdentityParameters assumeRoleWithWebIdentityParameters2 = this.webIdentityParameters;
            PlatformProvider platformProvider = this.platformProvider;
            String webIdentityTokenFilePath = assumeRoleWithWebIdentityParameters2.getWebIdentityTokenFilePath();
            attributes2 = attributes;
            c30321.L$0 = attributes2;
            c30321.L$1 = logger2;
            c30321.L$2 = this;
            c30321.L$3 = assumeRoleWithWebIdentityParameters2;
            c30321.label = 1;
            Object fileOrNull = platformProvider.readFileOrNull(webIdentityTokenFilePath, c30321);
            if (fileOrNull != coroutine_suspended) {
                assumeRoleWithWebIdentityParameters = assumeRoleWithWebIdentityParameters2;
                objAssumeRoleWithWebIdentity = fileOrNull;
                logger = logger2;
                stsWebIdentityCredentialsProvider = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30321.I$0;
                stsClient2 = (StsClient) c30321.L$6;
                logger = (Logger) c30321.L$1;
                try {
                    try {
                        ResultKt.throwOnFailure(objAssumeRoleWithWebIdentity);
                        AssumeRoleWithWebIdentityResponse assumeRoleWithWebIdentityResponse = (AssumeRoleWithWebIdentityResponse) objAssumeRoleWithWebIdentity;
                        stsClient2.close();
                        credentials = assumeRoleWithWebIdentityResponse.getCredentials();
                        if (credentials != null) {
                            throw new CredentialsProviderException("STS credentials must not be null", null, 2, null);
                        }
                        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StsWebIdentityCredentialsProvider.resolve$lambda$4(credentials);
                            }
                        }, 1, null);
                        AssumedRoleUser assumedRoleUser = assumeRoleWithWebIdentityResponse.getAssumedRoleUser();
                        if (assumedRoleUser != null && (arn = assumedRoleUser.getArn()) != null && (arn2 = Arn.INSTANCE.parse(arn)) != null) {
                            accountId = arn2.getAccountId();
                        }
                        return AwsBusinessMetricsUtilsKt.withBusinessMetric(CredentialsExtKt.credentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken(), credentials.getExpiration(), "WebIdentityToken", accountId), AwsBusinessMetric.Credentials.CREDENTIALS_STS_ASSUME_ROLE_WEB_ID);
                    } catch (Exception e) {
                        e = e;
                        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StsWebIdentityCredentialsProvider.resolve$lambda$3();
                            }
                        }, 1, null);
                        throw new CredentialsProviderException("STS failed to assume role from web identity", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    stsClient2.close();
                    throw th;
                }
            }
            TelemetryProvider telemetryProvider2 = (TelemetryProvider) c30321.L$5;
            str = (String) c30321.L$4;
            assumeRoleWithWebIdentityParameters = (AssumeRoleWithWebIdentityParameters) c30321.L$3;
            stsWebIdentityCredentialsProvider2 = (StsWebIdentityCredentialsProvider) c30321.L$2;
            Logger logger3 = (Logger) c30321.L$1;
            attributes3 = (Attributes) c30321.L$0;
            ResultKt.throwOnFailure(objAssumeRoleWithWebIdentity);
            telemetryProvider = telemetryProvider2;
            logger = logger3;
            stsClient = (StsClient) objAssumeRoleWithWebIdentity;
            try {
                AssumeRoleWithWebIdentityRequest.Builder builder = new AssumeRoleWithWebIdentityRequest.Builder();
                builder.setRoleArn(assumeRoleWithWebIdentityParameters.getRoleArn());
                builder.setWebIdentityToken(str);
                builder.setDurationSeconds(Boxing.boxInt((int) Duration.m15870getInWholeSecondsimpl(assumeRoleWithWebIdentityParameters.getDuration())));
                roleSessionName = assumeRoleWithWebIdentityParameters.getRoleSessionName();
                if (roleSessionName == null) {
                    roleSessionName = StsAssumeRoleCredentialsProviderKt.defaultSessionName(getPlatformProvider());
                }
                builder.setRoleSessionName(roleSessionName);
                builder.setProviderId(assumeRoleWithWebIdentityParameters.getProviderId());
                builder.setPolicyArns(assumeRoleWithWebIdentityParameters.getConvertedPolicyArns$aws_config());
                builder.setPolicy(assumeRoleWithWebIdentityParameters.getPolicy());
                AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequestBuild = builder.build();
                c30321.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
                c30321.L$1 = logger;
                c30321.L$2 = SpillingKt.nullOutSpilledVariable(stsWebIdentityCredentialsProvider2);
                c30321.L$3 = SpillingKt.nullOutSpilledVariable(assumeRoleWithWebIdentityParameters);
                c30321.L$4 = SpillingKt.nullOutSpilledVariable(str);
                c30321.L$5 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
                c30321.L$6 = stsClient;
                c30321.L$7 = SpillingKt.nullOutSpilledVariable(stsClient);
                c30321.I$0 = 0;
                c30321.label = 3;
                objAssumeRoleWithWebIdentity = stsClient.assumeRoleWithWebIdentity(assumeRoleWithWebIdentityRequestBuild, c30321);
                if (objAssumeRoleWithWebIdentity != coroutine_suspended) {
                    stsClient2 = stsClient;
                    AssumeRoleWithWebIdentityResponse assumeRoleWithWebIdentityResponse2 = (AssumeRoleWithWebIdentityResponse) objAssumeRoleWithWebIdentity;
                    stsClient2.close();
                    credentials = assumeRoleWithWebIdentityResponse2.getCredentials();
                    if (credentials != null) {
                    }
                }
                return coroutine_suspended;
            } catch (Exception e2) {
                e = e2;
                stsClient2 = stsClient;
                Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StsWebIdentityCredentialsProvider.resolve$lambda$3();
                    }
                }, 1, null);
                throw new CredentialsProviderException("STS failed to assume role from web identity", e);
            } catch (Throwable th2) {
                th = th2;
                stsClient2 = stsClient;
                stsClient2.close();
                throw th;
            }
        }
        AssumeRoleWithWebIdentityParameters assumeRoleWithWebIdentityParameters3 = (AssumeRoleWithWebIdentityParameters) c30321.L$3;
        stsWebIdentityCredentialsProvider = (StsWebIdentityCredentialsProvider) c30321.L$2;
        Logger logger4 = (Logger) c30321.L$1;
        attributes2 = (Attributes) c30321.L$0;
        ResultKt.throwOnFailure(objAssumeRoleWithWebIdentity);
        assumeRoleWithWebIdentityParameters = assumeRoleWithWebIdentityParameters3;
        logger = logger4;
        byte[] bArr = (byte[]) objAssumeRoleWithWebIdentity;
        if (bArr == null || (strDecodeToString = StringsKt.decodeToString(bArr)) == null) {
            throw new CredentialsProviderException("failed to read webIdentityToken from " + assumeRoleWithWebIdentityParameters.getWebIdentityTokenFilePath(), null, 2, null);
        }
        telemetryProvider = TelemetryProviderContextKt.getTelemetryProvider(c30321.get$context());
        StsClient.Companion companion = StsClient.INSTANCE;
        Function1 function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.StsWebIdentityCredentialsProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StsWebIdentityCredentialsProvider.resolve$lambda$1(this.f$0, telemetryProvider, attributes2, (StsClient.Config.Builder) obj);
            }
        };
        c30321.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
        c30321.L$1 = logger;
        c30321.L$2 = SpillingKt.nullOutSpilledVariable(stsWebIdentityCredentialsProvider);
        c30321.L$3 = assumeRoleWithWebIdentityParameters;
        c30321.L$4 = strDecodeToString;
        c30321.L$5 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
        c30321.label = 2;
        Object objFromEnvironment = companion.fromEnvironment(function1, c30321);
        if (objFromEnvironment != coroutine_suspended) {
            StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider3 = stsWebIdentityCredentialsProvider;
            str = strDecodeToString;
            objAssumeRoleWithWebIdentity = objFromEnvironment;
            attributes3 = attributes2;
            stsWebIdentityCredentialsProvider2 = stsWebIdentityCredentialsProvider3;
            stsClient = (StsClient) objAssumeRoleWithWebIdentity;
            AssumeRoleWithWebIdentityRequest.Builder builder2 = new AssumeRoleWithWebIdentityRequest.Builder();
            builder2.setRoleArn(assumeRoleWithWebIdentityParameters.getRoleArn());
            builder2.setWebIdentityToken(str);
            builder2.setDurationSeconds(Boxing.boxInt((int) Duration.m15870getInWholeSecondsimpl(assumeRoleWithWebIdentityParameters.getDuration())));
            roleSessionName = assumeRoleWithWebIdentityParameters.getRoleSessionName();
            if (roleSessionName == null) {
            }
            builder2.setRoleSessionName(roleSessionName);
            builder2.setProviderId(assumeRoleWithWebIdentityParameters.getProviderId());
            builder2.setPolicyArns(assumeRoleWithWebIdentityParameters.getConvertedPolicyArns$aws_config());
            builder2.setPolicy(assumeRoleWithWebIdentityParameters.getPolicy());
            AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequestBuild2 = builder2.build();
            c30321.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
            c30321.L$1 = logger;
            c30321.L$2 = SpillingKt.nullOutSpilledVariable(stsWebIdentityCredentialsProvider2);
            c30321.L$3 = SpillingKt.nullOutSpilledVariable(assumeRoleWithWebIdentityParameters);
            c30321.L$4 = SpillingKt.nullOutSpilledVariable(str);
            c30321.L$5 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
            c30321.L$6 = stsClient;
            c30321.L$7 = SpillingKt.nullOutSpilledVariable(stsClient);
            c30321.I$0 = 0;
            c30321.label = 3;
            objAssumeRoleWithWebIdentity = stsClient.assumeRoleWithWebIdentity(assumeRoleWithWebIdentityRequestBuild2, c30321);
            if (objAssumeRoleWithWebIdentity != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0() {
        return "retrieving assumed credentials via web identity";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolve$lambda$1(StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider, TelemetryProvider telemetryProvider, Attributes attributes, StsClient.Config.Builder fromEnvironment) {
        Intrinsics.checkNotNullParameter(fromEnvironment, "$this$fromEnvironment");
        fromEnvironment.setRegion(stsWebIdentityCredentialsProvider.region);
        fromEnvironment.setHttpClient(stsWebIdentityCredentialsProvider.httpClient);
        fromEnvironment.setTelemetryProvider(telemetryProvider);
        fromEnvironment.setLogMode((LogMode) attributes.getOrNull(SdkClientOption.INSTANCE.getLogMode()));
        fromEnvironment.setApplicationId((String) attributes.getOrNull(AwsSdkClientOption.INSTANCE.getApplicationId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$3() {
        return "sts refused to grant assumed role credentials from web identity";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$4(aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Credentials credentials) {
        return "obtained assumed credentials via web identity; expiration=" + credentials.getExpiration().format(TimestampFormat.ISO_8601);
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
