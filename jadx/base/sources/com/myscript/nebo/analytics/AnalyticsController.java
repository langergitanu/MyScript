package com.myscript.nebo.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsController implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String ANALYTICS_USER_ACKNOWLEDGE = AnalyticsController.class.getName() + ".ANALYTICS_USER_ACKNOWLEDGE";
    private static final String USER_PERSONALIZED_SETTINGS = AnalyticsController.class.getName() + ".USER_PERSONALIZED_SETTINGS";
    private static AnalyticsController instance;
    private final Context appContext;
    private boolean isFirebaseAnalyticsAvailable;
    private boolean isFirebaseAvailable;
    private final String mAnalyticsKey;
    private final String mCrashKey;

    public static synchronized void instantiate(Context context) {
        AnalyticsController analyticsController = new AnalyticsController(context);
        instance = analyticsController;
        analyticsController.initServices();
    }

    private static synchronized AnalyticsController getInstance() {
        return instance;
    }

    private AnalyticsController(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.mCrashKey = applicationContext.getString(C6150R.string.pref_analytics_log_crash_key);
        this.mAnalyticsKey = applicationContext.getString(C6150R.string.pref_analytics_log_event_key);
        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(this);
        this.isFirebaseAvailable = FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
        try {
            this.isFirebaseAnalyticsAvailable = !context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_analytics_collection_deactivated", true);
        } catch (PackageManager.NameNotFoundException unused) {
            this.isFirebaseAnalyticsAvailable = false;
        }
    }

    private FirebaseAnalytics getFirebaseAnalyticsInstance() {
        return FirebaseAnalytics.getInstance(this.appContext);
    }

    public static boolean isAnalyticsAvailable() {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            return analyticsController.isFirebaseAnalyticsAvailableImpl();
        }
        return false;
    }

    private boolean isFirebaseAnalyticsAvailableImpl() {
        return this.isFirebaseAvailable && this.isFirebaseAnalyticsAvailable;
    }

    public static boolean isCrashlogAvailable() {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            return analyticsController.isCrashlogAvailableImpl();
        }
        return false;
    }

    private boolean isCrashlogAvailableImpl() {
        return this.isFirebaseAvailable;
    }

    private void initServices() {
        boolean zHasUserConsent = hasUserConsent();
        boolean analyticsPreference = getAnalyticsPreference();
        if (zHasUserConsent) {
            if (isCrashlogAvailableImpl() && getCrashlogPreference()) {
                configureCrashlytics(true);
            }
            if (analyticsPreference && isFirebaseAnalyticsAvailableImpl()) {
                configureAnalytics(true);
            }
        }
    }

    public static boolean isCrashlogEnabled() {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController == null || !analyticsController.isCrashlogAvailableImpl()) {
            return false;
        }
        return analyticsController.getCrashlogPreference();
    }

    public static void setCrashlogEnabled(boolean z) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController == null || !analyticsController.isCrashlogAvailableImpl()) {
            return;
        }
        analyticsController.setPreference(analyticsController.mCrashKey, z);
    }

    public static boolean isAnalyticsEnabled() {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            return analyticsController.getAnalyticsPreference();
        }
        return false;
    }

    public static void setAnalyticsEnabled(boolean z) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController == null || !analyticsController.isFirebaseAnalyticsAvailableImpl()) {
            return;
        }
        analyticsController.setPreference(analyticsController.mAnalyticsKey, z);
    }

    public static boolean hasUserConsent() {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController == null) {
            return false;
        }
        if (analyticsController.isCrashlogAvailableImpl() || analyticsController.isFirebaseAnalyticsAvailableImpl()) {
            return analyticsController.getUserConsentPreference();
        }
        return false;
    }

    public static void setUserConsent(boolean z) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController == null || !analyticsController.isCrashlogAvailableImpl()) {
            return;
        }
        analyticsController.setPreference(ANALYTICS_USER_ACKNOWLEDGE, z);
    }

    private boolean getUserConsentPreference() {
        return getPreference(ANALYTICS_USER_ACKNOWLEDGE, true);
    }

    public static void setUserPersonalizedSettings(boolean z) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.setPreference(USER_PERSONALIZED_SETTINGS, z);
        }
    }

    public static boolean hasUserPersonalizedSettings() {
        AnalyticsController analyticsController = getInstance();
        return analyticsController != null && analyticsController.getPreference(USER_PERSONALIZED_SETTINGS, false);
    }

    private boolean getCrashlogPreference() {
        return getPreference(this.mCrashKey, this.appContext.getResources().getBoolean(C6150R.bool.pref_analytics_log_crash_default));
    }

    private boolean getAnalyticsPreference() {
        return getPreference(this.mAnalyticsKey, this.appContext.getResources().getBoolean(C6150R.bool.pref_analytics_log_event_default));
    }

    private boolean getPreference(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(this.appContext).getBoolean(str, z);
    }

    private void setPreference(String str, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.appContext).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Boolean boolValueOf;
        if (ANALYTICS_USER_ACKNOWLEDGE.equals(str)) {
            initServices();
            return;
        }
        if (hasUserConsent()) {
            if (this.mCrashKey.equals(str)) {
                if (isCrashlogAvailableImpl()) {
                    boolValueOf = Boolean.valueOf(getCrashlogPreference());
                    configureCrashlytics(boolValueOf.booleanValue());
                    if (!boolValueOf.booleanValue()) {
                        boolValueOf = Boolean.valueOf(getAnalyticsPreference());
                    }
                } else {
                    boolValueOf = null;
                }
            } else if (this.mAnalyticsKey.equals(str) && isFirebaseAnalyticsAvailableImpl()) {
                boolValueOf = Boolean.valueOf(getAnalyticsPreference());
                configureAnalytics(boolValueOf.booleanValue());
                if (!boolValueOf.booleanValue()) {
                    boolValueOf = Boolean.valueOf(getCrashlogPreference());
                }
            }
            if (boolValueOf == null || boolValueOf.booleanValue()) {
                return;
            }
            new Thread(new Runnable() { // from class: com.myscript.nebo.analytics.AnalyticsController$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSharedPreferenceChanged$0();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSharedPreferenceChanged$0() {
        FirebaseInstallations.getInstance().delete();
        getFirebaseAnalyticsInstance().resetAnalyticsData();
    }

    private void configureCrashlytics(boolean z) {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(z);
    }

    private void configureAnalytics(boolean z) {
        getFirebaseAnalyticsInstance().setAnalyticsCollectionEnabled(z);
    }

    public static void logException(Exception exc) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.logExceptionImpl(exc);
        }
    }

    public static void setKeyValue(String str, String str2) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.setKeyValueImpl(str, str2);
        }
    }

    private void setKeyValueImpl(String str, String str2) {
        try {
            if (isCrashlogAvailableImpl() && getCrashlogPreference()) {
                FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void addTrace(String str) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.addTraceImpl(str);
        }
    }

    private void addTraceImpl(String str) {
        try {
            if (isCrashlogAvailableImpl() && getCrashlogPreference()) {
                FirebaseCrashlytics.getInstance().log(str);
            }
        } catch (Exception unused) {
        }
    }

    private void logExceptionImpl(Exception exc) {
        try {
            if (isCrashlogAvailableImpl() && getCrashlogPreference()) {
                FirebaseCrashlytics.getInstance().recordException(exc);
            }
        } catch (Exception unused) {
        }
    }

    public static void logAnalytics(String str) {
        logAnalytics(str, new Bundle());
    }

    public static void logAnalytics(String str, Bundle bundle) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.logAnalyticsImpl(str, bundle);
        }
    }

    public static void logDevAnalytics(String str) {
        logDevAnalytics(str, new Bundle());
    }

    public static void logDevAnalytics(String str, Bundle bundle) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.logAnalyticsImpl(str, bundle);
        }
    }

    private void logAnalyticsImpl(String str, Bundle bundle) {
        try {
            if (isFirebaseAnalyticsAvailableImpl() && getAnalyticsPreference()) {
                getFirebaseAnalyticsInstance().logEvent(str, bundle);
            }
        } catch (Exception unused) {
        }
    }

    public static void setUserProperty(String str, String str2) {
        AnalyticsController analyticsController = getInstance();
        if (analyticsController != null) {
            analyticsController.setUserPropertyImpl(str, str2);
        }
    }

    private void setUserPropertyImpl(String str, String str2) {
        try {
            if (isFirebaseAnalyticsAvailableImpl() && getAnalyticsPreference()) {
                getFirebaseAnalyticsInstance().setUserProperty(str, str2);
            }
        } catch (Exception unused) {
        }
    }
}
