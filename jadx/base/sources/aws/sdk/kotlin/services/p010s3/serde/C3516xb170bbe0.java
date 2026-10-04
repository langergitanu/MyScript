package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CsvInput;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InputSerializationDocumentSerializerKt$serializeInputSerializationDocument$1$1$1 */
/* JADX INFO: compiled from: InputSerializationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3516xb170bbe0 extends FunctionReferenceImpl implements Function2<Serializer, CsvInput, Unit> {
    public static final C3516xb170bbe0 INSTANCE = new C3516xb170bbe0();

    C3516xb170bbe0() {
        super(2, CsvInputDocumentSerializerKt.class, "serializeCsvInputDocument", "serializeCsvInputDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/CsvInput;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, CsvInput csvInput) {
        invoke2(serializer, csvInput);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, CsvInput p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        CsvInputDocumentSerializerKt.serializeCsvInputDocument(p0, p1);
    }
}
