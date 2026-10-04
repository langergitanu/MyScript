package com.myscript.nebo.settings;

import com.google.api.services.drive.Drive;
import com.myscript.nebo.dms.cloud.common.api.AccountInfo;
import com.myscript.nebo.dms.gdrive.DriveLoginHelper;
import com.myscript.nebo.dms.gdrive.api.GetInfoKt;
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
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/dms/cloud/common/api/AccountInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1", m1609f = "SyncSettingsFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AccountInfo>, Object> {
    int label;

    SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1(Continuation<? super SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AccountInfo> continuation) {
        return ((SyncSettingsFragment$asyncUpdateGDriveUserInfo$1$info$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!DriveLoginHelper.hasInstance()) {
            return null;
        }
        DriveLoginHelper driveLoginHelper = DriveLoginHelper.getInstance();
        if (driveLoginHelper.getAccessToken() == null) {
            return null;
        }
        Drive driveService = driveLoginHelper.getDriveService();
        Intrinsics.checkNotNullExpressionValue(driveService, "getDriveService(...)");
        return GetInfoKt.getAccountInfo(driveService);
    }
}
