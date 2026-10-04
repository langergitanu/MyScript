package aws.sdk.kotlin.runtime.http;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/LanguageMetadata;", "", "version", "", "extras", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getVersion", "()Ljava/lang/String;", "getExtras", "()Ljava/util/Map;", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class LanguageMetadata {
    private final Map<String, String> extras;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public LanguageMetadata() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LanguageMetadata copy$default(LanguageMetadata languageMetadata, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languageMetadata.version;
        }
        if ((i & 2) != 0) {
            map = languageMetadata.extras;
        }
        return languageMetadata.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> component2() {
        return this.extras;
    }

    public final LanguageMetadata copy(String version, Map<String, String> extras) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new LanguageMetadata(version, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageMetadata)) {
            return false;
        }
        LanguageMetadata languageMetadata = (LanguageMetadata) other;
        return Intrinsics.areEqual(this.version, languageMetadata.version) && Intrinsics.areEqual(this.extras, languageMetadata.extras);
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.extras.hashCode();
    }

    public LanguageMetadata(String version, Map<String, String> extras) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.version = version;
        this.extras = extras;
    }

    public /* synthetic */ LanguageMetadata(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KotlinVersion.CURRENT.toString() : str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AwsUserAgentMetadataKt.uaPair("lang", "kotlin", this.version));
        if (!this.extras.isEmpty()) {
            sb.append(" " + ((Object) AdditionalMetadata.m12065toStringimpl(AdditionalMetadata.m12061constructorimpl(this.extras))));
        }
        return sb.toString();
    }
}
