package com.revenuecat.purchases.rules;

import com.revenuecat.purchases.rules.RulesEngine;
import com.revenuecat.purchases.rules.Value;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: ValueJson.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/ValueJson;", "", "()V", "convert", "Lcom/revenuecat/purchases/rules/Value;", "parsed", "parse", "input", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ValueJson {
    public static final ValueJson INSTANCE = new ValueJson();

    private ValueJson() {
    }

    public final Value parse(String input) throws RulesEngine.EvaluationException.Parse {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            return convert(new JSONTokener(input).nextValue());
        } catch (JSONException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unknown JSON error";
            }
            throw new RulesEngine.EvaluationException.Parse(message);
        }
    }

    private final Value convert(Object parsed) throws RulesEngine.EvaluationException.Parse {
        if (parsed == null ? true : Intrinsics.areEqual(parsed, JSONObject.NULL)) {
            return Value.Null.INSTANCE;
        }
        if (parsed instanceof Boolean) {
            return new Value.BoolValue(((Boolean) parsed).booleanValue());
        }
        if (parsed instanceof Integer) {
            return new Value.IntValue(((Number) parsed).intValue());
        }
        if (parsed instanceof Long) {
            return new Value.IntValue(((Number) parsed).longValue());
        }
        if (parsed instanceof Double) {
            return new Value.FloatValue(((Number) parsed).doubleValue());
        }
        if (parsed instanceof Float) {
            return new Value.FloatValue(((Number) parsed).floatValue());
        }
        if (parsed instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) parsed;
            if (bigDecimal.scale() > 0) {
                return new Value.FloatValue(bigDecimal.doubleValue());
            }
            return new Value.IntValue(bigDecimal.longValue());
        }
        if (parsed instanceof Number) {
            Number number = (Number) parsed;
            long jLongValue = number.longValue();
            if (((double) jLongValue) == number.doubleValue()) {
                return new Value.IntValue(jLongValue);
            }
            return new Value.FloatValue(number.doubleValue());
        }
        if (parsed instanceof String) {
            return new Value.StringValue((String) parsed);
        }
        if (parsed instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) parsed;
            IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.convert(jSONArray.opt(((IntIterator) it).nextInt())));
            }
            return new Value.ArrayValue(arrayList);
        }
        if (parsed instanceof JSONObject) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            JSONObject jSONObject = (JSONObject) parsed;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, convert(jSONObject.opt(key)));
            }
            return new Value.ObjectValue(linkedHashMap);
        }
        throw new RulesEngine.EvaluationException.Parse("unexpected JSONTokener output of type " + Reflection.getOrCreateKotlinClass(parsed.getClass()).getQualifiedName());
    }
}
