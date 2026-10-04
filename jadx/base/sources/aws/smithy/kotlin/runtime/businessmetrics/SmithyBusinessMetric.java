package aws.smithy.kotlin.runtime.businessmetrics;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BusinessMetricsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/businessmetrics/SmithyBusinessMetric;", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "", "", Keys.IDENTIFIER, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getIdentifier", "WAITER", "PAGINATOR", "RETRY_MODE_STANDARD", "RETRY_MODE_ADAPTIVE", "GZIP_REQUEST_COMPRESSION", "PROTOCOL_RPC_V2_CBOR", "SERVICE_ENDPOINT_OVERRIDE", "ACCOUNT_ID_BASED_ENDPOINT", "ACCOUNT_ID_MODE_PREFERRED", "ACCOUNT_ID_MODE_DISABLED", "ACCOUNT_ID_MODE_REQUIRED", "SIGV4A_SIGNING", "RESOLVED_ACCOUNT_ID", "FLEXIBLE_CHECKSUMS_REQ_CRC32", "FLEXIBLE_CHECKSUMS_REQ_CRC32C", "FLEXIBLE_CHECKSUMS_REQ_SHA1", "FLEXIBLE_CHECKSUMS_REQ_SHA256", "FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED", "FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED", "FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED", "FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED", "BEARER_SERVICE_ENV_VARS", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SmithyBusinessMetric implements BusinessMetric {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SmithyBusinessMetric[] $VALUES;
    private final String identifier;
    public static final SmithyBusinessMetric WAITER = new SmithyBusinessMetric("WAITER", 0, "B");
    public static final SmithyBusinessMetric PAGINATOR = new SmithyBusinessMetric("PAGINATOR", 1, "C");
    public static final SmithyBusinessMetric RETRY_MODE_STANDARD = new SmithyBusinessMetric("RETRY_MODE_STANDARD", 2, ExifInterface.LONGITUDE_EAST);
    public static final SmithyBusinessMetric RETRY_MODE_ADAPTIVE = new SmithyBusinessMetric("RETRY_MODE_ADAPTIVE", 3, "F");
    public static final SmithyBusinessMetric GZIP_REQUEST_COMPRESSION = new SmithyBusinessMetric("GZIP_REQUEST_COMPRESSION", 4, "L");
    public static final SmithyBusinessMetric PROTOCOL_RPC_V2_CBOR = new SmithyBusinessMetric("PROTOCOL_RPC_V2_CBOR", 5, "M");
    public static final SmithyBusinessMetric SERVICE_ENDPOINT_OVERRIDE = new SmithyBusinessMetric("SERVICE_ENDPOINT_OVERRIDE", 6, "N");
    public static final SmithyBusinessMetric ACCOUNT_ID_BASED_ENDPOINT = new SmithyBusinessMetric("ACCOUNT_ID_BASED_ENDPOINT", 7, "O");
    public static final SmithyBusinessMetric ACCOUNT_ID_MODE_PREFERRED = new SmithyBusinessMetric("ACCOUNT_ID_MODE_PREFERRED", 8, "P");
    public static final SmithyBusinessMetric ACCOUNT_ID_MODE_DISABLED = new SmithyBusinessMetric("ACCOUNT_ID_MODE_DISABLED", 9, "Q");
    public static final SmithyBusinessMetric ACCOUNT_ID_MODE_REQUIRED = new SmithyBusinessMetric("ACCOUNT_ID_MODE_REQUIRED", 10, "R");
    public static final SmithyBusinessMetric SIGV4A_SIGNING = new SmithyBusinessMetric("SIGV4A_SIGNING", 11, ExifInterface.LATITUDE_SOUTH);
    public static final SmithyBusinessMetric RESOLVED_ACCOUNT_ID = new SmithyBusinessMetric("RESOLVED_ACCOUNT_ID", 12, ExifInterface.GPS_DIRECTION_TRUE);
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_CRC32 = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_CRC32", 13, "U");
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_CRC32C = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_CRC32C", 14, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_SHA1 = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_SHA1", 15, "X");
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_SHA256 = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_SHA256", 16, "Y");
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED", 17, "Z");
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED", 18, CmcdData.OBJECT_TYPE_AUDIO_ONLY);
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED", 19, "b");
    public static final SmithyBusinessMetric FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED = new SmithyBusinessMetric("FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED", 20, "c");
    public static final SmithyBusinessMetric BEARER_SERVICE_ENV_VARS = new SmithyBusinessMetric("BEARER_SERVICE_ENV_VARS", 21, "3");

    private static final /* synthetic */ SmithyBusinessMetric[] $values() {
        return new SmithyBusinessMetric[]{WAITER, PAGINATOR, RETRY_MODE_STANDARD, RETRY_MODE_ADAPTIVE, GZIP_REQUEST_COMPRESSION, PROTOCOL_RPC_V2_CBOR, SERVICE_ENDPOINT_OVERRIDE, ACCOUNT_ID_BASED_ENDPOINT, ACCOUNT_ID_MODE_PREFERRED, ACCOUNT_ID_MODE_DISABLED, ACCOUNT_ID_MODE_REQUIRED, SIGV4A_SIGNING, RESOLVED_ACCOUNT_ID, FLEXIBLE_CHECKSUMS_REQ_CRC32, FLEXIBLE_CHECKSUMS_REQ_CRC32C, FLEXIBLE_CHECKSUMS_REQ_SHA1, FLEXIBLE_CHECKSUMS_REQ_SHA256, FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED, FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED, FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED, FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED, BEARER_SERVICE_ENV_VARS};
    }

    public static EnumEntries<SmithyBusinessMetric> getEntries() {
        return $ENTRIES;
    }

    public static SmithyBusinessMetric valueOf(String str) {
        return (SmithyBusinessMetric) Enum.valueOf(SmithyBusinessMetric.class, str);
    }

    public static SmithyBusinessMetric[] values() {
        return (SmithyBusinessMetric[]) $VALUES.clone();
    }

    private SmithyBusinessMetric(String str, int i, String str2) {
        this.identifier = str2;
    }

    @Override // aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric
    public String getIdentifier() {
        return this.identifier;
    }

    static {
        SmithyBusinessMetric[] smithyBusinessMetricArr$values = $values();
        $VALUES = smithyBusinessMetricArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(smithyBusinessMetricArr$values);
    }

    @Override // java.lang.Enum
    public String toString() {
        return getIdentifier();
    }
}
