package com.myscript.nebo.settings;

import com.dropbox.core.p013v2.DbxClientV2;
import com.myscript.nebo.dms.cloud.common.api.AccountInfo;
import com.myscript.nebo.dms.dropbox.api.GetInfoKt;
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

/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/dms/cloud/common/api/AccountInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AccountInfo>, Object> {
    final /* synthetic */ DbxClientV2 $dbxClient;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1(DbxClientV2 dbxClientV2, Continuation<? super SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1> continuation) {
        super(2, continuation);
        this.$dbxClient = dbxClientV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1(this.$dbxClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AccountInfo> continuation) {
        return ((SyncSettingsFragment$asyncUpdateDropboxUserInfo$1$info$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DbxClientV2 dbxClientV2 = this.$dbxClient;
        Intrinsics.checkNotNull(dbxClientV2);
        return GetInfoKt.getAccountInfo(dbxClientV2);
    }
}
