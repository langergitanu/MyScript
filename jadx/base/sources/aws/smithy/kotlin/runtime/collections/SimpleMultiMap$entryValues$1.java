package aws.smithy.kotlin.runtime.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: MultiMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\n"}, m1599d2 = {"<anonymous>", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/SequenceScope;", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.SimpleMultiMap$entryValues$1", m1609f = "MultiMap.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {47}, m1612m = "invokeSuspend", m1613n = {"$this$sequence", "$this$forEach$iv", "element$iv", SubscriberAttributeKt.JSON_NAME_KEY, "values", "$this$forEach$iv", "element$iv", "value", "$i$f$forEach", "$i$a$-forEach-SimpleMultiMap$entryValues$1$1", "$i$f$forEach", "$i$a$-forEach-SimpleMultiMap$entryValues$1$1$1"}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m1615s = {"L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
final class SimpleMultiMap$entryValues$1<K, V> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<? extends K, ? extends V>>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ SimpleMultiMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleMultiMap$entryValues$1(SimpleMultiMap<K, V> simpleMultiMap, Continuation<? super SimpleMultiMap$entryValues$1> continuation) {
        super(2, continuation);
        this.this$0 = simpleMultiMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SimpleMultiMap$entryValues$1 simpleMultiMap$entryValues$1 = new SimpleMultiMap$entryValues$1(this.this$0, continuation);
        simpleMultiMap$entryValues$1.L$0 = obj;
        return simpleMultiMap$entryValues$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Map.Entry<? extends K, ? extends V>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SimpleMultiMap$entryValues$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005f -> B:12:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00c9 -> B:17:0x00cc). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Set<Map.Entry<K, List<V>>> setEntrySet;
        Iterator it;
        int i;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            setEntrySet = this.this$0.entrySet();
            it = setEntrySet.iterator();
            i = 0;
            if (!it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$2;
            int i4 = this.I$1;
            int i5 = this.I$0;
            Iterator it2 = (Iterator) this.L$7;
            Iterable iterable = (Iterable) this.L$6;
            List list = (List) this.L$5;
            Object obj2 = this.L$4;
            Object obj3 = this.L$3;
            Iterator it3 = (Iterator) this.L$2;
            Iterable iterable2 = (Iterable) this.L$1;
            ResultKt.throwOnFailure(obj);
            int i6 = i3;
            setEntrySet = iterable2;
            Object obj4 = obj3;
            Iterator it4 = it2;
            int i7 = i4;
            int i8 = i5;
            Iterator it5 = it3;
            Object obj5 = obj2;
            List list2 = iterable;
            boolean z = true;
            if (it4.hasNext()) {
                Object next = it4.next();
                Entry entry = new Entry(obj5, next);
                this.L$0 = sequenceScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(setEntrySet);
                this.L$2 = it5;
                this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                this.L$4 = obj5;
                this.L$5 = SpillingKt.nullOutSpilledVariable(list);
                this.L$6 = SpillingKt.nullOutSpilledVariable(list2);
                this.L$7 = it4;
                this.L$8 = SpillingKt.nullOutSpilledVariable(next);
                this.L$9 = SpillingKt.nullOutSpilledVariable(next);
                this.I$0 = i8;
                this.I$1 = i7;
                this.I$2 = i6;
                this.I$3 = 0;
                z = true;
                this.label = 1;
                if (sequenceScope.yield(entry, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (it4.hasNext()) {
                    it = it5;
                    i = i8;
                    if (!it.hasNext()) {
                        Object next2 = it.next();
                        Map.Entry entry2 = (Map.Entry) next2;
                        Object key = entry2.getKey();
                        List list3 = (List) entry2.getValue();
                        list2 = list3;
                        it4 = list2.iterator();
                        obj4 = next2;
                        obj5 = key;
                        i7 = 0;
                        list = list3;
                        i8 = i;
                        it5 = it;
                        i6 = 0;
                        if (it4.hasNext()) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }
}
