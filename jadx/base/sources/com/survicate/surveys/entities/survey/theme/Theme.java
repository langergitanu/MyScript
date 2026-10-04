package com.survicate.surveys.entities.survey.theme;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/Theme;", "", "id", "", "type", "Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "settings", "Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "<init>", "(ILcom/survicate/surveys/entities/survey/theme/ThemeType;Lcom/survicate/surveys/entities/survey/theme/ColorScheme;Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;)V", "getId", "()I", "getType", "()Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "getColorScheme", "()Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "getSettings", "()Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class Theme {
    private final ColorScheme colorScheme;
    private final int id;
    private final ThemeSettings settings;
    private final ThemeType type;

    public static /* synthetic */ Theme copy$default(Theme theme, int i, ThemeType themeType, ColorScheme colorScheme, ThemeSettings themeSettings, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = theme.id;
        }
        if ((i2 & 2) != 0) {
            themeType = theme.type;
        }
        if ((i2 & 4) != 0) {
            colorScheme = theme.colorScheme;
        }
        if ((i2 & 8) != 0) {
            themeSettings = theme.settings;
        }
        return theme.copy(i, themeType, colorScheme, themeSettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ThemeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThemeSettings getSettings() {
        return this.settings;
    }

    public final Theme copy(int id, ThemeType type, ColorScheme colorScheme, ThemeSettings settings) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new Theme(id, type, colorScheme, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Theme)) {
            return false;
        }
        Theme theme = (Theme) other;
        return this.id == theme.id && this.type == theme.type && Intrinsics.areEqual(this.colorScheme, theme.colorScheme) && Intrinsics.areEqual(this.settings, theme.settings);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.colorScheme.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "Theme(id=" + this.id + ", type=" + this.type + ", colorScheme=" + this.colorScheme + ", settings=" + this.settings + ')';
    }

    public Theme(int i, ThemeType type, ColorScheme colorScheme, ThemeSettings settings) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.id = i;
        this.type = type;
        this.colorScheme = colorScheme;
        this.settings = settings;
    }

    public final int getId() {
        return this.id;
    }

    public final ThemeType getType() {
        return this.type;
    }

    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public final ThemeSettings getSettings() {
        return this.settings;
    }
}
