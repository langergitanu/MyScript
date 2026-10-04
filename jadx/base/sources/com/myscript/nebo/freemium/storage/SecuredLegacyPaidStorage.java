package com.myscript.nebo.freemium.storage;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SecuredLegacyPaidStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/freemium/storage/SecuredLegacyPaidStorage;", "Lcom/myscript/nebo/freemium/storage/LegacyPaidStorage;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "storedVersion", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/app/Application;Ljava/lang/String;Landroid/content/SharedPreferences;)V", "isPaidLegacyUser", "", "()Z", "storeLegacyState", "", "isLegacy", "clear", "Companion", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SecuredLegacyPaidStorage implements LegacyPaidStorage {
    private static final String FALLBACK_PREFS_NAME = "freemium_update_fallback_prefs_name";
    private static final String IS_PAID_LEGACY_USER = "is_paid_legacy_user_preference";
    private static final String SECURE_PREFS_NAME = "freemium_update_secure_prefs_name";
    private static final String UPDATED_TO_FREEMIUM_KEY = "updated_to_freemium_preference";
    private final SharedPreferences sharedPreferences;
    public static final int $stable = 8;

    public SecuredLegacyPaidStorage(Application application, String str, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
        if (sharedPreferences.getBoolean(UPDATED_TO_FREEMIUM_KEY, false)) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String str2 = str;
        editorEdit.putBoolean(IS_PAID_LEGACY_USER, !(str2 == null || StringsKt.isBlank(str2)));
        editorEdit.putBoolean(UPDATED_TO_FREEMIUM_KEY, true);
        editorEdit.apply();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SecuredLegacyPaidStorage(Application application, String str, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Application application2;
        if ((i & 4) != 0) {
            application2 = application;
            sharedPreferences = SecureStorageHelperKt.getSecureSharedPreferences$default(application2, SECURE_PREFS_NAME, FALLBACK_PREFS_NAME, null, 4, null);
        } else {
            application2 = application;
        }
        this(application2, str, sharedPreferences);
    }

    @Override // com.myscript.nebo.freemium.storage.LegacyPaidStorage
    public boolean isPaidLegacyUser() {
        return this.sharedPreferences.getBoolean(IS_PAID_LEGACY_USER, false);
    }

    @Override // com.myscript.nebo.freemium.storage.LegacyPaidStorage
    public void storeLegacyState(boolean isLegacy) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(IS_PAID_LEGACY_USER, isLegacy);
        editorEdit.putBoolean(UPDATED_TO_FREEMIUM_KEY, true);
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.freemium.storage.LegacyPaidStorage
    public void clear() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }
}
