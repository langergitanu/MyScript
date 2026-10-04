package com.revenuecat.purchases.p036ui.revenuecatui.data.testdata;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.p036ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPaywallUiState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TestData.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 «\u00012\u00020\u00012\u00020\u0002:\u0002«\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010x\u001a\u00020yH\u0082@¢\u0006\u0002\u0010zJ\b\u0010{\u001a\u00020yH\u0016J\u0012\u0010|\u001a\u00020y2\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J\u0013\u0010\u007f\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0080\u0001\u001a\u00020&H\u0016J\t\u0010\u0081\u0001\u001a\u00020\nH\u0016J0\u0010\u0082\u0001\u001a\u00020y2\u0007\u0010\u0083\u0001\u001a\u0002042\t\u0010\u0084\u0001\u001a\u0004\u0018\u0001052\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0096@¢\u0006\u0003\u0010\u0087\u0001J\u000f\u0010\u0088\u0001\u001a\u00020yH\u0096@¢\u0006\u0002\u0010zJ\u001b\u0010\u0089\u0001\u001a\u00020y2\u0007\u0010\u008a\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0001\u001a\u00020<H\u0016J\t\u0010\u008c\u0001\u001a\u00020yH\u0016J\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0012\u0010\u008f\u0001\u001a\u00020y2\u0007\u0010\u0090\u0001\u001a\u00020\rH\u0016J\t\u0010\u0091\u0001\u001a\u00020yH\u0016J\t\u0010\u0092\u0001\u001a\u00020yH\u0016J\t\u0010\u0093\u0001\u001a\u00020yH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020y2\u0007\u0010\u0095\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u0096\u0001\u001a\u00020yH\u0016J\u0014\u0010\u0097\u0001\u001a\u00020y2\t\u0010\u0083\u0001\u001a\u0004\u0018\u000104H\u0016J\u001c\u0010\u0098\u0001\u001a\u00020y2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\nH\u0016J\t\u0010\u009c\u0001\u001a\u00020yH\u0016J\t\u0010\u009d\u0001\u001a\u00020yH\u0016J\u0012\u0010\u009e\u0001\u001a\u00020y2\u0007\u0010\u009f\u0001\u001a\u00020]H\u0016J\t\u0010 \u0001\u001a\u00020yH\u0002J\u0012\u0010¡\u0001\u001a\u00020y2\u0007\u0010¢\u0001\u001a\u00020gH\u0016J\u001b\u0010£\u0001\u001a\u00020y2\u0007\u0010¤\u0001\u001a\u00020k2\u0007\u0010¥\u0001\u001a\u00020\rH\u0016J\t\u0010¦\u0001\u001a\u00020yH\u0016J\u0014\u0010§\u0001\u001a\u00020y2\t\b\u0002\u0010¨\u0001\u001a\u00020\rH\u0002J\u0010\u0010©\u0001\u001a\u00020y2\u0007\u0010ª\u0001\u001a\u00020rR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R*\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020&0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u001a\u0010,\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 RF\u00106\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105030%2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u000105030%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u001e\u00108\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u001e\u0010:\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 RB\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020<030%2\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020<030%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u001e\u0010?\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010 R*\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u001e\u0010C\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010 R\u001e\u0010E\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010 R\u001e\u0010G\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010 R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0019R\u001e\u0010K\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010 R.\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0%2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010)R.\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040%2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010)R\u001e\u0010Q\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010 R\u001e\u0010S\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010 R\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010 R\u001e\u0010[\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010 R*\u0010^\u001a\b\u0012\u0004\u0012\u00020]0%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020]0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010)R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00150a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u001e\u0010d\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010 R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020g0%¢\u0006\b\n\u0000\u001a\u0004\bh\u0010)R\u001e\u0010i\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010 RB\u0010l\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\r030%2\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\r030%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010)R\u001e\u0010n\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010 R\u001e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010 R*\u0010s\u001a\b\u0012\u0004\u0012\u00020r0%2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020r0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bt\u0010)R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0019¨\u0006¬\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/MockViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "offering", "Lcom/revenuecat/purchases/Offering;", "validationWarning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "allowsPurchases", "", "shouldErrorOnUnsupportedMethods", "webCheckoutUrl", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;ZZLjava/lang/String;)V", "_actionError", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/PurchasesError;", "_actionInProgress", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "actionError", "Landroidx/compose/runtime/State;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "getActionInProgress", "<set-?>", "", "clearActionErrorCallCount", "getClearActionErrorCallCount", "()I", "closePaywallCallCount", "getClosePaywallCallCount", "getWebCheckoutUrlCallCount", "getGetWebCheckoutUrlCallCount", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "getWebCheckoutUrlParams", "getGetWebCheckoutUrlParams", "()Ljava/util/List;", "handleBackNavigationCallCount", "getHandleBackNavigationCallCount", "handleBackNavigationResult", "getHandleBackNavigationResult", "()Z", "setHandleBackNavigationResult", "(Z)V", "handlePackagePurchaseCount", "getHandlePackagePurchaseCount", "Lkotlin/Pair;", "Landroid/app/Activity;", "Lcom/revenuecat/purchases/Package;", "handlePackagePurchaseParams", "getHandlePackagePurchaseParams", "handleRestorePurchasesCallCount", "getHandleRestorePurchasesCallCount", "handleWorkflowActionCallCount", "getHandleWorkflowActionCallCount", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "handleWorkflowActionParams", "getHandleWorkflowActionParams", "invalidateCustomerInfoCacheCallCount", "getInvalidateCustomerInfoCacheCallCount", "notifyUrlOpenedParams", "getNotifyUrlOpenedParams", "notifyWebCheckoutOpenedCallCount", "getNotifyWebCheckoutOpenedCallCount", "onTransitionCompleteCallCount", "getOnTransitionCompleteCallCount", "preloadExitOfferingCallCount", "getPreloadExitOfferingCallCount", "purchaseCompleted", "getPurchaseCompleted", "purchaseSelectedPackageCallCount", "getPurchaseSelectedPackageCallCount", "purchaseSelectedPackageIdentifiers", "getPurchaseSelectedPackageIdentifiers", "purchaseSelectedPackageParams", "getPurchaseSelectedPackageParams", "refreshStateIfColorsChangedCallCount", "getRefreshStateIfColorsChangedCallCount", "refreshStateIfLocaleChangedCallCount", "getRefreshStateIfLocaleChangedCallCount", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "restorePurchasesCallCount", "getRestorePurchasesCallCount", "selectPackageCallCount", "getSelectPackageCallCount", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "selectPackageCallParams", "getSelectPackageCallParams", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "trackComponentInteractionCallCount", "getTrackComponentInteractionCallCount", "trackComponentInteractionParams", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "getTrackComponentInteractionParams", "trackExitOfferCallCount", "getTrackExitOfferCallCount", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "trackExitOfferParams", "getTrackExitOfferParams", "trackPaywallImpressionIfNeededCallCount", "getTrackPaywallImpressionIfNeededCallCount", "updateOptionsCallCount", "getUpdateOptionsCallCount", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "updateOptionsParams", "getUpdateOptionsParams", "workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "getWorkflowState", "awaitSimulateActionInProgress", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearActionError", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getWebCheckoutUrl", "launchWebCheckout", "handleBackNavigation", "handlePackagePurchase", "activity", "pkg", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "handleWorkflowAction", "componentId", "triggerType", "invalidateCustomerInfoCache", "loadedLegacyState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "notifyUrlOpened", ImagesContract.URL, "notifyWebCheckoutOpened", "onPaywallDismissed", "onPaywallPresented", "onTransitionComplete", "transitionId", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "simulateActionInProgress", "trackComponentInteraction", "data", "trackExitOffer", "exitOfferType", "exitOfferingIdentifier", "trackPaywallImpressionIfNeeded", "unsupportedMethod", "errorMessage", "updateOptions", "options", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class MockViewModel extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final long MILLIS_2025_01_25 = 1737763200000L;

    @Deprecated
    public static final long fakePurchaseDelayMillis = 2000;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<PaywallState> _state;
    private final boolean allowsPurchases;
    private int clearActionErrorCallCount;
    private int closePaywallCallCount;
    private int getWebCheckoutUrlCallCount;
    private List<PaywallAction.External.LaunchWebCheckout> getWebCheckoutUrlParams;
    private int handleBackNavigationCallCount;
    private boolean handleBackNavigationResult;
    private int handlePackagePurchaseCount;
    private List<Pair<Activity, Package>> handlePackagePurchaseParams;
    private int handleRestorePurchasesCallCount;
    private int handleWorkflowActionCallCount;
    private List<Pair<String, WorkflowTriggerType>> handleWorkflowActionParams;
    private int invalidateCustomerInfoCacheCallCount;
    private List<String> notifyUrlOpenedParams;
    private int notifyWebCheckoutOpenedCallCount;
    private int onTransitionCompleteCallCount;
    private int preloadExitOfferingCallCount;
    private final State<Boolean> purchaseCompleted;
    private int purchaseSelectedPackageCallCount;
    private List<String> purchaseSelectedPackageIdentifiers;
    private List<Activity> purchaseSelectedPackageParams;
    private int refreshStateIfColorsChangedCallCount;
    private int refreshStateIfLocaleChangedCallCount;
    private int restorePurchasesCallCount;
    private int selectPackageCallCount;
    private List<TemplateConfiguration.PackageInfo> selectPackageCallParams;
    private final boolean shouldErrorOnUnsupportedMethods;
    private int trackComponentInteractionCallCount;
    private final List<PaywallComponentInteractionData> trackComponentInteractionParams;
    private int trackExitOfferCallCount;
    private List<Pair<ExitOfferType, String>> trackExitOfferParams;
    private int trackPaywallImpressionIfNeededCallCount;
    private int updateOptionsCallCount;
    private List<PaywallOptions> updateOptionsParams;
    private final String webCheckoutUrl;
    private final State<WorkflowPaywallUiState> workflowState;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1 */
    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel", m1609f = "TestData.kt", m1610i = {0}, m1611l = {766}, m1612m = "awaitSimulateActionInProgress", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C81781 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C81781(Continuation<? super C81781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockViewModel.this.awaitSimulateActionInProgress(this);
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallDismissed() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onPaywallPresented() {
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ MockViewModel(com.revenuecat.purchases.p036ui.revenuecatui.PaywallMode r2, com.revenuecat.purchases.Offering r3, com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallWarning r4, boolean r5, boolean r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto La
            com.revenuecat.purchases.ui.revenuecatui.PaywallMode$Companion r2 = com.revenuecat.purchases.p036ui.revenuecatui.PaywallMode.INSTANCE
            com.revenuecat.purchases.ui.revenuecatui.PaywallMode r2 = r2.getDefault()
        La:
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = 0
        L15:
            r9 = r8 & 16
            if (r9 == 0) goto L1a
            r6 = 1
        L1a:
            r8 = r8 & 32
            if (r8 == 0) goto L26
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L26:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.MockViewModel.<init>(com.revenuecat.purchases.ui.revenuecatui.PaywallMode, com.revenuecat.purchases.Offering, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public MockViewModel(PaywallMode mode, Offering offering, PaywallWarning paywallWarning, boolean z, boolean z2, String str) {
        PaywallState.Loaded.Components componentsPaywallState$default;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.allowsPurchases = z;
        this.shouldErrorOnUnsupportedMethods = z2;
        this.webCheckoutUrl = str;
        this.purchaseCompleted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.workflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        PaywallValidationResult paywallValidationResultValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, TestData.Constants.INSTANCE.getCurrentColorScheme(), getResourceProvider());
        if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) paywallValidationResultValidatedPaywall;
            componentsPaywallState$default = OfferingToStateMapperKt.toLegacyPaywallState(offering, new VariableDataProvider(getResourceProvider(), false, 2, null), mode, legacy.getDisplayablePaywall(), legacy.getTemplate(), false, "US", paywallWarning);
        } else {
            if (!(paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Components)) {
                throw new NoWhenBranchMatchedException();
            }
            componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, (PaywallValidationResult.Components) paywallValidationResultValidatedPaywall, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$_state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
        }
        this._state = StateFlowKt.MutableStateFlow(componentsPaywallState$default);
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.trackExitOfferParams = new ArrayList();
        this.trackComponentInteractionParams = new ArrayList();
        this.selectPackageCallParams = new ArrayList();
        this.getWebCheckoutUrlParams = new ArrayList();
        this.notifyUrlOpenedParams = new ArrayList();
        this.purchaseSelectedPackageParams = new ArrayList();
        this.purchaseSelectedPackageIdentifiers = new ArrayList();
        this.handlePackagePurchaseParams = new ArrayList();
        this.handleWorkflowActionParams = new ArrayList();
        this.updateOptionsParams = new ArrayList();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return new MockResourceProvider(null, null, null, null, null, 31, null);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.asStateFlow(this._state);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this.purchaseCompleted;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public State<WorkflowPaywallUiState> getWorkflowState() {
        return this.workflowState;
    }

    public final PaywallState.Loaded.Legacy loadedLegacyState() {
        return PaywallStateKt.loadedLegacy(getState().getValue());
    }

    public final int getTrackPaywallImpressionIfNeededCallCount() {
        return this.trackPaywallImpressionIfNeededCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        this.trackPaywallImpressionIfNeededCallCount++;
    }

    public final int getTrackExitOfferCallCount() {
        return this.trackExitOfferCallCount;
    }

    public final List<Pair<ExitOfferType, String>> getTrackExitOfferParams() {
        return this.trackExitOfferParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        this.trackExitOfferCallCount++;
        this.trackExitOfferParams.add(new Pair<>(exitOfferType, exitOfferingIdentifier));
    }

    public final int getTrackComponentInteractionCallCount() {
        return this.trackComponentInteractionCallCount;
    }

    public final List<PaywallComponentInteractionData> getTrackComponentInteractionParams() {
        return this.trackComponentInteractionParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.trackComponentInteractionCallCount++;
        this.trackComponentInteractionParams.add(data);
    }

    public final int getRefreshStateIfLocaleChangedCallCount() {
        return this.refreshStateIfLocaleChangedCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        this.refreshStateIfLocaleChangedCallCount++;
    }

    public final int getRefreshStateIfColorsChangedCallCount() {
        return this.refreshStateIfColorsChangedCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.refreshStateIfColorsChangedCallCount++;
    }

    public final int getSelectPackageCallCount() {
        return this.selectPackageCallCount;
    }

    public final List<TemplateConfiguration.PackageInfo> getSelectPackageCallParams() {
        return this.selectPackageCallParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        this.selectPackageCallCount++;
        this.selectPackageCallParams.add(packageToSelect);
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        if (legacyLoadedLegacyState != null) {
            legacyLoadedLegacyState.selectPackage(packageToSelect);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            unsupportedMethod$default(this, null, 1, null);
        }
    }

    public final int getClosePaywallCallCount() {
        return this.closePaywallCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult result) {
        this.closePaywallCallCount++;
    }

    public final int getGetWebCheckoutUrlCallCount() {
        return this.getWebCheckoutUrlCallCount;
    }

    public final List<PaywallAction.External.LaunchWebCheckout> getGetWebCheckoutUrlParams() {
        return this.getWebCheckoutUrlParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        this.getWebCheckoutUrlCallCount++;
        this.getWebCheckoutUrlParams.add(launchWebCheckout);
        return this.webCheckoutUrl;
    }

    public final int getNotifyWebCheckoutOpenedCallCount() {
        return this.notifyWebCheckoutOpenedCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyWebCheckoutOpened() {
        this.notifyWebCheckoutOpenedCallCount++;
    }

    public final List<String> getNotifyUrlOpenedParams() {
        return this.notifyUrlOpenedParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void notifyUrlOpened(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.notifyUrlOpenedParams.add(url);
    }

    public final int getInvalidateCustomerInfoCacheCallCount() {
        return this.invalidateCustomerInfoCacheCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.invalidateCustomerInfoCacheCallCount++;
    }

    public final int getPurchaseSelectedPackageCallCount() {
        return this.purchaseSelectedPackageCallCount;
    }

    public final List<Activity> getPurchaseSelectedPackageParams() {
        return this.purchaseSelectedPackageParams;
    }

    public final List<String> getPurchaseSelectedPackageIdentifiers() {
        return this.purchaseSelectedPackageIdentifiers;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        MutableState<TemplateConfiguration.PackageInfo> selectedPackage;
        TemplateConfiguration.PackageInfo value;
        Package rcPackage;
        this.purchaseSelectedPackageCallCount++;
        this.purchaseSelectedPackageParams.add(activity);
        List<String> list = this.purchaseSelectedPackageIdentifiers;
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        list.add((legacyLoadedLegacyState == null || (selectedPackage = legacyLoadedLegacyState.getSelectedPackage()) == null || (value = selectedPackage.getValue()) == null || (rcPackage = value.getRcPackage()) == null) ? null : rcPackage.getIdentifier());
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
    }

    public final int getHandlePackagePurchaseCount() {
        return this.handlePackagePurchaseCount;
    }

    public final List<Pair<Activity, Package>> getHandlePackagePurchaseParams() {
        return this.handlePackagePurchaseParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        this.handlePackagePurchaseCount++;
        this.handlePackagePurchaseParams.add(TuplesKt.m1606to(activity, r2));
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
        return Unit.INSTANCE;
    }

    public final int getRestorePurchasesCallCount() {
        return this.restorePurchasesCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        this.restorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
    }

    public final int getHandleRestorePurchasesCallCount() {
        return this.handleRestorePurchasesCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        this.handleRestorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
        return Unit.INSTANCE;
    }

    public final int getHandleWorkflowActionCallCount() {
        return this.handleWorkflowActionCallCount;
    }

    public final List<Pair<String, WorkflowTriggerType>> getHandleWorkflowActionParams() {
        return this.handleWorkflowActionParams;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        this.handleWorkflowActionCallCount++;
        this.handleWorkflowActionParams.add(TuplesKt.m1606to(componentId, triggerType));
    }

    public final int getHandleBackNavigationCallCount() {
        return this.handleBackNavigationCallCount;
    }

    public final boolean getHandleBackNavigationResult() {
        return this.handleBackNavigationResult;
    }

    public final void setHandleBackNavigationResult(boolean z) {
        this.handleBackNavigationResult = z;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public boolean handleBackNavigation() {
        this.handleBackNavigationCallCount++;
        return this.handleBackNavigationResult;
    }

    public final int getOnTransitionCompleteCallCount() {
        return this.onTransitionCompleteCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void onTransitionComplete(int transitionId) {
        this.onTransitionCompleteCallCount++;
    }

    public final int getClearActionErrorCallCount() {
        return this.clearActionErrorCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this.clearActionErrorCallCount++;
        this._actionError.setValue(null);
    }

    public final int getPreloadExitOfferingCallCount() {
        return this.preloadExitOfferingCallCount;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        this.preloadExitOfferingCallCount++;
    }

    public final int getUpdateOptionsCallCount() {
        return this.updateOptionsCallCount;
    }

    public final List<PaywallOptions> getUpdateOptionsParams() {
        return this.updateOptionsParams;
    }

    public final void updateOptions(PaywallOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.updateOptionsCallCount++;
        this.updateOptionsParams.add(options);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1 */
    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1", m1609f = "TestData.kt", m1610i = {}, m1611l = {760}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C81791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C81791(Continuation<? super C81791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MockViewModel.this.new C81791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C81791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MockViewModel.this.awaitSimulateActionInProgress(this) == coroutine_suspended) {
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

    private final void simulateActionInProgress() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C81791(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitSimulateActionInProgress(Continuation<? super Unit> continuation) {
        C81781 c81781;
        MockViewModel mockViewModel;
        if (continuation instanceof C81781) {
            c81781 = (C81781) continuation;
            if ((c81781.label & Integer.MIN_VALUE) != 0) {
                c81781.label -= Integer.MIN_VALUE;
            } else {
                c81781 = new C81781(continuation);
            }
        }
        Object obj = c81781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81781.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this._actionInProgress.setValue(Boxing.boxBoolean(true));
            c81781.L$0 = this;
            c81781.label = 1;
            if (DelayKt.delay(2000L, c81781) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mockViewModel = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mockViewModel = (MockViewModel) c81781.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mockViewModel._actionInProgress.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    static /* synthetic */ void unsupportedMethod$default(MockViewModel mockViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Not supported";
        }
        mockViewModel.unsupportedMethod(str);
    }

    private final void unsupportedMethod(String errorMessage) {
        if (this.shouldErrorOnUnsupportedMethods) {
            throw new IllegalStateException(errorMessage.toString());
        }
    }

    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/MockViewModel$Companion;", "", "()V", "MILLIS_2025_01_25", "", "fakePurchaseDelayMillis", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
