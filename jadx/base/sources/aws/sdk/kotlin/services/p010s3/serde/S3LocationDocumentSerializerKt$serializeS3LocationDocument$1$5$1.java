package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Tagging;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3LocationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$5$1 extends FunctionReferenceImpl implements Function2<Serializer, Tagging, Unit> {
    public static final S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$5$1 INSTANCE = new S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$5$1();

    S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$5$1() {
        super(2, TaggingDocumentSerializerKt.class, "serializeTaggingDocument", "serializeTaggingDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Tagging;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Tagging tagging) {
        invoke2(serializer, tagging);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, Tagging p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        TaggingDocumentSerializerKt.serializeTaggingDocument(p0, p1);
    }
}
