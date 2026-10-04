package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.S3TablesDestination;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.MetadataTableConfigurationPayloadSerializerKt$serializeMetadataTableConfigurationPayloadWithXmlNameMetadataTableConfiguration$1$1$1 */
/* JADX INFO: compiled from: MetadataTableConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3559xe8c5731 extends FunctionReferenceImpl implements Function2<Serializer, S3TablesDestination, Unit> {
    public static final C3559xe8c5731 INSTANCE = new C3559xe8c5731();

    C3559xe8c5731() {
        super(2, S3TablesDestinationDocumentSerializerKt.class, "serializeS3TablesDestinationDocument", "serializeS3TablesDestinationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/S3TablesDestination;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, S3TablesDestination s3TablesDestination) {
        invoke2(serializer, s3TablesDestination);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, S3TablesDestination p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        S3TablesDestinationDocumentSerializerKt.serializeS3TablesDestinationDocument(p0, p1);
    }
}
