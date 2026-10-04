package com.survicate.surveys.utils;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.ThemeMode;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemeModeStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/utils/SurvicateThemeModeStore;", "Lcom/survicate/surveys/utils/ThemeModeStore;", "<init>", "()V", "themeMode", "Lcom/survicate/surveys/ThemeMode;", "saveThemeMode", "", "mode", "getCurrentTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", "themeConfig", "Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "resolveAutoTheme", "reset", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateThemeModeStore implements ThemeModeStore {
    private volatile ThemeMode themeMode = ThemeMode.AUTO;

    /* JADX INFO: compiled from: ThemeModeStore.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeMode.values().length];
            try {
                iArr[ThemeMode.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThemeMode.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThemeMode.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.survicate.surveys.utils.ThemeModeStore
    public void saveThemeMode(ThemeMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.themeMode = mode;
    }

    @Override // com.survicate.surveys.utils.SurveyThemeProvider
    public Theme getCurrentTheme(ThemeConfiguration themeConfig, Context context) {
        Intrinsics.checkNotNullParameter(themeConfig, "themeConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = WhenMappings.$EnumSwitchMapping$0[this.themeMode.ordinal()];
        if (i == 1) {
            return themeConfig.getLight();
        }
        if (i == 2) {
            return themeConfig.getDark();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return resolveAutoTheme(themeConfig, context);
    }

    private final Theme resolveAutoTheme(ThemeConfiguration themeConfig, Context context) {
        if (ScreenUtils.INSTANCE.isDarkMode(context)) {
            return themeConfig.getDark();
        }
        return themeConfig.getLight();
    }

    @Override // com.survicate.surveys.utils.ThemeModeStore
    public void reset() {
        this.themeMode = ThemeMode.AUTO;
    }
}
