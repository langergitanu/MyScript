package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallKt;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointPaywallOutcome;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointWorkflowActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointWorkflowActivity;", "Landroidx/activity/ComponentActivity;", "()V", "callId", "", "manager", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager;", "outcomeListener", "com/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointWorkflowActivity$outcomeListener$1", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointWorkflowActivity$outcomeListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "recordOutcome", "outcome", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointWorkflowActivity extends ComponentActivity {
    public static final String EXTRA_CALL_ID = "checkpoint_call_id";
    private String callId;
    private CheckpointsManager manager;
    private final CheckpointWorkflowActivity$outcomeListener$1 outcomeListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointWorkflowActivity$outcomeListener$1
        @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
        public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
            this.this$0.recordOutcome(new CheckpointPaywallOutcome.Purchased(customerInfo, storeTransaction));
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
        public void onRestoreCompleted(CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            this.this$0.recordOutcome(new CheckpointPaywallOutcome.Restored(customerInfo));
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
        public void onPurchaseError(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
                this.this$0.recordOutcome(new CheckpointPaywallOutcome.Error(error));
            }
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
        public void onRestoreError(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.this$0.recordOutcome(new CheckpointPaywallOutcome.Error(error));
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallListener
        public void onWebCheckoutOpened() {
            this.this$0.recordOutcome(CheckpointPaywallOutcome.WebCheckoutOpened.INSTANCE);
        }
    };
    public static final int $stable = 8;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(EXTRA_CALL_ID);
        this.callId = stringExtra;
        CheckpointsManager checkpointsManager = Purchases.INSTANCE.isConfigured() ? CheckpointsExtensionsKt.getCheckpointsManager(Purchases.INSTANCE.getSharedInstance()) : null;
        this.manager = checkpointsManager;
        CheckpointPresentation checkpointPresentationPresentation = (stringExtra == null || checkpointsManager == null) ? null : checkpointsManager.presentation(stringExtra);
        if (stringExtra == null || checkpointsManager == null || checkpointPresentationPresentation == null) {
            Logger.INSTANCE.m1587w("Checkpoint call '" + stringExtra + "' no longer exists. Closing the checkpoint workflow.");
            finish();
        } else {
            checkpointsManager.onPresentationStarted(stringExtra, this);
            CheckpointResolution.MatchedWorkflow resolution = checkpointPresentationPresentation.getResolution();
            final PaywallOptions paywallOptionsBuild = new PaywallOptions.Builder(new CheckpointWorkflowActivity$onCreate$options$1(this)).injectedWorkflow(resolution.getWorkflow(), resolution.getOffering(), resolution.getUiConfig()).setCustomVariables(checkpointPresentationPresentation.getCustomVariables()).setListener(this.outcomeListener).build();
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1061187392, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointWorkflowActivity.onCreate.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C57@2723L16:CheckpointWorkflowActivity.kt#pm83j2");
                    if ((i & 3) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1061187392, i, -1, "com.revenuecat.purchases.ui.revenuecatui.checkpoints.CheckpointWorkflowActivity.onCreate.<anonymous> (CheckpointWorkflowActivity.kt:57)");
                    }
                    PaywallKt.Paywall(paywallOptionsBuild, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 1, null);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        CheckpointsManager checkpointsManager;
        String str = this.callId;
        if (str != null && (checkpointsManager = this.manager) != null) {
            checkpointsManager.onActivityDestroyed(str, isChangingConfigurations());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordOutcome(CheckpointPaywallOutcome outcome) {
        CheckpointsManager checkpointsManager;
        String str = this.callId;
        if (str == null || (checkpointsManager = this.manager) == null) {
            return;
        }
        checkpointsManager.recordOutcome(str, outcome);
    }
}
