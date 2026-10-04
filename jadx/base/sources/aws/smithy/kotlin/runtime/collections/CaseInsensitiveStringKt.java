package aws.smithy.kotlin.runtime.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaseInsensitiveString.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"", "Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "toInsensitive", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CaseInsensitiveStringKt {
    public static final CaseInsensitiveString toInsensitive(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new CaseInsensitiveString(str);
    }
}
