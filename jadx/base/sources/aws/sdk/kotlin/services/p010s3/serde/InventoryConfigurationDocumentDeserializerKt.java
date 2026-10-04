package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryConfiguration;
import aws.sdk.kotlin.services.p010s3.model.InventoryIncludedObjectVersions;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: InventoryConfigurationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeInventoryConfigurationDocument", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryConfigurationDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final InventoryConfiguration deserializeInventoryConfigurationDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        InventoryConfiguration.Builder builder = new InventoryConfiguration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1292855562:
                    if (tagName.equals("IncludedObjectVersions")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setIncludedObjectVersions((InventoryIncludedObjectVersions) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(InventoryIncludedObjectVersions.INSTANCE.fromValue((String) objTryData));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objTryData = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#InventoryIncludedObjectVersions`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setIncludedObjectVersions((InventoryIncludedObjectVersions) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -633276745:
                    if (tagName.equals("Schedule")) {
                        builder.setSchedule(InventoryScheduleDocumentDeserializerKt.deserializeInventoryScheduleDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -185404777:
                    if (tagName.equals("IsEnabled")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsEnabled`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setEnabled((Boolean) objM14499constructorimpl2);
                    }
                    break;
                case 2363:
                    if (tagName.equals("Id")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#InventoryId`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setId((String) objTryData2);
                    }
                    break;
                case 238021614:
                    if (tagName.equals(HttpHeaders.DESTINATION)) {
                        builder.setDestination(InventoryDestinationDocumentDeserializerKt.deserializeInventoryDestinationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 1731033689:
                    if (tagName.equals("OptionalFields")) {
                        builder.setOptionalFields(InventoryOptionalFieldsShapeDeserializerKt.deserializeInventoryOptionalFieldsShape(xmlTagReaderNextTag));
                    }
                    break;
                case 2104342424:
                    if (tagName.equals("Filter")) {
                        builder.setFilter(InventoryFilterDocumentDeserializerKt.deserializeInventoryFilterDocument(xmlTagReaderNextTag));
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
