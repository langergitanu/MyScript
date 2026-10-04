package aws.smithy.kotlin.runtime.p011io;

import kotlin.Metadata;

/* JADX INFO: compiled from: ExceptionsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/EOFException;", "Ljava/io/EOFException;", "", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "()V", "(Ljava/lang/String;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class EOFException extends java.io.EOFException {
    public EOFException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public EOFException() {
        this(null, null);
    }

    public EOFException(String str) {
        this(str, null);
    }
}
