package com.survicate.surveys.targeting;

import com.survicate.surveys.core.targeting.displayfilter.ScreenDisplayFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"MILLIS_IN_SECOND", "", "SCREEN_ORIENTATION_CHALLENGE_DELAY_MS", "createScreenDelayTriggers", "", "Lcom/survicate/surveys/targeting/ScreenDelayTrigger;", "Lcom/survicate/surveys/core/targeting/displayfilter/ScreenDisplayFilter;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenDelayTargetingKt {
    private static final long MILLIS_IN_SECOND = 1000;
    private static final long SCREEN_ORIENTATION_CHALLENGE_DELAY_MS = 3000;

    public static final List<ScreenDelayTrigger> createScreenDelayTriggers(ScreenDisplayFilter screenDisplayFilter) {
        Intrinsics.checkNotNullParameter(screenDisplayFilter, "<this>");
        List<String> screens = screenDisplayFilter.getScreens();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(screens, 10));
        Iterator<T> it = screens.iterator();
        while (it.hasNext()) {
            arrayList.add(new ScreenDelayTrigger((String) it.next(), (int) screenDisplayFilter.getDelayInSeconds()));
        }
        return arrayList;
    }
}
