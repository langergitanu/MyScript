package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.OutputSerialization;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectParametersDocumentSerializerKt$serializeSelectParametersDocument$1$2$1 */
/* JADX INFO: compiled from: SelectParametersDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3608xa0ac9d21 extends FunctionReferenceImpl implements Function2<Serializer, OutputSerialization, Unit> {
    public static final C3608xa0ac9d21 INSTANCE = new C3608xa0ac9d21();

    C3608xa0ac9d21() {
        super(2, OutputSerializationDocumentSerializerKt.class, "serializeOutputSerializationDocument", "serializeOutputSerializationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/OutputSerialization;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, OutputSerialization outputSerialization) {
        invoke2(serializer, outputSerialization);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, OutputSerialization p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        OutputSerializationDocumentSerializerKt.serializeOutputSerializationDocument(p0, p1);
    }
}
