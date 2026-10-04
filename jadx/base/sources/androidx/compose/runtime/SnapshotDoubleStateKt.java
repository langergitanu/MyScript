package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SnapshotDoubleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState doubleState, Object obj, KProperty<?> kProperty) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue(doubleState, obj, kProperty);
    }

    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(d);
    }

    public static final void setValue(MutableDoubleState mutableDoubleState, Object obj, KProperty<?> kProperty, double d) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue(mutableDoubleState, obj, kProperty, d);
    }
}
