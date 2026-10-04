package com.myscript.nebo.account.backend;

import android.content.SharedPreferences;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.android.utils.NullableStringSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.account.backend.entity.InAppPurchasePayload;
import com.myscript.nebo.account.backend.entity.InAppPurchaseResponse;
import com.myscript.nebo.account.backend.entity.KeyValue;
import com.myscript.nebo.account.backend.entity.KeyValueParameters;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.sso.model.UserData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: NeboBackend.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 A2\u00020\u0001:\u0001ABQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010!H\u0096@¢\u0006\u0002\u0010\"J(\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u0004\u0018\u00010$H\u0096@¢\u0006\u0002\u0010\"J6\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0096@¢\u0006\u0004\b1\u00102J&\u00103\u001a\b\u0012\u0004\u0012\u0002040+2\u0006\u0010,\u001a\u00020\u00052\u0006\u00105\u001a\u000206H\u0096@¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\"J\u000e\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010\"J\u001c\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050>H\u0096@¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020;2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\n \u001f*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/NeboBackend;", "Lcom/myscript/nebo/account/backend/Backend;", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "sharedPreferences", "Landroid/content/SharedPreferences;", "neboNetworkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "backendApi", "Lcom/myscript/nebo/account/backend/NeboBackendApi;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/myscript/nebo/sso/model/UserData;Landroid/content/SharedPreferences;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/account/backend/NeboBackendApi;Lcom/myscript/nebo/log/TechnicalLogger;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "<set-?>", "appUserId", "getAppUserId", "()Ljava/lang/String;", "setAppUserId", "(Ljava/lang/String;)V", "appUserId$delegate", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "neboBackendApi", "kotlin.jvm.PlatformType", "getNeboAccount", "Lcom/myscript/nebo/account/backend/entity/NeboAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPurchase", "Lcom/myscript/nebo/account/backend/entity/InAppPurchaseResponse;", "token", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "productId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagLegacyPurchase", "setValue", "Lkotlin/Result;", SubscriberAttributeKt.JSON_NAME_KEY, "value", "writeOnce", "", "forceCacheFallback", "setValue-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValue", "Lcom/myscript/nebo/account/backend/entity/KeyValue;", "cachePolicy", "Lcom/myscript/nebo/account/backend/CachePolicy;", "getValue-0E7RQCE", "(Ljava/lang/String;Lcom/myscript/nebo/account/backend/CachePolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateAppUserId", "resetAppUserId", "", "resetCachedValues", UserMetadata.KEYDATA_FILENAME, "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cache", "Companion", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboBackend implements Backend {
    private static final String BACKEND_APP_USER_ID_KEY = "app_user_id";

    /* JADX INFO: renamed from: appUserId$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty appUserId;
    private final CoroutineDispatcher ioDispatcher;
    private final TechnicalLogger logger;
    private final NeboBackendApi neboBackendApi;
    private final NeboNetworkStateRepository neboNetworkStateRepository;
    private final SharedPreferences sharedPreferences;
    private final UserData userData;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(NeboBackend.class, "appUserId", "getAppUserId()Ljava/lang/String;", 0)};

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$flagLegacyPurchase$1 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {}, m1611l = {97}, m1612m = "flagLegacyPurchase", m1613n = {}, m1614nl = {98}, m1615s = {}, m1616v = 2)
    static final class C60841 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C60841(Continuation<? super C60841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBackend.this.flagLegacyPurchase(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$getAppUserId$1 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {0}, m1611l = {193}, m1612m = "getAppUserId", m1613n = {"storedAppUserId"}, m1614nl = {193}, m1615s = {"L$0"}, m1616v = 2)
    static final class C60851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C60851(Continuation<? super C60851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBackend.this.getAppUserId(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$getNeboAccount$1 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {}, m1611l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1612m = "getNeboAccount", m1613n = {}, m1614nl = {79}, m1615s = {}, m1616v = 2)
    static final class C60861 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C60861(Continuation<? super C60861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBackend.this.getNeboAccount(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$getOrCreateAppUserId$1 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {0, 1, 1}, m1611l = {176, PDFACompliance.e_PDFA1_8_1}, m1612m = "getOrCreateAppUserId", m1613n = {"storedAppUserId", "storedAppUserId", "currentAppUserId"}, m1614nl = {176, PDFACompliance.e_PDFA1_8_4}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 2)
    static final class C60871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C60871(Continuation<? super C60871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBackend.this.getOrCreateAppUserId(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$sendPurchase$1 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend", m1609f = "NeboBackend.kt", m1610i = {0, 0, 0}, m1611l = {88}, m1612m = "sendPurchase", m1613n = {"token", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "productId"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C60901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C60901(Continuation<? super C60901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NeboBackend.this.sendPurchase(null, null, null, this);
        }
    }

    public NeboBackend(OkHttpClient httpClient, String baseUrl, UserData userData, SharedPreferences sharedPreferences, NeboNetworkStateRepository neboNetworkStateRepository, NeboBackendApi neboBackendApi, TechnicalLogger technicalLogger, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(neboNetworkStateRepository, "neboNetworkStateRepository");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.userData = userData;
        this.sharedPreferences = sharedPreferences;
        this.neboNetworkStateRepository = neboNetworkStateRepository;
        this.logger = technicalLogger;
        this.ioDispatcher = ioDispatcher;
        this.appUserId = SharedPreferencesExtKt.nullableStringPref(sharedPreferences, BACKEND_APP_USER_ID_KEY, null);
        this.neboBackendApi = neboBackendApi == null ? (NeboBackendApi) new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(NeboBackendApi.class) : neboBackendApi;
    }

    public final TechnicalLogger getLogger() {
        return this.logger;
    }

    public /* synthetic */ NeboBackend(OkHttpClient okHttpClient, String str, UserData userData, SharedPreferences sharedPreferences, NeboNetworkStateRepository neboNetworkStateRepository, NeboBackendApi neboBackendApi, TechnicalLogger technicalLogger, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, str, userData, sharedPreferences, neboNetworkStateRepository, (i & 32) != 0 ? null : neboBackendApi, (i & 64) != 0 ? null : technicalLogger, (i & 128) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    private final String getAppUserId() {
        return this.appUserId.getValue((Object) this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppUserId(String str) {
        this.appUserId.setValue2((Object) this, $$delegatedProperties[0], str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getNeboAccount(Continuation<? super NeboAccount> continuation) {
        C60861 c60861;
        if (continuation instanceof C60861) {
            c60861 = (C60861) continuation;
            if ((c60861.label & Integer.MIN_VALUE) != 0) {
                c60861.label -= Integer.MIN_VALUE;
            } else {
                c60861 = new C60861(continuation);
            }
        }
        Object user = c60861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60861.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(user);
                if (!this.userData.hasUser()) {
                    return null;
                }
                NeboBackendApi neboBackendApi = this.neboBackendApi;
                c60861.label = 1;
                user = neboBackendApi.getUser(c60861);
                if (user == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(user);
            }
            return (NeboAccount) user;
        } catch (Exception e) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Failed getting account", e));
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendPurchase(String str, String str2, String str3, Continuation<? super InAppPurchaseResponse> continuation) {
        C60901 c60901;
        if (continuation instanceof C60901) {
            c60901 = (C60901) continuation;
            if ((c60901.label & Integer.MIN_VALUE) != 0) {
                c60901.label -= Integer.MIN_VALUE;
            } else {
                c60901 = new C60901(continuation);
            }
        }
        Object objSendPurchase = c60901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60901.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objSendPurchase);
                NeboBackendApi neboBackendApi = this.neboBackendApi;
                InAppPurchasePayload inAppPurchasePayload = new InAppPurchasePayload(str, str2, str3);
                c60901.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c60901.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c60901.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                c60901.label = 1;
                objSendPurchase = neboBackendApi.sendPurchase(inAppPurchasePayload, c60901);
                if (objSendPurchase == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objSendPurchase);
            }
            return (InAppPurchaseResponse) objSendPurchase;
        } catch (Exception e) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger == null) {
                return null;
            }
            technicalLogger.logError(new RuntimeException("Failed sending purchase", e));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flagLegacyPurchase(Continuation<? super InAppPurchaseResponse> continuation) {
        C60841 c60841;
        if (continuation instanceof C60841) {
            c60841 = (C60841) continuation;
            if ((c60841.label & Integer.MIN_VALUE) != 0) {
                c60841.label -= Integer.MIN_VALUE;
            } else {
                c60841 = new C60841(continuation);
            }
        }
        Object objFlagLegacyPurchase = c60841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60841.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objFlagLegacyPurchase);
                NeboBackendApi neboBackendApi = this.neboBackendApi;
                c60841.label = 1;
                objFlagLegacyPurchase = neboBackendApi.flagLegacyPurchase(c60841);
                if (objFlagLegacyPurchase == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objFlagLegacyPurchase);
            }
            return (InAppPurchaseResponse) objFlagLegacyPurchase;
        } catch (Exception e) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger == null) {
                return null;
            }
            technicalLogger.logError(new RuntimeException("Failed flagging legacy purchase", e));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x00c9, TryCatch #1 {all -> 0x00c9, blocks: (B:29:0x00ab, B:31:0x00b5, B:35:0x00c1, B:36:0x00c4), top: B:53:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /* JADX INFO: renamed from: setValue-yxL6bBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12809setValueyxL6bBk(String str, String str2, boolean z, boolean z2, Continuation<? super Result<String>> continuation) {
        NeboBackend$setValue$1 neboBackend$setValue$1;
        String str3;
        Throwable th;
        Object obj;
        boolean z3;
        boolean z4;
        String str4;
        NeboBackend neboBackend;
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Map map;
        String str5;
        if (continuation instanceof NeboBackend$setValue$1) {
            neboBackend$setValue$1 = (NeboBackend$setValue$1) continuation;
            if ((neboBackend$setValue$1.label & Integer.MIN_VALUE) != 0) {
                neboBackend$setValue$1.label -= Integer.MIN_VALUE;
            } else {
                neboBackend$setValue$1 = new NeboBackend$setValue$1(this, continuation);
            }
        }
        Object obj2 = neboBackend$setValue$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBackend$setValue$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                Result.Companion companion = Result.INSTANCE;
                NeboBackend neboBackend2 = this;
                boolean z5 = this.neboNetworkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected;
                if (!z5) {
                    if (z2) {
                        cache(str, str2);
                    }
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m14499constructorimpl(ResultKt.createFailure(new IllegalStateException("No internet access")));
                }
                NeboBackendApi neboBackendApi = this.neboBackendApi;
                Map<String, KeyValueParameters> mapMapOf = MapsKt.mapOf(TuplesKt.m1606to(str, new KeyValueParameters(str2, z)));
                neboBackend$setValue$1.L$0 = str;
                neboBackend$setValue$1.L$1 = str2;
                neboBackend$setValue$1.L$2 = this;
                neboBackend$setValue$1.Z$0 = z;
                neboBackend$setValue$1.Z$1 = z2;
                neboBackend$setValue$1.I$0 = 0;
                neboBackend$setValue$1.I$1 = z5 ? 1 : 0;
                neboBackend$setValue$1.label = 1;
                Object value = neboBackendApi.setValue(mapMapOf, neboBackend$setValue$1);
                if (value == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = value;
                z3 = z2;
                z4 = z;
                str4 = str2;
                neboBackend = this;
                map = (Map) ((Response) obj).body();
                if (map != null) {
                    str5 = "";
                    if (z4) {
                    }
                    objM14499constructorimpl = Result.m14499constructorimpl(str5);
                }
            } catch (Throwable th2) {
                str3 = str;
                th = th2;
                Result.Companion companion3 = Result.INSTANCE;
                str4 = str2;
                z3 = z2;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                str = str3;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                if (thM14502exceptionOrNullimpl != null) {
                }
                return objM14499constructorimpl;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = neboBackend$setValue$1.I$1;
            int i3 = neboBackend$setValue$1.I$0;
            z2 = neboBackend$setValue$1.Z$1;
            boolean z6 = neboBackend$setValue$1.Z$0;
            NeboBackend neboBackend3 = (NeboBackend) neboBackend$setValue$1.L$2;
            str2 = (String) neboBackend$setValue$1.L$1;
            str3 = (String) neboBackend$setValue$1.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                neboBackend = neboBackend3;
                str = str3;
                obj = obj2;
                z3 = z2;
                z4 = z6;
                str4 = str2;
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion32 = Result.INSTANCE;
                str4 = str2;
                z3 = z2;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                str = str3;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                if (thM14502exceptionOrNullimpl != null) {
                }
                return objM14499constructorimpl;
            }
            try {
                map = (Map) ((Response) obj).body();
                if (map != null || (str5 = (String) map.get(str)) == null) {
                    str5 = "";
                }
                if (z4) {
                    neboBackend.cache(str, str5);
                }
                objM14499constructorimpl = Result.m14499constructorimpl(str5);
            } catch (Throwable th4) {
                str3 = str;
                th = th4;
                str2 = str4;
                z2 = z3;
                Result.Companion companion322 = Result.INSTANCE;
                str4 = str2;
                z3 = z2;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                str = str3;
            }
        }
        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Failed setting '" + str + "' value in backend", thM14502exceptionOrNullimpl));
            }
            if (z3) {
                cache(str, str4);
            }
        }
        return objM14499constructorimpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /* JADX INFO: renamed from: getValue-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12808getValue0E7RQCE(String str, CachePolicy cachePolicy, Continuation<? super Result<KeyValue>> continuation) {
        NeboBackend$getValue$1 neboBackend$getValue$1;
        String str2;
        Throwable th;
        IllegalStateException illegalStateException;
        Object objM14499constructorimpl;
        NeboBackend neboBackend;
        Object objM14499constructorimpl2;
        Object objM14499constructorimpl3;
        KeyValue keyValue;
        String value;
        if (continuation instanceof NeboBackend$getValue$1) {
            neboBackend$getValue$1 = (NeboBackend$getValue$1) continuation;
            if ((neboBackend$getValue$1.label & Integer.MIN_VALUE) != 0) {
                neboBackend$getValue$1.label -= Integer.MIN_VALUE;
            } else {
                neboBackend$getValue$1 = new NeboBackend$getValue$1(this, continuation);
            }
        }
        Object value2 = neboBackend$getValue$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = neboBackend$getValue$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(value2);
            try {
                Result.Companion companion = Result.INSTANCE;
                NeboBackend neboBackend2 = this;
                boolean z = this.neboNetworkStateRepository.getNeboNetworkState().getValue() instanceof NeboNetworkState.Connected;
                int i2 = ((z || cachePolicy != CachePolicy.FromCacheIfOffline) && cachePolicy != CachePolicy.FromCacheIfAvailable) ? 0 : 1;
                if (i2 != 0) {
                    String string = this.sharedPreferences.getString(str, null);
                    String str3 = string;
                    if (str3 != null && !StringsKt.isBlank(str3)) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m14499constructorimpl(new KeyValue(str, string));
                    }
                }
                if (this.userData.hasUser() && z) {
                    NeboBackendApi neboBackendApi = this.neboBackendApi;
                    neboBackend$getValue$1.L$0 = str;
                    neboBackend$getValue$1.L$1 = SpillingKt.nullOutSpilledVariable(cachePolicy);
                    neboBackend$getValue$1.L$2 = this;
                    neboBackend$getValue$1.I$0 = 0;
                    neboBackend$getValue$1.I$1 = z ? 1 : 0;
                    neboBackend$getValue$1.I$2 = i2;
                    neboBackend$getValue$1.label = 1;
                    value2 = neboBackendApi.getValue(str, neboBackend$getValue$1);
                    if (value2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    neboBackend = this;
                    keyValue = (KeyValue) value2;
                    value = keyValue.getValue();
                    if (value != null) {
                        neboBackend.cache(str, keyValue.getValue());
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(keyValue);
                    objM14499constructorimpl2 = Result.m14499constructorimpl(Result.m14498boximpl(objM14499constructorimpl));
                } else {
                    if (!z) {
                        illegalStateException = new IllegalStateException("Trying to fetch a value from server without internet");
                    } else {
                        illegalStateException = new IllegalStateException("Trying to fetch a value from server without user");
                    }
                    Result.Companion companion4 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(illegalStateException));
                    objM14499constructorimpl2 = Result.m14499constructorimpl(Result.m14498boximpl(objM14499constructorimpl));
                }
            } catch (Throwable th2) {
                str2 = str;
                th = th2;
                Result.Companion companion5 = Result.INSTANCE;
                String str4 = str2;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(th));
                str = str4;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = neboBackend$getValue$1.I$2;
            int i4 = neboBackend$getValue$1.I$1;
            int i5 = neboBackend$getValue$1.I$0;
            NeboBackend neboBackend3 = (NeboBackend) neboBackend$getValue$1.L$2;
            str2 = (String) neboBackend$getValue$1.L$0;
            try {
                ResultKt.throwOnFailure(value2);
                neboBackend = neboBackend3;
                str = str2;
                keyValue = (KeyValue) value2;
                value = keyValue.getValue();
                if (value != null && !StringsKt.isBlank(value)) {
                    neboBackend.cache(str, keyValue.getValue());
                }
                Result.Companion companion32 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(keyValue);
                objM14499constructorimpl2 = Result.m14499constructorimpl(Result.m14498boximpl(objM14499constructorimpl));
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion52 = Result.INSTANCE;
                String str42 = str2;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(th));
                str = str42;
            }
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
        if (thM14502exceptionOrNullimpl != null) {
            if ((thM14502exceptionOrNullimpl instanceof HttpException) && ((HttpException) thM14502exceptionOrNullimpl).code() == 404) {
                Result.Companion companion6 = Result.INSTANCE;
                objM14499constructorimpl3 = Result.m14499constructorimpl(new KeyValue(str, ""));
            } else {
                TechnicalLogger technicalLogger = this.logger;
                if (technicalLogger != null) {
                    technicalLogger.logError(new RuntimeException("Failed getting '" + str + "' value in backend", thM14502exceptionOrNullimpl));
                }
                Result.Companion companion7 = Result.INSTANCE;
                objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
            objM14499constructorimpl2 = Result.m14498boximpl(objM14499constructorimpl3);
        }
        return ((Result) objM14499constructorimpl2).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getOrCreateAppUserId(Continuation<? super String> continuation) {
        C60871 c60871;
        String str;
        Object value;
        String value2;
        String str2;
        if (continuation instanceof C60871) {
            c60871 = (C60871) continuation;
            if ((c60871.label & Integer.MIN_VALUE) != 0) {
                c60871.label -= Integer.MIN_VALUE;
            } else {
                c60871 = new C60871(continuation);
            }
        }
        C60871 c608712 = c60871;
        Object obj = c608712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c608712.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String appUserId = getAppUserId();
            String str3 = appUserId;
            if (str3 == null || StringsKt.isBlank(str3)) {
                c608712.L$0 = SpillingKt.nullOutSpilledVariable(appUserId);
                c608712.label = 1;
                Object objM12806getValue0E7RQCE$default = Backend.m12806getValue0E7RQCE$default(this, BACKEND_APP_USER_ID_KEY, null, c608712, 2, null);
                if (objM12806getValue0E7RQCE$default != coroutine_suspended) {
                    str = appUserId;
                    value = objM12806getValue0E7RQCE$default;
                }
                return coroutine_suspended;
            }
            return getAppUserId();
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c608712.L$1;
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
            value2 = str2;
            setAppUserId(value2);
            return getAppUserId();
        }
        str = (String) c608712.L$0;
        ResultKt.throwOnFailure(obj);
        value = ((Result) obj).getValue();
        if (Result.m14505isFailureimpl(value)) {
            value = null;
        }
        KeyValue keyValue = (KeyValue) value;
        value2 = keyValue != null ? keyValue.getValue() : null;
        String str4 = value2;
        if (str4 == null || StringsKt.isBlank(str4)) {
            String string = UUID.randomUUID().toString();
            c608712.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c608712.L$1 = string;
            c608712.label = 2;
            if (Backend.m12807setValueyxL6bBk$default(this, BACKEND_APP_USER_ID_KEY, string, true, false, c608712, 8, null) != coroutine_suspended) {
                str2 = string;
                value2 = str2;
            }
            return coroutine_suspended;
        }
        setAppUserId(value2);
        return getAppUserId();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.Backend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAppUserId(Continuation<? super String> continuation) {
        C60851 c60851;
        Object objMo12808getValue0E7RQCE;
        if (continuation instanceof C60851) {
            c60851 = (C60851) continuation;
            if ((c60851.label & Integer.MIN_VALUE) != 0) {
                c60851.label -= Integer.MIN_VALUE;
            } else {
                c60851 = new C60851(continuation);
            }
        }
        Object obj = c60851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String appUserId = getAppUserId();
            String str = appUserId;
            if (str == null || StringsKt.isBlank(str)) {
                CachePolicy cachePolicy = CachePolicy.FromCacheIfAvailable;
                c60851.L$0 = SpillingKt.nullOutSpilledVariable(appUserId);
                c60851.label = 1;
                objMo12808getValue0E7RQCE = mo12808getValue0E7RQCE(BACKEND_APP_USER_ID_KEY, cachePolicy, c60851);
                if (objMo12808getValue0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return getAppUserId();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        objMo12808getValue0E7RQCE = ((Result) obj).getValue();
        if (Result.m14505isFailureimpl(objMo12808getValue0E7RQCE)) {
            objMo12808getValue0E7RQCE = null;
        }
        KeyValue keyValue = (KeyValue) objMo12808getValue0E7RQCE;
        setAppUserId(keyValue != null ? keyValue.getValue() : null);
        return getAppUserId();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$resetAppUserId$2 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend$resetAppUserId$2", m1609f = "NeboBackend.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C60882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60882(Continuation<? super C60882> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBackend.this.new C60882(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60882) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NeboBackend.this.setAppUserId("");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.myscript.nebo.account.backend.Backend
    public Object resetAppUserId(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C60882(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.NeboBackend$resetCachedValues$2 */
    /* JADX INFO: compiled from: NeboBackend.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.NeboBackend$resetCachedValues$2", m1609f = "NeboBackend.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C60892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $keys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60892(List<String> list, Continuation<? super C60892> continuation) {
            super(2, continuation);
            this.$keys = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboBackend.this.new C60892(this.$keys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SharedPreferences.Editor editorEdit = NeboBackend.this.sharedPreferences.edit();
                Iterator<T> it = this.$keys.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.myscript.nebo.account.backend.Backend
    public Object resetCachedValues(List<String> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C60892(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void cache(String key, String value) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(key, value);
        editorEdit.apply();
    }
}
