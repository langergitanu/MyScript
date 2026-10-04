package com.myscript.nebo.freemium;

import com.android.billingclient.api.BillingResult;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.log.TechnicalLogger;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.survicate.surveys.TextRecallingManager;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: InAppPurchaseController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.freemium.InAppPurchaseController$connect$1$onBillingSetupFinished$1", m1609f = "InAppPurchaseController.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_7_4}, m1612m = "invokeSuspend", m1613n = {"needRetry", "maxTries", "currentTry", "delayFactor", "delay"}, m1614nl = {176}, m1615s = {"I$0", "I$1", "I$2", "I$3", "J$0"}, m1616v = 2)
final class InAppPurchaseController$connect$1$onBillingSetupFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingResult $billingResult;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    int label;
    final /* synthetic */ InAppPurchaseController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppPurchaseController$connect$1$onBillingSetupFinished$1(InAppPurchaseController inAppPurchaseController, BillingResult billingResult, Continuation<? super InAppPurchaseController$connect$1$onBillingSetupFinished$1> continuation) {
        super(2, continuation);
        this.this$0 = inAppPurchaseController;
        this.$billingResult = billingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppPurchaseController$connect$1$onBillingSetupFinished$1(this.this$0, this.$billingResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppPurchaseController$connect$1$onBillingSetupFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:19:0x0075, B:15:0x0047], limit reached: 41 */
    /* JADX WARN: Path cross not found for [B:19:0x0075, B:16:0x0049], limit reached: 41 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a A[LOOP:0: B:21:0x0084->B:23:0x008a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00df -> B:36:0x00fd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00fc -> B:36:0x00fd). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        Iterator it;
        TechnicalLogger technicalLogger;
        Integer[] numArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        char c = 2;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            j = 1000;
            i = 2;
            i2 = 5;
            i3 = 1;
            this.this$0.isBillingClientConnected = this.$billingResult.getResponseCode() != 0;
            if (!this.this$0.getIsBillingClientConnected()) {
                numArr = new Integer[3];
                numArr[0] = Boxing.boxInt(3);
                numArr[1] = Boxing.boxInt(5);
                numArr[c] = Boxing.boxInt(-2);
                if (SetsKt.setOf((Object[]) numArr).contains(Boxing.boxInt(this.$billingResult.getResponseCode()))) {
                }
                Set set = this.this$0.purchaseControllerStateListeners;
                InAppPurchaseController inAppPurchaseController = this.this$0;
                it = set.iterator();
                while (it.hasNext()) {
                }
                if (this.this$0.getIsBillingClientConnected()) {
                }
                if (i4 != 0) {
                }
                if (i4 != 0) {
                }
            }
            i4 = 0;
            Set set2 = this.this$0.purchaseControllerStateListeners;
            InAppPurchaseController inAppPurchaseController2 = this.this$0;
            it = set2.iterator();
            while (it.hasNext()) {
            }
            if (this.this$0.getIsBillingClientConnected()) {
            }
            if (i4 != 0) {
            }
            if (i4 != 0) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            i = this.I$3;
            i3 = this.I$2;
            i2 = this.I$1;
            i4 = this.I$0;
            ResultKt.throwOnFailure(obj);
            if (i4 != 0) {
                c = 2;
                this.this$0.isBillingClientConnected = this.$billingResult.getResponseCode() != 0;
                if (!this.this$0.getIsBillingClientConnected() && i3 <= i2) {
                    numArr = new Integer[3];
                    numArr[0] = Boxing.boxInt(3);
                    numArr[1] = Boxing.boxInt(5);
                    numArr[c] = Boxing.boxInt(-2);
                    if (SetsKt.setOf((Object[]) numArr).contains(Boxing.boxInt(this.$billingResult.getResponseCode()))) {
                        i4 = 1;
                    }
                    Set set22 = this.this$0.purchaseControllerStateListeners;
                    InAppPurchaseController inAppPurchaseController22 = this.this$0;
                    it = set22.iterator();
                    while (it.hasNext()) {
                        ((PurchaseController.StateListener) it.next()).onPurchaseControllerStateChanged(inAppPurchaseController22.getIsBillingClientConnected());
                    }
                    if (this.this$0.getIsBillingClientConnected()) {
                        this.this$0.fetchPreviousPurchasesState();
                    } else if (i3 == i2 && (technicalLogger = this.this$0.logger) != null) {
                        technicalLogger.logError(new IllegalStateException("Error while connecting to Billing service " + this.$billingResult.getResponseCode() + TextRecallingManager.ANSWER_SEPARATOR + this.$billingResult.getDebugMessage()));
                    }
                    if (i4 != 0) {
                        int i6 = i3 + 1;
                        this.I$0 = i4;
                        this.I$1 = i2;
                        this.I$2 = i6;
                        this.I$3 = i;
                        this.J$0 = j;
                        this.label = 1;
                        if (DelayKt.delay(((long) (i3 * i)) * j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i6;
                    }
                    if (i4 != 0) {
                    }
                }
                i4 = 0;
                Set set222 = this.this$0.purchaseControllerStateListeners;
                InAppPurchaseController inAppPurchaseController222 = this.this$0;
                it = set222.iterator();
                while (it.hasNext()) {
                }
                if (this.this$0.getIsBillingClientConnected()) {
                }
                if (i4 != 0) {
                }
                if (i4 != 0) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
