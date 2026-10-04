package com.myscript.nebo.trash.p033ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.C0028R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.MainActivityDetailFragment;
import com.myscript.nebo.Shortcut;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.trash.TrashViewModel;
import com.myscript.nebo.trash.TrashedPagesUIState;
import com.myscript.nebo.trash.p033ui.compose.TrashedPagesKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TrashedPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\f\u0011\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0002J\u001e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020 0-H\u0002J\b\u0010.\u001a\u00020\u0014H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/myscript/nebo/trash/ui/TrashedPagesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/MainActivityDetailFragment;", "<init>", "()V", "viewModel", "Lcom/myscript/nebo/trash/TrashViewModel;", "getViewModel", "()Lcom/myscript/nebo/trash/TrashViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "menuProvider", "com/myscript/nebo/trash/ui/TrashedPagesFragment$menuProvider$1", "Lcom/myscript/nebo/trash/ui/TrashedPagesFragment$menuProvider$1;", "selectionMode", "Lcom/myscript/android/utils/SelectionMode;", "selectionModeCallback", "com/myscript/nebo/trash/ui/TrashedPagesFragment$selectionModeCallback$1", "Lcom/myscript/nebo/trash/ui/TrashedPagesFragment$selectionModeCallback$1;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "toolbarContainer", "Landroid/widget/FrameLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "trashedPagesStateChanged", "", "state", "Lcom/myscript/nebo/trash/TrashedPagesUIState;", "onViewCreated", "view", "onDestroyView", "onPageLongClick", "pageModel", "Lcom/myscript/nebo/dms/core/model/PageModel;", "displayDeleteConfirmationDialog", "itemsToDeleteCount", "", "deleteAction", "Lkotlin/Function0;", "getToolbar", "onShortcut", "", "shortcut", "Lcom/myscript/nebo/Shortcut;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashedPagesFragment extends Fragment implements MainActivityDetailFragment {
    public static final String TAG = "TrashedPagesFragment";
    private SelectionMode selectionMode;
    private Toolbar toolbar;
    private FrameLayout toolbarContainer;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final TrashedPagesFragment$menuProvider$1 menuProvider = new TrashedPagesFragment$menuProvider$1(this);
    private final TrashedPagesFragment$selectionModeCallback$1 selectionModeCallback = new TrashedPagesFragment$selectionModeCallback$1(this);

    @JvmStatic
    public static final TrashedPagesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // com.myscript.nebo.MainActivityDetailFragment
    public boolean onShortcut(Shortcut shortcut) {
        Intrinsics.checkNotNullParameter(shortcut, "shortcut");
        return false;
    }

    public TrashedPagesFragment() {
        final TrashedPagesFragment trashedPagesFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(trashedPagesFragment, Reflection.getOrCreateKotlinClass(TrashViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return trashedPagesFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? trashedPagesFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrashedPagesFragment.viewModel_delegate$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrashViewModel getViewModel() {
        return (TrashViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return TrashViewModel.INSTANCE.getFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getViewModel().setThumbnailConfiguration(ScreenUtils.getFixedDisplayMetrics(requireActivity()));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(119284076, true, new Function2() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TrashedPagesFragment.onCreateView$lambda$0$0(composeView, inflater, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(ComposeView composeView, final LayoutInflater layoutInflater, final TrashedPagesFragment trashedPagesFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@6087L1386,137@5987L1486:TrashedPagesFragment.kt#xijr62");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(119284076, i, -1, "com.myscript.nebo.trash.ui.TrashedPagesFragment.onCreateView.<anonymous>.<anonymous> (TrashedPagesFragment.kt:137)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-1643248412, true, new Function2() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesFragment.onCreateView$lambda$0$0$0(layoutInflater, trashedPagesFragment, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(final LayoutInflater layoutInflater, final TrashedPagesFragment trashedPagesFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C138@6109L1346:TrashedPagesFragment.kt#xijr62");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643248412, i, -1, "com.myscript.nebo.trash.ui.TrashedPagesFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (TrashedPagesFragment.kt:138)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 558209834, "C139@6164L509,139@6142L593,150@6761L463,161@7291L30,161@7341L42,161@7405L27,161@7249L184:TrashedPagesFragment.kt#xijr62");
            ComposerKt.sourceInformationMarkerStart(composer, 295101355, "CC(remember):TrashedPagesFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(layoutInflater) | composer.changedInstance(trashedPagesFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrashedPagesFragment.onCreateView$lambda$0$0$0$0$0$0(layoutInflater, trashedPagesFragment, (Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer, 48, 4);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2014692931, "C154@6918L280:TrashedPagesFragment.kt#xijr62");
            TrashedPagesKt.TrashDisplayMode(PaddingKt.m2858paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterEnd()), 0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 0.0f, 11, null), trashedPagesFragment.getViewModel(), composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TrashViewModel viewModel = trashedPagesFragment.getViewModel();
            TrashViewModel viewModel2 = trashedPagesFragment.getViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, 295136940, "CC(remember):TrashedPagesFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(viewModel2);
            TrashedPagesFragment$onCreateView$1$1$1$1$3$1 trashedPagesFragment$onCreateView$1$1$1$1$3$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || trashedPagesFragment$onCreateView$1$1$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                trashedPagesFragment$onCreateView$1$1$1$1$3$1RememberedValue = new TrashedPagesFragment$onCreateView$1$1$1$1$3$1(viewModel2);
                composer.updateRememberedValue(trashedPagesFragment$onCreateView$1$1$1$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function1 = (Function1) ((KFunction) trashedPagesFragment$onCreateView$1$1$1$1$3$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 295138552, "CC(remember):TrashedPagesFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(trashedPagesFragment);
            TrashedPagesFragment$onCreateView$1$1$1$1$4$1 trashedPagesFragment$onCreateView$1$1$1$1$4$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance3 || trashedPagesFragment$onCreateView$1$1$1$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                trashedPagesFragment$onCreateView$1$1$1$1$4$1RememberedValue = new TrashedPagesFragment$onCreateView$1$1$1$1$4$1(trashedPagesFragment);
                composer.updateRememberedValue(trashedPagesFragment$onCreateView$1$1$1$1$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function12 = (Function1) ((KFunction) trashedPagesFragment$onCreateView$1$1$1$1$4$1RememberedValue);
            TrashViewModel viewModel3 = trashedPagesFragment.getViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, 295140585, "CC(remember):TrashedPagesFragment.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(viewModel3);
            TrashedPagesFragment$onCreateView$1$1$1$1$5$1 trashedPagesFragment$onCreateView$1$1$1$1$5$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance4 || trashedPagesFragment$onCreateView$1$1$1$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                trashedPagesFragment$onCreateView$1$1$1$1$5$1RememberedValue = new TrashedPagesFragment$onCreateView$1$1$1$1$5$1(viewModel3);
                composer.updateRememberedValue(trashedPagesFragment$onCreateView$1$1$1$1$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TrashedPagesKt.TrashedPagesPane(viewModel, function1, function12, (Function1) ((KFunction) trashedPagesFragment$onCreateView$1$1$1$1$5$1RememberedValue), composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateView$lambda$0$0$0$0$0$0(LayoutInflater layoutInflater, TrashedPagesFragment trashedPagesFragment, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View viewInflate = layoutInflater.inflate(C6079R.layout.trash_screen_toolbar, (ViewGroup) null, false);
        trashedPagesFragment.toolbar = (Toolbar) viewInflate.findViewById(C6079R.id.trashed_pages_toolbar);
        FragmentActivity fragmentActivityRequireActivity = trashedPagesFragment.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivityRequireActivity;
        appCompatActivity.setSupportActionBar(trashedPagesFragment.toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trashedPagesStateChanged(TrashedPagesUIState state) {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        if (state.isSelectionMode()) {
            SelectionMode selectionModeStartSelectionMode = this.selectionMode;
            if (selectionModeStartSelectionMode == null) {
                selectionModeStartSelectionMode = SelectionMode.startSelectionMode(fragmentActivityRequireActivity, this.toolbarContainer, this.selectionModeCallback);
            }
            this.selectionMode = selectionModeStartSelectionMode;
            if (selectionModeStartSelectionMode != null) {
                selectionModeStartSelectionMode.invalidate();
                return;
            }
            return;
        }
        ActionBar supportActionBar = ((AppCompatActivity) fragmentActivityRequireActivity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(state.getFolderName());
        }
        SelectionMode selectionMode = this.selectionMode;
        if (selectionMode != null) {
            selectionMode.finish();
        }
        this.selectionMode = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        fragmentActivityRequireActivity.addMenuProvider(this.menuProvider, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            this.toolbarContainer = (FrameLayout) view.findViewById(C6079R.id.trashed_pages_toolbar_container);
            getViewModel().getTrashedPagesState().observe(getViewLifecycleOwner(), new TrashedPagesFragment$sam$androidx_lifecycle_Observer$0(new TrashedPagesFragment$onViewCreated$1$1(this)));
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$onViewCreated$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    this.this$0.toolbarContainer = (FrameLayout) view.findViewById(C6079R.id.trashed_pages_toolbar_container);
                    this.this$0.getViewModel().getTrashedPagesState().observe(this.this$0.getViewLifecycleOwner(), new TrashedPagesFragment$sam$androidx_lifecycle_Observer$0(new TrashedPagesFragment$onViewCreated$1$1(this.this$0)));
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        requireActivity().removeMenuProvider(this.menuProvider);
        this.toolbar = null;
        this.toolbarContainer = null;
        this.selectionMode = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageLongClick(PageModel pageModel) {
        getViewModel().activatePagesSelectionMode(true);
        getViewModel().togglePageSelection(pageModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayDeleteConfirmationDialog(int itemsToDeleteCount, final Function0<Unit> deleteAction) {
        String cloudProvider = getViewModel().getCloudProvider();
        String quantityString = getResources().getQuantityString(!StringsKt.isBlank(cloudProvider) ? C6079R.plurals.delete_trashed_pages_with_cloud : C6079R.plurals.delete_trashed_pages_no_cloud, itemsToDeleteCount, cloudProvider);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6079R.string.delete_permanently_dialog_title).setMessage((CharSequence) quantityString).setPositiveButton(C6079R.string.delete_permanently_dialog_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                deleteAction.invoke();
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: compiled from: TrashedPagesFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/trash/ui/TrashedPagesFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/trash/ui/TrashedPagesFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TrashedPagesFragment newInstance() {
            return new TrashedPagesFragment();
        }
    }

    @Override // com.myscript.nebo.MainActivityDetailFragment
    public Toolbar getToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            return toolbar;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
