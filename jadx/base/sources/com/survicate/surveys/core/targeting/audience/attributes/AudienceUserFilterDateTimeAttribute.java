package com.survicate.surveys.core.targeting.audience.attributes;

import com.survicate.surveys.core.traits.CoreUserTrait;
import com.survicate.surveys.core.utils.DateUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudienceUserFilterDateTimeAttribute.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterDateTimeAttribute;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterDateTimeAttributeOperator;", "values", "", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterDateTimeAttributeOperator;Ljava/util/List;)V", "isSatisfiedBy", "", "userTraits", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterDateTimeAttribute implements AudienceUserFilterAttribute {
    private final String name;
    private final AudienceUserFilterDateTimeAttributeOperator operator;
    private final List<String> values;

    /* JADX INFO: compiled from: AudienceUserFilterDateTimeAttribute.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceUserFilterDateTimeAttributeOperator.values().length];
            try {
                iArr[AudienceUserFilterDateTimeAttributeOperator.IS_EARLIER_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceUserFilterDateTimeAttributeOperator.IS_LATER_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AudienceUserFilterDateTimeAttributeOperator.IS_ON_THE_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AudienceUserFilterDateTimeAttributeOperator.IS_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AudienceUserFilterDateTimeAttributeOperator.IS_NOT_BETWEEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudienceUserFilterDateTimeAttribute(String name, AudienceUserFilterDateTimeAttributeOperator operator, List<String> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(values, "values");
        this.name = name;
        this.operator = operator;
        this.values = values;
    }

    @Override // com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterAttribute
    public boolean isSatisfiedBy(List<CoreUserTrait> userTraits) {
        Object next;
        String dateOnlyPart;
        String str;
        String dateOnlyPart2;
        Intrinsics.checkNotNullParameter(userTraits, "userTraits");
        Iterator<T> it = userTraits.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((CoreUserTrait) next).getKey(), this.name)) {
                break;
            }
        }
        CoreUserTrait coreUserTrait = (CoreUserTrait) next;
        if (coreUserTrait != null && (dateOnlyPart = DateUtilsKt.getDateOnlyPart(coreUserTrait.getValue())) != null && (str = (String) CollectionsKt.getOrNull(this.values, 0)) != null && (dateOnlyPart2 = DateUtilsKt.getDateOnlyPart(str)) != null) {
            String str2 = (String) CollectionsKt.getOrNull(this.values, 1);
            String dateOnlyPart3 = str2 != null ? DateUtilsKt.getDateOnlyPart(str2) : null;
            int i = WhenMappings.$EnumSwitchMapping$0[this.operator.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return dateOnlyPart.compareTo(dateOnlyPart2) > 0;
                }
                if (i == 3) {
                    return Intrinsics.areEqual(dateOnlyPart, dateOnlyPart2);
                }
                if (i == 4) {
                    if (dateOnlyPart3 != null) {
                        String str3 = dateOnlyPart;
                        if (str3.compareTo(dateOnlyPart2) >= 0 && str3.compareTo(dateOnlyPart3) <= 0) {
                            return true;
                        }
                    }
                    return false;
                }
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (dateOnlyPart3 != null) {
                    String str4 = dateOnlyPart;
                    if (str4.compareTo(dateOnlyPart2) < 0 || str4.compareTo(dateOnlyPart3) > 0) {
                        return true;
                    }
                }
                return false;
            }
            if (dateOnlyPart.compareTo(dateOnlyPart2) < 0) {
                return true;
            }
        }
        return false;
    }
}
