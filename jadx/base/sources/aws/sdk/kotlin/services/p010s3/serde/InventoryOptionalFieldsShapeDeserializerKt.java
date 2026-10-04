package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InventoryOptionalFieldsShapeDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"deserializeInventoryOptionalFieldsShape", "", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryOptionalFieldsShapeDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<InventoryOptionalField> deserializeInventoryOptionalFieldsShape(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return arrayList;
            }
            if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Field")) {
                Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                if (Result.m14506isSuccessimpl(objTryData)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM14499constructorimpl = Result.m14499constructorimpl(InventoryOptionalField.INSTANCE.fromValue((String) objTryData));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objTryData = ResultKt.createFailure(th);
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                    }
                    thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                    if (thM14502exceptionOrNullimpl != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#InventoryOptionalField`)", thM14502exceptionOrNullimpl)));
                    }
                    ResultKt.throwOnFailure(objM14499constructorimpl);
                    arrayList.add((InventoryOptionalField) objM14499constructorimpl);
                } else {
                    objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                    thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                    if (thM14502exceptionOrNullimpl != null) {
                    }
                    ResultKt.throwOnFailure(objM14499constructorimpl);
                    arrayList.add((InventoryOptionalField) objM14499constructorimpl);
                }
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
