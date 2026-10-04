package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: EncryptedSharedPreferences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, m1599d2 = {"EncryptedSharedPreferences", "Landroid/content/SharedPreferences;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "fileName", "", "masterKey", "Landroidx/security/crypto/MasterKey;", "prefKeyEncryptionScheme", "Landroidx/security/crypto/EncryptedSharedPreferences$PrefKeyEncryptionScheme;", "prefValueEncryptionScheme", "Landroidx/security/crypto/EncryptedSharedPreferences$PrefValueEncryptionScheme;", "security-crypto-ktx_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class EncryptedSharedPreferencesKt {
    public static /* synthetic */ SharedPreferences EncryptedSharedPreferences$default(Context context, String str, MasterKey masterKey, EncryptedSharedPreferences.PrefKeyEncryptionScheme prefKeyEncryptionScheme, EncryptedSharedPreferences.PrefValueEncryptionScheme prefValueEncryptionScheme, int i, Object obj) {
        if ((i & 8) != 0) {
            prefKeyEncryptionScheme = EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV;
        }
        if ((i & 16) != 0) {
            prefValueEncryptionScheme = EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM;
        }
        return EncryptedSharedPreferences(context, str, masterKey, prefKeyEncryptionScheme, prefValueEncryptionScheme);
    }

    @Deprecated(message = "Use android.content.SharedPreferences instead")
    public static final SharedPreferences EncryptedSharedPreferences(Context context, String str, MasterKey masterKey, EncryptedSharedPreferences.PrefKeyEncryptionScheme prefKeyEncryptionScheme, EncryptedSharedPreferences.PrefValueEncryptionScheme prefValueEncryptionScheme) {
        return EncryptedSharedPreferences.create(context, str, masterKey, prefKeyEncryptionScheme, prefValueEncryptionScheme);
    }
}
