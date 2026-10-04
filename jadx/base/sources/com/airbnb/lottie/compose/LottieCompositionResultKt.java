package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LottieCompositionResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"awaitOrNull", "Lcom/airbnb/lottie/LottieComposition;", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "(Lcom/airbnb/lottie/compose/LottieCompositionResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieCompositionResultKt {

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.LottieCompositionResultKt$awaitOrNull$1 */
    /* JADX INFO: compiled from: LottieCompositionResult.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.LottieCompositionResultKt", m1609f = "LottieCompositionResult.kt", m1610i = {}, m1611l = {85}, m1612m = "awaitOrNull", m1613n = {}, m1615s = {})
    static final class C38761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C38761(Continuation<? super C38761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LottieCompositionResultKt.awaitOrNull(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitOrNull(LottieCompositionResult lottieCompositionResult, Continuation<? super LottieComposition> continuation) {
        C38761 c38761;
        if (continuation instanceof C38761) {
            c38761 = (C38761) continuation;
            if ((c38761.label & Integer.MIN_VALUE) != 0) {
                c38761.label -= Integer.MIN_VALUE;
            } else {
                c38761 = new C38761(continuation);
            }
        }
        Object objAwait = c38761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38761.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAwait);
                c38761.label = 1;
                objAwait = lottieCompositionResult.await(c38761);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            return (LottieComposition) objAwait;
        } catch (Throwable unused) {
            return null;
        }
    }
}
