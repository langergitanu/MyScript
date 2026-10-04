package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleFilter;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ReplicationRuleDocumentSerializerKt$serializeReplicationRuleDocument$1$4$1 */
/* JADX INFO: compiled from: ReplicationRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3587x2a7a333 extends FunctionReferenceImpl implements Function2<Serializer, ReplicationRuleFilter, Unit> {
    public static final C3587x2a7a333 INSTANCE = new C3587x2a7a333();

    C3587x2a7a333() {
        super(2, ReplicationRuleFilterDocumentSerializerKt.class, "serializeReplicationRuleFilterDocument", "serializeReplicationRuleFilterDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ReplicationRuleFilter replicationRuleFilter) {
        invoke2(serializer, replicationRuleFilter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ReplicationRuleFilter p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ReplicationRuleFilterDocumentSerializerKt.serializeReplicationRuleFilterDocument(p0, p1);
    }
}
