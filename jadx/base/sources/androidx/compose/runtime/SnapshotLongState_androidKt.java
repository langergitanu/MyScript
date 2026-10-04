package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: compiled from: SnapshotLongState.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"createSnapshotMutableLongState", "Landroidx/compose/runtime/MutableLongState;", "value", "", "runtime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SnapshotLongState_androidKt {
    public static final MutableLongState createSnapshotMutableLongState(long j) {
        return new ParcelableSnapshotMutableLongState(j);
    }
}
