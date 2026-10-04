package aws.smithy.kotlin.runtime.telemetry.logging;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractLogRecordBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u000bj\u0002`\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/AbstractLogRecordBuilder;", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "<init>", "()V", "setCause", "", "ex", "", "setMessage", "message", "", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/telemetry/logging/MessageSupplier;", "setKeyValuePair", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "emit", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractLogRecordBuilder implements LogRecordBuilder {
    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void emit() {
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setCause(Throwable ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setKeyValuePair(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder
    public void setMessage(Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
