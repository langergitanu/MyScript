package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/FrameworkMetadata;", "", "name", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "Companion", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class FrameworkMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final String version;

    public static /* synthetic */ FrameworkMetadata copy$default(FrameworkMetadata frameworkMetadata, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = frameworkMetadata.name;
        }
        if ((i & 2) != 0) {
            str2 = frameworkMetadata.version;
        }
        return frameworkMetadata.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final FrameworkMetadata copy(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        return new FrameworkMetadata(name, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameworkMetadata)) {
            return false;
        }
        FrameworkMetadata frameworkMetadata = (FrameworkMetadata) other;
        return Intrinsics.areEqual(this.name, frameworkMetadata.name) && Intrinsics.areEqual(this.version, frameworkMetadata.version);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.version.hashCode();
    }

    public FrameworkMetadata(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
    }

    /* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/FrameworkMetadata$Companion;", "", "<init>", "()V", "fromEnvironment", "Laws/sdk/kotlin/runtime/http/FrameworkMetadata;", "provider", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "fromEnvironment$aws_http", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FrameworkMetadata fromEnvironment$aws_http(PlatformEnvironProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            String property = provider.getProperty(AwsUserAgentMetadataKt.FRAMEWORK_METADATA_PROP);
            if (property == null) {
                property = provider.getenv(AwsUserAgentMetadataKt.FRAMEWORK_METADATA_ENV);
            }
            if (property == null) {
                return null;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) property, new char[]{AbstractJsonLexerKt.COLON}, false, 2, 2, (Object) null);
            if (listSplit$default.size() != 2) {
                throw new IllegalStateException(("Invalid value for FRAMEWORK_METADATA: " + property + "; must be of the form `name:version`").toString());
            }
            return new FrameworkMetadata((String) listSplit$default.get(0), (String) listSplit$default.get(1));
        }
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        return AwsUserAgentMetadataKt.uaPair("lib", this.name, this.version);
    }
}
