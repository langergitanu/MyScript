package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.DeletedObject;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeletedObjectDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeDeletedObjectDocument", "Laws/sdk/kotlin/services/s3/model/DeletedObject;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeletedObjectDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final DeletedObject deserializeDeletedObjectDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        DeletedObject.Builder builder = new DeletedObject.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -785043995:
                    if (tagName.equals("DeleteMarker")) {
                        Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#DeleteMarker`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setDeleteMarker((Boolean) objM14499constructorimpl);
                    }
                    break;
                case 75327:
                    if (tagName.equals("Key")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ObjectKey`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setKey((String) objTryData);
                    }
                    break;
                case 596865011:
                    if (tagName.equals("VersionId")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ObjectVersionId`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setVersionId((String) objTryData2);
                    }
                    break;
                case 1284707246:
                    if (tagName.equals("DeleteMarkerVersionId")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#DeleteMarkerVersionId`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setDeleteMarkerVersionId((String) objTryData3);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
