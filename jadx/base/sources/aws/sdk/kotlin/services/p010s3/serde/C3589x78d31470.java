package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleAndOperator;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ReplicationRuleFilterDocumentSerializerKt$serializeReplicationRuleFilterDocument$1$1$1 */
/* JADX INFO: compiled from: ReplicationRuleFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3589x78d31470 extends FunctionReferenceImpl implements Function2<Serializer, ReplicationRuleAndOperator, Unit> {
    public static final C3589x78d31470 INSTANCE = new C3589x78d31470();

    C3589x78d31470() {
        super(2, ReplicationRuleAndOperatorDocumentSerializerKt.class, "serializeReplicationRuleAndOperatorDocument", "serializeReplicationRuleAndOperatorDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ReplicationRuleAndOperator;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ReplicationRuleAndOperator replicationRuleAndOperator) {
        invoke2(serializer, replicationRuleAndOperator);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ReplicationRuleAndOperator p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ReplicationRuleAndOperatorDocumentSerializerKt.serializeReplicationRuleAndOperatorDocument(p0, p1);
    }
}
