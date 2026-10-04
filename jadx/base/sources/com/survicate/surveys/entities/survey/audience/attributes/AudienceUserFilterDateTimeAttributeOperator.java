package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterDateTimeAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EARLIER_THAN", "IS_LATER_THAN", "IS_ON_THE_DATE", "IS_BETWEEN", "IS_NOT_BETWEEN", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterDateTimeAttributeOperator implements AudienceUserFilterAttributeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceUserFilterDateTimeAttributeOperator[] $VALUES;

    @SerialName("is_earlier_than")
    public static final AudienceUserFilterDateTimeAttributeOperator IS_EARLIER_THAN = new AudienceUserFilterDateTimeAttributeOperator("IS_EARLIER_THAN", 0);

    @SerialName("is_later_than")
    public static final AudienceUserFilterDateTimeAttributeOperator IS_LATER_THAN = new AudienceUserFilterDateTimeAttributeOperator("IS_LATER_THAN", 1);

    @SerialName("is_on_the_date")
    public static final AudienceUserFilterDateTimeAttributeOperator IS_ON_THE_DATE = new AudienceUserFilterDateTimeAttributeOperator("IS_ON_THE_DATE", 2);

    @SerialName("is_between")
    public static final AudienceUserFilterDateTimeAttributeOperator IS_BETWEEN = new AudienceUserFilterDateTimeAttributeOperator("IS_BETWEEN", 3);

    @SerialName("is_not_between")
    public static final AudienceUserFilterDateTimeAttributeOperator IS_NOT_BETWEEN = new AudienceUserFilterDateTimeAttributeOperator("IS_NOT_BETWEEN", 4);

    private static final /* synthetic */ AudienceUserFilterDateTimeAttributeOperator[] $values() {
        return new AudienceUserFilterDateTimeAttributeOperator[]{IS_EARLIER_THAN, IS_LATER_THAN, IS_ON_THE_DATE, IS_BETWEEN, IS_NOT_BETWEEN};
    }

    public static EnumEntries<AudienceUserFilterDateTimeAttributeOperator> getEntries() {
        return $ENTRIES;
    }

    private AudienceUserFilterDateTimeAttributeOperator(String str, int i) {
    }

    static {
        AudienceUserFilterDateTimeAttributeOperator[] audienceUserFilterDateTimeAttributeOperatorArr$values = $values();
        $VALUES = audienceUserFilterDateTimeAttributeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceUserFilterDateTimeAttributeOperatorArr$values);
    }

    public static AudienceUserFilterDateTimeAttributeOperator valueOf(String str) {
        return (AudienceUserFilterDateTimeAttributeOperator) Enum.valueOf(AudienceUserFilterDateTimeAttributeOperator.class, str);
    }

    public static AudienceUserFilterDateTimeAttributeOperator[] values() {
        return (AudienceUserFilterDateTimeAttributeOperator[]) $VALUES.clone();
    }
}
