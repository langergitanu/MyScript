package com.myscript.nebo.p034ui.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.ScaleKt;
import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
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
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.C6079R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OnboardingPager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\r\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001aI\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010$\u001a\r\u0010%\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010$\"\u000e\u0010&\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020'X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006,²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020'X\u008a\u0084\u0002"}, m1599d2 = {"OnboardingLargeScreenLandscapePager", "", "pages", "", "Lcom/myscript/nebo/ui/compose/OnboardingPages;", "modifier", "Landroidx/compose/ui/Modifier;", "onCurrentPageChanged", "Lkotlin/Function1;", "", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "OnboardingLargeScreenPortraitPager", "OnboardingCompactScreenPortraitPager", "OnboardingCompactScreenLandscapePager", "OnboardingPageTitle", "text", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OnboardingPageDescription", "OnboardingPagerIndicator", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "activeColor", "Landroidx/compose/ui/graphics/Color;", "inactiveColor", "dotSize", "Landroidx/compose/ui/unit/Dp;", "spacing", "OnboardingPagerIndicator-64B7Zus", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;JJFFLandroidx/compose/runtime/Composer;II)V", "AutoScrollEffect", "autoScrollDelay", "", "autoScrollDuration", "(Landroidx/compose/foundation/pager/PagerState;JILandroidx/compose/runtime/Composer;II)V", "OnboardingLargeScreenPortraitPagerPreview", "(Landroidx/compose/runtime/Composer;I)V", "OnboardingCompactScreenPortraitPagerPreview", "LAYER_1_SPEED", "", "LAYER_2_SPEED", "LAYER_3_SPEED", "AUTO_SCROLL_DELAY_MS", "AUTO_SCROLL_DURATION_MS", "app_standardRelease", "popped", "", "popAnimationFraction"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OnboardingPagerKt {
    private static final long AUTO_SCROLL_DELAY_MS = 6000;
    private static final int AUTO_SCROLL_DURATION_MS = 800;
    public static final float LAYER_1_SPEED = 1.0f;
    public static final float LAYER_2_SPEED = 0.6f;
    public static final float LAYER_3_SPEED = 0.3f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoScrollEffect$lambda$1(PagerState pagerState, long j, int i, int i2, int i3, Composer composer, int i4) {
        AutoScrollEffect(pagerState, j, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$9(List list, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OnboardingCompactScreenLandscapePager(list, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$9(List list, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OnboardingCompactScreenPortraitPager(list, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPagerPreview$lambda$0(int i, Composer composer, int i2) {
        OnboardingCompactScreenPortraitPagerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$9(List list, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OnboardingLargeScreenLandscapePager(list, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$9(List list, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OnboardingLargeScreenPortraitPager(list, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPagerPreview$lambda$0(int i, Composer composer, int i2) {
        OnboardingLargeScreenPortraitPagerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPageDescription$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OnboardingPageDescription(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPageTitle$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OnboardingPageTitle(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPagerIndicator_64B7Zus$lambda$1(PagerState pagerState, Modifier modifier, long j, long j2, float f, float f2, int i, int i2, Composer composer, int i3) {
        m13480OnboardingPagerIndicator64B7Zus(pagerState, modifier, j, j2, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingLargeScreenLandscapePager(final List<OnboardingPages> pages, Modifier modifier, Function1<? super Integer, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super Integer, Unit> function12;
        final Modifier modifier3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super Integer, Unit> function14;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Composer composerStartRestartGroup = composer.startRestartGroup(91288636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingLargeScreenLandscapePager)N(pages,modifier,onCurrentPageChanged)65@2846L2,67@2905L14,67@2874L46,68@2925L28,70@2998L60,70@2959L99,73@3077L34,74@3144L200,78@3350L4272,172@7649L29,172@7628L50:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(pages) ? 4 : 2) | i;
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
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function13 = function12;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829038142, "CC(remember):OnboardingPager.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$0$0(((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function14 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function14 = function12;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(91288636, i3, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenLandscapePager (OnboardingPager.kt:66)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829040042, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(pages.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super Integer, Unit> function15 = function14;
                    final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 3);
                    Modifier modifier5 = modifier4;
                    AutoScrollEffect(pagerStateRememberPagerState, 0L, 0, composerStartRestartGroup, 0, 6);
                    Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829043064, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChanged = ((i3 & 896) == 256) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
                    OnboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1 onboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || onboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1RememberedValue = new OnboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1(function15, pagerStateRememberPagerState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingLargeScreenLandscapePager$2$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829045566, "CC(remember):OnboardingPager.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(OnboardingLargeScreenLandscapePager$lambda$4(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.spring$default(0.75f, 200.0f, null, 4, null), 0.0f, "first pop animation", null, composerStartRestartGroup, 3120, 20);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505707357, "C85@3599L27,91@3829L3673,83@3532L3970,166@7512L104:OnboardingPager.kt#h09ego");
                    Modifier modifierAlpha = AlphaKt.alpha(ScaleKt.scale(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), OnboardingLargeScreenLandscapePager$lambda$6(stateAnimateFloatAsState)), OnboardingLargeScreenLandscapePager$lambda$6(stateAnimateFloatAsState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1156947949, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$0$0(pages, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, modifierAlpha, null, null, 1, 0.0f, null, null, false, false, (Function1) objRememberedValue4, null, null, null, ComposableLambdaKt.rememberComposableLambda(58989107, true, new Function4() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1(pages, pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 24576, 15340);
                    m13480OnboardingPagerIndicator64B7Zus(pagerStateRememberPagerState, Modifier.INSTANCE, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, 48, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1829191865, "CC(remember):OnboardingPager.kt#9igjgp");
                    OnboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1 onboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (onboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1RememberedValue = new OnboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1(mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingLargeScreenLandscapePager$4$1RememberedValue, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function15;
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$9(pages, modifier3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final boolean OnboardingLargeScreenLandscapePager$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingLargeScreenLandscapePager$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OnboardingLargeScreenLandscapePager$lambda$7$0$0(List list, int i) {
        return Integer.valueOf(((OnboardingPages) list.get(i)).getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1(List list, final PagerState pagerState, PagerScope HorizontalPager, final int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)92@3856L3636:OnboardingPager.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(58989107, i2, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenLandscapePager.<anonymous>.<anonymous> (OnboardingPager.kt:92)");
        }
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1762547846, "C97@4066L2151,140@6235L1243:OnboardingPager.kt#h09ego");
        Alignment center = Alignment.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1514432478, "C99@4170L57,102@4367L444,98@4129L704,113@4896L57,116@5093L383,112@4855L643,126@5561L57,129@5758L419,125@5520L679:OnboardingPager.kt#h09ego");
        Painter painterPainterResource = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer1(), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 603047979, "CC(remember):OnboardingPager.kt#9igjgp");
        int i3 = (i2 & 112) ^ 48;
        boolean zChanged = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        Painter painterPainterResource2 = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer2(), composer, 0);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 603071150, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged2 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource2, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) objRememberedValue2), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        Painter painterPainterResource3 = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer3(), composer, 0);
        Modifier.Companion companion4 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 603092466, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged3 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$2$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource3, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion4, (Function1) objRememberedValue3), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Arrangement.Vertical verticalM2534spacedByD5KLDUw = Arrangement.Absolute.INSTANCE.m2534spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierM2931widthInVpY3zN4$default = SizeKt.m2931widthInVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1486Dp.m11017constructorimpl(600), 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2534spacedByD5KLDUw, centerHorizontally2, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM2931widthInVpY3zN4$default);
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1731126052, "C146@6584L46,147@6690L227,145@6532L407,154@7019L52,157@7211L227,153@6961L499:OnboardingPager.kt#h09ego");
        String strStringResource = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getTitleRes(), composer, 0);
        Modifier.Companion companion5 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -775436862, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged4 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1$0$1$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageTitle(strStringResource, GraphicsLayerModifierKt.graphicsLayer(companion5, (Function1) objRememberedValue4), composer, 0, 0);
        String strStringResource2 = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getDescriptionRes(), composer, 0);
        Modifier modifierM2931widthInVpY3zN4$default2 = SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(280), 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, -775420190, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged5 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenLandscapePager$lambda$7$1$0$1$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageDescription(strStringResource2, GraphicsLayerModifierKt.graphicsLayer(modifierM2931widthInVpY3zN4$default2, (Function1) objRememberedValue5), composer, 0, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 1.0f);
        graphicsLayer.setAlpha(1.0f - Math.abs(currentPage));
        graphicsLayer.setScaleX(1.0f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(1.0f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 0.6f);
        graphicsLayer.setScaleX(1.0f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(1.0f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1$0$0$2$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 0.3f);
        graphicsLayer.setScaleX(1.0f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(1.0f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1$0$1$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscapePager$lambda$7$1$0$1$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingLargeScreenPortraitPager(final List<OnboardingPages> pages, Modifier modifier, Function1<? super Integer, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super Integer, Unit> function12;
        final Modifier modifier3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super Integer, Unit> function14;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Composer composerStartRestartGroup = composer.startRestartGroup(-734007200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingLargeScreenPortraitPager)N(pages,modifier,onCurrentPageChanged)181@7845L2,183@7904L14,183@7873L46,184@7924L28,186@7997L60,186@7958L99,189@8076L34,190@8143L200,194@8349L4276,292@12652L29,292@12631L50:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(pages) ? 4 : 2) | i;
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
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function13 = function12;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1006277822, "CC(remember):OnboardingPager.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$0$0(((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function14 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function14 = function12;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-734007200, i3, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenPortraitPager (OnboardingPager.kt:182)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1006275922, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(pages.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super Integer, Unit> function15 = function14;
                    final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 3);
                    Modifier modifier5 = modifier4;
                    AutoScrollEffect(pagerStateRememberPagerState, 0L, 0, composerStartRestartGroup, 0, 6);
                    Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1006272900, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChanged = ((i3 & 896) == 256) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
                    OnboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1 onboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || onboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1RememberedValue = new OnboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1(function15, pagerStateRememberPagerState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingLargeScreenPortraitPager$2$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1006270398, "CC(remember):OnboardingPager.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(OnboardingLargeScreenPortraitPager$lambda$4(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.spring$default(0.75f, 200.0f, null, 4, null), 0.0f, "first pop animation", null, composerStartRestartGroup, 3120, 20);
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(modifier5, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(4), 7, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1801942183, "C202@8622L27,209@8896L3609,200@8555L3950,286@12515L104:OnboardingPager.kt#h09ego");
                    Modifier modifierAlpha = AlphaKt.alpha(ScaleKt.scale(SizeKt.m2912heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1486Dp.m11017constructorimpl(AUTO_SCROLL_DURATION_MS), 1, null), OnboardingLargeScreenPortraitPager$lambda$6(stateAnimateFloatAsState)), OnboardingLargeScreenPortraitPager$lambda$6(stateAnimateFloatAsState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1327344261, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$0$0(pages, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, modifierAlpha, null, null, 1, 0.0f, null, null, false, false, (Function1) objRememberedValue4, null, null, null, ComposableLambdaKt.rememberComposableLambda(650424201, true, new Function4() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1(pages, pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 24576, 15340);
                    m13480OnboardingPagerIndicator64B7Zus(pagerStateRememberPagerState, Modifier.INSTANCE, 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, 48, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1006123971, "CC(remember):OnboardingPager.kt#9igjgp");
                    OnboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1 onboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (onboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1RememberedValue = new OnboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1(mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingLargeScreenPortraitPager$4$1RememberedValue, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function13 = function15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$9(pages, modifier3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final boolean OnboardingLargeScreenPortraitPager$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingLargeScreenPortraitPager$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OnboardingLargeScreenPortraitPager$lambda$7$0$0(List list, int i) {
        return Integer.valueOf(((OnboardingPages) list.get(i)).getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1(List list, final PagerState pagerState, PagerScope HorizontalPager, final int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)210@8923L3572:OnboardingPager.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(650424201, i2, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenPortraitPager.<anonymous>.<anonymous> (OnboardingPager.kt:210)");
        }
        Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceAround, centerHorizontally, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 284538728, "C216@9145L2171,262@11334L1147:OnboardingPager.kt#h09ego");
        float f = 64;
        Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 0.0f, 8, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM2858paddingqDBjuR0$default);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1939067875, "C218@9272L57,222@9470L442,217@9231L703,233@9997L57,237@10195L381,232@9956L642,247@10661L57,251@10859L417,246@10620L678:OnboardingPager.kt#h09ego");
        Painter painterPainterResource = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer1(), composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -491632729, "CC(remember):OnboardingPager.kt#9igjgp");
        int i3 = (i2 & 112) ^ 48;
        boolean zChanged = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        Painter painterPainterResource2 = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer2(), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -491609590, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged2 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource2, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue2), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        Painter painterPainterResource3 = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer3(), composer, 0);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -491588306, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged3 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$2$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource3, (String) null, GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) objRememberedValue3), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Arrangement.Vertical verticalM2534spacedByD5KLDUw = Arrangement.Absolute.INSTANCE.m2534spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierM2931widthInVpY3zN4$default = SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(360), 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2534spacedByD5KLDUw, centerHorizontally2, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM2931widthInVpY3zN4$default);
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 560548022, "C268@11667L46,269@11773L227,267@11615L407,276@12102L52,277@12214L227,275@12044L419:OnboardingPager.kt#h09ego");
        String strStringResource = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getTitleRes(), composer, 0);
        Modifier.Companion companion4 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1228839360, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged4 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1$0$1$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageTitle(strStringResource, GraphicsLayerModifierKt.graphicsLayer(companion4, (Function1) objRememberedValue4), composer, 0, 0);
        String strStringResource2 = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getDescriptionRes(), composer, 0);
        Modifier.Companion companion5 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1228825248, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged5 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPager$lambda$7$1$0$1$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageDescription(strStringResource2, GraphicsLayerModifierKt.graphicsLayer(companion5, (Function1) objRememberedValue5), composer, 0, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 1.0f);
        graphicsLayer.setAlpha(1.0f - Math.abs(currentPage));
        float f = 1;
        graphicsLayer.setScaleX(f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 0.6f);
        float f = 1;
        graphicsLayer.setScaleX(f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1$0$0$2$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 0.3f);
        float f = 1;
        graphicsLayer.setScaleX(f - (Math.abs(currentPage) * 0.5f));
        graphicsLayer.setScaleY(f - (Math.abs(currentPage) * 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1$0$1$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortraitPager$lambda$7$1$0$1$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingCompactScreenPortraitPager(final List<OnboardingPages> pages, Modifier modifier, Function1<? super Integer, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super Integer, Unit> function12;
        final Modifier modifier3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super Integer, Unit> function14;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1672253640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingCompactScreenPortraitPager)N(pages,modifier,onCurrentPageChanged)301@12850L2,303@12909L14,303@12878L46,304@12929L28,306@13002L60,306@12963L99,309@13081L34,310@13148L200,314@13354L2860,380@16241L29,380@16220L50:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(pages) ? 4 : 2) | i;
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
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function13 = function12;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -717974438, "CC(remember):OnboardingPager.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$0$0(((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function14 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function14 = function12;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1672253640, i3, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenPortraitPager (OnboardingPager.kt:302)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -717972538, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(pages.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super Integer, Unit> function15 = function14;
                    final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 3);
                    Modifier modifier5 = modifier4;
                    AutoScrollEffect(pagerStateRememberPagerState, 0L, 0, composerStartRestartGroup, 0, 6);
                    Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -717969516, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChanged = ((i3 & 896) == 256) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
                    OnboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1 onboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || onboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1RememberedValue = new OnboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1(function15, pagerStateRememberPagerState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingCompactScreenPortraitPager$2$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -717967014, "CC(remember):OnboardingPager.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(OnboardingCompactScreenPortraitPager$lambda$4(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.spring$default(0.75f, 200.0f, null, 4, null), 0.0f, "first pop animation", null, composerStartRestartGroup, 3120, 20);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1881238851, "C321@13589L27,328@13866L2214,319@13522L2558,374@16090L118:OnboardingPager.kt#h09ego");
                    Alignment.Vertical top = Alignment.INSTANCE.getTop();
                    Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, AlphaKt.alpha(ScaleKt.scale(Modifier.INSTANCE, OnboardingCompactScreenPortraitPager$lambda$6(stateAnimateFloatAsState)), OnboardingCompactScreenPortraitPager$lambda$6(stateAnimateFloatAsState)), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -77862723, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$7$0$0(pages, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, modifierWeight$default, null, null, 1, 0.0f, top, null, false, false, (Function1) objRememberedValue4, null, null, null, ComposableLambdaKt.rememberComposableLambda(1621428257, true, new Function4() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$7$1(pages, pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 1597440, 24576, 15276);
                    m13480OnboardingPagerIndicator64B7Zus(pagerStateRememberPagerState, PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(4)), 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, 48, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -717865899, "CC(remember):OnboardingPager.kt#9igjgp");
                    OnboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1 onboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (onboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1RememberedValue = new OnboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1(mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingCompactScreenPortraitPager$4$1RememberedValue, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function15;
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$9(pages, modifier3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final boolean OnboardingCompactScreenPortraitPager$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingCompactScreenPortraitPager$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OnboardingCompactScreenPortraitPager$lambda$7$0$0(List list, int i) {
        return Integer.valueOf(((OnboardingPages) list.get(i)).getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$7$1(List list, final PagerState pagerState, PagerScope HorizontalPager, final int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)329@13893L2177:OnboardingPager.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1621428257, i2, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenPortraitPager.<anonymous>.<anonymous> (OnboardingPager.kt:329)");
        }
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierFillMaxSize = SizeKt.fillMaxSize(Modifier.INSTANCE, 1.0f);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize);
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
        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1253716166, "C337@14201L57,342@14472L289,334@14054L815,350@14887L1169:OnboardingPager.kt#h09ego");
        ContentScale crop = ContentScale.INSTANCE.getCrop();
        Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
        Painter painterPainterResource = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer1(), composer, 0);
        Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.66f);
        ComposerKt.sourceInformationMarkerStart(composer, 179001452, "CC(remember):OnboardingPager.kt#9igjgp");
        int i3 = (i2 & 112) ^ 48;
        boolean zChanged = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$7$1$0$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f = 36;
        ImageKt.Image(painterPainterResource, (String) null, ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxHeight, (Function1) objRememberedValue), RoundedCornerShapeKt.m3237RoundedCornerShapea9UjIt4$default(0.0f, 0.0f, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 3, null)), bottomCenter, crop, 0.0f, (ColorFilter) null, composer, Painter.$stable | 27696, 96);
        Arrangement.Vertical verticalM2534spacedByD5KLDUw = Arrangement.Absolute.INSTANCE.m2534spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(24), 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2534spacedByD5KLDUw, centerHorizontally2, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM2856paddingVpY3zN4$default);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 281902622, "C356@15242L46,357@15348L227,355@15190L407,364@15677L52,365@15789L227,363@15619L419:OnboardingPager.kt#h09ego");
        String strStringResource = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getTitleRes(), composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 147645400, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged2 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$7$1$0$1$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageTitle(strStringResource, GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue2), composer, 0, 0);
        String strStringResource2 = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getDescriptionRes(), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 147659512, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged3 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenPortraitPager$lambda$7$1$0$1$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageDescription(strStringResource2, GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue3), composer, 0, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$7$1$0$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 1.0f);
        graphicsLayer.setAlpha(1.0f - Math.abs(currentPage));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$7$1$0$1$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortraitPager$lambda$7$1$0$1$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingCompactScreenLandscapePager(final List<OnboardingPages> pages, Modifier modifier, Function1<? super Integer, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super Integer, Unit> function12;
        final Modifier modifier3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super Integer, Unit> function14;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Composer composerStartRestartGroup = composer.startRestartGroup(1070420068);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingCompactScreenLandscapePager)N(pages,modifier,onCurrentPageChanged)389@16440L2,391@16499L14,391@16468L46,392@16519L28,394@16592L60,394@16553L99,397@16671L34,398@16738L200,402@16944L2595,466@19567L29,466@19546L50:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(pages) ? 4 : 2) | i;
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
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function12 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function13 = function12;
                } else {
                    Modifier modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118460762, "CC(remember):OnboardingPager.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$0$0(((Integer) obj).intValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function14 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function14 = function12;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1070420068, i3, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenLandscapePager (OnboardingPager.kt:390)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118458862, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(pages.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super Integer, Unit> function15 = function14;
                    final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 3);
                    Modifier modifier5 = modifier4;
                    AutoScrollEffect(pagerStateRememberPagerState, 0L, 0, composerStartRestartGroup, 0, 6);
                    Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118455840, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChanged = ((i3 & 896) == 256) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
                    OnboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1 onboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || onboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1RememberedValue = new OnboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1(function15, pagerStateRememberPagerState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingCompactScreenLandscapePager$2$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118453338, "CC(remember):OnboardingPager.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(OnboardingCompactScreenLandscapePager$lambda$4(mutableState) ? 1.0f : 0.0f, AnimationSpecKt.spring$default(0.75f, 200.0f, null, 4, null), 0.0f, "first pop animation", null, composerStartRestartGroup, 3120, 20);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1011934570, "C405@17025L27,410@17227L2042,403@16958L2311,455@19279L254:OnboardingPager.kt#h09ego");
                    Modifier modifierAlpha = AlphaKt.alpha(ScaleKt.scale(modifier5, OnboardingCompactScreenLandscapePager$lambda$6(stateAnimateFloatAsState)), OnboardingCompactScreenLandscapePager$lambda$6(stateAnimateFloatAsState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1629925339, "CC(remember):OnboardingPager.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(pages);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$7$0$0(pages, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, modifierAlpha, null, null, 1, 0.0f, null, null, false, false, (Function1) objRememberedValue4, null, null, null, ComposableLambdaKt.rememberComposableLambda(1610375403, true, new Function4() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$7$1(pages, pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 24576, 15340);
                    m13480OnboardingPagerIndicator64B7Zus(pagerStateRememberPagerState, PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.5f), 0.66f), Alignment.INSTANCE.getBottomEnd()), C1486Dp.m11017constructorimpl(16)), 0L, 0L, 0.0f, 0.0f, composerStartRestartGroup, 0, 60);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118360671, "CC(remember):OnboardingPager.kt#9igjgp");
                    OnboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1 onboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (onboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        onboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1RememberedValue = new OnboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1(mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$OnboardingCompactScreenLandscapePager$4$1RememberedValue, composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function13 = function15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$9(pages, modifier3, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function12 = function1;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function12 = function1;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final boolean OnboardingCompactScreenLandscapePager$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingCompactScreenLandscapePager$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OnboardingCompactScreenLandscapePager$lambda$7$0$0(List list, int i) {
        return Integer.valueOf(((OnboardingPages) list.get(i)).getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$7$1(List list, final PagerState pagerState, PagerScope HorizontalPager, final int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)411@17254L2005:OnboardingPager.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610375403, i2, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenLandscapePager.<anonymous>.<anonymous> (OnboardingPager.kt:411)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, 679390727, "C413@17312L748,429@18078L1167:OnboardingPager.kt#h09ego");
        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.5f);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -374708213, "C416@17472L57,420@17714L306,414@17367L675:OnboardingPager.kt#h09ego");
        ContentScale fillHeight = ContentScale.INSTANCE.getFillHeight();
        Painter painterPainterResource = PainterResources_androidKt.painterResource(((OnboardingPages) list.get(i)).getIllustrationLayer1(), composer, 0);
        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1927586023, "CC(remember):OnboardingPager.kt#9igjgp");
        int i3 = (i2 & 112) ^ 48;
        boolean zChanged = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$7$1$0$0$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageKt.Image(painterPainterResource, (String) null, GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxHeight$default, (Function1) objRememberedValue), (Alignment) null, fillHeight, 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 104);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, 1.0f), C1486Dp.m11017constructorimpl(64));
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM2854padding3ABfNKs);
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer);
        Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1275344526, "C437@18431L46,438@18537L227,436@18379L407,445@18866L52,446@18978L227,444@18808L419:OnboardingPager.kt#h09ego");
        String strStringResource = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getTitleRes(), composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -928686744, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged2 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$7$1$0$1$0$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageTitle(strStringResource, GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue2), composer, 0, 0);
        String strStringResource2 = StringResources_androidKt.stringResource(((OnboardingPages) list.get(i)).getDescriptionRes(), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -928672632, "CC(remember):OnboardingPager.kt#9igjgp");
        boolean zChanged3 = composer.changed(pagerState) | ((i3 > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingPagerKt.OnboardingCompactScreenLandscapePager$lambda$7$1$0$1$1$0(pagerState, i, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingPageDescription(strStringResource2, GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) objRememberedValue3), composer, 0, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$7$1$0$0$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float currentPage = (pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction();
        graphicsLayer.setTranslationX((-currentPage) * Float.intBitsToFloat((int) (graphicsLayer.getSize() >> 32)) * 1.0f);
        graphicsLayer.setAlpha(1.0f - Math.abs(currentPage));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$7$1$0$1$0$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscapePager$lambda$7$1$0$1$1$0(PagerState pagerState, int i, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()) * 2.0f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingPageTitle(final String text, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1884818890);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPageTitle)N(text,modifier)475@19744L10,479@19892L6,473@19687L292:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(text) ? 4 : 2);
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1884818890, i3, -1, "com.myscript.nebo.ui.compose.OnboardingPageTitle (OnboardingPager.kt:472)");
                }
                TextStyle h4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH4();
                int iM10895getCentere0LSkKk = TextAlign.INSTANCE.m10895getCentere0LSkKk();
                FontWeight black = FontWeight.INSTANCE.getBlack();
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4524Text4IGK_g(text, modifier3, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), TextUnitKt.getSp(32), (FontStyle) null, black, (FontFamily) null, TextUnitKt.getSp(-0.4d), (TextDecoration) null, TextAlign.m10888boximpl(iM10895getCentere0LSkKk), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, h4, composer2, (i3 & 14) | 199680 | (i3 & 112), 0, 64848);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingPagerKt.OnboardingPageTitle$lambda$0(text, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingPageDescription(final String text, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1585359142);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPageDescription)N(text,modifier)489@20133L10,492@20245L6,487@20076L234:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(text) ? 4 : 2);
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1585359142, i3, -1, "com.myscript.nebo.ui.compose.OnboardingPageDescription (OnboardingPager.kt:486)");
                }
                TextStyle body1 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody1();
                int iM10895getCentere0LSkKk = TextAlign.INSTANCE.m10895getCentere0LSkKk();
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4524Text4IGK_g(text, modifier3, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(iM10895getCentere0LSkKk), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, body1, composer2, (i3 & 14) | 3072 | (i3 & 112), 0, 65008);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingPagerKt.OnboardingPageDescription$lambda$0(text, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX INFO: renamed from: OnboardingPagerIndicator-64B7Zus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m13480OnboardingPagerIndicator64B7Zus(final PagerState pagerState, Modifier modifier, long j, long j2, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long jM4203getPrimary0d7_KjU;
        int i4;
        long j3;
        int i5;
        float f3;
        int i6;
        float fM11017constructorimpl;
        float fM11017constructorimpl2;
        long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM8180getLightGray0d7_KjU;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(15888572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPagerIndicator)N(pagerState,modifier,activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,dotSize:c#ui.unit.Dp,spacing:c#ui.unit.Dp)507@20669L1554:OnboardingPager.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                jM4203getPrimary0d7_KjU = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) ? 256 : 128;
            } else {
                jM4203getPrimary0d7_KjU = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    j3 = j2;
                    i3 |= composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        f3 = f;
                        i3 |= composerStartRestartGroup.changed(f3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        fM11017constructorimpl = f2;
                    } else {
                        fM11017constructorimpl = f2;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i3 |= composerStartRestartGroup.changed(fM11017constructorimpl) ? 131072 : 65536;
                        }
                    }
                    boolean z = true;
                    if (!composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "500@20458L6");
                        if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            fM11017constructorimpl2 = f3;
                            jM8180getLightGray0d7_KjU = j3;
                        } else {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
                                i3 &= -897;
                            }
                            jM8180getLightGray0d7_KjU = i4 != 0 ? Color.INSTANCE.m8180getLightGray0d7_KjU() : j3;
                            fM11017constructorimpl2 = i5 != 0 ? C1486Dp.m11017constructorimpl(8) : f3;
                            if (i6 != 0) {
                                fM11017constructorimpl = C1486Dp.m11017constructorimpl(8);
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(15888572, i3, -1, "com.myscript.nebo.ui.compose.OnboardingPagerIndicator (OnboardingPager.kt:504)");
                        }
                        float fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(pagerState.getPageCount() * fM11017constructorimpl2) + C1486Dp.m11017constructorimpl((pagerState.getPageCount() - 1) * fM11017constructorimpl));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        final float f4 = fM11017constructorimpl;
                        final long j5 = jM8180getLightGray0d7_KjU;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2071356025, "C509@20803L117,519@21048L1169,515@20930L1287:OnboardingPager.kt#h09ego");
                        SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(SizeKt.m2929width3ABfNKs(modifier2, fM11017constructorimpl3), fM11017constructorimpl2), composerStartRestartGroup, 0);
                        Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, fM11017constructorimpl3), fM11017constructorimpl2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 348831655, "CC(remember):OnboardingPager.kt#9igjgp");
                        boolean z2 = ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((i3 & 7168) == 2048);
                        if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                            z = false;
                        }
                        boolean z3 = z2 | z;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            final float f5 = fM11017constructorimpl2;
                            final long j6 = jM4203getPrimary0d7_KjU;
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OnboardingPagerKt.OnboardingPagerIndicator_64B7Zus$lambda$0$0$0(f5, f4, pagerState, j6, j5, (DrawScope) obj);
                                }
                            };
                            fM11017constructorimpl = f4;
                            j4 = j5;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            j4 = j5;
                            fM11017constructorimpl = f4;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2910height3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        fM11017constructorimpl2 = f3;
                        j4 = j3;
                    }
                    final float f6 = fM11017constructorimpl;
                    final long j7 = jM4203getPrimary0d7_KjU;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final long j8 = j4;
                        final float f7 = fM11017constructorimpl2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OnboardingPagerKt.OnboardingPagerIndicator_64B7Zus$lambda$1(pagerState, modifier3, j7, j8, f7, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                f3 = f;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                boolean z4 = true;
                if (!composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
                }
                final float f62 = fM11017constructorimpl;
                final long j72 = jM4203getPrimary0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            j3 = j2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            f3 = f;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            boolean z42 = true;
            if (!composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
            }
            final float f622 = fM11017constructorimpl;
            final long j722 = jM4203getPrimary0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        j3 = j2;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        f3 = f;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        boolean z422 = true;
        if (!composerStartRestartGroup.shouldExecute((i3 & 74899) == 74898, i3 & 1)) {
        }
        final float f6222 = fM11017constructorimpl;
        final long j7222 = jM4203getPrimary0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void AutoScrollEffect(PagerState pagerState, long j, int i, Composer composer, final int i2, final int i3) {
        int i4;
        long j2;
        int i5;
        int i6;
        final int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PagerState pagerState2 = pagerState;
        Composer composerStartRestartGroup = composer.startRestartGroup(2009017628);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoScrollEffect)N(pagerState,autoScrollDelay,autoScrollDuration)557@22436L840,557@22409L867:OnboardingPager.kt#h09ego");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(pagerState2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                j2 = j;
                i4 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    i7 = i6;
                } else {
                    if (i8 != 0) {
                        j2 = AUTO_SCROLL_DELAY_MS;
                    }
                    i7 = i5 != 0 ? AUTO_SCROLL_DURATION_MS : i6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2009017628, i4, -1, "com.myscript.nebo.ui.compose.AutoScrollEffect (OnboardingPager.kt:556)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2069335804, "CC(remember):OnboardingPager.kt#9igjgp");
                    int i9 = i4 & 14;
                    boolean z = ((i4 & 112) == 32) | (i9 == 4) | ((i4 & 896) == 256);
                    OnboardingPagerKt$AutoScrollEffect$1$1 onboardingPagerKt$AutoScrollEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z || onboardingPagerKt$AutoScrollEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        OnboardingPagerKt$AutoScrollEffect$1$1 onboardingPagerKt$AutoScrollEffect$1$1 = new OnboardingPagerKt$AutoScrollEffect$1$1(j2, pagerState2, i7, null);
                        pagerState2 = pagerState2;
                        onboardingPagerKt$AutoScrollEffect$1$1RememberedValue = onboardingPagerKt$AutoScrollEffect$1$1;
                        composerStartRestartGroup.updateRememberedValue(onboardingPagerKt$AutoScrollEffect$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(pagerState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingPagerKt$AutoScrollEffect$1$1RememberedValue, composerStartRestartGroup, i9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                final long j3 = j2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda38
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OnboardingPagerKt.AutoScrollEffect$lambda$1(pagerState2, j3, i7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            i6 = i;
            if (!composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            }
            final long j32 = j2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        j2 = j;
        i5 = i3 & 4;
        if (i5 != 0) {
        }
        i6 = i;
        if (!composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
        }
        final long j322 = j2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static final void OnboardingLargeScreenPortraitPagerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1511364118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingLargeScreenPortraitPagerPreview)607@24227L41:OnboardingPager.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1511364118, i, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenPortraitPagerPreview (OnboardingPager.kt:587)");
            }
            OnboardingLargeScreenPortraitPager(CollectionsKt.listOf((Object[]) new OnboardingPages[]{new OnboardingPages(0, C6079R.string.onboarding_slide1_title, C6079R.string.onboarding_slide1_description, C6079R.drawable.onboarding_slide1_layer1, C6079R.drawable.onboarding_slide1_layer2, C6079R.drawable.onboarding_slide1_layer3), new OnboardingPages(1, C6079R.string.onboarding_slide1_title, C6079R.string.onboarding_slide1_description, C6079R.drawable.onboarding_slide1_layer1, C6079R.drawable.onboarding_slide1_layer2, C6079R.drawable.onboarding_slide1_layer3)}), null, null, composerStartRestartGroup, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingPagerKt.OnboardingLargeScreenPortraitPagerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void OnboardingCompactScreenPortraitPagerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-990788370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingCompactScreenPortraitPagerPreview)632@25205L43:OnboardingPager.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-990788370, i, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenPortraitPagerPreview (OnboardingPager.kt:612)");
            }
            OnboardingCompactScreenPortraitPager(CollectionsKt.listOf((Object[]) new OnboardingPages[]{new OnboardingPages(0, C6079R.string.onboarding_slide1_title, C6079R.string.onboarding_slide1_description, C6079R.drawable.onboarding_slide1_layer1, C6079R.drawable.onboarding_slide1_layer1, C6079R.drawable.onboarding_slide1_layer1), new OnboardingPages(2, C6079R.string.onboarding_slide1_title, C6079R.string.onboarding_slide1_description, C6079R.drawable.onboarding_slide2_layer1, C6079R.drawable.onboarding_slide2_layer1, C6079R.drawable.onboarding_slide2_layer1)}), null, null, composerStartRestartGroup, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingPagerKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingPagerKt.OnboardingCompactScreenPortraitPagerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float OnboardingLargeScreenLandscapePager$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float OnboardingLargeScreenPortraitPager$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float OnboardingCompactScreenPortraitPager$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float OnboardingCompactScreenLandscapePager$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPagerIndicator_64B7Zus$lambda$0$0$0(float f, float f2, PagerState pagerState, long j, long j2, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f3 = Canvas.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(f + f2));
        float f4 = Canvas.mo2191toPx0680j_4(f) / 2.0f;
        float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
        int pageCount = pagerState.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            DrawScope.m8710drawCircleVaOC9Bg$default(Canvas, j2, f4, Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.mo8729getSizeNHjbRc() & 4294967295L)) / 2)) & 4294967295L) | (Float.floatToRawIntBits((i * f3) + f4) << 32)), 0.0f, null, null, 0, 120, null);
        }
        float f5 = 2;
        float fCoerceAtLeast = RangesKt.coerceAtLeast(f3 * f5 * (0.5f - Math.abs(0.5f - Math.abs(currentPageOffsetFraction))), 0.0f);
        long jM7895constructorimpl = Offset.m7895constructorimpl((((long) Float.floatToRawIntBits((pagerState.getCurrentPage() * f3) + (currentPageOffsetFraction * f3))) << 32) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (Canvas.mo8729getSizeNHjbRc() & 4294967295L)) - Canvas.mo2191toPx0680j_4(f)) / f5)) & 4294967295L));
        long jM7963constructorimpl = Size.m7963constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo2191toPx0680j_4(f) + fCoerceAtLeast)) << 32) | (((long) Float.floatToRawIntBits(Canvas.mo2191toPx0680j_4(f))) & 4294967295L));
        float f6 = Canvas.mo2191toPx0680j_4(f);
        DrawScope.m8725drawRoundRectuAw5IA$default(Canvas, j, jM7895constructorimpl, jM7963constructorimpl, CornerRadius.m7857constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f6)))), null, 0.0f, null, 0, PsExtractor.VIDEO_STREAM_MASK, null);
        return Unit.INSTANCE;
    }
}
