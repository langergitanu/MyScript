package com.myscript.nebo.dms.sharepage.contacts.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.actions.SearchIntents;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ContactsViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/myscript/nebo/dms/sharepage/contacts/model/IContactsRepository;", "<init>", "(Lcom/myscript/nebo/dms/sharepage/contacts/model/IContactsRepository;)V", "_suggestedContacts", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "suggestedContacts", "Landroidx/lifecycle/LiveData;", "getSuggestedContacts", "()Landroidx/lifecycle/LiveData;", "selectedContactsRaw", "", "_selectedContacts", "selectedContacts", "getSelectedContacts", "currentQuery", "", "fetchContacts", "", SearchIntents.EXTRA_QUERY, "reset", "addContact", "contact", "removeContact", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContactsViewModel extends ViewModel {
    private final MutableLiveData<List<ContactItem>> _selectedContacts;
    private final MutableLiveData<List<ContactItem>> _suggestedContacts;
    private String currentQuery;
    private final IContactsRepository repository;
    private final Set<ContactItem> selectedContactsRaw;

    public ContactsViewModel(IContactsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this._suggestedContacts = new MutableLiveData<>(CollectionsKt.emptyList());
        this.selectedContactsRaw = new LinkedHashSet();
        this._selectedContacts = new MutableLiveData<>(CollectionsKt.emptyList());
    }

    public final LiveData<List<ContactItem>> getSuggestedContacts() {
        return this._suggestedContacts;
    }

    public final LiveData<List<ContactItem>> getSelectedContacts() {
        return this._selectedContacts;
    }

    public final void fetchContacts(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        String string = StringsKt.trim((CharSequence) query).toString();
        String str = this.currentQuery;
        if (Intrinsics.areEqual(string, str != null ? StringsKt.trim((CharSequence) str).toString() : null)) {
            return;
        }
        this.currentQuery = string;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62921(string, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$fetchContacts$1 */
    /* JADX INFO: compiled from: ContactsViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$fetchContacts$1", m1609f = "ContactsViewModel.kt", m1610i = {}, m1611l = {31}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {32}, m1615s = {}, m1616v = 2)
    static final class C62921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cleanedQuery;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62921(String str, Continuation<? super C62921> continuation) {
            super(2, continuation);
            this.$cleanedQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContactsViewModel.this.new C62921(this.$cleanedQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = ContactsViewModel.this._suggestedContacts;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object contacts = ContactsViewModel.this.repository.getContacts(this.$cleanedQuery, this);
                if (contacts == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                obj = contacts;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableLiveData.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$reset$1 */
    /* JADX INFO: compiled from: ContactsViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$reset$1", m1609f = "ContactsViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62941(Continuation<? super C62941> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContactsViewModel.this.new C62941(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ContactsViewModel.this.currentQuery = null;
                ContactsViewModel.this.selectedContactsRaw.clear();
                ContactsViewModel.this._suggestedContacts.setValue(CollectionsKt.emptyList());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void reset() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62941(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$addContact$1 */
    /* JADX INFO: compiled from: ContactsViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$addContact$1", m1609f = "ContactsViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContactItem $contact;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62911(ContactItem contactItem, Continuation<? super C62911> continuation) {
            super(2, continuation);
            this.$contact = contactItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContactsViewModel.this.new C62911(this.$contact, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (ContactsViewModel.this.selectedContactsRaw.add(this.$contact)) {
                    ContactsViewModel.this._selectedContacts.setValue(CollectionsKt.toList(ContactsViewModel.this.selectedContactsRaw));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void addContact(ContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62911(contact, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$removeContact$1 */
    /* JADX INFO: compiled from: ContactsViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.contacts.model.ContactsViewModel$removeContact$1", m1609f = "ContactsViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContactItem $contact;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62931(ContactItem contactItem, Continuation<? super C62931> continuation) {
            super(2, continuation);
            this.$contact = contactItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContactsViewModel.this.new C62931(this.$contact, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (ContactsViewModel.this.selectedContactsRaw.remove(this.$contact)) {
                    ContactsViewModel.this._selectedContacts.setValue(CollectionsKt.toList(ContactsViewModel.this.selectedContactsRaw));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void removeContact(ContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62931(contact, null), 3, null);
    }
}
