package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.AbortIncompleteMultipartUpload;
import aws.sdk.kotlin.services.p010s3.model.LifecycleExpiration;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRule;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleFilter;
import aws.sdk.kotlin.services.p010s3.model.NoncurrentVersionExpiration;
import aws.sdk.kotlin.services.p010s3.model.NoncurrentVersionTransition;
import aws.sdk.kotlin.services.p010s3.model.Transition;
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

/* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeLifecycleRuleDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleDocumentSerializerKt {
    public static final void serializeLifecycleRuleDocument(Serializer serializer, final LifecycleRule input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("AbortIncompleteMultipartUpload"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Expiration"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Filter"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ID"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("NoncurrentVersionExpiration"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("NoncurrentVersionTransition"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Status"));
        SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("Transition"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("LifecycleRule"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        builder.field(sdkFieldDescriptor9);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        AbortIncompleteMultipartUpload abortIncompleteMultipartUpload = input.getAbortIncompleteMultipartUpload();
        if (abortIncompleteMultipartUpload != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, abortIncompleteMultipartUpload, C3540xb298cab0.INSTANCE);
        }
        LifecycleExpiration expiration = input.getExpiration();
        if (expiration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, expiration, C3541xb298ce71.INSTANCE);
        }
        LifecycleRuleFilter filter = input.getFilter();
        if (filter != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, filter, C3542xb298d232.INSTANCE);
        }
        String id = input.getId();
        if (id != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, id);
        }
        NoncurrentVersionExpiration noncurrentVersionExpiration = input.getNoncurrentVersionExpiration();
        if (noncurrentVersionExpiration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor5, noncurrentVersionExpiration, C3543xb298d9b4.INSTANCE);
        }
        if (input.getNoncurrentVersionTransitions() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor6, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$6$1, reason: invalid class name */
                /* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, NoncurrentVersionTransition, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, NoncurrentVersionTransitionDocumentSerializerKt.class, "serializeNoncurrentVersionTransitionDocument", "serializeNoncurrentVersionTransitionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, NoncurrentVersionTransition noncurrentVersionTransition) {
                        invoke2(serializer, noncurrentVersionTransition);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, NoncurrentVersionTransition p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        NoncurrentVersionTransitionDocumentSerializerKt.serializeNoncurrentVersionTransitionDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<NoncurrentVersionTransition> it = input.getNoncurrentVersionTransitions().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, prefix);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor8, input.getStatus().getValue());
        if (input.getTransitions() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor9, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$8
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LifecycleRuleDocumentSerializerKt$serializeLifecycleRuleDocument$1$8$1, reason: invalid class name */
                /* JADX INFO: compiled from: LifecycleRuleDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, Transition, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, TransitionDocumentSerializerKt.class, "serializeTransitionDocument", "serializeTransitionDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Transition;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Transition transition) {
                        invoke2(serializer, transition);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, Transition p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        TransitionDocumentSerializerKt.serializeTransitionDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<Transition> it = input.getTransitions().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
    }
}
