package aws.smithy.kotlin.runtime.text;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001b\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, m1599d2 = {"", "prefix", "ensurePrefix", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "suffix", "ensureSuffix", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextKt {
    @InternalApi
    public static final String ensurePrefix(String str, String prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return StringsKt.startsWith$default(str, prefix, false, 2, (Object) null) ? str : prefix + str;
    }

    @InternalApi
    public static final String ensureSuffix(String str, String suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return StringsKt.endsWith$default(str, suffix, false, 2, (Object) null) ? str : str + suffix;
    }
}
