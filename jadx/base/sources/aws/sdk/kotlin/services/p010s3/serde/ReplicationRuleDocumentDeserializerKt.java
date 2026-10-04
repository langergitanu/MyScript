package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRule;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleStatus;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: ReplicationRuleDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeReplicationRuleDocument", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReplicationRuleDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ReplicationRule deserializeReplicationRuleDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReplicationRule.Builder builder = new ReplicationRule.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1896243534:
                    if (tagName.equals(TextFieldImplKt.PrefixId)) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setPrefix((String) objTryData);
                    }
                    break;
                case -1808614382:
                    if (tagName.equals("Status")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData2)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStatus((ReplicationRuleStatus) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ReplicationRuleStatus.INSTANCE.fromValue((String) objTryData2));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objTryData2 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData2);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ReplicationRuleStatus`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setStatus((ReplicationRuleStatus) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -1100816956:
                    if (tagName.equals("Priority")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#Priority`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setPriority((Integer) objM14499constructorimpl2);
                    }
                    break;
                case PDFACompliance.e_PDFA2_3_3_1 /* 2331 */:
                    if (tagName.equals("ID")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ID`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setId((String) objTryData3);
                    }
                    break;
                case 196825255:
                    if (tagName.equals("DeleteMarkerReplication")) {
                        builder.setDeleteMarkerReplication(DeleteMarkerReplicationDocumentDeserializerKt.deserializeDeleteMarkerReplicationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 238021614:
                    if (tagName.equals(HttpHeaders.DESTINATION)) {
                        builder.setDestination(DestinationDocumentDeserializerKt.deserializeDestinationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 933212322:
                    if (tagName.equals("ExistingObjectReplication")) {
                        builder.setExistingObjectReplication(ExistingObjectReplicationDocumentDeserializerKt.deserializeExistingObjectReplicationDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 1872294416:
                    if (tagName.equals("SourceSelectionCriteria")) {
                        builder.setSourceSelectionCriteria(SourceSelectionCriteriaDocumentDeserializerKt.deserializeSourceSelectionCriteriaDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 2104342424:
                    if (tagName.equals("Filter")) {
                        builder.setFilter(ReplicationRuleFilterDocumentDeserializerKt.deserializeReplicationRuleFilterDocument(xmlTagReaderNextTag));
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
