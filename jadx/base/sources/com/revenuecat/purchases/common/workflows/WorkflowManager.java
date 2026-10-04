package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.p007ts.TsExtractor;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.uiconfig.UiConfigProvider;
import com.revenuecat.purchases.common.uiconfig.UiConfigResolution;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.yalantis.ucrop.UCrop;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: WorkflowManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ4\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0082@¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001e\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001cJ\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\"H\u0086@¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0&J\u0016\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020 J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010+\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010#J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowManager;", "", "workflowsConfigProvider", "Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider;", "uiConfigProvider", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;", "workflowAssetPrewarmer", "Lcom/revenuecat/purchases/common/workflows/WorkflowAssetPrewarmer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "enabled", "", "(Lcom/revenuecat/purchases/common/workflows/WorkflowsConfigProvider;Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;Lcom/revenuecat/purchases/common/workflows/WorkflowAssetPrewarmer;Lkotlinx/coroutines/CoroutineScope;Z)V", "inFlightReadiness", "Lkotlinx/coroutines/Deferred;", "", "readinessLock", "awaitBestEffort", "what", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "getWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowOrOfferingId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWorkflowBody", "workflowId", "loadUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "offeringIdByWorkflowId", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPaywallConfigReady", "onComplete", "Lkotlin/Function0;", "prewarmWorkflowAssets", Keys.WORKFLOW, "uiConfig", "readinessFailureMessage", "readyUiConfig", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowManager {
    private final boolean enabled;
    private volatile Deferred<Unit> inFlightReadiness;
    private final Object readinessLock;
    private final CoroutineScope scope;
    private final UiConfigProvider uiConfigProvider;
    private final WorkflowAssetPrewarmer workflowAssetPrewarmer;
    private final WorkflowsConfigProvider workflowsConfigProvider;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$awaitBestEffort$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager", m1609f = "WorkflowManager.kt", m1610i = {0, 0}, m1611l = {216}, m1612m = "awaitBestEffort", m1613n = {"this", "what"}, m1615s = {"L$0", "L$1"})
    static final class C72541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72541(Continuation<? super C72541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowManager.this.awaitBestEffort(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$getWorkflow$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager", m1609f = "WorkflowManager.kt", m1610i = {0, 0, 1, 1, 2, 2, 2}, m1611l = {UCrop.REQUEST_CROP, TsExtractor.TS_SYNC_BYTE, 72}, m1612m = "getWorkflow", m1613n = {"this", "workflowOrOfferingId", "this", "workflowId", "this", "workflowId", Keys.WORKFLOW}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C72551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C72551(Continuation<? super C72551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowManager.this.getWorkflow(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$getWorkflowBody$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager", m1609f = "WorkflowManager.kt", m1610i = {0}, m1611l = {102}, m1612m = "getWorkflowBody", m1613n = {"workflowId"}, m1615s = {"L$0"})
    static final class C72561 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72561(Continuation<? super C72561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowManager.this.getWorkflowBody(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$loadUiConfig$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager", m1609f = "WorkflowManager.kt", m1610i = {0}, m1611l = {113}, m1612m = "loadUiConfig", m1613n = {"workflowId"}, m1615s = {"L$0"})
    static final class C72571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72571(Continuation<? super C72571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowManager.this.loadUiConfig(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$readyUiConfig$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager", m1609f = "WorkflowManager.kt", m1610i = {0}, m1611l = {197}, m1612m = "readyUiConfig", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C72621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72621(Continuation<? super C72621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowManager.this.readyUiConfig(this);
        }
    }

    public WorkflowManager(WorkflowsConfigProvider workflowsConfigProvider, UiConfigProvider uiConfigProvider, WorkflowAssetPrewarmer workflowAssetPrewarmer, CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(workflowsConfigProvider, "workflowsConfigProvider");
        Intrinsics.checkNotNullParameter(uiConfigProvider, "uiConfigProvider");
        Intrinsics.checkNotNullParameter(workflowAssetPrewarmer, "workflowAssetPrewarmer");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.workflowsConfigProvider = workflowsConfigProvider;
        this.uiConfigProvider = uiConfigProvider;
        this.workflowAssetPrewarmer = workflowAssetPrewarmer;
        this.scope = scope;
        this.enabled = z;
        this.readinessLock = new Object();
    }

    public /* synthetic */ WorkflowManager(WorkflowsConfigProvider workflowsConfigProvider, UiConfigProvider uiConfigProvider, WorkflowAssetPrewarmer workflowAssetPrewarmer, CoroutineScope coroutineScope, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(workflowsConfigProvider, uiConfigProvider, workflowAssetPrewarmer, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope, (i & 16) != 0 ? true : z);
    }

    public final void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getWorkflow(String str, Continuation<? super PublishedWorkflow> continuation) throws PurchasesException {
        C72551 c72551;
        WorkflowManager workflowManager;
        Object objLoadUiConfig;
        String str2;
        PublishedWorkflow publishedWorkflow;
        WorkflowManager workflowManager2;
        UiConfig uiConfig;
        if (continuation instanceof C72551) {
            c72551 = (C72551) continuation;
            if ((c72551.label & Integer.MIN_VALUE) != 0) {
                c72551.label -= Integer.MIN_VALUE;
            } else {
                c72551 = new C72551(continuation);
            }
        }
        Object objWorkflowIdForOfferingId = c72551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72551.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWorkflowIdForOfferingId);
            WorkflowsConfigProvider workflowsConfigProvider = this.workflowsConfigProvider;
            c72551.L$0 = this;
            c72551.L$1 = str;
            c72551.label = 1;
            objWorkflowIdForOfferingId = workflowsConfigProvider.workflowIdForOfferingId(str, c72551);
            if (objWorkflowIdForOfferingId != coroutine_suspended) {
                workflowManager = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                publishedWorkflow = (PublishedWorkflow) c72551.L$2;
                str2 = (String) c72551.L$1;
                workflowManager2 = (WorkflowManager) c72551.L$0;
                ResultKt.throwOnFailure(objWorkflowIdForOfferingId);
                uiConfig = (UiConfig) objWorkflowIdForOfferingId;
                if (uiConfig != null) {
                    throw new PurchasesException(new PurchasesError(PurchasesErrorCode.UnknownError, "Workflow '" + str2 + "' resolved, but its UI config is unavailable."));
                }
                workflowManager2.prewarmWorkflowAssets(publishedWorkflow, uiConfig);
                return publishedWorkflow;
            }
            str = (String) c72551.L$1;
            workflowManager = (WorkflowManager) c72551.L$0;
            ResultKt.throwOnFailure(objWorkflowIdForOfferingId);
            PublishedWorkflow publishedWorkflow2 = (PublishedWorkflow) objWorkflowIdForOfferingId;
            c72551.L$0 = workflowManager;
            c72551.L$1 = str;
            c72551.L$2 = publishedWorkflow2;
            c72551.label = 3;
            objLoadUiConfig = workflowManager.loadUiConfig(str, c72551);
            if (objLoadUiConfig != coroutine_suspended) {
                str2 = str;
                publishedWorkflow = publishedWorkflow2;
                objWorkflowIdForOfferingId = objLoadUiConfig;
                workflowManager2 = workflowManager;
                uiConfig = (UiConfig) objWorkflowIdForOfferingId;
                if (uiConfig != null) {
                }
            }
            return coroutine_suspended;
        }
        str = (String) c72551.L$1;
        workflowManager = (WorkflowManager) c72551.L$0;
        ResultKt.throwOnFailure(objWorkflowIdForOfferingId);
        String str3 = (String) objWorkflowIdForOfferingId;
        if (str3 != null) {
            str = str3;
        }
        c72551.L$0 = workflowManager;
        c72551.L$1 = str;
        c72551.label = 2;
        objWorkflowIdForOfferingId = workflowManager.getWorkflowBody(str, c72551);
        if (objWorkflowIdForOfferingId != coroutine_suspended) {
            PublishedWorkflow publishedWorkflow22 = (PublishedWorkflow) objWorkflowIdForOfferingId;
            c72551.L$0 = workflowManager;
            c72551.L$1 = str;
            c72551.L$2 = publishedWorkflow22;
            c72551.label = 3;
            objLoadUiConfig = workflowManager.loadUiConfig(str, c72551);
            if (objLoadUiConfig != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$prewarmWorkflowAssets$1 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager$prewarmWorkflowAssets$1", m1609f = "WorkflowManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UiConfig $uiConfig;
        final /* synthetic */ PublishedWorkflow $workflow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72611(PublishedWorkflow publishedWorkflow, UiConfig uiConfig, Continuation<? super C72611> continuation) {
            super(2, continuation);
            this.$workflow = publishedWorkflow;
            this.$uiConfig = uiConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C72611 c72611 = WorkflowManager.this.new C72611(this.$workflow, this.$uiConfig, continuation);
            c72611.L$0 = obj;
            return c72611;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM14499constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            WorkflowManager workflowManager = WorkflowManager.this;
            PublishedWorkflow publishedWorkflow = this.$workflow;
            UiConfig uiConfig = this.$uiConfig;
            try {
                Result.Companion companion = Result.INSTANCE;
                workflowManager.workflowAssetPrewarmer.preDownloadWorkflowAssets(publishedWorkflow, uiConfig);
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to pre-download workflow assets", thM14502exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    public final void prewarmWorkflowAssets(PublishedWorkflow workflow, UiConfig uiConfig) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72611(workflow, uiConfig, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getWorkflowBody(String str, Continuation<? super PublishedWorkflow> continuation) throws PurchasesException {
        C72561 c72561;
        if (continuation instanceof C72561) {
            c72561 = (C72561) continuation;
            if ((c72561.label & Integer.MIN_VALUE) != 0) {
                c72561.label -= Integer.MIN_VALUE;
            } else {
                c72561 = new C72561(continuation);
            }
        }
        Object workflow = c72561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(workflow);
            WorkflowsConfigProvider workflowsConfigProvider = this.workflowsConfigProvider;
            c72561.L$0 = str;
            c72561.label = 1;
            workflow = workflowsConfigProvider.getWorkflow(str, c72561);
            if (workflow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c72561.L$0;
            ResultKt.throwOnFailure(workflow);
        }
        PublishedWorkflow publishedWorkflow = (PublishedWorkflow) workflow;
        if (publishedWorkflow != null) {
            return publishedWorkflow;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.UnknownError, "Workflow '" + str + "' is unavailable from remote config."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadUiConfig(String str, Continuation<? super UiConfig> continuation) {
        C72571 c72571;
        if (continuation instanceof C72571) {
            c72571 = (C72571) continuation;
            if ((c72571.label & Integer.MIN_VALUE) != 0) {
                c72571.label -= Integer.MIN_VALUE;
            } else {
                c72571 = new C72571(continuation);
            }
        }
        Object uiConfig = c72571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72571.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(uiConfig);
                UiConfigProvider uiConfigProvider = this.uiConfigProvider;
                c72571.L$0 = str;
                c72571.label = 1;
                uiConfig = uiConfigProvider.getUiConfig(c72571);
                if (uiConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c72571.L$0;
                ResultKt.throwOnFailure(uiConfig);
            }
            return (UiConfig) uiConfig;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to load ui_config for workflow '" + str + "'.", e2);
            return null;
        }
    }

    public final Object resolveWorkflow(String str, Continuation<? super WorkflowResolution> continuation) {
        return this.workflowsConfigProvider.resolveWorkflow(str, continuation);
    }

    public final Object offeringIdByWorkflowId(Continuation<? super Map<String, String>> continuation) {
        return this.workflowsConfigProvider.offeringIdByWorkflowId(continuation);
    }

    public final void onPaywallConfigReady(Function0<Unit> onComplete) {
        final Deferred<Unit> deferredAsync$default;
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (this.enabled) {
            this.workflowsConfigProvider.prewarmOfferingAssets();
            if (this.uiConfigProvider.isWarm() && this.workflowsConfigProvider.isWarmForCurrentOffering()) {
                onComplete.invoke();
                return;
            }
            synchronized (this.readinessLock) {
                deferredAsync$default = this.inFlightReadiness;
                if (deferredAsync$default == null) {
                    deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new WorkflowManager$onPaywallConfigReady$readiness$1$1(this, null), 3, null);
                    this.inFlightReadiness = deferredAsync$default;
                    deferredAsync$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$readiness$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Object obj = this.this$0.readinessLock;
                            WorkflowManager workflowManager = this.this$0;
                            Deferred<Unit> deferred = deferredAsync$default;
                            synchronized (obj) {
                                if (workflowManager.inFlightReadiness == deferred) {
                                    workflowManager.inFlightReadiness = null;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    });
                }
            }
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72582(deferredAsync$default, onComplete, null), 3, null);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Workflows are disabled for this SDK configuration; skipping paywall config readiness.");
        }
        onComplete.invoke();
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$2 */
    /* JADX INFO: compiled from: WorkflowManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.workflows.WorkflowManager$onPaywallConfigReady$2", m1609f = "WorkflowManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_6}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ Deferred<Unit> $readiness;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72582(Deferred<Unit> deferred, Function0<Unit> function0, Continuation<? super C72582> continuation) {
            super(2, continuation);
            this.$readiness = deferred;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C72582(this.$readiness, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$readiness.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$onComplete.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readyUiConfig(Continuation<? super Unit> continuation) {
        C72621 c72621;
        WorkflowManager workflowManager;
        if (continuation instanceof C72621) {
            c72621 = (C72621) continuation;
            if ((c72621.label & Integer.MIN_VALUE) != 0) {
                c72621.label -= Integer.MIN_VALUE;
            } else {
                c72621 = new C72621(continuation);
            }
        }
        Object objResolveUiConfig = c72621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72621.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveUiConfig);
            UiConfigProvider uiConfigProvider = this.uiConfigProvider;
            c72621.L$0 = this;
            c72621.label = 1;
            objResolveUiConfig = uiConfigProvider.resolveUiConfig(c72621);
            if (objResolveUiConfig == coroutine_suspended) {
                return coroutine_suspended;
            }
            workflowManager = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            workflowManager = (WorkflowManager) c72621.L$0;
            ResultKt.throwOnFailure(objResolveUiConfig);
        }
        UiConfigResolution uiConfigResolution = (UiConfigResolution) objResolveUiConfig;
        if (!(uiConfigResolution instanceof UiConfigResolution.Found)) {
            if (!Intrinsics.areEqual(uiConfigResolution, UiConfigResolution.NotConfigured.INSTANCE)) {
                if (!Intrinsics.areEqual(uiConfigResolution, UiConfigResolution.Superseded.INSTANCE)) {
                    if (Intrinsics.areEqual(uiConfigResolution, UiConfigResolution.Unavailable.INSTANCE)) {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", workflowManager.readinessFailureMessage("ui_config"), null);
                    }
                } else {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "ui_config was superseded by a newer config commit before getOfferings; the next read re-resolves it.");
                    }
                }
            } else {
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Remote config has no ui_config to resolve before getOfferings.");
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitBestEffort(String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        C72541 c72541;
        WorkflowManager workflowManager;
        if (continuation instanceof C72541) {
            c72541 = (C72541) continuation;
            if ((c72541.label & Integer.MIN_VALUE) != 0) {
                c72541.label -= Integer.MIN_VALUE;
            } else {
                c72541 = new C72541(continuation);
            }
        }
        Object obj = c72541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72541.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    c72541.L$0 = this;
                    c72541.L$1 = str;
                    c72541.label = 1;
                    if (function1.invoke(c72541) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    e = e;
                    workflowManager = this;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", workflowManager.readinessFailureMessage(str), e);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c72541.L$1;
                workflowManager = (WorkflowManager) c72541.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", workflowManager.readinessFailureMessage(str), e);
                }
            }
            return Unit.INSTANCE;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    private final String readinessFailureMessage(String what) {
        return "Failed to ready " + what + " before getOfferings; proceeding without it.";
    }
}
