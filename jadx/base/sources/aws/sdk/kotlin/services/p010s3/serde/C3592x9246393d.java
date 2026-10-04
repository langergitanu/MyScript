package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.GlacierJobParameters;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.RestoreRequestPayloadSerializerKt$serializeRestoreRequestPayloadWithXmlNameRestoreRequest$1$3$1 */
/* JADX INFO: compiled from: RestoreRequestPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3592x9246393d extends FunctionReferenceImpl implements Function2<Serializer, GlacierJobParameters, Unit> {
    public static final C3592x9246393d INSTANCE = new C3592x9246393d();

    C3592x9246393d() {
        super(2, GlacierJobParametersDocumentSerializerKt.class, "serializeGlacierJobParametersDocument", "serializeGlacierJobParametersDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/GlacierJobParameters;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, GlacierJobParameters glacierJobParameters) {
        invoke2(serializer, glacierJobParameters);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, GlacierJobParameters p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        GlacierJobParametersDocumentSerializerKt.serializeGlacierJobParametersDocument(p0, p1);
    }
}
