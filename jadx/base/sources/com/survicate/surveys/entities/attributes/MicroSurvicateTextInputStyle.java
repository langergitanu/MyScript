package com.survicate.surveys.entities.attributes;

import com.survicate.surveys.C8369R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MicroSurvicateTextInputStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/entities/attributes/MicroSurvicateTextInputStyle;", "", "id", "", "height", "singleLine", "", "<init>", "(Ljava/lang/String;IILjava/lang/Integer;Z)V", "getId", "()I", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSingleLine", "()Z", "TEXT_ANSWER", "FORM", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurvicateTextInputStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MicroSurvicateTextInputStyle[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final Integer height;
    private final int id;
    private final boolean singleLine;
    public static final MicroSurvicateTextInputStyle TEXT_ANSWER = new MicroSurvicateTextInputStyle("TEXT_ANSWER", 0, 0, Integer.valueOf(C8369R.dimen.survicate_micro_input_height_text_answer), false);
    public static final MicroSurvicateTextInputStyle FORM = new MicroSurvicateTextInputStyle("FORM", 1, 1, null, true);

    private static final /* synthetic */ MicroSurvicateTextInputStyle[] $values() {
        return new MicroSurvicateTextInputStyle[]{TEXT_ANSWER, FORM};
    }

    public static EnumEntries<MicroSurvicateTextInputStyle> getEntries() {
        return $ENTRIES;
    }

    private MicroSurvicateTextInputStyle(String str, int i, int i2, Integer num, boolean z) {
        this.id = i2;
        this.height = num;
        this.singleLine = z;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    static {
        MicroSurvicateTextInputStyle[] microSurvicateTextInputStyleArr$values = $values();
        $VALUES = microSurvicateTextInputStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(microSurvicateTextInputStyleArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: MicroSurvicateTextInputStyle.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/attributes/MicroSurvicateTextInputStyle$Companion;", "", "<init>", "()V", "fromId", "Lcom/survicate/surveys/entities/attributes/MicroSurvicateTextInputStyle;", "id", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MicroSurvicateTextInputStyle fromId(int id) {
            MicroSurvicateTextInputStyle next;
            Iterator<MicroSurvicateTextInputStyle> it = MicroSurvicateTextInputStyle.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == id) {
                    break;
                }
            }
            MicroSurvicateTextInputStyle microSurvicateTextInputStyle = next;
            return microSurvicateTextInputStyle == null ? MicroSurvicateTextInputStyle.TEXT_ANSWER : microSurvicateTextInputStyle;
        }
    }

    public static MicroSurvicateTextInputStyle valueOf(String str) {
        return (MicroSurvicateTextInputStyle) Enum.valueOf(MicroSurvicateTextInputStyle.class, str);
    }

    public static MicroSurvicateTextInputStyle[] values() {
        return (MicroSurvicateTextInputStyle[]) $VALUES.clone();
    }
}
