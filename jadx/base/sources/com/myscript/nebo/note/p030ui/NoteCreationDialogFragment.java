package com.myscript.nebo.note.p030ui;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0028R;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentKt;
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
import com.myscript.android.utils.DialogUtilsKt;
import com.myscript.android.utils.LocaleExt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.note.NoteCreationUIState;
import com.myscript.nebo.note.NoteCreationViewModel;
import com.myscript.nebo.note.NoteType;
import com.myscript.nebo.note.Orientation;
import com.myscript.nebo.note.PageSize;
import com.myscript.nebo.note.p030ui.compose.NoteCreationPaneKt;
import com.myscript.snt.core.PaperSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getLanguageViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "languageViewModel$delegate", "Lkotlin/Lazy;", "noteCreationViewModel", "Lcom/myscript/nebo/note/NoteCreationViewModel;", "getNoteCreationViewModel", "()Lcom/myscript/nebo/note/NoteCreationViewModel;", "noteCreationViewModel$delegate", "type", "Lcom/myscript/nebo/note/NoteType;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "composeView", "Landroid/view/View;", "languageFragmentView", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCreateDialog", "Landroid/app/Dialog;", "create", "openLanguageManager", "closeLanguageManager", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Result", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteCreationDialogFragment extends DialogFragment {
    private static final String ARGUMENTS_NOTE_TYPE_KEY = "ARGUMENTS_NOTE_TYPE_KEY";
    private static final String NOTE_COVER_COLORS_KEY = "NOTE_COVER_COLORS_KEY";
    private static final String NOTE_LANGUAGE_KEY = "NOTE_LANGUAGE_KEY";
    private static final String NOTE_NAME_KEY = "NOTE_NAME_KEY";
    private static final String NOTE_PAGE_COLOR_KEY = "NOTE_PAGE_COLOR_KEY";
    private static final String NOTE_PAGE_PATTERN_KEY = "NOTE_PAGE_PATTERN_KEY";
    private static final String NOTE_PAPER_HEIGHT_KEY = "NOTE_PAPER_HEIGHT_KEY";
    private static final String NOTE_PAPER_WIDTH_KEY = "NOTE_PAPER_WIDTH_KEY";
    public static final String REQUEST_KEY = "NoteCreationDialogFragment_REQUEST_KEY";
    private static final String TAG = "NoteCreationDialogFragment";
    private View composeView;
    private View languageFragmentView;

    /* JADX INFO: renamed from: languageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy languageViewModel;

    /* JADX INFO: renamed from: noteCreationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy noteCreationViewModel;
    private Toolbar toolbar;
    private NoteType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Portrait.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NoteType.values().length];
            try {
                iArr2[NoteType.Notebook.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[NoteType.Board.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[NoteType.Document.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @JvmStatic
    public static final Result Result(Bundle bundle) {
        return INSTANCE.Result(bundle);
    }

    @JvmStatic
    public static final NoteCreationDialogFragment newInstance(NoteType noteType) {
        return INSTANCE.newInstance(noteType);
    }

    public NoteCreationDialogFragment() {
        final NoteCreationDialogFragment noteCreationDialogFragment = this;
        final Function0 function0 = null;
        this.languageViewModel = FragmentViewModelLazyKt.createViewModelLazy(noteCreationDialogFragment, Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return noteCreationDialogFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? noteCreationDialogFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NoteCreationDialogFragment.languageViewModel_delegate$lambda$0(this.f$0);
            }
        });
        Function0 function02 = new Function0() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NoteCreationDialogFragment.noteCreationViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return noteCreationDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.noteCreationViewModel = FragmentViewModelLazyKt.createViewModelLazy(noteCreationDialogFragment, Reflection.getOrCreateKotlinClass(NoteCreationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
    }

    private final LanguageViewModel getLanguageViewModel() {
        return (LanguageViewModel) this.languageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory languageViewModel_delegate$lambda$0(NoteCreationDialogFragment noteCreationDialogFragment) {
        FragmentActivity fragmentActivityRequireActivity = noteCreationDialogFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Configuration configuration = fragmentActivityRequireActivity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        Locale primaryLocale = LocaleExt.getPrimaryLocale(configuration);
        ComponentCallbacks2 application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider");
        return new LanguageViewModel.Factory(new LanguageNameHelper(primaryLocale), ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages());
    }

    private final NoteCreationViewModel getNoteCreationViewModel() {
        return (NoteCreationViewModel) this.noteCreationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory noteCreationViewModel_delegate$lambda$0(NoteCreationDialogFragment noteCreationDialogFragment) {
        NoteCreationViewModel.Companion companion = NoteCreationViewModel.INSTANCE;
        NoteType noteType = noteCreationDialogFragment.type;
        if (noteType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            noteType = null;
        }
        return companion.Factory(noteType);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", LaunchActivity.LaunchRoute.Language, "getLanguage", "Notebook", "Board", "Document", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Board;", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Document;", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Notebook;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Result {
        public static final int $stable = 0;
        private final String language;
        private final String name;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
            this.name = "";
        }

        public String getName() {
            return this.name;
        }

        public String getLanguage() {
            return this.language;
        }

        /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Notebook;", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result;", "name", "", LaunchActivity.LaunchRoute.Language, "coverColors", "", "", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "pageColor", "pagePattern", "Lcom/myscript/atk/core/BackgroundPattern;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/myscript/snt/core/PaperSize;ILcom/myscript/atk/core/BackgroundPattern;)V", "getName", "()Ljava/lang/String;", "getLanguage", "getCoverColors", "()Ljava/util/List;", "getPaperSize", "()Lcom/myscript/snt/core/PaperSize;", "getPageColor", "()I", "getPagePattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Notebook extends Result {
            public static final int $stable = 8;
            private final List<Integer> coverColors;
            private final String language;
            private final String name;
            private final int pageColor;
            private final BackgroundPattern pagePattern;
            private final PaperSize paperSize;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Notebook copy$default(Notebook notebook, String str, String str2, List list, PaperSize paperSize, int i, BackgroundPattern backgroundPattern, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = notebook.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = notebook.language;
                }
                if ((i2 & 4) != 0) {
                    list = notebook.coverColors;
                }
                if ((i2 & 8) != 0) {
                    paperSize = notebook.paperSize;
                }
                if ((i2 & 16) != 0) {
                    i = notebook.pageColor;
                }
                if ((i2 & 32) != 0) {
                    backgroundPattern = notebook.pagePattern;
                }
                int i3 = i;
                BackgroundPattern backgroundPattern2 = backgroundPattern;
                return notebook.copy(str, str2, list, paperSize, i3, backgroundPattern2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getLanguage() {
                return this.language;
            }

            public final List<Integer> component3() {
                return this.coverColors;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final PaperSize getPaperSize() {
                return this.paperSize;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getPageColor() {
                return this.pageColor;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final BackgroundPattern getPagePattern() {
                return this.pagePattern;
            }

            public final Notebook copy(String name, String language, List<Integer> coverColors, PaperSize paperSize, int pageColor, BackgroundPattern pagePattern) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                Intrinsics.checkNotNullParameter(coverColors, "coverColors");
                Intrinsics.checkNotNullParameter(paperSize, "paperSize");
                Intrinsics.checkNotNullParameter(pagePattern, "pagePattern");
                return new Notebook(name, language, coverColors, paperSize, pageColor, pagePattern);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Notebook)) {
                    return false;
                }
                Notebook notebook = (Notebook) other;
                return Intrinsics.areEqual(this.name, notebook.name) && Intrinsics.areEqual(this.language, notebook.language) && Intrinsics.areEqual(this.coverColors, notebook.coverColors) && Intrinsics.areEqual(this.paperSize, notebook.paperSize) && this.pageColor == notebook.pageColor && this.pagePattern == notebook.pagePattern;
            }

            public int hashCode() {
                return (((((((((this.name.hashCode() * 31) + this.language.hashCode()) * 31) + this.coverColors.hashCode()) * 31) + this.paperSize.hashCode()) * 31) + Integer.hashCode(this.pageColor)) * 31) + this.pagePattern.hashCode();
            }

            public String toString() {
                return "Notebook(name=" + this.name + ", language=" + this.language + ", coverColors=" + this.coverColors + ", paperSize=" + this.paperSize + ", pageColor=" + this.pageColor + ", pagePattern=" + this.pagePattern + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Notebook(String name, String language, List<Integer> coverColors, PaperSize paperSize, int i, BackgroundPattern pagePattern) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                Intrinsics.checkNotNullParameter(coverColors, "coverColors");
                Intrinsics.checkNotNullParameter(paperSize, "paperSize");
                Intrinsics.checkNotNullParameter(pagePattern, "pagePattern");
                this.name = name;
                this.language = language;
                this.coverColors = coverColors;
                this.paperSize = paperSize;
                this.pageColor = i;
                this.pagePattern = pagePattern;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getName() {
                return this.name;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getLanguage() {
                return this.language;
            }

            public final List<Integer> getCoverColors() {
                return this.coverColors;
            }

            public final PaperSize getPaperSize() {
                return this.paperSize;
            }

            public final int getPageColor() {
                return this.pageColor;
            }

            public final BackgroundPattern getPagePattern() {
                return this.pagePattern;
            }
        }

        /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Board;", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result;", "name", "", LaunchActivity.LaunchRoute.Language, "pageColor", "", "pagePattern", "Lcom/myscript/atk/core/BackgroundPattern;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/myscript/atk/core/BackgroundPattern;)V", "getName", "()Ljava/lang/String;", "getLanguage", "getPageColor", "()I", "getPagePattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Board extends Result {
            public static final int $stable = 0;
            private final String language;
            private final String name;
            private final int pageColor;
            private final BackgroundPattern pagePattern;

            public static /* synthetic */ Board copy$default(Board board, String str, String str2, int i, BackgroundPattern backgroundPattern, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = board.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = board.language;
                }
                if ((i2 & 4) != 0) {
                    i = board.pageColor;
                }
                if ((i2 & 8) != 0) {
                    backgroundPattern = board.pagePattern;
                }
                return board.copy(str, str2, i, backgroundPattern);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getLanguage() {
                return this.language;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getPageColor() {
                return this.pageColor;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final BackgroundPattern getPagePattern() {
                return this.pagePattern;
            }

            public final Board copy(String name, String language, int pageColor, BackgroundPattern pagePattern) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                Intrinsics.checkNotNullParameter(pagePattern, "pagePattern");
                return new Board(name, language, pageColor, pagePattern);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Board)) {
                    return false;
                }
                Board board = (Board) other;
                return Intrinsics.areEqual(this.name, board.name) && Intrinsics.areEqual(this.language, board.language) && this.pageColor == board.pageColor && this.pagePattern == board.pagePattern;
            }

            public int hashCode() {
                return (((((this.name.hashCode() * 31) + this.language.hashCode()) * 31) + Integer.hashCode(this.pageColor)) * 31) + this.pagePattern.hashCode();
            }

            public String toString() {
                return "Board(name=" + this.name + ", language=" + this.language + ", pageColor=" + this.pageColor + ", pagePattern=" + this.pagePattern + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Board(String name, String language, int i, BackgroundPattern pagePattern) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                Intrinsics.checkNotNullParameter(pagePattern, "pagePattern");
                this.name = name;
                this.language = language;
                this.pageColor = i;
                this.pagePattern = pagePattern;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getName() {
                return this.name;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getLanguage() {
                return this.language;
            }

            public final int getPageColor() {
                return this.pageColor;
            }

            public final BackgroundPattern getPagePattern() {
                return this.pagePattern;
            }
        }

        /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result$Document;", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result;", "name", "", LaunchActivity.LaunchRoute.Language, "pageColor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getLanguage", "getPageColor", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Document extends Result {
            public static final int $stable = 0;
            private final String language;
            private final String name;
            private final int pageColor;

            public static /* synthetic */ Document copy$default(Document document, String str, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = document.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = document.language;
                }
                if ((i2 & 4) != 0) {
                    i = document.pageColor;
                }
                return document.copy(str, str2, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getLanguage() {
                return this.language;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getPageColor() {
                return this.pageColor;
            }

            public final Document copy(String name, String language, int pageColor) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                return new Document(name, language, pageColor);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Document)) {
                    return false;
                }
                Document document = (Document) other;
                return Intrinsics.areEqual(this.name, document.name) && Intrinsics.areEqual(this.language, document.language) && this.pageColor == document.pageColor;
            }

            public int hashCode() {
                return (((this.name.hashCode() * 31) + this.language.hashCode()) * 31) + Integer.hashCode(this.pageColor);
            }

            public String toString() {
                return "Document(name=" + this.name + ", language=" + this.language + ", pageColor=" + this.pageColor + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Document(String name, String language, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(language, "language");
                this.name = name;
                this.language = language;
                this.pageColor = i;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getName() {
                return this.name;
            }

            @Override // com.myscript.nebo.note.ui.NoteCreationDialogFragment.Result
            public String getLanguage() {
                return this.language;
            }

            public final int getPageColor() {
                return this.pageColor;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        NoteType noteTypeValueOf;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARGUMENTS_NOTE_TYPE_KEY)) == null || (noteTypeValueOf = NoteType.valueOf(string)) == null) {
            throw new IllegalStateException("Missing note type argument".toString());
        }
        this.type = noteTypeValueOf;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6079R.layout.note_creation_dialog, container);
        DialogFragmentExt.allowWindowToBeResizedWithVirtualKeyboard(this);
        this.toolbar = (Toolbar) viewInflate.findViewById(C6079R.id.note_creation_dialog_fragment_toolbar);
        View viewFindViewById = viewInflate.findViewById(C6079R.id.note_creation_dialog_compose);
        final ComposeView composeView = (ComposeView) viewFindViewById;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1499098134, true, new Function2() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NoteCreationDialogFragment.onCreateView$lambda$0$0$0(composeView, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        this.composeView = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C6079R.id.note_creation_dialog_fragment_container);
        getChildFragmentManager().beginTransaction().replace(((FragmentContainerView) viewFindViewById2).getId(), new LanguageManagerFragment()).commit();
        this.languageFragmentView = viewFindViewById2;
        Intrinsics.checkNotNullExpressionValue(viewInflate, "apply(...)");
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(ComposeView composeView, final NoteCreationDialogFragment noteCreationDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@4865L1214,118@4606L1473:NoteCreationDialogFragment.kt#qfy3f4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499098134, i, -1, "com.myscript.nebo.note.ui.NoteCreationDialogFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (NoteCreationDialogFragment.kt:118)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            long jColor = ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary));
            Context context2 = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            ThemeKt.m13016NeboDialogThemeeopBjH0(false, jColor, ColorKt.Color(ContextExtKt.resolveColorAttribute(context2, R.attr.colorBackgroundFloating)), ComposableLambdaKt.rememberComposableLambda(-1077754087, true, new Function2() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0(final NoteCreationDialogFragment noteCreationDialogFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C124@5067L47,125@5170L55,126@5280L62,127@5399L60,128@5514L59,129@5631L67,130@5753L65,131@5871L52,132@5968L8,133@6022L9,121@4891L1166:NoteCreationDialogFragment.kt#qfy3f4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1077754087, i, -1, "com.myscript.nebo.note.ui.NoteCreationDialogFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NoteCreationDialogFragment.kt:121)");
            }
            NoteCreationViewModel noteCreationViewModel = noteCreationDialogFragment.getNoteCreationViewModel();
            LanguageViewModel languageViewModel = noteCreationDialogFragment.getLanguageViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -634552760, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$0$0(this.f$0, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634549456, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$1$0(this.f$0, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function12 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634545929, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$2$0(this.f$0, (PageBackgroundColor) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function13 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634542123, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$3$0(this.f$0, (PageBackgroundPattern) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function14 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634538444, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$4$0(this.f$0, (PageSize) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function15 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634534692, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$5$0(this.f$0, (Orientation) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function16 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634530790, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance7 = composer.changedInstance(noteCreationDialogFragment);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationDialogFragment.onCreateView$lambda$0$0$0$0$6$0(this.f$0, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function1 function17 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -634527027, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance8 = composer.changedInstance(noteCreationDialogFragment);
            NoteCreationDialogFragment$onCreateView$1$1$1$1$8$1 noteCreationDialogFragment$onCreateView$1$1$1$1$8$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance8 || noteCreationDialogFragment$onCreateView$1$1$1$1$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                noteCreationDialogFragment$onCreateView$1$1$1$1$8$1RememberedValue = new NoteCreationDialogFragment$onCreateView$1$1$1$1$8$1(noteCreationDialogFragment);
                composer.updateRememberedValue(noteCreationDialogFragment$onCreateView$1$1$1$1$8$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) noteCreationDialogFragment$onCreateView$1$1$1$1$8$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -634523967, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance9 = composer.changedInstance(noteCreationDialogFragment);
            NoteCreationDialogFragment$onCreateView$1$1$1$1$9$1 noteCreationDialogFragment$onCreateView$1$1$1$1$9$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance9 || noteCreationDialogFragment$onCreateView$1$1$1$1$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                noteCreationDialogFragment$onCreateView$1$1$1$1$9$1RememberedValue = new NoteCreationDialogFragment$onCreateView$1$1$1$1$9$1(noteCreationDialogFragment);
                composer.updateRememberedValue(noteCreationDialogFragment$onCreateView$1$1$1$1$9$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function02 = (Function0) ((KFunction) noteCreationDialogFragment$onCreateView$1$1$1$1$9$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -634522238, "CC(remember):NoteCreationDialogFragment.kt#9igjgp");
            boolean zChangedInstance10 = composer.changedInstance(noteCreationDialogFragment);
            NoteCreationDialogFragment$onCreateView$1$1$1$1$10$1 noteCreationDialogFragment$onCreateView$1$1$1$1$10$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance10 || noteCreationDialogFragment$onCreateView$1$1$1$1$10$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                noteCreationDialogFragment$onCreateView$1$1$1$1$10$1RememberedValue = new NoteCreationDialogFragment$onCreateView$1$1$1$1$10$1(noteCreationDialogFragment);
                composer.updateRememberedValue(noteCreationDialogFragment$onCreateView$1$1$1$1$10$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NoteCreationPaneKt.NoteCreationPane(noteCreationViewModel, languageViewModel, function1, function12, function13, function14, function15, function16, function17, function0, function02, (Function0) ((KFunction) noteCreationDialogFragment$onCreateView$1$1$1$1$10$1RememberedValue), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$0$0(NoteCreationDialogFragment noteCreationDialogFragment, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        noteCreationDialogFragment.getNoteCreationViewModel().setName(name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$1$0(NoteCreationDialogFragment noteCreationDialogFragment, int i) {
        noteCreationDialogFragment.getNoteCreationViewModel().setCoverColor(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$2$0(NoteCreationDialogFragment noteCreationDialogFragment, PageBackgroundColor pageColor) {
        Intrinsics.checkNotNullParameter(pageColor, "pageColor");
        noteCreationDialogFragment.getNoteCreationViewModel().setPageColor(pageColor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$3$0(NoteCreationDialogFragment noteCreationDialogFragment, PageBackgroundPattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        noteCreationDialogFragment.getNoteCreationViewModel().setPagePattern(pattern);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$4$0(NoteCreationDialogFragment noteCreationDialogFragment, PageSize pageSize) {
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        noteCreationDialogFragment.getNoteCreationViewModel().setPageSize(pageSize);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$5$0(NoteCreationDialogFragment noteCreationDialogFragment, Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        noteCreationDialogFragment.getNoteCreationViewModel().setOrientation(orientation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$6$0(NoteCreationDialogFragment noteCreationDialogFragment, String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        noteCreationDialogFragment.getNoteCreationViewModel().setLanguage(languageKey);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getNoteCreationViewModel().getNoteCreationUIState().observe(getViewLifecycleOwner(), new NoteCreationDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NoteCreationDialogFragment.onViewCreated$lambda$0(this.f$0, (NoteCreationUIState) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(NoteCreationDialogFragment noteCreationDialogFragment, NoteCreationUIState noteCreationUIState) {
        Toolbar toolbar = noteCreationDialogFragment.toolbar;
        if (toolbar != null) {
            toolbar.setTitle(noteCreationUIState.getDialogTitle());
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(dialogOnCreateDialog);
        DialogUtilsKt.configureForEdgeToEdge(dialogOnCreateDialog);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void create() {
        Pair pairM1606to;
        NoteType noteType;
        NoteType noteType2;
        NoteType noteType3;
        getNoteCreationViewModel().confirmNoteCreation();
        NoteCreationUIState value = getNoteCreationViewModel().getNoteCreationUIState().getValue();
        if (value != null) {
            NoteType noteType4 = this.type;
            if (noteType4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("type");
                noteType4 = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[noteType4.ordinal()];
            if (i == 1) {
                PaperSize paperSize = value.getNotebookDetailsState().getPageSize().getPaperSize();
                Orientation orientation = value.getNotebookDetailsState().getCoverData().getOrientation();
                ImmutableList<Color> colors = value.getNotebookDetailsState().getCoverData().getColors();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors, 10));
                Iterator<Color> it = colors.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(ColorKt.m8202toArgb8_81llA(it.next().m8158unboximpl())));
                }
                ArrayList arrayList2 = arrayList;
                int i2 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
                if (i2 == 1) {
                    pairM1606to = TuplesKt.m1606to(Float.valueOf(paperSize.getWidth()), Float.valueOf(paperSize.getHeight()));
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pairM1606to = TuplesKt.m1606to(Float.valueOf(paperSize.getHeight()), Float.valueOf(paperSize.getWidth()));
                }
                float fFloatValue = ((Number) pairM1606to.component1()).floatValue();
                float fFloatValue2 = ((Number) pairM1606to.component2()).floatValue();
                for (PageBackgroundColor pageBackgroundColor : value.getPageColorState().getColors()) {
                    if (pageBackgroundColor.isSelected()) {
                        int color = pageBackgroundColor.getColor();
                        for (PageBackgroundPattern pageBackgroundPattern : value.getPagePatternState().getPatterns()) {
                            if (pageBackgroundPattern.isSelected()) {
                                NoteCreationDialogFragment noteCreationDialogFragment = this;
                                Bundle bundle = new Bundle();
                                NoteType noteType5 = this.type;
                                if (noteType5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("type");
                                    noteType = null;
                                } else {
                                    noteType = noteType5;
                                }
                                bundle.putString(ARGUMENTS_NOTE_TYPE_KEY, noteType.name());
                                bundle.putString("NOTE_NAME_KEY", value.getNoteName());
                                bundle.putString(NOTE_LANGUAGE_KEY, value.getLanguage());
                                bundle.putIntArray(NOTE_COVER_COLORS_KEY, CollectionsKt.toIntArray(arrayList2));
                                bundle.putFloat(NOTE_PAPER_WIDTH_KEY, fFloatValue);
                                bundle.putFloat(NOTE_PAPER_HEIGHT_KEY, fFloatValue2);
                                bundle.putInt(NOTE_PAGE_COLOR_KEY, color);
                                bundle.putString(NOTE_PAGE_PATTERN_KEY, pageBackgroundPattern.getPattern().name());
                                Unit unit = Unit.INSTANCE;
                                FragmentKt.setFragmentResult(noteCreationDialogFragment, REQUEST_KEY, bundle);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                for (PageBackgroundColor pageBackgroundColor2 : value.getPageColorState().getColors()) {
                    if (pageBackgroundColor2.isSelected()) {
                        int color2 = pageBackgroundColor2.getColor();
                        NoteCreationDialogFragment noteCreationDialogFragment2 = this;
                        Bundle bundle2 = new Bundle();
                        NoteType noteType6 = this.type;
                        if (noteType6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("type");
                            noteType3 = null;
                        } else {
                            noteType3 = noteType6;
                        }
                        bundle2.putString(ARGUMENTS_NOTE_TYPE_KEY, noteType3.name());
                        bundle2.putString("NOTE_NAME_KEY", value.getNoteName());
                        bundle2.putString(NOTE_LANGUAGE_KEY, value.getLanguage());
                        bundle2.putInt(NOTE_PAGE_COLOR_KEY, color2);
                        Unit unit2 = Unit.INSTANCE;
                        FragmentKt.setFragmentResult(noteCreationDialogFragment2, REQUEST_KEY, bundle2);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            for (PageBackgroundColor pageBackgroundColor3 : value.getPageColorState().getColors()) {
                if (pageBackgroundColor3.isSelected()) {
                    int color3 = pageBackgroundColor3.getColor();
                    for (PageBackgroundPattern pageBackgroundPattern2 : value.getPagePatternState().getPatterns()) {
                        if (pageBackgroundPattern2.isSelected()) {
                            NoteCreationDialogFragment noteCreationDialogFragment3 = this;
                            Bundle bundle3 = new Bundle();
                            NoteType noteType7 = this.type;
                            if (noteType7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("type");
                                noteType2 = null;
                            } else {
                                noteType2 = noteType7;
                            }
                            bundle3.putString(ARGUMENTS_NOTE_TYPE_KEY, noteType2.name());
                            bundle3.putString("NOTE_NAME_KEY", value.getNoteName());
                            bundle3.putString(NOTE_LANGUAGE_KEY, value.getLanguage());
                            bundle3.putInt(NOTE_PAGE_COLOR_KEY, color3);
                            bundle3.putString(NOTE_PAGE_PATTERN_KEY, pageBackgroundPattern2.getPattern().name());
                            Unit unit3 = Unit.INSTANCE;
                            FragmentKt.setFragmentResult(noteCreationDialogFragment3, REQUEST_KEY, bundle3);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openLanguageManager() {
        View view = this.languageFragmentView;
        if (view != null) {
            view.setVisibility(0);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            Resources resources = getResources();
            int i = C6183R.drawable.ic_arrow_back;
            Context context = getContext();
            toolbar.setNavigationIcon(resources.getDrawable(i, context != null ? context.getTheme() : null));
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.note.ui.NoteCreationDialogFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.closeLanguageManager();
                }
            });
        }
        View view2 = this.composeView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeLanguageManager() {
        View view = this.languageFragmentView;
        if (view != null) {
            view.setVisibility(8);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setNavigationIcon((Drawable) null);
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            toolbar2.setNavigationOnClickListener(null);
        }
        View view2 = this.composeView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", NoteCreationDialogFragment.ARGUMENTS_NOTE_TYPE_KEY, "NOTE_NAME_KEY", NoteCreationDialogFragment.NOTE_LANGUAGE_KEY, NoteCreationDialogFragment.NOTE_COVER_COLORS_KEY, NoteCreationDialogFragment.NOTE_PAPER_WIDTH_KEY, NoteCreationDialogFragment.NOTE_PAPER_HEIGHT_KEY, NoteCreationDialogFragment.NOTE_PAGE_COLOR_KEY, NoteCreationDialogFragment.NOTE_PAGE_PATTERN_KEY, "newInstance", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment;", "type", "Lcom/myscript/nebo/note/NoteType;", "Result", "Lcom/myscript/nebo/note/ui/NoteCreationDialogFragment$Result;", "bundle", "Landroid/os/Bundle;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NoteType.values().length];
                try {
                    iArr[NoteType.Notebook.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[NoteType.Board.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[NoteType.Document.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NoteCreationDialogFragment newInstance(NoteType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            NoteCreationDialogFragment noteCreationDialogFragment = new NoteCreationDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(NoteCreationDialogFragment.ARGUMENTS_NOTE_TYPE_KEY, type.name());
            noteCreationDialogFragment.setArguments(bundle);
            return noteCreationDialogFragment;
        }

        @JvmStatic
        public final Result Result(Bundle bundle) {
            NoteType noteTypeValueOf;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(NoteCreationDialogFragment.ARGUMENTS_NOTE_TYPE_KEY);
            if (string == null || (noteTypeValueOf = NoteType.valueOf(string)) == null) {
                throw new IllegalStateException("Missing note type argument".toString());
            }
            int i = WhenMappings.$EnumSwitchMapping$0[noteTypeValueOf.ordinal()];
            if (i == 1) {
                float f = bundle.getFloat(NoteCreationDialogFragment.NOTE_PAPER_WIDTH_KEY);
                float f2 = bundle.getFloat(NoteCreationDialogFragment.NOTE_PAPER_HEIGHT_KEY);
                String string2 = bundle.getString("NOTE_NAME_KEY");
                if (string2 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                String string3 = bundle.getString(NoteCreationDialogFragment.NOTE_LANGUAGE_KEY);
                if (string3 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                int[] intArray = bundle.getIntArray(NoteCreationDialogFragment.NOTE_COVER_COLORS_KEY);
                if (intArray == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                List<Integer> list = ArraysKt.toList(intArray);
                PaperSize paperSize = new PaperSize(f, f2);
                int i2 = bundle.getInt(NoteCreationDialogFragment.NOTE_PAGE_COLOR_KEY);
                String string4 = bundle.getString(NoteCreationDialogFragment.NOTE_PAGE_PATTERN_KEY);
                BackgroundPattern backgroundPatternValueOf = string4 != null ? BackgroundPattern.valueOf(string4) : null;
                if (backgroundPatternValueOf != null) {
                    return new Result.Notebook(string2, string3, list, paperSize, i2, backgroundPatternValueOf);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                String string5 = bundle.getString("NOTE_NAME_KEY");
                if (string5 == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                String string6 = bundle.getString(NoteCreationDialogFragment.NOTE_LANGUAGE_KEY);
                if (string6 != null) {
                    return new Result.Document(string5, string6, bundle.getInt(NoteCreationDialogFragment.NOTE_PAGE_COLOR_KEY));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String string7 = bundle.getString("NOTE_NAME_KEY");
            if (string7 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String string8 = bundle.getString(NoteCreationDialogFragment.NOTE_LANGUAGE_KEY);
            if (string8 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int i3 = bundle.getInt(NoteCreationDialogFragment.NOTE_PAGE_COLOR_KEY);
            String string9 = bundle.getString(NoteCreationDialogFragment.NOTE_PAGE_PATTERN_KEY);
            BackgroundPattern backgroundPatternValueOf2 = string9 != null ? BackgroundPattern.valueOf(string9) : null;
            if (backgroundPatternValueOf2 != null) {
                return new Result.Board(string7, string8, i3, backgroundPatternValueOf2);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }
}
