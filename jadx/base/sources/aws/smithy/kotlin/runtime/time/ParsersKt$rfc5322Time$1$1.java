package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Parsers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ParsersKt$rfc5322Time$1$1 extends FunctionReferenceImpl implements Function2<String, Integer, ParseResult<? extends Character>> {
    public static final ParsersKt$rfc5322Time$1$1 INSTANCE = new ParsersKt$rfc5322Time$1$1();

    ParsersKt$rfc5322Time$1$1() {
        super(2, ParsersKt.class, "sp", "sp(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", 1);
    }

    public final ParseResult<Character> invoke(String p0, int i) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ParsersKt.m504sp(p0, i);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ParseResult<? extends Character> invoke(String str, Integer num) {
        return invoke(str, num.intValue());
    }
}
