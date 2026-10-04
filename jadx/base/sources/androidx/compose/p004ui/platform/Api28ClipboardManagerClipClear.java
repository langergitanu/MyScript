package androidx.compose.p004ui.platform;

import android.content.ClipboardManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Landroidx/compose/ui/platform/Api28ClipboardManagerClipClear;", "", "<init>", "()V", "clearPrimaryClip", "", "clipboardManager", "Landroid/content/ClipboardManager;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class Api28ClipboardManagerClipClear {
    public static final Api28ClipboardManagerClipClear INSTANCE = new Api28ClipboardManagerClipClear();

    private Api28ClipboardManagerClipClear() {
    }

    @JvmStatic
    public static final void clearPrimaryClip(ClipboardManager clipboardManager) {
        clipboardManager.clearPrimaryClip();
    }
}
