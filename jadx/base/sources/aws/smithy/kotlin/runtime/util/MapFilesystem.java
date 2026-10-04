package aws.smithy.kotlin.runtime.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: Filesystem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/MapFilesystem;", "Laws/smithy/kotlin/runtime/util/Filesystem;", "", "", "", "memFs", "filePathSeparator", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", ClientCookie.PATH_ATTR, "readFileOrNull", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "writeFile", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "fileExists", "(Ljava/lang/String;)Z", "Ljava/util/Map;", "Ljava/lang/String;", "getFilePathSeparator", "()Ljava/lang/String;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MapFilesystem implements Filesystem {
    private final String filePathSeparator;
    private final Map<String, byte[]> memFs;

    public MapFilesystem(Map<String, byte[]> memFs, String filePathSeparator) {
        Intrinsics.checkNotNullParameter(memFs, "memFs");
        Intrinsics.checkNotNullParameter(filePathSeparator, "filePathSeparator");
        this.memFs = memFs;
        this.filePathSeparator = filePathSeparator;
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public String getFilePathSeparator() {
        return this.filePathSeparator;
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public Object readFileOrNull(String str, Continuation<? super byte[]> continuation) {
        return this.memFs.get(str);
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public Object writeFile(String str, byte[] bArr, Continuation<? super Unit> continuation) {
        this.memFs.put(str, bArr);
        return Unit.INSTANCE;
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public boolean fileExists(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.memFs.get(path) != null;
    }
}
