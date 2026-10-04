package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: compiled from: XmlLexer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0002\u001a>\u0010\f\u001a$\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\r*\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000*$\b\u0002\u0010\u000b\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0011"}, m1599d2 = {"decimalCharRef", "Lkotlin/text/Regex;", "hexCharRef", "namedRefs", "", "", "", "isXmlns", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "xmlnsPrefix", "AttributeMap", "extractNsDeclarations", "Lkotlin/Pair;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/AttributeMap;", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Namespace;", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlLexerKt {
    private static final Regex decimalCharRef = new Regex("#([0-9]+)");
    private static final Regex hexCharRef = new Regex("#x([0-9a-fA-F]+)");
    private static final Map<String, char[]> namedRefs;

    static {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to("lt", Character.valueOf(Typography.less)), TuplesKt.m1606to("gt", Character.valueOf(Typography.greater)), TuplesKt.m1606to("amp", Character.valueOf(Typography.amp)), TuplesKt.m1606to("apos", '\''), TuplesKt.m1606to("quot", '\"'));
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf.size()));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            linkedHashMap.put(entry.getKey(), new char[]{((Character) entry.getValue()).charValue()});
        }
        namedRefs = linkedHashMap;
    }

    private static final boolean isXmlns(XmlToken.QualifiedName qualifiedName) {
        return (Intrinsics.areEqual(qualifiedName.getLocal(), "xmlns") && qualifiedName.getPrefix() == null) || Intrinsics.areEqual(qualifiedName.getPrefix(), "xmlns");
    }

    private static final String xmlnsPrefix(XmlToken.QualifiedName qualifiedName) {
        if (Intrinsics.areEqual(qualifiedName.getLocal(), "xmlns")) {
            return null;
        }
        return qualifiedName.getLocal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Map<XmlToken.QualifiedName, String>, List<XmlToken.Namespace>> extractNsDeclarations(Map<XmlToken.QualifiedName, String> map) {
        List list = MapsKt.toList(map);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (isXmlns((XmlToken.QualifiedName) ((Pair) obj).getFirst())) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        Map map2 = MapsKt.toMap((Iterable) pair.getSecond());
        Iterable<Pair> iterable = (Iterable) pair.getFirst();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair2 : iterable) {
            arrayList3.add(new XmlToken.Namespace((String) pair2.getSecond(), xmlnsPrefix((XmlToken.QualifiedName) pair2.getFirst())));
        }
        return TuplesKt.m1606to(map2, arrayList3);
    }
}
