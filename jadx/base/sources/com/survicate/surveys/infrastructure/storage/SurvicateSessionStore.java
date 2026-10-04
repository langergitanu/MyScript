package com.survicate.surveys.infrastructure.storage;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.ResponseAttribute;
import com.survicate.surveys.SurvicateFontSystem;
import com.survicate.surveys.core.models.ActiveScreen;
import com.survicate.surveys.core.targeting.SurveyChanceResult;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.targeting.ActiveEvent;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurvicateSessionStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0016\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010'\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010)\u001a\u00020\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140+H\u0016J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SurvicateSessionStore;", "Lcom/survicate/surveys/infrastructure/storage/SessionStore;", "<init>", "()V", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "surveyChanceResults", "", "", "Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "wasAnySurveyPresented", "", "activeScreens", "", "Lcom/survicate/surveys/core/models/ActiveScreen;", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "postponedEvent", "responseAttributes", "", "Lcom/survicate/surveys/ResponseAttribute;", "fontSystem", "Lcom/survicate/surveys/SurvicateFontSystem;", "saveWorkspace", "", "getWorkspace", "saveChanceResult", "surveyId", "result", "findChanceResult", "saveAnySurveyPresentedInSession", "value", "wasAnySurveyPresentedInSession", "saveActiveScreens", "screens", "provideActiveScreens", "saveActiveEvent", NotificationCompat.CATEGORY_EVENT, "provideActiveEvent", "savePostponedEvent", "providePostponedEvent", "saveResponseAttributes", "attributes", "", "provideResponseAttributes", "saveFontSystem", "provideFontSystem", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateSessionStore implements SessionStore {
    private ActiveEvent activeEvent;
    private ActiveEvent postponedEvent;
    private boolean wasAnySurveyPresented;
    private Workspace workspace;
    private Map<String, SurveyChanceResult> surveyChanceResults = new LinkedHashMap();
    private Set<ActiveScreen> activeScreens = SetsKt.emptySet();
    private Map<String, ResponseAttribute> responseAttributes = MapsKt.emptyMap();
    private SurvicateFontSystem fontSystem = SurvicateFontSystem.INSTANCE.getDefault();

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.WorkspaceStore
    public void saveWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.WorkspaceStore
    public Workspace getWorkspace() {
        return this.workspace;
    }

    @Override // com.survicate.surveys.core.providers.SurveyChanceStore
    public void saveChanceResult(String surveyId, SurveyChanceResult result) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(result, "result");
        this.surveyChanceResults.put(surveyId, result);
    }

    @Override // com.survicate.surveys.core.providers.SurveyChanceStore
    public SurveyChanceResult findChanceResult(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return this.surveyChanceResults.get(surveyId);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.PresentationStateStore
    public void saveAnySurveyPresentedInSession(boolean value) {
        this.wasAnySurveyPresented = value;
    }

    @Override // com.survicate.surveys.core.providers.PresentationStateProvider
    /* JADX INFO: renamed from: wasAnySurveyPresentedInSession, reason: from getter */
    public boolean getWasAnySurveyPresented() {
        return this.wasAnySurveyPresented;
    }

    @Override // com.survicate.surveys.core.providers.ActiveScreenStore
    public void saveActiveScreens(Set<ActiveScreen> screens) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        this.activeScreens = screens;
    }

    @Override // com.survicate.surveys.core.providers.ActiveScreenProvider
    public Set<ActiveScreen> provideActiveScreens() {
        return this.activeScreens;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventStore
    public void saveActiveEvent(ActiveEvent event) {
        this.activeEvent = event;
    }

    @Override // com.survicate.surveys.targeting.provider.ActiveEventProvider
    /* JADX INFO: renamed from: provideActiveEvent, reason: from getter */
    public ActiveEvent getActiveEvent() {
        return this.activeEvent;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventStore
    public void savePostponedEvent(ActiveEvent event) {
        this.postponedEvent = event;
    }

    @Override // com.survicate.surveys.targeting.provider.ActiveEventProvider
    /* JADX INFO: renamed from: providePostponedEvent, reason: from getter */
    public ActiveEvent getPostponedEvent() {
        return this.postponedEvent;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ResponseAttributeStore
    public void saveResponseAttributes(List<ResponseAttribute> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Map<String, ResponseAttribute> map = this.responseAttributes;
        List<ResponseAttribute> list = attributes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ResponseAttribute responseAttribute : list) {
            String strTake = StringsKt.take(responseAttribute.getName(), 255);
            String strTake2 = StringsKt.take(responseAttribute.getValue(), 255);
            String provider = responseAttribute.getProvider();
            arrayList.add(responseAttribute.copy(strTake, strTake2, provider != null ? StringsKt.take(provider, 255) : null));
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            linkedHashMap.put(((ResponseAttribute) obj).getName(), obj);
        }
        this.responseAttributes = MapsKt.plus(map, linkedHashMap);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ResponseAttributeProvider
    public List<ResponseAttribute> provideResponseAttributes() {
        Collection<ResponseAttribute> collectionValues = this.responseAttributes.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            ResponseAttribute responseAttribute = (ResponseAttribute) obj;
            if (responseAttribute.getName().length() > 0 && responseAttribute.getValue().length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemStore
    public void saveFontSystem(SurvicateFontSystem fontSystem) {
        Intrinsics.checkNotNullParameter(fontSystem, "fontSystem");
        this.fontSystem = fontSystem;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemProvider
    /* JADX INFO: renamed from: provideFontSystem, reason: from getter */
    public SurvicateFontSystem getFontSystem() {
        return this.fontSystem;
    }

    @Override // com.survicate.surveys.infrastructure.storage.SessionStore
    public void clear() {
        this.workspace = null;
        this.surveyChanceResults.clear();
        this.wasAnySurveyPresented = false;
        this.activeScreens = SetsKt.emptySet();
        this.activeEvent = null;
        this.postponedEvent = null;
        this.responseAttributes = MapsKt.emptyMap();
        this.fontSystem = SurvicateFontSystem.INSTANCE.getDefault();
    }
}
