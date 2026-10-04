package androidx.compose.p004ui.platform;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import androidx.compose.p004ui.unit.AndroidDensity_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.DpKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidWindowInfo.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, m1599d2 = {"calculateWindowSize", "Landroidx/compose/ui/platform/DerivedSize;", "view", "Landroid/view/View;", "tryUnwrapContext", "Landroid/content/Context;", WebViewMessageType.CONTEXT, "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidWindowInfo_androidKt {
    public static final DerivedSize calculateWindowSize(View view) {
        Context context = view.getContext();
        Context contextTryUnwrapContext = tryUnwrapContext(context);
        if (contextTryUnwrapContext != null) {
            WindowMetrics windowMetricsComputeCurrentWindowMetrics = WindowMetricsCalculator.INSTANCE.getOrCreate().computeCurrentWindowMetrics(contextTryUnwrapContext);
            return DerivedSize.INSTANCE.m10108fromPxSizeviCIZxY(IntSize.m11183constructorimpl((((long) windowMetricsComputeCurrentWindowMetrics.getBounds().width()) << 32) | (((long) windowMetricsComputeCurrentWindowMetrics.getBounds().height()) & 4294967295L)), AndroidDensity_androidKt.Density(contextTryUnwrapContext));
        }
        Configuration configuration = context.getResources().getConfiguration();
        return DerivedSize.INSTANCE.m10107fromDpSizeitqla9I(DpKt.m11039DpSizeYgX7TsA(C1486Dp.m11017constructorimpl(configuration.screenWidthDp), C1486Dp.m11017constructorimpl(configuration.screenHeightDp)), AndroidDensity_androidKt.Density(context));
    }

    private static final Context tryUnwrapContext(Context context) {
        while (context instanceof ContextWrapper) {
            if ((context instanceof Activity) || (context instanceof InputMethodService) || (context instanceof Application)) {
                return context;
            }
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() == null) {
                return null;
            }
            context = contextWrapper.getBaseContext();
        }
        return null;
    }
}
