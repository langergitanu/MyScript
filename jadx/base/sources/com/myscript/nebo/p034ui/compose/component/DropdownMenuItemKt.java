package com.myscript.nebo.p034ui.compose.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: dropdownMenuItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\f\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"DropdownMenuItemWithIcon", "", "Landroidx/compose/foundation/layout/ColumnScope;", "onClick", "Lkotlin/Function0;", "labelRes", "", "iconRes", "iconSpaceReserved", "", "enabled", "isCritical", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function0;ILjava/lang/Integer;ZZZLandroidx/compose/runtime/Composer;II)V", "label", "", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;ZZZLandroidx/compose/runtime/Composer;II)V", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DropdownMenuItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$0(ColumnScope columnScope, Function0 function0, int i, Integer num, boolean z, boolean z2, boolean z3, int i2, int i3, Composer composer, int i4) {
        DropdownMenuItemWithIcon(columnScope, (Function0<Unit>) function0, i, num, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$2(ColumnScope columnScope, Function0 function0, String str, Painter painter, boolean z, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        DropdownMenuItemWithIcon(columnScope, (Function0<Unit>) function0, str, painter, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItemWithIcon(final ColumnScope columnScope, final Function0<Unit> onClick, final int i, Integer num, boolean z, boolean z2, boolean z3, Composer composer, final int i2, final int i3) {
        int i4;
        Integer num2;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        final Integer num3;
        Composer composer2;
        final boolean z7;
        final boolean z8;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-890566946);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemWithIcon)N(onClick,labelRes,iconRes,iconSpaceReserved,enabled,isCritical)37@1499L24,37@1465L105:dropdownMenuItem.kt#c23i0p");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        int i8 = i3 & 4;
        if (i8 != 0) {
            i4 |= 3072;
        } else {
            if ((i2 & 3072) == 0) {
                num2 = num;
                i4 |= composerStartRestartGroup.changed(num2) ? 2048 : 1024;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    z4 = z;
                    i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                } else {
                    if ((196608 & i2) == 0) {
                        z5 = z2;
                        i4 |= composerStartRestartGroup.changed(z5) ? 131072 : 65536;
                    }
                    i7 = i3 & 32;
                    if (i7 != 0) {
                        if ((1572864 & i2) == 0) {
                            z6 = z3;
                            i4 |= composerStartRestartGroup.changed(z6) ? 1048576 : 524288;
                        }
                        if (!composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            num3 = num2;
                            composer2 = composerStartRestartGroup;
                            z7 = z4;
                            z8 = z5;
                            z9 = z6;
                        } else {
                            Painter painterPainterResource = null;
                            Integer num4 = i8 != 0 ? null : num2;
                            boolean z10 = i5 != 0 ? false : z4;
                            boolean z11 = i6 != 0 ? true : z5;
                            boolean z12 = i7 != 0 ? false : z6;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-890566946, i4, -1, "com.myscript.nebo.ui.compose.component.DropdownMenuItemWithIcon (dropdownMenuItem.kt:35)");
                            }
                            if (num4 == null || num4.intValue() == 0) {
                                composerStartRestartGroup.startReplaceGroup(-866556545);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1136333034);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "36@1426L24");
                                painterPainterResource = PainterResources_androidKt.painterResource(num4.intValue(), composerStartRestartGroup, (i4 >> 9) & 14);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            DropdownMenuItemWithIcon(columnScope, onClick, StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 6) & 14), painterPainterResource, z10, z11, z12, composerStartRestartGroup, (i4 & 3670016) | (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (Painter.$stable << 9) | (57344 & i4) | (458752 & i4), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            z9 = z12;
                            z8 = z11;
                            z7 = z10;
                            num3 = num4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.component.DropdownMenuItemKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DropdownMenuItemKt.DropdownMenuItemWithIcon$lambda$0(columnScope, onClick, i, num3, z7, z8, z9, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    z6 = z3;
                    if (!composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i7 = i3 & 32;
                if (i7 != 0) {
                }
                z6 = z3;
                if (!composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z5 = z2;
            i7 = i3 & 32;
            if (i7 != 0) {
            }
            z6 = z3;
            if (!composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        num2 = num;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z4 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z5 = z2;
        i7 = i3 & 32;
        if (i7 != 0) {
        }
        z6 = z3;
        if (!composerStartRestartGroup.shouldExecute((599187 & i4) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItemWithIcon(final ColumnScope columnScope, final Function0<Unit> onClick, final String label, Painter painter, boolean z, boolean z2, boolean z3, Composer composer, final int i, final int i2) {
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        final Painter painter2;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM8158unboximpl;
        Painter painter3 = painter;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerStartRestartGroup = composer.startRestartGroup(1955520040);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemWithIcon)N(onClick,label,icon,iconSpaceReserved,enabled,isCritical)49@1863L7,51@2038L393,51@1972L459:dropdownMenuItem.kt#c23i0p");
        if ((i & 48) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(label) ? 256 : 128;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(painter3) : composerStartRestartGroup.changedInstance(painter3) ? 2048 : 1024;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                z4 = z;
                i3 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            } else {
                if ((196608 & i) == 0) {
                    z5 = z2;
                    i3 |= composerStartRestartGroup.changed(z5) ? 131072 : 65536;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((1572864 & i) == 0) {
                        z6 = z3;
                        i3 |= composerStartRestartGroup.changed(z6) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((599185 & i3) == 599184, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        painter2 = painter3;
                        z7 = z4;
                        z8 = z5;
                    } else {
                        if (i6 != 0) {
                            painter3 = null;
                        }
                        z7 = i7 != 0 ? false : z4;
                        final boolean z9 = i4 != 0 ? true : z5;
                        if (i5 != 0) {
                            z6 = false;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1955520040, i3, -1, "com.myscript.nebo.ui.compose.component.DropdownMenuItemWithIcon (dropdownMenuItem.kt:48)");
                        }
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fFloatValue = ((Number) objConsume).floatValue();
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1940906163);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "50@1924L6");
                            jM8158unboximpl = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4197getError0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1940905233);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "50@1960L7");
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM8158unboximpl = ((Color) objConsume2).m8158unboximpl();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Painter painter4 = painter3;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m8138boximpl(jM8158unboximpl)), ComposableLambdaKt.rememberComposableLambda(-269991576, true, new Function2() { // from class: com.myscript.nebo.ui.compose.component.DropdownMenuItemKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DropdownMenuItemKt.DropdownMenuItemWithIcon$lambda$1(onClick, z9, painter4, fFloatValue, z7, label, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z9;
                        painter2 = painter4;
                    }
                    final boolean z10 = z6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.component.DropdownMenuItemKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DropdownMenuItemKt.DropdownMenuItemWithIcon$lambda$2(columnScope, onClick, label, painter2, z7, z8, z10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                z6 = z3;
                if (composerStartRestartGroup.shouldExecute((599185 & i3) == 599184, i3 & 1)) {
                }
                final boolean z102 = z6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z2;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            z6 = z3;
            if (composerStartRestartGroup.shouldExecute((599185 & i3) == 599184, i3 & 1)) {
            }
            final boolean z1022 = z6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        z4 = z;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z5 = z2;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        z6 = z3;
        if (composerStartRestartGroup.shouldExecute((599185 & i3) == 599184, i3 & 1)) {
        }
        final boolean z10222 = z6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$1(Function0 function0, boolean z, final Painter painter, final float f, final boolean z2, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C52@2103L322,52@2048L377:dropdownMenuItem.kt#c23i0p");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-269991576, i, -1, "com.myscript.nebo.ui.compose.component.DropdownMenuItemWithIcon.<anonymous> (dropdownMenuItem.kt:52)");
            }
            AndroidMenu_androidKt.DropdownMenuItem(function0, null, z, null, null, ComposableLambdaKt.rememberComposableLambda(-1787224373, true, new Function3() { // from class: com.myscript.nebo.ui.compose.component.DropdownMenuItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DropdownMenuItemKt.DropdownMenuItemWithIcon$lambda$1$0(painter, f, z2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemWithIcon$lambda$1$0(Painter painter, float f, boolean z, String str, RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C53@2117L298:dropdownMenuItem.kt#c23i0p");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1787224373, i, -1, "com.myscript.nebo.ui.compose.component.DropdownMenuItemWithIcon.<anonymous>.<anonymous> (dropdownMenuItem.kt:53)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -817812349, "C58@2390L11:dropdownMenuItem.kt#c23i0p");
            if (painter != null) {
                composer.startReplaceGroup(-442021823);
                ComposerKt.sourceInformation(composer, "55@2235L50");
                IconKt.m4300Iconww6aTOc(painter, (String) null, AlphaKt.alpha(Modifier.INSTANCE, f), 0L, composer, Painter.$stable | 48, 8);
                composer.endReplaceGroup();
            } else if (z) {
                composer.startReplaceGroup(-442018901);
                ComposerKt.sourceInformation(composer, "56@2327L28");
                SpacerKt.Spacer(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-817639277);
                composer.endReplaceGroup();
            }
            TextKt.m4524Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
