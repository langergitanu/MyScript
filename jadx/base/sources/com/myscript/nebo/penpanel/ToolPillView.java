package com.myscript.nebo.penpanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolPillView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0016R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolPillView;", "Landroidx/appcompat/widget/AppCompatImageView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/myscript/nebo/penpanel/ColorUpdateAnimator;", "colorUpdateAnimator", "setColorUpdateAnimator", "(Lcom/myscript/nebo/penpanel/ColorUpdateAnimator;)V", "animatedColor", "", "getAnimatedColor", "()I", "tint", "getTint", "setTint", "(I)V", "", "isPaused", "()Z", "setPaused", "(Z)V", "setSelected", "", "selected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onCreateDrawableState", "", "extraSpace", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolPillView extends AppCompatImageView {
    private ColorUpdateAnimator colorUpdateAnimator;
    private boolean isPaused;
    private int tint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolPillView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setTint(context.getTheme().obtainStyledAttributes(attrs, C6693R.styleable.ToolPillView, 0, 0).getColor(C6693R.styleable.ToolPillView_tpv_tint, 0));
        if (isInEditMode()) {
            if (getDrawable() == null) {
                setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), C6693R.drawable.ic_color_pen, context.getTheme()));
            }
            if (this.tint == 0) {
                setTint(ResourcesCompat.getColor(context.getResources(), C6693R.color.PenGreen, context.getTheme()));
            }
        }
    }

    private final void setColorUpdateAnimator(ColorUpdateAnimator colorUpdateAnimator) {
        ColorUpdateAnimator colorUpdateAnimator2 = this.colorUpdateAnimator;
        if (colorUpdateAnimator2 != null) {
            colorUpdateAnimator2.cancel();
        }
        this.colorUpdateAnimator = colorUpdateAnimator;
    }

    private final int getAnimatedColor() {
        ColorUpdateAnimator colorUpdateAnimator = this.colorUpdateAnimator;
        return colorUpdateAnimator != null ? colorUpdateAnimator.getAnimatedValue() : this.tint;
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
        int animatedColor = getAnimatedColor();
        this.tint = i;
        if (animatedColor != 0 && animatedColor != i && i != 0) {
            setColorUpdateAnimator(new ColorUpdateAnimator(animatedColor, this.tint, getResources().getInteger(android.R.integer.config_mediumAnimTime), new ToolPillView$tint$1(this)));
            ColorUpdateAnimator colorUpdateAnimator = this.colorUpdateAnimator;
            if (colorUpdateAnimator != null) {
                colorUpdateAnimator.start(new Function0() { // from class: com.myscript.nebo.penpanel.ToolPillView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ToolPillView._set_tint_$lambda$0(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        setColorUpdateAnimator(null);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _set_tint_$lambda$0(ToolPillView toolPillView) {
        toolPillView.setColorUpdateAnimator(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isPaused, reason: from getter */
    public final boolean getIsPaused() {
        return this.isPaused;
    }

    public final void setPaused(boolean z) {
        this.isPaused = z;
        refreshDrawableState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean selected) {
        if (!selected) {
            setPaused(false);
        }
        super.setSelected(selected);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableFindDrawableByLayerId;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Drawable drawableMutate = getDrawable().getCurrent().mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        if (!(drawableMutate instanceof LayerDrawable) || (drawableFindDrawableByLayerId = ((LayerDrawable) drawableMutate).findDrawableByLayerId(C6693R.id.tool_colored_layer)) == null) {
            return;
        }
        if (getAnimatedColor() == 0) {
            drawableFindDrawableByLayerId.setAlpha(0);
        } else {
            drawableFindDrawableByLayerId.setAlpha(255);
            DrawableCompat.setTint(drawableFindDrawableByLayerId, getAnimatedColor());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 2);
        AppCompatImageView.mergeDrawableStates(iArrOnCreateDrawableState, new int[]{this.isPaused ? C6693R.attr.tool_state_paused : -C6693R.attr.tool_state_paused});
        Intrinsics.checkNotNull(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }
}
