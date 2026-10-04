package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ObjectLockRule;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ObjectLockConfigurationPayloadSerializerKt$serializeObjectLockConfigurationPayloadWithXmlNameObjectLockConfiguration$1$2$1 */
/* JADX INFO: compiled from: ObjectLockConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3570xdca91693 extends FunctionReferenceImpl implements Function2<Serializer, ObjectLockRule, Unit> {
    public static final C3570xdca91693 INSTANCE = new C3570xdca91693();

    C3570xdca91693() {
        super(2, ObjectLockRuleDocumentSerializerKt.class, "serializeObjectLockRuleDocument", "serializeObjectLockRuleDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/ObjectLockRule;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, ObjectLockRule objectLockRule) {
        invoke2(serializer, objectLockRule);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, ObjectLockRule p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ObjectLockRuleDocumentSerializerKt.serializeObjectLockRuleDocument(p0, p1);
    }
}
