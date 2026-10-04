package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PaywallWebViewPrewarmer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m1599d2 = {"<anonymous>", "", "invoke"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
final class PaywallWebViewPrewarmer$begin$view$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $url;
    final /* synthetic */ PaywallWebViewPrewarmer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallWebViewPrewarmer$begin$view$2(PaywallWebViewPrewarmer paywallWebViewPrewarmer, String str) {
        super(0);
        this.this$0 = paywallWebViewPrewarmer;
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler handler = this.this$0.mainHandler;
        final PaywallWebViewPrewarmer paywallWebViewPrewarmer = this.this$0;
        final String str = this.$url;
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebViewPrewarmer$begin$view$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaywallWebViewPrewarmer.access$settle(paywallWebViewPrewarmer, str);
            }
        });
    }
}
