package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleAndOperator;
import aws.sdk.kotlin.services.p010s3.model.Tag;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.Flattened;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifecycleRuleAndOperatorDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeLifecycleRuleAndOperatorDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleAndOperatorDocumentSerializerKt {
    public static final void serializeLifecycleRuleAndOperatorDocument(Serializer serializer, final LifecycleRuleAndOperator input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Long.INSTANCE, new XmlSerialName("ObjectSizeGreaterThan"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Long.INSTANCE, new XmlSerialName("ObjectSizeLessThan"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("Tag"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("LifecycleRuleAndOperator"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        Long objectSizeGreaterThan = input.getObjectSizeGreaterThan();
        if (objectSizeGreaterThan != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, objectSizeGreaterThan.longValue());
        }
        Long objectSizeLessThan = input.getObjectSizeLessThan();
        if (objectSizeLessThan != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, objectSizeLessThan.longValue());
        }
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, prefix);
        }
        if (input.getTags() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor4, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.LifecycleRuleAndOperatorDocumentSerializerKt$serializeLifecycleRuleAndOperatorDocument$1$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleAndOperatorDocumentSerializerKt$serializeLifecycleRuleAndOperatorDocument$1$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: LifecycleRuleAndOperatorDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, Tag, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, TagDocumentSerializerKt.class, "serializeTagDocument", "serializeTagDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Tag;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Tag tag) {
                        invoke2(serializer, tag);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, Tag p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        TagDocumentSerializerKt.serializeTagDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<Tag> it = input.getTags().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
    }
}
