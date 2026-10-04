package aws.smithy.kotlin.runtime.telemetry.logging;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LogRecordBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\b0\tj\u0002`\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0001H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "", "setCause", "", "ex", "", "setMessage", "message", "", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/telemetry/logging/MessageSupplier;", "setKeyValuePair", SubscriberAttributeKt.JSON_NAME_KEY, "value", "emit", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LogRecordBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void emit();

    void setCause(Throwable ex);

    void setKeyValuePair(String key, Object value);

    void setMessage(String message);

    void setMessage(Function0<String> message);

    /* JADX INFO: compiled from: LogRecordBuilder.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final LogRecordBuilder None = new AbstractLogRecordBuilder() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder$Companion$None$1
        };

        private Companion() {
        }

        public final LogRecordBuilder getNone() {
            return None;
        }
    }
}
