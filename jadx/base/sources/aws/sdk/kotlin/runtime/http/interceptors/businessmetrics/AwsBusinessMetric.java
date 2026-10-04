package aws.sdk.kotlin.runtime.http.interceptors.businessmetrics;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AwsBusinessMetricsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u000b\u001a\u00020\u0004H\u0096\u0080\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/interceptors/businessmetrics/AwsBusinessMetric;", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "", Keys.IDENTIFIER, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "S3_EXPRESS_BUCKET", "DDB_MAPPER", "toString", "Credentials", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsBusinessMetric implements BusinessMetric {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AwsBusinessMetric[] $VALUES;
    private final String identifier;
    public static final AwsBusinessMetric S3_EXPRESS_BUCKET = new AwsBusinessMetric("S3_EXPRESS_BUCKET", 0, "J");
    public static final AwsBusinessMetric DDB_MAPPER = new AwsBusinessMetric("DDB_MAPPER", 1, "d");

    private static final /* synthetic */ AwsBusinessMetric[] $values() {
        return new AwsBusinessMetric[]{S3_EXPRESS_BUCKET, DDB_MAPPER};
    }

    public static EnumEntries<AwsBusinessMetric> getEntries() {
        return $ENTRIES;
    }

    public static AwsBusinessMetric valueOf(String str) {
        return (AwsBusinessMetric) Enum.valueOf(AwsBusinessMetric.class, str);
    }

    public static AwsBusinessMetric[] values() {
        return (AwsBusinessMetric[]) $VALUES.clone();
    }

    private AwsBusinessMetric(String str, int i, String str2) {
        this.identifier = str2;
    }

    @Override // aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric
    public String getIdentifier() {
        return this.identifier;
    }

    static {
        AwsBusinessMetric[] awsBusinessMetricArr$values = $values();
        $VALUES = awsBusinessMetricArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(awsBusinessMetricArr$values);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: AwsBusinessMetricsUtils.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/interceptors/businessmetrics/AwsBusinessMetric$Credentials;", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "", Keys.IDENTIFIER, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "CREDENTIALS_CODE", "CREDENTIALS_JVM_SYSTEM_PROPERTIES", "CREDENTIALS_ENV_VARS", "CREDENTIALS_ENV_VARS_STS_WEB_ID_TOKEN", "CREDENTIALS_STS_ASSUME_ROLE", "CREDENTIALS_STS_ASSUME_ROLE_WEB_ID", "CREDENTIALS_PROFILE", "CREDENTIALS_PROFILE_SOURCE_PROFILE", "CREDENTIALS_PROFILE_NAMED_PROVIDER", "CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN", "CREDENTIALS_PROFILE_SSO", "CREDENTIALS_SSO", "CREDENTIALS_PROFILE_SSO_LEGACY", "CREDENTIALS_SSO_LEGACY", "CREDENTIALS_PROFILE_PROCESS", "CREDENTIALS_PROCESS", "CREDENTIALS_HTTP", "CREDENTIALS_IMDS", "CREDENTIALS_PROFILE_LOGIN", "CREDENTIALS_LOGIN", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Credentials implements BusinessMetric {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Credentials[] $VALUES;
        private final String identifier;
        public static final Credentials CREDENTIALS_CODE = new Credentials("CREDENTIALS_CODE", 0, "e");
        public static final Credentials CREDENTIALS_JVM_SYSTEM_PROPERTIES = new Credentials("CREDENTIALS_JVM_SYSTEM_PROPERTIES", 1, "f");
        public static final Credentials CREDENTIALS_ENV_VARS = new Credentials("CREDENTIALS_ENV_VARS", 2, "g");
        public static final Credentials CREDENTIALS_ENV_VARS_STS_WEB_ID_TOKEN = new Credentials("CREDENTIALS_ENV_VARS_STS_WEB_ID_TOKEN", 3, CmcdData.STREAMING_FORMAT_HLS);
        public static final Credentials CREDENTIALS_STS_ASSUME_ROLE = new Credentials("CREDENTIALS_STS_ASSUME_ROLE", 4, CmcdData.OBJECT_TYPE_INIT_SEGMENT);
        public static final Credentials CREDENTIALS_STS_ASSUME_ROLE_WEB_ID = new Credentials("CREDENTIALS_STS_ASSUME_ROLE_WEB_ID", 5, "k");
        public static final Credentials CREDENTIALS_PROFILE = new Credentials("CREDENTIALS_PROFILE", 6, "n");
        public static final Credentials CREDENTIALS_PROFILE_SOURCE_PROFILE = new Credentials("CREDENTIALS_PROFILE_SOURCE_PROFILE", 7, "o");
        public static final Credentials CREDENTIALS_PROFILE_NAMED_PROVIDER = new Credentials("CREDENTIALS_PROFILE_NAMED_PROVIDER", 8, TtmlNode.TAG_P);
        public static final Credentials CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN = new Credentials("CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN", 9, "q");
        public static final Credentials CREDENTIALS_PROFILE_SSO = new Credentials("CREDENTIALS_PROFILE_SSO", 10, "r");
        public static final Credentials CREDENTIALS_SSO = new Credentials("CREDENTIALS_SSO", 11, CmcdData.STREAMING_FORMAT_SS);
        public static final Credentials CREDENTIALS_PROFILE_SSO_LEGACY = new Credentials("CREDENTIALS_PROFILE_SSO_LEGACY", 12, "t");
        public static final Credentials CREDENTIALS_SSO_LEGACY = new Credentials("CREDENTIALS_SSO_LEGACY", 13, "u");
        public static final Credentials CREDENTIALS_PROFILE_PROCESS = new Credentials("CREDENTIALS_PROFILE_PROCESS", 14, "v");
        public static final Credentials CREDENTIALS_PROCESS = new Credentials("CREDENTIALS_PROCESS", 15, "w");
        public static final Credentials CREDENTIALS_HTTP = new Credentials("CREDENTIALS_HTTP", 16, "z");
        public static final Credentials CREDENTIALS_IMDS = new Credentials("CREDENTIALS_IMDS", 17, "0");
        public static final Credentials CREDENTIALS_PROFILE_LOGIN = new Credentials("CREDENTIALS_PROFILE_LOGIN", 18, "AC");
        public static final Credentials CREDENTIALS_LOGIN = new Credentials("CREDENTIALS_LOGIN", 19, "AD");

        private static final /* synthetic */ Credentials[] $values() {
            return new Credentials[]{CREDENTIALS_CODE, CREDENTIALS_JVM_SYSTEM_PROPERTIES, CREDENTIALS_ENV_VARS, CREDENTIALS_ENV_VARS_STS_WEB_ID_TOKEN, CREDENTIALS_STS_ASSUME_ROLE, CREDENTIALS_STS_ASSUME_ROLE_WEB_ID, CREDENTIALS_PROFILE, CREDENTIALS_PROFILE_SOURCE_PROFILE, CREDENTIALS_PROFILE_NAMED_PROVIDER, CREDENTIALS_PROFILE_STS_WEB_ID_TOKEN, CREDENTIALS_PROFILE_SSO, CREDENTIALS_SSO, CREDENTIALS_PROFILE_SSO_LEGACY, CREDENTIALS_SSO_LEGACY, CREDENTIALS_PROFILE_PROCESS, CREDENTIALS_PROCESS, CREDENTIALS_HTTP, CREDENTIALS_IMDS, CREDENTIALS_PROFILE_LOGIN, CREDENTIALS_LOGIN};
        }

        public static EnumEntries<Credentials> getEntries() {
            return $ENTRIES;
        }

        public static Credentials valueOf(String str) {
            return (Credentials) Enum.valueOf(Credentials.class, str);
        }

        public static Credentials[] values() {
            return (Credentials[]) $VALUES.clone();
        }

        private Credentials(String str, int i, String str2) {
            this.identifier = str2;
        }

        @Override // aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric
        public String getIdentifier() {
            return this.identifier;
        }

        static {
            Credentials[] credentialsArr$values = $values();
            $VALUES = credentialsArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(credentialsArr$values);
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return getIdentifier();
    }
}
