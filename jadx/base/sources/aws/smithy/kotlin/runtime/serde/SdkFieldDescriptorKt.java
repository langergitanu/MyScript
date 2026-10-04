package aws.smithy.kotlin.runtime.serde;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SdkFieldDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a \u0010\u0005\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a\u0019\u0010\b\u001a\u00020\t\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¨\u0006\n"}, m1599d2 = {"expectTrait", "TExpected", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;", "(Laws/smithy/kotlin/runtime/serde/SdkFieldDescriptor;)Laws/smithy/kotlin/runtime/serde/FieldTrait;", "findTrait", "findTraits", "", "hasTrait", "", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkFieldDescriptorKt {
    @InternalApi
    public static final /* synthetic */ <TExpected extends FieldTrait> TExpected expectTrait(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Class<?> cls = ((FieldTrait) next).getClass();
            Intrinsics.reifiedOperationMarker(4, "TExpected");
            if (cls == FieldTrait.class) {
                break;
            }
        }
        TExpected texpected = (TExpected) next;
        if (texpected == null) {
            StringBuilder sb = new StringBuilder("Expected to find trait ");
            Intrinsics.reifiedOperationMarker(4, "TExpected");
            throw new IllegalArgumentException(sb.append(Reflection.getOrCreateKotlinClass(FieldTrait.class)).append(" in ").append(sdkFieldDescriptor).append(" but was not present.").toString().toString());
        }
        Intrinsics.reifiedOperationMarker(1, "TExpected");
        return texpected;
    }

    @InternalApi
    public static final /* synthetic */ <TExpected extends FieldTrait> TExpected findTrait(SdkFieldDescriptor sdkFieldDescriptor) {
        Object next;
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Iterator<T> it = sdkFieldDescriptor.getTraits().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Class<?> cls = ((FieldTrait) next).getClass();
            Intrinsics.reifiedOperationMarker(4, "TExpected");
            if (cls == FieldTrait.class) {
                break;
            }
        }
        TExpected texpected = (TExpected) next;
        Intrinsics.reifiedOperationMarker(2, "TExpected");
        return texpected;
    }

    @InternalApi
    public static final /* synthetic */ <TExpected extends FieldTrait> Set<TExpected> findTraits(SdkFieldDescriptor sdkFieldDescriptor) {
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Set<FieldTrait> traits = sdkFieldDescriptor.getTraits();
        ArrayList arrayList = new ArrayList();
        for (Object obj : traits) {
            Class<?> cls = ((FieldTrait) obj).getClass();
            Intrinsics.reifiedOperationMarker(4, "TExpected");
            if (cls == FieldTrait.class) {
                arrayList.add(obj);
            }
        }
        ArrayList<FieldTrait> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (FieldTrait fieldTrait : arrayList2) {
            Intrinsics.reifiedOperationMarker(1, "TExpected");
            arrayList3.add(fieldTrait);
        }
        return CollectionsKt.toSet(arrayList3);
    }

    @InternalApi
    public static final /* synthetic */ <TExpected extends FieldTrait> boolean hasTrait(SdkFieldDescriptor sdkFieldDescriptor) {
        Intrinsics.checkNotNullParameter(sdkFieldDescriptor, "<this>");
        Set<FieldTrait> traits = sdkFieldDescriptor.getTraits();
        if ((traits instanceof Collection) && traits.isEmpty()) {
            return false;
        }
        for (FieldTrait fieldTrait : traits) {
            Intrinsics.reifiedOperationMarker(3, "TExpected");
            if (fieldTrait instanceof FieldTrait) {
                return true;
            }
        }
        return false;
    }
}
