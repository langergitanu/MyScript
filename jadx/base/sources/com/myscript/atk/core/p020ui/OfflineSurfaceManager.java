package com.myscript.atk.core.p020ui;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.myscript.atk.core.Extent;

/* JADX INFO: loaded from: classes4.dex */
public class OfflineSurfaceManager {
    private int nextID = 0;
    private final SparseArray<Bitmap> offlineSurfaces = new SparseArray<>();

    public synchronized int create(Extent extent, int i, int i2, boolean z) {
        int i3;
        i3 = this.nextID;
        this.nextID = i3 + 1;
        try {
            this.offlineSurfaces.put(i3, Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888));
        } catch (Error unused) {
            return -1;
        }
        return i3;
    }

    public synchronized void release(int i) {
        if (i < 0) {
            return;
        }
        Bitmap bitmap = this.offlineSurfaces.get(i);
        if (bitmap == null) {
            return;
        }
        this.offlineSurfaces.remove(i);
        bitmap.recycle();
    }

    public synchronized Bitmap getBitmap(int i) {
        return this.offlineSurfaces.get(i);
    }

    public synchronized void release() {
        for (int i = 0; i < this.offlineSurfaces.size(); i++) {
            Bitmap bitmapValueAt = this.offlineSurfaces.valueAt(i);
            if (bitmapValueAt != null && !bitmapValueAt.isRecycled()) {
                bitmapValueAt.recycle();
            }
        }
        this.offlineSurfaces.clear();
    }
}
