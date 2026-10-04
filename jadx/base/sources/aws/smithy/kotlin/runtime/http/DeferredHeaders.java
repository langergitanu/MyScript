package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: DeferredHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0004¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "Laws/smithy/kotlin/runtime/collections/ValuesMap;", "Lkotlinx/coroutines/Deferred;", "", "Companion", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DeferredHeaders extends ValuesMap<Deferred<? extends String>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: DeferredHeaders.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean contains(DeferredHeaders deferredHeaders, String name, Deferred<String> value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return DeferredHeaders.super.contains(name, value);
        }

        @Deprecated
        public static void forEach(DeferredHeaders deferredHeaders, Function2<? super String, ? super List<? extends Deferred<String>>, Unit> body) {
            Intrinsics.checkNotNullParameter(body, "body");
            DeferredHeaders.super.forEach(body);
        }

        @Deprecated
        public static Deferred<String> get(DeferredHeaders deferredHeaders, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return DeferredHeaders.access$get$jd(deferredHeaders, name);
        }
    }

    /* JADX INFO: compiled from: DeferredHeaders.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/DeferredHeaders$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/DeferredHeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "Empty", "getEmpty", "()Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final DeferredHeaders Empty = EmptyDeferredHeaders.INSTANCE;

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [aws.smithy.kotlin.runtime.http.DeferredHeaders] */
        public final DeferredHeaders invoke(Function1<? super DeferredHeadersBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            DeferredHeadersBuilder deferredHeadersBuilder = new DeferredHeadersBuilder();
            block.invoke(deferredHeadersBuilder);
            return deferredHeadersBuilder.build();
        }

        public final DeferredHeaders getEmpty() {
            return Empty;
        }
    }

    static /* synthetic */ Deferred access$get$jd(DeferredHeaders deferredHeaders, String str) {
        return (Deferred) super.get(str);
    }
}
