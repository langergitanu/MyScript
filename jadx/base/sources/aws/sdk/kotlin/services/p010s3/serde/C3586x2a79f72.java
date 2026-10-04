package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ExistingObjectReplication;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ReplicationRuleDocumentSerializerKt$serializeReplicationRuleDocument$1$3$1 */
/* JADX INFO: compiled from: ReplicationRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3586x2a79f72 extends FunctionReferenceImpl implements Function2<Serializer, ExistingObjectReplication, Unit> {
    public static final C3586x2a79f72 INSTANCE = new C3586x2a79f72();

    C3586x2a79f72() {
        super(2, ExistingObjectReplicationDocumentSerializerKt.class, "serializeExistingObjectReplicationDocument", "serializeExistingObjectReplicationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ExistingObjectReplication existingObjectReplication) {
        invoke2(serializer, existingObjectReplication);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ExistingObjectReplication p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ExistingObjectReplicationDocumentSerializerKt.serializeExistingObjectReplicationDocument(p0, p1);
    }
}
