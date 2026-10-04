package com.dropbox.core.p012v1;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DbxThumbnailSize {
    public final int height;
    public final String ident;
    public final int width;
    public static final DbxThumbnailSize w32h32 = new DbxThumbnailSize("xs", 32, 32);
    public static final DbxThumbnailSize w64h64 = new DbxThumbnailSize(CmcdData.STREAMING_FORMAT_SS, 64, 64);
    public static final DbxThumbnailSize w128h128 = new DbxThumbnailSize(CmcdData.OBJECT_TYPE_MANIFEST, 128, 128);
    public static final DbxThumbnailSize w640h480 = new DbxThumbnailSize(CmcdData.STREAM_TYPE_LIVE, 640, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
    public static final DbxThumbnailSize w1024h768 = new DbxThumbnailSize("xl", 1024, ViewUtils.EDGE_TO_EDGE_FLAGS);

    public DbxThumbnailSize(String str, int i, int i2) {
        this.ident = str;
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        return "(" + this.ident + " " + this.width + "x" + this.height + ")";
    }
}
