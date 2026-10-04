package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;
import kotlin.time.Duration;

/* JADX INFO: compiled from: EngineAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/EngineAttributes;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "Lkotlin/time/Duration;", "TimeToFirstByte", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "getTimeToFirstByte", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EngineAttributes {
    public static final EngineAttributes INSTANCE = new EngineAttributes();
    private static final AttributeKey<Duration> TimeToFirstByte = new AttributeKey<>("aws.smithy.kotlin#TimeToFirstByte");

    private EngineAttributes() {
    }

    public final AttributeKey<Duration> getTimeToFirstByte() {
        return TimeToFirstByte;
    }
}
