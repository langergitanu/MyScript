package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/IncompleteException;", "Laws/smithy/kotlin/runtime/time/ParseException;", "", "input", "Laws/smithy/kotlin/runtime/time/Needed;", "needed", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Needed;)V", "Laws/smithy/kotlin/runtime/time/Needed;", "getNeeded", "()Laws/smithy/kotlin/runtime/time/Needed;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IncompleteException extends ParseException {
    private final Needed needed;

    public final Needed getNeeded() {
        return this.needed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompleteException(String input, Needed needed) {
        super(input, needed.toString(), input.length() - 1);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(needed, "needed");
        this.needed = needed;
    }
}
