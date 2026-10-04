package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Destination;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DestinationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeDestinationDocument", "Laws/sdk/kotlin/services/s3/model/Destination;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DestinationDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Destination deserializeDestinationDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Destination.Builder builder = new Destination.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1674487645:
                    if (tagName.equals("Metrics")) {
                        builder.setMetrics(MetricsDocumentDeserializerKt.deserializeMetricsDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -1119502183:
                    if (tagName.equals("ReplicationTime")) {
                        builder.setReplicationTime(ReplicationTimeDocumentDeserializerKt.deserializeReplicationTimeDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -1082721773:
                    if (tagName.equals("EncryptionConfiguration")) {
                        builder.setEncryptionConfiguration(EncryptionConfigurationDocumentDeserializerKt.deserializeEncryptionConfigurationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 487334413:
                    if (tagName.equals("Account")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#AccountId`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setAccount((String) objTryData);
                    }
                    break;
                case 1035673565:
                    if (tagName.equals("StorageClass")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData2)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStorageClass((StorageClass) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(StorageClass.INSTANCE.fromValue((String) objTryData2));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objTryData2 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#StorageClass`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStorageClass((StorageClass) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case 1627958712:
                    if (tagName.equals("AccessControlTranslation")) {
                        builder.setAccessControlTranslation(AccessControlTranslationDocumentDeserializerKt.deserializeAccessControlTranslationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 2000631306:
                    if (tagName.equals("Bucket")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#BucketName`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setBucket((String) objTryData3);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
