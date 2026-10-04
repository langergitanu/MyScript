package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.FilterRule;
import aws.sdk.kotlin.services.p010s3.model.S3KeyFilter;
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

/* JADX INFO: compiled from: S3KeyFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeS3KeyFilterDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/S3KeyFilter;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3KeyFilterDocumentSerializerKt {
    public static final void serializeS3KeyFilterDocument(Serializer serializer, final S3KeyFilter input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("FilterRule"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("S3KeyFilter"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        if (input.getFilterRules() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.S3KeyFilterDocumentSerializerKt$serializeS3KeyFilterDocument$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.S3KeyFilterDocumentSerializerKt$serializeS3KeyFilterDocument$1$1$1 */
                /* JADX INFO: compiled from: S3KeyFilterDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class C35971 extends FunctionReferenceImpl implements Function2<Serializer, FilterRule, Unit> {
                    public static final C35971 INSTANCE = new C35971();

                    C35971() {
                        super(2, FilterRuleDocumentSerializerKt.class, "serializeFilterRuleDocument", "serializeFilterRuleDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/FilterRule;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, FilterRule filterRule) {
                        invoke2(serializer, filterRule);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, FilterRule p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        FilterRuleDocumentSerializerKt.serializeFilterRuleDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<FilterRule> it = input.getFilterRules().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), C35971.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
    }
}
