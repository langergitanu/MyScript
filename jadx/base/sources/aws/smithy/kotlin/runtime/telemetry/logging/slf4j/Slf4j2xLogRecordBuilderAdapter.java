package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.spi.LoggingEventBuilder;

/* JADX INFO: compiled from: Slf4j2xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4j2xLogRecordBuilderAdapter;", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "delegate", "Lorg/slf4j/spi/LoggingEventBuilder;", "<init>", "(Lorg/slf4j/spi/LoggingEventBuilder;)V", "setCause", "", "ex", "", "setMessage", "message", "", "Lkotlin/Function0;", "setKeyValuePair", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "emit", "logging-slf4j2"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class Slf4j2xLogRecordBuilderAdapter implements LogRecordBuilder {
    private final LoggingEventBuilder delegate;

    public Slf4j2xLogRecordBuilderAdapter(LoggingEventBuilder delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setCause(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        this.delegate.setCause(ex);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.delegate.setMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setMessage$lambda$0(Function0 function0) {
        return (String) function0.invoke();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(final Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.delegate.setMessage(new Supplier() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.slf4j.Slf4j2xLogRecordBuilderAdapter$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Slf4j2xLogRecordBuilderAdapter.setMessage$lambda$0(message);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setKeyValuePair(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.addKeyValue(key, value);
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void emit() {
        this.delegate.log();
    }
}
