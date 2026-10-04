package androidx.security.crypto;

import android.content.Context;
import androidx.security.crypto.MasterKey;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: MasterKey.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007¨\u0006\r"}, m1599d2 = {"MasterKey", "Landroidx/security/crypto/MasterKey;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "keyAlias", "", "keyScheme", "Landroidx/security/crypto/MasterKey$KeyScheme;", "authenticationRequired", "", "userAuthenticationValidityDurationSeconds", "", "requestStrongBoxBacked", "security-crypto-ktx_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class MasterKeyKt {
    public static /* synthetic */ MasterKey MasterKey$default(Context context, String str, MasterKey.KeyScheme keyScheme, boolean z, int i, boolean z2, int i2, Object obj) {
        boolean z3;
        int i3;
        MasterKey.KeyScheme keyScheme2;
        boolean z4;
        Context context2;
        String str2;
        if ((i2 & 2) != 0) {
            str = MasterKey.DEFAULT_MASTER_KEY_ALIAS;
        }
        if ((i2 & 4) != 0) {
            keyScheme = MasterKey.KeyScheme.AES256_GCM;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            i = MasterKey.getDefaultAuthenticationValidityDurationSeconds();
        }
        if ((i2 & 32) != 0) {
            z3 = false;
            z4 = z;
            i3 = i;
            str2 = str;
            keyScheme2 = keyScheme;
            context2 = context;
        } else {
            z3 = z2;
            i3 = i;
            keyScheme2 = keyScheme;
            z4 = z;
            context2 = context;
            str2 = str;
        }
        return MasterKey(context2, str2, keyScheme2, z4, i3, z3);
    }

    @Deprecated(message = "Use Android Keystore directly instead")
    public static final MasterKey MasterKey(Context context, String str, MasterKey.KeyScheme keyScheme, boolean z, int i, boolean z2) {
        return new MasterKey.Builder(context, str).setKeyScheme(keyScheme).setUserAuthenticationRequired(z, i).setRequestStrongBoxBacked(z2).build();
    }
}
