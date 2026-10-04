package androidx.room;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 */
/* JADX INFO: compiled from: RoomDatabase.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", m1609f = "RoomDatabase.android.kt", m1610i = {0}, m1611l = {1984}, m1612m = "invokeSuspend", m1613n = {"transactionElement"}, m1615s = {"L$0"})
final class C2663x2e53b6b3<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    C2663x2e53b6b3(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C2663x2e53b6b3> continuation) {
        super(2, continuation);
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C2663x2e53b6b3 c2663x2e53b6b3 = new C2663x2e53b6b3(this.$block, continuation);
        c2663x2e53b6b3.L$0 = obj;
        return c2663x2e53b6b3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((C2663x2e53b6b3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TransactionElement transactionElement;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transactionElement = (TransactionElement) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                transactionElement.release();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                transactionElement.release();
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.INSTANCE);
        Intrinsics.checkNotNull(element);
        TransactionElement transactionElement2 = (TransactionElement) element;
        transactionElement2.acquire();
        try {
            Function1<Continuation<? super R>, Object> function1 = this.$block;
            this.L$0 = transactionElement2;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            transactionElement = transactionElement2;
            obj = objInvoke;
            transactionElement.release();
            return obj;
        } catch (Throwable th3) {
            transactionElement = transactionElement2;
            th = th3;
            transactionElement.release();
            throw th;
        }
    }
}
