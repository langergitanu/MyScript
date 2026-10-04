package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.JsonOutput;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.OutputSerializationDocumentSerializerKt$serializeOutputSerializationDocument$1$2$1 */
/* JADX INFO: compiled from: OutputSerializationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3574x24c5fb91 extends FunctionReferenceImpl implements Function2<Serializer, JsonOutput, Unit> {
    public static final C3574x24c5fb91 INSTANCE = new C3574x24c5fb91();

    C3574x24c5fb91() {
        super(2, JsonOutputDocumentSerializerKt.class, "serializeJsonOutputDocument", "serializeJsonOutputDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/JsonOutput;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, JsonOutput jsonOutput) {
        invoke2(serializer, jsonOutput);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, JsonOutput p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        JsonOutputDocumentSerializerKt.serializeJsonOutputDocument(p0, p1);
    }
}
