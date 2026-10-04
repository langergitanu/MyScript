package com.myscript.nebo.p034ui.compose;

import android.R;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.ScaleKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.p019ui.compose.ButtonsKt;
import com.myscript.android.utils.p019ui.compose.LayoutConfigurationKt;
import com.myscript.android.utils.p019ui.compose.ScreenLayoutState;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.migration.ILenovoMigrationController;
import com.myscript.nebo.migration.MigrationError;
import com.myscript.nebo.migration.MigrationProgress;
import com.myscript.nebo.migration.Phase;
import com.myscript.nebo.p034ui.compose.LenovoMigrationOnboardingViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: LenovoMigrationOnboarding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\n\u001a?\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003¢\u0006\u0002\u0010\u0015\u001aC\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001e\u001a;\u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010 \u001a\u0015\u0010!\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003¢\u0006\u0002\u0010&\u001a\u000e\u0010'\u001a\u00020(*\u0004\u0018\u00010%H\u0003\u001a\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020(H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020*X\u008a\u0084\u0002"}, m1599d2 = {"transferPage", "Lcom/myscript/nebo/ui/compose/MigrationOnboardingPage;", "migrationPages", "", "LenovoMigrationOnboarding", "", "controller", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "onFinished", "Lkotlin/Function0;", "(Lcom/myscript/nebo/migration/ILenovoMigrationController;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LenovoMigrationOnboardingContent", "progress", "Lcom/myscript/nebo/migration/MigrationProgress;", "onStart", "onRetry", "(Lcom/myscript/nebo/migration/MigrationProgress;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TransferSlideScreen", "onContinue", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MigrationPagerScreen", "(Lcom/myscript/nebo/migration/MigrationProgress;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MigrationControls", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/foundation/pager/PagerState;Lcom/myscript/nebo/migration/MigrationProgress;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MigrationSlide", "page", "(Lcom/myscript/nebo/ui/compose/MigrationOnboardingPage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MigrationBottomArea", "(Lcom/myscript/nebo/migration/MigrationProgress;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProgressArea", "(Lcom/myscript/nebo/migration/MigrationProgress;Landroidx/compose/runtime/Composer;I)V", "ErrorArea", "error", "Lcom/myscript/nebo/migration/MigrationError;", "(Lcom/myscript/nebo/migration/MigrationError;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "messageRes", "", "computeGlobalPercent", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/myscript/nebo/migration/Phase;", "localPercent", "app_standardRelease", "animatedProgress"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LenovoMigrationOnboardingKt {
    private static final MigrationOnboardingPage transferPage = new MigrationOnboardingPage(C6079R.string.lenovo_migration_onboarding_slide5_title, C6079R.string.lenovo_migration_onboarding_slide5_description, C6079R.drawable.lenovo_migration_transfer);
    private static final List<MigrationOnboardingPage> migrationPages = CollectionsKt.listOf((Object[]) new MigrationOnboardingPage[]{new MigrationOnboardingPage(C6079R.string.lenovo_migration_onboarding_slide2_title, C6079R.string.lenovo_migration_onboarding_slide2_description, C6079R.drawable.lenovo_migration_ui), new MigrationOnboardingPage(C6079R.string.lenovo_migration_onboarding_slide3_title, C6079R.string.lenovo_migration_onboarding_slide3_description, C6079R.drawable.lenovo_migration_ai), new MigrationOnboardingPage(C6079R.string.lenovo_migration_onboarding_slide4_title, C6079R.string.lenovo_migration_onboarding_slide4_description, C6079R.drawable.lenovo_migration_perf)});

    /* JADX INFO: compiled from: LenovoMigrationOnboarding.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Phase.values().length];
            try {
                iArr[Phase.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Phase.CreatingBackup.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Phase.CopyingBackup.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Phase.Restoring.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Phase.Done.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Phase.Error.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorArea$lambda$1(MigrationError migrationError, Function0 function0, int i, Composer composer, int i2) {
        ErrorArea(migrationError, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboarding$lambda$3(ILenovoMigrationController iLenovoMigrationController, Function0 function0, int i, Composer composer, int i2) {
        LenovoMigrationOnboarding(iLenovoMigrationController, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboardingContent$lambda$2(MigrationProgress migrationProgress, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        LenovoMigrationOnboardingContent(migrationProgress, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationBottomArea$lambda$1(MigrationProgress migrationProgress, Function0 function0, Function0 function02, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MigrationBottomArea(migrationProgress, function0, function02, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationControls$lambda$1(PagerState pagerState, MigrationProgress migrationProgress, Function0 function0, Function0 function02, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MigrationControls(pagerState, migrationProgress, function0, function02, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationPagerScreen$lambda$3(MigrationProgress migrationProgress, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        MigrationPagerScreen(migrationProgress, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationSlide$lambda$4(MigrationOnboardingPage migrationOnboardingPage, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MigrationSlide(migrationOnboardingPage, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressArea$lambda$2(MigrationProgress migrationProgress, int i, Composer composer, int i2) {
        ProgressArea(migrationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransferSlideScreen$lambda$2(Function0 function0, int i, Composer composer, int i2) {
        TransferSlideScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void LenovoMigrationOnboarding(final ILenovoMigrationController controller, Function0<Unit> onFinished, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Composer composerStartRestartGroup = composer.startRestartGroup(-839986056);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LenovoMigrationOnboarding)N(controller,onFinished)134@5716L89,138@5839L16,142@5942L23,144@6018L14,140@5861L177:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(controller) : composerStartRestartGroup.changedInstance(controller) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFinished) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onFinished;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-839986056, i2, -1, "com.myscript.nebo.ui.compose.LenovoMigrationOnboarding (LenovoMigrationOnboarding.kt:133)");
            }
            LenovoMigrationOnboardingViewModel.Factory factory = new LenovoMigrationOnboardingViewModel.Factory(controller);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)N(viewModelStoreOwner,key,factory,extras)56@2573L7,67@2981L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(LenovoMigrationOnboardingViewModel.class), current, (String) null, factory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LenovoMigrationOnboardingViewModel lenovoMigrationOnboardingViewModel = (LenovoMigrationOnboardingViewModel) viewModel;
            MigrationProgress migrationProgressLenovoMigrationOnboarding$lambda$0 = LenovoMigrationOnboarding$lambda$0(SnapshotStateKt.collectAsState(lenovoMigrationOnboardingViewModel.getProgress(), null, composerStartRestartGroup, 0, 1));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227264047, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(lenovoMigrationOnboardingViewModel);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LenovoMigrationOnboardingKt.LenovoMigrationOnboarding$lambda$1$0(lenovoMigrationOnboardingViewModel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function02 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227266470, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(lenovoMigrationOnboardingViewModel);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LenovoMigrationOnboardingKt.LenovoMigrationOnboarding$lambda$2$0(lenovoMigrationOnboardingViewModel);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function0 = onFinished;
            LenovoMigrationOnboardingContent(migrationProgressLenovoMigrationOnboarding$lambda$0, function02, function0, (Function0) objRememberedValue2, composerStartRestartGroup, (i2 << 3) & 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.LenovoMigrationOnboarding$lambda$3(controller, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboarding$lambda$1$0(LenovoMigrationOnboardingViewModel lenovoMigrationOnboardingViewModel) {
        lenovoMigrationOnboardingViewModel.startMigration();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboarding$lambda$2$0(LenovoMigrationOnboardingViewModel lenovoMigrationOnboardingViewModel) {
        lenovoMigrationOnboardingViewModel.retry();
        return Unit.INSTANCE;
    }

    private static final void LenovoMigrationOnboardingContent(final MigrationProgress migrationProgress, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i) {
        int i2;
        Function0<Unit> function04;
        Composer composerStartRestartGroup = composer.startRestartGroup(1334756422);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LenovoMigrationOnboardingContent)N(progress,onStart,onFinished,onRetry)160@6525L57,161@6605L27,166@6736L6,163@6638L2388:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(migrationProgress) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function04 = function03;
            i2 |= composerStartRestartGroup.changedInstance(function04) ? 2048 : 1024;
        } else {
            function04 = function03;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1334756422, i2, -1, "com.myscript.nebo.ui.compose.LenovoMigrationOnboardingContent (LenovoMigrationOnboarding.kt:158)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1494291137, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(migrationProgress.getPhase() != Phase.Idle), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ScreenLayoutState screenLayoutStateRememberScreenLayoutState = LayoutConfigurationKt.rememberScreenLayoutState(composerStartRestartGroup, 0);
            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4196getBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 72978845, "C176@7213L55,181@7419L465,174@7117L767:LenovoMigrationOnboarding.kt#h09ego");
            Modifier modifierSafeDrawingPadding = screenLayoutStateRememberScreenLayoutState.isLargeScreen() ? WindowInsetsPadding_androidKt.safeDrawingPadding(Modifier.INSTANCE) : WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifierSafeDrawingPadding);
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1942022711, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LenovoMigrationOnboardingKt.LenovoMigrationOnboardingContent$lambda$1$0$0((AnimatedContentTransitionScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function0<Unit> function05 = function04;
            AnimatedContentKt.AnimatedContent(boolValueOf, modifierThen, (Function1) objRememberedValue2, null, "migration_screen", null, ComposableLambdaKt.rememberComposableLambda(1090200221, true, new Function4() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return LenovoMigrationOnboardingKt.LenovoMigrationOnboardingContent$lambda$1$1(function0, migrationProgress, function02, function05, mutableState, (AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1597824, 40);
            composerStartRestartGroup = composerStartRestartGroup;
            if (!((Boolean) mutableState.getValue()).booleanValue() || migrationProgress.getPhase() == Phase.Error) {
                composerStartRestartGroup.startReplaceGroup(74420995);
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8499L41,207@8579L39,208@8657L6,205@8467L543");
                IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6014R.drawable.ic_close, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.cancel, composerStartRestartGroup, 6), SizeKt.m2924size3ABfNKs(PaddingKt.m2854padding3ABfNKs(ClickableKt.m2062clickableoSLSa3U$default(ClipKt.clip(PaddingKt.m2854padding3ABfNKs(WindowInsetsPadding_androidKt.safeDrawingPadding(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd())), C1486Dp.m11017constructorimpl(4)), RoundedCornerShapeKt.getCircleShape()), false, null, null, null, function02, 15, null), C1486Dp.m11017constructorimpl(12)), C1486Dp.m11017constructorimpl(24)), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4198getOnBackground0d7_KjU(), composerStartRestartGroup, Painter.$stable, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(74952738);
                composerStartRestartGroup.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.LenovoMigrationOnboardingContent$lambda$2(migrationProgress, function0, function02, function03, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform LenovoMigrationOnboardingContent$lambda$1$0$0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboardingContent$lambda$1$1(final Function0 function0, MigrationProgress migrationProgress, Function0 function02, Function0 function03, final MutableState mutableState, AnimatedContentScope AnimatedContent, boolean z, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(started):LenovoMigrationOnboarding.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1090200221, i, -1, "com.myscript.nebo.ui.compose.LenovoMigrationOnboardingContent.<anonymous>.<anonymous> (LenovoMigrationOnboarding.kt:182)");
        }
        if (!z) {
            composer.startReplaceGroup(-387863186);
            ComposerKt.sourceInformation(composer, "184@7530L111,183@7476L183");
            ComposerKt.sourceInformationMarkerStart(composer, -289604180, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LenovoMigrationOnboardingKt.LenovoMigrationOnboardingContent$lambda$1$1$0$0(mutableState, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TransferSlideScreen((Function0) objRememberedValue, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-387644574);
            ComposerKt.sourceInformation(composer, "190@7697L163");
            MigrationPagerScreen(migrationProgress, function02, function03, composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LenovoMigrationOnboardingContent$lambda$1$1$0$0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(true);
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void TransferSlideScreen(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1854676050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransferSlideScreen)N(onContinue)228@9318L27:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1854676050, i2, -1, "com.myscript.nebo.ui.compose.TransferSlideScreen (LenovoMigrationOnboarding.kt:227)");
            }
            ScreenLayoutState screenLayoutStateRememberScreenLayoutState = LayoutConfigurationKt.rememberScreenLayoutState(composerStartRestartGroup, 0);
            if (screenLayoutStateRememberScreenLayoutState.isLandscape() && !screenLayoutStateRememberScreenLayoutState.isLargeScreen()) {
                composerStartRestartGroup.startReplaceGroup(-2099647606);
                ComposerKt.sourceInformation(composerStartRestartGroup, "233@9646L726");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -897952007, "C234@9699L35,235@9747L615:LenovoMigrationOnboarding.kt#h09ego");
                MigrationSlide(transferPage, null, composerStartRestartGroup, 6, 2);
                Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.fillMaxWidth(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), 0.5f), C1486Dp.m11017constructorimpl(32), C1486Dp.m11017constructorimpl(24));
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1553728628, "C242@10046L302:LenovoMigrationOnboarding.kt#h09ego");
                ButtonsKt.LargeButton(C6079R.string.lenovo_migration_continue, SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1486Dp.m11017constructorimpl(280), 1, null), C1486Dp.m11017constructorimpl(48)), function0, composerStartRestartGroup, ((i2 << 6) & 896) | 48);
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
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2098900444);
                ComposerKt.sourceInformation(composerStartRestartGroup, "253@10394L588");
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(24), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1817852199, "C260@10654L67,261@10734L238:LenovoMigrationOnboarding.kt#h09ego");
                MigrationSlide(transferPage, ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 6, 0);
                ButtonsKt.LargeButton(C6079R.string.lenovo_migration_continue, SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48)), function0, composerStartRestartGroup, ((i2 << 6) & 896) | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.TransferSlideScreen$lambda$2(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void MigrationPagerScreen(MigrationProgress migrationProgress, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        final MigrationProgress migrationProgress2 = migrationProgress;
        final Function0<Unit> function03 = function0;
        final Function0<Unit> function04 = function02;
        Composer composerStartRestartGroup = composer.startRestartGroup(-722636456);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MigrationPagerScreen)N(progress,onFinished,onRetry)282@11370L23,282@11339L55,283@11417L27:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(migrationProgress2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function04) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-722636456, i2, -1, "com.myscript.nebo.ui.compose.MigrationPagerScreen (LenovoMigrationOnboarding.kt:281)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1331073103, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(LenovoMigrationOnboardingKt.MigrationPagerScreen$lambda$0$0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            ScreenLayoutState screenLayoutStateRememberScreenLayoutState = LayoutConfigurationKt.rememberScreenLayoutState(composerStartRestartGroup, 0);
            if (screenLayoutStateRememberScreenLayoutState.isLandscape() && !screenLayoutStateRememberScreenLayoutState.isLargeScreen()) {
                composerStartRestartGroup.startReplaceGroup(-1686002432);
                ComposerKt.sourceInformation(composerStartRestartGroup, "289@11756L1018");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1637840911, "C294@11971L470,290@11809L632,305@12454L310:LenovoMigrationOnboarding.kt#h09ego");
                PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, 1, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1231118518, true, new Function4() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return LenovoMigrationOnboardingKt.MigrationPagerScreen$lambda$1$0(pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24624, 24576, 16364);
                MigrationControls(pagerStateRememberPagerState, migrationProgress2, function03, function04, SizeKt.fillMaxWidth(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), 0.5f), composerStartRestartGroup, (i2 << 3) & 8176, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                migrationProgress2 = migrationProgress;
                function03 = function0;
                function04 = function02;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1684960925);
                ComposerKt.sourceInformation(composerStartRestartGroup, "316@12796L1031");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -330597770, "C324@13097L470,320@12938L629,335@13580L237:LenovoMigrationOnboarding.kt#h09ego");
                PagerKt.m3173HorizontalPager8jOkeI(pagerStateRememberPagerState, ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), null, null, 1, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(245989405, true, new Function4() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return LenovoMigrationOnboardingKt.MigrationPagerScreen$lambda$2$0(pagerStateRememberPagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 24576, 16364);
                int i3 = i2 << 3;
                int i4 = (i3 & 112) | 24576 | (i3 & 896) | (i3 & 7168);
                migrationProgress2 = migrationProgress;
                function03 = function0;
                function04 = function02;
                MigrationControls(pagerStateRememberPagerState, migrationProgress2, function03, function04, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, i4, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationPagerScreen$lambda$3(migrationProgress2, function03, function04, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MigrationPagerScreen$lambda$0$0() {
        return migrationPages.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationPagerScreen$lambda$1$0(PagerState pagerState, PagerScope HorizontalPager, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)298@12171L256:LenovoMigrationOnboarding.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1231118518, i2, -1, "com.myscript.nebo.ui.compose.MigrationPagerScreen.<anonymous>.<anonymous> (LenovoMigrationOnboarding.kt:295)");
        }
        float fCoerceIn = 1.0f - RangesKt.coerceIn(Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()), 0.0f, 1.0f);
        MigrationSlide(migrationPages.get(i), ScaleKt.scale(AlphaKt.alpha(Modifier.INSTANCE, MathHelpersKt.lerp(0.6f, 1.0f, fCoerceIn)), MathHelpersKt.lerp(0.93f, 1.0f, fCoerceIn)), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationPagerScreen$lambda$2$0(PagerState pagerState, PagerScope HorizontalPager, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)328@13297L256:LenovoMigrationOnboarding.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245989405, i2, -1, "com.myscript.nebo.ui.compose.MigrationPagerScreen.<anonymous>.<anonymous> (LenovoMigrationOnboarding.kt:325)");
        }
        float fCoerceIn = 1.0f - RangesKt.coerceIn(Math.abs((pagerState.getCurrentPage() - i) + pagerState.getCurrentPageOffsetFraction()), 0.0f, 1.0f);
        MigrationSlide(migrationPages.get(i), ScaleKt.scale(AlphaKt.alpha(Modifier.INSTANCE, MathHelpersKt.lerp(0.6f, 1.0f, fCoerceIn)), MathHelpersKt.lerp(0.93f, 1.0f, fCoerceIn)), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MigrationControls(final PagerState pagerState, final MigrationProgress migrationProgress, final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, Composer composer, final int i, final int i2) {
        PagerState pagerState2;
        int i3;
        MigrationProgress migrationProgress2;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-881718310);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MigrationControls)N(pagerState,progress,onFinished,onRetry,modifier)359@14310L550:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            pagerState2 = pagerState;
            i3 = (composerStartRestartGroup.changed(pagerState2) ? 4 : 2) | i;
        } else {
            pagerState2 = pagerState;
            i3 = i;
        }
        if ((i & 48) == 0) {
            migrationProgress2 = migrationProgress;
            i3 |= composerStartRestartGroup.changed(migrationProgress2) ? 32 : 16;
        } else {
            migrationProgress2 = migrationProgress;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-881718310, i3, -1, "com.myscript.nebo.ui.compose.MigrationControls (LenovoMigrationOnboarding.kt:358)");
                }
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 220585539, "C363@14422L130,367@14561L293:LenovoMigrationOnboarding.kt#h09ego");
                Modifier modifier4 = companion;
                composer2 = composerStartRestartGroup;
                OnboardingPagerKt.m13480OnboardingPagerIndicator64B7Zus(pagerState2, PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(12), 1, null), 0L, 0L, 0.0f, 0.0f, composer2, (i3 & 14) | 48, 60);
                MigrationBottomArea(migrationProgress2, function0, function02, PaddingKt.m2858paddingqDBjuR0$default(PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(32), 0.0f, 2, null), 0.0f, C1486Dp.m11017constructorimpl(8), 0.0f, C1486Dp.m11017constructorimpl(24), 5, null), composer2, (i3 >> 3) & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LenovoMigrationOnboardingKt.MigrationControls$lambda$1(pagerState, migrationProgress, function0, function02, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final void MigrationSlide(final MigrationOnboardingPage migrationOnboardingPage, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-325390016);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MigrationSlide)N(page,modifier)462@18793L1203,387@15311L1209,415@16611L937,438@17640L1024,385@15187L4815:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(migrationOnboardingPage) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-325390016, i3, -1, "com.myscript.nebo.ui.compose.MigrationSlide (LenovoMigrationOnboarding.kt:384)");
            }
            LayoutConfigurationKt.AdaptiveLayout(ComposableLambdaKt.rememberComposableLambda(-1268780147, true, new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationSlide$lambda$0(modifier, migrationOnboardingPage, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-320290418, true, new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationSlide$lambda$1(modifier, migrationOnboardingPage, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(628199311, true, new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationSlide$lambda$2(modifier, migrationOnboardingPage, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1576689040, true, new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationSlide$lambda$3(modifier, migrationOnboardingPage, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3510, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.MigrationSlide$lambda$4(migrationOnboardingPage, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationSlide$lambda$1(Modifier modifier, MigrationOnboardingPage migrationOnboardingPage, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C388@15325L1185:LenovoMigrationOnboarding.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320290418, i, -1, "com.myscript.nebo.ui.compose.MigrationSlide.<anonymous> (LenovoMigrationOnboarding.kt:388)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -297551766, "C393@15520L37,392@15483L466,402@15966L530:LenovoMigrationOnboarding.kt#h09ego");
            float f = 36;
            ImageKt.Image(PainterResources_androidKt.painterResource(migrationOnboardingPage.getIllustrationRes(), composer, 0), (String) null, ClipKt.clip(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.66f), RoundedCornerShapeKt.m3237RoundedCornerShapea9UjIt4$default(0.0f, 0.0f, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 3, null)), Alignment.INSTANCE.getBottomCenter(), ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 27696, 96);
            Arrangement.Vertical verticalM2530spacedByD5KLDUw = Arrangement.INSTANCE.m2530spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(24), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2530spacedByD5KLDUw, centerHorizontally2, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -136611242, "C409@16358L29,409@16331L57,410@16442L35,410@16409L69:LenovoMigrationOnboarding.kt#h09ego");
            OnboardingPagerKt.OnboardingPageTitle(StringResources_androidKt.stringResource(migrationOnboardingPage.getTitleRes(), composer, 0), null, composer, 0, 2);
            OnboardingPagerKt.OnboardingPageDescription(StringResources_androidKt.stringResource(migrationOnboardingPage.getDescriptionRes(), composer, 0), null, composer, 0, 2);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationSlide$lambda$2(Modifier modifier, MigrationOnboardingPage migrationOnboardingPage, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C416@16625L913:LenovoMigrationOnboarding.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(628199311, i, -1, "com.myscript.nebo.ui.compose.MigrationSlide.<anonymous> (LenovoMigrationOnboarding.kt:416)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -466961434, "C417@16682L349,425@17048L476:LenovoMigrationOnboarding.kt#h09ego");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1873542122, "C419@16778L37,418@16737L276:LenovoMigrationOnboarding.kt#h09ego");
            ImageKt.Image(PainterResources_androidKt.painterResource(migrationOnboardingPage.getIllustrationRes(), composer, 0), (String) null, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, ContentScale.INSTANCE.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(64));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1683795449, "C432@17386L29,432@17359L57,433@17470L35,433@17437L69:LenovoMigrationOnboarding.kt#h09ego");
            OnboardingPagerKt.OnboardingPageTitle(StringResources_androidKt.stringResource(migrationOnboardingPage.getTitleRes(), composer, 0), null, composer, 0, 2);
            OnboardingPagerKt.OnboardingPageDescription(StringResources_androidKt.stringResource(migrationOnboardingPage.getDescriptionRes(), composer, 0), null, composer, 0, 2);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationSlide$lambda$3(Modifier modifier, MigrationOnboardingPage migrationOnboardingPage, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C439@17654L1000:LenovoMigrationOnboarding.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1576689040, i, -1, "com.myscript.nebo.ui.compose.MigrationSlide.<anonymous> (LenovoMigrationOnboarding.kt:439)");
            }
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, centerHorizontally, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -562206944, "C444@17875L290,451@18182L458:LenovoMigrationOnboarding.kt#h09ego");
            Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(64), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1862163687, "C446@17980L37,445@17939L208:LenovoMigrationOnboarding.kt#h09ego");
            ImageKt.Image(PainterResources_androidKt.painterResource(migrationOnboardingPage.getIllustrationRes(), composer, 0), (String) null, (Modifier) null, (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 108);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.Vertical verticalM2530spacedByD5KLDUw = Arrangement.INSTANCE.m2530spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2931widthInVpY3zN4$default = SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2530spacedByD5KLDUw, centerHorizontally2, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -401258732, "C456@18502L29,456@18475L57,457@18586L35,457@18553L69:LenovoMigrationOnboarding.kt#h09ego");
            OnboardingPagerKt.OnboardingPageTitle(StringResources_androidKt.stringResource(migrationOnboardingPage.getTitleRes(), composer, 0), null, composer, 0, 2);
            OnboardingPagerKt.OnboardingPageDescription(StringResources_androidKt.stringResource(migrationOnboardingPage.getDescriptionRes(), composer, 0), null, composer, 0, 2);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationSlide$lambda$0(Modifier modifier, MigrationOnboardingPage migrationOnboardingPage, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C463@18807L1179:LenovoMigrationOnboarding.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1268780147, i, -1, "com.myscript.nebo.ui.compose.MigrationSlide.<anonymous> (LenovoMigrationOnboarding.kt:463)");
            }
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -165230191, "C468@19029L289,475@19335L637:LenovoMigrationOnboarding.kt#h09ego");
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
            ComposerKt.sourceInformationMarkerStart(composer, -2035832374, "C470@19133L37,469@19092L208:LenovoMigrationOnboarding.kt#h09ego");
            ImageKt.Image(PainterResources_androidKt.painterResource(migrationOnboardingPage.getIllustrationRes(), composer, 0), (String) null, (Modifier) null, (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 108);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.Vertical verticalM2530spacedByD5KLDUw = Arrangement.INSTANCE.m2530spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getCenterVertically());
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2931widthInVpY3zN4$default = SizeKt.m2931widthInVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, C1486Dp.m11017constructorimpl(600), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM2530spacedByD5KLDUw, centerHorizontally2, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -4283994, "C482@19721L29,482@19694L57,484@19830L35,483@19772L182:LenovoMigrationOnboarding.kt#h09ego");
            OnboardingPagerKt.OnboardingPageTitle(StringResources_androidKt.stringResource(migrationOnboardingPage.getTitleRes(), composer, 0), null, composer, 0, 2);
            OnboardingPagerKt.OnboardingPageDescription(StringResources_androidKt.stringResource(migrationOnboardingPage.getDescriptionRes(), composer, 0), SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND), 1, null), composer, 48, 0);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MigrationBottomArea(final MigrationProgress migrationProgress, final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1433837790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MigrationBottomArea)N(progress,onFinished,onRetry,modifier)504@20389L1039:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(migrationProgress) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1433837790, i3, -1, "com.myscript.nebo.ui.compose.MigrationBottomArea (LenovoMigrationOnboarding.kt:503)");
                }
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(12));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
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
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1629124355, "C511@20648L55,513@20754L668,509@20560L862:LenovoMigrationOnboarding.kt#h09ego");
                Modifier modifier4 = companion;
                Phase phase = migrationProgress.getPhase();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640186271, "CC(remember):LenovoMigrationOnboarding.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LenovoMigrationOnboardingKt.MigrationBottomArea$lambda$0$0$0((AnimatedContentTransitionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedContentKt.AnimatedContent(phase, null, (Function1) objRememberedValue, null, "migration_bottom", null, ComposableLambdaKt.rememberComposableLambda(-2142614318, true, new Function4() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return LenovoMigrationOnboardingKt.MigrationBottomArea$lambda$0$1(migrationProgress, function0, function02, (AnimatedContentScope) obj, (Phase) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1597824, 42);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LenovoMigrationOnboardingKt.MigrationBottomArea$lambda$1(migrationProgress, function0, function02, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform MigrationBottomArea$lambda$0$0$0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MigrationBottomArea$lambda$0$1(MigrationProgress migrationProgress, Function0 function0, Function0 function02, AnimatedContentScope AnimatedContent, Phase phase, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(phase, "phase");
        ComposerKt.sourceInformation(composer, "CN(phase):LenovoMigrationOnboarding.kt#h09ego");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2142614318, i, -1, "com.myscript.nebo.ui.compose.MigrationBottomArea.<anonymous>.<anonymous> (LenovoMigrationOnboarding.kt:514)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                composer.startReplaceGroup(-1763019160);
                ComposerKt.sourceInformation(composer, "518@20930L22");
                ProgressArea(migrationProgress, composer, 0);
                composer.endReplaceGroup();
                break;
            case 5:
                composer.startReplaceGroup(1181043975);
                ComposerKt.sourceInformation(composer, "521@21006L289");
                ButtonsKt.LargeButton(C6079R.string.lenovo_migration_start_using, SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48)), function0, composer, 48);
                composer.endReplaceGroup();
                break;
            case 6:
                composer.startReplaceGroup(-1763005818);
                ComposerKt.sourceInformation(composer, "530@21346L52");
                ErrorArea(migrationProgress.getError(), function02, composer, 0);
                composer.endReplaceGroup();
                break;
            default:
                composer.startReplaceGroup(-1763023443);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void ProgressArea(final MigrationProgress migrationProgress, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1027354631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProgressArea)N(progress)540@21693L160,546@21859L496:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(migrationProgress) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1027354631, i2, -1, "com.myscript.nebo.ui.compose.ProgressArea (LenovoMigrationOnboarding.kt:537)");
            }
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(computeGlobalPercent(migrationProgress.getPhase(), migrationProgress.getPercent()) / 100.0f, AnimationSpecKt.tween$default(500, 0, null, 6, null), 0.0f, "migration_progress", null, composerStartRestartGroup, 3120, 20);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959940493, "C548@22003L55,549@22094L10,551@22188L6,547@21978L240,554@22228L121:LenovoMigrationOnboarding.kt#h09ego");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.lenovo_migration_setup_message, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4198getOnBackground0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody1(), composerStartRestartGroup, 0, 0, 65018);
            ProgressIndicatorKt.m4371LinearProgressIndicator_5eSRE(ProgressArea$lambda$0(stateAnimateFloatAsState), SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(PsExtractor.VIDEO_STREAM_MASK)), 0L, 0L, 0, composerStartRestartGroup, 48, 28);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.ProgressArea$lambda$2(migrationProgress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ErrorArea(final MigrationError migrationError, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1995916389);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorArea)N(error,onRetry)563@22444L589:LenovoMigrationOnboarding.kt#h09ego");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(migrationError == null ? -1 : migrationError.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1995916389, i2, -1, "com.myscript.nebo.ui.compose.ErrorArea (LenovoMigrationOnboarding.kt:562)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2010740453, "C568@22611L34,569@22681L10,571@22775L6,567@22586L218,573@22813L214:LenovoMigrationOnboarding.kt#h09ego");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(messageRes(migrationError), composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4198getOnBackground0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody1(), composerStartRestartGroup, 0, 0, 65018);
            composerStartRestartGroup = composerStartRestartGroup;
            ButtonsKt.LargeButton(C6079R.string.lenovo_migration_error_retry, SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280), 0.0f, 2, null), C1486Dp.m11017constructorimpl(48)), function0, composerStartRestartGroup, 48 | ((i2 << 3) & 896));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.LenovoMigrationOnboardingKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LenovoMigrationOnboardingKt.ErrorArea$lambda$1(migrationError, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int messageRes(MigrationError migrationError) {
        return C6079R.string.lenovo_migration_error_message;
    }

    public static final float computeGlobalPercent(Phase phase, int i) {
        float f;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(phase, "phase");
        switch (WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
            case 1:
                return 0.0f;
            case 2:
                if (i < 0) {
                    return 0.0f;
                }
                return i * 0.4f;
            case 3:
                f = 40.0f;
                if (i < 0) {
                    return 40.0f;
                }
                f2 = i;
                f3 = 0.1f;
                break;
            case 4:
                f = 50.0f;
                if (i < 0) {
                    return 50.0f;
                }
                f2 = i;
                f3 = 0.5f;
                break;
            case 5:
                return 100.0f;
            case 6:
                return 0.0f;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return (f2 * f3) + f;
    }

    private static final MigrationProgress LenovoMigrationOnboarding$lambda$0(State<MigrationProgress> state) {
        return state.getValue();
    }

    private static final float ProgressArea$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
