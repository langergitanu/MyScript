package com.myscript.nebo.editing;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenQuickToolTrigger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B?\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\tR>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/editing/SpenQuickToolTrigger;", "Landroid/view/View$OnHoverListener;", "onTrigger", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "onHoverChange", "Lkotlin/Function1;", "", "hovering", "getOnHoverChange", "()Lkotlin/jvm/functions/Function1;", "setOnHoverChange", "(Lkotlin/jvm/functions/Function1;)V", "buttonWasDown", "suppressNextTrigger", "onHover", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "trackButtonWhileOpen", "handle", "notifyHoverChange", "reset", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpenQuickToolTrigger implements View.OnHoverListener {
    public static final int $stable = 8;
    private boolean buttonWasDown;
    private Function1<? super Boolean, Unit> onHoverChange;
    private final Function2<Float, Float, Unit> onTrigger;
    private boolean suppressNextTrigger;

    /* JADX WARN: Multi-variable type inference failed */
    public SpenQuickToolTrigger(Function2<? super Float, ? super Float, Unit> onTrigger) {
        Intrinsics.checkNotNullParameter(onTrigger, "onTrigger");
        this.onTrigger = onTrigger;
    }

    public final Function1<Boolean, Unit> getOnHoverChange() {
        return this.onHoverChange;
    }

    public final void setOnHoverChange(Function1<? super Boolean, Unit> function1) {
        this.onHoverChange = function1;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        handle(v, event, true);
        return false;
    }

    public final void trackButtonWhileOpen(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        handle(v, event, false);
    }

    private final void handle(View v, MotionEvent event, boolean notifyHoverChange) {
        Function1<? super Boolean, Unit> function1;
        Function1<? super Boolean, Unit> function12;
        if (event.getToolType(0) != 2) {
            return;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 7) {
            boolean zIsButtonPressed = event.isButtonPressed(32);
            boolean z = this.buttonWasDown;
            if (!z && zIsButtonPressed) {
                this.buttonWasDown = true;
                return;
            }
            if (!z || zIsButtonPressed) {
                return;
            }
            this.buttonWasDown = false;
            if (!this.suppressNextTrigger) {
                this.onTrigger.invoke(Float.valueOf(event.getX()), Float.valueOf(event.getY()));
            }
            this.suppressNextTrigger = false;
            return;
        }
        if (actionMasked == 9) {
            if (!event.isButtonPressed(32)) {
                this.suppressNextTrigger = false;
            }
            if (!notifyHoverChange || (function1 = this.onHoverChange) == null) {
                return;
            }
            function1.invoke(true);
            return;
        }
        if (actionMasked != 10) {
            return;
        }
        if (this.buttonWasDown) {
            this.suppressNextTrigger = true;
        }
        this.buttonWasDown = false;
        if (!notifyHoverChange || (function12 = this.onHoverChange) == null) {
            return;
        }
        function12.invoke(false);
    }

    public final void reset() {
        this.buttonWasDown = false;
        this.suppressNextTrigger = false;
    }
}
