package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEventType;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyEventHelpers.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, m1599d2 = {"cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "showCharacterPalette", "", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KeyEventHelpers_androidKt {
    public static final void showCharacterPalette() {
    }

    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m3419cancelsTextSelectionZmokQxo(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 4 && KeyEventType.m9317equalsimpl0(KeyEvent_androidKt.m9325getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m9322getKeyUpCS__XNY());
    }
}
