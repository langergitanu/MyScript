package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WebViewJavaScriptBridge.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewJavaScriptBridge$webMessageListener$1$1", m1609f = "WebViewJavaScriptBridge.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class WebViewJavaScriptBridge$webMessageListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    final /* synthetic */ boolean $isMainFrame;
    final /* synthetic */ Uri $sourceOrigin;
    int label;
    final /* synthetic */ WebViewJavaScriptBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewJavaScriptBridge$webMessageListener$1$1(WebViewJavaScriptBridge webViewJavaScriptBridge, String str, Uri uri, boolean z, Continuation<? super WebViewJavaScriptBridge$webMessageListener$1$1> continuation) {
        super(2, continuation);
        this.this$0 = webViewJavaScriptBridge;
        this.$data = str;
        this.$sourceOrigin = uri;
        this.$isMainFrame = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewJavaScriptBridge$webMessageListener$1$1(this.this$0, this.$data, this.$sourceOrigin, this.$isMainFrame, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewJavaScriptBridge$webMessageListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.handleInboundMessage(this.$data, this.$sourceOrigin, this.$isMainFrame);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
