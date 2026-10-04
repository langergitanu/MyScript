package com.myscript.nebo.languagemanager.presentation;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.languagemanager.C6611R;
import com.myscript.nebo.languagemanager.databinding.LanguageManagerFragmentBinding;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: LanguageManagerFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010,\u001a\u00020*2\b\b\u0001\u0010-\u001a\u00020\u00062\b\b\u0001\u0010.\u001a\u00020\u0006H\u0002J\u0006\u0010/\u001a\u00020*J\u0006\u00100\u001a\u00020*J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u000203R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageManagerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "viewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "refreshAfterErrorListener", "Landroid/view/View$OnClickListener;", "binding", "Lcom/myscript/nebo/languagemanager/databinding/LanguageManagerFragmentBinding;", "adapter", "Lcom/myscript/nebo/languagemanager/presentation/LanguageAdapter;", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupInfoHeader", "drawableRes", "messageRes", "onSearchOpened", "onSearchClosed", FirebaseAnalytics.Event.SEARCH, "label", "", "Companion", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageManagerFragment extends Fragment implements NestedFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String REQUEST_KEY = "LanguageManagerFragment_REQUEST_KEY";
    public static final String TAG = "LanguageManagerFragment";
    private LanguageManagerFragmentBinding binding;
    private final int menuRes;
    private Navigator navigator;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final View.OnClickListener refreshAfterErrorListener = new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda5
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LanguageManagerFragment.refreshAfterErrorListener$lambda$0(this.f$0, view);
        }
    };
    private final LanguageAdapter adapter = new LanguageAdapter(new Callback() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$adapter$1
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
            this.this$0.getViewModel().download(languageKey);
        }
    });

    @JvmStatic
    public static final LanguageManagerFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public LanguageManagerFragment() {
        final LanguageManagerFragment languageManagerFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(languageManagerFragment, Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return languageManagerFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? languageManagerFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LanguageManagerFragment.viewModel_delegate$lambda$0(this.f$0);
            }
        });
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6611R.string.notebook_manage_languages_dialog_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return this.menuRes;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LanguageViewModel getViewModel() {
        return (LanguageViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(LanguageManagerFragment languageManagerFragment) {
        FragmentActivity fragmentActivityRequireActivity = languageManagerFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Configuration configuration = fragmentActivityRequireActivity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        Locale primaryLocale = LocaleExt.getPrimaryLocale(configuration);
        ComponentCallbacks2 application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider");
        return new LanguageViewModel.Factory(new LanguageNameHelper(primaryLocale), ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAfterErrorListener$lambda$0(LanguageManagerFragment languageManagerFragment, View view) {
        languageManagerFragment.getViewModel().loadLanguages();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LanguageManagerFragmentBinding languageManagerFragmentBindingInflate = LanguageManagerFragmentBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(languageManagerFragmentBindingInflate, "inflate(...)");
        this.binding = languageManagerFragmentBindingInflate;
        if (languageManagerFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBindingInflate = null;
        }
        return languageManagerFragmentBindingInflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LanguageManagerFragmentBinding languageManagerFragmentBinding = this.binding;
        if (languageManagerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBinding = null;
        }
        languageManagerFragmentBinding.languageList.setAdapter(this.adapter);
        getViewModel().getLanguages().observe(getViewLifecycleOwner(), new LanguageManagerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageManagerFragment.onViewCreated$lambda$0(this.f$0, (List) obj);
            }
        }));
        getViewModel().isError().observe(getViewLifecycleOwner(), new LanguageManagerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageManagerFragment.onViewCreated$lambda$1(this.f$0, (Boolean) obj);
            }
        }));
        getViewModel().getShowSpinner().observe(getViewLifecycleOwner(), new LanguageManagerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageManagerFragment.onViewCreated$lambda$2(this.f$0, (Boolean) obj);
            }
        }));
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().observe(getViewLifecycleOwner(), new LanguageManagerFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LanguageManagerFragment.onViewCreated$lambda$3(this.f$0, (NeboNetworkState) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(LanguageManagerFragment languageManagerFragment, List list) {
        languageManagerFragment.adapter.submitList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(LanguageManagerFragment languageManagerFragment, Boolean bool) {
        if (!bool.booleanValue()) {
            return Unit.INSTANCE;
        }
        LanguageManagerFragmentBinding languageManagerFragmentBinding = languageManagerFragment.binding;
        if (languageManagerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBinding = null;
        }
        Snackbar.make(languageManagerFragmentBinding.getRoot(), C6611R.string.languagemanager_error_fetch_languages, 0).setAction(C6611R.string.languagemanager_try_again, languageManagerFragment.refreshAfterErrorListener).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(LanguageManagerFragment languageManagerFragment, Boolean bool) {
        LanguageManagerFragmentBinding languageManagerFragmentBinding = languageManagerFragment.binding;
        if (languageManagerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBinding = null;
        }
        ProgressBar progressBar = languageManagerFragmentBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ProgressBar progressBar2 = progressBar;
        Intrinsics.checkNotNull(bool);
        progressBar2.setVisibility(bool.booleanValue() ? 0 : 8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(LanguageManagerFragment languageManagerFragment, NeboNetworkState neboNetworkState) {
        if (!(neboNetworkState instanceof NeboNetworkState.Connected) || !((NeboNetworkState.Connected) neboNetworkState).isEnabled()) {
            languageManagerFragment.setupInfoHeader(C6611R.drawable.ic_cloud_disabled_outline, C6611R.string.languagemanager_no_internet_label);
        } else {
            LanguageManagerFragmentBinding languageManagerFragmentBinding = languageManagerFragment.binding;
            if (languageManagerFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                languageManagerFragmentBinding = null;
            }
            TextView txtLanguageInfo = languageManagerFragmentBinding.txtLanguageInfo;
            Intrinsics.checkNotNullExpressionValue(txtLanguageInfo, "txtLanguageInfo");
            txtLanguageInfo.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final void setupInfoHeader(int drawableRes, int messageRes) {
        LanguageManagerFragmentBinding languageManagerFragmentBinding = this.binding;
        LanguageManagerFragmentBinding languageManagerFragmentBinding2 = null;
        if (languageManagerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBinding = null;
        }
        languageManagerFragmentBinding.txtLanguageInfo.setText(requireContext().getString(messageRes));
        Drawable drawable = ContextCompat.getDrawable(requireContext(), drawableRes);
        LanguageManagerFragmentBinding languageManagerFragmentBinding3 = this.binding;
        if (languageManagerFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            languageManagerFragmentBinding3 = null;
        }
        languageManagerFragmentBinding3.txtLanguageInfo.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        LanguageManagerFragmentBinding languageManagerFragmentBinding4 = this.binding;
        if (languageManagerFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            languageManagerFragmentBinding2 = languageManagerFragmentBinding4;
        }
        TextView txtLanguageInfo = languageManagerFragmentBinding2.txtLanguageInfo;
        Intrinsics.checkNotNullExpressionValue(txtLanguageInfo, "txtLanguageInfo");
        txtLanguageInfo.setVisibility(0);
    }

    /* JADX INFO: compiled from: LanguageManagerFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageManagerFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", "newInstance", "Lcom/myscript/nebo/languagemanager/presentation/LanguageManagerFragment;", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LanguageManagerFragment newInstance() {
            return new LanguageManagerFragment();
        }
    }

    public final void onSearchOpened() {
        getViewModel().onSearchOpened();
    }

    public final void onSearchClosed() {
        getViewModel().onSearchClosed();
    }

    public final void search(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        getViewModel().search(label);
    }
}
