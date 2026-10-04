package com.revenuecat.purchases.common.localrules;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriberAttributesDimensionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¢\u0006\u0002\u0010\u0007J\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/SubscriberAttributesDimensionProvider;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "storedAttributes", "Lkotlin/Function0;", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "(Lkotlin/jvm/functions/Function0;)V", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "getNamespace", "()Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "dimensions", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TypedValues.Custom.S_DIMENSION, "Lkotlin/Pair;", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SubscriberAttributesDimensionProvider implements RulesDimensionProvider {
    public static final String KEY_EVALUATED_AT = "evaluatedAt";
    public static final String KEY_UPDATED_AT = "updatedAt";
    public static final String KEY_VALUE = "value";
    private final RulesDimensionNamespace namespace;
    private final Function0<Map<String, SubscriberAttribute>> storedAttributes;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriberAttributesDimensionProvider(Function0<? extends Map<String, SubscriberAttribute>> storedAttributes) {
        Intrinsics.checkNotNullParameter(storedAttributes, "storedAttributes");
        this.storedAttributes = storedAttributes;
        this.namespace = RulesDimensionNamespace.SubscriberAttributes;
    }

    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    public RulesDimensionNamespace getNamespace() {
        return this.namespace;
    }

    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    public Object dimensions(Date date, Continuation<? super Map<String, ? extends RulesDimensionValue>> continuation) {
        try {
            Collection<SubscriberAttribute> collectionValues = this.storedAttributes.invoke().values();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                Pair<String, RulesDimensionValue> pairDimension = dimension((SubscriberAttribute) it.next(), date);
                if (pairDimension != null) {
                    arrayList.add(pairDimension);
                }
            }
            return MapsKt.toMap(arrayList);
        } catch (Exception e) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "The subscriber attributes are unavailable, so they can't be evaluated: " + e);
            }
            return MapsKt.emptyMap();
        }
    }

    private final Pair<String, RulesDimensionValue> dimension(SubscriberAttribute subscriberAttribute, Date date) {
        String value = subscriberAttribute.getValue();
        if (value != null) {
            if (value.length() <= 0) {
                value = null;
            }
            if (value != null) {
                return TuplesKt.m1606to(subscriberAttribute.getKey().getBackendKey(), new RulesDimensionValue.ObjectValue(MapsKt.mapOf(TuplesKt.m1606to("value", new RulesDimensionValue.StringValue(value)), TuplesKt.m1606to(KEY_UPDATED_AT, new RulesDimensionValue.DateValue(subscriberAttribute.getSetTime())), TuplesKt.m1606to(KEY_EVALUATED_AT, new RulesDimensionValue.DateValue(date)))));
            }
        }
        return null;
    }
}
