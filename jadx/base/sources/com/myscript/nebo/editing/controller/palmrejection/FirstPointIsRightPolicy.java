package com.myscript.nebo.editing.controller.palmrejection;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.myscript.android.utils.MotionEventSPenExt;
import com.myscript.nebo.editing.impl.p027ui.IInputHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirstPointIsRightPolicy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/palmrejection/FirstPointIsRightPolicy;", "Lcom/myscript/nebo/editing/controller/palmrejection/IPalmRejectionPolicy;", "inputHandler", "Lcom/myscript/nebo/editing/impl/ui/IInputHandler;", "<init>", "(Lcom/myscript/nebo/editing/impl/ui/IInputHandler;)V", "eventPointerId", "", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FirstPointIsRightPolicy implements IPalmRejectionPolicy {
    private static final int NO_POINTER_ID = -1;
    private int eventPointerId;
    private final IInputHandler inputHandler;

    public FirstPointIsRightPolicy(IInputHandler inputHandler) {
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        this.inputHandler = inputHandler;
        this.eventPointerId = -1;
    }

    @Override // com.myscript.nebo.editing.controller.palmrejection.IPalmRejectionPolicy
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMaskedSPen = MotionEventSPenExt.getActionMaskedSPen(event);
        int pointerId = event.getPointerId(event.getActionIndex());
        if (this.eventPointerId == pointerId && (actionMaskedSPen == 2 || actionMaskedSPen == 1)) {
            this.inputHandler.handleEventHistory(event);
        } else if (actionMaskedSPen == 0) {
            this.eventPointerId = pointerId;
        }
        boolean zHandleEvent = this.eventPointerId == pointerId ? this.inputHandler.handleEvent(event) : false;
        if ((actionMaskedSPen == 1 || actionMaskedSPen == 6) && this.eventPointerId == pointerId) {
            this.eventPointerId = -1;
        }
        return zHandleEvent;
    }
}
