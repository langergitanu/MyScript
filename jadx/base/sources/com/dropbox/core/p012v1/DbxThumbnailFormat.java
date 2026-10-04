package com.dropbox.core.p012v1;

import com.myscript.nebo.clipboard.ClipboardContentProvider;

/* JADX INFO: loaded from: classes4.dex */
public class DbxThumbnailFormat {
    public static final DbxThumbnailFormat JPEG = new DbxThumbnailFormat("jpeg");
    public static final DbxThumbnailFormat PNG = new DbxThumbnailFormat("png");
    public final String ident;

    public DbxThumbnailFormat(String str) {
        this.ident = str;
    }

    public static DbxThumbnailFormat bestForFileName(String str, DbxThumbnailFormat dbxThumbnailFormat) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(ClipboardContentProvider.PNG_EXTENSION) || lowerCase.endsWith(".gif")) {
            return PNG;
        }
        return (lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpe")) ? JPEG : dbxThumbnailFormat;
    }
}
