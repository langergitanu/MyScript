package com.myscript.nebo.whatsnew;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.dms.core.LibraryMigrator;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.storage.AvailableSpaceProvider;
import com.myscript.nebo.storage.AvailableSpaceProviderImpl;
import com.myscript.nebo.storage.StorageState;
import com.myscript.nebo.whatsnew.PLSMigrationScreenState;
import com.myscript.nebo.whatsnew.PLSMigrationViewModel;
import com.myscript.snt.dms.DMSLogLevel;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: PLSMigrationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u00103\u001a\u00020&H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020-2\u0006\u00106\u001a\u000201H\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u000201H\u0002J\u0006\u00109\u001a\u00020-J\b\u0010:\u001a\u00020-H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0 8F¢\u0006\u0006\u001a\u0004\b(\u0010\"R$\u0010)\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0*j\u0002`.X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010/\u001a\u0018\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010*j\u0002`2X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationViewModel;", "Landroidx/lifecycle/ViewModel;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "libraryMigrator", "Lcom/myscript/nebo/dms/core/LibraryMigrator;", "cloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "availableSpaceProvider", "Lcom/myscript/nebo/storage/AvailableSpaceProvider;", "fakeDelay", "Lkotlin/time/Duration;", "minimumMigrationDuration", "storageStatePollPeriod", "customCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "ioDispatcher", "<init>", "(Lcom/myscript/nebo/log/TechnicalLogger;Lcom/myscript/nebo/dms/core/LibraryMigrator;Lcom/myscript/nebo/cloudsync/CloudManager;Lcom/myscript/nebo/storage/AvailableSpaceProvider;JJJLkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "coroutineScope", "value", "", "requiredSpace", "getRequiredSpace", "()J", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "storageStatePollJob", "Lkotlinx/coroutines/Job;", "_storageState", "Lcom/myscript/nebo/storage/StorageState;", "storageState", "getStorageState", "onMigrationLog", "Lkotlin/Function2;", "Lcom/myscript/snt/dms/DMSLogLevel;", "", "", "Lcom/myscript/nebo/whatsnew/PLSMigrationLogDelegate;", "onMigrationProgress", "", "", "Lcom/myscript/nebo/whatsnew/PLSMigrationProgressDelegate;", "computeStorageState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerLocalMigration", "storageRequirementsSatisfied", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkLowStorage", "forceRefreshAvailableDiskSpace", "onCleared", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PLSMigrationViewModel extends ViewModel {
    private static final ViewModelProvider.Factory Factory;
    private static final String TAG = "PLSMigrationViewModel";
    private final MutableLiveData<PLSMigrationScreenState> _state;
    private final MutableLiveData<StorageState> _storageState;
    private final AvailableSpaceProvider availableSpaceProvider;
    private final CloudManager cloudManager;
    private final CoroutineScope coroutineScope;
    private final long fakeDelay;
    private final CoroutineContext ioDispatcher;
    private final LibraryMigrator libraryMigrator;
    private final TechnicalLogger logger;
    private final CoroutineContext mainDispatcher;
    private final long minimumMigrationDuration;
    private final Function2<DMSLogLevel, String, Unit> onMigrationLog;
    private final Function2<Float, Float, Boolean> onMigrationProgress;
    private long requiredSpace;
    private Job storageStatePollJob;
    private final long storageStatePollPeriod;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$computeStorageState$1 */
    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel", m1609f = "PLSMigrationViewModel.kt", m1610i = {}, m1611l = {220}, m1612m = "computeStorageState", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_2_1}, m1615s = {}, m1616v = 2)
    static final class C69071 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C69071(Continuation<? super C69071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PLSMigrationViewModel.this.computeStorageState(this);
        }
    }

    public /* synthetic */ PLSMigrationViewModel(TechnicalLogger technicalLogger, LibraryMigrator libraryMigrator, CloudManager cloudManager, AvailableSpaceProvider availableSpaceProvider, long j, long j2, long j3, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, DefaultConstructorMarker defaultConstructorMarker) {
        this(technicalLogger, libraryMigrator, cloudManager, availableSpaceProvider, j, j2, j3, coroutineScope, coroutineContext, coroutineContext2);
    }

    private PLSMigrationViewModel(TechnicalLogger logger, LibraryMigrator libraryMigrator, CloudManager cloudManager, AvailableSpaceProvider availableSpaceProvider, long j, long j2, long j3, CoroutineScope coroutineScope, CoroutineContext mainDispatcher, CoroutineContext ioDispatcher) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(libraryMigrator, "libraryMigrator");
        Intrinsics.checkNotNullParameter(cloudManager, "cloudManager");
        Intrinsics.checkNotNullParameter(availableSpaceProvider, "availableSpaceProvider");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.logger = logger;
        this.libraryMigrator = libraryMigrator;
        this.cloudManager = cloudManager;
        this.availableSpaceProvider = availableSpaceProvider;
        this.fakeDelay = j;
        this.minimumMigrationDuration = j2;
        this.storageStatePollPeriod = j3;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        CoroutineScope viewModelScope = coroutineScope == null ? ViewModelKt.getViewModelScope(this) : coroutineScope;
        this.coroutineScope = viewModelScope;
        this._state = new MutableLiveData<>(PLSMigrationScreenState.Preparing.INSTANCE);
        this._storageState = new MutableLiveData<>(new StorageState.Critical(0L));
        this.onMigrationLog = new Function2() { // from class: com.myscript.nebo.whatsnew.PLSMigrationViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PLSMigrationViewModel.onMigrationLog$lambda$0(this.f$0, (DMSLogLevel) obj, (String) obj2);
            }
        };
        this.onMigrationProgress = new Function2() { // from class: com.myscript.nebo.whatsnew.PLSMigrationViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PLSMigrationViewModel.onMigrationProgress$lambda$0(this.f$0, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        };
        this.requiredSpace = Long.MIN_VALUE;
        BuildersKt__Builders_commonKt.launch$default(viewModelScope, mainDispatcher, null, new C69061(null), 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PLSMigrationViewModel(TechnicalLogger technicalLogger, LibraryMigrator libraryMigrator, CloudManager cloudManager, AvailableSpaceProvider availableSpaceProvider, long j, long j2, long j3, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        long duration2;
        long duration3;
        if ((i & 16) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(250, DurationUnit.MILLISECONDS);
        } else {
            duration = j;
        }
        if ((i & 32) != 0) {
            Duration.Companion companion2 = Duration.INSTANCE;
            duration2 = DurationKt.toDuration(4, DurationUnit.SECONDS);
        } else {
            duration2 = j2;
        }
        if ((i & 64) != 0) {
            Duration.Companion companion3 = Duration.INSTANCE;
            duration3 = DurationKt.toDuration(1, DurationUnit.MINUTES);
        } else {
            duration3 = j3;
        }
        this(technicalLogger, libraryMigrator, cloudManager, availableSpaceProvider, duration, duration2, duration3, (i & 128) != 0 ? null : coroutineScope, (i & 256) != 0 ? Dispatchers.getMain() : coroutineContext, (i & 512) != 0 ? Dispatchers.getIO() : coroutineContext2, null);
    }

    public final long getRequiredSpace() {
        return Long.max(this.requiredSpace, this.availableSpaceProvider.getCriticalThreshold());
    }

    public final LiveData<PLSMigrationScreenState> getState() {
        return this._state;
    }

    public final LiveData<StorageState> getStorageState() {
        return this._storageState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMigrationLog$lambda$0(PLSMigrationViewModel pLSMigrationViewModel, DMSLogLevel level, String message) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(message, "message");
        if (level == DMSLogLevel.WARNING || level == DMSLogLevel.ERR) {
            TechnicalLoggerExt.logAction(pLSMigrationViewModel.logger, TAG, "PLS V2 migration " + level.name() + " (" + pLSMigrationViewModel._state.getValue() + ")", new PLSMigrationViewModel$onMigrationLog$1$1(message));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onMigrationProgress$lambda$0(PLSMigrationViewModel pLSMigrationViewModel, float f, float f2) {
        if (!CoroutineScopeKt.isActive(pLSMigrationViewModel.coroutineScope)) {
            return false;
        }
        boolean zCheckLowStorage = pLSMigrationViewModel.checkLowStorage();
        BuildersKt__Builders_commonKt.launch$default(pLSMigrationViewModel.coroutineScope, pLSMigrationViewModel.mainDispatcher, null, new PLSMigrationViewModel$onMigrationProgress$1$1(pLSMigrationViewModel, zCheckLowStorage, f, f2, null), 2, null);
        return zCheckLowStorage;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$1 */
    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$1", m1609f = "PLSMigrationViewModel.kt", m1610i = {0}, m1611l = {185}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1614nl = {195}, m1615s = {"L$0"}, m1616v = 2)
    static final class C69061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C69061(Continuation<? super C69061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C69061 c69061 = PLSMigrationViewModel.this.new C69061(continuation);
            c69061.L$0 = obj;
            return c69061;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$1", m1609f = "PLSMigrationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
            int label;
            final /* synthetic */ PLSMigrationViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PLSMigrationViewModel pLSMigrationViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = pLSMigrationViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxLong(this.this$0.libraryMigrator.requiredDiskSpaceForMigrationToV2());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PLSMigrationViewModel pLSMigrationViewModel;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PLSMigrationViewModel pLSMigrationViewModel2 = PLSMigrationViewModel.this;
                this.L$0 = coroutineScope;
                this.L$1 = pLSMigrationViewModel2;
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(pLSMigrationViewModel2.ioDispatcher, new AnonymousClass1(PLSMigrationViewModel.this, null), this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pLSMigrationViewModel = pLSMigrationViewModel2;
                obj = objWithContext;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pLSMigrationViewModel = (PLSMigrationViewModel) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            pLSMigrationViewModel.requiredSpace = ((Number) obj).longValue();
            PLSMigrationViewModel pLSMigrationViewModel3 = PLSMigrationViewModel.this;
            pLSMigrationViewModel3.storageStatePollJob = BuildersKt__Builders_commonKt.async$default(coroutineScope, pLSMigrationViewModel3.mainDispatcher, null, new AnonymousClass2(PLSMigrationViewModel.this, null), 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$2", m1609f = "PLSMigrationViewModel.kt", m1610i = {0, 1, 1, 2, 2}, m1611l = {198, 208, 210}, m1612m = "invokeSuspend", m1613n = {"$this$async", "$this$async", "newStorageState", "$this$async", "newStorageState"}, m1614nl = {199, 210, 211}, m1615s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ PLSMigrationViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PLSMigrationViewModel pLSMigrationViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = pLSMigrationViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b3 -> B:17:0x0035). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                final StorageState storageState;
                PLSMigrationViewModel pLSMigrationViewModel;
                boolean z;
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        storageState = (StorageState) obj;
                        TechnicalLoggerExt.logAction(this.this$0.logger, PLSMigrationViewModel.TAG, "Refresh storage state", new Function0() { // from class: com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PLSMigrationViewModel.C69061.AnonymousClass2.invokeSuspend$lambda$0(storageState);
                            }
                        });
                        pLSMigrationViewModel = this.this$0;
                        synchronized (pLSMigrationViewModel) {
                            z = !CoroutineScopeKt.isActive(coroutineScope) || pLSMigrationViewModel.storageStatePollJob == null;
                        }
                        if (!z) {
                            this.this$0._storageState.setValue(storageState);
                            PLSMigrationViewModel pLSMigrationViewModel2 = this.this$0;
                            this.L$0 = coroutineScope;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(storageState);
                            this.label = 2;
                            if (pLSMigrationViewModel2.triggerLocalMigration(pLSMigrationViewModel2.checkLowStorage(), this) != coroutine_suspended) {
                                this.L$0 = coroutineScope;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(storageState);
                                this.label = 3;
                                if (DelayKt.m16008delayVtjQ1oo(this.this$0.storageStatePollPeriod, this) != coroutine_suspended) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i == 2) {
                        storageState = (StorageState) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = coroutineScope;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(storageState);
                        this.label = 3;
                        if (DelayKt.m16008delayVtjQ1oo(this.this$0.storageStatePollPeriod, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 1;
                    obj = this.this$0.computeStorageState(this);
                    if (obj != coroutine_suspended) {
                        storageState = (StorageState) obj;
                        TechnicalLoggerExt.logAction(this.this$0.logger, PLSMigrationViewModel.TAG, "Refresh storage state", new Function0() { // from class: com.myscript.nebo.whatsnew.PLSMigrationViewModel$1$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PLSMigrationViewModel.C69061.AnonymousClass2.invokeSuspend$lambda$0(storageState);
                            }
                        });
                        pLSMigrationViewModel = this.this$0;
                        synchronized (pLSMigrationViewModel) {
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String invokeSuspend$lambda$0(StorageState storageState) {
                return storageState.getClass().getSimpleName() + " (" + CommonUtils.getHumanReadableByteCount(storageState.getAvailableSpace(), true) + ")";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeStorageState(Continuation<? super StorageState> continuation) {
        C69071 c69071;
        if (continuation instanceof C69071) {
            c69071 = (C69071) continuation;
            if ((c69071.label & Integer.MIN_VALUE) != 0) {
                c69071.label -= Integer.MIN_VALUE;
            } else {
                c69071 = new C69071(continuation);
            }
        }
        Object availableSpace = c69071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c69071.label;
        if (i == 0) {
            ResultKt.throwOnFailure(availableSpace);
            AvailableSpaceProvider availableSpaceProvider = this.availableSpaceProvider;
            c69071.label = 1;
            availableSpace = availableSpaceProvider.getAvailableSpace(c69071);
            if (availableSpace == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(availableSpace);
        }
        StorageState storageStateFromSpace = StorageState.INSTANCE.fromSpace(((Number) availableSpace).longValue(), this.availableSpaceProvider.getCriticalThreshold(), this.availableSpaceProvider.getLowThreshold());
        TechnicalLoggerExt.setStorageStateKeyValues(this.logger, storageStateFromSpace);
        return storageStateFromSpace;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$triggerLocalMigration$2 */
    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$triggerLocalMigration$2", m1609f = "PLSMigrationViewModel.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {247, 277}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "newState", "minimumTimeEnd", "$this$launch", "newState", "minimumTimeEnd", "migrationSucceeded"}, m1614nl = {256, 279}, m1615s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "Z$0"}, m1616v = 2)
    static final class C69092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $storageRequirementsSatisfied;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C69092(boolean z, Continuation<? super C69092> continuation) {
            super(2, continuation);
            this.$storageRequirementsSatisfied = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C69092 c69092 = PLSMigrationViewModel.this.new C69092(this.$storageRequirementsSatisfied, continuation);
            c69092.L$0 = obj;
            return c69092;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0118, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(java.lang.Long.max(r6 - java.lang.System.currentTimeMillis(), kotlin.time.Duration.m15867getInWholeMillisecondsimpl(r12.this$0.fakeDelay)), r12) == r1) goto L47;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PLSMigrationScreenState.Migrating migratingCopy$default;
            long jCurrentTimeMillis;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PLSMigrationScreenState pLSMigrationScreenState = (PLSMigrationScreenState) PLSMigrationViewModel.this._state.getValue();
                if (Intrinsics.areEqual(pLSMigrationScreenState, PLSMigrationScreenState.Preparing.INSTANCE)) {
                    migratingCopy$default = new PLSMigrationScreenState.Migrating(this.$storageRequirementsSatisfied, 0, 0, 6, null);
                } else if (pLSMigrationScreenState instanceof PLSMigrationScreenState.Migrating) {
                    PLSMigrationScreenState.Migrating migrating = (PLSMigrationScreenState.Migrating) pLSMigrationScreenState;
                    boolean zIsOngoing = migrating.isOngoing();
                    boolean z = this.$storageRequirementsSatisfied;
                    if (zIsOngoing == z) {
                        return Unit.INSTANCE;
                    }
                    migratingCopy$default = PLSMigrationScreenState.Migrating.copy$default(migrating, z, 0, 0, 6, null);
                } else {
                    return Unit.INSTANCE;
                }
                PLSMigrationViewModel.this._state.setValue(migratingCopy$default);
                if (this.$storageRequirementsSatisfied) {
                    jCurrentTimeMillis = System.currentTimeMillis() + Duration.m15867getInWholeMillisecondsimpl(PLSMigrationViewModel.this.minimumMigrationDuration);
                    this.L$0 = coroutineScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(migratingCopy$default);
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    obj = BuildersKt.withContext(PLSMigrationViewModel.this.ioDispatcher, new C6910x3f355732(PLSMigrationViewModel.this, null), this);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    PLSMigrationViewModel.this._state.setValue(PLSMigrationScreenState.EndWithoutSync.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            jCurrentTimeMillis = this.J$0;
            migratingCopy$default = (PLSMigrationScreenState.Migrating) this.L$1;
            ResultKt.throwOnFailure(obj);
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (!zBooleanValue) {
                PLSMigrationViewModel.this.logger.logError(new RuntimeException("PLS V2 migration failure"));
            }
            if (CoroutineScopeKt.isActive(coroutineScope) && (zBooleanValue || PLSMigrationViewModel.this.checkLowStorage())) {
                PLSMigrationViewModel pLSMigrationViewModel = PLSMigrationViewModel.this;
                synchronized (pLSMigrationViewModel) {
                    Job job = pLSMigrationViewModel.storageStatePollJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    pLSMigrationViewModel.storageStatePollJob = null;
                    Unit unit = Unit.INSTANCE;
                }
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(migratingCopy$default);
                this.J$0 = jCurrentTimeMillis;
                this.Z$0 = zBooleanValue;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object triggerLocalMigration(boolean z, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C69092(z, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkLowStorage() {
        StorageState value = getStorageState().getValue();
        if (value == null) {
            return false;
        }
        long availableSpace = value.getAvailableSpace();
        long requiredSpace = getRequiredSpace();
        return 0 <= requiredSpace && requiredSpace <= availableSpace && !(value instanceof StorageState.Critical);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationViewModel$forceRefreshAvailableDiskSpace$1 */
    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.whatsnew.PLSMigrationViewModel$forceRefreshAvailableDiskSpace$1", m1609f = "PLSMigrationViewModel.kt", m1610i = {0, 1}, m1611l = {302, 303}, m1612m = "invokeSuspend", m1613n = {"migrationState", "migrationState"}, m1614nl = {303, 305}, m1615s = {"L$0", "L$0"}, m1616v = 2)
    static final class C69081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C69081(Continuation<? super C69081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PLSMigrationViewModel.this.new C69081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        
            if (r10.triggerLocalMigration(r10.checkLowStorage(), r9) != r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            PLSMigrationScreenState.Migrating migrating;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PLSMigrationScreenState value = PLSMigrationViewModel.this.getState().getValue();
                PLSMigrationScreenState.Migrating migrating2 = value instanceof PLSMigrationScreenState.Migrating ? (PLSMigrationScreenState.Migrating) value : null;
                if (migrating2 == null) {
                    return Unit.INSTANCE;
                }
                if (!migrating2.isOngoing()) {
                    mutableLiveData = PLSMigrationViewModel.this._storageState;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(migrating2);
                    this.L$1 = mutableLiveData;
                    this.label = 1;
                    Object objComputeStorageState = PLSMigrationViewModel.this.computeStorageState(this);
                    if (objComputeStorageState != coroutine_suspended) {
                        migrating = migrating2;
                        obj = objComputeStorageState;
                        mutableLiveData.setValue(obj);
                        PLSMigrationViewModel pLSMigrationViewModel = PLSMigrationViewModel.this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(migrating);
                        this.L$1 = null;
                        this.label = 2;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            mutableLiveData = (MutableLiveData) this.L$1;
            migrating = (PLSMigrationScreenState.Migrating) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableLiveData.setValue(obj);
            PLSMigrationViewModel pLSMigrationViewModel2 = PLSMigrationViewModel.this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(migrating);
            this.L$1 = null;
            this.label = 2;
        }
    }

    public final void forceRefreshAvailableDiskSpace() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.mainDispatcher, null, new C69081(null), 2, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        synchronized (this) {
            Job job = this.storageStatePollJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.storageStatePollJob = null;
            Unit unit = Unit.INSTANCE;
        }
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
        super.onCleared();
    }

    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationViewModel$Companion;", "", "<init>", "()V", "TAG", "", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return PLSMigrationViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PLSMigrationViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return new PLSMigrationViewModel(((TechnicalLoggerProvider) objRequireApplication).provideTechnicalLogger(), ((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository(), ((CloudManager.Provider) objRequireApplication).provideCloudManager(), new AvailableSpaceProviderImpl((Context) objRequireApplication), 0L, 0L, 0L, null, null, null, 1008, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(PLSMigrationViewModel.class), new Function1() { // from class: com.myscript.nebo.whatsnew.PLSMigrationViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PLSMigrationViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
