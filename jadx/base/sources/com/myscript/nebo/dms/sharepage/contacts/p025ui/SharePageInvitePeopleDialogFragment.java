package com.myscript.nebo.dms.sharepage.contacts.p025ui;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.android.utils.C6014R;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModelFactory;
import com.myscript.nebo.dms.sharepage.contacts.model.ContentResolverContactsRepository;
import com.myscript.nebo.dms.sharepage.contacts.p025ui.AutoCompleteContactController;
import com.myscript.nebo.dms.sharepage.contacts.p025ui.ContactViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SharePageInvitePeopleDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002=>B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010+\u001a\u00020!H\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020!H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000207H\u0002J\u0010\u0010<\u001a\u00020!2\u0006\u0010;\u001a\u000207H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u0006?"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController$AutoCompleteContactCallback;", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;", "<init>", "()V", "contactsAdapter", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/SelectedContactsAdapter;", "callback", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Callback;", "getCallback", "()Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Callback;", "setCallback", "(Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Callback;)V", "contactRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shareMessageView", "Landroid/widget/TextView;", "autoCompleteContactView", "Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;", "autoCompleteController", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/AutoCompleteContactController;", "positiveButton", "Landroid/view/View;", "viewModel", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactsViewModel;", "getViewModel", "()Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "view", "updatePositiveButton", "onContactItemDeleted", "contact", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "addContact", "fetchContacts", "queryText", "", "onStart", "hasPermission", "", "permission", "requestPermission", "Callback", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharePageInvitePeopleDialogFragment extends DialogFragment implements AutoCompleteContactController.AutoCompleteContactCallback, ContactViewHolder.Callback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int READ_CONTACTS_REQUEST_CODE = 1;
    public static final String TAG = "SharePageInvitePeopleDialogFragment";
    private AppCompatAutoCompleteTextView autoCompleteContactView;
    private AutoCompleteContactController autoCompleteController;
    private Callback callback;
    private RecyclerView contactRecyclerView;
    private final SelectedContactsAdapter contactsAdapter = new SelectedContactsAdapter(this);
    private NeboNetworkStateRepository networkStateRepository;
    private View positiveButton;
    private TextView shareMessageView;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: SharePageInvitePeopleDialogFragment.kt */
    @FunctionalInterface
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Callback;", "", "onPeopleInvited", "", "contactList", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "message", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onPeopleInvited(List<ContactItem> contactList, String message);
    }

    public SharePageInvitePeopleDialogFragment() {
        final SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharePageInvitePeopleDialogFragment.viewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return sharePageInvitePeopleDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(sharePageInvitePeopleDialogFragment, Reflection.getOrCreateKotlinClass(ContactsViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$special$$inlined$viewModels$default$4
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

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    private final ContactsViewModel getViewModel() {
        return (ContactsViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment) {
        ContentResolver contentResolver = sharePageInvitePeopleDialogFragment.requireActivity().getApplication().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return new ContactsViewModelFactory(new ContentResolverContactsRepository(contentResolver));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        this.networkStateRepository = ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository();
        setStyle(0, getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_Dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6280R.layout.share_page_invite_dialog, container, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6280R.id.share_page_invite_to);
        recyclerView.setAdapter(this.contactsAdapter);
        this.contactRecyclerView = recyclerView;
        this.contactsAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment.onCreateView.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                RecyclerView recyclerView2 = SharePageInvitePeopleDialogFragment.this.contactRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.scrollToPosition(positionStart);
                }
            }
        });
        this.shareMessageView = (TextView) viewInflate.findViewById(C6280R.id.share_page_invite_message);
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) viewInflate.findViewById(C6280R.id.auto_complete_contact_view);
        appCompatAutoCompleteTextView.requestFocus();
        this.autoCompleteContactView = appCompatAutoCompleteTextView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView2 = this.autoCompleteContactView;
        if (appCompatAutoCompleteTextView2 != null) {
            this.autoCompleteController = new AutoCompleteContactController(contextRequireContext, appCompatAutoCompleteTextView2, this);
            this.positiveButton = viewInflate.findViewById(C6280R.id.share_page_send_button);
            viewInflate.findViewById(C6280R.id.share_page_cancel_button).setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SharePageInvitePeopleDialogFragment.onCreateView$lambda$2(this.f$0, view);
                }
            });
            return viewInflate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment, View view) {
        sharePageInvitePeopleDialogFragment.dismiss();
        view.setOnClickListener(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.contactRecyclerView = null;
        this.shareMessageView = null;
        this.autoCompleteContactView = null;
        this.autoCompleteController = null;
        this.positiveButton = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        dialogOnCreateDialog.setTitle(C6280R.string.invite_people);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.positiveButton;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SharePageInvitePeopleDialogFragment.onViewCreated$lambda$0(this.f$0, view3);
                }
            });
        }
        SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment = this;
        getViewModel().getSuggestedContacts().observe(sharePageInvitePeopleDialogFragment, new C6297x61b26dc2(new Function1() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharePageInvitePeopleDialogFragment.onViewCreated$lambda$1(this.f$0, (List) obj);
            }
        }));
        getViewModel().getSelectedContacts().observe(sharePageInvitePeopleDialogFragment, new C6297x61b26dc2(new Function1() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharePageInvitePeopleDialogFragment.onViewCreated$lambda$2(this.f$0, (List) obj);
            }
        }));
        NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
        if (neboNetworkStateRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepository = null;
        }
        neboNetworkStateRepository.getNeboNetworkState().observe(getViewLifecycleOwner(), new C6297x61b26dc2(new Function1() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SharePageInvitePeopleDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharePageInvitePeopleDialogFragment.onViewCreated$lambda$3(this.f$0, (NeboNetworkState) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment, View view) {
        view.setOnClickListener(null);
        List<ContactItem> value = sharePageInvitePeopleDialogFragment.getViewModel().getSelectedContacts().getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        Callback callback = sharePageInvitePeopleDialogFragment.callback;
        if (callback != null) {
            TextView textView = sharePageInvitePeopleDialogFragment.shareMessageView;
            callback.onPeopleInvited(value, String.valueOf(textView != null ? textView.getText() : null));
        }
        sharePageInvitePeopleDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onViewCreated$lambda$1(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment, List list) {
        AutoCompleteContactController autoCompleteContactController = sharePageInvitePeopleDialogFragment.autoCompleteController;
        if (autoCompleteContactController != 0) {
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            autoCompleteContactController.updateSuggestions(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment, List list) {
        sharePageInvitePeopleDialogFragment.contactsAdapter.submitList(list);
        sharePageInvitePeopleDialogFragment.updatePositiveButton();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(SharePageInvitePeopleDialogFragment sharePageInvitePeopleDialogFragment, NeboNetworkState neboNetworkState) {
        sharePageInvitePeopleDialogFragment.updatePositiveButton();
        return Unit.INSTANCE;
    }

    private final void updatePositiveButton() {
        NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
        if (neboNetworkStateRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStateRepository");
            neboNetworkStateRepository = null;
        }
        NeboNetworkState value = neboNetworkStateRepository.getNeboNetworkState().getValue();
        View view = this.positiveButton;
        if (view != null) {
            List<ContactItem> value2 = getViewModel().getSelectedContacts().getValue();
            boolean z = false;
            if (value2 != null && !value2.isEmpty()) {
                if (value != null ? value.isDataTransferAllowed() : false) {
                    z = true;
                }
            }
            view.setEnabled(z);
        }
    }

    @Override // com.myscript.nebo.dms.sharepage.contacts.ui.ContactViewHolder.Callback
    public void onContactItemDeleted(ContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        getViewModel().removeContact(contact);
    }

    @Override // com.myscript.nebo.dms.sharepage.contacts.ui.AutoCompleteContactController.AutoCompleteContactCallback
    public void addContact(ContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        getViewModel().addContact(contact);
    }

    @Override // com.myscript.nebo.dms.sharepage.contacts.ui.AutoCompleteContactController.AutoCompleteContactCallback
    public void fetchContacts(String queryText) {
        Intrinsics.checkNotNullParameter(queryText, "queryText");
        if (hasPermission("android.permission.READ_CONTACTS")) {
            getViewModel().fetchContacts(queryText);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (hasPermission("android.permission.READ_CONTACTS")) {
            return;
        }
        requestPermission("android.permission.READ_CONTACTS");
    }

    private final boolean hasPermission(String permission) {
        FragmentActivity activity = getActivity();
        return activity != null && ContextCompat.checkSelfPermission(activity.getApplicationContext(), permission) == 0;
    }

    private final void requestPermission(String permission) {
        requestPermissions(new String[]{permission}, 1);
    }

    /* JADX INFO: compiled from: SharePageInvitePeopleDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment$Companion;", "", "<init>", "()V", "READ_CONTACTS_REQUEST_CODE", "", "TAG", "", "newInstance", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/SharePageInvitePeopleDialogFragment;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharePageInvitePeopleDialogFragment newInstance() {
            return new SharePageInvitePeopleDialogFragment();
        }
    }
}
