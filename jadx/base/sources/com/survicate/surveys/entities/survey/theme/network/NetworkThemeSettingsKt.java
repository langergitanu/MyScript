package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.entities.survey.theme.ThemeSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkThemeSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"toDomainModel", "Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkThemeSettingsKt {
    public static final ThemeSettings toDomainModel(NetworkThemeSettings networkThemeSettings) {
        Intrinsics.checkNotNullParameter(networkThemeSettings, "<this>");
        return new ThemeSettings(networkThemeSettings.getCompanyLogo(), networkThemeSettings.getPersonalization(), networkThemeSettings.getShortTextMessage(), networkThemeSettings.getAvatarImage());
    }
}
