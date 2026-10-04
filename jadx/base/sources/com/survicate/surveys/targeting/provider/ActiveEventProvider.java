package com.survicate.surveys.targeting.provider;

import com.survicate.surveys.targeting.ActiveEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActiveEventProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, m1599d2 = {"Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;", "", "provideActiveEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "providePostponedEvent", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ActiveEventProvider {
    ActiveEvent provideActiveEvent();

    ActiveEvent providePostponedEvent();
}
