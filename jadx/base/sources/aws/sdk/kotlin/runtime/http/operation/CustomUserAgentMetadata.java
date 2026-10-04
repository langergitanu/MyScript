package aws.sdk.kotlin.runtime.http.operation;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CustomUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0002R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "", "extras", "", "", "typedExtras", "", "Laws/sdk/kotlin/runtime/http/operation/TypedUserAgentMetadata;", "<init>", "(Ljava/util/Map;Ljava/util/List;)V", "", "getExtras$aws_http", "()Ljava/util/Map;", "", "getTypedExtras$aws_http", "()Ljava/util/List;", "add", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", TtmlNode.TAG_METADATA, "plus", "other", "Companion", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CustomUserAgentMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<CustomUserAgentMetadata> ContextKey = new AttributeKey<>("CustomUserAgentMetadata");
    private final Map<String, String> extras;
    private final List<TypedUserAgentMetadata> typedExtras;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomUserAgentMetadata() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CustomUserAgentMetadata(Map<String, String> extras, List<? extends TypedUserAgentMetadata> typedExtras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(typedExtras, "typedExtras");
        this.extras = MapsKt.toMutableMap(extras);
        this.typedExtras = CollectionsKt.toMutableList((Collection) typedExtras);
    }

    public /* synthetic */ CustomUserAgentMetadata(Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Map<String, String> getExtras$aws_http() {
        return this.extras;
    }

    public final List<TypedUserAgentMetadata> getTypedExtras$aws_http() {
        return this.typedExtras;
    }

    /* JADX INFO: compiled from: CustomUserAgentMetadata.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata$Companion;", "", "<init>", "()V", "ContextKey", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "Laws/sdk/kotlin/runtime/http/operation/CustomUserAgentMetadata;", "getContextKey", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "fromEnvironment", "provider", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "fromEnvironment$aws_http", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<CustomUserAgentMetadata> getContextKey() {
            return CustomUserAgentMetadata.ContextKey;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CustomUserAgentMetadata fromEnvironment$aws_http(PlatformEnvironProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            return new CustomUserAgentMetadata(MapsKt.plus(fromEnvironment$findAndStripKeyPrefix(provider.getAllEnvVars(), "AWS_CUSTOM_METADATA_"), fromEnvironment$findAndStripKeyPrefix(provider.getAllProperties(), "aws.customMetadata.")), null, 2, 0 == true ? 1 : 0);
        }

        private static final Map<String, String> fromEnvironment$findAndStripKeyPrefix(Map<String, String> map, String str) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringsKt.startsWith$default(entry.getKey(), str, false, 2, (Object) null)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                String strSubstring = ((String) entry2.getKey()).substring(str.length());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                linkedHashMap3.put(strSubstring, entry2.getValue());
            }
            return linkedHashMap3;
        }
    }

    public final void add(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.extras.put(key, value);
    }

    @InternalSdkApi
    public final void add(TypedUserAgentMetadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.typedExtras.add(metadata);
    }

    public final CustomUserAgentMetadata plus(CustomUserAgentMetadata other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new CustomUserAgentMetadata(MapsKt.plus(this.extras, other.extras), CollectionsKt.plus((Collection) this.typedExtras, (Iterable) other.typedExtras));
    }
}
