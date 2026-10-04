package com.myscript.nebo.editing;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.myscript.android.utils.ImageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: ImageImporter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/editing/ImageImporterImpl;", "Lcom/myscript/nebo/editing/ImageImporter;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "importImage", "Lcom/myscript/nebo/editing/ImageHolder;", "uri", "Landroid/net/Uri;", "decodeBitmap", "Landroid/graphics/Bitmap;", "mimeType", "", "decodeBitmapFromStream", "fallbackMimeTypeGuess", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImageImporterImpl implements ImageImporter {
    private static final int CAMERA_IMAGE_COMPRESSION_QUALITY = 80;
    private final Application application;
    public static final int $stable = 8;

    public ImageImporterImpl(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r2.equals("image/jpeg") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009a, code lost:
    
        if (r2.equals(androidx.media3.common.MimeTypes.IMAGE_AVIF) != false) goto L43;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[Catch: all -> 0x0144, TryCatch #0 {all -> 0x0144, blocks: (B:10:0x0035, B:14:0x0046, B:44:0x009d, B:46:0x00a3, B:50:0x00c6, B:47:0x00b2, B:49:0x00b8, B:53:0x010e, B:54:0x0128, B:17:0x004f, B:20:0x0056, B:23:0x005f, B:26:0x0068, B:29:0x0071, B:32:0x007a, B:35:0x0082, B:38:0x008b, B:41:0x0094, B:55:0x0129, B:56:0x0143), top: B:60:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2 A[Catch: all -> 0x0144, TryCatch #0 {all -> 0x0144, blocks: (B:10:0x0035, B:14:0x0046, B:44:0x009d, B:46:0x00a3, B:50:0x00c6, B:47:0x00b2, B:49:0x00b8, B:53:0x010e, B:54:0x0128, B:17:0x004f, B:20:0x0056, B:23:0x005f, B:26:0x0068, B:29:0x0071, B:32:0x007a, B:35:0x0082, B:38:0x008b, B:41:0x0094, B:55:0x0129, B:56:0x0143), top: B:60:0x0035 }] */
    @Override // com.myscript.nebo.editing.ImageImporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageHolder importImage(Uri uri) {
        String str;
        Pair pairM1606to;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String type = this.application.getContentResolver().getType(uri);
        if (type == null && (type = fallbackMimeTypeGuess(uri)) == null) {
            throw new IllegalArgumentException("Can't determine mime type from Uri: " + uri);
        }
        Bitmap bitmapDecodeBitmap = decodeBitmap(uri, type);
        try {
            switch (type.hashCode()) {
                case -1487656890:
                    break;
                case -1487464693:
                    if (type.equals("image/heic")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                            pairM1606to = TuplesKt.m1606to(Bitmap.CompressFormat.PNG, MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
                        } else {
                            if (!Intrinsics.areEqual(str, "image/jpeg")) {
                                throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                            }
                            pairM1606to = TuplesKt.m1606to(Bitmap.CompressFormat.JPEG, MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
                        }
                        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile, 80, compressFormat);
                        Intrinsics.checkNotNull(fileCreateTempFile);
                        return new ImageHolder(fileCreateTempFile, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -1487464690:
                    if (type.equals("image/heif")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat2 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile2 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile2);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile2, 80, compressFormat2);
                        Intrinsics.checkNotNull(fileCreateTempFile2);
                        return new ImageHolder(fileCreateTempFile2, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -1487394660:
                    break;
                case -1487018032:
                    if (type.equals("image/webp")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat22 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile22 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile22);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile22, 80, compressFormat22);
                        Intrinsics.checkNotNull(fileCreateTempFile22);
                        return new ImageHolder(fileCreateTempFile22, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -1423313290:
                    if (type.equals("image/x-adobe-dng")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat222 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile222 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile222);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile222, 80, compressFormat222);
                        Intrinsics.checkNotNull(fileCreateTempFile222);
                        return new ImageHolder(fileCreateTempFile222, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -879267568:
                    if (type.equals("image/gif")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat2222 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile2222 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile2222);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile2222, 80, compressFormat2222);
                        Intrinsics.checkNotNull(fileCreateTempFile2222);
                        return new ImageHolder(fileCreateTempFile2222, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -879264467:
                    if (type.equals("image/jpg")) {
                        str = "image/jpeg";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat22222 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile22222 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile22222);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile22222, 80, compressFormat22222);
                        Intrinsics.checkNotNull(fileCreateTempFile22222);
                        return new ImageHolder(fileCreateTempFile22222, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case -879258763:
                    if (type.equals("image/png")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat222222 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile222222 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile222222);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile222222, 80, compressFormat222222);
                        Intrinsics.checkNotNull(fileCreateTempFile222222);
                        return new ImageHolder(fileCreateTempFile222222, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                case 1544502791:
                    if (type.equals("image/x-ms-bmp")) {
                        str = "image/png";
                        if (!Intrinsics.areEqual(str, "image/png")) {
                        }
                        Bitmap.CompressFormat compressFormat2222222 = (Bitmap.CompressFormat) pairM1606to.component1();
                        File fileCreateTempFile2222222 = File.createTempFile("IMG_" + UUID.randomUUID(), "." + ((String) pairM1606to.component2()), this.application.getCacheDir());
                        Intrinsics.checkNotNull(fileCreateTempFile2222222);
                        ImageUtils.saveToFile(bitmapDecodeBitmap, fileCreateTempFile2222222, 80, compressFormat2222222);
                        Intrinsics.checkNotNull(fileCreateTempFile2222222);
                        return new ImageHolder(fileCreateTempFile2222222, str);
                    }
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
                default:
                    throw new IllegalArgumentException("Unsupported mime type from Uri " + uri + ": " + type);
            }
        } finally {
            bitmapDecodeBitmap.recycle();
        }
    }

    private final Bitmap decodeBitmap(Uri uri, String mimeType) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        Bitmap bitmapRotate;
        try {
            parcelFileDescriptorOpenFileDescriptor = this.application.getContentResolver().openFileDescriptor(uri, "r");
        } catch (FileNotFoundException unused) {
            return decodeBitmapFromStream(uri, mimeType);
        }
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
            try {
                ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor2.getFileDescriptor());
                if (bitmapDecodeFileDescriptor != null && (bitmapRotate = ImageUtils.rotate(bitmapDecodeFileDescriptor, new ExifInterface(parcelFileDescriptor2.getFileDescriptor()).getRotationDegrees())) != null) {
                    CloseableKt.closeFinally(parcelFileDescriptor, null);
                    if (bitmapRotate != null) {
                        return bitmapRotate;
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported image format (" + mimeType + ") from Uri: " + uri);
                }
            } finally {
            }
            return decodeBitmapFromStream(uri, mimeType);
        }
        throw new IllegalStateException(("Can't retrieve image from Uri: " + uri).toString());
    }

    private final Bitmap decodeBitmapFromStream(Uri uri, String mimeType) throws IOException {
        Bitmap bitmapRotate;
        File fileCreateTempFile = File.createTempFile("IMG_SRC_" + UUID.randomUUID(), null, this.application.getCacheDir());
        try {
            InputStream inputStreamOpenInputStream = this.application.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                FileOutputStream fileOutputStream = inputStreamOpenInputStream;
                try {
                    InputStream inputStream = fileOutputStream;
                    Intrinsics.checkNotNull(fileCreateTempFile);
                    fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(fileCreateTempFile.getPath());
                        if (bitmapDecodeFile == null || (bitmapRotate = ImageUtils.rotate(bitmapDecodeFile, new ExifInterface(fileCreateTempFile.getPath()).getRotationDegrees())) == null) {
                            throw new IllegalArgumentException("Unsupported image format (" + mimeType + ") from Uri: " + uri);
                        }
                        return bitmapRotate;
                    } finally {
                    }
                } finally {
                }
            } else {
                throw new IllegalStateException(("Can't retrieve image from Uri: " + uri).toString());
            }
        } finally {
            fileCreateTempFile.delete();
        }
    }

    private final String fallbackMimeTypeGuess(Uri uri) {
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    }
}
