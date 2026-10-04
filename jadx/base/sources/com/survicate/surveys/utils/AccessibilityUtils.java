package com.survicate.surveys.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils;", "", "<init>", "()V", "isTalkbackEnabled", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "setExpandedState", "", "view", "Landroid/view/View;", "isExpanded", "setErrorState", "error", "", "ExpandableViewAccessibilityDelegate", "ButtonRoleAccessibilityDelegate", "ProgressBarRoleAccessibilityDelegate", "ErrorAccessibilityDelegate", "HintAccessibilityDelegate", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    private AccessibilityUtils() {
    }

    @JvmStatic
    public static final boolean isTalkbackEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager == null) {
            return false;
        }
        return accessibilityManager.isTouchExplorationEnabled();
    }

    public final void setExpandedState(View view, boolean isExpanded) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(C8369R.id.survicate_accessibility_state_expanded, Boolean.valueOf(isExpanded));
    }

    public final void setErrorState(View view, String error) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(C8369R.id.survicate_accessibility_state_error, error);
    }

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils$ExpandableViewAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "<init>", "()V", "onInitializeAccessibilityNodeInfo", "", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "performAccessibilityAction", "", "action", "", "args", "Landroid/os/Bundle;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class ExpandableViewAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            Object tag = host.getTag(C8369R.id.survicate_accessibility_state_expanded);
            Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
            if (bool != null) {
                info.addAction(bool.booleanValue() ? 524288 : 262144);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            Intrinsics.checkNotNullParameter(host, "host");
            if (action == 262144 || action == 524288) {
                host.performClick();
                return true;
            }
            return super.performAccessibilityAction(host, action, args);
        }
    }

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils$ButtonRoleAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "<init>", "()V", "onInitializeAccessibilityNodeInfo", "", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class ButtonRoleAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName(Button.class.getName());
        }
    }

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils$ProgressBarRoleAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "<init>", "()V", "onInitializeAccessibilityNodeInfo", "", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class ProgressBarRoleAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName(ProgressBar.class.getName());
        }
    }

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils$ErrorAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "<init>", "()V", "onInitializeAccessibilityNodeInfo", "", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class ErrorAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            Object tag = host.getTag(C8369R.id.survicate_accessibility_state_error);
            String str = tag instanceof String ? (String) tag : null;
            if (str != null) {
                info.setContentInvalid(true);
                info.setError(str);
            }
        }
    }

    /* JADX INFO: compiled from: AccessibilityUtils.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/utils/AccessibilityUtils$HintAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "hint", "", "<init>", "(Ljava/lang/String;)V", "onInitializeAccessibilityNodeInfo", "", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class HintAccessibilityDelegate extends AccessibilityDelegateCompat {
        private final String hint;

        public HintAccessibilityDelegate(String hint) {
            Intrinsics.checkNotNullParameter(hint, "hint");
            this.hint = hint;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setHintText(this.hint);
        }
    }
}
