package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringAndOperator;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.IntelligentTieringFilterDocumentSerializerKt$serializeIntelligentTieringFilterDocument$1$1$1 */
/* JADX INFO: compiled from: IntelligentTieringFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3522x78ba52d6 extends FunctionReferenceImpl implements Function2<Serializer, IntelligentTieringAndOperator, Unit> {
    public static final C3522x78ba52d6 INSTANCE = new C3522x78ba52d6();

    C3522x78ba52d6() {
        super(2, IntelligentTieringAndOperatorDocumentSerializerKt.class, "serializeIntelligentTieringAndOperatorDocument", "serializeIntelligentTieringAndOperatorDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/IntelligentTieringAndOperator;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, IntelligentTieringAndOperator intelligentTieringAndOperator) {
        invoke2(serializer, intelligentTieringAndOperator);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, IntelligentTieringAndOperator p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        IntelligentTieringAndOperatorDocumentSerializerKt.serializeIntelligentTieringAndOperatorDocument(p0, p1);
    }
}
