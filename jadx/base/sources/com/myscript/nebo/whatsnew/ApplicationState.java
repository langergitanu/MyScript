package com.myscript.nebo.whatsnew;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.NullableStringSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.StringSetSharedPreferencesProperty;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.crash.ICrashCountState;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApplicationState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\b\u0017\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010)\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020\fH\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0013H\u0016J\u0010\u00108\u001a\u0002092\u0006\u00107\u001a\u00020\u0013H\u0017J\u0010\u0010:\u001a\u0002092\u0006\u00107\u001a\u00020\u0013H\u0016J\u0010\u0010;\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0013H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0013H\u0016J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u001dH\u0007J\b\u0010O\u001a\u000209H\u0007J\u0006\u0010P\u001a\u000209J\u0006\u0010Q\u001a\u00020\fJ\u0006\u0010R\u001a\u000209R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R/\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001d8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010%\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u0011\u0010(\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR$\u0010+\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R$\u0010/\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R+\u00103\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R/\u0010=\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u001a\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R7\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130A2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130A8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001d0L8F¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006T"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/ApplicationState;", "Lcom/myscript/nebo/whatsnew/IWhatsNewState;", "Lcom/myscript/nebo/crash/ICrashCountState;", "Lcom/myscript/nebo/whatsnew/IPLSMigrationState;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "appPreferences", "Landroid/content/SharedPreferences;", "defaultPreferences", "<set-?>", "", "isFirstInstall", "()Z", "setFirstInstall", "(Z)V", "isFirstInstall$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "", "storedVersion", "getStoredVersion", "()Ljava/lang/String;", "setStoredVersion", "(Ljava/lang/String;)V", "storedVersion$delegate", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "freshInstall", "getFreshInstall", "", "migrationProgress", "getMigrationProgress", "()I", "setMigrationProgress", "(I)V", "migrationProgress$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "isMigrationOngoing", "setMigrationOngoing", "isMigrationOngoing$delegate", "isNeboAiAllowed", "requiresWhatsNew", "value", "crossSellNumber", "getCrossSellNumber", "setCrossSellNumber", "migrationNumber", "whatsNewNumber", "getWhatsNewNumber", "setWhatsNewNumber", "requiresPLSMigration", "isPLSMigrationDone", "setPLSMigrationDone", "isPLSMigrationDone$delegate", "getCrashCount", SubscriberAttributeKt.JSON_NAME_KEY, "incrementCrashCount", "", "resetCrashCount", "shouldFlagPageAsCorrupted", "shouldLeaveCrashingPage", "noteCrashCountKey", "getNoteCrashCountKey", "setNoteCrashCountKey", "noteCrashCountKey$delegate", "", "pagesCrashCountKeys", "getPagesCrashCountKeys", "()Ljava/util/Set;", "setPagesCrashCountKeys", "(Ljava/util/Set;)V", "pagesCrashCountKeys$delegate", "Lcom/myscript/android/utils/StringSetSharedPreferencesProperty;", "addNativeCrashToLog", "nativeCrashToLog", "nativeCrashesToLog", "", "getNativeCrashesToLog", "()Ljava/util/List;", "clearNativeCrashesToLog", "setCrashing", "wasCrashed", "clearCrash", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ApplicationState implements IWhatsNewState, ICrashCountState, IPLSMigrationState {
    private static final String APP_STATE_CRASH_COUNT_KEY = "app_state_crash_count_uuid_key";
    private static final String APP_STATE_CRASH_COUNT_KEYS = "app_state_crash_count_keys";
    private static final String APP_STATE_MIGRATION_ONGOING = "app_state_migration_ongoing";
    private static final String APP_STATE_MIGRATION_PROGRESS = "app_state_migration_progress";
    private static final String APP_STATE_PLS_MIGRATION_DONE = "app_state_pls_migration_done";
    private static final String APP_STATE_PREF_NAME = "application_state_pref";
    private static final String APP_STATE_STORE_VERSION = "app_state_store_version";
    private static final String CRASH_DETECTED_KEY = "crash_detected";
    private static final String CROSS_SELL_NUMBER_KEY = "pref_cross_sell_math_shown";
    private static final boolean DBG = false;
    private static final String IS_FIRST_INSTALL_PREF_KEY = "is_first_install_tag";
    private static final int MAX_CRASH_BEFORE_CLOSING_PAGE = 1;
    private static final int MAX_CRASH_BEFORE_CORRUPTED = 2;
    private static final String NATIVE_CRASH_TO_LOG_KEY = "native_crash_to_log";
    private static final String TAG = "ApplicationState";
    public static final int WHATS_NEW_NUMBER = 108;
    public static final String WHATS_NEW_NUMBER_KEY = "app_state_migration_number";
    private final SharedPreferences appPreferences;
    private final SharedPreferences defaultPreferences;
    private final boolean freshInstall;

    /* JADX INFO: renamed from: isFirstInstall$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isFirstInstall;

    /* JADX INFO: renamed from: isMigrationOngoing$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isMigrationOngoing;
    private final boolean isNeboAiAllowed;

    /* JADX INFO: renamed from: isPLSMigrationDone$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isPLSMigrationDone;

    /* JADX INFO: renamed from: migrationProgress$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty migrationProgress;

    /* JADX INFO: renamed from: noteCrashCountKey$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty noteCrashCountKey;

    /* JADX INFO: renamed from: pagesCrashCountKeys$delegate, reason: from kotlin metadata */
    private final StringSetSharedPreferencesProperty pagesCrashCountKeys;

    /* JADX INFO: renamed from: storedVersion$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty storedVersion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(ApplicationState.class, "isFirstInstall", "isFirstInstall()Z", 0), new MutablePropertyReference1Impl(ApplicationState.class, "storedVersion", "getStoredVersion()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(ApplicationState.class, "migrationProgress", "getMigrationProgress()I", 0), new MutablePropertyReference1Impl(ApplicationState.class, "isMigrationOngoing", "isMigrationOngoing()Z", 0), new MutablePropertyReference1Impl(ApplicationState.class, "isPLSMigrationDone", "isPLSMigrationDone()Z", 0), new MutablePropertyReference1Impl(ApplicationState.class, "noteCrashCountKey", "getNoteCrashCountKey()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(ApplicationState.class, "pagesCrashCountKeys", "getPagesCrashCountKeys()Ljava/util/Set;", 0)};
    public static final int $stable = 8;

    public ApplicationState(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        SharedPreferences sharedPreferences = application.getSharedPreferences(APP_STATE_PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.appPreferences = sharedPreferences;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.defaultPreferences = defaultSharedPreferences;
        this.isFirstInstall = SharedPreferencesExtKt.booleanPref(defaultSharedPreferences, IS_FIRST_INSTALL_PREF_KEY, true);
        this.storedVersion = SharedPreferencesExtKt.nullableStringPref(sharedPreferences, APP_STATE_STORE_VERSION, null);
        this.freshInstall = getStoredVersion() == null;
        this.migrationProgress = SharedPreferencesExtKt.intPref(sharedPreferences, APP_STATE_MIGRATION_PROGRESS, 0);
        this.isMigrationOngoing = SharedPreferencesExtKt.booleanPref(sharedPreferences, APP_STATE_MIGRATION_ONGOING, false);
        this.isNeboAiAllowed = application.getResources().getBoolean(C6079R.bool.is_ai_available_for_flavor);
        this.isPLSMigrationDone = SharedPreferencesExtKt.booleanPref(sharedPreferences, APP_STATE_PLS_MIGRATION_DONE, false);
        this.noteCrashCountKey = SharedPreferencesExtKt.nullableStringPref(sharedPreferences, APP_STATE_CRASH_COUNT_KEY, null);
        this.pagesCrashCountKeys = SharedPreferencesExtKt.stringSetPref$default(sharedPreferences, APP_STATE_CRASH_COUNT_KEYS, null, 2, null);
    }

    public final boolean isFirstInstall() {
        return this.isFirstInstall.getValue((Object) this, $$delegatedProperties[0]).booleanValue();
    }

    public final void setFirstInstall(boolean z) {
        this.isFirstInstall.setValue(this, $$delegatedProperties[0], z);
    }

    public final String getStoredVersion() {
        return this.storedVersion.getValue((Object) this, $$delegatedProperties[1]);
    }

    public final void setStoredVersion(String str) {
        this.storedVersion.setValue2((Object) this, $$delegatedProperties[1], str);
    }

    public final boolean getFreshInstall() {
        return this.freshInstall;
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public int getMigrationProgress() {
        return this.migrationProgress.getValue((Object) this, $$delegatedProperties[2]).intValue();
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public void setMigrationProgress(int i) {
        this.migrationProgress.setValue(this, $$delegatedProperties[2], i);
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public boolean isMigrationOngoing() {
        return this.isMigrationOngoing.getValue((Object) this, $$delegatedProperties[3]).booleanValue();
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public void setMigrationOngoing(boolean z) {
        this.isMigrationOngoing.setValue(this, $$delegatedProperties[3], z);
    }

    /* JADX INFO: renamed from: isNeboAiAllowed, reason: from getter */
    public final boolean getIsNeboAiAllowed() {
        return this.isNeboAiAllowed;
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public boolean requiresWhatsNew() {
        return this.isNeboAiAllowed && getWhatsNewNumber() < 108;
    }

    public final int getCrossSellNumber() {
        return this.defaultPreferences.getInt(CROSS_SELL_NUMBER_KEY, 0);
    }

    public final void setCrossSellNumber(int i) {
        SharedPreferences.Editor editorEdit = this.defaultPreferences.edit();
        editorEdit.putInt(CROSS_SELL_NUMBER_KEY, i);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public int getWhatsNewNumber() {
        int i = this.appPreferences.getInt(WHATS_NEW_NUMBER_KEY, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        setWhatsNewNumber(108);
        return 108;
    }

    @Override // com.myscript.nebo.whatsnew.IWhatsNewState
    public void setWhatsNewNumber(int i) {
        SharedPreferences.Editor editorEdit = this.appPreferences.edit();
        editorEdit.putInt(WHATS_NEW_NUMBER_KEY, i);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.whatsnew.IPLSMigrationState
    public boolean requiresPLSMigration() {
        List listSplit$default;
        String str;
        Integer numValueOf = null;
        try {
            String storedVersion = getStoredVersion();
            if (storedVersion != null && (listSplit$default = StringsKt.split$default((CharSequence) storedVersion, new char[]{'.'}, false, 0, 6, (Object) null)) != null && (str = (String) CollectionsKt.firstOrNull(listSplit$default)) != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(str));
            }
        } catch (NumberFormatException unused) {
        }
        return (isPLSMigrationDone() || numValueOf == null || numValueOf.intValue() >= 5) ? false : true;
    }

    @Override // com.myscript.nebo.whatsnew.IPLSMigrationState
    public boolean isPLSMigrationDone() {
        return this.isPLSMigrationDone.getValue((Object) this, $$delegatedProperties[4]).booleanValue();
    }

    @Override // com.myscript.nebo.whatsnew.IPLSMigrationState
    public void setPLSMigrationDone(boolean z) {
        this.isPLSMigrationDone.setValue(this, $$delegatedProperties[4], z);
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public int getCrashCount(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.appPreferences.getInt(key, 0);
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public void incrementCrashCount(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.appPreferences.edit().putInt(key, this.appPreferences.getInt(key, 0) + 1).commit();
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public void resetCrashCount(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.appPreferences.edit();
        editorEdit.remove(key);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public boolean shouldFlagPageAsCorrupted(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getCrashCount(key) >= 2;
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public boolean shouldLeaveCrashingPage(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getCrashCount(key) > 1;
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public String getNoteCrashCountKey() {
        return this.noteCrashCountKey.getValue((Object) this, $$delegatedProperties[5]);
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public void setNoteCrashCountKey(String str) {
        this.noteCrashCountKey.setValue2((Object) this, $$delegatedProperties[5], str);
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public Set<String> getPagesCrashCountKeys() {
        return this.pagesCrashCountKeys.getValue((Object) this, $$delegatedProperties[6]);
    }

    @Override // com.myscript.nebo.crash.ICrashCountState
    public void setPagesCrashCountKeys(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.pagesCrashCountKeys.setValue2((Object) this, $$delegatedProperties[6], set);
    }

    public final void addNativeCrashToLog(int nativeCrashToLog) {
        this.appPreferences.edit().putString(NATIVE_CRASH_TO_LOG_KEY, this.appPreferences.getString(NATIVE_CRASH_TO_LOG_KEY, "") + "," + nativeCrashToLog).commit();
    }

    public final List<Integer> getNativeCrashesToLog() {
        Integer numValueOf;
        String string = this.appPreferences.getString(NATIVE_CRASH_TO_LOG_KEY, null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf((String) it.next());
            } catch (NumberFormatException unused) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    public final void clearNativeCrashesToLog() {
        this.appPreferences.edit().remove(NATIVE_CRASH_TO_LOG_KEY).commit();
    }

    public final void setCrashing() {
        SharedPreferences.Editor editorEdit = this.appPreferences.edit();
        editorEdit.putBoolean(CRASH_DETECTED_KEY, true);
        editorEdit.apply();
    }

    public final boolean wasCrashed() {
        return this.appPreferences.getBoolean(CRASH_DETECTED_KEY, false);
    }

    public final void clearCrash() {
        SharedPreferences.Editor editorEdit = this.appPreferences.edit();
        editorEdit.putBoolean(CRASH_DETECTED_KEY, false);
        editorEdit.apply();
    }
}
