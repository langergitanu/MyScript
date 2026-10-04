package com.myscript.nebo.banner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Banners.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/banner/Type;", "", "<init>", "(Ljava/lang/String;I)V", "PERMANENT", "PERMANENT_FORCED", "TRANSIENT", "UNIQUE_TRANSIENT", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Type {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Type[] $VALUES;
    public static final Type PERMANENT = new Type("PERMANENT", 0);
    public static final Type PERMANENT_FORCED = new Type("PERMANENT_FORCED", 1);
    public static final Type TRANSIENT = new Type("TRANSIENT", 2);
    public static final Type UNIQUE_TRANSIENT = new Type("UNIQUE_TRANSIENT", 3);

    private static final /* synthetic */ Type[] $values() {
        return new Type[]{PERMANENT, PERMANENT_FORCED, TRANSIENT, UNIQUE_TRANSIENT};
    }

    public static EnumEntries<Type> getEntries() {
        return $ENTRIES;
    }

    public static Type valueOf(String str) {
        return (Type) Enum.valueOf(Type.class, str);
    }

    public static Type[] values() {
        return (Type[]) $VALUES.clone();
    }

    private Type(String str, int i) {
    }

    static {
        Type[] typeArr$values = $values();
        $VALUES = typeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
    }
}
