package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0005*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m1599d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "StrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getStrokeWidth-D9Ej5fM", "()F", "F", "material3"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();
    private static final float StrokeWidth = C1486Dp.m11017constructorimpl(2);

    private CheckboxDefaults() {
    }

    public final CheckboxColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -9530498, "C(colors)315@14310L11:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-9530498, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:315)");
        }
        CheckboxColors defaultCheckboxColors$material3 = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCheckboxColors$material3;
    }

    /* JADX INFO: renamed from: colors-5tl4gsc, reason: not valid java name */
    public final CheckboxColors m4721colors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -89536160, "C(colors)N(checkedColor:c#ui.graphics.Color,uncheckedColor:c#ui.graphics.Color,checkmarkColor:c#ui.graphics.Color,disabledCheckedColor:c#ui.graphics.Color,disabledUncheckedColor:c#ui.graphics.Color,disabledIndeterminateColor:c#ui.graphics.Color)341@15700L11:Checkbox.kt#uh7d8r");
        long jM8184getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j;
        long jM8184getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j2;
        long jM8184getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j3;
        long jM8184getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j4;
        long jM8184getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j5;
        long jM8184getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:341)");
        }
        CheckboxColors checkboxColorsM4708copy2qZNXz8 = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4708copy2qZNXz8(jM8184getUnspecified0d7_KjU3, Color.INSTANCE.m8183getTransparent0d7_KjU(), jM8184getUnspecified0d7_KjU, Color.INSTANCE.m8183getTransparent0d7_KjU(), jM8184getUnspecified0d7_KjU4, Color.INSTANCE.m8183getTransparent0d7_KjU(), jM8184getUnspecified0d7_KjU6, jM8184getUnspecified0d7_KjU, jM8184getUnspecified0d7_KjU2, jM8184getUnspecified0d7_KjU4, jM8184getUnspecified0d7_KjU5, jM8184getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return checkboxColorsM4708copy2qZNXz8;
    }

    public final CheckboxColors getDefaultCheckboxColors$material3(ColorScheme colorScheme) {
        CheckboxColors defaultCheckboxColorsCached = colorScheme.getDefaultCheckboxColorsCached();
        if (defaultCheckboxColorsCached != null) {
            return defaultCheckboxColorsCached;
        }
        CheckboxColors checkboxColors = new CheckboxColors(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedIconColor()), Color.INSTANCE.m8183getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), Color.INSTANCE.m8183getTransparent0d7_KjU(), Color.m8147copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m8183getTransparent0d7_KjU(), Color.m8147copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedOutlineColor()), Color.m8147copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m8147copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m8147copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultCheckboxColorsCached$material3(checkboxColors);
        return checkboxColors;
    }

    /* JADX INFO: renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m4722getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }
}
