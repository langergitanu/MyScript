package com.survicate.surveys.entities.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveEventHistory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m1599d2 = {"updatedWithNewOccurrence", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "invokeTimeMs", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ActiveEventHistoryKt {
    public static final ActiveEventHistory updatedWithNewOccurrence(ActiveEventHistory activeEventHistory, long j) {
        Intrinsics.checkNotNullParameter(activeEventHistory, "<this>");
        return ActiveEventHistory.copy$default(activeEventHistory, null, activeEventHistory.getOccurrenceCount() + 1, 0L, j, 5, null);
    }
}
