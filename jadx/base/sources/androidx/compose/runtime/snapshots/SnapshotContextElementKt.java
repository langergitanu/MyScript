package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

/* JADX INFO: compiled from: SnapshotContextElement.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"asContextElement", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "runtime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SnapshotContextElementKt {
    public static final SnapshotContextElement asContextElement(Snapshot snapshot) {
        return new SnapshotContextElementImpl(snapshot);
    }
}
