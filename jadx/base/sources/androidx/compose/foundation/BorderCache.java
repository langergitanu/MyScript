package androidx.compose.foundation;

import androidx.compose.p004ui.draw.CacheDrawScope;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.BlendMode;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.ImageBitmapConfig;
import androidx.compose.p004ui.graphics.ImageBitmapKt;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\f\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\tJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "obtainPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final /* data */ class BorderCache {
    private Path borderPath;
    private Canvas canvas;
    private CanvasDrawScope canvasDrawScope;
    private ImageBitmap imageBitmap;

    public BorderCache() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ImageBitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Canvas getCanvas() {
        return this.canvas;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Path getBorderPath() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap, canvas, canvasDrawScope, path);
    }

    public final BorderCache copy(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path borderPath) {
        return new BorderCache(imageBitmap, canvas, canvasDrawScope, borderPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) other;
        return Intrinsics.areEqual(this.imageBitmap, borderCache.imageBitmap) && Intrinsics.areEqual(this.canvas, borderCache.canvas) && Intrinsics.areEqual(this.canvasDrawScope, borderCache.canvasDrawScope) && Intrinsics.areEqual(this.borderPath, borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap = this.imageBitmap;
        int iHashCode = (imageBitmap == null ? 0 : imageBitmap.hashCode()) * 31;
        Canvas canvas = this.canvas;
        int iHashCode2 = (iHashCode + (canvas == null ? 0 : canvas.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        int iHashCode3 = (iHashCode2 + (canvasDrawScope == null ? 0 : canvasDrawScope.hashCode())) * 31;
        Path path = this.borderPath;
        return iHashCode3 + (path != null ? path.hashCode() : 0);
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path) {
        this.imageBitmap = imageBitmap;
        this.canvas = canvas;
        this.canvasDrawScope = canvasDrawScope;
        this.borderPath = path;
    }

    public /* synthetic */ BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageBitmap, (i & 2) != 0 ? null : canvas, (i & 4) != 0 ? null : canvasDrawScope, (i & 8) != 0 ? null : path);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX INFO: renamed from: drawBorderCache-EMwLDEs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ImageBitmap m2030drawBorderCacheEMwLDEs(CacheDrawScope cacheDrawScope, long j, int i, Function1<? super DrawScope, Unit> function1) {
        int i2;
        CanvasDrawScope canvasDrawScope;
        ImageBitmap imageBitmapM8386ImageBitmapx__hDU$default = this.imageBitmap;
        Canvas Canvas = this.canvas;
        ImageBitmapConfig imageBitmapConfigM8373boximpl = imageBitmapM8386ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m8373boximpl(imageBitmapM8386ImageBitmapx__hDU$default.mo8012getConfig_sVssgQ()) : null;
        boolean z = false;
        if (!(imageBitmapConfigM8373boximpl == null ? false : ImageBitmapConfig.m8376equalsimpl0(imageBitmapConfigM8373boximpl.m8379unboximpl(), ImageBitmapConfig.INSTANCE.m8381getArgb8888_sVssgQ()))) {
            i2 = i;
            if (ImageBitmapConfig.m8375equalsimpl(i2, imageBitmapM8386ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m8373boximpl(imageBitmapM8386ImageBitmapx__hDU$default.mo8012getConfig_sVssgQ()) : null)) {
            }
            if (imageBitmapM8386ImageBitmapx__hDU$default != null || Canvas == null || Float.intBitsToFloat((int) (cacheDrawScope.m7683getSizeNHjbRc() >> 32)) > imageBitmapM8386ImageBitmapx__hDU$default.getWidth() || Float.intBitsToFloat((int) (cacheDrawScope.m7683getSizeNHjbRc() & 4294967295L)) > imageBitmapM8386ImageBitmapx__hDU$default.getHeight() || !z) {
                imageBitmapM8386ImageBitmapx__hDU$default = ImageBitmapKt.m8386ImageBitmapx__hDU$default((int) (j >> 32), (int) (j & 4294967295L), i2, false, null, 24, null);
                this.imageBitmap = imageBitmapM8386ImageBitmapx__hDU$default;
                Canvas = androidx.compose.p004ui.graphics.CanvasKt.Canvas(imageBitmapM8386ImageBitmapx__hDU$default);
                this.canvas = Canvas;
            }
            canvasDrawScope = this.canvasDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.canvasDrawScope = canvasDrawScope;
            }
            long jM11200toSizeozmzZPI = IntSizeKt.m11200toSizeozmzZPI(j);
            LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
            Density density = drawParams.getDensity();
            LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
            Canvas canvas = drawParams.getCanvas();
            long size = drawParams.getSize();
            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
            drawParams2.setDensity(cacheDrawScope);
            drawParams2.setLayoutDirection(layoutDirection);
            drawParams2.setCanvas(Canvas);
            drawParams2.m8649setSizeuvyYCjk(jM11200toSizeozmzZPI);
            Canvas.save();
            CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
            ImageBitmap imageBitmap = imageBitmapM8386ImageBitmapx__hDU$default;
            DrawScope.m8723drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m8174getBlack0d7_KjU(), 0L, jM11200toSizeozmzZPI, 0.0f, null, null, BlendMode.INSTANCE.m8061getClear0nO6VwU(), 58, null);
            function1.invoke(canvasDrawScope2);
            Canvas.restore();
            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
            drawParams3.setDensity(density);
            drawParams3.setLayoutDirection(layoutDirection2);
            drawParams3.setCanvas(canvas);
            drawParams3.m8649setSizeuvyYCjk(size);
            imageBitmap.prepareToDraw();
            return imageBitmap;
        }
        i2 = i;
        z = true;
        if (imageBitmapM8386ImageBitmapx__hDU$default != null) {
            imageBitmapM8386ImageBitmapx__hDU$default = ImageBitmapKt.m8386ImageBitmapx__hDU$default((int) (j >> 32), (int) (j & 4294967295L), i2, false, null, 24, null);
            this.imageBitmap = imageBitmapM8386ImageBitmapx__hDU$default;
            Canvas = androidx.compose.p004ui.graphics.CanvasKt.Canvas(imageBitmapM8386ImageBitmapx__hDU$default);
            this.canvas = Canvas;
        }
        canvasDrawScope = this.canvasDrawScope;
        if (canvasDrawScope == null) {
        }
        long jM11200toSizeozmzZPI2 = IntSizeKt.m11200toSizeozmzZPI(j);
        LayoutDirection layoutDirection3 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope.getDrawParams();
        Density density2 = drawParams4.getDensity();
        LayoutDirection layoutDirection22 = drawParams4.getLayoutDirection();
        Canvas canvas2 = drawParams4.getCanvas();
        long size2 = drawParams4.getSize();
        CanvasDrawScope.DrawParams drawParams22 = canvasDrawScope.getDrawParams();
        drawParams22.setDensity(cacheDrawScope);
        drawParams22.setLayoutDirection(layoutDirection3);
        drawParams22.setCanvas(Canvas);
        drawParams22.m8649setSizeuvyYCjk(jM11200toSizeozmzZPI2);
        Canvas.save();
        CanvasDrawScope canvasDrawScope22 = canvasDrawScope;
        ImageBitmap imageBitmap2 = imageBitmapM8386ImageBitmapx__hDU$default;
        DrawScope.m8723drawRectnJ9OG0$default(canvasDrawScope22, Color.INSTANCE.m8174getBlack0d7_KjU(), 0L, jM11200toSizeozmzZPI2, 0.0f, null, null, BlendMode.INSTANCE.m8061getClear0nO6VwU(), 58, null);
        function1.invoke(canvasDrawScope22);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams32 = canvasDrawScope.getDrawParams();
        drawParams32.setDensity(density2);
        drawParams32.setLayoutDirection(layoutDirection22);
        drawParams32.setCanvas(canvas2);
        drawParams32.m8649setSizeuvyYCjk(size2);
        imageBitmap2.prepareToDraw();
        return imageBitmap2;
    }

    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }
}
