package com.chuckerteam.chucker.api;

import android.content.Context;
import android.content.Intent;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chucker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u000e"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/Chucker;", "", "<init>", "()V", "isOp", "", "isOp$annotations", "()Z", "getLaunchIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "dismissNotifications", "", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Chucker {
    public static final Chucker INSTANCE = new Chucker();
    private static final boolean isOp = false;

    @JvmStatic
    public static final void dismissNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void isOp$annotations() {
    }

    private Chucker() {
    }

    public final boolean isOp() {
        return isOp;
    }

    @JvmStatic
    public static final Intent getLaunchIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent();
    }
}
