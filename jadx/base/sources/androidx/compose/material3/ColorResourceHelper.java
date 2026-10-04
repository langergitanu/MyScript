package androidx.compose.material3;

import android.content.Context;
import androidx.compose.p004ui.graphics.ColorKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: DynamicTonalPalette.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Landroidx/compose/material3/ColorResourceHelper;", "", "<init>", "()V", "getColor", "Landroidx/compose/ui/graphics/Color;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "id", "", "getColor-WaAFU9c", "(Landroid/content/Context;I)J", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
final class ColorResourceHelper {
    public static final ColorResourceHelper INSTANCE = new ColorResourceHelper();

    private ColorResourceHelper() {
    }

    /* JADX INFO: renamed from: getColor-WaAFU9c, reason: not valid java name */
    public final long m4773getColorWaAFU9c(Context context, int id) {
        return ColorKt.Color(context.getResources().getColor(id, context.getTheme()));
    }
}
