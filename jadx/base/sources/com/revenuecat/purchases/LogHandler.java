package com.revenuecat.purchases;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: compiled from: LogHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/LogHandler;", "", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "v", "w", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface LogHandler {
    /* JADX INFO: renamed from: d */
    void mo1541d(String tag, String msg);

    /* JADX INFO: renamed from: e */
    void mo1542e(String tag, String msg, Throwable throwable);

    /* JADX INFO: renamed from: i */
    void mo1543i(String tag, String msg);

    /* JADX INFO: renamed from: v */
    void mo1544v(String tag, String msg);

    /* JADX INFO: renamed from: w */
    void mo1545w(String tag, String msg);
}
