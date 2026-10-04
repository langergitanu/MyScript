package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.GetObjectAttributesParts;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetObjectAttributesPartsDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeGetObjectAttributesPartsDocument", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectAttributesPartsDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final GetObjectAttributesParts deserializeGetObjectAttributesPartsDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        GetObjectAttributesParts.Builder builder = new GetObjectAttributesParts.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -2019824081:
                    if (tagName.equals("PartsCount")) {
                        Object objM14499constructorimpl = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#PartsCount`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setTotalPartsCount((Integer) objM14499constructorimpl);
                    }
                    break;
                case -668327511:
                    if (tagName.equals("NextPartNumberMarker")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NextPartNumberMarker`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setNextPartNumberMarker((String) objTryData);
                    }
                    break;
                case 2480147:
                    if (tagName.equals("Part")) {
                        builder.setParts(CollectionExtKt.createOrAppend(builder.getParts(), ObjectPartDocumentDeserializerKt.deserializeObjectPartDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case 159271316:
                    if (tagName.equals("IsTruncated")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsTruncated`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setTruncated((Boolean) objM14499constructorimpl2);
                    }
                    break;
                case 458336252:
                    if (tagName.equals("MaxParts")) {
                        Object objM14499constructorimpl3 = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#MaxParts`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl3);
                        builder.setMaxParts((Integer) objM14499constructorimpl3);
                    }
                    break;
                case 1866967190:
                    if (tagName.equals("PartNumberMarker")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#PartNumberMarker`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setPartNumberMarker((String) objTryData2);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
