package androidx.compose.p004ui.text.googlefonts;

import android.content.Context;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m1599d2 = {"Landroidx/compose/ui/text/googlefonts/DefaultFontsContractCompatLoader;", "Landroidx/compose/ui/text/googlefonts/FontsContractCompatLoader;", "<init>", "()V", "requestFont", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "fontRequest", "Landroidx/core/provider/FontRequest;", "typefaceStyle", "", "handler", "Landroid/os/Handler;", "callback", "Landroidx/core/provider/FontsContractCompat$FontRequestCallback;", "ui-text-google-fonts"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class DefaultFontsContractCompatLoader implements FontsContractCompatLoader {
    public static final DefaultFontsContractCompatLoader INSTANCE = new DefaultFontsContractCompatLoader();

    private DefaultFontsContractCompatLoader() {
    }

    @Override // androidx.compose.p004ui.text.googlefonts.FontsContractCompatLoader
    public void requestFont(Context context, FontRequest fontRequest, int typefaceStyle, Handler handler, FontsContractCompat.FontRequestCallback callback) {
        FontsContractCompat.requestFont(context, fontRequest, typefaceStyle, false, 0, handler, callback);
    }
}
