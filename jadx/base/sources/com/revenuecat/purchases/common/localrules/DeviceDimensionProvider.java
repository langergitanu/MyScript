package com.revenuecat.purchases.common.localrules;

import android.os.Build;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.LocaleProvider;
import com.revenuecat.purchases.common.StorePlatformKt;
import com.revenuecat.purchases.common.localrules.RulesDimensionValue;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: DeviceDimensionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\bH\u0002J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/DeviceDimensionProvider;", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "localeProvider", "Lcom/revenuecat/purchases/common/LocaleProvider;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/LocaleProvider;)V", "fallbackLanguageTag", "", "fixedDimensions", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "getNamespace", "()Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "currentLocale", "dimensions", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DeviceDimensionProvider implements RulesDimensionProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_APP_VERSION = "appVersion";
    public static final String KEY_LOCALE = "locale";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PLATFORM_VERSION = "platformVersion";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    private final String fallbackLanguageTag;
    private final Map<String, RulesDimensionValue> fixedDimensions;
    private final LocaleProvider localeProvider;
    private final RulesDimensionNamespace namespace;

    public DeviceDimensionProvider(AppConfig appConfig, LocaleProvider localeProvider) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.localeProvider = localeProvider;
        this.namespace = RulesDimensionNamespace.Device;
        this.fixedDimensions = MapsKt.mapOf(TuplesKt.m1606to("appVersion", new RulesDimensionValue.StringValue(appConfig.getVersionName())), TuplesKt.m1606to(KEY_PLATFORM, new RulesDimensionValue.StringValue(StorePlatformKt.getPlatformName(appConfig.getStore()))), TuplesKt.m1606to("platformVersion", new RulesDimensionValue.IntValue(Build.VERSION.SDK_INT)), TuplesKt.m1606to("sdkVersion", new RulesDimensionValue.StringValue("10.20.0")));
        this.fallbackLanguageTag = appConfig.getLanguageTag();
    }

    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    public RulesDimensionNamespace getNamespace() {
        return this.namespace;
    }

    @Override // com.revenuecat.purchases.common.localrules.RulesDimensionProvider
    public Object dimensions(Date date, Continuation<? super Map<String, ? extends RulesDimensionValue>> continuation) {
        Map mapPlus = MapsKt.plus(this.fixedDimensions, TuplesKt.m1606to("locale", new RulesDimensionValue.StringValue(currentLocale())));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapPlus.entrySet()) {
            if (INSTANCE.getHasValue((RulesDimensionValue) entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final String currentLocale() {
        String strSubstringBefore$default = StringsKt.substringBefore$default(this.localeProvider.getCurrentLocalesLanguageTags(), AbstractJsonLexerKt.COMMA, (String) null, 2, (Object) null);
        if (strSubstringBefore$default.length() == 0) {
            strSubstringBefore$default = this.fallbackLanguageTag;
        }
        String lowerCase = strSubstringBefore$default.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.replace$default(lowerCase, Soundex.SILENT_MARKER, '_', false, 4, (Object) null);
    }

    /* JADX INFO: compiled from: DeviceDimensionProvider.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/DeviceDimensionProvider$Companion;", "", "()V", "KEY_APP_VERSION", "", "KEY_LOCALE", "KEY_PLATFORM", "KEY_PLATFORM_VERSION", "KEY_SDK_VERSION", "hasValue", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", "getHasValue", "(Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;)Z", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasValue(RulesDimensionValue rulesDimensionValue) {
            return !(rulesDimensionValue instanceof RulesDimensionValue.StringValue) || ((RulesDimensionValue.StringValue) rulesDimensionValue).getValue().length() > 0;
        }
    }
}
