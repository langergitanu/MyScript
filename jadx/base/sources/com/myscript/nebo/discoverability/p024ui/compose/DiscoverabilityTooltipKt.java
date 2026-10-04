package com.myscript.nebo.discoverability.p024ui.compose;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.ShadowKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.PrimitiveResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.window.AndroidDialog_androidKt;
import androidx.compose.p004ui.window.AndroidPopup_androidKt;
import androidx.compose.p004ui.window.DialogProperties;
import androidx.compose.p004ui.window.PopupProperties;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.p019ui.compose.VideoKt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.discoverability.C6207R;
import com.myscript.nebo.discoverability.p024ui.TooltipIllustration;
import com.myscript.nebo.discoverability.p024ui.TooltipPosition;
import com.myscript.nebo.discoverability.p024ui.TooltipType;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: DiscoverabilityTooltip.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001a1\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a5\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u001a\u001a)\u0010\u001d\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a5\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010(\u001a#\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010(\u001a\u001f\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010.\u001a\u0017\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104\u001a\u0017\u00105\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002¢\u0006\u0004\b6\u00104\u001a6\u00107\u001a\u00020\u00012\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u00101\u001a\u0002022\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b;H\u0007¢\u0006\u0004\b<\u0010=\u001a6\u0010>\u001a\u00020\u00012\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u00101\u001a\u0002022\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b;H\u0007¢\u0006\u0004\b?\u0010=\u001a\r\u0010@\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010A¨\u0006B²\u0006\n\u0010C\u001a\u00020DX\u008a\u008e\u0002²\u0006\f\u0010E\u001a\u0004\u0018\u00010FX\u008a\u008e\u0002²\u0006\f\u0010G\u001a\u0004\u0018\u00010HX\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\f\u0010J\u001a\u0004\u0018\u00010KX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020MX\u008a\u0084\u0002"}, m1599d2 = {"DiscoverabilityTooltip", "", "state", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "targetRect", "Landroid/graphics/Rect;", "onTooltipDismissed", "Lkotlin/Function0;", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Landroid/graphics/Rect;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FloatingTooltip", "tooltipPositionProvider", "Lcom/myscript/nebo/discoverability/ui/compose/TooltipPositionProvider;", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Landroid/graphics/Rect;Lcom/myscript/nebo/discoverability/ui/compose/TooltipPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ModalTooltip", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TooltipContent", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "TooltipText", "title", "", "message", "modifier", "Landroidx/compose/ui/Modifier;", "(IILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TooltipTitle", "titleRes", "(ILandroidx/compose/runtime/Composer;I)V", "TooltipMessage", "messageRes", "TooltipCloseButton", "Landroidx/compose/foundation/layout/BoxScope;", "onClick", "(Landroidx/compose/foundation/layout/BoxScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TooltipIllustration", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;II)V", "CompactTooltipContent", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Landroidx/compose/runtime/Composer;I)V", "ModalTooltipContent", "LargeTooltipContent", "LottieIllustration", "tooltipIllustration", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$LottieJson;", "(Lcom/myscript/nebo/discoverability/ui/TooltipIllustration$LottieJson;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "lightColorPalette", "Landroidx/compose/material3/ColorScheme;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "lightColorPalette-8_81llA", "(J)Landroidx/compose/material3/ColorScheme;", "darkColorPalette", "darkColorPalette-8_81llA", "TooltipTheme", "darkTheme", "", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "TooltipTheme-3IgeMak", "(ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalTooltipTheme", "ModalTooltipTheme-3IgeMak", "DiscoverabilityTooltipDarkPreview", "(Landroidx/compose/runtime/Composer;I)V", "discoverability_release", "bubbleShape", "Lcom/myscript/nebo/discoverability/ui/compose/SpeechBubbleShape;", "tooltipBounds", "Landroidx/compose/ui/geometry/Rect;", "tooltipPosition", "Landroidx/compose/ui/geometry/Offset;", "updateCount", "preloaderLottieComposition", "Lcom/airbnb/lottie/LottieComposition;", "preloaderProgress", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DiscoverabilityTooltipKt {

    /* JADX INFO: compiled from: DiscoverabilityTooltip.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TooltipType.values().length];
            try {
                iArr[TooltipType.Modal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TooltipType.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TooltipType.Large.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactTooltipContent$lambda$1(TooltipUIState tooltipUIState, int i, Composer composer, int i2) throws FileNotFoundException {
        CompactTooltipContent(tooltipUIState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltip$lambda$0(TooltipUIState tooltipUIState, Rect rect, Function0 function0, int i, int i2, Composer composer, int i3) {
        DiscoverabilityTooltip(tooltipUIState, rect, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect DiscoverabilityTooltip$lambda$2$0$0(Rect rect) {
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltip$lambda$3(TooltipUIState tooltipUIState, Rect rect, Function0 function0, int i, int i2, Composer composer, int i3) {
        DiscoverabilityTooltip(tooltipUIState, rect, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect DiscoverabilityTooltipDarkPreview$lambda$0$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltipDarkPreview$lambda$2(int i, Composer composer, int i2) {
        DiscoverabilityTooltipDarkPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingTooltip$lambda$1(TooltipUIState tooltipUIState, Rect rect, TooltipPositionProvider tooltipPositionProvider, Function0 function0, int i, Composer composer, int i2) {
        FloatingTooltip(tooltipUIState, rect, tooltipPositionProvider, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeTooltipContent$lambda$1(TooltipUIState tooltipUIState, int i, Composer composer, int i2) throws FileNotFoundException {
        LargeTooltipContent(tooltipUIState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LottieIllustration$lambda$2(TooltipIllustration.LottieJson lottieJson, Modifier modifier, int i, int i2, Composer composer, int i3) throws FileNotFoundException {
        LottieIllustration(lottieJson, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalTooltip$lambda$1(TooltipUIState tooltipUIState, Function0 function0, int i, Composer composer, int i2) {
        ModalTooltip(tooltipUIState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalTooltipContent$lambda$1(TooltipUIState tooltipUIState, Function0 function0, int i, Composer composer, int i2) throws FileNotFoundException {
        ModalTooltipContent(tooltipUIState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalTooltipTheme_3IgeMak$lambda$0(boolean z, long j, Function2 function2, int i, int i2, Composer composer, int i3) {
        m12942ModalTooltipTheme3IgeMak(z, j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipCloseButton$lambda$1(BoxScope boxScope, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TooltipCloseButton(boxScope, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipContent$lambda$1(TooltipUIState tooltipUIState, Function0 function0, int i, int i2, Composer composer, int i3) throws FileNotFoundException {
        TooltipContent(tooltipUIState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipIllustration$lambda$0(TooltipUIState tooltipUIState, Modifier modifier, ColorFilter colorFilter, ContentScale contentScale, int i, int i2, Composer composer, int i3) throws FileNotFoundException {
        TooltipIllustration(tooltipUIState, modifier, colorFilter, contentScale, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipMessage$lambda$0(int i, int i2, Composer composer, int i3) {
        TooltipMessage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipText$lambda$1(int i, int i2, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        TooltipText(i, i2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipTheme_3IgeMak$lambda$0(boolean z, long j, Function2 function2, int i, int i2, Composer composer, int i3) {
        m12943TooltipTheme3IgeMak(z, j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipTitle$lambda$0(int i, int i2, Composer composer, int i3) {
        TooltipTitle(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void DiscoverabilityTooltip(final TooltipUIState tooltipUIState, Rect rect, final Function0<Unit> onTooltipDismissed, Composer composer, final int i, final int i2) {
        int i3;
        final Rect rect2;
        Intrinsics.checkNotNullParameter(onTooltipDismissed, "onTooltipDismissed");
        Composer composerStartRestartGroup = composer.startRestartGroup(301566689);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DiscoverabilityTooltip)N(state,targetRect,onTooltipDismissed):DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(tooltipUIState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(rect) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onTooltipDismissed) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            Rect rect3 = i4 != 0 ? null : rect;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(301566689, i3, -1, "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltip (DiscoverabilityTooltip.kt:80)");
            }
            if (tooltipUIState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Rect rect4 = rect3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DiscoverabilityTooltipKt.DiscoverabilityTooltip$lambda$0(tooltipUIState, rect4, onTooltipDismissed, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            final Rect rect5 = rect3;
            if (tooltipUIState.getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-1098153482);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (WhenMappings.$EnumSwitchMapping$0[tooltipUIState.getType().ordinal()] == 1) {
                    composerStartRestartGroup.startReplaceGroup(-1098120064);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "87@4036L79,87@4018L97");
                    m12942ModalTooltipTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(1752414737, true, new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DiscoverabilityTooltipKt.DiscoverabilityTooltip$lambda$1(tooltipUIState, onTooltipDismissed, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1097958709);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "92@4181L489,92@4168L502");
                    m12943TooltipTheme3IgeMak(false, 0L, ComposableLambdaKt.rememberComposableLambda(593552841, true, new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DiscoverabilityTooltipKt.DiscoverabilityTooltip$lambda$2(tooltipUIState, rect5, onTooltipDismissed, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1097429663);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            rect2 = rect5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            rect2 = rect;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.DiscoverabilityTooltip$lambda$3(tooltipUIState, rect2, onTooltipDismissed, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltip$lambda$1(TooltipUIState tooltipUIState, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C88@4058L39:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752414737, i, -1, "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltip.<anonymous> (DiscoverabilityTooltip.kt:88)");
            }
            ModalTooltip(tooltipUIState, function0, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltip$lambda$2(TooltipUIState tooltipUIState, final Rect rect, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@4378L7,96@4435L14,97@4512L10,97@4543L7,98@4573L79:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(593552841, i, -1, "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltip.<anonymous> (DiscoverabilityTooltip.kt:93)");
            }
            TooltipPosition toolTipPosition = tooltipUIState.getToolTipPosition();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, -826362025, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(rect);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DiscoverabilityTooltipKt.DiscoverabilityTooltip$lambda$2$0$0(rect);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composer, 6);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingTooltip(tooltipUIState, rect, new TooltipPositionProvider(toolTipPosition, density, (Function0) objRememberedValue, statusBars.getTop((Density) objConsume2)), function0, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void FloatingTooltip(final TooltipUIState tooltipUIState, final Rect rect, final TooltipPositionProvider tooltipPositionProvider, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1773457905);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingTooltip)N(state,targetRect,tooltipPositionProvider,onTooltipDismissed)114@5105L4278,107@4874L4509:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(tooltipUIState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rect) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(tooltipPositionProvider) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1773457905, i2, -1, "com.myscript.nebo.discoverability.ui.compose.FloatingTooltip (DiscoverabilityTooltip.kt:106)");
            }
            AndroidPopup_androidKt.Popup(tooltipPositionProvider, null, new PopupProperties(false, false, false, false, false, 24, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1637599341, true, new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.FloatingTooltip$lambda$0(rect, tooltipUIState, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 6) & 14) | 3456, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.FloatingTooltip$lambda$1(tooltipUIState, rect, tooltipPositionProvider, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit FloatingTooltip$lambda$0(Rect rect, TooltipUIState tooltipUIState, Function0 function0, Composer composer, int i) throws FileNotFoundException {
        final MutableState mutableState;
        Point point;
        ComposerKt.sourceInformation(composer, "C115@5131L61,118@5333L79,129@5968L69,130@6069L71,131@6168L33,134@6314L107,134@6287L134,140@6458L7,145@6635L54,147@6756L1257,143@6532L1701,175@8391L986,175@8331L1046:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1637599341, i, -1, "com.myscript.nebo.discoverability.ui.compose.FloatingTooltip.<anonymous> (DiscoverabilityTooltip.kt:115)");
            }
            float fDimensionResource = PrimitiveResources_androidKt.dimensionResource(C6207R.dimen.discoverability_tooltip_caret_size, composer, 0);
            if (rect != null) {
                Point point2 = !rect.isEmpty() ? new Point(rect.centerX(), rect.centerY()) : null;
                ComposerKt.sourceInformationMarkerStart(composer, -1774928990, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SpeechBubbleShape(0.0f, 0.0f, new Point(), null, 3, null), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                PaddingValues paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(fDimensionResource);
                ComposerKt.sourceInformationMarkerStart(composer, -1774908680, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState3 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1774905446, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1774902316, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1774897570, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue5 = composer.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function2) new DiscoverabilityTooltipKt$FloatingTooltip$1$1$1(mutableState3, mutableState4, mutableIntState, null);
                    composer.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(rect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer, 0);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                final float fMo2191toPx0680j_4 = ((Density) objConsume).mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(10));
                Modifier modifierClip = ClipKt.clip(BackgroundKt.m2016backgroundbw27NRU$default(ShadowKt.m7746shadows4CzXII$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(8), FloatingTooltip$lambda$0$3(mutableState2), false, 0L, 0L, 28, null), ColorResources_androidKt.colorResource(C6207R.color.discoverability_bottom_bg_color, composer, 0), null, 2, null), FloatingTooltip$lambda$0$3(mutableState2));
                ComposerKt.sourceInformationMarkerStart(composer, -1774882276, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                boolean zChanged = composer.changed(fMo2191toPx0680j_4);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    final int i2 = 3;
                    mutableState = mutableState3;
                    Object obj = new Function1() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DiscoverabilityTooltipKt.FloatingTooltip$lambda$0$16$0(i2, mutableState4, fMo2191toPx0680j_4, mutableState, mutableIntState, (LayoutCoordinates) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                    objRememberedValue6 = obj;
                } else {
                    mutableState = mutableState3;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierClip, (Function1) objRememberedValue6);
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnGloballyPositioned);
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
                ComposerKt.sourceInformationMarkerStart(composer, -1023646095, "C170@8038L41,171@8092L131:DiscoverabilityTooltip.kt#g50l23");
                TooltipContent(tooltipUIState, function0, composer, 0, 0);
                TooltipCloseButton(boxScopeInstance, function0, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, PaddingKt.calculateEndPadding(paddingValuesM2847PaddingValues0680j_4, LayoutDirection.Ltr), 0.0f, 11, null), composer, 6, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                androidx.compose.p004ui.geometry.Rect rectFloatingTooltip$lambda$0$6 = FloatingTooltip$lambda$0$6(mutableState);
                Offset offsetFloatingTooltip$lambda$0$9 = FloatingTooltip$lambda$0$9(mutableState4);
                ComposerKt.sourceInformationMarkerStart(composer, -1774830227, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(point2) | composer.changed(fDimensionResource);
                Object objRememberedValue7 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    point = point2;
                    objRememberedValue7 = (Function2) new DiscoverabilityTooltipKt$FloatingTooltip$1$4$1(mutableState, mutableState4, point2, fDimensionResource, mutableState2, null);
                    composer.updateRememberedValue(objRememberedValue7);
                } else {
                    point = point2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(rectFloatingTooltip$lambda$0$6, offsetFloatingTooltip$lambda$0$9, point, (Function2) objRememberedValue7, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final SpeechBubbleShape FloatingTooltip$lambda$0$3(MutableState<SpeechBubbleShape> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.p004ui.geometry.Rect FloatingTooltip$lambda$0$6(MutableState<androidx.compose.p004ui.geometry.Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset FloatingTooltip$lambda$0$9(MutableState<Offset> mutableState) {
        return mutableState.getValue();
    }

    private static final int FloatingTooltip$lambda$0$12(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit FloatingTooltip$lambda$0$16$0(int i, MutableState mutableState, float f, MutableState mutableState2, MutableIntState mutableIntState, LayoutCoordinates coordinates) {
        boolean z;
        androidx.compose.p004ui.geometry.Rect rectFloatingTooltip$lambda$0$6;
        Offset offsetFloatingTooltip$lambda$0$9;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        androidx.compose.p004ui.geometry.Rect rectBoundsInWindow$default = LayoutCoordinatesKt.boundsInWindow$default(coordinates, false, 1, null);
        long jPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(coordinates);
        if (FloatingTooltip$lambda$0$9(mutableState) == null || (offsetFloatingTooltip$lambda$0$9 = FloatingTooltip$lambda$0$9(mutableState)) == null) {
            z = true;
        } else {
            long jM7913unboximpl = offsetFloatingTooltip$lambda$0$9.m7913unboximpl();
            if (Math.abs(Float.intBitsToFloat((int) (jPositionOnScreen >> 32)) - Float.intBitsToFloat((int) (jM7913unboximpl >> 32))) <= f && Math.abs(Float.intBitsToFloat((int) (jPositionOnScreen & 4294967295L)) - Float.intBitsToFloat((int) (jM7913unboximpl & 4294967295L))) <= f) {
                z = false;
            }
        }
        boolean z2 = FloatingTooltip$lambda$0$6(mutableState2) == null || (rectFloatingTooltip$lambda$0$6 = FloatingTooltip$lambda$0$6(mutableState2)) == null || Math.abs((rectBoundsInWindow$default.getRight() - rectBoundsInWindow$default.getLeft()) - (rectFloatingTooltip$lambda$0$6.getRight() - rectFloatingTooltip$lambda$0$6.getLeft())) > f || Math.abs((rectBoundsInWindow$default.getBottom() - rectBoundsInWindow$default.getTop()) - (rectFloatingTooltip$lambda$0$6.getBottom() - rectFloatingTooltip$lambda$0$6.getTop())) > f;
        if ((z || z2) && FloatingTooltip$lambda$0$12(mutableIntState) < i) {
            mutableState2.setValue(rectBoundsInWindow$default);
            mutableState.setValue(Offset.m7892boximpl(jPositionOnScreen));
            mutableIntState.setIntValue(FloatingTooltip$lambda$0$12(mutableIntState) + 1);
        }
        return Unit.INSTANCE;
    }

    private static final void ModalTooltip(final TooltipUIState tooltipUIState, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function02;
        Composer composerStartRestartGroup = composer.startRestartGroup(470027361);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalTooltip)N(state,onTooltipDismissed)206@9643L228,203@9485L386:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(tooltipUIState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function02 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(470027361, i2, -1, "com.myscript.nebo.discoverability.ui.compose.ModalTooltip (DiscoverabilityTooltip.kt:202)");
            }
            function02 = function0;
            AndroidDialog_androidKt.Dialog(function02, new DialogProperties(false, false, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(956516522, true, new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.ModalTooltip$lambda$0(tooltipUIState, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.ModalTooltip$lambda$1(tooltipUIState, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalTooltip$lambda$0(final TooltipUIState tooltipUIState, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C208@9693L6,210@9764L101,207@9653L212:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(956516522, i, -1, "com.myscript.nebo.discoverability.ui.compose.ModalTooltip.<anonymous> (DiscoverabilityTooltip.kt:207)");
            }
            CardKt.Card(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(400)), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium(), null, null, null, ComposableLambdaKt.rememberComposableLambda(-1466159496, true, new Function3() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DiscoverabilityTooltipKt.ModalTooltip$lambda$0$0(tooltipUIState, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 196614, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalTooltip$lambda$0$0(TooltipUIState tooltipUIState, Function0 function0, ColumnScope Card, Composer composer, int i) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C211@9778L77:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1466159496, i, -1, "com.myscript.nebo.discoverability.ui.compose.ModalTooltip.<anonymous>.<anonymous> (DiscoverabilityTooltip.kt:211)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -109519672, "C212@9800L41:DiscoverabilityTooltip.kt#g50l23");
            TooltipContent(tooltipUIState, function0, composer, 0, 0);
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

    public static final void TooltipContent(final TooltipUIState state, final Function0<Unit> function0, Composer composer, final int i, final int i2) throws FileNotFoundException {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(819417921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipContent)N(state,onTooltipDismissed)219@9962L2:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481609315, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda11
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
                ComposerKt.traceEventStart(819417921, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipContent (DiscoverabilityTooltip.kt:219)");
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[state.getType().ordinal()];
            if (i5 == 2) {
                composerStartRestartGroup.startReplaceGroup(1481611229);
                ComposerKt.sourceInformation(composerStartRestartGroup, "221@10021L28");
                CompactTooltipContent(state, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i5 == 3) {
                composerStartRestartGroup.startReplaceGroup(1481613083);
                ComposerKt.sourceInformation(composerStartRestartGroup, "222@10079L26");
                LargeTooltipContent(state, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1481614479);
                ComposerKt.sourceInformation(composerStartRestartGroup, "223@10122L46");
                ModalTooltipContent(state, function0, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.TooltipContent$lambda$1(state, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TooltipText(final int i, final int i2, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-28355820);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipText)N(title,message,modifier)229@10299L133:DiscoverabilityTooltip.kt#g50l23");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i6 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-28355820, i5, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipText (DiscoverabilityTooltip.kt:228)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 83089702, "C230@10375L19,231@10403L23:DiscoverabilityTooltip.kt#g50l23");
            TooltipTitle(i, composerStartRestartGroup, i5 & 14);
            TooltipMessage(i2, composerStartRestartGroup, (i5 >> 3) & 14);
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
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.TooltipText$lambda$1(i, i2, modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TooltipTitle(final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1034340609);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipTitle)N(titleRes)238@10515L24,239@10571L11,240@10624L10,237@10494L196:DiscoverabilityTooltip.kt#g50l23");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1034340609, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipTitle (DiscoverabilityTooltip.kt:236)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i3 & 14), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composer2, 1572864, 0, 131002);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.TooltipTitle$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TooltipMessage(final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-515543822);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipMessage)N(messageRes)248@10777L26,249@10835L10,250@10888L11,247@10756L173:DiscoverabilityTooltip.kt#g50l23");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-515543822, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipMessage (DiscoverabilityTooltip.kt:246)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i3 & 14), null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.TooltipMessage$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TooltipCloseButton(final BoxScope boxScope, final Function0<Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(547945270);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipCloseButton)N(onClick,modifier)256@11059L47,258@11172L11,262@11314L13,255@11035L326:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(547945270, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipCloseButton (DiscoverabilityTooltip.kt:254)");
                }
                Painter painterPainterResource = PainterResources_androidKt.painterResource(C6183R.drawable.ic_close, composerStartRestartGroup, 0);
                long onSurface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface();
                Modifier modifierClip = ClipKt.clip(boxScope.align(modifier4, Alignment.INSTANCE.getTopEnd()), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1705561117, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
                boolean z = (i3 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DiscoverabilityTooltipKt.TooltipCloseButton$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m5163Iconww6aTOc(painterPainterResource, (String) null, PaddingKt.m2854padding3ABfNKs(ClickableKt.m2062clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null), C1486Dp.m11017constructorimpl(16)), onSurface, composerStartRestartGroup, Painter.$stable | 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DiscoverabilityTooltipKt.TooltipCloseButton$lambda$1(boxScope, onClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipCloseButton$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TooltipIllustration(final TooltipUIState state, Modifier modifier, ColorFilter colorFilter, ContentScale contentScale, Composer composer, final int i, final int i2) throws FileNotFoundException {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        ContentScale contentScale2;
        Composer composer2;
        final ColorFilter colorFilter2;
        final Modifier modifier3;
        final ContentScale contentScale3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ContentScale contentScale4;
        ColorFilter colorFilter3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(1572050051);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipIllustration)N(state,modifier,colorFilter,contentScale):DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i3 |= composerStartRestartGroup.changed(colorFilter) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        contentScale2 = contentScale;
                        i3 |= composerStartRestartGroup.changed(contentScale2) ? 2048 : 1024;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        colorFilter2 = colorFilter;
                        modifier3 = modifier2;
                        contentScale3 = contentScale2;
                    } else {
                        Modifier modifier5 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        ColorFilter colorFilter4 = i4 != 0 ? null : colorFilter;
                        ContentScale fit = i5 != 0 ? ContentScale.INSTANCE.getFit() : contentScale2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1572050051, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipIllustration (DiscoverabilityTooltip.kt:268)");
                        }
                        TooltipIllustration illustration = state.getIllustration();
                        if (illustration instanceof TooltipIllustration.DrawableIllustration) {
                            composerStartRestartGroup.startReplaceGroup(619947892);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "272@11678L52,271@11645L267");
                            int i7 = i3 << 3;
                            composer2 = composerStartRestartGroup;
                            ImageKt.Image(PainterResources_androidKt.painterResource(((TooltipIllustration.DrawableIllustration) illustration).getDrawableId(), composerStartRestartGroup, 0), (String) null, modifier5, (Alignment) null, fit, 0.0f, colorFilter4, composer2, Painter.$stable | 48 | (i7 & 896) | (i7 & 57344) | ((i3 << 12) & 3670016), 40);
                            contentScale4 = fit;
                            colorFilter3 = colorFilter4;
                            modifier4 = modifier5;
                            composer2.endReplaceGroup();
                        } else {
                            composer2 = composerStartRestartGroup;
                            contentScale4 = fit;
                            colorFilter3 = colorFilter4;
                            modifier4 = modifier5;
                            if (illustration instanceof TooltipIllustration.LottieJson) {
                                composer2.startReplaceGroup(620243446);
                                ComposerKt.sourceInformation(composer2, "281@11963L49");
                                LottieIllustration((TooltipIllustration.LottieJson) illustration, modifier4, composer2, i3 & 112, 0);
                                composer2.endReplaceGroup();
                            } else if (illustration instanceof TooltipIllustration.Video) {
                                composer2.startReplaceGroup(620364408);
                                ComposerKt.sourceInformation(composer2, "285@12131L7,286@12205L144");
                                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composer2.consume(localContext);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                VideoKt.Video(Uri.parse("android.resource://" + ((Context) objConsume).getPackageName() + DomExceptionUtils.SEPARATOR + ((TooltipIllustration.Video) illustration).getRawResId()), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), 1.7777778f, false, 2, null), true, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(-1088383078);
                                composer2.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        contentScale3 = contentScale4;
                        colorFilter2 = colorFilter3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DiscoverabilityTooltipKt.TooltipIllustration$lambda$0(state, modifier3, colorFilter2, contentScale3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                contentScale2 = contentScale;
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            contentScale2 = contentScale;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        contentScale2 = contentScale;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void CompactTooltipContent(final TooltipUIState state, Composer composer, final int i) throws FileNotFoundException {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1501658828);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CompactTooltipContent)N(state)295@12454L54,297@12514L558:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1501658828, i2, -1, "com.myscript.nebo.discoverability.ui.compose.CompactTooltipContent (DiscoverabilityTooltip.kt:294)");
            }
            float f = 24;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, ColorResources_androidKt.colorResource(C6207R.color.discoverability_bottom_bg_color, composerStartRestartGroup, 0), null, 2, null), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2855paddingVpY3zN4);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646060080, "C307@12951L11,303@12751L232,310@12993L73:DiscoverabilityTooltip.kt#g50l23");
            float f2 = 44;
            TooltipIllustration(state, SizeKt.m2929width3ABfNKs(SizeKt.m2911heightInVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(TextFieldImplKt.AnimationDuration)), C1486Dp.m11017constructorimpl(f2)), ColorFilter.Companion.m8189tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0, 2, null), null, composerStartRestartGroup, (i2 & 14) | 48, 8);
            TooltipText(state.getTitle(), state.getMessage(), null, composerStartRestartGroup, 0, 4);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.CompactTooltipContent$lambda$1(state, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ModalTooltipContent(TooltipUIState state, Function0<Unit> onTooltipDismissed, Composer composer, final int i) throws FileNotFoundException {
        int i2;
        final TooltipUIState tooltipUIState;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onTooltipDismissed, "onTooltipDismissed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1215680014);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalTooltipContent)N(state,onTooltipDismissed)320@13174L467:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onTooltipDismissed) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            tooltipUIState = state;
            function0 = onTooltipDismissed;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1215680014, i3, -1, "com.myscript.nebo.discoverability.ui.compose.ModalTooltipContent (DiscoverabilityTooltip.kt:318)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1687567340, "C321@13188L379,332@13576L59:DiscoverabilityTooltip.kt#g50l23");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1191256505, "C322@13209L101,328@13487L11,324@13324L233:DiscoverabilityTooltip.kt#g50l23");
            TooltipIllustration(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, ContentScale.INSTANCE.getFillWidth(), composerStartRestartGroup, (i3 & 14) | 3120, 4);
            tooltipUIState = state;
            TooltipText(tooltipUIState.getTitle(), tooltipUIState.getMessage(), PaddingKt.m2854padding3ABfNKs(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), null, 2, null), C1486Dp.m11017constructorimpl(24)), composerStartRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function0 = onTooltipDismissed;
            TooltipCloseButton(boxScopeInstance, function0, Modifier.INSTANCE, composerStartRestartGroup, 390 | (i3 & 112), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.ModalTooltipContent$lambda$1(tooltipUIState, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void LargeTooltipContent(final TooltipUIState state, Composer composer, final int i) throws FileNotFoundException {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(870721484);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LargeTooltipContent)N(state)338@13710L476:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(870721484, i2, -1, "com.myscript.nebo.discoverability.ui.compose.LargeTooltipContent (DiscoverabilityTooltip.kt:337)");
            }
            Modifier modifierM2929width3ABfNKs = SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(PDFACompliance.e_PDFA3_5_6));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2929width3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456973953, "C339@13748L432:DiscoverabilityTooltip.kt#g50l23");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1281769738, "C341@13867L11,340@13769L229,345@14012L158:DiscoverabilityTooltip.kt#g50l23");
            TooltipIllustration(state, SizeKt.m2912heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), null, 2, null), 0.0f, 1, null), C1486Dp.m11017constructorimpl(50), 0.0f, 2, null), null, ContentScale.INSTANCE.getFillWidth(), composerStartRestartGroup, (i2 & 14) | 3072, 4);
            TooltipText(state.getTitle(), state.getMessage(), PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.LargeTooltipContent$lambda$1(state, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LottieIllustration(final TooltipIllustration.LottieJson tooltipIllustration, Modifier modifier, Composer composer, final int i, final int i2) throws FileNotFoundException {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(tooltipIllustration, "tooltipIllustration");
        Composer composerStartRestartGroup = composer.startRestartGroup(1740610682);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LottieIllustration)N(tooltipIllustration,modifier)358@14330L100,362@14452L61,381@14884L181,388@15071L206:DiscoverabilityTooltip.kt#g50l23");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(tooltipIllustration) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1740610682, i3, -1, "com.myscript.nebo.discoverability.ui.compose.LottieIllustration (DiscoverabilityTooltip.kt:356)");
                }
                modifier3 = companion;
                LottieCompositionResult lottieCompositionResultRememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.Asset.m12393boximpl(LottieCompositionSpec.Asset.m12394constructorimpl(tooltipIllustration.getJsonString())), null, null, null, null, null, composerStartRestartGroup, 0, 62);
                LottieAnimationKt.LottieAnimation(LottieIllustration$lambda$0(lottieCompositionResultRememberLottieComposition), LottieIllustration$lambda$1(AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(LottieIllustration$lambda$0(lottieCompositionResultRememberLottieComposition), true, false, false, new LottieClipSpec.Frame(0, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_DTS_UHD), false, 4, null), 0.0f, Integer.MAX_VALUE, null, false, false, composerStartRestartGroup, (LottieClipSpec.Frame.$stable << 12) | 1572912, 940)), PaddingKt.m2854padding3ABfNKs(SizeKt.m2912heightInVpY3zN4$default(modifier3, 0.0f, C1486Dp.m11017constructorimpl(TextFieldImplKt.AnimationDuration), 1, null), PrimitiveResources_androidKt.dimensionResource(C6207R.dimen.discoverability_tooltip_caret_size, composerStartRestartGroup, 0)), false, false, false, false, null, false, null, null, null, false, false, null, composerStartRestartGroup, 0, 0, 32760);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DiscoverabilityTooltipKt.LottieIllustration$lambda$2(tooltipIllustration, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final LottieComposition LottieIllustration$lambda$0(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    private static final float LottieIllustration$lambda$1(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX INFO: renamed from: lightColorPalette-8_81llA, reason: not valid java name */
    private static final ColorScheme m12945lightColorPalette8_81llA(long j) {
        return ColorSchemeKt.m4844lightColorScheme_VG5OTI$default(j, 0L, 0L, 0L, 0L, ColorKt.Color(4284440415L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.Color(4278211411L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -32802, 65535, null);
    }

    /* JADX INFO: renamed from: darkColorPalette-8_81llA, reason: not valid java name */
    private static final ColorScheme m12944darkColorPalette8_81llA(long j) {
        return ColorSchemeKt.m4838darkColorScheme_VG5OTI$default(j, 0L, 0L, 0L, 0L, ColorKt.Color(4284440415L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.Color(4283650899L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -32802, 65535, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: TooltipTheme-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m12943TooltipTheme3IgeMak(boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final boolean zIsSystemInDarkTheme;
        int i3;
        long neBlue;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ColorScheme colorSchemeM12944darkColorPalette8_81llA;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-100877631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipTheme)N(darkTheme,tintColor:c#ui.graphics.Color,content)423@16017L6,421@15941L156:DiscoverabilityTooltip.kt#g50l23");
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
        if (i5 == 0) {
            if ((i & 48) == 0) {
                neBlue = j;
                i3 |= composerStartRestartGroup.changed(neBlue) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "410@15669L21");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 1) != 0) {
                        zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                        i3 &= -15;
                    }
                    if (i5 != 0) {
                        neBlue = ColorsKt.getNeBlue();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 1) != 0) {
                        i3 &= -15;
                    }
                }
                long j3 = neBlue;
                boolean z2 = zIsSystemInDarkTheme;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-100877631, i3, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipTheme (DiscoverabilityTooltip.kt:412)");
                }
                if (z2) {
                    colorSchemeM12944darkColorPalette8_81llA = m12945lightColorPalette8_81llA(j3);
                } else {
                    colorSchemeM12944darkColorPalette8_81llA = m12944darkColorPalette8_81llA(j3);
                }
                MaterialThemeKt.MaterialTheme(colorSchemeM12944darkColorPalette8_81llA, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable), null, null, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), null, null, 27, null), null, content, composerStartRestartGroup, (i3 << 3) & 7168, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                zIsSystemInDarkTheme = z2;
                j2 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j2 = neBlue;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DiscoverabilityTooltipKt.TooltipTheme_3IgeMak$lambda$0(zIsSystemInDarkTheme, j2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        neBlue = j;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ModalTooltipTheme-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m12942ModalTooltipTheme3IgeMak(boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        final boolean zIsSystemInDarkTheme;
        int i3;
        long neBlue;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ColorScheme colorSchemeM4844lightColorScheme_VG5OTI$default;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-22797584);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalTooltipTheme)N(darkTheme,tintColor:c#ui.graphics.Color,content)447@16634L6,445@16558L156:DiscoverabilityTooltip.kt#g50l23");
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
        if (i5 == 0) {
            if ((i & 48) == 0) {
                neBlue = j;
                i3 |= composerStartRestartGroup.changed(neBlue) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "429@16156L21");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 1) != 0) {
                        zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                        i3 &= -15;
                    }
                    if (i5 != 0) {
                        neBlue = ColorsKt.getNeBlue();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 1) != 0) {
                        i3 &= -15;
                    }
                }
                long j3 = neBlue;
                boolean z2 = zIsSystemInDarkTheme;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-22797584, i3, -1, "com.myscript.nebo.discoverability.ui.compose.ModalTooltipTheme (DiscoverabilityTooltip.kt:431)");
                }
                if (z2) {
                    colorSchemeM4844lightColorScheme_VG5OTI$default = ColorSchemeKt.m4838darkColorScheme_VG5OTI$default(j3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.Color(4284440415L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -32770, 65535, null);
                } else {
                    colorSchemeM4844lightColorScheme_VG5OTI$default = ColorSchemeKt.m4844lightColorScheme_VG5OTI$default(j3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -32770, 65535, null);
                }
                MaterialThemeKt.MaterialTheme(colorSchemeM4844lightColorScheme_VG5OTI$default, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable), null, null, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(16)), null, null, 27, null), null, content, composerStartRestartGroup, (i3 << 3) & 7168, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                zIsSystemInDarkTheme = z2;
                j2 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j2 = neBlue;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DiscoverabilityTooltipKt.ModalTooltipTheme_3IgeMak$lambda$0(zIsSystemInDarkTheme, j2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        neBlue = j;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final void DiscoverabilityTooltipDarkPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1274440059);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DiscoverabilityTooltipDarkPreview)457@16958L7,458@16995L8,459@17046L10,459@17077L7,460@17122L531,460@17091L562:DiscoverabilityTooltip.kt#g50l23");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1274440059, i, -1, "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipDarkPreview (DiscoverabilityTooltip.kt:454)");
            }
            TooltipPosition tooltipPosition = TooltipPosition.Auto;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671210387, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DiscoverabilityTooltipKt.DiscoverabilityTooltipDarkPreview$lambda$0$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final TooltipPositionProvider tooltipPositionProvider = new TooltipPositionProvider(tooltipPosition, density, (Function0) objRememberedValue, statusBars.getTop((Density) objConsume2));
            m12943TooltipTheme3IgeMak(true, 0L, ComposableLambdaKt.rememberComposableLambda(-649025126, true, new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.DiscoverabilityTooltipDarkPreview$lambda$1(tooltipPositionProvider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DiscoverabilityTooltipKt.DiscoverabilityTooltipDarkPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscoverabilityTooltipDarkPreview$lambda$1(TooltipPositionProvider tooltipPositionProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C472@17635L2,461@17132L515:DiscoverabilityTooltip.kt#g50l23");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649025126, i, -1, "com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipDarkPreview.<anonymous> (DiscoverabilityTooltip.kt:461)");
            }
            TooltipUIState tooltipUIState = new TooltipUIState(C6207R.string.tooltip_preview_title, C6207R.string.tooltip_preview_message, new TooltipIllustration.DrawableIllustration(C6014R.drawable.ic_notif), -1, TooltipType.Small, true, null, null, PsExtractor.AUDIO_STREAM, null);
            ComposerKt.sourceInformationMarkerStart(composer, -942871748, "CC(remember):DiscoverabilityTooltip.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.discoverability.ui.compose.DiscoverabilityTooltipKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingTooltip(tooltipUIState, null, tooltipPositionProvider, (Function0) objRememberedValue, composer, 3120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
