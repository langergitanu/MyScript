package com.survicate.surveys.entities.survey.audience.attributes;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0000¨\u0006\u000b"}, m1599d2 = {"toCoreOperator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterStringAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterStringAttributeOperator;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterNumberAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterNumberAttributeOperator;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterBooleanAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterBooleanAttributeOperator;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterDateTimeAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterDateTimeAttributeOperator;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterTimeIntervalAttributeOperator;", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterTimeIntervalAttributeOperator;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserFilterAttributeOperatorsKt {

    /* JADX INFO: compiled from: UserFilterAttributeOperators.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[AudienceUserFilterStringAttributeOperator.values().length];
            try {
                iArr[AudienceUserFilterStringAttributeOperator.IS_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.IS_NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.CONTAINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.DOES_NOT_CONTAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.EXISTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.DOES_NOT_EXIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AudienceUserFilterStringAttributeOperator.ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AudienceUserFilterNumberAttributeOperator.values().length];
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_BETWEEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[AudienceUserFilterNumberAttributeOperator.IS_NOT_BETWEEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AudienceUserFilterBooleanAttributeOperator.values().length];
            try {
                iArr3[AudienceUserFilterBooleanAttributeOperator.IS_TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[AudienceUserFilterBooleanAttributeOperator.IS_FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AudienceUserFilterDateTimeAttributeOperator.values().length];
            try {
                iArr4[AudienceUserFilterDateTimeAttributeOperator.IS_EARLIER_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[AudienceUserFilterDateTimeAttributeOperator.IS_LATER_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[AudienceUserFilterDateTimeAttributeOperator.IS_ON_THE_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr4[AudienceUserFilterDateTimeAttributeOperator.IS_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr4[AudienceUserFilterDateTimeAttributeOperator.IS_NOT_BETWEEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[AudienceUserFilterTimeIntervalAttributeOperator.values().length];
            try {
                iArr5[AudienceUserFilterTimeIntervalAttributeOperator.IS_GREATER_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[AudienceUserFilterTimeIntervalAttributeOperator.IS_LESS_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            $EnumSwitchMapping$4 = iArr5;
        }
    }

    public static final com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator toCoreOperator(AudienceUserFilterStringAttributeOperator audienceUserFilterStringAttributeOperator) {
        Intrinsics.checkNotNullParameter(audienceUserFilterStringAttributeOperator, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[audienceUserFilterStringAttributeOperator.ordinal()]) {
            case 1:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.IS_EQUAL;
            case 2:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.IS_NOT_EQUAL;
            case 3:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.CONTAINS;
            case 4:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.DOES_NOT_CONTAIN;
            case 5:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.EXISTS;
            case 6:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.DOES_NOT_EXIST;
            case 7:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttributeOperator.ANY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator toCoreOperator(AudienceUserFilterNumberAttributeOperator audienceUserFilterNumberAttributeOperator) {
        Intrinsics.checkNotNullParameter(audienceUserFilterNumberAttributeOperator, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[audienceUserFilterNumberAttributeOperator.ordinal()]) {
            case 1:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_EQUAL;
            case 2:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_NOT_EQUAL;
            case 3:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN;
            case 4:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN_OR_EQUAL;
            case 5:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN;
            case 6:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN_OR_EQUAL;
            case 7:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_BETWEEN;
            case 8:
                return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterNumberAttributeOperator.IS_NOT_BETWEEN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterBooleanAttributeOperator toCoreOperator(AudienceUserFilterBooleanAttributeOperator audienceUserFilterBooleanAttributeOperator) {
        Intrinsics.checkNotNullParameter(audienceUserFilterBooleanAttributeOperator, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[audienceUserFilterBooleanAttributeOperator.ordinal()];
        if (i == 1) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterBooleanAttributeOperator.IS_TRUE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterBooleanAttributeOperator.IS_FALSE;
    }

    public static final com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator toCoreOperator(AudienceUserFilterDateTimeAttributeOperator audienceUserFilterDateTimeAttributeOperator) {
        Intrinsics.checkNotNullParameter(audienceUserFilterDateTimeAttributeOperator, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$3[audienceUserFilterDateTimeAttributeOperator.ordinal()];
        if (i == 1) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator.IS_EARLIER_THAN;
        }
        if (i == 2) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator.IS_LATER_THAN;
        }
        if (i == 3) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator.IS_ON_THE_DATE;
        }
        if (i == 4) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator.IS_BETWEEN;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterDateTimeAttributeOperator.IS_NOT_BETWEEN;
    }

    public static final com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterTimeIntervalAttributeOperator toCoreOperator(AudienceUserFilterTimeIntervalAttributeOperator audienceUserFilterTimeIntervalAttributeOperator) {
        Intrinsics.checkNotNullParameter(audienceUserFilterTimeIntervalAttributeOperator, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$4[audienceUserFilterTimeIntervalAttributeOperator.ordinal()];
        if (i == 1) {
            return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterTimeIntervalAttributeOperator.IS_GREATER_THAN;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterTimeIntervalAttributeOperator.IS_LESS_THAN;
    }
}
