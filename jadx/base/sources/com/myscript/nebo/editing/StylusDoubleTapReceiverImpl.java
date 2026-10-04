package com.myscript.nebo.editing;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StylusDoubleTapReceiver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/StylusDoubleTapReceiverImpl;", "Lcom/myscript/nebo/editing/StylusDoubleTapReceiver;", "<init>", "()V", "stylusDoubleTapListener", "Lcom/myscript/nebo/editing/IStylusDoubleTapListener;", "getIntentFilters", "Landroid/content/IntentFilter;", "setStylusDoubleTapListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onKeyDown", "", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onReceive", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StylusDoubleTapReceiverImpl extends StylusDoubleTapReceiver {
    private static final String HONOR_STYLUS_DOUBLE_TAP = "com.hihonor.stylus.action.STYLUS_DOUBLE_CLICK";
    private static final String HUAWEI_DOUBLE_TAP_SWITCH_MODE = "double_click_switch_mode";
    private static final String HUAWEI_STYLUS_DOUBLE_TAP = "com.huawei.stylus.action.BUTTON_DOUBLE_PRESSED";
    private static final int LENOVO_STYLUS_DOUBLE_TAP = 601;
    private IStylusDoubleTapListener stylusDoubleTapListener;
    public static final int $stable = 8;

    @Override // com.myscript.nebo.editing.StylusDoubleTapReceiver
    public IntentFilter getIntentFilters() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HUAWEI_STYLUS_DOUBLE_TAP);
        intentFilter.addAction(HONOR_STYLUS_DOUBLE_TAP);
        return intentFilter;
    }

    @Override // com.myscript.nebo.editing.StylusDoubleTapReceiver
    public void setStylusDoubleTapListener(IStylusDoubleTapListener listener) {
        this.stylusDoubleTapListener = listener;
    }

    @Override // com.myscript.nebo.editing.StylusDoubleTapReceiver
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 601) {
            return false;
        }
        IStylusDoubleTapListener iStylusDoubleTapListener = this.stylusDoubleTapListener;
        if (iStylusDoubleTapListener == null) {
            return true;
        }
        iStylusDoubleTapListener.stylusDoubleTap(StylusSwitchBehavior.CURRENT_AND_ERASER);
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StylusSwitchBehavior stylusSwitchBehavior;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(HUAWEI_STYLUS_DOUBLE_TAP, intent != null ? intent.getAction() : null)) {
            int i = Settings.Global.getInt(context.getApplicationContext().getContentResolver(), HUAWEI_DOUBLE_TAP_SWITCH_MODE, 0);
            if (i == 0) {
                stylusSwitchBehavior = StylusSwitchBehavior.CURRENT_AND_ERASER;
            } else if (i == 1) {
                stylusSwitchBehavior = StylusSwitchBehavior.CURRENT_AND_TOOL;
            } else if (i == 2) {
                stylusSwitchBehavior = StylusSwitchBehavior.COLOR_PALETTE;
            } else {
                stylusSwitchBehavior = StylusSwitchBehavior.NONE;
            }
        } else {
            if (Intrinsics.areEqual(HONOR_STYLUS_DOUBLE_TAP, intent != null ? intent.getAction() : null)) {
                stylusSwitchBehavior = StylusSwitchBehavior.CURRENT_AND_ERASER;
            } else {
                stylusSwitchBehavior = StylusSwitchBehavior.NONE;
            }
        }
        IStylusDoubleTapListener iStylusDoubleTapListener = this.stylusDoubleTapListener;
        if (iStylusDoubleTapListener != null) {
            iStylusDoubleTapListener.stylusDoubleTap(stylusSwitchBehavior);
        }
    }
}
