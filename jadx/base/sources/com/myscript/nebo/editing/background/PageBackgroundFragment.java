package com.myscript.nebo.editing.background;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.C4627R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.card.MaterialCardView;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.databinding.PageBackgroundLayoutBinding;
import com.myscript.nebo.editing.BackgroundSettingsUIState;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import com.myscript.snt.core.PageKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: PageBackgroundFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/PageBackgroundFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/myscript/nebo/databinding/PageBackgroundLayoutBinding;", "currentState", "Lcom/myscript/nebo/editing/BackgroundSettingsUIState;", "colorListAdapter", "Lcom/myscript/nebo/editing/background/BackgroundColorListAdapter;", "patternListAdapter", "Lcom/myscript/nebo/editing/background/BackgroundPatternListAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onSaveInstanceState", "outState", "backgroundStateChanged", "state", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageBackgroundFragment extends BottomSheetDialogFragment {
    public static final String IS_CHILD_PAGE_KEY = "IS_CHILD_PAGE_KEY";
    public static final String IS_CONTAINER_KEY = "IS_CONTAINER_KEY";
    public static final String PAGE_BACKGROUND_COLOR_KEY = "PAGE_BACKGROUND_COLOR_KEY";
    public static final String PAGE_BACKGROUND_PATTERN_KEY = "PAGE_BACKGROUND_PATTERN_KEY";
    public static final String PAGE_BACKGROUND_REQUEST_KEY = "PAGE_BACKGROUND_REQUEST_KEY";
    public static final String PAGE_BACKGROUND_STATE_KEY = "PAGE_BACKGROUND_INITIAL_KEY";
    public static final String PAGE_KEY_KEY = "PAGE_KEY_KEY";
    public static final String TAG = "PageBackgroundFragment";
    private BackgroundSettingsUIState currentState;
    private PageBackgroundLayoutBinding viewBinding;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.background.PageBackgroundFragment$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PageBackgroundFragment.logger_delegate$lambda$0(this.f$0);
        }
    });
    private BackgroundColorListAdapter colorListAdapter = new BackgroundColorListAdapter(new Function1() { // from class: com.myscript.nebo.editing.background.PageBackgroundFragment$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PageBackgroundFragment.colorListAdapter$lambda$0(this.f$0, (PageBackgroundColor) obj);
        }
    });
    private BackgroundPatternListAdapter patternListAdapter = new BackgroundPatternListAdapter(new Function1() { // from class: com.myscript.nebo.editing.background.PageBackgroundFragment$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PageBackgroundFragment.patternListAdapter$lambda$0(this.f$0, (BackgroundPattern) obj);
        }
    });

    @JvmStatic
    public static final PageBackgroundFragment newInstance(boolean z, boolean z2, PageKey pageKey, BackgroundSettingsUIState backgroundSettingsUIState) {
        return INSTANCE.newInstance(z, z2, pageKey, backgroundSettingsUIState);
    }

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(PageBackgroundFragment pageBackgroundFragment) {
        ComponentCallbacks2 application = pageBackgroundFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit colorListAdapter$lambda$0(PageBackgroundFragment pageBackgroundFragment, PageBackgroundColor selectedColor) {
        Intrinsics.checkNotNullParameter(selectedColor, "selectedColor");
        TechnicalLoggerExt.logAction(pageBackgroundFragment.getLogger(), TAG, "Background color update", new PageBackgroundFragment$colorListAdapter$1$1(selectedColor));
        BackgroundSettingsUIState backgroundSettingsUIState = pageBackgroundFragment.currentState;
        if (backgroundSettingsUIState != null) {
            List<PageBackgroundColor> backgroundColors = backgroundSettingsUIState.getBackgroundColors();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(backgroundColors, 10));
            for (PageBackgroundColor pageBackgroundColor : backgroundColors) {
                arrayList.add(PageBackgroundColor.copy$default(pageBackgroundColor, 0, 0, Intrinsics.areEqual(pageBackgroundColor, selectedColor), 3, null));
            }
            pageBackgroundFragment.backgroundStateChanged(BackgroundSettingsUIState.copy$default(backgroundSettingsUIState, arrayList, null, 2, null));
        }
        PageBackgroundFragment pageBackgroundFragment2 = pageBackgroundFragment;
        Pair[] pairArr = new Pair[3];
        Bundle arguments = pageBackgroundFragment.getArguments();
        pairArr[0] = TuplesKt.m1606to("PAGE_KEY_KEY", arguments != null ? arguments.getString("PAGE_KEY_KEY") : null);
        Bundle arguments2 = pageBackgroundFragment.getArguments();
        pairArr[1] = TuplesKt.m1606to(IS_CONTAINER_KEY, arguments2 != null ? Boolean.valueOf(arguments2.getBoolean(IS_CONTAINER_KEY)) : null);
        pairArr[2] = TuplesKt.m1606to(PAGE_BACKGROUND_COLOR_KEY, Integer.valueOf(selectedColor.getColor()));
        FragmentKt.setFragmentResult(pageBackgroundFragment2, PAGE_BACKGROUND_REQUEST_KEY, BundleKt.bundleOf(pairArr));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit patternListAdapter$lambda$0(PageBackgroundFragment pageBackgroundFragment, final BackgroundPattern selectedPattern) {
        Intrinsics.checkNotNullParameter(selectedPattern, "selectedPattern");
        TechnicalLoggerExt.logAction(pageBackgroundFragment.getLogger(), TAG, "Background pattern update", new PropertyReference0Impl(selectedPattern) { // from class: com.myscript.nebo.editing.background.PageBackgroundFragment$patternListAdapter$1$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((BackgroundPattern) this.receiver).name();
            }
        });
        BackgroundSettingsUIState backgroundSettingsUIState = pageBackgroundFragment.currentState;
        if (backgroundSettingsUIState != null) {
            List<PageBackgroundPattern> backgroundPatterns = backgroundSettingsUIState.getBackgroundPatterns();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(backgroundPatterns, 10));
            for (PageBackgroundPattern pageBackgroundPattern : backgroundPatterns) {
                arrayList.add(PageBackgroundPattern.copy$default(pageBackgroundPattern, null, pageBackgroundPattern.getPattern() == selectedPattern, 1, null));
            }
            pageBackgroundFragment.backgroundStateChanged(BackgroundSettingsUIState.copy$default(backgroundSettingsUIState, null, arrayList, 1, null));
        }
        PageBackgroundFragment pageBackgroundFragment2 = pageBackgroundFragment;
        Pair[] pairArr = new Pair[3];
        Bundle arguments = pageBackgroundFragment.getArguments();
        pairArr[0] = TuplesKt.m1606to("PAGE_KEY_KEY", arguments != null ? arguments.getString("PAGE_KEY_KEY") : null);
        Bundle arguments2 = pageBackgroundFragment.getArguments();
        pairArr[1] = TuplesKt.m1606to(IS_CONTAINER_KEY, arguments2 != null ? Boolean.valueOf(arguments2.getBoolean(IS_CONTAINER_KEY)) : null);
        pairArr[2] = TuplesKt.m1606to(PAGE_BACKGROUND_PATTERN_KEY, selectedPattern.name());
        FragmentKt.setFragmentResult(pageBackgroundFragment2, PAGE_BACKGROUND_REQUEST_KEY, BundleKt.bundleOf(pairArr));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        PageBackgroundLayoutBinding pageBackgroundLayoutBindingInflate = PageBackgroundLayoutBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(pageBackgroundLayoutBindingInflate, "inflate(...)");
        pageBackgroundLayoutBindingInflate.backgroundColorList.setAdapter(this.colorListAdapter);
        pageBackgroundLayoutBindingInflate.backgroundPatternList.setAdapter(this.patternListAdapter);
        this.viewBinding = pageBackgroundLayoutBindingInflate;
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        if (savedInstanceState == null) {
            savedInstanceState = bundleRequireArguments;
        }
        BackgroundSettingsUIState backgroundSettingsUIState = (BackgroundSettingsUIState) BundleCompat.getParcelable(savedInstanceState, PAGE_BACKGROUND_STATE_KEY, BackgroundSettingsUIState.class);
        if (backgroundSettingsUIState != null) {
            List<PageBackgroundColor> backgroundColors = backgroundSettingsUIState.getBackgroundColors();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(backgroundColors, 10));
            for (PageBackgroundColor pageBackgroundColor : backgroundColors) {
                arrayList.add(PageBackgroundColor.copy$default(pageBackgroundColor, 0, PageBackgroundUtilsKt.resolveBackgroundColor(pageBackgroundColor.getColor(), DarkModeUtils.isDarkMode(this)), false, 5, null));
            }
            backgroundStateChanged(BackgroundSettingsUIState.copy$default(backgroundSettingsUIState, arrayList, null, 2, null));
        }
        boolean z2 = bundleRequireArguments.getBoolean(IS_CHILD_PAGE_KEY);
        TextView textView = pageBackgroundLayoutBindingInflate.backgroundDialogTitle;
        if (z2) {
            i = C6079R.string.child_page_background_dialog_title;
        } else {
            i = C6079R.string.note_background_dialog_title;
        }
        textView.setText(i);
        MaterialCardView pageBackgroundNotebookWarning = pageBackgroundLayoutBindingInflate.pageBackgroundNotebookWarning;
        Intrinsics.checkNotNullExpressionValue(pageBackgroundNotebookWarning, "pageBackgroundNotebookWarning");
        MaterialCardView materialCardView = pageBackgroundNotebookWarning;
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(IS_CONTAINER_KEY);
        }
        materialCardView.setVisibility(z ? 0 : 8);
        LinearLayout root = pageBackgroundLayoutBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.clearFlags(2);
        }
        Dialog dialog2 = getDialog();
        Intrinsics.checkNotNull(dialog2, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View viewFindViewById = ((BottomSheetDialog) dialog2).findViewById(C4627R.id.design_bottom_sheet);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        BottomSheetBehavior.from((FrameLayout) viewFindViewById).setState(3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.viewBinding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        BackgroundSettingsUIState backgroundSettingsUIState = this.currentState;
        if (backgroundSettingsUIState != null) {
            outState.putParcelable(PAGE_BACKGROUND_STATE_KEY, backgroundSettingsUIState);
        }
    }

    private final void backgroundStateChanged(BackgroundSettingsUIState state) {
        this.currentState = state;
        PageBackgroundLayoutBinding pageBackgroundLayoutBinding = this.viewBinding;
        if (pageBackgroundLayoutBinding == null) {
            return;
        }
        boolean zIsBackgroundPatternListVisible = state.isBackgroundPatternListVisible();
        TextView backgroundPatternListTitle = pageBackgroundLayoutBinding.backgroundPatternListTitle;
        Intrinsics.checkNotNullExpressionValue(backgroundPatternListTitle, "backgroundPatternListTitle");
        backgroundPatternListTitle.setVisibility(zIsBackgroundPatternListVisible ? 0 : 8);
        RecyclerView backgroundPatternList = pageBackgroundLayoutBinding.backgroundPatternList;
        Intrinsics.checkNotNullExpressionValue(backgroundPatternList, "backgroundPatternList");
        backgroundPatternList.setVisibility(zIsBackgroundPatternListVisible ? 0 : 8);
        this.patternListAdapter.submitList(state.getBackgroundPatterns());
        boolean zIsBackgroundColorListVisible = state.isBackgroundColorListVisible();
        TextView backgroundPatternListTitle2 = pageBackgroundLayoutBinding.backgroundPatternListTitle;
        Intrinsics.checkNotNullExpressionValue(backgroundPatternListTitle2, "backgroundPatternListTitle");
        backgroundPatternListTitle2.setVisibility(zIsBackgroundColorListVisible ? 0 : 8);
        RecyclerView backgroundPatternList2 = pageBackgroundLayoutBinding.backgroundPatternList;
        Intrinsics.checkNotNullExpressionValue(backgroundPatternList2, "backgroundPatternList");
        backgroundPatternList2.setVisibility(zIsBackgroundColorListVisible ? 0 : 8);
        this.colorListAdapter.submitList(state.getBackgroundColors());
    }

    /* JADX INFO: compiled from: PageBackgroundFragment.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/PageBackgroundFragment$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_KEY_KEY", PageBackgroundFragment.IS_CONTAINER_KEY, PageBackgroundFragment.IS_CHILD_PAGE_KEY, "PAGE_BACKGROUND_STATE_KEY", PageBackgroundFragment.PAGE_BACKGROUND_REQUEST_KEY, PageBackgroundFragment.PAGE_BACKGROUND_COLOR_KEY, PageBackgroundFragment.PAGE_BACKGROUND_PATTERN_KEY, "newInstance", "Lcom/myscript/nebo/editing/background/PageBackgroundFragment;", "isContainer", "", "isChildPage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "backgroundSettingsUIState", "Lcom/myscript/nebo/editing/BackgroundSettingsUIState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageBackgroundFragment newInstance(boolean isContainer, boolean isChildPage, PageKey pageKey, BackgroundSettingsUIState backgroundSettingsUIState) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(backgroundSettingsUIState, "backgroundSettingsUIState");
            PageBackgroundFragment pageBackgroundFragment = new PageBackgroundFragment();
            Bundle bundle = new Bundle();
            bundle.putString("PAGE_KEY_KEY", pageKey.serialize());
            bundle.putBoolean(PageBackgroundFragment.IS_CONTAINER_KEY, isContainer);
            bundle.putBoolean(PageBackgroundFragment.IS_CHILD_PAGE_KEY, isChildPage);
            bundle.putParcelable(PageBackgroundFragment.PAGE_BACKGROUND_STATE_KEY, backgroundSettingsUIState);
            pageBackgroundFragment.setArguments(bundle);
            return pageBackgroundFragment;
        }
    }
}
