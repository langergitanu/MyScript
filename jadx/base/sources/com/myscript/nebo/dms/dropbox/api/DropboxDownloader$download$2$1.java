package com.myscript.nebo.dms.dropbox.api;

import androidx.compose.material.TextFieldImplKt;
import com.dropbox.core.InvalidAccessTokenException;
import com.dropbox.core.p013v2.files.DownloadErrorException;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.myscript.nebo.dms.cloud.common.api.ProgressListener;
import com.myscript.nebo.dms.cloud.common.utils.CloudErrorExtKt;
import com.myscript.snt.dms.BatchResult;
import com.myscript.snt.dms.CloudFileRequest;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: DropboxDownloader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.DropboxDownloader$download$2$1", m1609f = "DropboxDownloader.kt", m1610i = {}, m1611l = {149}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TextFieldImplKt.AnimationDuration}, m1615s = {}, m1616v = 2)
final class DropboxDownloader$download$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProgressListener $callback;
    final /* synthetic */ CloudFileRequest $cloudFileRequest;
    final /* synthetic */ BatchResult $downloadResults;
    final /* synthetic */ CoroutineScope $downloadScope;
    final /* synthetic */ CopyOnWriteArrayList<CloudFileRequest> $syncCurrentList;
    int label;
    final /* synthetic */ DropboxDownloader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DropboxDownloader$download$2$1(DropboxDownloader dropboxDownloader, CloudFileRequest cloudFileRequest, ProgressListener progressListener, CopyOnWriteArrayList<CloudFileRequest> copyOnWriteArrayList, BatchResult batchResult, CoroutineScope coroutineScope, Continuation<? super DropboxDownloader$download$2$1> continuation) {
        super(2, continuation);
        this.this$0 = dropboxDownloader;
        this.$cloudFileRequest = cloudFileRequest;
        this.$callback = progressListener;
        this.$syncCurrentList = copyOnWriteArrayList;
        this.$downloadResults = batchResult;
        this.$downloadScope = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DropboxDownloader$download$2$1(this.this$0, this.$cloudFileRequest, this.$callback, this.$syncCurrentList, this.$downloadResults, this.$downloadScope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DropboxDownloader$download$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NoSuchElementException noSuchElementException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DropboxDownloader dropboxDownloader = this.this$0;
                CloudFileRequest cloudFileRequest = this.$cloudFileRequest;
                Intrinsics.checkNotNull(cloudFileRequest);
                this.label = 1;
                obj = dropboxDownloader.launchDownload(cloudFileRequest, this.$callback, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FileMetadata fileMetadata = (FileMetadata) obj;
            if (fileMetadata != null) {
                this.$callback.onComplete(Boxing.boxLong(this.$cloudFileRequest.getRequestId()), fileMetadata.getRev());
                this.$syncCurrentList.remove(this.$cloudFileRequest);
                BatchResult batchResult = this.$downloadResults;
                CloudFileRequest cloudFileRequest2 = this.$cloudFileRequest;
                synchronized (batchResult) {
                    batchResult.put(cloudFileRequest2.getRequestId(), "");
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                BatchResult batchResult2 = this.$downloadResults;
                CloudFileRequest cloudFileRequest3 = this.$cloudFileRequest;
                synchronized (batchResult2) {
                    batchResult2.put(cloudFileRequest3.getRequestId(), CloudErrorExtKt.getAsCloudError(new RuntimeException("Download failed for unknown reason.")));
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        } catch (IOException e) {
            if (Intrinsics.areEqual(e.getMessage(), "Canceled")) {
                this.this$0.setCanceled(true);
                CoroutineScopeKt.cancel$default(this.$downloadScope, null, 1, null);
                return Unit.INSTANCE;
            }
        } catch (Exception e2) {
            BatchResult batchResult3 = this.$downloadResults;
            CopyOnWriteArrayList<CloudFileRequest> copyOnWriteArrayList = this.$syncCurrentList;
            CloudFileRequest cloudFileRequest4 = this.$cloudFileRequest;
            synchronized (batchResult3) {
                if ((e2 instanceof DownloadErrorException) && ((DownloadErrorException) e2).errorValue.getPathValue().isNotFound()) {
                    copyOnWriteArrayList.remove(cloudFileRequest4);
                    noSuchElementException = new NoSuchElementException("File " + cloudFileRequest4.getFile().getPath() + " not found remotely");
                } else {
                    noSuchElementException = e2;
                }
                batchResult3.put(cloudFileRequest4.getRequestId(), CloudErrorExtKt.getAsCloudError(noSuchElementException));
                Unit unit3 = Unit.INSTANCE;
                if (e2 instanceof InvalidAccessTokenException) {
                    this.this$0.setCanceled(true);
                    CoroutineScopeKt.cancel$default(this.$downloadScope, null, 1, null);
                    return Unit.INSTANCE;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
