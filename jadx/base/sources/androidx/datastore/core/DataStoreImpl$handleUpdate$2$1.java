package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.datastore.core.DataStoreImpl$handleUpdate$2$1", m1609f = "DataStoreImpl.kt", m1610i = {}, m1611l = {256, 262, 265}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
final class DataStoreImpl$handleUpdate$2$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ DataStoreImpl<T> $this_runCatching;
    final /* synthetic */ Message.Update<T> $update;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$handleUpdate$2$1(DataStoreImpl<T> dataStoreImpl, Message.Update<T> update, Continuation<? super DataStoreImpl$handleUpdate$2$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = dataStoreImpl;
        this.$update = update;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$handleUpdate$2$1(this.$this_runCatching, this.$update, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((DataStoreImpl$handleUpdate$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            State<T> currentState = ((DataStoreImpl) this.$this_runCatching).inMemoryCache.getCurrentState();
            if (currentState instanceof Data) {
                this.label = 1;
                Object objTransformAndWrite = this.$this_runCatching.transformAndWrite(this.$update.getTransform(), this.$update.getCallerContext(), this);
                if (objTransformAndWrite != coroutine_suspended) {
                    return objTransformAndWrite;
                }
            } else if ((currentState instanceof ReadException) || (currentState instanceof UnInitialized)) {
                if (currentState == this.$update.getLastState()) {
                    this.label = 2;
                    if (this.$this_runCatching.readAndInitOrPropagateAndThrowFailure(this) != coroutine_suspended) {
                    }
                } else {
                    throw ((ReadException) currentState).getReadException();
                }
            } else {
                if (currentState instanceof Final) {
                    throw ((Final) currentState).getFinalException();
                }
                if (currentState instanceof NoValueDataState) {
                    throw new IllegalStateException(DataStoreImpl.BUG_MESSAGE.toString());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        if (i != 2) {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 3;
        Object objTransformAndWrite2 = this.$this_runCatching.transformAndWrite(this.$update.getTransform(), this.$update.getCallerContext(), this);
        return objTransformAndWrite2 == coroutine_suspended ? coroutine_suspended : objTransformAndWrite2;
    }
}
