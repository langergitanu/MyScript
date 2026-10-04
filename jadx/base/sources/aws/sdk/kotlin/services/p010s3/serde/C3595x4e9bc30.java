package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Condition;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.RoutingRuleDocumentSerializerKt$serializeRoutingRuleDocument$1$1$1 */
/* JADX INFO: compiled from: RoutingRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3595x4e9bc30 extends FunctionReferenceImpl implements Function2<Serializer, Condition, Unit> {
    public static final C3595x4e9bc30 INSTANCE = new C3595x4e9bc30();

    C3595x4e9bc30() {
        super(2, ConditionDocumentSerializerKt.class, "serializeConditionDocument", "serializeConditionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Condition;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Condition condition) {
        invoke2(serializer, condition);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Condition p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ConditionDocumentSerializerKt.serializeConditionDocument(p0, p1);
    }
}
