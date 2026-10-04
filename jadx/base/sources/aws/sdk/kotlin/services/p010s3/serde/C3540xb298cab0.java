package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AbortIncompleteMultipartUpload;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$1$1 */
/* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3540xb298cab0 extends FunctionReferenceImpl implements Function2<Serializer, AbortIncompleteMultipartUpload, Unit> {
    public static final C3540xb298cab0 INSTANCE = new C3540xb298cab0();

    C3540xb298cab0() {
        super(2, AbortIncompleteMultipartUploadDocumentSerializerKt.class, "serializeAbortIncompleteMultipartUploadDocument", "serializeAbortIncompleteMultipartUploadDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
        invoke2(serializer, abortIncompleteMultipartUpload);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, AbortIncompleteMultipartUpload p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AbortIncompleteMultipartUploadDocumentSerializerKt.serializeAbortIncompleteMultipartUploadDocument(p0, p1);
    }
}
