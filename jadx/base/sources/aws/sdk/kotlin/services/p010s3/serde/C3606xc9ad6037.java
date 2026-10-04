package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ScanRange;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationSerializerKt$serializeSelectObjectContentOperationBody$1$6$1 */
/* JADX INFO: compiled from: SelectObjectContentOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3606xc9ad6037 extends FunctionReferenceImpl implements Function2<Serializer, ScanRange, Unit> {
    public static final C3606xc9ad6037 INSTANCE = new C3606xc9ad6037();

    C3606xc9ad6037() {
        super(2, ScanRangeDocumentSerializerKt.class, "serializeScanRangeDocument", "serializeScanRangeDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ScanRange;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ScanRange scanRange) {
        invoke2(serializer, scanRange);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ScanRange p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ScanRangeDocumentSerializerKt.serializeScanRangeDocument(p0, p1);
    }
}
