package com.chuckerteam.chucker.api;

import android.content.Context;
import android.net.Uri;
import com.chuckerteam.chucker.api.RetentionManager;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChuckerCollector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/ChuckerCollector;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "showNotification", "", "retentionPeriod", "Lcom/chuckerteam/chucker/api/RetentionManager$Period;", "<init>", "(Landroid/content/Context;ZLcom/chuckerteam/chucker/api/RetentionManager$Period;)V", "getShowNotification", "()Z", "setShowNotification", "(Z)V", "writeTransactions", "Landroid/net/Uri;", "startTimestamp", "", "exportFormat", "Lcom/chuckerteam/chucker/api/ExportFormat;", "(Landroid/content/Context;Ljava/lang/Long;Lcom/chuckerteam/chucker/api/ExportFormat;)Landroid/net/Uri;", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChuckerCollector {
    private boolean showNotification;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChuckerCollector(Context context) {
        this(context, false, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChuckerCollector(Context context, boolean z) {
        this(context, z, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Uri writeTransactions(Context context, Long startTimestamp, ExportFormat exportFormat) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exportFormat, "exportFormat");
        return null;
    }

    public ChuckerCollector(Context context, boolean z, RetentionManager.Period retentionPeriod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(retentionPeriod, "retentionPeriod");
        this.showNotification = z;
    }

    public final boolean getShowNotification() {
        return this.showNotification;
    }

    public final void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public /* synthetic */ ChuckerCollector(Context context, boolean z, RetentionManager.Period period, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? true : z, (i & 4) != 0 ? RetentionManager.Period.ONE_WEEK : period);
    }

    public static /* synthetic */ Uri writeTransactions$default(ChuckerCollector chuckerCollector, Context context, Long l, ExportFormat exportFormat, int i, Object obj) {
        if ((i & 4) != 0) {
            exportFormat = ExportFormat.LOG;
        }
        return chuckerCollector.writeTransactions(context, l, exportFormat);
    }
}
