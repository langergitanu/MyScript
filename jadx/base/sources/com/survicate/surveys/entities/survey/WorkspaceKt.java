package com.survicate.surveys.entities.survey;

import com.survicate.surveys.core.targeting.displayfilter.ScreenDisplayFilter;
import com.survicate.surveys.targeting.EventDelayTargetingKt;
import com.survicate.surveys.targeting.EventDelayTrigger;
import com.survicate.surveys.targeting.ScreenDelayTargetingKt;
import com.survicate.surveys.targeting.ScreenDelayTrigger;
import com.survicate.surveys.targeting.displayfilter.EventDisplayFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Workspace.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0003¨\u0006\u0007"}, m1599d2 = {"getScreenDelayTriggers", "", "Lcom/survicate/surveys/targeting/ScreenDelayTrigger;", "Lcom/survicate/surveys/entities/survey/Workspace;", "getEventDelayTriggers", "", "Lcom/survicate/surveys/targeting/EventDelayTrigger;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class WorkspaceKt {
    public static final Set<ScreenDelayTrigger> getScreenDelayTriggers(Workspace workspace) {
        Intrinsics.checkNotNullParameter(workspace, "<this>");
        List<Survey> surveys = workspace.getSurveys();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = surveys.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Survey) it.next()).getDisplayFilters());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof ScreenDisplayFilter) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList3, ScreenDelayTargetingKt.createScreenDelayTriggers((ScreenDisplayFilter) it2.next()));
        }
        return CollectionsKt.toSet(arrayList3);
    }

    public static final List<EventDelayTrigger> getEventDelayTriggers(Workspace workspace) {
        Intrinsics.checkNotNullParameter(workspace, "<this>");
        List<Survey> surveys = workspace.getSurveys();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = surveys.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Survey) it.next()).getDisplayFilters());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof EventDisplayFilter) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList3, EventDelayTargetingKt.createEventDelayTriggers((EventDisplayFilter) it2.next()));
        }
        return arrayList3;
    }
}
