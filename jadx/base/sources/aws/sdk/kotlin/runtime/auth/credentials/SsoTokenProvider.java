package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.compose.runtime.GapComposerKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p007ts.TsExtractor;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.SsoOidcClient;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenRequest;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenResponse;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SingleFlightGroup;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: SsoTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010&J\u0014\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0016\u0010.\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/SsoTokenProvider;", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "ssoSessionName", "", "startUrl", "ssoRegion", "refreshBufferWindow", "Lkotlin/time/Duration;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLaws/smithy/kotlin/runtime/http/engine/HttpClientEngine;Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSsoSessionName", "()Ljava/lang/String;", "getStartUrl", "getSsoRegion", "getRefreshBufferWindow-UwyO8pc", "()J", "J", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getPlatformProvider", "()Laws/smithy/kotlin/runtime/util/PlatformProvider;", "sfg", "Laws/smithy/kotlin/runtime/util/SingleFlightGroup;", "Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;", "resolve", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "attemptRefresh", "oldToken", "(Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeToken", "", "refreshed", "throwTokenExpired", "", "cause", "", "refreshToken", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoTokenProvider implements BearerTokenProvider {
    private final Clock clock;
    private final HttpClientEngine httpClient;
    private final PlatformProvider platformProvider;
    private final long refreshBufferWindow;
    private final SingleFlightGroup<SsoToken> sfg;
    private final String ssoRegion;
    private final String ssoSessionName;
    private final String startUrl;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$attemptRefresh$1 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider", m1609f = "SsoTokenProvider.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {97, 99}, m1612m = "attemptRefresh", m1613n = {"oldToken", "$this$attemptRefresh_u24lambda_u241", "$i$a$-runCatching-SsoTokenProvider$attemptRefresh$result$1", "oldToken", "result", "refreshed", "$i$a$-onSuccess-SsoTokenProvider$attemptRefresh$3"}, m1614nl = {97, 99}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$3", "I$0"}, m1616v = 2)
    static final class C30251 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30251(Continuation<? super C30251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoTokenProvider.this.attemptRefresh(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$getToken$1 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider", m1609f = "SsoTokenProvider.kt", m1610i = {0, 1, 1}, m1611l = {80, 88}, m1612m = "getToken", m1613n = {"attributes", "attributes", "token"}, m1614nl = {PDFACompliance.e_PDFA8_1, PDFACompliance.e_PDFA9_1}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 2)
    static final class C30261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30261(Continuation<? super C30261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoTokenProvider.this.getToken(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$refreshToken$1 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider", m1609f = "SsoTokenProvider.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {GapComposerKt.nodeKey, PDFACompliance.e_PDFA2_6_1}, m1612m = "refreshToken", m1613n = {"oldToken", "telemetry", "oldToken", "telemetry", "$this$use$iv", "client", "$this$createToken$iv", "$completion$iv", "$i$f$use", "closed$iv", "$i$a$-use-SsoTokenProvider$refreshToken$3", "$i$f$createToken"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
    static final class C30271 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C30271(Continuation<? super C30271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoTokenProvider.this.refreshToken(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$writeToken$1 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider", m1609f = "SsoTokenProvider.kt", m1610i = {0, 0, 0, 0}, m1611l = {115}, m1612m = "writeToken", m1613n = {"refreshed", "cacheKey", "filepath", "contents"}, m1614nl = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1615s = {"L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C30291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C30291(Continuation<? super C30291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SsoTokenProvider.this.writeToken(null, this);
        }
    }

    public /* synthetic */ SsoTokenProvider(String str, String str2, String str3, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, httpClientEngine, platformProvider, clock);
    }

    private SsoTokenProvider(String ssoSessionName, String startUrl, String ssoRegion, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock) {
        Intrinsics.checkNotNullParameter(ssoSessionName, "ssoSessionName");
        Intrinsics.checkNotNullParameter(startUrl, "startUrl");
        Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.ssoSessionName = ssoSessionName;
        this.startUrl = startUrl;
        this.ssoRegion = ssoRegion;
        this.refreshBufferWindow = j;
        this.httpClient = httpClientEngine;
        this.platformProvider = platformProvider;
        this.clock = clock;
        this.sfg = new SingleFlightGroup<>();
    }

    public final String getSsoSessionName() {
        return this.ssoSessionName;
    }

    public final String getStartUrl() {
        return this.startUrl;
    }

    public final String getSsoRegion() {
        return this.ssoRegion;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SsoTokenProvider(String str, String str2, String str3, long j, HttpClientEngine httpClientEngine, PlatformProvider platformProvider, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(300, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(str, str2, str3, duration, (i & 16) != 0 ? null : httpClientEngine, (i & 32) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider, (i & 64) != 0 ? Clock.System.INSTANCE : clock, null);
    }

    /* JADX INFO: renamed from: getRefreshBufferWindow-UwyO8pc, reason: not valid java name and from getter */
    public final long getRefreshBufferWindow() {
        return this.refreshBufferWindow;
    }

    public final HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    public final PlatformProvider getPlatformProvider() {
        return this.platformProvider;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$resolve$2 */
    /* JADX INFO: compiled from: SsoTokenProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$resolve$2", m1609f = "SsoTokenProvider.kt", m1610i = {}, m1611l = {BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C30282 extends SuspendLambda implements Function1<Continuation<? super SsoToken>, Object> {
        final /* synthetic */ Attributes $attributes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30282(Attributes attributes, Continuation<? super C30282> continuation) {
            super(1, continuation);
            this.$attributes = attributes;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SsoTokenProvider.this.new C30282(this.$attributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super SsoToken> continuation) {
            return ((C30282) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object token = SsoTokenProvider.this.getToken(this.$attributes, this);
            return token == coroutine_suspended ? coroutine_suspended : token;
        }
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        return this.sfg.singleFlight(new C30282(attributes, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getToken(Attributes attributes, Continuation<? super SsoToken> continuation) {
        C30261 c30261;
        if (continuation instanceof C30261) {
            c30261 = (C30261) continuation;
            if ((c30261.label & Integer.MIN_VALUE) != 0) {
                c30261.label -= Integer.MIN_VALUE;
            } else {
                c30261 = new C30261(continuation);
            }
        }
        Object tokenFromCache = c30261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30261.label;
        if (i == 0) {
            ResultKt.throwOnFailure(tokenFromCache);
            String str = this.ssoSessionName;
            PlatformProvider platformProvider = this.platformProvider;
            c30261.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
            c30261.label = 1;
            tokenFromCache = SsoTokenProviderKt.readTokenFromCache(str, platformProvider, c30261);
            if (tokenFromCache != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(tokenFromCache);
            return tokenFromCache;
        }
        attributes = (Attributes) c30261.L$0;
        ResultKt.throwOnFailure(tokenFromCache);
        final SsoToken ssoToken = (SsoToken) tokenFromCache;
        if (this.clock.getNow().compareTo(ssoToken.getExpiration().m12288minusLRDsOJo(this.refreshBufferWindow)) >= 0) {
            if (SsoTokenProviderKt.getCanRefresh(ssoToken)) {
                c30261.L$0 = SpillingKt.nullOutSpilledVariable(attributes);
                c30261.L$1 = SpillingKt.nullOutSpilledVariable(ssoToken);
                c30261.label = 2;
                Object objAttemptRefresh = attemptRefresh(ssoToken, c30261);
                return objAttemptRefresh == coroutine_suspended ? coroutine_suspended : objAttemptRefresh;
            }
            if (this.clock.getNow().compareTo(ssoToken.getExpiration()) >= 0) {
                ssoToken = null;
            }
            if (ssoToken != null) {
                CoroutineContext context = c30261.get$context();
                Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoTokenProvider.getToken$lambda$2$0(ssoToken, this);
                    }
                };
                LogLevel logLevel = LogLevel.Debug;
                String qualifiedName = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
                return ssoToken;
            }
            throwTokenExpired$default(this, null, 1, null);
            throw new KotlinNothingValueException();
        }
        CoroutineContext context2 = c30261.get$context();
        Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SsoTokenProvider.getToken$lambda$0(this.f$0);
            }
        };
        LogLevel logLevel2 = LogLevel.Debug;
        String qualifiedName2 = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
        if (qualifiedName2 == null) {
            throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
        }
        CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName2, null, function02);
        return ssoToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getToken$lambda$0(SsoTokenProvider ssoTokenProvider) {
        return "using cached token for sso-session: " + ssoTokenProvider.ssoSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getToken$lambda$2$0(SsoToken ssoToken, SsoTokenProvider ssoTokenProvider) {
        return "cached token is not refreshable but still valid until " + ssoToken.getExpiration() + " for sso-session: " + ssoTokenProvider.ssoSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object attemptRefresh(SsoToken ssoToken, Continuation<? super SsoToken> continuation) {
        C30251 c30251;
        Object objM14499constructorimpl;
        final SsoToken ssoToken2;
        Object obj;
        SsoToken ssoToken3;
        Throwable thM14502exceptionOrNullimpl;
        if (continuation instanceof C30251) {
            c30251 = (C30251) continuation;
            if ((c30251.label & Integer.MIN_VALUE) != 0) {
                c30251.label -= Integer.MIN_VALUE;
            } else {
                c30251 = new C30251(continuation);
            }
        }
        Object objRefreshToken = c30251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30251.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(objRefreshToken);
            CoroutineContext context = c30251.get$context();
            Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SsoTokenProvider.attemptRefresh$lambda$0(this.f$0);
                }
            };
            LogLevel logLevel = LogLevel.Debug;
            String qualifiedName = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
            }
            CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
            Result.Companion companion2 = Result.INSTANCE;
            SsoTokenProvider ssoTokenProvider = this;
            c30251.L$0 = ssoToken;
            c30251.L$1 = SpillingKt.nullOutSpilledVariable(this);
            c30251.I$0 = 0;
            c30251.label = 1;
            objRefreshToken = refreshToken(ssoToken, c30251);
            if (objRefreshToken == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30251.I$0;
                obj = c30251.L$2;
                Object obj2 = c30251.L$1;
                ssoToken3 = (SsoToken) c30251.L$0;
                ResultKt.throwOnFailure(objRefreshToken);
                ssoToken2 = ssoToken3;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
                if (thM14502exceptionOrNullimpl != null) {
                    return obj;
                }
                if (this.clock.getNow().compareTo(ssoToken2.getExpiration()) >= 0) {
                    CoroutineContext context2 = c30251.get$context();
                    Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SsoTokenProvider.attemptRefresh$lambda$3$0();
                        }
                    };
                    LogLevel logLevel2 = LogLevel.Error;
                    String qualifiedName2 = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
                    if (qualifiedName2 == null) {
                        throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                    }
                    CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName2, thM14502exceptionOrNullimpl, function02);
                    throwTokenExpired(thM14502exceptionOrNullimpl);
                    throw new KotlinNothingValueException();
                }
                CoroutineContext context3 = c30251.get$context();
                Function0 function03 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoTokenProvider.attemptRefresh$lambda$3$1(ssoToken2, this);
                    }
                };
                LogLevel logLevel3 = LogLevel.Debug;
                String qualifiedName3 = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
                if (qualifiedName3 == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context3, logLevel3, qualifiedName3, null, function03);
                return ssoToken2;
            }
            int i3 = c30251.I$0;
            ssoToken = (SsoToken) c30251.L$0;
            ResultKt.throwOnFailure(objRefreshToken);
        }
        objM14499constructorimpl = Result.m14499constructorimpl((SsoToken) objRefreshToken);
        Object obj3 = objM14499constructorimpl;
        ssoToken2 = ssoToken;
        obj = obj3;
        if (Result.m14506isSuccessimpl(obj)) {
            SsoToken ssoToken4 = (SsoToken) obj;
            c30251.L$0 = ssoToken2;
            c30251.L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c30251.L$2 = obj;
            c30251.L$3 = SpillingKt.nullOutSpilledVariable(ssoToken4);
            c30251.I$0 = 0;
            c30251.label = 2;
            if (writeToken(ssoToken4, c30251) != coroutine_suspended) {
                ssoToken3 = ssoToken2;
                ssoToken2 = ssoToken3;
            }
            return coroutine_suspended;
        }
        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(obj);
        if (thM14502exceptionOrNullimpl != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$0(SsoTokenProvider ssoTokenProvider) {
        return "attempting to refresh token for sso-session: " + ssoTokenProvider.ssoSessionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$3$0() {
        return "token refresh failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String attemptRefresh$lambda$3$1(SsoToken ssoToken, SsoTokenProvider ssoTokenProvider) {
        return "refresh token failed, original token is still valid until " + ssoToken.getExpiration() + " for sso-session: " + ssoTokenProvider.ssoSessionName + ", re-using";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeToken(SsoToken ssoToken, Continuation<? super Unit> continuation) {
        C30291 c30291;
        final String str;
        String qualifiedName;
        if (continuation instanceof C30291) {
            c30291 = (C30291) continuation;
            if ((c30291.label & Integer.MIN_VALUE) != 0) {
                c30291.label -= Integer.MIN_VALUE;
            } else {
                c30291 = new C30291(continuation);
            }
        }
        Object obj = c30291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30291.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String cacheFilename = SsoTokenProviderKt.getCacheFilename(this.ssoSessionName);
            String strNormalizePath = AwsConfigLoaderKt.normalizePath(SsoTokenProviderKt.filepath(this.platformProvider, "~", ".aws", "sso", "cache", cacheFilename), this.platformProvider);
            try {
                byte[] bArrSerializeSsoToken = SsoTokenProviderKt.serializeSsoToken(ssoToken);
                PlatformProvider platformProvider = this.platformProvider;
                c30291.L$0 = SpillingKt.nullOutSpilledVariable(ssoToken);
                c30291.L$1 = SpillingKt.nullOutSpilledVariable(cacheFilename);
                c30291.L$2 = strNormalizePath;
                c30291.L$3 = SpillingKt.nullOutSpilledVariable(bArrSerializeSsoToken);
                c30291.label = 1;
                if (platformProvider.writeFile(strNormalizePath, bArrSerializeSsoToken, c30291) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e) {
                e = e;
                str = strNormalizePath;
                CoroutineContext context = c30291.get$context();
                Exception exc = e;
                Function0 function0 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoTokenProvider.writeToken$lambda$0(str);
                    }
                };
                LogLevel logLevel = LogLevel.Debug;
                qualifiedName = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
                if (qualifiedName != null) {
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c30291.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                e = e2;
                CoroutineContext context2 = c30291.get$context();
                Exception exc2 = e;
                Function0 function02 = new Function0() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SsoTokenProvider.writeToken$lambda$0(str);
                    }
                };
                LogLevel logLevel2 = LogLevel.Debug;
                qualifiedName = Reflection.getOrCreateKotlinClass(SsoTokenProvider.class).getQualifiedName();
                if (qualifiedName != null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context2, logLevel2, qualifiedName, exc2, function02);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeToken$lambda$0(String str) {
        return "failed to write refreshed token back to disk at " + str;
    }

    private final Void throwTokenExpired(Throwable cause) {
        throw new InvalidSsoTokenException("SSO token for sso-session: " + this.ssoSessionName + " is expired", cause);
    }

    static /* synthetic */ Void throwTokenExpired$default(SsoTokenProvider ssoTokenProvider, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return ssoTokenProvider.throwTokenExpired(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshToken(SsoToken ssoToken, Continuation<? super SsoToken> continuation) throws Throwable {
        C30271 c30271;
        final TelemetryProvider telemetryProvider;
        Object objFromEnvironment;
        Closeable closeable;
        Closeable closeable2;
        SsoToken ssoToken2;
        if (continuation instanceof C30271) {
            c30271 = (C30271) continuation;
            if ((c30271.label & Integer.MIN_VALUE) != 0) {
                c30271.label -= Integer.MIN_VALUE;
            } else {
                c30271 = new C30271(continuation);
            }
        }
        Object objCreateToken = c30271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30271.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateToken);
                telemetryProvider = TelemetryProviderContextKt.getTelemetryProvider(c30271.get$context());
                SsoOidcClient.Companion companion = SsoOidcClient.INSTANCE;
                Function1 function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.SsoTokenProvider$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SsoTokenProvider.refreshToken$lambda$0(this.f$0, telemetryProvider, (SsoOidcClient.Config.Builder) obj);
                    }
                };
                c30271.L$0 = ssoToken;
                c30271.L$1 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
                c30271.label = 1;
                objFromEnvironment = companion.fromEnvironment(function1, c30271);
                if (objFromEnvironment != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c30271.I$3;
                int i3 = c30271.I$2;
                int i4 = c30271.I$1;
                int i5 = c30271.I$0;
                closeable2 = (Closeable) c30271.L$2;
                ssoToken2 = (SsoToken) c30271.L$0;
                try {
                    ResultKt.throwOnFailure(objCreateToken);
                    SsoToken ssoToken3 = SsoTokenProviderKt.toSsoToken((CreateTokenResponse) objCreateToken, ssoToken2, this.clock);
                    closeable2.close();
                    return ssoToken3;
                } catch (Throwable th) {
                    th = th;
                    try {
                        closeable2.close();
                    } catch (Throwable th2) {
                        ExceptionsKt.addSuppressed(th, th2);
                    }
                    throw th;
                }
            }
            TelemetryProvider telemetryProvider2 = (TelemetryProvider) c30271.L$1;
            SsoToken ssoToken4 = (SsoToken) c30271.L$0;
            ResultKt.throwOnFailure(objCreateToken);
            telemetryProvider = telemetryProvider2;
            ssoToken = ssoToken4;
            objFromEnvironment = objCreateToken;
            SsoOidcClient ssoOidcClient = (SsoOidcClient) closeable;
            CreateTokenRequest.Builder builder = new CreateTokenRequest.Builder();
            builder.setClientId(ssoToken.getClientId());
            builder.setClientSecret(ssoToken.getClientSecret());
            builder.setRefreshToken(ssoToken.getRefreshToken());
            builder.setGrantType("refresh_token");
            CreateTokenRequest createTokenRequestBuild = builder.build();
            c30271.L$0 = ssoToken;
            c30271.L$1 = SpillingKt.nullOutSpilledVariable(telemetryProvider);
            c30271.L$2 = closeable;
            c30271.L$3 = SpillingKt.nullOutSpilledVariable(ssoOidcClient);
            c30271.L$4 = SpillingKt.nullOutSpilledVariable(ssoOidcClient);
            c30271.L$5 = SpillingKt.nullOutSpilledVariable(c30271);
            c30271.I$0 = 0;
            c30271.I$1 = 0;
            c30271.I$2 = 0;
            c30271.I$3 = 0;
            c30271.label = 2;
            objCreateToken = ssoOidcClient.createToken(createTokenRequestBuild, c30271);
            if (objCreateToken != coroutine_suspended) {
                ssoToken2 = ssoToken;
                closeable2 = closeable;
                SsoToken ssoToken32 = SsoTokenProviderKt.toSsoToken((CreateTokenResponse) objCreateToken, ssoToken2, this.clock);
                closeable2.close();
                return ssoToken32;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
            closeable2.close();
            throw th;
        }
        closeable = (Closeable) objFromEnvironment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshToken$lambda$0(SsoTokenProvider ssoTokenProvider, TelemetryProvider telemetryProvider, SsoOidcClient.Config.Builder fromEnvironment) {
        Intrinsics.checkNotNullParameter(fromEnvironment, "$this$fromEnvironment");
        fromEnvironment.setRegion(ssoTokenProvider.ssoRegion);
        fromEnvironment.setHttpClient(ssoTokenProvider.httpClient);
        fromEnvironment.setTelemetryProvider(telemetryProvider);
        return Unit.INSTANCE;
    }
}
