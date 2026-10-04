package aws.smithy.kotlin.runtime.util;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: Filesystem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H¦@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/Filesystem;", "", "", ClientCookie.PATH_ATTR, "", "readFileOrNull", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "writeFile", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "fileExists", "(Ljava/lang/String;)Z", "getFilePathSeparator", "()Ljava/lang/String;", "filePathSeparator", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Filesystem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    boolean fileExists(String path);

    String getFilePathSeparator();

    Object readFileOrNull(String str, Continuation<? super byte[]> continuation);

    Object writeFile(String str, byte[] bArr, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: Filesystem.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/Filesystem$Companion;", "", "<init>", "()V", "", "", "", "data", "filePathSeparator", "Laws/smithy/kotlin/runtime/util/Filesystem;", "fromMap", "(Ljava/util/Map;Ljava/lang/String;)Laws/smithy/kotlin/runtime/util/Filesystem;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ Filesystem fromMap$default(Companion companion, Map map, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = DomExceptionUtils.SEPARATOR;
            }
            return companion.fromMap(map, str);
        }

        public final Filesystem fromMap(Map<String, byte[]> data, String filePathSeparator) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(filePathSeparator, "filePathSeparator");
            return new MapFilesystem(MapsKt.toMutableMap(data), filePathSeparator);
        }
    }
}
