package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.MetadataTableEncryptionConfiguration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryTableConfigurationUpdatesPayloadSerializerKt$serializeInventoryTableConfigurationUpdatesPayloadWithXmlNameInventoryTableConfiguration$1$1$1 */
/* JADX INFO: compiled from: InventoryTableConfigurationUpdatesPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3533x84818e38 extends FunctionReferenceImpl implements Function2<Serializer, MetadataTableEncryptionConfiguration, Unit> {
    public static final C3533x84818e38 INSTANCE = new C3533x84818e38();

    C3533x84818e38() {
        super(2, MetadataTableEncryptionConfigurationDocumentSerializerKt.class, "serializeMetadataTableEncryptionConfigurationDocument", "serializeMetadataTableEncryptionConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/MetadataTableEncryptionConfiguration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, MetadataTableEncryptionConfiguration metadataTableEncryptionConfiguration) {
        invoke2(serializer, metadataTableEncryptionConfiguration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, MetadataTableEncryptionConfiguration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        MetadataTableEncryptionConfigurationDocumentSerializerKt.serializeMetadataTableEncryptionConfigurationDocument(p0, p1);
    }
}
