package androidx.compose.foundation.text;

import androidx.compose.p004ui.input.pointer.PointerIcon;
import androidx.compose.p004ui.input.pointer.PointerIcon_androidKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextPointerIcon.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"handwritingPointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getHandwritingPointerIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextPointerIcon_androidKt {
    private static final PointerIcon handwritingPointerIcon = PointerIcon_androidKt.PointerIcon(AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);

    public static final PointerIcon getHandwritingPointerIcon() {
        return handwritingPointerIcon;
    }
}
