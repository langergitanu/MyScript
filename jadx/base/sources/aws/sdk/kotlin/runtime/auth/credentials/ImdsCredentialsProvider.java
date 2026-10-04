package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.container.MdtaMetadataEntry;
import aws.sdk.kotlin.runtime.auth.credentials.JsonCredentialsResponse;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.imds.EC2MetadataError;
import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ImdsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u0004\u0018\u00010\u00142\n\u0010\"\u001a\u00060#j\u0002`$H\u0082@¢\u0006\u0002\u0010%J\n\u0010&\u001a\u00020\u0003H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/ImdsCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "profileOverride", "", "client", "Lkotlin/Lazy;", "Laws/sdk/kotlin/runtime/config/imds/InstanceMetadataProvider;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Lkotlin/Lazy;Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;Laws/smithy/kotlin/runtime/time/Clock;)V", "getProfileOverride", "()Ljava/lang/String;", "getClient", "()Lkotlin/Lazy;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "previousCredentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "nextRefresh", "Laws/smithy/kotlin/runtime/time/Instant;", "mu", "Lkotlinx/coroutines/sync/Mutex;", "resolve", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "loadProfile", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useCachedCredentials", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsCredentialsProvider implements CloseableCredentialsProvider {
    private final Lazy<InstanceMetadataProvider> client;
    private final Clock clock;
    private final Mutex mu;
    private Instant nextRefresh;
    private final PlatformEnvironProvider platformProvider;
    private Credentials previousCredentials;
    private final String profileOverride;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1 */
    /* JADX INFO: compiled from: ImdsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider", m1609f = "ImdsCredentialsProvider.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_3_3}, m1612m = "loadProfile", m1613n = {}, m1614nl = {134}, m1615s = {}, m1616v = 2)
    static final class C30081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C30081(Continuation<? super C30081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsCredentialsProvider.this.loadProfile(this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: ImdsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider", m1609f = "ImdsCredentialsProvider.kt", m1610i = {0, 0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, m1611l = {PDFACompliance.e_PDFA1_6_1, 79, PDFACompliance.e_PDFA8_1, 85, 87, 177}, m1612m = "resolve", m1613n = {"attributes", "$this$withLock_u24default$iv", "$i$f$withLock", "attributes", "attributes", "ex", "attributes", "profileName", "attributes", "profileName", "ex", "attributes", "profileName", "payload", "deserializer", "resp", "creds", "it", "$this$withLock_u24default$iv", "$completion$iv", "$i$a$-also-ImdsCredentialsProvider$resolve$4", "$i$f$withLock"}, m1614nl = {162, 80, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 86, 84, 178}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1"}, m1616v = 2)
    static final class C30091 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
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

        C30091(Continuation<? super C30091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsCredentialsProvider.this.resolve(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$useCachedCredentials$1 */
    /* JADX INFO: compiled from: ImdsCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider", m1609f = "ImdsCredentialsProvider.kt", m1610i = {0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_6_1}, m1612m = "useCachedCredentials", m1613n = {"ex", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {162}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C30101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30101(Continuation<? super C30101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsCredentialsProvider.this.useCachedCredentials(null, this);
        }
    }

    public ImdsCredentialsProvider() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImdsCredentialsProvider(String str, Lazy<? extends InstanceMetadataProvider> client, PlatformEnvironProvider platformProvider, Clock clock) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.profileOverride = str;
        this.client = client;
        this.platformProvider = platformProvider;
        this.clock = clock;
        this.mu = MutexKt.Mutex$default(false, 1, null);
    }

    public final String getProfileOverride() {
        return this.profileOverride;
    }

    public /* synthetic */ ImdsCredentialsProvider(String str, Lazy lazy, PlatformProvider platformProvider, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImdsCredentialsProvider._init_$lambda$0();
            }
        }) : lazy, (i & 4) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 8) != 0 ? Clock.System.INSTANCE : system);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImdsClient _init_$lambda$0() {
        return new ImdsClient();
    }

    public final Lazy<InstanceMetadataProvider> getClient() {
        return this.client;
    }

    public final PlatformEnvironProvider getPlatformProvider() {
        return this.platformProvider;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02de, code lost:
    
        if (r0 == r4) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ba, code lost:
    
        if (r0 == r4) goto L106;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd A[Catch: all -> 0x02f0, TRY_LEAVE, TryCatch #0 {all -> 0x02f0, blocks: (B:33:0x00e5, B:35:0x00e9, B:37:0x00ed, B:42:0x00fd), top: B:117:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: Exception -> 0x02cc, TRY_LEAVE, TryCatch #3 {Exception -> 0x02cc, blocks: (B:46:0x0109, B:48:0x010d), top: B:123:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123 A[PHI: r0 r9
      0x0123: PHI (r0v22 java.lang.String) = (r0v11 java.lang.String), (r0v29 java.lang.String) binds: [B:47:0x010b, B:53:0x0122] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r9v6 aws.smithy.kotlin.runtime.collections.Attributes) = (r9v3 aws.smithy.kotlin.runtime.collections.Attributes), (r9v7 aws.smithy.kotlin.runtime.collections.Attributes) binds: [B:47:0x010b, B:53:0x0122] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0236  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        C30091 c30091;
        Attributes attributes2;
        Mutex mutex;
        Exception exc;
        Attributes attributes3;
        String str;
        Instant instant;
        String str2;
        String str3;
        Attributes attributes4;
        Exception exc2;
        JsonCredentialsResponse jsonCredentialsResponseDeserializeJsonCredentials;
        Instant instantM12289plusLRDsOJo;
        Credentials credentials;
        Credentials credentials2;
        Mutex mutex2;
        if (continuation instanceof C30091) {
            c30091 = (C30091) continuation;
            if ((c30091.label & Integer.MIN_VALUE) != 0) {
                c30091.label -= Integer.MIN_VALUE;
            } else {
                c30091 = new C30091(continuation);
            }
        }
        Object objLoadProfile = c30091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c30091.label) {
            case 0:
                ResultKt.throwOnFailure(objLoadProfile);
                if (Intrinsics.areEqual(EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsEc2MetadataDisabled(), this.platformProvider), Boxing.boxBoolean(true))) {
                    throw new CredentialsNotLoadedException("AWS EC2 metadata is explicitly disabled; credentials not loaded", null, 2, null);
                }
                Mutex mutex3 = this.mu;
                c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
                c30091.L$1 = mutex3;
                c30091.I$0 = 0;
                c30091.label = 1;
                if (mutex3.lock(null, c30091) != coroutine_suspended) {
                    attributes2 = attributes;
                    mutex = mutex3;
                    try {
                        if (this.previousCredentials != null && (instant = this.nextRefresh) != null) {
                            if (this.clock.getNow().compareTo(instant) < 0) {
                                instant = null;
                            }
                            if (instant != null) {
                                Credentials credentials3 = this.previousCredentials;
                                Intrinsics.checkNotNull(credentials3);
                                return credentials3;
                            }
                        }
                        try {
                            str = this.profileOverride;
                            if (str != null) {
                                c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                                c30091.L$1 = null;
                                c30091.label = 2;
                                objLoadProfile = loadProfile(c30091);
                                if (objLoadProfile != coroutine_suspended) {
                                    attributes3 = attributes2;
                                    str = (String) objLoadProfile;
                                    attributes2 = attributes3;
                                    str2 = str;
                                    try {
                                        c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                                        c30091.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                                        c30091.label = 4;
                                        objLoadProfile = this.client.getValue().get("/latest/meta-data/iam/security-credentials/" + str2, c30091);
                                        if (objLoadProfile != coroutine_suspended) {
                                            str3 = str2;
                                            attributes4 = attributes2;
                                            String str4 = (String) objLoadProfile;
                                            JsonDeserializer jsonDeserializer = new JsonDeserializer(StringsKt.encodeToByteArray(str4));
                                            jsonCredentialsResponseDeserializeJsonCredentials = JsonCredentialsDeserializerKt.deserializeJsonCredentials(jsonDeserializer);
                                            if (!(jsonCredentialsResponseDeserializeJsonCredentials instanceof JsonCredentialsResponse.SessionCredentials)) {
                                                JsonCredentialsResponse.SessionCredentials sessionCredentials = (JsonCredentialsResponse.SessionCredentials) jsonCredentialsResponseDeserializeJsonCredentials;
                                                if (sessionCredentials.getExpiration() == null || sessionCredentials.getExpiration().compareTo(this.clock.getNow()) >= 0) {
                                                    instantM12289plusLRDsOJo = null;
                                                } else {
                                                    CoroutineContext coroutineContext = c30091.get$context();
                                                    Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$$ExternalSyntheticLambda2
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return ImdsCredentialsProvider.resolve$lambda$1();
                                                        }
                                                    };
                                                    LogLevel logLevel = LogLevel.Warning;
                                                    String qualifiedName = Reflection.getOrCreateKotlinClass(ImdsCredentialsProvider.class).getQualifiedName();
                                                    if (qualifiedName == null) {
                                                        throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                                                    }
                                                    CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
                                                    Instant now = this.clock.getNow();
                                                    Duration.Companion companion = Duration.INSTANCE;
                                                    instantM12289plusLRDsOJo = now.m12289plusLRDsOJo(DurationKt.toDuration(900, DurationUnit.SECONDS));
                                                }
                                                this.nextRefresh = instantM12289plusLRDsOJo;
                                                Credentials credentialsWithBusinessMetric = AwsBusinessMetricsUtilsKt.withBusinessMetric(Credentials.Companion.invoke$default(Credentials.INSTANCE, sessionCredentials.getAccessKeyId(), sessionCredentials.getSecretAccessKey(), sessionCredentials.getSessionToken(), sessionCredentials.getExpiration(), "IMDSv2", null, 32, null), AwsBusinessMetric.Credentials.CREDENTIALS_IMDS);
                                                Mutex mutex4 = this.mu;
                                                c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes4);
                                                c30091.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                                c30091.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                                                c30091.L$3 = SpillingKt.nullOutSpilledVariable(jsonDeserializer);
                                                c30091.L$4 = SpillingKt.nullOutSpilledVariable(jsonCredentialsResponseDeserializeJsonCredentials);
                                                c30091.L$5 = SpillingKt.nullOutSpilledVariable(credentialsWithBusinessMetric);
                                                c30091.L$6 = credentialsWithBusinessMetric;
                                                c30091.L$7 = credentialsWithBusinessMetric;
                                                c30091.L$8 = mutex4;
                                                c30091.L$9 = SpillingKt.nullOutSpilledVariable(c30091);
                                                c30091.I$0 = 0;
                                                c30091.I$1 = 0;
                                                c30091.label = 6;
                                                if (mutex4.lock(null, c30091) != coroutine_suspended) {
                                                    credentials = credentialsWithBusinessMetric;
                                                    credentials2 = credentials;
                                                    mutex2 = mutex4;
                                                    try {
                                                        this.previousCredentials = credentials;
                                                        Unit unit = Unit.INSTANCE;
                                                        return credentials2;
                                                    } finally {
                                                    }
                                                }
                                            } else {
                                                if (!(jsonCredentialsResponseDeserializeJsonCredentials instanceof JsonCredentialsResponse.Error)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                JsonCredentialsResponse.Error error = (JsonCredentialsResponse.Error) jsonCredentialsResponseDeserializeJsonCredentials;
                                                if (Intrinsics.areEqual(error.getCode(), "AssumeRoleUnauthorizedAccess")) {
                                                    throw new ProviderConfigurationException("Incorrect IMDS/IAM configuration: [" + error.getCode() + "] " + error.getMessage() + ". Hint: Does this role have a trust relationship with EC2?", null, 2, null);
                                                }
                                                throw new CredentialsProviderException("Error retrieving credentials from IMDS: code=" + error.getCode() + "; " + error.getMessage(), null, 2, null);
                                            }
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        exc2 = e;
                                        c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                                        c30091.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                                        c30091.L$2 = exc2;
                                        c30091.label = 5;
                                        objLoadProfile = useCachedCredentials(exc2, c30091);
                                        break;
                                    }
                                }
                            } else {
                                str2 = str;
                                c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                                c30091.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                                c30091.label = 4;
                                objLoadProfile = this.client.getValue().get("/latest/meta-data/iam/security-credentials/" + str2, c30091);
                                if (objLoadProfile != coroutine_suspended) {
                                }
                            }
                        } catch (Exception e2) {
                            exc = e2;
                            attributes3 = attributes2;
                            c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
                            c30091.L$1 = exc;
                            c30091.label = 3;
                            objLoadProfile = useCachedCredentials(exc, c30091);
                            break;
                        }
                    } finally {
                    }
                }
                return coroutine_suspended;
            case 1:
                int i = c30091.I$0;
                mutex = (Mutex) c30091.L$1;
                attributes2 = (Attributes) c30091.L$0;
                ResultKt.throwOnFailure(objLoadProfile);
                if (this.previousCredentials != null) {
                    if (this.clock.getNow().compareTo(instant) < 0) {
                    }
                    if (instant != null) {
                    }
                }
                str = this.profileOverride;
                if (str != null) {
                }
                return coroutine_suspended;
            case 2:
                attributes3 = (Attributes) c30091.L$0;
                try {
                    ResultKt.throwOnFailure(objLoadProfile);
                    str = (String) objLoadProfile;
                    attributes2 = attributes3;
                    str2 = str;
                    c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                    c30091.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    c30091.label = 4;
                    objLoadProfile = this.client.getValue().get("/latest/meta-data/iam/security-credentials/" + str2, c30091);
                    if (objLoadProfile != coroutine_suspended) {
                    }
                } catch (Exception e3) {
                    exc = e3;
                    c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
                    c30091.L$1 = exc;
                    c30091.label = 3;
                    objLoadProfile = useCachedCredentials(exc, c30091);
                    break;
                }
                return coroutine_suspended;
            case 3:
                exc = (Exception) c30091.L$1;
                ResultKt.throwOnFailure(objLoadProfile);
                Credentials credentials4 = (Credentials) objLoadProfile;
                if (credentials4 != null) {
                    return credentials4;
                }
                throw new CredentialsProviderException("failed to load instance profile", exc);
            case 4:
                str3 = (String) c30091.L$1;
                attributes4 = (Attributes) c30091.L$0;
                try {
                    ResultKt.throwOnFailure(objLoadProfile);
                    String str42 = (String) objLoadProfile;
                    JsonDeserializer jsonDeserializer2 = new JsonDeserializer(StringsKt.encodeToByteArray(str42));
                    jsonCredentialsResponseDeserializeJsonCredentials = JsonCredentialsDeserializerKt.deserializeJsonCredentials(jsonDeserializer2);
                    if (!(jsonCredentialsResponseDeserializeJsonCredentials instanceof JsonCredentialsResponse.SessionCredentials)) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    attributes2 = attributes4;
                    str2 = str3;
                    exc2 = e;
                    c30091.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
                    c30091.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    c30091.L$2 = exc2;
                    c30091.label = 5;
                    objLoadProfile = useCachedCredentials(exc2, c30091);
                    break;
                }
                break;
            case 5:
                exc2 = (Exception) c30091.L$2;
                ResultKt.throwOnFailure(objLoadProfile);
                Credentials credentials5 = (Credentials) objLoadProfile;
                if (credentials5 != null) {
                    return credentials5;
                }
                throw new CredentialsProviderException("failed to load credentials", exc2);
            case 6:
                int i2 = c30091.I$1;
                int i3 = c30091.I$0;
                mutex2 = (Mutex) c30091.L$8;
                credentials = (Credentials) c30091.L$7;
                credentials2 = (Credentials) c30091.L$6;
                ResultKt.throwOnFailure(objLoadProfile);
                this.previousCredentials = credentials;
                Unit unit2 = Unit.INSTANCE;
                return credentials2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$1() {
        return "Attempting credential expiration extension due to a credential service availability issue. A refresh of these credentials will be attempted again in 15 minutes.";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.client.isInitialized()) {
            this.client.getValue().close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadProfile(Continuation<? super String> continuation) {
        C30081 c30081;
        if (continuation instanceof C30081) {
            c30081 = (C30081) continuation;
            if ((c30081.label & Integer.MIN_VALUE) != 0) {
                c30081.label -= Integer.MIN_VALUE;
            } else {
                c30081 = new C30081(continuation);
            }
        }
        Object obj = c30081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30081.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InstanceMetadataProvider value = this.client.getValue();
                c30081.label = 1;
                obj = value.get("/latest/meta-data/iam/security-credentials/", c30081);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (String) obj;
        } catch (EC2MetadataError e) {
            if (Intrinsics.areEqual(e.getStatus(), HttpStatusCode.INSTANCE.getNotFound())) {
                CoroutineContext coroutineContext = c30081.get$context();
                Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ImdsCredentialsProvider.loadProfile$lambda$0();
                    }
                };
                LogLevel logLevel = LogLevel.Info;
                String qualifiedName = Reflection.getOrCreateKotlinClass(ImdsCredentialsProvider.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadProfile$lambda$0() {
        return "Received 404 from IMDS when loading profile information. Hint: This instance may not have an IAM role associated.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object useCachedCredentials(Exception exc, Continuation<? super Credentials> continuation) {
        C30101 c30101;
        Mutex mutex;
        if (continuation instanceof C30101) {
            c30101 = (C30101) continuation;
            if ((c30101.label & Integer.MIN_VALUE) != 0) {
                c30101.label -= Integer.MIN_VALUE;
            } else {
                c30101 = new C30101(continuation);
            }
        }
        Object obj = c30101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(exc instanceof IOException) && (!(exc instanceof EC2MetadataError) || !Intrinsics.areEqual(((EC2MetadataError) exc).getStatus(), HttpStatusCode.INSTANCE.getInternalServerError()))) {
                return null;
            }
            Mutex mutex2 = this.mu;
            c30101.L$0 = SpillingKt.nullOutSpilledVariable(exc);
            c30101.L$1 = mutex2;
            c30101.I$0 = 0;
            c30101.label = 1;
            if (mutex2.lock(null, c30101) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c30101.I$0;
            mutex = (Mutex) c30101.L$1;
            ResultKt.throwOnFailure(obj);
        }
        try {
            Credentials credentials = this.previousCredentials;
            if (credentials != null) {
                Instant now = this.clock.getNow();
                Duration.Companion companion = Duration.INSTANCE;
                this.nextRefresh = now.m12289plusLRDsOJo(DurationKt.toDuration(900, DurationUnit.SECONDS));
            } else {
                credentials = null;
            }
            return credentials;
        } finally {
            mutex.unlock(null);
        }
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
