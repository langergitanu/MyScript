package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.InterProcessCoordinatorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: OkioStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"createSingleProcessCoordinator", "Landroidx/datastore/core/InterProcessCoordinator;", ClientCookie.PATH_ATTR, "Lokio/Path;", "datastore-core-okio"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class OkioStorageKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(path.normalized().toString());
    }
}
