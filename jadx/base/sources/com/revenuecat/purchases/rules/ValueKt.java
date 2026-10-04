package com.revenuecat.purchases.rules;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.provider.CredentialEntry;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.rules.Value;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Value.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"JS_OBJECT_STRING", "", "NUMERIC_PREFIX_REGEX", "Lkotlin/text/Regex;", "jsArrayElementString", "value", "Lcom/revenuecat/purchases/rules/Value;", "jsArrayJoin", FirebaseAnalytics.Param.ITEMS, "", "jsNumberString", "", "jsParseFloat", "jsString", "jsToNumber", "looseEq", "", "lhs", "rhs", "parseFloatPrefix", TypedValues.Custom.S_STRING, "strictEq", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ValueKt {
    private static final String JS_OBJECT_STRING = "[object Object]";
    private static final Regex NUMERIC_PREFIX_REGEX = new Regex("^[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");

    public static final double jsToNumber(Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, Value.Null.INSTANCE)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (Intrinsics.areEqual(value, Value.Undefined.INSTANCE)) {
            return Double.NaN;
        }
        if (value instanceof Value.BoolValue) {
            if (((Value.BoolValue) value).getValue()) {
                return 1.0d;
            }
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (value instanceof Value.IntValue) {
            return ((Value.IntValue) value).getValue();
        }
        if (value instanceof Value.FloatValue) {
            return ((Value.FloatValue) value).getValue();
        }
        if (value instanceof Value.StringValue) {
            String string = StringsKt.trim((CharSequence) ((Value.StringValue) value).getValue()).toString();
            if (string.length() == 0) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            Double doubleOrNull = StringsKt.toDoubleOrNull(string);
            if (doubleOrNull != null) {
                return doubleOrNull.doubleValue();
            }
            return Double.NaN;
        }
        if (value instanceof Value.ArrayValue ? true : value instanceof Value.ObjectValue) {
            return Double.NaN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean looseEq(Value lhs, Value rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        boolean z = lhs instanceof Value.Undefined;
        if (z || (rhs instanceof Value.Undefined)) {
            return (z || (lhs instanceof Value.Null)) && ((rhs instanceof Value.Undefined) || (rhs instanceof Value.Null));
        }
        boolean z2 = lhs instanceof Value.Null;
        if (z2 && (rhs instanceof Value.Null)) {
            return true;
        }
        if (!z2 && !(rhs instanceof Value.Null)) {
            if ((lhs instanceof Value.BoolValue) && (rhs instanceof Value.BoolValue)) {
                return ((Value.BoolValue) lhs).getValue() == ((Value.BoolValue) rhs).getValue();
            }
            if ((lhs instanceof Value.StringValue) && (rhs instanceof Value.StringValue)) {
                return Intrinsics.areEqual(((Value.StringValue) lhs).getValue(), ((Value.StringValue) rhs).getValue());
            }
            boolean z3 = lhs instanceof Value.IntValue;
            if (z3 && (rhs instanceof Value.IntValue)) {
                return ((Value.IntValue) lhs).getValue() == ((Value.IntValue) rhs).getValue();
            }
            boolean z4 = lhs instanceof Value.FloatValue;
            if (z4 && (rhs instanceof Value.FloatValue)) {
                return ((Value.FloatValue) lhs).getValue() == ((Value.FloatValue) rhs).getValue();
            }
            if (z3 && (rhs instanceof Value.FloatValue)) {
                return ((double) ((Value.IntValue) lhs).getValue()) == ((Value.FloatValue) rhs).getValue();
            }
            if (z4 && (rhs instanceof Value.IntValue)) {
                return ((Value.FloatValue) lhs).getValue() == ((double) ((Value.IntValue) rhs).getValue());
            }
            boolean z5 = lhs instanceof Value.ArrayValue;
            if (z5 && (rhs instanceof Value.ArrayValue)) {
                return false;
            }
            boolean z6 = lhs instanceof Value.ObjectValue;
            if (z6 && (rhs instanceof Value.ObjectValue)) {
                return false;
            }
            if (z5 && (rhs instanceof Value.ObjectValue)) {
                return false;
            }
            if (z6 && (rhs instanceof Value.ArrayValue)) {
                return false;
            }
            if (z5) {
                return looseEq(new Value.StringValue(jsArrayJoin(((Value.ArrayValue) lhs).getItems())), rhs);
            }
            if (rhs instanceof Value.ArrayValue) {
                return looseEq(lhs, new Value.StringValue(jsArrayJoin(((Value.ArrayValue) rhs).getItems())));
            }
            if (z6) {
                return looseEq(new Value.StringValue(JS_OBJECT_STRING), rhs);
            }
            if (rhs instanceof Value.ObjectValue) {
                return looseEq(lhs, new Value.StringValue(JS_OBJECT_STRING));
            }
            Double numberOrNull$purchases_defaultsRelease = lhs.toNumberOrNull$purchases_defaultsRelease();
            if (numberOrNull$purchases_defaultsRelease != null) {
                double dDoubleValue = numberOrNull$purchases_defaultsRelease.doubleValue();
                Double numberOrNull$purchases_defaultsRelease2 = rhs.toNumberOrNull$purchases_defaultsRelease();
                if (numberOrNull$purchases_defaultsRelease2 != null && dDoubleValue == numberOrNull$purchases_defaultsRelease2.doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final String jsString(Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, Value.Null.INSTANCE)) {
            return AbstractJsonLexerKt.NULL;
        }
        if (Intrinsics.areEqual(value, Value.Undefined.INSTANCE)) {
            return "undefined";
        }
        if (value instanceof Value.BoolValue) {
            return ((Value.BoolValue) value).getValue() ? CredentialEntry.TRUE_STRING : CredentialEntry.FALSE_STRING;
        }
        if (value instanceof Value.IntValue) {
            return String.valueOf(((Value.IntValue) value).getValue());
        }
        if (value instanceof Value.FloatValue) {
            return jsNumberString(((Value.FloatValue) value).getValue());
        }
        if (value instanceof Value.StringValue) {
            return ((Value.StringValue) value).getValue();
        }
        if (value instanceof Value.ArrayValue) {
            return jsArrayJoin(((Value.ArrayValue) value).getItems());
        }
        if (value instanceof Value.ObjectValue) {
            return JS_OBJECT_STRING;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double jsParseFloat(Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value instanceof Value.IntValue ? ((Value.IntValue) value).getValue() : value instanceof Value.FloatValue ? ((Value.FloatValue) value).getValue() : parseFloatPrefix(jsString(value));
    }

    private static final String jsArrayJoin(List<? extends Value> list) {
        return CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1<Value, CharSequence>() { // from class: com.revenuecat.purchases.rules.ValueKt.jsArrayJoin.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Value it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ValueKt.jsArrayElementString(it);
            }
        }, 30, null);
    }

    public static final String jsArrayElementString(Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if ((value instanceof Value.Null) || (value instanceof Value.Undefined)) {
            return "";
        }
        return jsString(value);
    }

    private static final String jsNumberString(double d) {
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (Double.isInfinite(d)) {
            return d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? "Infinity" : "-Infinity";
        }
        long j = (long) d;
        if (j == d) {
            return String.valueOf(j);
        }
        return String.valueOf(d);
    }

    public static final boolean strictEq(Value lhs, Value rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        if ((lhs instanceof Value.Null) && (rhs instanceof Value.Null)) {
            return true;
        }
        if ((lhs instanceof Value.Undefined) && (rhs instanceof Value.Undefined)) {
            return true;
        }
        if ((lhs instanceof Value.BoolValue) && (rhs instanceof Value.BoolValue)) {
            return ((Value.BoolValue) lhs).getValue() == ((Value.BoolValue) rhs).getValue();
        }
        boolean z = lhs instanceof Value.IntValue;
        if (z && (rhs instanceof Value.IntValue)) {
            return ((Value.IntValue) lhs).getValue() == ((Value.IntValue) rhs).getValue();
        }
        boolean z2 = lhs instanceof Value.FloatValue;
        if (z2 && (rhs instanceof Value.FloatValue)) {
            return ((Value.FloatValue) lhs).getValue() == ((Value.FloatValue) rhs).getValue();
        }
        if (z && (rhs instanceof Value.FloatValue)) {
            return ((double) ((Value.IntValue) lhs).getValue()) == ((Value.FloatValue) rhs).getValue();
        }
        if (z2 && (rhs instanceof Value.IntValue)) {
            return ((Value.FloatValue) lhs).getValue() == ((double) ((Value.IntValue) rhs).getValue());
        }
        if ((lhs instanceof Value.StringValue) && (rhs instanceof Value.StringValue)) {
            return Intrinsics.areEqual(((Value.StringValue) lhs).getValue(), ((Value.StringValue) rhs).getValue());
        }
        return false;
    }

    private static final double parseFloatPrefix(String str) {
        String strSubSequence;
        Double doubleOrNull;
        String str2 = str;
        int length = str2.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!CharsKt.isWhitespace(str2.charAt(i))) {
                    strSubSequence = str2.subSequence(i, str2.length());
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        String string = strSubSequence.toString();
        String str3 = string;
        if (str3.length() == 0) {
            return Double.NaN;
        }
        if (StringsKt.startsWith$default(string, "Infinity", false, 2, (Object) null)) {
            return Double.POSITIVE_INFINITY;
        }
        if (StringsKt.startsWith$default(string, "-Infinity", false, 2, (Object) null)) {
            return Double.NEGATIVE_INFINITY;
        }
        if (StringsKt.startsWith$default(string, "+Infinity", false, 2, (Object) null)) {
            return Double.POSITIVE_INFINITY;
        }
        MatchResult matchResultFind$default = Regex.find$default(NUMERIC_PREFIX_REGEX, str3, 0, 2, null);
        if (matchResultFind$default == null || matchResultFind$default.getRange().getFirst() != 0 || (doubleOrNull = StringsKt.toDoubleOrNull(matchResultFind$default.getValue())) == null) {
            return Double.NaN;
        }
        return doubleOrNull.doubleValue();
    }
}
