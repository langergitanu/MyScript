package com.myscript.nebo.p022ai.data;

import com.myscript.nebo.p022ai.data.model.explain.ExplainInput;
import com.myscript.nebo.p022ai.data.model.quiz.QuizRequest;
import com.myscript.nebo.p022ai.data.model.summarize.SummarizeInput;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

/* JADX INFO: compiled from: NeboAIApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/NeboAIApi;", "", "summarize", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "summarizeInput", "Lcom/myscript/nebo/ai/data/model/summarize/SummarizeInput;", "(Lcom/myscript/nebo/ai/data/model/summarize/SummarizeInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "explain", "explainInput", "Lcom/myscript/nebo/ai/data/model/explain/ExplainInput;", "(Lcom/myscript/nebo/ai/data/model/explain/ExplainInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shorter", "generateQuiz", "request", "Lcom/myscript/nebo/ai/data/model/quiz/QuizRequest;", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface NeboAIApi {
    @Streaming
    @POST("api/v1/explain")
    Object explain(@Body ExplainInput explainInput, Continuation<? super Response<ResponseBody>> continuation);

    @Streaming
    @POST("api/v2/quiz")
    Object generateQuiz(@Body QuizRequest quizRequest, Continuation<? super Response<ResponseBody>> continuation);

    @Streaming
    @POST("api/v1/shorter")
    Object shorter(@Body SummarizeInput summarizeInput, Continuation<? super Response<ResponseBody>> continuation);

    @Streaming
    @POST("api/v1/summarize")
    Object summarize(@Body SummarizeInput summarizeInput, Continuation<? super Response<ResponseBody>> continuation);
}
