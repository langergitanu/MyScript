package com.myscript.nebo.p022ai.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.p022ai.data.model.explain.ExplainStreamData;
import com.myscript.nebo.p022ai.data.model.quiz.QuestionHistory;
import com.myscript.nebo.p022ai.data.model.quiz.QuizContent;
import com.myscript.nebo.p022ai.data.model.quiz.QuizEvent;
import com.myscript.nebo.p022ai.data.model.quiz.QuizUserInfo;
import com.myscript.nebo.p022ai.data.model.summarize.SummarizeStreamData;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NeboAIClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J2\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0012Jx\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00192\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019H¦@¢\u0006\u0002\u0010#¨\u0006$À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/AIClient;", "", "addNetworkStateObserver", "", "removeNetworkStateObserver", "summarize", "Lkotlinx/coroutines/flow/Flow;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "Lcom/myscript/nebo/ai/data/model/summarize/SummarizeStreamData;", "text", "", "shorter", "", LaunchActivity.LaunchRoute.Language, "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "explain", "Lcom/myscript/nebo/ai/data/model/explain/ExplainStreamData;", WebViewMessageType.CONTEXT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateQuiz", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "userInfo", "Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;", "lang", "questionTypes", "", "questionCount", "", "optionCount", "explanation", "contentRef", FirebaseAnalytics.Param.CONTENT, "Lcom/myscript/nebo/ai/data/model/quiz/QuizContent;", "history", "Lcom/myscript/nebo/ai/data/model/quiz/QuestionHistory;", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;Ljava/lang/String;Ljava/util/List;IIZZLjava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AIClient {
    void addNetworkStateObserver();

    Object explain(String str, String str2, String str3, Continuation<? super Flow<? extends AIClientResult<ExplainStreamData>>> continuation);

    Object generateQuiz(QuizUserInfo quizUserInfo, String str, List<String> list, int i, int i2, boolean z, boolean z2, List<QuizContent> list2, List<QuestionHistory> list3, Continuation<? super Flow<? extends AIClientResult<? extends QuizEvent>>> continuation);

    void removeNetworkStateObserver();

    Object summarize(String str, boolean z, String str2, Continuation<? super Flow<? extends AIClientResult<SummarizeStreamData>>> continuation);

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object generateQuiz$default(AIClient aIClient, QuizUserInfo quizUserInfo, String str, List list, int i, int i2, boolean z, boolean z2, List list2, List list3, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            return aIClient.generateQuiz(quizUserInfo, str, list, i, i2, z, z2, list2, (i3 & 256) != 0 ? null : list3, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateQuiz");
    }
}
