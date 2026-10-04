package com.myscript.nebo.dms.core;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSSyncState;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: AutoSyncTimerManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001!\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010-\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010.\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010/\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00100\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00101\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00102\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00103\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00104\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u000e\u00105\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\b\u00106\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u0016\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u000e\u0010B\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u0018\u0010C\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010EJ\u000e\u0010G\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u001e\u0010H\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0082@¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u000e\u0010K\u001a\u00020*H\u0082@¢\u0006\u0002\u0010+J\u0010\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020NH\u0002J\b\u0010P\u001a\u00020NH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010#\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006R"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/AutoSyncTimerManager;", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "syncHelper", "Lcom/myscript/nebo/dms/core/SyncHelper;", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/myscript/nebo/account/backend/Backend;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "gridViewIntervalSeconds", "", "pageEditingIntervalSeconds", "multiEditorPageEditingIntervalSeconds", "<init>", "(Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/SyncHelper;Lcom/myscript/nebo/account/backend/Backend;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;JJJ)V", "syncJob", "Lkotlinx/coroutines/Job;", "syncJobMutex", "Lkotlinx/coroutines/sync/Mutex;", "isEnabled", "", "isPageEditingMode", "isPaused", "isSyncing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "networkStateObserver", "Landroidx/lifecycle/Observer;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "syncListener", "com/myscript/nebo/dms/core/AutoSyncTimerManager$syncListener$1", "Lcom/myscript/nebo/dms/core/AutoSyncTimerManager$syncListener$1;", "hasMultiEditor", "getHasMultiEditor", "()Z", "effectiveInterval", "getEffectiveInterval", "()J", TtmlNode.START, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "pause", "resume", "enterPageEditingMode", "exitPageEditingMode", "onAppGoingToBackground", "onAppResumedFromBackground", "triggerSyncNow", "triggerRefreshNow", "triggerResumeSync", "cancelSync", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "onSyncStateChanged", "syncState", "Lcom/myscript/snt/dms/DMSSyncState;", "failureReason", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;", "scheduleNextSync", "intervalSeconds", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rescheduleSync", "cancelScheduledSync", "performSync", "forceSync", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSkipSync", "executeSyncOperation", "handleSyncCompleted", "(Lcom/myscript/snt/dms/DMSSyncState;Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSyncFailed", "rescheduleIfEnabled", "logDebug", "message", "", "buildStartMessage", "buildIntervalMessage", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AutoSyncTimerManager implements IAutoSyncTimerManager {
    private static final boolean DBG = false;
    private static final long GRID_VIEW_INTERVAL_SECONDS = 20;
    private static final String KEY_SYNC_GRID_VIEW_INTERVAL_SECONDS = "SYNC_GRID_VIEW_INTERVAL_SECONDS";
    private static final String KEY_SYNC_MULTI_EDITOR_PAGE_EDITING_INTERVAL_SECONDS = "SYNC_MULTI_EDITOR_PAGE_EDITING_INTERVAL_SECONDS";
    private static final String KEY_SYNC_PAGE_EDITING_INTERVAL_SECONDS = "SYNC_PAGE_EDITING_INTERVAL_SECONDS";
    private static final long MILLISECONDS_PER_SECOND = 1000;
    private static final long MULTI_EDITOR_PAGE_EDITING_INTERVAL_SECONDS = 20;
    private static final long ONE_MONTH_MICROSECONDS = 2592000000000L;
    private static final long PAGE_EDITING_INTERVAL_SECONDS = 120;
    private static final String TAG = "AutoSyncTimerManager";
    private final Backend backend;
    private long gridViewIntervalSeconds;
    private final CoroutineDispatcher ioDispatcher;
    private volatile boolean isEnabled;
    private volatile boolean isPageEditingMode;
    private volatile boolean isPaused;
    private final AtomicBoolean isSyncing;
    private final LibraryRepository libraryRepository;
    private final CoroutineDispatcher mainDispatcher;
    private long multiEditorPageEditingIntervalSeconds;
    private final Observer<NeboNetworkState> networkStateObserver;
    private final NeboNetworkStateRepository networkStateRepository;
    private long pageEditingIntervalSeconds;
    private final SyncHelper syncHelper;
    private volatile Job syncJob;
    private final Mutex syncJobMutex;
    private final AutoSyncTimerManager$syncListener$1 syncListener;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMSSyncState.values().length];
            try {
                iArr[DMSSyncState.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DMSSyncState.SYNCING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$cancelScheduledSync$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {0, 0}, m1611l = {645}, m1612m = "cancelScheduledSync", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {646}, m1615s = {"L$0", "I$0"}, m1616v = 2)
    static final class C62101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62101(Continuation<? super C62101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.cancelScheduledSync(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$enterPageEditingMode$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {263}, m1612m = "enterPageEditingMode", m1613n = {}, m1614nl = {264}, m1615s = {}, m1616v = 2)
    static final class C62111 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62111(Continuation<? super C62111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.enterPageEditingMode(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$executeSyncOperation$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {1}, m1611l = {567, 582}, m1612m = "executeSyncOperation", m1613n = {"e"}, m1614nl = {576, 586}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62121(Continuation<? super C62121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.executeSyncOperation(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$exitPageEditingMode$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {282, 283}, m1612m = "exitPageEditingMode", m1613n = {}, m1614nl = {283, 285}, m1615s = {}, m1616v = 2)
    static final class C62141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62141(Continuation<? super C62141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.exitPageEditingMode(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$onAppGoingToBackground$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {297, 301, 303}, m1612m = "onAppGoingToBackground", m1613n = {}, m1614nl = {AIContainerViewModel.SUMMARIZE_MIN_LIMIT, 302, 306}, m1615s = {}, m1616v = 2)
    static final class C62151 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62151(Continuation<? super C62151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.onAppGoingToBackground(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$pause$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_3_2}, m1612m = "pause", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA2_3_3}, m1615s = {}, m1616v = 2)
    static final class C62181 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62181(Continuation<? super C62181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.pause(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$performSync$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {0, 1, 2}, m1611l = {PDFACompliance.e_PDFA5_2_7, PDFACompliance.e_PDFA5_2_9, 539}, m1612m = "performSync", m1613n = {"forceSync", "forceSync", "forceSync"}, m1614nl = {PDFACompliance.e_PDFA5_2_8, 530, 540}, m1615s = {"Z$0", "Z$0", "Z$0"}, m1616v = 2)
    static final class C62191 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C62191(Continuation<? super C62191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.performSync(false, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$scheduleNextSync$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {0, 0, 0}, m1611l = {645}, m1612m = "scheduleNextSync", m1613n = {"$this$withLock_u24default$iv", "intervalSeconds", "$i$f$withLock"}, m1614nl = {646}, m1615s = {"L$0", "J$0", "I$0"}, m1616v = 2)
    static final class C62201 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62201(Continuation<? super C62201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.scheduleNextSync(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$shouldSkipSync$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {0}, m1611l = {550}, m1612m = "shouldSkipSync", m1613n = {"forceSync"}, m1614nl = {558}, m1615s = {"Z$0"}, m1616v = 2)
    static final class C62211 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C62211(Continuation<? super C62211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.shouldSkipSync(false, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$start$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {175, PDFACompliance.e_PDFA1_8_2, 194}, m1612m = TtmlNode.START, m1613n = {}, m1614nl = {179, 194, 195}, m1615s = {}, m1616v = 2)
    static final class C62231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62231(Continuation<? super C62231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.start(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$stop$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {211, 214}, m1612m = "stop", m1613n = {}, m1614nl = {214, 219}, m1615s = {}, m1616v = 2)
    static final class C62261 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C62261(Continuation<? super C62261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.stop(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerRefreshNow$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {2}, m1611l = {378, 387, 397}, m1612m = "triggerRefreshNow", m1613n = {"e"}, m1614nl = {PDFACompliance.e_PDFA3_8_1, 391, 399}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62281(Continuation<? super C62281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.triggerRefreshNow(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerResumeSync$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {2}, m1611l = {412, 421, 431}, m1612m = "triggerResumeSync", m1613n = {"e"}, m1614nl = {HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, TypedValues.CycleType.TYPE_WAVE_PHASE, 433}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62301 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62301(Continuation<? super C62301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.triggerResumeSync(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerSyncNow$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager", m1609f = "AutoSyncTimerManager.kt", m1610i = {2}, m1611l = {347, PDFACompliance.e_PDFA3_5_6, 366}, m1612m = "triggerSyncNow", m1613n = {"e"}, m1614nl = {WorkflowTransitionState.SLIDE_DURATION_MS, 360, 368}, m1615s = {"L$0"}, m1616v = 2)
    static final class C62321 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C62321(Continuation<? super C62321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoSyncTimerManager.this.triggerSyncNow(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDebug(String message) {
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.myscript.nebo.dms.core.AutoSyncTimerManager$syncListener$1] */
    public AutoSyncTimerManager(LibraryRepository libraryRepository, SyncHelper syncHelper, Backend backend, NeboNetworkStateRepository networkStateRepository, CoroutineDispatcher mainDispatcher, CoroutineDispatcher ioDispatcher, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(syncHelper, "syncHelper");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.syncHelper = syncHelper;
        this.backend = backend;
        this.networkStateRepository = networkStateRepository;
        this.mainDispatcher = mainDispatcher;
        this.ioDispatcher = ioDispatcher;
        this.gridViewIntervalSeconds = j;
        this.pageEditingIntervalSeconds = j2;
        this.multiEditorPageEditingIntervalSeconds = j3;
        this.syncJobMutex = MutexKt.Mutex$default(false, 1, null);
        this.isSyncing = new AtomicBoolean(false);
        this.networkStateObserver = new Observer() { // from class: com.myscript.nebo.dms.core.AutoSyncTimerManager$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AutoSyncTimerManager.networkStateObserver$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        };
        this.syncListener = new LibraryRepository.SyncListener() { // from class: com.myscript.nebo.dms.core.AutoSyncTimerManager$syncListener$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void autoSyncSettingChanged() {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void conflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2s) {
                Intrinsics.checkNotNullParameter(duplicatedPageKeys, "duplicatedPageKeys");
                Intrinsics.checkNotNullParameter(duplicatedPageKeys2s, "duplicatedPageKeys2s");
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void refreshProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncPrepareProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(NotebookKey folderSyncing, int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncStateChanged(DMSSyncState state, int impactedFolderCount, LibraryRepository.SyncFailureReason failureReason) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(failureReason, "failureReason");
                this.this$0.onSyncStateChanged(state, failureReason);
            }
        };
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ AutoSyncTimerManager(com.myscript.nebo.dms.core.LibraryRepository r16, com.myscript.nebo.dms.core.SyncHelper r17, com.myscript.nebo.account.backend.Backend r18, com.myscript.nebo.common.network.NeboNetworkStateRepository r19, kotlinx.coroutines.CoroutineDispatcher r20, kotlinx.coroutines.CoroutineDispatcher r21, long r22, long r24, long r26, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 16
            if (r1 == 0) goto Le
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.CoroutineDispatcher r1 = (kotlinx.coroutines.CoroutineDispatcher) r1
            r7 = r1
            goto L10
        Le:
            r7 = r20
        L10:
            r1 = r0 & 32
            if (r1 == 0) goto L1a
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r8 = r1
            goto L1c
        L1a:
            r8 = r21
        L1c:
            r1 = r0 & 64
            r2 = 20
            if (r1 == 0) goto L24
            r9 = r2
            goto L26
        L24:
            r9 = r22
        L26:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L2e
            r4 = 120(0x78, double:5.93E-322)
            r11 = r4
            goto L30
        L2e:
            r11 = r24
        L30:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L3f
            r13 = r2
            r4 = r17
            r5 = r18
            r6 = r19
            r2 = r15
            r3 = r16
            goto L4a
        L3f:
            r13 = r26
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
        L4a:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.dms.core.AutoSyncTimerManager.<init>(com.myscript.nebo.dms.core.LibraryRepository, com.myscript.nebo.dms.core.SyncHelper, com.myscript.nebo.account.backend.Backend, com.myscript.nebo.common.network.NeboNetworkStateRepository, kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void networkStateObserver$lambda$0(AutoSyncTimerManager autoSyncTimerManager, NeboNetworkState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        autoSyncTimerManager.logDebug("Network state changed: " + state);
        if (state.isDataTransferAllowed()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), autoSyncTimerManager.ioDispatcher, null, new AutoSyncTimerManager$networkStateObserver$1$1(autoSyncTimerManager, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasMultiEditor() {
        return this.syncHelper.hasMultiEditor(ONE_MONTH_MICROSECONDS);
    }

    private final long getEffectiveInterval() {
        return (getHasMultiEditor() && this.isPageEditingMode) ? this.multiEditorPageEditingIntervalSeconds : this.isPageEditingMode ? this.pageEditingIntervalSeconds : this.gridViewIntervalSeconds;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
    
        if (performSync(true, r0) != r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object start(Continuation<? super Unit> continuation) {
        C62231 c62231;
        if (continuation instanceof C62231) {
            c62231 = (C62231) continuation;
            if ((c62231.label & Integer.MIN_VALUE) != 0) {
                c62231.label -= Integer.MIN_VALUE;
            } else {
                c62231 = new C62231(continuation);
            }
        }
        Object obj = c62231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isEnabled) {
                logDebug("Already started");
                return Unit.INSTANCE;
            }
            this.libraryRepository.addSyncListener(this.syncListener);
            CoroutineDispatcher coroutineDispatcher = this.mainDispatcher;
            C62242 c62242 = new C62242(null);
            c62231.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, c62242, c62231) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            c62231.label = 3;
        }
        this.isEnabled = true;
        this.isSyncing.set(false);
        CoroutineDispatcher coroutineDispatcher2 = this.ioDispatcher;
        C62253 c62253 = new C62253(null);
        c62231.label = 2;
        if (BuildersKt.withContext(coroutineDispatcher2, c62253, c62231) != coroutine_suspended) {
            c62231.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$start$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$start$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62242(Continuation<? super C62242> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62242(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoSyncTimerManager.this.networkStateRepository.getNeboNetworkState().observeForever(AutoSyncTimerManager.this.networkStateObserver);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$start$3 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$start$3", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_4, PDFACompliance.e_PDFA1_8_6, TsExtractor.TS_PACKET_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {185, PDFACompliance.e_PDFA1_8_7, PsExtractor.PRIVATE_STREAM_1}, m1615s = {}, m1616v = 2)
    static final class C62253 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C62253(Continuation<? super C62253> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62253(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62253) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0104  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AutoSyncTimerManager autoSyncTimerManager;
            Object objM12807setValueyxL6bBk$default;
            AutoSyncTimerManager autoSyncTimerManager2;
            Object objM12807setValueyxL6bBk$default2;
            Long longOrNull;
            Object objM12807setValueyxL6bBk$default3;
            AutoSyncTimerManager autoSyncTimerManager3;
            Object value;
            Long longOrNull2;
            String str;
            Long longOrNull3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            long jLongValue = 20;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                autoSyncTimerManager = AutoSyncTimerManager.this;
                this.L$0 = autoSyncTimerManager;
                this.label = 1;
                objM12807setValueyxL6bBk$default = Backend.m12807setValueyxL6bBk$default(autoSyncTimerManager.backend, AutoSyncTimerManager.KEY_SYNC_GRID_VIEW_INTERVAL_SECONDS, String.valueOf(AutoSyncTimerManager.this.gridViewIntervalSeconds), true, false, this, 8, null);
                if (objM12807setValueyxL6bBk$default != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    autoSyncTimerManager3 = (AutoSyncTimerManager) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value = ((Result) obj).getValue();
                    str = (String) (Result.m14505isFailureimpl(value) ? null : value);
                    if (str != null && (longOrNull3 = StringsKt.toLongOrNull(str)) != null) {
                        jLongValue = longOrNull3.longValue();
                    }
                    autoSyncTimerManager3.multiEditorPageEditingIntervalSeconds = jLongValue;
                    AutoSyncTimerManager autoSyncTimerManager4 = AutoSyncTimerManager.this;
                    autoSyncTimerManager4.logDebug(autoSyncTimerManager4.buildStartMessage());
                    return Unit.INSTANCE;
                }
                autoSyncTimerManager2 = (AutoSyncTimerManager) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM12807setValueyxL6bBk$default2 = ((Result) obj).getValue();
                if (Result.m14505isFailureimpl(objM12807setValueyxL6bBk$default2)) {
                    objM12807setValueyxL6bBk$default2 = null;
                }
                String str2 = (String) objM12807setValueyxL6bBk$default2;
                autoSyncTimerManager2.pageEditingIntervalSeconds = (str2 != null || (longOrNull2 = StringsKt.toLongOrNull(str2)) == null) ? AutoSyncTimerManager.PAGE_EDITING_INTERVAL_SECONDS : longOrNull2.longValue();
                AutoSyncTimerManager autoSyncTimerManager5 = AutoSyncTimerManager.this;
                this.L$0 = autoSyncTimerManager5;
                this.label = 3;
                objM12807setValueyxL6bBk$default3 = Backend.m12807setValueyxL6bBk$default(autoSyncTimerManager5.backend, AutoSyncTimerManager.KEY_SYNC_MULTI_EDITOR_PAGE_EDITING_INTERVAL_SECONDS, String.valueOf(AutoSyncTimerManager.this.multiEditorPageEditingIntervalSeconds), true, false, this, 8, null);
                if (objM12807setValueyxL6bBk$default3 != coroutine_suspended) {
                    autoSyncTimerManager3 = autoSyncTimerManager5;
                    value = objM12807setValueyxL6bBk$default3;
                    str = (String) (Result.m14505isFailureimpl(value) ? null : value);
                    if (str != null) {
                        jLongValue = longOrNull3.longValue();
                    }
                    autoSyncTimerManager3.multiEditorPageEditingIntervalSeconds = jLongValue;
                    AutoSyncTimerManager autoSyncTimerManager42 = AutoSyncTimerManager.this;
                    autoSyncTimerManager42.logDebug(autoSyncTimerManager42.buildStartMessage());
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            autoSyncTimerManager = (AutoSyncTimerManager) this.L$0;
            ResultKt.throwOnFailure(obj);
            objM12807setValueyxL6bBk$default = ((Result) obj).getValue();
            if (Result.m14505isFailureimpl(objM12807setValueyxL6bBk$default)) {
                objM12807setValueyxL6bBk$default = null;
            }
            String str3 = (String) objM12807setValueyxL6bBk$default;
            autoSyncTimerManager.gridViewIntervalSeconds = (str3 == null || (longOrNull = StringsKt.toLongOrNull(str3)) == null) ? 20L : longOrNull.longValue();
            autoSyncTimerManager2 = AutoSyncTimerManager.this;
            this.L$0 = autoSyncTimerManager2;
            this.label = 2;
            objM12807setValueyxL6bBk$default2 = Backend.m12807setValueyxL6bBk$default(autoSyncTimerManager2.backend, AutoSyncTimerManager.KEY_SYNC_PAGE_EDITING_INTERVAL_SECONDS, String.valueOf(AutoSyncTimerManager.this.pageEditingIntervalSeconds), true, false, this, 8, null);
            if (objM12807setValueyxL6bBk$default2 != coroutine_suspended) {
                if (Result.m14505isFailureimpl(objM12807setValueyxL6bBk$default2)) {
                }
                String str22 = (String) objM12807setValueyxL6bBk$default2;
                autoSyncTimerManager2.pageEditingIntervalSeconds = (str22 != null || (longOrNull2 = StringsKt.toLongOrNull(str22)) == null) ? AutoSyncTimerManager.PAGE_EDITING_INTERVAL_SECONDS : longOrNull2.longValue();
                AutoSyncTimerManager autoSyncTimerManager52 = AutoSyncTimerManager.this;
                this.L$0 = autoSyncTimerManager52;
                this.label = 3;
                objM12807setValueyxL6bBk$default3 = Backend.m12807setValueyxL6bBk$default(autoSyncTimerManager52.backend, AutoSyncTimerManager.KEY_SYNC_MULTI_EDITOR_PAGE_EDITING_INTERVAL_SECONDS, String.valueOf(AutoSyncTimerManager.this.multiEditorPageEditingIntervalSeconds), true, false, this, 8, null);
                if (objM12807setValueyxL6bBk$default3 != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object stop(Continuation<? super Unit> continuation) {
        C62261 c62261;
        if (continuation instanceof C62261) {
            c62261 = (C62261) continuation;
            if ((c62261.label & Integer.MIN_VALUE) != 0) {
                c62261.label -= Integer.MIN_VALUE;
            } else {
                c62261 = new C62261(continuation);
            }
        }
        Object obj = c62261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62261.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isEnabled) {
                return Unit.INSTANCE;
            }
            this.isEnabled = false;
            this.isPaused = false;
            this.isSyncing.set(false);
            c62261.label = 1;
            if (cancelScheduledSync(c62261) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            logDebug("Stopped");
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher coroutineDispatcher = this.mainDispatcher;
        C62272 c62272 = new C62272(null);
        c62261.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$stop$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$stop$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62272(Continuation<? super C62272> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62272(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoSyncTimerManager.this.libraryRepository.removeSyncListener(AutoSyncTimerManager.this.syncListener);
                AutoSyncTimerManager.this.networkStateRepository.getNeboNetworkState().removeObserver(AutoSyncTimerManager.this.networkStateObserver);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object pause(Continuation<? super Unit> continuation) {
        C62181 c62181;
        if (continuation instanceof C62181) {
            c62181 = (C62181) continuation;
            if ((c62181.label & Integer.MIN_VALUE) != 0) {
                c62181.label -= Integer.MIN_VALUE;
            } else {
                c62181 = new C62181(continuation);
            }
        }
        Object obj = c62181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62181.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isEnabled || this.isPaused) {
                return Unit.INSTANCE;
            }
            this.isPaused = true;
            c62181.label = 1;
            if (cancelScheduledSync(c62181) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        logDebug("Sync paused (e.g., backup operation in progress)");
        return Unit.INSTANCE;
    }

    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    public Object resume(Continuation<? super Unit> continuation) {
        if (!this.isEnabled || !this.isPaused) {
            return Unit.INSTANCE;
        }
        this.isPaused = false;
        logDebug("Sync resumed, triggering immediate sync");
        Object objPerformSync = performSync(true, continuation);
        return objPerformSync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSync : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object enterPageEditingMode(Continuation<? super Unit> continuation) {
        C62111 c62111;
        if (continuation instanceof C62111) {
            c62111 = (C62111) continuation;
            if ((c62111.label & Integer.MIN_VALUE) != 0) {
                c62111.label -= Integer.MIN_VALUE;
            } else {
                c62111 = new C62111(continuation);
            }
        }
        Object obj = c62111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isPageEditingMode) {
                return Unit.INSTANCE;
            }
            this.isPageEditingMode = true;
            if (this.isEnabled) {
                c62111.label = 1;
                if (rescheduleSync(c62111) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        logDebug("Entered page editing mode with " + buildIntervalMessage());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (performSync(true, r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object exitPageEditingMode(Continuation<? super Unit> continuation) {
        C62141 c62141;
        if (continuation instanceof C62141) {
            c62141 = (C62141) continuation;
            if ((c62141.label & Integer.MIN_VALUE) != 0) {
                c62141.label -= Integer.MIN_VALUE;
            } else {
                c62141 = new C62141(continuation);
            }
        }
        Object obj = c62141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isPageEditingMode) {
                return Unit.INSTANCE;
            }
            this.isPageEditingMode = false;
            if (!this.isEnabled) {
                return Unit.INSTANCE;
            }
            logDebug("Exited page editing mode, triggering immediate sync");
            c62141.label = 1;
            if (cancelScheduledSync(c62141) != coroutine_suspended) {
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
        c62141.label = 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (executeSyncOperation(r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object onAppGoingToBackground(Continuation<? super Unit> continuation) {
        C62151 c62151;
        if (continuation instanceof C62151) {
            c62151 = (C62151) continuation;
            if ((c62151.label & Integer.MIN_VALUE) != 0) {
                c62151.label -= Integer.MIN_VALUE;
            } else {
                c62151 = new C62151(continuation);
            }
        }
        Object objShouldSkipSync = c62151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objShouldSkipSync);
            if (!this.isEnabled) {
                return Unit.INSTANCE;
            }
            logDebug("App going to background, triggering immediate sync and pausing");
            c62151.label = 1;
            if (cancelScheduledSync(c62151) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objShouldSkipSync);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objShouldSkipSync);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objShouldSkipSync);
            if (!((Boolean) objShouldSkipSync).booleanValue() || !this.isSyncing.compareAndSet(false, true)) {
                return Unit.INSTANCE;
            }
            c62151.label = 3;
        }
        this.isPaused = true;
        c62151.label = 2;
        objShouldSkipSync = shouldSkipSync(true, c62151);
        if (objShouldSkipSync != coroutine_suspended) {
            if (!((Boolean) objShouldSkipSync).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$onAppResumedFromBackground$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$onAppResumedFromBackground$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_2_2, 328}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {328, 329}, m1615s = {}, m1616v = 2)
    static final class C62162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62162(Continuation<? super C62162> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62162(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        
            if (r4.this$0.performSync(true, r4) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (AutoSyncTimerManager.this.isEnabled) {
                    AutoSyncTimerManager.this.logDebug("App resumed from background, resuming and triggering immediate sync");
                    AutoSyncTimerManager.this.isPaused = false;
                    this.label = 1;
                    if (AutoSyncTimerManager.this.cancelScheduledSync(this) != coroutine_suspended) {
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
            ResultKt.throwOnFailure(obj);
            this.label = 2;
        }
    }

    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    public Object onAppResumedFromBackground(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C62162(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0) == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b3, code lost:
    
        if (handleSyncFailed(r0) != r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object triggerSyncNow(Continuation<? super Unit> continuation) {
        C62321 c62321;
        if (continuation instanceof C62321) {
            c62321 = (C62321) continuation;
            if ((c62321.label & Integer.MIN_VALUE) != 0) {
                c62321.label -= Integer.MIN_VALUE;
            } else {
                c62321 = new C62321(continuation);
            }
        }
        Object obj = c62321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62321.label;
        try {
        } catch (CancellationException e) {
            logDebug("Sync cancelled: " + e);
            this.isSyncing.set(false);
        } catch (Exception e2) {
            Log.e(TAG, "Error during sync", e2);
            c62321.L$0 = SpillingKt.nullOutSpilledVariable(e2);
            c62321.label = 3;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isEnabled) {
                logDebug("Cannot trigger sync - timer not enabled");
                return Unit.INSTANCE;
            }
            if (this.isSyncing.get()) {
                logDebug("Sync already in progress, skipping manual sync");
                return Unit.INSTANCE;
            }
            logDebug("Manual sync triggered");
            c62321.label = 1;
            if (cancelScheduledSync(c62321) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (!this.isSyncing.compareAndSet(false, true)) {
            logDebug("Sync already in progress, skipping sync");
            return Unit.INSTANCE;
        }
        CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
        C62332 c62332 = new C62332(null);
        c62321.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerSyncNow$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerSyncNow$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62332(Continuation<? super C62332> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62332(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoSyncTimerManager.this.syncHelper.triggerSync(true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        if (handleSyncFailed(r0) != r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object triggerRefreshNow(Continuation<? super Unit> continuation) {
        C62281 c62281;
        if (continuation instanceof C62281) {
            c62281 = (C62281) continuation;
            if ((c62281.label & Integer.MIN_VALUE) != 0) {
                c62281.label -= Integer.MIN_VALUE;
            } else {
                c62281 = new C62281(continuation);
            }
        }
        Object obj = c62281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62281.label;
        try {
        } catch (CancellationException e) {
            logDebug("Refresh cancelled: " + e);
            this.isSyncing.set(false);
        } catch (Exception e2) {
            Log.e(TAG, "Error during refresh", e2);
            c62281.L$0 = SpillingKt.nullOutSpilledVariable(e2);
            c62281.label = 3;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            logDebug("Force refresh triggered");
            c62281.label = 1;
            if (cancelScheduledSync(c62281) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (!this.isSyncing.compareAndSet(false, true)) {
            logDebug("Sync already in progress, skipping refresh");
            return Unit.INSTANCE;
        }
        CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
        C62292 c62292 = new C62292(null);
        c62281.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerRefreshNow$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerRefreshNow$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62292(Continuation<? super C62292> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62292(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoSyncTimerManager.this.syncHelper.triggerRefresh();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r9, r2, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
    
        if (handleSyncFailed(r0) != r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object triggerResumeSync(Continuation<? super Unit> continuation) {
        C62301 c62301;
        if (continuation instanceof C62301) {
            c62301 = (C62301) continuation;
            if ((c62301.label & Integer.MIN_VALUE) != 0) {
                c62301.label -= Integer.MIN_VALUE;
            } else {
                c62301 = new C62301(continuation);
            }
        }
        Object obj = c62301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62301.label;
        try {
        } catch (CancellationException e) {
            logDebug("Resume sync cancelled: " + e);
            this.isSyncing.set(false);
        } catch (Exception e2) {
            Log.e(TAG, "Error during resume sync", e2);
            c62301.L$0 = SpillingKt.nullOutSpilledVariable(e2);
            c62301.label = 3;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.isSyncing.get()) {
                logDebug("Sync already in progress, skipping resume");
                return Unit.INSTANCE;
            }
            logDebug("Resume sync triggered");
            c62301.label = 1;
            if (cancelScheduledSync(c62301) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (!this.isSyncing.compareAndSet(false, true)) {
            logDebug("Sync already in progress, skipping resume");
            return Unit.INSTANCE;
        }
        CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
        C62312 c62312 = new C62312(null);
        c62301.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerResumeSync$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$triggerResumeSync$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62312(Continuation<? super C62312> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62312(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62312) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoSyncTimerManager.this.syncHelper.resumeSync();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    public void cancelSync() {
        if (!this.isEnabled) {
            logDebug("Cannot cancel sync - timer not enabled");
        } else {
            if (!this.isSyncing.get()) {
                logDebug("No sync in progress to cancel");
                return;
            }
            logDebug("Canceling all syncs");
            this.syncHelper.cancelSync();
            this.isSyncing.set(false);
        }
    }

    @Override // com.myscript.nebo.dms.core.IAutoSyncTimerManager
    public void cancelSync(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        if (!this.isEnabled) {
            logDebug("Cannot cancel sync - timer not enabled");
        } else {
            logDebug("Canceling sync for notebook: " + notebookKey);
            this.syncHelper.cancelSync(notebookKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSyncStateChanged(DMSSyncState syncState, LibraryRepository.SyncFailureReason failureReason) {
        logDebug("Received sync state: " + syncState);
        int i = WhenMappings.$EnumSwitchMapping$0[syncState.ordinal()];
        if (i != 1 && i != 2) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), this.mainDispatcher, null, new C62171(syncState, failureReason, null), 2, null);
        } else {
            logDebug("Sync in progress");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$onSyncStateChanged$1 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$onSyncStateChanged$1", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {482}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {483}, m1615s = {}, m1616v = 2)
    static final class C62171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LibraryRepository.SyncFailureReason $failureReason;
        final /* synthetic */ DMSSyncState $syncState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62171(DMSSyncState dMSSyncState, LibraryRepository.SyncFailureReason syncFailureReason, Continuation<? super C62171> continuation) {
            super(2, continuation);
            this.$syncState = dMSSyncState;
            this.$failureReason = syncFailureReason;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62171(this.$syncState, this.$failureReason, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AutoSyncTimerManager.this.handleSyncCompleted(this.$syncState, this.$failureReason, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scheduleNextSync(long j, Continuation<? super Unit> continuation) {
        C62201 c62201;
        Mutex mutex;
        if (continuation instanceof C62201) {
            c62201 = (C62201) continuation;
            if ((c62201.label & Integer.MIN_VALUE) != 0) {
                c62201.label -= Integer.MIN_VALUE;
            } else {
                c62201 = new C62201(continuation);
            }
        }
        Object obj = c62201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isEnabled) {
                logDebug("Cannot scheduleNextSync - timer not enabled");
                return Unit.INSTANCE;
            }
            mutex = this.syncJobMutex;
            c62201.L$0 = mutex;
            c62201.J$0 = j;
            c62201.I$0 = 0;
            c62201.label = 1;
            if (mutex.lock(null, c62201) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c62201.I$0;
            j = c62201.J$0;
            Mutex mutex2 = (Mutex) c62201.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
        }
        try {
            Job job = this.syncJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.syncJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), this.ioDispatcher, null, new AutoSyncTimerManager$scheduleNextSync$2$1(j, this, null), 2, null);
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            logDebug("Next sync scheduled in " + j + " seconds");
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object rescheduleSync(Continuation<? super Unit> continuation) {
        Object objScheduleNextSync = scheduleNextSync(getEffectiveInterval(), continuation);
        return objScheduleNextSync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScheduleNextSync : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelScheduledSync(Continuation<? super Unit> continuation) {
        C62101 c62101;
        Mutex mutex;
        if (continuation instanceof C62101) {
            c62101 = (C62101) continuation;
            if ((c62101.label & Integer.MIN_VALUE) != 0) {
                c62101.label -= Integer.MIN_VALUE;
            } else {
                c62101 = new C62101(continuation);
            }
        }
        Object obj = c62101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.syncJobMutex;
            c62101.L$0 = mutex2;
            c62101.I$0 = 0;
            c62101.label = 1;
            if (mutex2.lock(null, c62101) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c62101.I$0;
            mutex = (Mutex) c62101.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            Job job = this.syncJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.syncJob = null;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (scheduleNextSync(r2, r0) == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        if (executeSyncOperation(r0) == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performSync(boolean z, Continuation<? super Unit> continuation) {
        C62191 c62191;
        if (continuation instanceof C62191) {
            c62191 = (C62191) continuation;
            if ((c62191.label & Integer.MIN_VALUE) != 0) {
                c62191.label -= Integer.MIN_VALUE;
            } else {
                c62191 = new C62191(continuation);
            }
        }
        Object objShouldSkipSync = c62191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objShouldSkipSync);
            if (!this.isEnabled || this.isPaused) {
                return Unit.INSTANCE;
            }
            if (this.isSyncing.get()) {
                logDebug("Sync already in progress, skipping sync");
                return Unit.INSTANCE;
            }
            c62191.Z$0 = z;
            c62191.label = 1;
            objShouldSkipSync = shouldSkipSync(z, c62191);
            if (objShouldSkipSync != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                boolean z2 = c62191.Z$0;
                ResultKt.throwOnFailure(objShouldSkipSync);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z3 = c62191.Z$0;
            ResultKt.throwOnFailure(objShouldSkipSync);
            return Unit.INSTANCE;
        }
        z = c62191.Z$0;
        ResultKt.throwOnFailure(objShouldSkipSync);
        if (((Boolean) objShouldSkipSync).booleanValue()) {
            logDebug("Skipping sync - no local updates");
            long effectiveInterval = getEffectiveInterval();
            c62191.Z$0 = z;
            c62191.label = 2;
        } else {
            if (!this.isSyncing.compareAndSet(false, true)) {
                logDebug("Sync already started by another thread, skipping sync");
                return Unit.INSTANCE;
            }
            c62191.Z$0 = z;
            c62191.label = 3;
        }
        return coroutine_suspended;
    }

    static /* synthetic */ Object performSync$default(AutoSyncTimerManager autoSyncTimerManager, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return autoSyncTimerManager.performSync(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object shouldSkipSync(boolean z, Continuation<? super Boolean> continuation) {
        C62211 c62211;
        if (continuation instanceof C62211) {
            c62211 = (C62211) continuation;
            if ((c62211.label & Integer.MIN_VALUE) != 0) {
                c62211.label -= Integer.MIN_VALUE;
            } else {
                c62211 = new C62211(continuation);
            }
        }
        Object objWithContext = c62211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62211.label;
        boolean zBooleanValue = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                NeboNetworkState value = this.networkStateRepository.getNeboNetworkState().getValue();
                if (value != null && !value.isDataTransferAllowed()) {
                    logDebug("Skipping sync - no internet access");
                    return Boxing.boxBoolean(true);
                }
                CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
                C62222 c62222 = new C62222(z, this, null);
                c62211.Z$0 = z;
                c62211.label = 1;
                objWithContext = BuildersKt.withContext(coroutineDispatcher, c62222, c62211);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = c62211.Z$0;
                ResultKt.throwOnFailure(objWithContext);
            }
            zBooleanValue = ((Boolean) objWithContext).booleanValue();
        } catch (CancellationException unused) {
            logDebug("shouldSkipSync cancelled");
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$shouldSkipSync$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$shouldSkipSync$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $forceSync;
        int label;
        final /* synthetic */ AutoSyncTimerManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62222(boolean z, AutoSyncTimerManager autoSyncTimerManager, Continuation<? super C62222> continuation) {
            super(2, continuation);
            this.$forceSync = z;
            this.this$0 = autoSyncTimerManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62222(this.$forceSync, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C62222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = false;
            if (!this.$forceSync && (this.this$0.isPageEditingMode ? !(!this.this$0.isPageEditingMode || this.this$0.getHasMultiEditor() || this.this$0.syncHelper.hasLocalSyncUpdate()) : !this.this$0.syncHelper.hasLocalSyncUpdate())) {
                z = true;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (handleSyncFailed(r0) != r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeSyncOperation(Continuation<? super Unit> continuation) {
        C62121 c62121;
        if (continuation instanceof C62121) {
            c62121 = (C62121) continuation;
            if ((c62121.label & Integer.MIN_VALUE) != 0) {
                c62121.label -= Integer.MIN_VALUE;
            } else {
                c62121 = new C62121(continuation);
            }
        }
        Object obj = c62121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c62121.label;
        try {
        } catch (CancellationException e) {
            logDebug("Sync operation cancelled: " + e);
            this.isSyncing.set(false);
        } catch (Exception e2) {
            Log.e(TAG, "Error during sync operation", e2);
            c62121.L$0 = SpillingKt.nullOutSpilledVariable(e2);
            c62121.label = 2;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
            C62132 c62132 = new C62132(null);
            c62121.label = 1;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.core.AutoSyncTimerManager$executeSyncOperation$2 */
    /* JADX INFO: compiled from: AutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.core.AutoSyncTimerManager$executeSyncOperation$2", m1609f = "AutoSyncTimerManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C62132(Continuation<? super C62132> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSyncTimerManager.this.new C62132(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (AutoSyncTimerManager.this.syncHelper.isAutoSyncEnabled()) {
                    AutoSyncTimerManager.this.logDebug("Performing sync (auto-sync enabled)");
                    AutoSyncTimerManager.this.syncHelper.triggerSync(false);
                } else {
                    AutoSyncTimerManager.this.logDebug("Performing refresh (auto-sync disabled)");
                    AutoSyncTimerManager.this.syncHelper.triggerRefresh();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSyncCompleted(DMSSyncState dMSSyncState, LibraryRepository.SyncFailureReason syncFailureReason, Continuation<? super Unit> continuation) {
        if (this.isSyncing.compareAndSet(true, false)) {
            logDebug("Sync completed with state: " + dMSSyncState);
            if (syncFailureReason == LibraryRepository.SyncFailureReason.INSUFFICIENT_STORAGE) {
                logDebug("Cloud storage full, skipping auto-sync reschedule");
                return Unit.INSTANCE;
            }
            if (this.isEnabled && !this.isPaused) {
                Object objScheduleNextSync = scheduleNextSync(getEffectiveInterval(), continuation);
                return objScheduleNextSync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScheduleNextSync : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSyncFailed(Continuation<? super Unit> continuation) {
        this.isSyncing.set(false);
        Object objRescheduleIfEnabled = rescheduleIfEnabled(continuation);
        return objRescheduleIfEnabled == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRescheduleIfEnabled : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object rescheduleIfEnabled(Continuation<? super Unit> continuation) {
        if (this.isEnabled && !this.isPaused) {
            Object objScheduleNextSync = scheduleNextSync(getEffectiveInterval(), continuation);
            return objScheduleNextSync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScheduleNextSync : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildStartMessage() {
        return "Started with " + (getHasMultiEditor() ? "multi-editor " : "") + (this.isPageEditingMode ? "in page edit mode " : "in dms mode ") + "grid view interval: " + getEffectiveInterval() + " seconds";
    }

    private final String buildIntervalMessage() {
        return (getHasMultiEditor() ? "multi-editor " : "") + "interval: " + getEffectiveInterval() + " seconds";
    }
}
