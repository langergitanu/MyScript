package com.myscript.nebo.note;

import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/note/Orientation;", "", "labelRes", "", "<init>", "(Ljava/lang/String;II)V", "getLabelRes", "()I", "Portrait", "Landscape", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Orientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Orientation[] $VALUES;
    private final int labelRes;
    public static final Orientation Portrait = new Orientation("Portrait", 0, C6079R.string.orientation_portrait);
    public static final Orientation Landscape = new Orientation("Landscape", 1, C6079R.string.orientation_landscape);

    private static final /* synthetic */ Orientation[] $values() {
        return new Orientation[]{Portrait, Landscape};
    }

    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    public static Orientation valueOf(String str) {
        return (Orientation) Enum.valueOf(Orientation.class, str);
    }

    public static Orientation[] values() {
        return (Orientation[]) $VALUES.clone();
    }

    private Orientation(String str, int i, int i2) {
        this.labelRes = i2;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    static {
        Orientation[] orientationArr$values = $values();
        $VALUES = orientationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(orientationArr$values);
    }
}
