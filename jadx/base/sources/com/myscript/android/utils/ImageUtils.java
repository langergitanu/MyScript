package com.myscript.android.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m1599d2 = {"rotate", "Landroid/graphics/Bitmap;", "orientation", "", "saveToFile", "", "file", "Ljava/io/File;", "quality", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImageUtils {
    public static final Bitmap rotate(Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "also(...)");
        return bitmapCreateBitmap;
    }

    public static final void saveToFile(Bitmap bitmap, File file, int i, Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            bitmap.compress(compressFormat, i, fileOutputStream2);
            fileOutputStream2.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }
}
