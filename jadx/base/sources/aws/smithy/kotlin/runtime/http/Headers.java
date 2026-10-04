package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.collections.ValuesMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/Headers;", "Laws/smithy/kotlin/runtime/collections/ValuesMap;", "", "Companion", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Headers extends ValuesMap<String> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean contains(Headers headers, String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return Headers.super.contains(name, value);
        }

        @Deprecated
        public static void forEach(Headers headers, Function2<? super String, ? super List<String>, Unit> body) {
            Intrinsics.checkNotNullParameter(body, "body");
            Headers.super.forEach(body);
        }

        @Deprecated
        public static String get(Headers headers, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return Headers.access$get$jd(headers, name);
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/Headers$Companion;", "", "<init>", "()V", "invoke", "Laws/smithy/kotlin/runtime/http/Headers;", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "Empty", "getEmpty", "()Laws/smithy/kotlin/runtime/http/Headers;", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Headers Empty = EmptyHeaders.INSTANCE;

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [aws.smithy.kotlin.runtime.http.Headers] */
        public final Headers invoke(Function1<? super HeadersBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            HeadersBuilder headersBuilder = new HeadersBuilder();
            block.invoke(headersBuilder);
            return headersBuilder.build();
        }

        public final Headers getEmpty() {
            return Empty;
        }
    }

    static /* synthetic */ String access$get$jd(Headers headers, String str) {
        return (String) super.get(str);
    }
}
