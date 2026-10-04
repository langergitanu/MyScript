package com.myscript.atk.core.p020ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapCache extends LruCache<String, Bitmap> {
    private static final boolean DBG = false;
    private static final String TAG = "BitmapCache";

    public BitmapCache() {
        this(((int) Runtime.getRuntime().maxMemory()) / 8);
    }

    public BitmapCache(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public void clear() {
        evictAll();
    }

    public void load(String str, String str2) {
        load(str, str2, -1, -1);
    }

    public Bitmap load(String str, String str2, int i, int i2) {
        try {
            Bitmap bitmapDecodeSampledBitmapFromFile = decodeSampledBitmapFromFile(str, i, i2);
            if (bitmapDecodeSampledBitmapFromFile == null) {
                return null;
            }
            Bitmap bitmapPut = put(str, bitmapDecodeSampledBitmapFromFile);
            if (bitmapPut != null) {
                bitmapPut.recycle();
            }
            return bitmapDecodeSampledBitmapFromFile;
        } catch (RuntimeException e) {
            Log.e(TAG, "Error while loading image " + str + " " + str2, e);
            return null;
        }
    }

    private static int computeInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (i >= 0 && i2 >= 0) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 <= i2 && i5 <= i) {
                return 1;
            }
            int i6 = i4 / 2;
            int i7 = i5 / 2;
            while (i6 / i3 >= i2 && i7 / i3 >= i) {
                i3 *= 2;
            }
        }
        return i3;
    }

    private static Bitmap decodeSampledBitmapFromFile(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inDither = false;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
