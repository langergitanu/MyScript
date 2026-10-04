package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Grantee;
import aws.sdk.kotlin.services.p010s3.model.Type;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GranteeDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeGranteeDocument", "Laws/sdk/kotlin/services/s3/model/Grantee;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GranteeDocumentDeserializerKt {
    public static final Grantee deserializeGranteeDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Grantee.Builder builder = new Grantee.Builder();
        String attr = reader.getTag().getAttr("xsi:type");
        if (attr != null) {
            builder.setType(Type.INSTANCE.fromValue(attr));
        }
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            int iHashCode = tagName.hashCode();
            if (iHashCode != -912949683) {
                if (iHashCode != -906611496) {
                    if (iHashCode != 2331) {
                        if (iHashCode == 84300 && tagName.equals("URI")) {
                            Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion = Result.INSTANCE;
                                objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#URI`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objTryData);
                            builder.setUri((String) objTryData);
                        }
                    } else if (tagName.equals("ID")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ID`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setId((String) objTryData2);
                    }
                } else if (tagName.equals("EmailAddress")) {
                    Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                    if (thM14502exceptionOrNullimpl3 != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#EmailAddress`)", thM14502exceptionOrNullimpl3)));
                    }
                    ResultKt.throwOnFailure(objTryData3);
                    builder.setEmailAddress((String) objTryData3);
                }
            } else if (tagName.equals("DisplayName")) {
                Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData4);
                if (thM14502exceptionOrNullimpl4 != null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#DisplayName`)", thM14502exceptionOrNullimpl4)));
                }
                ResultKt.throwOnFailure(objTryData4);
                builder.setDisplayName((String) objTryData4);
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
