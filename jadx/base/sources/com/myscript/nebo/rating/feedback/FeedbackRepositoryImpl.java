package com.myscript.nebo.rating.feedback;

import com.myscript.nebo.rating.feedback.FeedbackResult;
import com.myscript.nebo.rating.feedback.entity.FreshdeskTicket;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.encoding.Base64;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.ResponseBody;
import retrofit2.KotlinExtensions;
import retrofit2.Response;

/* JADX INFO: compiled from: FeedbackRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FeedbackRepositoryImpl;", "Lcom/myscript/nebo/rating/feedback/FeedbackRepository;", "freshDeskApi", "Lcom/myscript/nebo/rating/feedback/FreshDeskApi;", "<init>", "(Lcom/myscript/nebo/rating/feedback/FreshDeskApi;)V", "sendFeedback", "Lcom/myscript/nebo/rating/feedback/FeedbackResult;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FeedbackRepositoryImpl implements FeedbackRepository {
    private static final String ANDROID_TAG = "0-Android";
    private static final String DEFAULT_SUBJECT = "Pre-rating-filter";
    private static final int FEEDBACK_PRIORITY = 1;
    private static final int FEEDBACK_STATUS = 5;
    private static final String FEEDBACK_TAG = "0-Pre-Rating";
    private static final String FRESHDESK_API_KEY = "WvYcohPtp9Bm2Ozk6Pdz";
    private static final String SUPPORT_EMAIL = "feedback-in-app@myscript.com";
    private final FreshDeskApi freshDeskApi;
    public static final int $stable = 8;

    public FeedbackRepositoryImpl(FreshDeskApi freshDeskApi) {
        Intrinsics.checkNotNullParameter(freshDeskApi, "freshDeskApi");
        this.freshDeskApi = freshDeskApi;
    }

    @Override // com.myscript.nebo.rating.feedback.FeedbackRepository
    public Object sendFeedback(String str, Continuation<? super FeedbackResult> continuation) {
        Base64.Companion companion = Base64.INSTANCE;
        byte[] bytes = FRESHDESK_API_KEY.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return BuildersKt.withContext(Dispatchers.getIO(), new C67492(Base64.encode$default(companion, bytes, 0, 0, 6, null), new FreshdeskTicket(DEFAULT_SUBJECT, str, 5, 1, SUPPORT_EMAIL, CollectionsKt.listOf((Object[]) new String[]{FEEDBACK_TAG, ANDROID_TAG, "0-" + Locale.getDefault().getCountry()})), null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.feedback.FeedbackRepositoryImpl$sendFeedback$2 */
    /* JADX INFO: compiled from: FeedbackRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/rating/feedback/FeedbackResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.feedback.FeedbackRepositoryImpl$sendFeedback$2", m1609f = "FeedbackRepository.kt", m1610i = {}, m1611l = {41}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {42}, m1615s = {}, m1616v = 2)
    static final class C67492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FeedbackResult>, Object> {
        final /* synthetic */ String $authString;
        final /* synthetic */ FreshdeskTicket $freshdeskTicket;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67492(String str, FreshdeskTicket freshdeskTicket, Continuation<? super C67492> continuation) {
            super(2, continuation);
            this.$authString = str;
            this.$freshdeskTicket = freshdeskTicket;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedbackRepositoryImpl.this.new C67492(this.$authString, this.$freshdeskTicket, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FeedbackResult> continuation) {
            return ((C67492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = KotlinExtensions.awaitResponse(FeedbackRepositoryImpl.this.freshDeskApi.sendFeedback(this.$authString, this.$freshdeskTicket), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    return FeedbackResult.Success.INSTANCE;
                }
                ResponseBody responseBodyErrorBody = response.errorBody();
                String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                if (strString == null) {
                    strString = response.message();
                }
                return new FeedbackResult.Error("Failed to send feedback: " + strString);
            } catch (Exception e) {
                return new FeedbackResult.Error("Failed to send feedback: " + e.getMessage());
            }
        }
    }
}
