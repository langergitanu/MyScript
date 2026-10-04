package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.Encryption;
import aws.sdk.kotlin.services.p010s3.model.Grant;
import aws.sdk.kotlin.services.p010s3.model.MetadataEntry;
import aws.sdk.kotlin.services.p010s3.model.ObjectCannedAcl;
import aws.sdk.kotlin.services.p010s3.model.S3Location;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
import aws.sdk.kotlin.services.p010s3.model.Tagging;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlCollectionName;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3LocationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeS3LocationDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/S3Location;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3LocationDocumentSerializerKt {
    public static final void serializeS3LocationDocument(Serializer serializer, final S3Location input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("AccessControlList"), new XmlCollectionName("Grant"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("BucketName"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("CannedACL"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Encryption"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("StorageClass"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Tagging"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("UserMetadata"), new XmlCollectionName("MetadataEntry"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("S3Location"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        if (input.getAccessControlList() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$1$1 */
                /* JADX INFO: compiled from: S3LocationDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class C35981 extends FunctionReferenceImpl implements Function2<Serializer, Grant, Unit> {
                    public static final C35981 INSTANCE = new C35981();

                    C35981() {
                        super(2, GrantDocumentSerializerKt.class, "serializeGrantDocument", "serializeGrantDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Grant;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Grant grant) {
                        invoke2(serializer, grant);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, Grant p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        GrantDocumentSerializerKt.serializeGrantDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<Grant> it = input.getAccessControlList().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), C35981.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor2, input.getBucketName());
        ObjectCannedAcl cannedAcl = input.getCannedAcl();
        if (cannedAcl != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, cannedAcl.getValue());
        }
        Encryption encryption = input.getEncryption();
        if (encryption != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor4, encryption, S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$3$1.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor5, input.getPrefix());
        StorageClass storageClass = input.getStorageClass();
        if (storageClass != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, storageClass.getValue());
        }
        Tagging tagging = input.getTagging();
        if (tagging != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor7, tagging, S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$5$1.INSTANCE);
        }
        if (input.getUserMetadata() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor8, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.S3LocationDocumentSerializerKt$serializeS3LocationDocument$1$6$1 */
                /* JADX INFO: compiled from: S3LocationDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class C35991 extends FunctionReferenceImpl implements Function2<Serializer, MetadataEntry, Unit> {
                    public static final C35991 INSTANCE = new C35991();

                    C35991() {
                        super(2, MetadataEntryDocumentSerializerKt.class, "serializeMetadataEntryDocument", "serializeMetadataEntryDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/MetadataEntry;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, MetadataEntry metadataEntry) {
                        invoke2(serializer, metadataEntry);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, MetadataEntry p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        MetadataEntryDocumentSerializerKt.serializeMetadataEntryDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<MetadataEntry> it = input.getUserMetadata().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), C35991.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
    }
}
