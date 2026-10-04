package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlTagReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0007\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f*\u00020\u0001H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"xmlTagReader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "payload", "", "root", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "tagReader", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "reader", "data", "", "tryData", "Lkotlin/Result;", "(Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;)Ljava/lang/Object;", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlTagReaderKt {
    @InternalApi
    public static final XmlTagReader xmlTagReader(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return root(XmlStreamReaderKt.xmlStreamReader(payload));
    }

    @InternalApi
    public static final XmlTagReader tagReader(XmlToken.BeginElement beginElement, XmlStreamReader reader) {
        Intrinsics.checkNotNullParameter(beginElement, "<this>");
        Intrinsics.checkNotNullParameter(reader, "reader");
        XmlToken lastToken = reader.getLastToken();
        XmlToken.BeginElement beginElement2 = lastToken instanceof XmlToken.BeginElement ? (XmlToken.BeginElement) lastToken : null;
        if (beginElement2 == null) {
            throw new IllegalStateException(("expected start tag found " + reader.getLastToken()).toString());
        }
        if (!Intrinsics.areEqual(beginElement.getName(), beginElement2.getName())) {
            throw new IllegalStateException(("expected start tag " + beginElement.getName() + " but current reader state is on " + beginElement2.getName()).toString());
        }
        return new XmlTagReader(beginElement, reader);
    }

    @InternalApi
    public static final String data(XmlTagReader xmlTagReader) {
        Intrinsics.checkNotNullParameter(xmlTagReader, "<this>");
        XmlToken xmlTokenNextToken = xmlTagReader.nextToken();
        if (xmlTokenNextToken instanceof XmlToken.Text) {
            String value = ((XmlToken.Text) xmlTokenNextToken).getValue();
            return value == null ? "" : value;
        }
        if (xmlTokenNextToken == null || (xmlTokenNextToken instanceof XmlToken.EndElement)) {
            return "";
        }
        throw new DeserializationException("expected XmlToken.Text element, found " + xmlTokenNextToken);
    }

    @InternalApi
    public static final Object tryData(XmlTagReader xmlTagReader) {
        Intrinsics.checkNotNullParameter(xmlTagReader, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(data(xmlTagReader));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    private static final XmlTagReader root(XmlStreamReader xmlStreamReader) {
        boolean z;
        XmlToken lastToken = xmlStreamReader.getLastToken();
        do {
            z = lastToken instanceof XmlToken.BeginElement;
            if (!z) {
                lastToken = xmlStreamReader.nextToken();
            }
            if (lastToken == null) {
                break;
            }
        } while (!z);
        XmlToken.BeginElement beginElement = (XmlToken.BeginElement) lastToken;
        if (beginElement == null) {
            throw new IllegalStateException(("expected start tag: last = " + xmlStreamReader.getLastToken()).toString());
        }
        return tagReader(beginElement, xmlStreamReader);
    }
}
