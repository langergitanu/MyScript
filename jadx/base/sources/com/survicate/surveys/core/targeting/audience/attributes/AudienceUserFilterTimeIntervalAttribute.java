package com.survicate.surveys.core.targeting.audience.attributes;

import com.survicate.surveys.core.converters.DateTimeConverter;
import com.survicate.surveys.core.providers.TimestampProvider;
import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudienceUserFilterTimeIntervalAttribute.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterTimeIntervalAttribute;", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterTimeIntervalAttributeOperator;", "values", "", "", "timestampProvider", "Lcom/survicate/surveys/core/providers/TimestampProvider;", "dateTimeConverter", "Lcom/survicate/surveys/core/converters/DateTimeConverter;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterTimeIntervalAttributeOperator;Ljava/util/List;Lcom/survicate/surveys/core/providers/TimestampProvider;Lcom/survicate/surveys/core/converters/DateTimeConverter;)V", "isSatisfiedBy", "", "userTraits", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceUserFilterTimeIntervalAttribute implements AudienceUserFilterAttribute {
    private final DateTimeConverter dateTimeConverter;
    private final String name;
    private final AudienceUserFilterTimeIntervalAttributeOperator operator;
    private final TimestampProvider timestampProvider;
    private final List<Long> values;

    /* JADX INFO: compiled from: AudienceUserFilterTimeIntervalAttribute.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudienceUserFilterTimeIntervalAttributeOperator.values().length];
            try {
                iArr[AudienceUserFilterTimeIntervalAttributeOperator.IS_GREATER_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudienceUserFilterTimeIntervalAttributeOperator.IS_LESS_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudienceUserFilterTimeIntervalAttribute(String name, AudienceUserFilterTimeIntervalAttributeOperator operator, List<Long> values, TimestampProvider timestampProvider, DateTimeConverter dateTimeConverter) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(dateTimeConverter, "dateTimeConverter");
        this.name = name;
        this.operator = operator;
        this.values = values;
        this.timestampProvider = timestampProvider;
        this.dateTimeConverter = dateTimeConverter;
    }

    @Override // com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterAttribute
    public boolean isSatisfiedBy(List<CoreUserTrait> userTraits) {
        Object next;
        Long lFromIsoStringToMillis;
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
        if (coreUserTrait != null && (lFromIsoStringToMillis = this.dateTimeConverter.fromIsoStringToMillis(coreUserTrait.getValue())) != null) {
            long jLongValue = lFromIsoStringToMillis.longValue();
            Long l = (Long) CollectionsKt.firstOrNull((List) this.values);
            if (l != null) {
                long jLongValue2 = l.longValue();
                int i = WhenMappings.$EnumSwitchMapping$0[this.operator.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        return this.timestampProvider.currentTimeMillis() < jLongValue + jLongValue2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.timestampProvider.currentTimeMillis() > jLongValue + jLongValue2) {
                    return true;
                }
            }
        }
        return false;
    }
}
