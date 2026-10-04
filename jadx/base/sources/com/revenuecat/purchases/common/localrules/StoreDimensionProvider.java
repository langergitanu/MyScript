package com.revenuecat.purchases.common.localrules;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Date;
import java.util.IllformedLocaleException;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StoreDimensionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u001e\u0010\u0002\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\u0007J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u0002\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/StoreDimensionProvider;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "storefrontCountryCode", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "getNamespace", "()Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "Lkotlin/jvm/functions/Function1;", "dimensions", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asAlpha3CountryCodeOrNull", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StoreDimensionProvider implements RulesDimensionProvider {
    public static final String KEY_COUNTRY = "country";
    private final RulesDimensionNamespace namespace;
    private final Function1<Continuation<? super String>, Object> storefrontCountryCode;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.localrules.StoreDimensionProvider$dimensions$1 */
    /* JADX INFO: compiled from: StoreDimensionProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.localrules.StoreDimensionProvider", m1609f = "StoreDimensionProvider.kt", m1610i = {0}, m1611l = {40}, m1612m = "dimensions", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C71841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C71841(Continuation<? super C71841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreDimensionProvider.this.dimensions(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreDimensionProvider(Function1<? super Continuation<? super String>, ? extends Object> storefrontCountryCode) {
        Intrinsics.checkNotNullParameter(storefrontCountryCode, "storefrontCountryCode");
        this.storefrontCountryCode = storefrontCountryCode;
        this.namespace = RulesDimensionNamespace.Store;
    }

    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    public RulesDimensionNamespace getNamespace() {
        return this.namespace;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object dimensions(Date date, Continuation<? super Map<String, ? extends RulesDimensionValue>> continuation) {
        C71841 c71841;
        StoreDimensionProvider storeDimensionProvider;
        if (continuation instanceof C71841) {
            c71841 = (C71841) continuation;
            if ((c71841.label & Integer.MIN_VALUE) != 0) {
                c71841.label -= Integer.MIN_VALUE;
            } else {
                c71841 = new C71841(continuation);
            }
        }
        Object objInvoke = c71841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c71841.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function1<Continuation<? super String>, Object> function1 = this.storefrontCountryCode;
                c71841.L$0 = this;
                c71841.label = 1;
                objInvoke = function1.invoke(c71841);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                storeDimensionProvider = this;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                storeDimensionProvider = (StoreDimensionProvider) c71841.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            String str = (String) objInvoke;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return MapsKt.emptyMap();
            }
            String strAsAlpha3CountryCodeOrNull = storeDimensionProvider.asAlpha3CountryCodeOrNull(str);
            if (strAsAlpha3CountryCodeOrNull != null) {
                return MapsKt.mapOf(TuplesKt.m1606to("country", new RulesDimensionValue.StringValue(strAsAlpha3CountryCodeOrNull)));
            }
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Ignoring store country '" + str + "': it has no ISO 3166-1 alpha-3 equivalent.");
            }
            return MapsKt.emptyMap();
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            LogLevel logLevel2 = LogLevel.WARN;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), "The store country is unavailable, so store dimensions can't be evaluated: " + e2);
            }
            return MapsKt.emptyMap();
        }
    }

    private final String asAlpha3CountryCodeOrNull(String str) {
        try {
            String iSO3Country = new Locale.Builder().setRegion(str).build().getISO3Country();
            if (iSO3Country.length() == 0) {
                iSO3Country = null;
            }
            return iSO3Country;
        } catch (IllformedLocaleException | MissingResourceException unused) {
            return null;
        }
    }
}
