package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.auth.credentials.profile.LeafProvider;
import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChain;
import aws.sdk.kotlin.runtime.auth.credentials.profile.RoleArn;
import aws.sdk.kotlin.runtime.auth.credentials.profile.RoleArnSource;
import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigurationSource;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ProfileCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB7\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\rJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\"\u0010$\u001a\u00020\u001c*\u00020%2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&H\u0082@¢\u0006\u0002\u0010'J*\u0010$\u001a\u00020\u001c*\u00020(2\u0006\u0010)\u001a\u00020\u001e2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&H\u0082@¢\u0006\u0002\u0010*J\f\u0010+\u001a\u00020\u0003*\u00020%H\u0002J\n\u0010,\u001a\u00020\u0003H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/ProfileCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "profileName", "", TtmlNode.TAG_REGION, "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "configurationSource", "Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;)V", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getProfileName", "()Ljava/lang/String;", "getRegion", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getConfigurationSource", "()Laws/sdk/kotlin/runtime/config/profile/AwsConfigurationSource;", "credentialsBusinessMetrics", "", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "namedProviders", "", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "toCredentialsProvider", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "(Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArn;", "creds", "(Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArn;Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "description", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProfileCredentialsProvider implements CloseableCredentialsProvider {
    private final AwsConfigurationSource configurationSource;
    private final Set<BusinessMetric> credentialsBusinessMetrics;
    private final HttpClientEngine httpClient;
    private final Map<String, CredentialsProvider> namedProviders;
    private final PlatformProvider platformProvider;
    private final String profileName;
    private final String region;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: ProfileCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider", m1609f = "ProfileCredentialsProvider.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, m1611l = {PDFACompliance.e_PDFA1_2_2, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, PDFACompliance.e_PDFA1_3_2, 140, 146}, m1612m = "resolve", m1613n = {"attributes", "logger", "attributes", "logger", "sharedConfig", "chain", "profileOverride", TtmlNode.TAG_REGION, "attributes", "logger", "sharedConfig", "chain", "profileOverride", TtmlNode.TAG_REGION, "leaf", "creds", "attributes", "logger", "sharedConfig", "chain", "profileOverride", TtmlNode.TAG_REGION, "leaf", "creds", "$this$forEach$iv", "element$iv", "roleArn", "$i$f$forEach", "$i$a$-forEach-ProfileCredentialsProvider$resolve$4", "attributes", "logger", "sharedConfig", "chain", "profileOverride", TtmlNode.TAG_REGION, "leaf", "creds", "$this$forEach$iv", "element$iv", "roleArn", "assumeProvider", "$i$f$forEach", "$i$a$-forEach-ProfileCredentialsProvider$resolve$4"}, m1614nl = {PDFACompliance.e_PDFA1_2_3, PDFACompliance.e_PDFA1_3_1, 134, PDFACompliance.e_PDFA1_4_2, 147}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "I$0", "I$1"}, m1616v = 2)
    static final class C30201 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C30201(Continuation<? super C30201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileCredentialsProvider.this.resolve(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$toCredentialsProvider$1 */
    /* JADX INFO: compiled from: ProfileCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider", m1609f = "ProfileCredentialsProvider.kt", m1610i = {0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA1_7_1, 202}, m1612m = "toCredentialsProvider", m1613n = {"$this$toCredentialsProvider", TtmlNode.TAG_REGION, "$this$toCredentialsProvider", TtmlNode.TAG_REGION}, m1614nl = {172, 203}, m1615s = {"L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C30211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30211(Continuation<? super C30211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileCredentialsProvider.this.toCredentialsProvider(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$toCredentialsProvider$9 */
    /* JADX INFO: compiled from: ProfileCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider", m1609f = "ProfileCredentialsProvider.kt", m1610i = {0, 0, 0}, m1611l = {217}, m1612m = "toCredentialsProvider", m1613n = {"$this$toCredentialsProvider", "creds", TtmlNode.TAG_REGION}, m1614nl = {218}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C30229 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C30229(Continuation<? super C30229> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileCredentialsProvider.this.toCredentialsProvider(null, null, null, this);
        }
    }

    @InternalSdkApi
    public ProfileCredentialsProvider() {
        this(null, null, null, null, null, 31, null);
    }

    @InternalSdkApi
    public ProfileCredentialsProvider(String str, String str2, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, AwsConfigurationSource awsConfigurationSource) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.profileName = str;
        this.region = str2;
        this.platformProvider = platformProvider;
        this.httpClient = httpClientEngine;
        this.configurationSource = awsConfigurationSource;
        this.credentialsBusinessMetrics = new LinkedHashSet();
        this.namedProviders = MapsKt.mapOf(TuplesKt.m1606to("Environment", new EnvironmentCredentialsProvider(new ProfileCredentialsProvider$namedProviders$1(platformProvider))), TuplesKt.m1606to("Ec2InstanceMetadata", new ImdsCredentialsProvider(null, LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileCredentialsProvider.namedProviders$lambda$0(this.f$0);
            }
        }), platformProvider, null, 9, null)), TuplesKt.m1606to("EcsContainer", new EcsCredentialsProvider(platformProvider, httpClientEngine)));
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public final String getRegion() {
        return this.region;
    }

    public /* synthetic */ ProfileCredentialsProvider(String str, String str2, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, AwsConfigurationSource awsConfigurationSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 8) != 0 ? null : httpClientEngine, (i & 16) != 0 ? null : awsConfigurationSource);
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public final AwsConfigurationSource getConfigurationSource() {
        return this.configurationSource;
    }

    public /* synthetic */ ProfileCredentialsProvider(String str, String str2, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 8) != 0 ? null : httpClientEngine);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileCredentialsProvider(String str, String str2, PlatformProvider platformProvider, HttpClientEngine httpClientEngine) {
        this(str, str2, platformProvider, httpClientEngine, null);
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImdsClient namedProviders$lambda$0(final ProfileCredentialsProvider profileCredentialsProvider) {
        return ImdsClient.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileCredentialsProvider.namedProviders$lambda$0$0(this.f$0, (ImdsClient.Builder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit namedProviders$lambda$0$0(ProfileCredentialsProvider profileCredentialsProvider, ImdsClient.Builder ImdsClient) {
        Intrinsics.checkNotNullParameter(ImdsClient, "$this$ImdsClient");
        ImdsClient.setPlatformProvider$aws_config(profileCredentialsProvider.platformProvider);
        ImdsClient.setEngine(profileCredentialsProvider.httpClient);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x031f -> B:60:0x0329). Please report as a decompilation issue!!! */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) throws Throwable {
        C30201 c30201;
        int i;
        Logger logger;
        Object obj;
        Attributes attributes2;
        AwsSharedConfig awsSharedConfig;
        Object obj2;
        Logger logger2;
        final ProfileChain profileChain;
        LazyAsyncValue<String> lazyAsyncValue;
        ConfigSection configSection;
        Attributes attributes3;
        final Ref.ObjectRef objectRef;
        Object objResolve;
        Attributes attributes4;
        Logger logger3;
        AwsSharedConfig awsSharedConfig2;
        ProfileChain profileChain2;
        CredentialsProvider credentialsProvider;
        Ref.ObjectRef objectRef2;
        T t;
        List<RoleArn> roles;
        Iterator it;
        int i2;
        CredentialsProvider credentialsProvider2;
        Iterable iterable;
        AwsSharedConfig awsSharedConfig3;
        ProfileChain profileChain3;
        ConfigSection configSection2;
        Iterator it2;
        Ref.ObjectRef objectRef3;
        Object obj3;
        RoleArn roleArn;
        LazyAsyncValue<String> lazyAsyncValue2;
        int i3;
        Logger logger4;
        int i4;
        Object obj4;
        Set set;
        Object objResolve2;
        if (continuation instanceof C30201) {
            c30201 = (C30201) continuation;
            if ((c30201.label & Integer.MIN_VALUE) != 0) {
                c30201.label -= Integer.MIN_VALUE;
            } else {
                c30201 = new C30201(continuation);
            }
        }
        Object obj5 = c30201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c30201.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj5);
            CoroutineContext coroutineContext = c30201.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(ProfileCredentialsProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger5 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            PlatformProvider platformProvider = this.platformProvider;
            String str = this.profileName;
            AwsConfigurationSource awsConfigurationSource = this.configurationSource;
            c30201.L$0 = attributes;
            c30201.L$1 = logger5;
            i = 1;
            c30201.label = 1;
            Object objLoadAwsSharedConfig = AwsConfigLoaderKt.loadAwsSharedConfig(platformProvider, str, awsConfigurationSource, c30201);
            if (objLoadAwsSharedConfig != coroutine_suspended) {
                logger = logger5;
                obj = objLoadAwsSharedConfig;
                attributes2 = attributes;
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            Logger logger6 = (Logger) c30201.L$1;
            attributes2 = (Attributes) c30201.L$0;
            ResultKt.throwOnFailure(obj5);
            logger = logger6;
            obj = obj5;
            i = 1;
        } else {
            if (i5 == 2) {
                LazyAsyncValue<String> lazyAsyncValue3 = (LazyAsyncValue) c30201.L$5;
                ConfigSection configSection3 = (ConfigSection) c30201.L$4;
                profileChain = (ProfileChain) c30201.L$3;
                AwsSharedConfig awsSharedConfig4 = (AwsSharedConfig) c30201.L$2;
                Logger logger7 = (Logger) c30201.L$1;
                Attributes attributes5 = (Attributes) c30201.L$0;
                ResultKt.throwOnFailure(obj5);
                logger2 = logger7;
                attributes3 = attributes5;
                configSection = configSection3;
                awsSharedConfig = awsSharedConfig4;
                lazyAsyncValue = lazyAsyncValue3;
                obj2 = obj5;
                CredentialsProvider credentialsProvider3 = (CredentialsProvider) obj2;
                Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileCredentialsProvider.resolve$lambda$2(this.f$0, profileChain);
                    }
                }, 1, null);
                objectRef = new Ref.ObjectRef();
                c30201.L$0 = attributes3;
                c30201.L$1 = logger2;
                c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig);
                c30201.L$3 = profileChain;
                c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection);
                c30201.L$5 = lazyAsyncValue;
                c30201.L$6 = SpillingKt.nullOutSpilledVariable(credentialsProvider3);
                c30201.L$7 = objectRef;
                c30201.L$8 = objectRef;
                c30201.label = 3;
                objResolve = credentialsProvider3.resolve(attributes3, c30201);
                if (objResolve != coroutine_suspended) {
                    attributes4 = attributes3;
                    logger3 = logger2;
                    awsSharedConfig2 = awsSharedConfig;
                    profileChain2 = profileChain;
                    credentialsProvider = credentialsProvider3;
                    objectRef2 = objectRef;
                    t = objResolve;
                    objectRef2.element = t;
                    roles = profileChain2.getRoles();
                    it = roles.iterator();
                    i2 = 0;
                    if (!it.hasNext()) {
                    }
                }
                return coroutine_suspended;
            }
            if (i5 == 3) {
                objectRef2 = (Ref.ObjectRef) c30201.L$8;
                objectRef = (Ref.ObjectRef) c30201.L$7;
                credentialsProvider = (CredentialsProvider) c30201.L$6;
                lazyAsyncValue = (LazyAsyncValue) c30201.L$5;
                configSection = (ConfigSection) c30201.L$4;
                ProfileChain profileChain4 = (ProfileChain) c30201.L$3;
                AwsSharedConfig awsSharedConfig5 = (AwsSharedConfig) c30201.L$2;
                Logger logger8 = (Logger) c30201.L$1;
                Attributes attributes6 = (Attributes) c30201.L$0;
                ResultKt.throwOnFailure(obj5);
                attributes4 = attributes6;
                logger3 = logger8;
                awsSharedConfig2 = awsSharedConfig5;
                profileChain2 = profileChain4;
                t = obj5;
                objectRef2.element = t;
                roles = profileChain2.getRoles();
                it = roles.iterator();
                i2 = 0;
                if (!it.hasNext()) {
                }
            } else {
                if (i5 == 4) {
                    int i6 = c30201.I$1;
                    int i7 = c30201.I$0;
                    RoleArn roleArn2 = (RoleArn) c30201.L$11;
                    Object obj6 = c30201.L$10;
                    Iterator it3 = (Iterator) c30201.L$9;
                    Iterable iterable2 = (Iterable) c30201.L$8;
                    objectRef3 = (Ref.ObjectRef) c30201.L$7;
                    CredentialsProvider credentialsProvider4 = (CredentialsProvider) c30201.L$6;
                    LazyAsyncValue<String> lazyAsyncValue4 = (LazyAsyncValue) c30201.L$5;
                    configSection2 = (ConfigSection) c30201.L$4;
                    profileChain3 = (ProfileChain) c30201.L$3;
                    awsSharedConfig3 = (AwsSharedConfig) c30201.L$2;
                    Logger logger9 = (Logger) c30201.L$1;
                    Attributes attributes7 = (Attributes) c30201.L$0;
                    ResultKt.throwOnFailure(obj5);
                    iterable = iterable2;
                    obj3 = obj6;
                    lazyAsyncValue2 = lazyAsyncValue4;
                    attributes4 = attributes7;
                    obj4 = obj5;
                    credentialsProvider2 = credentialsProvider4;
                    it2 = it3;
                    roleArn = roleArn2;
                    i3 = i6;
                    i4 = i7;
                    logger4 = logger9;
                    CredentialsProvider credentialsProvider5 = (CredentialsProvider) obj4;
                    RoleArn roleArn3 = roleArn;
                    Object obj7 = obj3;
                    set = (Set) ((Credentials) objectRef3.element).getAttributes().getOrNull(BusinessMetricsUtilsKt.getBusinessMetrics());
                    if (set != null) {
                    }
                    c30201.L$0 = attributes4;
                    c30201.L$1 = logger4;
                    c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig3);
                    c30201.L$3 = SpillingKt.nullOutSpilledVariable(profileChain3);
                    c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection2);
                    c30201.L$5 = lazyAsyncValue2;
                    c30201.L$6 = SpillingKt.nullOutSpilledVariable(credentialsProvider2);
                    c30201.L$7 = objectRef3;
                    c30201.L$8 = SpillingKt.nullOutSpilledVariable(iterable);
                    c30201.L$9 = it2;
                    c30201.L$10 = SpillingKt.nullOutSpilledVariable(obj7);
                    c30201.L$11 = SpillingKt.nullOutSpilledVariable(roleArn3);
                    c30201.L$12 = SpillingKt.nullOutSpilledVariable(credentialsProvider5);
                    c30201.L$13 = objectRef3;
                    c30201.I$0 = i4;
                    c30201.I$1 = i3;
                    c30201.label = 5;
                    objResolve2 = credentialsProvider5.resolve(attributes4, c30201);
                    if (objResolve2 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i5 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i8 = c30201.I$1;
                int i9 = c30201.I$0;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) c30201.L$13;
                Object obj8 = c30201.L$10;
                Iterator it4 = (Iterator) c30201.L$9;
                Iterable iterable3 = (Iterable) c30201.L$8;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) c30201.L$7;
                CredentialsProvider credentialsProvider6 = (CredentialsProvider) c30201.L$6;
                LazyAsyncValue<String> lazyAsyncValue5 = (LazyAsyncValue) c30201.L$5;
                ConfigSection configSection4 = (ConfigSection) c30201.L$4;
                ProfileChain profileChain5 = (ProfileChain) c30201.L$3;
                AwsSharedConfig awsSharedConfig6 = (AwsSharedConfig) c30201.L$2;
                logger3 = (Logger) c30201.L$1;
                Attributes attributes8 = (Attributes) c30201.L$0;
                ResultKt.throwOnFailure(obj5);
                i2 = i9;
                objectRef = objectRef5;
                iterable = iterable3;
                attributes4 = attributes8;
                awsSharedConfig2 = awsSharedConfig6;
                credentialsProvider = credentialsProvider6;
                profileChain3 = profileChain5;
                configSection = configSection4;
                T t2 = obj5;
                objectRef4.element = t2;
                it = it4;
                profileChain2 = profileChain3;
                lazyAsyncValue = lazyAsyncValue5;
                roles = iterable;
                if (!it.hasNext()) {
                    Object next = it.next();
                    final RoleArn roleArn4 = (RoleArn) next;
                    Iterable iterable4 = roles;
                    credentialsProvider2 = credentialsProvider;
                    ConfigSection configSection5 = configSection;
                    Logger.debug$default(logger3, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileCredentialsProvider.resolve$lambda$3$0(roleArn4);
                        }
                    }, 1, null);
                    if (roleArn4.getSource() == RoleArnSource.SOURCE_PROFILE) {
                        this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_SOURCE_PROFILE);
                    }
                    Credentials credentials = (Credentials) objectRef.element;
                    c30201.L$0 = attributes4;
                    c30201.L$1 = logger3;
                    c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig2);
                    c30201.L$3 = SpillingKt.nullOutSpilledVariable(profileChain2);
                    c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection5);
                    c30201.L$5 = lazyAsyncValue;
                    c30201.L$6 = SpillingKt.nullOutSpilledVariable(credentialsProvider2);
                    c30201.L$7 = objectRef;
                    c30201.L$8 = SpillingKt.nullOutSpilledVariable(iterable4);
                    c30201.L$9 = it;
                    c30201.L$10 = SpillingKt.nullOutSpilledVariable(next);
                    c30201.L$11 = SpillingKt.nullOutSpilledVariable(roleArn4);
                    c30201.L$12 = null;
                    c30201.L$13 = null;
                    c30201.I$0 = i2;
                    c30201.I$1 = 0;
                    c30201.label = 4;
                    Object credentialsProvider7 = toCredentialsProvider(roleArn4, credentials, lazyAsyncValue, c30201);
                    if (credentialsProvider7 != coroutine_suspended) {
                        profileChain3 = profileChain2;
                        obj3 = next;
                        iterable = iterable4;
                        lazyAsyncValue2 = lazyAsyncValue;
                        i3 = 0;
                        logger4 = logger3;
                        it2 = it;
                        roleArn = roleArn4;
                        awsSharedConfig3 = awsSharedConfig2;
                        objectRef3 = objectRef;
                        i4 = i2;
                        configSection2 = configSection5;
                        obj4 = credentialsProvider7;
                        CredentialsProvider credentialsProvider52 = (CredentialsProvider) obj4;
                        RoleArn roleArn32 = roleArn;
                        Object obj72 = obj3;
                        set = (Set) ((Credentials) objectRef3.element).getAttributes().getOrNull(BusinessMetricsUtilsKt.getBusinessMetrics());
                        if (set != null) {
                            for (Iterator it5 = set.iterator(); it5.hasNext(); it5 = it5) {
                                this.credentialsBusinessMetrics.add((BusinessMetric) it5.next());
                            }
                        }
                        c30201.L$0 = attributes4;
                        c30201.L$1 = logger4;
                        c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig3);
                        c30201.L$3 = SpillingKt.nullOutSpilledVariable(profileChain3);
                        c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection2);
                        c30201.L$5 = lazyAsyncValue2;
                        c30201.L$6 = SpillingKt.nullOutSpilledVariable(credentialsProvider2);
                        c30201.L$7 = objectRef3;
                        c30201.L$8 = SpillingKt.nullOutSpilledVariable(iterable);
                        c30201.L$9 = it2;
                        c30201.L$10 = SpillingKt.nullOutSpilledVariable(obj72);
                        c30201.L$11 = SpillingKt.nullOutSpilledVariable(roleArn32);
                        c30201.L$12 = SpillingKt.nullOutSpilledVariable(credentialsProvider52);
                        c30201.L$13 = objectRef3;
                        c30201.I$0 = i4;
                        c30201.I$1 = i3;
                        c30201.label = 5;
                        objResolve2 = credentialsProvider52.resolve(attributes4, c30201);
                        if (objResolve2 != coroutine_suspended) {
                            objectRef4 = objectRef3;
                            it4 = it2;
                            logger3 = logger4;
                            awsSharedConfig2 = awsSharedConfig3;
                            credentialsProvider = credentialsProvider2;
                            lazyAsyncValue5 = lazyAsyncValue2;
                            configSection = configSection2;
                            i2 = i4;
                            objectRef = objectRef4;
                            t2 = objResolve2;
                            objectRef4.element = t2;
                            it = it4;
                            profileChain2 = profileChain3;
                            lazyAsyncValue = lazyAsyncValue5;
                            roles = iterable;
                            if (!it.hasNext()) {
                                Logger.debug$default(logger3, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ProfileCredentialsProvider.resolve$lambda$4(objectRef);
                                    }
                                }, 1, null);
                                return AwsBusinessMetricsUtilsKt.withBusinessMetrics((Credentials) objectRef.element, this.credentialsBusinessMetrics);
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
        final AwsSharedConfig awsSharedConfig7 = (AwsSharedConfig) obj;
        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileCredentialsProvider.resolve$lambda$0(awsSharedConfig7);
            }
        }, i, null);
        ProfileChain profileChainResolve$aws_config = ProfileChain.INSTANCE.resolve$aws_config(awsSharedConfig7);
        String str2 = this.profileName;
        ConfigSection configSection6 = str2 != null ? awsSharedConfig7.getProfiles().get(str2) : null;
        LazyAsyncValue<String> lazyAsyncValueAsyncLazy = LazyAsyncValueKt.asyncLazy(new ProfileCredentialsProvider$resolve$region$1(this, configSection6, attributes2, null));
        LeafProvider leaf = profileChainResolve$aws_config.getLeaf();
        c30201.L$0 = attributes2;
        c30201.L$1 = logger;
        c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig7);
        c30201.L$3 = profileChainResolve$aws_config;
        c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection6);
        c30201.L$5 = lazyAsyncValueAsyncLazy;
        c30201.label = 2;
        Object credentialsProvider8 = toCredentialsProvider(leaf, lazyAsyncValueAsyncLazy, c30201);
        if (credentialsProvider8 != coroutine_suspended) {
            awsSharedConfig = awsSharedConfig7;
            obj2 = credentialsProvider8;
            ConfigSection configSection7 = configSection6;
            logger2 = logger;
            profileChain = profileChainResolve$aws_config;
            lazyAsyncValue = lazyAsyncValueAsyncLazy;
            configSection = configSection7;
            attributes3 = attributes2;
            CredentialsProvider credentialsProvider32 = (CredentialsProvider) obj2;
            Logger.debug$default(logger2, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileCredentialsProvider.resolve$lambda$2(this.f$0, profileChain);
                }
            }, 1, null);
            objectRef = new Ref.ObjectRef();
            c30201.L$0 = attributes3;
            c30201.L$1 = logger2;
            c30201.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig);
            c30201.L$3 = profileChain;
            c30201.L$4 = SpillingKt.nullOutSpilledVariable(configSection);
            c30201.L$5 = lazyAsyncValue;
            c30201.L$6 = SpillingKt.nullOutSpilledVariable(credentialsProvider32);
            c30201.L$7 = objectRef;
            c30201.L$8 = objectRef;
            c30201.label = 3;
            objResolve = credentialsProvider32.resolve(attributes3, c30201);
            if (objResolve != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0(AwsSharedConfig awsSharedConfig) {
        return "Loading credentials from profile `" + awsSharedConfig.getActiveProfile().getName() + '`';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$2(ProfileCredentialsProvider profileCredentialsProvider, ProfileChain profileChain) {
        return "Resolving credentials from " + profileCredentialsProvider.description(profileChain.getLeaf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$3$0(RoleArn roleArn) {
        return "Assuming role `" + roleArn.getRoleArn() + '`';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$4(Ref.ObjectRef objectRef) {
        StringBuilder sb = new StringBuilder("Obtained credentials from profile; expiration=");
        Instant expiration = ((Credentials) objectRef.element).getExpiration();
        return sb.append(expiration != null ? expiration.format(TimestampFormat.ISO_8601) : null).toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<Map.Entry<String, CredentialsProvider>> it = this.namedProviders.entrySet().iterator();
        while (it.hasNext()) {
            CloseableKt.closeIfCloseable(it.next().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toCredentialsProvider(LeafProvider leafProvider, LazyAsyncValue<String> lazyAsyncValue, Continuation<? super CredentialsProvider> continuation) {
        C30211 c30211;
        String str;
        Object obj;
        String str2;
        String str3;
        LeafProvider leafProvider2 = leafProvider;
        if (continuation instanceof C30211) {
            c30211 = (C30211) continuation;
            if ((c30211.label & Integer.MIN_VALUE) != 0) {
                c30211.label -= Integer.MIN_VALUE;
            } else {
                c30211 = new C30211(continuation);
            }
        }
        Object obj2 = c30211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30211.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str4 = (String) c30211.L$2;
                ResultKt.throwOnFailure(obj2);
                str = str4;
                LoginCredentialsProvider loginCredentialsProvider = new LoginCredentialsProvider(str, (String) obj2, null, null, null, 28, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_LOGIN);
                return loginCredentialsProvider;
            }
            String str5 = (String) c30211.L$3;
            String str6 = (String) c30211.L$2;
            LeafProvider leafProvider3 = (LeafProvider) c30211.L$0;
            ResultKt.throwOnFailure(obj2);
            str2 = str5;
            leafProvider2 = leafProvider3;
            str3 = str6;
            obj = obj2;
            StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider = new StsWebIdentityCredentialsProvider(str3, str2, (String) obj, ((LeafProvider.WebIdentityTokenRole) leafProvider2).getSessionName(), 0L, this.platformProvider, this.httpClient, 16, null);
            this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN);
            return stsWebIdentityCredentialsProvider;
        }
        ResultKt.throwOnFailure(obj2);
        if (leafProvider2 instanceof LeafProvider.NamedSource) {
            LeafProvider.NamedSource namedSource = (LeafProvider.NamedSource) leafProvider2;
            CredentialsProvider credentialsProvider = this.namedProviders.get(namedSource.getName());
            this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_NAMED_PROVIDER);
            if (credentialsProvider != null) {
                return credentialsProvider;
            }
            throw new ProviderConfigurationException("unknown credentials source: " + namedSource.getName(), null, 2, null);
        }
        if (leafProvider2 instanceof LeafProvider.AccessKey) {
            StaticCredentialsProvider staticCredentialsProvider = new StaticCredentialsProvider(((LeafProvider.AccessKey) leafProvider2).getCredentials());
            this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE);
            return staticCredentialsProvider;
        }
        if (leafProvider2 instanceof LeafProvider.WebIdentityTokenRole) {
            LeafProvider.WebIdentityTokenRole webIdentityTokenRole = (LeafProvider.WebIdentityTokenRole) leafProvider2;
            String roleArn = webIdentityTokenRole.getRoleArn();
            String webIdentityTokenFile = webIdentityTokenRole.getWebIdentityTokenFile();
            c30211.L$0 = leafProvider2;
            c30211.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30211.L$2 = roleArn;
            c30211.L$3 = webIdentityTokenFile;
            c30211.label = 1;
            obj = lazyAsyncValue.get(c30211);
            if (obj != coroutine_suspended) {
                str2 = webIdentityTokenFile;
                str3 = roleArn;
                StsWebIdentityCredentialsProvider stsWebIdentityCredentialsProvider2 = new StsWebIdentityCredentialsProvider(str3, str2, (String) obj, ((LeafProvider.WebIdentityTokenRole) leafProvider2).getSessionName(), 0L, this.platformProvider, this.httpClient, 16, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN);
                return stsWebIdentityCredentialsProvider2;
            }
        } else {
            if (leafProvider2 instanceof LeafProvider.SsoSession) {
                LeafProvider.SsoSession ssoSession = (LeafProvider.SsoSession) leafProvider2;
                SsoCredentialsProvider ssoCredentialsProvider = new SsoCredentialsProvider(ssoSession.getSsoAccountId(), ssoSession.getSsoRoleName(), ssoSession.getSsoStartUrl(), ssoSession.getSsoRegion(), ssoSession.getSsoSessionName(), this.httpClient, this.platformProvider, null, 128, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_SSO);
                return ssoCredentialsProvider;
            }
            if (leafProvider2 instanceof LeafProvider.LegacySso) {
                LeafProvider.LegacySso legacySso = (LeafProvider.LegacySso) leafProvider2;
                SsoCredentialsProvider ssoCredentialsProvider2 = new SsoCredentialsProvider(legacySso.getSsoAccountId(), legacySso.getSsoRoleName(), legacySso.getSsoStartUrl(), legacySso.getSsoRegion(), null, this.httpClient, this.platformProvider, null, 144, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_SSO_LEGACY);
                return ssoCredentialsProvider2;
            }
            if (!(leafProvider2 instanceof LeafProvider.LoginSession)) {
                if (!(leafProvider2 instanceof LeafProvider.Process)) {
                    throw new NoWhenBranchMatchedException();
                }
                ProcessCredentialsProvider processCredentialsProvider = new ProcessCredentialsProvider(((LeafProvider.Process) leafProvider2).getCommand(), null, 0L, 0L, 14, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_PROCESS);
                return processCredentialsProvider;
            }
            String loginSessionName = ((LeafProvider.LoginSession) leafProvider2).getLoginSessionName();
            c30211.L$0 = SpillingKt.nullOutSpilledVariable(leafProvider2);
            c30211.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30211.L$2 = loginSessionName;
            c30211.label = 2;
            Object obj3 = lazyAsyncValue.get(c30211);
            if (obj3 != coroutine_suspended) {
                str = loginSessionName;
                obj2 = obj3;
                LoginCredentialsProvider loginCredentialsProvider2 = new LoginCredentialsProvider(str, (String) obj2, null, null, null, 28, null);
                this.credentialsBusinessMetrics.add(AwsBusinessMetric.Credentials.CREDENTIALS_PROFILE_LOGIN);
                return loginCredentialsProvider2;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toCredentialsProvider(RoleArn roleArn, Credentials credentials, LazyAsyncValue<String> lazyAsyncValue, Continuation<? super CredentialsProvider> continuation) {
        C30229 c30229;
        CredentialsProvider credentialsProvider;
        String str;
        RoleArn roleArn2;
        if (continuation instanceof C30229) {
            c30229 = (C30229) continuation;
            if ((c30229.label & Integer.MIN_VALUE) != 0) {
                c30229.label -= Integer.MIN_VALUE;
            } else {
                c30229 = new C30229(continuation);
            }
        }
        Object obj = c30229.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30229.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StaticCredentialsProvider staticCredentialsProvider = new StaticCredentialsProvider(credentials);
            String roleArn3 = roleArn.getRoleArn();
            c30229.L$0 = roleArn;
            c30229.L$1 = SpillingKt.nullOutSpilledVariable(credentials);
            c30229.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30229.L$3 = staticCredentialsProvider;
            c30229.L$4 = roleArn3;
            c30229.label = 1;
            Object obj2 = lazyAsyncValue.get(c30229);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            credentialsProvider = staticCredentialsProvider;
            obj = obj2;
            str = roleArn3;
            roleArn2 = roleArn;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c30229.L$4;
            credentialsProvider = (CredentialsProvider) c30229.L$3;
            roleArn2 = (RoleArn) c30229.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
        }
        return new StsAssumeRoleCredentialsProvider(credentialsProvider, str, (String) obj, roleArn2.getSessionName(), roleArn2.getExternalId(), 0L, this.httpClient, 32, null);
    }

    private final String description(LeafProvider leafProvider) {
        if (leafProvider instanceof LeafProvider.NamedSource) {
            return "named source " + ((LeafProvider.NamedSource) leafProvider).getName();
        }
        if (leafProvider instanceof LeafProvider.AccessKey) {
            return "static credentials";
        }
        if (leafProvider instanceof LeafProvider.WebIdentityTokenRole) {
            return "web identity token";
        }
        if (leafProvider instanceof LeafProvider.SsoSession) {
            return "single sign-on (session)";
        }
        if (leafProvider instanceof LeafProvider.LegacySso) {
            return "single sign-on (legacy)";
        }
        if (leafProvider instanceof LeafProvider.LoginSession) {
            return "aws login";
        }
        if (leafProvider instanceof LeafProvider.Process) {
            return "process";
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
