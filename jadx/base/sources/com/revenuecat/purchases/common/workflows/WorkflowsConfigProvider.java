package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.remoteconfig.ConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.GenerationGuardedCache;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopic;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.revenuecat.purchases.common.workflows.WorkflowResolution;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 92\u00020\u0001:\u000289B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005\u0012h\b\u0002\u0010\t\u001ab\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u00121\u0012/\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u001b\u001a\u00020\u00132\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0013J\u001a\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020'J\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001dH\u0086@¢\u0006\u0002\u0010\u001fJ\u0010\u0010,\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u0010.\u001a\u00020\u0013J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010%J\u0018\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010%J\u0018\u00103\u001a\u0004\u0018\u00010#2\u0006\u0010\r\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010%J\u000e\u00104\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u00104\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0086@¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)J\u0018\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00101\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010%R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rp\u0010\t\u001ab\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u00121\u0012/\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigCommitListener;", "manager", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "currentOfferingIdProvider", "Lkotlin/Function0;", "", "prewarmOfferingIdsProvider", "", "onWorkflowLoaded", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "workflowId", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "", "transientDecode", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/CoroutineScope;)V", "cache", "Lcom/revenuecat/purchases/common/remoteconfig/GenerationGuardedCache;", "Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider$Cached;", "Lkotlin/jvm/functions/Function3;", "announceWorkflowsToPrewarm", "offeringToWorkflowId", "", "awaitReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "decodeWorkflow", TtmlNode.TAG_BODY, "", "getWorkflow", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWarmAtOrAbove", "", "generation", "", "isWarmForCurrentOffering", "offeringIdByWorkflowId", "onConfigCommitted", "onConfigInvalidated", "prewarmOfferingAssets", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "resolveWorkflowBody", "resolveWorkflowBytes", "warm", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "warmAsync", "workflowIdForOfferingId", "Cached", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowsConfigProvider implements RemoteConfigCommitListener {
    private static final Companion Companion = new Companion(null);
    private static final String KEY_OFFERING_IDENTIFIER = "offering_identifier";
    private final GenerationGuardedCache<Cached> cache;
    private final Function0<String> currentOfferingIdProvider;
    private final RemoteConfigManager manager;
    private final Function3<String, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, Continuation<? super Unit>, Object> onWorkflowLoaded;
    private final Function0<Set<String>> prewarmOfferingIdsProvider;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$offeringIdByWorkflowId$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {140}, m1612m = "offeringIdByWorkflowId", m1613n = {}, m1615s = {})
    static final class C72711 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72711(Continuation<? super C72711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.offeringIdByWorkflowId(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$resolveWorkflow$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {100}, m1612m = "resolveWorkflow", m1613n = {}, m1615s = {})
    static final class C72731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72731(Continuation<? super C72731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.resolveWorkflow(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$resolveWorkflowBody$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {0, 0}, m1611l = {164}, m1612m = "resolveWorkflowBody", m1613n = {"this", "workflowId"}, m1615s = {"L$0", "L$1"})
    static final class C72761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72761(Continuation<? super C72761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.resolveWorkflowBody(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$resolveWorkflowBytes$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {0, 0}, m1611l = {170}, m1612m = "resolveWorkflowBytes", m1613n = {"this", "workflowId"}, m1615s = {"L$0", "L$1"})
    static final class C72771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72771(Continuation<? super C72771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.resolveWorkflowBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warm$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {215, 230}, m1612m = "warm", m1613n = {"this", "generation", "this", "offeringToWorkflowId", "generation"}, m1615s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
    static final class C72791 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72791(Continuation<? super C72791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.warm(0, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warm$4 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {0}, m1611l = {269, 270}, m1612m = "warm", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C72804 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72804(Continuation<? super C72804> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.warm(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$workflowIdForOfferingId$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_3_2}, m1612m = "workflowIdForOfferingId", m1613n = {}, m1615s = {})
    static final class C72821 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72821(Continuation<? super C72821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowsConfigProvider.this.workflowIdForOfferingId(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkflowsConfigProvider(RemoteConfigManager manager, Function0<String> currentOfferingIdProvider, Function0<? extends Set<String>> prewarmOfferingIdsProvider, Function3<? super String, ? super Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> function3, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(currentOfferingIdProvider, "currentOfferingIdProvider");
        Intrinsics.checkNotNullParameter(prewarmOfferingIdsProvider, "prewarmOfferingIdsProvider");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.manager = manager;
        this.currentOfferingIdProvider = currentOfferingIdProvider;
        this.prewarmOfferingIdsProvider = prewarmOfferingIdsProvider;
        this.onWorkflowLoaded = function3;
        this.scope = scope;
        this.cache = new GenerationGuardedCache<>();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkflowsConfigProvider(RemoteConfigManager remoteConfigManager, C72661 c72661, Function0 function0, Function3 function3, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        final Function0 function02 = (i & 2) != 0 ? new Function0() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider.1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        } : c72661;
        this(remoteConfigManager, function02, (i & 4) != 0 ? new Function0<Set<? extends String>>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                return SetsKt.setOfNotNull(function02.invoke());
            }
        } : function0, (i & 8) != 0 ? null : function3, (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider$Cached;", "", BackendEvent.WORKFLOW_EVENT_TYPE, "", "", "Lkotlin/Lazy;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "offeringToWorkflowId", "(Ljava/util/Map;Ljava/util/Map;)V", "getOfferingToWorkflowId", "()Ljava/util/Map;", "getWorkflows", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Cached {
        private final Map<String, String> offeringToWorkflowId;
        private final Map<String, Lazy<PublishedWorkflow>> workflows;

        /* JADX WARN: Multi-variable type inference failed */
        public Cached(Map<String, ? extends Lazy<PublishedWorkflow>> workflows, Map<String, String> offeringToWorkflowId) {
            Intrinsics.checkNotNullParameter(workflows, "workflows");
            Intrinsics.checkNotNullParameter(offeringToWorkflowId, "offeringToWorkflowId");
            this.workflows = workflows;
            this.offeringToWorkflowId = offeringToWorkflowId;
        }

        public final Map<String, Lazy<PublishedWorkflow>> getWorkflows() {
            return this.workflows;
        }

        public final Map<String, String> getOfferingToWorkflowId() {
            return this.offeringToWorkflowId;
        }
    }

    public final boolean isWarmForCurrentOffering() {
        Cached cached = this.cache.getCached();
        if (cached == null) {
            return false;
        }
        String strInvoke = this.currentOfferingIdProvider.invoke();
        String str = strInvoke != null ? cached.getOfferingToWorkflowId().get(strInvoke) : null;
        return str == null || cached.getWorkflows().containsKey(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveWorkflow(final String str, Continuation<? super WorkflowResolution> continuation) {
        C72731 c72731;
        if (continuation instanceof C72731) {
            c72731 = (C72731) continuation;
            if ((c72731.label & Integer.MIN_VALUE) != 0) {
                c72731.label -= Integer.MIN_VALUE;
            } else {
                c72731 = new C72731(continuation);
            }
        }
        Object consistent = c72731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(consistent);
            if (!this.manager.isDisabled()) {
                Cached cached = this.cache.getCached();
                if (cached != null) {
                    String str2 = cached.getOfferingToWorkflowId().get(str);
                    return str2 != null ? new WorkflowResolution.Found(str2) : WorkflowResolution.NoWorkflow.INSTANCE;
                }
                RemoteConfigManager remoteConfigManager = this.manager;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider.resolveWorkflow.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "the workflow for offering '" + str + '\'';
                    }
                };
                C72755 c72755 = new C72755(str, null);
                c72731.label = 1;
                consistent = RemoteConfigConsistentReadKt.readConsistent(remoteConfigManager, function0, c72755, c72731);
                if (consistent == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Workflows are unavailable: remote config is disabled for this SDK configuration.", null);
                return WorkflowResolution.Unavailable.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(consistent);
        }
        WorkflowResolution workflowResolution = (WorkflowResolution) consistent;
        return workflowResolution == null ? WorkflowResolution.Unavailable.INSTANCE : workflowResolution;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$resolveWorkflow$5 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "<anonymous parameter 0>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$resolveWorkflow$5", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {101}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72755 extends SuspendLambda implements Function2<Integer, Continuation<? super WorkflowResolution>, Object> {
        final /* synthetic */ String $offeringId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72755(String str, Continuation<? super C72755> continuation) {
            super(2, continuation);
            this.$offeringId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WorkflowsConfigProvider.this.new C72755(this.$offeringId, continuation);
        }

        public final Object invoke(int i, Continuation<? super WorkflowResolution> continuation) {
            return ((C72755) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super WorkflowResolution> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = WorkflowsConfigProvider.this.manager.topic(RemoteConfigTopic.Workflows, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ConfigTopic configTopic = (ConfigTopic) obj;
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "workflows topic " + (configTopic == null ? "is absent" : "has " + configTopic.size() + " item(s)"));
            }
            if (configTopic == null) {
                String str2 = this.$offeringId;
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Workflows topic unavailable resolving offering '" + str2 + '\'');
                }
                return WorkflowResolution.Unavailable.INSTANCE;
            }
            Set<Map.Entry<String, RemoteConfiguration.ConfigItem>> setEntrySet = configTopic.entrySet();
            String str3 = this.$offeringId;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : setEntrySet) {
                if (Intrinsics.areEqual(WorkflowsConfigProvider.Companion.stringOrNull(((RemoteConfiguration.ConfigItem) ((Map.Entry) obj2).getValue()).getMetadata(), "offering_identifier"), str3)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() > 1) {
                String str4 = this.$offeringId;
                LogLevel logLevel3 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    String str5 = "[Purchases] - " + logLevel3.name();
                    StringBuilder sbAppend = new StringBuilder("Duplicate offering_identifier '").append(str4).append("' in workflows topic: ");
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add((String) ((Map.Entry) it.next()).getKey());
                    }
                    currentLogHandler3.mo1545w(str5, sbAppend.append(arrayList4).toString());
                }
            }
            Map.Entry entry = (Map.Entry) CollectionsKt.lastOrNull((List) arrayList2);
            String str6 = entry != null ? (String) entry.getKey() : null;
            String str7 = this.$offeringId;
            LogLevel logLevel4 = LogLevel.VERBOSE;
            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                String str8 = "[Purchases] - " + logLevel4.name();
                if (str6 != null) {
                    str = "Resolved offering '" + str7 + "' to workflow '" + str6 + '\'';
                } else {
                    str = "No workflow found for offering '" + str7 + '\'';
                }
                currentLogHandler4.mo1544v(str8, str);
            }
            return str6 != null ? new WorkflowResolution.Found(str6) : WorkflowResolution.NoWorkflow.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object workflowIdForOfferingId(String str, Continuation<? super String> continuation) {
        C72821 c72821;
        if (continuation instanceof C72821) {
            c72821 = (C72821) continuation;
            if ((c72821.label & Integer.MIN_VALUE) != 0) {
                c72821.label -= Integer.MIN_VALUE;
            } else {
                c72821 = new C72821(continuation);
            }
        }
        Object objResolveWorkflow = c72821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveWorkflow);
            c72821.label = 1;
            objResolveWorkflow = resolveWorkflow(str, c72821);
            if (objResolveWorkflow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolveWorkflow);
        }
        WorkflowResolution.Found found = objResolveWorkflow instanceof WorkflowResolution.Found ? (WorkflowResolution.Found) objResolveWorkflow : null;
        if (found != null) {
            return found.getWorkflowId();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object offeringIdByWorkflowId(Continuation<? super Map<String, String>> continuation) {
        C72711 c72711;
        if (continuation instanceof C72711) {
            c72711 = (C72711) continuation;
            if ((c72711.label & Integer.MIN_VALUE) != 0) {
                c72711.label -= Integer.MIN_VALUE;
            } else {
                c72711 = new C72711(continuation);
            }
        }
        Object obj = c72711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.Workflows;
            c72711.label = 1;
            obj = remoteConfigManager.topic(remoteConfigTopic, c72711);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ConfigTopic configTopic = (ConfigTopic) obj;
        Map map = null;
        if (configTopic != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, RemoteConfiguration.ConfigItem> entry : configTopic.entrySet()) {
                String key = entry.getKey();
                String strStringOrNull = Companion.stringOrNull(entry.getValue().getMetadata(), "offering_identifier");
                Pair pairM1606to = strStringOrNull != null ? TuplesKt.m1606to(key, strStringOrNull) : null;
                if (pairM1606to != null) {
                    arrayList.add(pairM1606to);
                }
            }
            map = MapsKt.toMap(arrayList);
        }
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final Object getWorkflow(final String str, Continuation<? super PublishedWorkflow> continuation) {
        Map<String, Lazy<PublishedWorkflow>> workflows;
        Lazy<PublishedWorkflow> lazy;
        Cached cached = this.cache.getCached();
        return (cached == null || (workflows = cached.getWorkflows()) == null || (lazy = workflows.get(str)) == null) ? RemoteConfigConsistentReadKt.readConsistent(this.manager, new Function0<String>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider.getWorkflow.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "workflow '" + str + '\'';
            }
        }, new C72704(str, null), continuation) : lazy.getValue();
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$getWorkflow$4 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "<anonymous parameter 0>", ""}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$getWorkflow$4", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {158}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72704 extends SuspendLambda implements Function2<Integer, Continuation<? super PublishedWorkflow>, Object> {
        final /* synthetic */ String $workflowId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72704(String str, Continuation<? super C72704> continuation) {
            super(2, continuation);
            this.$workflowId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WorkflowsConfigProvider.this.new C72704(this.$workflowId, continuation);
        }

        public final Object invoke(int i, Continuation<? super PublishedWorkflow> continuation) {
            return ((C72704) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super PublishedWorkflow> continuation) {
            return invoke(num.intValue(), continuation);
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
            this.label = 1;
            Object objResolveWorkflowBody = WorkflowsConfigProvider.this.resolveWorkflowBody(this.$workflowId, this);
            return objResolveWorkflowBody == coroutine_suspended ? coroutine_suspended : objResolveWorkflowBody;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveWorkflowBody(String str, Continuation<? super PublishedWorkflow> continuation) {
        C72761 c72761;
        WorkflowsConfigProvider workflowsConfigProvider;
        if (continuation instanceof C72761) {
            c72761 = (C72761) continuation;
            if ((c72761.label & Integer.MIN_VALUE) != 0) {
                c72761.label -= Integer.MIN_VALUE;
            } else {
                c72761 = new C72761(continuation);
            }
        }
        Object objResolveWorkflowBytes = c72761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveWorkflowBytes);
            c72761.L$0 = this;
            c72761.L$1 = str;
            c72761.label = 1;
            objResolveWorkflowBytes = resolveWorkflowBytes(str, c72761);
            if (objResolveWorkflowBytes == coroutine_suspended) {
                return coroutine_suspended;
            }
            workflowsConfigProvider = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c72761.L$1;
            workflowsConfigProvider = (WorkflowsConfigProvider) c72761.L$0;
            ResultKt.throwOnFailure(objResolveWorkflowBytes);
        }
        byte[] bArr = (byte[]) objResolveWorkflowBytes;
        if (bArr == null) {
            return null;
        }
        return workflowsConfigProvider.decodeWorkflow(str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveWorkflowBytes(String str, Continuation<? super byte[]> continuation) {
        C72771 c72771;
        WorkflowsConfigProvider workflowsConfigProvider;
        if (continuation instanceof C72771) {
            c72771 = (C72771) continuation;
            if ((c72771.label & Integer.MIN_VALUE) != 0) {
                c72771.label -= Integer.MIN_VALUE;
            } else {
                c72771 = new C72771(continuation);
            }
        }
        Object objBlobData = c72771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72771.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objBlobData);
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.Workflows;
            C72782 c72782 = new Function1<byte[], byte[]>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider.resolveWorkflowBytes.2
                @Override // kotlin.jvm.functions.Function1
                public final byte[] invoke(byte[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it;
                }
            };
            c72771.L$0 = this;
            c72771.L$1 = str;
            c72771.label = 1;
            objBlobData = remoteConfigManager.blobData(remoteConfigTopic, str, c72782, c72771);
            if (objBlobData == coroutine_suspended) {
                return coroutine_suspended;
            }
            workflowsConfigProvider = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c72771.L$1;
            workflowsConfigProvider = (WorkflowsConfigProvider) c72771.L$0;
            ResultKt.throwOnFailure(objBlobData);
        }
        byte[] bArr = (byte[]) objBlobData;
        if (bArr != null) {
            return bArr;
        }
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Workflow '" + str + "' is unavailable from remote config.", null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PublishedWorkflow decodeWorkflow(String workflowId, byte[] body) {
        try {
            PublishedWorkflow publishedWorkflow = WorkflowJsonParser.INSTANCE.parsePublishedWorkflow(StringsKt.decodeToString(body));
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Parsed workflow '" + workflowId + "' (" + publishedWorkflow.getSteps().size() + " step(s))");
            }
            return publishedWorkflow;
        } catch (Exception e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse workflow '" + workflowId + "' body.", e);
            return null;
        }
    }

    public final Object awaitReady(Continuation<? super Unit> continuation) {
        Object objAwaitTopicAndPrefetchBlobsReady = this.manager.awaitTopicAndPrefetchBlobsReady(RemoteConfigTopic.Workflows, continuation);
        return objAwaitTopicAndPrefetchBlobsReady == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitTopicAndPrefetchBlobsReady : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object warm(int i, Continuation<? super Unit> continuation) {
        C72791 c72791;
        WorkflowsConfigProvider workflowsConfigProvider;
        final WorkflowsConfigProvider workflowsConfigProvider2;
        LinkedHashMap linkedHashMap;
        LogLevel logLevel;
        if (continuation instanceof C72791) {
            c72791 = (C72791) continuation;
            if ((c72791.label & Integer.MIN_VALUE) != 0) {
                c72791.label -= Integer.MIN_VALUE;
            } else {
                c72791 = new C72791(continuation);
            }
        }
        Object objCommittedTopicOrNull = c72791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c72791.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            if (isWarmAtOrAbove(i)) {
                return Unit.INSTANCE;
            }
            RemoteConfigManager remoteConfigManager = this.manager;
            RemoteConfigTopic remoteConfigTopic = RemoteConfigTopic.Workflows;
            c72791.L$0 = this;
            c72791.I$0 = i;
            c72791.label = 1;
            objCommittedTopicOrNull = remoteConfigManager.committedTopicOrNull(remoteConfigTopic, c72791);
            if (objCommittedTopicOrNull != coroutine_suspended) {
                workflowsConfigProvider = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c72791.I$0;
            linkedHashMap = (LinkedHashMap) c72791.L$1;
            workflowsConfigProvider2 = (WorkflowsConfigProvider) c72791.L$0;
            ResultKt.throwOnFailure(objCommittedTopicOrNull);
            ArrayList arrayList = new ArrayList();
            for (Pair pair : (Iterable) objCommittedTopicOrNull) {
                final String str = (String) pair.component1();
                final byte[] bArr = (byte[]) pair.component2();
                Pair pairM1606to = bArr != null ? TuplesKt.m1606to(str, LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PublishedWorkflow>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warm$workflows$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final PublishedWorkflow invoke() {
                        return this.this$0.decodeWorkflow(str, bArr);
                    }
                })) : null;
                if (pairM1606to != null) {
                    arrayList.add(pairM1606to);
                }
            }
            Map map = MapsKt.toMap(arrayList);
            logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Warmed workflows cache: " + map.size() + " eligible workflow(s), " + linkedHashMap.size() + " offering mapping(s).");
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            workflowsConfigProvider2.cache.store(i, new Cached(map, linkedHashMap2));
            workflowsConfigProvider2.announceWorkflowsToPrewarm(linkedHashMap2);
            return Unit.INSTANCE;
        }
        i = c72791.I$0;
        workflowsConfigProvider = (WorkflowsConfigProvider) c72791.L$0;
        ResultKt.throwOnFailure(objCommittedTopicOrNull);
        ConfigTopic configTopic = (ConfigTopic) objCommittedTopicOrNull;
        if (configTopic == null) {
            return Unit.INSTANCE;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        String strInvoke = workflowsConfigProvider.currentOfferingIdProvider.invoke();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = configTopic.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            RemoteConfiguration.ConfigItem configItem = (RemoteConfiguration.ConfigItem) entry.getValue();
            String strStringOrNull = Companion.stringOrNull(configItem.getMetadata(), "offering_identifier");
            if (strStringOrNull != null) {
                linkedHashMap3.put(strStringOrNull, str2);
            }
            if (configItem.getPrefetch() || (strStringOrNull != null && Intrinsics.areEqual(strStringOrNull, strInvoke))) {
                arrayList2.add(str2);
            }
        }
        WorkflowsConfigProvider$warm$workflows$1 workflowsConfigProvider$warm$workflows$1 = new WorkflowsConfigProvider$warm$workflows$1(arrayList2, workflowsConfigProvider, null);
        c72791.L$0 = workflowsConfigProvider;
        c72791.L$1 = linkedHashMap3;
        c72791.I$0 = i;
        c72791.label = 2;
        objCommittedTopicOrNull = CoroutineScopeKt.coroutineScope(workflowsConfigProvider$warm$workflows$1, c72791);
        if (objCommittedTopicOrNull != coroutine_suspended) {
            workflowsConfigProvider2 = workflowsConfigProvider;
            linkedHashMap = linkedHashMap3;
            ArrayList arrayList3 = new ArrayList();
            while (r15.hasNext()) {
            }
            Map map2 = MapsKt.toMap(arrayList3);
            logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            }
            LinkedHashMap linkedHashMap22 = linkedHashMap;
            workflowsConfigProvider2.cache.store(i, new Cached(map2, linkedHashMap22));
            workflowsConfigProvider2.announceWorkflowsToPrewarm(linkedHashMap22);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    public final void prewarmOfferingAssets() {
        Cached cached = this.cache.getCached();
        announceWorkflowsToPrewarm(cached != null ? cached.getOfferingToWorkflowId() : null);
    }

    private final void announceWorkflowsToPrewarm(Map<String, String> offeringToWorkflowId) {
        LinkedHashSet linkedHashSet;
        Function3<String, Function2<? super String, ? super Continuation<? super PublishedWorkflow>, ? extends Object>, Continuation<? super Unit>, Object> function3 = this.onWorkflowLoaded;
        if (function3 == null) {
            return;
        }
        if (offeringToWorkflowId != null) {
            Set<String> setInvoke = this.prewarmOfferingIdsProvider.invoke();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                String str = offeringToWorkflowId.get((String) it.next());
                if (str != null) {
                    linkedHashSet2.add(str);
                }
            }
            linkedHashSet = linkedHashSet2;
        } else {
            linkedHashSet = null;
        }
        LinkedHashSet linkedHashSet3 = linkedHashSet;
        if (linkedHashSet3 == null || linkedHashSet3.isEmpty()) {
            return;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new WorkflowsConfigProvider$announceWorkflowsToPrewarm$1$1(function3, (String) it2.next(), this, null), 3, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r2.warm(r6, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object warm(Continuation<? super Unit> continuation) {
        C72804 c72804;
        WorkflowsConfigProvider workflowsConfigProvider;
        if (continuation instanceof C72804) {
            c72804 = (C72804) continuation;
            if ((c72804.label & Integer.MIN_VALUE) != 0) {
                c72804.label -= Integer.MIN_VALUE;
            } else {
                c72804 = new C72804(continuation);
            }
        }
        Object obj = c72804.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72804.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c72804.L$0 = this;
            c72804.label = 1;
            if (awaitReady(c72804) != coroutine_suspended) {
                workflowsConfigProvider = this;
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
        workflowsConfigProvider = (WorkflowsConfigProvider) c72804.L$0;
        ResultKt.throwOnFailure(obj);
        int configGeneration = workflowsConfigProvider.manager.getConfigGeneration();
        c72804.L$0 = null;
        c72804.label = 2;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warmAsync$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$warmAsync$1", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {275}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $generation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72811(int i, Continuation<? super C72811> continuation) {
            super(2, continuation);
            this.$generation = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WorkflowsConfigProvider.this.new C72811(this.$generation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (WorkflowsConfigProvider.this.warm(this.$generation, this) == coroutine_suspended) {
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

    public final void warmAsync(int generation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72811(generation, null), 3, null);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$onConfigCommitted$1 */
    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowsConfigProvider$onConfigCommitted$1", m1609f = "WorkflowsConfigProvider.kt", m1610i = {}, m1611l = {279}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $generation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72721(int i, Continuation<? super C72721> continuation) {
            super(2, continuation);
            this.$generation = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WorkflowsConfigProvider.this.new C72721(this.$generation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (WorkflowsConfigProvider.this.warm(this.$generation, this) == coroutine_suspended) {
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

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener
    public void onConfigCommitted(int generation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72721(generation, null), 3, null);
    }

    @Override // com.revenuecat.purchases.common.remoteconfig.RemoteConfigCommitListener
    public void onConfigInvalidated(int generation) {
        this.cache.invalidate(generation);
    }

    public final void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    private final boolean isWarmAtOrAbove(int generation) {
        return this.cache.isAtOrAbove(generation) && isWarmForCurrentOffering();
    }

    /* JADX INFO: compiled from: WorkflowsConfigProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider$Companion;", "", "()V", "KEY_OFFERING_IDENTIFIER", "", "stringOrNull", "Lkotlinx/serialization/json/JsonObject;", SubscriberAttributeKt.JSON_NAME_KEY, "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String stringOrNull(JsonObject jsonObject, String str) {
            Object obj = jsonObject.get((Object) str);
            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
            if (jsonPrimitive != null) {
                if (!jsonPrimitive.getIsString()) {
                    jsonPrimitive = null;
                }
                if (jsonPrimitive != null) {
                    return jsonPrimitive.getContent();
                }
            }
            return null;
        }
    }
}
