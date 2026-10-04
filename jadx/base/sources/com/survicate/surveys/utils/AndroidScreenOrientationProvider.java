package com.survicate.surveys.utils;

import com.survicate.surveys.core.models.ScreenOrientation;
import com.survicate.surveys.core.providers.ScreenOrientationProvider;
import com.survicate.surveys.helpers.Observable;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScreenOrientationProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, m1599d2 = {"Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "Lcom/survicate/surveys/core/providers/ScreenOrientationProvider;", "observeOrientationChanges", "Lcom/survicate/surveys/helpers/Observable;", "Lcom/survicate/surveys/core/models/ScreenOrientation;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface AndroidScreenOrientationProvider extends ScreenOrientationProvider {
    Observable<ScreenOrientation> observeOrientationChanges();
}
