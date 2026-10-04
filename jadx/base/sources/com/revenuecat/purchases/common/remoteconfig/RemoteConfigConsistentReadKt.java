package com.revenuecat.purchases.common.remoteconfig;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: RemoteConfigConsistentRead.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u000523\u0010\u0007\u001a/\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0080@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"readConsistent", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "what", "Lkotlin/Function0;", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "generation", "Lkotlin/coroutines/Continuation;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigConsistentReadKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt$readConsistent$1 */
    /* JADX INFO: compiled from: RemoteConfigConsistentRead.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigConsistentReadKt", m1609f = "RemoteConfigConsistentRead.kt", m1610i = {0, 0, 0, 0, 1, 1}, m1611l = {18, 22}, m1612m = "readConsistent", m1613n = {"$this$readConsistent", "what", "block", "generation", "$this$readConsistent", "generation"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class C72191<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C72191(Continuation<? super C72191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigConsistentReadKt.readConsistent(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object readConsistent(RemoteConfigManager remoteConfigManager, Function0<String> function0, Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        C72191 c72191;
        Ref.IntRef intRef;
        Object objInvoke;
        RemoteConfigManager remoteConfigManager2;
        Ref.IntRef intRef2;
        if (continuation instanceof C72191) {
            c72191 = (C72191) continuation;
            if ((c72191.label & Integer.MIN_VALUE) != 0) {
                c72191.label -= Integer.MIN_VALUE;
            } else {
                c72191 = new C72191(continuation);
            }
        }
        Object obj = c72191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intRef = new Ref.IntRef();
            intRef.element = remoteConfigManager.getConfigGeneration();
            Integer numBoxInt = Boxing.boxInt(intRef.element);
            c72191.L$0 = remoteConfigManager;
            c72191.L$1 = function0;
            c72191.L$2 = function2;
            c72191.L$3 = intRef;
            c72191.label = 1;
            objInvoke = function2.invoke(numBoxInt, c72191);
            if (objInvoke != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef2 = (Ref.IntRef) c72191.L$1;
            remoteConfigManager2 = (RemoteConfigManager) c72191.L$0;
            ResultKt.throwOnFailure(obj);
            if (remoteConfigManager2.getConfigGeneration() != intRef2.element) {
                return obj;
            }
            return null;
        }
        Ref.IntRef intRef3 = (Ref.IntRef) c72191.L$3;
        function2 = (Function2) c72191.L$2;
        function0 = (Function0) c72191.L$1;
        RemoteConfigManager remoteConfigManager3 = (RemoteConfigManager) c72191.L$0;
        ResultKt.throwOnFailure(obj);
        intRef = intRef3;
        remoteConfigManager = remoteConfigManager3;
        objInvoke = obj;
        if (remoteConfigManager.getConfigGeneration() == intRef.element) {
            return objInvoke;
        }
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config changed while reading " + function0.invoke() + "; reading it again.");
        }
        intRef.element = remoteConfigManager.getConfigGeneration();
        Integer numBoxInt2 = Boxing.boxInt(intRef.element);
        c72191.L$0 = remoteConfigManager;
        c72191.L$1 = intRef;
        c72191.L$2 = null;
        c72191.L$3 = null;
        c72191.label = 2;
        Object objInvoke2 = function2.invoke(numBoxInt2, c72191);
        if (objInvoke2 != coroutine_suspended) {
            remoteConfigManager2 = remoteConfigManager;
            intRef2 = intRef;
            obj = objInvoke2;
            if (remoteConfigManager2.getConfigGeneration() != intRef2.element) {
            }
        }
        return coroutine_suspended;
    }
}
