package com.myscript.nebo.editing.controller.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.myscript.snt.core.ToolType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchGestureDetector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001d\u001eB/\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/gesture/TouchGestureDetector;", "Landroid/view/GestureDetector;", "Lcom/myscript/nebo/editing/controller/gesture/CurrentState;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "gestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "doubleTapListener", "Landroid/view/GestureDetector$OnDoubleTapListener;", "touchesGestureDetector", "Lcom/myscript/nebo/editing/controller/gesture/TouchGestureDetector$TouchGestureDetectorListener;", "<init>", "(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/view/GestureDetector$OnDoubleTapListener;Lcom/myscript/nebo/editing/controller/gesture/TouchGestureDetector$TouchGestureDetectorListener;)V", "currentToolType", "Lcom/myscript/snt/core/ToolType;", "getCurrentToolType", "()Lcom/myscript/snt/core/ToolType;", "setCurrentToolType", "(Lcom/myscript/snt/core/ToolType;)V", "activePenMode", "", "getActivePenMode", "()Z", "setActivePenMode", "(Z)V", "canceled", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "TouchGestureDetectorListener", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TouchGestureDetector extends GestureDetector implements CurrentState {
    private static final int WAIT_FOR_NEW_TOUCH_POINT_DELAY = 40;
    private boolean activePenMode;
    private boolean canceled;
    private ToolType currentToolType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TouchGestureDetector(Context context, GestureDetector.OnGestureListener onGestureListener, GestureDetector.OnDoubleTapListener doubleTapListener) {
        this(context, onGestureListener, doubleTapListener, null, 8, null);
        Intrinsics.checkNotNullParameter(doubleTapListener, "doubleTapListener");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchGestureDetector(Context context, GestureDetector.OnGestureListener onGestureListener, GestureDetector.OnDoubleTapListener doubleTapListener, TouchGestureDetectorListener touchesGestureDetector) {
        super(context, touchesGestureDetector);
        Intrinsics.checkNotNullParameter(doubleTapListener, "doubleTapListener");
        Intrinsics.checkNotNullParameter(touchesGestureDetector, "touchesGestureDetector");
        this.currentToolType = ToolType.None;
        touchesGestureDetector.setCurrentStateProvider(this);
    }

    public /* synthetic */ TouchGestureDetector(Context context, GestureDetector.OnGestureListener onGestureListener, GestureDetector.OnDoubleTapListener onDoubleTapListener, TouchGestureDetectorListener touchGestureDetectorListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onGestureListener, onDoubleTapListener, (i & 8) != 0 ? new TouchGestureDetectorListener(onGestureListener, onDoubleTapListener) : touchGestureDetectorListener);
    }

    @Override // com.myscript.nebo.editing.controller.gesture.CurrentState
    public ToolType getCurrentToolType() {
        return this.currentToolType;
    }

    @Override // com.myscript.nebo.editing.controller.gesture.CurrentState
    public void setCurrentToolType(ToolType toolType) {
        Intrinsics.checkNotNullParameter(toolType, "<set-?>");
        this.currentToolType = toolType;
    }

    @Override // com.myscript.nebo.editing.controller.gesture.CurrentState
    public boolean getActivePenMode() {
        return this.activePenMode;
    }

    @Override // com.myscript.nebo.editing.controller.gesture.CurrentState
    public void setActivePenMode(boolean z) {
        this.activePenMode = z;
    }

    /* JADX INFO: compiled from: TouchGestureDetector.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J*\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006!"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/gesture/TouchGestureDetector$TouchGestureDetectorListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "gestureListener", "doubleTapListener", "<init>", "(Landroid/view/GestureDetector$OnGestureListener;Landroid/view/GestureDetector$OnDoubleTapListener;)V", "currentStateProvider", "Lcom/myscript/nebo/editing/controller/gesture/CurrentState;", "getCurrentStateProvider", "()Lcom/myscript/nebo/editing/controller/gesture/CurrentState;", "setCurrentStateProvider", "(Lcom/myscript/nebo/editing/controller/gesture/CurrentState;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onShowPress", "", "onSingleTapUp", "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "onLongPress", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class TouchGestureDetectorListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        private CurrentState currentStateProvider;
        private final GestureDetector.OnDoubleTapListener doubleTapListener;
        private final GestureDetector.OnGestureListener gestureListener;

        public TouchGestureDetectorListener(GestureDetector.OnGestureListener onGestureListener, GestureDetector.OnDoubleTapListener doubleTapListener) {
            Intrinsics.checkNotNullParameter(doubleTapListener, "doubleTapListener");
            this.gestureListener = onGestureListener;
            this.doubleTapListener = doubleTapListener;
        }

        public final CurrentState getCurrentStateProvider() {
            return this.currentStateProvider;
        }

        public final void setCurrentStateProvider(CurrentState currentState) {
            this.currentStateProvider = currentState;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            GestureDetector.OnGestureListener onGestureListener;
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) == 1 && (onGestureListener = this.gestureListener) != null) {
                return onGestureListener.onDown(e);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e) {
            GestureDetector.OnGestureListener onGestureListener;
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) != 1 || (onGestureListener = this.gestureListener) == null) {
                return;
            }
            onGestureListener.onShowPress(e);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            GestureDetector.OnGestureListener onGestureListener;
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) == 1 && (onGestureListener = this.gestureListener) != null) {
                return onGestureListener.onSingleTapUp(e);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) != 1) {
                return false;
            }
            return this.doubleTapListener.onSingleTapConfirmed(e);
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) != 1) {
                return false;
            }
            return this.doubleTapListener.onDoubleTap(e);
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getToolType(e.getActionIndex()) != 1) {
                return false;
            }
            return this.doubleTapListener.onDoubleTapEvent(e);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            GestureDetector.OnGestureListener onGestureListener = this.gestureListener;
            if (onGestureListener != null) {
                onGestureListener.onLongPress(e);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            GestureDetector.OnGestureListener onGestureListener;
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (e1 == null || e1.getToolType(e1.getActionIndex()) != 1 || (onGestureListener = this.gestureListener) == null) {
                return false;
            }
            return onGestureListener.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            GestureDetector.OnGestureListener onGestureListener;
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (e1 == null || e1.getToolType(e1.getActionIndex()) != 1 || (onGestureListener = this.gestureListener) == null) {
                return false;
            }
            return onGestureListener.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.canceled = false;
        } else if (this.canceled) {
            return false;
        }
        if (ev.getPointerCount() > 2) {
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            motionEventObtain.setAction(3);
            boolean zOnTouchEvent = super.onTouchEvent(motionEventObtain);
            this.canceled = true;
            return zOnTouchEvent;
        }
        boolean z = !getActivePenMode() && getCurrentToolType() == ToolType.Pen && ev.getToolType(ev.getActionIndex()) == 1;
        boolean z2 = getActivePenMode() && getCurrentToolType() == ToolType.Pen && ev.getToolType(ev.getActionIndex()) == 2;
        boolean z3 = ev.getAction() == 2 && ev.getEventTime() < ev.getDownTime() + ((long) 40);
        if (z || z2 || z3) {
            return false;
        }
        return super.onTouchEvent(ev);
    }
}
