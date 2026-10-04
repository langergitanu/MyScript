package androidx.compose.p004ui.graphics.shadow;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p004ui.graphics.BlendMode;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.BrushKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.CanvasKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.CompositeShaderBrush;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.ImageBitmapConfig;
import androidx.compose.p004ui.graphics.ImageBitmapKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.PaintingStyle;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.ShaderBrush;
import androidx.compose.p004ui.graphics.ShaderKt;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: DropShadowPainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JQ\u0010\u001e\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020 H\u0002¢\u0006\u0004\b*\u0010+J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m1599d2 = {"Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", ClientCookie.PATH_ATTR, "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "Landroidx/compose/ui/graphics/Brush;", "brush", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createOuterShadowBitmap", "radius", "spread", "createOuterShadowBitmap-Cqks5Fs", "(JLandroidx/compose/ui/graphics/Path;FF)Landroidx/compose/ui/graphics/ImageBitmap;", "shadowRadius", "createOuterShadowBitmap-D_oqF2M", "(JFFJ)Landroidx/compose/ui/graphics/ImageBitmap;", "ui-graphics"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DropShadowRenderer extends ShadowRenderer {
    public static final int $stable = 8;
    private CompositeShaderBrush compositeShader;
    private final Paint paint;
    private final Shadow shadow;
    private ImageBitmap shadowBitmap;

    public DropShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    @Override // androidx.compose.p004ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: buildShadow-_SMYjrA, reason: not valid java name */
    protected void mo8867buildShadow_SMYjrA(DrawScope drawScope, long j, long j2, Path path) {
        DropShadowRenderer dropShadowRenderer;
        ImageBitmap imageBitmapM8866createOuterShadowBitmapD_oqF2M;
        float f = drawScope.mo2191toPx0680j_4(this.shadow.getRadius());
        float f2 = drawScope.mo2191toPx0680j_4(this.shadow.getSpread());
        if (path != null) {
            dropShadowRenderer = this;
            imageBitmapM8866createOuterShadowBitmapD_oqF2M = dropShadowRenderer.m8865createOuterShadowBitmapCqks5Fs(j, path, f, f2);
        } else {
            dropShadowRenderer = this;
            imageBitmapM8866createOuterShadowBitmapD_oqF2M = dropShadowRenderer.m8866createOuterShadowBitmapD_oqF2M(j, f, f2, j2);
        }
        dropShadowRenderer.shadowBitmap = imageBitmapM8866createOuterShadowBitmapD_oqF2M;
    }

    private final Brush obtainCompositeBrush(ImageBitmap shadowBitmap, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush == null || !Intrinsics.areEqual(compositeShaderBrush.getSrcBrush(), brush)) {
            Brush.Companion companion = Brush.INSTANCE;
            ShaderBrush ShaderBrush = BrushKt.ShaderBrush(ShaderKt.m8483ImageShaderF49vj9s$default(shadowBitmap, 0, 0, 6, null));
            if (brush instanceof ShaderBrush) {
                brush = BrushKt.ShaderBrush(((ShaderBrush) brush).mo8117createShaderuvyYCjk(Size.m7963constructorimpl((((long) Float.floatToRawIntBits(shadowBitmap.getWidth())) << 32) | (((long) Float.floatToRawIntBits(shadowBitmap.getHeight())) & 4294967295L))));
            }
            Brush brushM8105composite7EN7VTw = companion.m8105composite7EN7VTw(ShaderBrush, brush, BlendMode.INSTANCE.m8086getSrcIn0nO6VwU());
            Intrinsics.checkNotNull(brushM8105composite7EN7VTw, "null cannot be cast to non-null type androidx.compose.ui.graphics.CompositeShaderBrush");
            compositeShaderBrush = (CompositeShaderBrush) brushM8105composite7EN7VTw;
            this.compositeShader = compositeShaderBrush;
        }
        return compositeShaderBrush;
    }

    @Override // androidx.compose.p004ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: onDrawShadow-MLmccfk, reason: not valid java name */
    protected void mo8868onDrawShadowMLmccfk(DrawScope drawScope, long j, long j2, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        ImageBitmap imageBitmap = this.shadowBitmap;
        if (imageBitmap != null) {
            float f2 = -(drawScope.mo2191toPx0680j_4(this.shadow.getRadius()) + drawScope.mo2191toPx0680j_4(this.shadow.getSpread()));
            if (brush != null && colorFilter == null) {
                Brush brushObtainCompositeBrush = obtainCompositeBrush(imageBitmap, brush);
                drawScope.getDrawContext().getTransform().translate(f2, f2);
                try {
                    float width = imageBitmap.getWidth();
                    DrawScope.m8722drawRectAsUm42w$default(drawScope, brushObtainCompositeBrush, 0L, Size.m7963constructorimpl((((long) Float.floatToRawIntBits(imageBitmap.getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), f, null, null, i, 50, null);
                    return;
                } finally {
                    float f3 = -f2;
                    drawScope.getDrawContext().getTransform().translate(f3, f3);
                }
            }
            DrawScope.m8713drawImagegbVJVH8$default(drawScope, imageBitmap, Offset.m7895constructorimpl((4294967295L & ((long) Float.floatToRawIntBits(f2))) | (Float.floatToRawIntBits(f2) << 32)), f, null, colorFilter, i, 8, null);
        }
    }

    /* JADX INFO: renamed from: createOuterShadowBitmap-Cqks5Fs, reason: not valid java name */
    private final ImageBitmap m8865createOuterShadowBitmapCqks5Fs(long size, Path path, float radius, float spread) {
        float f = 2;
        float f2 = (radius * f) + (f * spread);
        ImageBitmap imageBitmapM8386ImageBitmapx__hDU$default = ImageBitmapKt.m8386ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat((int) (size >> 32)) + f2), (int) Math.ceil(Float.intBitsToFloat((int) (size & 4294967295L)) + f2), ImageBitmapConfig.INSTANCE.m8380getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(imageBitmapM8386ImageBitmapx__hDU$default);
        if (spread > 0.0f) {
            float f3 = radius + spread;
            Canvas.translate(f3, f3);
            Canvas.drawPath(path, BlurKt.m8864configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null));
            Paint paintM8864configureShadowFoewPVk$default = BlurKt.m8864configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, PaintingStyle.INSTANCE.m8432getStrokeTiuSbCo(), 3, null);
            paintM8864configureShadowFoewPVk$default.setStrokeWidth(2.0f * spread);
            Unit unit = Unit.INSTANCE;
            Canvas.drawPath(path, paintM8864configureShadowFoewPVk$default);
            return imageBitmapM8386ImageBitmapx__hDU$default;
        }
        BlurKt.m8864configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null);
        Canvas.translate(radius, radius);
        Canvas.drawPath(path, this.paint);
        return imageBitmapM8386ImageBitmapx__hDU$default;
    }

    /* JADX INFO: renamed from: createOuterShadowBitmap-D_oqF2M, reason: not valid java name */
    private final ImageBitmap m8866createOuterShadowBitmapD_oqF2M(long size, float shadowRadius, float spread, long cornerRadius) {
        float f = 2;
        float f2 = (shadowRadius * f) + (f * spread);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size >> 32)) + f2;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size & 4294967295L)) + f2;
        ImageBitmap imageBitmapM8386ImageBitmapx__hDU$default = ImageBitmapKt.m8386ImageBitmapx__hDU$default((int) Math.ceil(fIntBitsToFloat), (int) Math.ceil(fIntBitsToFloat2), ImageBitmapConfig.INSTANCE.m8380getAlpha8_sVssgQ(), false, null, 24, null);
        CanvasKt.Canvas(imageBitmapM8386ImageBitmapx__hDU$default).drawRoundRect(shadowRadius, shadowRadius, fIntBitsToFloat - shadowRadius, fIntBitsToFloat2 - shadowRadius, Float.intBitsToFloat((int) (cornerRadius >> 32)), Float.intBitsToFloat((int) (cornerRadius & 4294967295L)), BlurKt.m8864configureShadowFoewPVk$default(this.paint, 0L, 0, shadowRadius > 0.0f ? Blur_androidKt.BlurFilter(shadowRadius) : null, 0, 11, null));
        return imageBitmapM8386ImageBitmapx__hDU$default;
    }
}
