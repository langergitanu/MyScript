package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SimplePrefix;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.TargetObjectKeyFormatDocumentSerializerKt$serializeTargetObjectKeyFormatDocument$1$2$1 */
/* JADX INFO: compiled from: TargetObjectKeyFormatDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3620x9f98ea71 extends FunctionReferenceImpl implements Function2<Serializer, SimplePrefix, Unit> {
    public static final C3620x9f98ea71 INSTANCE = new C3620x9f98ea71();

    C3620x9f98ea71() {
        super(2, SimplePrefixDocumentSerializerKt.class, "serializeSimplePrefixDocument", "serializeSimplePrefixDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/SimplePrefix;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, SimplePrefix simplePrefix) {
        invoke2(serializer, simplePrefix);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, SimplePrefix p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SimplePrefixDocumentSerializerKt.serializeSimplePrefixDocument(p0, p1);
    }
}
