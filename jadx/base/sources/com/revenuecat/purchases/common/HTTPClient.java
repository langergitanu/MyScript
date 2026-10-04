package com.revenuecat.purchases.common;

import android.os.Build;
import androidx.credentials.provider.CredentialEntry;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.APISourceFailover;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.networking.RCContainer;
import com.revenuecat.purchases.common.networking.RCContainerFormatException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.survicate.surveys.TextRecallingManager;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.ByteStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 t2\u00020\u0001:\u0002stBw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\n -*\u0004\u0018\u00010,0,2\u0006\u0010.\u001a\u00020/H\u0002J\\\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u00010,2\u0006\u00107\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u00010,2\u0006\u00109\u001a\u00020:H\u0002J\u0017\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010.\u001a\u00020&H\u0001¢\u0006\u0002\b=J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020/H\u0002J\u0080\u0001\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001012\u001a\u0010I\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0K\u0018\u00010J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,012\u0006\u00105\u001a\u00020\u001cH\u0002J\u0095\u0001\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u0002042\u0006\u0010E\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001012\u001a\u0010I\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0K\u0018\u00010J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,012\u0006\u00105\u001a\u00020\u001c2!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110R¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020$0QH\u0002J\u0082\u0001\u0010V\u001a\u00020N2\u0006\u0010O\u001a\u0002042\u0006\u00109\u001a\u00020:2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001012\u001a\u0010I\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0K\u0018\u00010J2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,012\b\b\u0002\u00105\u001a\u00020\u001c2\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u0002040J2\b\b\u0002\u0010X\u001a\u00020RJ\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020<H\u0002J.\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010_\u001a\u00020R2\u0006\u00109\u001a\u00020:2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J\u0010\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020(H\u0002JD\u0010d\u001a\u00020$2\u0006\u0010O\u001a\u0002042\u0006\u00109\u001a\u00020:2\u0006\u0010e\u001a\u00020@2\u0006\u0010f\u001a\u00020\u001c2\b\u0010g\u001a\u0004\u0018\u00010N2\u0006\u0010h\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J\"\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u00010,H\u0002J*\u0010l\u001a\u00020j2\u0006\u0010k\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\u0006\u0010m\u001a\u00020Z2\b\u00106\u001a\u0004\u0018\u00010,H\u0002J6\u0010n\u001a\u00020j2\u0006\u0010k\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\b\u0010o\u001a\u0004\u0018\u00010,2\b\u00106\u001a\u0004\u0018\u00010,2\b\u00108\u001a\u0004\u0018\u00010,H\u0002J\u0018\u0010p\u001a\u00020$2\u0006\u0010q\u001a\u00020 2\u0006\u0010H\u001a\u00020,H\u0002J\u001c\u0010r\u001a\u00020,*\u00020Z2\u0006\u00109\u001a\u00020:2\u0006\u0010U\u001a\u00020RH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, m1599d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "eTagManager", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "signingManager", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "storefrontProvider", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "apiSourceFailover", "Lcom/revenuecat/purchases/common/networking/APISourceFailover;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "mapConverter", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "localeProvider", "Lcom/revenuecat/purchases/common/LocaleProvider;", "forceServerErrorStrategy", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "requestResponseListener", "Lcom/revenuecat/purchases/common/RequestResponseListener;", "timeoutManager", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/verification/SigningManager;Lcom/revenuecat/purchases/interfaces/StorefrontProvider;Lcom/revenuecat/purchases/common/networking/APISourceFailover;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/MapConverter;Lcom/revenuecat/purchases/common/LocaleProvider;Lcom/revenuecat/purchases/ForceServerErrorStrategy;Lcom/revenuecat/purchases/common/RequestResponseListener;Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;)V", "enableExtraRequestLogging", "", "getSigningManager", "()Lcom/revenuecat/purchases/common/verification/SigningManager;", "buffer", "Ljava/io/BufferedWriter;", "outputStream", "Ljava/io/OutputStream;", "clearCaches", "", "getConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "timeoutMs", "", "getETagHeader", "", "kotlin.jvm.PlatformType", "connection", "Ljava/net/URLConnection;", "getHeaders", "", "authenticationHeaders", "fullURL", "Ljava/net/URL;", "refreshETag", "nonce", "shouldSignResponse", "postFieldsToSignHeader", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "getInputStream", "Ljava/io/InputStream;", "getInputStream$purchases_defaultsRelease", "getLoadShedderHeader", "getRequestDateHeader", "Ljava/util/Date;", "getRequestTimeHeader", "performAttempt", "Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome;", "requestBaseURL", "isFallbackURL", "isMainBackend", "fallbackAvailable", TtmlNode.TAG_BODY, "postFieldsToSign", "", "Lkotlin/Pair;", "requestHeaders", "performCall", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "baseURL", "onResponseReceived", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "responseCode", "performRequest", "fallbackBaseURLs", "fallbackURLIndex", "readBytesFully", "", "inputStream", "sourceToRetryOn", "Lcom/revenuecat/purchases/common/networking/APISourceFailover$ResolvedSource;", FirebaseAnalytics.Param.SOURCE, "sourceAttempts", "connectionException", "Ljava/io/IOException;", "toCurlRequest", "httpRequest", "trackHttpRequestPerformedIfNeeded", "requestStartTime", "callSuccessful", "callResult", "isRetry", "verifyRCFormatNoContentResponse", "Lcom/revenuecat/purchases/VerificationResult;", "urlPath", "verifyRCFormatResponse", "payloadBytes", "verifyResponse", "payload", "writeFully", "writer", "describeForLogging", "AttemptOutcome", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class HTTPClient {
    public static final int MAX_API_SOURCE_ATTEMPTS = 5;
    public static final int NO_STATUS_CODE = -1;
    public static final String RC_FORMAT_ACCEPT = "application/x-rc-format";
    public static final String RC_FORMAT_ACCEPT_ENCODING = "gzip";
    public static final String RC_FORMAT_ACCEPT_ENCODING_HEADER = "Accept-RC-Element-Encoding";
    private final APISourceFailover apiSourceFailover;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final boolean enableExtraRequestLogging;
    private final ForceServerErrorStrategy forceServerErrorStrategy;
    private final LocaleProvider localeProvider;
    private final MapConverter mapConverter;
    private final RequestResponseListener requestResponseListener;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;
    private final HTTPTimeoutManager timeoutManager;

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, APISourceFailover aPISourceFailover, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager timeoutManager) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(eTagManager, "eTagManager");
        Intrinsics.checkNotNullParameter(signingManager, "signingManager");
        Intrinsics.checkNotNullParameter(storefrontProvider, "storefrontProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(mapConverter, "mapConverter");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(timeoutManager, "timeoutManager");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.apiSourceFailover = aPISourceFailover;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
        this.localeProvider = localeProvider;
        this.forceServerErrorStrategy = forceServerErrorStrategy;
        this.requestResponseListener = requestResponseListener;
        this.timeoutManager = timeoutManager;
        this.enableExtraRequestLogging = false;
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, APISourceFailover aPISourceFailover, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager hTTPTimeoutManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        AppConfig appConfig2;
        HTTPTimeoutManager hTTPTimeoutManager2;
        DateProvider defaultDateProvider = (i & 64) != 0 ? new DefaultDateProvider() : dateProvider;
        MapConverter mapConverter2 = (i & 128) != 0 ? new MapConverter() : mapConverter;
        ForceServerErrorStrategy forceServerErrorStrategy2 = (i & 512) != 0 ? null : forceServerErrorStrategy;
        RequestResponseListener requestResponseListener2 = (i & 1024) != 0 ? null : requestResponseListener;
        if ((i & 2048) != 0) {
            appConfig2 = appConfig;
            hTTPTimeoutManager2 = new HTTPTimeoutManager(appConfig2, defaultDateProvider);
        } else {
            appConfig2 = appConfig;
            hTTPTimeoutManager2 = hTTPTimeoutManager;
        }
        this(appConfig2, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, aPISourceFailover, defaultDateProvider, mapConverter2, localeProvider, forceServerErrorStrategy2, requestResponseListener2, hTTPTimeoutManager2);
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    private final byte[] readBytesFully(InputStream inputStream) throws IOException {
        return ByteStreamsKt.readBytes(inputStream);
    }

    private final String describeForLogging(byte[] bArr, Endpoint endpoint, int i) {
        if (endpoint.getExpectsRCFormatResponse() && RCHTTPStatusCodes.INSTANCE.isSuccessful(i)) {
            return "<rc-format: " + bArr.length + " bytes>";
        }
        return new String(bArr, Charsets.UTF_8);
    }

    public final InputStream getInputStream$purchases_defaultsRelease(HttpURLConnection connection) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            return connection.getInputStream();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException ? true : e instanceof IOException)) {
                throw e;
            }
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$getInputStream$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                    String str2 = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{e.getMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return sbAppend.append(str2).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.mo1541d(str, strInvoke);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.mo1541d(str, strInvoke);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.mo1541d(str, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.mo1541d(str, strInvoke);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            try {
                return connection.getErrorStream();
            } catch (NullPointerException e2) {
                throw new NullPointerReadingErrorStreamException(e2.getMessage(), e2);
            }
        }
    }

    private final void writeFully(BufferedWriter writer, String body) throws IOException {
        writer.write(body);
        writer.flush();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z, List list2, int i, int i2, Object obj) throws JSONException, IOException {
        if ((i2 & 32) != 0) {
            z = false;
        }
        if ((i2 & 64) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i2 & 128) != 0) {
            i = 0;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z, list2, i);
    }

    private static final boolean performRequest$canUseFallback(Endpoint endpoint, int i, List<URL> list) {
        return endpoint.getSupportsFallbackBaseURLs() && i >= 0 && i < list.size();
    }

    private static final HTTPResult performRequest$performRequestToFallbackURL(List<URL> list, int i, HTTPClient hTTPClient, final Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list2, Map<String, String> map2, boolean z) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final URL url = list.get(i);
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str2 = String.format(NetworkStrings.RETRYING_CALL_WITH_FALLBACK_URL, Arrays.copyOf(new Object[]{endpoint.getPath(true), url}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        return hTTPClient.performRequest(url, endpoint, map, list2, map2, z, list, i + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag, List<URL> fallbackBaseURLs, int fallbackURLIndex) throws Throwable {
        URL url;
        AttemptOutcome attemptOutcomePerformAttempt;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        APISourceFailover.ResolvedSource resolvedSourceSourceToRetryOn;
        Endpoint endpoint2 = endpoint;
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint2, "endpoint");
        Map<String, String> requestHeaders2 = requestHeaders;
        Intrinsics.checkNotNullParameter(requestHeaders2, "requestHeaders");
        Intrinsics.checkNotNullParameter(fallbackBaseURLs, "fallbackBaseURLs");
        int i = 1;
        boolean z = fallbackURLIndex == 0 && !endpoint2.getTargetsFallbackHost();
        APISourceFailover aPISourceFailover = this.apiSourceFailover;
        APISourceFailover.ResolvedSource resolvedSourceCurrentSource = aPISourceFailover != null ? aPISourceFailover.currentSource(endpoint2, baseURL, !z) : null;
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            if (resolvedSourceCurrentSource == null || (url = resolvedSourceCurrentSource.getUrl()) == null) {
                url = baseURL;
            }
            boolean z2 = fallbackURLIndex > 0 ? i : 0;
            APISourceFailover.ResolvedSource resolvedSource = resolvedSourceCurrentSource;
            URL url2 = url;
            Endpoint endpoint3 = endpoint2;
            boolean z3 = z;
            attemptOutcomePerformAttempt = performAttempt(url2, z2, z3, performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs), endpoint3, body, postFieldsToSign, requestHeaders2, refreshETag);
            z = z3;
            endpoint2 = endpoint3;
            if (!attemptOutcomePerformAttempt.getCanFailOverToNextSource() || (resolvedSourceSourceToRetryOn = sourceToRetryOn(resolvedSource, i3, endpoint2, attemptOutcomePerformAttempt.getConnectionException())) == null) {
                break;
            }
            requestHeaders2 = requestHeaders;
            resolvedSourceCurrentSource = resolvedSourceSourceToRetryOn;
            i2 = i3;
            i = 1;
        }
        if (attemptOutcomePerformAttempt instanceof AttemptOutcome.Failed) {
            if (!performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) {
                throw ((AttemptOutcome.Failed) attemptOutcomePerformAttempt).getException();
            }
            HTTPResult hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag);
            return (RCHTTPStatusCodes.INSTANCE.isServerError(hTTPResultPerformRequest$performRequestToFallbackURL.getResponseCode()) && performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) ? performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag) : hTTPResultPerformRequest$performRequestToFallbackURL;
        }
        if (!(attemptOutcomePerformAttempt instanceof AttemptOutcome.Completed)) {
            throw new NoWhenBranchMatchedException();
        }
        HTTPResult result = ((AttemptOutcome.Completed) attemptOutcomePerformAttempt).getResult();
        if (result != null) {
            return (RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) && performRequest$canUseFallback(endpoint, fallbackURLIndex, fallbackBaseURLs)) ? performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint, body, postFieldsToSign, requestHeaders, refreshETag) : result;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                break;
        }
        return performRequest(baseURL, endpoint, body, postFieldsToSign, requestHeaders, true, fallbackBaseURLs, fallbackURLIndex);
    }

    /* JADX INFO: compiled from: HTTPClient.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome;", "", "canFailOverToNextSource", "", "getCanFailOverToNextSource", "()Z", "connectionException", "Ljava/io/IOException;", "getConnectionException", "()Ljava/io/IOException;", "Completed", "Failed", "Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome$Completed;", "Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome$Failed;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private interface AttemptOutcome {

        /* JADX INFO: compiled from: HTTPClient.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome$Completed;", "Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome;", "result", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "(Lcom/revenuecat/purchases/common/networking/HTTPResult;)V", "getResult", "()Lcom/revenuecat/purchases/common/networking/HTTPResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Completed implements AttemptOutcome {
            private final HTTPResult result;

            public static /* synthetic */ Completed copy$default(Completed completed, HTTPResult hTTPResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    hTTPResult = completed.result;
                }
                return completed.copy(hTTPResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HTTPResult getResult() {
                return this.result;
            }

            public final Completed copy(HTTPResult result) {
                return new Completed(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Completed) && Intrinsics.areEqual(this.result, ((Completed) other).result);
            }

            public int hashCode() {
                HTTPResult hTTPResult = this.result;
                if (hTTPResult == null) {
                    return 0;
                }
                return hTTPResult.hashCode();
            }

            public String toString() {
                return "Completed(result=" + this.result + ')';
            }

            public Completed(HTTPResult hTTPResult) {
                this.result = hTTPResult;
            }

            public final HTTPResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: HTTPClient.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome$Failed;", "Lcom/revenuecat/purchases/common/HTTPClient$AttemptOutcome;", "exception", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getException", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class Failed implements AttemptOutcome {
            private final IOException exception;

            public static /* synthetic */ Failed copy$default(Failed failed, IOException iOException, int i, Object obj) {
                if ((i & 1) != 0) {
                    iOException = failed.exception;
                }
                return failed.copy(iOException);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final IOException getException() {
                return this.exception;
            }

            public final Failed copy(IOException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new Failed(exception);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failed) && Intrinsics.areEqual(this.exception, ((Failed) other).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Failed(exception=" + this.exception + ')';
            }

            public Failed(IOException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public final IOException getException() {
                return this.exception;
            }
        }

        /* JADX INFO: compiled from: HTTPClient.kt */
        @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static boolean getCanFailOverToNextSource(AttemptOutcome attemptOutcome) {
                return AttemptOutcome.super.getCanFailOverToNextSource();
            }

            @Deprecated
            public static IOException getConnectionException(AttemptOutcome attemptOutcome) {
                return AttemptOutcome.super.getConnectionException();
            }
        }

        default boolean getCanFailOverToNextSource() {
            if (this instanceof Failed) {
                return true;
            }
            if (!(this instanceof Completed)) {
                throw new NoWhenBranchMatchedException();
            }
            HTTPResult result = ((Completed) this).getResult();
            return result != null && RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode());
        }

        default IOException getConnectionException() {
            Failed failed = this instanceof Failed ? (Failed) this : null;
            if (failed != null) {
                return failed.getException();
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AttemptOutcome performAttempt(URL requestBaseURL, boolean isFallbackURL, boolean isMainBackend, boolean fallbackAvailable, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag) throws Throwable {
        Date date;
        IOException iOException;
        Integer num;
        Integer num2;
        Integer num3;
        Date now = this.dateProvider.getNow();
        HTTPTimeoutManager.RequestResult requestResult = HTTPTimeoutManager.RequestResult.OTHER_RESULT;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        HTTPResult hTTPResult = null;
        try {
            HTTPResult hTTPResultPerformCall = performCall(requestBaseURL, isFallbackURL, endpoint, body, postFieldsToSign, requestHeaders, refreshETag, new Function1<Integer, Unit>() { // from class: com.revenuecat.purchases.common.HTTPClient.performAttempt.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num4) {
                    invoke(num4.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Integer] */
                public final void invoke(int i) {
                    objectRef.element = Integer.valueOf(i);
                }
            });
            if (isMainBackend && (num3 = (Integer) objectRef.element) != null) {
                if (RCHTTPStatusCodes.INSTANCE.isSuccessful(num3.intValue())) {
                    requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                }
            }
            this.timeoutManager.recordRequestResult(requestBaseURL.getHost(), requestResult);
            iOException = null;
            trackHttpRequestPerformedIfNeeded(requestBaseURL, endpoint, now, true, hTTPResultPerformCall, refreshETag, null);
            hTTPResult = hTTPResultPerformCall;
        } catch (IOException e) {
            date = now;
            iOException = e;
            try {
                boolean z = (iOException instanceof SocketTimeoutException) && isMainBackend;
                boolean z2 = this.appConfig.getUsesRemoteConfigAPISources() || fallbackAvailable;
                if (z && z2) {
                    requestResult = HTTPTimeoutManager.RequestResult.MAIN_SOURCE_TIMED_OUT;
                }
                if (isMainBackend && (num2 = (Integer) objectRef.element) != null) {
                    if (RCHTTPStatusCodes.INSTANCE.isSuccessful(num2.intValue())) {
                        requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                    }
                }
                this.timeoutManager.recordRequestResult(requestBaseURL.getHost(), requestResult);
                trackHttpRequestPerformedIfNeeded(requestBaseURL, endpoint, date, false, null, refreshETag, iOException);
            } catch (Throwable th) {
                th = th;
                if (isMainBackend && (num = (Integer) objectRef.element) != null) {
                    if (RCHTTPStatusCodes.INSTANCE.isSuccessful(num.intValue())) {
                        requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                    }
                }
                this.timeoutManager.recordRequestResult(requestBaseURL.getHost(), requestResult);
                trackHttpRequestPerformedIfNeeded(requestBaseURL, endpoint, date, false, null, refreshETag, iOException);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            date = now;
            iOException = null;
            if (isMainBackend) {
                if (RCHTTPStatusCodes.INSTANCE.isSuccessful(num.intValue())) {
                }
            }
            this.timeoutManager.recordRequestResult(requestBaseURL.getHost(), requestResult);
            trackHttpRequestPerformedIfNeeded(requestBaseURL, endpoint, date, false, null, refreshETag, iOException);
            throw th;
        }
        return iOException != null ? new AttemptOutcome.Failed(iOException) : new AttemptOutcome.Completed(hTTPResult);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final APISourceFailover.ResolvedSource sourceToRetryOn(APISourceFailover.ResolvedSource source, int sourceAttempts, final Endpoint endpoint, IOException connectionException) {
        APISourceFailover.FailureDecision failureDecisionOnRequestFailure;
        final APISourceFailover.ResolvedSource next;
        APISourceFailover aPISourceFailover;
        if (source == null) {
            failureDecisionOnRequestFailure = null;
        } else {
            if (sourceAttempts >= 5) {
                source = null;
            }
            if (source != null && (aPISourceFailover = this.apiSourceFailover) != null) {
                failureDecisionOnRequestFailure = aPISourceFailover.onRequestFailure(source, connectionException);
            }
        }
        APISourceFailover.FailureDecision.RetryNextSource retryNextSource = failureDecisionOnRequestFailure instanceof APISourceFailover.FailureDecision.RetryNextSource ? (APISourceFailover.FailureDecision.RetryNextSource) failureDecisionOnRequestFailure : null;
        if (retryNextSource == null || (next = retryNextSource.getNext()) == null) {
            return null;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$sourceToRetryOn$lambda$8$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                String str = String.format(NetworkStrings.RETRYING_CALL_WITH_NEXT_API_SOURCE, Arrays.copyOf(new Object[]{endpoint.getName(), next.getUrl()}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return sbAppend.append(str).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), function0.invoke());
                }
                return next;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                return next;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    return next;
                }
                return next;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    return next;
                }
                return next;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.mo1541d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    return next;
                }
                return next;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                return next;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    return next;
                }
                return next;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    return next;
                }
                return next;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.mo1541d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    return next;
                }
                return next;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    return next;
                }
                return next;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    return next;
                }
                return next;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                return next;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    return next;
                }
                return next;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                return next;
            default:
                return next;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HTTPResult performCall(URL baseURL, boolean isFallbackURL, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag, Function1<? super Integer, Unit> onResponseReceived) throws Exception {
        boolean z;
        URL urlModifyRequestURL;
        URL url;
        String postParamsForSigningHeaderIfNeeded;
        URL url2;
        HTTPClient hTTPClient;
        InputStream inputStream;
        String str;
        boolean z2;
        String str2;
        HTTPResult.Payload.Text text;
        URL url3;
        int i;
        String str3;
        boolean z3;
        String str4;
        String str5;
        HTTPClient hTTPClient2;
        String str6;
        String str7;
        VerificationResult verificationResultVerifyResponse;
        VerificationResult verificationResult;
        VerificationResult verificationResultVerifyRCFormatResponse;
        RequestResponseListener requestResponseListener;
        ForceServerErrorStrategy forceServerErrorStrategy;
        ForceServerErrorStrategy forceServerErrorStrategy2;
        HTTPResult hTTPResultFakeResponseWithoutPerformingRequest;
        HTTPClient hTTPClient3 = this;
        JSONObject jSONObjectConvertToJSON$purchases_defaultsRelease = body != null ? hTTPClient3.mapConverter.convertToJSON$purchases_defaultsRelease(body) : null;
        String path = endpoint.getPath(isFallbackURL);
        boolean zShouldVerifyEndpoint = hTTPClient3.signingManager.shouldVerifyEndpoint(endpoint);
        boolean z4 = zShouldVerifyEndpoint && endpoint.getNeedsNonceToPerformSigning();
        if (!hTTPClient3.appConfig.getRunningTests() || (forceServerErrorStrategy2 = hTTPClient3.forceServerErrorStrategy) == null || (hTTPResultFakeResponseWithoutPerformingRequest = forceServerErrorStrategy2.fakeResponseWithoutPerformingRequest(baseURL, endpoint)) == null) {
            try {
                URL url4 = new URL(baseURL, path);
                if (!hTTPClient3.appConfig.getRunningTests() || (forceServerErrorStrategy = hTTPClient3.forceServerErrorStrategy) == null || !forceServerErrorStrategy.shouldForceServerError(baseURL, endpoint)) {
                    z = z4;
                    ForceServerErrorStrategy forceServerErrorStrategy3 = hTTPClient3.forceServerErrorStrategy;
                    if (forceServerErrorStrategy3 != null && (urlModifyRequestURL = forceServerErrorStrategy3.modifyRequestURL(url4, endpoint)) != null) {
                        url4 = urlModifyRequestURL;
                    }
                } else {
                    LogLevel logLevel = LogLevel.WARN;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    z = z4;
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Forcing server error for request to " + new URL(baseURL, path));
                    }
                    url4 = new URL(hTTPClient3.forceServerErrorStrategy.getServerErrorURL());
                }
                String strCreateRandomNonce = z ? hTTPClient3.signingManager.createRandomNonce() : null;
                if (postFieldsToSign == null) {
                    url = url4;
                    postParamsForSigningHeaderIfNeeded = null;
                } else if ((zShouldVerifyEndpoint ? postFieldsToSign : null) != null) {
                    URL url5 = url4;
                    postParamsForSigningHeaderIfNeeded = hTTPClient3.signingManager.getPostParamsForSigningHeaderIfNeeded(endpoint, postFieldsToSign);
                    url = url5;
                }
                URL url6 = url;
                HTTPRequest hTTPRequest = new HTTPRequest(url6, hTTPClient3.getHeaders(requestHeaders, url, refreshETag, strCreateRandomNonce, zShouldVerifyEndpoint, postParamsForSigningHeaderIfNeeded, endpoint), jSONObjectConvertToJSON$purchases_defaultsRelease);
                if (hTTPClient3.enableExtraRequestLogging) {
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    url2 = url6;
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "HTTP request:\\n " + hTTPClient3.toCurlRequest(hTTPRequest));
                    }
                } else {
                    url2 = url6;
                }
                HttpURLConnection connection = hTTPClient3.getConnection(hTTPRequest, hTTPClient3.timeoutManager.getTimeoutForRequest(baseURL.getHost(), isFallbackURL || endpoint.getTargetsFallbackHost(), endpoint.getSupportsFallbackBaseURLs() && !hTTPClient3.appConfig.getFallbackBaseURLs().isEmpty(), hTTPClient3.appConfig.getHasProxyURL(), hTTPClient3.appConfig.getUsesRemoteConfigAPISources()));
                InputStream inputStream$purchases_defaultsRelease = hTTPClient3.getInputStream$purchases_defaultsRelease(connection);
                try {
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        str = strCreateRandomNonce;
                        String str8 = "[Purchases] - " + logLevel3.name();
                        z2 = zShouldVerifyEndpoint;
                        str2 = postParamsForSigningHeaderIfNeeded;
                        String str9 = String.format(NetworkStrings.API_REQUEST_STARTED, Arrays.copyOf(new Object[]{connection.getRequestMethod(), path}, 2));
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        currentLogHandler3.mo1541d(str8, str9);
                    } else {
                        str = strCreateRandomNonce;
                        z2 = zShouldVerifyEndpoint;
                        str2 = postParamsForSigningHeaderIfNeeded;
                    }
                    int responseCode = connection.getResponseCode();
                    byte[] bytesFully = inputStream$purchases_defaultsRelease != null ? hTTPClient3.readBytesFully(inputStream$purchases_defaultsRelease) : null;
                    if (hTTPClient3.enableExtraRequestLogging) {
                        try {
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            inputStream = inputStream$purchases_defaultsRelease;
                            try {
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                    currentLogHandler4.mo1541d("[Purchases] - " + logLevel4.name(), "HTTP response:\\n  status code: " + responseCode + " \\n  body: " + (bytesFully != null ? hTTPClient3.describeForLogging(bytesFully, endpoint, responseCode) : null));
                                }
                            } catch (Throwable th) {
                                th = th;
                                hTTPClient = hTTPClient3;
                                try {
                                    if (hTTPClient.enableExtraRequestLogging) {
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "HTTP request failed", th);
                                    }
                                    throw th;
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        inputStream.close();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    connection.disconnect();
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream$purchases_defaultsRelease;
                        }
                    } else {
                        inputStream = inputStream$purchases_defaultsRelease;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    connection.disconnect();
                    LogLevel logLevel5 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        String str10 = "[Purchases] - " + logLevel5.name();
                        String str11 = String.format(NetworkStrings.API_REQUEST_COMPLETED, Arrays.copyOf(new Object[]{connection.getRequestMethod(), path, Integer.valueOf(responseCode)}, 3));
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        currentLogHandler5.mo1541d(str10, str11);
                    }
                    onResponseReceived.invoke(Integer.valueOf(responseCode));
                    if (bytesFully == null && (responseCode != 204 || !endpoint.getExpectsRCFormatResponse())) {
                        throw new IOException(NetworkStrings.HTTP_RESPONSE_PAYLOAD_NULL);
                    }
                    if (bytesFully == null) {
                        bytesFully = new byte[0];
                    }
                    byte[] bArr = bytesFully;
                    if (endpoint.getExpectsRCFormatResponse() && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode)) {
                        text = new HTTPResult.Payload.RCFormat(bArr);
                    } else {
                        text = new HTTPResult.Payload.Text(new String(bArr, Charsets.UTF_8));
                    }
                    HTTPResult.Payload payload = text;
                    String text2 = payload.getText();
                    if (!hTTPClient3.appConfig.getRunningTests() || (requestResponseListener = hTTPClient3.requestResponseListener) == null) {
                        url3 = url2;
                        i = responseCode;
                        str3 = "fullURL.toString()";
                        z3 = z2;
                        str4 = str;
                        str5 = str2;
                    } else {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
                        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                            String key = entry.getKey();
                            List<String> values = entry.getValue();
                            if (key != null) {
                                Intrinsics.checkNotNullExpressionValue(values, "values");
                                if (!values.isEmpty()) {
                                    linkedHashMap.put(key, CollectionsKt.joinToString$default(values, TextRecallingManager.ANSWER_SEPARATOR, null, null, 0, null, null, 62, null));
                                }
                            }
                        }
                        try {
                            URL url7 = new URL(baseURL, path);
                            String string = url7.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "fullURL.toString()");
                            String requestMethod = connection.getRequestMethod();
                            Intrinsics.checkNotNullExpressionValue(requestMethod, "connection.requestMethod");
                            url3 = url2;
                            str3 = "fullURL.toString()";
                            z3 = z2;
                            str4 = str;
                            str5 = str2;
                            hTTPClient3 = this;
                            try {
                                requestResponseListener.onRequestResponse(string, requestMethod, hTTPClient3.getHeaders(requestHeaders, url7, refreshETag, str4, z3, str5, endpoint), jSONObjectConvertToJSON$purchases_defaultsRelease != null ? jSONObjectConvertToJSON$purchases_defaultsRelease.toString() : null, responseCode, linkedHashMap, text2 == null ? "" : text2);
                                i = responseCode;
                            } catch (Throwable th4) {
                                th = th4;
                                i = responseCode;
                                LogLevel logLevel6 = LogLevel.WARN;
                                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                    currentLogHandler6.mo1545w("[Purchases] - " + logLevel6.name(), "RequestResponseListener error: " + th.getMessage());
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            hTTPClient3 = this;
                            url3 = url2;
                            i = responseCode;
                            str3 = "fullURL.toString()";
                            z3 = z2;
                            str4 = str;
                            str5 = str2;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    if (z3 && RCHTTPStatusCodes.INSTANCE.isSuccessful(i)) {
                        if (endpoint.getExpectsRCFormatResponse()) {
                            if (i == 204 && bArr.length == 0) {
                                verificationResultVerifyRCFormatResponse = hTTPClient3.verifyRCFormatNoContentResponse(path, connection, str4);
                            } else {
                                verificationResultVerifyRCFormatResponse = hTTPClient3.verifyRCFormatResponse(path, connection, bArr, str4);
                            }
                            verificationResult = verificationResultVerifyRCFormatResponse;
                            hTTPClient2 = hTTPClient3;
                            str6 = path;
                            str7 = text2;
                            if (verificationResult != VerificationResult.FAILED && (hTTPClient2.signingManager.getSignatureVerificationMode() instanceof SignatureVerificationMode.Enforced)) {
                                throw new SignatureVerificationException(str6);
                            }
                            HttpURLConnection httpURLConnection = connection;
                            boolean loadShedderHeader = hTTPClient2.getLoadShedderHeader(httpURLConnection);
                            if (!endpoint.getExpectsRCFormatResponse()) {
                                return new HTTPResult(i, payload, HTTPResult.Origin.BACKEND, hTTPClient2.getRequestDateHeader(httpURLConnection), verificationResult, loadShedderHeader, isFallbackURL);
                            }
                            int i2 = i;
                            ETagManager eTagManager = hTTPClient2.eTagManager;
                            String str12 = str7 == null ? "" : str7;
                            String eTagHeader = hTTPClient2.getETagHeader(httpURLConnection);
                            String string2 = url3.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, str3);
                            return eTagManager.getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(i2, str12, eTagHeader, string2, refreshETag, hTTPClient2.getRequestDateHeader(httpURLConnection), verificationResult, loadShedderHeader, isFallbackURL);
                        }
                        str6 = path;
                        str7 = text2;
                        verificationResultVerifyResponse = hTTPClient3.verifyResponse(str6, connection, str7, str4, str5);
                        hTTPClient2 = hTTPClient3;
                    } else {
                        hTTPClient2 = hTTPClient3;
                        str6 = path;
                        str7 = text2;
                        verificationResultVerifyResponse = VerificationResult.NOT_REQUESTED;
                    }
                    verificationResult = verificationResultVerifyResponse;
                    if (verificationResult != VerificationResult.FAILED) {
                    }
                    HttpURLConnection httpURLConnection2 = connection;
                    boolean loadShedderHeader2 = hTTPClient2.getLoadShedderHeader(httpURLConnection2);
                    if (!endpoint.getExpectsRCFormatResponse()) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    hTTPClient = hTTPClient3;
                    inputStream = inputStream$purchases_defaultsRelease;
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            LogLevel logLevel7 = LogLevel.WARN;
            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                currentLogHandler7.mo1545w("[Purchases] - " + logLevel7.name(), "Faking response for request to " + Endpoint.getPath$default(endpoint, false, 1, null));
            }
            return hTTPResultFakeResponseWithoutPerformingRequest;
        }
    }

    private final String toCurlRequest(HTTPRequest httpRequest) {
        String str;
        StringBuilder sb = new StringBuilder("curl -v -X ");
        if (httpRequest.getBody() == null) {
            str = "GET";
        } else {
            str = "POST";
        }
        sb.append(str).append(" \\\n  ");
        for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
            sb.append("-H \"").append(entry.getKey()).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(entry.getValue());
            sb.append("\" \\\n  ");
        }
        if (httpRequest.getBody() != null) {
            sb.append("-d '").append(httpRequest.getBody().toString()).append("' \\\n  ");
        }
        sb.append("\"").append(httpRequest.getFullURL()).append("\"");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    private final void trackHttpRequestPerformedIfNeeded(URL baseURL, Endpoint endpoint, Date requestStartTime, boolean callSuccessful, HTTPResult callResult, boolean isRetry, IOException connectionException) {
        int responseCode;
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.dateProvider.getNow());
            if (callSuccessful) {
                responseCode = callResult != null ? callResult.getResponseCode() : 304;
            } else {
                responseCode = -1;
            }
            int i = responseCode;
            HTTPResult.Origin origin = callResult != null ? callResult.getOrigin() : null;
            if (callResult == null || (verificationResult = callResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult2 = verificationResult;
            boolean z = callSuccessful && RCHTTPStatusCodes.INSTANCE.isSuccessful(i);
            ConnectionErrorReason connectionErrorReasonFromIOException = connectionException != null ? ConnectionErrorReason.INSTANCE.fromIOException(connectionException) : null;
            String host = baseURL.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "baseURL.host");
            diagnosticsTracker.m13726trackHttpRequestPerformedXzGXFE(host, endpoint, jBetween, z, i, callResult != null ? callResult.getBackendErrorCode() : null, origin, verificationResult2, isRetry, connectionErrorReasonFromIOException);
        }
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsRelease();
    }

    private final Map<String, String> getHeaders(Map<String, String> authenticationHeaders, URL fullURL, boolean refreshETag, String nonce, boolean shouldSignResponse, String postFieldsToSignHeader, Endpoint endpoint) {
        Map<String, String> eTagHeaders$purchases_defaultsRelease;
        Pair[] pairArr = new Pair[24];
        pairArr[0] = TuplesKt.m1606to("Content-Type", "application/json");
        pairArr[1] = TuplesKt.m1606to("Accept", endpoint.getExpectsRCFormatResponse() ? RC_FORMAT_ACCEPT : null);
        pairArr[2] = TuplesKt.m1606to(RC_FORMAT_ACCEPT_ENCODING_HEADER, endpoint.getExpectsRCFormatResponse() ? RC_FORMAT_ACCEPT_ENCODING : null);
        pairArr[3] = TuplesKt.m1606to("X-Platform", StorePlatformKt.getPlatformName(this.appConfig.getStore()));
        pairArr[4] = TuplesKt.m1606to("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor());
        pairArr[5] = TuplesKt.m1606to("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion());
        pairArr[6] = TuplesKt.m1606to("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT));
        pairArr[7] = TuplesKt.m1606to("X-Platform-Device", Build.MODEL);
        pairArr[8] = TuplesKt.m1606to("X-Platform-Brand", Build.BRAND);
        pairArr[9] = TuplesKt.m1606to("X-Version", "10.20.0");
        pairArr[10] = TuplesKt.m1606to("X-Preferred-Locales", StringsKt.replace$default(this.localeProvider.getCurrentLocalesLanguageTags(), Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
        pairArr[11] = TuplesKt.m1606to("X-Client-Locale", this.appConfig.getLanguageTag());
        pairArr[12] = TuplesKt.m1606to("X-Client-Version", this.appConfig.getVersionName());
        pairArr[13] = TuplesKt.m1606to("X-Client-Bundle-ID", this.appConfig.getPackageName());
        pairArr[14] = TuplesKt.m1606to("X-Observer-Mode-Enabled", this.appConfig.getFinishTransactions() ? CredentialEntry.FALSE_STRING : CredentialEntry.TRUE_STRING);
        pairArr[15] = TuplesKt.m1606to("X-Nonce", nonce);
        pairArr[16] = TuplesKt.m1606to(HTTPRequest.POST_PARAMS_HASH, postFieldsToSignHeader);
        pairArr[17] = TuplesKt.m1606to("X-Custom-Entitlements-Computation", this.appConfig.getCustomEntitlementComputation() ? CredentialEntry.TRUE_STRING : null);
        pairArr[18] = TuplesKt.m1606to("X-UI-Preview-Mode", this.appConfig.getUiPreviewMode() ? CredentialEntry.TRUE_STRING : null);
        pairArr[19] = TuplesKt.m1606to("X-Storefront", this.storefrontProvider.getStorefront());
        pairArr[20] = TuplesKt.m1606to("X-Is-Debug-Build", String.valueOf(this.appConfig.getIsDebugBuild()));
        pairArr[21] = TuplesKt.m1606to("X-Kotlin-Version", KotlinVersion.CURRENT.toString());
        pairArr[22] = TuplesKt.m1606to("X-Is-Backgrounded", String.valueOf(this.appConfig.isAppBackgrounded()));
        pairArr[23] = TuplesKt.m1606to("X-Billing-Client-Sdk-Version", "8.3.0");
        Map mapPlus = MapsKt.plus(MapsKt.mapOf(pairArr), authenticationHeaders);
        if (endpoint.getExpectsRCFormatResponse()) {
            eTagHeaders$purchases_defaultsRelease = MapsKt.emptyMap();
        } else {
            ETagManager eTagManager = this.eTagManager;
            String string = fullURL.toString();
            Intrinsics.checkNotNullExpressionValue(string, "fullURL.toString()");
            eTagHeaders$purchases_defaultsRelease = eTagManager.getETagHeaders$purchases_defaultsRelease(string, shouldSignResponse, refreshETag);
        }
        return MapExtensionsKt.filterNotNullValues(MapsKt.plus(mapPlus, eTagHeaders$purchases_defaultsRelease));
    }

    private final HttpURLConnection getConnection(HTTPRequest request, long timeoutMs) throws IOException {
        URLConnection uRLConnectionOpenConnection = request.getFullURL().openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout((int) timeoutMs);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(os, "os");
            BufferedWriter bufferedWriterBuffer = buffer(os);
            String string = body.toString();
            Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
            writeFully(bufferedWriterBuffer, string);
        }
        return httpURLConnection;
    }

    private final VerificationResult verifyResponse(String urlPath, URLConnection connection, String payload, String nonce, String postFieldsToSignHeader) {
        byte[] bytes;
        SigningManager signingManager = this.signingManager;
        String headerField = connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME);
        if (payload != null) {
            bytes = payload.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            bytes = null;
        }
        return signingManager.verifyResponse(urlPath, headerField, nonce, bytes, getRequestTimeHeader(connection), getETagHeader(connection), postFieldsToSignHeader);
    }

    private final VerificationResult verifyRCFormatResponse(String urlPath, URLConnection connection, byte[] payloadBytes, String nonce) {
        try {
            return this.signingManager.verifyResponse(urlPath, connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), nonce, RCContainer.INSTANCE.parse(payloadBytes).getConfig(), getRequestTimeHeader(connection), getETagHeader(connection), null);
        } catch (RCContainerFormatException e) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(NetworkStrings.VERIFICATION_ERROR, Arrays.copyOf(new Object[]{urlPath}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            currentLogHandler.mo1542e("[Purchases] - ERROR", str, e);
            return VerificationResult.FAILED;
        }
    }

    private final VerificationResult verifyRCFormatNoContentResponse(String urlPath, URLConnection connection, String nonce) {
        return this.signingManager.verifyResponse(urlPath, connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), nonce, new byte[0], getRequestTimeHeader(connection), getETagHeader(connection), null);
    }

    private final String getETagHeader(URLConnection connection) {
        return connection.getHeaderField("X-RevenueCat-ETag");
    }

    private final String getRequestTimeHeader(URLConnection connection) {
        String headerField = connection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || StringsKt.isBlank(headerField)) {
            return null;
        }
        return headerField;
    }

    private final Date getRequestDateHeader(URLConnection connection) {
        Long longOrNull;
        String requestTimeHeader = getRequestTimeHeader(connection);
        if (requestTimeHeader == null || (longOrNull = StringsKt.toLongOrNull(requestTimeHeader)) == null) {
            return null;
        }
        return new Date(longOrNull.longValue());
    }

    private final boolean getLoadShedderHeader(URLConnection connection) {
        String lowerCase;
        String headerField = connection.getHeaderField(HTTPResult.LOAD_SHEDDER_HEADER_NAME);
        if (headerField != null) {
            lowerCase = headerField.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return Intrinsics.areEqual(lowerCase, CredentialEntry.TRUE_STRING);
    }
}
