package com.myscript.nebo.freemium.storage;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.myscript.nebo.log.TechnicalLogger;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureStorageHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a&\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"KEYSTORE_PROVIDER", "", "getSecureSharedPreferences", "Landroid/content/SharedPreferences;", "Landroid/app/Application;", "securePrefName", "fallbackPrefName", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "createSecureSharedPreferences", "prefName", "resetSecureSharedPreferences", "", "freemium_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SecureStorageHelperKt {
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";

    public static /* synthetic */ SharedPreferences getSecureSharedPreferences$default(Application application, String str, String str2, TechnicalLogger technicalLogger, int i, Object obj) {
        if ((i & 4) != 0) {
            technicalLogger = null;
        }
        return getSecureSharedPreferences(application, str, str2, technicalLogger);
    }

    public static final SharedPreferences getSecureSharedPreferences(Application application, String securePrefName, String fallbackPrefName, TechnicalLogger technicalLogger) {
        SharedPreferences sharedPreferences;
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(securePrefName, "securePrefName");
        Intrinsics.checkNotNullParameter(fallbackPrefName, "fallbackPrefName");
        try {
            return createSecureSharedPreferences(application, securePrefName);
        } catch (Exception e) {
            if (technicalLogger != null) {
                technicalLogger.logError(e);
            }
            try {
                resetSecureSharedPreferences(application, securePrefName);
                sharedPreferences = createSecureSharedPreferences(application, securePrefName);
            } catch (Exception e2) {
                if (technicalLogger != null) {
                    technicalLogger.logError(new RuntimeException("Second attempt to create secure prefs failed: " + e2.getMessage()));
                }
                sharedPreferences = application.getSharedPreferences(fallbackPrefName, 0);
            }
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences;
        }
    }

    private static final SharedPreferences createSecureSharedPreferences(Application application, String str) throws GeneralSecurityException, IOException {
        Application application2 = application;
        MasterKey masterKeyBuild = new MasterKey.Builder(application2, MasterKey.DEFAULT_MASTER_KEY_ALIAS).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
        SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(application2, str, masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
        return sharedPreferencesCreate;
    }

    private static final void resetSecureSharedPreferences(Application application, String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
            keyStore.load(null);
            keyStore.deleteEntry(MasterKey.DEFAULT_MASTER_KEY_ALIAS);
            SharedPreferences sharedPreferences = application.getSharedPreferences(str, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.apply();
            application.deleteSharedPreferences(str);
        } catch (Exception unused) {
        }
    }
}
