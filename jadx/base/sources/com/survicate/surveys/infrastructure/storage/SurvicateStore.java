package com.survicate.surveys.infrastructure.storage;

import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.traits.UserTrait;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurvicateStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\tH&J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H&J\u001c\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u001c\u0010\u001d\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0016\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0005H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0005H&J\u0016\u0010#\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0005H&J\u0017\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&¨\u0006."}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SurvicateStore;", "", "migrateSchemaIfNeeded", "", "migrations", "", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "saveCurrentSdkVersion", "versionName", "", "loadSavedSdkVersion", "saveUserTraits", "traits", "Lcom/survicate/surveys/traits/UserTrait;", "loadTraits", "findUserTrait", "attribute", "saveVisitorUuid", "visitorUuid", "loadVisitorUuid", "saveSeenSurveyIds", "seenSurveyIds", "", "loadSeenSurveyIds", "saveSurveysFirstPresentationTimes", "presentationTimes", "", "", "loadFirstPresentationTimes", "saveSurveysLastPresentationTimes", "loadLastPresentationTimes", "saveEventsHistory", "eventsHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "loadEventsHistory", "saveContactActions", "actions", "Lcom/survicate/surveys/entities/models/ContactAction;", "loadContactActions", "saveRespondentVerificationTimeMs", "timeMs", "(Ljava/lang/Long;)V", "loadRespondentVerificationTimeMs", "()Ljava/lang/Long;", "clearUserData", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurvicateStore {
    void clear();

    void clearUserData();

    UserTrait findUserTrait(String attribute);

    List<ContactAction> loadContactActions();

    List<ActiveEventHistory> loadEventsHistory();

    Map<String, Long> loadFirstPresentationTimes();

    Map<String, Long> loadLastPresentationTimes();

    Long loadRespondentVerificationTimeMs();

    String loadSavedSdkVersion();

    Set<String> loadSeenSurveyIds();

    List<UserTrait> loadTraits();

    String loadVisitorUuid();

    void migrateSchemaIfNeeded(List<? extends SurvicateStoreMigration> migrations);

    void saveContactActions(List<? extends ContactAction> actions);

    void saveCurrentSdkVersion(String versionName);

    void saveEventsHistory(List<ActiveEventHistory> eventsHistory);

    void saveRespondentVerificationTimeMs(Long timeMs);

    void saveSeenSurveyIds(Set<String> seenSurveyIds);

    void saveSurveysFirstPresentationTimes(Map<String, Long> presentationTimes);

    void saveSurveysLastPresentationTimes(Map<String, Long> presentationTimes);

    void saveUserTraits(List<? extends UserTrait> traits);

    void saveVisitorUuid(String visitorUuid);
}
