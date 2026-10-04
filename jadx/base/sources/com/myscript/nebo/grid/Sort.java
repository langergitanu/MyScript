package com.myscript.nebo.grid;

import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/grid/Sort;", "", "<init>", "(Ljava/lang/String;I)V", "Manual", "Alphabetical", "CreationDate", "ModificationDate", "nameRes", "", "getNameRes", "()I", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Sort {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Sort[] $VALUES;
    public static final Sort Manual = new Sort("Manual", 0);
    public static final Sort Alphabetical = new Sort("Alphabetical", 1);
    public static final Sort CreationDate = new Sort("CreationDate", 2);
    public static final Sort ModificationDate = new Sort("ModificationDate", 3);

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

    private static final /* synthetic */ Sort[] $values() {
        return new Sort[]{Manual, Alphabetical, CreationDate, ModificationDate};
    }

    public static EnumEntries<Sort> getEntries() {
        return $ENTRIES;
    }

    public static Sort valueOf(String str) {
        return (Sort) Enum.valueOf(Sort.class, str);
    }

    public static Sort[] values() {
        return (Sort[]) $VALUES.clone();
    }

    private Sort(String str, int i) {
    }

    static {
        Sort[] sortArr$values = $values();
        $VALUES = sortArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sortArr$values);
    }

    public final int getNameRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return C6079R.string.grid_sort_manual;
        }
        if (i == 2) {
            return C6079R.string.grid_sort_alphabetical;
        }
        if (i == 3) {
            return C6079R.string.grid_sort_creation_date;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return C6079R.string.grid_sort_modification_date;
    }
}
