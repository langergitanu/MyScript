package com.survicate.surveys.core.targeting.audience;

import com.survicate.surveys.core.models.ScreenOrientation;
import com.survicate.surveys.core.providers.ScreenOrientationProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOrientationAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/ScreenOrientationAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "values", "", "", "exclude", "", "screenOrientationProvider", "Lcom/survicate/surveys/core/providers/ScreenOrientationProvider;", "<init>", "(Ljava/util/List;ZLcom/survicate/surveys/core/providers/ScreenOrientationProvider;)V", "isSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenOrientationAudienceFilter implements AudienceFilter {
    private final boolean exclude;
    private final ScreenOrientationProvider screenOrientationProvider;
    private final List<String> values;

    public ScreenOrientationAudienceFilter(List<String> values, boolean z, ScreenOrientationProvider screenOrientationProvider) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(screenOrientationProvider, "screenOrientationProvider");
        this.values = values;
        this.exclude = z;
        this.screenOrientationProvider = screenOrientationProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        ScreenOrientation currentOrientation = this.screenOrientationProvider.getCurrentOrientation();
        List<String> list = this.values;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ScreenOrientation screenOrientationFromString = ScreenOrientation.INSTANCE.fromString((String) it.next());
            if (screenOrientationFromString != null) {
                arrayList.add(screenOrientationFromString);
            }
        }
        boolean zContains = arrayList.contains(currentOrientation);
        return this.exclude ? !zContains : zContains;
    }
}
