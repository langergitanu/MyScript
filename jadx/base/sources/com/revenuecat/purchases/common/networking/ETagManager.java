package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: ETagManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ5\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0016J[\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0000¢\u0006\u0002\b#J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0017\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0018H\u0002J\u0015\u0010*\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b+J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J%\u0010-\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0011H\u0000¢\u0006\u0002\b/J \u00100\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "prefs", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "payloadStore", "Lcom/revenuecat/purchases/common/networking/ETagPayloadStore;", "(Landroid/content/Context;Lkotlin/Lazy;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/ETagPayloadStore;)V", "clearCaches", "", "clearCaches$purchases_defaultsRelease", "getETagHeaders", "", "", "urlString", "verificationRequested", "", "refreshETag", "getETagHeaders$purchases_defaultsRelease", "getHTTPResultFromCacheOrBackend", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "responseCode", "", "payload", "eTagHeader", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "isLoadShedderResponse", "isFallbackURL", "getHTTPResultFromCacheOrBackend$purchases_defaultsRelease", "getStoredMetadata", "Lcom/revenuecat/purchases/common/networking/ETagCacheMetadata;", "getStoredResult", "getStoredResult$purchases_defaultsRelease", "shouldStoreBackendResult", "resultFromBackend", "shouldUseCachedVersion", "shouldUseCachedVersion$purchases_defaultsRelease", "shouldUseETag", "storeBackendResultIfNoError", "eTagInResponse", "storeBackendResultIfNoError$purchases_defaultsRelease", "storeResult", "result", "eTag", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ETagManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LEGACY_PREFERENCES_FILE_SUFFIX = "_preferences_etags";
    private static final String PREFERENCES_FILE_SUFFIX = "_preferences_etags_v2";
    private final DateProvider dateProvider;
    private final ETagPayloadStore payloadStore;
    private final Lazy<SharedPreferences> prefs;

    /* JADX INFO: compiled from: ETagManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerificationResult.values().length];
            try {
                iArr[VerificationResult.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationResult.NOT_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationResult.VERIFIED_ON_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean shouldUseCachedVersion$purchases_defaultsRelease(int responseCode) {
        return responseCode == 304;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ETagManager(Context context, Lazy<? extends SharedPreferences> prefs, DateProvider dateProvider, ETagPayloadStore payloadStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(payloadStore, "payloadStore");
        this.prefs = prefs;
        this.dateProvider = dateProvider;
        this.payloadStore = payloadStore;
    }

    public /* synthetic */ ETagManager(final Context context, Lazy lazy, DefaultDateProvider defaultDateProvider, ETagPayloadStore eTagPayloadStore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.revenuecat.purchases.common.networking.ETagManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                ETagManager.INSTANCE.deleteLegacyPreferencesFile$purchases_defaultsRelease(context);
                return ETagManager.INSTANCE.initializeSharedPreferences(context);
            }
        }) : lazy, (i & 4) != 0 ? new DefaultDateProvider() : defaultDateProvider, (i & 8) != 0 ? new ETagPayloadStore(context) : eTagPayloadStore);
    }

    public static /* synthetic */ Map getETagHeaders$purchases_defaultsRelease$default(ETagManager eTagManager, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return eTagManager.getETagHeaders$purchases_defaultsRelease(str, z, z2);
    }

    public final Map<String, String> getETagHeaders$purchases_defaultsRelease(String urlString, boolean verificationRequested, boolean refreshETag) {
        ETagData eTagData;
        Date lastRefreshTime;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String string = null;
        ETagCacheMetadata storedMetadata = refreshETag ? null : getStoredMetadata(urlString);
        if (storedMetadata == null || (eTagData = storedMetadata.getETagData()) == null || !shouldUseETag(storedMetadata.getVerificationResult(), verificationRequested)) {
            eTagData = null;
        }
        Pair[] pairArr = new Pair[2];
        String eTag = eTagData != null ? eTagData.getETag() : null;
        if (eTag == null) {
            eTag = "";
        }
        pairArr[0] = TuplesKt.m1606to("X-RevenueCat-ETag", eTag);
        if (eTagData != null && (lastRefreshTime = eTagData.getLastRefreshTime()) != null) {
            string = Long.valueOf(lastRefreshTime.getTime()).toString();
        }
        pairArr[1] = TuplesKt.m1606to(HTTPRequest.LAST_REFRESH_TIME_HEADER_NAME, string);
        return MapsKt.mapOf(pairArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final HTTPResult getHTTPResultFromCacheOrBackend$purchases_defaultsRelease(int responseCode, String payload, String eTagHeader, String urlString, boolean refreshETag, Date requestDate, VerificationResult verificationResult, boolean isLoadShedderResponse, boolean isFallbackURL) {
        HTTPResult hTTPResultCopy$default;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        final HTTPResult hTTPResult = new HTTPResult(responseCode, payload, HTTPResult.Origin.BACKEND, requestDate, verificationResult, isLoadShedderResponse, isFallbackURL);
        if (eTagHeader != null) {
            if (shouldUseCachedVersion$purchases_defaultsRelease(responseCode)) {
                HTTPResult storedResult$purchases_defaultsRelease = getStoredResult$purchases_defaultsRelease(urlString);
                if (storedResult$purchases_defaultsRelease != null) {
                    hTTPResultCopy$default = HTTPResult.copy$default(storedResult$purchases_defaultsRelease, 0, null, null, requestDate == null ? storedResult$purchases_defaultsRelease.getRequestDate() : requestDate, verificationResult, false, false, HttpStatusCodesKt.HTTP_EARLY_HINTS, null);
                } else {
                    hTTPResultCopy$default = null;
                }
                if (hTTPResultCopy$default != null) {
                    return hTTPResultCopy$default;
                }
                if (!refreshETag) {
                    return null;
                }
                final LogIntent logIntent = LogIntent.WARNING;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.networking.ETagManager$getHTTPResultFromCacheOrBackend$lambda$3$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                        String str = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{hTTPResult}, 1));
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
                            return hTTPResult;
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        return hTTPResult;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.mo1541d("[Purchases] - " + logLevel4.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        return hTTPResult;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.mo1541d("[Purchases] - " + logLevel7.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        return hTTPResult;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                        return hTTPResult;
                }
            } else {
                storeBackendResultIfNoError$purchases_defaultsRelease(urlString, hTTPResult, eTagHeader);
            }
        }
        return hTTPResult;
    }

    public final HTTPResult getStoredResult$purchases_defaultsRelease(String urlString) {
        ETagCacheMetadata eTagCacheMetadataDeserialize;
        String str;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String string = this.prefs.getValue().getString(urlString, null);
        if (string == null || (eTagCacheMetadataDeserialize = ETagCacheMetadata.INSTANCE.deserialize(string)) == null || (str = this.payloadStore.read(urlString, eTagCacheMetadataDeserialize.getPayloadChecksum())) == null) {
            return null;
        }
        return eTagCacheMetadataDeserialize.toHTTPResult(str);
    }

    public final void storeBackendResultIfNoError$purchases_defaultsRelease(String urlString, HTTPResult resultFromBackend, String eTagInResponse) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(resultFromBackend, "resultFromBackend");
        Intrinsics.checkNotNullParameter(eTagInResponse, "eTagInResponse");
        if (shouldStoreBackendResult(resultFromBackend)) {
            storeResult(urlString, resultFromBackend, eTagInResponse);
        }
    }

    public final synchronized void clearCaches$purchases_defaultsRelease() {
        this.prefs.getValue().edit().clear().apply();
        this.payloadStore.clear();
    }

    private final synchronized void storeResult(String urlString, HTTPResult result, String eTag) {
        Long lWrite = this.payloadStore.write(urlString, result.getPayloadText());
        if (lWrite != null) {
            this.prefs.getValue().edit().putString(urlString, ETagCacheMetadata.INSTANCE.fromResult(result, new ETagData(eTag, this.dateProvider.getNow()), lWrite.longValue()).serialize()).apply();
        }
    }

    private final ETagCacheMetadata getStoredMetadata(String urlString) {
        String string = this.prefs.getValue().getString(urlString, null);
        if (string != null) {
            return ETagCacheMetadata.INSTANCE.deserialize(string);
        }
        return null;
    }

    private final boolean shouldStoreBackendResult(HTTPResult resultFromBackend) {
        int responseCode = resultFromBackend.getResponseCode();
        return (responseCode == 304 || responseCode >= 500 || resultFromBackend.getVerificationResult() == VerificationResult.FAILED) ? false : true;
    }

    private final boolean shouldUseETag(VerificationResult verificationResult, boolean verificationRequested) {
        int i = WhenMappings.$EnumSwitchMapping$0[verificationResult.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !verificationRequested;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: ETagManager.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager$Companion;", "", "()V", "LEGACY_PREFERENCES_FILE_SUFFIX", "", "PREFERENCES_FILE_SUFFIX", "deleteLegacyPreferencesFile", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "deleteLegacyPreferencesFile$purchases_defaultsRelease", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void deleteLegacyPreferencesFile$purchases_defaultsRelease(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                try {
                    context.deleteSharedPreferences(context.getPackageName() + ETagManager.LEGACY_PREFERENCES_FILE_SUFFIX);
                } catch (Exception e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to delete the legacy ETag preferences file.", e);
                }
            }
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + ETagManager.PREFERENCES_FILE_SUFFIX, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }
}
