package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.DefaultRetention;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ObjectLockRuleDocumentSerializerKt$serializeObjectLockRuleDocument$1$1$1 */
/* JADX INFO: compiled from: ObjectLockRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3571xec2805a0 extends FunctionReferenceImpl implements Function2<Serializer, DefaultRetention, Unit> {
    public static final C3571xec2805a0 INSTANCE = new C3571xec2805a0();

    C3571xec2805a0() {
        super(2, DefaultRetentionDocumentSerializerKt.class, "serializeDefaultRetentionDocument", "serializeDefaultRetentionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/DefaultRetention;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, DefaultRetention defaultRetention) {
        invoke2(serializer, defaultRetention);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, DefaultRetention p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        DefaultRetentionDocumentSerializerKt.serializeDefaultRetentionDocument(p0, p1);
    }
}
