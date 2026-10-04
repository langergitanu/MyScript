package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryConfigurationState;
import aws.sdk.kotlin.services.p010s3.model.InventoryTableConfigurationResult;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InventoryTableConfigurationResultDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeInventoryTableConfigurationResultDocument", "Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryTableConfigurationResultDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final InventoryTableConfigurationResult deserializeInventoryTableConfigurationResultDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        InventoryTableConfigurationResult.Builder builder = new InventoryTableConfigurationResult.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1658272421:
                    if (tagName.equals("ConfigurationState")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setConfigurationState((InventoryConfigurationState) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(InventoryConfigurationState.INSTANCE.fromValue((String) objTryData));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objTryData = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#InventoryConfigurationState`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setConfigurationState((InventoryConfigurationState) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -830804017:
                    if (tagName.equals("TableArn")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#S3TablesArn`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setTableArn((String) objTryData2);
                    }
                    break;
                case 15250265:
                    if (tagName.equals("TableName")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#S3TablesName`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setTableName((String) objTryData3);
                    }
                    break;
                case 67232232:
                    if (tagName.equals("Error")) {
                        builder.setError(ErrorDetailsDocumentDeserializerKt.deserializeErrorDetailsDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 1930956096:
                    if (tagName.equals("TableStatus")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData4);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#MetadataTableStatus`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData4);
                        builder.setTableStatus((String) objTryData4);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
