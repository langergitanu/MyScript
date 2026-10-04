package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.Key;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyMapping.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"platformDefaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getPlatformDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* JADX INFO: renamed from: map-ZmokQxo */
        public KeyCommand mo3420mapZmokQxo(KeyEvent event) {
            int iM3465getModifiersZmokQxo = KeyModifiersKt.m3465getModifiersZmokQxo(event);
            KeyCommand keyCommand = null;
            if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.Companion.m3456getAltShiftAuQ4EfA())) {
                long jM9324getKeyZmokQxo = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.Companion.m9081getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.Companion.m9082getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.Companion.m9083getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.Companion.m9078getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.Companion.m3454getAltAuQ4EfA())) {
                long jM9324getKeyZmokQxo2 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.Companion.m9081getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.Companion.m9082getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.Companion.m9083getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.Companion.m9078getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.Companion.m9022getBackspaceEK5gGoQ())) {
                    keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo3420mapZmokQxo(event) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
