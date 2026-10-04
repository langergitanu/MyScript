package androidx.compose.foundation.pager;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: LazyLayoutPager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u00063"}, m1599d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LazyLayoutPagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Pager_eLwUrMk$lambda$6(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, TargetedFlingBehavior targetedFlingBehavior, boolean z2, OverscrollEffect overscrollEffect, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, Function1 function1, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m3166PagereLwUrMk(modifier, pagerState, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i, f, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /* JADX INFO: renamed from: Pager-eLwUrMk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3166PagereLwUrMk(final Modifier modifier, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final TargetedFlingBehavior targetedFlingBehavior, final boolean z2, final OverscrollEffect overscrollEffect, int i, float f, final PageSize pageSize, NestedScrollConnection nestedScrollConnection, final Function1<? super Integer, ? extends Object> function1, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        PagerState pagerState2;
        NestedScrollConnection nestedScrollConnection2;
        Composer composer2;
        final int i10;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LegacyPagerBringIntoViewSpec legacyPagerBringIntoViewSpec;
        Modifier.Companion companionLazyLayoutBeyondBoundsModifier;
        Composer composerStartRestartGroup = composer.startRestartGroup(-572816025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Pager)N(modifier,state,contentPadding,reverseLayout,orientation,flingBehavior,userScrollEnabled,overscrollEffect,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,pageNestedScrollConnection,key,horizontalAlignment,verticalAlignment,snapPosition,pageContent)113@5634L39,113@5549L124,117@5700L24,133@6343L19,120@5758L615,136@6399L70,139@6511L82,141@6653L7,142@6708L7,175@7881L301,170@7712L1450:LazyLayoutPager.kt#g6yjnt");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(pagerState) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i5 |= composerStartRestartGroup.changed(targetedFlingBehavior) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
        }
        int i11 = i4 & 256;
        if (i11 == 0) {
            if ((i2 & 100663296) == 0) {
                i6 = 196608;
                i5 |= composerStartRestartGroup.changed(i) ? 67108864 : 33554432;
            }
            i7 = i4 & 512;
            if (i7 == 0) {
                i5 |= 805306368;
                f2 = f;
            } else {
                f2 = f;
                if ((i2 & 805306368) == 0) {
                    i5 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
                }
            }
            if ((i3 & 6) != 0) {
                i8 = i3 | (composerStartRestartGroup.changed(pageSize) ? 4 : 2);
            } else {
                i8 = i3;
            }
            if ((i3 & 48) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(nestedScrollConnection) ? 32 : 16;
            }
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i3 & 3072) == 0) {
                i8 |= composerStartRestartGroup.changed(horizontal) ? 2048 : 1024;
            }
            if ((i3 & 24576) == 0) {
                i8 |= composerStartRestartGroup.changed(vertical) ? 16384 : 8192;
            }
            if ((i3 & i6) == 0) {
                i8 |= composerStartRestartGroup.changed(snapPosition) ? 131072 : 65536;
            }
            if ((i3 & 1572864) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function4) ? 1048576 : 524288;
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i9) != 599186, i5 & 1)) {
                pagerState2 = pagerState;
                nestedScrollConnection2 = nestedScrollConnection;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                i10 = i;
                f3 = f2;
            } else {
                int i12 = i11 != 0 ? 0 : i;
                float fM11017constructorimpl = i7 != 0 ? C1486Dp.m11017constructorimpl(0) : f2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-572816025, i5, i9, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:106)");
                }
                if (!(i12 >= 0)) {
                    InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + i12);
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720319826, "CC(remember):LazyLayoutPager.kt#9igjgp");
                int i13 = i5 & 112;
                boolean z3 = i13 == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(pagerState.getPageCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i14 = i5 >> 3;
                int i15 = i14 & 14;
                int i16 = i9 >> 15;
                int i17 = i5;
                int i18 = i12;
                Function0<PagerLazyLayoutItemProvider> function0RememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, function4, function1, function0, composerStartRestartGroup, i15 | (i16 & 112) | (i9 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720297158, "CC(remember):LazyLayoutPager.kt#9igjgp");
                boolean z4 = i13 == 32;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(pagerState.getPageCount());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i19 = i17 >> 9;
                int i20 = i9 << 15;
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicyM3182rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m3182rememberPagerMeasurePolicy8u0NR3k(function0RememberPagerItemProviderLambda, pagerState, paddingValues, z, orientation, i18, fM11017constructorimpl, pageSize, horizontal, vertical, snapPosition, coroutineScope, (Function0) objRememberedValue3, composerStartRestartGroup, (i17 & 65520) | (i19 & 458752) | (i19 & 3670016) | ((i9 << 21) & 29360128) | (i20 & 234881024) | (i20 & C2181C.ENCODING_PCM_DOUBLE), i16 & 14);
                pagerState2 = pagerState;
                float f4 = fM11017constructorimpl;
                LazyLayoutSemanticState lazyLayoutSemanticStateRememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState2, orientation == Orientation.Vertical, composerStartRestartGroup, i15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720291719, "CC(remember):LazyLayoutPager.kt#9igjgp");
                boolean z5 = (i13 == 32) | ((i17 & 458752) == 131072);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localBringIntoViewSpec);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) objConsume;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                if (ComposeFoundationFlags.isBringIntoViewRltBouncyBehaviorInPagerFixEnabled) {
                    composerStartRestartGroup.startReplaceGroup(-853904960);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "145@6826L163");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720281558, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    boolean zChanged = (i13 == 32) | composerStartRestartGroup.changed(bringIntoViewSpec) | composerStartRestartGroup.changed(layoutDirection.ordinal());
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new PagerBringIntoViewSpec(pagerState2, bringIntoViewSpec, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    legacyPagerBringIntoViewSpec = (PagerBringIntoViewSpec) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-853714372);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "149@7019L135");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720275410, "CC(remember):LazyLayoutPager.kt#9igjgp");
                    boolean zChanged2 = (i13 == 32) | composerStartRestartGroup.changed(bringIntoViewSpec);
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new LegacyPagerBringIntoViewSpec(pagerState2, bringIntoViewSpec);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    legacyPagerBringIntoViewSpec = (LegacyPagerBringIntoViewSpec) objRememberedValue6;
                }
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-853484445);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "158@7327L167");
                    companionLazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState2, i18, composerStartRestartGroup, i15 | ((i17 >> 21) & 112)), pagerState2.getBeyondBoundsInfo(), z, orientation);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-853054661);
                    composerStartRestartGroup.endReplaceGroup();
                    companionLazyLayoutBeyondBoundsModifier = Modifier.INSTANCE;
                }
                Modifier modifierDragDirectionDetector = dragDirectionDetector(ScrollableAreaKt.scrollableArea(PagerKt.pagerSemantics(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState2.getRemeasurementModifier()).then(pagerState2.getAwaitLayoutModifier()), function0RememberPagerItemProviderLambda, lazyLayoutSemanticStateRememberPagerSemanticState, orientation, z2, z, composerStartRestartGroup, ((i17 << 6) & 458752) | (i14 & 7168) | ((i17 >> 6) & 57344)), pagerState2, orientation == Orientation.Vertical, coroutineScope, z2).then(companionLazyLayoutBeyondBoundsModifier), pagerState2, orientation, overscrollEffect, z2, z, pagerWrapperFlingBehavior, pagerState2.getInternalInteractionSource(), legacyPagerBringIntoViewSpec), pagerState2);
                nestedScrollConnection2 = nestedScrollConnection;
                LazyLayoutKt.LazyLayout(function0RememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(modifierDragDirectionDetector, nestedScrollConnection2, null, 2, null), pagerState2.getPrefetchState(), lazyLayoutMeasurePolicyM3182rememberPagerMeasurePolicy8u0NR3k, composerStartRestartGroup, 0, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f4;
                i10 = i18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final NestedScrollConnection nestedScrollConnection3 = nestedScrollConnection2;
                final PagerState pagerState3 = pagerState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$6(modifier, pagerState3, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i10, f3, pageSize, nestedScrollConnection3, function1, horizontal, vertical, snapPosition, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i5 |= 100663296;
        i6 = 196608;
        i7 = i4 & 512;
        if (i7 == 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & i6) == 0) {
        }
        if ((i3 & 1572864) == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i9) != 599186, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1052364153, "C(rememberPagerItemProviderLambda)N(state,pageContent,key,pageCount)269@11376L33,270@11430L25,271@11467L742:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052364153, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:268)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 2004647903, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(stateRememberUpdatedState) | composer.changed(stateRememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$0(stateRememberUpdatedState, stateRememberUpdatedState2, function0);
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$0$1(stateDerivedStateOf, pagerState);
                }
            });
            objRememberedValue = (KProperty0) new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$0$0(State state, State state2, Function0 function0) {
        return new PagerLayoutIntervalContent((Function4) state.getValue(), (Function1) state2.getValue(), ((Number) function0.invoke()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$0$1(State state, PagerState pagerState) {
        PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) state.getValue();
        return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation(), pagerLayoutIntervalContent));
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt.dragDirectionDetector.1

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: LazyLayoutPager.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", m1609f = "LazyLayoutPager.kt", m1610i = {}, m1611l = {296}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LazyLayoutPager.kt */
                @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", m1609f = "LazyLayoutPager.kt", m1610i = {0, 1, 1, 1}, m1611l = {298, 302}, m1612m = "invokeSuspend", m1613n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, m1615s = {"L$0", "L$0", "L$1", "L$2"}, m1616v = 1)
                static final class C91741 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PagerState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C91741(PagerState pagerState, Continuation<? super C91741> continuation) {
                        super(2, continuation);
                        this.$state = pagerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C91741 c91741 = new C91741(this.$state, continuation);
                        c91741.L$0 = obj;
                        return c91741;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C91741) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
                    
                        return r0;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006b -> B:18:0x006e). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        PointerInputChange pointerInputChange;
                        PointerInputChange pointerInputChange2;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                        } else if (i == 1) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            pointerInputChange = (PointerInputChange) this.L$2;
                            pointerInputChange2 = (PointerInputChange) this.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            PointerEvent pointerEvent = (PointerEvent) obj;
                            List<PointerInputChange> changes = pointerEvent.getChanges();
                            int size = changes.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 < size) {
                                    if (!PointerEventKt.changedToUp(changes.get(i2))) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    pointerInputChange = pointerEvent.getChanges().get(0);
                                    break;
                                }
                            }
                            if (pointerInputChange != null) {
                                this.L$0 = awaitPointerEventScope2;
                                this.L$1 = pointerInputChange2;
                                this.L$2 = pointerInputChange;
                                this.label = 2;
                                obj = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, this);
                            } else {
                                this.$state.m3190setUpDownDifferencek4lQ0M$foundation(Offset.m7907minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition()));
                                return Unit.INSTANCE;
                            }
                        }
                        this.$state.m3190setUpDownDifferencek4lQ0M$foundation(Offset.INSTANCE.m7919getZeroF1C5BW0());
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange = null;
                        pointerInputChange2 = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C91741(this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p004ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, pagerState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }));
    }
}
