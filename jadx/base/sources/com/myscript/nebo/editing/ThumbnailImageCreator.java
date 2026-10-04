package com.myscript.nebo.editing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.ImageUtils;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.CustomContext;
import com.myscript.nebo.editing.impl.p027ui.DocToScreenConverter;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.snt.core.IThumbnailerImageRequester;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbnailImageCreator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/editing/ThumbnailImageCreator;", "Lcom/myscript/snt/core/IThumbnailerImageRequester;", "displayMetrics", "Landroid/util/DisplayMetrics;", "cacheDir", "Ljava/io/File;", "<init>", "(Landroid/util/DisplayMetrics;Ljava/io/File;)V", "createThumbnail", "", "thumbnailPath", "", "renderer", "Lcom/myscript/atk/core/Renderer;", TtmlNode.ATTR_TTS_EXTENT, "Lcom/myscript/atk/core/Extent;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "zoom", "", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ThumbnailImageCreator implements IThumbnailerImageRequester {
    private static final String TAG = "ThumbnailImageCreator";
    private final File cacheDir;
    private final DisplayMetrics displayMetrics;

    public ThumbnailImageCreator(DisplayMetrics displayMetrics, File cacheDir) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.displayMetrics = displayMetrics;
        this.cacheDir = cacheDir;
        cacheDir.mkdirs();
    }

    @Override // com.myscript.snt.core.IThumbnailerImageRequester
    public boolean createThumbnail(String thumbnailPath, Renderer renderer, Extent extent, ViewTransform viewTransform, float zoom) {
        Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(extent, "extent");
        Intrinsics.checkNotNullParameter(viewTransform, "viewTransform");
        try {
            try {
                DocToScreenConverter docToScreenConverter = new DocToScreenConverter(renderer, viewTransform);
                docToScreenConverter.extentToRect(extent, new Rect());
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (r12.width() * zoom), (int) (r12.height() * zoom), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.save();
                canvas.drawColor(0);
                Matrix matrixComputeZoomMatrixInverted = docToScreenConverter.computeZoomMatrixInverted();
                matrixComputeZoomMatrixInverted.postTranslate(-r12.left, -r12.top);
                matrixComputeZoomMatrixInverted.postScale(zoom, zoom);
                CustomContext customContext = new CustomContext();
                customContext.canvas = canvas;
                customContext.extent = extent;
                customContext.needCanvasRestore = false;
                customContext.setDocToScreenMatrix(matrixComputeZoomMatrixInverted, 0.0f, 0.0f);
                NeboPageView neboPageView = new NeboPageView(this.displayMetrics, false);
                neboPageView.setBitmapCache(PageControllerStateKt.getImagesCache());
                neboPageView.setStretchedFontRenderingMode(true, customContext);
                neboPageView.drawOutlines(false);
                renderer.setView(neboPageView, viewTransform, this.cacheDir.getAbsolutePath());
                renderer.setViewport(extent, viewTransform, false);
                renderer.draw(extent, InvalidateType.DOCUMENT, customContext);
                File file = new File(thumbnailPath);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        Log.e(TAG, "Unable to create thumbnail directory " + parentFile);
                    } else if (!file.createNewFile()) {
                        Log.e(TAG, "Unable to create thumbnail file " + file.getAbsolutePath());
                    } else {
                        try {
                            ImageUtils.saveToFile(bitmapCreateBitmap, file, 100, Bitmap.CompressFormat.PNG);
                            bitmapCreateBitmap.recycle();
                            if (customContext.needCanvasRestore) {
                                customContext.canvas.restore();
                                customContext.needCanvasRestore = false;
                            }
                            canvas.restore();
                            renderer.setView(null, null, "");
                            docToScreenConverter.release();
                            return true;
                        } catch (Throwable th) {
                            bitmapCreateBitmap.recycle();
                            throw th;
                        }
                    }
                }
            } finally {
                renderer.delete();
                viewTransform.delete();
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception while creating thumbnail " + thumbnailPath, e);
        }
        renderer.delete();
        viewTransform.delete();
        return false;
    }
}
