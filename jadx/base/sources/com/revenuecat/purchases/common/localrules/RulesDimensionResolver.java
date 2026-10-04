package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.localrules.RulesDimensionResolutionException;
import com.revenuecat.purchases.rules.Value;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RulesDimensionResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolver;", "", "providers", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Ljava/util/List;Lcom/revenuecat/purchases/common/DateProvider;)V", "snapshot", "Lkotlin/Result;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionSnapshot;", "customVariables", "", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "snapshot-gIAlu-s", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RulesDimensionResolver {
    private final DateProvider dateProvider;
    private final List<RulesDimensionProvider> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public RulesDimensionResolver(List<? extends RulesDimensionProvider> providers, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.providers = providers;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ RulesDimensionResolver(List list, DefaultDateProvider defaultDateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new DefaultDateProvider() : defaultDateProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:28:0x0089). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: snapshot-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m13736snapshotgIAlus(Map<String, ? extends RulesDimensionValue> map, Continuation<? super Result<RulesDimensionSnapshot>> continuation) {
        RulesDimensionResolver$snapshot$1 rulesDimensionResolver$snapshot$1;
        Map linkedHashMap;
        Iterator<RulesDimensionProvider> it;
        Date date;
        String message;
        if (continuation instanceof RulesDimensionResolver$snapshot$1) {
            rulesDimensionResolver$snapshot$1 = (RulesDimensionResolver$snapshot$1) continuation;
            if ((rulesDimensionResolver$snapshot$1.label & Integer.MIN_VALUE) != 0) {
                rulesDimensionResolver$snapshot$1.label -= Integer.MIN_VALUE;
            } else {
                rulesDimensionResolver$snapshot$1 = new RulesDimensionResolver$snapshot$1(this, continuation);
            }
        }
        Object obj = rulesDimensionResolver$snapshot$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = rulesDimensionResolver$snapshot$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            RulesDimensionProvider rulesDimensionProvider = (RulesDimensionProvider) rulesDimensionResolver$snapshot$1.L$4;
            it = (Iterator) rulesDimensionResolver$snapshot$1.L$3;
            linkedHashMap = (Map) rulesDimensionResolver$snapshot$1.L$2;
            date = (Date) rulesDimensionResolver$snapshot$1.L$1;
            Map<String, ? extends RulesDimensionValue> map2 = (Map) rulesDimensionResolver$snapshot$1.L$0;
            try {
                try {
                    ResultKt.throwOnFailure(obj);
                    RulesDimensionResolutionException.ConflictingDimension conflictingDimensionAddDimensions = RulesDimensionResolverKt.addDimensions(linkedHashMap, rulesDimensionProvider.getNamespace(), (Map) obj);
                    if (conflictingDimensionAddDimensions == null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m14499constructorimpl(ResultKt.createFailure(conflictingDimensionAddDimensions));
                    }
                    map = map2;
                    if (it.hasNext()) {
                        RulesDimensionResolutionException.ConflictingDimension conflictingDimensionAddDimensions2 = RulesDimensionResolverKt.addDimensions(linkedHashMap, RulesDimensionNamespace.Custom, map);
                        if (conflictingDimensionAddDimensions2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            return Result.m14499constructorimpl(ResultKt.createFailure(conflictingDimensionAddDimensions2));
                        }
                        Result.Companion companion3 = Result.INSTANCE;
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            linkedHashMap2.put(entry.getKey(), new Value.ObjectValue((Map) entry.getValue()));
                        }
                        return Result.m14499constructorimpl(new RulesDimensionSnapshot(linkedHashMap2, date));
                    }
                    RulesDimensionProvider next = it.next();
                    try {
                        rulesDimensionResolver$snapshot$1.L$0 = map;
                        rulesDimensionResolver$snapshot$1.L$1 = date;
                        rulesDimensionResolver$snapshot$1.L$2 = linkedHashMap;
                        rulesDimensionResolver$snapshot$1.L$3 = it;
                        rulesDimensionResolver$snapshot$1.L$4 = next;
                        rulesDimensionResolver$snapshot$1.label = 1;
                        Object objDimensions = next.dimensions(date, rulesDimensionResolver$snapshot$1);
                        if (objDimensions == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map2 = map;
                        rulesDimensionProvider = next;
                        obj = objDimensions;
                        RulesDimensionResolutionException.ConflictingDimension conflictingDimensionAddDimensions3 = RulesDimensionResolverKt.addDimensions(linkedHashMap, rulesDimensionProvider.getNamespace(), (Map) obj);
                        if (conflictingDimensionAddDimensions3 == null) {
                        }
                    } catch (Exception e) {
                        e = e;
                        rulesDimensionProvider = next;
                        Result.Companion companion4 = Result.INSTANCE;
                        RulesDimensionNamespace namespace = rulesDimensionProvider.getNamespace();
                        message = e.getMessage();
                        if (message == null) {
                        }
                        return Result.m14499constructorimpl(ResultKt.createFailure(new RulesDimensionResolutionException.ProviderFailed(namespace, message)));
                    }
                } catch (CancellationException e2) {
                    throw e2;
                }
            } catch (Exception e3) {
                e = e3;
                Result.Companion companion42 = Result.INSTANCE;
                RulesDimensionNamespace namespace2 = rulesDimensionProvider.getNamespace();
                message = e.getMessage();
                if (message == null) {
                    message = e.toString();
                }
                return Result.m14499constructorimpl(ResultKt.createFailure(new RulesDimensionResolutionException.ProviderFailed(namespace2, message)));
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Date now = this.dateProvider.getNow();
            linkedHashMap = new LinkedHashMap();
            it = this.providers.iterator();
            date = now;
            if (it.hasNext()) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: snapshot-gIAlu-s$default, reason: not valid java name */
    public static /* synthetic */ Object m13735snapshotgIAlus$default(RulesDimensionResolver rulesDimensionResolver, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return rulesDimensionResolver.m13736snapshotgIAlus(map, continuation);
    }
}
