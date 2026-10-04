package com.myscript.nebo.grid;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;

/* JADX INFO: loaded from: classes7.dex */
public class PageDragShadowBuilder extends View.DragShadowBuilder {
    private View mBackgroundView;
    private Path mClipPath;
    private int mCornerRadius;
    private boolean mIsDarkMode;
    private int mPadding;
    private Drawable mPageForeground;
    private RectF mRoundedClipRect;
    private final Point mTouchPoint;
    private Rect mViewRect;

    protected static void startDrag(View view, ClipData clipData, Point point) {
        ViewCompat.startDragAndDrop(view, clipData, new PageDragShadowBuilder(view, point), null, 512);
    }

    protected PageDragShadowBuilder(View view, Point point) {
        super(view);
        Point point2 = new Point();
        this.mTouchPoint = point2;
        this.mClipPath = new Path();
        this.mRoundedClipRect = new RectF();
        Context context = view.getContext();
        point2.set(point.x, point.y);
        this.mCornerRadius = context.getResources().getDimensionPixelSize(C6079R.dimen.page_drag_shadow_corner);
        this.mPadding = context.getResources().getDimensionPixelSize(C6079R.dimen.page_drag_shadow_padding);
        this.mViewRect = new Rect();
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        this.mIsDarkMode = DarkModeUtils.isDarkMode(view);
        this.mPageForeground = getView().getForeground();
        View view2 = new View(context);
        this.mBackgroundView = view2;
        view2.setBackground(ResourcesCompat.getDrawable(resources, C6183R.drawable.drag_elevation_rounded, theme));
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        View view = getView();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect = this.mViewRect;
        int i = this.mPadding;
        rect.set(0, 0, (i * 2) + measuredWidth, (i * 2) + measuredHeight);
        point.set(Math.max((this.mPadding * 2) + measuredWidth, 1), Math.max((this.mPadding * 2) + measuredHeight, 1));
        point2.set(Math.max(this.mTouchPoint.x + this.mPadding, 0), Math.max(this.mTouchPoint.y + this.mPadding, 0));
        this.mRoundedClipRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mClipPath.reset();
        Path path = this.mClipPath;
        RectF rectF = this.mRoundedClipRect;
        int i2 = this.mCornerRadius;
        path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        this.mBackgroundView.layout(this.mViewRect.left, this.mViewRect.top, this.mViewRect.right, this.mViewRect.bottom);
        this.mBackgroundView.draw(canvas);
        int i = this.mPadding;
        canvas.translate(i, i);
        View view = getView();
        if (!this.mIsDarkMode) {
            view.setForeground(null);
        }
        canvas.clipPath(this.mClipPath);
        view.draw(canvas);
        if (this.mIsDarkMode) {
            return;
        }
        view.setForeground(this.mPageForeground);
    }
}
