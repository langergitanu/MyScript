package coil.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import coil.util.GifUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MovieDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020!H\u0002J\u0010\u00103\u001a\u0002002\u0006\u00101\u001a\u00020\u0018H\u0002J\u000e\u00104\u001a\u0002002\u0006\u0010%\u001a\u00020&J\u0006\u00105\u001a\u00020&J\u0010\u00106\u001a\u0002002\b\u0010(\u001a\u0004\u0018\u00010)J\b\u00107\u001a\u0004\u0018\u00010)J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020&H\u0016J\b\u0010:\u001a\u00020&H\u0017J\u0012\u0010;\u001a\u0002002\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u0015H\u0002J\b\u0010@\u001a\u00020&H\u0016J\b\u0010A\u001a\u00020&H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010B\u001a\u000200H\u0016J\b\u0010C\u001a\u000200H\u0016J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010F\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0013H\u0016J\b\u0010G\u001a\u000200H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u00020\u0015*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006K"}, m1599d2 = {"Lcoil/drawable/MovieDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "movie", "Landroid/graphics/Movie;", "config", "Landroid/graphics/Bitmap$Config;", "scale", "Lcoil/size/Scale;", "<init>", "(Landroid/graphics/Movie;Landroid/graphics/Bitmap$Config;Lcoil/size/Scale;)V", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getScale", "()Lcoil/size/Scale;", "paint", "Landroid/graphics/Paint;", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "currentBounds", "Landroid/graphics/Rect;", "tempCanvasBounds", "softwareCanvas", "Landroid/graphics/Canvas;", "softwareBitmap", "Landroid/graphics/Bitmap;", "softwareScale", "", "hardwareScale", "hardwareDx", "hardwareDy", "isRunning", "", "startTimeMillis", "", "frameTimeMillis", "repeatCount", "", "loopIteration", "animatedTransformation", "Lcoil/transform/AnimatedTransformation;", "animatedTransformationPicture", "Landroid/graphics/Picture;", "pixelOpacity", "Lcoil/transform/PixelOpacity;", "isSoftwareScalingEnabled", "draw", "", "canvas", "updateFrameTime", "drawFrame", "setRepeatCount", "getRepeatCount", "setAnimatedTransformation", "getAnimatedTransformation", "setAlpha", "alpha", "getOpacity", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "updateBounds", "bounds", "getIntrinsicWidth", "getIntrinsicHeight", TtmlNode.START, "stop", "registerAnimationCallback", "callback", "unregisterAnimationCallback", "clearAnimationCallbacks", "getBounds", "(Landroid/graphics/Canvas;)Landroid/graphics/Rect;", "Companion", "coil-gif_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class MovieDrawable extends Drawable implements Animatable2Compat {
    public static final int REPEAT_INFINITE = -1;
    private AnimatedTransformation animatedTransformation;
    private Picture animatedTransformationPicture;
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final Bitmap.Config config;
    private final Rect currentBounds;
    private long frameTimeMillis;
    private float hardwareDx;
    private float hardwareDy;
    private float hardwareScale;
    private boolean isRunning;
    private boolean isSoftwareScalingEnabled;
    private int loopIteration;
    private final Movie movie;
    private final Paint paint;
    private PixelOpacity pixelOpacity;
    private int repeatCount;
    private final Scale scale;
    private Bitmap softwareBitmap;
    private Canvas softwareCanvas;
    private float softwareScale;
    private long startTimeMillis;
    private final Rect tempCanvasBounds;

    public MovieDrawable(Movie movie) {
        this(movie, null, null, 6, null);
    }

    public MovieDrawable(Movie movie, Bitmap.Config config) {
        this(movie, config, null, 4, null);
    }

    public /* synthetic */ MovieDrawable(Movie movie, Bitmap.Config config, Scale scale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(movie, (i & 2) != 0 ? Bitmap.Config.ARGB_8888 : config, (i & 4) != 0 ? Scale.FIT : scale);
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public MovieDrawable(Movie movie, Bitmap.Config config, Scale scale) {
        this.movie = movie;
        this.config = config;
        this.scale = scale;
        this.paint = new Paint(3);
        this.callbacks = new ArrayList();
        this.currentBounds = new Rect();
        this.tempCanvasBounds = new Rect();
        this.softwareScale = 1.0f;
        this.hardwareScale = 1.0f;
        this.repeatCount = -1;
        this.pixelOpacity = PixelOpacity.UNCHANGED;
        if (GifUtils.isHardware(config)) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zUpdateFrameTime = updateFrameTime();
        if (this.isSoftwareScalingEnabled) {
            updateBounds(getBounds(canvas));
            int iSave = canvas.save();
            try {
                float f = 1 / this.softwareScale;
                canvas.scale(f, f);
                drawFrame(canvas);
            } finally {
                canvas.restoreToCount(iSave);
            }
        } else {
            updateBounds(getBounds());
            drawFrame(canvas);
        }
        if (this.isRunning && zUpdateFrameTime) {
            invalidateSelf();
        } else {
            stop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean updateFrameTime() {
        boolean z;
        int iDuration = this.movie.duration();
        if (iDuration == 0) {
            z = 0;
        } else {
            if (this.isRunning) {
                this.frameTimeMillis = SystemClock.uptimeMillis();
            }
            int i = (int) (this.frameTimeMillis - this.startTimeMillis);
            int i2 = i / iDuration;
            this.loopIteration = i2;
            int i3 = this.repeatCount;
            i = (i3 == -1 || i2 <= i3) ? 1 : 0;
            if (i != 0) {
                iDuration = i - (i2 * iDuration);
            }
            int i4 = i;
            i = iDuration;
            z = i4;
        }
        this.movie.setTime(i);
        return z;
    }

    private final void drawFrame(Canvas canvas) {
        Canvas canvas2 = this.softwareCanvas;
        Bitmap bitmap = this.softwareBitmap;
        if (canvas2 == null || bitmap == null) {
            return;
        }
        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        int iSave = canvas2.save();
        try {
            float f = this.softwareScale;
            canvas2.scale(f, f);
            this.movie.draw(canvas2, 0.0f, 0.0f, this.paint);
            Picture picture = this.animatedTransformationPicture;
            if (picture != null) {
                picture.draw(canvas2);
            }
            canvas2.restoreToCount(iSave);
            int iSave2 = canvas.save();
            try {
                canvas.translate(this.hardwareDx, this.hardwareDy);
                float f2 = this.hardwareScale;
                canvas.scale(f2, f2);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
            } finally {
                canvas.restoreToCount(iSave2);
            }
        } catch (Throwable th) {
            canvas2.restoreToCount(iSave);
            throw th;
        }
    }

    public final void setRepeatCount(int repeatCount) {
        if (repeatCount < -1) {
            throw new IllegalArgumentException(("Invalid repeatCount: " + repeatCount).toString());
        }
        this.repeatCount = repeatCount;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final void setAnimatedTransformation(AnimatedTransformation animatedTransformation) {
        this.animatedTransformation = animatedTransformation;
        if (animatedTransformation != null && this.movie.width() > 0 && this.movie.height() > 0) {
            Picture picture = new Picture();
            this.pixelOpacity = animatedTransformation.transform(picture.beginRecording(this.movie.width(), this.movie.height()));
            picture.endRecording();
            this.animatedTransformationPicture = picture;
            this.isSoftwareScalingEnabled = true;
        } else {
            this.animatedTransformationPicture = null;
            this.pixelOpacity = PixelOpacity.UNCHANGED;
            this.isSoftwareScalingEnabled = false;
        }
        invalidateSelf();
    }

    public final AnimatedTransformation getAnimatedTransformation() {
        return this.animatedTransformation;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (alpha < 0 || alpha >= 256) {
            throw new IllegalArgumentException(("Invalid alpha: " + alpha).toString());
        }
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (this.paint.getAlpha() != 255) {
            return -3;
        }
        if (this.pixelOpacity != PixelOpacity.OPAQUE) {
            return (this.pixelOpacity == PixelOpacity.UNCHANGED && this.movie.isOpaque()) ? -1 : -3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    private final void updateBounds(Rect bounds) {
        if (Intrinsics.areEqual(this.currentBounds, bounds)) {
            return;
        }
        this.currentBounds.set(bounds);
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int iWidth2 = this.movie.width();
        int iHeight2 = this.movie.height();
        if (iWidth2 <= 0 || iHeight2 <= 0) {
            return;
        }
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(iWidth2, iHeight2, iWidth, iHeight, this.scale);
        if (!this.isSoftwareScalingEnabled) {
            dComputeSizeMultiplier = RangesKt.coerceAtMost(dComputeSizeMultiplier, 1.0d);
        }
        float f = (float) dComputeSizeMultiplier;
        this.softwareScale = f;
        int i = (int) (iWidth2 * f);
        int i2 = (int) (f * iHeight2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, this.config);
        Bitmap bitmap = this.softwareBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.softwareBitmap = bitmapCreateBitmap;
        this.softwareCanvas = new Canvas(bitmapCreateBitmap);
        if (this.isSoftwareScalingEnabled) {
            this.hardwareScale = 1.0f;
            this.hardwareDx = 0.0f;
            this.hardwareDy = 0.0f;
        } else {
            this.hardwareScale = (float) DecodeUtils.computeSizeMultiplier(i, i2, iWidth, iHeight, this.scale);
            float f2 = bounds.left;
            float f3 = iWidth - (this.hardwareScale * i);
            float f4 = 2;
            this.hardwareDx = f2 + (f3 / f4);
            this.hardwareDy = bounds.top + ((iHeight - (this.hardwareScale * i2)) / f4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.movie.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.movie.height();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.loopIteration = 0;
        this.startTimeMillis = SystemClock.uptimeMillis();
        List<Animatable2Compat.AnimationCallback> list = this.callbacks;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).onAnimationStart(this);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            List<Animatable2Compat.AnimationCallback> list = this.callbacks;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).onAnimationEnd(this);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback callback) {
        this.callbacks.add(callback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback callback) {
        return this.callbacks.remove(callback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    private final Rect getBounds(Canvas canvas) {
        Rect rect = this.tempCanvasBounds;
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        return rect;
    }
}
