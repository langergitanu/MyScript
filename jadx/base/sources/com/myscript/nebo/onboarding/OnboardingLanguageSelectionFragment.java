package com.myscript.nebo.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.analytics.AnalyticsEvent;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.languagemanager.presentation.Callback;
import com.myscript.nebo.languagemanager.presentation.LanguageAdapter;
import com.myscript.nebo.onboarding.databinding.OnboardingLanguageSelectionBinding;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: OnboardingLanguageSelectionFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/onboarding/OnboardingLanguageSelectionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/myscript/nebo/onboarding/LanguageSelectionViewModel;", "getViewModel", "()Lcom/myscript/nebo/onboarding/LanguageSelectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/myscript/nebo/onboarding/databinding/OnboardingLanguageSelectionBinding;", "lastNotifiedLanguageKey", "", "adapter", "Lcom/myscript/nebo/languagemanager/presentation/LanguageAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "onDestroyView", "dismissKeyboard", "Companion", "onboarding_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OnboardingLanguageSelectionFragment extends Fragment {
    public static final String CONFIRM_LANGUAGE_SELECTION_KEY = "CONFIRM_LANGUAGE_SELECTION_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LANGUAGE_REQUEST_KEY = "OnboardingLanguageSelectionFragment_REQUEST_KEY";
    public static final String MOVE_FORWARD_REQUEST_KEY = "MOVE_FORWARD_REQUEST_KEY";
    public static final String SELECTED_LANGUAGE_KEY = "SELECTED_LANGUAGE_KEY";
    public static final String TAG = "OnboardingLanguageSelectionFragment";
    private final LanguageAdapter adapter;
    private OnboardingLanguageSelectionBinding binding;
    private String lastNotifiedLanguageKey;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @JvmStatic
    public static final OnboardingLanguageSelectionFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public OnboardingLanguageSelectionFragment() {
        final OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OnboardingLanguageSelectionFragment.viewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return onboardingLanguageSelectionFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(onboardingLanguageSelectionFragment, Reflection.getOrCreateKotlinClass(LanguageSelectionViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$special$$inlined$viewModels$default$4
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
        this.adapter = new LanguageAdapter(new Callback() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$adapter$1
            @Override // com.myscript.nebo.languagemanager.presentation.Callback
            public void onLanguageDownloadRequested(String languageKey) {
                Intrinsics.checkNotNullParameter(languageKey, "languageKey");
                this.this$0.getViewModel().download(languageKey);
            }

            @Override // com.myscript.nebo.languagemanager.presentation.Callback
            public void onRemoveLanguageRequest(String languageKey) {
                Intrinsics.checkNotNullParameter(languageKey, "languageKey");
                this.this$0.getViewModel().removeLanguage(languageKey);
            }

            @Override // com.myscript.nebo.languagemanager.presentation.Callback
            public void onCancelLanguageDownloadRequest(String languageKey) {
                Intrinsics.checkNotNullParameter(languageKey, "languageKey");
                this.this$0.getViewModel().cancelDownload(languageKey);
            }

            @Override // com.myscript.nebo.languagemanager.presentation.Callback
            public void onLanguageClicked(String languageKey) {
                Intrinsics.checkNotNullParameter(languageKey, "languageKey");
                this.this$0.getViewModel().selectLanguage(languageKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LanguageSelectionViewModel getViewModel() {
        return (LanguageSelectionViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment) {
        Locale locale = onboardingLanguageSelectionFragment.requireContext().getResources().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNull(locale);
        return new LanguageSelectionViewModelFactory(locale);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        AnalyticsEvent.log$default(NeboFirebaseEvent.TutorialLanguageScreen, null, 1, null);
        OnboardingLanguageSelectionBinding onboardingLanguageSelectionBindingInflate = OnboardingLanguageSelectionBinding.inflate(inflater, container, false);
        onboardingLanguageSelectionBindingInflate.languageList.setAdapter(this.adapter);
        onboardingLanguageSelectionBindingInflate.searchLanguage.setMaxWidth(Integer.MAX_VALUE);
        this.binding = onboardingLanguageSelectionBindingInflate;
        return onboardingLanguageSelectionBindingInflate != null ? onboardingLanguageSelectionBindingInflate.getRoot() : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getViewModel().getState().observe(getViewLifecycleOwner(), new C6663xe6e0062d(new Function1() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingLanguageSelectionFragment.onViewCreated$lambda$0(this.f$0, (LanguageSelectUIState) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment, LanguageSelectUIState languageSelectUIState) {
        OnboardingLanguageSelectionBinding onboardingLanguageSelectionBinding = onboardingLanguageSelectionFragment.binding;
        if (onboardingLanguageSelectionBinding == null) {
            return Unit.INSTANCE;
        }
        onboardingLanguageSelectionBinding.searchLanguage.setIconified(!languageSelectUIState.isSearchActive());
        onboardingLanguageSelectionBinding.onboardingContinue.setEnabled(languageSelectUIState.getCanContinue());
        onboardingLanguageSelectionFragment.adapter.submitList(languageSelectUIState.getLanguages());
        boolean zIsEmpty = languageSelectUIState.getLanguages().isEmpty();
        RecyclerView languageList = onboardingLanguageSelectionBinding.languageList;
        Intrinsics.checkNotNullExpressionValue(languageList, "languageList");
        languageList.setVisibility(!zIsEmpty ? 0 : 8);
        ImageView searchLanguageNoResultIcon = onboardingLanguageSelectionBinding.searchLanguageNoResultIcon;
        Intrinsics.checkNotNullExpressionValue(searchLanguageNoResultIcon, "searchLanguageNoResultIcon");
        searchLanguageNoResultIcon.setVisibility(zIsEmpty && languageSelectUIState.isSearchActive() ? 0 : 8);
        TextView searchLanguageNoResultLabel = onboardingLanguageSelectionBinding.searchLanguageNoResultLabel;
        Intrinsics.checkNotNullExpressionValue(searchLanguageNoResultLabel, "searchLanguageNoResultLabel");
        searchLanguageNoResultLabel.setVisibility(zIsEmpty && languageSelectUIState.isSearchActive() ? 0 : 8);
        ProgressBar progressBar = onboardingLanguageSelectionBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(languageSelectUIState.getShowSpinner() ? 0 : 8);
        TextView txtNetworkInfo = onboardingLanguageSelectionBinding.txtNetworkInfo;
        Intrinsics.checkNotNullExpressionValue(txtNetworkInfo, "txtNetworkInfo");
        txtNetworkInfo.setVisibility(languageSelectUIState.getNetworkError() ? 0 : 8);
        String selectedLanguageKey = onboardingLanguageSelectionFragment.getViewModel().getSelectedLanguageKey();
        if (selectedLanguageKey != null && !Intrinsics.areEqual(onboardingLanguageSelectionFragment.lastNotifiedLanguageKey, selectedLanguageKey)) {
            onboardingLanguageSelectionFragment.lastNotifiedLanguageKey = selectedLanguageKey;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OnboardingLanguageSelectionBinding onboardingLanguageSelectionBinding = this.binding;
        if (onboardingLanguageSelectionBinding == null) {
            return;
        }
        onboardingLanguageSelectionBinding.onboardingContinue.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingLanguageSelectionFragment.onStart$lambda$0(this.f$0, view);
            }
        });
        onboardingLanguageSelectionBinding.searchLanguage.setOnSearchClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingLanguageSelectionFragment.onStart$lambda$1(this.f$0, view);
            }
        });
        onboardingLanguageSelectionBinding.searchLanguage.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment$$ExternalSyntheticLambda2
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return OnboardingLanguageSelectionFragment.onStart$lambda$2(this.f$0);
            }
        });
        onboardingLanguageSelectionBinding.searchLanguage.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment.onStart.4
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                if (query == null) {
                    return true;
                }
                OnboardingLanguageSelectionFragment.this.getViewModel().search(query);
                OnboardingLanguageSelectionFragment.this.dismissKeyboard();
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                if (newText == null) {
                    return true;
                }
                OnboardingLanguageSelectionFragment.this.getViewModel().search(newText);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment, View view) {
        FragmentKt.setFragmentResult(onboardingLanguageSelectionFragment, LANGUAGE_REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m1606to(SELECTED_LANGUAGE_KEY, onboardingLanguageSelectionFragment.getViewModel().getSelectedLanguageKey())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$1(OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment, View view) {
        if (onboardingLanguageSelectionFragment.getViewModel().isSearchActive()) {
            return;
        }
        onboardingLanguageSelectionFragment.getViewModel().search("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onStart$lambda$2(OnboardingLanguageSelectionFragment onboardingLanguageSelectionFragment) {
        onboardingLanguageSelectionFragment.getViewModel().search(null);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        OnboardingLanguageSelectionBinding onboardingLanguageSelectionBinding = this.binding;
        if (onboardingLanguageSelectionBinding == null) {
            return;
        }
        onboardingLanguageSelectionBinding.onboardingContinue.setOnClickListener(null);
        onboardingLanguageSelectionBinding.searchLanguage.setOnSearchClickListener(null);
        onboardingLanguageSelectionBinding.searchLanguage.setOnCloseListener(null);
        onboardingLanguageSelectionBinding.searchLanguage.setOnQueryTextListener(null);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.binding = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissKeyboard() {
        Object systemService = requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View view = getView();
        inputMethodManager.hideSoftInputFromWindow(view != null ? view.getWindowToken() : null, 0);
    }

    /* JADX INFO: compiled from: OnboardingLanguageSelectionFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/onboarding/OnboardingLanguageSelectionFragment$Companion;", "", "<init>", "()V", "TAG", "", "LANGUAGE_REQUEST_KEY", OnboardingLanguageSelectionFragment.SELECTED_LANGUAGE_KEY, OnboardingLanguageSelectionFragment.MOVE_FORWARD_REQUEST_KEY, OnboardingLanguageSelectionFragment.CONFIRM_LANGUAGE_SELECTION_KEY, "newInstance", "Lcom/myscript/nebo/onboarding/OnboardingLanguageSelectionFragment;", "onboarding_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OnboardingLanguageSelectionFragment newInstance() {
            return new OnboardingLanguageSelectionFragment();
        }
    }
}
