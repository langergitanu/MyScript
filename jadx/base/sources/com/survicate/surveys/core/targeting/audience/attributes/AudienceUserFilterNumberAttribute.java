package com.survicate.surveys.core.targeting.audience.attributes;

import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudienceUserFilterNumberAttribute.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterNumberAttribute;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterNumberAttributeOperator;", "values", "", "", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterNumberAttributeOperator;Ljava/util/List;)V", "isSatisfiedBy", "", "userTraits", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterNumberAttribute implements AudienceUserFilterAttribute {
    private final String name;
    private final AudienceUserFilterNumberAttributeOperator operator;
    private final List<Double> values;

    /* JADX INFO: compiled from: AudienceUserFilterNumberAttribute.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceUserFilterNumberAttributeOperator.values().length];
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_LESS_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_BETWEEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AudienceUserFilterNumberAttributeOperator.IS_NOT_BETWEEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudienceUserFilterNumberAttribute(String name, AudienceUserFilterNumberAttributeOperator operator, List<Double> values) {
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
        Double doubleOrNull;
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
        if (coreUserTrait != null && (doubleOrNull = StringsKt.toDoubleOrNull(coreUserTrait.getValue())) != null) {
            double dDoubleValue = doubleOrNull.doubleValue();
            Double d = (Double) CollectionsKt.getOrNull(this.values, 0);
            if (d != null) {
                double dDoubleValue2 = d.doubleValue();
                Double d2 = (Double) CollectionsKt.getOrNull(this.values, 1);
                switch (WhenMappings.$EnumSwitchMapping$0[this.operator.ordinal()]) {
                    case 1:
                        List<Double> list = this.values;
                        if ((list instanceof Collection) && list.isEmpty()) {
                            return false;
                        }
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (dDoubleValue == ((Number) it2.next()).doubleValue()) {
                                return true;
                            }
                        }
                        break;
                    case 2:
                        List<Double> list2 = this.values;
                        if ((list2 instanceof Collection) && list2.isEmpty()) {
                            return true;
                        }
                        Iterator<T> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            if (dDoubleValue == ((Number) it3.next()).doubleValue()) {
                                return false;
                            }
                        }
                        return true;
                    case 3:
                        return dDoubleValue > dDoubleValue2;
                    case 4:
                        return dDoubleValue >= dDoubleValue2;
                    case 5:
                        return dDoubleValue < dDoubleValue2;
                    case 6:
                        return dDoubleValue <= dDoubleValue2;
                    case 7:
                        return d2 != null && dDoubleValue2 <= dDoubleValue && dDoubleValue <= d2.doubleValue();
                    case 8:
                        return d2 != null && (dDoubleValue2 > dDoubleValue || dDoubleValue > d2.doubleValue());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
        return false;
    }
}
