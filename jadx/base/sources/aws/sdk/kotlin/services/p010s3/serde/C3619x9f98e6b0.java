package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.PartitionedPrefix;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.TargetObjectKeyFormatDocumentSerializerKt$serializeTargetObjectKeyFormatDocument$1$1$1 */
/* JADX INFO: compiled from: TargetObjectKeyFormatDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3619x9f98e6b0 extends FunctionReferenceImpl implements Function2<Serializer, PartitionedPrefix, Unit> {
    public static final C3619x9f98e6b0 INSTANCE = new C3619x9f98e6b0();

    C3619x9f98e6b0() {
        super(2, PartitionedPrefixDocumentSerializerKt.class, "serializePartitionedPrefixDocument", "serializePartitionedPrefixDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/PartitionedPrefix;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, PartitionedPrefix partitionedPrefix) {
        invoke2(serializer, partitionedPrefix);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, PartitionedPrefix p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        PartitionedPrefixDocumentSerializerKt.serializePartitionedPrefixDocument(p0, p1);
    }
}
