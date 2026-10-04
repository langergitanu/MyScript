package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: XmlStreamWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H'J&\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H'J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H'R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "", "startDocument", "", "endDocument", "startTag", "name", "", "namespace", "attribute", "value", "endTag", "text", "namespacePrefix", "uri", "prefix", "bytes", "", "getBytes", "()[B", "getText", "()Ljava/lang/String;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface XmlStreamWriter {
    XmlStreamWriter attribute(String name, String value, String namespace);

    void endDocument();

    @InternalApi
    XmlStreamWriter endTag(String name, String namespace);

    byte[] getBytes();

    String getText();

    @InternalApi
    void namespacePrefix(String uri, String prefix);

    void startDocument();

    @InternalApi
    XmlStreamWriter startTag(String name, String namespace);

    XmlStreamWriter text(String text);

    /* JADX INFO: compiled from: XmlStreamWriter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ XmlStreamWriter startTag$default(XmlStreamWriter xmlStreamWriter, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTag");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return xmlStreamWriter.startTag(str, str2);
    }

    static /* synthetic */ XmlStreamWriter attribute$default(XmlStreamWriter xmlStreamWriter, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attribute");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return xmlStreamWriter.attribute(str, str2, str3);
    }

    static /* synthetic */ XmlStreamWriter endTag$default(XmlStreamWriter xmlStreamWriter, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endTag");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return xmlStreamWriter.endTag(str, str2);
    }

    static /* synthetic */ void namespacePrefix$default(XmlStreamWriter xmlStreamWriter, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: namespacePrefix");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        xmlStreamWriter.namespacePrefix(str, str2);
    }
}
