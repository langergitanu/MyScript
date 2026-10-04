package com.revenuecat.purchases.checkpoints;

import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.CustomVariableKeyValidator;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.audiences.AudiencesConfigProvider;
import com.revenuecat.purchases.common.checkpoints.CheckpointRule;
import com.revenuecat.purchases.common.checkpoints.CheckpointRulesResolution;
import com.revenuecat.purchases.common.checkpoints.CheckpointsConfigProvider;
import com.revenuecat.purchases.common.localrules.LocalRulesEvaluator;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.common.uiconfig.UiConfigProvider;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowManager;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 72\u00020\u0001:\u000267BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0002\u0010\u0011J,\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0018H\u0082@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@¢\u0006\u0002\u0010\u001aJ&\u0010%\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010*J.\u0010+\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010.J6\u0010/\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\u0006\u00105\u001a\u00020\u0016H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolverImpl;", "Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolver;", "workflowManager", "Lcom/revenuecat/purchases/common/workflows/WorkflowManager;", "uiConfigProvider", "Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;", "checkpointsConfigProvider", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointsConfigProvider;", "audiencesConfigProvider", "Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;", "localRulesEvaluator", "Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluator;", "getOfferings", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/revenuecat/purchases/Offerings;", "", "(Lcom/revenuecat/purchases/common/workflows/WorkflowManager;Lcom/revenuecat/purchases/common/uiconfig/UiConfigProvider;Lcom/revenuecat/purchases/common/checkpoints/CheckpointsConfigProvider;Lcom/revenuecat/purchases/common/audiences/AudiencesConfigProvider;Lcom/revenuecat/purchases/common/localrules/LocalRulesEvaluator;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "attemptResolve", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", Keys.IDENTIFIER, "", "customVariables", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configurationUnavailable", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction;", "message", "loadOffering", "Lcom/revenuecat/purchases/Offering;", "checkpointIdentifier", "offeringIdentifier", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noMatch", "resolve", "resolveOfferingRule", "rule", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;", "step", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;Lcom/revenuecat/purchases/common/workflows/WorkflowStep;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRule", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowManager;Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;Lcom/revenuecat/purchases/UiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUiRule", Keys.WORKFLOW, "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowManager;Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Lcom/revenuecat/purchases/UiConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unknownCheckpoint", "unservableRule", "reason", "AudienceUnavailableException", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointWorkflowResolverImpl implements CheckpointWorkflowResolver {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String OFFERING_IDENTIFIER_PARAM = "offering_identifier";

    @Deprecated
    public static final String OFFERING_STEP_TYPE = "offering";

    @Deprecated
    public static final String SIMULATED_ERROR_CHECKPOINT_ID = "error_checkpoint";
    private final AudiencesConfigProvider audiencesConfigProvider;
    private final CheckpointsConfigProvider checkpointsConfigProvider;
    private final Function1<Continuation<? super Offerings>, Object> getOfferings;
    private final LocalRulesEvaluator localRulesEvaluator;
    private final UiConfigProvider uiConfigProvider;
    private final WorkflowManager workflowManager;

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$attemptResolve$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3}, m1611l = {84, 90, 108, 115}, m1612m = "attemptResolve", m1613n = {"this", Keys.IDENTIFIER, "customVariables", "this", Keys.IDENTIFIER, "rulesResolution", "this", Keys.IDENTIFIER, "rulesResolution", "rule", "this", "rulesResolution"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class C71451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C71451(Continuation<? super C71451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.attemptResolve(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$loadOffering$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0}, m1611l = {200}, m1612m = "loadOffering", m1613n = {"checkpointIdentifier", "offeringIdentifier"}, m1615s = {"L$0", "L$1"})
    static final class C71461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C71461(Continuation<? super C71461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.loadOffering(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$resolve$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0, 0, 1, 1}, m1611l = {68, 70}, m1612m = "resolve", m1613n = {"this", Keys.IDENTIFIER, "customVariables", "this", Keys.IDENTIFIER}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C71471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C71471(Continuation<? super C71471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.resolve(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$resolveOfferingRule$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0, 0}, m1611l = {158}, m1612m = "resolveOfferingRule", m1613n = {"this", "rule", "offeringIdentifier"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C71481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C71481(Continuation<? super C71481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.resolveOfferingRule(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$resolveRule$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {127, 137, PDFACompliance.e_PDFA1_4_2}, m1612m = "resolveRule", m1613n = {"this", "checkpointIdentifier", "workflowManager", "rule", "uiConfig"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C71491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C71491(Continuation<? super C71491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.resolveRule(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl$resolveUiRule$1 */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl", m1609f = "CheckpointWorkflowResolverImpl.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {177, PDFACompliance.e_PDFA1_8_7}, m1612m = "resolveUiRule", m1613n = {"this", "checkpointIdentifier", "workflowManager", "rule", Keys.WORKFLOW, "uiConfig", "this", "workflowManager", "rule", Keys.WORKFLOW, "uiConfig", "offeringId"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class C71501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C71501(Continuation<? super C71501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointWorkflowResolverImpl.this.resolveUiRule(null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckpointWorkflowResolverImpl(WorkflowManager workflowManager, UiConfigProvider uiConfigProvider, CheckpointsConfigProvider checkpointsConfigProvider, AudiencesConfigProvider audiencesConfigProvider, LocalRulesEvaluator localRulesEvaluator, Function1<? super Continuation<? super Offerings>, ? extends Object> getOfferings) {
        Intrinsics.checkNotNullParameter(workflowManager, "workflowManager");
        Intrinsics.checkNotNullParameter(uiConfigProvider, "uiConfigProvider");
        Intrinsics.checkNotNullParameter(checkpointsConfigProvider, "checkpointsConfigProvider");
        Intrinsics.checkNotNullParameter(audiencesConfigProvider, "audiencesConfigProvider");
        Intrinsics.checkNotNullParameter(localRulesEvaluator, "localRulesEvaluator");
        Intrinsics.checkNotNullParameter(getOfferings, "getOfferings");
        this.workflowManager = workflowManager;
        this.uiConfigProvider = uiConfigProvider;
        this.checkpointsConfigProvider = checkpointsConfigProvider;
        this.audiencesConfigProvider = audiencesConfigProvider;
        this.localRulesEvaluator = localRulesEvaluator;
        this.getOfferings = getOfferings;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolve(String str, Map<String, ? extends RulesDimensionValue> map, Continuation<? super CheckpointResolution> continuation) throws PurchasesException {
        C71471 c71471;
        Object obj;
        Map<String, ? extends RulesDimensionValue> map2;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl;
        if (continuation instanceof C71471) {
            c71471 = (C71471) continuation;
            if ((c71471.label & Integer.MIN_VALUE) != 0) {
                c71471.label -= Integer.MIN_VALUE;
            } else {
                c71471 = new C71471(continuation);
            }
        }
        Object objAttemptResolve = c71471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71471.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAttemptResolve);
            if (Intrinsics.areEqual(str, SIMULATED_ERROR_CHECKPOINT_ID)) {
                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.ConfigurationError, "Simulated error: checkpoint workflow not presentable.");
                LogUtilsKt.errorLog(purchasesError);
                throw new PurchasesException(purchasesError);
            }
            c71471.L$0 = this;
            c71471.L$1 = str;
            c71471.L$2 = map;
            c71471.label = 1;
            Object objAttemptResolve2 = attemptResolve(str, map, c71471);
            if (objAttemptResolve2 != coroutine_suspended) {
                obj = objAttemptResolve2;
                map2 = map;
                checkpointWorkflowResolverImpl = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c71471.L$1;
            checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c71471.L$0;
            ResultKt.throwOnFailure(objAttemptResolve);
            CheckpointResolution checkpointResolution = (CheckpointResolution) objAttemptResolve;
            return checkpointResolution == null ? checkpointWorkflowResolverImpl.configurationUnavailable("Remote config kept changing while resolving checkpoint '" + str + "'.") : checkpointResolution;
        }
        Map<String, ? extends RulesDimensionValue> map3 = (Map) c71471.L$2;
        str = (String) c71471.L$1;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl2 = (CheckpointWorkflowResolverImpl) c71471.L$0;
        ResultKt.throwOnFailure(objAttemptResolve);
        map2 = map3;
        checkpointWorkflowResolverImpl = checkpointWorkflowResolverImpl2;
        obj = objAttemptResolve;
        CheckpointResolution checkpointResolution2 = (CheckpointResolution) obj;
        if (checkpointResolution2 != null) {
            return checkpointResolution2;
        }
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config changed while resolving checkpoint '" + str + "'; resolving it again.");
        }
        c71471.L$0 = checkpointWorkflowResolverImpl;
        c71471.L$1 = str;
        c71471.L$2 = null;
        c71471.label = 2;
        objAttemptResolve = checkpointWorkflowResolverImpl.attemptResolve(str, map2, c71471);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object attemptResolve(String str, Map<String, ? extends RulesDimensionValue> map, Continuation<? super CheckpointResolution> continuation) {
        C71451 c71451;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl;
        Object value;
        CheckpointRulesResolution.Found found;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl2;
        Throwable thM14502exceptionOrNullimpl;
        String str2;
        CheckpointRule checkpointRule;
        Object uiConfig;
        CheckpointRule checkpointRule2;
        CheckpointRulesResolution.Found found2;
        String str3;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl3;
        UiConfig uiConfig2;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl4;
        if (continuation instanceof C71451) {
            c71451 = (C71451) continuation;
            if ((c71451.label & Integer.MIN_VALUE) != 0) {
                c71451.label -= Integer.MIN_VALUE;
            } else {
                c71451 = new C71451(continuation);
            }
        }
        C71451 c714512 = c71451;
        Object objResolveCheckpoint = c714512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c714512.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objResolveCheckpoint);
                CheckpointsConfigProvider checkpointsConfigProvider = this.checkpointsConfigProvider;
                c714512.L$0 = this;
                c714512.L$1 = str;
                c714512.L$2 = map;
                c714512.label = 1;
                objResolveCheckpoint = checkpointsConfigProvider.resolveCheckpoint(str, c714512);
                if (objResolveCheckpoint != coroutine_suspended) {
                    checkpointWorkflowResolverImpl = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        found2 = (CheckpointRulesResolution.Found) c714512.L$1;
                        checkpointWorkflowResolverImpl4 = (CheckpointWorkflowResolverImpl) c714512.L$0;
                        ResultKt.throwOnFailure(objResolveCheckpoint);
                        CheckpointResolution checkpointResolution = (CheckpointResolution) objResolveCheckpoint;
                        if (checkpointWorkflowResolverImpl4.checkpointsConfigProvider.isCurrent(found2)) {
                            return null;
                        }
                        return checkpointResolution;
                    }
                    checkpointRule = (CheckpointRule) c714512.L$3;
                    found = (CheckpointRulesResolution.Found) c714512.L$2;
                    str2 = (String) c714512.L$1;
                    checkpointWorkflowResolverImpl2 = (CheckpointWorkflowResolverImpl) c714512.L$0;
                    try {
                        ResultKt.throwOnFailure(objResolveCheckpoint);
                        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl5 = checkpointWorkflowResolverImpl2;
                        checkpointRule2 = checkpointRule;
                        found2 = found;
                        str3 = "'.";
                        checkpointWorkflowResolverImpl3 = checkpointWorkflowResolverImpl5;
                        uiConfig2 = (UiConfig) objResolveCheckpoint;
                    } catch (Exception e) {
                        e = e;
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "UI config could not be fetched for checkpoint '" + str2 + "'.", e);
                        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl6 = checkpointWorkflowResolverImpl2;
                        checkpointRule2 = checkpointRule;
                        found2 = found;
                        str3 = "'.";
                        checkpointWorkflowResolverImpl3 = checkpointWorkflowResolverImpl6;
                        uiConfig2 = null;
                    }
                    if (uiConfig2 != null) {
                        return checkpointWorkflowResolverImpl3.configurationUnavailable("UI config is unavailable for checkpoint '" + str2 + str3);
                    }
                    String str4 = str2;
                    WorkflowManager workflowManager = checkpointWorkflowResolverImpl3.workflowManager;
                    c714512.L$0 = checkpointWorkflowResolverImpl3;
                    c714512.L$1 = found2;
                    c714512.L$2 = null;
                    c714512.L$3 = null;
                    c714512.label = 4;
                    objResolveCheckpoint = checkpointWorkflowResolverImpl3.resolveRule(str4, workflowManager, checkpointRule2, uiConfig2, c714512);
                    if (objResolveCheckpoint != coroutine_suspended) {
                        checkpointWorkflowResolverImpl4 = checkpointWorkflowResolverImpl3;
                        CheckpointResolution checkpointResolution2 = (CheckpointResolution) objResolveCheckpoint;
                        if (checkpointWorkflowResolverImpl4.checkpointsConfigProvider.isCurrent(found2)) {
                        }
                    }
                    return coroutine_suspended;
                }
                CheckpointRulesResolution.Found found3 = (CheckpointRulesResolution.Found) c714512.L$2;
                String str5 = (String) c714512.L$1;
                checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c714512.L$0;
                ResultKt.throwOnFailure(objResolveCheckpoint);
                value = ((Result) objResolveCheckpoint).getValue();
                found = found3;
                str = str5;
                checkpointWorkflowResolverImpl2 = checkpointWorkflowResolverImpl;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(value);
                if (thM14502exceptionOrNullimpl == null) {
                    return checkpointWorkflowResolverImpl2.configurationUnavailable("The audiences for checkpoint '" + str + "' could not be evaluated: " + thM14502exceptionOrNullimpl.getMessage());
                }
                CheckpointRule checkpointRule3 = (CheckpointRule) value;
                if (!checkpointWorkflowResolverImpl2.checkpointsConfigProvider.isCurrent(found)) {
                    return null;
                }
                if (checkpointRule3 == null) {
                    return checkpointWorkflowResolverImpl2.noMatch(str);
                }
                try {
                    UiConfigProvider uiConfigProvider = checkpointWorkflowResolverImpl2.uiConfigProvider;
                    c714512.L$0 = checkpointWorkflowResolverImpl2;
                    c714512.L$1 = str;
                    c714512.L$2 = found;
                    c714512.L$3 = checkpointRule3;
                    c714512.label = 3;
                    uiConfig = uiConfigProvider.getUiConfig(c714512);
                } catch (Exception e2) {
                    e = e2;
                    str2 = str;
                    checkpointRule = checkpointRule3;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "UI config could not be fetched for checkpoint '" + str2 + "'.", e);
                    CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl62 = checkpointWorkflowResolverImpl2;
                    checkpointRule2 = checkpointRule;
                    found2 = found;
                    str3 = "'.";
                    checkpointWorkflowResolverImpl3 = checkpointWorkflowResolverImpl62;
                    uiConfig2 = null;
                }
                if (uiConfig != coroutine_suspended) {
                    str2 = str;
                    checkpointRule = checkpointRule3;
                    objResolveCheckpoint = uiConfig;
                    CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl52 = checkpointWorkflowResolverImpl2;
                    checkpointRule2 = checkpointRule;
                    found2 = found;
                    str3 = "'.";
                    checkpointWorkflowResolverImpl3 = checkpointWorkflowResolverImpl52;
                    uiConfig2 = (UiConfig) objResolveCheckpoint;
                    if (uiConfig2 != null) {
                    }
                }
                return coroutine_suspended;
            }
            map = (Map) c714512.L$2;
            str = (String) c714512.L$1;
            checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c714512.L$0;
            ResultKt.throwOnFailure(objResolveCheckpoint);
            CheckpointRulesResolution checkpointRulesResolution = (CheckpointRulesResolution) objResolveCheckpoint;
            if (!(checkpointRulesResolution instanceof CheckpointRulesResolution.Found)) {
                if (Intrinsics.areEqual(checkpointRulesResolution, CheckpointRulesResolution.NotConfigured.INSTANCE)) {
                    return checkpointWorkflowResolverImpl.unknownCheckpoint(str);
                }
                if (Intrinsics.areEqual(checkpointRulesResolution, CheckpointRulesResolution.Unavailable.INSTANCE)) {
                    return checkpointWorkflowResolverImpl.configurationUnavailable("The rules for checkpoint '" + str + "' could not be read.");
                }
                throw new NoWhenBranchMatchedException();
            }
            CheckpointRulesResolution.Found found4 = (CheckpointRulesResolution.Found) checkpointRulesResolution;
            LocalRulesEvaluator localRulesEvaluator = checkpointWorkflowResolverImpl.localRulesEvaluator;
            List<CheckpointRule> rules = found4.getCheckpoint().getRules();
            Map<String, ? extends RulesDimensionValue> mapValidateAndFilter = CustomVariableKeyValidator.INSTANCE.validateAndFilter(map);
            CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1 checkpointWorkflowResolverImpl$attemptResolve$matchResult$1 = new CheckpointWorkflowResolverImpl$attemptResolve$matchResult$1(checkpointWorkflowResolverImpl, null);
            c714512.L$0 = checkpointWorkflowResolverImpl;
            c714512.L$1 = str;
            c714512.L$2 = found4;
            c714512.label = 2;
            Object objM13734matchBWLJW6A = localRulesEvaluator.m13734matchBWLJW6A(rules, mapValidateAndFilter, checkpointWorkflowResolverImpl$attemptResolve$matchResult$1, c714512);
            if (objM13734matchBWLJW6A != coroutine_suspended) {
                value = objM13734matchBWLJW6A;
                found = found4;
                checkpointWorkflowResolverImpl2 = checkpointWorkflowResolverImpl;
                thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(value);
                if (thM14502exceptionOrNullimpl == null) {
                }
            }
            return coroutine_suspended;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveRule(String str, WorkflowManager workflowManager, CheckpointRule checkpointRule, UiConfig uiConfig, Continuation<? super CheckpointResolution> continuation) {
        C71491 c71491;
        PurchasesException purchasesException;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl;
        PurchasesException e;
        UiConfig uiConfig2;
        if (continuation instanceof C71491) {
            c71491 = (C71491) continuation;
            if ((c71491.label & Integer.MIN_VALUE) != 0) {
                c71491.label -= Integer.MIN_VALUE;
            } else {
                c71491 = new C71491(continuation);
            }
        }
        C71491 c714912 = c71491;
        Object workflowBody = c714912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c714912.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(workflowBody);
                try {
                    String workflowId = checkpointRule.getWorkflowId();
                    c714912.L$0 = this;
                    c714912.L$1 = str;
                    c714912.L$2 = workflowManager;
                    c714912.L$3 = checkpointRule;
                    c714912.L$4 = uiConfig;
                    c714912.label = 1;
                    workflowBody = workflowManager.getWorkflowBody(workflowId, c714912);
                    if (workflowBody != coroutine_suspended) {
                        checkpointWorkflowResolverImpl = this;
                    }
                    return coroutine_suspended;
                } catch (PurchasesException e2) {
                    purchasesException = e2;
                    checkpointWorkflowResolverImpl = this;
                    return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "it could not be loaded: " + purchasesException.getError());
                }
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(workflowBody);
                    return workflowBody;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(workflowBody);
                return workflowBody;
            }
            uiConfig = (UiConfig) c714912.L$4;
            checkpointRule = (CheckpointRule) c714912.L$3;
            workflowManager = (WorkflowManager) c714912.L$2;
            str = (String) c714912.L$1;
            checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c714912.L$0;
            try {
                ResultKt.throwOnFailure(workflowBody);
            } catch (PurchasesException e3) {
                e = e3;
                purchasesException = e;
                return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "it could not be loaded: " + purchasesException.getError());
            }
            PublishedWorkflow publishedWorkflow = (PublishedWorkflow) workflowBody;
            WorkflowStep workflowStep = publishedWorkflow.getSteps().get(publishedWorkflow.getInitialStepId());
            if (workflowStep == null) {
                return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "its initial step was not found");
            }
            if (Intrinsics.areEqual(workflowStep.getType(), "offering")) {
                if (publishedWorkflow.getSteps().size() != 1) {
                    return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "an offering step cannot be mixed with other steps");
                }
                c714912.L$0 = null;
                c714912.L$1 = null;
                c714912.L$2 = null;
                c714912.L$3 = null;
                c714912.L$4 = null;
                c714912.label = 2;
                Object objResolveOfferingRule = checkpointWorkflowResolverImpl.resolveOfferingRule(str, checkpointRule, workflowStep, c714912);
                if (objResolveOfferingRule != coroutine_suspended) {
                    return objResolveOfferingRule;
                }
            } else {
                Collection<WorkflowStep> collectionValues = publishedWorkflow.getSteps().values();
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((WorkflowStep) it.next()).getType(), "offering")) {
                            return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "a UI workflow cannot contain offering steps");
                        }
                    }
                }
                c714912.L$0 = null;
                c714912.L$1 = null;
                c714912.L$2 = null;
                c714912.L$3 = null;
                c714912.L$4 = null;
                c714912.label = 3;
                Object objResolveUiRule = checkpointWorkflowResolverImpl.resolveUiRule(str, workflowManager, checkpointRule, publishedWorkflow, uiConfig2, c714912);
                if (objResolveUiRule != coroutine_suspended) {
                    return objResolveUiRule;
                }
            }
            return coroutine_suspended;
        } catch (PurchasesException e4) {
            e = e4;
            purchasesException = e;
            return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "it could not be loaded: " + purchasesException.getError());
        }
        uiConfig2 = uiConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveOfferingRule(String str, CheckpointRule checkpointRule, WorkflowStep workflowStep, Continuation<? super CheckpointResolution> continuation) {
        C71481 c71481;
        String content;
        String str2;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl;
        if (continuation instanceof C71481) {
            c71481 = (C71481) continuation;
            if ((c71481.label & Integer.MIN_VALUE) != 0) {
                c71481.label -= Integer.MIN_VALUE;
            } else {
                c71481 = new C71481(continuation);
            }
        }
        Object objLoadOffering = c71481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71481.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadOffering);
            JsonElement jsonElement = workflowStep.getParamValues().get(OFFERING_IDENTIFIER_PARAM);
            JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
            if (jsonPrimitive != null) {
                if (!jsonPrimitive.getIsString()) {
                    jsonPrimitive = null;
                }
                if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null) {
                    if (StringsKt.isBlank(content)) {
                        content = null;
                    }
                    if (content != null) {
                        c71481.L$0 = this;
                        c71481.L$1 = checkpointRule;
                        c71481.L$2 = content;
                        c71481.label = 1;
                        objLoadOffering = loadOffering(str, content, c71481);
                        if (objLoadOffering == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str2 = content;
                        checkpointWorkflowResolverImpl = this;
                    }
                }
            }
            return unservableRule(checkpointRule, "the offering step has no valid offering identifier");
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str2 = (String) c71481.L$2;
        checkpointRule = (CheckpointRule) c71481.L$1;
        checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c71481.L$0;
        ResultKt.throwOnFailure(objLoadOffering);
        Offering offering = (Offering) objLoadOffering;
        if (offering == null) {
            return checkpointWorkflowResolverImpl.unservableRule(checkpointRule, "offering '" + str2 + "' was not found in offerings");
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Checkpoint resolved to offering '" + offering.getIdentifier() + "' from workflow '" + checkpointRule.getWorkflowId() + '\'');
        }
        return new CheckpointResolution.MatchedOffering(offering);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveUiRule(String str, WorkflowManager workflowManager, CheckpointRule checkpointRule, PublishedWorkflow publishedWorkflow, UiConfig uiConfig, Continuation<? super CheckpointResolution> continuation) {
        C71501 c71501;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl;
        String str2;
        String str3;
        CheckpointRule checkpointRule2;
        PublishedWorkflow publishedWorkflow2;
        UiConfig uiConfig2;
        WorkflowManager workflowManager2;
        CheckpointWorkflowResolverImpl checkpointWorkflowResolverImpl2;
        Offering offering;
        if (continuation instanceof C71501) {
            c71501 = (C71501) continuation;
            if ((c71501.label & Integer.MIN_VALUE) != 0) {
                c71501.label -= Integer.MIN_VALUE;
            } else {
                c71501 = new C71501(continuation);
            }
        }
        Object objOfferingIdByWorkflowId = c71501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71501.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objOfferingIdByWorkflowId);
                try {
                    c71501.L$0 = this;
                    c71501.L$1 = str;
                    c71501.L$2 = workflowManager;
                    c71501.L$3 = checkpointRule;
                    c71501.L$4 = publishedWorkflow;
                    c71501.L$5 = uiConfig;
                    c71501.label = 1;
                    objOfferingIdByWorkflowId = workflowManager.offeringIdByWorkflowId(c71501);
                    if (objOfferingIdByWorkflowId != coroutine_suspended) {
                        checkpointWorkflowResolverImpl = this;
                    }
                } catch (Exception e) {
                    e = e;
                    checkpointWorkflowResolverImpl = this;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Workflow offering metadata could not be fetched for checkpoint '" + str + "'.", e);
                    str2 = null;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str3 = (String) c71501.L$5;
                uiConfig2 = (UiConfig) c71501.L$4;
                publishedWorkflow2 = (PublishedWorkflow) c71501.L$3;
                checkpointRule2 = (CheckpointRule) c71501.L$2;
                workflowManager2 = (WorkflowManager) c71501.L$1;
                checkpointWorkflowResolverImpl2 = (CheckpointWorkflowResolverImpl) c71501.L$0;
                ResultKt.throwOnFailure(objOfferingIdByWorkflowId);
                offering = (Offering) objOfferingIdByWorkflowId;
                if (offering != null) {
                    return checkpointWorkflowResolverImpl2.unservableRule(checkpointRule2, "offering '" + str3 + "' was not found in offerings");
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Checkpoint resolved to workflow '" + checkpointRule2.getWorkflowId() + "' (offering: " + offering.getIdentifier() + ')');
                }
                workflowManager2.prewarmWorkflowAssets(publishedWorkflow2, uiConfig2);
                return new CheckpointResolution.MatchedWorkflow(publishedWorkflow2, uiConfig2, offering);
            }
            uiConfig = (UiConfig) c71501.L$5;
            publishedWorkflow = (PublishedWorkflow) c71501.L$4;
            checkpointRule = (CheckpointRule) c71501.L$3;
            workflowManager = (WorkflowManager) c71501.L$2;
            str = (String) c71501.L$1;
            checkpointWorkflowResolverImpl = (CheckpointWorkflowResolverImpl) c71501.L$0;
            try {
                ResultKt.throwOnFailure(objOfferingIdByWorkflowId);
            } catch (Exception e2) {
                e = e2;
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Workflow offering metadata could not be fetched for checkpoint '" + str + "'.", e);
                str2 = null;
            }
            str2 = (String) ((Map) objOfferingIdByWorkflowId).get(checkpointRule.getWorkflowId());
            WorkflowManager workflowManager3 = workflowManager;
            String str4 = str;
            str3 = str2;
            PublishedWorkflow publishedWorkflow3 = publishedWorkflow;
            checkpointRule2 = checkpointRule;
            publishedWorkflow2 = publishedWorkflow3;
            if (str3 == null) {
                return checkpointWorkflowResolverImpl.unservableRule(checkpointRule2, "no offering is mapped to it in the workflows topic");
            }
            c71501.L$0 = checkpointWorkflowResolverImpl;
            c71501.L$1 = workflowManager3;
            c71501.L$2 = checkpointRule2;
            c71501.L$3 = publishedWorkflow2;
            c71501.L$4 = uiConfig;
            c71501.L$5 = str3;
            c71501.label = 2;
            Object objLoadOffering = checkpointWorkflowResolverImpl.loadOffering(str4, str3, c71501);
            if (objLoadOffering != coroutine_suspended) {
                objOfferingIdByWorkflowId = objLoadOffering;
                uiConfig2 = uiConfig;
                workflowManager2 = workflowManager3;
                checkpointWorkflowResolverImpl2 = checkpointWorkflowResolverImpl;
                offering = (Offering) objOfferingIdByWorkflowId;
                if (offering != null) {
                }
            }
            return coroutine_suspended;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadOffering(String str, String str2, Continuation<? super Offering> continuation) {
        C71461 c71461;
        if (continuation instanceof C71461) {
            c71461 = (C71461) continuation;
            if ((c71461.label & Integer.MIN_VALUE) != 0) {
                c71461.label -= Integer.MIN_VALUE;
            } else {
                c71461 = new C71461(continuation);
            }
        }
        Object objInvoke = c71461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71461.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function1<Continuation<? super Offerings>, Object> function1 = this.getOfferings;
                c71461.L$0 = str;
                c71461.L$1 = str2;
                c71461.label = 1;
                objInvoke = function1.invoke(c71461);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) c71461.L$1;
                str = (String) c71461.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            return ((Offerings) objInvoke).getAll().get(str2);
        } catch (PurchasesException e) {
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Offerings could not be fetched for checkpoint '" + str + "': " + e.getError(), null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolverImpl$AudienceUnavailableException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", Keys.IDENTIFIER, "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class AudienceUnavailableException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudienceUnavailableException(String identifier) {
            super("audience '" + identifier + "' could not be read");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
        }
    }

    /* JADX INFO: compiled from: CheckpointWorkflowResolverImpl.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointWorkflowResolverImpl$Companion;", "", "()V", "OFFERING_IDENTIFIER_PARAM", "", "OFFERING_STEP_TYPE", "SIMULATED_ERROR_CHECKPOINT_ID", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final CheckpointResolution.NoAction unservableRule(CheckpointRule rule, String reason) {
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "The matched checkpoint rule for workflow '" + rule.getWorkflowId() + "' can't be served: " + reason + '.');
        }
        return new CheckpointResolution.NoAction(CheckpointResolution.NoAction.Reason.CONFIGURATION_UNAVAILABLE);
    }

    private final CheckpointResolution.NoAction configurationUnavailable(String message) {
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", message, null);
        return new CheckpointResolution.NoAction(CheckpointResolution.NoAction.Reason.CONFIGURATION_UNAVAILABLE);
    }

    private final CheckpointResolution.NoAction unknownCheckpoint(String identifier) {
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Checkpoint '" + identifier + "' is not configured in the dashboard.", null);
        return new CheckpointResolution.NoAction(CheckpointResolution.NoAction.Reason.UNKNOWN_CHECKPOINT);
    }

    private final CheckpointResolution.NoAction noMatch(String identifier) {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "No rule for checkpoint '" + identifier + "' matched.");
        }
        return new CheckpointResolution.NoAction(CheckpointResolution.NoAction.Reason.NO_MATCH);
    }
}
