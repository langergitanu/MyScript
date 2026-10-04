package com.myscript.nebo.editing.debug;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.editing.C6421R;
import com.myscript.snt.core.LayoutGrid;
import com.myscript.snt.core.PageController;

/* JADX INFO: loaded from: classes7.dex */
public class DebugView extends View implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final float GRID_DASH_SPACE = 5.0f;
    private static final float GRID_DASH_WIDTH = 5.0f;
    private Path dashedLine;
    private Paint gridPaint;
    private PageController pageController;
    private ViewTransform viewTransform;

    public DebugView(Context context) {
        this(context, null, 0, 0);
    }

    public DebugView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public DebugView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DebugView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(this);
        reloadPreferences();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        reloadPreferences();
    }

    private void reloadPreferences() {
        setVisibility(PreferenceManager.getDefaultSharedPreferences(getContext()).getBoolean(getResources().getString(C6421R.string.showLayoutGridPreferenceKey), false) ? 0 : 8);
        postInvalidate();
    }

    public void setPageController(PageController pageController) {
        if (pageController != null) {
            this.pageController = PageController.newRef(pageController);
            this.viewTransform = pageController.getViewTransform();
        } else {
            release();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Resources resources = getResources();
        if (this.pageController == null || this.viewTransform == null) {
            return;
        }
        int height = getHeight();
        if (this.gridPaint == null) {
            Paint paint = new Paint(1);
            this.gridPaint = paint;
            paint.setStrokeWidth(1.0f);
            this.gridPaint.setDither(true);
            this.gridPaint.setStyle(Paint.Style.STROKE);
            this.gridPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.gridPaint.setStrokeJoin(Paint.Join.MITER);
            this.gridPaint.setColor(ResourcesCompat.getColor(resources, C6421R.color.grid_color, getContext().getTheme()));
        }
        if (this.dashedLine == null) {
            this.dashedLine = new Path();
            if (isHardwareAccelerated()) {
                this.dashedLine.moveTo(0.0f, 0.0f);
                float f = 0.0f;
                while (f < height) {
                    float f2 = f + 5.0f;
                    this.dashedLine.lineTo(0.0f, f2);
                    f = f2 + 5.0f;
                    this.dashedLine.moveTo(0.0f, f);
                }
            }
        }
        LayoutGrid grid = this.pageController.getGrid();
        int iColumnCount = grid.columnCount();
        canvas.save();
        float f3 = 0.0f;
        for (int i = 0; i <= iColumnCount; i++) {
            float fMapX = this.viewTransform.mapX(grid.column(i));
            float fMapX2 = this.viewTransform.mapX(grid.columnGutterLeft(i));
            float fMapX3 = this.viewTransform.mapX(grid.columnGutterRight(i));
            canvas.translate(fMapX - f3, 0.0f);
            canvas.drawLine(0.0f, 0.0f, 0.0f, height, this.gridPaint);
            if (i < iColumnCount) {
                canvas.translate(fMapX2 - fMapX, 0.0f);
                canvas.drawPath(this.dashedLine, this.gridPaint);
                canvas.translate(fMapX3 - fMapX2, 0.0f);
                canvas.drawPath(this.dashedLine, this.gridPaint);
                f3 = fMapX3;
            } else {
                f3 = fMapX;
            }
        }
        canvas.restore();
    }

    public void release() {
        PageController pageController = this.pageController;
        if (pageController != null) {
            pageController.delete();
            this.pageController = null;
        }
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null) {
            viewTransform.delete();
            this.viewTransform = null;
        }
    }
}
