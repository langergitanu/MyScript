package com.myscript.nebo.editing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.PointerIcon;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.snt.core.ToolType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SpenHoverCursor.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u0018\u0010$\u001a\u00020\u0019*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/editing/SpenHoverCursor;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "penCache", "Lcom/myscript/nebo/editing/SpenHoverCursor$CachedIcon;", "hlCache", "penDrawable", "Landroid/graphics/drawable/Drawable;", "getPenDrawable", "()Landroid/graphics/drawable/Drawable;", "penDrawable$delegate", "Lkotlin/Lazy;", "hlDrawable", "getHlDrawable", "hlDrawable$delegate", "update", "", "view", "Landroid/view/View;", "toolType", "Lcom/myscript/snt/core/ToolType;", "color", "", "clearMode", "", "penIconFor", "Landroid/view/PointerIcon;", "hlIconFor", "tintedBitmap", "Landroid/graphics/Bitmap;", "drawable", "w", CmcdData.STREAMING_FORMAT_HLS, "rgb", "getRgb", "(I)I", "CachedIcon", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SpenHoverCursor {
    private static final int HL_CURSOR_ALPHA = 160;
    private static final int HL_CURSOR_HEIGHT_DP = 12;
    private static final int HL_CURSOR_WIDTH_DP = 40;
    private static final int PEN_CURSOR_HOTSPOT_DP = 4;
    private static final int PEN_CURSOR_SIZE_DP = 32;
    private final Context context;
    private CachedIcon hlCache;

    /* JADX INFO: renamed from: hlDrawable$delegate, reason: from kotlin metadata */
    private final Lazy hlDrawable;
    private CachedIcon penCache;

    /* JADX INFO: renamed from: penDrawable$delegate, reason: from kotlin metadata */
    private final Lazy penDrawable;
    public static final int $stable = 8;

    public SpenHoverCursor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.penDrawable = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.SpenHoverCursor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SpenHoverCursor.penDrawable_delegate$lambda$0(this.f$0);
            }
        });
        this.hlDrawable = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.SpenHoverCursor$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SpenHoverCursor.hlDrawable_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: compiled from: SpenHoverCursor.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/editing/SpenHoverCursor$CachedIcon;", "", "icon", "Landroid/view/PointerIcon;", "color", "", "density", "", "<init>", "(Landroid/view/PointerIcon;IF)V", "getIcon", "()Landroid/view/PointerIcon;", "getColor", "()I", "getDensity", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final /* data */ class CachedIcon {
        private final int color;
        private final float density;
        private final PointerIcon icon;

        public static /* synthetic */ CachedIcon copy$default(CachedIcon cachedIcon, PointerIcon pointerIcon, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                pointerIcon = cachedIcon.icon;
            }
            if ((i2 & 2) != 0) {
                i = cachedIcon.color;
            }
            if ((i2 & 4) != 0) {
                f = cachedIcon.density;
            }
            return cachedIcon.copy(pointerIcon, i, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PointerIcon getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getDensity() {
            return this.density;
        }

        public final CachedIcon copy(PointerIcon icon, int color, float density) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            return new CachedIcon(icon, color, density);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedIcon)) {
                return false;
            }
            CachedIcon cachedIcon = (CachedIcon) other;
            return Intrinsics.areEqual(this.icon, cachedIcon.icon) && this.color == cachedIcon.color && Float.compare(this.density, cachedIcon.density) == 0;
        }

        public int hashCode() {
            return (((this.icon.hashCode() * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.density);
        }

        public String toString() {
            return "CachedIcon(icon=" + this.icon + ", color=" + this.color + ", density=" + this.density + ")";
        }

        public CachedIcon(PointerIcon icon, int i, float f) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.icon = icon;
            this.color = i;
            this.density = f;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getDensity() {
            return this.density;
        }

        public final PointerIcon getIcon() {
            return this.icon;
        }
    }

    private final Drawable getPenDrawable() {
        Object value = this.penDrawable.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Drawable) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable penDrawable_delegate$lambda$0(SpenHoverCursor spenHoverCursor) {
        Drawable drawable = ContextCompat.getDrawable(spenHoverCursor.context, C6079R.drawable.ic_spen_cursor_pen);
        if (drawable != null) {
            return drawable.mutate();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final Drawable getHlDrawable() {
        Object value = this.hlDrawable.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Drawable) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable hlDrawable_delegate$lambda$0(SpenHoverCursor spenHoverCursor) {
        Drawable drawable = ContextCompat.getDrawable(spenHoverCursor.context, C6079R.drawable.ic_spen_cursor_highlighter);
        if (drawable != null) {
            return drawable.mutate();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void update$default(SpenHoverCursor spenHoverCursor, View view, ToolType toolType, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        spenHoverCursor.update(view, toolType, i, z);
    }

    public final void update(View view, ToolType toolType, int color, boolean clearMode) {
        PointerIcon pointerIconHlIconFor;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(toolType, "toolType");
        if (toolType == ToolType.Pen) {
            pointerIconHlIconFor = penIconFor(color);
        } else {
            pointerIconHlIconFor = (toolType != ToolType.Highlighter || clearMode) ? null : hlIconFor(color);
        }
        if (view instanceof DocumentRenderingView) {
            ((DocumentRenderingView) view).setHoverPointerIcon(pointerIconHlIconFor);
            return;
        }
        if (pointerIconHlIconFor == null) {
            pointerIconHlIconFor = PointerIcon.getSystemIcon(this.context, 1000);
            Intrinsics.checkNotNullExpressionValue(pointerIconHlIconFor, "getSystemIcon(...)");
        }
        view.setPointerIcon(pointerIconHlIconFor);
    }

    private final PointerIcon penIconFor(int color) {
        int rgb = getRgb(color);
        float f = this.context.getResources().getDisplayMetrics().density;
        CachedIcon cachedIcon = this.penCache;
        if (cachedIcon != null) {
            if (cachedIcon.getColor() != rgb || cachedIcon.getDensity() != f) {
                cachedIcon = null;
            }
            if (cachedIcon != null) {
                return cachedIcon.getIcon();
            }
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (32 * f), 1);
        float f2 = 4 * f;
        PointerIcon pointerIconCreate = PointerIcon.create(tintedBitmap(getPenDrawable(), rgb, iCoerceAtLeast, iCoerceAtLeast), f2, f2);
        Intrinsics.checkNotNull(pointerIconCreate);
        this.penCache = new CachedIcon(pointerIconCreate, rgb, f);
        Intrinsics.checkNotNullExpressionValue(pointerIconCreate, "also(...)");
        return pointerIconCreate;
    }

    private final PointerIcon hlIconFor(int color) {
        int rgb = getRgb(color);
        float f = this.context.getResources().getDisplayMetrics().density;
        CachedIcon cachedIcon = this.hlCache;
        if (cachedIcon != null) {
            if (cachedIcon.getColor() != rgb || cachedIcon.getDensity() != f) {
                cachedIcon = null;
            }
            if (cachedIcon != null) {
                return cachedIcon.getIcon();
            }
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (40 * f), 1);
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast((int) (12 * f), 1);
        PointerIcon pointerIconCreate = PointerIcon.create(tintedBitmap(getHlDrawable(), Color.argb(HL_CURSOR_ALPHA, Color.red(rgb), Color.green(rgb), Color.blue(rgb)), iCoerceAtLeast, iCoerceAtLeast2), 1.0f, iCoerceAtLeast2 / 2.0f);
        Intrinsics.checkNotNull(pointerIconCreate);
        this.hlCache = new CachedIcon(pointerIconCreate, rgb, f);
        Intrinsics.checkNotNullExpressionValue(pointerIconCreate, "also(...)");
        return pointerIconCreate;
    }

    private final Bitmap tintedBitmap(Drawable drawable, int color, int w, int h) {
        drawable.setTint(color);
        drawable.setTintMode(PorterDuff.Mode.SRC_IN);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        drawable.setBounds(0, 0, w, h);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    private final int getRgb(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }
}
