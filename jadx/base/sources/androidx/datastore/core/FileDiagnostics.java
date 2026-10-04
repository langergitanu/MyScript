package androidx.datastore.core;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileDiagnostics.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, m1599d2 = {"Landroidx/datastore/core/FileDiagnostics;", "", "<init>", "()V", "attachFileDebugInfo", "Ljava/io/IOException;", "file", "Ljava/io/File;", "cause", "attachParentStacktrace", "attachFileSystemMessage", "origException", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class FileDiagnostics {
    public static final FileDiagnostics INSTANCE = new FileDiagnostics();

    private FileDiagnostics() {
    }

    public final IOException attachFileDebugInfo(File file, IOException cause) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    if (file.canWrite()) {
                        return attachParentStacktrace(file, cause);
                    }
                    return attachParentStacktrace(file, cause);
                }
                if (file.canWrite()) {
                    return attachParentStacktrace(file, cause);
                }
                return attachParentStacktrace(file, cause);
            }
            if (file.canRead()) {
                if (file.canWrite()) {
                    return attachParentStacktrace(file, cause);
                }
                return attachParentStacktrace(file, cause);
            }
            if (file.canWrite()) {
                return attachParentStacktrace(file, cause);
            }
            return attachParentStacktrace(file, cause);
        }
        return attachParentStacktrace(file, cause);
    }

    private final IOException attachParentStacktrace(File file, IOException cause) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return attachFileSystemMessage(file, cause);
        }
        if (parentFile.exists()) {
            if (parentFile.isFile()) {
                if (parentFile.canRead()) {
                    if (parentFile.canWrite()) {
                        return attachFileSystemMessage(file, cause);
                    }
                    return attachFileSystemMessage(file, cause);
                }
                if (parentFile.canWrite()) {
                    return attachFileSystemMessage(file, cause);
                }
                return attachFileSystemMessage(file, cause);
            }
            if (parentFile.canRead()) {
                if (parentFile.canWrite()) {
                    return attachFileSystemMessage(file, cause);
                }
                return attachFileSystemMessage(file, cause);
            }
            if (parentFile.canWrite()) {
                return attachFileSystemMessage(file, cause);
            }
            return attachFileSystemMessage(file, cause);
        }
        return attachFileSystemMessage(file, cause);
    }

    private final IOException attachFileSystemMessage(File file, IOException origException) {
        StringBuilder sb = new StringBuilder("Inoperable file:");
        try {
            sb.append(" canonical[" + file.getCanonicalPath() + "] freeSpace[" + file.getFreeSpace() + ']');
        } catch (IOException unused) {
            sb.append(" failed to attach additional metadata");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new IOException(string, origException);
    }
}
