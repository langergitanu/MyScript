package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventorySchedule;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryConfigurationPayloadSerializerKt$serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration$1$4$1 */
/* JADX INFO: compiled from: InventoryConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3527xa1a44777 extends FunctionReferenceImpl implements Function2<Serializer, InventorySchedule, Unit> {
    public static final C3527xa1a44777 INSTANCE = new C3527xa1a44777();

    C3527xa1a44777() {
        super(2, InventoryScheduleDocumentSerializerKt.class, "serializeInventoryScheduleDocument", "serializeInventoryScheduleDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/InventorySchedule;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, InventorySchedule inventorySchedule) {
        invoke2(serializer, inventorySchedule);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, InventorySchedule p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        InventoryScheduleDocumentSerializerKt.serializeInventoryScheduleDocument(p0, p1);
    }
}
