package com.revenuecat.purchases;

import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.RestoreStrings;
import com.revenuecat.purchases.utils.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: PostPendingTransactionsHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J`\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u00142\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bH\u0002J\\\u0010\u001d\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120#2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120\u001bH\u0002J&\u0010$\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;Lcom/revenuecat/purchases/PostReceiptHelper;)V", "callCompletionFromResults", "", "transactionsToSync", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "results", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "Lkotlin/Function1;", "onSuccess", "postTransactionsWithCompletion", "allowSharingPlayStoreAccount", "", "appUserID", "", "onNoTransactionsToSync", "Lkotlin/Function0;", "syncPendingPurchaseQueue", "callback", "Lcom/revenuecat/purchases/SyncPendingPurchaseResult;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PostPendingTransactionsHelper {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;

    public PostPendingTransactionsHelper(AppConfig appConfig, DeviceCache deviceCache, BillingAbstract billing, Dispatcher dispatcher, IdentityManager identityManager, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostReceiptHelper postReceiptHelper) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        this.appConfig = appConfig;
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dispatcher = dispatcher;
        this.identityManager = identityManager;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postReceiptHelper = postReceiptHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncPendingPurchaseQueue$default(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        postPendingTransactionsHelper.syncPendingPurchaseQueue(z, function1);
    }

    public final void syncPendingPurchaseQueue(final boolean allowSharingPlayStoreAccount, final Function1<? super SyncPendingPurchaseResult, Unit> callback) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Updating pending purchase queue";
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.mo1541d("[Purchases] - " + logLevel.name(), function0.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler4.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.mo1541d("[Purchases] - " + logLevel4.name(), function0.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.mo1541d("[Purchases] - " + logLevel6.name(), function0.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.mo1541d("[Purchases] - " + logLevel7.name(), function0.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler11.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
            final String currentAppUserID = this.identityManager.getCurrentAppUserID();
            Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PostPendingTransactionsHelper.syncPendingPurchaseQueue$lambda$2(this.f$0, currentAppUserID, allowSharingPlayStoreAccount, callback);
                }
            }, null, 2, null);
            return;
        }
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Skipping automatic synchronization.";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                LogLevel logLevel11 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    str = "[Purchases] - " + logLevel11.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler12.mo1545w("[Purchases] - " + logLevel12.name(), function02.invoke());
                }
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler13.mo1543i("[Purchases] - " + logLevel13.name(), function02.invoke());
                }
                break;
            case 5:
                LogLevel logLevel14 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    str = "[Purchases] - " + logLevel14.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler14.mo1543i("[Purchases] - " + logLevel15.name(), function02.invoke());
                }
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    str = "[Purchases] - " + logLevel16.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    str = "[Purchases] - " + logLevel17.name();
                    strInvoke = function02.invoke();
                    currentLogHandler.mo1541d(str, strInvoke);
                }
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.mo1545w("[Purchases] - " + logLevel18.name(), function02.invoke());
                }
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.mo1545w("[Purchases] - " + logLevel19.name(), function02.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.mo1545w("[Purchases] - " + logLevel20.name(), function02.invoke());
                }
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function02.invoke(), null);
                break;
        }
        if (callback != null) {
            callback.invoke(SyncPendingPurchaseResult.AutoSyncDisabled.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncPendingPurchaseQueue$lambda$2(final PostPendingTransactionsHelper postPendingTransactionsHelper, final String str, final boolean z, final Function1 function1) {
        postPendingTransactionsHelper.billing.queryPurchases(str, new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreTransaction> map) {
                invoke2((Map<String, StoreTransaction>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, StoreTransaction> purchasesByHashedToken) {
                LogHandler currentLogHandler;
                String str2;
                String strInvoke;
                Intrinsics.checkNotNullParameter(purchasesByHashedToken, "purchasesByHashedToken");
                for (Map.Entry<String, StoreTransaction> entry : purchasesByHashedToken.entrySet()) {
                    final String key = entry.getKey();
                    final StoreTransaction value = entry.getValue();
                    final LogIntent logIntent = LogIntent.DEBUG;
                    Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$invoke$lambda$1$$inlined$log$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(TokenParser.f2383SP);
                            String str3 = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_HASH, Arrays.copyOf(new Object[]{value.getType(), key}, 2));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            return sbAppend.append(str3).toString();
                        }
                    };
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                        case 1:
                            LogLevel logLevel = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                str2 = "[Purchases] - " + logLevel.name();
                                strInvoke = function0.invoke();
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                            continue;
                        case 3:
                            LogLevel logLevel2 = LogLevel.WARN;
                            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 4:
                            LogLevel logLevel3 = LogLevel.INFO;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler3.mo1543i("[Purchases] - " + logLevel3.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 5:
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                str2 = "[Purchases] - " + logLevel4.name();
                                strInvoke = function0.invoke();
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                            continue;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler4.mo1543i("[Purchases] - " + logLevel5.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                str2 = "[Purchases] - " + logLevel6.name();
                                strInvoke = function0.invoke();
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                str2 = "[Purchases] - " + logLevel7.name();
                                strInvoke = function0.invoke();
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler5.mo1545w("[Purchases] - " + logLevel8.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler6.mo1545w("[Purchases] - " + logLevel9.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                            continue;
                        case 13:
                            LogLevel logLevel10 = LogLevel.WARN;
                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                currentLogHandler7.mo1545w("[Purchases] - " + logLevel10.name(), function0.invoke());
                            } else {
                                continue;
                            }
                            break;
                        case 14:
                            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function0.invoke(), null);
                            continue;
                    }
                    currentLogHandler.mo1541d(str2, strInvoke);
                }
                this.this$0.deviceCache.cleanPreviouslySentTokens$purchases_defaultsRelease(purchasesByHashedToken.keySet());
                List<StoreTransaction> activePurchasesNotInCache$purchases_defaultsRelease = this.this$0.deviceCache.getActivePurchasesNotInCache$purchases_defaultsRelease(purchasesByHashedToken);
                List<StoreTransaction> purchasesWithAutoRenewingChange$purchases_defaultsRelease = this.this$0.deviceCache.getPurchasesWithAutoRenewingChange$purchases_defaultsRelease(purchasesByHashedToken);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(purchasesWithAutoRenewingChange$purchases_defaultsRelease, 10));
                Iterator<T> it = purchasesWithAutoRenewingChange$purchases_defaultsRelease.iterator();
                while (it.hasNext()) {
                    arrayList.add(UtilsKt.sha1(((StoreTransaction) it.next()).getPurchaseToken()));
                }
                this.this$0.deviceCache.saveAutoRenewingStatus$purchases_defaultsRelease(MapsKt.minus((Map) purchasesByHashedToken, (Iterable) CollectionsKt.toSet(arrayList)));
                List listPlus = CollectionsKt.plus((Collection) activePurchasesNotInCache$purchases_defaultsRelease, (Iterable) purchasesWithAutoRenewingChange$purchases_defaultsRelease);
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listPlus) {
                    if (hashSet.add(((StoreTransaction) obj).getPurchaseToken())) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                Collection<StoreTransaction> collectionValues = purchasesByHashedToken.values();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : collectionValues) {
                    if (((StoreTransaction) obj2).getPurchaseState() == PurchaseState.PENDING) {
                        arrayList4.add(obj2);
                    }
                }
                ArrayList arrayList5 = arrayList4;
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                Iterator it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    arrayList6.add(((StoreTransaction) it2.next()).getPurchaseToken());
                }
                final Set set = CollectionsKt.toSet(arrayList6);
                PostPendingTransactionsHelper postPendingTransactionsHelper2 = this.this$0;
                boolean z2 = z;
                String str3 = str;
                final PostPendingTransactionsHelper postPendingTransactionsHelper3 = this.this$0;
                final String str4 = str;
                final boolean z3 = z;
                final Function1<SyncPendingPurchaseResult, Unit> function12 = function1;
                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper3.postReceiptHelper;
                        String str5 = str4;
                        boolean z4 = z3;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function13 = function12;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Function1<SyncPendingPurchaseResult, Unit> function14 = function13;
                                if (function14 != null) {
                                    function14.invoke(SyncPendingPurchaseResult.NoPendingPurchasesToSync.INSTANCE);
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function14 = function12;
                        Function1<PurchasesError, Unit> function15 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                                invoke2(purchasesError);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function16 = function14;
                                if (function16 != null) {
                                    function16.invoke(new SyncPendingPurchaseResult.Error(it3));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function12;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str5, z4, set2, function03, function15, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                                invoke2(customerInfo);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(CustomerInfo it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function17 = function16;
                                if (function17 != null) {
                                    function17.invoke(new SyncPendingPurchaseResult.Success(it3));
                                }
                            }
                        });
                    }
                };
                final PostPendingTransactionsHelper postPendingTransactionsHelper4 = this.this$0;
                final String str5 = str;
                final boolean z4 = z;
                final Function1<SyncPendingPurchaseResult, Unit> function13 = function1;
                Function1<PurchasesError, Unit> function14 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                        invoke2(purchasesError);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final PurchasesError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper4.postReceiptHelper;
                        String str6 = str5;
                        boolean z5 = z4;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function15 = function13;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                LogHandler currentLogHandler8;
                                String str7;
                                String strInvoke2;
                                final LogIntent logIntent2 = LogIntent.DEBUG;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$3$1$invoke$$inlined$log$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " No pending purchases to sync";
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel11 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                            str7 = "[Purchases] - " + logLevel11.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str7, strInvoke2);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel12 = LogLevel.WARN;
                                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel13 = LogLevel.INFO;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel14 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            str7 = "[Purchases] - " + logLevel14.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str7, strInvoke2);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel15 = LogLevel.INFO;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler11.mo1543i("[Purchases] - " + logLevel15.name(), function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel16 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            str7 = "[Purchases] - " + logLevel16.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str7, strInvoke2);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            str7 = "[Purchases] - " + logLevel17.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str7, strInvoke2);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel18 = LogLevel.WARN;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler12.mo1545w("[Purchases] - " + logLevel18.name(), function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler13.mo1545w("[Purchases] - " + logLevel19.name(), function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler14.mo1545w("[Purchases] - " + logLevel20.name(), function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                }
                                Function1<SyncPendingPurchaseResult, Unit> function16 = function15;
                                if (function16 != null) {
                                    function16.invoke(new SyncPendingPurchaseResult.Error(error));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function13;
                        Function1<PurchasesError, Unit> function17 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                                invoke2(purchasesError);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function18 = function16;
                                if (function18 != null) {
                                    function18.invoke(new SyncPendingPurchaseResult.Error(error));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function18 = function13;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str6, z5, set2, function03, function17, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                                invoke2(customerInfo);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(CustomerInfo it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function19 = function18;
                                if (function19 != null) {
                                    function19.invoke(new SyncPendingPurchaseResult.Success(it3));
                                }
                            }
                        });
                    }
                };
                final PostPendingTransactionsHelper postPendingTransactionsHelper5 = this.this$0;
                final String str6 = str;
                final boolean z5 = z;
                final Function1<SyncPendingPurchaseResult, Unit> function15 = function1;
                postPendingTransactionsHelper2.postTransactionsWithCompletion(arrayList3, z2, str3, function02, function14, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo) {
                        invoke2(customerInfo);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final CustomerInfo customerInfo) {
                        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                        PostReceiptHelper postReceiptHelper = postPendingTransactionsHelper5.postReceiptHelper;
                        String str7 = str6;
                        boolean z6 = z5;
                        Set<String> set2 = set;
                        final Function1<SyncPendingPurchaseResult, Unit> function16 = function15;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                LogHandler currentLogHandler8;
                                String str8;
                                String strInvoke2;
                                final LogIntent logIntent2 = LogIntent.DEBUG;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$1$4$1$invoke$$inlined$log$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " No pending purchases to sync";
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel11 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                            str8 = "[Purchases] - " + logLevel11.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str8, strInvoke2);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel12 = LogLevel.WARN;
                                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                            currentLogHandler9.mo1545w("[Purchases] - " + logLevel12.name(), function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel13 = LogLevel.INFO;
                                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                            currentLogHandler10.mo1543i("[Purchases] - " + logLevel13.name(), function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel14 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                            str8 = "[Purchases] - " + logLevel14.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str8, strInvoke2);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel15 = LogLevel.INFO;
                                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                            currentLogHandler11.mo1543i("[Purchases] - " + logLevel15.name(), function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel16 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                            str8 = "[Purchases] - " + logLevel16.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str8, strInvoke2);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel17 = LogLevel.DEBUG;
                                        currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                            str8 = "[Purchases] - " + logLevel17.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler8.mo1541d(str8, strInvoke2);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel18 = LogLevel.WARN;
                                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                            currentLogHandler12.mo1545w("[Purchases] - " + logLevel18.name(), function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel19 = LogLevel.WARN;
                                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                            currentLogHandler13.mo1545w("[Purchases] - " + logLevel19.name(), function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel20 = LogLevel.WARN;
                                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                            currentLogHandler14.mo1545w("[Purchases] - " + logLevel20.name(), function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                }
                                Function1<SyncPendingPurchaseResult, Unit> function17 = function16;
                                if (function17 != null) {
                                    function17.invoke(new SyncPendingPurchaseResult.Success(customerInfo));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function17 = function15;
                        Function1<PurchasesError, Unit> function18 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                                invoke2(purchasesError);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PurchasesError it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function19 = function17;
                                if (function19 != null) {
                                    function19.invoke(new SyncPendingPurchaseResult.Error(it3));
                                }
                            }
                        };
                        final Function1<SyncPendingPurchaseResult, Unit> function19 = function15;
                        postReceiptHelper.postRemainingCachedTransactionMetadata(str7, z6, set2, function03, function18, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.syncPendingPurchaseQueue.3.1.4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(CustomerInfo customerInfo2) {
                                invoke2(customerInfo2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(CustomerInfo it3) {
                                Intrinsics.checkNotNullParameter(it3, "it");
                                Function1<SyncPendingPurchaseResult, Unit> function110 = function19;
                                if (function110 != null) {
                                    function110.invoke(new SyncPendingPurchaseResult.Success(it3));
                                }
                            }
                        });
                    }
                });
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PurchasesError error) {
                LogHandler currentLogHandler;
                String str2;
                String strInvoke;
                Intrinsics.checkNotNullParameter(error, "error");
                final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + TokenParser.f2383SP + error.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str2 = "[Purchases] - " + logLevel.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.mo1541d(str2, strInvoke);
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
                            str2 = "[Purchases] - " + logLevel4.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.mo1541d(str2, strInvoke);
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
                            str2 = "[Purchases] - " + logLevel6.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.mo1541d(str2, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str2 = "[Purchases] - " + logLevel7.name();
                            strInvoke = function0.invoke();
                            currentLogHandler.mo1541d(str2, strInvoke);
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
                Function1<SyncPendingPurchaseResult, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(new SyncPendingPurchaseResult.Error(error));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postTransactionsWithCompletion(final List<StoreTransaction> transactionsToSync, boolean allowSharingPlayStoreAccount, String appUserID, Function0<Unit> onNoTransactionsToSync, final Function1<? super PurchasesError, Unit> onError, final Function1<? super CustomerInfo, Unit> onSuccess) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        if (!transactionsToSync.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            this.postTransactionWithProductDetailsHelper.postTransactions(transactionsToSync, allowSharingPlayStoreAccount, appUserID, PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES, false, new Function2<StoreTransaction, CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.postTransactionsWithCompletion.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    invoke2(storeTransaction, customerInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                    arrayList.add(new Result.Success(customerInfo));
                    this.callCompletionFromResults(transactionsToSync, arrayList, onError, onSuccess);
                }
            }, new Function2<StoreTransaction, PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper.postTransactionsWithCompletion.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                    invoke2(storeTransaction, purchasesError);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StoreTransaction storeTransaction, PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
                    arrayList.add(new Result.Error(purchasesError));
                    this.callCompletionFromResults(transactionsToSync, arrayList, onError, onSuccess);
                }
            });
            return;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PostPendingTransactionsHelper$postTransactionsWithCompletion$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " No pending purchases to sync";
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
        onNoTransactionsToSync.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void callCompletionFromResults$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, List list2, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.callCompletionFromResults(list, list2, function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callCompletionFromResults(List<StoreTransaction> transactionsToSync, List<? extends Result<CustomerInfo, PurchasesError>> results, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        if (transactionsToSync.size() == results.size()) {
            int i = 0;
            for (Object obj : results) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Result result = (Result) obj;
                if (result instanceof Result.Error) {
                    if (onError != null) {
                        onError.invoke(((Result.Error) result).getValue());
                        return;
                    }
                    return;
                } else {
                    if (i == results.size() - 1 && onSuccess != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        onSuccess.invoke(((Result.Success) result).getValue());
                    }
                    i = i2;
                }
            }
        }
    }
}
