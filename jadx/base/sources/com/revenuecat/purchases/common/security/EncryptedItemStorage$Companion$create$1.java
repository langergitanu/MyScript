package com.revenuecat.purchases.common.security;

import androidx.appcompat.app.AppCompatDelegate;
import com.revenuecat.purchases.common.security.EncryptedItemStorage;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: EncryptedItemStorage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.security.EncryptedItemStorage$Companion", m1609f = "EncryptedItemStorage.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {97, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m1612m = "create", m1613n = {WebViewMessageType.CONTEXT, "computationDispatcher", "ioDispatcher", "computationDispatcher", "ioDispatcher", SubscriberAttributeKt.JSON_NAME_KEY}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class EncryptedItemStorage$Companion$create$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EncryptedItemStorage.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EncryptedItemStorage$Companion$create$1(EncryptedItemStorage.Companion companion, Continuation<? super EncryptedItemStorage$Companion$create$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, null, null, null, null, this);
    }
}
