package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterBooleanAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_TRUE", "IS_FALSE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterBooleanAttributeOperator implements AudienceUserFilterAttributeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceUserFilterBooleanAttributeOperator[] $VALUES;

    @SerialName("is_true")
    public static final AudienceUserFilterBooleanAttributeOperator IS_TRUE = new AudienceUserFilterBooleanAttributeOperator("IS_TRUE", 0);

    @SerialName("is_false")
    public static final AudienceUserFilterBooleanAttributeOperator IS_FALSE = new AudienceUserFilterBooleanAttributeOperator("IS_FALSE", 1);

    private static final /* synthetic */ AudienceUserFilterBooleanAttributeOperator[] $values() {
        return new AudienceUserFilterBooleanAttributeOperator[]{IS_TRUE, IS_FALSE};
    }

    public static EnumEntries<AudienceUserFilterBooleanAttributeOperator> getEntries() {
        return $ENTRIES;
    }

    private AudienceUserFilterBooleanAttributeOperator(String str, int i) {
    }

    static {
        AudienceUserFilterBooleanAttributeOperator[] audienceUserFilterBooleanAttributeOperatorArr$values = $values();
        $VALUES = audienceUserFilterBooleanAttributeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceUserFilterBooleanAttributeOperatorArr$values);
    }

    public static AudienceUserFilterBooleanAttributeOperator valueOf(String str) {
        return (AudienceUserFilterBooleanAttributeOperator) Enum.valueOf(AudienceUserFilterBooleanAttributeOperator.class, str);
    }

    public static AudienceUserFilterBooleanAttributeOperator[] values() {
        return (AudienceUserFilterBooleanAttributeOperator[]) $VALUES.clone();
    }
}
