package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/TakeWhileMNException;", "Laws/smithy/kotlin/runtime/time/ParseException;", "", "input", "", "lastPos", "expected", "matched", "<init>", "(Ljava/lang/String;III)V", "I", "getExpected", "()I", "getMatched", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TakeWhileMNException extends ParseException {
    private final int expected;
    private final int matched;

    public final int getExpected() {
        return this.expected;
    }

    public final int getMatched() {
        return this.matched;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeWhileMNException(String input, int i, int i2, int i3) {
        super(input, "expected at least " + i2 + " matches of predicate; only matched " + i3, i);
        Intrinsics.checkNotNullParameter(input, "input");
        this.expected = i2;
        this.matched = i3;
    }
}
