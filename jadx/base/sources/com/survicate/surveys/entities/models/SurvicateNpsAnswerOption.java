package com.survicate.surveys.entities.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurvicateNpsAnswerOption.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateNpsAnswerOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurvicateNpsAnswerOption[] $VALUES;
    private final int value;
    public static final SurvicateNpsAnswerOption Zero = new SurvicateNpsAnswerOption("Zero", 0, 0);
    public static final SurvicateNpsAnswerOption One = new SurvicateNpsAnswerOption("One", 1, 1);
    public static final SurvicateNpsAnswerOption Two = new SurvicateNpsAnswerOption("Two", 2, 2);
    public static final SurvicateNpsAnswerOption Three = new SurvicateNpsAnswerOption("Three", 3, 3);
    public static final SurvicateNpsAnswerOption Four = new SurvicateNpsAnswerOption("Four", 4, 4);
    public static final SurvicateNpsAnswerOption Five = new SurvicateNpsAnswerOption("Five", 5, 5);
    public static final SurvicateNpsAnswerOption Six = new SurvicateNpsAnswerOption("Six", 6, 6);
    public static final SurvicateNpsAnswerOption Seven = new SurvicateNpsAnswerOption("Seven", 7, 7);
    public static final SurvicateNpsAnswerOption Eight = new SurvicateNpsAnswerOption("Eight", 8, 8);
    public static final SurvicateNpsAnswerOption Nine = new SurvicateNpsAnswerOption("Nine", 9, 9);
    public static final SurvicateNpsAnswerOption Ten = new SurvicateNpsAnswerOption("Ten", 10, 10);

    private static final /* synthetic */ SurvicateNpsAnswerOption[] $values() {
        return new SurvicateNpsAnswerOption[]{Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten};
    }

    public static EnumEntries<SurvicateNpsAnswerOption> getEntries() {
        return $ENTRIES;
    }

    private SurvicateNpsAnswerOption(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        SurvicateNpsAnswerOption[] survicateNpsAnswerOptionArr$values = $values();
        $VALUES = survicateNpsAnswerOptionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(survicateNpsAnswerOptionArr$values);
    }

    public static SurvicateNpsAnswerOption valueOf(String str) {
        return (SurvicateNpsAnswerOption) Enum.valueOf(SurvicateNpsAnswerOption.class, str);
    }

    public static SurvicateNpsAnswerOption[] values() {
        return (SurvicateNpsAnswerOption[]) $VALUES.clone();
    }
}
