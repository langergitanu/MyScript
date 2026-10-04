package com.survicate.surveys.entities.survey;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.surveys.CtaSurveyAnswerType;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyAnswerType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SMILEY_SCALE", "SINGLE", "MULTIPLE", "TEXT", "DATE", "CSAT", "NUMERICAL", "SHAPE", "MATRIX", "NPS", "FORM", "BUTTON_NEXT", "BUTTON_CLOSE", "BUTTON_LINK", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyAnswerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyAnswerType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String key;

    @SerialName(QuestionSurveyAnswerType.SMILEY_SCALE)
    public static final SurveyAnswerType SMILEY_SCALE = new SurveyAnswerType("SMILEY_SCALE", 0, QuestionSurveyAnswerType.SMILEY_SCALE);

    @SerialName(QuestionSurveyAnswerType.SINGLE)
    public static final SurveyAnswerType SINGLE = new SurveyAnswerType("SINGLE", 1, QuestionSurveyAnswerType.SINGLE);

    @SerialName(QuestionSurveyAnswerType.MULTIPLE)
    public static final SurveyAnswerType MULTIPLE = new SurveyAnswerType("MULTIPLE", 2, QuestionSurveyAnswerType.MULTIPLE);

    @SerialName("text")
    public static final SurveyAnswerType TEXT = new SurveyAnswerType("TEXT", 3, "text");

    @SerialName(QuestionSurveyAnswerType.DATE)
    public static final SurveyAnswerType DATE = new SurveyAnswerType("DATE", 4, QuestionSurveyAnswerType.DATE);

    @SerialName(QuestionSurveyAnswerType.CSAT)
    public static final SurveyAnswerType CSAT = new SurveyAnswerType("CSAT", 5, QuestionSurveyAnswerType.CSAT);

    @SerialName(QuestionSurveyAnswerType.NUMERICAL)
    public static final SurveyAnswerType NUMERICAL = new SurveyAnswerType("NUMERICAL", 6, QuestionSurveyAnswerType.NUMERICAL);

    @SerialName(QuestionSurveyAnswerType.SHAPE)
    public static final SurveyAnswerType SHAPE = new SurveyAnswerType("SHAPE", 7, QuestionSurveyAnswerType.SHAPE);

    @SerialName(QuestionSurveyAnswerType.MATRIX)
    public static final SurveyAnswerType MATRIX = new SurveyAnswerType("MATRIX", 8, QuestionSurveyAnswerType.MATRIX);

    @SerialName("nps")
    public static final SurveyAnswerType NPS = new SurveyAnswerType("NPS", 9, "nps");

    @SerialName("form")
    public static final SurveyAnswerType FORM = new SurveyAnswerType("FORM", 10, "form");

    @SerialName(CtaSurveyAnswerType.BUTTON_NEXT)
    public static final SurveyAnswerType BUTTON_NEXT = new SurveyAnswerType("BUTTON_NEXT", 11, CtaSurveyAnswerType.BUTTON_NEXT);

    @SerialName(CtaSurveyAnswerType.BUTTON_CLOSE)
    public static final SurveyAnswerType BUTTON_CLOSE = new SurveyAnswerType("BUTTON_CLOSE", 12, CtaSurveyAnswerType.BUTTON_CLOSE);

    @SerialName(CtaSurveyAnswerType.BUTTON_LINK)
    public static final SurveyAnswerType BUTTON_LINK = new SurveyAnswerType("BUTTON_LINK", 13, CtaSurveyAnswerType.BUTTON_LINK);

    private static final /* synthetic */ SurveyAnswerType[] $values() {
        return new SurveyAnswerType[]{SMILEY_SCALE, SINGLE, MULTIPLE, TEXT, DATE, CSAT, NUMERICAL, SHAPE, MATRIX, NPS, FORM, BUTTON_NEXT, BUTTON_CLOSE, BUTTON_LINK};
    }

    @JvmStatic
    public static final SurveyAnswerType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<SurveyAnswerType> getEntries() {
        return $ENTRIES;
    }

    private SurveyAnswerType(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        SurveyAnswerType[] surveyAnswerTypeArr$values = $values();
        $VALUES = surveyAnswerTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyAnswerTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: SurveyAnswerType.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveyAnswerType$Companion;", "", "<init>", "()V", "fromString", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "typeString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SurveyAnswerType fromString(String typeString) {
            SurveyAnswerType next;
            Intrinsics.checkNotNullParameter(typeString, "typeString");
            Iterator<SurveyAnswerType> it = SurveyAnswerType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String key = next.getKey();
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = key.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Locale US2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase2 = typeString.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    break;
                }
            }
            return next;
        }
    }

    public static SurveyAnswerType valueOf(String str) {
        return (SurveyAnswerType) Enum.valueOf(SurveyAnswerType.class, str);
    }

    public static SurveyAnswerType[] values() {
        return (SurveyAnswerType[]) $VALUES.clone();
    }
}
