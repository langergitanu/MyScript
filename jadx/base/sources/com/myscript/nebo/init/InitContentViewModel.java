package com.myscript.nebo.init;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: InitContentViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ2\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/init/InitContentViewModel;", "Landroidx/lifecycle/ViewModel;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "languageKey", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/init/InitContentState;", "kotlin.jvm.PlatformType", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "createInitialContent", "", "collectionName", "folderName", "folderColor", "", "notebookName", "notebookColor", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InitContentViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<InitContentState> _state;
    private final CoroutineDispatcher ioDispatcher;
    private final String languageKey;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;

    public InitContentViewModel(LibraryRepository libraryRepository, String languageKey, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.languageKey = languageKey;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this._state = new MutableLiveData<>(new InitContentState(false, false, null, 7, null));
    }

    public /* synthetic */ InitContentViewModel(LibraryRepository libraryRepository, String str, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraryRepository, str, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final LiveData<InitContentState> getState() {
        return this._state;
    }

    public final void createInitialContent(String collectionName, String folderName, int folderColor, String notebookName, int notebookColor) {
        Intrinsics.checkNotNullParameter(collectionName, "collectionName");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(notebookName, "notebookName");
        InitContentState value = this._state.getValue();
        if (value == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C65941(value, collectionName, folderName, folderColor, notebookColor, notebookName, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.init.InitContentViewModel$createInitialContent$1 */
    /* JADX INFO: compiled from: InitContentViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.init.InitContentViewModel$createInitialContent$1", m1609f = "InitContentViewModel.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA8_1}, m1615s = {}, m1616v = 2)
    static final class C65941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionName;
        final /* synthetic */ int $folderColor;
        final /* synthetic */ String $folderName;
        final /* synthetic */ int $notebookColor;
        final /* synthetic */ String $notebookName;
        final /* synthetic */ InitContentState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C65941(InitContentState initContentState, String str, String str2, int i, int i2, String str3, Continuation<? super C65941> continuation) {
            super(2, continuation);
            this.$state = initContentState;
            this.$collectionName = str;
            this.$folderName = str2;
            this.$folderColor = i;
            this.$notebookColor = i2;
            this.$notebookName = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InitContentViewModel.this.new C65941(this.$state, this.$collectionName, this.$folderName, this.$folderColor, this.$notebookColor, this.$notebookName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C65941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InitContentViewModel.this._state.setValue(InitContentState.copy$default(this.$state, true, false, null, 6, null));
                this.label = 1;
                obj = BuildersKt.withContext(InitContentViewModel.this.ioDispatcher, new InitContentViewModel$createInitialContent$1$result$1(InitContentViewModel.this, this.$collectionName, this.$state, this.$folderName, this.$folderColor, this.$notebookColor, this.$notebookName, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            InitContentViewModel.this._state.setValue(InitContentState.copy$default((InitContentState) obj, false, false, null, 6, null));
            return Unit.INSTANCE;
        }
    }
}
