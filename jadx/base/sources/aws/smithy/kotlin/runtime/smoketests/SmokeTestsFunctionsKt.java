package aws.smithy.kotlin.runtime.smoketests;

import kotlin.Metadata;

/* JADX INFO: compiled from: SmokeTestsFunctions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0002\u001a\u00060\u0000j\u0002`\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "DefaultPrinter", "Ljava/lang/Appendable;", "getDefaultPrinter", "()Ljava/lang/Appendable;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SmokeTestsFunctionsKt {
    private static final Appendable DefaultPrinter = new Appendable() { // from class: aws.smithy.kotlin.runtime.smoketests.SmokeTestsFunctionsKt$DefaultPrinter$1
        @Override // java.lang.Appendable
        public SmokeTestsFunctionsKt$DefaultPrinter$1 append(char value) {
            System.out.print(value);
            return this;
        }

        @Override // java.lang.Appendable
        public SmokeTestsFunctionsKt$DefaultPrinter$1 append(CharSequence value) {
            System.out.print(value);
            return this;
        }

        @Override // java.lang.Appendable
        public SmokeTestsFunctionsKt$DefaultPrinter$1 append(CharSequence value, int startIndex, int endIndex) {
            System.out.print(value != null ? value.subSequence(startIndex, endIndex) : null);
            return this;
        }
    };

    public static final Appendable getDefaultPrinter() {
        return DefaultPrinter;
    }
}
