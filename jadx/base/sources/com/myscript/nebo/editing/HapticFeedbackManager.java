package com.myscript.nebo.editing;

import android.content.Context;
import com.myscript.snt.core.ToolConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: HapticFeedbackManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0007H&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/HapticFeedbackManager;", "", "isDeviceCapable", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "init", "", "startFeedback", "stopFeedback", "setTool", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "setEnable", "enable", "onEvent", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HapticFeedbackManager {
    void init(Context context);

    boolean isDeviceCapable(Context context);

    void onEvent();

    void setEnable(boolean enable);

    void setTool(ToolConfiguration toolConfiguration);

    void startFeedback();

    void stopFeedback();
}
