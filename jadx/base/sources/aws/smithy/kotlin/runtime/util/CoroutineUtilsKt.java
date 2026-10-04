package aws.smithy.kotlin.runtime.util;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CoroutineUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "name", "Lkotlinx/coroutines/CoroutineName;", "derivedName", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)Lkotlinx/coroutines/CoroutineName;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CoroutineUtilsKt {
    @InternalApi
    public static final CoroutineName derivedName(CoroutineContext coroutineContext, String name) {
        String name2;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.INSTANCE);
        if (coroutineName == null || (name2 = coroutineName.getName()) == null) {
            return new CoroutineName(name);
        }
        return new CoroutineName(name2 + AbstractJsonLexerKt.COLON + name);
    }
}
