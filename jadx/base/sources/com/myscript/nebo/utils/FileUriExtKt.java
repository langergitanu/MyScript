package com.myscript.nebo.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.myscript.nebo.clipboard.ContentProviderUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileUriExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, m1599d2 = {"getExternalPictureStorageDirectory", "Ljava/io/File;", "getFileUriForPicture", "Landroid/net/Uri;", "Landroid/content/Context;", "fileName", "", "mimeType", "getFileUriForPictureFallback", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FileUriExtKt {
    private static final File getExternalPictureStorageDirectory() {
        if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) {
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "NeboImagesAlbum");
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final Uri getFileUriForPicture(Context context, String fileName, String mimeType) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", fileName);
                contentValues.put("mime_type", mimeType);
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                }
                return null;
            } catch (Exception unused) {
                return getFileUriForPictureFallback(context, fileName);
            }
        }
        return getFileUriForPictureFallback(context, fileName);
    }

    private static final Uri getFileUriForPictureFallback(Context context, String str) {
        return FileProvider.getUriForFile(context, ContentProviderUtils.ContentProviderFileGeneric, File.createTempFile(StringsKt.removeSuffix(StringsKt.replaceAfterLast$default(str, ".", "", (String) null, 4, (Object) null), (CharSequence) "."), StringsKt.replaceBeforeLast$default(str, ".", "", (String) null, 4, (Object) null), getExternalPictureStorageDirectory()));
    }
}
