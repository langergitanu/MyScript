package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ParserCombinatorsKt$fraction$1$2 extends FunctionReferenceImpl implements Function1<Character, Boolean> {
    public static final ParserCombinatorsKt$fraction$1$2 INSTANCE = new ParserCombinatorsKt$fraction$1$2();

    ParserCombinatorsKt$fraction$1$2() {
        super(1, ParserCombinatorsKt.class, "isDigit", "isDigit(C)Z", 1);
    }

    public final Boolean invoke(char c) {
        return Boolean.valueOf(ParserCombinatorsKt.isDigit(c));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Character ch2) {
        return invoke(ch2.charValue());
    }
}
