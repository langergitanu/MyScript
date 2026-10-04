package com.myscript.nebo.p022ai.data;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myscript.nebo.LaunchActivity;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.p022ai.data.AIClientError;
import com.myscript.nebo.p022ai.data.AIClientResult;
import com.myscript.nebo.p022ai.data.model.explain.ExplainContent;
import com.myscript.nebo.p022ai.data.model.explain.ExplainInput;
import com.myscript.nebo.p022ai.data.model.explain.ExplainStreamData;
import com.myscript.nebo.p022ai.data.model.quiz.QuestionHistory;
import com.myscript.nebo.p022ai.data.model.quiz.QuizContent;
import com.myscript.nebo.p022ai.data.model.quiz.QuizError;
import com.myscript.nebo.p022ai.data.model.quiz.QuizEvent;
import com.myscript.nebo.p022ai.data.model.quiz.QuizInfo;
import com.myscript.nebo.p022ai.data.model.quiz.QuizOptions;
import com.myscript.nebo.p022ai.data.model.quiz.QuizRequest;
import com.myscript.nebo.p022ai.data.model.quiz.QuizResponse;
import com.myscript.nebo.p022ai.data.model.quiz.QuizUserInfo;
import com.myscript.nebo.p022ai.data.model.summarize.SummarizeContent;
import com.myscript.nebo.p022ai.data.model.summarize.SummarizeInput;
import com.myscript.nebo.p022ai.data.model.summarize.SummarizeStreamData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.TextStreamsKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.internal.p041ws.WebSocketProtocol;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: NeboAIClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001KB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J2\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\"J2\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&Jv\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001d0\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u0002040-2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010-H\u0096@¢\u0006\u0002\u00107Js\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H90\u001d0\u001c\"\u0004\b\u0000\u001092\u0006\u0010:\u001a\u00020\u00052\"\u0010;\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0=\u0012\u0006\u0012\u0004\u0018\u00010@0<2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H90<2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020C0<H\u0002¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010G\u001a\u00020/H\u0002J$\u0010H\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u000e*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/NeboAIClient;", "Lcom/myscript/nebo/ai/data/AIClient;", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "neboNetworkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/log/TechnicalLogger;)V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gsonConverterFactory", "Lretrofit2/converter/gson/GsonConverterFactory;", "connected", "", "networkObserver", "Landroidx/lifecycle/Observer;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "neboAIApi", "Lcom/myscript/nebo/ai/data/NeboAIApi;", "addNetworkStateObserver", "", "removeNetworkStateObserver", "summarize", "Lkotlinx/coroutines/flow/Flow;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "Lcom/myscript/nebo/ai/data/model/summarize/SummarizeStreamData;", "text", "shorter", LaunchActivity.LaunchRoute.Language, "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "explain", "Lcom/myscript/nebo/ai/data/model/explain/ExplainStreamData;", WebViewMessageType.CONTEXT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateQuiz", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "userInfo", "Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;", "lang", "questionTypes", "", "questionCount", "", "optionCount", "explanation", "contentRef", FirebaseAnalytics.Param.CONTENT, "Lcom/myscript/nebo/ai/data/model/quiz/QuizContent;", "history", "Lcom/myscript/nebo/ai/data/model/quiz/QuestionHistory;", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;Ljava/lang/String;Ljava/util/List;IIZZLjava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRequest", ExifInterface.GPS_DIRECTION_TRUE, "endpoint", "request", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "", "parseJson", "mapError", "Lcom/myscript/nebo/ai/data/AIClientError;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "mapQuizServerError", "message", "statusCode", "logNonFatalError", "cause", "", "Provider", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboAIClient implements AIClient {
    public static final int $stable = 8;
    private boolean connected;
    private final Gson gson;
    private final GsonConverterFactory gsonConverterFactory;
    private final TechnicalLogger logger;
    private final NeboAIApi neboAIApi;
    private final NeboNetworkStateRepository neboNetworkStateRepository;
    private final Observer<NeboNetworkState> networkObserver;

    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/NeboAIClient$Provider;", "", "provideNeboAIClient", "Lcom/myscript/nebo/ai/data/NeboAIClient;", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        NeboAIClient provideNeboAIClient();
    }

    public NeboAIClient(OkHttpClient httpClient, String baseUrl, NeboNetworkStateRepository neboNetworkStateRepository, TechnicalLogger technicalLogger) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(neboNetworkStateRepository, "neboNetworkStateRepository");
        this.neboNetworkStateRepository = neboNetworkStateRepository;
        this.logger = technicalLogger;
        Gson gsonCreate = new GsonBuilder().create();
        this.gson = gsonCreate;
        GsonConverterFactory gsonConverterFactoryCreate = GsonConverterFactory.create(gsonCreate);
        this.gsonConverterFactory = gsonConverterFactoryCreate;
        this.connected = true;
        this.networkObserver = new Observer() { // from class: com.myscript.nebo.ai.data.NeboAIClient$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NeboAIClient.networkObserver$lambda$0(this.f$0, (NeboNetworkState) obj);
            }
        };
        this.neboAIApi = (NeboAIApi) new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactoryCreate).client(httpClient).build().create(NeboAIApi.class);
    }

    public /* synthetic */ NeboAIClient(OkHttpClient okHttpClient, String str, NeboNetworkStateRepository neboNetworkStateRepository, TechnicalLogger technicalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, str, neboNetworkStateRepository, (i & 8) != 0 ? null : technicalLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void networkObserver$lambda$0(NeboAIClient neboAIClient, NeboNetworkState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        neboAIClient.connected = it instanceof NeboNetworkState.Connected ? ((NeboNetworkState.Connected) it).isEnabled() : false;
    }

    @Override // com.myscript.nebo.p022ai.data.AIClient
    public void addNetworkStateObserver() {
        this.neboNetworkStateRepository.getNeboNetworkState().observeForever(this.networkObserver);
    }

    @Override // com.myscript.nebo.p022ai.data.AIClient
    public void removeNetworkStateObserver() {
        this.neboNetworkStateRepository.getNeboNetworkState().removeObserver(this.networkObserver);
    }

    @Override // com.myscript.nebo.p022ai.data.AIClient
    public Object summarize(String str, boolean z, String str2, Continuation<? super Flow<? extends AIClientResult<SummarizeStreamData>>> continuation) {
        return performRequest("summarize", new C60992(z, this, str2, str, null), new Function1() { // from class: com.myscript.nebo.ai.data.NeboAIClient$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboAIClient.summarize$lambda$0((String) obj);
            }
        }, new C61004(this));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$summarize$2 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$summarize$2", m1609f = "NeboAIClient.kt", m1610i = {}, m1611l = {WebSocketProtocol.PAYLOAD_SHORT, 134}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {134, PDFACompliance.e_PDFA1_4_1}, m1615s = {}, m1616v = 2)
    static final class C60992 extends SuspendLambda implements Function1<Continuation<? super Response<ResponseBody>>, Object> {
        final /* synthetic */ String $language;
        final /* synthetic */ boolean $shorter;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ NeboAIClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60992(boolean z, NeboAIClient neboAIClient, String str, String str2, Continuation<? super C60992> continuation) {
            super(1, continuation);
            this.$shorter = z;
            this.this$0 = neboAIClient;
            this.$language = str;
            this.$text = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C60992(this.$shorter, this.this$0, this.$language, this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Response<ResponseBody>> continuation) {
            return ((C60992) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            if (r8 == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        
            if (r8 == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return (Response) obj;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return (Response) obj;
            }
            ResultKt.throwOnFailure(obj);
            if (this.$shorter) {
                this.label = 1;
                obj = this.this$0.neboAIApi.shorter(new SummarizeInput(true, this.$language, new SummarizeContent(this.$text)), this);
            } else {
                this.label = 2;
                obj = this.this$0.neboAIApi.summarize(new SummarizeInput(true, this.$language, new SummarizeContent(this.$text)), this);
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$summarize$4 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C61004 extends FunctionReferenceImpl implements Function1<Integer, AIClientError> {
        C61004(Object obj) {
            super(1, obj, NeboAIClient.class, "mapError", "mapError(I)Lcom/myscript/nebo/ai/data/AIClientError;", 0);
        }

        public final AIClientError invoke(int i) {
            return ((NeboAIClient) this.receiver).mapError(i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AIClientError invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SummarizeStreamData summarize$lambda$0(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return (SummarizeStreamData) new Gson().fromJson(jsonString, SummarizeStreamData.class);
    }

    @Override // com.myscript.nebo.p022ai.data.AIClient
    public Object explain(String str, String str2, String str3, Continuation<? super Flow<? extends AIClientResult<ExplainStreamData>>> continuation) {
        return performRequest("explain", new C60922(str3, str, str2, null), new Function1() { // from class: com.myscript.nebo.ai.data.NeboAIClient$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboAIClient.explain$lambda$0((String) obj);
            }
        }, new C60934(this));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$explain$2 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$explain$2", m1609f = "NeboAIClient.kt", m1610i = {}, m1611l = {154}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {160}, m1615s = {}, m1616v = 2)
    static final class C60922 extends SuspendLambda implements Function1<Continuation<? super Response<ResponseBody>>, Object> {
        final /* synthetic */ String $context;
        final /* synthetic */ String $language;
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60922(String str, String str2, String str3, Continuation<? super C60922> continuation) {
            super(1, continuation);
            this.$language = str;
            this.$text = str2;
            this.$context = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NeboAIClient.this.new C60922(this.$language, this.$text, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Response<ResponseBody>> continuation) {
            return ((C60922) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objExplain = NeboAIClient.this.neboAIApi.explain(new ExplainInput(true, this.$language, new ExplainContent(this.$text, this.$context)), this);
            return objExplain == coroutine_suspended ? coroutine_suspended : objExplain;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$explain$4 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C60934 extends FunctionReferenceImpl implements Function1<Integer, AIClientError> {
        C60934(Object obj) {
            super(1, obj, NeboAIClient.class, "mapError", "mapError(I)Lcom/myscript/nebo/ai/data/AIClientError;", 0);
        }

        public final AIClientError invoke(int i) {
            return ((NeboAIClient) this.receiver).mapError(i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AIClientError invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExplainStreamData explain$lambda$0(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return (ExplainStreamData) new Gson().fromJson(jsonString, ExplainStreamData.class);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$generateQuiz$2 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$generateQuiz$2", m1609f = "NeboAIClient.kt", m1610i = {0, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8}, m1611l = {178, PDFACompliance.e_PDFA1_8_2, 202, 206, 208, 226, 230, 235, 247}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$flow", "$this$flow", "response", "errorBody", "statusCode", "$this$flow", "response", "$this$flow", "response", "responseBody", "$this$flow", "response", "responseBody", "$this$useLines$iv", "it$iv", "lines", "currentEvent", "line", "trimmedLine", "jsonString", "info", "$i$f$useLines", "$i$a$-use-TextStreamsKt$useLines$1$iv", "$i$a$-useLines-NeboAIClient$generateQuiz$2$2", "$this$flow", "response", "responseBody", "$this$useLines$iv", "it$iv", "lines", "currentEvent", "line", "trimmedLine", "jsonString", "quizResponse", "$i$f$useLines", "$i$a$-use-TextStreamsKt$useLines$1$iv", "$i$a$-useLines-NeboAIClient$generateQuiz$2$2", "$this$flow", "response", "responseBody", "$this$useLines$iv", "it$iv", "lines", "currentEvent", "line", "trimmedLine", "jsonString", "quizError", "$i$f$useLines", "$i$a$-use-TextStreamsKt$useLines$1$iv", "$i$a$-useLines-NeboAIClient$generateQuiz$2$2", "$this$flow", "response", "responseBody"}, m1614nl = {179, 198, 203, 208, 210, 229, PDFACompliance.e_PDFA2_3_3, 236, 248}, m1615s = {"L$0", "L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C60942 extends SuspendLambda implements Function2<FlowCollector<? super AIClientResult<? extends QuizEvent>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<QuizContent> $content;
        final /* synthetic */ boolean $contentRef;
        final /* synthetic */ boolean $explanation;
        final /* synthetic */ List<QuestionHistory> $history;
        final /* synthetic */ String $lang;
        final /* synthetic */ int $optionCount;
        final /* synthetic */ int $questionCount;
        final /* synthetic */ List<String> $questionTypes;
        final /* synthetic */ QuizUserInfo $userInfo;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60942(QuizUserInfo quizUserInfo, String str, List<String> list, int i, int i2, boolean z, boolean z2, List<QuizContent> list2, List<QuestionHistory> list3, Continuation<? super C60942> continuation) {
            super(2, continuation);
            this.$userInfo = quizUserInfo;
            this.$lang = str;
            this.$questionTypes = list;
            this.$questionCount = i;
            this.$optionCount = i2;
            this.$explanation = z;
            this.$contentRef = z2;
            this.$content = list2;
            this.$history = list3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C60942 c60942 = NeboAIClient.this.new C60942(this.$userInfo, this.$lang, this.$questionTypes, this.$questionCount, this.$optionCount, this.$explanation, this.$contentRef, this.$content, this.$history, continuation);
            c60942.L$0 = obj;
            return c60942;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super AIClientResult<? extends QuizEvent>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C60942) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:121:0x055b, code lost:
        
            if (r3.emit(com.myscript.nebo.ai.data.AIClientResult.StreamingComplete.INSTANCE, r24) == r4) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0142, code lost:
        
            if (r3.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(com.myscript.nebo.ai.data.AIClientError.NetworkError.INSTANCE), r24) == r4) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x01ef, code lost:
        
            if (r3.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(r24.this$0.mapError(r0)), r24) == r4) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x021d, code lost:
        
            if (r3.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(com.myscript.nebo.ai.data.AIClientError.UnknownError.INSTANCE), r24) == r4) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x023a, code lost:
        
            if (r3.emit(com.myscript.nebo.ai.data.AIClientResult.StreamingStarted.INSTANCE, r24) == r4) goto L122;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x028b A[Catch: all -> 0x0561, TryCatch #0 {all -> 0x0561, blocks: (B:74:0x0285, B:76:0x028b, B:78:0x02ae, B:79:0x02c6, B:81:0x02cf, B:84:0x02ec, B:91:0x0307, B:94:0x0310, B:100:0x03ba, B:102:0x03ca, B:108:0x045f, B:111:0x0479, B:73:0x026e), top: B:131:0x026e }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0471 -> B:116:0x0504). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x04e8 -> B:115:0x04f8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objGenerateQuiz;
            Response response;
            ResponseBody responseBody;
            String str;
            BufferedReader bufferedReader;
            Iterator<String> it;
            Reader reader;
            BufferedReader bufferedReader2;
            Sequence<String> sequence;
            int i;
            int i2;
            String string;
            Throwable th;
            NeboAIClient neboAIClient;
            int i3;
            Throwable th2;
            String str2;
            Closeable closeable;
            int i4;
            int i5;
            int i6;
            int i7;
            Reader reader2;
            NeboAIClient neboAIClient2;
            int i8;
            Closeable closeable2;
            Iterator<String> it2;
            Sequence<String> sequence2;
            BufferedReader bufferedReader3;
            ResponseBody responseBody2;
            ResponseBody responseBody3;
            Response response2;
            String str3 = "data: ";
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (NeboAIClient.this.connected) {
                        this.L$0 = flowCollector;
                        this.label = 2;
                        objGenerateQuiz = NeboAIClient.this.neboAIApi.generateQuiz(new QuizRequest(this.$userInfo, new QuizOptions(this.$lang, this.$questionTypes, this.$questionCount, this.$optionCount, this.$explanation, this.$contentRef), this.$content, this.$history), this);
                        if (objGenerateQuiz != coroutine_suspended) {
                            response = (Response) objGenerateQuiz;
                            if (response.isSuccessful()) {
                                int iCode = response.code();
                                ResponseBody responseBodyErrorBody = response.errorBody();
                                String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                                NeboAIClient neboAIClient3 = NeboAIClient.this;
                                if (strString == null || (str = " - " + strString) == null) {
                                    str = "";
                                }
                                NeboAIClient.logNonFatalError$default(neboAIClient3, "quiz", "HTTP " + iCode + str, null, 4, null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(strString);
                                this.I$0 = iCode;
                                this.label = 3;
                            } else {
                                responseBody = (ResponseBody) response.body();
                                if (responseBody != null) {
                                    this.L$0 = flowCollector;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                    this.L$2 = responseBody;
                                    this.label = 5;
                                } else {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                    this.label = 4;
                                }
                            }
                        }
                        break;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.label = 1;
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    objGenerateQuiz = obj;
                    response = (Response) objGenerateQuiz;
                    if (response.isSuccessful()) {
                    }
                    return coroutine_suspended;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 5:
                    responseBody = (ResponseBody) this.L$2;
                    response = (Response) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Reader inputStreamReader = new InputStreamReader(responseBody.byteStream(), Charsets.UTF_8);
                    BufferedReader bufferedReader4 = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    NeboAIClient neboAIClient4 = NeboAIClient.this;
                    bufferedReader = bufferedReader4 instanceof BufferedReader ? bufferedReader4 : new BufferedReader(bufferedReader4, 8192);
                    try {
                        BufferedReader bufferedReader5 = bufferedReader;
                        Sequence<String> sequenceLineSequence = TextStreamsKt.lineSequence(bufferedReader5);
                        it = sequenceLineSequence.iterator();
                        reader = bufferedReader4;
                        bufferedReader2 = bufferedReader5;
                        sequence = sequenceLineSequence;
                        i = 0;
                        i2 = 0;
                        string = null;
                        th = null;
                        neboAIClient = neboAIClient4;
                        i3 = 0;
                        while (it.hasNext()) {
                            String next = it.next();
                            String string2 = StringsKt.trim((CharSequence) next).toString();
                            ResponseBody responseBody4 = responseBody;
                            Response response3 = response;
                            NeboAIClient neboAIClient5 = neboAIClient;
                            if (StringsKt.startsWith$default(string2, "event: ", false, 2, (Object) null)) {
                                string = StringsKt.trim((CharSequence) StringsKt.removePrefix(string2, (CharSequence) "event: ")).toString();
                                responseBody = responseBody4;
                                response = response3;
                                neboAIClient = neboAIClient5;
                            } else {
                                if (StringsKt.startsWith$default(string2, str3, false, 2, (Object) null)) {
                                    String string3 = StringsKt.trim((CharSequence) StringsKt.removePrefix(string2, (CharSequence) str3)).toString();
                                    if (string3.length() > 0 && string != null) {
                                        int iHashCode = string.hashCode();
                                        if (iHashCode != -1165870106) {
                                            if (iHashCode != 3237038) {
                                                if (iHashCode == 96784904 && string.equals("error")) {
                                                    QuizError quizError = (QuizError) new Gson().fromJson(string3, QuizError.class);
                                                    int i9 = i;
                                                    NeboAIClient.logNonFatalError$default(neboAIClient5, "quiz", "server sent error: " + quizError.getMessage(), null, 4, null);
                                                    AIClientResult.Error error = new AIClientResult.Error(neboAIClient5.mapQuizServerError(quizError.getMessage()));
                                                    this.L$0 = flowCollector;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody4);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(reader);
                                                    this.L$4 = bufferedReader;
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(bufferedReader2);
                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(sequence);
                                                    this.L$7 = SpillingKt.nullOutSpilledVariable(string);
                                                    this.L$8 = SpillingKt.nullOutSpilledVariable(next);
                                                    this.L$9 = SpillingKt.nullOutSpilledVariable(string2);
                                                    this.L$10 = SpillingKt.nullOutSpilledVariable(string3);
                                                    this.L$11 = SpillingKt.nullOutSpilledVariable(quizError);
                                                    this.L$12 = null;
                                                    this.L$13 = null;
                                                    this.I$0 = i2;
                                                    this.I$1 = i9;
                                                    this.I$2 = i3;
                                                    this.label = 8;
                                                    if (flowCollector.emit(error, this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    responseBody3 = responseBody4;
                                                    closeable = bufferedReader;
                                                    response2 = response3;
                                                    response = response2;
                                                    responseBody = responseBody3;
                                                    Throwable th3 = th;
                                                    Unit unit = Unit.INSTANCE;
                                                    CloseableKt.closeFinally(closeable, th3);
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.L$6 = null;
                                                    this.L$7 = null;
                                                    this.L$8 = null;
                                                    this.L$9 = null;
                                                    this.L$10 = null;
                                                    this.L$11 = null;
                                                    this.L$12 = null;
                                                    this.L$13 = null;
                                                    this.label = 9;
                                                }
                                                str2 = str3;
                                                i4 = i;
                                                i5 = i2;
                                                neboAIClient = neboAIClient5;
                                                i = i4;
                                                i2 = i5;
                                                response = response3;
                                                responseBody = responseBody4;
                                                break;
                                            } else {
                                                i4 = i;
                                                i5 = i2;
                                                neboAIClient = neboAIClient5;
                                                if (string.equals("info")) {
                                                    QuizInfo quizInfo = (QuizInfo) new Gson().fromJson(string3, QuizInfo.class);
                                                    str2 = str3;
                                                    Intrinsics.checkNotNull(quizInfo);
                                                    AIClientResult.Success success = new AIClientResult.Success(new QuizEvent.Info(quizInfo));
                                                    this.L$0 = flowCollector;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody4);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(reader);
                                                    this.L$4 = neboAIClient;
                                                    this.L$5 = bufferedReader;
                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(bufferedReader2);
                                                    this.L$7 = SpillingKt.nullOutSpilledVariable(sequence);
                                                    this.L$8 = SpillingKt.nullOutSpilledVariable(string);
                                                    this.L$9 = it;
                                                    this.L$10 = SpillingKt.nullOutSpilledVariable(next);
                                                    this.L$11 = SpillingKt.nullOutSpilledVariable(string2);
                                                    this.L$12 = SpillingKt.nullOutSpilledVariable(string3);
                                                    this.L$13 = SpillingKt.nullOutSpilledVariable(quizInfo);
                                                    this.I$0 = i5;
                                                    this.I$1 = i4;
                                                    this.I$2 = i3;
                                                    this.label = 6;
                                                    if (flowCollector.emit(success, this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    sequence = sequence;
                                                    bufferedReader2 = bufferedReader2;
                                                    neboAIClient = neboAIClient;
                                                    i = i4;
                                                    it = it;
                                                    bufferedReader = bufferedReader;
                                                    response = response3;
                                                    i2 = i5;
                                                    reader = reader;
                                                    i3 = i3;
                                                    responseBody = responseBody4;
                                                } else {
                                                    str2 = str3;
                                                    i = i4;
                                                    i2 = i5;
                                                    response = response3;
                                                    responseBody = responseBody4;
                                                }
                                            }
                                        } else {
                                            neboAIClient = neboAIClient5;
                                            str2 = str3;
                                            i4 = i;
                                            i5 = i2;
                                            if (string.equals("question")) {
                                                QuizResponse quizResponse = (QuizResponse) new Gson().fromJson(string3, QuizResponse.class);
                                                Intrinsics.checkNotNull(quizResponse);
                                                AIClientResult.Success success2 = new AIClientResult.Success(new QuizEvent.Question(quizResponse));
                                                this.L$0 = flowCollector;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody4);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(reader);
                                                this.L$4 = neboAIClient;
                                                this.L$5 = bufferedReader;
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(bufferedReader2);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(sequence);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable(string);
                                                this.L$9 = it;
                                                this.L$10 = SpillingKt.nullOutSpilledVariable(next);
                                                this.L$11 = SpillingKt.nullOutSpilledVariable(string2);
                                                this.L$12 = SpillingKt.nullOutSpilledVariable(string3);
                                                this.L$13 = SpillingKt.nullOutSpilledVariable(quizResponse);
                                                this.I$0 = i5;
                                                this.I$1 = i4;
                                                this.I$2 = i3;
                                                this.label = 7;
                                                if (flowCollector.emit(success2, this) != coroutine_suspended) {
                                                    i6 = i4;
                                                    i7 = i3;
                                                    reader2 = reader;
                                                    neboAIClient2 = neboAIClient;
                                                    i8 = i5;
                                                    closeable2 = bufferedReader;
                                                    it2 = it;
                                                    sequence2 = sequence;
                                                    bufferedReader3 = bufferedReader2;
                                                    response = response3;
                                                    responseBody2 = responseBody4;
                                                    sequence = sequence2;
                                                    bufferedReader2 = bufferedReader3;
                                                    it = it2;
                                                    i2 = i8;
                                                    i = i6;
                                                    neboAIClient = neboAIClient2;
                                                    reader = reader2;
                                                    i3 = i7;
                                                    responseBody = responseBody2;
                                                    bufferedReader = closeable2;
                                                }
                                                return coroutine_suspended;
                                            }
                                            i = i4;
                                            i2 = i5;
                                            response = response3;
                                            responseBody = responseBody4;
                                        }
                                        str3 = str2;
                                        string = null;
                                        while (it.hasNext()) {
                                        }
                                    }
                                }
                                neboAIClient = neboAIClient5;
                                i = i;
                                i2 = i2;
                                response = response3;
                                str3 = str3;
                                responseBody = responseBody4;
                            }
                        }
                        closeable = bufferedReader;
                        Throwable th32 = th;
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable, th32);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.L$11 = null;
                        this.L$12 = null;
                        this.L$13 = null;
                        this.label = 9;
                        break;
                    } catch (Throwable th4) {
                        th = th4;
                        th2 = th;
                        try {
                            throw th2;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(bufferedReader, th2);
                            throw th5;
                        }
                    }
                    break;
                case 6:
                    int i10 = this.I$2;
                    int i11 = this.I$1;
                    int i12 = this.I$0;
                    Iterator<String> it3 = (Iterator) this.L$9;
                    Sequence<String> sequence3 = (Sequence) this.L$7;
                    BufferedReader bufferedReader6 = (BufferedReader) this.L$6;
                    Closeable closeable3 = (Closeable) this.L$5;
                    NeboAIClient neboAIClient6 = (NeboAIClient) this.L$4;
                    Reader reader3 = (Reader) this.L$3;
                    ResponseBody responseBody5 = (ResponseBody) this.L$2;
                    Response response4 = (Response) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str2 = "data: ";
                        th = null;
                        sequence = sequence3;
                        bufferedReader2 = bufferedReader6;
                        neboAIClient = neboAIClient6;
                        i = i11;
                        it = it3;
                        bufferedReader = closeable3;
                        response = response4;
                        i2 = i12;
                        reader = reader3;
                        i3 = i10;
                        responseBody = responseBody5;
                        str3 = str2;
                        string = null;
                        while (it.hasNext()) {
                        }
                        closeable = bufferedReader;
                        Throwable th322 = th;
                        Unit unit22 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable, th322);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.L$11 = null;
                        this.L$12 = null;
                        this.L$13 = null;
                        this.label = 9;
                    } catch (Throwable th6) {
                        th2 = th6;
                        bufferedReader = closeable3;
                        throw th2;
                    }
                    break;
                case 7:
                    i7 = this.I$2;
                    i6 = this.I$1;
                    i8 = this.I$0;
                    it2 = (Iterator) this.L$9;
                    sequence2 = (Sequence) this.L$7;
                    bufferedReader3 = (BufferedReader) this.L$6;
                    closeable2 = (Closeable) this.L$5;
                    neboAIClient2 = (NeboAIClient) this.L$4;
                    reader2 = (Reader) this.L$3;
                    responseBody2 = (ResponseBody) this.L$2;
                    response = (Response) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str2 = "data: ";
                        th = null;
                        sequence = sequence2;
                        bufferedReader2 = bufferedReader3;
                        it = it2;
                        i2 = i8;
                        i = i6;
                        neboAIClient = neboAIClient2;
                        reader = reader2;
                        i3 = i7;
                        responseBody = responseBody2;
                        bufferedReader = closeable2;
                        str3 = str2;
                        string = null;
                        while (it.hasNext()) {
                        }
                        closeable = bufferedReader;
                        Throwable th3222 = th;
                        Unit unit222 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable, th3222);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.L$11 = null;
                        this.L$12 = null;
                        this.L$13 = null;
                        this.label = 9;
                    } catch (Throwable th7) {
                        th2 = th7;
                        bufferedReader = closeable2;
                        throw th2;
                    }
                    break;
                case 8:
                    closeable = (Closeable) this.L$4;
                    responseBody3 = (ResponseBody) this.L$2;
                    response2 = (Response) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        response = response2;
                        responseBody = responseBody3;
                        Throwable th32222 = th;
                        Unit unit2222 = Unit.INSTANCE;
                        CloseableKt.closeFinally(closeable, th32222);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.L$11 = null;
                        this.L$12 = null;
                        this.L$13 = null;
                        this.label = 9;
                    } catch (Throwable th8) {
                        th = th8;
                        bufferedReader = closeable;
                        th2 = th;
                        throw th2;
                    }
                    break;
                case 9:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.myscript.nebo.p022ai.data.AIClient
    public Object generateQuiz(QuizUserInfo quizUserInfo, String str, List<String> list, int i, int i2, boolean z, boolean z2, List<QuizContent> list2, List<QuestionHistory> list3, Continuation<? super Flow<? extends AIClientResult<? extends QuizEvent>>> continuation) {
        return FlowKt.m16058catch(FlowKt.flow(new C60942(quizUserInfo, str, list, i, i2, z, z2, list2, list3, null)), new C60953(null));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$generateQuiz$3 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "Lcom/myscript/nebo/ai/data/model/quiz/QuizEvent;", "e", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$generateQuiz$3", m1609f = "NeboAIClient.kt", m1610i = {0, 0}, m1611l = {250}, m1612m = "invokeSuspend", m1613n = {"$this$catch", "e"}, m1614nl = {PDFACompliance.e_PDFA2_5_1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C60953 extends SuspendLambda implements Function3<FlowCollector<? super AIClientResult<? extends QuizEvent>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        C60953(Continuation<? super C60953> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super AIClientResult<? extends QuizEvent>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C60953 c60953 = NeboAIClient.this.new C60953(continuation);
            c60953.L$0 = flowCollector;
            c60953.L$1 = th;
            return c60953.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NeboAIClient neboAIClient = NeboAIClient.this;
                String message = th.getMessage();
                if (message == null) {
                    message = "unknown exception";
                }
                neboAIClient.logNonFatalError("quiz", message, th);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(new AIClientResult.Error(AIClientError.ServerError.INSTANCE), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$performRequest$1 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/myscript/nebo/ai/data/AIClientResult;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$performRequest$1", m1609f = "NeboAIClient.kt", m1610i = {0, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, m1611l = {260, 264, 269, 273, 282, 284}, m1612m = "invokeSuspend", m1613n = {"$this$flow", "$this$flow", "$this$flow", "response", "errorBody", "statusCode", "$this$flow", "response", "$this$flow", "response", "responseBody", "isFirstEmission", "$this$useLines$iv", "it$iv", "lines", "$this$forEach$iv", "element$iv", "line", "jsonString", "result", "$i$f$useLines", "$i$a$-use-TextStreamsKt$useLines$1$iv", "$i$a$-useLines-NeboAIClient$performRequest$1$2", "$i$f$forEach", "$i$a$-forEach-NeboAIClient$performRequest$1$2$1", "$this$flow", "response", "responseBody", "isFirstEmission", "$this$useLines$iv", "it$iv", "lines", "$this$forEach$iv", "element$iv", "line", "jsonString", "result", "$i$f$useLines", "$i$a$-use-TextStreamsKt$useLines$1$iv", "$i$a$-useLines-NeboAIClient$performRequest$1$2", "$i$f$forEach", "$i$a$-forEach-NeboAIClient$performRequest$1$2$1"}, m1614nl = {PDFACompliance.e_PDFA2_6_1, 265, 270, 274, 284, 286}, m1615s = {"L$0", "L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C60961<T> extends SuspendLambda implements Function2<FlowCollector<? super AIClientResult<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endpoint;
        final /* synthetic */ Function1<Integer, AIClientError> $mapError;
        final /* synthetic */ Function1<String, T> $parseJson;
        final /* synthetic */ Function1<Continuation<? super Response<ResponseBody>>, Object> $request;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C60961(Function1<? super Continuation<? super Response<ResponseBody>>, ? extends Object> function1, String str, Function1<? super Integer, ? extends AIClientError> function12, Function1<? super String, ? extends T> function13, Continuation<? super C60961> continuation) {
            super(2, continuation);
            this.$request = function1;
            this.$endpoint = str;
            this.$mapError = function12;
            this.$parseJson = function13;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C60961 c60961 = NeboAIClient.this.new C60961(this.$request, this.$endpoint, this.$mapError, this.$parseJson, continuation);
            c60961.L$0 = obj;
            return c60961;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super AIClientResult<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C60961) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0110, code lost:
        
            if (r0.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(com.myscript.nebo.ai.data.AIClientError.NetworkError.INSTANCE), r25) == r2) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x019f, code lost:
        
            if (r0.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(r25.$mapError.invoke(kotlin.coroutines.jvm.internal.Boxing.boxInt(r5))), r25) == r2) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x01cd, code lost:
        
            if (r0.emit(new com.myscript.nebo.ai.data.AIClientResult.Error(com.myscript.nebo.ai.data.AIClientError.UnknownError.INSTANCE), r25) == r2) goto L79;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x022b A[Catch: all -> 0x0394, TryCatch #1 {all -> 0x0394, blocks: (B:65:0x0225, B:67:0x022b, B:69:0x0247, B:71:0x0253, B:84:0x038c), top: B:95:0x0225 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0359  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x038c A[Catch: all -> 0x0394, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0394, blocks: (B:65:0x0225, B:67:0x022b, B:69:0x0247, B:71:0x0253, B:84:0x038c), top: B:95:0x0225 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0359 -> B:81:0x0367). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x037a -> B:83:0x0384). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            Closeable closeable;
            Object objInvoke;
            Response response;
            ResponseBody responseBody;
            Ref.BooleanRef booleanRef;
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2;
            Response response2;
            Function1<String, T> function1;
            Sequence<String> sequence;
            Sequence<String> sequence2;
            Iterator<String> it;
            Closeable closeable2;
            int i;
            Throwable th2;
            int i2;
            int i3;
            int i4;
            String str;
            int i5;
            int i6;
            int i7;
            String str2;
            Object obj2;
            Iterator<String> it2;
            Sequence<String> sequence3;
            Sequence<String> sequence4;
            int i8;
            BufferedReader bufferedReader3;
            Function1<String, T> function12;
            Ref.BooleanRef booleanRef2;
            Response response3;
            String str3;
            Object objInvoke2;
            ResponseBody responseBody2;
            String str4;
            Throwable th3;
            String str5;
            Reader reader;
            Object obj3;
            Sequence<String> sequence5;
            Sequence<String> sequence6;
            int i9;
            Ref.BooleanRef booleanRef3;
            int i10;
            int i11;
            AIClientResult.Success success;
            int i12;
            int i13;
            Iterator<String> it3;
            Throwable th4;
            BufferedReader bufferedReader4;
            ResponseBody responseBody3;
            Function1<String, T> function13;
            Response response4;
            Iterator<String> it4;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str6 = "";
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (!NeboAIClient.this.connected) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            this.label = 1;
                            break;
                        } else {
                            Function1<Continuation<? super Response<ResponseBody>>, Object> function14 = this.$request;
                            this.L$0 = flowCollector;
                            this.label = 2;
                            objInvoke = function14.invoke(this);
                            if (objInvoke != coroutine_suspended) {
                                response = (Response) objInvoke;
                                if (response.isSuccessful()) {
                                    int iCode = response.code();
                                    ResponseBody responseBodyErrorBody = response.errorBody();
                                    String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                                    NeboAIClient neboAIClient = NeboAIClient.this;
                                    String str7 = this.$endpoint;
                                    if (strString != null && (str = " - " + strString) != null) {
                                        str6 = str;
                                    }
                                    NeboAIClient.logNonFatalError$default(neboAIClient, str7, "HTTP " + iCode + str6, null, 4, null);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(strString);
                                    this.I$0 = iCode;
                                    this.label = 3;
                                    break;
                                } else {
                                    responseBody = (ResponseBody) response.body();
                                    if (responseBody == null) {
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        this.label = 4;
                                        break;
                                    } else {
                                        booleanRef = new Ref.BooleanRef();
                                        booleanRef.element = true;
                                        Reader inputStreamReader = new InputStreamReader(responseBody.byteStream(), Charsets.UTF_8);
                                        bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                                        Function1<String, T> function15 = this.$parseJson;
                                        BufferedReader bufferedReader5 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
                                        bufferedReader2 = bufferedReader5;
                                        Sequence<String> sequenceLineSequence = TextStreamsKt.lineSequence(bufferedReader2);
                                        response2 = response;
                                        function1 = function15;
                                        sequence = sequenceLineSequence;
                                        sequence2 = sequence;
                                        it = sequenceLineSequence.iterator();
                                        closeable2 = bufferedReader5;
                                        i = 0;
                                        th2 = null;
                                        i2 = 0;
                                        i3 = 0;
                                        i4 = 0;
                                        try {
                                            if (!it.hasNext()) {
                                                String next = it.next();
                                                responseBody2 = responseBody;
                                                String str8 = next;
                                                BufferedReader bufferedReader6 = bufferedReader2;
                                                String strSubstringAfter = StringsKt.substringAfter(str8, "data: ", str6);
                                                if (strSubstringAfter.length() > 0) {
                                                    str3 = str6;
                                                    objInvoke2 = function1.invoke(strSubstringAfter);
                                                    str5 = str8;
                                                    if (booleanRef.element) {
                                                        booleanRef.element = false;
                                                        AIClientResult.StreamingStarted streamingStarted = AIClientResult.StreamingStarted.INSTANCE;
                                                        this.L$0 = flowCollector;
                                                        str4 = strSubstringAfter;
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody2);
                                                        this.L$3 = booleanRef;
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(bufferedReader);
                                                        this.L$5 = function1;
                                                        this.L$6 = closeable2;
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable(bufferedReader6);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(sequence2);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(sequence);
                                                        this.L$10 = it;
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable(next);
                                                        this.L$12 = SpillingKt.nullOutSpilledVariable(str5);
                                                        this.L$13 = SpillingKt.nullOutSpilledVariable(str4);
                                                        this.L$14 = objInvoke2;
                                                        this.I$0 = i4;
                                                        this.I$1 = i3;
                                                        this.I$2 = i2;
                                                        this.I$3 = i;
                                                        this.I$4 = 0;
                                                        this.label = 5;
                                                        if (flowCollector.emit(streamingStarted, this) != coroutine_suspended) {
                                                            i5 = i2;
                                                            i7 = i4;
                                                            sequence3 = sequence;
                                                            obj2 = next;
                                                            bufferedReader3 = bufferedReader6;
                                                            function12 = function1;
                                                            th3 = th2;
                                                            str2 = str5;
                                                            response3 = response2;
                                                            booleanRef2 = booleanRef;
                                                            i6 = i3;
                                                            it2 = it;
                                                            sequence4 = sequence2;
                                                            i8 = 0;
                                                            Iterator<String> it5 = it2;
                                                            i3 = i6;
                                                            i10 = i8;
                                                            obj3 = obj2;
                                                            sequence5 = sequence4;
                                                            it = it5;
                                                            response2 = response3;
                                                            function1 = function12;
                                                            reader = bufferedReader;
                                                            i9 = i7;
                                                            booleanRef3 = booleanRef2;
                                                            str5 = str2;
                                                            sequence6 = sequence3;
                                                            closeable = closeable2;
                                                            i11 = i5;
                                                            success = new AIClientResult.Success(objInvoke2);
                                                            this.L$0 = flowCollector;
                                                            this.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                                                            this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody2);
                                                            this.L$3 = booleanRef3;
                                                            this.L$4 = SpillingKt.nullOutSpilledVariable(reader);
                                                            this.L$5 = function1;
                                                            this.L$6 = closeable;
                                                            this.L$7 = SpillingKt.nullOutSpilledVariable(bufferedReader3);
                                                            this.L$8 = SpillingKt.nullOutSpilledVariable(sequence5);
                                                            this.L$9 = SpillingKt.nullOutSpilledVariable(sequence6);
                                                            this.L$10 = it;
                                                            this.L$11 = SpillingKt.nullOutSpilledVariable(obj3);
                                                            this.L$12 = SpillingKt.nullOutSpilledVariable(str5);
                                                            this.L$13 = SpillingKt.nullOutSpilledVariable(str4);
                                                            this.L$14 = SpillingKt.nullOutSpilledVariable(objInvoke2);
                                                            this.I$0 = i9;
                                                            this.I$1 = i3;
                                                            this.I$2 = i11;
                                                            this.I$3 = i;
                                                            this.I$4 = i10;
                                                            this.label = 6;
                                                            if (flowCollector.emit(success, this) != coroutine_suspended) {
                                                                booleanRef = booleanRef3;
                                                                i12 = i;
                                                                i13 = i3;
                                                                it3 = it;
                                                                th4 = th3;
                                                                bufferedReader4 = bufferedReader3;
                                                                responseBody3 = responseBody2;
                                                                function13 = function1;
                                                                response4 = response2;
                                                                BufferedReader bufferedReader7 = bufferedReader4;
                                                                i3 = i13;
                                                                bufferedReader2 = bufferedReader7;
                                                                it4 = it3;
                                                                sequence = sequence6;
                                                                i = i12;
                                                                th2 = th4;
                                                                sequence2 = sequence5;
                                                                responseBody = responseBody3;
                                                                i2 = i11;
                                                                closeable2 = closeable;
                                                                i4 = i9;
                                                                bufferedReader = reader;
                                                                response2 = response4;
                                                                function1 = function13;
                                                                it = it4;
                                                                str6 = str3;
                                                                if (!it.hasNext()) {
                                                                    Unit unit = Unit.INSTANCE;
                                                                    CloseableKt.closeFinally(closeable2, th2);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        str4 = strSubstringAfter;
                                                        int i14 = i4;
                                                        closeable = closeable2;
                                                        i11 = i2;
                                                        sequence5 = sequence2;
                                                        obj3 = next;
                                                        bufferedReader3 = bufferedReader6;
                                                        reader = bufferedReader;
                                                        i9 = i14;
                                                        Sequence<String> sequence7 = sequence;
                                                        th3 = th2;
                                                        sequence6 = sequence7;
                                                        booleanRef3 = booleanRef;
                                                        i10 = 0;
                                                        success = new AIClientResult.Success(objInvoke2);
                                                        this.L$0 = flowCollector;
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody2);
                                                        this.L$3 = booleanRef3;
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(reader);
                                                        this.L$5 = function1;
                                                        this.L$6 = closeable;
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable(bufferedReader3);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(sequence5);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(sequence6);
                                                        this.L$10 = it;
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable(obj3);
                                                        this.L$12 = SpillingKt.nullOutSpilledVariable(str5);
                                                        this.L$13 = SpillingKt.nullOutSpilledVariable(str4);
                                                        this.L$14 = SpillingKt.nullOutSpilledVariable(objInvoke2);
                                                        this.I$0 = i9;
                                                        this.I$1 = i3;
                                                        this.I$2 = i11;
                                                        this.I$3 = i;
                                                        this.I$4 = i10;
                                                        this.label = 6;
                                                        if (flowCollector.emit(success, this) != coroutine_suspended) {
                                                        }
                                                    }
                                                } else {
                                                    str3 = str6;
                                                    it4 = it;
                                                    responseBody = responseBody2;
                                                    bufferedReader2 = bufferedReader6;
                                                    function13 = function1;
                                                    response4 = response2;
                                                    response2 = response4;
                                                    function1 = function13;
                                                    it = it4;
                                                    str6 = str3;
                                                    if (!it.hasNext()) {
                                                    }
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            closeable = closeable2;
                                            try {
                                                throw th;
                                            } catch (Throwable th6) {
                                                CloseableKt.closeFinally(closeable, th);
                                                throw th6;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        objInvoke = obj;
                        response = (Response) objInvoke;
                        if (response.isSuccessful()) {
                        }
                        return coroutine_suspended;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 5:
                        int i15 = this.I$4;
                        int i16 = this.I$3;
                        i5 = this.I$2;
                        i6 = this.I$1;
                        i7 = this.I$0;
                        Object obj4 = this.L$14;
                        String str9 = (String) this.L$13;
                        str2 = (String) this.L$12;
                        obj2 = this.L$11;
                        it2 = (Iterator) this.L$10;
                        sequence3 = (Sequence) this.L$9;
                        sequence4 = (Sequence) this.L$8;
                        i8 = i15;
                        bufferedReader3 = (BufferedReader) this.L$7;
                        Closeable closeable3 = (Closeable) this.L$6;
                        function12 = (Function1) this.L$5;
                        Reader reader2 = (Reader) this.L$4;
                        booleanRef2 = (Ref.BooleanRef) this.L$3;
                        ResponseBody responseBody4 = (ResponseBody) this.L$2;
                        response3 = (Response) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str3 = "";
                            objInvoke2 = obj4;
                            bufferedReader = reader2;
                            i = i16;
                            closeable2 = closeable3;
                            responseBody2 = responseBody4;
                            str4 = str9;
                            th3 = null;
                            Iterator<String> it52 = it2;
                            i3 = i6;
                            i10 = i8;
                            obj3 = obj2;
                            sequence5 = sequence4;
                            it = it52;
                            response2 = response3;
                            function1 = function12;
                            reader = bufferedReader;
                            i9 = i7;
                            booleanRef3 = booleanRef2;
                            str5 = str2;
                            sequence6 = sequence3;
                            closeable = closeable2;
                            i11 = i5;
                            success = new AIClientResult.Success(objInvoke2);
                            this.L$0 = flowCollector;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(response2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(responseBody2);
                            this.L$3 = booleanRef3;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(reader);
                            this.L$5 = function1;
                            this.L$6 = closeable;
                            this.L$7 = SpillingKt.nullOutSpilledVariable(bufferedReader3);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(sequence5);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(sequence6);
                            this.L$10 = it;
                            this.L$11 = SpillingKt.nullOutSpilledVariable(obj3);
                            this.L$12 = SpillingKt.nullOutSpilledVariable(str5);
                            this.L$13 = SpillingKt.nullOutSpilledVariable(str4);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(objInvoke2);
                            this.I$0 = i9;
                            this.I$1 = i3;
                            this.I$2 = i11;
                            this.I$3 = i;
                            this.I$4 = i10;
                            this.label = 6;
                            if (flowCollector.emit(success, this) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th7) {
                            th = th7;
                            closeable = closeable3;
                            throw th;
                        }
                    case 6:
                        int i17 = this.I$3;
                        i11 = this.I$2;
                        i13 = this.I$1;
                        i9 = this.I$0;
                        it3 = (Iterator) this.L$10;
                        sequence6 = (Sequence) this.L$9;
                        sequence5 = (Sequence) this.L$8;
                        bufferedReader4 = (BufferedReader) this.L$7;
                        closeable = (Closeable) this.L$6;
                        function13 = (Function1) this.L$5;
                        Reader reader3 = (Reader) this.L$4;
                        booleanRef = (Ref.BooleanRef) this.L$3;
                        i12 = i17;
                        responseBody3 = (ResponseBody) this.L$2;
                        response4 = (Response) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        str3 = "";
                        reader = reader3;
                        th4 = null;
                        BufferedReader bufferedReader72 = bufferedReader4;
                        i3 = i13;
                        bufferedReader2 = bufferedReader72;
                        it4 = it3;
                        sequence = sequence6;
                        i = i12;
                        th2 = th4;
                        sequence2 = sequence5;
                        responseBody = responseBody3;
                        i2 = i11;
                        closeable2 = closeable;
                        i4 = i9;
                        bufferedReader = reader;
                        response2 = response4;
                        function1 = function13;
                        it = it4;
                        str6 = str3;
                        if (!it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    private final <T> Flow<AIClientResult<T>> performRequest(String endpoint, Function1<? super Continuation<? super Response<ResponseBody>>, ? extends Object> request, Function1<? super String, ? extends T> parseJson, Function1<? super Integer, ? extends AIClientError> mapError) {
        return FlowKt.onCompletion(FlowKt.m16058catch(FlowKt.flow(new C60961(request, endpoint, mapError, parseJson, null)), new C60972(endpoint, null)), new C60983(null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$performRequest$2 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "e", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$performRequest$2", m1609f = "NeboAIClient.kt", m1610i = {0, 0}, m1611l = {290}, m1612m = "invokeSuspend", m1613n = {"$this$catch", "e"}, m1614nl = {PDFACompliance.e_PDFA2_9_1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C60972<T> extends SuspendLambda implements Function3<FlowCollector<? super AIClientResult<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $endpoint;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60972(String str, Continuation<? super C60972> continuation) {
            super(3, continuation);
            this.$endpoint = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super AIClientResult<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C60972 c60972 = NeboAIClient.this.new C60972(this.$endpoint, continuation);
            c60972.L$0 = flowCollector;
            c60972.L$1 = th;
            return c60972.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NeboAIClient neboAIClient = NeboAIClient.this;
                String str = this.$endpoint;
                String message = th.getMessage();
                if (message == null) {
                    message = "unknown exception";
                }
                neboAIClient.logNonFatalError(str, message, th);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 1;
                if (flowCollector.emit(new AIClientResult.Error(AIClientError.ServerError.INSTANCE), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.myscript.nebo.ai.data.NeboAIClient$performRequest$3 */
    /* JADX INFO: compiled from: NeboAIClient.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, m1599d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/myscript/nebo/ai/data/AIClientResult;", "it", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ai.data.NeboAIClient$performRequest$3", m1609f = "NeboAIClient.kt", m1610i = {0}, m1611l = {292}, m1612m = "invokeSuspend", m1613n = {"$this$onCompletion"}, m1614nl = {293}, m1615s = {"L$0"}, m1616v = 2)
    static final class C60983<T> extends SuspendLambda implements Function3<FlowCollector<? super AIClientResult<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C60983(Continuation<? super C60983> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super AIClientResult<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C60983 c60983 = new C60983(continuation);
            c60983.L$0 = flowCollector;
            return c60983.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.label = 1;
                if (flowCollector.emit(AIClientResult.StreamingComplete.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final AIClientError mapQuizServerError(String message) {
        switch (message.hashCode()) {
            case 11446408:
                if (message.equals("Note is too short")) {
                    return AIClientError.ContextLimitError.INSTANCE;
                }
                break;
            case 389321640:
                if (message.equals("JSON schema is invalid")) {
                    return AIClientError.ServerError.INSTANCE;
                }
                break;
            case 831451376:
                if (message.equals("Note is too long")) {
                    return AIClientError.ContextLimitError.INSTANCE;
                }
                break;
            case 1934844921:
                if (message.equals("Note is unusable")) {
                    return AIClientError.UnknownError.INSTANCE;
                }
                break;
        }
        return AIClientError.UnknownError.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIClientError mapError(int statusCode) {
        if (statusCode == 429) {
            return AIClientError.QuotaError.INSTANCE;
        }
        if (statusCode == 450) {
            return AIClientError.ContextLimitError.INSTANCE;
        }
        if (299 <= statusCode && statusCode < 1000) {
            return AIClientError.ServerError.INSTANCE;
        }
        return AIClientError.UnknownError.INSTANCE;
    }

    static /* synthetic */ void logNonFatalError$default(NeboAIClient neboAIClient, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        neboAIClient.logNonFatalError(str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logNonFatalError(String endpoint, String message, Throwable cause) {
        TechnicalLogger technicalLogger;
        String str = "NeboAI " + endpoint + " error: " + message;
        if (cause != null && (technicalLogger = this.logger) != null) {
            technicalLogger.logTrace(str);
        }
        TechnicalLogger technicalLogger2 = this.logger;
        if (technicalLogger2 != null) {
            technicalLogger2.logError(new Exception(str, cause));
        }
    }
}
