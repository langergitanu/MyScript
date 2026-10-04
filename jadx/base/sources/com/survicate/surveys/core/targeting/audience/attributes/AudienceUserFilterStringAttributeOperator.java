package com.survicate.surveys.core.targeting.audience.attributes;

import com.google.api.client.googleapis.notifications.ResourceStates;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterStringAttributeOperator;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttributeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EQUAL", "IS_NOT_EQUAL", "CONTAINS", "DOES_NOT_CONTAIN", ResourceStates.EXISTS, "DOES_NOT_EXIST", "ANY", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterStringAttributeOperator implements AudienceUserFilterAttributeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceUserFilterStringAttributeOperator[] $VALUES;
    public static final AudienceUserFilterStringAttributeOperator IS_EQUAL = new AudienceUserFilterStringAttributeOperator("IS_EQUAL", 0);
    public static final AudienceUserFilterStringAttributeOperator IS_NOT_EQUAL = new AudienceUserFilterStringAttributeOperator("IS_NOT_EQUAL", 1);
    public static final AudienceUserFilterStringAttributeOperator CONTAINS = new AudienceUserFilterStringAttributeOperator("CONTAINS", 2);
    public static final AudienceUserFilterStringAttributeOperator DOES_NOT_CONTAIN = new AudienceUserFilterStringAttributeOperator("DOES_NOT_CONTAIN", 3);
    public static final AudienceUserFilterStringAttributeOperator EXISTS = new AudienceUserFilterStringAttributeOperator(ResourceStates.EXISTS, 4);
    public static final AudienceUserFilterStringAttributeOperator DOES_NOT_EXIST = new AudienceUserFilterStringAttributeOperator("DOES_NOT_EXIST", 5);
    public static final AudienceUserFilterStringAttributeOperator ANY = new AudienceUserFilterStringAttributeOperator("ANY", 6);

    private static final /* synthetic */ AudienceUserFilterStringAttributeOperator[] $values() {
        return new AudienceUserFilterStringAttributeOperator[]{IS_EQUAL, IS_NOT_EQUAL, CONTAINS, DOES_NOT_CONTAIN, EXISTS, DOES_NOT_EXIST, ANY};
    }

    public static EnumEntries<AudienceUserFilterStringAttributeOperator> getEntries() {
        return $ENTRIES;
    }

    private AudienceUserFilterStringAttributeOperator(String str, int i) {
    }

    static {
        AudienceUserFilterStringAttributeOperator[] audienceUserFilterStringAttributeOperatorArr$values = $values();
        $VALUES = audienceUserFilterStringAttributeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceUserFilterStringAttributeOperatorArr$values);
    }

    public static AudienceUserFilterStringAttributeOperator valueOf(String str) {
        return (AudienceUserFilterStringAttributeOperator) Enum.valueOf(AudienceUserFilterStringAttributeOperator.class, str);
    }

    public static AudienceUserFilterStringAttributeOperator[] values() {
        return (AudienceUserFilterStringAttributeOperator[]) $VALUES.clone();
    }
}
