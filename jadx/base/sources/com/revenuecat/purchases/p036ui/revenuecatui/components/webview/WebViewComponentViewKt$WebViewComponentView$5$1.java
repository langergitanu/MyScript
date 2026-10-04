package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$5$1", m1609f = "WebViewComponentView.kt", m1610i = {}, m1611l = {111}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WebViewComponentViewKt$WebViewComponentView$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewBridgeHolder $bridgeHolder;
    final /* synthetic */ State<PaywallState.Loaded.Components> $currentState$delegate;
    final /* synthetic */ State<Boolean> $darkMode$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewComponentViewKt$WebViewComponentView$5$1(State<PaywallState.Loaded.Components> state, State<Boolean> state2, WebViewBridgeHolder webViewBridgeHolder, Continuation<? super WebViewComponentViewKt$WebViewComponentView$5$1> continuation) {
        super(2, continuation);
        this.$currentState$delegate = state;
        this.$darkMode$delegate = state2;
        this.$bridgeHolder = webViewBridgeHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewComponentViewKt$WebViewComponentView$5$1(this.$currentState$delegate, this.$darkMode$delegate, this.$bridgeHolder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewComponentViewKt$WebViewComponentView$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final State<PaywallState.Loaded.Components> state = this.$currentState$delegate;
            final State<Boolean> state2 = this.$darkMode$delegate;
            Flow flowDrop = FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0<List<? extends Object>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$5$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Object> invoke() {
                    return WebViewComponentViewKt.webViewContextPushKey(WebViewComponentViewKt.WebViewComponentView$lambda$3(state), WebViewComponentViewKt.WebViewComponentView$lambda$2(state2));
                }
            }), 1);
            final WebViewBridgeHolder webViewBridgeHolder = this.$bridgeHolder;
            this.label = 1;
            if (flowDrop.collect(new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$5$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<? extends Object>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<? extends Object> list, Continuation<? super Unit> continuation) {
                    WebViewJavaScriptBridge bridge = webViewBridgeHolder.getBridge();
                    if (bridge != null) {
                        bridge.pushContextNow();
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
