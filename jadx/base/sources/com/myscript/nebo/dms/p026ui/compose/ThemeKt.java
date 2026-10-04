package com.myscript.nebo.dms.p026ui.compose;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a6\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a>\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"darkColorPalette", "Landroidx/compose/material/Colors;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "darkColorPalette-8_81llA", "(J)Landroidx/compose/material/Colors;", "lightColorPalette", "lightColorPalette-8_81llA", "NeboTheme", "", "darkTheme", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "NeboTheme-3IgeMak", "(ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NeboDialogTheme", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "NeboDialogTheme-eopBjH0", "(ZJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "dms_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ThemeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NeboDialogTheme_eopBjH0$lambda$0(boolean z, long j, long j2, Function2 function2, int i, int i2, Composer composer, int i3) {
        m13016NeboDialogThemeeopBjH0(z, j, j2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NeboTheme_3IgeMak$lambda$0(boolean z, long j, Function2 function2, int i, int i2, Composer composer, int i3) {
        m13017NeboTheme3IgeMak(z, j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: darkColorPalette-8_81llA, reason: not valid java name */
    private static final Colors m13018darkColorPalette8_81llA(long j) {
        return ColorsKt.m4223darkColors2qZNXz8$default(j, 0L, j, 0L, 0L, 0L, 0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 3962, null);
    }

    /* JADX INFO: renamed from: lightColorPalette-8_81llA, reason: not valid java name */
    private static final Colors m13019lightColorPalette8_81llA(long j) {
        return ColorsKt.m4225lightColors2qZNXz8$default(j, 0L, j, 0L, Color.INSTANCE.m8185getWhite0d7_KjU(), Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 4042, null);
    }

    /* JADX INFO: renamed from: NeboTheme-3IgeMak, reason: not valid java name */
    public static final void m13017NeboTheme3IgeMak(boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z2;
        final long j2;
        boolean zIsSystemInDarkTheme;
        long neBlue;
        boolean z3;
        Colors colorsM13019lightColorPalette8_81llA;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1921747876);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NeboTheme)N(darkTheme,tintColor:c#ui.graphics.Color,content)35@1046L79:Theme.kt#3ga04k");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "26@802L21");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    i3 &= -15;
                } else {
                    zIsSystemInDarkTheme = z;
                }
                if (i4 != 0) {
                    z3 = zIsSystemInDarkTheme;
                    neBlue = ColorsKt.getNeBlue();
                } else {
                    neBlue = j;
                    z3 = zIsSystemInDarkTheme;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                z3 = z;
                neBlue = j;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1921747876, i3, -1, "com.myscript.nebo.dms.ui.compose.NeboTheme (Theme.kt:28)");
            }
            if (z3) {
                colorsM13019lightColorPalette8_81llA = m13018darkColorPalette8_81llA(neBlue);
            } else {
                colorsM13019lightColorPalette8_81llA = m13019lightColorPalette8_81llA(neBlue);
            }
            MaterialThemeKt.MaterialTheme(colorsM13019lightColorPalette8_81llA, null, null, content, composerStartRestartGroup, (i3 << 3) & 7168, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z3;
            j2 = neBlue;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
            j2 = j;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.NeboTheme_3IgeMak$lambda$0(z2, j2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0101  */
    /* JADX INFO: renamed from: NeboDialogTheme-eopBjH0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m13016NeboDialogThemeeopBjH0(boolean z, long j, final long j2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final boolean zIsSystemInDarkTheme;
        int i3;
        long j3;
        final long j4;
        boolean z2;
        long neBlue;
        Colors colorsM13019lightColorPalette8_81llA;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-650717429);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NeboDialogTheme)N(darkTheme,tintColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,content)52@1517L79:Theme.kt#3ga04k");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                zIsSystemInDarkTheme = z;
                int i4 = composerStartRestartGroup.changed(zIsSystemInDarkTheme) ? 4 : 2;
                i3 = i4 | i;
            } else {
                zIsSystemInDarkTheme = z;
            }
            i3 = i4 | i;
        } else {
            zIsSystemInDarkTheme = z;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
            j3 = j;
        } else {
            j3 = j;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
            }
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "42@1182L21");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    i3 &= -15;
                }
                if (i5 != 0) {
                    z2 = zIsSystemInDarkTheme;
                    neBlue = ColorsKt.getNeBlue();
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-650717429, i3, -1, "com.myscript.nebo.dms.ui.compose.NeboDialogTheme (Theme.kt:45)");
                }
                if (!z2) {
                    colorsM13019lightColorPalette8_81llA = m13018darkColorPalette8_81llA(neBlue);
                } else {
                    colorsM13019lightColorPalette8_81llA = m13019lightColorPalette8_81llA(neBlue);
                }
                Colors colors = colorsM13019lightColorPalette8_81llA;
                MaterialThemeKt.MaterialTheme(colors.m4195copypvPzIIM((8175 & 1) != 0 ? colors.m4203getPrimary0d7_KjU() : 0L, (8175 & 2) != 0 ? colors.m4204getPrimaryVariant0d7_KjU() : 0L, (8175 & 4) != 0 ? colors.m4205getSecondary0d7_KjU() : 0L, (8175 & 8) != 0 ? colors.m4206getSecondaryVariant0d7_KjU() : 0L, (8175 & 16) != 0 ? colors.m4196getBackground0d7_KjU() : j2, (8175 & 32) != 0 ? colors.m4207getSurface0d7_KjU() : 0L, (8175 & 64) != 0 ? colors.m4197getError0d7_KjU() : 0L, (8175 & 128) != 0 ? colors.m4200getOnPrimary0d7_KjU() : 0L, (8175 & 256) != 0 ? colors.m4201getOnSecondary0d7_KjU() : 0L, (8175 & 512) != 0 ? colors.m4198getOnBackground0d7_KjU() : 0L, (8175 & 1024) != 0 ? colors.m4202getOnSurface0d7_KjU() : 0L, (8175 & 2048) != 0 ? colors.m4199getOnError0d7_KjU() : 0L, (8175 & 4096) != 0 ? colors.isLight() : false), null, null, content, composerStartRestartGroup, i3 & 7168, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                zIsSystemInDarkTheme = z2;
                j4 = neBlue;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            z2 = zIsSystemInDarkTheme;
            neBlue = j3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!z2) {
            }
            Colors colors2 = colorsM13019lightColorPalette8_81llA;
            MaterialThemeKt.MaterialTheme(colors2.m4195copypvPzIIM((8175 & 1) != 0 ? colors2.m4203getPrimary0d7_KjU() : 0L, (8175 & 2) != 0 ? colors2.m4204getPrimaryVariant0d7_KjU() : 0L, (8175 & 4) != 0 ? colors2.m4205getSecondary0d7_KjU() : 0L, (8175 & 8) != 0 ? colors2.m4206getSecondaryVariant0d7_KjU() : 0L, (8175 & 16) != 0 ? colors2.m4196getBackground0d7_KjU() : j2, (8175 & 32) != 0 ? colors2.m4207getSurface0d7_KjU() : 0L, (8175 & 64) != 0 ? colors2.m4197getError0d7_KjU() : 0L, (8175 & 128) != 0 ? colors2.m4200getOnPrimary0d7_KjU() : 0L, (8175 & 256) != 0 ? colors2.m4201getOnSecondary0d7_KjU() : 0L, (8175 & 512) != 0 ? colors2.m4198getOnBackground0d7_KjU() : 0L, (8175 & 1024) != 0 ? colors2.m4202getOnSurface0d7_KjU() : 0L, (8175 & 2048) != 0 ? colors2.m4199getOnError0d7_KjU() : 0L, (8175 & 4096) != 0 ? colors2.isLight() : false), null, null, content, composerStartRestartGroup, i3 & 7168, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            zIsSystemInDarkTheme = z2;
            j4 = neBlue;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j4 = j3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.ThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.NeboDialogTheme_eopBjH0$lambda$0(zIsSystemInDarkTheme, j4, j2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
