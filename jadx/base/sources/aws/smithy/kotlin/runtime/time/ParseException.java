package aws.smithy.kotlin.runtime.time;

import aws.smithy.kotlin.runtime.SdkBaseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ParseException;", "Laws/smithy/kotlin/runtime/SdkBaseException;", "", "input", "message", "", "position", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ParseException extends SdkBaseException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParseException(String input, String message, int i) {
        super("parse `" + input + "`: error at " + i + ": " + message);
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
