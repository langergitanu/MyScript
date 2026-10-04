package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryptionRule;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServerSideEncryptionRuleDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeServerSideEncryptionRuleDocument", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionRule;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ServerSideEncryptionRuleDocumentDeserializerKt {
    public static final ServerSideEncryptionRule deserializeServerSideEncryptionRuleDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        ServerSideEncryptionRule.Builder builder = new ServerSideEncryptionRule.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                int iHashCode = tagName.hashCode();
                if (iHashCode != -1516318881) {
                    if (iHashCode != -1170571446) {
                        if (iHashCode == -262342260 && tagName.equals("BucketKeyEnabled")) {
                            Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#BucketKeyEnabled`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setBucketKeyEnabled((Boolean) objM14499constructorimpl);
                        }
                    } else if (tagName.equals("BlockedEncryptionTypes")) {
                        builder.setBlockedEncryptionTypes(BlockedEncryptionTypesDocumentDeserializerKt.deserializeBlockedEncryptionTypesDocument(xmlTagReaderNextTag));
                    }
                } else if (tagName.equals("ApplyServerSideEncryptionByDefault")) {
                    builder.setApplyServerSideEncryptionByDefault(ServerSideEncryptionByDefaultDocumentDeserializerKt.deserializeServerSideEncryptionByDefaultDocument(xmlTagReaderNextTag));
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
