package androidx.compose.p004ui.unit;

import android.content.Context;
import androidx.compose.p004ui.unit.fontscaling.FontScaleConverterFactory;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidDensity.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"Density", "Landroidx/compose/ui/unit/Density;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "ui-unit"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidDensity_androidKt {
    public static final Density Density(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f2 = context.getResources().getDisplayMetrics().density;
        LinearFontScaleConverter linearFontScaleConverterForScale = FontScaleConverterFactory.INSTANCE.forScale(f);
        if (linearFontScaleConverterForScale == null) {
            linearFontScaleConverterForScale = new LinearFontScaleConverter(f);
        }
        return new DensityWithConverter(f2, f, linearFontScaleConverterForScale);
    }
}
