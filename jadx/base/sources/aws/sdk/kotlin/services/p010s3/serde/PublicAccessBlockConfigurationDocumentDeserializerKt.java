package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.PublicAccessBlockConfiguration;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PublicAccessBlockConfigurationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializePublicAccessBlockConfigurationDocument", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PublicAccessBlockConfigurationDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final PublicAccessBlockConfiguration deserializePublicAccessBlockConfigurationDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        PublicAccessBlockConfiguration.Builder builder = new PublicAccessBlockConfiguration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -221833308:
                    if (tagName.equals("RestrictPublicBuckets")) {
                        Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#Setting`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setRestrictPublicBuckets((Boolean) objM14499constructorimpl);
                    }
                    break;
                case -58118273:
                    if (tagName.equals("BlockPublicAcls")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#Setting`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setBlockPublicAcls((Boolean) objM14499constructorimpl2);
                    }
                    break;
                case 94364356:
                    if (tagName.equals("IgnorePublicAcls")) {
                        Object objM14499constructorimpl3 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#Setting`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl3);
                        builder.setIgnorePublicAcls((Boolean) objM14499constructorimpl3);
                    }
                    break;
                case 423427592:
                    if (tagName.equals("BlockPublicPolicy")) {
                        Object objM14499constructorimpl4 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl4);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#Setting`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl4);
                        builder.setBlockPublicPolicy((Boolean) objM14499constructorimpl4);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
