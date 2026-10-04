package androidx.security.crypto;

import android.content.Context;
import androidx.security.crypto.EncryptedFile;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: EncryptedFile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\r"}, m1599d2 = {"EncryptedFile", "Landroidx/security/crypto/EncryptedFile;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "file", "Ljava/io/File;", "masterKey", "Landroidx/security/crypto/MasterKey;", "fileEncryptionScheme", "Landroidx/security/crypto/EncryptedFile$FileEncryptionScheme;", "keysetPrefName", "", "keysetAlias", "security-crypto-ktx_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class EncryptedFileKt {
    public static /* synthetic */ EncryptedFile EncryptedFile$default(Context context, File file, MasterKey masterKey, EncryptedFile.FileEncryptionScheme fileEncryptionScheme, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            fileEncryptionScheme = EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB;
        }
        return EncryptedFile(context, file, masterKey, fileEncryptionScheme, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2);
    }

    @Deprecated(message = "Use java.io.File instead")
    public static final EncryptedFile EncryptedFile(Context context, File file, MasterKey masterKey, EncryptedFile.FileEncryptionScheme fileEncryptionScheme, String str, String str2) {
        EncryptedFile.Builder builder = new EncryptedFile.Builder(context, file, masterKey, fileEncryptionScheme);
        if (str != null) {
            builder.setKeysetPrefName(str);
        }
        if (str2 != null) {
            builder.setKeysetAlias(str2);
        }
        return builder.build();
    }
}
