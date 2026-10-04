package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _UCollections.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0011\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u001b\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, m1599d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, m1600k = 5, m1601mv = {2, 3, 0}, m1603xi = 49, m1604xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM14569constructorimpl = UByteArray.m14569constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m14580setVurrAj0(bArrM14569constructorimpl, i, it.next().getData());
            i++;
        }
        return bArrM14569constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM14648constructorimpl = UIntArray.m14648constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m14659setVXSXFK8(iArrM14648constructorimpl, i, it.next().getData());
            i++;
        }
        return iArrM14648constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM14727constructorimpl = ULongArray.m14727constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m14738setk8EXiF4(jArrM14727constructorimpl, i, it.next().getData());
            i++;
        }
        return jArrM14727constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM14832constructorimpl = UShortArray.m14832constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m14843set01HTLdE(sArrM14832constructorimpl, i, it.next().getData());
            i++;
        }
        return sArrM14832constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int iM14594constructorimpl = 0;
        while (it.hasNext()) {
            iM14594constructorimpl = UInt.m14594constructorimpl(iM14594constructorimpl + it.next().getData());
        }
        return iM14594constructorimpl;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long jM14673constructorimpl = 0;
        while (it.hasNext()) {
            jM14673constructorimpl = ULong.m14673constructorimpl(jM14673constructorimpl + it.next().getData());
        }
        return jM14673constructorimpl;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int iM14594constructorimpl = 0;
        while (it.hasNext()) {
            iM14594constructorimpl = UInt.m14594constructorimpl(iM14594constructorimpl + UInt.m14594constructorimpl(it.next().getData() & 255));
        }
        return iM14594constructorimpl;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int iM14594constructorimpl = 0;
        while (it.hasNext()) {
            iM14594constructorimpl = UInt.m14594constructorimpl(iM14594constructorimpl + UInt.m14594constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM14594constructorimpl;
    }
}
