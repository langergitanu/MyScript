package com.survicate.surveys.core.targeting.audience.attributes;

import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudienceUserFilterStringAttribute.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterStringAttribute;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterStringAttributeOperator;", "values", "", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterStringAttributeOperator;Ljava/util/List;)V", "isSatisfiedBy", "", "userTraits", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterStringAttribute implements AudienceUserFilterAttribute {
    private final String name;
    private final AudienceUserFilterStringAttributeOperator operator;
    private final List<String> values;

    /* JADX INFO: compiled from: AudienceUserFilterStringAttribute.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
        }
    }

    public AudienceUserFilterStringAttribute(String name, AudienceUserFilterStringAttributeOperator operator, List<String> values) {
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
        if (coreUserTrait == null) {
            return this.operator == AudienceUserFilterStringAttributeOperator.DOES_NOT_EXIST;
        }
        String value = coreUserTrait.getValue();
        switch (WhenMappings.$EnumSwitchMapping$0[this.operator.ordinal()]) {
            case 1:
                List<String> list = this.values;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return false;
                }
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(value, (String) it2.next())) {
                        return true;
                    }
                }
                return false;
            case 2:
                List<String> list2 = this.values;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    return true;
                }
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.areEqual(value, (String) it3.next())) {
                        return false;
                    }
                }
                return true;
            case 3:
                List<String> list3 = this.values;
                if ((list3 instanceof Collection) && list3.isEmpty()) {
                    return false;
                }
                Iterator<T> it4 = list3.iterator();
                while (it4.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) value, (CharSequence) it4.next(), false, 2, (Object) null)) {
                        return true;
                    }
                }
                return false;
            case 4:
                List<String> list4 = this.values;
                if ((list4 instanceof Collection) && list4.isEmpty()) {
                    return true;
                }
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) value, (CharSequence) it5.next(), false, 2, (Object) null)) {
                        return false;
                    }
                }
                return true;
            case 5:
                return !StringsKt.isBlank(value);
            case 6:
                return StringsKt.isBlank(value);
            case 7:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
