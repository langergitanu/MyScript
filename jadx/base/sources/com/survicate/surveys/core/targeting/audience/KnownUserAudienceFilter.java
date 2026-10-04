package com.survicate.surveys.core.targeting.audience;

import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.core.traits.CoreUserTrait;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KnownUserAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/KnownUserAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "values", "", "", "exclude", "userTraitsProvider", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "<init>", "(Ljava/util/List;ZLcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;)V", "isSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KnownUserAudienceFilter implements AudienceFilter {
    private final boolean exclude;
    private final CoreUserTraitsProvider userTraitsProvider;
    private final List<Boolean> values;

    public KnownUserAudienceFilter(List<Boolean> values, boolean z, CoreUserTraitsProvider userTraitsProvider) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        this.values = values;
        this.exclude = z;
        this.userTraitsProvider = userTraitsProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        boolean z;
        List<CoreUserTrait> listProvideCoreUserTraits = this.userTraitsProvider.provideCoreUserTraits();
        if ((listProvideCoreUserTraits instanceof Collection) && listProvideCoreUserTraits.isEmpty()) {
            z = false;
        } else {
            for (CoreUserTrait coreUserTrait : listProvideCoreUserTraits) {
                if (Intrinsics.areEqual(coreUserTrait.getKey(), "user_id") && !coreUserTrait.hasClearedValue()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        boolean z2 = z == this.values.get(0).booleanValue();
        return this.exclude ? !z2 : z2;
    }
}
