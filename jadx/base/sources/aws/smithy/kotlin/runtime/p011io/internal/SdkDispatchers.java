package aws.smithy.kotlin.runtime.p011io.internal;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SdkDispatchersJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/SdkDispatchers;", "", "<init>", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkDispatchers {
    public static final SdkDispatchers INSTANCE = new SdkDispatchers();
    private static final CoroutineDispatcher IO = Dispatchers.getIO();

    private SdkDispatchers() {
    }

    public final CoroutineDispatcher getIO() {
        return IO;
    }
}
