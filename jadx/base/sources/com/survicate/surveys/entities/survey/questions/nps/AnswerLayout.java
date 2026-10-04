package com.survicate.surveys.entities.survey.questions.nps;

import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyNpsPointSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;", "", "<init>", "(Ljava/lang/String;I)V", Profile.DEFAULT_PROFILE_NAME, "Horizontal", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AnswerLayout {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnswerLayout[] $VALUES;

    @SerialName("default")
    public static final AnswerLayout Default = new AnswerLayout(Profile.DEFAULT_PROFILE_NAME, 0);

    @SerialName("horizontal")
    public static final AnswerLayout Horizontal = new AnswerLayout("Horizontal", 1);

    private static final /* synthetic */ AnswerLayout[] $values() {
        return new AnswerLayout[]{Default, Horizontal};
    }

    public static EnumEntries<AnswerLayout> getEntries() {
        return $ENTRIES;
    }

    private AnswerLayout(String str, int i) {
    }

    static {
        AnswerLayout[] answerLayoutArr$values = $values();
        $VALUES = answerLayoutArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(answerLayoutArr$values);
    }

    public static AnswerLayout valueOf(String str) {
        return (AnswerLayout) Enum.valueOf(AnswerLayout.class, str);
    }

    public static AnswerLayout[] values() {
        return (AnswerLayout[]) $VALUES.clone();
    }
}
