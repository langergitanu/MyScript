package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0002\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"writeTag", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "tagName", "", "ns", "Laws/smithy/kotlin/runtime/serde/xml/AbstractXmlNamespaceTrait;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "startTag", "isMapOrList", "", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)Z", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlSerializerKt {
    static /* synthetic */ void writeTag$default(XmlStreamWriter xmlStreamWriter, String str, AbstractXmlNamespaceTrait abstractXmlNamespaceTrait, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            abstractXmlNamespaceTrait = null;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: aws.smithy.kotlin.runtime.serde.xml.XmlSerializerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return XmlSerializerKt.writeTag$lambda$0((XmlStreamWriter) obj2);
                }
            };
        }
        writeTag(xmlStreamWriter, str, abstractXmlNamespaceTrait, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeTag$lambda$0(XmlStreamWriter xmlStreamWriter) {
        Intrinsics.checkNotNullParameter(xmlStreamWriter, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeTag(XmlStreamWriter xmlStreamWriter, String str, AbstractXmlNamespaceTrait abstractXmlNamespaceTrait, Function1<? super XmlStreamWriter, Unit> function1) {
        startTag(xmlStreamWriter, str, abstractXmlNamespaceTrait);
        function1.invoke(xmlStreamWriter);
        XmlStreamWriter.endTag$default(xmlStreamWriter, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTag(XmlStreamWriter xmlStreamWriter, String str, AbstractXmlNamespaceTrait abstractXmlNamespaceTrait) {
        if (abstractXmlNamespaceTrait != null) {
            xmlStreamWriter.namespacePrefix(abstractXmlNamespaceTrait.getUri(), abstractXmlNamespaceTrait.getPrefix());
        }
        XmlStreamWriter.startTag$default(xmlStreamWriter, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMapOrList(SdkFieldDescriptor sdkFieldDescriptor) {
        return Intrinsics.areEqual(sdkFieldDescriptor.getKind(), SerialKind.List.INSTANCE) || Intrinsics.areEqual(sdkFieldDescriptor.getKind(), SerialKind.Map.INSTANCE);
    }
}
