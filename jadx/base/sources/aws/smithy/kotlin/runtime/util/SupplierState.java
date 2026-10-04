package aws.smithy.kotlin.runtime.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DslBuilderProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/SupplierState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_INITIALIZED", "INITIALIZED", "EXPLICIT_CONFIG", "EXPLICIT_INSTANCE", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class SupplierState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SupplierState[] $VALUES;
    public static final SupplierState NOT_INITIALIZED = new SupplierState("NOT_INITIALIZED", 0);
    public static final SupplierState INITIALIZED = new SupplierState("INITIALIZED", 1);
    public static final SupplierState EXPLICIT_CONFIG = new SupplierState("EXPLICIT_CONFIG", 2);
    public static final SupplierState EXPLICIT_INSTANCE = new SupplierState("EXPLICIT_INSTANCE", 3);

    private static final /* synthetic */ SupplierState[] $values() {
        return new SupplierState[]{NOT_INITIALIZED, INITIALIZED, EXPLICIT_CONFIG, EXPLICIT_INSTANCE};
    }

    public static EnumEntries<SupplierState> getEntries() {
        return $ENTRIES;
    }

    public static SupplierState valueOf(String str) {
        return (SupplierState) Enum.valueOf(SupplierState.class, str);
    }

    public static SupplierState[] values() {
        return (SupplierState[]) $VALUES.clone();
    }

    private SupplierState(String str, int i) {
    }

    static {
        SupplierState[] supplierStateArr$values = $values();
        $VALUES = supplierStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(supplierStateArr$values);
    }
}
