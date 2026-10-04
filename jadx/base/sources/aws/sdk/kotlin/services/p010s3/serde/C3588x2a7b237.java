package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SourceSelectionCriteria;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ReplicationRuleDocumentSerializerKt$serializeReplicationRuleDocument$1$8$1 */
/* JADX INFO: compiled from: ReplicationRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3588x2a7b237 extends FunctionReferenceImpl implements Function2<Serializer, SourceSelectionCriteria, Unit> {
    public static final C3588x2a7b237 INSTANCE = new C3588x2a7b237();

    C3588x2a7b237() {
        super(2, SourceSelectionCriteriaDocumentSerializerKt.class, "serializeSourceSelectionCriteriaDocument", "serializeSourceSelectionCriteriaDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, SourceSelectionCriteria sourceSelectionCriteria) {
        invoke2(serializer, sourceSelectionCriteria);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, SourceSelectionCriteria p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SourceSelectionCriteriaDocumentSerializerKt.serializeSourceSelectionCriteriaDocument(p0, p1);
    }
}
