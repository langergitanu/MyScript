package aws.smithy.kotlin.runtime.serde.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LexerState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/LexerState;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "ArrayFirstValueOrEnd", "ArrayNextValueOrEnd", "ObjectFirstKeyOrEnd", "ObjectNextKeyOrEnd", "ObjectFieldValue", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LexerState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LexerState[] $VALUES;
    public static final LexerState Initial = new LexerState("Initial", 0);
    public static final LexerState ArrayFirstValueOrEnd = new LexerState("ArrayFirstValueOrEnd", 1);
    public static final LexerState ArrayNextValueOrEnd = new LexerState("ArrayNextValueOrEnd", 2);
    public static final LexerState ObjectFirstKeyOrEnd = new LexerState("ObjectFirstKeyOrEnd", 3);
    public static final LexerState ObjectNextKeyOrEnd = new LexerState("ObjectNextKeyOrEnd", 4);
    public static final LexerState ObjectFieldValue = new LexerState("ObjectFieldValue", 5);

    private static final /* synthetic */ LexerState[] $values() {
        return new LexerState[]{Initial, ArrayFirstValueOrEnd, ArrayNextValueOrEnd, ObjectFirstKeyOrEnd, ObjectNextKeyOrEnd, ObjectFieldValue};
    }

    public static EnumEntries<LexerState> getEntries() {
        return $ENTRIES;
    }

    public static LexerState valueOf(String str) {
        return (LexerState) Enum.valueOf(LexerState.class, str);
    }

    public static LexerState[] values() {
        return (LexerState[]) $VALUES.clone();
    }

    private LexerState(String str, int i) {
    }

    static {
        LexerState[] lexerStateArr$values = $values();
        $VALUES = lexerStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(lexerStateArr$values);
    }
}
