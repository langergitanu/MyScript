package com.samsung.android.sdk.pen.setting.quicktool;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenCircularLayoutManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0003J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "radius", "", "<init>", "(I)V", "mScrollDirection", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil$ScrollDirection;", "mRadius", "mTotalItemCount", "mTotalItemVisible", "mAnglePerPixel", "", "mAngleStep", "mScrollAngleOffset", "mFirstItemAngleOffset", "mFirstVisibleItemPos", "mDividerIdxSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "close", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "canScrollHorizontally", "", "scrollHorizontallyBy", "dx", "setDialItems", FirebaseAnalytics.Param.ITEMS, "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "setScrollDirection", "direction", "getScrollDistance", "distance", "isLeftToRight", "setFirstVisibleItemPosition", "visibleItemPos", "needLayoutChildren", "updateScrollAngleOffset", "angle", "updateFirstVisibleItem", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenCircularLayoutManager extends RecyclerView.LayoutManager {
    private static final int MAX_ITEMS_VISIBLE = 12;
    private static final String TAG = "SpenCircularLayoutManager";
    private double mAnglePerPixel;
    private double mAngleStep;
    private HashSet<Integer> mDividerIdxSet;
    private double mFirstItemAngleOffset;
    private int mFirstVisibleItemPos;
    private int mRadius;
    private double mScrollAngleOffset;
    private SpenSettingQTUtil.ScrollDirection mScrollDirection = SpenSettingQTUtil.ScrollDirection.DIR_NONE;
    private int mTotalItemCount;
    private int mTotalItemVisible;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    public SpenCircularLayoutManager(int i) {
        this.mRadius = i;
        this.mAnglePerPixel = 360.0d / (((double) i) * 6.283185307179586d);
    }

    public final void close() {
        this.mDividerIdxSet = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        SpenCircularLayoutManager spenCircularLayoutManager = this;
        RecyclerView.Recycler recycler2 = recycler;
        Intrinsics.checkNotNullParameter(state, "state");
        if (spenCircularLayoutManager.mTotalItemCount == 0 || recycler2 == null || state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        int width = spenCircularLayoutManager.getWidth() / 2;
        int height = spenCircularLayoutManager.getHeight() / 2;
        int i = spenCircularLayoutManager.mTotalItemVisible;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            int i4 = (spenCircularLayoutManager.mFirstVisibleItemPos + i3) % spenCircularLayoutManager.mTotalItemCount;
            View viewForPosition = recycler2.getViewForPosition(i4);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            spenCircularLayoutManager.addView(viewForPosition);
            spenCircularLayoutManager.measureChildWithMargins(viewForPosition, i2, i2);
            int decoratedMeasuredWidth = spenCircularLayoutManager.getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = spenCircularLayoutManager.getDecoratedMeasuredHeight(viewForPosition);
            int i5 = i3;
            double radians = Math.toRadians((((double) (1 - i3)) * spenCircularLayoutManager.mAngleStep) + spenCircularLayoutManager.mScrollAngleOffset);
            int i6 = width;
            double d = 2;
            int iCos = (int) ((((double) width) + (((double) spenCircularLayoutManager.mRadius) * Math.cos(radians))) - (((double) decoratedMeasuredWidth) / d));
            int iSin = (int) ((((double) height) + (((double) spenCircularLayoutManager.mRadius) * Math.sin(radians))) - (((double) decoratedMeasuredHeight) / d));
            HashSet<Integer> hashSet = spenCircularLayoutManager.mDividerIdxSet;
            if (hashSet != null && hashSet.contains(Integer.valueOf(i4))) {
                viewForPosition.setRotation((float) Math.toDegrees(radians));
            }
            spenCircularLayoutManager.layoutDecorated(viewForPosition, iCos, iSin, iCos + decoratedMeasuredWidth, iSin + decoratedMeasuredHeight);
            i3 = i5 + 1;
            spenCircularLayoutManager = this;
            recycler2 = recycler;
            width = i6;
            i2 = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!needLayoutChildren(dx)) {
            return super.scrollHorizontallyBy(dx, recycler, state);
        }
        double d = ((double) dx) * this.mAnglePerPixel;
        updateScrollAngleOffset(d);
        updateFirstVisibleItem(d);
        onLayoutChildren(recycler, state);
        return dx;
    }

    public final void setDialItems(List<SpenSettingQTColorDialLayout.ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int size = items.size();
        this.mTotalItemCount = size;
        Log.i(TAG, "setTotalItemCount totalItemCount=" + size);
        if (this.mTotalItemCount <= 0) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Iterator<T> it = items.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (((SpenSettingQTColorDialLayout.ColorDialItem) it.next()).getType() == SpenSettingQTColorDialLayout.DialItemType.DIVIDER) {
                hashSet.add(Integer.valueOf(i));
            }
            i = i2;
        }
        if (!hashSet.isEmpty()) {
            this.mDividerIdxSet = hashSet;
        }
        int iMin = (int) Math.min(this.mTotalItemCount, 12.0d);
        this.mTotalItemVisible = iMin;
        this.mAngleStep = 360.0d / ((double) iMin);
        this.mFirstVisibleItemPos = this.mTotalItemCount - 1;
    }

    public final void setScrollDirection(SpenSettingQTUtil.ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.mScrollDirection = direction;
    }

    public final int getScrollDistance(double distance, boolean isLeftToRight) {
        double d;
        int i = 0;
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (isLeftToRight) {
            double d3 = this.mScrollAngleOffset - (distance * this.mAnglePerPixel);
            double d4 = 360;
            int i2 = (int) (d3 / d4);
            if (i2 < 0) {
                i2 *= -1;
            }
            while (d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d3 += 360.0d;
            }
            int i3 = this.mTotalItemVisible;
            while (true) {
                if (i >= i3) {
                    break;
                }
                double d5 = this.mAngleStep;
                d2 = ((double) i) * d5;
                if (d2 > d3) {
                    d2 -= d5;
                    break;
                }
                if (d2 == d3) {
                    break;
                }
                i++;
            }
            double d6 = this.mScrollAngleOffset;
            d = d6 > d2 ? (((double) (i2 * 360)) + d6) - d2 : (d4 - d2) + ((double) (i2 * 360)) + d6;
        } else {
            double d7 = (distance * this.mAnglePerPixel) + this.mScrollAngleOffset;
            double d8 = 360;
            int i4 = (int) (d7 / d8);
            double d9 = d7 % d8;
            int i5 = this.mTotalItemVisible;
            while (i < i5) {
                d2 = ((double) i) * this.mAngleStep;
                if (d2 >= d9) {
                    break;
                }
                i++;
            }
            d = (((double) (i4 * 360)) + (d2 >= d9 ? 360.0d + d2 : 360.0d)) - this.mScrollAngleOffset;
        }
        return (int) (d / this.mAnglePerPixel);
    }

    public final void setFirstVisibleItemPosition(int visibleItemPos) {
        Log.i(TAG, "setFirstVisibleItemPosition visibleItemPos= " + visibleItemPos);
        if (visibleItemPos == 0) {
            visibleItemPos = this.mTotalItemCount;
        }
        this.mFirstVisibleItemPos = visibleItemPos - 1;
        this.mScrollAngleOffset = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        requestLayout();
    }

    private final boolean needLayoutChildren(int dx) {
        if (dx == 0 || this.mScrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
            return false;
        }
        if (this.mScrollDirection != SpenSettingQTUtil.ScrollDirection.DIR_COUNTER_CLOCK_WISE || dx >= 0) {
            return this.mScrollDirection != SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE || dx <= 0;
        }
        return false;
    }

    private final void updateScrollAngleOffset(double angle) {
        double d = this.mScrollAngleOffset + angle;
        this.mScrollAngleOffset = d;
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.mScrollAngleOffset = d + 360.0d;
        } else {
            this.mScrollAngleOffset = d % 360.0d;
        }
    }

    private final void updateFirstVisibleItem(double angle) {
        int i = this.mTotalItemCount;
        if (i == 0) {
            return;
        }
        double d = this.mFirstItemAngleOffset + angle;
        this.mFirstItemAngleOffset = d;
        double d2 = this.mAngleStep;
        if (d >= d2) {
            int i2 = (int) (d / d2);
            this.mFirstItemAngleOffset = d % d2;
            this.mFirstVisibleItemPos = (this.mFirstVisibleItemPos + i2) % i;
            this.mScrollAngleOffset -= d2 * ((double) i2);
            return;
        }
        if (d <= (-d2)) {
            int i3 = (int) (d / d2);
            this.mFirstItemAngleOffset = d % d2;
            int i4 = (this.mFirstVisibleItemPos + i3) % i;
            this.mFirstVisibleItemPos = i4;
            if (i4 < 0) {
                this.mFirstVisibleItemPos = i + i4;
            }
            this.mScrollAngleOffset -= d2 * ((double) i3);
        }
    }
}
