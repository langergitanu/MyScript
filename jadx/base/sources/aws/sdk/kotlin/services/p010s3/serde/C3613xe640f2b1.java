package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SseKmsEncryptedObjects;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SourceSelectionCriteriaDocumentSerializerKt$serializeSourceSelectionCriteriaDocument$1$2$1 */
/* JADX INFO: compiled from: SourceSelectionCriteriaDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3613xe640f2b1 extends FunctionReferenceImpl implements Function2<Serializer, SseKmsEncryptedObjects, Unit> {
    public static final C3613xe640f2b1 INSTANCE = new C3613xe640f2b1();

    C3613xe640f2b1() {
        super(2, SseKmsEncryptedObjectsDocumentSerializerKt.class, "serializeSseKmsEncryptedObjectsDocument", "serializeSseKmsEncryptedObjectsDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, SseKmsEncryptedObjects sseKmsEncryptedObjects) {
        invoke2(serializer, sseKmsEncryptedObjects);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, SseKmsEncryptedObjects p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        SseKmsEncryptedObjectsDocumentSerializerKt.serializeSseKmsEncryptedObjectsDocument(p0, p1);
    }
}
