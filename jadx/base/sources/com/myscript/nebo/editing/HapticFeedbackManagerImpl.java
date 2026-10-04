package com.myscript.nebo.editing;

import android.content.Context;
import com.myscript.snt.core.ToolConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HapticFeedbackManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/HapticFeedbackManagerImpl;", "Lcom/myscript/nebo/editing/HapticFeedbackManager;", "<init>", "()V", "isDeviceCapable", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "init", "", "startFeedback", "stopFeedback", "setTool", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "setEnable", "enable", "onEvent", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HapticFeedbackManagerImpl implements HapticFeedbackManager {
    public static final int $stable = 0;

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public boolean isDeviceCapable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void onEvent() {
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void setEnable(boolean enable) {
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void setTool(ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void startFeedback() {
    }

    @Override // com.myscript.nebo.editing.HapticFeedbackManager
    public void stopFeedback() {
    }
}
