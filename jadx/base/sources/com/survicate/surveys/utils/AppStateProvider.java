package com.survicate.surveys.utils;

import com.survicate.surveys.helpers.Observable;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppStateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/utils/AppStateProvider;", "", "currentState", "Lcom/survicate/surveys/utils/AppState;", "getCurrentState", "()Lcom/survicate/surveys/utils/AppState;", "observeAppStateChanges", "Lcom/survicate/surveys/helpers/Observable;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface AppStateProvider {
    AppState getCurrentState();

    Observable<AppState> observeAppStateChanges();
}
