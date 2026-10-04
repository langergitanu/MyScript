package com.myscript.nebo.sso.api;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.DbxPKCEManager;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.api.auth.SSOAuthApi;
import com.myscript.nebo.sso.api.auth.SSOAuthApiKt;
import com.myscript.nebo.sso.api.discovery.DiscoveredSSOConfiguration;
import com.myscript.nebo.sso.api.discovery.DiscoveryApi;
import com.myscript.nebo.sso.api.entity.DropboxCredentialPayload;
import com.myscript.nebo.sso.api.entity.GDriveAuthCodePayload;
import com.myscript.nebo.sso.api.entity.SSOAccount;
import com.myscript.nebo.sso.api.entity.ShareNotesPayload;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.sso.util.SSOCustomHeaderKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.http.HttpStatus;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u0001:\u0001bB\u0097\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00128\b\u0002\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010+\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0012\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u000109H\u0017J\u0018\u0010:\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u000109H\u0096@¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020!H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010=\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010>\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010?\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010,J\u001e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020\u00172\u0006\u00108\u001a\u00020*H\u0016J\u0010\u0010I\u001a\u00020\u00172\u0006\u00108\u001a\u00020*H\u0016J\u0012\u0010J\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010KH\u0017J\u001a\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\b\u00108\u001a\u0004\u0018\u00010OH\u0016J\"\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010RH\u0016J\u001a\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010RH\u0016J \u0010U\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010DJ\u000e\u0010V\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010,J \u0010W\u001a\u00020N2\u0006\u0010X\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010DJ\u001e\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020&2\u0006\u0010[\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020N2\u0006\u0010Z\u001a\u00020&H\u0082@¢\u0006\u0002\u0010^J\u001e\u0010_\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010DJ\u0010\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n $*\u0004\u0018\u00010#0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u00105\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00102¨\u0006c"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/SSOManager;", "Lcom/myscript/nebo/sso/api/ISSOManager;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "config", "Lcom/myscript/nebo/sso/api/SSOConfiguration;", "appVersion", "", "discoveryApi", "Lcom/myscript/nebo/sso/api/discovery/DiscoveryApi;", "ssoAuthApi", "Lcom/myscript/nebo/sso/api/auth/SSOAuthApi;", "httpClient", "Lokhttp3/OkHttpClient;", "nativeLoginHttpClient", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "onLoginAnalyticsEvent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "origin", "type", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/sso/api/SSOConfiguration;Ljava/lang/String;Lcom/myscript/nebo/sso/api/discovery/DiscoveryApi;Lcom/myscript/nebo/sso/api/auth/SSOAuthApi;Lokhttp3/OkHttpClient;Lokhttp3/OkHttpClient;Lcom/myscript/nebo/log/TechnicalLogger;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineScope;)V", "customHeaders", "", "getCustomHeaders", "()Ljava/util/Map;", "discoveredSSOConfiguration", "Lcom/myscript/nebo/sso/api/discovery/DiscoveredSSOConfiguration;", "ssoApi", "Lcom/myscript/nebo/sso/api/SSOApi;", "kotlin.jvm.PlatformType", "nativeLoginApi", "Lcom/myscript/nebo/sso/api/NativeLoginApi;", "currentCodeVerifier", "loginListeners", "", "Lcom/myscript/nebo/sso/api/ISSOManager$OnLoginListener;", "buildAuthorizeUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateCodeVerifier", "getCodeChallenge", "verifier", "privacyPolicyUpdateUrl", "getPrivacyPolicyUpdateUrl", "()Ljava/lang/String;", "privacyPolicyAcceptedUrl", "getPrivacyPolicyAcceptedUrl", "privacyPolicyRejectedUrl", "getPrivacyPolicyRejectedUrl", "getAccountAsync", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/sso/api/ISSOManager$OnAccountReceivedListener;", "fetchAccount", "(Lcom/myscript/nebo/sso/api/ISSOManager$OnAccountReceivedListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrFetchSSOConfiguration", "getAuthorizeEndpoint", "getTokenEndpoint", "getLogoutEndpoint", "getToken", "Lcom/myscript/nebo/sso/api/auth/SSOAuthApi$AccessTokenResponse;", "code", "codeVerifier", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeTokens", "accessToken", "refreshToken", "addLoginListener", "removeLoginListener", "reSendEmail", "Lcom/myscript/nebo/sso/api/ISSOManager$OnResendEmailListener;", "saveShareMyNotesSetting", "shareWithMyScript", "", "Lcom/myscript/nebo/sso/api/ISSOManager$OnShareSavedListener;", "saveDropboxCredential", "clientId", "Lcom/myscript/nebo/sso/api/ISSOManager$OnProviderTokenSaved;", "saveGDriveAuthToken", "authToken", "login", "logout", "startNativeLoginWithGoogle", "googleIdToken", "sendGoogleIdToken", "api", "idToken", "(Lcom/myscript/nebo/sso/api/NativeLoginApi;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startNativeLoginFlow", "(Lcom/myscript/nebo/sso/api/NativeLoginApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exchangeCodeAndLogin", "log", "message", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOManager implements ISSOManager {
    public static final String REDIRECT_URI = "myscriptnotes://myscript.app/";
    private static final String TAG = "SSOManager";
    private final String appVersion;
    private final SSOConfiguration config;
    private final CoroutineScope coroutineScope;
    private String currentCodeVerifier;
    private final Map<String, String> customHeaders;
    private DiscoveredSSOConfiguration discoveredSSOConfiguration;
    private final DiscoveryApi discoveryApi;
    private final TechnicalLogger logger;
    private final List<ISSOManager.OnLoginListener> loginListeners;
    private final NativeLoginApi nativeLoginApi;
    private final Function2<String, String, Unit> onLoginAnalyticsEvent;
    private final SSOApi ssoApi;
    private final SSOAuthApi ssoAuthApi;
    private final UserData userData;

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$buildAuthorizeUrl$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {147}, m1612m = "buildAuthorizeUrl", m1613n = {"params"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C68241(Continuation<? super C68241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.buildAuthorizeUrl(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$exchangeCodeAndLogin$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0}, m1611l = {433}, m1612m = "exchangeCodeAndLogin", m1613n = {"code", "codeVerifier"}, m1614nl = {439}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C68251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C68251(Continuation<? super C68251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.exchangeCodeAndLogin(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$fetchAccount$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {190}, m1612m = "fetchAccount", m1613n = {ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, m1614nl = {191}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C68271(Continuation<? super C68271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.fetchAccount(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getAuthorizeEndpoint$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {229}, m1612m = "getAuthorizeEndpoint", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C68291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C68291(Continuation<? super C68291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.getAuthorizeEndpoint(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getLogoutEndpoint$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {237}, m1612m = "getLogoutEndpoint", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C68301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C68301(Continuation<? super C68301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.getLogoutEndpoint(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getOrFetchSSOConfiguration$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {216}, m1612m = "getOrFetchSSOConfiguration", m1613n = {}, m1614nl = {225}, m1615s = {}, m1616v = 2)
    static final class C68311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C68311(Continuation<? super C68311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.getOrFetchSSOConfiguration(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getToken$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA2_4_2, PDFACompliance.e_PDFA2_4_2}, m1612m = "getToken", m1613n = {"code", "codeVerifier", "$this$getToken_u24lambda_u240", "$i$a$-runCatching-SSOManager$getToken$2", "code", "codeVerifier", "$this$getToken_u24lambda_u240", "$i$a$-runCatching-SSOManager$getToken$2"}, m1614nl = {PDFACompliance.e_PDFA2_4_4, 248}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C68331 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C68331(Continuation<? super C68331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.getToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getTokenEndpoint$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_3}, m1612m = "getTokenEndpoint", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C68341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C68341(Continuation<? super C68341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.getTokenEndpoint(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$login$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0}, m1611l = {338}, m1612m = "login", m1613n = {"code", "origin"}, m1614nl = {344}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C68351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C68351(Continuation<? super C68351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.login(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$logout$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_5_4}, m1612m = "logout", m1613n = {}, m1614nl = {358}, m1615s = {}, m1616v = 2)
    static final class C68371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C68371(Continuation<? super C68371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.logout(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$sendGoogleIdToken$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0, 0, 0}, m1611l = {383}, m1612m = "sendGoogleIdToken", m1613n = {"api", "idToken", "$this$sendGoogleIdToken_u24lambda_u240", "$i$a$-runCatching-SSOManager$sendGoogleIdToken$2"}, m1614nl = {392}, m1615s = {"L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C68441 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C68441(Continuation<? super C68441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.sendGoogleIdToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$startNativeLoginFlow$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, m1611l = {403, HttpStatus.SC_NOT_ACCEPTABLE, 420}, m1612m = "startNativeLoginFlow", m1613n = {"api", "$this$startNativeLoginFlow_u24lambda_u240", "$i$a$-runCatching-SSOManager$startNativeLoginFlow$2", "api", "$this$startNativeLoginFlow_u24lambda_u240", "authorizeUrl", "$i$a$-runCatching-SSOManager$startNativeLoginFlow$2", "api", "$this$startNativeLoginFlow_u24lambda_u240", "authorizeUrl", "response", "code", FirebaseAnalytics.Param.LOCATION, "$i$a$-runCatching-SSOManager$startNativeLoginFlow$2"}, m1614nl = {404, HttpStatus.SC_GONE, 421}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
    static final class C68451 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C68451(Continuation<? super C68451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.startNativeLoginFlow(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$startNativeLoginWithGoogle$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager", m1609f = "SSOManager.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {369, 374}, m1612m = "startNativeLoginWithGoogle", m1613n = {"googleIdToken", "origin", "api", "googleIdToken", "origin", "api", FirebaseAnalytics.Param.SUCCESS}, m1614nl = {370, 375}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "Z$0"}, m1616v = 2)
    static final class C68461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C68461(Continuation<? super C68461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSOManager.this.startNativeLoginWithGoogle(null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, SSOAuthApi ssoAuthApi, OkHttpClient httpClient) {
        this(userData, config, appVersion, discoveryApi, ssoAuthApi, httpClient, null, null, null, null, 960, null);
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, SSOAuthApi ssoAuthApi, OkHttpClient httpClient, OkHttpClient okHttpClient) {
        this(userData, config, appVersion, discoveryApi, ssoAuthApi, httpClient, okHttpClient, null, null, null, 896, null);
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, SSOAuthApi ssoAuthApi, OkHttpClient httpClient, OkHttpClient okHttpClient, TechnicalLogger technicalLogger) {
        this(userData, config, appVersion, discoveryApi, ssoAuthApi, httpClient, okHttpClient, technicalLogger, null, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, SSOAuthApi ssoAuthApi, OkHttpClient httpClient, OkHttpClient okHttpClient, TechnicalLogger technicalLogger, Function2<? super String, ? super String, Unit> onLoginAnalyticsEvent) {
        this(userData, config, appVersion, discoveryApi, ssoAuthApi, httpClient, okHttpClient, technicalLogger, onLoginAnalyticsEvent, null, 512, null);
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(onLoginAnalyticsEvent, "onLoginAnalyticsEvent");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, OkHttpClient httpClient) {
        this(userData, config, appVersion, discoveryApi, null, httpClient, null, null, null, null, 976, null);
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String message) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSOManager(UserData userData, SSOConfiguration config, String appVersion, DiscoveryApi discoveryApi, SSOAuthApi ssoAuthApi, OkHttpClient httpClient, OkHttpClient okHttpClient, TechnicalLogger technicalLogger, Function2<? super String, ? super String, Unit> onLoginAnalyticsEvent, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(discoveryApi, "discoveryApi");
        Intrinsics.checkNotNullParameter(ssoAuthApi, "ssoAuthApi");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(onLoginAnalyticsEvent, "onLoginAnalyticsEvent");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.userData = userData;
        this.config = config;
        this.appVersion = appVersion;
        this.discoveryApi = discoveryApi;
        this.ssoAuthApi = ssoAuthApi;
        this.logger = technicalLogger;
        this.onLoginAnalyticsEvent = onLoginAnalyticsEvent;
        this.coroutineScope = coroutineScope;
        this.customHeaders = SSOCustomHeaderKt.computeCustomHeaders(userData.getAppInstanceId(), appVersion);
        this.ssoApi = (SSOApi) new Retrofit.Builder().baseUrl(config.getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(SSOApi.class);
        this.nativeLoginApi = okHttpClient != null ? (NativeLoginApi) new Retrofit.Builder().baseUrl(config.getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build().create(NativeLoginApi.class) : null;
        this.currentCodeVerifier = "";
        this.loginListeners = new ArrayList();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SSOManager(UserData userData, SSOConfiguration sSOConfiguration, String str, DiscoveryApi discoveryApi, SSOAuthApi sSOAuthApi, OkHttpClient okHttpClient, OkHttpClient okHttpClient2, TechnicalLogger technicalLogger, Function2 function2, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        SSOAuthApi sSOAuthApiBuildSSOAuthApi$default;
        if ((i & 16) != 0) {
            str2 = str;
            sSOAuthApiBuildSSOAuthApi$default = SSOAuthApiKt.buildSSOAuthApi$default(userData.getAppInstanceId(), str2, null, 4, null);
        } else {
            str2 = str;
            sSOAuthApiBuildSSOAuthApi$default = sSOAuthApi;
        }
        this(userData, sSOConfiguration, str2, discoveryApi, sSOAuthApiBuildSSOAuthApi$default, okHttpClient, (i & 64) != 0 ? null : okHttpClient2, (i & 128) != 0 ? null : technicalLogger, (i & 256) != 0 ? new Function2() { // from class: com.myscript.nebo.sso.api.SSOManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SSOManager._init_$lambda$0((String) obj, (String) obj2);
            }
        } : function2, (i & 512) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())) : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public Map<String, String> getCustomHeaders() {
        return this.customHeaders;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object buildAuthorizeUrl(Continuation<? super String> continuation) {
        C68241 c68241;
        String str;
        if (continuation instanceof C68241) {
            c68241 = (C68241) continuation;
            if ((c68241.label & Integer.MIN_VALUE) != 0) {
                c68241.label -= Integer.MIN_VALUE;
            } else {
                c68241 = new C68241(continuation);
            }
        }
        Object obj = c68241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68241.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to("client_id", this.config.getClientId()), TuplesKt.m1606to("redirect_uri", URLEncoder.encode(REDIRECT_URI, Charsets.UTF_8.name())), TuplesKt.m1606to("scope", Scopes.OPEN_ID), TuplesKt.m1606to("response_type", "code"), TuplesKt.m1606to("code_challenge", getCodeChallenge(generateCodeVerifier())), TuplesKt.m1606to("code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS));
            ArrayList arrayList = new ArrayList(mapMapOf.size());
            for (Map.Entry entry : mapMapOf.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
            c68241.L$0 = strJoinToString$default;
            c68241.label = 1;
            Object authorizeEndpoint = getAuthorizeEndpoint(c68241);
            if (authorizeEndpoint == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = strJoinToString$default;
            obj = authorizeEndpoint;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c68241.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return obj + "?" + str;
    }

    private final String generateCodeVerifier() {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        String strEncodeToString = Base64.encodeToString(bArr, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        this.currentCodeVerifier = strEncodeToString;
        return strEncodeToString;
    }

    private final String getCodeChallenge(String verifier) throws NoSuchAlgorithmException {
        byte[] bytes = verifier.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        messageDigest.update(bytes, 0, bytes.length);
        String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public String getPrivacyPolicyUpdateUrl() {
        return this.config.getBaseUrl() + "/nebo/privacy-policy/update?app_connection_key=" + this.userData.getAppConnectionKey();
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public String getPrivacyPolicyAcceptedUrl() {
        return this.config.getBaseUrl() + "/nebo/privacy-policy/accepted";
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public String getPrivacyPolicyRejectedUrl() {
        return this.config.getBaseUrl() + "/nebo/privacy-policy/rejected";
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getAccountAsync$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$getAccountAsync$1", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_4}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {185}, m1615s = {}, m1616v = 2)
    static final class C68281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISSOManager.OnAccountReceivedListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68281(ISSOManager.OnAccountReceivedListener onAccountReceivedListener, Continuation<? super C68281> continuation) {
            super(2, continuation);
            this.$listener = onAccountReceivedListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68281(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SSOManager.this.fetchAccount(this.$listener, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    @Deprecated(message = "Use suspendable function getAccount instead")
    public void getAccountAsync(ISSOManager.OnAccountReceivedListener listener) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C68281(listener, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchAccount(ISSOManager.OnAccountReceivedListener onAccountReceivedListener, Continuation<? super Unit> continuation) {
        C68271 c68271;
        if (continuation instanceof C68271) {
            c68271 = (C68271) continuation;
            if ((c68271.label & Integer.MIN_VALUE) != 0) {
                c68271.label -= Integer.MIN_VALUE;
            } else {
                c68271 = new C68271(continuation);
            }
        }
        Object account = c68271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68271.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(account);
                SSOApi sSOApi = this.ssoApi;
                c68271.L$0 = onAccountReceivedListener;
                c68271.label = 1;
                account = sSOApi.getAccount(c68271);
                if (account == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                onAccountReceivedListener = (ISSOManager.OnAccountReceivedListener) c68271.L$0;
                ResultKt.throwOnFailure(account);
            }
            SSOAccount sSOAccount = (SSOAccount) account;
            this.userData.setLogin(sSOAccount.getLogin());
            this.userData.setMail(sSOAccount.getEmail());
            UserData userData = this.userData;
            String firstName = sSOAccount.getFirstName();
            String str = "";
            if (firstName == null) {
                firstName = "";
            }
            userData.setFirstName(firstName);
            UserData userData2 = this.userData;
            String lastName = sSOAccount.getLastName();
            if (lastName == null) {
                lastName = "";
            }
            userData2.setLastName(lastName);
            this.userData.setAppConnectionKey(sSOAccount.getAppConnectionKey());
            this.userData.setAccountActivated(sSOAccount.isActivated());
            this.userData.setNotesSharingActivated(sSOAccount.isSharedWithMyScript());
            UserData userData3 = this.userData;
            Boolean boolIsExplicitConsentTermsPrivacy = sSOAccount.isExplicitConsentTermsPrivacy();
            userData3.setNewPrivacyAccepted(boolIsExplicitConsentTermsPrivacy != null ? boolIsExplicitConsentTermsPrivacy.booleanValue() : false);
            UserData userData4 = this.userData;
            String publicAuthorId = sSOAccount.getPublicAuthorId();
            if (publicAuthorId != null) {
                str = publicAuthorId;
            }
            userData4.setPublicAuthorId(str);
            this.userData.setInstrumentedFeatureActivated(sSOAccount.isInstrumentedFeatureActivated());
            if (onAccountReceivedListener != null) {
                onAccountReceivedListener.onAccountReceived();
            }
        } catch (HttpException e) {
            int iCode = e.code();
            if ((iCode == 401 || iCode == 403) && onAccountReceivedListener != null) {
                onAccountReceivedListener.onTokenInvalid();
            }
        } catch (Exception e2) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Failed fetching account", e2));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOrFetchSSOConfiguration(Continuation<? super DiscoveredSSOConfiguration> continuation) {
        C68311 c68311;
        SSOManager sSOManager;
        DiscoveredSSOConfiguration discoveredSSOConfiguration;
        if (continuation instanceof C68311) {
            c68311 = (C68311) continuation;
            if ((c68311.label & Integer.MIN_VALUE) != 0) {
                c68311.label -= Integer.MIN_VALUE;
            } else {
                c68311 = new C68311(continuation);
            }
        }
        Object objWithContext = c68311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68311.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (this.discoveredSSOConfiguration == null) {
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                C68322 c68322 = new C68322(null);
                c68311.L$0 = this;
                c68311.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, c68322, c68311);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sSOManager = this;
            }
            discoveredSSOConfiguration = this.discoveredSSOConfiguration;
            if (discoveredSSOConfiguration == null) {
                return discoveredSSOConfiguration;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        sSOManager = (SSOManager) c68311.L$0;
        ResultKt.throwOnFailure(objWithContext);
        sSOManager.discoveredSSOConfiguration = (DiscoveredSSOConfiguration) objWithContext;
        discoveredSSOConfiguration = this.discoveredSSOConfiguration;
        if (discoveredSSOConfiguration == null) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$getOrFetchSSOConfiguration$2 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/sso/api/discovery/DiscoveredSSOConfiguration;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$getOrFetchSSOConfiguration$2", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {218}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {219}, m1615s = {}, m1616v = 2)
    static final class C68322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DiscoveredSSOConfiguration>, Object> {
        int label;

        C68322(Continuation<? super C68322> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68322(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DiscoveredSSOConfiguration> continuation) {
            return ((C68322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SSOManager.this.discoveryApi.discoverSSOConfiguration(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (DiscoveredSSOConfiguration) obj;
            } catch (Exception e) {
                TechnicalLogger technicalLogger = SSOManager.this.logger;
                if (technicalLogger != null) {
                    technicalLogger.logError(new RuntimeException("Failed api discovery", e));
                }
                return new DiscoveredSSOConfiguration(null, null, null, null, null, 31, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAuthorizeEndpoint(Continuation<? super String> continuation) {
        C68291 c68291;
        if (continuation instanceof C68291) {
            c68291 = (C68291) continuation;
            if ((c68291.label & Integer.MIN_VALUE) != 0) {
                c68291.label -= Integer.MIN_VALUE;
            } else {
                c68291 = new C68291(continuation);
            }
        }
        Object orFetchSSOConfiguration = c68291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68291.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
            c68291.label = 1;
            orFetchSSOConfiguration = getOrFetchSSOConfiguration(c68291);
            if (orFetchSSOConfiguration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
        }
        return ((DiscoveredSSOConfiguration) orFetchSSOConfiguration).getAuthorizationEndpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getTokenEndpoint(Continuation<? super String> continuation) {
        C68341 c68341;
        if (continuation instanceof C68341) {
            c68341 = (C68341) continuation;
            if ((c68341.label & Integer.MIN_VALUE) != 0) {
                c68341.label -= Integer.MIN_VALUE;
            } else {
                c68341 = new C68341(continuation);
            }
        }
        Object orFetchSSOConfiguration = c68341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
            c68341.label = 1;
            orFetchSSOConfiguration = getOrFetchSSOConfiguration(c68341);
            if (orFetchSSOConfiguration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
        }
        return ((DiscoveredSSOConfiguration) orFetchSSOConfiguration).getTokenEndpoint();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getLogoutEndpoint(Continuation<? super String> continuation) {
        C68301 c68301;
        if (continuation instanceof C68301) {
            c68301 = (C68301) continuation;
            if ((c68301.label & Integer.MIN_VALUE) != 0) {
                c68301.label -= Integer.MIN_VALUE;
            } else {
                c68301 = new C68301(continuation);
            }
        }
        Object orFetchSSOConfiguration = c68301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68301.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
            c68301.label = 1;
            orFetchSSOConfiguration = getOrFetchSSOConfiguration(c68301);
            if (orFetchSSOConfiguration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orFetchSSOConfiguration);
        }
        return ((DiscoveredSSOConfiguration) orFetchSSOConfiguration).getLogoutEndpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
    
        if (r15 == r0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getToken(String str, String str2, Continuation<? super SSOAuthApi.AccessTokenResponse> continuation) {
        C68331 c68331;
        Object objM14499constructorimpl;
        TechnicalLogger technicalLogger;
        String str3;
        String str4;
        int i;
        SSOManager sSOManager;
        SSOAuthApi sSOAuthApi;
        if (continuation instanceof C68331) {
            c68331 = (C68331) continuation;
            if ((c68331.label & Integer.MIN_VALUE) != 0) {
                c68331.label -= Integer.MIN_VALUE;
            } else {
                c68331 = new C68331(continuation);
            }
        }
        C68331 c683312 = c68331;
        Object token = c683312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c683312.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(token);
            Result.Companion companion2 = Result.INSTANCE;
            SSOManager sSOManager2 = this;
            SSOAuthApi sSOAuthApi2 = this.ssoAuthApi;
            c683312.L$0 = str;
            c683312.L$1 = str2;
            c683312.L$2 = this;
            c683312.L$3 = sSOAuthApi2;
            c683312.I$0 = 0;
            c683312.label = 1;
            Object tokenEndpoint = getTokenEndpoint(c683312);
            if (tokenEndpoint == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str;
            str4 = str2;
            i = 0;
            sSOManager = this;
            sSOAuthApi = sSOAuthApi2;
            token = tokenEndpoint;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c683312.I$0;
                ResultKt.throwOnFailure(token);
                objM14499constructorimpl = Result.m14499constructorimpl((SSOAuthApi.AccessTokenResponse) token);
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                if (thM14502exceptionOrNullimpl == null) {
                    return objM14499constructorimpl;
                }
                Exception exc = thM14502exceptionOrNullimpl instanceof Exception ? (Exception) thM14502exceptionOrNullimpl : null;
                if (exc != null && (technicalLogger = this.logger) != null) {
                    technicalLogger.logError(exc);
                }
                return new SSOAuthApi.AccessTokenResponse(null, null, 3, null);
            }
            i = c683312.I$0;
            SSOAuthApi sSOAuthApi3 = (SSOAuthApi) c683312.L$3;
            SSOManager sSOManager3 = (SSOManager) c683312.L$2;
            String str5 = (String) c683312.L$1;
            String str6 = (String) c683312.L$0;
            ResultKt.throwOnFailure(token);
            sSOAuthApi = sSOAuthApi3;
            sSOManager = sSOManager3;
            str4 = str5;
            str3 = str6;
        }
        String clientId = sSOManager.config.getClientId();
        String clientSecret = sSOManager.config.getClientSecret();
        c683312.L$0 = SpillingKt.nullOutSpilledVariable(str3);
        c683312.L$1 = SpillingKt.nullOutSpilledVariable(str4);
        c683312.L$2 = SpillingKt.nullOutSpilledVariable(sSOManager);
        c683312.L$3 = null;
        c683312.I$0 = i;
        c683312.label = 2;
        token = sSOAuthApi.getToken((String) token, clientId, "authorization_code", clientSecret, REDIRECT_URI, str3, str4, c683312);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void storeTokens(String accessToken, String refreshToken) {
        this.userData.setAccessToken(accessToken);
        this.userData.setRefreshToken(refreshToken);
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void addLoginListener(ISSOManager.OnLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            this.loginListeners.add(listener);
        }
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void removeLoginListener(ISSOManager.OnLoginListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            this.loginListeners.remove(listener);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$reSendEmail$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$reSendEmail$1", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {278}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {279}, m1615s = {}, m1616v = 2)
    static final class C68391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISSOManager.OnResendEmailListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68391(ISSOManager.OnResendEmailListener onResendEmailListener, Continuation<? super C68391> continuation) {
            super(2, continuation);
            this.$listener = onResendEmailListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68391(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (SSOManager.this.ssoApi.reSendEmail(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ISSOManager.OnResendEmailListener onResendEmailListener = this.$listener;
                if (onResendEmailListener != null) {
                    onResendEmailListener.onResult(true);
                }
            } catch (Exception unused) {
                ISSOManager.OnResendEmailListener onResendEmailListener2 = this.$listener;
                if (onResendEmailListener2 != null) {
                    onResendEmailListener2.onResult(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void reSendEmail(ISSOManager.OnResendEmailListener listener) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C68391(listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$saveShareMyNotesSetting$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$saveShareMyNotesSetting$1", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {290}, m1612m = "invokeSuspend", m1613n = {TtmlNode.TAG_BODY}, m1614nl = {297}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISSOManager.OnShareSavedListener $listener;
        final /* synthetic */ boolean $shareWithMyScript;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68421(boolean z, ISSOManager.OnShareSavedListener onShareSavedListener, Continuation<? super C68421> continuation) {
            super(2, continuation);
            this.$shareWithMyScript = z;
            this.$listener = onShareSavedListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68421(this.$shareWithMyScript, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ShareNotesPayload shareNotesPayload = new ShareNotesPayload(SSOManager.this.userData.getLogin(), this.$shareWithMyScript);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(shareNotesPayload);
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new C6843xeaec52fc(SSOManager.this, shareNotesPayload, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                ISSOManager.OnShareSavedListener onShareSavedListener = this.$listener;
                if (onShareSavedListener != null) {
                    if (zBooleanValue != this.$shareWithMyScript) {
                        z = false;
                    }
                    onShareSavedListener.onShareSaved(z);
                }
            } catch (Exception unused) {
                ISSOManager.OnShareSavedListener onShareSavedListener2 = this.$listener;
                if (onShareSavedListener2 != null) {
                    onShareSavedListener2.onShareSaved(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void saveShareMyNotesSetting(boolean shareWithMyScript, ISSOManager.OnShareSavedListener listener) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C68421(shareWithMyScript, listener, null), 3, null);
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void saveDropboxCredential(String clientId, String refreshToken, ISSOManager.OnProviderTokenSaved listener) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        if (this.userData.isNotesSharingActivated()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C68401(refreshToken, clientId, this, listener, null), 3, null);
        } else if (listener != null) {
            listener.onProviderTokenSaved(true);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$saveDropboxCredential$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$saveDropboxCredential$1", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {312}, m1612m = "invokeSuspend", m1613n = {TtmlNode.TAG_BODY}, m1614nl = {313}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clientId;
        final /* synthetic */ ISSOManager.OnProviderTokenSaved $listener;
        final /* synthetic */ String $refreshToken;
        Object L$0;
        int label;
        final /* synthetic */ SSOManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68401(String str, String str2, SSOManager sSOManager, ISSOManager.OnProviderTokenSaved onProviderTokenSaved, Continuation<? super C68401> continuation) {
            super(2, continuation);
            this.$refreshToken = str;
            this.$clientId = str2;
            this.this$0 = sSOManager;
            this.$listener = onProviderTokenSaved;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C68401(this.$refreshToken, this.$clientId, this.this$0, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DropboxCredentialPayload dropboxCredentialPayload = new DropboxCredentialPayload(this.$refreshToken, this.$clientId);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(dropboxCredentialPayload);
                    this.label = 1;
                    if (this.this$0.ssoApi.linkDropboxAccount(dropboxCredentialPayload, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ISSOManager.OnProviderTokenSaved onProviderTokenSaved = this.$listener;
                if (onProviderTokenSaved != null) {
                    onProviderTokenSaved.onProviderTokenSaved(true);
                }
            } catch (Exception unused) {
                ISSOManager.OnProviderTokenSaved onProviderTokenSaved2 = this.$listener;
                if (onProviderTokenSaved2 != null) {
                    onProviderTokenSaved2.onProviderTokenSaved(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.sso.api.ISSOManager
    public void saveGDriveAuthToken(String authToken, ISSOManager.OnProviderTokenSaved listener) {
        Intrinsics.checkNotNullParameter(authToken, "authToken");
        if (this.userData.isNotesSharingActivated()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C68411(authToken, this, listener, null), 3, null);
        } else if (listener != null) {
            listener.onProviderTokenSaved(true);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$saveGDriveAuthToken$1 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$saveGDriveAuthToken$1", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {329}, m1612m = "invokeSuspend", m1613n = {TtmlNode.TAG_BODY}, m1614nl = {330}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authToken;
        final /* synthetic */ ISSOManager.OnProviderTokenSaved $listener;
        Object L$0;
        int label;
        final /* synthetic */ SSOManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68411(String str, SSOManager sSOManager, ISSOManager.OnProviderTokenSaved onProviderTokenSaved, Continuation<? super C68411> continuation) {
            super(2, continuation);
            this.$authToken = str;
            this.this$0 = sSOManager;
            this.$listener = onProviderTokenSaved;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C68411(this.$authToken, this.this$0, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GDriveAuthCodePayload gDriveAuthCodePayload = new GDriveAuthCodePayload(this.$authToken);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(gDriveAuthCodePayload);
                    this.label = 1;
                    if (this.this$0.ssoApi.linkGDriveAccount(gDriveAuthCodePayload, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ISSOManager.OnProviderTokenSaved onProviderTokenSaved = this.$listener;
                if (onProviderTokenSaved != null) {
                    onProviderTokenSaved.onProviderTokenSaved(true);
                }
            } catch (Exception unused) {
                ISSOManager.OnProviderTokenSaved onProviderTokenSaved2 = this.$listener;
                if (onProviderTokenSaved2 != null) {
                    onProviderTokenSaved2.onProviderTokenSaved(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$login$2 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$login$2", m1609f = "SSOManager.kt", m1610i = {1}, m1611l = {339, PDFACompliance.e_PDFA3_4_1}, m1612m = "invokeSuspend", m1613n = {"tokens"}, m1614nl = {340, 342}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68362(String str, Continuation<? super C68362> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68362(this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
        
            if (com.myscript.nebo.sso.api.ISSOManager.fetchAccount$default(r6.this$0, null, r6, 1, null) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SSOManager sSOManager = SSOManager.this;
                this.label = 1;
                obj = sSOManager.getToken(this.$code, sSOManager.currentCodeVerifier, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SSOAuthApi.AccessTokenResponse accessTokenResponse = (SSOAuthApi.AccessTokenResponse) obj;
            SSOManager.this.storeTokens(accessTokenResponse.getAccessToken(), accessTokenResponse.getRefreshToken());
            this.L$0 = SpillingKt.nullOutSpilledVariable(accessTokenResponse);
            this.label = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object login(String str, String str2, Continuation<? super Unit> continuation) {
        C68351 c68351;
        if (continuation instanceof C68351) {
            c68351 = (C68351) continuation;
            if ((c68351.label & Integer.MIN_VALUE) != 0) {
                c68351.label -= Integer.MIN_VALUE;
            } else {
                c68351 = new C68351(continuation);
            }
        }
        Object obj = c68351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68351.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C68362 c68362 = new C68362(str, null);
            c68351.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c68351.L$1 = str2;
            c68351.label = 1;
            if (BuildersKt.withContext(io2, c68362, c68351) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c68351.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (str2 != null) {
            this.onLoginAnalyticsEvent.invoke(str2, "web");
        }
        synchronized (this) {
            Iterator<T> it = this.loginListeners.iterator();
            while (it.hasNext()) {
                ((ISSOManager.OnLoginListener) it.next()).onLogin();
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$logout$2 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$logout$2", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C68382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68382(Continuation<? super C68382> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68382(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SSOManager.this.userData.logout();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object logout(Continuation<? super Unit> continuation) {
        C68371 c68371;
        if (continuation instanceof C68371) {
            c68371 = (C68371) continuation;
            if ((c68371.label & Integer.MIN_VALUE) != 0) {
                c68371.label -= Integer.MIN_VALUE;
            } else {
                c68371 = new C68371(continuation);
            }
        }
        Object obj = c68371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C68382 c68382 = new C68382(null);
            c68371.label = 1;
            if (BuildersKt.withContext(io2, c68382, c68371) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        synchronized (this) {
            Iterator<T> it = this.loginListeners.iterator();
            while (it.hasNext()) {
                ((ISSOManager.OnLoginListener) it.next()).onLogout();
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.sso.api.ISSOManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startNativeLoginWithGoogle(String str, String str2, Continuation<? super Boolean> continuation) {
        C68461 c68461;
        String str3;
        NativeLoginApi nativeLoginApi;
        String str4;
        boolean zBooleanValue;
        if (continuation instanceof C68461) {
            c68461 = (C68461) continuation;
            if ((c68461.label & Integer.MIN_VALUE) != 0) {
                c68461.label -= Integer.MIN_VALUE;
            } else {
                c68461 = new C68461(continuation);
            }
        }
        Object objStartNativeLoginFlow = c68461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objStartNativeLoginFlow);
            NativeLoginApi nativeLoginApi2 = this.nativeLoginApi;
            if (nativeLoginApi2 == null) {
                log("native login API not configured");
                return Boxing.boxBoolean(false);
            }
            log("starting native login");
            c68461.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c68461.L$1 = str2;
            c68461.L$2 = nativeLoginApi2;
            c68461.label = 1;
            Object objSendGoogleIdToken = sendGoogleIdToken(nativeLoginApi2, str, c68461);
            if (objSendGoogleIdToken != coroutine_suspended) {
                str3 = str;
                nativeLoginApi = nativeLoginApi2;
                objStartNativeLoginFlow = objSendGoogleIdToken;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z = c68461.Z$0;
            str4 = (String) c68461.L$1;
            ResultKt.throwOnFailure(objStartNativeLoginFlow);
            zBooleanValue = ((Boolean) objStartNativeLoginFlow).booleanValue();
            if (zBooleanValue && str4 != null) {
                this.onLoginAnalyticsEvent.invoke(str4, "native_google");
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        nativeLoginApi = (NativeLoginApi) c68461.L$2;
        str2 = (String) c68461.L$1;
        str3 = (String) c68461.L$0;
        ResultKt.throwOnFailure(objStartNativeLoginFlow);
        boolean zBooleanValue2 = ((Boolean) objStartNativeLoginFlow).booleanValue();
        if (!zBooleanValue2) {
            log("aborting, sendGoogleIdToken failed");
            return Boxing.boxBoolean(false);
        }
        c68461.L$0 = SpillingKt.nullOutSpilledVariable(str3);
        c68461.L$1 = str2;
        c68461.L$2 = SpillingKt.nullOutSpilledVariable(nativeLoginApi);
        c68461.Z$0 = zBooleanValue2;
        c68461.label = 2;
        objStartNativeLoginFlow = startNativeLoginFlow(nativeLoginApi, c68461);
        if (objStartNativeLoginFlow != coroutine_suspended) {
            str4 = str2;
            zBooleanValue = ((Boolean) objStartNativeLoginFlow).booleanValue();
            if (zBooleanValue) {
                this.onLoginAnalyticsEvent.invoke(str4, "native_google");
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendGoogleIdToken(NativeLoginApi nativeLoginApi, String str, Continuation<? super Boolean> continuation) {
        C68441 c68441;
        Object objM14499constructorimpl;
        if (continuation instanceof C68441) {
            c68441 = (C68441) continuation;
            if ((c68441.label & Integer.MIN_VALUE) != 0) {
                c68441.label -= Integer.MIN_VALUE;
            } else {
                c68441 = new C68441(continuation);
            }
        }
        Object obj = c68441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68441.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                SSOManager sSOManager = this;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                SSOManager$sendGoogleIdToken$2$1 sSOManager$sendGoogleIdToken$2$1 = new SSOManager$sendGoogleIdToken$2$1(str, this, nativeLoginApi, null);
                c68441.L$0 = SpillingKt.nullOutSpilledVariable(nativeLoginApi);
                c68441.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c68441.L$2 = SpillingKt.nullOutSpilledVariable(this);
                c68441.I$0 = 0;
                c68441.label = 1;
                if (BuildersKt.withContext(io2, sSOManager$sendGoogleIdToken$2$1, c68441) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c68441.I$0;
                ResultKt.throwOnFailure(obj);
            }
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14506isSuccessimpl(objM14499constructorimpl)) {
            log("id token accepted (200)");
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            HttpException httpException = thM14502exceptionOrNullimpl instanceof HttpException ? (HttpException) thM14502exceptionOrNullimpl : null;
            log("send id token failed (HTTP " + (httpException != null ? Boxing.boxInt(httpException.code()) : null) + "): " + thM14502exceptionOrNullimpl.getMessage());
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(new IllegalStateException("native_login: send id token failed: " + thM14502exceptionOrNullimpl));
            }
        }
        return Boxing.boxBoolean(Result.m14506isSuccessimpl(objM14499constructorimpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x012a, code lost:
    
        if (r14.exchangeCodeAndLogin(r1, r0, r3) == r4) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ef A[Catch: all -> 0x0171, TryCatch #0 {all -> 0x0171, blocks: (B:14:0x004c, B:40:0x012d, B:19:0x0067, B:33:0x00cd, B:35:0x00ef, B:37:0x00fb, B:41:0x0139, B:42:0x014f, B:43:0x0150, B:44:0x0170, B:22:0x0079, B:29:0x009c, B:25:0x0085), top: B:54:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150 A[Catch: all -> 0x0171, TryCatch #0 {all -> 0x0171, blocks: (B:14:0x004c, B:40:0x012d, B:19:0x0067, B:33:0x00cd, B:35:0x00ef, B:37:0x00fb, B:41:0x0139, B:42:0x014f, B:43:0x0150, B:44:0x0170, B:22:0x0079, B:29:0x009c, B:25:0x0085), top: B:54:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startNativeLoginFlow(NativeLoginApi nativeLoginApi, Continuation<? super Boolean> continuation) {
        C68451 c68451;
        Object objM14499constructorimpl;
        int i;
        Object objBuildAuthorizeUrl;
        SSOManager sSOManager;
        String str;
        Object objWithContext;
        NativeLoginApi nativeLoginApi2;
        SSOManager sSOManager2;
        String str2;
        if (continuation instanceof C68451) {
            c68451 = (C68451) continuation;
            if ((c68451.label & Integer.MIN_VALUE) != 0) {
                c68451.label -= Integer.MIN_VALUE;
            } else {
                c68451 = new C68451(continuation);
            }
        }
        Object obj = c68451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c68451.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Result.Companion companion2 = Result.INSTANCE;
            SSOManager sSOManager3 = this;
            c68451.L$0 = nativeLoginApi;
            c68451.L$1 = this;
            i = 0;
            c68451.I$0 = 0;
            c68451.label = 1;
            objBuildAuthorizeUrl = buildAuthorizeUrl(c68451);
            if (objBuildAuthorizeUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
            sSOManager = this;
        } else if (i2 == 1) {
            int i3 = c68451.I$0;
            SSOManager sSOManager4 = (SSOManager) c68451.L$1;
            NativeLoginApi nativeLoginApi3 = (NativeLoginApi) c68451.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            nativeLoginApi = nativeLoginApi3;
            sSOManager = sSOManager4;
            objBuildAuthorizeUrl = obj;
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c68451.I$0;
                sSOManager2 = (SSOManager) c68451.L$1;
                ResultKt.throwOnFailure(obj);
                sSOManager2.log("login complete");
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                if (thM14502exceptionOrNullimpl != null) {
                    log("FAILED: " + thM14502exceptionOrNullimpl.getMessage());
                    TechnicalLogger technicalLogger = this.logger;
                    if (technicalLogger != null) {
                        technicalLogger.logError(new Exception("native_login: failed: " + thM14502exceptionOrNullimpl.getMessage(), thM14502exceptionOrNullimpl));
                    }
                }
                return Boxing.boxBoolean(Result.m14506isSuccessimpl(objM14499constructorimpl));
            }
            int i5 = c68451.I$0;
            str = (String) c68451.L$2;
            SSOManager sSOManager5 = (SSOManager) c68451.L$1;
            nativeLoginApi2 = (NativeLoginApi) c68451.L$0;
            ResultKt.throwOnFailure(obj);
            i = i5;
            sSOManager2 = sSOManager5;
            objWithContext = obj;
            Response response = (Response) objWithContext;
            sSOManager2.log("authorize response HTTP " + response.code());
            str2 = response.headers().get("Location");
            if (str2 != null) {
                throw new IllegalStateException(("No Location header in authorize response (HTTP " + response.code() + ")").toString());
            }
            String queryParameter = Uri.parse(str2).getQueryParameter("code");
            if (queryParameter == null) {
                throw new IllegalStateException(("No authorization code in redirect URI: " + str2).toString());
            }
            sSOManager2.log("authorize succeeded, exchanging code for tokens");
            String str3 = sSOManager2.currentCodeVerifier;
            c68451.L$0 = SpillingKt.nullOutSpilledVariable(nativeLoginApi2);
            c68451.L$1 = sSOManager2;
            c68451.L$2 = SpillingKt.nullOutSpilledVariable(str);
            c68451.L$3 = SpillingKt.nullOutSpilledVariable(response);
            c68451.L$4 = SpillingKt.nullOutSpilledVariable(queryParameter);
            c68451.L$5 = SpillingKt.nullOutSpilledVariable(str2);
            c68451.I$0 = i;
            c68451.label = 3;
        }
        str = (String) objBuildAuthorizeUrl;
        sSOManager.log("GET /authorize");
        CoroutineDispatcher io2 = Dispatchers.getIO();
        SSOManager$startNativeLoginFlow$2$response$1 sSOManager$startNativeLoginFlow$2$response$1 = new SSOManager$startNativeLoginFlow$2$response$1(nativeLoginApi, str, null);
        c68451.L$0 = SpillingKt.nullOutSpilledVariable(nativeLoginApi);
        c68451.L$1 = sSOManager;
        c68451.L$2 = SpillingKt.nullOutSpilledVariable(str);
        c68451.I$0 = i;
        c68451.label = 2;
        objWithContext = BuildersKt.withContext(io2, sSOManager$startNativeLoginFlow$2$response$1, c68451);
        if (objWithContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        SSOManager sSOManager6 = sSOManager;
        nativeLoginApi2 = nativeLoginApi;
        sSOManager2 = sSOManager6;
        Response response2 = (Response) objWithContext;
        sSOManager2.log("authorize response HTTP " + response2.code());
        str2 = response2.headers().get("Location");
        if (str2 != null) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$exchangeCodeAndLogin$2 */
    /* JADX INFO: compiled from: SSOManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$exchangeCodeAndLogin$2", m1609f = "SSOManager.kt", m1610i = {1}, m1611l = {434, 436}, m1612m = "invokeSuspend", m1613n = {"tokens"}, m1614nl = {435, 437}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        final /* synthetic */ String $codeVerifier;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68262(String str, String str2, Continuation<? super C68262> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$codeVerifier = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSOManager.this.new C68262(this.$code, this.$codeVerifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        
            if (com.myscript.nebo.sso.api.ISSOManager.fetchAccount$default(r6.this$0, null, r6, 1, null) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SSOManager.this.getToken(this.$code, this.$codeVerifier, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SSOAuthApi.AccessTokenResponse accessTokenResponse = (SSOAuthApi.AccessTokenResponse) obj;
            SSOManager.this.storeTokens(accessTokenResponse.getAccessToken(), accessTokenResponse.getRefreshToken());
            this.L$0 = SpillingKt.nullOutSpilledVariable(accessTokenResponse);
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object exchangeCodeAndLogin(String str, String str2, Continuation<? super Unit> continuation) {
        C68251 c68251;
        if (continuation instanceof C68251) {
            c68251 = (C68251) continuation;
            if ((c68251.label & Integer.MIN_VALUE) != 0) {
                c68251.label -= Integer.MIN_VALUE;
            } else {
                c68251 = new C68251(continuation);
            }
        }
        Object obj = c68251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C68262 c68262 = new C68262(str, str2, null);
            c68251.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c68251.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c68251.label = 1;
            if (BuildersKt.withContext(io2, c68262, c68251) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        synchronized (this) {
            Iterator<T> it = this.loginListeners.iterator();
            while (it.hasNext()) {
                ((ISSOManager.OnLoginListener) it.next()).onLogin();
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
