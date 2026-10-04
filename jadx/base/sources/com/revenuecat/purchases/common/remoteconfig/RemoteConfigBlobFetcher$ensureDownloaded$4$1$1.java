package com.revenuecat.purchases.common.remoteconfig;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$ensureDownloaded$4$1$1", m1609f = "RemoteConfigBlobFetcher.kt", m1610i = {}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class RemoteConfigBlobFetcher$ensureDownloaded$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ RemoteConfigBlobFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigBlobFetcher$ensureDownloaded$4$1$1(RemoteConfigBlobFetcher remoteConfigBlobFetcher, String str, Continuation<? super RemoteConfigBlobFetcher$ensureDownloaded$4$1$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteConfigBlobFetcher;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteConfigBlobFetcher$ensureDownloaded$4$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((RemoteConfigBlobFetcher$ensureDownloaded$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objEnsureDownloaded = this.this$0.ensureDownloaded(this.$it, this);
        return objEnsureDownloaded == coroutine_suspended ? coroutine_suspended : objEnsureDownloaded;
    }
}
