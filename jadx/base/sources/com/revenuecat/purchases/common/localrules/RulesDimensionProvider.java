package com.revenuecat.purchases.common.localrules;

import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RulesDimensionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionProvider;", "", "namespace", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "getNamespace", "()Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "dimensions", "", "", "Lcom/revenuecat/purchases/common/localrules/RulesDimensionValue;", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface RulesDimensionProvider {
    Object dimensions(Date date, Continuation<? super Map<String, ? extends RulesDimensionValue>> continuation);

    RulesDimensionNamespace getNamespace();
}
