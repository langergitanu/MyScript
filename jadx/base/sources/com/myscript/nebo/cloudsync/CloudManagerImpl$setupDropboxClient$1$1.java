package com.myscript.nebo.cloudsync;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CloudManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.cloudsync.CloudManagerImpl$setupDropboxClient$1$1", m1609f = "CloudManagerImpl.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class CloudManagerImpl$setupDropboxClient$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $exception;
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $onResult;
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ CloudManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CloudManagerImpl$setupDropboxClient$1$1(Exception exc, boolean z, CloudManagerImpl cloudManagerImpl, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super CloudManagerImpl$setupDropboxClient$1$1> continuation) {
        super(2, continuation);
        this.$exception = exc;
        this.$success = z;
        this.this$0 = cloudManagerImpl;
        this.$onResult = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudManagerImpl$setupDropboxClient$1$1(this.$exception, this.$success, this.this$0, this.$onResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudManagerImpl$setupDropboxClient$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zHandleError;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            Exception exc = this.$exception;
            if (exc != null) {
                CloudManagerImpl cloudManagerImpl = this.this$0;
                String strStartAction = cloudManagerImpl.libraryRepository.getCloudOperationLogger().startAction();
                zHandleError = cloudManagerImpl.handleError("Dropbox setup failed.", exc);
                cloudManagerImpl.libraryRepository.getCloudOperationLogger().endAction(strStartAction, "DROPBOX_SETUP");
            } else {
                zHandleError = false;
            }
            if (this.$success) {
                this.this$0.libraryRepository.notifyValidCloudToken();
            }
            this.$onResult.invoke(Boxing.boxBoolean(this.$success), Boxing.boxBoolean(zHandleError));
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            this.$onResult.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
            throw e;
        }
    }
}
