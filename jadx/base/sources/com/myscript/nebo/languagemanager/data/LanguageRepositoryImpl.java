package com.myscript.nebo.languagemanager.data;

import androidx.lifecycle.Observer;
import com.myscript.atk.resourcemanager.GlobalDownloadsCallback;
import com.myscript.atk.resourcemanager.Language;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.languagemanager.domain.LanguageRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\fH\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/data/LanguageRepositoryImpl;", "Lcom/myscript/nebo/languagemanager/domain/LanguageRepository;", "resourceManager", "Lcom/myscript/atk/resourcemanager/ResourceManager;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "<init>", "(Lcom/myscript/atk/resourcemanager/ResourceManager;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;)V", "_neboNetworkState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "neboNetworkDataState", "Lkotlinx/coroutines/flow/Flow;", "getNeboNetworkDataState", "()Lkotlinx/coroutines/flow/Flow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "onNetworkUpdate", "Landroidx/lifecycle/Observer;", "getLanguages", "", "Lcom/myscript/atk/resourcemanager/Language;", "getInstalledLanguages", "removeLanguage", "", "languageKey", "", "downloadLanguage", "cancelDownloadLanguage", "canDownload", "", "isDownloading", "addGlobalDownloadCallback", "callback", "Lcom/myscript/atk/resourcemanager/GlobalDownloadsCallback;", "removeGlobalDownloadCallback", "destroy", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageRepositoryImpl implements LanguageRepository {
    private final MutableStateFlow<NeboNetworkState> _neboNetworkState;
    private final CoroutineScope coroutineScope;
    private final NeboNetworkStateRepository networkStateRepository;
    private final Observer<NeboNetworkState> onNetworkUpdate;
    private final ResourceManager resourceManager;

    private static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public LanguageRepositoryImpl(ResourceManager resourceManager, NeboNetworkStateRepository networkStateRepository) {
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        this.resourceManager = resourceManager;
        this.networkStateRepository = networkStateRepository;
        this._neboNetworkState = StateFlowKt.MutableStateFlow(NeboNetworkState.Offline.INSTANCE);
        this.coroutineScope = GlobalScope.INSTANCE;
        Observer<NeboNetworkState> observer = new Observer() { // from class: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LanguageRepositoryImpl.onNetworkUpdate$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        };
        this.onNetworkUpdate = observer;
        networkStateRepository.getNeboNetworkState().observeForever(observer);
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public Flow<NeboNetworkState> getNeboNetworkDataState() {
        return this._neboNetworkState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNetworkUpdate$lambda$0(LanguageRepositoryImpl languageRepositoryImpl, NeboNetworkState networkState) {
        List<Language> currentDownloads;
        Intrinsics.checkNotNullParameter(networkState, "networkState");
        if (!networkState.isDataTransferAllowed() && (currentDownloads = languageRepositoryImpl.resourceManager.getCurrentDownloads()) != null && !currentDownloads.isEmpty()) {
            Iterator<Language> it = currentDownloads.iterator();
            while (it.hasNext()) {
                languageRepositoryImpl.resourceManager.cancelDownload(it.next());
            }
        }
        languageRepositoryImpl._neboNetworkState.setValue(networkState);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getLanguages$1 */
    /* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getLanguages$1", m1609f = "LanguageRepositoryImpl.kt", m1610i = {0, 1, 1}, m1611l = {53, 63}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$flow", "languages"}, m1614nl = {63, 64}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 2)
    static final class C66151 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Language>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C66151(Continuation<? super C66151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C66151 c66151 = LanguageRepositoryImpl.this.new C66151(continuation);
            c66151.L$0 = obj;
            return c66151;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Language>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<Language>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<Language>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C66151) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        
            if (r0.emit(r8, r7) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new LanguageRepositoryImpl$getLanguages$1$languages$1(LanguageRepositoryImpl.this, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 2;
        }
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public Flow<List<Language>> getLanguages() {
        return FlowKt.flow(new C66151(null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getInstalledLanguages$1 */
    /* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/myscript/atk/resourcemanager/Language;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$getInstalledLanguages$1", m1609f = "LanguageRepositoryImpl.kt", m1610i = {0, 1, 1}, m1611l = {67, 73}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$flow", "installedLanguages"}, m1614nl = {73, 74}, m1615s = {"L$0", "L$0", "L$1"}, m1616v = 2)
    static final class C66131 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Language>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C66131(Continuation<? super C66131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C66131 c66131 = LanguageRepositoryImpl.this.new C66131(continuation);
            c66131.L$0 = obj;
            return c66131;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Language>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<Language>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<Language>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C66131) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        
            if (r0.emit(r8, r7) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = flowCollector;
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new C6614x5abc5f70(LanguageRepositoryImpl.this, null), this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 2;
        }
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public Flow<List<Language>> getInstalledLanguages() {
        return FlowKt.flow(new C66131(null));
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void removeLanguage(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.resourceManager.deleteLanguage(new Language(languageKey, null, false, null, 14, null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$downloadLanguage$1 */
    /* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$downloadLanguage$1", m1609f = "LanguageRepositoryImpl.kt", m1610i = {}, m1611l = {82}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {85}, m1615s = {}, m1616v = 2)
    static final class C66121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $languageKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66121(String str, Continuation<? super C66121> continuation) {
            super(2, continuation);
            this.$languageKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LanguageRepositoryImpl.this.new C66121(this.$languageKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$downloadLanguage$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: LanguageRepositoryImpl.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.languagemanager.data.LanguageRepositoryImpl$downloadLanguage$1$1", m1609f = "LanguageRepositoryImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $languageKey;
            int label;
            final /* synthetic */ LanguageRepositoryImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LanguageRepositoryImpl languageRepositoryImpl, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = languageRepositoryImpl;
                this.$languageKey = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$languageKey, continuation);
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
                    this.this$0.resourceManager.downloadLanguage(new Language(this.$languageKey, null, false, null, 14, null));
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
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(LanguageRepositoryImpl.this, this.$languageKey, null), this) == coroutine_suspended) {
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

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void downloadLanguage(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C66121(languageKey, null), 3, null);
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void cancelDownloadLanguage(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.resourceManager.cancelDownload(new Language(languageKey, null, false, null, 14, null));
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public boolean canDownload() {
        NeboNetworkState value = this.networkStateRepository.getNeboNetworkState().getValue();
        return value != null && value.isDataTransferAllowed();
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public boolean isDownloading() {
        Intrinsics.checkNotNullExpressionValue(this.resourceManager.getCurrentDownloads(), "getCurrentDownloads(...)");
        return !r0.isEmpty();
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void addGlobalDownloadCallback(GlobalDownloadsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.resourceManager.addDownloadsCallback(callback);
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void removeGlobalDownloadCallback(GlobalDownloadsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.resourceManager.removeDownloadsCallback(callback);
    }

    @Override // com.myscript.nebo.languagemanager.domain.LanguageRepository
    public void destroy() {
        this.networkStateRepository.getNeboNetworkState().removeObserver(this.onNetworkUpdate);
    }
}
