package com.myscript.nebo.network;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.network.ConnectionType;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.network.NetworkProviderInternal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0016\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/network/NeboNetworkStateRepositoryImpl;", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "networkProviderInternal", "Lcom/myscript/nebo/network/NetworkProviderInternal;", "prefSaver", "Lcom/myscript/nebo/network/PrefSaver;", "dozeIdleNotifications", "Lcom/myscript/nebo/network/DozeIdleNotifications;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/myscript/nebo/network/NetworkProviderInternal;Lcom/myscript/nebo/network/PrefSaver;Lcom/myscript/nebo/network/DozeIdleNotifications;Lkotlinx/coroutines/CoroutineDispatcher;)V", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "neboNetworkState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "getNeboNetworkState", "()Landroidx/lifecycle/MutableLiveData;", "networkCallback", "com/myscript/nebo/network/NeboNetworkStateRepositoryImpl$networkCallback$1", "Lcom/myscript/nebo/network/NeboNetworkStateRepositoryImpl$networkCallback$1;", "destroy", "", "computeState", "setDownloadOverCellularEnabled", "enabled", "", "isDownloadOverCellularEnabled", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboNetworkStateRepositoryImpl implements NeboNetworkStateRepository {
    public static final int $stable = 8;
    private final DozeIdleNotifications dozeIdleNotifications;
    private final CoroutineDispatcher mainDispatcher;
    private final MutableLiveData<NeboNetworkState> neboNetworkState;
    private final NeboNetworkStateRepositoryImpl$networkCallback$1 networkCallback;
    private final NetworkProviderInternal networkProviderInternal;
    private CompletableJob parentJob;
    private final PrefSaver prefSaver;
    private final CoroutineScope scope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NeboNetworkStateRepositoryImpl(NetworkProviderInternal networkProviderInternal, PrefSaver prefSaver) {
        this(networkProviderInternal, prefSaver, null, null, 12, null);
        Intrinsics.checkNotNullParameter(networkProviderInternal, "networkProviderInternal");
        Intrinsics.checkNotNullParameter(prefSaver, "prefSaver");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NeboNetworkStateRepositoryImpl(NetworkProviderInternal networkProviderInternal, PrefSaver prefSaver, DozeIdleNotifications dozeIdleNotifications) {
        this(networkProviderInternal, prefSaver, dozeIdleNotifications, null, 8, null);
        Intrinsics.checkNotNullParameter(networkProviderInternal, "networkProviderInternal");
        Intrinsics.checkNotNullParameter(prefSaver, "prefSaver");
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.myscript.nebo.network.NeboNetworkStateRepositoryImpl$networkCallback$1] */
    public NeboNetworkStateRepositoryImpl(NetworkProviderInternal networkProviderInternal, PrefSaver prefSaver, DozeIdleNotifications dozeIdleNotifications, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(networkProviderInternal, "networkProviderInternal");
        Intrinsics.checkNotNullParameter(prefSaver, "prefSaver");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.networkProviderInternal = networkProviderInternal;
        this.prefSaver = prefSaver;
        this.dozeIdleNotifications = dozeIdleNotifications;
        this.mainDispatcher = mainDispatcher;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobJob$default.plus(mainDispatcher));
        this.neboNetworkState = new MutableLiveData<>(NeboNetworkState.Offline.INSTANCE);
        ?? r3 = new NetworkProviderInternal.Callback() { // from class: com.myscript.nebo.network.NeboNetworkStateRepositoryImpl$networkCallback$1
            @Override // com.myscript.nebo.network.NetworkProviderInternal.Callback
            public void onNetworkChanged(boolean hasInternet) {
                this.this$0.computeState();
            }
        };
        this.networkCallback = r3;
        computeState();
        networkProviderInternal.registerNetworkChanges((NetworkProviderInternal.Callback) r3);
        if (dozeIdleNotifications != null) {
            dozeIdleNotifications.registerDozeIdleChanged(new C66331(this));
        }
    }

    public /* synthetic */ NeboNetworkStateRepositoryImpl(NetworkProviderInternal networkProviderInternal, PrefSaver prefSaver, DozeIdleNotifications dozeIdleNotifications, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkProviderInternal, prefSaver, (i & 4) != 0 ? null : dozeIdleNotifications, (i & 8) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    @Override // com.myscript.nebo.common.network.NeboNetworkStateRepository
    public MutableLiveData<NeboNetworkState> getNeboNetworkState() {
        return this.neboNetworkState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.network.NeboNetworkStateRepositoryImpl$1 */
    /* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66331 extends FunctionReferenceImpl implements Function0<Unit> {
        C66331(Object obj) {
            super(0, obj, NeboNetworkStateRepositoryImpl.class, "computeState", "computeState()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((NeboNetworkStateRepositoryImpl) this.receiver).computeState();
        }
    }

    public final void destroy() {
        this.networkProviderInternal.unregisterNetworkChanges(this.networkCallback);
        DozeIdleNotifications dozeIdleNotifications = this.dozeIdleNotifications;
        if (dozeIdleNotifications != null) {
            dozeIdleNotifications.unregisterDozeIdleChanged();
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.network.NeboNetworkStateRepositoryImpl$computeState$1 */
    /* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.network.NeboNetworkStateRepositoryImpl$computeState$1", m1609f = "NeboNetworkStateRepositoryImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66341(Continuation<? super C66341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NeboNetworkStateRepositoryImpl.this.new C66341(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NeboNetworkState.Connected connected;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!NeboNetworkStateRepositoryImpl.this.networkProviderInternal.hasInternetAccess()) {
                    connected = NeboNetworkState.Offline.INSTANCE;
                } else if (NeboNetworkStateRepositoryImpl.this.networkProviderInternal.isNetworkWithoutCharges()) {
                    connected = new NeboNetworkState.Connected(ConnectionType.OTHER, true);
                } else {
                    connected = NeboNetworkStateRepositoryImpl.this.isDownloadOverCellularEnabled() ? new NeboNetworkState.Connected(ConnectionType.CELLULAR, true) : new NeboNetworkState.Connected(ConnectionType.CELLULAR, false);
                }
                if (!Intrinsics.areEqual(NeboNetworkStateRepositoryImpl.this.getNeboNetworkState().getValue(), connected)) {
                    NeboNetworkStateRepositoryImpl.this.getNeboNetworkState().postValue(connected);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void computeState() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, this.mainDispatcher, null, new C66341(null), 2, null);
    }

    @Override // com.myscript.nebo.common.network.NeboNetworkStateRepository
    public void setDownloadOverCellularEnabled(boolean enabled) {
        this.prefSaver.saveBoolean(C6079R.string.pref_network_cellular_key, enabled);
        computeState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDownloadOverCellularEnabled() {
        return this.prefSaver.getBoolean(C6079R.string.pref_network_cellular_key, C6079R.bool.pref_enable_data_over_cellular_default);
    }
}
