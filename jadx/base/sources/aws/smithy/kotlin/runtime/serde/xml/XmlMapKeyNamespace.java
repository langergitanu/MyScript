package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlMapKeyNamespace;", "Laws/smithy/kotlin/runtime/serde/xml/AbstractXmlNamespaceTrait;", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "uri", "", "prefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlMapKeyNamespace extends AbstractXmlNamespaceTrait implements FieldTrait {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlMapKeyNamespace(String uri, String str) {
        super(uri, str);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public /* synthetic */ XmlMapKeyNamespace(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }
}
