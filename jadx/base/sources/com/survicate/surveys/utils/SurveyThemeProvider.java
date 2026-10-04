package com.survicate.surveys.utils;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeConfiguration;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThemeModeStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurveyThemeProvider;", "", "getCurrentTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", "themeConfig", "Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyThemeProvider {
    Theme getCurrentTheme(ThemeConfiguration themeConfig, Context context);
}
