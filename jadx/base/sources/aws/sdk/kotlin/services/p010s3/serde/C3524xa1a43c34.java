package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryDestination;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryConfigurationPayloadSerializerKt$serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration$1$1$1 */
/* JADX INFO: compiled from: InventoryConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3524xa1a43c34 extends FunctionReferenceImpl implements Function2<Serializer, InventoryDestination, Unit> {
    public static final C3524xa1a43c34 INSTANCE = new C3524xa1a43c34();

    C3524xa1a43c34() {
        super(2, InventoryDestinationDocumentSerializerKt.class, "serializeInventoryDestinationDocument", "serializeInventoryDestinationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/InventoryDestination;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, InventoryDestination inventoryDestination) {
        invoke2(serializer, inventoryDestination);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, InventoryDestination p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        InventoryDestinationDocumentSerializerKt.serializeInventoryDestinationDocument(p0, p1);
    }
}
