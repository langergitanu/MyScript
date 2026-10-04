package com.myscript.nebo.editing.impl.p027ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.myscript.snt.core.ToolType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NestedScrollableSwipeFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001eH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/NestedScrollableSwipeFilter;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "initialX", "", "initialY", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "interactionContext", "Lcom/myscript/nebo/editing/impl/ui/InteractionContext;", "getInteractionContext", "()Lcom/myscript/nebo/editing/impl/ui/InteractionContext;", "canChildScroll", "", "orientation", "delta", "isSwipeAllowed", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "handleInterceptTouchEvent", "", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NestedScrollableSwipeFilter extends FrameLayout {
    private float initialX;
    private float initialY;
    private int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableSwipeFilter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableSwipeFilter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableSwipeFilter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ViewPager2 getViewPager() {
        View view;
        Object parent = getParent();
        if (parent instanceof View) {
            view = (View) parent;
            while (view != null && !(view instanceof ViewPager2)) {
                Object parent2 = view.getParent();
                if (parent2 instanceof View) {
                    view = (View) parent2;
                }
            }
            if (view instanceof ViewPager2) {
                return (ViewPager2) view;
            }
            return null;
        }
        view = null;
    }

    private final InteractionContext getInteractionContext() {
        ActivityResultCaller activityResultCallerFindFragment = FragmentManager.findFragment(this);
        if (activityResultCallerFindFragment instanceof InteractionContext) {
            return (InteractionContext) activityResultCallerFindFragment;
        }
        return null;
    }

    private final boolean canChildScroll(int orientation, float delta) {
        int i = -((int) Math.signum(delta));
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        if (orientation == 0) {
            if (childAt != null) {
                return childAt.canScrollHorizontally(i);
            }
            return false;
        }
        if (orientation != 1) {
            throw new IllegalArgumentException();
        }
        if (childAt != null) {
            return childAt.canScrollVertically(i);
        }
        return false;
    }

    private final boolean isSwipeAllowed(MotionEvent event) {
        if (event.getToolType(0) == 2) {
            return false;
        }
        InteractionContext interactionContext = getInteractionContext();
        boolean activePenEnabled = interactionContext != null ? interactionContext.getActivePenEnabled() : false;
        InteractionContext interactionContext2 = getInteractionContext();
        boolean z = (interactionContext2 != null ? interactionContext2.getCurrentToolType() : null) == ToolType.InteractionTool;
        InteractionContext interactionContext3 = getInteractionContext();
        boolean zIsCurrentToolInteracting = interactionContext3 != null ? interactionContext3.isCurrentToolInteracting() : true;
        return event.getPointerCount() == 1 && ((zIsCurrentToolInteracting && activePenEnabled && event.getToolType(0) != 2) || (zIsCurrentToolInteracting && !activePenEnabled && z));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    private final void handleInterceptTouchEvent(MotionEvent e) {
        ViewPager2 viewPager = getViewPager();
        if (viewPager != null) {
            int orientation = viewPager.getOrientation();
            ViewPager2 viewPager2 = getViewPager();
            if (viewPager2 == null || viewPager2.isUserInputEnabled()) {
                if (!isSwipeAllowed(e)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return;
                }
                if (canChildScroll(orientation, -1.0f) || canChildScroll(orientation, 1.0f)) {
                    if (e.getAction() == 0) {
                        this.initialX = e.getX();
                        this.initialY = e.getY();
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return;
                    }
                    if (e.getAction() == 2) {
                        float x = e.getX() - this.initialX;
                        float y = e.getY() - this.initialY;
                        boolean z = orientation == 0;
                        float fAbs = Math.abs(x) * (z ? 0.5f : 1.0f);
                        float fAbs2 = Math.abs(y) * (z ? 1.0f : 0.5f);
                        int i = this.touchSlop;
                        if (fAbs > i || fAbs2 > i) {
                            if (z == (fAbs2 > fAbs)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                return;
                            }
                            if (!z) {
                                x = y;
                            }
                            if (canChildScroll(orientation, x)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    }
                }
            }
        }
    }
}
