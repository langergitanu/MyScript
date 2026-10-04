package com.myscript.nebo.init;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InitContentViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/init/InitContentError;", "", "<init>", "(Ljava/lang/String;I)V", "CANNOT_CREATE_COLLECTION", "CANNOT_CREATE_FOLDER", "CANNOT_CREATE_NOTEBOOK", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InitContentError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InitContentError[] $VALUES;
    public static final InitContentError CANNOT_CREATE_COLLECTION = new InitContentError("CANNOT_CREATE_COLLECTION", 0);
    public static final InitContentError CANNOT_CREATE_FOLDER = new InitContentError("CANNOT_CREATE_FOLDER", 1);
    public static final InitContentError CANNOT_CREATE_NOTEBOOK = new InitContentError("CANNOT_CREATE_NOTEBOOK", 2);

    private static final /* synthetic */ InitContentError[] $values() {
        return new InitContentError[]{CANNOT_CREATE_COLLECTION, CANNOT_CREATE_FOLDER, CANNOT_CREATE_NOTEBOOK};
    }

    public static EnumEntries<InitContentError> getEntries() {
        return $ENTRIES;
    }

    public static InitContentError valueOf(String str) {
        return (InitContentError) Enum.valueOf(InitContentError.class, str);
    }

    public static InitContentError[] values() {
        return (InitContentError[]) $VALUES.clone();
    }

    private InitContentError(String str, int i) {
    }

    static {
        InitContentError[] initContentErrorArr$values = $values();
        $VALUES = initContentErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(initContentErrorArr$values);
    }
}
