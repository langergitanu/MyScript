package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryEncryption;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryS3BucketDestinationDocumentSerializerKt$serializeInventoryS3BucketDestinationDocument$1$2$1 */
/* JADX INFO: compiled from: InventoryS3BucketDestinationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3531x34d5e0a5 extends FunctionReferenceImpl implements Function2<Serializer, InventoryEncryption, Unit> {
    public static final C3531x34d5e0a5 INSTANCE = new C3531x34d5e0a5();

    C3531x34d5e0a5() {
        super(2, InventoryEncryptionDocumentSerializerKt.class, "serializeInventoryEncryptionDocument", "serializeInventoryEncryptionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/InventoryEncryption;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, InventoryEncryption inventoryEncryption) {
        invoke2(serializer, inventoryEncryption);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, InventoryEncryption p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        InventoryEncryptionDocumentSerializerKt.serializeInventoryEncryptionDocument(p0, p1);
    }
}
