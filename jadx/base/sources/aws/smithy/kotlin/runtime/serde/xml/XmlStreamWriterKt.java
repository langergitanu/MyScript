package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.xml.serialization.BufferingXmlStreamWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlStreamWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m1599d2 = {"text", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "", "xmlStreamWriter", "pretty", "", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlStreamWriterKt {
    @InternalApi
    public static final void text(XmlStreamWriter xmlStreamWriter, Number text) {
        Intrinsics.checkNotNullParameter(xmlStreamWriter, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        xmlStreamWriter.text(text.toString());
    }

    @InternalApi
    public static final XmlStreamWriter xmlStreamWriter(boolean z) {
        return new BufferingXmlStreamWriter(z);
    }

    public static /* synthetic */ XmlStreamWriter xmlStreamWriter$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return xmlStreamWriter(z);
    }
}
