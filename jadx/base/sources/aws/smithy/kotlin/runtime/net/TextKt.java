package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\u0003\u001a\u001b\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t*\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0013\u0010\u0010\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0003\u001a\u0013\u0010\u0012\u001a\u00020\u0001*\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, m1599d2 = {"", "", "isValidHostname", "(Ljava/lang/String;)Z", "isIpv4", "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "parseIpv4OrNull", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/IpV4Addr;", "isIpv6", "", "getIpv6AddressSegments", "(Ljava/lang/String;)Ljava/util/List;", "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "parseIpv6OrNull", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/IpV6Addr;", "isIpv6AddressSegment", "isIpv6ZoneId", "", "isHexDigit", "(C)Z", "", "IPV6_SEGMENT_COUNT", "I", "IPV4_MAPPED_IPV6_SEGMENT_COUNT", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextKt {
    private static final int IPV4_MAPPED_IPV6_SEGMENT_COUNT = 7;
    private static final int IPV6_SEGMENT_COUNT = 8;

    private static final boolean isHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return true;
        }
        if ('a' > c || c >= 'g') {
            return 'A' <= c && c < 'G';
        }
        return true;
    }

    @InternalApi
    public static final boolean isValidHostname(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 64 && Character.isLetterOrDigit(str.charAt(0))) {
            String strDrop = StringsKt.drop(str, 1);
            for (int i = 0; i < strDrop.length(); i++) {
                char cCharAt = strDrop.charAt(i);
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '-') {
                }
            }
            return true;
        }
        return false;
    }

    @InternalApi
    public static final boolean isIpv4(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return parseIpv4OrNull(str) != null;
    }

    public static final IpV4Addr parseIpv4OrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 4) {
            return null;
        }
        List list = listSplit$default;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
                int iIntValue = intOrNull != null ? intOrNull.intValue() : -1;
                if (!(iIntValue >= 0 && iIntValue < 256)) {
                    return null;
                }
            }
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Byte.valueOf(UStringsKt.toUByte((String) it2.next())));
        }
        return new IpV4Addr(CollectionsKt.toByteArray(arrayList));
    }

    @InternalApi
    public static final boolean isIpv6(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return parseIpv6OrNull(str) != null;
    }

    private static final List<String> getIpv6AddressSegments(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"::"}, false, 0, 6, (Object) null);
        if (listSplit$default.size() > 2) {
            return null;
        }
        if (listSplit$default.size() == 1) {
            return StringsKt.split$default((CharSequence) listSplit$default.get(0), new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 0, 6, (Object) null);
        }
        List listEmptyList = Intrinsics.areEqual(listSplit$default.get(0), "") ? CollectionsKt.emptyList() : StringsKt.split$default((CharSequence) listSplit$default.get(0), new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
        List listEmptyList2 = Intrinsics.areEqual(listSplit$default.get(1), "") ? CollectionsKt.emptyList() : StringsKt.split$default((CharSequence) listSplit$default.get(1), new char[]{AbstractJsonLexerKt.COLON}, false, 0, 6, (Object) null);
        int i = 8;
        if (listEmptyList.size() + listEmptyList2.size() == 8) {
            return null;
        }
        String str2 = (String) CollectionsKt.lastOrNull(listEmptyList2);
        if (str2 != null && StringsKt.contains$default((CharSequence) str2, '.', false, 2, (Object) null)) {
            i = 7;
        }
        int size = (i - listEmptyList.size()) - listEmptyList2.size();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(listEmptyList);
        for (int i2 = 0; i2 < size; i2++) {
            listCreateListBuilder.add("0");
        }
        listCreateListBuilder.addAll(listEmptyList2);
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final IpV6Addr parseIpv6OrNull(String str) {
        IpV4Addr ipv4OrNull;
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'%'}, false, 0, 6, (Object) null);
        if (listSplit$default.size() > 2) {
            return null;
        }
        if (listSplit$default.size() == 2 && !isIpv6ZoneId((String) listSplit$default.get(1))) {
            return null;
        }
        String str2 = listSplit$default.size() == 2 ? (String) listSplit$default.get(1) : null;
        List<String> ipv6AddressSegments = getIpv6AddressSegments((String) listSplit$default.get(0));
        if (ipv6AddressSegments == null || ipv6AddressSegments.size() < 7) {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            if (!isIpv6AddressSegment(ipv6AddressSegments.get(i))) {
                return null;
            }
        }
        if (ipv6AddressSegments.size() == 7) {
            List<String> listSubList = ipv6AddressSegments.subList(0, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
            Iterator<T> it = listSubList.iterator();
            while (it.hasNext()) {
                arrayList.add(UShort.m14774boximpl(UStringsKt.toUShort((String) it.next(), 16)));
            }
            if (Intrinsics.areEqual(arrayList, CollectionsKt.listOf((Object[]) new UShort[]{UShort.m14774boximpl((short) 0), UShort.m14774boximpl((short) 0), UShort.m14774boximpl((short) 0), UShort.m14774boximpl((short) 0), UShort.m14774boximpl((short) 0), UShort.m14774boximpl((short) -1)})) && (ipv4OrNull = parseIpv4OrNull(ipv6AddressSegments.get(6))) != null) {
                return ipv4OrNull.toMappedIpv6();
            }
            return null;
        }
        if (ipv6AddressSegments.size() != 8 || !isIpv6AddressSegment(ipv6AddressSegments.get(6)) || !isIpv6AddressSegment(ipv6AddressSegments.get(7))) {
            return null;
        }
        List<String> list = ipv6AddressSegments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(UShort.m14774boximpl(UStringsKt.toUShort((String) it2.next(), 16)));
        }
        ArrayList arrayList3 = arrayList2;
        return new IpV6Addr(((UShort) arrayList3.get(0)).getData(), ((UShort) arrayList3.get(1)).getData(), ((UShort) arrayList3.get(2)).getData(), ((UShort) arrayList3.get(3)).getData(), ((UShort) arrayList3.get(4)).getData(), ((UShort) arrayList3.get(5)).getData(), ((UShort) arrayList3.get(6)).getData(), ((UShort) arrayList3.get(7)).getData(), str2, null);
    }

    private static final boolean isIpv6AddressSegment(String str) {
        int length = str.length();
        if (1 <= length && length < 5) {
            String str2 = str;
            for (int i = 0; i < str2.length(); i++) {
                if (isHexDigit(str2.charAt(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean isIpv6ZoneId(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        return str2.length() > 0 && !StringsKt.contains$default((CharSequence) str2, '%', false, 2, (Object) null);
    }
}
