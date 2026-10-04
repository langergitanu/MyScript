package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.localrules.RulesDimensionResolutionException;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.rules.Value;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RulesDimensionResolver.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001aB\u0010\u0007\u001a\u0004\u0018\u00010\b*\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000eH\u0002\u001a,\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000e*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"DIMENSION_PATH_SEPARATOR", "", "asRulesEngineValue", "Lcom/revenuecat/purchases/rules/Value;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "getAsRulesEngineValue", "(Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;)Lcom/revenuecat/purchases/rules/Value;", "addDimensions", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionResolutionException$ConflictingDimension;", "", "", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "dimensions", "", "filterReachable", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RulesDimensionResolverKt {
    private static final char DIMENSION_PATH_SEPARATOR = '.';

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesDimensionResolutionException.ConflictingDimension addDimensions(Map<String, Map<String, Value>> map, RulesDimensionNamespace rulesDimensionNamespace, Map<String, ? extends RulesDimensionValue> map2) {
        Map<String, RulesDimensionValue> mapFilterReachable = filterReachable(map2, rulesDimensionNamespace);
        if (mapFilterReachable.isEmpty()) {
            return null;
        }
        String key = rulesDimensionNamespace.getKey();
        LinkedHashMap linkedHashMap = map.get(key);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            map.put(key, linkedHashMap);
        }
        Map<String, Value> map3 = linkedHashMap;
        for (Map.Entry<String, RulesDimensionValue> entry : mapFilterReachable.entrySet()) {
            String key2 = entry.getKey();
            RulesDimensionValue value = entry.getValue();
            if (map3.containsKey(key2)) {
                return new RulesDimensionResolutionException.ConflictingDimension(rulesDimensionNamespace.getKey() + DIMENSION_PATH_SEPARATOR + key2);
            }
            map3.put(key2, getAsRulesEngineValue(value));
        }
        return null;
    }

    private static final Value getAsRulesEngineValue(RulesDimensionValue rulesDimensionValue) {
        if (rulesDimensionValue instanceof RulesDimensionValue.StringValue) {
            return new Value.StringValue(((RulesDimensionValue.StringValue) rulesDimensionValue).getValue());
        }
        if (rulesDimensionValue instanceof RulesDimensionValue.BoolValue) {
            return new Value.BoolValue(((RulesDimensionValue.BoolValue) rulesDimensionValue).getValue());
        }
        if (rulesDimensionValue instanceof RulesDimensionValue.IntValue) {
            return new Value.IntValue(((RulesDimensionValue.IntValue) rulesDimensionValue).getValue());
        }
        if (rulesDimensionValue instanceof RulesDimensionValue.DoubleValue) {
            return new Value.FloatValue(((RulesDimensionValue.DoubleValue) rulesDimensionValue).getValue());
        }
        if (rulesDimensionValue instanceof RulesDimensionValue.DateValue) {
            return new Value.IntValue(((RulesDimensionValue.DateValue) rulesDimensionValue).getValue().getTime());
        }
        if (rulesDimensionValue instanceof RulesDimensionValue.ObjectListValue) {
            List<Map<String, RulesDimensionValue>> value = ((RulesDimensionValue.ObjectListValue) rulesDimensionValue).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), getAsRulesEngineValue((RulesDimensionValue) entry.getValue()));
                }
                arrayList.add(new Value.ObjectValue(linkedHashMap));
            }
            return new Value.ArrayValue(arrayList);
        }
        if (!(rulesDimensionValue instanceof RulesDimensionValue.ObjectValue)) {
            throw new NoWhenBranchMatchedException();
        }
        Map<String, RulesDimensionValue> value2 = ((RulesDimensionValue.ObjectValue) rulesDimensionValue).getValue();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(value2.size()));
        Iterator<T> it2 = value2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), getAsRulesEngineValue((RulesDimensionValue) entry2.getValue()));
        }
        return new Value.ObjectValue(linkedHashMap2);
    }

    private static final Map<String, RulesDimensionValue> filterReachable(Map<String, ? extends RulesDimensionValue> map, RulesDimensionNamespace rulesDimensionNamespace) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends RulesDimensionValue> entry : map.entrySet()) {
            String key = entry.getKey();
            String str = key;
            boolean z = false;
            if (str.length() > 0 && !StringsKt.contains$default((CharSequence) str, DIMENSION_PATH_SEPARATOR, false, 2, (Object) null)) {
                z = true;
            }
            if (!z) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Ignoring dimension '" + rulesDimensionNamespace.getKey() + DIMENSION_PATH_SEPARATOR + key + "': a dimension name can't be empty or contain '.'.");
                }
            }
            if (z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
