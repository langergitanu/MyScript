package com.myscript.nebo.discoverability;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.myscript.nebo.discoverability.session.ISessionManager;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: compiled from: DiscoverabilityManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001%B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u001eJ\u001c\u0010\"\u001a\u00020\u001a2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "Lcom/myscript/nebo/discoverability/IDiscoverabilityManager;", "features", "", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "discoveryRepository", "Lcom/myscript/nebo/discoverability/IDiscoveryRepository;", "sessionManager", "Lcom/myscript/nebo/discoverability/session/ISessionManager;", "extraMetrics", "Lcom/myscript/nebo/discoverability/IExtraMetrics;", "<init>", "(Ljava/util/List;Lcom/myscript/nebo/discoverability/IDiscoveryRepository;Lcom/myscript/nebo/discoverability/session/ISessionManager;Lcom/myscript/nebo/discoverability/IExtraMetrics;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "discoverableFeatures", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "_nextDiscovery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "nextDiscovery", "Lkotlinx/coroutines/flow/StateFlow;", "getNextDiscovery", "()Lkotlinx/coroutines/flow/StateFlow;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discover", "feature", "(Lcom/myscript/nebo/discoverability/IDiscoverableFeature;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDiscoverableFeatures", "updateDiscoverableFeaturesUnlocked", "setDiscoverable", "updateDiscoverableFeaturesList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDataStore", "Provider", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DiscoverabilityManager extends IDiscoverabilityManager {
    public static final int $stable = 8;
    private final MutableStateFlow<IDiscoverableFeature> _nextDiscovery;
    private final CoroutineScope coroutineScope;
    private final List<IDiscoverableFeature> discoverableFeatures;
    private final IDiscoveryRepository discoveryRepository;
    private final IExtraMetrics extraMetrics;
    private final Mutex mutex;
    private final StateFlow<IDiscoverableFeature> nextDiscovery;
    private final ISessionManager sessionManager;

    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/DiscoverabilityManager$Provider;", "", "provideGridDiscoverabilityManager", "Lcom/myscript/nebo/discoverability/DiscoverabilityManager;", "provideEditingDiscoverabilityManager", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        DiscoverabilityManager provideEditingDiscoverabilityManager();

        DiscoverabilityManager provideGridDiscoverabilityManager();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$clearDataStore$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {108, 99}, m1612m = "clearDataStore", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$clearDataStore$2"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 100}, m1615s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C61911 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C61911(Continuation<? super C61911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.clearDataStore(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$discover$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, m1611l = {108, 44, 45, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m1612m = "discover", m1613n = {"feature", "$this$withLock_u24default$iv", "$i$f$withLock", "feature", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$discover$2", "feature", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$discover$2", "feature", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$discover$2"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 45, 48, 53}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, m1616v = 2)
    static final class C61921 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C61921(Continuation<? super C61921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.discover(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$init$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {108, 34, 39}, m1612m = "init", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$init$2", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-DiscoverabilityManager$init$2$undiscoveredFeatures$1"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 112, 40}, m1615s = {"L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C61931 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C61931(Continuation<? super C61931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.init(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$setDiscoverable$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {108, 73, BaseNCodec.MIME_CHUNK_SIZE}, m1612m = "setDiscoverable", m1613n = {"feature", "$this$withLock_u24default$iv", "$i$f$withLock", "feature", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$setDiscoverable$2", "feature", "$this$withLock_u24default$iv", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$setDiscoverable$2", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-DiscoverabilityManager$setDiscoverable$2$onlyDiscoverable$1"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 75, 112}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C61941 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C61941(Continuation<? super C61941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.setDiscoverable(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$updateDiscoverableFeatures$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {108, 58}, m1612m = "updateDiscoverableFeatures", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$updateDiscoverableFeatures$2"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 59}, m1615s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C61961 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C61961(Continuation<? super C61961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.updateDiscoverableFeatures(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$updateDiscoverableFeaturesList$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m1611l = {108, TsExtractor.TS_STREAM_TYPE_DVBSUBS, PDFACompliance.e_PDFA9_3}, m1612m = "updateDiscoverableFeaturesList", m1613n = {"features", "$this$withLock_u24default$iv", "$i$f$withLock", "features", "$this$withLock_u24default$iv", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$updateDiscoverableFeaturesList$2", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-DiscoverabilityManager$updateDiscoverableFeaturesList$2$undiscoveredFeatures$1", "features", "$this$withLock_u24default$iv", "undiscoveredFeatures", "$i$f$withLock", "$i$a$-withLock$default-DiscoverabilityManager$updateDiscoverableFeaturesList$2"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 112, PDFACompliance.e_PDFA9_4}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "I$0", "I$1"}, m1616v = 2)
    static final class C61971 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C61971(Continuation<? super C61971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.updateDiscoverableFeaturesList(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.discoverability.DiscoverabilityManager$updateDiscoverableFeaturesUnlocked$1 */
    /* JADX INFO: compiled from: DiscoverabilityManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.discoverability.DiscoverabilityManager", m1609f = "DiscoverabilityManager.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {64}, m1612m = "updateDiscoverableFeaturesUnlocked", m1613n = {"$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-DiscoverabilityManager$updateDiscoverableFeaturesUnlocked$onlyDiscoverable$1"}, m1614nl = {104}, m1615s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C61991 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C61991(Continuation<? super C61991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DiscoverabilityManager.this.updateDiscoverableFeaturesUnlocked(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoverabilityManager(List<? extends IDiscoverableFeature> features, IDiscoveryRepository discoveryRepository, ISessionManager sessionManager, IExtraMetrics iExtraMetrics) {
        super(iExtraMetrics);
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(discoveryRepository, "discoveryRepository");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.discoveryRepository = discoveryRepository;
        this.sessionManager = sessionManager;
        this.extraMetrics = iExtraMetrics;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.discoverableFeatures = CollectionsKt.toMutableList((Collection) features);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        MutableStateFlow<IDiscoverableFeature> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._nextDiscovery = MutableStateFlow;
        this.nextDiscovery = MutableStateFlow;
    }

    public /* synthetic */ DiscoverabilityManager(List list, IDiscoveryRepository iDiscoveryRepository, ISessionManager iSessionManager, IExtraMetrics iExtraMetrics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, iDiscoveryRepository, iSessionManager, (i & 8) != 0 ? null : iExtraMetrics);
    }

    @Override // com.myscript.nebo.discoverability.IDiscoverabilityManager
    public StateFlow<IDiscoverableFeature> getNextDiscovery() {
        return this.nextDiscovery;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0121, code lost:
    
        if (updateDiscoverableFeatures(r2) == r3) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #0 {all -> 0x0127, blocks: (B:28:0x00a6, B:30:0x00ac, B:38:0x00fa), top: B:50:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #2 {all -> 0x006b, blocks: (B:17:0x0063, B:34:0x00e9, B:36:0x00f1), top: B:54:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fa A[Catch: all -> 0x0127, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0127, blocks: (B:28:0x00a6, B:30:0x00ac, B:38:0x00fa), top: B:50:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e6 -> B:34:0x00e9). Please report as a decompilation issue!!! */
    @Override // com.myscript.nebo.discoverability.IDiscoverabilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object init(Continuation<? super Unit> continuation) throws Throwable {
        C61931 c61931;
        Mutex mutex;
        int i;
        Iterable iterable;
        int i2;
        Collection arrayList;
        Iterator it;
        int i3;
        int i4;
        int i5;
        Object obj;
        Iterable iterable2;
        if (continuation instanceof C61931) {
            c61931 = (C61931) continuation;
            if ((c61931.label & Integer.MIN_VALUE) != 0) {
                c61931.label -= Integer.MIN_VALUE;
            } else {
                c61931 = new C61931(continuation);
            }
        }
        Object obj2 = c61931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c61931.label;
        Object obj3 = null;
        try {
            try {
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Mutex mutex2 = this.mutex;
                    c61931.L$0 = mutex2;
                    c61931.I$0 = 0;
                    c61931.label = 1;
                    if (mutex2.lock(null, c61931) != coroutine_suspended) {
                        mutex = mutex2;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    int i7 = c61931.I$4;
                    i3 = c61931.I$3;
                    i4 = c61931.I$2;
                    i5 = c61931.I$1;
                    i2 = c61931.I$0;
                    Object obj4 = c61931.L$5;
                    it = (Iterator) c61931.L$4;
                    arrayList = (Collection) c61931.L$3;
                    iterable = (Iterable) c61931.L$2;
                    Iterable iterable3 = (Iterable) c61931.L$1;
                    mutex = (Mutex) c61931.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        Iterable iterable4 = iterable3;
                        if (!((Boolean) obj2).booleanValue()) {
                            arrayList.add(obj4);
                        }
                        obj = obj3;
                        iterable2 = iterable4;
                        if (it.hasNext()) {
                            Object next = it.next();
                            IDiscoverableFeature iDiscoverableFeature = (IDiscoverableFeature) next;
                            IDiscoveryRepository iDiscoveryRepository = this.discoveryRepository;
                            c61931.L$0 = mutex;
                            iterable4 = iterable2;
                            c61931.L$1 = SpillingKt.nullOutSpilledVariable(iterable4);
                            c61931.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                            c61931.L$3 = arrayList;
                            c61931.L$4 = it;
                            c61931.L$5 = next;
                            c61931.L$6 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeature);
                            c61931.I$0 = i2;
                            c61931.I$1 = i5;
                            c61931.I$2 = i4;
                            c61931.I$3 = i3;
                            c61931.I$4 = 0;
                            c61931.label = 2;
                            Object objIsDiscovered = iDiscoveryRepository.isDiscovered(iDiscoverableFeature, c61931);
                            if (objIsDiscovered != coroutine_suspended) {
                                obj3 = obj;
                                obj4 = next;
                                obj2 = objIsDiscovered;
                                if (!((Boolean) obj2).booleanValue()) {
                                }
                                obj = obj3;
                                iterable2 = iterable4;
                                if (it.hasNext()) {
                                    this.discoverableFeatures.clear();
                                    this.discoverableFeatures.addAll((List) arrayList);
                                    mutex.unlock(obj);
                                    c61931.L$0 = null;
                                    c61931.L$1 = null;
                                    c61931.L$2 = null;
                                    c61931.L$3 = null;
                                    c61931.L$4 = null;
                                    c61931.L$5 = null;
                                    c61931.L$6 = null;
                                    c61931.label = 3;
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        mutex.unlock(obj3);
                        throw th;
                    }
                }
                i = c61931.I$0;
                Mutex mutex3 = (Mutex) c61931.L$0;
                ResultKt.throwOnFailure(obj2);
                mutex = mutex3;
                if (it.hasNext()) {
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                obj3 = obj;
                mutex.unlock(obj3);
                throw th;
            }
            List<IDiscoverableFeature> list = this.discoverableFeatures;
            iterable = list;
            i2 = i;
            arrayList = new ArrayList();
            it = list.iterator();
            i3 = 0;
            i4 = 0;
            i5 = 0;
            obj = null;
            iterable2 = iterable;
        } catch (Throwable th3) {
            th = th3;
            mutex.unlock(obj3);
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|60|(1:(3:(1:(1:(5:14|15|53|54|55)(2:19|20))(7:21|66|22|46|47|(1:49)|50))(7:26|64|27|28|40|(2:42|(1:44)(5:45|46|47|(0)|50))(3:47|(0)|50)|52)|58|59)(1:31))(3:32|(1:35)|52)|62|36|(3:39|40|(0)(0))|52) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f9, code lost:
    
        if (updateDiscoverableFeaturesUnlocked(r0) == r1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0105, code lost:
    
        r9 = r12;
        r12 = r11;
        r11 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:53:0x00fc, B:47:0x00da, B:49:0x00e2, B:50:0x00e7, B:40:0x00b7, B:42:0x00bf), top: B:60:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[Catch: all -> 0x0042, PHI: r2 r3 r6 r11
      0x00da: PHI (r2v5 int) = (r2v4 int), (r2v6 int) binds: [B:41:0x00bd, B:46:0x00d6] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r3v3 int) = (r3v1 int), (r3v5 int) binds: [B:41:0x00bd, B:46:0x00d6] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r6v4 ??) = (r6v9 ??), (r6v6 ??) binds: [B:41:0x00bd, B:46:0x00d6] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r11v9 kotlinx.coroutines.sync.Mutex) = (r11v28 kotlinx.coroutines.sync.Mutex), (r11v11 kotlinx.coroutines.sync.Mutex) binds: [B:41:0x00bd, B:46:0x00d6] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:53:0x00fc, B:47:0x00da, B:49:0x00e2, B:50:0x00e7, B:40:0x00b7, B:42:0x00bf), top: B:60:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:53:0x00fc, B:47:0x00da, B:49:0x00e2, B:50:0x00e7, B:40:0x00b7, B:42:0x00bf), top: B:60:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.myscript.nebo.discoverability.DiscoverabilityManager] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.myscript.nebo.discoverability.IDiscoverableFeature, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.myscript.nebo.discoverability.IDiscoverableFeature, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r12v11, types: [com.myscript.nebo.discoverability.IDiscoveryRepository] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.myscript.nebo.discoverability.IDiscoverableFeature, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.myscript.nebo.discoverability.IDiscoveryRepository] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.myscript.nebo.discoverability.IDiscoverabilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object discover(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) throws Throwable {
        C61921 c61921;
        Mutex mutex;
        int i;
        ?? r11;
        ?? r6;
        Mutex mutex2;
        Mutex mutex3;
        int i2;
        ?? r5;
        Mutex mutex4;
        ?? r62;
        if (continuation instanceof C61921) {
            c61921 = (C61921) continuation;
            if ((c61921.label & Integer.MIN_VALUE) != 0) {
                c61921.label -= Integer.MIN_VALUE;
            } else {
                c61921 = new C61921(continuation);
            }
        }
        Object obj = c61921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c61921.label;
        int i4 = 0;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c61921.L$0 = iDiscoverableFeature;
            c61921.L$1 = mutex;
            c61921.I$0 = 0;
            c61921.label = 1;
            if (mutex.lock(null, c61921) != coroutine_suspended) {
                i = 0;
                r11 = iDiscoverableFeature;
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                i4 = c61921.I$1;
                int i5 = c61921.I$0;
                Mutex mutex5 = (Mutex) c61921.L$1;
                IDiscoverableFeature iDiscoverableFeature2 = (IDiscoverableFeature) c61921.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i5;
                    mutex2 = mutex5;
                    r6 = iDiscoverableFeature2;
                    r62 = r6;
                    mutex4 = mutex2;
                    if (((Boolean) obj).booleanValue()) {
                        ?? r12 = this.discoveryRepository;
                        c61921.L$0 = r6;
                        c61921.L$1 = mutex2;
                        c61921.I$0 = i;
                        c61921.I$1 = i4;
                        c61921.label = 3;
                        if (r12.discover(r6, c61921) != coroutine_suspended) {
                            int i6 = i4;
                            mutex3 = mutex2;
                            i2 = i6;
                            r5 = r6;
                            Mutex mutex6 = mutex3;
                            i4 = i2;
                            mutex4 = mutex6;
                            r62 = r5;
                            if (this.discoverableFeatures.contains(r62)) {
                            }
                            c61921.L$0 = SpillingKt.nullOutSpilledVariable(r62);
                            c61921.L$1 = mutex4;
                            c61921.I$0 = i;
                            c61921.I$1 = i4;
                            c61921.label = 4;
                            iDiscoverableFeature = mutex4;
                        }
                    } else {
                        if (this.discoverableFeatures.contains(r62)) {
                        }
                        c61921.L$0 = SpillingKt.nullOutSpilledVariable(r62);
                        c61921.L$1 = mutex4;
                        c61921.I$0 = i;
                        c61921.I$1 = i4;
                        c61921.label = 4;
                        iDiscoverableFeature = mutex4;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    iDiscoverableFeature = mutex5;
                }
            } else {
                if (i3 != 3) {
                    if (i3 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i7 = c61921.I$1;
                    int i8 = c61921.I$0;
                    Mutex mutex7 = (Mutex) c61921.L$1;
                    ResultKt.throwOnFailure(obj);
                    iDiscoverableFeature = mutex7;
                    Unit unit = Unit.INSTANCE;
                    iDiscoverableFeature.unlock(null);
                    return Unit.INSTANCE;
                }
                i2 = c61921.I$1;
                i = c61921.I$0;
                Mutex mutex8 = (Mutex) c61921.L$1;
                IDiscoverableFeature iDiscoverableFeature3 = (IDiscoverableFeature) c61921.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex3 = mutex8;
                    r5 = iDiscoverableFeature3;
                    Mutex mutex62 = mutex3;
                    i4 = i2;
                    mutex4 = mutex62;
                    r62 = r5;
                    if (this.discoverableFeatures.contains(r62)) {
                        this.discoverableFeatures.remove((Object) r62);
                    }
                    c61921.L$0 = SpillingKt.nullOutSpilledVariable(r62);
                    c61921.L$1 = mutex4;
                    c61921.I$0 = i;
                    c61921.I$1 = i4;
                    c61921.label = 4;
                    iDiscoverableFeature = mutex4;
                } catch (Throwable th3) {
                    th = th3;
                    iDiscoverableFeature = mutex8;
                }
            }
            iDiscoverableFeature.unlock(null);
            throw th;
        }
        int i9 = c61921.I$0;
        Mutex mutex9 = (Mutex) c61921.L$1;
        IDiscoverableFeature iDiscoverableFeature4 = (IDiscoverableFeature) c61921.L$0;
        ResultKt.throwOnFailure(obj);
        mutex = mutex9;
        i = i9;
        r11 = iDiscoverableFeature4;
        ?? r7 = this.discoveryRepository;
        c61921.L$0 = r11;
        c61921.L$1 = mutex;
        c61921.I$0 = i;
        c61921.I$1 = 0;
        c61921.label = 2;
        Object objIsDiscovered = r7.isDiscovered(r11, c61921);
        if (objIsDiscovered != coroutine_suspended) {
            r6 = r11;
            mutex2 = mutex;
            obj = objIsDiscovered;
            r62 = r6;
            mutex4 = mutex2;
            if (((Boolean) obj).booleanValue()) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateDiscoverableFeatures(Continuation<? super Unit> continuation) throws Throwable {
        C61961 c61961;
        Mutex mutex;
        int i;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof C61961) {
            c61961 = (C61961) continuation;
            if ((c61961.label & Integer.MIN_VALUE) != 0) {
                c61961.label -= Integer.MIN_VALUE;
            } else {
                c61961 = new C61961(continuation);
            }
        }
        Object obj = c61961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c61961.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c61961.L$0 = mutex;
                c61961.I$0 = 0;
                c61961.label = 1;
                if (mutex.lock(null, c61961) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c61961.I$1;
                int i4 = c61961.I$0;
                mutex2 = (Mutex) c61961.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c61961.I$0;
            Mutex mutex3 = (Mutex) c61961.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            c61961.L$0 = mutex;
            c61961.I$0 = i;
            c61961.I$1 = 0;
            c61961.label = 2;
            if (updateDiscoverableFeaturesUnlocked(c61961) != coroutine_suspended) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00ac -> B:20:0x00af). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateDiscoverableFeaturesUnlocked(Continuation<? super Unit> continuation) {
        C61991 c61991;
        Iterable iterable;
        Iterable iterable2;
        Collection arrayList;
        int i;
        Iterator it;
        int i2;
        if (continuation instanceof C61991) {
            c61991 = (C61991) continuation;
            if ((c61991.label & Integer.MIN_VALUE) != 0) {
                c61991.label -= Integer.MIN_VALUE;
            } else {
                c61991 = new C61991(continuation);
            }
        }
        Object objNeedsDiscovery = c61991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c61991.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objNeedsDiscovery);
            List<IDiscoverableFeature> list = this.discoverableFeatures;
            iterable = list;
            iterable2 = iterable;
            arrayList = new ArrayList();
            i = 0;
            it = list.iterator();
            i2 = 0;
            if (it.hasNext()) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c61991.I$2;
            i = c61991.I$1;
            i2 = c61991.I$0;
            Object next = c61991.L$4;
            it = (Iterator) c61991.L$3;
            arrayList = (Collection) c61991.L$2;
            iterable = (Iterable) c61991.L$1;
            iterable2 = (Iterable) c61991.L$0;
            ResultKt.throwOnFailure(objNeedsDiscovery);
            if (((Boolean) objNeedsDiscovery).booleanValue()) {
                arrayList.add(next);
            }
            if (it.hasNext()) {
                next = it.next();
                IDiscoverableFeature iDiscoverableFeature = (IDiscoverableFeature) next;
                FeatureDiscoveryState featureDiscoveryState = new FeatureDiscoveryState(this.sessionManager.getSessionCount(), this.discoveryRepository, this.extraMetrics);
                c61991.L$0 = SpillingKt.nullOutSpilledVariable(iterable2);
                c61991.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                c61991.L$2 = arrayList;
                c61991.L$3 = it;
                c61991.L$4 = next;
                c61991.L$5 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeature);
                c61991.I$0 = i2;
                c61991.I$1 = i;
                c61991.I$2 = 0;
                c61991.label = 1;
                objNeedsDiscovery = iDiscoverableFeature.needsDiscovery(featureDiscoveryState, c61991);
                if (objNeedsDiscovery == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) objNeedsDiscovery).booleanValue()) {
                }
                if (it.hasNext()) {
                    this._nextDiscovery.setValue((IDiscoverableFeature) CollectionsKt.firstOrNull(CollectionsKt.sortedWith((List) arrayList, new Comparator() { // from class: com.myscript.nebo.discoverability.DiscoverabilityManager$updateDiscoverableFeaturesUnlocked$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((IDiscoverableFeature) t).getMinimumSessionCount()), Integer.valueOf(((IDiscoverableFeature) t2).getMinimumSessionCount()));
                        }
                    })));
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(4:(1:(15:13|87|14|15|79|46|(1:48)|49|91|37|(7:89|39|40|85|41|42|(1:93)(8:45|79|46|(0)|49|91|37|(7:57|83|58|(1:60)|61|62|63)(0)))(0)|52|56|73|74)(2:18|19))(14:20|81|21|22|75|35|36|91|37|(0)(0)|52|56|73|74)|25|73|74)(1:26))(4:27|(1:30)|29|44)|77|31|(11:34|75|35|36|91|37|(0)(0)|52|56|73|74)|29|44|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01a7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01a8, code lost:
    
        r8 = r5;
        r5 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0156 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #2 {all -> 0x0168, blocks: (B:46:0x014e, B:48:0x0156), top: B:79:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0141 -> B:79:0x014e). Please report as a decompilation issue!!! */
    @Override // com.myscript.nebo.discoverability.IDiscoverabilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setDiscoverable(IDiscoverableFeature iDiscoverableFeature, Continuation<? super Unit> continuation) throws Throwable {
        C61941 c61941;
        IDiscoverableFeature iDiscoverableFeature2;
        Object obj;
        Mutex mutex;
        int i;
        Object obj2;
        Mutex mutex2;
        Mutex mutex3;
        IDiscoverableFeature iDiscoverableFeature3;
        int i2;
        Iterable iterable;
        Iterable iterable2;
        Collection arrayList;
        Iterator it;
        Object obj3;
        IDiscoverableFeature iDiscoverableFeature4;
        int i3;
        int i4;
        int i5;
        Object obj4;
        Object obj5;
        if (continuation instanceof C61941) {
            c61941 = (C61941) continuation;
            if ((c61941.label & Integer.MIN_VALUE) != 0) {
                c61941.label -= Integer.MIN_VALUE;
            } else {
                c61941 = new C61941(continuation);
            }
        }
        Object obj6 = c61941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c61941.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj6);
            Mutex mutex4 = this.mutex;
            iDiscoverableFeature2 = iDiscoverableFeature;
            c61941.L$0 = iDiscoverableFeature2;
            c61941.L$1 = mutex4;
            c61941.I$0 = 0;
            c61941.label = 1;
            obj = null;
            if (mutex4.lock(null, c61941) != coroutine_suspended) {
                mutex = mutex4;
                i = 0;
            }
            return coroutine_suspended;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                i2 = c61941.I$1;
                int i7 = c61941.I$0;
                mutex3 = (Mutex) c61941.L$1;
                iDiscoverableFeature3 = (IDiscoverableFeature) c61941.L$0;
                try {
                    ResultKt.throwOnFailure(obj6);
                    i = i7;
                    obj = null;
                    try {
                        List<IDiscoverableFeature> list = this.discoverableFeatures;
                        iterable = list;
                        iterable2 = iterable;
                        arrayList = new ArrayList();
                        it = list.iterator();
                        obj3 = obj;
                        mutex2 = mutex3;
                        iDiscoverableFeature4 = iDiscoverableFeature3;
                        i3 = 0;
                        i4 = i2;
                        i5 = 0;
                        if (!it.hasNext()) {
                        }
                        th = th;
                        obj2 = obj5;
                    } catch (Throwable th) {
                        th = th;
                        obj2 = obj;
                        mutex2 = mutex3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    mutex2 = mutex3;
                    obj2 = null;
                }
                mutex2.unlock(obj2);
                throw th;
            }
            if (i6 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = c61941.I$4;
            int i9 = c61941.I$3;
            int i10 = c61941.I$2;
            int i11 = c61941.I$1;
            int i12 = c61941.I$0;
            Object next = c61941.L$6;
            it = (Iterator) c61941.L$5;
            arrayList = (Collection) c61941.L$4;
            Iterable iterable3 = (Iterable) c61941.L$3;
            Iterable iterable4 = (Iterable) c61941.L$2;
            mutex2 = (Mutex) c61941.L$1;
            IDiscoverableFeature iDiscoverableFeature5 = (IDiscoverableFeature) c61941.L$0;
            try {
                ResultKt.throwOnFailure(obj6);
                Iterable iterable5 = iterable4;
                Object obj7 = null;
                Iterable iterable6 = iterable3;
                Object obj8 = coroutine_suspended;
                boolean z = false;
                IDiscoverableFeature iDiscoverableFeature6 = iDiscoverableFeature5;
                int i13 = i11;
                int i14 = i10;
                Mutex mutex5 = mutex2;
                int i15 = i9;
                C61941 c619412 = c61941;
                int i16 = i12;
                try {
                    try {
                        if (((Boolean) obj6).booleanValue()) {
                            arrayList.add(next);
                        }
                        if (!it.hasNext()) {
                            try {
                                try {
                                    next = it.next();
                                    IDiscoverableFeature iDiscoverableFeature7 = (IDiscoverableFeature) next;
                                    Iterable iterable7 = iterable;
                                    iterable5 = iterable2;
                                    Object obj9 = coroutine_suspended;
                                    FeatureDiscoveryState featureDiscoveryState = new FeatureDiscoveryState(this.sessionManager.getSessionCount(), this.discoveryRepository, this.extraMetrics);
                                    c61941.L$0 = iDiscoverableFeature4;
                                    c61941.L$1 = mutex2;
                                    c61941.L$2 = SpillingKt.nullOutSpilledVariable(iterable5);
                                    c61941.L$3 = SpillingKt.nullOutSpilledVariable(iterable7);
                                    c61941.L$4 = arrayList;
                                    c61941.L$5 = it;
                                    c61941.L$6 = next;
                                    c61941.L$7 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeature7);
                                    c61941.I$0 = i;
                                    c61941.I$1 = i4;
                                    c61941.I$2 = i3;
                                    c61941.I$3 = i5;
                                    z = false;
                                    c61941.I$4 = 0;
                                    c61941.label = 3;
                                    Object objNeedsDiscovery = iDiscoverableFeature7.needsDiscovery(featureDiscoveryState, c61941);
                                    obj8 = obj9;
                                    if (objNeedsDiscovery == obj8) {
                                        return obj8;
                                    }
                                    C61941 c619413 = c61941;
                                    i16 = i;
                                    obj6 = objNeedsDiscovery;
                                    iDiscoverableFeature6 = iDiscoverableFeature4;
                                    i13 = i4;
                                    i14 = i3;
                                    mutex5 = mutex2;
                                    i15 = i5;
                                    c619412 = c619413;
                                    iterable6 = iterable7;
                                    obj7 = obj5;
                                    if (((Boolean) obj6).booleanValue()) {
                                    }
                                    i = i16;
                                    c61941 = c619412;
                                    i5 = i15;
                                    mutex2 = mutex5;
                                    i3 = i14;
                                    i4 = i13;
                                    iDiscoverableFeature4 = iDiscoverableFeature6;
                                    obj3 = obj7;
                                    coroutine_suspended = obj8;
                                    iterable = iterable6;
                                    iterable2 = iterable5;
                                    if (!it.hasNext()) {
                                        obj5 = obj3;
                                        try {
                                            if (CollectionsKt.sortedWith((List) arrayList, new Comparator() { // from class: com.myscript.nebo.discoverability.DiscoverabilityManager$setDiscoverable$lambda$0$$inlined$sortedBy$1
                                                @Override // java.util.Comparator
                                                public final int compare(T t, T t2) {
                                                    return ComparisonsKt.compareValues(Integer.valueOf(((IDiscoverableFeature) t).getMinimumSessionCount()), Integer.valueOf(((IDiscoverableFeature) t2).getMinimumSessionCount()));
                                                }
                                            }).contains(iDiscoverableFeature4)) {
                                                this._nextDiscovery.setValue(iDiscoverableFeature4);
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            mutex2.unlock(obj5);
                                            return Unit.INSTANCE;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj4 = obj5;
                                            obj2 = obj4;
                                            mutex2.unlock(obj2);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                obj5 = obj3;
                            } catch (Throwable th5) {
                                th = th5;
                                obj5 = obj3;
                            }
                        }
                        th = th4;
                        obj2 = obj5;
                    } catch (Throwable th6) {
                        th = th6;
                        mutex2 = mutex5;
                        obj2 = obj7;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    obj4 = obj3;
                }
                i = i16;
                c61941 = c619412;
                i5 = i15;
                mutex2 = mutex5;
                i3 = i14;
                i4 = i13;
                iDiscoverableFeature4 = iDiscoverableFeature6;
                obj3 = obj7;
                coroutine_suspended = obj8;
                iterable = iterable6;
                iterable2 = iterable5;
            } catch (Throwable th8) {
                th = th8;
                obj2 = null;
            }
            mutex2.unlock(obj2);
            throw th;
            obj2 = null;
            mutex2.unlock(obj2);
            throw th;
        }
        int i17 = c61941.I$0;
        Mutex mutex6 = (Mutex) c61941.L$1;
        IDiscoverableFeature iDiscoverableFeature8 = (IDiscoverableFeature) c61941.L$0;
        ResultKt.throwOnFailure(obj6);
        i = i17;
        iDiscoverableFeature2 = iDiscoverableFeature8;
        mutex = mutex6;
        obj = null;
        IDiscoveryRepository iDiscoveryRepository = this.discoveryRepository;
        c61941.L$0 = iDiscoverableFeature2;
        c61941.L$1 = mutex;
        c61941.I$0 = i;
        c61941.I$1 = 0;
        c61941.label = 2;
        if (iDiscoveryRepository.setDiscoverable(iDiscoverableFeature2, c61941) != coroutine_suspended) {
            mutex3 = mutex;
            iDiscoverableFeature3 = iDiscoverableFeature2;
            i2 = 0;
            List<IDiscoverableFeature> list2 = this.discoverableFeatures;
            iterable = list2;
            iterable2 = iterable;
            arrayList = new ArrayList();
            it = list2.iterator();
            obj3 = obj;
            mutex2 = mutex3;
            iDiscoverableFeature4 = iDiscoverableFeature3;
            i3 = 0;
            i4 = i2;
            i5 = 0;
            if (!it.hasNext()) {
            }
            th = th4;
            obj2 = obj5;
            mutex2.unlock(obj2);
            throw th;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(4:(1:(8:13|73|14|15|71|53|54|55)(2:18|19))(12:20|69|21|22|79|41|(1:43)|44|77|33|(5:35|36|75|37|(8:40|79|41|(0)|44|77|33|(3:48|49|(5:52|71|53|54|55))(0)))(0)|51)|25|65|66)(1:26))(3:27|(1:30)|51)|67|31|32|77|33|(0)(0)|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017c, code lost:
    
        r16 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0180, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0181, code lost:
    
        r9 = null;
        r3 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1 A[Catch: all -> 0x017b, TRY_LEAVE, TryCatch #5 {all -> 0x017b, blocks: (B:33:0x00cb, B:35:0x00d1), top: B:77:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123 A[Catch: all -> 0x012f, TRY_LEAVE, TryCatch #6 {all -> 0x012f, blocks: (B:41:0x011b, B:43:0x0123), top: B:79:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0113 -> B:79:0x011b). Please report as a decompilation issue!!! */
    @Override // com.myscript.nebo.discoverability.IDiscoverabilityManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateDiscoverableFeaturesList(List<? extends IDiscoverableFeature> list, Continuation<? super Unit> continuation) throws Throwable {
        C61971 c61971;
        List<? extends IDiscoverableFeature> list2;
        Mutex mutex;
        int i;
        Object obj;
        Mutex mutex2;
        List<? extends IDiscoverableFeature> list3;
        int i2;
        Iterable iterable;
        Collection arrayList;
        int i3;
        int i4;
        Iterator it;
        Object obj2;
        List<? extends IDiscoverableFeature> list4;
        int i5;
        Object obj3;
        int i6;
        int i7;
        C61971 c619712;
        Iterable iterable2;
        if (continuation instanceof C61971) {
            c61971 = (C61971) continuation;
            if ((c61971.label & Integer.MIN_VALUE) != 0) {
                c61971.label -= Integer.MIN_VALUE;
            } else {
                c61971 = new C61971(continuation);
            }
        }
        Object obj4 = c61971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = c61971.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj4);
            Mutex mutex3 = this.mutex;
            list2 = list;
            c61971.L$0 = list2;
            c61971.L$1 = mutex3;
            c61971.I$0 = 0;
            c61971.label = 1;
            if (mutex3.lock(null, c61971) != coroutine_suspended) {
                mutex = mutex3;
                i = 0;
            }
            return coroutine_suspended;
        }
        if (i8 != 1) {
            if (i8 == 2) {
                int i9 = c61971.I$4;
                int i10 = c61971.I$3;
                int i11 = c61971.I$2;
                i4 = c61971.I$1;
                i2 = c61971.I$0;
                Object next = c61971.L$6;
                it = (Iterator) c61971.L$5;
                arrayList = (Collection) c61971.L$4;
                iterable = (Iterable) c61971.L$3;
                Iterable iterable3 = (Iterable) c61971.L$2;
                Mutex mutex4 = (Mutex) c61971.L$1;
                list4 = (List) c61971.L$0;
                try {
                    ResultKt.throwOnFailure(obj4);
                    iterable2 = iterable3;
                    obj3 = null;
                    i7 = i10;
                    c619712 = c61971;
                    i6 = i11;
                } catch (Throwable th) {
                    th = th;
                    mutex2 = mutex4;
                    obj = null;
                }
                try {
                    if (!((Boolean) obj4).booleanValue()) {
                        arrayList.add(next);
                    }
                    i3 = i6;
                    c61971 = c619712;
                    i5 = i7;
                    mutex = mutex4;
                    list3 = iterable2;
                    obj2 = obj3;
                    if (it.hasNext()) {
                        try {
                            next = it.next();
                            IDiscoverableFeature iDiscoverableFeature = (IDiscoverableFeature) next;
                            Iterable iterable4 = list3;
                            IDiscoveryRepository iDiscoveryRepository = this.discoveryRepository;
                            c61971.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                            c61971.L$1 = mutex;
                            c61971.L$2 = SpillingKt.nullOutSpilledVariable(iterable4);
                            c61971.L$3 = SpillingKt.nullOutSpilledVariable(iterable);
                            c61971.L$4 = arrayList;
                            c61971.L$5 = it;
                            c61971.L$6 = next;
                            c61971.L$7 = SpillingKt.nullOutSpilledVariable(iDiscoverableFeature);
                            c61971.I$0 = i2;
                            c61971.I$1 = i4;
                            c61971.I$2 = i3;
                            c61971.I$3 = i5;
                            c61971.I$4 = 0;
                            c61971.label = 2;
                            Object objIsDiscovered = iDiscoveryRepository.isDiscovered(iDiscoverableFeature, c61971);
                            if (objIsDiscovered != coroutine_suspended) {
                                C61971 c619713 = c61971;
                                i6 = i3;
                                obj4 = objIsDiscovered;
                                mutex4 = mutex;
                                i7 = i5;
                                c619712 = c619713;
                                iterable2 = iterable4;
                                if (!((Boolean) obj4).booleanValue()) {
                                }
                                i3 = i6;
                                c61971 = c619712;
                                i5 = i7;
                                mutex = mutex4;
                                list3 = iterable2;
                                obj2 = obj3;
                                if (it.hasNext()) {
                                    obj3 = obj2;
                                    List list5 = (List) arrayList;
                                    this.discoverableFeatures.clear();
                                    this.discoverableFeatures.addAll(list5);
                                    c61971.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                                    c61971.L$1 = mutex;
                                    c61971.L$2 = SpillingKt.nullOutSpilledVariable(list5);
                                    c61971.L$3 = null;
                                    c61971.L$4 = null;
                                    c61971.L$5 = null;
                                    c61971.L$6 = null;
                                    c61971.L$7 = null;
                                    c61971.I$0 = i2;
                                    c61971.I$1 = i4;
                                    c61971.label = 3;
                                    if (updateDiscoverableFeaturesUnlocked(c61971) != coroutine_suspended) {
                                        mutex2 = mutex;
                                        obj = obj3;
                                        Unit unit = Unit.INSTANCE;
                                        mutex2.unlock(obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2 = mutex;
                            obj = obj3;
                            mutex2.unlock(obj);
                            throw th;
                        }
                        obj3 = obj2;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex4;
                    obj = obj3;
                    mutex2.unlock(obj);
                    throw th;
                }
            }
            if (i8 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i12 = c61971.I$1;
            int i13 = c61971.I$0;
            mutex2 = (Mutex) c61971.L$1;
            try {
                ResultKt.throwOnFailure(obj4);
                obj = null;
                try {
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(obj);
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                obj = null;
            }
            obj = null;
            mutex2.unlock(obj);
            throw th;
        }
        int i14 = c61971.I$0;
        mutex = (Mutex) c61971.L$1;
        List<? extends IDiscoverableFeature> list6 = (List) c61971.L$0;
        ResultKt.throwOnFailure(obj4);
        i = i14;
        list2 = list6;
        list3 = list2;
        i2 = i;
        iterable = list3;
        arrayList = new ArrayList();
        i3 = 0;
        i4 = 0;
        it = list3.iterator();
        obj2 = null;
        list4 = list2;
        i5 = 0;
        if (it.hasNext()) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearDataStore(Continuation<? super Unit> continuation) throws Throwable {
        C61911 c61911;
        Mutex mutex;
        int i;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof C61911) {
            c61911 = (C61911) continuation;
            if ((c61911.label & Integer.MIN_VALUE) != 0) {
                c61911.label -= Integer.MIN_VALUE;
            } else {
                c61911 = new C61911(continuation);
            }
        }
        Object obj = c61911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c61911.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c61911.L$0 = mutex;
                c61911.I$0 = 0;
                c61911.label = 1;
                if (mutex.lock(null, c61911) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c61911.I$1;
                int i4 = c61911.I$0;
                mutex2 = (Mutex) c61911.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c61911.I$0;
            Mutex mutex3 = (Mutex) c61911.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            IDiscoveryRepository iDiscoveryRepository = this.discoveryRepository;
            c61911.L$0 = mutex;
            c61911.I$0 = i;
            c61911.I$1 = 0;
            c61911.label = 2;
            if (iDiscoveryRepository.clear(c61911) != coroutine_suspended) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
