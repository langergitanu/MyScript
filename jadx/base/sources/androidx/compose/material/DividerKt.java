package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "DividerAlpha", "", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Divider_oMI9zvI$lambda$0(Modifier modifier, long j, float f, float f2, int i, int i2, Composer composer, int i3) {
        m4242DivideroMI9zvI(modifier, j, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4242DivideroMI9zvI(Modifier modifier, long j, float f, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM8147copywmQWz5c$default;
        float fM11017constructorimpl;
        int i4;
        float f3;
        Modifier.Companion companion;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM11017constructorimpl2;
        Modifier.Companion companionM2858paddingqDBjuR0$default;
        float fM11017constructorimpl3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)N(modifier,color:c#ui.graphics.Color,thickness:c#ui.unit.Dp,startIndent:c#ui.unit.Dp)63@2271L94:Divider.kt#jmzs0o");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            jM8147copywmQWz5c$default = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM8147copywmQWz5c$default)) ? 32 : 16;
        } else {
            jM8147copywmQWz5c$default = j;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                fM11017constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM11017constructorimpl) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f3 = f2;
                    i3 |= composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@1841L6");
                    if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        companion = modifier2;
                    } else {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m4202getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -113;
                        }
                        if (i6 != 0) {
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(1);
                        }
                        if (i4 != 0) {
                            fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(0);
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:50)");
                        }
                        if (fM11017constructorimpl2 == 0.0f) {
                            companionM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, fM11017constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            companionM2858paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        if (!C1486Dp.m11022equalsimpl0(fM11017constructorimpl, C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM())) {
                            composerStartRestartGroup.startReplaceGroup(-455979798);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2198L7");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(1.0f / ((Density) objConsume).getDensity());
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-455913241);
                            composerStartRestartGroup.endReplaceGroup();
                            fM11017constructorimpl3 = fM11017constructorimpl;
                        }
                        BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.m2910height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM2858paddingqDBjuR0$default), 0.0f, 1, null), fM11017constructorimpl3), jM8147copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f4 = fM11017constructorimpl2;
                    }
                    fM11017constructorimpl2 = f3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (fM11017constructorimpl2 == 0.0f) {
                    }
                    if (!C1486Dp.m11022equalsimpl0(fM11017constructorimpl, C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM())) {
                    }
                    BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.m2910height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(companionM2858paddingqDBjuR0$default), 0.0f, 1, null), fM11017constructorimpl3), jM8147copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f4 = fM11017constructorimpl2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    f4 = f3;
                }
                final float f5 = fM11017constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final long j2 = jM8147copywmQWz5c$default;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.DividerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DividerKt.Divider_oMI9zvI$lambda$0(modifier3, j2, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            f3 = f2;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            final float f52 = fM11017constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM11017constructorimpl = f;
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        f3 = f2;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        final float f522 = fM11017constructorimpl;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
