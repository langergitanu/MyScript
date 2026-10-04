package com.survicate.surveys.core.targeting.backend;

import com.survicate.surveys.core.providers.TimestampProvider;
import com.survicate.surveys.core.targeting.TargetingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BackendTargetingResultStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0016J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bH\u0016J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0016J\u0016\u0010\"\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/SurvicateBackendTargetingResultStore;", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "timestampProvider", "Lcom/survicate/surveys/core/providers/TimestampProvider;", "<init>", "(Lcom/survicate/surveys/core/providers/TimestampProvider;)V", "targetingMode", "Lcom/survicate/surveys/core/targeting/TargetingMode;", "getTargetingMode", "()Lcom/survicate/surveys/core/targeting/TargetingMode;", "setTargetingMode", "(Lcom/survicate/surveys/core/targeting/TargetingMode;)V", "surveyResults", "", "", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingSurveyResult;", "audienceResults", "", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingAudienceResult;", "displayedSurveys", "", "isFrequencySatisfied", "", "surveyId", "isAudienceSatisfied", "audienceId", "getSurveysToRefresh", "", "surveyIds", "getAudiencesToRefresh", "audienceIds", "updateSurveyResults", "", "results", "updateAudienceResults", "markSurveyAsDisplayed", "clear", "currentTimeMillis", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateBackendTargetingResultStore implements BackendTargetingResultStore {
    public static final long REFRESH_THRESHOLD_MS = 30000;
    private Map<Long, CoreBackendTargetingAudienceResult> audienceResults;
    private Set<String> displayedSurveys;
    private Map<String, CoreBackendTargetingSurveyResult> surveyResults;
    private TargetingMode targetingMode;
    private final TimestampProvider timestampProvider;

    public SurvicateBackendTargetingResultStore(TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        this.timestampProvider = timestampProvider;
        this.targetingMode = TargetingMode.LOCAL;
        this.surveyResults = MapsKt.emptyMap();
        this.audienceResults = MapsKt.emptyMap();
        this.displayedSurveys = SetsKt.emptySet();
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public TargetingMode getTargetingMode() {
        return this.targetingMode;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public void setTargetingMode(TargetingMode targetingMode) {
        Intrinsics.checkNotNullParameter(targetingMode, "<set-?>");
        this.targetingMode = targetingMode;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider
    public boolean isFrequencySatisfied(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        if (getTargetingMode() == TargetingMode.LOCAL) {
            return true;
        }
        CoreBackendTargetingSurveyResult coreBackendTargetingSurveyResult = this.surveyResults.get(surveyId);
        return (coreBackendTargetingSurveyResult == null || !coreBackendTargetingSurveyResult.isSuccess() || coreBackendTargetingSurveyResult.isExpired(currentTimeMillis()) || this.displayedSurveys.contains(surveyId)) ? false : true;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider
    public boolean isAudienceSatisfied(long audienceId) {
        if (getTargetingMode() == TargetingMode.LOCAL) {
            return true;
        }
        CoreBackendTargetingAudienceResult coreBackendTargetingAudienceResult = this.audienceResults.get(Long.valueOf(audienceId));
        return (coreBackendTargetingAudienceResult == null || !coreBackendTargetingAudienceResult.isSuccess() || coreBackendTargetingAudienceResult.isExpired(currentTimeMillis())) ? false : true;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public List<String> getSurveysToRefresh(List<String> surveyIds) {
        Intrinsics.checkNotNullParameter(surveyIds, "surveyIds");
        ArrayList arrayList = new ArrayList();
        for (Object obj : surveyIds) {
            CoreBackendTargetingSurveyResult coreBackendTargetingSurveyResult = this.surveyResults.get((String) obj);
            if (coreBackendTargetingSurveyResult == null || coreBackendTargetingSurveyResult.shouldRefresh(currentTimeMillis(), 30000L)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public List<Long> getAudiencesToRefresh(List<Long> audienceIds) {
        Intrinsics.checkNotNullParameter(audienceIds, "audienceIds");
        ArrayList arrayList = new ArrayList();
        for (Object obj : audienceIds) {
            CoreBackendTargetingAudienceResult coreBackendTargetingAudienceResult = this.audienceResults.get(Long.valueOf(((Number) obj).longValue()));
            if (coreBackendTargetingAudienceResult == null || coreBackendTargetingAudienceResult.shouldRefresh(currentTimeMillis(), 30000L)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public void updateSurveyResults(List<CoreBackendTargetingSurveyResult> results) {
        Intrinsics.checkNotNullParameter(results, "results");
        Map<String, CoreBackendTargetingSurveyResult> map = this.surveyResults;
        List<CoreBackendTargetingSurveyResult> list = results;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((CoreBackendTargetingSurveyResult) obj).getId(), obj);
        }
        this.surveyResults = MapsKt.plus(map, linkedHashMap);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CoreBackendTargetingSurveyResult) it.next()).getId());
        }
        this.displayedSurveys = SetsKt.minus((Set) this.displayedSurveys, (Iterable) CollectionsKt.toSet(arrayList));
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public void updateAudienceResults(List<CoreBackendTargetingAudienceResult> results) {
        Intrinsics.checkNotNullParameter(results, "results");
        Map<Long, CoreBackendTargetingAudienceResult> map = this.audienceResults;
        List<CoreBackendTargetingAudienceResult> list = results;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((CoreBackendTargetingAudienceResult) obj).getId()), obj);
        }
        this.audienceResults = MapsKt.plus(map, linkedHashMap);
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public void markSurveyAsDisplayed(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        this.displayedSurveys = SetsKt.plus(this.displayedSurveys, surveyId);
    }

    @Override // com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore
    public void clear() {
        this.surveyResults = MapsKt.emptyMap();
        this.audienceResults = MapsKt.emptyMap();
        this.displayedSurveys = SetsKt.emptySet();
    }

    private final long currentTimeMillis() {
        return this.timestampProvider.currentTimeMillis();
    }
}
