package com.survicate.surveys.entities.survey.audience;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudienceRelation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toCoreRelation", "Lcom/survicate/surveys/core/targeting/audience/AudienceRelation;", "Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceRelationKt {

    /* JADX INFO: compiled from: AudienceRelation.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceRelation.values().length];
            try {
                iArr[AudienceRelation.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceRelation.f2274OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final com.survicate.surveys.core.targeting.audience.AudienceRelation toCoreRelation(AudienceRelation audienceRelation) {
        Intrinsics.checkNotNullParameter(audienceRelation, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[audienceRelation.ordinal()];
        if (i == 1) {
            return com.survicate.surveys.core.targeting.audience.AudienceRelation.AND;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.survicate.surveys.core.targeting.audience.AudienceRelation.f2264OR;
    }
}
