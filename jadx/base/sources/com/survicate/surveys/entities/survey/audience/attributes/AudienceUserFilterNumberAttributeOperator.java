package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterNumberAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EQUAL", "IS_NOT_EQUAL", "IS_GREATER_THAN", "IS_GREATER_THAN_OR_EQUAL", "IS_LESS_THAN", "IS_LESS_THAN_OR_EQUAL", "IS_BETWEEN", "IS_NOT_BETWEEN", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterNumberAttributeOperator implements AudienceUserFilterAttributeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceUserFilterNumberAttributeOperator[] $VALUES;

    @SerialName("is_equal")
    public static final AudienceUserFilterNumberAttributeOperator IS_EQUAL = new AudienceUserFilterNumberAttributeOperator("IS_EQUAL", 0);

    @SerialName("is_not_equal")
    public static final AudienceUserFilterNumberAttributeOperator IS_NOT_EQUAL = new AudienceUserFilterNumberAttributeOperator("IS_NOT_EQUAL", 1);

    @SerialName("is_greater_than")
    public static final AudienceUserFilterNumberAttributeOperator IS_GREATER_THAN = new AudienceUserFilterNumberAttributeOperator("IS_GREATER_THAN", 2);

    @SerialName("is_greater_than_or_equal")
    public static final AudienceUserFilterNumberAttributeOperator IS_GREATER_THAN_OR_EQUAL = new AudienceUserFilterNumberAttributeOperator("IS_GREATER_THAN_OR_EQUAL", 3);

    @SerialName("is_less_than")
    public static final AudienceUserFilterNumberAttributeOperator IS_LESS_THAN = new AudienceUserFilterNumberAttributeOperator("IS_LESS_THAN", 4);

    @SerialName("is_less_than_or_equal")
    public static final AudienceUserFilterNumberAttributeOperator IS_LESS_THAN_OR_EQUAL = new AudienceUserFilterNumberAttributeOperator("IS_LESS_THAN_OR_EQUAL", 5);

    @SerialName("is_between")
    public static final AudienceUserFilterNumberAttributeOperator IS_BETWEEN = new AudienceUserFilterNumberAttributeOperator("IS_BETWEEN", 6);

    @SerialName("is_not_between")
    public static final AudienceUserFilterNumberAttributeOperator IS_NOT_BETWEEN = new AudienceUserFilterNumberAttributeOperator("IS_NOT_BETWEEN", 7);

    private static final /* synthetic */ AudienceUserFilterNumberAttributeOperator[] $values() {
        return new AudienceUserFilterNumberAttributeOperator[]{IS_EQUAL, IS_NOT_EQUAL, IS_GREATER_THAN, IS_GREATER_THAN_OR_EQUAL, IS_LESS_THAN, IS_LESS_THAN_OR_EQUAL, IS_BETWEEN, IS_NOT_BETWEEN};
    }

    public static EnumEntries<AudienceUserFilterNumberAttributeOperator> getEntries() {
        return $ENTRIES;
    }

    private AudienceUserFilterNumberAttributeOperator(String str, int i) {
    }

    static {
        AudienceUserFilterNumberAttributeOperator[] audienceUserFilterNumberAttributeOperatorArr$values = $values();
        $VALUES = audienceUserFilterNumberAttributeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceUserFilterNumberAttributeOperatorArr$values);
    }

    public static AudienceUserFilterNumberAttributeOperator valueOf(String str) {
        return (AudienceUserFilterNumberAttributeOperator) Enum.valueOf(AudienceUserFilterNumberAttributeOperator.class, str);
    }

    public static AudienceUserFilterNumberAttributeOperator[] values() {
        return (AudienceUserFilterNumberAttributeOperator[]) $VALUES.clone();
    }
}
