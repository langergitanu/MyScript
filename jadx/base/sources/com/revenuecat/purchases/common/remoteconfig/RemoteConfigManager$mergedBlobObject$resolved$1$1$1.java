package com.revenuecat.purchases.common.remoteconfig;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RemoteConfigManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$mergedBlobObject$resolved$1$1$1", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {764}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class RemoteConfigManager$mergedBlobObject$resolved$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ RemoteConfigTopic $topic;
    int label;
    final /* synthetic */ RemoteConfigManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigManager$mergedBlobObject$resolved$1$1$1(RemoteConfigManager remoteConfigManager, RemoteConfigTopic remoteConfigTopic, String str, Continuation<? super RemoteConfigManager$mergedBlobObject$resolved$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteConfigManager;
        this.$topic = remoteConfigTopic;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteConfigManager$mergedBlobObject$resolved$1$1$1(this.this$0, this.$topic, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((RemoteConfigManager$mergedBlobObject$resolved$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objResolveBlobBytes = this.this$0.resolveBlobBytes(this.$topic, this.$key, this);
        return objResolveBlobBytes == coroutine_suspended ? coroutine_suspended : objResolveBlobBytes;
    }
}
