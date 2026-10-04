package com.survicate.surveys.entities.attributes;

import com.survicate.surveys.C8369R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MicroSurvicateSelectionType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/entities/attributes/MicroSurvicateSelectionType;", "", "drawableRes", "", "<init>", "(Ljava/lang/String;II)V", "getDrawableRes", "()I", "Checkbox", "Radio", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurvicateSelectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MicroSurvicateSelectionType[] $VALUES;
    public static final MicroSurvicateSelectionType Checkbox = new MicroSurvicateSelectionType("Checkbox", 0, C8369R.drawable.ic_checkbox_button_micro);
    public static final MicroSurvicateSelectionType Radio = new MicroSurvicateSelectionType("Radio", 1, C8369R.drawable.ic_radio_button_micro);
    private final int drawableRes;

    private static final /* synthetic */ MicroSurvicateSelectionType[] $values() {
        return new MicroSurvicateSelectionType[]{Checkbox, Radio};
    }

    public static EnumEntries<MicroSurvicateSelectionType> getEntries() {
        return $ENTRIES;
    }

    private MicroSurvicateSelectionType(String str, int i, int i2) {
        this.drawableRes = i2;
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    static {
        MicroSurvicateSelectionType[] microSurvicateSelectionTypeArr$values = $values();
        $VALUES = microSurvicateSelectionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(microSurvicateSelectionTypeArr$values);
    }

    public static MicroSurvicateSelectionType valueOf(String str) {
        return (MicroSurvicateSelectionType) Enum.valueOf(MicroSurvicateSelectionType.class, str);
    }

    public static MicroSurvicateSelectionType[] values() {
        return (MicroSurvicateSelectionType[]) $VALUES.clone();
    }
}
