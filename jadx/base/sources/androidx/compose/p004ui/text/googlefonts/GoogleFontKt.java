package androidx.compose.p004ui.text.googlefonts;

import android.content.Context;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.googlefonts.GoogleFont;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, m1599d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "googleFont", "Landroidx/compose/ui/text/googlefonts/GoogleFont;", "fontProvider", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-wCLgNak", "(Landroidx/compose/ui/text/googlefonts/GoogleFont;Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "isAvailableOnDevice", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "reasonToString", "", "reasonCode", "", "ui-text-google-fonts"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class GoogleFontKt {
    /* JADX INFO: renamed from: Font-wCLgNak$default, reason: not valid java name */
    public static /* synthetic */ Font m10623FontwCLgNak$default(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getW400();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.INSTANCE.m10574getNormal_LCdwA();
        }
        return m10622FontwCLgNak(googleFont, provider, fontWeight, i);
    }

    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m10622FontwCLgNak(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i) {
        return new GoogleFontImpl(googleFont.getName(), provider, fontWeight, i, googleFont.getBestEffort(), null);
    }

    public static final boolean isAvailableOnDevice(GoogleFont.Provider provider, Context context) {
        return FontProviderHelperKt.checkAvailable(provider, context.getPackageManager(), context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String reasonToString(int i) {
        if (i == -4) {
            return "Font was not loaded due to security issues. This usually means the font was attempted to load in a restricted context";
        }
        if (i == -3) {
            return "Generic error loading font, for example variation settings were not parsable";
        }
        if (i == -2) {
            return "The given provider cannot be authenticated with the certificates given.";
        }
        if (i == -1) {
            return "The requested provider was not found on this device.";
        }
        if (i == 1) {
            return "Font not found, please check availability on GoogleFont.Provider.AllFontsList: https://fonts.gstatic.com/s/a/directory.xml";
        }
        if (i == 2) {
            return "The provider found the queried font, but it is currently unavailable.";
        }
        if (i == 3) {
            return "The given query was not supported by this provider.";
        }
        return "Unknown error code";
    }
}
