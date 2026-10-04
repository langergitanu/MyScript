package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkTheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, m1599d2 = {"toThemeConfiguration", "Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "getLightTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", "networkTheme", "getDarkTheme", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkThemeKt {
    public static final ThemeConfiguration toThemeConfiguration(NetworkTheme networkTheme) {
        Intrinsics.checkNotNullParameter(networkTheme, "<this>");
        Theme lightTheme = getLightTheme(networkTheme);
        Theme darkTheme = getDarkTheme(networkTheme);
        if (darkTheme == null) {
            darkTheme = lightTheme;
        }
        return new ThemeConfiguration(lightTheme, darkTheme);
    }

    private static final Theme getLightTheme(NetworkTheme networkTheme) {
        return new Theme(networkTheme.getId(), NetworkThemeTypeKt.toDomainModel(networkTheme.getType()), NetworkColorSchemeKt.toDomainModel(networkTheme.getColorScheme()), NetworkThemeSettingsKt.toDomainModel(networkTheme.getSettings()));
    }

    private static final Theme getDarkTheme(NetworkTheme networkTheme) {
        if (!networkTheme.getHasDarkMode() || networkTheme.getColorSchemeDark() == null || networkTheme.getSettingsDark() == null) {
            return null;
        }
        return new Theme(networkTheme.getId(), NetworkThemeTypeKt.toDomainModel(networkTheme.getType()), NetworkColorSchemeKt.toDomainModel(networkTheme.getColorSchemeDark()), NetworkThemeSettingsKt.toDomainModel(networkTheme.getSettingsDark()));
    }
}
