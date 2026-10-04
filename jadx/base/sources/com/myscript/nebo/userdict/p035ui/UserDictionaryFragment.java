package com.myscript.nebo.userdict.p035ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.selection.Selection;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.SelectionMode;
import com.myscript.android.utils.TextViewExt;
import com.myscript.nebo.userdict.C6889R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UserDictionaryFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u000203H\u0016J\b\u00107\u001a\u00020(H\u0016J\u0018\u00108\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00102\u001a\u000203H\u0016J\u0018\u00109\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u0010:\u001a\u000200H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u00105\u001a\u000206H\u0016J\b\u0010<\u001a\u00020(H\u0002J\b\u0010=\u001a\u00020(H\u0002J\b\u0010>\u001a\u00020(H\u0002J\u0016\u0010?\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/android/utils/NestedFragment;", "Lcom/myscript/android/utils/SelectionMode$Callback;", "<init>", "()V", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "viewModel", "Lcom/myscript/nebo/userdict/ui/UserDictionaryViewModel;", "getViewModel", "()Lcom/myscript/nebo/userdict/ui/UserDictionaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/myscript/nebo/userdict/ui/UserDictionaryAdapter;", "selectionTracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "listView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "onSaveInstanceState", "outState", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "onCreateSelectionMode", "mode", "Lcom/myscript/android/utils/SelectionMode;", "onDestroyView", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "onDestroySelectionMode", "updateSelectionState", "selectAllWords", "deleteSelection", "onItemsDeleted", FirebaseAnalytics.Param.ITEMS, "", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "Companion", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryFragment extends Fragment implements NestedFragment, SelectionMode.Callback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "UserDictionaryFragment";
    private final UserDictionaryAdapter adapter = new UserDictionaryAdapter();
    private RecyclerView listView;
    private Navigator navigator;
    private SelectionTracker<Long> selectionTracker;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @JvmStatic
    public static final UserDictionaryFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public UserDictionaryFragment() {
        final UserDictionaryFragment userDictionaryFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(userDictionaryFragment, Reflection.getOrCreateKotlinClass(UserDictionaryViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return userDictionaryFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? userDictionaryFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UserDictionaryFragment.viewModel_delegate$lambda$0();
            }
        });
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6889R.string.user_dict_label;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return C6889R.menu.user_dict_menu;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public final UserDictionaryViewModel getViewModel() {
        return (UserDictionaryViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return UserDictionaryViewModel.INSTANCE.getFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6889R.layout.user_dictionary_fragment, container, false);
        TextView textView = (TextView) viewInflate.findViewById(C6889R.id.user_dict_learn_more_link);
        if (textView != null) {
            String string = getString(C6889R.string.user_dict_learn_more_link, textView.getText());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            TextViewExt.setHtml(textView, string);
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6889R.id.user_dict);
        recyclerView.setAdapter(this.adapter);
        Intrinsics.checkNotNull(recyclerView);
        SelectionTracker<Long> selectionTrackerCreateSelectionTracker = UserDictionaryFragmentKt.createSelectionTracker(recyclerView);
        this.selectionTracker = selectionTrackerCreateSelectionTracker;
        if (selectionTrackerCreateSelectionTracker != null) {
            selectionTrackerCreateSelectionTracker.onRestoreInstanceState(savedInstanceState);
        }
        this.adapter.setTracker$user_dictionary_release(this.selectionTracker);
        this.listView = recyclerView;
        updateSelectionState();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getViewModel().loadWords$user_dictionary_release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        if (selectionTracker != null) {
            selectionTracker.addObserver(new SelectionTracker.SelectionObserver<Long>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment.onViewCreated.1
                @Override // androidx.recyclerview.selection.SelectionTracker.SelectionObserver
                public void onSelectionChanged() {
                    super.onSelectionChanged();
                    UserDictionaryFragment.this.updateSelectionState();
                }
            });
        }
        getViewModel().getWords().observe(getViewLifecycleOwner(), new UserDictionaryFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDictionaryFragment.onViewCreated$lambda$0(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(UserDictionaryFragment userDictionaryFragment, List list) {
        Navigator navigator = userDictionaryFragment.getNavigator();
        if (navigator != null) {
            navigator.invalidateOptionsMenu();
        }
        userDictionaryFragment.adapter.submitList(list);
        SelectionTracker<Long> selectionTracker = userDictionaryFragment.selectionTracker;
        if (selectionTracker != null) {
            selectionTracker.clearSelection();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        if (selectionTracker != null) {
            selectionTracker.onSaveInstanceState(outState);
        }
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == C6889R.id.user_dict_add_word_menu_item) {
            UserDictionaryViewModel viewModel = getViewModel();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            UserDictionaryPrompter.promptNewWord(viewModel, contextRequireContext);
            return true;
        }
        if (itemId == C6889R.id.user_dict_select_all_menu_item) {
            Navigator navigator = getNavigator();
            if (navigator != null) {
                navigator.startSelectionMode();
            }
            selectAllWords();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment, com.myscript.android.utils.NestedFragment
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareOptionsMenu(menu);
        List<UserDictionaryItem> value = getViewModel().getWords().getValue();
        int size = value != null ? value.size() : 0;
        MenuItem menuItemFindItem = menu.findItem(C6889R.id.user_dict_select_all_menu_item);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(size > 0);
        }
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuInflater menuInflater = mode.getMenuInflater();
        if (menuInflater != null) {
            menuInflater.inflate(C6889R.menu.user_dict_selection_menu, menu);
        }
        RecyclerView recyclerView = this.listView;
        if (recyclerView == null) {
            return true;
        }
        recyclerView.post(new Runnable() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                UserDictionaryFragment.onCreateSelectionMode$lambda$0(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateSelectionMode$lambda$0(UserDictionaryFragment userDictionaryFragment) {
        userDictionaryFragment.adapter.setInSelectionMode(true);
        userDictionaryFragment.adapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.listView = null;
        super.onDestroyView();
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        Selection<Long> selection;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        int size = (selectionTracker == null || (selection = selectionTracker.getSelection()) == null) ? 0 : selection.size();
        mode.setTitle(getResources().getQuantityString(C6889R.plurals.user_dict_selected_words, size, Integer.valueOf(size)));
        boolean z = size == 0;
        menu.findItem(C6889R.id.user_dict_delete_selection_menu_item).setEnabled(!z);
        menu.findItem(C6889R.id.user_dict_select_all_menu_item).setVisible(size != this.adapter.getItemCount());
        menu.findItem(C6889R.id.user_dict_deselect_all_menu_item).setVisible(!z);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == C6889R.id.user_dict_delete_selection_menu_item) {
            deleteSelection();
            return true;
        }
        if (itemId == C6889R.id.user_dict_select_all_menu_item) {
            selectAllWords();
            return true;
        }
        if (itemId != C6889R.id.user_dict_deselect_all_menu_item) {
            return false;
        }
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        if (selectionTracker != null) {
            selectionTracker.clearSelection();
        }
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        RecyclerView recyclerView = this.listView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    UserDictionaryFragment.onDestroySelectionMode$lambda$0(this.f$0);
                }
            });
        }
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        if (selectionTracker != null) {
            selectionTracker.clearSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroySelectionMode$lambda$0(UserDictionaryFragment userDictionaryFragment) {
        userDictionaryFragment.adapter.setInSelectionMode(false);
        userDictionaryFragment.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionState() {
        Selection<Long> selection;
        Navigator navigator = getNavigator();
        if (navigator == null) {
            return;
        }
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        boolean z = false;
        if (selectionTracker != null && (selection = selectionTracker.getSelection()) != null && selection.isEmpty()) {
            z = true;
        }
        if (!navigator.hasSelectionMode() && !z) {
            navigator.startSelectionMode();
        }
        if (!z) {
            navigator.invalidateSelectionMode();
        } else if (navigator.hasSelectionMode()) {
            navigator.stopSelectionMode();
        }
    }

    private final void selectAllWords() {
        long itemCount = this.adapter.getItemCount();
        for (long j = 0; j < itemCount; j++) {
            SelectionTracker<Long> selectionTracker = this.selectionTracker;
            if (selectionTracker != null) {
                selectionTracker.select(Long.valueOf(j));
            }
        }
        this.adapter.notifyDataSetChanged();
    }

    private final void deleteSelection() {
        Selection<Long> selection;
        UserDictionaryItem userDictionaryItem;
        ArrayList arrayList = new ArrayList();
        RecyclerViewKeyProvider recyclerViewKeyProvider = new RecyclerViewKeyProvider();
        SelectionTracker<Long> selectionTracker = this.selectionTracker;
        if (selectionTracker != null && (selection = selectionTracker.getSelection()) != null) {
            for (Long l : selection) {
                Intrinsics.checkNotNull(l);
                int position = recyclerViewKeyProvider.getPosition(l.longValue());
                List<UserDictionaryItem> value = getViewModel().getWords().getValue();
                if (value != null && (userDictionaryItem = value.get(position)) != null) {
                    arrayList.add(userDictionaryItem);
                }
            }
        }
        onItemsDeleted(arrayList);
    }

    private final void onItemsDeleted(List<UserDictionaryItem> items) {
        getViewModel().removeWords(items);
        View view = getView();
        View viewFindViewById = view != null ? view.findViewById(C6889R.id.user_dict_coordinator) : null;
        if (!isAdded() || viewFindViewById == null) {
            return;
        }
        Snackbar snackbarMake = Snackbar.make(viewFindViewById, getString(C6889R.string.user_dict_word_deleted, CollectionsKt.joinToString$default(items, null, null, null, 0, null, null, 63, null)), 0);
        snackbarMake.setAction(C6889R.string.user_dict_word_deleted_undo, new View.OnClickListener() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserDictionaryFragment.onItemsDeleted$lambda$0$0(this.f$0, view2);
            }
        });
        snackbarMake.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryFragment$onItemsDeleted$1$2
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar snackbar, int event) {
                if (snackbar != null) {
                    snackbar.removeCallback(this);
                }
                this.this$0.getViewModel().purgeRemovedWords();
                super.onDismissed(snackbar, event);
            }
        });
        snackbarMake.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onItemsDeleted$lambda$0$0(UserDictionaryFragment userDictionaryFragment, View view) {
        userDictionaryFragment.getViewModel().restoreRemovedWords();
    }

    /* JADX INFO: compiled from: UserDictionaryFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/userdict/ui/UserDictionaryFragment;", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UserDictionaryFragment newInstance() {
            return new UserDictionaryFragment();
        }
    }
}
