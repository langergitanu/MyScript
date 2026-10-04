package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Sses3;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.InventoryEncryptionDocumentSerializerKt$serializeInventoryEncryptionDocument$1$2$1 */
/* JADX INFO: compiled from: InventoryEncryptionDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3530x96dc8d91 extends FunctionReferenceImpl implements Function2<Serializer, Sses3, Unit> {
    public static final C3530x96dc8d91 INSTANCE = new C3530x96dc8d91();

    C3530x96dc8d91() {
        super(2, Sses3DocumentSerializerKt.class, "serializeSses3Document", "serializeSses3Document(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Sses3;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Sses3 sses3) {
        invoke2(serializer, sses3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Sses3 p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Sses3DocumentSerializerKt.serializeSses3Document(p0, p1);
    }
}
