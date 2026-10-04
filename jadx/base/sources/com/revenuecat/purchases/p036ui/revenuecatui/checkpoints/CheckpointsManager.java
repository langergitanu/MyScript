package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import android.app.Activity;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointParams;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointPaywallOutcome;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CheckpointsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ2\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020$0#H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0016\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u001fJ\u0012\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J1\u00100\u001a\u0004\u0018\u0001H1\"\u0004\b\u0000\u001012\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H103H\u0002¢\u0006\u0002\u00104R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager;", "", "()V", "<set-?>", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;", "checkpointListener", "getCheckpointListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;", "setCheckpointListener", "(Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;)V", "pendingCall", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager$PendingCall;", "abandon", "", "callId", "", "checkpoint", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "purchases", "Lcom/revenuecat/purchases/Purchases;", Keys.IDENTIFIER, "params", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityDestroyed", "isChangingConfigurations", "", "onPresentationStarted", "activity", "Landroid/app/Activity;", "present", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "resolution", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentation", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPresentation;", "presentationError", "", "code", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "message", "recordOutcome", "outcome", "take", "withPendingCall", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "PendingCall", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointsManager {
    public static final int $stable = 8;
    private CheckpointListener checkpointListener;
    private PendingCall pendingCall;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager$present$1 */
    /* JADX INFO: compiled from: CheckpointsManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager", m1609f = "CheckpointsManager.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA1_4_1}, m1612m = "present", m1613n = {"this", NotificationCompat.CATEGORY_CALL}, m1615s = {"L$0", "L$1"})
    static final class C75051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C75051(Continuation<? super C75051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckpointsManager.this.present(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: CheckpointsManager.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager$PendingCall;", "", "callId", "", "resolution", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "paywallFinished", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "(Ljava/lang/String;Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;Ljava/util/Map;Lkotlinx/coroutines/CompletableDeferred;)V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/WeakReference;", "setActivity", "(Ljava/lang/ref/WeakReference;)V", "getCallId", "()Ljava/lang/String;", "getCustomVariables", "()Ljava/util/Map;", "outcome", "getOutcome", "()Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "setOutcome", "(Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;)V", "getPaywallFinished", "()Lkotlinx/coroutines/CompletableDeferred;", "getResolution", "()Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class PendingCall {
        private WeakReference<Activity> activity;
        private final String callId;
        private final Map<String, CustomVariableValue> customVariables;
        private CheckpointPaywallOutcome outcome;
        private final CompletableDeferred<CheckpointPaywallOutcome> paywallFinished;
        private final CheckpointResolution.MatchedWorkflow resolution;

        /* JADX WARN: Multi-variable type inference failed */
        public PendingCall(String callId, CheckpointResolution.MatchedWorkflow resolution, Map<String, ? extends CustomVariableValue> customVariables, CompletableDeferred<CheckpointPaywallOutcome> paywallFinished) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(resolution, "resolution");
            Intrinsics.checkNotNullParameter(customVariables, "customVariables");
            Intrinsics.checkNotNullParameter(paywallFinished, "paywallFinished");
            this.callId = callId;
            this.resolution = resolution;
            this.customVariables = customVariables;
            this.paywallFinished = paywallFinished;
            this.outcome = CheckpointPaywallOutcome.Dismissed.INSTANCE;
        }

        public final String getCallId() {
            return this.callId;
        }

        public final CheckpointResolution.MatchedWorkflow getResolution() {
            return this.resolution;
        }

        public final Map<String, CustomVariableValue> getCustomVariables() {
            return this.customVariables;
        }

        public final CompletableDeferred<CheckpointPaywallOutcome> getPaywallFinished() {
            return this.paywallFinished;
        }

        public final CheckpointPaywallOutcome getOutcome() {
            return this.outcome;
        }

        public final void setOutcome(CheckpointPaywallOutcome checkpointPaywallOutcome) {
            Intrinsics.checkNotNullParameter(checkpointPaywallOutcome, "<set-?>");
            this.outcome = checkpointPaywallOutcome;
        }

        public final WeakReference<Activity> getActivity() {
            return this.activity;
        }

        public final void setActivity(WeakReference<Activity> weakReference) {
            this.activity = weakReference;
        }
    }

    public final synchronized CheckpointListener getCheckpointListener() {
        return this.checkpointListener;
    }

    public final synchronized void setCheckpointListener(CheckpointListener checkpointListener) {
        this.checkpointListener = checkpointListener;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager$checkpoint$2 */
    /* JADX INFO: compiled from: CheckpointsManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager$checkpoint$2", m1609f = "CheckpointsManager.kt", m1610i = {0, 1}, m1611l = {82, TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m1612m = "invokeSuspend", m1613n = {"customVariables", "customVariables"}, m1615s = {"L$0", "L$0"})
    static final class C75032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckpointResult>, Object> {
        final /* synthetic */ String $identifier;
        final /* synthetic */ CheckpointParams $params;
        final /* synthetic */ Purchases $purchases;
        Object L$0;
        int label;
        final /* synthetic */ CheckpointsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C75032(CheckpointParams checkpointParams, CheckpointsManager checkpointsManager, String str, Purchases purchases, Continuation<? super C75032> continuation) {
            super(2, continuation);
            this.$params = checkpointParams;
            this.this$0 = checkpointsManager;
            this.$identifier = str;
            this.$purchases = purchases;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75032(this.$params, this.this$0, this.$identifier, this.$purchases, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CheckpointResult> continuation) {
            return ((C75032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0124  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws PurchasesException {
            Map<String, CustomVariableValue> map;
            CheckpointResult.NoAction noAction;
            Map<String, CustomVariableValue> map2;
            CheckpointListener checkpointListener;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CheckpointParams CheckpointParams = this.$params;
                if (CheckpointParams == null) {
                    CheckpointParams = CheckpointParamsKt.CheckpointParams(new Function1<CheckpointParams.Builder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager$checkpoint$2$customVariables$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CheckpointParams.Builder CheckpointParams2) {
                            Intrinsics.checkNotNullParameter(CheckpointParams2, "$this$CheckpointParams");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CheckpointParams.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }
                    });
                }
                Map<String, CustomVariableValue> customVariables = CheckpointParams.getCustomVariables();
                CheckpointListener checkpointListener2 = this.this$0.getCheckpointListener();
                if (checkpointListener2 != null) {
                    checkpointListener2.onCheckpointHit(new CheckpointHitContext(this.$identifier, customVariables));
                }
                if (!CheckpointIdentifierValidator.INSTANCE.isValid(this.$identifier)) {
                    Logger.INSTANCE.m1584e(CheckpointIdentifierValidator.INSTANCE.invalidIdentifierLogMessage(this.$identifier));
                    CheckpointResult.NoAction noAction2 = new CheckpointResult.NoAction(CheckpointResult.NoAction.Reason.INVALID_CHECKPOINT_IDENTIFIER);
                    CheckpointListener checkpointListener3 = this.this$0.getCheckpointListener();
                    if (checkpointListener3 != null) {
                        checkpointListener3.onCheckpointCompleted(new CheckpointCompletedContext(this.$identifier, customVariables, noAction2));
                    }
                    return noAction2;
                }
                Purchases purchases = this.$purchases;
                String str = this.$identifier;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(customVariables.size()));
                Iterator<T> it = customVariables.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), CheckpointParamsKt.getAsRulesDimensionValue((CustomVariableValue) entry.getValue()));
                }
                this.L$0 = customVariables;
                this.label = 1;
                Object objResolveCheckpoint = purchases.resolveCheckpoint(str, linkedHashMap, this);
                if (objResolveCheckpoint != coroutine_suspended) {
                    map = customVariables;
                    obj = objResolveCheckpoint;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map2 = (Map) this.L$0;
                ResultKt.throwOnFailure(obj);
                map = map2;
                noAction = new CheckpointResult.PaywallPresented((CheckpointPaywallOutcome) obj);
                checkpointListener = this.this$0.getCheckpointListener();
                if (checkpointListener != null) {
                    checkpointListener.onCheckpointCompleted(new CheckpointCompletedContext(this.$identifier, map, noAction));
                }
                return noAction;
            }
            map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            CheckpointResolution checkpointResolution = (CheckpointResolution) obj;
            if (checkpointResolution instanceof CheckpointResolution.MatchedOffering) {
                noAction = new CheckpointResult.ReceivedOffering(((CheckpointResolution.MatchedOffering) checkpointResolution).getOffering());
            } else {
                if (checkpointResolution instanceof CheckpointResolution.MatchedWorkflow) {
                    this.L$0 = map;
                    this.label = 2;
                    obj = this.this$0.present(this.$purchases, (CheckpointResolution.MatchedWorkflow) checkpointResolution, map, this);
                    if (obj != coroutine_suspended) {
                        map2 = map;
                        map = map2;
                        noAction = new CheckpointResult.PaywallPresented((CheckpointPaywallOutcome) obj);
                    }
                    return coroutine_suspended;
                }
                if (checkpointResolution instanceof CheckpointResolution.NoAction) {
                    noAction = new CheckpointResult.NoAction(CheckpointsManagerKt.toResultReason(((CheckpointResolution.NoAction) checkpointResolution).getReason()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            checkpointListener = this.this$0.getCheckpointListener();
            if (checkpointListener != null) {
            }
            return noAction;
        }
    }

    public final Object checkpoint(Purchases purchases, String str, CheckpointParams checkpointParams, Continuation<? super CheckpointResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C75032(checkpointParams, this, str, purchases, null), continuation);
    }

    public final CheckpointPresentation presentation(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        return (CheckpointPresentation) withPendingCall(callId, new Function1<PendingCall, CheckpointPresentation>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager.presentation.1
            @Override // kotlin.jvm.functions.Function1
            public final CheckpointPresentation invoke(PendingCall it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new CheckpointPresentation(it.getResolution(), it.getCustomVariables());
            }
        });
    }

    public final void onPresentationStarted(String callId, final Activity activity) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        withPendingCall(callId, new Function1<PendingCall, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager.onPresentationStarted.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PendingCall pendingCall) {
                invoke2(pendingCall);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PendingCall it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setActivity(new WeakReference<>(activity));
            }
        });
    }

    public final void recordOutcome(String callId, final CheckpointPaywallOutcome outcome) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        withPendingCall(callId, new Function1<PendingCall, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager.recordOutcome.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PendingCall pendingCall) {
                invoke2(pendingCall);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PendingCall it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setOutcome(outcome);
            }
        });
    }

    public final void onActivityDestroyed(String callId, boolean isChangingConfigurations) {
        PendingCall pendingCallTake;
        Intrinsics.checkNotNullParameter(callId, "callId");
        if (isChangingConfigurations || (pendingCallTake = take(callId)) == null) {
            return;
        }
        pendingCallTake.getPaywallFinished().complete(pendingCallTake.getOutcome());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object present(Purchases purchases, CheckpointResolution.MatchedWorkflow matchedWorkflow, Map<String, ? extends CustomVariableValue> map, Continuation<? super CheckpointPaywallOutcome> continuation) throws PurchasesException {
        C75051 c75051;
        boolean z;
        CheckpointsManager checkpointsManager;
        PendingCall pendingCall;
        if (continuation instanceof C75051) {
            c75051 = (C75051) continuation;
            if ((c75051.label & Integer.MIN_VALUE) != 0) {
                c75051.label -= Integer.MIN_VALUE;
            } else {
                c75051 = new C75051(continuation);
            }
        }
        Object obj = c75051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c75051.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pendingCall = (PendingCall) c75051.L$1;
            checkpointsManager = (CheckpointsManager) c75051.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (CancellationException e) {
                e = e;
                checkpointsManager.abandon(pendingCall.getCallId());
                throw e;
            } catch (Exception e2) {
                e = e2;
                checkpointsManager.abandon(pendingCall.getCallId());
                checkpointsManager.presentationError(PurchasesErrorCode.ConfigurationError, "Failed to present checkpoint workflow: " + e);
                throw new KotlinNothingValueException();
            }
        }
        ResultKt.throwOnFailure(obj);
        Activity currentActivity = purchases.getCurrentActivity();
        if (currentActivity == null) {
            presentationError(PurchasesErrorCode.ConfigurationError, "Cannot present checkpoint workflow: no started Activity found.");
            throw new KotlinNothingValueException();
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        PendingCall pendingCall2 = new PendingCall(string, matchedWorkflow, map, CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        synchronized (this) {
            z = this.pendingCall == null;
            if (z) {
                this.pendingCall = pendingCall2;
            }
        }
        if (!z) {
            presentationError(PurchasesErrorCode.OperationAlreadyInProgressError, "Another checkpoint workflow is already being presented.");
            throw new KotlinNothingValueException();
        }
        try {
            currentActivity.startActivity(new Intent(currentActivity, (Class<?>) CheckpointWorkflowActivity.class).putExtra(CheckpointWorkflowActivity.EXTRA_CALL_ID, pendingCall2.getCallId()));
            CompletableDeferred<CheckpointPaywallOutcome> paywallFinished = pendingCall2.getPaywallFinished();
            c75051.L$0 = this;
            c75051.L$1 = pendingCall2;
            c75051.label = 1;
            Object objAwait = paywallFinished.await(c75051);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        } catch (CancellationException e3) {
            e = e3;
            checkpointsManager = this;
            pendingCall = pendingCall2;
            checkpointsManager.abandon(pendingCall.getCallId());
            throw e;
        } catch (Exception e4) {
            e = e4;
            checkpointsManager = this;
            pendingCall = pendingCall2;
            checkpointsManager.abandon(pendingCall.getCallId());
            checkpointsManager.presentationError(PurchasesErrorCode.ConfigurationError, "Failed to present checkpoint workflow: " + e);
            throw new KotlinNothingValueException();
        }
    }

    private final void abandon(String callId) {
        WeakReference<Activity> activity;
        Activity activity2;
        PendingCall pendingCallTake = take(callId);
        if (pendingCallTake == null || (activity = pendingCallTake.getActivity()) == null || (activity2 = activity.get()) == null) {
            return;
        }
        activity2.finish();
    }

    private final PendingCall take(String callId) {
        return (PendingCall) withPendingCall(callId, new Function1<PendingCall, PendingCall>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointsManager.take.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PendingCall invoke(PendingCall it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CheckpointsManager.this.pendingCall = null;
                return it;
            }
        });
    }

    private final <T> T withPendingCall(String callId, Function1<? super PendingCall, ? extends T> block) {
        T tInvoke;
        synchronized (this) {
            PendingCall pendingCall = this.pendingCall;
            tInvoke = null;
            if (pendingCall != null) {
                if (!Intrinsics.areEqual(pendingCall.getCallId(), callId)) {
                    pendingCall = null;
                }
                if (pendingCall != null) {
                    tInvoke = block.invoke(pendingCall);
                }
            }
        }
        return tInvoke;
    }

    private final Void presentationError(PurchasesErrorCode code, String message) throws PurchasesException {
        PurchasesError purchasesError = new PurchasesError(code, message);
        Logger.INSTANCE.m1584e(purchasesError.toString());
        throw new PurchasesException(purchasesError);
    }
}
