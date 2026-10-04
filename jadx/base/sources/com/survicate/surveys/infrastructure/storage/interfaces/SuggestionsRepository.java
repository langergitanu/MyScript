package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.targeting.ActiveEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: SuggestionsRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/SuggestionsRepository;", "", "updateSuggestionsFrom", "", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "addEventSuggestionFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SuggestionsRepository {
    void addEventSuggestionFor(ActiveEvent activeEvent);

    void clear();

    void updateSuggestionsFrom(Workspace workspace);
}
