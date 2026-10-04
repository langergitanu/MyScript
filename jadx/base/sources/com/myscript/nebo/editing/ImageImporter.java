package com.myscript.nebo.editing;

import android.net.Uri;
import androidx.media3.common.MimeTypes;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageImporter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/ImageImporter;", "", "importImage", "Lcom/myscript/nebo/editing/ImageHolder;", "uri", "Landroid/net/Uri;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ImageImporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ImageHolder importImage(Uri uri);

    /* JADX INFO: compiled from: ImageImporter.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/editing/ImageImporter$Companion;", "", "<init>", "()V", "SUPPORTED_IMAGE_MIMETYPES", "", "", "getSUPPORTED_IMAGE_MIMETYPES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String[] SUPPORTED_IMAGE_MIMETYPES = {"image/png", "image/jpeg", "image/jpg", "image/webp", "image/heif", "image/heic", "image/gif", MimeTypes.IMAGE_AVIF, "image/x-ms-bmp", "image/x-adobe-dng"};

        private Companion() {
        }

        public final String[] getSUPPORTED_IMAGE_MIMETYPES() {
            return SUPPORTED_IMAGE_MIMETYPES;
        }
    }
}
