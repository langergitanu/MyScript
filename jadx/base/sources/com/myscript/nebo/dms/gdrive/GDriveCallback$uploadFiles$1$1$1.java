package com.myscript.nebo.dms.gdrive;

import com.myscript.nebo.dms.cloud.common.utils.CloudErrorExtKt;
import com.myscript.snt.dms.BatchResult;
import com.myscript.snt.dms.CancelableCloudTaskProgressHandler;
import com.myscript.snt.dms.CloudOperationLogger;
import com.myscript.snt.dms.CloudUploadFileRequest;
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

/* JADX INFO: compiled from: GDriveCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.gdrive.GDriveCallback$uploadFiles$1$1$1", m1609f = "GDriveCallback.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GDriveCallback$uploadFiles$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionId;
    final /* synthetic */ CloudUploadFileRequest $fileRequest;
    final /* synthetic */ List<String> $files;
    final /* synthetic */ CancelableCloudTaskProgressHandler $progressCallback;
    final /* synthetic */ BatchResult $result;
    int label;
    final /* synthetic */ GDriveCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GDriveCallback$uploadFiles$1$1$1(GDriveCallback gDriveCallback, CloudUploadFileRequest cloudUploadFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, BatchResult batchResult, List<String> list, String str, Continuation<? super GDriveCallback$uploadFiles$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = gDriveCallback;
        this.$fileRequest = cloudUploadFileRequest;
        this.$progressCallback = cancelableCloudTaskProgressHandler;
        this.$result = batchResult;
        this.$files = list;
        this.$actionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GDriveCallback$uploadFiles$1$1$1(this.this$0, this.$fileRequest, this.$progressCallback, this.$result, this.$files, this.$actionId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GDriveCallback$uploadFiles$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            GDriveCallback gDriveCallback = this.this$0;
            CloudUploadFileRequest cloudUploadFileRequest = this.$fileRequest;
            Intrinsics.checkNotNull(cloudUploadFileRequest);
            String strUploadFile = gDriveCallback.uploadFile(cloudUploadFileRequest, this.$progressCallback);
            BatchResult batchResult = this.$result;
            CloudUploadFileRequest cloudUploadFileRequest2 = this.$fileRequest;
            List<String> list = this.$files;
            synchronized (batchResult) {
                batchResult.put(cloudUploadFileRequest2.getRequestId(), strUploadFile);
                String localPath = cloudUploadFileRequest2.getLocalPath();
                Intrinsics.checkNotNullExpressionValue(localPath, "getLocalPath(...)");
                list.add(localPath);
            }
        } catch (Exception e) {
            BatchResult batchResult2 = this.$result;
            GDriveCallback gDriveCallback2 = this.this$0;
            String str = this.$actionId;
            CloudUploadFileRequest cloudUploadFileRequest3 = this.$fileRequest;
            synchronized (batchResult2) {
                CloudOperationLogger cloudOperationLogger = gDriveCallback2.cloudOperationLogger;
                if (cloudOperationLogger != null) {
                    cloudOperationLogger.addError(str, CloudErrorExtKt.getAsCloudError(e).toString());
                }
                batchResult2.put(cloudUploadFileRequest3.getRequestId(), CloudErrorExtKt.getAsCloudError(e));
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
