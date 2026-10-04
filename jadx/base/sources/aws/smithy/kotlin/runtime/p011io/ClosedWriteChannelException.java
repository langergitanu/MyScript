package aws.smithy.kotlin.runtime.p011io;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/ClosedWriteChannelException;", "Ljava/io/IOException;", "Laws/smithy/kotlin/runtime/io/IOException;", "", "message", "<init>", "(Ljava/lang/String;)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ClosedWriteChannelException extends IOException {
    /* JADX WARN: Multi-variable type inference failed */
    public ClosedWriteChannelException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ClosedWriteChannelException(String str) {
        super(str);
    }

    public /* synthetic */ ClosedWriteChannelException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
