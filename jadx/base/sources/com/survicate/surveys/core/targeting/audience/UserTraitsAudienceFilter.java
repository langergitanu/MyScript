package com.survicate.surveys.core.targeting.audience;

import com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterAttribute;
import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserTraitsAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/UserTraitsAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "attributes", "", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "relation", "Lcom/survicate/surveys/core/targeting/audience/AudienceRelation;", "exclude", "", "userTraitsProvider", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "<init>", "(Ljava/util/List;Lcom/survicate/surveys/core/targeting/audience/AudienceRelation;ZLcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;)V", "isSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserTraitsAudienceFilter implements AudienceFilter {
    private final List<AudienceUserFilterAttribute> attributes;
    private final boolean exclude;
    private final AudienceRelation relation;
    private final CoreUserTraitsProvider userTraitsProvider;

    /* JADX INFO: compiled from: UserTraitsAudienceFilter.kt */
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
                iArr[AudienceRelation.f2264OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserTraitsAudienceFilter(List<? extends AudienceUserFilterAttribute> attributes, AudienceRelation relation, boolean z, CoreUserTraitsProvider userTraitsProvider) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        this.attributes = attributes;
        this.relation = relation;
        this.exclude = z;
        this.userTraitsProvider = userTraitsProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isSatisfied() {
        List<CoreUserTrait> listProvideCoreUserTraits = this.userTraitsProvider.provideCoreUserTraits();
        List<AudienceUserFilterAttribute> list = this.attributes;
        if (list.isEmpty()) {
            return true;
        }
        List<AudienceUserFilterAttribute> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((AudienceUserFilterAttribute) it.next()).isSatisfiedBy(listProvideCoreUserTraits)));
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it2.next();
        while (true) {
            boolean z = false;
            if (!it2.hasNext()) {
                boolean zBooleanValue = ((Boolean) next).booleanValue();
                return this.exclude ? !zBooleanValue : zBooleanValue;
            }
            boolean zBooleanValue2 = ((Boolean) it2.next()).booleanValue();
            boolean zBooleanValue3 = ((Boolean) next).booleanValue();
            int i = WhenMappings.$EnumSwitchMapping$0[this.relation.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (zBooleanValue3 || zBooleanValue2) {
                    z = true;
                }
            } else if (!zBooleanValue3 || !zBooleanValue2) {
            }
            next = Boolean.valueOf(z);
        }
    }
}
