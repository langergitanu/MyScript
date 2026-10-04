package com.myscript.nebo.userdict.p035ui;

import android.content.ComponentCallbacks2;
import androidx.compose.runtime.GapComposerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.text.UserDictionary;
import com.myscript.nebo.userdict.IUserDictionaryProvider;
import com.myscript.nebo.userdict.UserDictionaryInputChecker;
import com.myscript.nebo.userdict.p035ui.InputStatus;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: UserDictionaryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0014\u0010\u0019\u001a\u00020\u00172\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000fJ\u0014\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010!\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\b\u0010'\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryViewModel;", "Landroidx/lifecycle/ViewModel;", "userDictionary", "Lcom/myscript/atk/text/UserDictionary;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/atk/text/UserDictionary;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "newNativeRef", "getNewNativeRef", "()Lcom/myscript/atk/text/UserDictionary;", "_words", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "words", "Landroidx/lifecycle/LiveData;", "getWords", "()Landroidx/lifecycle/LiveData;", "removedWords", "", "loadWords", "", "loadWords$user_dictionary_release", "clear", "addWord", "item", "save", "", "removeWord", "removeWords", FirebaseAnalytics.Param.ITEMS, "restoreRemovedWords", "purgeRemovedWords", "checkInput", "Lcom/myscript/nebo/userdict/ui/InputStatus;", "input", "", "onCleared", "Companion", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryViewModel extends ViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ViewModelProvider.Factory Factory;
    private final MutableLiveData<List<UserDictionaryItem>> _words;
    private final CoroutineDispatcher ioDispatcher;
    private final List<UserDictionaryItem> removedWords;
    private final CoroutineDispatcher uiDispatcher;
    private final UserDictionary userDictionary;

    public UserDictionaryViewModel(UserDictionary userDictionary, CoroutineDispatcher uiDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(userDictionary, "userDictionary");
        Intrinsics.checkNotNullParameter(uiDispatcher, "uiDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.userDictionary = userDictionary;
        this.uiDispatcher = uiDispatcher;
        this.ioDispatcher = ioDispatcher;
        this._words = new MutableLiveData<>();
        this.removedWords = new ArrayList();
        loadWords$user_dictionary_release();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserDictionaryViewModel(UserDictionary userDictionary, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        coroutineDispatcher = (i & 2) != 0 ? Dispatchers.getMain() : coroutineDispatcher;
        if ((i & 4) != 0) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            coroutineDispatcher2 = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        }
        this(userDictionary, coroutineDispatcher, coroutineDispatcher2);
    }

    private final UserDictionary getNewNativeRef() {
        if (UserDictionary.getCPtr(this.userDictionary) != 0) {
            return UserDictionary.newRef(this.userDictionary);
        }
        return null;
    }

    public final LiveData<List<UserDictionaryItem>> getWords() {
        return this._words;
    }

    public final void loadWords$user_dictionary_release() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new UserDictionaryViewModel$loadWords$1(this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$1 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C68961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<UserDictionaryItem> $words;
        int label;
        final /* synthetic */ UserDictionaryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68961(List<UserDictionaryItem> list, UserDictionaryViewModel userDictionaryViewModel, Continuation<? super C68961> continuation) {
            super(2, continuation);
            this.$words = list;
            this.this$0 = userDictionaryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C68961(this.$words, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<UserDictionaryItem> list = this.$words;
            UserDictionaryViewModel userDictionaryViewModel = this.this$0;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                userDictionaryViewModel.userDictionary.removeLabel(((UserDictionaryItem) it.next()).getLabel());
            }
            this.this$0.loadWords$user_dictionary_release();
            this.this$0.save();
            return Unit.INSTANCE;
        }
    }

    public final void clear(List<UserDictionaryItem> words) {
        Intrinsics.checkNotNullParameter(words, "words");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C68961(words, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$2 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$2", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {101}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {104}, m1615s = {}, m1616v = 2)
    static final class C68972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68972(Continuation<? super C68972> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserDictionaryViewModel.this.new C68972(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$clear$2$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserDictionaryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserDictionaryViewModel userDictionaryViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userDictionaryViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.userDictionary.clear();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(UserDictionaryViewModel.this.ioDispatcher, new AnonymousClass1(UserDictionaryViewModel.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UserDictionaryViewModel.this.loadWords$user_dictionary_release();
            UserDictionaryViewModel.this.save();
            return Unit.INSTANCE;
        }
    }

    public final void clear() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C68972(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$addWord$1 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$addWord$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {112}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {115}, m1615s = {}, m1616v = 2)
    static final class C68951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserDictionaryItem $item;
        final /* synthetic */ boolean $save;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68951(UserDictionaryItem userDictionaryItem, boolean z, Continuation<? super C68951> continuation) {
            super(2, continuation);
            this.$item = userDictionaryItem;
            this.$save = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserDictionaryViewModel.this.new C68951(this.$item, this.$save, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(UserDictionaryViewModel.this.checkInput(this.$item.getLabel()), InputStatus.Valid.INSTANCE)) {
                    this.label = 1;
                    if (BuildersKt.withContext(UserDictionaryViewModel.this.ioDispatcher, new AnonymousClass1(UserDictionaryViewModel.this, this.$item, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserDictionaryViewModel.this.loadWords$user_dictionary_release();
            if (this.$save) {
                UserDictionaryViewModel.this.save();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$addWord$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$addWord$1$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserDictionaryItem $item;
            int label;
            final /* synthetic */ UserDictionaryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserDictionaryViewModel userDictionaryViewModel, UserDictionaryItem userDictionaryItem, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userDictionaryViewModel;
                this.$item = userDictionaryItem;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$item, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.userDictionary.addLabel(this.$item.getLabel());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ void addWord$default(UserDictionaryViewModel userDictionaryViewModel, UserDictionaryItem userDictionaryItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        userDictionaryViewModel.addWord(userDictionaryItem, z);
    }

    public final void addWord(UserDictionaryItem item, boolean save) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C68951(item, save, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWord$1 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWord$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {GapComposerKt.nodeKey}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {128}, m1615s = {}, m1616v = 2)
    static final class C68991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserDictionaryItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C68991(UserDictionaryItem userDictionaryItem, Continuation<? super C68991> continuation) {
            super(2, continuation);
            this.$item = userDictionaryItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserDictionaryViewModel.this.new C68991(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWord$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWord$1$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ UserDictionaryItem $item;
            int label;
            final /* synthetic */ UserDictionaryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserDictionaryViewModel userDictionaryViewModel, UserDictionaryItem userDictionaryItem, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userDictionaryViewModel;
                this.$item = userDictionaryItem;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$item, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.userDictionary.removeLabel(this.$item.getLabel());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(UserDictionaryViewModel.this.ioDispatcher, new AnonymousClass1(UserDictionaryViewModel.this, this.$item, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            UserDictionaryViewModel.this.loadWords$user_dictionary_release();
            UserDictionaryViewModel.this.save();
            return Unit.INSTANCE;
        }
    }

    public final void removeWord(UserDictionaryItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C68991(item, null), 2, null);
    }

    public final void removeWords(List<UserDictionaryItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        List<UserDictionaryItem> list = this.removedWords;
        list.clear();
        list.addAll(CollectionsKt.distinct(items));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C69002(items, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWords$2 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$removeWords$2", m1609f = "UserDictionaryViewModel.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_4_1}, m1612m = "invokeSuspend", m1613n = {"$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-UserDictionaryViewModel$removeWords$2$1"}, m1614nl = {144}, m1615s = {"L$0", "L$3", "L$4", "I$0", "I$1"}, m1616v = 2)
    static final class C69002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<UserDictionaryItem> $items;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ UserDictionaryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69002(List<UserDictionaryItem> list, UserDictionaryViewModel userDictionaryViewModel, Continuation<? super C69002> continuation) {
            super(2, continuation);
            this.$items = list;
            this.this$0 = userDictionaryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69002(this.$items, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69002) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Iterable iterable;
            UserDictionaryViewModel userDictionaryViewModel;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<UserDictionaryItem> list = this.$items;
                UserDictionaryViewModel userDictionaryViewModel2 = this.this$0;
                it = list.iterator();
                iterable = list;
                userDictionaryViewModel = userDictionaryViewModel2;
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$2;
                userDictionaryViewModel = (UserDictionaryViewModel) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                UserDictionaryItem userDictionaryItem = (UserDictionaryItem) next;
                CoroutineDispatcher coroutineDispatcher = userDictionaryViewModel.ioDispatcher;
                UserDictionaryViewModel$removeWords$2$1$1 userDictionaryViewModel$removeWords$2$1$1 = new UserDictionaryViewModel$removeWords$2$1$1(userDictionaryViewModel, userDictionaryItem, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = userDictionaryViewModel;
                this.L$2 = it;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.L$4 = SpillingKt.nullOutSpilledVariable(userDictionaryItem);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, userDictionaryViewModel$removeWords$2$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.loadWords$user_dictionary_release();
            this.this$0.save();
            return Unit.INSTANCE;
        }
    }

    public final void restoreRemovedWords() {
        for (UserDictionaryItem userDictionaryItem : this.removedWords) {
            addWord(userDictionaryItem, Intrinsics.areEqual(userDictionaryItem, CollectionsKt.last((List) this.removedWords)));
        }
        loadWords$user_dictionary_release();
    }

    public final void purgeRemovedWords() {
        this.removedWords.clear();
    }

    public final void save() {
        UserDictionary newNativeRef = getNewNativeRef();
        if (newNativeRef != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.ioDispatcher, null, new C69011(newNativeRef, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$save$1 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$save$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C69011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserDictionary $userDictCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69011(UserDictionary userDictionary, Continuation<? super C69011> continuation) {
            super(2, continuation);
            this.$userDictCopy = userDictionary;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69011(this.$userDictCopy, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserDictionary userDictionary = this.$userDictCopy;
            try {
                userDictionary.store();
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(userDictionary, null);
                return Unit.INSTANCE;
            } finally {
            }
        }
    }

    public final InputStatus checkInput(CharSequence input) {
        ArrayList arrayListEmptyList;
        List<UserDictionaryItem> value = getWords().getValue();
        if (value == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List<UserDictionaryItem> list = value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((UserDictionaryItem) it.next()).getLabel());
            }
            arrayListEmptyList = arrayList;
        }
        return UserDictionaryInputChecker.checkInput(input, arrayListEmptyList);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.uiDispatcher, null, new C68981(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$onCleared$1 */
    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$onCleared$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA1_8_4}, m1615s = {}, m1616v = 2)
    static final class C68981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C68981(Continuation<? super C68981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserDictionaryViewModel.this.new C68981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$onCleared$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.userdict.ui.UserDictionaryViewModel$onCleared$1$1", m1609f = "UserDictionaryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserDictionaryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UserDictionaryViewModel userDictionaryViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = userDictionaryViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.userDictionary.delete();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(UserDictionaryViewModel.this.ioDispatcher, new AnonymousClass1(UserDictionaryViewModel.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return UserDictionaryViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserDictionaryViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.userdict.IUserDictionaryProvider");
        return new UserDictionaryViewModel(((IUserDictionaryProvider) componentCallbacks2RequireApplication).provideUserDictionary(), null, null, 6, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(UserDictionaryViewModel.class), new Function1() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserDictionaryViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
