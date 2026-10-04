package com.myscript.android.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: ThreadExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"cancellableDelay", "", "delayMs", "", "isCancelled", "Lkotlin/Function0;", "", "chunkSize", "(JLkotlin/jvm/functions/Function0;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ThreadExt {

    /* JADX INFO: renamed from: com.myscript.android.utils.ThreadExt$cancellableDelay$1 */
    /* JADX INFO: compiled from: ThreadExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.android.utils.ThreadExt", m1609f = "ThreadExt.kt", m1610i = {0, 0, 0, 0}, m1611l = {22}, m1612m = "cancellableDelay", m1613n = {"isCancelled", "delayMs", "chunkSize", "remaining"}, m1614nl = {23}, m1615s = {"L$0", "J$0", "J$1", "J$2"}, m1616v = 2)
    static final class C60161 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C60161(Continuation<? super C60161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThreadExt.cancellableDelay(0L, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0069 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object cancellableDelay(long j, Function0<Boolean> function0, long j2, Continuation<? super Unit> continuation) {
        C60161 c60161;
        long j3;
        Function0<Boolean> function02;
        long j4;
        if (continuation instanceof C60161) {
            c60161 = (C60161) continuation;
            if ((c60161.label & Integer.MIN_VALUE) != 0) {
                c60161.label -= Integer.MIN_VALUE;
            } else {
                c60161 = new C60161(continuation);
            }
        }
        Object obj = c60161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60161.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j3 = j2;
            function02 = function0;
            j4 = j;
            if (j <= 0) {
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c60161.J$2;
        long j5 = c60161.J$1;
        long j6 = c60161.J$0;
        function02 = (Function0) c60161.L$0;
        ResultKt.throwOnFailure(obj);
        j3 = j5;
        j4 = j6;
        j -= Math.min(j, j3);
        if (j <= 0 && !function02.invoke().booleanValue()) {
            long jMin = Math.min(j, j3);
            c60161.L$0 = function02;
            c60161.J$0 = j4;
            c60161.J$1 = j3;
            c60161.J$2 = j;
            c60161.label = 1;
            if (DelayKt.delay(jMin, c60161) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j -= Math.min(j, j3);
            if (j <= 0) {
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object cancellableDelay$default(long j, Function0 function0, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 100;
        }
        return cancellableDelay(j, function0, j2, continuation);
    }
}
