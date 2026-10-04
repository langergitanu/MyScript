package com.myscript.nebo.grid;

import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/grid/Order;", "", "<init>", "(Ljava/lang/String;I)V", "Ascending", "Descending", "getNameRes", "", "sorting", "Lcom/myscript/nebo/grid/Sort;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Order {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Order[] $VALUES;
    public static final Order Ascending = new Order("Ascending", 0);
    public static final Order Descending = new Order("Descending", 1);

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Sort.values().length];
            try {
                iArr[Sort.Manual.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Sort.Alphabetical.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Sort.CreationDate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Sort.ModificationDate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Order[] $values() {
        return new Order[]{Ascending, Descending};
    }

    public static EnumEntries<Order> getEntries() {
        return $ENTRIES;
    }

    public static Order valueOf(String str) {
        return (Order) Enum.valueOf(Order.class, str);
    }

    public static Order[] values() {
        return (Order[]) $VALUES.clone();
    }

    private Order(String str, int i) {
    }

    static {
        Order[] orderArr$values = $values();
        $VALUES = orderArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(orderArr$values);
    }

    public final int getNameRes(Sort sorting) {
        Intrinsics.checkNotNullParameter(sorting, "sorting");
        int i = WhenMappings.$EnumSwitchMapping$0[sorting.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return this == Ascending ? C6079R.string.grid_sort_order_name_ascending : C6079R.string.grid_sort_order_name_descending;
        }
        if (i == 3) {
            return this == Ascending ? C6079R.string.grid_sort_order_date_ascending : C6079R.string.grid_sort_order_date_descending;
        }
        if (i == 4) {
            return this == Ascending ? C6079R.string.grid_sort_order_date_ascending : C6079R.string.grid_sort_order_date_descending;
        }
        throw new NoWhenBranchMatchedException();
    }
}
