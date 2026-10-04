package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SelectParameters;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.RestoreRequestPayloadSerializerKt$serializeRestoreRequestPayloadWithXmlNameRestoreRequest$1$5$1 */
/* JADX INFO: compiled from: RestoreRequestPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3594x924640bf extends FunctionReferenceImpl implements Function2<Serializer, SelectParameters, Unit> {
    public static final C3594x924640bf INSTANCE = new C3594x924640bf();

    C3594x924640bf() {
        super(2, SelectParametersDocumentSerializerKt.class, "serializeSelectParametersDocument", "serializeSelectParametersDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/SelectParameters;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, SelectParameters selectParameters) {
        invoke2(serializer, selectParameters);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, SelectParameters p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SelectParametersDocumentSerializerKt.serializeSelectParametersDocument(p0, p1);
    }
}
