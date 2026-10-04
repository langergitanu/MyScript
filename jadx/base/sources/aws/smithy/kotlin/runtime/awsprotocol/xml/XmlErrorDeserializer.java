package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RestXmlErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/XmlErrorDeserializer;", "", "<init>", "()V", "deserialize", "Laws/smithy/kotlin/runtime/awsprotocol/xml/XmlError;", "root", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlErrorDeserializer {
    public static final XmlErrorDeserializer INSTANCE = new XmlErrorDeserializer();

    private XmlErrorDeserializer() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final XmlError deserialize(XmlTagReader root) {
        Object objM14499constructorimpl;
        XmlTagReader xmlTagReaderNextTag;
        String strData;
        String strData2;
        Intrinsics.checkNotNullParameter(root, "root");
        try {
            Result.Companion companion = Result.INSTANCE;
            XmlErrorDeserializer xmlErrorDeserializer = this;
            String tagName = root.getTagName();
            if (!Intrinsics.areEqual(tagName, "ErrorResponse") && !Intrinsics.areEqual(tagName, "Error")) {
                throw new IllegalStateException("expected restXml error response with root tag of <ErrorResponse> or <Error>".toString());
            }
            if (Intrinsics.areEqual(root.getTagName(), "ErrorResponse")) {
                xmlTagReaderNextTag = root.nextTag();
                if (xmlTagReaderNextTag == null) {
                    throw new IllegalStateException("expected more tags after <ErrorResponse>".toString());
                }
            } else {
                xmlTagReaderNextTag = root;
            }
            String strData3 = null;
            if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Error")) {
                strData = null;
                strData2 = null;
                while (true) {
                    XmlTagReader xmlTagReaderNextTag2 = xmlTagReaderNextTag.nextTag();
                    if (xmlTagReaderNextTag2 != null) {
                        String tagName2 = xmlTagReaderNextTag2.getTagName();
                        switch (tagName2.hashCode()) {
                            case -1675388953:
                                if (!tagName2.equals("Message")) {
                                }
                                xmlTagReaderNextTag2.drop();
                                break;
                            case -1597066262:
                                if (tagName2.equals("RequestId")) {
                                    strData3 = XmlTagReaderKt.data(xmlTagReaderNextTag2);
                                } else {
                                    continue;
                                }
                                xmlTagReaderNextTag2.drop();
                                break;
                            case 2105869:
                                if (tagName2.equals("Code")) {
                                    strData2 = XmlTagReaderKt.data(xmlTagReaderNextTag2);
                                } else {
                                    continue;
                                }
                                xmlTagReaderNextTag2.drop();
                                break;
                            case 954925063:
                                if (!tagName2.equals("message")) {
                                }
                                xmlTagReaderNextTag2.drop();
                                break;
                            default:
                                continue;
                                xmlTagReaderNextTag2.drop();
                                break;
                        }
                        strData = XmlTagReaderKt.data(xmlTagReaderNextTag2);
                        xmlTagReaderNextTag2.drop();
                    }
                }
            } else {
                strData = null;
                strData2 = null;
            }
            if (strData3 == null) {
                while (true) {
                    XmlTagReader xmlTagReaderNextTag3 = root.nextTag();
                    if (xmlTagReaderNextTag3 != null) {
                        if (Intrinsics.areEqual(xmlTagReaderNextTag3.getTagName(), "RequestId")) {
                            strData3 = XmlTagReaderKt.data(xmlTagReaderNextTag3);
                        }
                    }
                }
            }
            objM14499constructorimpl = Result.m14499constructorimpl(new XmlError(strData3, strData2, strData));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            Result.Companion companion3 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("Unable to deserialize RestXml error", thM14502exceptionOrNullimpl)));
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return (XmlError) objM14499constructorimpl;
    }
}
