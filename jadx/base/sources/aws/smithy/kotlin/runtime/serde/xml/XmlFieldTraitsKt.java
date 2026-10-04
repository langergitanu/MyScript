package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: XmlFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\u0005H\u0000\u001a\u001a\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010*\u00020\u0005H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0005*\u00020\u0006H\u0000\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0018\u0010\u0016\u001a\u00020\n*\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"toQualifiedName", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "xmlNamespace", "Laws/smithy/kotlin/runtime/serde/xml/XmlNamespace;", "name", "", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "toQualifiedNames", "", "nameMatches", "", "other", "requireNameMatch", "", "nodeHasPrefix", "parseNodeWithPrefix", "Lkotlin/Pair;", "serialName", "Laws/smithy/kotlin/runtime/serde/xml/XmlSerialName;", "getSerialName", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)Laws/smithy/kotlin/runtime/serde/xml/XmlSerialName;", "generalName", "hasXmlAttributes", "Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;", "getHasXmlAttributes", "(Laws/smithy/kotlin/runtime/serde/SdkObjectDescriptor;)Z", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlFieldTraitsKt {
    private static final XmlToken.QualifiedName toQualifiedName(XmlNamespace xmlNamespace, String str) {
        Pair<String, String> nodeWithPrefix;
        if (str != null && (nodeWithPrefix = parseNodeWithPrefix(str)) != null) {
            String strComponent1 = nodeWithPrefix.component1();
            String strComponent2 = nodeWithPrefix.component2();
            if (xmlNamespace != null) {
                if (!Intrinsics.areEqual(strComponent2, xmlNamespace.getPrefix())) {
                    strComponent2 = null;
                }
                return new XmlToken.QualifiedName(strComponent1, strComponent2);
            }
            if (strComponent2 != null) {
                return new XmlToken.QualifiedName(strComponent1, strComponent2);
            }
            return new XmlToken.QualifiedName(strComponent1, null, 2, null);
        }
        throw new DeserializationException("Unable to parse qualified name from " + str);
    }

    public static final Set<XmlToken.QualifiedName> toQualifiedNames(SdkFieldDescriptor sdkFieldDescriptor, XmlNamespace xmlNamespace) {
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Set of = SetsKt.setOf(toQualifiedName$default(sdkFieldDescriptor, null, 1, null));
        Set<FieldTrait> traits = sdkFieldDescriptor.getTraits();
        ArrayList arrayList = new ArrayList();
        for (Object obj : traits) {
            if (((FieldTrait) obj).getClass() == XmlAliasName.class) {
                arrayList.add(obj);
            }
        }
        ArrayList<FieldTrait> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (FieldTrait fieldTrait : arrayList2) {
            if (fieldTrait == null) {
                throw new NullPointerException("null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.XmlAliasName");
            }
            arrayList3.add((XmlAliasName) fieldTrait);
        }
        Set set = CollectionsKt.toSet(arrayList3);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList4.add(toQualifiedName(xmlNamespace, ((XmlAliasName) it.next()).getName()));
        }
        return SetsKt.plus(of, (Iterable) arrayList4);
    }

    public static final boolean nameMatches(SdkFieldDescriptor sdkFieldDescriptor, String other) {
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set qualifiedNames$default = toQualifiedNames$default(sdkFieldDescriptor, null, 1, null);
        if ((qualifiedNames$default instanceof Collection) && qualifiedNames$default.isEmpty()) {
            return false;
        }
        Iterator it = qualifiedNames$default.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((XmlToken.QualifiedName) it.next()).toString(), other)) {
                return true;
            }
        }
        return false;
    }

    public static final void requireNameMatch(SdkFieldDescriptor sdkFieldDescriptor, String other) {
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set qualifiedNames$default = toQualifiedNames$default(sdkFieldDescriptor, null, 1, null);
        if (nameMatches(sdkFieldDescriptor, other)) {
            return;
        }
        throw new DeserializationException("Expected beginning element named " + CollectionsKt.joinToString$default(qualifiedNames$default, " or ", null, null, 0, null, null, 62, null) + " but found " + other);
    }

    public static final boolean nodeHasPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.contains$default((CharSequence) str, AbstractJsonLexerKt.COLON, false, 2, (Object) null);
    }

    public static final Pair<String, String> parseNodeWithPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (nodeHasPrefix(str)) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
            return TuplesKt.m1606to((String) listSplit$default.get(1), (String) listSplit$default.get(0));
        }
        return TuplesKt.m1606to(str, null);
    }

    public static final boolean getHasXmlAttributes(SdkObjectDescriptor sdkObjectDescriptor) {
        Intrinsics.checkNotNullParameter(sdkObjectDescriptor, "<this>");
        List<SdkFieldDescriptor> fields = sdkObjectDescriptor.getFields();
        if ((fields instanceof Collection) && fields.isEmpty()) {
            return false;
        }
        Iterator<T> it = fields.iterator();
        while (it.hasNext()) {
            Set<FieldTrait> traits = ((SdkFieldDescriptor) it.next()).getTraits();
            if (!(traits instanceof Collection) || !traits.isEmpty()) {
                Iterator<T> it2 = traits.iterator();
                while (it2.hasNext()) {
                    if (((FieldTrait) it2.next()) instanceof XmlAttribute) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final XmlToken.QualifiedName toQualifiedName(SdkFieldDescriptor sdkFieldDescriptor, XmlNamespace xmlNamespace) {
        Object next;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((FieldTrait) next).getClass() == XmlSerialName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (!(fieldTrait instanceof XmlSerialName)) {
            fieldTrait = null;
        }
        XmlSerialName xmlSerialName = (XmlSerialName) fieldTrait;
        return toQualifiedName(xmlNamespace, xmlSerialName != null ? xmlSerialName.getName() : null);
    }

    public static /* synthetic */ XmlToken.QualifiedName toQualifiedName$default(SdkFieldDescriptor sdkFieldDescriptor, XmlNamespace xmlNamespace, int i, Object obj) {
        Object next;
        if ((i & 1) != 0) {
            Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                    break;
                }
            }
            FieldTrait fieldTrait = (FieldTrait) next;
            xmlNamespace = (XmlNamespace) (fieldTrait instanceof XmlNamespace ? fieldTrait : null);
        }
        return toQualifiedName(sdkFieldDescriptor, xmlNamespace);
    }

    public static /* synthetic */ Set toQualifiedNames$default(SdkFieldDescriptor sdkFieldDescriptor, XmlNamespace xmlNamespace, int i, Object obj) {
        Object next;
        if ((i & 1) != 0) {
            Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((FieldTrait) next).getClass() == XmlNamespace.class) {
                    break;
                }
            }
            FieldTrait fieldTrait = (FieldTrait) next;
            xmlNamespace = (XmlNamespace) (fieldTrait instanceof XmlNamespace ? fieldTrait : null);
        }
        return toQualifiedNames(sdkFieldDescriptor, xmlNamespace);
    }

    public static final XmlSerialName getSerialName(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((FieldTrait) next).getClass() == XmlSerialName.class) {
                break;
            }
        }
        FieldTrait fieldTrait = (FieldTrait) next;
        if (fieldTrait == null) {
            throw new IllegalArgumentException(("Expected to find trait " + Reflection.getOrCreateKotlinClass(XmlSerialName.class) + " in " + sdkFieldDescriptor + " but was not present.").toString());
        }
        return (XmlSerialName) fieldTrait;
    }

    public static final String generalName(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        String element;
        Object next2;
        String value;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Set<FieldTrait> traits = sdkFieldDescriptor.getTraits();
        if (!(traits instanceof Collection) || !traits.isEmpty()) {
            Iterator<T> it = traits.iterator();
            while (it.hasNext()) {
                if (((FieldTrait) it.next()) instanceof XmlCollectionName) {
                    Iterator<T> it2 = sdkFieldDescriptor.getTraits().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        if (((FieldTrait) next).getClass() == XmlCollectionName.class) {
                            break;
                        }
                    }
                    FieldTrait fieldTrait = (FieldTrait) next;
                    XmlCollectionName xmlCollectionName = (XmlCollectionName) (fieldTrait instanceof XmlCollectionName ? fieldTrait : null);
                    return (xmlCollectionName == null || (element = xmlCollectionName.getElement()) == null) ? XmlCollectionName.INSTANCE.getDefault().getElement() : element;
                }
            }
        }
        Set<FieldTrait> traits2 = sdkFieldDescriptor.getTraits();
        if (!(traits2 instanceof Collection) || !traits2.isEmpty()) {
            Iterator<T> it3 = traits2.iterator();
            while (it3.hasNext()) {
                if (((FieldTrait) it3.next()) instanceof XmlMapName) {
                    Iterator<T> it4 = sdkFieldDescriptor.getTraits().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it4.next();
                        if (((FieldTrait) next2).getClass() == XmlMapName.class) {
                            break;
                        }
                    }
                    FieldTrait fieldTrait2 = (FieldTrait) next2;
                    XmlMapName xmlMapName = (XmlMapName) (fieldTrait2 instanceof XmlMapName ? fieldTrait2 : null);
                    return (xmlMapName == null || (value = xmlMapName.getValue()) == null) ? XmlMapName.INSTANCE.getDefault().getValue() : value;
                }
            }
        }
        Iterator<T> it5 = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next3 = it5.next();
            if (((FieldTrait) next3).getClass() == XmlSerialName.class) {
                obj = next3;
                break;
            }
        }
        FieldTrait fieldTrait3 = (FieldTrait) obj;
        if (fieldTrait3 != null) {
            return ((XmlSerialName) fieldTrait3).getName();
        }
        throw new IllegalArgumentException(("Expected to find trait " + Reflection.getOrCreateKotlinClass(XmlSerialName.class) + " in " + sdkFieldDescriptor + " but was not present.").toString());
    }
}
