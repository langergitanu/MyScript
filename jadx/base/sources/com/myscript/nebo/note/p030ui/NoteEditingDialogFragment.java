package com.myscript.nebo.note.p030ui;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0028R;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.note.NoteEditingViewModel;
import com.myscript.nebo.note.p030ui.compose.NoteEditingPaneKt;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* JADX INFO: compiled from: NoteEditingDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteEditingDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/PageKey;", "noteEditingViewModel", "Lcom/myscript/nebo/note/NoteEditingViewModel;", "getNoteEditingViewModel", "()Lcom/myscript/nebo/note/NoteEditingViewModel;", "noteEditingViewModel$delegate", "Lkotlin/Lazy;", "composeView", "Landroid/view/View;", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteEditingDialogFragment extends DialogFragment {
    private static final String ARGUMENTS_NOTE_PAGE_KEY = "ARGUMENTS_NOTE_PAGE_KEY";
    private static final String TAG = "NoteEditingDialogFragment";
    private View composeView;
    private PageKey key;

    /* JADX INFO: renamed from: noteEditingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy noteEditingViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final NoteEditingDialogFragment newInstance(PageKey pageKey) {
        return INSTANCE.newInstance(pageKey);
    }

    public NoteEditingDialogFragment() {
        final NoteEditingDialogFragment noteEditingDialogFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NoteEditingDialogFragment.noteEditingViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return noteEditingDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.noteEditingViewModel = FragmentViewModelLazyKt.createViewModelLazy(noteEditingDialogFragment, Reflection.getOrCreateKotlinClass(NoteEditingViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
    }

    private final NoteEditingViewModel getNoteEditingViewModel() {
        return (NoteEditingViewModel) this.noteEditingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory noteEditingViewModel_delegate$lambda$0(NoteEditingDialogFragment noteEditingDialogFragment) {
        PageKey pageKey = noteEditingDialogFragment.key;
        if (pageKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SubscriberAttributeKt.JSON_NAME_KEY);
            pageKey = null;
        }
        return new NoteEditingViewModel.NoteEditionViewModelFactory(pageKey);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        PageKey pageKeyDeserialize;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARGUMENTS_NOTE_PAGE_KEY)) == null || (pageKeyDeserialize = PageKey.deserialize(string)) == null) {
            throw new IllegalStateException("Missing note key argument".toString());
        }
        this.key = pageKeyDeserialize;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6079R.layout.note_editing_dialog, container);
        DialogFragmentExt.allowWindowToBeResizedWithVirtualKeyboard(this);
        View viewFindViewById = viewInflate.findViewById(C6079R.id.note_editing_dialog_compose);
        final ComposeView composeView = (ComposeView) viewFindViewById;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1584811968, true, new Function2() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NoteEditingDialogFragment.onCreateView$lambda$0$0$0(composeView, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        this.composeView = viewFindViewById;
        Intrinsics.checkNotNullExpressionValue(viewInflate, "apply(...)");
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(ComposeView composeView, final NoteEditingDialogFragment noteEditingDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@2443L605,52@2184L864:NoteEditingDialogFragment.kt#qfy3f4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584811968, i, -1, "com.myscript.nebo.note.ui.NoteEditingDialogFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (NoteEditingDialogFragment.kt:52)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            long jColor = ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary));
            Context context2 = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            ThemeKt.m13016NeboDialogThemeeopBjH0(false, jColor, ColorKt.Color(ContextExtKt.resolveColorAttribute(context2, R.attr.colorBackgroundFloating)), ComposableLambdaKt.rememberComposableLambda(-162233681, true, new Function2() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteEditingDialogFragment.onCreateView$lambda$0$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0(final NoteEditingDialogFragment noteEditingDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C57@2592L47,58@2695L54,59@2792L153,63@2991L9,55@2469L557:NoteEditingDialogFragment.kt#qfy3f4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-162233681, i, -1, "com.myscript.nebo.note.ui.NoteEditingDialogFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NoteEditingDialogFragment.kt:55)");
            }
            NoteEditingViewModel noteEditingViewModel = noteEditingDialogFragment.getNoteEditingViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -1287739970, "CC(remember):NoteEditingDialogFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(noteEditingDialogFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteEditingDialogFragment.onCreateView$lambda$0$0$0$0$0$0(this.f$0, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1287736667, "CC(remember):NoteEditingDialogFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(noteEditingDialogFragment);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteEditingDialogFragment.onCreateView$lambda$0$0$0$0$1$0(this.f$0, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function12 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1287733464, "CC(remember):NoteEditingDialogFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(noteEditingDialogFragment);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.note.ui.NoteEditingDialogFragment$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NoteEditingDialogFragment.onCreateView$lambda$0$0$0$0$2$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1287727240, "CC(remember):NoteEditingDialogFragment.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(noteEditingDialogFragment);
            NoteEditingDialogFragment$onCreateView$1$1$1$1$4$1 noteEditingDialogFragment$onCreateView$1$1$1$1$4$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance4 || noteEditingDialogFragment$onCreateView$1$1$1$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                noteEditingDialogFragment$onCreateView$1$1$1$1$4$1RememberedValue = new NoteEditingDialogFragment$onCreateView$1$1$1$1$4$1(noteEditingDialogFragment);
                composer.updateRememberedValue(noteEditingDialogFragment$onCreateView$1$1$1$1$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NoteEditingPaneKt.NoteEditingPane(noteEditingViewModel, function1, function12, function0, (Function0) ((KFunction) noteEditingDialogFragment$onCreateView$1$1$1$1$4$1RememberedValue), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$0$0(NoteEditingDialogFragment noteEditingDialogFragment, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        noteEditingDialogFragment.getNoteEditingViewModel().setTitle(name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$1$0(NoteEditingDialogFragment noteEditingDialogFragment, int i) {
        noteEditingDialogFragment.getNoteEditingViewModel().setCoverColor(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$2$0(NoteEditingDialogFragment noteEditingDialogFragment) {
        noteEditingDialogFragment.getNoteEditingViewModel().applyChanges();
        noteEditingDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    /* JADX INFO: compiled from: NoteEditingDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteEditingDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", NoteEditingDialogFragment.ARGUMENTS_NOTE_PAGE_KEY, "newInstance", "Lcom/myscript/nebo/note/ui/NoteEditingDialogFragment;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/PageKey;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NoteEditingDialogFragment newInstance(PageKey key) {
            Intrinsics.checkNotNullParameter(key, "key");
            NoteEditingDialogFragment noteEditingDialogFragment = new NoteEditingDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(NoteEditingDialogFragment.ARGUMENTS_NOTE_PAGE_KEY, key.serialize());
            noteEditingDialogFragment.setArguments(bundle);
            return noteEditingDialogFragment;
        }
    }
}
