package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCircularViewAdapter;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import com.samsung.android.spen.C8357R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenCircularRecyclerView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 )2\u00020\u0001:\u0002)*B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0014J\u0014\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mGestureDetector", "Landroid/view/GestureDetector;", "mLayoutManager", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularLayoutManager;", "mLastEvent", "Landroid/view/MotionEvent;", "mInterceptTouch", "", "mViewHolderTouched", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter$ColorViewHolder;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter;", "mAngleTracker", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularAngleTracker;", "mCenter", "Landroid/graphics/PointF;", "getMCenter", "()Landroid/graphics/PointF;", "close", "", "dispatchTouchEvent", "ev", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "onInterceptTouchEvent", "e", "dispatchHoverEvent", "setDialItems", FirebaseAnalytics.Param.ITEMS, "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "setSelectedColor", "colorIndex", "", "Companion", "GestureListener", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenCircularRecyclerView extends RecyclerView {
    private static final float SCROLLER_FRICTION = 0.1f;
    private static final String TAG = "SpenCircularRecycleView";
    private SpenCircularAngleTracker mAngleTracker;
    private GestureDetector mGestureDetector;
    private boolean mInterceptTouch;
    private MotionEvent mLastEvent;
    private final SpenCircularLayoutManager mLayoutManager;
    private SpenCircularViewAdapter.ColorViewHolder mViewHolderTouched;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpenCircularRecyclerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }

    public /* synthetic */ SpenCircularRecyclerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCircularRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOverScrollMode(2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_circular_recycle_view_radius);
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
        SpenCircularLayoutManager spenCircularLayoutManager = new SpenCircularLayoutManager(dimensionPixelSize);
        this.mLayoutManager = spenCircularLayoutManager;
        setLayoutManager(spenCircularLayoutManager);
        this.mAngleTracker = new SpenCircularAngleTracker(0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PointF getMCenter() {
        return new PointF(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public final void close() {
        this.mLastEvent = null;
        this.mLayoutManager.close();
        this.mViewHolderTouched = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View viewFindChildViewUnder;
        Intrinsics.checkNotNullParameter(ev, "ev");
        this.mGestureDetector.onTouchEvent(ev);
        if (ev.getAction() == 0 && (viewFindChildViewUnder = findChildViewUnder(ev.getX(), ev.getY())) != null) {
            RecyclerView.ViewHolder childViewHolder = getChildViewHolder(viewFindChildViewUnder);
            this.mViewHolderTouched = childViewHolder instanceof SpenCircularViewAdapter.ColorViewHolder ? (SpenCircularViewAdapter.ColorViewHolder) childViewHolder : null;
        }
        return this.mInterceptTouch || super.dispatchTouchEvent(ev);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 1 || event.getActionMasked() == 3) {
            this.mInterceptTouch = false;
        }
        return super.onTouchEvent(event);
    }

    public final void setDialItems(List<SpenSettingQTColorDialLayout.ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mLayoutManager.setDialItems(items);
    }

    public final void setSelectedColor(int colorIndex) {
        Log.i(TAG, "setSelectedColor colorIndex=" + colorIndex);
        RecyclerView.Adapter adapter = getAdapter();
        SpenCircularViewAdapter spenCircularViewAdapter = adapter instanceof SpenCircularViewAdapter ? (SpenCircularViewAdapter) adapter : null;
        if (spenCircularViewAdapter == null) {
            return;
        }
        spenCircularViewAdapter.setSelectedPosition(colorIndex);
        if (colorIndex >= 0) {
            this.mLayoutManager.setFirstVisibleItemPosition(colorIndex);
        }
    }

    /* JADX INFO: compiled from: SpenCircularRecyclerView.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0011"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRecyclerView$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRecyclerView;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            SpenCircularRecyclerView.this.mLastEvent = MotionEvent.obtain(e);
            SpenCircularRecyclerView.this.mInterceptTouch = false;
            SpenCircularRecyclerView.this.mAngleTracker.start(SpenSettingQTUtil.getAngleByTouch(e, SpenCircularRecyclerView.this.getMCenter()));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            SpenChipView colorChipView;
            Intrinsics.checkNotNullParameter(e2, "e2");
            int iSqrt = (int) Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
            if (iSqrt == 0) {
                return false;
            }
            SpenCircularRecyclerView.this.mAngleTracker.move(SpenSettingQTUtil.getAngleByTouch(e2, SpenCircularRecyclerView.this.getMCenter()));
            SpenSettingQTUtil.ScrollDirection scrollDirection = SpenCircularRecyclerView.this.mAngleTracker.getScrollDirection();
            SpenCircularRecyclerView.this.mLastEvent = MotionEvent.obtain(e2);
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
                return false;
            }
            if (!SpenCircularRecyclerView.this.mInterceptTouch) {
                MotionEvent motionEventObtain = MotionEvent.obtain(e2);
                motionEventObtain.setAction(3);
                SpenCircularViewAdapter.ColorViewHolder colorViewHolder = SpenCircularRecyclerView.this.mViewHolderTouched;
                if (colorViewHolder != null && (colorChipView = colorViewHolder.getColorChipView()) != null) {
                    colorChipView.onTouchEvent(motionEventObtain);
                }
            }
            SpenCircularRecyclerView.this.mInterceptTouch = true;
            SpenCircularRecyclerView.this.mLayoutManager.setScrollDirection(scrollDirection);
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE) {
                iSqrt *= -1;
            }
            SpenCircularRecyclerView.this.scrollBy(iSqrt, 0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            SpenSettingQTUtil.ScrollDirection scrollDirection = SpenCircularRecyclerView.this.mAngleTracker.getScrollDirection();
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
                return false;
            }
            SpenCircularRecyclerView.this.mInterceptTouch = true;
            SpenCircularRecyclerView.this.mLayoutManager.setScrollDirection(scrollDirection);
            OverScroller overScroller = new OverScroller(SpenCircularRecyclerView.this.getContext());
            overScroller.setFriction(0.1f);
            overScroller.fling(0, 0, (int) velocityX, (int) velocityY, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int iHypot = (int) Math.hypot(overScroller.getFinalX(), overScroller.getFinalY());
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE) {
                iHypot *= -1;
            }
            SpenCircularRecyclerView.this.smoothScrollBy(iHypot, 0);
            return true;
        }
    }
}
