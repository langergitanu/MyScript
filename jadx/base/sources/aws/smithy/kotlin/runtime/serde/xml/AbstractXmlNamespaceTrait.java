package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\n\u0010\f\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/AbstractXmlNamespaceTrait;", "", "uri", "", "prefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getPrefix", "isDefault", "", "toString", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class AbstractXmlNamespaceTrait {
    private final String prefix;
    private final String uri;

    public AbstractXmlNamespaceTrait(String uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.prefix = str;
    }

    public /* synthetic */ AbstractXmlNamespaceTrait(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getUri() {
        return this.uri;
    }

    public final boolean isDefault() {
        return this.prefix == null;
    }

    public String toString() {
        return "AbstractXmlNamespace(uri=" + this.uri + ", prefix=" + this.prefix + ')';
    }
}
