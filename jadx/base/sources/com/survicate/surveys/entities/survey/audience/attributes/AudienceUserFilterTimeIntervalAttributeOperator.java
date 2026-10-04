package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterTimeIntervalAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_GREATER_THAN", "IS_LESS_THAN", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterTimeIntervalAttributeOperator implements AudienceUserFilterAttributeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceUserFilterTimeIntervalAttributeOperator[] $VALUES;

    @SerialName("is_greater_than")
    public static final AudienceUserFilterTimeIntervalAttributeOperator IS_GREATER_THAN = new AudienceUserFilterTimeIntervalAttributeOperator("IS_GREATER_THAN", 0);

    @SerialName("is_less_than")
    public static final AudienceUserFilterTimeIntervalAttributeOperator IS_LESS_THAN = new AudienceUserFilterTimeIntervalAttributeOperator("IS_LESS_THAN", 1);

    private static final /* synthetic */ AudienceUserFilterTimeIntervalAttributeOperator[] $values() {
        return new AudienceUserFilterTimeIntervalAttributeOperator[]{IS_GREATER_THAN, IS_LESS_THAN};
    }

    public static EnumEntries<AudienceUserFilterTimeIntervalAttributeOperator> getEntries() {
        return $ENTRIES;
    }

    private AudienceUserFilterTimeIntervalAttributeOperator(String str, int i) {
    }

    static {
        AudienceUserFilterTimeIntervalAttributeOperator[] audienceUserFilterTimeIntervalAttributeOperatorArr$values = $values();
        $VALUES = audienceUserFilterTimeIntervalAttributeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceUserFilterTimeIntervalAttributeOperatorArr$values);
    }

    public static AudienceUserFilterTimeIntervalAttributeOperator valueOf(String str) {
        return (AudienceUserFilterTimeIntervalAttributeOperator) Enum.valueOf(AudienceUserFilterTimeIntervalAttributeOperator.class, str);
    }

    public static AudienceUserFilterTimeIntervalAttributeOperator[] values() {
        return (AudienceUserFilterTimeIntervalAttributeOperator[]) $VALUES.clone();
    }
}
