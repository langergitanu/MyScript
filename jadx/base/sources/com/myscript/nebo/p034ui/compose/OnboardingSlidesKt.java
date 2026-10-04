package com.myscript.nebo.p034ui.compose;

import android.text.Spanned;
import android.text.style.URLSpan;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.UriHandler;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.PlatformSpanStyle;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.text.HtmlCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.android.utils.p019ui.compose.ButtonsKt;
import com.myscript.android.utils.p019ui.compose.LayoutConfigurationKt;
import com.myscript.android.utils.p019ui.compose.ScreenLayoutState;
import com.myscript.nebo.C6079R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OnboardingSlides.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a-\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001a!\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001a!\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u001b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u008a\u008e\u0002"}, m1599d2 = {"pages", "", "Lcom/myscript/nebo/ui/compose/OnboardingPages;", "OnboardingSlides", "", "onCtaButtonClick", "Lkotlin/Function1;", "", "debugMode", "", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "OnboardingLargeScreenPortrait", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OnboardingLargeScreenLandscape", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "OnboardingCompactScreenPortrait", "OnboardingCompactScreenLandscape", "LegalMention", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OnboardingPhonePortraitPreview", "(Landroidx/compose/runtime/Composer;I)V", "OnboardingPhoneLandscapePreview", "OnboardingTabletPortraitPreview", "OnboardingSmallTabletPortraitPreview", "OnboardingSmallTabletLandscapePreview", "OnboardingFoldableUnfoldedPreview", "app_standardRelease", "currentPage"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OnboardingSlidesKt {
    private static final List<OnboardingPages> pages = CollectionsKt.listOf((Object[]) new OnboardingPages[]{new OnboardingPages(0, C6079R.string.onboarding_slide1_title, C6079R.string.onboarding_slide1_description, C6079R.drawable.onboarding_slide1_layer1, C6079R.drawable.onboarding_slide1_layer2, C6079R.drawable.onboarding_slide1_layer3), new OnboardingPages(1, C6079R.string.onboarding_slide2_title, C6079R.string.onboarding_slide2_description, C6079R.drawable.onboarding_slide2_layer1, C6079R.drawable.onboarding_slide2_layer2, C6079R.drawable.onboarding_slide2_layer3), new OnboardingPages(2, C6079R.string.onboarding_slide3_title, C6079R.string.onboarding_slide3_description, C6079R.drawable.onboarding_slide3_layer1, C6079R.drawable.onboarding_slide3_layer2, C6079R.drawable.onboarding_slide3_layer3)});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LegalMention$lambda$2(Modifier modifier, int i, int i2, Composer composer, int i3) {
        LegalMention(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscape$lambda$4(Function1 function1, int i, Composer composer, int i2) {
        OnboardingCompactScreenLandscape(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortrait$lambda$4(Function1 function1, int i, Composer composer, int i2) {
        OnboardingCompactScreenPortrait(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingFoldableUnfoldedPreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingFoldableUnfoldedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscape$lambda$4(Function1 function1, int i, Composer composer, int i2) {
        OnboardingLargeScreenLandscape(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortrait$lambda$4(Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OnboardingLargeScreenPortrait(function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPhoneLandscapePreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingPhoneLandscapePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPhonePortraitPreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingPhonePortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$2(Function1 function1, boolean z, int i, int i2, Composer composer, int i3) {
        OnboardingSlides(function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSmallTabletLandscapePreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingSmallTabletLandscapePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSmallTabletPortraitPreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingSmallTabletPortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingTabletPortraitPreview$lambda$1(int i, Composer composer, int i2) {
        OnboardingTabletPortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingSlides(Function1<? super Integer, Unit> function1, boolean z, Composer composer, final int i, final int i2) {
        final Function1<? super Integer, Unit> function12;
        int i3;
        boolean z2;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function1<? super Integer, Unit> function13;
        Modifier modifierNavigationBarsPadding;
        Composer composerStartRestartGroup = composer.startRestartGroup(602786853);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingSlides)N(onCtaButtonClick,debugMode)83@3433L2,86@3494L27,90@3608L6,88@3527L1204:OnboardingSlides.kt#h09ego");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            function12 = function1;
        } else if ((i & 6) == 0) {
            function12 = function1;
            i3 = (composerStartRestartGroup.changedInstance(function12) ? 4 : 2) | i;
        } else {
            function12 = function1;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z2;
            } else {
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542417305, "CC(remember):OnboardingSlides.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingSlidesKt.OnboardingSlides$lambda$0$0(((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function13 = (Function1) objRememberedValue;
                } else {
                    function13 = function12;
                }
                z3 = i5 != 0 ? false : z2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(602786853, i3, -1, "com.myscript.nebo.ui.compose.OnboardingSlides (OnboardingSlides.kt:85)");
                }
                ScreenLayoutState screenLayoutStateRememberScreenLayoutState = LayoutConfigurationKt.rememberScreenLayoutState(composerStartRestartGroup, 0);
                Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4196getBackground0d7_KjU(), null, 2, null);
                if (screenLayoutStateRememberScreenLayoutState.isLargeScreen()) {
                    modifierNavigationBarsPadding = WindowInsetsPadding_androidKt.safeDrawingPadding(Modifier.INSTANCE);
                } else {
                    modifierNavigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE);
                }
                Modifier modifierThen = modifierM2016backgroundbw27NRU$default.then(modifierNavigationBarsPadding);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -27053722, "C98@3856L190,104@4078L192,110@4303L194,116@4527L188,97@3811L914:OnboardingSlides.kt#h09ego");
                LayoutConfigurationKt.AdaptiveLayout(ComposableLambdaKt.rememberComposableLambda(376511352, true, new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingSlidesKt.OnboardingSlides$lambda$1$0(function13, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1725942151, true, new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingSlidesKt.OnboardingSlides$lambda$1$1(function13, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(466571642, true, new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingSlidesKt.OnboardingSlides$lambda$1$2(function13, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1635881861, true, new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingSlidesKt.OnboardingSlides$lambda$1$3(function13, z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3510, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingSlidesKt.OnboardingSlides$lambda$2(function12, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        z2 = z;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$1$0(Function1 function1, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@3874L48:OnboardingSlides.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376511352, i, -1, "com.myscript.nebo.ui.compose.OnboardingSlides.<anonymous>.<anonymous> (OnboardingSlides.kt:99)");
            }
            OnboardingLargeScreenLandscape(function1, composer, 0);
            if (z) {
                composer.startReplaceGroup(-1804790084);
                ComposerKt.sourceInformation(composer, "101@3976L38");
                TextKt.m4524Text4IGK_g("OnboardingLargeScreenLandscape", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1804715126);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$1$1(Function1 function1, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4096L49:OnboardingSlides.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1725942151, i, -1, "com.myscript.nebo.ui.compose.OnboardingSlides.<anonymous>.<anonymous> (OnboardingSlides.kt:105)");
            }
            OnboardingCompactScreenPortrait(function1, composer, 0);
            if (z) {
                composer.startReplaceGroup(1805947930);
                ComposerKt.sourceInformation(composer, "107@4199L39");
                TextKt.m4524Text4IGK_g("OnboardingCompactScreenPortrait", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1806023849);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$1$2(Function1 function1, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4321L50:OnboardingSlides.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(466571642, i, -1, "com.myscript.nebo.ui.compose.OnboardingSlides.<anonymous>.<anonymous> (OnboardingSlides.kt:111)");
            }
            OnboardingCompactScreenLandscape(function1, composer, 0);
            if (z) {
                composer.startReplaceGroup(1121718648);
                ComposerKt.sourceInformation(composer, "113@4425L40");
                TextKt.m4524Text4IGK_g("OnboardingCompactScreenLandscape", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1121795528);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSlides$lambda$1$3(Function1 function1, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C117@4545L47:OnboardingSlides.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1635881861, i, -1, "com.myscript.nebo.ui.compose.OnboardingSlides.<anonymous>.<anonymous> (OnboardingSlides.kt:117)");
            }
            OnboardingLargeScreenPortrait(function1, null, composer, 0, 2);
            if (z) {
                composer.startReplaceGroup(437485274);
                ComposerKt.sourceInformation(composer, "119@4646L37");
                TextKt.m4524Text4IGK_g("OnboardingLargeScreenPortrait", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 6, 0, 131070);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(437559271);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OnboardingLargeScreenPortrait(final Function1<? super Integer, Unit> onCtaButtonClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(onCtaButtonClick, "onCtaButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1959865628);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingLargeScreenPortrait)N(onCtaButtonClick,modifier)131@4880L30,133@4916L913:OnboardingSlides.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onCtaButtonClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1959865628, i3, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenPortrait (OnboardingSlides.kt:130)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059778722, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, centerHorizontally, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -242071755, "C142@5240L62,139@5098L214,145@5322L500:OnboardingSlides.kt#h09ego");
            List<OnboardingPages> list = pages;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 407837112, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingLargeScreenPortrait$lambda$3$0$0(mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = i3;
            OnboardingPagerKt.OnboardingLargeScreenPortraitPager(list, modifierWeight$default, (Function1) objRememberedValue2, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            float f = 32;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 0.0f, C1486Dp.m11017constructorimpl(16), 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 567713464, "C154@5737L33,149@5529L255,157@5798L14:OnboardingSlides.kt#h09ego");
            int i5 = C6079R.string.onboarding_continue;
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1680887729, "CC(remember):OnboardingSlides.kt#9igjgp");
            boolean z = (i4 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingSlidesKt.OnboardingLargeScreenPortrait$lambda$3$1$0$0(onCtaButtonClick, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonsKt.LargeButton(i5, modifierM2910height3ABfNKs, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            LegalMention(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingLargeScreenPortrait$lambda$4(onCtaButtonClick, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int OnboardingLargeScreenPortrait$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void OnboardingLargeScreenPortrait$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortrait$lambda$3$0$0(MutableState mutableState, int i) {
        OnboardingLargeScreenPortrait$lambda$2(mutableState, RangesKt.coerceAtLeast(i, OnboardingLargeScreenPortrait$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenPortrait$lambda$3$1$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(Integer.valueOf(OnboardingLargeScreenPortrait$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    public static final void OnboardingLargeScreenLandscape(final Function1<? super Integer, Unit> onCtaButtonClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onCtaButtonClick, "onCtaButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1368087535);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingLargeScreenLandscape)N(onCtaButtonClick)167@5944L30,169@5980L1043:OnboardingSlides.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onCtaButtonClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368087535, i2, -1, "com.myscript.nebo.ui.compose.OnboardingLargeScreenLandscape (OnboardingSlides.kt:166)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 472131757, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -805043438, "C174@6093L924:OnboardingSlides.kt#h09ego");
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1689790073, "C183@6448L62,179@6272L252,186@6538L469:OnboardingSlides.kt#h09ego");
            List<OnboardingPages> list = pages;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1024345641, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingLargeScreenLandscape$lambda$3$0$0$0(mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingPagerKt.OnboardingLargeScreenLandscapePager(list, modifierWeight$default, (Function1) objRememberedValue2, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_42 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(24));
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_42, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -656721347, "C195@6927L33,190@6700L261,197@6979L14:OnboardingSlides.kt#h09ego");
            int i3 = C6079R.string.onboarding_continue;
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1779937762, "CC(remember):OnboardingSlides.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingSlidesKt.OnboardingLargeScreenLandscape$lambda$3$0$1$0$0(onCtaButtonClick, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonsKt.LargeButton(i3, modifierM2910height3ABfNKs, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            LegalMention(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingLargeScreenLandscape$lambda$4(onCtaButtonClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int OnboardingLargeScreenLandscape$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void OnboardingLargeScreenLandscape$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscape$lambda$3$0$0$0(MutableState mutableState, int i) {
        OnboardingLargeScreenLandscape$lambda$2(mutableState, RangesKt.coerceAtLeast(i, OnboardingLargeScreenLandscape$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLargeScreenLandscape$lambda$3$0$1$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(Integer.valueOf(OnboardingLargeScreenLandscape$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    public static final void OnboardingCompactScreenPortrait(final Function1<? super Integer, Unit> onCtaButtonClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onCtaButtonClick, "onCtaButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1131666923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingCompactScreenPortrait)N(onCtaButtonClick)207@7139L30,209@7175L1099:OnboardingSlides.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onCtaButtonClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1131666923, i2, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenPortrait (OnboardingSlides.kt:206)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 905190345, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 359321888, "C210@7213L1054:OnboardingSlides.kt#h09ego");
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 389805418, "C218@7571L62,215@7415L232,221@7661L596:OnboardingSlides.kt#h09ego");
            List<OnboardingPages> list = pages;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 843862573, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingCompactScreenPortrait$lambda$3$0$0$0(mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            OnboardingPagerKt.OnboardingCompactScreenPortraitPager(list, modifierWeight$default, (Function1) objRememberedValue2, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 662684722, "C230@8032L33,228@7931L280,236@8229L14:OnboardingSlides.kt#h09ego");
            int i4 = C6079R.string.onboarding_continue;
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1502640774, "CC(remember):OnboardingSlides.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingSlidesKt.OnboardingCompactScreenPortrait$lambda$3$0$1$0$0(onCtaButtonClick, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonsKt.LargeButton(i4, modifierM2910height3ABfNKs, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            LegalMention(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingCompactScreenPortrait$lambda$4(onCtaButtonClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int OnboardingCompactScreenPortrait$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void OnboardingCompactScreenPortrait$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortrait$lambda$3$0$0$0(MutableState mutableState, int i) {
        OnboardingCompactScreenPortrait$lambda$2(mutableState, RangesKt.coerceAtLeast(i, OnboardingCompactScreenPortrait$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenPortrait$lambda$3$0$1$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(Integer.valueOf(OnboardingCompactScreenPortrait$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    public static final void OnboardingCompactScreenLandscape(final Function1<? super Integer, Unit> onCtaButtonClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onCtaButtonClick, "onCtaButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1703014935);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingCompactScreenLandscape)N(onCtaButtonClick)247@8391L30,249@8427L869:OnboardingSlides.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onCtaButtonClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1703014935, i2, -1, "com.myscript.nebo.ui.compose.OnboardingCompactScreenLandscape (OnboardingSlides.kt:246)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 214816021, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1684403146, "C253@8575L62,250@8441L206,256@8657L632:OnboardingSlides.kt#h09ego");
            List<OnboardingPages> list = pages;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1716900069, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingCompactScreenLandscape$lambda$3$0$0(mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingPagerKt.OnboardingCompactScreenLandscapePager(list, companion2, (Function1) objRememberedValue2, composerStartRestartGroup, 432, 0);
            float f = 32;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2532spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m2532spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(boxScopeInstance.align(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.5f), Alignment.INSTANCE.getBottomEnd()), C1486Dp.m11017constructorimpl(f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2532spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2856paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -739345454, "C266@9053L33,264@8961L290,273@9265L14:OnboardingSlides.kt#h09ego");
            int i3 = C6079R.string.onboarding_continue;
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1486Dp.m11017constructorimpl(280), 1, null), C1486Dp.m11017constructorimpl(48));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1686415180, "CC(remember):OnboardingSlides.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingSlidesKt.OnboardingCompactScreenLandscape$lambda$3$1$0$0(onCtaButtonClick, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonsKt.LargeButton(i3, modifierM2910height3ABfNKs, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            LegalMention(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingCompactScreenLandscape$lambda$4(onCtaButtonClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int OnboardingCompactScreenLandscape$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void OnboardingCompactScreenLandscape$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscape$lambda$3$0$0(MutableState mutableState, int i) {
        OnboardingCompactScreenLandscape$lambda$2(mutableState, RangesKt.coerceAtLeast(i, OnboardingCompactScreenLandscape$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingCompactScreenLandscape$lambda$3$1$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(Integer.valueOf(OnboardingCompactScreenLandscape$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    public static final void LegalMention(Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1732001277);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LegalMention)N(modifier)283@9407L49,308@10249L7,318@10598L10,320@10699L6,312@10327L239,310@10262L547:OnboardingSlides.kt#h09ego");
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
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1732001277, i3, -1, "com.myscript.nebo.ui.compose.LegalMention (OnboardingSlides.kt:281)");
            }
            Spanned spannedFromHtml = HtmlCompat.fromHtml(StringResources_androidKt.stringResource(C6079R.string.onboarding_legal_mention, composerStartRestartGroup, 0), 63);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
            composerStartRestartGroup.startReplaceGroup(-1994075965);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.append(spannedFromHtml.toString());
            composerStartRestartGroup.startReplaceGroup(-1994072437);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*293@9855L6");
            Object[] spans = spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            for (Object obj : spans) {
                URLSpan uRLSpan = (URLSpan) obj;
                int spanStart = spannedFromHtml.getSpanStart(uRLSpan);
                int spanEnd = spannedFromHtml.getSpanEnd(uRLSpan);
                builder.addStyle(new SpanStyle(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), spanStart, spanEnd);
                String url = uRLSpan.getURL();
                Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
                builder.addStringAnnotation("URL", url, spanStart, spanEnd);
            }
            composerStartRestartGroup.endReplaceGroup();
            final AnnotatedString annotatedString = builder.toAnnotatedString();
            composerStartRestartGroup.endReplaceGroup();
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final UriHandler uriHandler = (UriHandler) objConsume;
            TextStyle textStyleM10466copyp1EtxEg$default = TextStyle.m10466copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getCaption(), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(10), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m10895getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744444, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1994050964, "CC(remember):OnboardingSlides.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(annotatedString) | composerStartRestartGroup.changedInstance(uriHandler);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return OnboardingSlidesKt.LegalMention$lambda$1$0(annotatedString, uriHandler, ((Integer) obj2).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ClickableTextKt.m3377ClickableText4YKlhWE(annotatedString, modifier3, textStyleM10466copyp1EtxEg$default, false, 0, 0, null, (Function1) objRememberedValue, composerStartRestartGroup, (i3 << 3) & 112, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return OnboardingSlidesKt.LegalMention$lambda$2(modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LegalMention$lambda$1$0(AnnotatedString annotatedString, UriHandler uriHandler, int i) {
        AnnotatedString.Range range = (AnnotatedString.Range) CollectionsKt.firstOrNull((List) annotatedString.getStringAnnotations("URL", i, i));
        if (range != null) {
            uriHandler.openUri((String) range.getItem());
        }
        return Unit.INSTANCE;
    }

    public static final void OnboardingPhonePortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1651638653);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPhonePortraitPreview)335@11013L8,335@10981L40:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1651638653, i, -1, "com.myscript.nebo.ui.compose.OnboardingPhonePortraitPreview (OnboardingSlides.kt:334)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1913151579, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingPhonePortraitPreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingCompactScreenPortrait((Function1) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingPhonePortraitPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPhonePortraitPreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    public static final void OnboardingPhoneLandscapePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-391584121);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPhoneLandscapePreview)345@11283L8,345@11250L41:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391584121, i, -1, "com.myscript.nebo.ui.compose.OnboardingPhoneLandscapePreview (OnboardingSlides.kt:344)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1644784239, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingPhoneLandscapePreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingCompactScreenLandscape((Function1) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingPhoneLandscapePreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingPhoneLandscapePreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    public static final void OnboardingTabletPortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-995607341);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingTabletPortraitPreview)363@11635L8,362@11577L72:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995607341, i, -1, "com.myscript.nebo.ui.compose.OnboardingTabletPortraitPreview (OnboardingSlides.kt:361)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 999055579, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingTabletPortraitPreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingLargeScreenPortrait((Function1) objRememberedValue, null, composerStartRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingTabletPortraitPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingTabletPortraitPreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    public static final void OnboardingSmallTabletPortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-453948418);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingSmallTabletPortraitPreview)383@12155L8,382@12097L72:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453948418, i, -1, "com.myscript.nebo.ui.compose.OnboardingSmallTabletPortraitPreview (OnboardingSlides.kt:381)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1842237926, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingSmallTabletPortraitPreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingLargeScreenPortrait((Function1) objRememberedValue, null, composerStartRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingSmallTabletPortraitPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSmallTabletPortraitPreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    public static final void OnboardingSmallTabletLandscapePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1240273882);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingSmallTabletLandscapePreview)395@12470L8,394@12412L72:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1240273882, i, -1, "com.myscript.nebo.ui.compose.OnboardingSmallTabletLandscapePreview (OnboardingSlides.kt:393)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2097711150, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingSmallTabletLandscapePreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingLargeScreenPortrait((Function1) objRememberedValue, null, composerStartRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingSmallTabletLandscapePreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSmallTabletLandscapePreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }

    public static final void OnboardingFoldableUnfoldedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1947457120);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingFoldableUnfoldedPreview)407@12783L8,407@12750L41:OnboardingSlides.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1947457120, i, -1, "com.myscript.nebo.ui.compose.OnboardingFoldableUnfoldedPreview (OnboardingSlides.kt:406)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1099451272, "CC(remember):OnboardingSlides.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingSlidesKt.OnboardingFoldableUnfoldedPreview$lambda$0$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnboardingCompactScreenLandscape((Function1) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.OnboardingSlidesKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingSlidesKt.OnboardingFoldableUnfoldedPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingFoldableUnfoldedPreview$lambda$0$0(int i) {
        return Unit.INSTANCE;
    }
}
