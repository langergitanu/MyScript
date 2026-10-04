package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ec2QueryErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryErrorResponseDeserializer;", "", "<init>", "()V", "deserialize", "Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryErrorResponse;", "root", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Ec2QueryErrorResponseDeserializer {
    public static final Ec2QueryErrorResponseDeserializer INSTANCE = new Ec2QueryErrorResponseDeserializer();

    private Ec2QueryErrorResponseDeserializer() {
    }

    public final Ec2QueryErrorResponse deserialize(XmlTagReader root) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(root, "root");
        try {
            Result.Companion companion = Result.INSTANCE;
            Ec2QueryErrorResponseDeserializer ec2QueryErrorResponseDeserializer = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (Intrinsics.areEqual(root.getTagName(), "Response")) {
            List<Ec2QueryError> listEmptyList = null;
            String strData = null;
            while (true) {
                XmlTagReader xmlTagReaderNextTag = root.nextTag();
                if (xmlTagReaderNextTag == null) {
                    break;
                }
                String tagName = xmlTagReaderNextTag.getTagName();
                if (Intrinsics.areEqual(tagName, "Errors")) {
                    listEmptyList = Ec2QueryErrorListDeserializer.INSTANCE.deserialize(xmlTagReaderNextTag);
                } else if (Intrinsics.areEqual(tagName, "RequestId")) {
                    strData = XmlTagReaderKt.data(xmlTagReaderNextTag);
                }
                xmlTagReaderNextTag.drop();
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            objM14499constructorimpl = Result.m14499constructorimpl(new Ec2QueryErrorResponse(listEmptyList, strData));
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("Unable to deserialize EC2Query error", thM14502exceptionOrNullimpl)));
            }
            ResultKt.throwOnFailure(objM14499constructorimpl);
            return (Ec2QueryErrorResponse) objM14499constructorimpl;
        }
        throw new IllegalStateException(("expected <Response> found " + root.getTag()).toString());
    }
}
