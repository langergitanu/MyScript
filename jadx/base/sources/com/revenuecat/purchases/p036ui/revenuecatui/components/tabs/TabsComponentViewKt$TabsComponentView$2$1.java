package com.revenuecat.purchases.p036ui.revenuecatui.components.tabs;

import androidx.compose.runtime.MutableState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.paywalls.components.common.StateUpdate;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonElementKt;

/* JADX INFO: compiled from: TabsComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$2$1", m1609f = "TabsComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class TabsComponentViewKt$TabsComponentView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $lastPublishedTabId;
    final /* synthetic */ String $selectedTabId;
    final /* synthetic */ PaywallState.Loaded.Components $state;
    final /* synthetic */ TabsComponentStyle $style;
    final /* synthetic */ TabsComponentState $tabsState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabsComponentViewKt$TabsComponentView$2$1(TabsComponentState tabsComponentState, String str, MutableState<String> mutableState, TabsComponentStyle tabsComponentStyle, PaywallState.Loaded.Components components, Continuation<? super TabsComponentViewKt$TabsComponentView$2$1> continuation) {
        super(2, continuation);
        this.$tabsState = tabsComponentState;
        this.$selectedTabId = str;
        this.$lastPublishedTabId = mutableState;
        this.$style = tabsComponentStyle;
        this.$state = components;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TabsComponentViewKt$TabsComponentView$2$1(this.$tabsState, this.$selectedTabId, this.$lastPublishedTabId, this.$style, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TabsComponentViewKt$TabsComponentView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.$tabsState.getVisible() || Intrinsics.areEqual(this.$selectedTabId, this.$lastPublishedTabId.getValue())) {
            return Unit.INSTANCE;
        }
        this.$lastPublishedTabId.setValue(this.$selectedTabId);
        List<? extends StateUpdate> stateUpdates = this.$style.getStateUpdates();
        if (stateUpdates != null) {
            if (stateUpdates.isEmpty()) {
                stateUpdates = null;
            }
            if (stateUpdates != null) {
                this.$state.getStateStore().applyUpdates(stateUpdates, JsonElementKt.JsonPrimitive(this.$selectedTabId));
            }
        }
        return Unit.INSTANCE;
    }
}
