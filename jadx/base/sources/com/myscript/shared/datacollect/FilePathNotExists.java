package com.myscript.shared.datacollect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: UploadFile.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/shared/datacollect/FilePathNotExists;", "", ClientCookie.PATH_ATTR, "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FilePathNotExists extends Throwable {
    private final String path;

    public static /* synthetic */ FilePathNotExists copy$default(FilePathNotExists filePathNotExists, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filePathNotExists.path;
        }
        return filePathNotExists.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final FilePathNotExists copy(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new FilePathNotExists(path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FilePathNotExists) && Intrinsics.areEqual(this.path, ((FilePathNotExists) other).path);
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FilePathNotExists(path=" + this.path + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilePathNotExists(String path) {
        super("The path " + path + " doesn't exist");
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }
}
