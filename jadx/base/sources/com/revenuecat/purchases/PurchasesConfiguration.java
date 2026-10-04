package com.revenuecat.purchases;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.galaxy.GalaxyBillingMode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PurchasesConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u00109\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\b:J\u0013\u0010;\u001a\u00020\f2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010=\u001a\u00020>H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\f8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000eR\u0011\u0010#\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000eR\u0013\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000eR\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006@"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesConfiguration;", "", "builder", "Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "(Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;)V", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "appUserID", "getAppUserID", "automaticDeviceIdentifierCollectionEnabled", "", "getAutomaticDeviceIdentifierCollectionEnabled", "()Z", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "diagnosticsEnabled", "getDiagnosticsEnabled", "galaxyBillingMode", "Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "getGalaxyBillingMode", "()Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "iamEnabled", "getIamEnabled$purchases_defaultsRelease", "observerMode", "getObserverMode$annotations", "()V", "getObserverMode", "pendingTransactionsForPrepaidPlansEnabled", "getPendingTransactionsForPrepaidPlansEnabled", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/concurrent/ExecutorService;", "getService", "()Ljava/util/concurrent/ExecutorService;", "showInAppMessagesAutomatically", "getShowInAppMessagesAutomatically", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "verificationMode", "Lcom/revenuecat/purchases/EntitlementVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/EntitlementVerificationMode;", "copy", "copy$purchases_defaultsRelease", "equals", "other", "hashCode", "", "Builder", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public class PurchasesConfiguration {
    private final String apiKey;
    private final String appUserID;
    private final boolean automaticDeviceIdentifierCollectionEnabled;
    private final Context context;
    private final DangerousSettings dangerousSettings;
    private final boolean diagnosticsEnabled;
    private final GalaxyBillingMode galaxyBillingMode;
    private final boolean iamEnabled;
    private final boolean pendingTransactionsForPrepaidPlansEnabled;
    private final String preferredUILocaleOverride;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final ExecutorService service;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final EntitlementVerificationMode verificationMode;

    /* JADX INFO: compiled from: PurchasesConfiguration.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "observerMode is being deprecated in favor of purchasesAreCompletedBy.", replaceWith = @ReplaceWith(expression = "purchasesAreCompletedBy == MY_APP", imports = {"com.revenuecat.purchases.PurchasesAreCompletedBy.MY_APP"}))
    public static /* synthetic */ void getObserverMode$annotations() {
    }

    public PurchasesConfiguration(Builder builder) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (UtilsKt.isDeviceProtectedStorageCompat(builder.getContext())) {
            applicationContext = builder.getContext();
        } else {
            applicationContext = builder.getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "{\n                builde…tionContext\n            }");
        }
        this.context = applicationContext;
        this.apiKey = StringsKt.trim((CharSequence) builder.getApiKey()).toString();
        this.appUserID = builder.getAppUserID();
        this.purchasesAreCompletedBy = builder.getPurchasesAreCompletedBy();
        this.service = builder.getService();
        this.store = builder.getStore();
        this.diagnosticsEnabled = builder.getDiagnosticsEnabled();
        this.verificationMode = builder.getVerificationMode();
        this.dangerousSettings = builder.getDangerousSettings();
        this.showInAppMessagesAutomatically = builder.getShowInAppMessagesAutomatically();
        this.pendingTransactionsForPrepaidPlansEnabled = builder.getPendingTransactionsForPrepaidPlansEnabled();
        this.automaticDeviceIdentifierCollectionEnabled = builder.getAutomaticDeviceIdentifierCollectionEnabled();
        this.preferredUILocaleOverride = builder.getPreferredUILocaleOverride();
        this.galaxyBillingMode = builder.getGalaxyBillingMode();
        this.iamEnabled = builder.getIamEnabled();
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppUserID() {
        return this.appUserID;
    }

    public final boolean getObserverMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.purchasesAreCompletedBy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final ExecutorService getService() {
        return this.service;
    }

    public final Store getStore() {
        return this.store;
    }

    public final boolean getDiagnosticsEnabled() {
        return this.diagnosticsEnabled;
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final EntitlementVerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public final boolean getPendingTransactionsForPrepaidPlansEnabled() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final boolean getAutomaticDeviceIdentifierCollectionEnabled() {
        return this.automaticDeviceIdentifierCollectionEnabled;
    }

    public final String getPreferredUILocaleOverride() {
        return this.preferredUILocaleOverride;
    }

    public final GalaxyBillingMode getGalaxyBillingMode() {
        return this.galaxyBillingMode;
    }

    /* JADX INFO: renamed from: getIamEnabled$purchases_defaultsRelease, reason: from getter */
    public final /* synthetic */ boolean getIamEnabled() {
        return this.iamEnabled;
    }

    public static /* synthetic */ PurchasesConfiguration copy$purchases_defaultsRelease$default(PurchasesConfiguration purchasesConfiguration, String str, ExecutorService executorService, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            str = purchasesConfiguration.appUserID;
        }
        if ((i & 2) != 0) {
            executorService = purchasesConfiguration.service;
        }
        return purchasesConfiguration.copy$purchases_defaultsRelease(str, executorService);
    }

    public final PurchasesConfiguration copy$purchases_defaultsRelease(String appUserID, ExecutorService service) {
        Builder builderIamEnabled = new Builder(this.context, this.apiKey).appUserID(appUserID).purchasesAreCompletedBy(this.purchasesAreCompletedBy).store(this.store).diagnosticsEnabled(this.diagnosticsEnabled).entitlementVerificationMode(this.verificationMode).dangerousSettings(this.dangerousSettings).showInAppMessagesAutomatically(this.showInAppMessagesAutomatically).pendingTransactionsForPrepaidPlansEnabled(this.pendingTransactionsForPrepaidPlansEnabled).automaticDeviceIdentifierCollectionEnabled(this.automaticDeviceIdentifierCollectionEnabled).preferredUILocaleOverride(this.preferredUILocaleOverride).galaxyBillingMode(this.galaxyBillingMode).iamEnabled(this.iamEnabled);
        if (service != null) {
            builderIamEnabled = builderIamEnabled.service(service);
        }
        return builderIamEnabled.build();
    }

    /* JADX INFO: compiled from: PurchasesConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010I\u001a\u00020JH\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010D\u001a\u00020CJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u000eH\u0007J\u0010\u0010N\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000eH\u0007J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u0005J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000204J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u000eJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR*\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00058@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00168@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R&\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R&\u0010(\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R*\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00058@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\rR&\u0010/\u001a\u00020.2\u0006\u0010\t\u001a\u00020.8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00105\u001a\u0004\u0018\u0001042\b\u0010\t\u001a\u0004\u0018\u0001048@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010:\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010\u0013R&\u0010>\u001a\u00020=2\u0006\u0010\t\u001a\u00020=8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR&\u0010D\u001a\u00020C2\u0006\u0010\t\u001a\u00020C8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006P"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "apiKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getApiKey$purchases_defaultsRelease", "()Ljava/lang/String;", "<set-?>", "appUserID", "getAppUserID$purchases_defaultsRelease", "setAppUserID$purchases_defaultsRelease", "(Ljava/lang/String;)V", "", "automaticDeviceIdentifierCollectionEnabled", "getAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsRelease", "()Z", "setAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsRelease", "(Z)V", "getContext$purchases_defaultsRelease", "()Landroid/content/Context;", "Lcom/revenuecat/purchases/DangerousSettings;", "dangerousSettings", "getDangerousSettings$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/DangerousSettings;", "setDangerousSettings$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/DangerousSettings;)V", "diagnosticsEnabled", "getDiagnosticsEnabled$purchases_defaultsRelease", "setDiagnosticsEnabled$purchases_defaultsRelease", "Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "galaxyBillingMode", "getGalaxyBillingMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "setGalaxyBillingMode$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;)V", "iamEnabled", "getIamEnabled$purchases_defaultsRelease", "setIamEnabled$purchases_defaultsRelease", "pendingTransactionsForPrepaidPlansEnabled", "getPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsRelease", "setPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsRelease", "preferredUILocaleOverride", "getPreferredUILocaleOverride$purchases_defaultsRelease", "setPreferredUILocaleOverride$purchases_defaultsRelease", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "purchasesAreCompletedBy", "getPurchasesAreCompletedBy$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "setPurchasesAreCompletedBy$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)V", "Ljava/util/concurrent/ExecutorService;", NotificationCompat.CATEGORY_SERVICE, "getService$purchases_defaultsRelease", "()Ljava/util/concurrent/ExecutorService;", "setService$purchases_defaultsRelease", "(Ljava/util/concurrent/ExecutorService;)V", "showInAppMessagesAutomatically", "getShowInAppMessagesAutomatically$purchases_defaultsRelease", "setShowInAppMessagesAutomatically$purchases_defaultsRelease", "Lcom/revenuecat/purchases/Store;", "store", "getStore$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/Store;", "setStore$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/Store;)V", "Lcom/revenuecat/purchases/EntitlementVerificationMode;", "verificationMode", "getVerificationMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/EntitlementVerificationMode;", "setVerificationMode$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/EntitlementVerificationMode;)V", "build", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "entitlementVerificationMode", "informationalVerificationModeAndDiagnosticsEnabled", "enabled", "observerMode", "localeString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static class Builder {
        private final String apiKey;
        private String appUserID;
        private boolean automaticDeviceIdentifierCollectionEnabled;
        private final Context context;
        private DangerousSettings dangerousSettings;
        private boolean diagnosticsEnabled;
        private GalaxyBillingMode galaxyBillingMode;
        private boolean iamEnabled;
        private boolean pendingTransactionsForPrepaidPlansEnabled;
        private String preferredUILocaleOverride;
        private PurchasesAreCompletedBy purchasesAreCompletedBy;
        private ExecutorService service;
        private boolean showInAppMessagesAutomatically;
        private Store store;
        private EntitlementVerificationMode verificationMode;

        public Builder(Context context, String apiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            this.context = context;
            this.apiKey = apiKey;
            this.purchasesAreCompletedBy = PurchasesAreCompletedBy.REVENUECAT;
            this.showInAppMessagesAutomatically = true;
            this.store = Store.PLAY_STORE;
            this.verificationMode = EntitlementVerificationMode.INSTANCE.getDefault();
            this.dangerousSettings = new DangerousSettings(false, 1, null);
            this.automaticDeviceIdentifierCollectionEnabled = true;
            this.galaxyBillingMode = GalaxyBillingMode.PRODUCTION;
        }

        /* JADX INFO: renamed from: getContext$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: getApiKey$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ String getApiKey() {
            return this.apiKey;
        }

        /* JADX INFO: renamed from: getAppUserID$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ String getAppUserID() {
            return this.appUserID;
        }

        public final /* synthetic */ void setAppUserID$purchases_defaultsRelease(String str) {
            this.appUserID = str;
        }

        /* JADX INFO: renamed from: getPurchasesAreCompletedBy$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
            return this.purchasesAreCompletedBy;
        }

        public final /* synthetic */ void setPurchasesAreCompletedBy$purchases_defaultsRelease(PurchasesAreCompletedBy purchasesAreCompletedBy) {
            Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "<set-?>");
            this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        }

        /* JADX INFO: renamed from: getShowInAppMessagesAutomatically$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ boolean getShowInAppMessagesAutomatically() {
            return this.showInAppMessagesAutomatically;
        }

        public final /* synthetic */ void setShowInAppMessagesAutomatically$purchases_defaultsRelease(boolean z) {
            this.showInAppMessagesAutomatically = z;
        }

        /* JADX INFO: renamed from: getService$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ ExecutorService getService() {
            return this.service;
        }

        public final /* synthetic */ void setService$purchases_defaultsRelease(ExecutorService executorService) {
            this.service = executorService;
        }

        /* JADX INFO: renamed from: getStore$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ Store getStore() {
            return this.store;
        }

        public final /* synthetic */ void setStore$purchases_defaultsRelease(Store store) {
            Intrinsics.checkNotNullParameter(store, "<set-?>");
            this.store = store;
        }

        /* JADX INFO: renamed from: getDiagnosticsEnabled$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ boolean getDiagnosticsEnabled() {
            return this.diagnosticsEnabled;
        }

        public final /* synthetic */ void setDiagnosticsEnabled$purchases_defaultsRelease(boolean z) {
            this.diagnosticsEnabled = z;
        }

        /* JADX INFO: renamed from: getVerificationMode$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ EntitlementVerificationMode getVerificationMode() {
            return this.verificationMode;
        }

        public final /* synthetic */ void setVerificationMode$purchases_defaultsRelease(EntitlementVerificationMode entitlementVerificationMode) {
            Intrinsics.checkNotNullParameter(entitlementVerificationMode, "<set-?>");
            this.verificationMode = entitlementVerificationMode;
        }

        /* JADX INFO: renamed from: getDangerousSettings$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ DangerousSettings getDangerousSettings() {
            return this.dangerousSettings;
        }

        public final /* synthetic */ void setDangerousSettings$purchases_defaultsRelease(DangerousSettings dangerousSettings) {
            Intrinsics.checkNotNullParameter(dangerousSettings, "<set-?>");
            this.dangerousSettings = dangerousSettings;
        }

        /* JADX INFO: renamed from: getPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ boolean getPendingTransactionsForPrepaidPlansEnabled() {
            return this.pendingTransactionsForPrepaidPlansEnabled;
        }

        /* JADX INFO: renamed from: setPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsRelease */
        public final /* synthetic */ void m1549xf2b2d52b(boolean z) {
            this.pendingTransactionsForPrepaidPlansEnabled = z;
        }

        /* JADX INFO: renamed from: getAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ boolean getAutomaticDeviceIdentifierCollectionEnabled() {
            return this.automaticDeviceIdentifierCollectionEnabled;
        }

        /* JADX INFO: renamed from: setAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsRelease */
        public final /* synthetic */ void m1548xd881993f(boolean z) {
            this.automaticDeviceIdentifierCollectionEnabled = z;
        }

        /* JADX INFO: renamed from: getPreferredUILocaleOverride$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ String getPreferredUILocaleOverride() {
            return this.preferredUILocaleOverride;
        }

        public final /* synthetic */ void setPreferredUILocaleOverride$purchases_defaultsRelease(String str) {
            this.preferredUILocaleOverride = str;
        }

        /* JADX INFO: renamed from: getGalaxyBillingMode$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ GalaxyBillingMode getGalaxyBillingMode() {
            return this.galaxyBillingMode;
        }

        public final /* synthetic */ void setGalaxyBillingMode$purchases_defaultsRelease(GalaxyBillingMode galaxyBillingMode) {
            Intrinsics.checkNotNullParameter(galaxyBillingMode, "<set-?>");
            this.galaxyBillingMode = galaxyBillingMode;
        }

        /* JADX INFO: renamed from: getIamEnabled$purchases_defaultsRelease, reason: from getter */
        public final /* synthetic */ boolean getIamEnabled() {
            return this.iamEnabled;
        }

        public final /* synthetic */ void setIamEnabled$purchases_defaultsRelease(boolean z) {
            this.iamEnabled = z;
        }

        public final Builder appUserID(String appUserID) {
            this.appUserID = appUserID;
            return this;
        }

        public final Builder showInAppMessagesAutomatically(boolean showInAppMessagesAutomatically) {
            this.showInAppMessagesAutomatically = showInAppMessagesAutomatically;
            return this;
        }

        @Deprecated(message = "observerMode() is being deprecated in favor of purchasesAreCompletedBy().", replaceWith = @ReplaceWith(expression = "purchasesAreCompletedBy(if (observerMode) MY_APP else REVENUECAT)", imports = {"com.revenuecat.purchases.PurchasesAreCompletedBy.REVENUECAT", "com.revenuecat.purchases.PurchasesAreCompletedBy.MY_APP"}))
        public final Builder observerMode(boolean observerMode) {
            PurchasesAreCompletedBy purchasesAreCompletedBy;
            if (observerMode) {
                purchasesAreCompletedBy = PurchasesAreCompletedBy.MY_APP;
            } else {
                purchasesAreCompletedBy = PurchasesAreCompletedBy.REVENUECAT;
            }
            purchasesAreCompletedBy(purchasesAreCompletedBy);
            return this;
        }

        public final Builder purchasesAreCompletedBy(PurchasesAreCompletedBy purchasesAreCompletedBy) {
            Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
            this.purchasesAreCompletedBy = purchasesAreCompletedBy;
            return this;
        }

        public final Builder service(ExecutorService service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.service = service;
            return this;
        }

        public final Builder store(Store store) {
            Intrinsics.checkNotNullParameter(store, "store");
            this.store = store;
            return this;
        }

        public final Builder diagnosticsEnabled(boolean diagnosticsEnabled) {
            this.diagnosticsEnabled = diagnosticsEnabled;
            return this;
        }

        @Deprecated(message = "Use the new entitlementVerificationMode setter instead.", replaceWith = @ReplaceWith(expression = "entitlementVerificationMode(EntitlementVerificationMode.INFORMATIONAL)", imports = {}))
        public final /* synthetic */ Builder informationalVerificationModeAndDiagnosticsEnabled(boolean enabled) {
            if (enabled) {
                this.verificationMode = EntitlementVerificationMode.INFORMATIONAL;
                this.diagnosticsEnabled = true;
                return this;
            }
            this.verificationMode = EntitlementVerificationMode.DISABLED;
            this.diagnosticsEnabled = false;
            return this;
        }

        public final Builder entitlementVerificationMode(EntitlementVerificationMode verificationMode) {
            Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
            this.verificationMode = verificationMode;
            return this;
        }

        public final Builder dangerousSettings(DangerousSettings dangerousSettings) {
            Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
            this.dangerousSettings = dangerousSettings;
            return this;
        }

        public final Builder pendingTransactionsForPrepaidPlansEnabled(boolean pendingTransactionsForPrepaidPlansEnabled) {
            this.pendingTransactionsForPrepaidPlansEnabled = pendingTransactionsForPrepaidPlansEnabled;
            return this;
        }

        public final Builder automaticDeviceIdentifierCollectionEnabled(boolean automaticDeviceIdentifierCollectionEnabled) {
            this.automaticDeviceIdentifierCollectionEnabled = automaticDeviceIdentifierCollectionEnabled;
            return this;
        }

        public final Builder preferredUILocaleOverride(String localeString) {
            this.preferredUILocaleOverride = localeString;
            return this;
        }

        public final Builder galaxyBillingMode(GalaxyBillingMode galaxyBillingMode) {
            Intrinsics.checkNotNullParameter(galaxyBillingMode, "galaxyBillingMode");
            this.galaxyBillingMode = galaxyBillingMode;
            return this;
        }

        public final Builder iamEnabled(boolean iamEnabled) {
            this.iamEnabled = iamEnabled;
            return this;
        }

        public PurchasesConfiguration build() {
            return new PurchasesConfiguration(this);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.PurchasesConfiguration");
        PurchasesConfiguration purchasesConfiguration = (PurchasesConfiguration) other;
        return Intrinsics.areEqual(this.apiKey, purchasesConfiguration.apiKey) && Intrinsics.areEqual(this.appUserID, purchasesConfiguration.appUserID) && this.purchasesAreCompletedBy == purchasesConfiguration.purchasesAreCompletedBy && this.showInAppMessagesAutomatically == purchasesConfiguration.showInAppMessagesAutomatically && this.store == purchasesConfiguration.store && this.diagnosticsEnabled == purchasesConfiguration.diagnosticsEnabled && Intrinsics.areEqual(this.dangerousSettings, purchasesConfiguration.dangerousSettings) && this.verificationMode == purchasesConfiguration.verificationMode && this.pendingTransactionsForPrepaidPlansEnabled == purchasesConfiguration.pendingTransactionsForPrepaidPlansEnabled && this.automaticDeviceIdentifierCollectionEnabled == purchasesConfiguration.automaticDeviceIdentifierCollectionEnabled && Intrinsics.areEqual(this.preferredUILocaleOverride, purchasesConfiguration.preferredUILocaleOverride) && Intrinsics.areEqual(this.galaxyBillingMode, purchasesConfiguration.galaxyBillingMode) && this.iamEnabled == purchasesConfiguration.iamEnabled;
    }

    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.appUserID;
        int iHashCode2 = (((((((((((((((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.purchasesAreCompletedBy.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.diagnosticsEnabled)) * 31) + this.dangerousSettings.hashCode()) * 31) + this.verificationMode.hashCode()) * 31) + Boolean.hashCode(this.pendingTransactionsForPrepaidPlansEnabled)) * 31) + Boolean.hashCode(this.automaticDeviceIdentifierCollectionEnabled)) * 31;
        String str2 = this.preferredUILocaleOverride;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.galaxyBillingMode.hashCode()) * 31) + Boolean.hashCode(this.iamEnabled);
    }
}
