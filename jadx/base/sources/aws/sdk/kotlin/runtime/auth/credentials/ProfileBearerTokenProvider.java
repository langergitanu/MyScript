package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.yalantis.ucrop.UCrop;
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

/* JADX INFO: compiled from: ProfileBearerTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0001*\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/ProfileBearerTokenProvider;", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "profileName", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/time/Clock;)V", "sharedConfig", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "resolve", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveTokenProviderOrThrow", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProfileBearerTokenProvider implements BearerTokenProvider {
    private final Clock clock;
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final String profileName;
    private final LazyAsyncValue<AwsSharedConfig> sharedConfig;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.ProfileBearerTokenProvider$resolve$1 */
    /* JADX INFO: compiled from: ProfileBearerTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.ProfileBearerTokenProvider", m1609f = "ProfileBearerTokenProvider.kt", m1610i = {0, 0, 1, 1, 1, 1}, m1611l = {68, 72}, m1612m = "resolve", m1613n = {"attributes", "logger", "attributes", "logger", "config", "provider"}, m1614nl = {UCrop.REQUEST_CROP, -1}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C30191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30191(Continuation<? super C30191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileBearerTokenProvider.this.resolve(null, this);
        }
    }

    public ProfileBearerTokenProvider() {
        this(null, null, null, null, 15, null);
    }

    public ProfileBearerTokenProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, Clock clock) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.profileName = str;
        this.platformProvider = platformProvider;
        this.httpClient = httpClientEngine;
        this.clock = clock;
        this.sharedConfig = LazyAsyncValueKt.asyncLazy(new ProfileBearerTokenProvider$sharedConfig$1(this, null));
    }

    public /* synthetic */ ProfileBearerTokenProvider(String str, PlatformProvider platformProvider, HttpClientEngine httpClientEngine, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 4) != 0 ? null : httpClientEngine, (i & 8) != 0 ? Clock.System.INSTANCE : system);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        C30191 c30191;
        Attributes attributes2;
        Logger logger;
        if (continuation instanceof C30191) {
            c30191 = (C30191) continuation;
            if ((c30191.label & Integer.MIN_VALUE) != 0) {
                c30191.label -= Integer.MIN_VALUE;
            } else {
                c30191 = new C30191(continuation);
            }
        }
        Object obj = c30191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext context = c30191.getContext();
            String qualifiedName = Reflection.getOrCreateKotlinClass(ProfileBearerTokenProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger2 = CoroutineContextLogExtKt.logger(context, qualifiedName);
            LazyAsyncValue<AwsSharedConfig> lazyAsyncValue = this.sharedConfig;
            c30191.L$0 = attributes;
            c30191.L$1 = logger2;
            c30191.label = 1;
            Object obj2 = lazyAsyncValue.get(c30191);
            if (obj2 != coroutine_suspended) {
                attributes2 = attributes;
                logger = logger2;
                obj = obj2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        logger = (Logger) c30191.L$1;
        attributes2 = (Attributes) c30191.L$0;
        ResultKt.throwOnFailure(obj);
        final AwsSharedConfig awsSharedConfig = (AwsSharedConfig) obj;
        Logger.debug$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ProfileBearerTokenProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBearerTokenProvider.resolve$lambda$0(awsSharedConfig);
            }
        }, 1, null);
        BearerTokenProvider bearerTokenProviderResolveTokenProviderOrThrow = resolveTokenProviderOrThrow(awsSharedConfig);
        c30191.L$0 = SpillingKt.nullOutSpilledVariable(attributes2);
        c30191.L$1 = SpillingKt.nullOutSpilledVariable(logger);
        c30191.L$2 = SpillingKt.nullOutSpilledVariable(awsSharedConfig);
        c30191.L$3 = SpillingKt.nullOutSpilledVariable(bearerTokenProviderResolveTokenProviderOrThrow);
        c30191.label = 2;
        Object objResolve = bearerTokenProviderResolveTokenProviderOrThrow.resolve(attributes2, c30191);
        return objResolve == coroutine_suspended ? coroutine_suspended : objResolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolve$lambda$0(AwsSharedConfig awsSharedConfig) {
        return "Loading bearer token from profile `" + awsSharedConfig.getActiveProfile().getName() + '`';
    }

    private final BearerTokenProvider resolveTokenProviderOrThrow(AwsSharedConfig awsSharedConfig) {
        String orNull$default = ConfigSection.getOrNull$default(awsSharedConfig.getActiveProfile(), ProfileChainKt.SSO_SESSION, null, 2, null);
        if (orNull$default == null) {
            throw new ProviderConfigurationException("no bearer token providers available for profile `" + awsSharedConfig.getActiveProfile().getName() + '`', null, 2, null);
        }
        ConfigSection configSection = awsSharedConfig.getSsoSessions().get(orNull$default);
        if (configSection == null) {
            throw new ProviderConfigurationException("profile (" + awsSharedConfig.getActiveProfile().getName() + ") references non-existing sso_session = `" + orNull$default + '`', null, 2, null);
        }
        String orNull$default2 = ConfigSection.getOrNull$default(configSection, ProfileChainKt.SSO_START_URL, null, 2, null);
        if (orNull$default2 == null) {
            throw new ProviderConfigurationException("sso-session (" + orNull$default + ") missing `sso_start_url`", null, 2, null);
        }
        String orNull$default3 = ConfigSection.getOrNull$default(configSection, ProfileChainKt.SSO_REGION, null, 2, null);
        if (orNull$default3 == null) {
            throw new ProviderConfigurationException("sso-session (" + orNull$default + ") missing `sso_region`", null, 2, null);
        }
        return new SsoTokenProvider(orNull$default, orNull$default2, orNull$default3, 0L, this.httpClient, this.platformProvider, this.clock, 8, null);
    }
}
