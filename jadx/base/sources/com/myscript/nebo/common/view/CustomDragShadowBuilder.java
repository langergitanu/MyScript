package com.myscript.nebo.common.view;

import android.R;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.log.TechnicalLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public class CustomDragShadowBuilder extends View.DragShadowBuilder {
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private Rect mBackgroundRect;
    private View mBackgroundView;
    private int mPadding;
    private final Point mTouchPoint;
    private Rect mViewRect;

    protected static boolean startDrag(View view, ClipData clipData, CustomDragShadowBuilder customDragShadowBuilder) {
        try {
            return ViewCompat.startDragAndDrop(view, clipData, customDragShadowBuilder, null, 512);
        } catch (IllegalStateException unused) {
            if (view == null) {
                return false;
            }
            ((TechnicalLoggerProvider) view.getContext().getApplicationContext()).provideTechnicalLogger().logError(new IllegalStateException("Drag shadow dimensions must not be negative (touchPoint = " + customDragShadowBuilder.mTouchPoint + ", padding = " + customDragShadowBuilder.mPadding + ", view width = " + view.getWidth() + ", view height = " + view.getHeight() + ")"));
            return false;
        }
    }

    protected CustomDragShadowBuilder(View view, Point point) {
        super(view);
        Point point2 = new Point();
        this.mTouchPoint = point2;
        Context context = view.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.mBackgroundColor = typedValue.data;
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setColor(this.mBackgroundColor);
        this.mBackgroundRect = new Rect();
        point2.set(point.x, point.y);
        this.mPadding = ScreenUtils.dpToPx(context, 22.0f);
        this.mViewRect = new Rect();
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        View view2 = new View(context);
        this.mBackgroundView = view2;
        view2.setBackground(ResourcesCompat.getDrawable(resources, C6183R.drawable.drag_elevation_squared, theme));
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        View view = getView();
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = this.mViewRect;
        int i = this.mPadding;
        rect.set(0, 0, (i * 2) + width, (i * 2) + height);
        this.mBackgroundRect.set(this.mViewRect);
        Rect rect2 = this.mBackgroundRect;
        int i2 = this.mPadding;
        rect2.inset(i2, i2);
        int i3 = this.mPadding;
        point.set(width + (i3 * 2), height + (i3 * 2));
        point2.set(this.mTouchPoint.x + this.mPadding, this.mTouchPoint.y + this.mPadding);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        this.mBackgroundView.layout(this.mViewRect.left, this.mViewRect.top, this.mViewRect.right, this.mViewRect.bottom);
        this.mBackgroundView.draw(canvas);
        canvas.drawRect(this.mBackgroundRect, this.mBackgroundPaint);
        int i = this.mPadding;
        canvas.translate(i, i);
        getView().draw(canvas);
    }
}
