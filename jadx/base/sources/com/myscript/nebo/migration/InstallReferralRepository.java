package com.myscript.nebo.migration;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.NullableStringSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.migration.ReferrerResult;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InstallReferralRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010 \u001a\u00020\rH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020\u0015H\u0002J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001d\u0010\u0010¨\u0006+"}, m1599d2 = {"Lcom/myscript/nebo/migration/InstallReferralRepository;", "Lcom/myscript/nebo/migration/IInstallReferralRepository;", "prefs", "Landroid/content/SharedPreferences;", "referrerSource", "Lcom/myscript/nebo/migration/InstallReferrerSource;", "installerSource", "Lcom/myscript/nebo/migration/InstallerPackageSource;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Landroid/content/SharedPreferences;Lcom/myscript/nebo/migration/InstallReferrerSource;Lcom/myscript/nebo/migration/InstallerPackageSource;Lcom/myscript/nebo/log/TechnicalLogger;)V", "<set-?>", "", "referrerChecked", "getReferrerChecked", "()Z", "setReferrerChecked", "(Z)V", "referrerChecked$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "", "cachedReferralSource", "getCachedReferralSource", "()Ljava/lang/String;", "setCachedReferralSource", "(Ljava/lang/String;)V", "cachedReferralSource$delegate", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "isGalaxyStoreInstall", "isGalaxyStoreInstall$delegate", "Lkotlin/Lazy;", "isLenovoReferral", "referralSource", "installSource", "resolveReferral", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractUtmSource", NeboUserProfileManager.CUSTOM_ATTRIBUTE_REFERRER_KEY, "markChecked", FirebaseAnalytics.Param.SOURCE, "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstallReferralRepository implements IInstallReferralRepository {
    private static final String GALAXY_STORE_PACKAGE = "com.sec.android.app.samsungapps";
    public static final String GALAXY_STORE_SOURCE = "galaxy_store";
    public static final String LENOVO_REFERRAL_SOURCE = "nebo_for_lenovo";
    public static final String PREFS_NAME = "lenovo_referral_prefs";
    public static final String PREF_REFERRAL_SOURCE = "pref_lenovo_referral_source";
    public static final String PREF_REFERRER_CHECKED = "pref_install_referrer_checked";
    private static final String UTM_SOURCE_PARAM = "utm_source";

    /* JADX INFO: renamed from: cachedReferralSource$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty cachedReferralSource;
    private final InstallerPackageSource installerSource;

    /* JADX INFO: renamed from: isGalaxyStoreInstall$delegate, reason: from kotlin metadata */
    private final Lazy isGalaxyStoreInstall;
    private final TechnicalLogger logger;
    private final SharedPreferences prefs;

    /* JADX INFO: renamed from: referrerChecked$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty referrerChecked;
    private final InstallReferrerSource referrerSource;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(InstallReferralRepository.class, "referrerChecked", "getReferrerChecked()Z", 0), new MutablePropertyReference1Impl(InstallReferralRepository.class, "cachedReferralSource", "getCachedReferralSource()Ljava/lang/String;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.migration.InstallReferralRepository$resolveReferral$1 */
    /* JADX INFO: compiled from: InstallReferralRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.InstallReferralRepository", m1609f = "InstallReferralRepository.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m1612m = "resolveReferral", m1613n = {}, m1614nl = {56}, m1615s = {}, m1616v = 2)
    static final class C66271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C66271(Continuation<? super C66271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InstallReferralRepository.this.resolveReferral(this);
        }
    }

    public InstallReferralRepository(SharedPreferences prefs, InstallReferrerSource referrerSource, InstallerPackageSource installerSource, TechnicalLogger technicalLogger) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(referrerSource, "referrerSource");
        Intrinsics.checkNotNullParameter(installerSource, "installerSource");
        this.prefs = prefs;
        this.referrerSource = referrerSource;
        this.installerSource = installerSource;
        this.logger = technicalLogger;
        this.referrerChecked = SharedPreferencesExtKt.booleanPref$default(prefs, PREF_REFERRER_CHECKED, false, 2, null);
        this.cachedReferralSource = SharedPreferencesExtKt.nullableStringPref$default(prefs, PREF_REFERRAL_SOURCE, null, 2, null);
        this.isGalaxyStoreInstall = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.migration.InstallReferralRepository$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(InstallReferralRepository.isGalaxyStoreInstall_delegate$lambda$0(this.f$0));
            }
        });
    }

    public /* synthetic */ InstallReferralRepository(SharedPreferences sharedPreferences, InstallReferrerSource installReferrerSource, InstallerPackageSource installerPackageSource, TechnicalLogger technicalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, installReferrerSource, installerPackageSource, (i & 8) != 0 ? null : technicalLogger);
    }

    private final boolean getReferrerChecked() {
        return this.referrerChecked.getValue((Object) this, $$delegatedProperties[0]).booleanValue();
    }

    private final void setReferrerChecked(boolean z) {
        this.referrerChecked.setValue(this, $$delegatedProperties[0], z);
    }

    private final String getCachedReferralSource() {
        return this.cachedReferralSource.getValue((Object) this, $$delegatedProperties[1]);
    }

    private final void setCachedReferralSource(String str) {
        this.cachedReferralSource.setValue2((Object) this, $$delegatedProperties[1], str);
    }

    private final boolean isGalaxyStoreInstall() {
        return ((Boolean) this.isGalaxyStoreInstall.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isGalaxyStoreInstall_delegate$lambda$0(InstallReferralRepository installReferralRepository) {
        return Intrinsics.areEqual(installReferralRepository.installerSource.installerPackage(), GALAXY_STORE_PACKAGE);
    }

    @Override // com.myscript.nebo.migration.IInstallReferralRepository
    public boolean isLenovoReferral() {
        return referralSource() != null;
    }

    @Override // com.myscript.nebo.migration.IInstallReferralRepository
    public String referralSource() {
        return getCachedReferralSource();
    }

    @Override // com.myscript.nebo.migration.IInstallReferralRepository
    public String installSource() {
        String cachedReferralSource = getCachedReferralSource();
        if (cachedReferralSource != null) {
            return cachedReferralSource;
        }
        if (isGalaxyStoreInstall()) {
            return GALAXY_STORE_SOURCE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.migration.IInstallReferralRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolveReferral(Continuation<? super Unit> continuation) {
        C66271 c66271;
        if (continuation instanceof C66271) {
            c66271 = (C66271) continuation;
            if ((c66271.label & Integer.MIN_VALUE) != 0) {
                c66271.label -= Integer.MIN_VALUE;
            } else {
                c66271 = new C66271(continuation);
            }
        }
        Object objQuery = c66271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c66271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQuery);
            if (getReferrerChecked()) {
                return Unit.INSTANCE;
            }
            InstallReferrerSource installReferrerSource = this.referrerSource;
            c66271.label = 1;
            objQuery = installReferrerSource.query(c66271);
            if (objQuery == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQuery);
        }
        ReferrerResult referrerResult = (ReferrerResult) objQuery;
        if (referrerResult instanceof ReferrerResult.Resolved) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logTrace("Install referrer: " + ((ReferrerResult.Resolved) referrerResult).getReferrer());
            }
            String referrer = ((ReferrerResult.Resolved) referrerResult).getReferrer();
            String str = null;
            String strExtractUtmSource = referrer != null ? extractUtmSource(referrer) : null;
            if (strExtractUtmSource != null && Intrinsics.areEqual(strExtractUtmSource, LENOVO_REFERRAL_SOURCE)) {
                str = strExtractUtmSource;
            }
            markChecked(str);
        } else {
            if (!Intrinsics.areEqual(referrerResult, ReferrerResult.Transient.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            TechnicalLogger technicalLogger2 = this.logger;
            if (technicalLogger2 != null) {
                technicalLogger2.logTrace("Install referrer unavailable; will retry on next launch");
            }
        }
        return Unit.INSTANCE;
    }

    private final String extractUtmSource(String referrer) {
        Object objM14499constructorimpl;
        Object next;
        String str;
        try {
            Result.Companion companion = Result.INSTANCE;
            InstallReferralRepository installReferralRepository = this;
            Iterator it = SequencesKt.map(CollectionsKt.asSequence(StringsKt.split$default((CharSequence) referrer, new String[]{"&"}, false, 0, 6, (Object) null)), new Function1() { // from class: com.myscript.nebo.migration.InstallReferralRepository$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InstallReferralRepository.extractUtmSource$lambda$0$0((String) obj);
                }
            }).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(CollectionsKt.getOrNull((List) next, 0), UTM_SOURCE_PARAM)) {
                    break;
                }
            }
            List list = (List) next;
            objM14499constructorimpl = Result.m14499constructorimpl((list == null || (str = (String) CollectionsKt.getOrNull(list, 1)) == null) ? null : URLDecoder.decode(str, "UTF-8"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m14505isFailureimpl(objM14499constructorimpl) ? null : objM14499constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List extractUtmSource$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.split$default((CharSequence) it, new String[]{"="}, false, 2, 2, (Object) null);
    }

    private final void markChecked(String source) {
        setCachedReferralSource(source);
        setReferrerChecked(true);
    }

    /* JADX INFO: compiled from: InstallReferralRepository.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/migration/InstallReferralRepository$Companion;", "", "<init>", "()V", "LENOVO_REFERRAL_SOURCE", "", "GALAXY_STORE_SOURCE", "GALAXY_STORE_PACKAGE", "UTM_SOURCE_PARAM", "PREFS_NAME", "PREF_REFERRER_CHECKED", "PREF_REFERRAL_SOURCE", "create", "Lcom/myscript/nebo/migration/InstallReferralRepository;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ InstallReferralRepository create$default(Companion companion, Context context, TechnicalLogger technicalLogger, int i, Object obj) {
            if ((i & 2) != 0) {
                technicalLogger = null;
            }
            return companion.create(context, technicalLogger);
        }

        public final InstallReferralRepository create(Context context, TechnicalLogger logger) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(InstallReferralRepository.PREFS_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return new InstallReferralRepository(sharedPreferences, new PlayInstallReferrerSource(context), new PackageManagerInstallerSource(context), logger);
        }
    }
}
