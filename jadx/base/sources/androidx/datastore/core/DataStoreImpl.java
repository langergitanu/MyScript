package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 Y*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYBp\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012?\b\u0002\u0010\u0005\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00070\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aJ\u000e\u0010!\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\"\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u001aJA\u0010#\u001a\u00028\u000021\u0010$\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007H\u0096@¢\u0006\u0002\u0010&J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000=2\u0006\u0010>\u001a\u00020?H\u0082@¢\u0006\u0002\u0010@J\u001c\u0010A\u001a\u00020\r2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0082@¢\u0006\u0002\u0010CJ\u000e\u0010D\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u001aJ\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000=2\u0006\u0010>\u001a\u00020?H\u0082@¢\u0006\u0002\u0010@J\u000e\u0010F\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010\u001aJI\u0010G\u001a\u00028\u000021\u0010$\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u0006\u0010H\u001a\u00020IH\u0082@¢\u0006\u0002\u0010JJ \u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00020?H\u0080@¢\u0006\u0004\bN\u0010OJ\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000Q2\u0006\u0010R\u001a\u00020?H\u0082@¢\u0006\u0002\u0010@JG\u0010S\u001a\u0002HT\"\u0004\b\u0001\u0010T2\u0006\u0010R\u001a\u00020?2\u001c\u0010U\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002HT0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0VH\u0082@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010WR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010)\u001a\f0*R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-0,X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b1\u00102*\u0004\b/\u00100R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000;0:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, m1599d2 = {"Landroidx/datastore/core/DataStoreImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/CurrentDataProviderStore;", "storage", "Landroidx/datastore/core/Storage;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/datastore/core/Storage;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "currentData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectorMutex", "Lkotlinx/coroutines/sync/Mutex;", "collectorCounter", "", "collectorJob", "Lkotlinx/coroutines/Job;", "incrementCollector", "decrementCollector", "updateData", "transform", "t", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inMemoryCache", "Landroidx/datastore/core/DataStoreInMemoryCache;", "readAndInit", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "storageConnectionDelegate", "Lkotlin/Lazy;", "Landroidx/datastore/core/StorageConnection;", "storageConnection", "getStorageConnection$datastore_core$delegate", "(Landroidx/datastore/core/DataStoreImpl;)Ljava/lang/Object;", "getStorageConnection$datastore_core", "()Landroidx/datastore/core/StorageConnection;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "coordinator$delegate", "Lkotlin/Lazy;", "writeActor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/Message$Update;", "readState", "Landroidx/datastore/core/State;", "requireLock", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "(Landroidx/datastore/core/Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readDataAndUpdateCache", "readDataFromFileOrDefault", "transformAndWrite", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "updateCache", "writeData$datastore_core", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDataOrHandleCorruption", "Landroidx/datastore/core/Data;", "hasWriteFileLock", "doWithWriteFileLock", "R", "block", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InitDataStore", "Companion", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class DataStoreImpl<T> implements CurrentDataProviderStore<T> {
    public static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    private int collectorCounter;
    private Job collectorJob;
    private final Mutex collectorMutex;

    /* JADX INFO: renamed from: coordinator$delegate, reason: from kotlin metadata */
    private final Lazy coordinator;
    private final CorruptionHandler<T> corruptionHandler;
    private final Flow<T> data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final CoroutineScope scope;
    private final Storage<T> storage;
    private final Lazy<StorageConnection<T>> storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$currentData$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {120}, m1612m = "currentData", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18511 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18511(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18511> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.currentData(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$decrementCollector$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {0}, m1611l = {566}, m1612m = "decrementCollector", m1613n = {"$this$withLock_u24default$iv"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C18571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18571(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18571> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$handleUpdate$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_5_1}, m1612m = "handleUpdate", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18591(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18591> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$incrementCollector$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {0}, m1611l = {566}, m1612m = "incrementCollector", m1613n = {"$this$withLock_u24default$iv"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C18601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18601(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18601> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.incrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {1}, m1611l = {284, 286}, m1612m = "readAndInitOrPropagateAndThrowFailure", m1613n = {"preReadVersion"}, m1615s = {"I$0"}, m1616v = 1)
    static final class C18621 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18621(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18621> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {0, 0}, m1611l = {305, 314, PDFACompliance.e_PDFA3_2_2}, m1612m = "readDataAndUpdateCache", m1613n = {"currentState", "requireLock"}, m1615s = {"L$0", "Z$0"}, m1616v = 1)
    static final class C18631 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18631(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18631> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataAndUpdateCache(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl", m1609f = "DataStoreImpl.kt", m1610i = {0, 1, 2, 3, 4, 4, 4, 5, 5, 5}, m1611l = {385, 386, 388, 389, 396, 400}, m1612m = "readDataOrHandleCorruption", m1613n = {"hasWriteFileLock", "hasWriteFileLock", "hasWriteFileLock", "hasWriteFileLock", "ex", "newData", "hasWriteFileLock", "ex", "newData", "version"}, m1615s = {"Z$0", "Z$0", "Z$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C18661 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18661(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18661> continuation) {
            super(continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(false, this);
        }
    }

    public DataStoreImpl(Storage<T> storage, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList, CorruptionHandler<T> corruptionHandler, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = MutexKt.Mutex$default(false, 1, null);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DataStoreImpl.storageConnectionDelegate$lambda$0(this.f$0);
            }
        });
        this.coordinator = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DataStoreImpl.coordinator_delegate$lambda$0(this.f$0);
            }
        });
        this.writeActor = new SimpleActor<>(scope, new Function1() { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataStoreImpl.writeActor$lambda$0(this.f$0, (Throwable) obj);
            }
        }, new Function2() { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DataStoreImpl.writeActor$lambda$1((Message.Update) obj, (Throwable) obj2);
            }
        }, new DataStoreImpl$writeActor$3(this, null));
    }

    public /* synthetic */ DataStoreImpl(Storage storage, List list, NoOpCorruptionHandler noOpCorruptionHandler, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? new NoOpCorruptionHandler() : noOpCorruptionHandler, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    @Override // androidx.datastore.core.DataStore
    public Flow<T> getData() {
        return this.data;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.datastore.core.CurrentDataProviderStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object currentData(Continuation<? super T> continuation) throws Throwable {
        C18511 c18511;
        if (continuation instanceof C18511) {
            c18511 = (C18511) continuation;
            if ((c18511.label & Integer.MIN_VALUE) != 0) {
                c18511.label -= Integer.MIN_VALUE;
            } else {
                c18511 = new C18511(this, continuation);
            }
        }
        Object state = c18511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(state);
            c18511.label = 1;
            state = readState(false, c18511);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(state);
        }
        State state2 = (State) state;
        if (state2 instanceof Data) {
            return ((Data) state2).getValue();
        }
        if (state2 instanceof UnInitialized) {
            throw new IllegalStateException(BUG_MESSAGE.toString());
        }
        if (state2 instanceof ReadException) {
            throw ((ReadException) state2).getReadException();
        }
        if (state2 instanceof Final) {
            throw ((Final) state2).getFinalException();
        }
        if (state2 instanceof NoValueDataState) {
            throw new IllegalStateException(BUG_MESSAGE.toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object incrementCollector(Continuation<? super Unit> continuation) {
        C18601 c18601;
        Mutex mutex;
        if (continuation instanceof C18601) {
            c18601 = (C18601) continuation;
            if ((c18601.label & Integer.MIN_VALUE) != 0) {
                c18601.label -= Integer.MIN_VALUE;
            } else {
                c18601 = new C18601(this, continuation);
            }
        }
        Object obj = c18601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.collectorMutex;
            c18601.L$0 = mutex;
            c18601.label = 1;
            if (mutex.lock(null, c18601) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c18601.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
        }
        try {
            int i2 = this.collectorCounter + 1;
            this.collectorCounter = i2;
            if (i2 == 1) {
                this.collectorJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DataStoreImpl$incrementCollector$2$1(this, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decrementCollector(Continuation<? super Unit> continuation) {
        C18571 c18571;
        Mutex mutex;
        if (continuation instanceof C18571) {
            c18571 = (C18571) continuation;
            if ((c18571.label & Integer.MIN_VALUE) != 0) {
                c18571.label -= Integer.MIN_VALUE;
            } else {
                c18571 = new C18571(this, continuation);
            }
        }
        Object obj = c18571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.collectorMutex;
            c18571.L$0 = mutex2;
            c18571.label = 1;
            if (mutex2.lock(null, c18571) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c18571.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            int i2 = this.collectorCounter - 1;
            this.collectorCounter = i2;
            if (i2 == 0) {
                Job job = this.collectorJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.collectorJob = null;
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new C18712(this, function2, null), continuation);
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$updateData$2 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$updateData$2", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {185}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super T>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C18712(DataStoreImpl<T> dataStoreImpl, Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C18712> continuation) {
            super(2, continuation);
            this.this$0 = dataStoreImpl;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18712 c18712 = new C18712(this.this$0, this.$transform, continuation);
            c18712.L$0 = obj;
            return c18712;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C18712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            NoValueDataState currentState = ((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState();
            if (currentState instanceof Data) {
                currentState = new NoValueDataState(((Data) currentState).getVersion());
            }
            ((DataStoreImpl) this.this$0).writeActor.offer(new Message.Update(this.$transform, completableDeferredCompletableDeferred$default, currentState, coroutineScope.getCoroutineContext()));
            this.label = 1;
            Object objAwait = completableDeferredCompletableDeferred$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StorageConnection storageConnectionDelegate$lambda$0(DataStoreImpl dataStoreImpl) {
        return dataStoreImpl.storage.createConnection();
    }

    public final StorageConnection<T> getStorageConnection$datastore_core() {
        return this.storageConnectionDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterProcessCoordinator coordinator_delegate$lambda$0(DataStoreImpl dataStoreImpl) {
        return dataStoreImpl.getStorageConnection$datastore_core().getCoordinator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeActor$lambda$0(DataStoreImpl dataStoreImpl, Throwable th) {
        if (th != null) {
            dataStoreImpl.inMemoryCache.tryUpdate(new Final(th));
        }
        if (dataStoreImpl.storageConnectionDelegate.isInitialized()) {
            dataStoreImpl.getStorageConnection$datastore_core().close();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeActor$lambda$1(Message.Update msg, Throwable th) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        CompletableDeferred<T> ack = msg.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        ack.completeExceptionally(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readState$2 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$readState$2", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_2, PsExtractor.VIDEO_STREAM_MASK}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18692 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State<T>>, Object> {
        final /* synthetic */ boolean $requireLock;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18692(DataStoreImpl<T> dataStoreImpl, boolean z, Continuation<? super C18692> continuation) {
            super(2, continuation);
            this.this$0 = dataStoreImpl;
            this.$requireLock = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18692(this.this$0, this.$requireLock, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super State<T>> continuation) {
            return ((C18692) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        
            if (r5 == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState() instanceof Final) {
                        return ((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState();
                    }
                    this.label = 1;
                    if (this.this$0.readAndInitOrPropagateAndThrowFailure(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return (State) obj;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 2;
                obj = this.this$0.readDataAndUpdateCache(this.$requireLock, this);
            } catch (Throwable th) {
                return new ReadException(th, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z, Continuation<? super State<T>> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C18692(this, z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleUpdate(Message.Update<T> update, Continuation<? super Unit> continuation) {
        C18591 c18591;
        Throwable th;
        CompletableDeferred<T> completableDeferred;
        Object objM14499constructorimpl;
        if (continuation instanceof C18591) {
            c18591 = (C18591) continuation;
            if ((c18591.label & Integer.MIN_VALUE) != 0) {
                c18591.label -= Integer.MIN_VALUE;
            } else {
                c18591 = new C18591(this, continuation);
            }
        }
        Object obj = c18591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CompletableDeferred<T> ack = update.getAck();
            try {
                Result.Companion companion = Result.INSTANCE;
                DataStoreImpl<T> dataStoreImpl = this;
                CoroutineContext coroutineContextPlus = update.getCallerContext().plus(c18591.getContext());
                DataStoreImpl$handleUpdate$2$1 dataStoreImpl$handleUpdate$2$1 = new DataStoreImpl$handleUpdate$2$1(this, update, null);
                c18591.L$0 = ack;
                c18591.label = 1;
                Object objWithContext = BuildersKt.withContext(coroutineContextPlus, dataStoreImpl$handleUpdate$2$1, c18591);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objWithContext;
                completableDeferred = ack;
            } catch (Throwable th2) {
                th = th2;
                completableDeferred = ack;
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableDeferred = (CompletableDeferred) c18591.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion22 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
        }
        objM14499constructorimpl = Result.m14499constructorimpl(obj);
        CompletableDeferredKt.completeWith(completableDeferred, objM14499constructorimpl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r2.runIfNeeded(r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInitOrPropagateAndThrowFailure(Continuation<? super Unit> continuation) throws Throwable {
        C18621 c18621;
        int iIntValue;
        int i;
        Throwable th;
        if (continuation instanceof C18621) {
            c18621 = (C18621) continuation;
            if ((c18621.label & Integer.MIN_VALUE) != 0) {
                c18621.label -= Integer.MIN_VALUE;
            } else {
                c18621 = new C18621(this, continuation);
            }
        }
        Object version = c18621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c18621.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(version);
                InterProcessCoordinator coordinator = getCoordinator();
                c18621.label = 1;
                version = coordinator.getVersion(c18621);
                if (version != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = c18621.I$0;
                try {
                    ResultKt.throwOnFailure(version);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    this.inMemoryCache.tryUpdate(new ReadException(th, i));
                    throw th;
                }
            }
            ResultKt.throwOnFailure(version);
            DataStoreImpl<T>.InitDataStore initDataStore = this.readAndInit;
            c18621.I$0 = iIntValue;
            c18621.label = 2;
        } catch (Throwable th3) {
            i = iIntValue;
            th = th3;
            this.inMemoryCache.tryUpdate(new ReadException(th, i));
            throw th;
        }
        iIntValue = ((Number) version).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        if (r9 == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ac, code lost:
    
        if (r9 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataAndUpdateCache(boolean z, Continuation<? super State<T>> continuation) {
        C18631 c18631;
        State<T> currentState;
        Pair pair;
        if (continuation instanceof C18631) {
            c18631 = (C18631) continuation;
            if ((c18631.label & Integer.MIN_VALUE) != 0) {
                c18631.label -= Integer.MIN_VALUE;
            } else {
                c18631 = new C18631(this, continuation);
            }
        }
        Object version = c18631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(version);
            currentState = this.inMemoryCache.getCurrentState();
            if (currentState instanceof UnInitialized) {
                throw new IllegalStateException(BUG_MESSAGE.toString());
            }
            InterProcessCoordinator coordinator = getCoordinator();
            c18631.L$0 = currentState;
            c18631.Z$0 = z;
            c18631.label = 1;
            version = coordinator.getVersion(c18631);
            if (version != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(version);
                pair = (Pair) version;
                State<T> state = (State) pair.component1();
                if (((Boolean) pair.component2()).booleanValue()) {
                }
                return state;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(version);
            pair = (Pair) version;
            State<T> state2 = (State) pair.component1();
            if (((Boolean) pair.component2()).booleanValue()) {
                this.inMemoryCache.tryUpdate(state2);
            }
            return state2;
        }
        z = c18631.Z$0;
        currentState = (State) c18631.L$0;
        ResultKt.throwOnFailure(version);
        int iIntValue = ((Number) version).intValue();
        boolean z2 = currentState instanceof Data;
        int version2 = z2 ? ((Data) currentState).getVersion() : -1;
        if (z2 && iIntValue == version2) {
            return currentState;
        }
        if (z) {
            InterProcessCoordinator coordinator2 = getCoordinator();
            C18643 c18643 = new C18643(this, null);
            c18631.L$0 = null;
            c18631.label = 2;
            version = coordinator2.lock(c18643, c18631);
        } else {
            InterProcessCoordinator coordinator3 = getCoordinator();
            C18654 c18654 = new C18654(this, version2, null);
            c18631.L$0 = null;
            c18631.label = 3;
            version = coordinator3.tryLock(c18654, c18631);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u0003H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, ""}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18643 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends State<T>, ? extends Boolean>>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18643(DataStoreImpl<T> dataStoreImpl, Continuation<? super C18643> continuation) {
            super(1, continuation);
            this.this$0 = dataStoreImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18643(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Pair<? extends State<T>, Boolean>> continuation) {
            return ((C18643) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            ReadException readException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Throwable th2) {
                this.L$0 = th2;
                this.label = 2;
                Object version = this.this$0.getCoordinator().getVersion(this);
                if (version != coroutine_suspended) {
                    th = th2;
                    obj = version;
                }
                return coroutine_suspended;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.readDataOrHandleCorruption(true, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    readException = new ReadException(th, ((Number) obj).intValue());
                    return TuplesKt.m1606to(readException, Boxing.boxBoolean(true));
                }
                ResultKt.throwOnFailure(obj);
            }
            readException = (State) obj;
            return TuplesKt.m1606to(readException, Boxing.boxBoolean(true));
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, "", "locked"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", m1609f = "DataStoreImpl.kt", m1610i = {0, 1}, m1611l = {PDFACompliance.e_PDFA3_2_4, 328}, m1612m = "invokeSuspend", m1613n = {"locked", "locked"}, m1615s = {"Z$0", "Z$0"}, m1616v = 1)
    static final class C18654 extends SuspendLambda implements Function2<Boolean, Continuation<? super Pair<? extends State<T>, ? extends Boolean>>, Object> {
        final /* synthetic */ int $cachedVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18654(DataStoreImpl<T> dataStoreImpl, int i, Continuation<? super C18654> continuation) {
            super(2, continuation);
            this.this$0 = dataStoreImpl;
            this.$cachedVersion = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18654 c18654 = new C18654(this.this$0, this.$cachedVersion, continuation);
            c18654.Z$0 = ((Boolean) obj).booleanValue();
            return c18654;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Object obj) {
            return invoke(bool.booleanValue(), (Continuation) obj);
        }

        public final Object invoke(boolean z, Continuation<? super Pair<? extends State<T>, Boolean>> continuation) {
            return ((C18654) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r5v0 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            int iIntValue;
            ?? r0;
            ?? r02;
            ReadException readException;
            ?? r1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r12 = this.label;
            try {
            } catch (Throwable th2) {
                if (r12 != 0) {
                    this.L$0 = th2;
                    this.Z$0 = r12;
                    this.label = 2;
                    Object version = this.this$0.getCoordinator().getVersion(this);
                    if (version != coroutine_suspended) {
                        r02 = r12;
                        th = th2;
                        obj = version;
                    }
                    return coroutine_suspended;
                }
                ?? r5 = r12;
                th = th2;
                iIntValue = this.$cachedVersion;
                r0 = r5 == true ? 1 : 0;
            }
            if (r12 == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.Z$0;
                this.Z$0 = z;
                this.label = 1;
                obj = this.this$0.readDataOrHandleCorruption(z, this);
                r12 = z;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z2 = this.Z$0;
                    th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r02 = z2;
                    iIntValue = ((Number) obj).intValue();
                    r0 = r02;
                    readException = new ReadException(th, iIntValue);
                    r1 = r0;
                    return TuplesKt.m1606to(readException, Boxing.boxBoolean(r1));
                }
                boolean z3 = this.Z$0;
                ResultKt.throwOnFailure(obj);
                r12 = z3;
            }
            readException = (State) obj;
            r1 = r12;
            return TuplesKt.m1606to(readException, Boxing.boxBoolean(r1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation<? super T> continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core(), continuation);
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$transformAndWrite$2 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", m1609f = "DataStoreImpl.kt", m1610i = {1, 2}, m1611l = {WorkflowTransitionState.SLIDE_DURATION_MS, PDFACompliance.e_PDFA3_5_1, PDFACompliance.e_PDFA3_5_7}, m1612m = "invokeSuspend", m1613n = {"curData", "newData"}, m1615s = {"L$0", "L$0"}, m1616v = 1)
    static final class C18702 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {
        final /* synthetic */ CoroutineContext $callerContext;
        final /* synthetic */ Function2<T, Continuation<? super T>, Object> $transform;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C18702(DataStoreImpl<T> dataStoreImpl, CoroutineContext coroutineContext, Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super C18702> continuation) {
            super(1, continuation);
            this.this$0 = dataStoreImpl;
            this.$callerContext = coroutineContext;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18702(this.this$0, this.$callerContext, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super T> continuation) {
            return ((C18702) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws CorruptionException {
            Data data;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.readDataOrHandleCorruption(true, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return obj2;
                }
                data = (Data) this.L$0;
                ResultKt.throwOnFailure(obj);
                data.checkHashCode();
                if (!Intrinsics.areEqual(data.getValue(), obj)) {
                    DataStoreImpl<T> dataStoreImpl = this.this$0;
                    this.L$0 = obj;
                    this.label = 3;
                    if (dataStoreImpl.writeData$datastore_core((T) obj, true, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            data = (Data) obj;
            this.L$0 = data;
            this.label = 2;
            obj = BuildersKt.withContext(this.$callerContext, new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, data, null), this);
            if (obj != coroutine_suspended) {
                data.checkHashCode();
                if (!Intrinsics.areEqual(data.getValue(), obj)) {
                }
                return obj;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        return getCoordinator().lock(new C18702(this, coroutineContext, function2, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeData$datastore_core(T t, boolean z, Continuation<? super Integer> continuation) {
        DataStoreImpl$writeData$1 dataStoreImpl$writeData$1;
        Ref.IntRef intRef;
        if (continuation instanceof DataStoreImpl$writeData$1) {
            dataStoreImpl$writeData$1 = (DataStoreImpl$writeData$1) continuation;
            if ((dataStoreImpl$writeData$1.label & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$writeData$1.label -= Integer.MIN_VALUE;
            } else {
                dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuation);
            }
        }
        Object obj = dataStoreImpl$writeData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dataStoreImpl$writeData$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef2 = new Ref.IntRef();
            StorageConnection<T> storageConnection$datastore_core = getStorageConnection$datastore_core();
            DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(intRef2, this, t, z, null);
            dataStoreImpl$writeData$1.L$0 = intRef2;
            dataStoreImpl$writeData$1.label = 1;
            if (storageConnection$datastore_core.writeScope(dataStoreImpl$writeData$2, dataStoreImpl$writeData$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) dataStoreImpl$writeData$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[Catch: CorruptionException -> 0x007a, TryCatch #0 {CorruptionException -> 0x007a, blocks: (B:19:0x005a, B:54:0x00eb, B:22:0x0061, B:51:0x00ce, B:30:0x0076, B:40:0x0091, B:42:0x0097, B:36:0x0082, B:48:0x00be), top: B:74:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataOrHandleCorruption(boolean z, Continuation<? super Data<T>> continuation) throws CorruptionException {
        C18661 c18661;
        Ref.ObjectRef objectRef;
        CorruptionException corruptionException;
        Ref.ObjectRef objectRef2;
        CorruptionException corruptionException2;
        C18683 c18683;
        Ref.IntRef intRef;
        Ref.ObjectRef objectRef3;
        Object version;
        boolean z2;
        int i;
        Object obj;
        if (continuation instanceof C18661) {
            c18661 = (C18661) continuation;
            if ((c18661.label & Integer.MIN_VALUE) != 0) {
                c18661.label -= Integer.MIN_VALUE;
            } else {
                c18661 = new C18661(this, continuation);
            }
        }
        Object obj2 = (T) c18661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (CorruptionException e) {
            e = e;
        }
        switch (c18661.label) {
            case 0:
                ResultKt.throwOnFailure(obj2);
                if (z) {
                    c18661.Z$0 = z;
                    c18661.label = 1;
                    obj2 = (T) readDataFromFileOrDefault(c18661);
                    if (obj2 != coroutine_suspended) {
                        int iHashCode = obj2 == null ? obj2.hashCode() : 0;
                        InterProcessCoordinator coordinator = getCoordinator();
                        c18661.L$0 = obj2;
                        c18661.Z$0 = z;
                        c18661.I$0 = iHashCode;
                        c18661.label = 2;
                        version = coordinator.getVersion(c18661);
                        if (version != coroutine_suspended) {
                            int i2 = iHashCode;
                            z2 = z;
                            i = i2;
                            obj = obj2;
                            obj2 = (T) version;
                            return new Data(obj, i, ((Number) obj2).intValue());
                        }
                    }
                } else {
                    InterProcessCoordinator coordinator2 = getCoordinator();
                    c18661.Z$0 = z;
                    c18661.label = 3;
                    obj2 = (T) coordinator2.getVersion(c18661);
                    if (obj2 != coroutine_suspended) {
                        int iIntValue = ((Number) obj2).intValue();
                        InterProcessCoordinator coordinator3 = getCoordinator();
                        C18672 c18672 = new C18672(this, iIntValue, null);
                        c18661.Z$0 = z;
                        c18661.label = 4;
                        obj2 = (T) coordinator3.tryLock(c18672, c18661);
                        if (obj2 == coroutine_suspended) {
                        }
                        return (Data) obj2;
                    }
                }
                return coroutine_suspended;
            case 1:
                z = c18661.Z$0;
                ResultKt.throwOnFailure(obj2);
                if (obj2 == null) {
                }
                InterProcessCoordinator coordinator4 = getCoordinator();
                c18661.L$0 = obj2;
                c18661.Z$0 = z;
                c18661.I$0 = iHashCode;
                c18661.label = 2;
                version = coordinator4.getVersion(c18661);
                if (version != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                i = c18661.I$0;
                z2 = c18661.Z$0;
                obj = c18661.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    return new Data(obj, i, ((Number) obj2).intValue());
                } catch (CorruptionException e2) {
                    e = e2;
                    z = z2;
                    objectRef = new Ref.ObjectRef();
                    CorruptionHandler<T> corruptionHandler = this.corruptionHandler;
                    c18661.L$0 = e;
                    c18661.L$1 = objectRef;
                    c18661.L$2 = objectRef;
                    c18661.Z$0 = z;
                    c18661.label = 5;
                    Object objHandleCorruption = corruptionHandler.handleCorruption(e, c18661);
                    if (objHandleCorruption != coroutine_suspended) {
                        corruptionException = e;
                        obj2 = (T) objHandleCorruption;
                        objectRef2 = objectRef;
                        objectRef2.element = (T) obj2;
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        try {
                            c18683 = new C18683(objectRef, this, intRef2, null);
                            c18661.L$0 = corruptionException;
                            c18661.L$1 = objectRef;
                            c18661.L$2 = intRef2;
                            c18661.label = 6;
                            if (doWithWriteFileLock(z, c18683, c18661) != coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            corruptionException2 = corruptionException;
                            ExceptionsKt.addSuppressed(corruptionException2, th);
                            throw corruptionException2;
                        }
                    }
                    return coroutine_suspended;
                }
            case 3:
                z = c18661.Z$0;
                ResultKt.throwOnFailure(obj2);
                int iIntValue2 = ((Number) obj2).intValue();
                InterProcessCoordinator coordinator32 = getCoordinator();
                C18672 c186722 = new C18672(this, iIntValue2, null);
                c18661.Z$0 = z;
                c18661.label = 4;
                obj2 = (T) coordinator32.tryLock(c186722, c18661);
                if (obj2 == coroutine_suspended) {
                }
                return (Data) obj2;
            case 4:
                boolean z3 = c18661.Z$0;
                ResultKt.throwOnFailure(obj2);
                return (Data) obj2;
            case 5:
                z = c18661.Z$0;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) c18661.L$2;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) c18661.L$1;
                corruptionException = (CorruptionException) c18661.L$0;
                ResultKt.throwOnFailure(obj2);
                objectRef2 = objectRef4;
                objectRef = objectRef5;
                objectRef2.element = (T) obj2;
                Ref.IntRef intRef22 = new Ref.IntRef();
                c18683 = new C18683(objectRef, this, intRef22, null);
                c18661.L$0 = corruptionException;
                c18661.L$1 = objectRef;
                c18661.L$2 = intRef22;
                c18661.label = 6;
                if (doWithWriteFileLock(z, c18683, c18661) != coroutine_suspended) {
                    intRef = intRef22;
                    objectRef3 = objectRef;
                    T t = objectRef3.element;
                    T t2 = objectRef3.element;
                    return new Data(t, t2 != null ? t2.hashCode() : 0, intRef.element);
                }
                return coroutine_suspended;
            case 6:
                intRef = (Ref.IntRef) c18661.L$2;
                objectRef3 = (Ref.ObjectRef) c18661.L$1;
                corruptionException2 = (CorruptionException) c18661.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    T t3 = objectRef3.element;
                    T t22 = objectRef3.element;
                    return new Data(t3, t22 != null ? t22.hashCode() : 0, intRef.element);
                } catch (Throwable th2) {
                    th = th2;
                    ExceptionsKt.addSuppressed(corruptionException2, th);
                    throw corruptionException2;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Landroidx/datastore/core/Data;", ExifInterface.GPS_DIRECTION_TRUE, "locked", ""}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", m1609f = "DataStoreImpl.kt", m1610i = {0, 1}, m1611l = {390, 391}, m1612m = "invokeSuspend", m1613n = {"locked", "data"}, m1615s = {"Z$0", "L$0"}, m1616v = 1)
    static final class C18672 extends SuspendLambda implements Function2<Boolean, Continuation<? super Data<T>>, Object> {
        final /* synthetic */ int $preLockVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18672(DataStoreImpl<T> dataStoreImpl, int i, Continuation<? super C18672> continuation) {
            super(2, continuation);
            this.this$0 = dataStoreImpl;
            this.$preLockVersion = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18672 c18672 = new C18672(this.this$0, this.$preLockVersion, continuation);
            c18672.Z$0 = ((Boolean) obj).booleanValue();
            return c18672;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Object obj) {
            return invoke(bool.booleanValue(), (Continuation) obj);
        }

        public final Object invoke(boolean z, Continuation<? super Data<T>> continuation) {
            return ((C18672) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object obj2;
            int iIntValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z = this.Z$0;
                this.Z$0 = z;
                this.label = 1;
                obj = this.this$0.readDataFromFileOrDefault(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                iIntValue = ((Number) obj).intValue();
                return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, iIntValue);
            }
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
            if (z) {
                this.L$0 = obj;
                this.label = 2;
                Object version = this.this$0.getCoordinator().getVersion(this);
                if (version != coroutine_suspended) {
                    obj2 = obj;
                    obj = version;
                    iIntValue = ((Number) obj).intValue();
                    return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, iIntValue);
                }
                return coroutine_suspended;
            }
            obj2 = obj;
            iIntValue = this.$preLockVersion;
            return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, iIntValue);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {403, 404, HttpStatus.SC_NOT_ACCEPTABLE}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18683 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<T> $newData;
        final /* synthetic */ Ref.IntRef $version;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18683(Ref.ObjectRef<T> objectRef, DataStoreImpl<T> dataStoreImpl, Ref.IntRef intRef, Continuation<? super C18683> continuation) {
            super(1, continuation);
            this.$newData = objectRef;
            this.this$0 = dataStoreImpl;
            this.$version = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18683(this.$newData, this.this$0, this.$version, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C18683) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.IntRef intRef;
            Ref.ObjectRef<T> objectRef;
            Ref.IntRef intRef2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (CorruptionException unused) {
                Ref.IntRef intRef3 = this.$version;
                this.L$0 = intRef3;
                this.label = 3;
                Object objWriteData$datastore_core = this.this$0.writeData$datastore_core(this.$newData.element, true, this);
                if (objWriteData$datastore_core != coroutine_suspended) {
                    intRef = intRef3;
                    obj = (T) objWriteData$datastore_core;
                }
                return coroutine_suspended;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = this.$newData;
                this.L$0 = objectRef;
                this.label = 1;
                obj = (T) this.this$0.readDataFromFileOrDefault(this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    intRef2 = (Ref.IntRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    intRef2.element = ((Number) obj).intValue();
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                intRef = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                intRef.element = ((Number) obj).intValue();
                return Unit.INSTANCE;
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef.element = (T) obj;
            intRef2 = this.$version;
            this.L$0 = intRef2;
            this.label = 2;
            obj = (T) this.this$0.getCoordinator().getVersion(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef2.element = ((Number) obj).intValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        if (z) {
            return function1.invoke(continuation);
        }
        return getCoordinator().lock(new C18582(function1, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$2 */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, m1599d2 = {"<anonymous>", "R"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$2", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {434}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18582<R> extends SuspendLambda implements Function1<Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C18582(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C18582> continuation) {
            super(1, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18582(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super R> continuation) {
            return ((C18582) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super R>, Object> function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001BF\u0012=\u0010\u0002\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u0003¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000f\u001a\u00020\nH\u0094@¢\u0006\u0002\u0010\u0010RG\u0010\u000e\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Landroidx/datastore/core/RunOnce;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Landroidx/datastore/core/DataStoreImpl;Ljava/util/List;)V", "initTasks", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    final class InitDataStore extends RunOnce {
        private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList) {
            Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.toList(initTasksList);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        
            if (r7 == r1) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        
            if (r7 == r1) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Object doRun(Continuation<? super Unit> continuation) throws CorruptionException {
            DataStoreImpl$InitDataStore$doRun$1 dataStoreImpl$InitDataStore$doRun$1;
            Data data;
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$1) {
                dataStoreImpl$InitDataStore$doRun$1 = (DataStoreImpl$InitDataStore$doRun$1) continuation;
                if ((dataStoreImpl$InitDataStore$doRun$1.label & Integer.MIN_VALUE) != 0) {
                    dataStoreImpl$InitDataStore$doRun$1.label -= Integer.MIN_VALUE;
                } else {
                    dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuation);
                }
            }
            Object dataOrHandleCorruption = dataStoreImpl$InitDataStore$doRun$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = dataStoreImpl$InitDataStore$doRun$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list = this.initTasks;
                if (list != null) {
                    Intrinsics.checkNotNull(list);
                    if (!list.isEmpty()) {
                        InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                        DataStoreImpl$InitDataStore$doRun$initData$1 dataStoreImpl$InitDataStore$doRun$initData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this, null);
                        dataStoreImpl$InitDataStore$doRun$1.label = 2;
                        dataOrHandleCorruption = coordinator.lock(dataStoreImpl$InitDataStore$doRun$initData$1, dataStoreImpl$InitDataStore$doRun$1);
                    } else {
                        DataStoreImpl<T> dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$1.label = 1;
                        dataOrHandleCorruption = dataStoreImpl.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                    }
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            }
            ((DataStoreImpl) this.this$0).inMemoryCache.tryUpdate(data);
            return Unit.INSTANCE;
        }
    }
}
