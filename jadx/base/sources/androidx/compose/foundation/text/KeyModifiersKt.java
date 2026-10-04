package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyModifiers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"modifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "Landroidx/compose/ui/input/key/KeyEvent;", "getModifiers-ZmokQxo", "(Landroid/view/KeyEvent;)I", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KeyModifiersKt {
    /* JADX INFO: renamed from: getModifiers-ZmokQxo, reason: not valid java name */
    public static final int m3465getModifiersZmokQxo(KeyEvent keyEvent) {
        return KeyModifiers.m3424constructorimpl(KeyEvent_androidKt.m9327isAltPressedZmokQxo(keyEvent), KeyEvent_androidKt.m9328isCtrlPressedZmokQxo(keyEvent), KeyEvent_androidKt.m9329isMetaPressedZmokQxo(keyEvent), KeyEvent_androidKt.m9330isShiftPressedZmokQxo(keyEvent));
    }
}
