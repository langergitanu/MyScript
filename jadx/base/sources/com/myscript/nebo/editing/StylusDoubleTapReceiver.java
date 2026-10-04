package com.myscript.nebo.editing;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: StylusDoubleTapReceiver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/editing/StylusDoubleTapReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "getIntentFilters", "Landroid/content/IntentFilter;", "setStylusDoubleTapListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/editing/IStylusDoubleTapListener;", "onKeyDown", "", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class StylusDoubleTapReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    public abstract IntentFilter getIntentFilters();

    public abstract boolean onKeyDown(int keyCode, KeyEvent event);

    public abstract void setStylusDoubleTapListener(IStylusDoubleTapListener listener);
}
