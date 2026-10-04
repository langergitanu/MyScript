package aws.sdk.kotlin.runtime.http;

import androidx.credentials.provider.CredentialEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AwsUserAgentMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u000f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/AdditionalMetadata;", "", "extras", "", "", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "toString", "toString-impl", "(Ljava/util/Map;)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@JvmInline
public final class AdditionalMetadata {
    private final Map<String, String> extras;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdditionalMetadata m12060boximpl(Map map) {
        return new AdditionalMetadata(map);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Map<String, ? extends String> m12061constructorimpl(Map<String, String> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        return extras;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12062equalsimpl(Map<String, ? extends String> map, Object obj) {
        return (obj instanceof AdditionalMetadata) && Intrinsics.areEqual(map, ((AdditionalMetadata) obj).getExtras());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12063equalsimpl0(Map<String, ? extends String> map, Map<String, ? extends String> map2) {
        return Intrinsics.areEqual(map, map2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m12064hashCodeimpl(Map<String, ? extends String> map) {
        return map.hashCode();
    }

    public boolean equals(Object other) {
        return m12062equalsimpl(this.extras, other);
    }

    public int hashCode() {
        return m12064hashCodeimpl(this.extras);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Map getExtras() {
        return this.extras;
    }

    private /* synthetic */ AdditionalMetadata(Map map) {
        this.extras = map;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m12065toStringimpl(Map<String, ? extends String> map) {
        return CollectionsKt.joinToString$default(map.entrySet(), " ", null, null, 0, null, new Function1() { // from class: aws.sdk.kotlin.runtime.http.AdditionalMetadata$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdditionalMetadata.toString_impl$lambda$0((Map.Entry) obj);
            }
        }, 30, null);
    }

    public String toString() {
        return m12065toStringimpl(this.extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString_impl$lambda$0(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (StringsKt.equals((String) value, CredentialEntry.TRUE_STRING, true)) {
            value = null;
        }
        return AwsUserAgentMetadataKt.uaPair("md", str, (String) value);
    }
}
