package com.myscript.nebo.penpanel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.CompoundButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.myscript.android.utils.ColorExt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.DisplayMetricsExtKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorPillView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J(\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0014J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012H\u0014J\u0010\u0010)\u001a\n +*\u0004\u0018\u00010*0*H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPillView;", "Landroid/widget/CompoundButton;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "shape", "Landroid/graphics/drawable/shapes/Shape;", "fillPaint", "Landroid/graphics/Paint;", "borderPaint", "checkDrawable", "Landroid/graphics/drawable/Drawable;", "checkDrawableSize", "", "value", "", "tint", "getTint", "()I", "setTint", "(I)V", "setChecked", "", "checked", "", "animated", "toggle", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateDrawableState", "", "extraSpace", "getAccessibilityClassName", "", "kotlin.jvm.PlatformType", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPillView extends CompoundButton {
    private final Paint borderPaint;
    private final Drawable checkDrawable;
    private final float checkDrawableSize;
    private final Paint fillPaint;
    private final Shape shape;
    private int tint;

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPillView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C6693R.styleable.ColorPillView, 0, 0);
        try {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(C6693R.styleable.ColorPillView_cpv_borderWidth, 0.0f));
            paint.setColor(typedArrayObtainStyledAttributes.getColor(C6693R.styleable.ColorPillView_cpv_borderTint, 0));
            this.borderPaint = paint;
            int color = typedArrayObtainStyledAttributes.getColor(C6693R.styleable.ColorPillView_cpv_pillTint, 0);
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(color);
            this.fillPaint = paint2;
            setTint(color);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C6693R.styleable.ColorPillView_cpv_checkDrawable);
            if (isInEditMode() && drawable == null) {
                drawable = ResourcesCompat.getDrawable(context.getResources(), C6183R.drawable.ic_check, context.getTheme());
            }
            this.checkDrawable = drawable;
            this.checkDrawableSize = typedArrayObtainStyledAttributes.getDimension(C6693R.styleable.ColorPillView_cpv_checkDrawableSize, TypedValue.applyDimension(1, 24.0f, DisplayMetricsExtKt.getFixedDisplayMetrics(context)));
            typedArrayObtainStyledAttributes.recycle();
            OvalShape ovalShape = new OvalShape();
            ovalShape.resize((ovalShape.getWidth() - getPaddingLeft()) - getPaddingRight(), (ovalShape.getHeight() - getPaddingTop()) - getPaddingBottom());
            this.shape = ovalShape;
            if (isInEditMode()) {
                if (paint2.getColor() == 0) {
                    paint2.setColor(-256);
                }
                if (paint.getColor() == 0) {
                    paint.setColor(ColorUtils.setAlphaComponent(-16777216, 160));
                }
                if (getForegroundTintList() == null) {
                    setForegroundTintList(ColorStateList.valueOf(ColorUtils.setAlphaComponent(-16777216, 128)));
                }
            }
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.myscript.nebo.penpanel.ColorPillView.3
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline != null) {
                        ((OvalShape) ColorPillView.this.shape).getOutline(outline);
                        outline.offset(ColorPillView.this.getPaddingLeft(), ColorPillView.this.getPaddingTop());
                    }
                }
            });
            setClipToOutline(true);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final int getTint() {
        return this.tint;
    }

    public final void setTint(int i) {
        if (i != 0) {
            i = ColorUtils.setAlphaComponent(i, 255);
        }
        if (i == this.tint) {
            return;
        }
        this.tint = i;
        this.fillPaint.setColor(i);
        if (Build.VERSION.SDK_INT >= 28) {
            setOutlineSpotShadowColor(i);
        }
        invalidate();
    }

    public final void setChecked(boolean checked, boolean animated) {
        setChecked(checked);
        if (animated && checked) {
            Object obj = this.checkDrawable;
            Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
            if (animatable != null) {
                animatable.start();
            }
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.shape.resize((w - getPaddingLeft()) - getPaddingRight(), (h - getPaddingTop()) - getPaddingBottom());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableMutate;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        ColorPillViewKt.mutate(canvas, new Function1() { // from class: com.myscript.nebo.penpanel.ColorPillView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ColorPillView.onDraw$lambda$0(this.f$0, (Canvas) obj);
            }
        });
        Drawable drawable = this.checkDrawable;
        if (drawable == null || (drawableMutate = drawable.mutate()) == null) {
            return;
        }
        float f = 2;
        float width = (getWidth() - this.checkDrawableSize) / f;
        float height = getHeight();
        float f2 = this.checkDrawableSize;
        float f3 = (height - f2) / f;
        drawableMutate.setBounds((int) width, (int) f3, (int) (width + f2), (int) (f3 + f2));
        ColorStateList foregroundTintList = getForegroundTintList();
        drawableMutate.setTint(foregroundTintList != null ? foregroundTintList.getColorForState(getDrawableState(), -65281) : -65281);
        drawableMutate.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDraw$lambda$0(ColorPillView colorPillView, Canvas c) {
        Intrinsics.checkNotNullParameter(c, "c");
        c.translate(colorPillView.getPaddingStart(), colorPillView.getPaddingTop());
        colorPillView.shape.draw(c, colorPillView.fillPaint);
        colorPillView.shape.draw(c, colorPillView.borderPaint);
        return Unit.INSTANCE;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int extraSpace) {
        if (isChecked()) {
            int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, new int[]{((Number) ColorExt.getBrightnessAwareValue$default(this.tint, Integer.valueOf(C6693R.attr.state_on_bright_color), Integer.valueOf(-C6693R.attr.state_on_bright_color), 0.0f, 8, null)).intValue()});
            Intrinsics.checkNotNull(iArrOnCreateDrawableState);
            return iArrOnCreateDrawableState;
        }
        int[] iArrOnCreateDrawableState2 = super.onCreateDrawableState(extraSpace);
        Intrinsics.checkNotNull(iArrOnCreateDrawableState2);
        return iArrOnCreateDrawableState2;
    }

    @Override // android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public String getAccessibilityClassName() {
        return ColorPillView.class.getName();
    }
}
