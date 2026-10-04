package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: CoroutineStackFrame.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0080\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m1599d2 = {"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
