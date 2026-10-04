package com.survicate.surveys.core.targeting.audience.attributes;

import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudienceUserFilterBooleanAttribute.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterBooleanAttribute;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterBooleanAttributeOperator;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterBooleanAttributeOperator;)V", "isSatisfiedBy", "", "userTraits", "", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterBooleanAttribute implements AudienceUserFilterAttribute {
    private final String name;
    private final AudienceUserFilterBooleanAttributeOperator operator;

    /* JADX INFO: compiled from: AudienceUserFilterBooleanAttribute.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceUserFilterBooleanAttributeOperator.values().length];
            try {
                iArr[AudienceUserFilterBooleanAttributeOperator.IS_TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceUserFilterBooleanAttributeOperator.IS_FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudienceUserFilterBooleanAttribute(String name, AudienceUserFilterBooleanAttributeOperator operator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.name = name;
        this.operator = operator;
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
            return false;
        }
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(coreUserTrait.getValue());
        int i = WhenMappings.$EnumSwitchMapping$0[this.operator.ordinal()];
        if (i == 1) {
            return Intrinsics.areEqual((Object) booleanStrictOrNull, (Object) true);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.areEqual((Object) booleanStrictOrNull, (Object) false);
    }
}
