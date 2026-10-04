package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryFilter;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryConfigurationPayloadSerializerKt$serializeInventoryConfigurationPayloadWithXmlNameInventoryConfiguration$1$2$1 */
/* JADX INFO: compiled from: InventoryConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3525xa1a43ff5 extends FunctionReferenceImpl implements Function2<Serializer, InventoryFilter, Unit> {
    public static final C3525xa1a43ff5 INSTANCE = new C3525xa1a43ff5();

    C3525xa1a43ff5() {
        super(2, InventoryFilterDocumentSerializerKt.class, "serializeInventoryFilterDocument", "serializeInventoryFilterDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/InventoryFilter;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, InventoryFilter inventoryFilter) {
        invoke2(serializer, inventoryFilter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, InventoryFilter p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        InventoryFilterDocumentSerializerKt.serializeInventoryFilterDocument(p0, p1);
    }
}
