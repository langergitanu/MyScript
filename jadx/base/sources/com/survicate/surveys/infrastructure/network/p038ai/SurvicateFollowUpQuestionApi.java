package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.SurvicateHttpClient;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FollowUpQuestionApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/SurvicateFollowUpQuestionApi;", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionApi;", "requestFactory", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestFactory;", "deserializer", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;", "httpClient", "Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestFactory;Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;Lkotlinx/coroutines/CoroutineDispatcher;)V", "requestFollowUpQuestion", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionResponse;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "(Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateFollowUpQuestionApi implements FollowUpQuestionApi {
    private final FollowUpQuestionSerializer deserializer;
    private final CoroutineDispatcher dispatcher;
    private final SurvicateHttpClient httpClient;
    private final FollowUpQuestionRequestFactory requestFactory;

    public SurvicateFollowUpQuestionApi(FollowUpQuestionRequestFactory requestFactory, FollowUpQuestionSerializer deserializer, SurvicateHttpClient httpClient, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.requestFactory = requestFactory;
        this.deserializer = deserializer;
        this.httpClient = httpClient;
        this.dispatcher = dispatcher;
    }

    public /* synthetic */ SurvicateFollowUpQuestionApi(FollowUpQuestionRequestFactory followUpQuestionRequestFactory, FollowUpQuestionSerializer followUpQuestionSerializer, SurvicateHttpClient survicateHttpClient, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(followUpQuestionRequestFactory, followUpQuestionSerializer, survicateHttpClient, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.network.ai.SurvicateFollowUpQuestionApi$requestFollowUpQuestion$2 */
    /* JADX INFO: compiled from: FollowUpQuestionApi.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.network.ai.SurvicateFollowUpQuestionApi$requestFollowUpQuestion$2", m1609f = "FollowUpQuestionApi.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FollowUpQuestionResponse>, Object> {
        final /* synthetic */ FollowUpQuestionRequestBody $body;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84112(FollowUpQuestionRequestBody followUpQuestionRequestBody, Continuation<? super C84112> continuation) {
            super(2, continuation);
            this.$body = followUpQuestionRequestBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SurvicateFollowUpQuestionApi.this.new C84112(this.$body, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FollowUpQuestionResponse> continuation) {
            return ((C84112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String strLoadUrlResponse = SurvicateFollowUpQuestionApi.this.httpClient.loadUrlResponse(SurvicateFollowUpQuestionApi.this.requestFactory.createFollowUpQuestionRequest(this.$body));
                if (strLoadUrlResponse != null) {
                    return SurvicateFollowUpQuestionApi.this.deserializer.deserializeFollowUpQuestionResponse(strLoadUrlResponse);
                }
                throw new IOException("Failed to fetch follow up question: empty API response");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionApi
    public Object requestFollowUpQuestion(FollowUpQuestionRequestBody followUpQuestionRequestBody, Continuation<? super FollowUpQuestionResponse> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C84112(followUpQuestionRequestBody, null), continuation);
    }
}
