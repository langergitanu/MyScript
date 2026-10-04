package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleFilter;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleRuleFilterDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeLifecycleRuleFilterDocument", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleFilterDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final LifecycleRuleFilter deserializeLifecycleRuleFilterDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        LifecycleRuleFilter.Builder builder = new LifecycleRuleFilter.Builder();
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
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setPrefix((String) objTryData);
                    }
                    break;
                case -1052988261:
                    if (tagName.equals("ObjectSizeGreaterThan")) {
                        Object objM14499constructorimpl = ParsersKt.parseLong(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (long: `com.amazonaws.s3#ObjectSizeGreaterThanBytes`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setObjectSizeGreaterThan((Long) objM14499constructorimpl);
                    }
                    break;
                case -889950470:
                    if (tagName.equals("ObjectSizeLessThan")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseLong(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (long: `com.amazonaws.s3#ObjectSizeLessThanBytes`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setObjectSizeLessThan((Long) objM14499constructorimpl2);
                    }
                    break;
                case 65975:
                    if (tagName.equals("And")) {
                        builder.setAnd(LifecycleRuleAndOperatorDocumentDeserializerKt.deserializeLifecycleRuleAndOperatorDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 83834:
                    if (tagName.equals("Tag")) {
                        builder.setTag(TagDocumentDeserializerKt.deserializeTagDocument(xmlTagReaderNextTag));
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
