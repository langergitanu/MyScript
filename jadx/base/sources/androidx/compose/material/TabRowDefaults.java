package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u001c\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\tX\u008a\u0084\u0002"}, m1599d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "<init>", "()V", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "DividerOpacity", "", "DividerThickness", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "material", "currentTabWidth", "indicatorOffset"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float DividerThickness = C1486Dp.m11017constructorimpl(1);
    private static final float IndicatorHeight = C1486Dp.m11017constructorimpl(2);
    private static final float ScrollableTabRowPadding = C1486Dp.m11017constructorimpl(52);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Divider_9IZ8Weo$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4474Divider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_9IZ8Weo$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4475Indicator9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private TabRowDefaults() {
    }

    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public final void m4474Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        float f2;
        long jM8147copywmQWz5c$default;
        final float f3;
        final long j2;
        float f4;
        float f5;
        long j3;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(910934799);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Divider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)358@16538L66:TabRow.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            if ((i2 & 2) == 0) {
                f2 = f;
                int i5 = composerStartRestartGroup.changed(f2) ? 32 : 16;
                i3 |= i5;
            } else {
                f2 = f;
            }
            i3 |= i5;
        } else {
            f2 = f;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            jM8147copywmQWz5c$default = j;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM8147copywmQWz5c$default)) ? 256 : 128;
        } else {
            jM8147copywmQWz5c$default = j;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "356@16458L7");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                f5 = f2;
                j3 = jM8147copywmQWz5c$default;
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    f4 = DividerThickness;
                    i3 &= -113;
                } else {
                    f4 = f2;
                }
                if ((i2 & 4) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(((Color) objConsume).m8158unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -897;
                }
                f5 = f4;
                j3 = jM8147copywmQWz5c$default;
                modifier3 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(910934799, i3, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:357)");
            }
            DividerKt.m4242DivideroMI9zvI(modifier3, j3, f5, 0.0f, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | ((i3 << 3) & 896), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j2 = j3;
            f3 = f5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f3 = f2;
            j2 = jM8147copywmQWz5c$default;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowDefaults.Divider_9IZ8Weo$lambda$0(this.f$0, modifier2, f3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m4475Indicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long jM8158unboximpl;
        TabRowDefaults tabRowDefaults;
        final Modifier.Companion companion;
        final float f3;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1499002201);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)375@17072L69:TabRow.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            if ((i2 & 2) == 0) {
                f2 = f;
                int i5 = composerStartRestartGroup.changed(f2) ? 32 : 16;
                i3 |= i5;
            } else {
                f2 = f;
            }
            i3 |= i5;
        } else {
            f2 = f;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                jM8158unboximpl = j;
                int i6 = composerStartRestartGroup.changed(jM8158unboximpl) ? 256 : 128;
                i3 |= i6;
            } else {
                jM8158unboximpl = j;
            }
            i3 |= i6;
        } else {
            jM8158unboximpl = j;
        }
        if ((i & 3072) == 0) {
            tabRowDefaults = this;
            i3 |= composerStartRestartGroup.changed(tabRowDefaults) ? 2048 : 1024;
        } else {
            tabRowDefaults = this;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "373@17047L7");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                companion = modifier2;
                f3 = f2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    f3 = IndicatorHeight;
                    i3 &= -113;
                } else {
                    f3 = f2;
                }
                if ((i2 & 4) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM8158unboximpl = ((Color) objConsume).m8158unboximpl();
                    i3 &= -897;
                }
            }
            long j3 = jM8158unboximpl;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499002201, i3, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:374)");
            }
            BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.m2910height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3), j3, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            f3 = f2;
            j2 = jM8158unboximpl;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TabRowDefaults tabRowDefaults2 = tabRowDefaults;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowDefaults.Indicator_9IZ8Weo$lambda$0(this.f$0, companion, f3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier tabIndicatorOffset$lambda$1(TabPosition tabPosition, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-398757863);
        ComposerKt.sourceInformation(composer, "C394@17891L190,399@18133L189,405@18430L53:TabRow.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-398757863, i, -1, "androidx.compose.material.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:393)");
        }
        State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(tabPosition.getWidth(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, composer, 0, 12);
        final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(tabPosition.getLeft(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, composer, 0, 12);
        Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, -954198002, "CC(remember):TabRow.kt#9igjgp");
        boolean zChanged = composer.changed(stateM1892animateDpAsStateAjpBEmI2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material.TabRowDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TabRowDefaults.tabIndicatorOffset$lambda$1$2$0(stateM1892animateDpAsStateAjpBEmI2, (Density) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM2929width3ABfNKs = SizeKt.m2929width3ABfNKs(OffsetKt.offset(modifierWrapContentSize$default, (Function1) objRememberedValue), tabIndicatorOffset$lambda$1$0(stateM1892animateDpAsStateAjpBEmI));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2929width3ABfNKs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset tabIndicatorOffset$lambda$1$2$0(State state, Density density) {
        return IntOffset.m11136boximpl(IntOffset.m11139constructorimpl((((long) density.mo2185roundToPx0680j_4(tabIndicatorOffset$lambda$1$1(state))) << 32) | (((long) 0) & 4294967295L)));
    }

    /* JADX INFO: renamed from: getDividerThickness-D9Ej5fM, reason: not valid java name */
    public final float m4476getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* JADX INFO: renamed from: getIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m4477getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* JADX INFO: renamed from: getScrollableTabRowPadding-D9Ej5fM, reason: not valid java name */
    public final float m4478getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    public final Modifier tabIndicatorOffset(Modifier modifier, final TabPosition tabPosition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(tabPosition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.material.TabRowDefaults$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TabRowDefaults.tabIndicatorOffset$lambda$1(tabPosition, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    private static final float tabIndicatorOffset$lambda$1$0(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float tabIndicatorOffset$lambda$1$1(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }
}
