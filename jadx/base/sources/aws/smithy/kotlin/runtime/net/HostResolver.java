package aws.smithy.kotlin.runtime.net;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: HostResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\f\u0010\u000b¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/HostResolver;", "", "", "hostname", "", "Laws/smithy/kotlin/runtime/net/HostAddress;", "resolve", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addr", "", "reportFailure", "(Laws/smithy/kotlin/runtime/net/HostAddress;)V", "purgeCache", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HostResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @InternalApi
    void purgeCache(HostAddress addr);

    void reportFailure(HostAddress addr);

    Object resolve(String str, Continuation<? super List<HostAddress>> continuation);

    /* JADX INFO: compiled from: HostResolver.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/HostResolver$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/net/HostResolver;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/net/HostResolver;", "getDefault", "()Laws/smithy/kotlin/runtime/net/HostResolver;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final HostResolver Default = DefaultHostResolver.INSTANCE;

        private Companion() {
        }

        public final HostResolver getDefault() {
            return Default;
        }
    }

    /* JADX INFO: compiled from: HostResolver.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void purgeCache$default(HostResolver hostResolver, HostAddress hostAddress, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: purgeCache");
        }
        if ((i & 1) != 0) {
            hostAddress = null;
        }
        hostResolver.purgeCache(hostAddress);
    }
}
