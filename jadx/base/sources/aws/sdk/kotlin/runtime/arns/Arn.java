package aws.sdk.kotlin.runtime.arns;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Arn.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\n\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/arns/Arn;", "", "partition", "", NotificationCompat.CATEGORY_SERVICE, TtmlNode.TAG_REGION, "accountId", "resource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "builder", "Laws/sdk/kotlin/runtime/arns/Arn$Builder;", "(Laws/sdk/kotlin/runtime/arns/Arn$Builder;)V", "getPartition", "()Ljava/lang/String;", "getService", "getRegion", "getAccountId", "getResource", "toString", "equals", "", "other", "hashCode", "", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Arn {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accountId;
    private final String partition;
    private final String region;
    private final String resource;
    private final String service;

    public Arn(String partition, String service, String str, String str2, String resource) {
        Intrinsics.checkNotNullParameter(partition, "partition");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.partition = partition;
        this.service = service;
        this.region = str;
        this.accountId = str2;
        this.resource = resource;
        if (str != null && StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("ARN region must not be blank".toString());
        }
        if (str2 != null && StringsKt.isBlank(str2)) {
            throw new IllegalArgumentException("ARN accountId must not be blank".toString());
        }
    }

    public final String getPartition() {
        return this.partition;
    }

    public final String getService() {
        return this.service;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getResource() {
        return this.resource;
    }

    /* JADX INFO: compiled from: Arn.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, m1599d2 = {"Laws/sdk/kotlin/runtime/arns/Arn$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/arns/Arn;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/arns/Arn$Builder;", "", "Lkotlin/ExtensionFunctionType;", "parse", "arn", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Arn invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        public final Arn parse(String arn) {
            Intrinsics.checkNotNullParameter(arn, "arn");
            List listSplit$default = StringsKt.split$default((CharSequence) arn, new char[]{AbstractJsonLexerKt.COLON}, false, 6, 2, (Object) null);
            if (listSplit$default.size() != 6) {
                throw new IllegalArgumentException(("Malformed ARN (" + arn + ") does not have the expected number of components").toString());
            }
            if (!Intrinsics.areEqual(listSplit$default.get(0), "arn")) {
                throw new IllegalArgumentException("Malformed ARN - does not start with `arn:`".toString());
            }
            if (StringsKt.isBlank((CharSequence) listSplit$default.get(1))) {
                throw new IllegalArgumentException("Malformed ARN - no AWS partition specified".toString());
            }
            if (StringsKt.isBlank((CharSequence) listSplit$default.get(2))) {
                throw new IllegalArgumentException("Malformed ARN - no AWS service specified".toString());
            }
            Companion companion = Arn.INSTANCE;
            Builder builder = new Builder();
            builder.setPartition((String) listSplit$default.get(1));
            builder.setService((String) listSplit$default.get(2));
            Object obj = listSplit$default.get(3);
            if (!Boolean.valueOf(!StringsKt.isBlank((String) obj)).booleanValue()) {
                obj = null;
            }
            builder.setRegion((String) obj);
            Object obj2 = listSplit$default.get(4);
            builder.setAccountId((String) (Boolean.valueOf(StringsKt.isBlank((String) obj2) ^ true).booleanValue() ? obj2 : null));
            builder.setResource((String) listSplit$default.get(5));
            return builder.build();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Arn(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        String partition = builder.getPartition();
        Intrinsics.checkNotNull(partition);
        String service = builder.getService();
        Intrinsics.checkNotNull(service);
        String region = builder.getRegion();
        String accountId = builder.getAccountId();
        String resource = builder.getResource();
        Intrinsics.checkNotNull(resource);
        this(partition, service, region, accountId, resource);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("arn:" + this.partition + AbstractJsonLexerKt.COLON + this.service + AbstractJsonLexerKt.COLON);
        String str = this.region;
        if (str != null) {
            sb.append(str);
        }
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        String str2 = this.accountId;
        if (str2 != null) {
            sb.append(str2);
        }
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.resource);
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Arn)) {
            return false;
        }
        Arn arn = (Arn) other;
        if (Intrinsics.areEqual(this.partition, arn.partition) && Intrinsics.areEqual(this.service, arn.service) && Intrinsics.areEqual(this.region, arn.region) && Intrinsics.areEqual(this.accountId, arn.accountId)) {
            return Intrinsics.areEqual(this.resource, arn.resource);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.partition.hashCode() * 31) + this.service.hashCode()) * 31;
        String str = this.region;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accountId;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.resource.hashCode();
    }

    /* JADX INFO: compiled from: Arn.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/runtime/arns/Arn$Builder;", "", "<init>", "()V", "partition", "", "getPartition", "()Ljava/lang/String;", "setPartition", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_SERVICE, "getService", "setService", TtmlNode.TAG_REGION, "getRegion", "setRegion", "accountId", "getAccountId", "setAccountId", "resource", "getResource", "setResource", "build", "Laws/sdk/kotlin/runtime/arns/Arn;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String accountId;
        private String partition;
        private String region;
        private String resource;
        private String service;

        public final String getPartition() {
            return this.partition;
        }

        public final void setPartition(String str) {
            this.partition = str;
        }

        public final String getService() {
            return this.service;
        }

        public final void setService(String str) {
            this.service = str;
        }

        public final String getRegion() {
            return this.region;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public final String getAccountId() {
            return this.accountId;
        }

        public final void setAccountId(String str) {
            this.accountId = str;
        }

        public final String getResource() {
            return this.resource;
        }

        public final void setResource(String str) {
            this.resource = str;
        }

        public final Arn build() {
            String str = this.partition;
            if (str == null || StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("ARN partition must not be null or blank".toString());
            }
            String str2 = this.service;
            if (str2 == null || StringsKt.isBlank(str2)) {
                throw new IllegalArgumentException("ARN service must not be null or blank".toString());
            }
            if (this.resource == null) {
                throw new IllegalArgumentException("ARN resource must not be null".toString());
            }
            return new Arn(this);
        }
    }
}
