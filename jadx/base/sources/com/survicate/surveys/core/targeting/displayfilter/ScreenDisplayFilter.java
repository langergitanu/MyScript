package com.survicate.surveys.core.targeting.displayfilter;

import com.survicate.surveys.core.models.ActiveScreen;
import com.survicate.surveys.core.providers.ActiveScreenProvider;
import com.survicate.surveys.core.providers.TimestampProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/ScreenDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "screens", "", "", "delayInSeconds", "", "activeScreenProvider", "Lcom/survicate/surveys/core/providers/ActiveScreenProvider;", "timestampProvider", "Lcom/survicate/surveys/core/providers/TimestampProvider;", "<init>", "(Ljava/util/List;JLcom/survicate/surveys/core/providers/ActiveScreenProvider;Lcom/survicate/surveys/core/providers/TimestampProvider;)V", "getScreens", "()Ljava/util/List;", "getDelayInSeconds", "()J", "isSatisfied", "", "isScreenSatisfied", "conditionScreen", "activeScreens", "", "Lcom/survicate/surveys/core/models/ActiveScreen;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenDisplayFilter implements DisplayFilter {
    private final ActiveScreenProvider activeScreenProvider;
    private final long delayInSeconds;
    private final List<String> screens;
    private final TimestampProvider timestampProvider;

    public ScreenDisplayFilter(List<String> screens, long j, ActiveScreenProvider activeScreenProvider, TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(activeScreenProvider, "activeScreenProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        this.screens = screens;
        this.delayInSeconds = j;
        this.activeScreenProvider = activeScreenProvider;
        this.timestampProvider = timestampProvider;
    }

    public final List<String> getScreens() {
        return this.screens;
    }

    public final long getDelayInSeconds() {
        return this.delayInSeconds;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        if (this.screens.isEmpty()) {
            return true;
        }
        Set<ActiveScreen> setProvideActiveScreens = this.activeScreenProvider.provideActiveScreens();
        List<String> list = this.screens;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(isScreenSatisfied((String) it.next(), setProvideActiveScreens)));
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            if (((Boolean) it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isScreenSatisfied(String conditionScreen, Set<ActiveScreen> activeScreens) {
        Object next;
        Iterator<T> it = activeScreens.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ActiveScreen) next).getScreenName(), conditionScreen)) {
                break;
            }
        }
        ActiveScreen activeScreen = (ActiveScreen) next;
        if (activeScreen == null) {
            return false;
        }
        return ((this.delayInSeconds > 0L ? 1 : (this.delayInSeconds == 0L ? 0 : -1)) == 0) || (((activeScreen.getTimeOfCreationMs() + (this.delayInSeconds * 1000)) > this.timestampProvider.currentTimeMillis() ? 1 : ((activeScreen.getTimeOfCreationMs() + (this.delayInSeconds * 1000)) == this.timestampProvider.currentTimeMillis() ? 0 : -1)) < 0);
    }
}
