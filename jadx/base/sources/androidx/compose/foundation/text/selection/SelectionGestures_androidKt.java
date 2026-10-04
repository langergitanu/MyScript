package androidx.compose.foundation.text.selection;

import android.view.MotionEvent;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerType;
import androidx.core.view.InputDeviceCompat;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionGestures.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"isMouseOrTouchPad", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "FirstLongPressSelectionAdjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getFirstLongPressSelectionAdjustment", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SelectionGestures_androidKt {
    private static final SelectionAdjustment FirstLongPressSelectionAdjustment = SelectionAdjustment.INSTANCE.getWord();

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isMouseOrTouchPad(PointerEvent pointerEvent) {
        MotionEvent motionEvent;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (PointerType.m9565equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m9570getMouseT8wyACA())) {
                i++;
            } else {
                MotionEvent motionEvent2 = pointerEvent.getMotionEvent();
                if ((motionEvent2 == null || !motionEvent2.isFromSource(8194)) && ((motionEvent = pointerEvent.getMotionEvent()) == null || !motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD))) {
                    return false;
                }
            }
        }
    }

    public static final SelectionAdjustment getFirstLongPressSelectionAdjustment() {
        return FirstLongPressSelectionAdjustment;
    }
}
