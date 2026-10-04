package com.revenuecat.purchases.common.remoteconfig;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.common.remoteconfig.WeightedSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WeightedSourceSelector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0015B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u0014R$\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/WeightedSourceSelector;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", "", "sources", "", "random", "Lkotlin/random/Random;", "(Ljava/util/List;Lkotlin/random/Random;)V", "<set-?>", "current", "getCurrent", "()Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", "Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", "iterator", "", "orderedSources", "advance", "nextOrNull", "reset", "", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WeightedSourceSelector<T extends WeightedSource> {
    private static final Companion Companion = new Companion(null);
    private T current;
    private Iterator<? extends T> iterator;
    private final List<T> orderedSources;

    public WeightedSourceSelector(List<? extends T> sources, Random random) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> listComputeOrder = Companion.computeOrder(sources, random);
        this.orderedSources = listComputeOrder;
        this.iterator = listComputeOrder.iterator();
        this.current = (T) nextOrNull();
    }

    public /* synthetic */ WeightedSourceSelector(List list, Random.Companion companion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? Random.INSTANCE : companion);
    }

    public final T getCurrent() {
        return this.current;
    }

    public final T advance() {
        T t = (T) nextOrNull();
        this.current = t;
        return t;
    }

    public final void reset() {
        this.iterator = this.orderedSources.iterator();
        this.current = (T) nextOrNull();
    }

    private final T nextOrNull() {
        if (this.iterator.hasNext()) {
            return this.iterator.next();
        }
        return null;
    }

    /* JADX INFO: compiled from: WeightedSourceSelector.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ&\u0010\u000e\u001a\u00020\u000b\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0006\u0010\b\u001a\u00020\tJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/WeightedSourceSelector$Companion;", "", "()V", "computeOrder", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/revenuecat/purchases/common/remoteconfig/WeightedSource;", "sources", "random", "Lkotlin/random/Random;", "sumOrIntMax", "", "lhs", "rhs", "weightedPickIndex", "weightedShuffle", "tier", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends WeightedSource> List<T> computeOrder(List<? extends T> sources, Random random) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(random, "random");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : sources) {
                Integer numValueOf = Integer.valueOf(((WeightedSource) obj).getPriority());
                Object obj2 = linkedHashMap.get(numValueOf);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(numValueOf, obj2);
                }
                ((List) obj2).add(obj);
            }
            List listSortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: com.revenuecat.purchases.common.remoteconfig.WeightedSourceSelector$Companion$computeOrder$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t2).getKey());
                }
            });
            ArrayList arrayList = new ArrayList();
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, WeightedSourceSelector.Companion.weightedShuffle((List) ((Map.Entry) it.next()).getValue(), random));
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T extends WeightedSource> List<T> weightedShuffle(List<? extends T> tier, Random random) {
            Intrinsics.checkNotNullParameter(tier, "tier");
            Intrinsics.checkNotNullParameter(random, "random");
            if (tier.size() <= 1) {
                return tier;
            }
            List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) tier);
            ArrayList arrayList = new ArrayList(mutableList.size());
            while (mutableList.size() > 1) {
                arrayList.add(mutableList.remove(weightedPickIndex(mutableList, random)));
            }
            arrayList.add(CollectionsKt.first((List) mutableList));
            return arrayList;
        }

        public final <T extends WeightedSource> int weightedPickIndex(List<? extends T> sources, Random random) {
            int i;
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(random, "random");
            List<? extends T> list = sources;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                arrayList.add(Integer.valueOf(Math.max(0, ((WeightedSource) it.next()).getWeight())));
            }
            ArrayList arrayList2 = arrayList;
            Iterator it2 = arrayList2.iterator();
            int iSumOrIntMax = 0;
            while (it2.hasNext()) {
                iSumOrIntMax = sumOrIntMax(iSumOrIntMax, ((Number) it2.next()).intValue());
            }
            if (iSumOrIntMax <= 0) {
                return random.nextInt(sources.size());
            }
            int iNextInt = random.nextInt(iSumOrIntMax);
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            int size = arrayList2.size();
            for (i = 0; i < size; i++) {
                iNextInt -= ((Number) arrayList2.get(i)).intValue();
                if (iNextInt < 0) {
                    return i;
                }
            }
            return lastIndex;
        }

        public final int sumOrIntMax(int lhs, int rhs) {
            return (int) RangesKt.coerceAtMost(((long) lhs) + ((long) rhs), SieveCacheKt.NodeLinkMask);
        }
    }
}
