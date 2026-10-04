package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$2$1", m1609f = "WebViewComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
public final class WebViewComponentViewKt$WebViewComponentView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $componentId;
    final /* synthetic */ String $resolvedUrl;
    final /* synthetic */ WebViewComponentStyle $style;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewComponentViewKt$WebViewComponentView$2$1(String str, WebViewComponentStyle webViewComponentStyle, String str2, Continuation<? super WebViewComponentViewKt$WebViewComponentView$2$1> continuation) {
        super(2, continuation);
        this.$resolvedUrl = str;
        this.$style = webViewComponentStyle;
        this.$componentId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewComponentViewKt$WebViewComponentView$2$1(this.$resolvedUrl, this.$style, this.$componentId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewComponentViewKt$WebViewComponentView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$resolvedUrl == null) {
            Logger.INSTANCE.m1587w("Paywalls V2 web_view not rendered: URL must be https with no '{{' markers: '" + this.$style.getUrl() + '\'');
        } else if (StringsKt.isBlank(this.$componentId)) {
            Logger.INSTANCE.m1587w("Paywalls V2 web_view not rendered: componentId is blank.");
        }
        return Unit.INSTANCE;
    }
}
