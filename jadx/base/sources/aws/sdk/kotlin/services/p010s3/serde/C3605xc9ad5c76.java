package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.RequestProgress;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationSerializerKt$serializeSelectObjectContentOperationBody$1$5$1 */
/* JADX INFO: compiled from: SelectObjectContentOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3605xc9ad5c76 extends FunctionReferenceImpl implements Function2<Serializer, RequestProgress, Unit> {
    public static final C3605xc9ad5c76 INSTANCE = new C3605xc9ad5c76();

    C3605xc9ad5c76() {
        super(2, RequestProgressDocumentSerializerKt.class, "serializeRequestProgressDocument", "serializeRequestProgressDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/RequestProgress;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, RequestProgress requestProgress) {
        invoke2(serializer, requestProgress);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, RequestProgress p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        RequestProgressDocumentSerializerKt.serializeRequestProgressDocument(p0, p1);
    }
}
