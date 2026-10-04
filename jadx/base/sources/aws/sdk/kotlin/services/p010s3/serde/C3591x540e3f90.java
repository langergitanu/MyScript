package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ReplicationTimeValue;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ReplicationTimeDocumentSerializerKt$serializeReplicationTimeDocument$1$1$1 */
/* JADX INFO: compiled from: ReplicationTimeDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3591x540e3f90 extends FunctionReferenceImpl implements Function2<Serializer, ReplicationTimeValue, Unit> {
    public static final C3591x540e3f90 INSTANCE = new C3591x540e3f90();

    C3591x540e3f90() {
        super(2, ReplicationTimeValueDocumentSerializerKt.class, "serializeReplicationTimeValueDocument", "serializeReplicationTimeValueDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ReplicationTimeValue;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ReplicationTimeValue replicationTimeValue) {
        invoke2(serializer, replicationTimeValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ReplicationTimeValue p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ReplicationTimeValueDocumentSerializerKt.serializeReplicationTimeValueDocument(p0, p1);
    }
}
