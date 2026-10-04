package com.myscript.nebo.editing;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.yalantis.ucrop.UCrop;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: PageAccessSerializer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0006H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageAccessSerializer;", "", "<init>", "()V", "guards", "Ljava/util/HashMap;", "", "Lcom/myscript/nebo/editing/PageAccessSerializer$Guard;", "Lkotlin/collections/HashMap;", "withPageAccess", ExifInterface.GPS_DIRECTION_TRUE, "pageUuid", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireGuard", "releaseGuard", "", "Guard", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageAccessSerializer {
    public static final PageAccessSerializer INSTANCE = new PageAccessSerializer();
    private static final HashMap<String, Guard> guards = new HashMap<>();

    /* JADX INFO: renamed from: com.myscript.nebo.editing.PageAccessSerializer$withPageAccess$1 */
    /* JADX INFO: compiled from: PageAccessSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.PageAccessSerializer", m1609f = "PageAccessSerializer.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {UCrop.REQUEST_CROP, 43}, m1612m = "withPageAccess", m1613n = {"pageUuid", "block", "guard", "$this$withLock_u24default$iv", "$i$f$withLock", "pageUuid", "block", "guard", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-PageAccessSerializer$withPageAccess$2"}, m1614nl = {70, TsExtractor.TS_SYNC_BYTE}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m1616v = 2)
    static final class C63891<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C63891(Continuation<? super C63891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageAccessSerializer.this.withPageAccess(null, null, this);
        }
    }

    private PageAccessSerializer() {
    }

    /* JADX INFO: compiled from: PageAccessSerializer.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageAccessSerializer$Guard;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "users", "", "getUsers", "()I", "setUsers", "(I)V", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Guard {
        private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
        private int users;

        public final Mutex getMutex() {
            return this.mutex;
        }

        public final int getUsers() {
            return this.users;
        }

        public final void setUsers(int i) {
            this.users = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object withPageAccess(String str, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        C63891 c63891;
        Guard guardAcquireGuard;
        Function1 function12;
        Mutex mutex;
        int i;
        Mutex mutex2;
        String str2;
        if (continuation instanceof C63891) {
            c63891 = (C63891) continuation;
            if ((c63891.label & Integer.MIN_VALUE) != 0) {
                c63891.label -= Integer.MIN_VALUE;
            } else {
                c63891 = new C63891(continuation);
            }
        }
        Object objInvoke = c63891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c63891.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                guardAcquireGuard = acquireGuard(str);
                try {
                    Mutex mutex3 = guardAcquireGuard.getMutex();
                    c63891.L$0 = str;
                    c63891.L$1 = function1;
                    c63891.L$2 = SpillingKt.nullOutSpilledVariable(guardAcquireGuard);
                    c63891.L$3 = mutex3;
                    c63891.I$0 = 0;
                    c63891.label = 1;
                    if (mutex3.lock(null, c63891) != coroutine_suspended) {
                        function12 = function1;
                        mutex = mutex3;
                        i = 0;
                        c63891.L$0 = str;
                        c63891.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                        c63891.L$2 = SpillingKt.nullOutSpilledVariable(guardAcquireGuard);
                        c63891.L$3 = mutex;
                        c63891.I$0 = i;
                        c63891.I$1 = 0;
                        c63891.label = 2;
                        objInvoke = function12.invoke(c63891);
                        if (objInvoke != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    function1 = (Function1<? super Continuation<? super T>, ? extends Object>) str;
                    th = th;
                    releaseGuard(function1);
                    throw th;
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c63891.I$1;
                int i4 = c63891.I$0;
                mutex2 = (Mutex) c63891.L$3;
                str2 = (String) c63891.L$0;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    mutex2.unlock(null);
                    releaseGuard(str2);
                    return objInvoke;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i5 = c63891.I$0;
            mutex = (Mutex) c63891.L$3;
            guardAcquireGuard = (Guard) c63891.L$2;
            Function1 function13 = (Function1) c63891.L$1;
            String str3 = (String) c63891.L$0;
            try {
                ResultKt.throwOnFailure(objInvoke);
                i = i5;
                str = str3;
                function12 = function13;
                try {
                    c63891.L$0 = str;
                    c63891.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                    c63891.L$2 = SpillingKt.nullOutSpilledVariable(guardAcquireGuard);
                    c63891.L$3 = mutex;
                    c63891.I$0 = i;
                    c63891.I$1 = 0;
                    c63891.label = 2;
                    objInvoke = function12.invoke(c63891);
                    if (objInvoke != coroutine_suspended) {
                        Mutex mutex4 = mutex;
                        str2 = str;
                        mutex2 = mutex4;
                        mutex2.unlock(null);
                        releaseGuard(str2);
                        return objInvoke;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex;
                    mutex2.unlock(null);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                function1 = (Function1<? super Continuation<? super T>, ? extends Object>) str3;
                releaseGuard(function1);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private final Guard acquireGuard(String pageUuid) {
        Guard guard;
        HashMap<String, Guard> map = guards;
        synchronized (map) {
            HashMap<String, Guard> map2 = map;
            Guard guard2 = map2.get(pageUuid);
            if (guard2 == null) {
                guard2 = new Guard();
                map2.put(pageUuid, guard2);
            }
            Guard guard3 = guard2;
            guard3.setUsers(guard3.getUsers() + 1);
            guard = guard2;
        }
        return guard;
    }

    private final void releaseGuard(String pageUuid) {
        HashMap<String, Guard> map = guards;
        synchronized (map) {
            Guard guard = map.get(pageUuid);
            if (guard == null) {
                return;
            }
            guard.setUsers(guard.getUsers() - 1);
            if (guard.getUsers() <= 0) {
                map.remove(pageUuid);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
