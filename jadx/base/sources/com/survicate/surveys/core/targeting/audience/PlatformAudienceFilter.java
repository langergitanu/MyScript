package com.survicate.surveys.core.targeting.audience;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/PlatformAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "values", "", "", "exclude", "", "<init>", "(Ljava/util/List;Z)V", "isSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PlatformAudienceFilter implements AudienceFilter {
    private final boolean exclude;
    private final List<String> values;

    public PlatformAudienceFilter(List<String> values, boolean z) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
        this.exclude = z;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        boolean zContains = this.values.contains(PlatformKt.getCurrentPlatform());
        return this.exclude ? !zContains : zContains;
    }
}
