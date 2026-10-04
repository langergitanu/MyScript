package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.Key;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "systemShortcutModifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "commonKeyMapping-VSD1kLU", "(I)Landroidx/compose/foundation/text/KeyMapping;", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    /* JADX INFO: renamed from: commonKeyMapping-VSD1kLU, reason: not valid java name */
    public static final KeyMapping m3421commonKeyMappingVSD1kLU(final int i) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo3420mapZmokQxo(KeyEvent event) {
                int iM3465getModifiersZmokQxo = KeyModifiersKt.m3465getModifiersZmokQxo(event);
                if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.m3440plus1uj4btU(i, KeyModifiers.INSTANCE.m3463getShiftAuQ4EfA()))) {
                    if (Key.m9004equalsimpl0(KeyEvent_androidKt.m9324getKeyZmokQxo(event), Key.INSTANCE.m9302getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, i)) {
                    long jM9324getKeyZmokQxo = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9059getCEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9123getInsertEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9190getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9291getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9299getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9009getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9300getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9302getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3463getShiftAuQ4EfA())) {
                    long jM9324getKeyZmokQxo2 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9081getDirectionLeftEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9183getNumPadDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9082getDirectionRightEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9184getNumPadDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9083getDirectionUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9185getNumPadDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9078getDirectionDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9182getNumPadDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9204getPageUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9196getNumPadPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9203getPageDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9195getNumPadPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9157getMoveHomeEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9193getNumPadMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9156getMoveEndEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9192getNumPadMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9123getInsertEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9190getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                if (!KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3462getNoneAuQ4EfA())) {
                    return null;
                }
                long jM9324getKeyZmokQxo3 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9081getDirectionLeftEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9183getNumPadDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9082getDirectionRightEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9184getNumPadDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9083getDirectionUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9185getNumPadDirectionUpEK5gGoQ())) {
                    return KeyCommand.f62UP;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9078getDirectionDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9182getNumPadDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9077getDirectionCenterEK5gGoQ())) {
                    return KeyCommand.CENTER;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9204getPageUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9196getNumPadPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9203getPageDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9195getNumPadPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9157getMoveHomeEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9193getNumPadMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9156getMoveEndEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9192getNumPadMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9091getEnterEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9188getNumPadEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9022getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9076getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9206getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9074getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9071getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9252getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingM3421commonKeyMappingVSD1kLU = m3421commonKeyMappingVSD1kLU(KeyModifiers.INSTANCE.m3457getCtrlAuQ4EfA());
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1$1
            /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public KeyCommand mo3420mapZmokQxo(KeyEvent event) {
                KeyCommand keyCommand;
                int iM3465getModifiersZmokQxo = KeyModifiersKt.m3465getModifiersZmokQxo(event);
                long jM9324getKeyZmokQxo = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                KeyCommand keyCommand2 = null;
                if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9022getBackspaceEK5gGoQ())) {
                    if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3462getNoneAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3463getShiftAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3464getShiftMetaAuQ4EfA())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else {
                        keyCommand = (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3457getCtrlAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3460getCtrlShiftAuQ4EfA())) ? KeyCommand.DELETE_PREV_WORD : null;
                    }
                } else if ((Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9091getEnterEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo, Key.INSTANCE.m9188getNumPadEnterEK5gGoQ())) && (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3462getNoneAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3463getShiftAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3457getCtrlAuQ4EfA()) || KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo, KeyModifiers.INSTANCE.m3460getCtrlShiftAuQ4EfA()))) {
                    keyCommand = KeyCommand.NEW_LINE;
                }
                if (keyCommand != null) {
                    return keyCommand;
                }
                int iM3465getModifiersZmokQxo2 = KeyModifiersKt.m3465getModifiersZmokQxo(event);
                if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo2, KeyModifiers.INSTANCE.m3460getCtrlShiftAuQ4EfA())) {
                    long jM9324getKeyZmokQxo2 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9081getDirectionLeftEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9183getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9082getDirectionRightEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9184getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9083getDirectionUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9185getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9078getDirectionDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo2, Key.INSTANCE.m9182getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo2, KeyModifiers.INSTANCE.m3457getCtrlAuQ4EfA())) {
                    long jM9324getKeyZmokQxo3 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9081getDirectionLeftEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9183getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.LEFT_WORD;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9082getDirectionRightEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9184getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.RIGHT_WORD;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9083getDirectionUpEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9185getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9078getDirectionDownEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9182getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9116getHEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9076getDeleteEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo3, Key.INSTANCE.m9021getBackslashEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DESELECT;
                    }
                } else if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo2, KeyModifiers.INSTANCE.m3463getShiftAuQ4EfA())) {
                    long jM9324getKeyZmokQxo4 = KeyEvent_androidKt.m9324getKeyZmokQxo(event);
                    if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo4, Key.INSTANCE.m9157getMoveHomeEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo4, Key.INSTANCE.m9193getNumPadMoveHomeEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m9004equalsimpl0(jM9324getKeyZmokQxo4, Key.INSTANCE.m9156getMoveEndEK5gGoQ()) || Key.m9004equalsimpl0(jM9324getKeyZmokQxo4, Key.INSTANCE.m9192getNumPadMoveEndEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_END;
                    }
                } else if (KeyModifiers.m3427equalsimpl0(iM3465getModifiersZmokQxo2, KeyModifiers.INSTANCE.m3454getAltAuQ4EfA()) && Key.m9004equalsimpl0(KeyEvent_androidKt.m9324getKeyZmokQxo(event), Key.INSTANCE.m9076getDeleteEK5gGoQ())) {
                    keyCommand2 = KeyCommand.DELETE_TO_LINE_END;
                }
                return keyCommand2 == null ? keyMappingM3421commonKeyMappingVSD1kLU.mo3420mapZmokQxo(event) : keyCommand2;
            }
        };
    }
}
