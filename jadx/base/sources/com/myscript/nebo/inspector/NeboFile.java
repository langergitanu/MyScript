package com.myscript.nebo.inspector;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFile;", "", "file", "Ljava/io/File;", "label", "", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getLabel", "()Ljava/lang/String;", "filepathMd5sum", "getFilepathMd5sum", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NeboFile {
    private final File file;
    private final String filepathMd5sum;
    private final String label;

    public static /* synthetic */ NeboFile copy$default(NeboFile neboFile, File file, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            file = neboFile.file;
        }
        if ((i & 2) != 0) {
            str = neboFile.label;
        }
        return neboFile.copy(file, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final NeboFile copy(File file, String label) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(label, "label");
        return new NeboFile(file, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NeboFile)) {
            return false;
        }
        NeboFile neboFile = (NeboFile) other;
        return Intrinsics.areEqual(this.file, neboFile.file) && Intrinsics.areEqual(this.label, neboFile.label);
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + this.label.hashCode();
    }

    public String toString() {
        return "NeboFile(file=" + this.file + ", label=" + this.label + ")";
    }

    public NeboFile(File file, String label) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(label, "label");
        this.file = file;
        this.label = label;
        this.filepathMd5sum = NeboFilesViewModelKt.getFilepathMd5sum(file);
    }

    public final File getFile() {
        return this.file;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getFilepathMd5sum() {
        return this.filepathMd5sum;
    }
}
