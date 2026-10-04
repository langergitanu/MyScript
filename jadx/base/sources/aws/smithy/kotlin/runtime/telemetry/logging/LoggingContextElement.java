package aws.smithy.kotlin.runtime.telemetry.logging;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutineContextLogExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B5\b\u0016\u0012*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b\u0006\u0010\u000bJ\n\u0010\u000e\u001a\u00020\u0004H\u0096\u0080\u0004J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LoggingContextElement;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "kvPairs", "", "", "", "<init>", "(Ljava/util/Map;)V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "getKvPairs", "()Ljava/util/Map;", "toString", "component1", "copy", "equals", "", "other", "hashCode", "", "Key", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class LoggingContextElement extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, Object> kvPairs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoggingContextElement copy$default(LoggingContextElement loggingContextElement, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = loggingContextElement.kvPairs;
        }
        return loggingContextElement.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.kvPairs;
    }

    public final LoggingContextElement copy(Map<String, ? extends Object> kvPairs) {
        Intrinsics.checkNotNullParameter(kvPairs, "kvPairs");
        return new LoggingContextElement(kvPairs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LoggingContextElement) && Intrinsics.areEqual(this.kvPairs, ((LoggingContextElement) other).kvPairs);
    }

    public int hashCode() {
        return this.kvPairs.hashCode();
    }

    public final Map<String, Object> getKvPairs() {
        return this.kvPairs;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggingContextElement(Map<String, ? extends Object> kvPairs) {
        super(INSTANCE);
        Intrinsics.checkNotNullParameter(kvPairs, "kvPairs");
        this.kvPairs = kvPairs;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.telemetry.logging.LoggingContextElement$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CoroutineContextLogExt.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LoggingContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggingContextElement;", "<init>", "()V", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements CoroutineContext.Key<LoggingContextElement> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoggingContextElement(Pair<String, ? extends Object>... pairs) {
        this((Map<String, ? extends Object>) MapsKt.toMap(pairs));
        Intrinsics.checkNotNullParameter(pairs, "pairs");
    }

    public String toString() {
        return "LoggingContextElement(" + this.kvPairs + ')';
    }
}
