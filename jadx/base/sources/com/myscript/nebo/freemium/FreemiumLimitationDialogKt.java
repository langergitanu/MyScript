package com.myscript.nebo.freemium;

import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.window.AndroidDialog_androidKt;
import androidx.compose.p004ui.window.DialogProperties;
import androidx.compose.p004ui.window.DialogWindowProvider;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.p019ui.compose.ScreenSizeKt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: FreemiumLimitationDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0007\u001a1\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0007\u001a1\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0007\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a/\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0016\u001a1\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a!\u0010\u0018\u001a\u00020\u00012\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001b\u001a1\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\"\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b+H\u0003¢\u0006\u0002\u0010,\u001a\r\u0010-\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010.\u001a\r\u0010/\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010.\u001a\r\u00100\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010.¨\u00061"}, m1599d2 = {"FreemiumLimitationDialog", "", "state", "Lcom/myscript/nebo/freemium/FreemiumLimitationDialogState;", "onActionButtonClick", "Lkotlin/Function0;", "onCloseButtonClick", "(Lcom/myscript/nebo/freemium/FreemiumLimitationDialogState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LargeDialog", "CompactLandscapeDialog", "CompactPortraitDialog", "NormalContent", "CloseButton", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "closeClick", "CloseButton-3IgeMak", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SubscribeButton", "onClick", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PhoneLandscapeContent", "Illustration", "drawableResId", "", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TextContent", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Lcom/myscript/nebo/freemium/FreemiumLimitationDialogState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;II)V", "GradientButton", "roundedCornerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "colors", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/shape/RoundedCornerShape;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FreemiumLimitationDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "FreemiumLimitationDialogPhonePortraitPreview", "FreemiumLimitationDialogPhoneLandscapePreview", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreemiumLimitationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CloseButton_3IgeMak$lambda$1(Modifier modifier, long j, Function0 function0, int i, int i2, Composer composer, int i3) {
        m13201CloseButton3IgeMak(modifier, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactLandscapeDialog$lambda$2(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CompactLandscapeDialog(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactPortraitDialog$lambda$2(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CompactPortraitDialog(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreemiumLimitationDialog$lambda$1(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        FreemiumLimitationDialog(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreemiumLimitationDialogPhoneLandscapePreview$lambda$2(int i, Composer composer, int i2) {
        FreemiumLimitationDialogPhoneLandscapePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreemiumLimitationDialogPhonePortraitPreview$lambda$2(int i, Composer composer, int i2) {
        FreemiumLimitationDialogPhonePortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreemiumLimitationDialogPreview$lambda$2(int i, Composer composer, int i2) {
        FreemiumLimitationDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GradientButton$lambda$1(Modifier modifier, RoundedCornerShape roundedCornerShape, List list, Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        GradientButton(modifier, roundedCornerShape, list, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Illustration$lambda$0(int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        Illustration(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeDialog$lambda$2(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        LargeDialog(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NormalContent$lambda$1(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NormalContent(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneLandscapeContent$lambda$1(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        PhoneLandscapeContent(freemiumLimitationDialogState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubscribeButton$lambda$1(Function0 function0, int i, int i2, Composer composer, int i3) {
        SubscribeButton(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextContent$lambda$1(FreemiumLimitationDialogState freemiumLimitationDialogState, Modifier modifier, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, int i2, Composer composer, int i3) {
        TextContent(freemiumLimitationDialogState, modifier, vertical, horizontal, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FreemiumLimitationDialog(final FreemiumLimitationDialogState state, final Function0<Unit> onActionButtonClick, final Function0<Unit> onCloseButtonClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onActionButtonClick, "onActionButtonClick");
        Intrinsics.checkNotNullParameter(onCloseButtonClick, "onCloseButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-181093407);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FreemiumLimitationDialog)N(state,onActionButtonClick,onCloseButtonClick)60@2628L412,60@2618L422:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onActionButtonClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCloseButtonClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-181093407, i2, -1, "com.myscript.nebo.freemium.FreemiumLimitationDialog (FreemiumLimitationDialog.kt:59)");
            }
            ThemeKt.m13017NeboTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(-359970983, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.FreemiumLimitationDialog$lambda$0(state, onActionButtonClick, onCloseButtonClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.FreemiumLimitationDialog$lambda$1(state, onActionButtonClick, onCloseButtonClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FreemiumLimitationDialog$lambda$0(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2657L20,66@2797L9:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-359970983, i, -1, "com.myscript.nebo.freemium.FreemiumLimitationDialog.<anonymous> (FreemiumLimitationDialog.kt:61)");
            }
            if (ScreenSizeKt.isPhoneInLandscape(composer, 0)) {
                composer.startReplaceGroup(637839299);
                ComposerKt.sourceInformation(composer, "63@2699L70");
                CompactLandscapeDialog(freemiumLimitationDialogState, function0, function02, composer, 0);
                composer.endReplaceGroup();
            } else if (ScreenSizeKt.isPhone(composer, 0)) {
                composer.startReplaceGroup(637967236);
                ComposerKt.sourceInformation(composer, "67@2828L69");
                CompactPortraitDialog(freemiumLimitationDialogState, function0, function02, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(638088942);
                ComposerKt.sourceInformation(composer, "71@2951L59");
                LargeDialog(freemiumLimitationDialogState, function0, function02, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void LargeDialog(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1643313732);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LargeDialog)N(state,onActionButtonClick,onCloseButtonClick)81@3322L2,82@3331L322,79@3189L464:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(freemiumLimitationDialogState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643313732, i2, -1, "com.myscript.nebo.freemium.LargeDialog (FreemiumLimitationDialog.kt:78)");
            }
            DialogProperties dialogProperties = new DialogProperties(false, false, false, 4, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1323476734, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidDialog_androidKt.Dialog((Function0) objRememberedValue, dialogProperties, ComposableLambdaKt.rememberComposableLambda(-1651250939, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.LargeDialog$lambda$1(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.LargeDialog$lambda$2(freemiumLimitationDialogState, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeDialog$lambda$1$0(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@3463L174:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1278133634, i, -1, "com.myscript.nebo.freemium.LargeDialog.<anonymous>.<anonymous> (FreemiumLimitationDialog.kt:87)");
            }
            NormalContent(freemiumLimitationDialogState, function0, function02, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CompactLandscapeDialog(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(159973411);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CompactLandscapeDialog)N(state,onActionButtonClick,onCloseButtonClick)100@3979L2,101@3988L331,98@3813L506:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(freemiumLimitationDialogState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159973411, i2, -1, "com.myscript.nebo.freemium.CompactLandscapeDialog (FreemiumLimitationDialog.kt:97)");
            }
            DialogProperties dialogProperties = new DialogProperties(false, false, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -884365019, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidDialog_androidKt.Dialog((Function0) objRememberedValue, dialogProperties, ComposableLambdaKt.rememberComposableLambda(-242326214, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactLandscapeDialog$lambda$1(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactLandscapeDialog$lambda$2(freemiumLimitationDialogState, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactLandscapeDialog$lambda$1$0(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4121L182:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1787807901, i, -1, "com.myscript.nebo.freemium.CompactLandscapeDialog.<anonymous>.<anonymous> (FreemiumLimitationDialog.kt:106)");
            }
            PhoneLandscapeContent(freemiumLimitationDialogState, function0, function02, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CompactPortraitDialog(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-76299655);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CompactPortraitDialog)N(state,onActionButtonClick,onCloseButtonClick)119@4644L2,120@4653L596,117@4478L771:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(freemiumLimitationDialogState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-76299655, i2, -1, "com.myscript.nebo.freemium.CompactPortraitDialog (FreemiumLimitationDialog.kt:116)");
            }
            DialogProperties dialogProperties = new DialogProperties(false, false, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -309514789, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidDialog_androidKt.Dialog((Function0) objRememberedValue, dialogProperties, ComposableLambdaKt.rememberComposableLambda(187817602, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactPortraitDialog$lambda$1(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactPortraitDialog$lambda$2(freemiumLimitationDialogState, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactPortraitDialog$lambda$1(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0 function0, final Function0 function02, Composer composer, int i) {
        Window window;
        ComposerKt.sourceInformation(composer, "C122@4766L7,130@5045L198,125@4880L363:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(187817602, i, -1, "com.myscript.nebo.freemium.CompactPortraitDialog.<anonymous> (FreemiumLimitationDialog.kt:122)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewParent parent = ((View) objConsume).getParent();
            DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
            if (dialogWindowProvider != null && (window = dialogWindowProvider.getWindow()) != null) {
                window.setGravity(80);
            }
            CardKt.m4173CardFjzlyU(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.8f), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), 0L, 0L, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-23788865, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactPortraitDialog$lambda$1$0(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572870, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactPortraitDialog$lambda$1$0(FreemiumLimitationDialogState freemiumLimitationDialogState, Function0 function0, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C131@5059L174:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-23788865, i, -1, "com.myscript.nebo.freemium.CompactPortraitDialog.<anonymous>.<anonymous> (FreemiumLimitationDialog.kt:131)");
            }
            NormalContent(freemiumLimitationDialogState, function0, function02, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void NormalContent(FreemiumLimitationDialogState state, final Function0<Unit> onActionButtonClick, Function0<Unit> onCloseButtonClick, Composer composer, final int i) {
        int i2;
        final FreemiumLimitationDialogState freemiumLimitationDialogState;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onActionButtonClick, "onActionButtonClick");
        Intrinsics.checkNotNullParameter(onCloseButtonClick, "onCloseButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-141426643);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NormalContent)N(state,onActionButtonClick,onCloseButtonClick)146@5406L944:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onActionButtonClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCloseButtonClick) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            freemiumLimitationDialogState = state;
            function0 = onCloseButtonClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-141426643, i3, -1, "com.myscript.nebo.freemium.NormalContent (FreemiumLimitationDialog.kt:145)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -924126246, "C149@5478L717,173@6205L139:FreemiumLimitationDialog.kt#d60tuo");
            float f = 16;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(32), C1486Dp.m11017constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1025398817, "C155@5688L447,170@6149L36:FreemiumLimitationDialog.kt#d60tuo");
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1169085243, "C156@5734L195,163@5947L174:FreemiumLimitationDialog.kt#d60tuo");
            Illustration(state.getDrawableResId(), SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null), composerStartRestartGroup, 48, 0);
            TextContent(state, ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(4)), null, composerStartRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 8);
            freemiumLimitationDialogState = state;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubscribeButton(onActionButtonClick, composerStartRestartGroup, (i3 >> 3) & 14, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function0 = onCloseButtonClick;
            m13201CloseButton3IgeMak(PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), C1486Dp.m11017constructorimpl(8)), Color.INSTANCE.m8177getDarkGray0d7_KjU(), function0, composerStartRestartGroup, (i3 & 896) | 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.NormalContent$lambda$1(freemiumLimitationDialogState, onActionButtonClick, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: CloseButton-3IgeMak, reason: not valid java name */
    private static final void m13201CloseButton3IgeMak(Modifier modifier, final long j, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(-524786998);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CloseButton)N(modifier,tint:c#ui.graphics.Color,closeClick)186@6586L16,187@6638L65,182@6465L303:FreemiumLimitationDialog.kt#d60tuo");
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
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-524786998, i3, -1, "com.myscript.nebo.freemium.CloseButton (FreemiumLimitationDialog.kt:181)");
            }
            Modifier modifierClip = ClipKt.clip(SizeKt.m2924size3ABfNKs(companion, C1486Dp.m11017constructorimpl(24)), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1809124678, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FreemiumLimitationDialogKt.CloseButton_3IgeMak$lambda$0$0(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_close, composerStartRestartGroup, 6), "close", ClickableKt.m2062clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null), j, composerStartRestartGroup, ((i3 << 6) & 7168) | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CloseButton_3IgeMak$lambda$1(companion, j, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CloseButton_3IgeMak$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void SubscribeButton(final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1406058930);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubscribeButton)N(onClick)194@6834L2,197@6978L6,195@6844L352:FreemiumLimitationDialog.kt#d60tuo");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1692065164, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1406058930, i3, -1, "com.myscript.nebo.freemium.SubscribeButton (FreemiumLimitationDialog.kt:194)");
            }
            Function0<Unit> function02 = function0;
            GradientButton(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(12)), CollectionsKt.listOf((Object[]) new Color[]{Color.m8138boximpl(ColorKt.Color(4282045176L)), Color.m8138boximpl(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU())}), function02, ComposableSingletons$FreemiumLimitationDialogKt.INSTANCE.getLambda$227765896$app_standardRelease(), composerStartRestartGroup, ((i3 << 9) & 7168) | 24582);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function0 = function02;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.SubscribeButton$lambda$1(function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void PhoneLandscapeContent(FreemiumLimitationDialogState state, final Function0<Unit> onActionButtonClick, Function0<Unit> onCloseButtonClick, Composer composer, final int i) {
        int i2;
        final FreemiumLimitationDialogState freemiumLimitationDialogState;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onActionButtonClick, "onActionButtonClick");
        Intrinsics.checkNotNullParameter(onCloseButtonClick, "onCloseButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1987227571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PhoneLandscapeContent)N(state,onActionButtonClick,onCloseButtonClick)213@7361L959:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onActionButtonClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCloseButtonClick) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            freemiumLimitationDialogState = state;
            function0 = onCloseButtonClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1987227571, i3, -1, "com.myscript.nebo.freemium.PhoneLandscapeContent (FreemiumLimitationDialog.kt:212)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1773671184, "C214@7412L754,233@8175L139:FreemiumLimitationDialog.kt#d60tuo");
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(48));
            float f = 32;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 28672751, "C219@7632L33,220@7678L477:FreemiumLimitationDialog.kt#d60tuo");
            Illustration(state.getDrawableResId(), null, composerStartRestartGroup, 0, 2);
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Vertical verticalM2530spacedByD5KLDUw = Arrangement.INSTANCE.m2530spacedByD5KLDUw(C1486Dp.m11017constructorimpl(f), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM2530spacedByD5KLDUw, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -42104733, "C221@7808L269,229@8095L46:FreemiumLimitationDialog.kt#d60tuo");
            TextContent(state, SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(400), 1, null), Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(4)), Alignment.INSTANCE.getStart(), composerStartRestartGroup, (i3 & 14) | 3504, 0);
            freemiumLimitationDialogState = state;
            SubscribeButton(onActionButtonClick, composerStartRestartGroup, (i3 >> 3) & 14, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function0 = onCloseButtonClick;
            m13201CloseButton3IgeMak(PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), C1486Dp.m11017constructorimpl(8)), Color.INSTANCE.m8177getDarkGray0d7_KjU(), function0, composerStartRestartGroup, (i3 & 896) | 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.PhoneLandscapeContent$lambda$1(freemiumLimitationDialogState, onActionButtonClick, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void Illustration(final int i, final Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1608551122);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Illustration)N(drawableResId,modifier)242@8448L35,241@8423L190:FreemiumLimitationDialog.kt#d60tuo");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1608551122, i4, -1, "com.myscript.nebo.freemium.Illustration (FreemiumLimitationDialog.kt:240)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14), "AI account Background", modifier2, (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 24624 | ((i4 << 3) & 896), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.Illustration$lambda$0(i, modifier, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextContent(final FreemiumLimitationDialogState state, Modifier modifier, final Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontal, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment.Horizontal horizontal2;
        Composer composer2;
        final Modifier modifier3;
        final Alignment.Horizontal horizontal3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1339558716);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextContent)N(state,modifier,verticalArrangement,horizontalAlignment)255@8854L723:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= composerStartRestartGroup.changed(verticalArrangement) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    horizontal2 = horizontal;
                    i3 |= composerStartRestartGroup.changed(horizontal2) ? 2048 : 1024;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                } else {
                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    Alignment.Horizontal centerHorizontally = i4 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontal2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1339558716, i3, -1, "com.myscript.nebo.freemium.TextContent (FreemiumLimitationDialog.kt:254)");
                    }
                    Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), C1486Dp.m11017constructorimpl(8));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalArrangement, centerHorizontally, composerStartRestartGroup, (((i3 >> 3) & 1008) >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 840452173, "C263@9088L37,264@9161L10,265@9210L6,262@9063L220,269@9317L36,271@9509L10,268@9292L279:FreemiumLimitationDialog.kt#d60tuo");
                    Alignment.Horizontal horizontal4 = centerHorizontally;
                    Modifier modifier4 = companion;
                    TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(state.getTitleResId(), composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH5(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 0, 65498);
                    composer2 = composerStartRestartGroup;
                    TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(state.getTextResId(), composerStartRestartGroup, 0), (Modifier) null, Color.INSTANCE.m8177getDarkGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(Intrinsics.areEqual(horizontal4, Alignment.INSTANCE.getCenterHorizontally()) ? TextAlign.INSTANCE.m10895getCentere0LSkKk() : TextAlign.INSTANCE.m10900getStarte0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 65018);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = horizontal4;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FreemiumLimitationDialogKt.TextContent$lambda$1(state, modifier3, verticalArrangement, horizontal3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            horizontal2 = horizontal;
            if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        horizontal2 = horizontal;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final void GradientButton(final Modifier modifier, final RoundedCornerShape roundedCornerShape, final List<Color> list, final Function0<Unit> function0, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1523474218);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GradientButton)N(modifier,roundedCornerShape,colors,onClick,content)289@9902L49,291@9994L580,286@9793L781:FreemiumLimitationDialog.kt#d60tuo");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(roundedCornerShape) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1523474218, i2, -1, "com.myscript.nebo.freemium.GradientButton (FreemiumLimitationDialog.kt:284)");
            }
            int i3 = i2;
            ButtonKt.Button(function0, null, false, null, null, roundedCornerShape, null, ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(Color.INSTANCE.m8183getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null), ComposableLambdaKt.rememberComposableLambda(1053499110, true, new Function3() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FreemiumLimitationDialogKt.GradientButton$lambda$0(modifier, list, roundedCornerShape, function3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | 905969664 | ((i3 << 12) & 458752), 94);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.GradientButton$lambda$1(modifier, roundedCornerShape, list, function0, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GradientButton$lambda$0(Modifier modifier, List list, RoundedCornerShape roundedCornerShape, Function3 function3, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C293@10005L563:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053499110, i, -1, "com.myscript.nebo.freemium.GradientButton.<anonymous> (FreemiumLimitationDialog.kt:293)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            RoundedCornerShape roundedCornerShape2 = roundedCornerShape;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(ClipKt.clip(BackgroundKt.background$default(SizeKt.m2908defaultMinSizeVpY3zN4(modifier, ButtonDefaults.INSTANCE.m4168getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m4167getMinHeightD9Ej5fM()), Brush.Companion.m8095horizontalGradient8A3gB4$default(Brush.INSTANCE, list, 0.0f, 0.0f, 0, 14, (Object) null), roundedCornerShape2, 0.0f, 4, null), roundedCornerShape2), C1486Dp.m11017constructorimpl(12), C1486Dp.m11017constructorimpl(6));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2855paddingVpY3zN4);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1237377426, "C307@10549L9:FreemiumLimitationDialog.kt#d60tuo");
            function3.invoke(boxScopeInstance, composer, 6);
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

    public static final void FreemiumLimitationDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2024467904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FreemiumLimitationDialogPreview)317@10778L2,318@10811L2,315@10673L146:FreemiumLimitationDialog.kt#d60tuo");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2024467904, i, -1, "com.myscript.nebo.freemium.FreemiumLimitationDialogPreview (FreemiumLimitationDialog.kt:314)");
            }
            FreemiumLimitationDialogState freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, false, 0, 0, 0, 31, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 106534114, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 106535170, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FreemiumLimitationDialog(freemiumLimitationDialogState, function0, (Function0) objRememberedValue2, composerStartRestartGroup, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.FreemiumLimitationDialogPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FreemiumLimitationDialogPhonePortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1233547447);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FreemiumLimitationDialogPhonePortraitPreview)327@11006L2,328@11039L2,325@10901L146:FreemiumLimitationDialog.kt#d60tuo");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1233547447, i, -1, "com.myscript.nebo.freemium.FreemiumLimitationDialogPhonePortraitPreview (FreemiumLimitationDialog.kt:324)");
            }
            FreemiumLimitationDialogState freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, false, 0, 0, 0, 31, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 28128057, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 28129113, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FreemiumLimitationDialog(freemiumLimitationDialogState, function0, (Function0) objRememberedValue2, composerStartRestartGroup, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.FreemiumLimitationDialogPhonePortraitPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FreemiumLimitationDialogPhoneLandscapePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1977187923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FreemiumLimitationDialogPhoneLandscapePreview)341@11352L2,342@11385L2,339@11247L146:FreemiumLimitationDialog.kt#d60tuo");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1977187923, i, -1, "com.myscript.nebo.freemium.FreemiumLimitationDialogPhoneLandscapePreview (FreemiumLimitationDialog.kt:338)");
            }
            FreemiumLimitationDialogState freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, false, 0, 0, 0, 31, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702054389, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702055445, "CC(remember):FreemiumLimitationDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FreemiumLimitationDialog(freemiumLimitationDialogState, function0, (Function0) objRememberedValue2, composerStartRestartGroup, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.FreemiumLimitationDialogPhoneLandscapePreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeDialog$lambda$1(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C86@3449L198,83@3341L306:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651250939, i, -1, "com.myscript.nebo.freemium.LargeDialog.<anonymous> (FreemiumLimitationDialog.kt:83)");
            }
            CardKt.m4173CardFjzlyU(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND)), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), 0L, 0L, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1278133634, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.LargeDialog$lambda$1$0(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572870, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactLandscapeDialog$lambda$1(final FreemiumLimitationDialogState freemiumLimitationDialogState, final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4107L206,102@3998L315:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-242326214, i, -1, "com.myscript.nebo.freemium.CompactLandscapeDialog.<anonymous> (FreemiumLimitationDialog.kt:102)");
            }
            CardKt.m4173CardFjzlyU(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), 0L, 0L, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1787807901, true, new Function2() { // from class: com.myscript.nebo.freemium.FreemiumLimitationDialogKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FreemiumLimitationDialogKt.CompactLandscapeDialog$lambda$1$0(freemiumLimitationDialogState, function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572870, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
