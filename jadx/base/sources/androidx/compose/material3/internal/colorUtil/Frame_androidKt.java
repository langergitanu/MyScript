package androidx.compose.material3.internal.colorUtil;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;

/* JADX INFO: compiled from: Frame.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, m1599d2 = {"lerp", "", TtmlNode.START, "stop", Keys.AMOUNT, "material3"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class Frame_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float lerp(float f, float f2, float f3) {
        return ((1.0f - f3) * f) + (f3 * f2);
    }
}
