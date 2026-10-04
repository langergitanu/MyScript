package com.samsung.android.sdk.pen.setting.quicktool;

import kotlin.Metadata;

/* JADX INFO: compiled from: OnCurvedDialerTrackListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/OnCurvedDialerTrackListener;", "", "onStartTrackingTouch", "", "onStopTrackingTouch", "onProgressChanged", "progress", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public interface OnCurvedDialerTrackListener {
    void onProgressChanged(int progress);

    void onStartTrackingTouch();

    void onStopTrackingTouch();
}
