package aws.sdk.kotlin.services.p010s3.express;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.sdk.kotlin.services.p010s3.S3Attributes;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.CreateSessionRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateSessionResponse;
import aws.sdk.kotlin.services.p010s3.model.SessionCredentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.LruCache;
import aws.smithy.kotlin.runtime.p011io.SdkManagedBase;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.InstantKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: DefaultS3ExpressCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0080@¢\u0006\u0004\b\"\u0010#J\n\u0010*\u001a\u00020+H\u0096\u0080\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010$\u001a\u00020%*\u00020!8@X\u0080\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/DefaultS3ExpressCredentialsProvider;", "Laws/smithy/kotlin/runtime/io/SdkManagedBase;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "Lkotlinx/coroutines/CoroutineScope;", "timeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "credentialsCache", "Laws/smithy/kotlin/runtime/collections/LruCache;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheKey;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheValue;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCache;", "refreshBuffer", "Lkotlin/time/Duration;", "<init>", "(Lkotlin/time/TimeSource$WithComparableMarks;Laws/smithy/kotlin/runtime/time/Clock;Laws/smithy/kotlin/runtime/collections/LruCache;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "resolve", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "createSessionCredentials", "Laws/sdk/kotlin/services/s3/express/ExpiringValue;", SubscriberAttributeKt.JSON_NAME_KEY, "client", "Laws/sdk/kotlin/services/s3/S3Client;", "createSessionCredentials$s3", "(Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheKey;Laws/sdk/kotlin/services/s3/S3Client;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "getLogger$s3$annotations", "(Laws/sdk/kotlin/services/s3/S3Client;)V", "getLogger$s3", "(Laws/sdk/kotlin/services/s3/S3Client;)Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultS3ExpressCredentialsProvider extends SdkManagedBase implements CloseableCredentialsProvider, CoroutineScope {
    private final Clock clock;
    private final CoroutineContext coroutineContext;
    private final LruCache<S3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue> credentialsCache;
    private final long refreshBuffer;
    private final TimeSource.WithComparableMarks timeSource;

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$resolve$1 */
    /* JADX INFO: compiled from: DefaultS3ExpressCredentialsProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider", m1609f = "DefaultS3ExpressCredentialsProvider.kt", m1610i = {0, 0, 1, 1, 1, 2, 2, 2}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, PDFACompliance.e_PDFA8_1}, m1612m = "resolve", m1613n = {"attributes", "client", "attributes", "client", SubscriberAttributeKt.JSON_NAME_KEY, "attributes", "client", SubscriberAttributeKt.JSON_NAME_KEY}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C31391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C31391(Continuation<? super C31391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultS3ExpressCredentialsProvider.this.resolve(null, this);
        }
    }

    public /* synthetic */ DefaultS3ExpressCredentialsProvider(TimeSource.WithComparableMarks withComparableMarks, Clock clock, LruCache lruCache, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(withComparableMarks, clock, lruCache, j);
    }

    public static /* synthetic */ void getLogger$s3$annotations(S3Client s3Client) {
    }

    private DefaultS3ExpressCredentialsProvider(TimeSource.WithComparableMarks timeSource, Clock clock, LruCache<S3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue> credentialsCache, long j) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(credentialsCache, "credentialsCache");
        this.timeSource = timeSource;
        this.clock = clock;
        this.credentialsCache = credentialsCache;
        this.refreshBuffer = j;
        this.coroutineContext = JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(new CoroutineName("DefaultS3ExpressCredentialsProvider"));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultS3ExpressCredentialsProvider(TimeSource.Monotonic monotonic, Clock.System system, LruCache lruCache, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TimeSource.WithComparableMarks withComparableMarks = (i & 1) != 0 ? TimeSource.Monotonic.INSTANCE : monotonic;
        Clock clock = (i & 2) != 0 ? Clock.System.INSTANCE : system;
        LruCache lruCacheS3ExpressCredentialsCache = (i & 4) != 0 ? S3ExpressCredentialsCacheKt.S3ExpressCredentialsCache() : lruCache;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(1, DurationUnit.MINUTES);
        }
        this(withComparableMarks, clock, lruCacheS3ExpressCredentialsCache, j, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0140, code lost:
    
        if (r1 != r7) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        C31391 c31391;
        String str;
        S3Client s3Client;
        S3Client s3Client2;
        final S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey;
        Attributes attributes2;
        final S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue;
        Credentials value;
        Attributes attributes3 = attributes;
        if (continuation instanceof C31391) {
            c31391 = (C31391) continuation;
            if ((c31391.label & Integer.MIN_VALUE) != 0) {
                c31391.label -= Integer.MIN_VALUE;
            } else {
                c31391 = new C31391(continuation);
            }
        }
        C31391 c313912 = c31391;
        Object objCreateSessionCredentials$s3 = c313912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c313912.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateSessionCredentials$s3);
            Object obj = AttributesKt.get(attributes3, S3Attributes.INSTANCE.getExpressClient());
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.S3Client");
            S3Client s3Client3 = (S3Client) obj;
            str = (String) AttributesKt.get(attributes3, S3Attributes.INSTANCE.getBucket());
            CredentialsProvider credentialsProvider = s3Client3.getConfig().getCredentialsProvider();
            c313912.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
            c313912.L$1 = s3Client3;
            c313912.L$2 = str;
            c313912.label = 1;
            Object objResolve = credentialsProvider.resolve(attributes3, c313912);
            if (objResolve != coroutine_suspended) {
                s3Client = s3Client3;
                objCreateSessionCredentials$s3 = objResolve;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            String str2 = (String) c313912.L$2;
            S3Client s3Client4 = (S3Client) c313912.L$1;
            Attributes attributes4 = (Attributes) c313912.L$0;
            ResultKt.throwOnFailure(objCreateSessionCredentials$s3);
            str = str2;
            attributes3 = attributes4;
            s3Client = s3Client4;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCreateSessionCredentials$s3);
                return (Credentials) ((ExpiringValue) objCreateSessionCredentials$s3).getValue();
            }
            S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey2 = (S3ExpressCredentialsCacheKey) c313912.L$2;
            s3Client2 = (S3Client) c313912.L$1;
            Attributes attributes5 = (Attributes) c313912.L$0;
            ResultKt.throwOnFailure(objCreateSessionCredentials$s3);
            attributes2 = attributes5;
            s3ExpressCredentialsCacheKey = s3ExpressCredentialsCacheKey2;
            s3ExpressCredentialsCacheValue = (S3ExpressCredentialsCacheValue) objCreateSessionCredentials$s3;
            if (s3ExpressCredentialsCacheValue != null) {
                if (S3ExpressCredentialsCacheKt.isExpired(s3ExpressCredentialsCacheValue.getExpiringCredentials())) {
                    s3ExpressCredentialsCacheValue = null;
                }
                if (s3ExpressCredentialsCacheValue != null) {
                    if (S3ExpressCredentialsCacheKt.m12073isExpiringWithinHG0u8IE(s3ExpressCredentialsCacheValue.getExpiringCredentials(), this.refreshBuffer)) {
                        Logger.trace$default(getLogger$s3(s3Client2), null, new Function0() { // from class: aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DefaultS3ExpressCredentialsProvider.resolve$lambda$1$0(s3ExpressCredentialsCacheKey, s3ExpressCredentialsCacheValue);
                            }
                        }, 1, null);
                        BuildersKt__Builders_commonKt.launch$default(this, getCoroutineContext(), null, new DefaultS3ExpressCredentialsProvider$resolve$3$2(s3ExpressCredentialsCacheValue, this, s3Client2, s3ExpressCredentialsCacheKey, null), 2, null);
                    }
                    ExpiringValue<Credentials> expiringCredentials = s3ExpressCredentialsCacheValue.getExpiringCredentials();
                    if (expiringCredentials != null && (value = expiringCredentials.getValue()) != null) {
                        return value;
                    }
                }
            }
            c313912.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
            c313912.L$1 = SpillingKt.nullOutSpilledVariable(s3Client2);
            c313912.L$2 = SpillingKt.nullOutSpilledVariable(s3ExpressCredentialsCacheKey);
            c313912.label = 3;
            objCreateSessionCredentials$s3 = createSessionCredentials$s3(s3ExpressCredentialsCacheKey, s3Client2, c313912);
        }
        S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey3 = new S3ExpressCredentialsCacheKey(str, (Credentials) objCreateSessionCredentials$s3);
        LruCache<S3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue> lruCache = this.credentialsCache;
        c313912.L$0 = SpillingKt.nullOutSpilledVariable(attributes3);
        c313912.L$1 = s3Client;
        c313912.L$2 = s3ExpressCredentialsCacheKey3;
        c313912.label = 2;
        objCreateSessionCredentials$s3 = lruCache.get(s3ExpressCredentialsCacheKey3, c313912);
        if (objCreateSessionCredentials$s3 != coroutine_suspended) {
            s3Client2 = s3Client;
            s3ExpressCredentialsCacheKey = s3ExpressCredentialsCacheKey3;
            attributes2 = attributes3;
            s3ExpressCredentialsCacheValue = (S3ExpressCredentialsCacheValue) objCreateSessionCredentials$s3;
            if (s3ExpressCredentialsCacheValue != null) {
            }
            c313912.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
            c313912.L$1 = SpillingKt.nullOutSpilledVariable(s3Client2);
            c313912.L$2 = SpillingKt.nullOutSpilledVariable(s3ExpressCredentialsCacheKey);
            c313912.label = 3;
            objCreateSessionCredentials$s3 = createSessionCredentials$s3(s3ExpressCredentialsCacheKey, s3Client2, c313912);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$1$0(S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue) {
        return "Credentials for " + s3ExpressCredentialsCacheKey.getBucket() + " are expiring in " + s3ExpressCredentialsCacheValue.getExpiringCredentials().getExpiresAt() + " and are within their refresh window, performing asynchronous refresh...";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JobKt.cancel(getCoroutineContext(), (CancellationException) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createSessionCredentials$s3(S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey, S3Client s3Client, Continuation<? super ExpiringValue<Credentials>> continuation) {
        DefaultS3ExpressCredentialsProvider$createSessionCredentials$1 defaultS3ExpressCredentialsProvider$createSessionCredentials$1;
        S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey2;
        S3Client s3Client2;
        if (continuation instanceof DefaultS3ExpressCredentialsProvider$createSessionCredentials$1) {
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1 = (DefaultS3ExpressCredentialsProvider$createSessionCredentials$1) continuation;
            if ((defaultS3ExpressCredentialsProvider$createSessionCredentials$1.label & Integer.MIN_VALUE) != 0) {
                defaultS3ExpressCredentialsProvider$createSessionCredentials$1.label -= Integer.MIN_VALUE;
            } else {
                defaultS3ExpressCredentialsProvider$createSessionCredentials$1 = new DefaultS3ExpressCredentialsProvider$createSessionCredentials$1(this, continuation);
            }
        }
        Object objCreateSession = defaultS3ExpressCredentialsProvider$createSessionCredentials$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = defaultS3ExpressCredentialsProvider$createSessionCredentials$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateSession);
            CreateSessionRequest.Builder builder = new CreateSessionRequest.Builder();
            builder.setBucket(s3ExpressCredentialsCacheKey.getBucket());
            CreateSessionRequest createSessionRequestBuild = builder.build();
            s3ExpressCredentialsCacheKey2 = s3ExpressCredentialsCacheKey;
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$0 = s3ExpressCredentialsCacheKey2;
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$1 = SpillingKt.nullOutSpilledVariable(s3Client);
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$2 = SpillingKt.nullOutSpilledVariable(s3Client);
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1.I$0 = 0;
            defaultS3ExpressCredentialsProvider$createSessionCredentials$1.label = 1;
            s3Client2 = s3Client;
            objCreateSession = s3Client2.createSession(createSessionRequestBuild, defaultS3ExpressCredentialsProvider$createSessionCredentials$1);
            if (objCreateSession != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = defaultS3ExpressCredentialsProvider$createSessionCredentials$1.I$0;
            ExpiringValue expiringValue = (ExpiringValue) defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$2;
            ResultKt.throwOnFailure(objCreateSession);
            return expiringValue;
        }
        int i3 = defaultS3ExpressCredentialsProvider$createSessionCredentials$1.I$0;
        S3Client s3Client3 = (S3Client) defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$1;
        S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey3 = (S3ExpressCredentialsCacheKey) defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$0;
        ResultKt.throwOnFailure(objCreateSession);
        s3Client2 = s3Client3;
        s3ExpressCredentialsCacheKey2 = s3ExpressCredentialsCacheKey3;
        SessionCredentials credentials = ((CreateSessionResponse) objCreateSession).getCredentials();
        Intrinsics.checkNotNull(credentials);
        ExpiringValue expiringValue2 = new ExpiringValue(Credentials.Companion.invoke$default(Credentials.INSTANCE, credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken(), credentials.getExpiration(), null, null, 48, null), this.timeSource.markNow().mo15847plusLRDsOJo(InstantKt.until(this.clock.getNow(), credentials.getExpiration())));
        LruCache<S3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue> lruCache = this.credentialsCache;
        S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue = new S3ExpressCredentialsCacheValue(expiringValue2, null, 2, null);
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$0 = SpillingKt.nullOutSpilledVariable(s3ExpressCredentialsCacheKey2);
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$1 = SpillingKt.nullOutSpilledVariable(s3Client2);
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$2 = expiringValue2;
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.L$3 = SpillingKt.nullOutSpilledVariable(expiringValue2);
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.I$0 = 0;
        defaultS3ExpressCredentialsProvider$createSessionCredentials$1.label = 2;
        return lruCache.put(s3ExpressCredentialsCacheKey2, s3ExpressCredentialsCacheValue, defaultS3ExpressCredentialsProvider$createSessionCredentials$1) == coroutine_suspended ? coroutine_suspended : expiringValue2;
    }

    public final Logger getLogger$s3(S3Client s3Client) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        LoggerProvider loggerProvider = s3Client.getConfig().getTelemetryProvider().getLoggerProvider();
        String qualifiedName = Reflection.getOrCreateKotlinClass(DefaultS3ExpressCredentialsProvider.class).getQualifiedName();
        if (qualifiedName != null) {
            return loggerProvider.getOrCreateLogger(qualifiedName);
        }
        throw new IllegalArgumentException("getLogger<T> cannot be used on an anonymous object".toString());
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
