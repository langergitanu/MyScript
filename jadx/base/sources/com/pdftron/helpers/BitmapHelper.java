package com.pdftron.helpers;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes7.dex */
public class BitmapHelper {
    public static void drawInRect(Bitmap bitmap, Graphics graphics, int i, int i2) {
    }

    public static class CustomBitmap {

        /* JADX INFO: renamed from: a */
        private int f1415a;

        /* JADX INFO: renamed from: b */
        private int f1416b;
        public Bitmap bitmap;
        public int[] bitmapArray;

        /* JADX INFO: renamed from: c */
        private Bitmap.Config f1417c;

        public CustomBitmap(int i, int i2) {
            this.f1415a = i;
            this.f1416b = i2;
            if (i == 0 || i2 == 0) {
                return;
            }
            this.bitmapArray = new int[i * i2];
        }

        public CustomBitmap(int i, int i2, Bitmap.Config config) {
            this(i, i2);
            this.f1417c = config;
        }

        public void create() {
            if (this.bitmapArray == null || this.f1415a == 0 || this.f1416b == 0) {
                return;
            }
            if (this.f1417c == null) {
                this.f1417c = Bitmap.Config.ARGB_4444;
            }
            this.bitmap = Bitmap.createBitmap(this.bitmapArray, this.f1415a, this.f1416b, this.f1417c);
        }
    }

    public static int getHeight(Bitmap bitmap) {
        return bitmap.getHeight();
    }

    public static int getWidth(Bitmap bitmap) {
        return bitmap.getWidth();
    }

    public static void createArrayFromBitmap(Bitmap bitmap, int[] iArr, int i, int i2) {
        if (iArr.length == i * i2) {
            bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        }
    }

    public static Bitmap getBitmap(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int i = iArr[iArr.length - 2];
        int i2 = iArr[iArr.length - 1];
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return bitmapCreateBitmap;
    }

    public static byte[] getColor(int[] iArr) {
        return new byte[]{(byte) iArr[0], (byte) iArr[1], (byte) iArr[2]};
    }
}
