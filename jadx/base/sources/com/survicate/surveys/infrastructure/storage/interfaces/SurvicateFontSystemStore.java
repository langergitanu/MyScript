package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.SurvicateFontSystem;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurvicateFontSystemStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemProvider;", "saveFontSystem", "", "fontSystem", "Lcom/survicate/surveys/SurvicateFontSystem;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurvicateFontSystemStore extends SurvicateFontSystemProvider {
    void saveFontSystem(SurvicateFontSystem fontSystem);
}
