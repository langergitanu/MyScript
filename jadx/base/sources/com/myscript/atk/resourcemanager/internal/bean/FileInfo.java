package com.myscript.atk.resourcemanager.internal.bean;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/atk/resourcemanager/internal/bean/FileInfo;", "", "filename", "", "hash", "size", "", "uri", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILandroid/net/Uri;)V", "getFilename", "()Ljava/lang/String;", "getHash", "getSize", "()I", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "resourcemanager-lib_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FileInfo {
    private final String filename;
    private final String hash;
    private final int size;
    private final Uri uri;

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, String str, String str2, int i, Uri uri, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileInfo.filename;
        }
        if ((i2 & 2) != 0) {
            str2 = fileInfo.hash;
        }
        if ((i2 & 4) != 0) {
            i = fileInfo.size;
        }
        if ((i2 & 8) != 0) {
            uri = fileInfo.uri;
        }
        return fileInfo.copy(str, str2, i, uri);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public final FileInfo copy(String filename, String hash, int size, Uri uri) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new FileInfo(filename, hash, size, uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) other;
        return Intrinsics.areEqual(this.filename, fileInfo.filename) && Intrinsics.areEqual(this.hash, fileInfo.hash) && this.size == fileInfo.size && Intrinsics.areEqual(this.uri, fileInfo.uri);
    }

    public int hashCode() {
        return (((((this.filename.hashCode() * 31) + this.hash.hashCode()) * 31) + Integer.hashCode(this.size)) * 31) + this.uri.hashCode();
    }

    public String toString() {
        return "FileInfo(filename=" + this.filename + ", hash=" + this.hash + ", size=" + this.size + ", uri=" + this.uri + ")";
    }

    public FileInfo(String filename, String hash, int i, Uri uri) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.filename = filename;
        this.hash = hash;
        this.size = i;
        this.uri = uri;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final String getHash() {
        return this.hash;
    }

    public final int getSize() {
        return this.size;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
