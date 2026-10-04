package com.survicate.surveys.entities.attributes;

import com.survicate.surveys.C8369R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MicroSurvicateCommentFieldStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/entities/attributes/MicroSurvicateCommentFieldStyle;", "", "id", "", "height", "<init>", "(Ljava/lang/String;III)V", "getId", "()I", "getHeight", "NESTED", "STANDALONE", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurvicateCommentFieldStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MicroSurvicateCommentFieldStyle[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MicroSurvicateCommentFieldStyle NESTED = new MicroSurvicateCommentFieldStyle("NESTED", 0, 0, C8369R.dimen.survicate_micro_input_height_comment_nested);
    public static final MicroSurvicateCommentFieldStyle STANDALONE = new MicroSurvicateCommentFieldStyle("STANDALONE", 1, 1, C8369R.dimen.survicate_micro_input_height_comment_standalone);
    private final int height;
    private final int id;

    private static final /* synthetic */ MicroSurvicateCommentFieldStyle[] $values() {
        return new MicroSurvicateCommentFieldStyle[]{NESTED, STANDALONE};
    }

    public static EnumEntries<MicroSurvicateCommentFieldStyle> getEntries() {
        return $ENTRIES;
    }

    private MicroSurvicateCommentFieldStyle(String str, int i, int i2, int i3) {
        this.id = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    static {
        MicroSurvicateCommentFieldStyle[] microSurvicateCommentFieldStyleArr$values = $values();
        $VALUES = microSurvicateCommentFieldStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(microSurvicateCommentFieldStyleArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: MicroSurvicateCommentFieldStyle.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/attributes/MicroSurvicateCommentFieldStyle$Companion;", "", "<init>", "()V", "fromId", "Lcom/survicate/surveys/entities/attributes/MicroSurvicateCommentFieldStyle;", "id", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MicroSurvicateCommentFieldStyle fromId(int id) {
            MicroSurvicateCommentFieldStyle next;
            Iterator<MicroSurvicateCommentFieldStyle> it = MicroSurvicateCommentFieldStyle.getEntries().iterator();
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
            MicroSurvicateCommentFieldStyle microSurvicateCommentFieldStyle = next;
            return microSurvicateCommentFieldStyle == null ? MicroSurvicateCommentFieldStyle.STANDALONE : microSurvicateCommentFieldStyle;
        }
    }

    public static MicroSurvicateCommentFieldStyle valueOf(String str) {
        return (MicroSurvicateCommentFieldStyle) Enum.valueOf(MicroSurvicateCommentFieldStyle.class, str);
    }

    public static MicroSurvicateCommentFieldStyle[] values() {
        return (MicroSurvicateCommentFieldStyle[]) $VALUES.clone();
    }
}
