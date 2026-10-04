package com.myscript.android.utils.p019ui.compose;

import android.content.res.Configuration;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001ae\u0010\u0003\u001a\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a]\u0010\f\u001a\u00020\u00042&\u0010\r\u001a\"\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u00072&\u0010\u0013\u001a\"\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0015\u001a\u00020\u00042&\u0010\u0016\u001a\"\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u00072&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0019"}, m1599d2 = {"rememberScreenLayoutState", "Lcom/myscript/android/utils/ui/compose/ScreenLayoutState;", "(Landroidx/compose/runtime/Composer;I)Lcom/myscript/android/utils/ui/compose/ScreenLayoutState;", "AdaptiveLayout", "", "largeLandscape", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "compactPortrait", "compactLandscape", "largePortrait", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AdaptiveLayoutBySize", "compact", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isLandscape", "large", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AdaptiveLayoutByOrientation", "portrait", "isLargeScreen", "landscape", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LayoutConfigurationKt {

    /* JADX INFO: compiled from: LayoutConfiguration.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenLayoutConfiguration.values().length];
            try {
                iArr[ScreenLayoutConfiguration.COMPACT_PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScreenLayoutConfiguration.COMPACT_LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScreenLayoutConfiguration.LARGE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScreenLayoutConfiguration.LARGE_LANDSCAPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdaptiveLayout$lambda$0(Function2 function2, Function2 function22, Function2 function23, Function2 function24, int i, int i2, Composer composer, int i3) {
        AdaptiveLayout(function2, function22, function23, function24, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdaptiveLayoutByOrientation$lambda$0(Function3 function3, Function3 function32, int i, Composer composer, int i2) {
        AdaptiveLayoutByOrientation(function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdaptiveLayoutBySize$lambda$0(Function3 function3, Function3 function32, int i, Composer composer, int i2) {
        AdaptiveLayoutBySize(function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final ScreenLayoutState rememberScreenLayoutState(Composer composer, int i) {
        ScreenLayoutConfiguration screenLayoutConfiguration;
        ComposerKt.sourceInformationMarkerStart(composer, -2026479339, "C(rememberScreenLayoutState)51@1441L7:LayoutConfiguration.kt#vd5fha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026479339, i, -1, "com.myscript.android.utils.ui.compose.rememberScreenLayoutState (LayoutConfiguration.kt:50)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        boolean z = configuration.orientation == 2;
        boolean z2 = ((float) configuration.screenWidthDp) > C1486Dp.m11017constructorimpl((float) 500) && ((float) configuration.screenHeightDp) > C1486Dp.m11017constructorimpl((float) 600);
        if (z2 && z) {
            screenLayoutConfiguration = ScreenLayoutConfiguration.LARGE_LANDSCAPE;
        } else if (z2) {
            screenLayoutConfiguration = ScreenLayoutConfiguration.LARGE_PORTRAIT;
        } else if (!z2 && z) {
            screenLayoutConfiguration = ScreenLayoutConfiguration.COMPACT_LANDSCAPE;
        } else {
            screenLayoutConfiguration = ScreenLayoutConfiguration.COMPACT_PORTRAIT;
        }
        ScreenLayoutState screenLayoutState = new ScreenLayoutState(screenLayoutConfiguration, z, z2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return screenLayoutState;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdaptiveLayout(final Function2<? super Composer, ? super Integer, Unit> largeLandscape, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(largeLandscape, "largeLandscape");
        Composer composerStartRestartGroup = composer.startRestartGroup(999256474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AdaptiveLayout)N(largeLandscape,compactPortrait,compactLandscape,largePortrait)123@4293L27:LayoutConfiguration.kt#vd5fha");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(largeLandscape) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function24 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function25 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function25) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        function26 = function23;
                        i3 |= composerStartRestartGroup.changedInstance(function26) ? 2048 : 1024;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                    } else {
                        if (i6 != 0) {
                            function24 = null;
                        }
                        if (i4 != 0) {
                            function25 = null;
                        }
                        if (i5 != 0) {
                            function26 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(999256474, i3, -1, "com.myscript.android.utils.ui.compose.AdaptiveLayout (LayoutConfiguration.kt:122)");
                        }
                        int i7 = WhenMappings.$EnumSwitchMapping$0[rememberScreenLayoutState(composerStartRestartGroup, 0).getConfiguration().ordinal()];
                        if (i7 == 1) {
                            composerStartRestartGroup.startReplaceGroup(-1787190753);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "126@4415L37");
                            (function24 == null ? largeLandscape : function24).invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (i7 == 2) {
                            composerStartRestartGroup.startReplaceGroup(-1787187776);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "127@4508L38");
                            (function25 == null ? largeLandscape : function25).invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (i7 == 3) {
                            composerStartRestartGroup.startReplaceGroup(-1787184867);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "128@4599L35");
                            (function26 == null ? largeLandscape : function26).invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            if (i7 != 4) {
                                composerStartRestartGroup.startReplaceGroup(-1787193254);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-1787182038);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "129@4688L16");
                            largeLandscape.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function24;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.LayoutConfigurationKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LayoutConfigurationKt.AdaptiveLayout$lambda$0(largeLandscape, function29, function27, function28, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                function26 = function23;
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                }
                final Function2 function272 = function25;
                final Function2 function282 = function26;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function25 = function22;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            function26 = function23;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
            }
            final Function2 function2722 = function25;
            final Function2 function2822 = function26;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function24 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function26 = function23;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        final Function2 function27222 = function25;
        final Function2 function28222 = function26;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void AdaptiveLayoutBySize(final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> compact, final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> large, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(compact, "compact");
        Intrinsics.checkNotNullParameter(large, "large");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2111213442);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AdaptiveLayoutBySize)N(compact,large)155@5381L27:LayoutConfiguration.kt#vd5fha");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(compact) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(large) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2111213442, i2, -1, "com.myscript.android.utils.ui.compose.AdaptiveLayoutBySize (LayoutConfiguration.kt:154)");
            }
            ScreenLayoutState screenLayoutStateRememberScreenLayoutState = rememberScreenLayoutState(composerStartRestartGroup, 0);
            if (screenLayoutStateRememberScreenLayoutState.isLargeScreen()) {
                composerStartRestartGroup.startReplaceGroup(341658614);
                ComposerKt.sourceInformation(composerStartRestartGroup, "158@5455L30");
                large.invoke(Boolean.valueOf(screenLayoutStateRememberScreenLayoutState.isLandscape()), composerStartRestartGroup, Integer.valueOf(i2 & 112));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(341710260);
                ComposerKt.sourceInformation(composerStartRestartGroup, "160@5507L32");
                compact.invoke(Boolean.valueOf(screenLayoutStateRememberScreenLayoutState.isLandscape()), composerStartRestartGroup, Integer.valueOf((i2 << 3) & 112));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.LayoutConfigurationKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LayoutConfigurationKt.AdaptiveLayoutBySize$lambda$0(compact, large, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AdaptiveLayoutByOrientation(final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> portrait, final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> landscape, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        Intrinsics.checkNotNullParameter(landscape, "landscape");
        Composer composerStartRestartGroup = composer.startRestartGroup(-649165255);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AdaptiveLayoutByOrientation)N(portrait,landscape)186@6243L27:LayoutConfiguration.kt#vd5fha");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(portrait) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(landscape) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649165255, i2, -1, "com.myscript.android.utils.ui.compose.AdaptiveLayoutByOrientation (LayoutConfiguration.kt:185)");
            }
            ScreenLayoutState screenLayoutStateRememberScreenLayoutState = rememberScreenLayoutState(composerStartRestartGroup, 0);
            if (screenLayoutStateRememberScreenLayoutState.isLandscape()) {
                composerStartRestartGroup.startReplaceGroup(955862869);
                ComposerKt.sourceInformation(composerStartRestartGroup, "189@6315L36");
                landscape.invoke(Boolean.valueOf(screenLayoutStateRememberScreenLayoutState.isLargeScreen()), composerStartRestartGroup, Integer.valueOf(i2 & 112));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(955920374);
                ComposerKt.sourceInformation(composerStartRestartGroup, "191@6373L35");
                portrait.invoke(Boolean.valueOf(screenLayoutStateRememberScreenLayoutState.isLargeScreen()), composerStartRestartGroup, Integer.valueOf((i2 << 3) & 112));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.LayoutConfigurationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LayoutConfigurationKt.AdaptiveLayoutByOrientation$lambda$0(portrait, landscape, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
