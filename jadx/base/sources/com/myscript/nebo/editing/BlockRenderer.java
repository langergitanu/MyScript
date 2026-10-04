package com.myscript.nebo.editing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SizeF;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.CustomContext;
import com.myscript.nebo.editing.impl.p027ui.DocToScreenConverter;
import com.myscript.nebo.editing.impl.p027ui.NeboPageView;
import com.myscript.snt.core.IRendererListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class BlockRenderer implements IRendererListener {
    private static final int IMAGE_BLOCK_MEGAPIXELS = 12;
    private static final boolean LIMIT_IMAGE_BLOCK_SIZE = true;
    private static final String TAG = "BlockRenderer";
    private final File mCacheDir;
    private final DisplayMetrics mDisplayMetrics;

    public BlockRenderer(DisplayMetrics displayMetrics, File file) {
        this.mDisplayMetrics = displayMetrics;
        file.mkdirs();
        this.mCacheDir = file;
    }

    private float scaleFromMaxMegaPixel(Extent extent, ViewTransform viewTransform) {
        SizeF sizeF = new SizeF(viewTransform.mapX(extent.getWidth()), viewTransform.mapX(extent.getHeight()));
        return Math.max(1.0f, (float) Math.sqrt((sizeF.getWidth() * sizeF.getHeight()) / 1.2E7f));
    }

    @Override // com.myscript.snt.core.IRendererListener
    public void createBlockImage(Renderer renderer, Extent extent, int i, String str) {
        Bitmap bitmapCreateGhostBitmap;
        ViewTransform viewTransform = new ViewTransform(this.mDisplayMetrics.xdpi, this.mDisplayMetrics.ydpi);
        try {
            try {
                viewTransform.setZoomScale(scaleFromMaxMegaPixel(extent, viewTransform));
                bitmapCreateGhostBitmap = createGhostBitmap(renderer, viewTransform, extent, i);
            } finally {
                renderer.delete();
                viewTransform.delete();
            }
        } catch (IOException e) {
            Log.e(TAG, "Unable to create an image file " + str, e);
        }
        if (bitmapCreateGhostBitmap == null) {
            Log.w(TAG, "..... impossible to retrieve bitmap " + str);
            return;
        }
        File file = new File(str);
        file.createNewFile();
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bitmapCreateGhostBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                bitmapCreateGhostBitmap.recycle();
            }
        } catch (Exception e2) {
            Log.e(TAG, "compress > Unable to create an image file " + str, e2);
        }
    }

    private Bitmap createGhostBitmap(Renderer renderer, ViewTransform viewTransform, Extent extent, int i) {
        DocToScreenConverter docToScreenConverter = new DocToScreenConverter(renderer, viewTransform);
        Rect rect = new Rect();
        docToScreenConverter.extentToRect(extent, rect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setHasAlpha(Color.alpha(i) != 255);
        bitmapCreateBitmap.eraseColor(i);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        Matrix matrixComputeZoomMatrixInverted = docToScreenConverter.computeZoomMatrixInverted();
        matrixComputeZoomMatrixInverted.postTranslate(-rect.left, -rect.top);
        CustomContext customContext = new CustomContext();
        customContext.canvas = canvas;
        customContext.extent = extent;
        customContext.needCanvasRestore = false;
        customContext.setDocToScreenMatrix(matrixComputeZoomMatrixInverted, 0.0f, 0.0f);
        NeboPageView neboPageView = new NeboPageView(this.mDisplayMetrics, false);
        neboPageView.setBitmapCache(PageControllerStateKt.getImagesCache());
        neboPageView.drawOutlines(false);
        renderer.setView(neboPageView, viewTransform, this.mCacheDir.getAbsolutePath());
        renderer.draw(extent, InvalidateType.DOCUMENT, customContext);
        if (customContext.needCanvasRestore) {
            customContext.canvas.restore();
            customContext.needCanvasRestore = false;
        }
        canvas.restore();
        renderer.setView(null, null, "");
        docToScreenConverter.release();
        return bitmapCreateBitmap;
    }
}
