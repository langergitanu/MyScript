package com.survicate.surveys.infrastructure.network.p038ai;

import com.myscript.nebo.LaunchActivity;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.environment.WorkspaceKeyProvider;
import com.survicate.surveys.infrastructure.network.HttpException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: FollowUpQuestionRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/SurvicateFollowUpQuestionRepository;", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "followUpQuestionApi", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionApi;", "workspaceKeyProvider", "Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionApi;Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "requestFollowUpQuestion", "", "dialogs", "", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpDialog;", LaunchActivity.LaunchRoute.Language, "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logFollowUpSendingError", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateFollowUpQuestionRepository implements FollowUpQuestionRepository {
    private final FollowUpQuestionApi followUpQuestionApi;
    private final SdkLogger logger;
    private final WorkspaceKeyProvider workspaceKeyProvider;

    /* JADX INFO: renamed from: com.survicate.surveys.infrastructure.network.ai.SurvicateFollowUpQuestionRepository$requestFollowUpQuestion$1 */
    /* JADX INFO: compiled from: FollowUpQuestionRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.infrastructure.network.ai.SurvicateFollowUpQuestionRepository", m1609f = "FollowUpQuestionRepository.kt", m1610i = {}, m1611l = {26}, m1612m = "requestFollowUpQuestion", m1613n = {}, m1615s = {})
    static final class C84121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84121(Continuation<? super C84121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SurvicateFollowUpQuestionRepository.this.requestFollowUpQuestion(null, null, this);
        }
    }

    public SurvicateFollowUpQuestionRepository(FollowUpQuestionApi followUpQuestionApi, WorkspaceKeyProvider workspaceKeyProvider, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(followUpQuestionApi, "followUpQuestionApi");
        Intrinsics.checkNotNullParameter(workspaceKeyProvider, "workspaceKeyProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.followUpQuestionApi = followUpQuestionApi;
        this.workspaceKeyProvider = workspaceKeyProvider;
        this.logger = logger;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object requestFollowUpQuestion(List<FollowUpDialog> list, String str, Continuation<? super String> continuation) {
        C84121 c84121;
        if (continuation instanceof C84121) {
            c84121 = (C84121) continuation;
            if ((c84121.label & Integer.MIN_VALUE) != 0) {
                c84121.label -= Integer.MIN_VALUE;
            } else {
                c84121 = new C84121(continuation);
            }
        }
        Object objRequestFollowUpQuestion = c84121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84121.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRequestFollowUpQuestion);
                FollowUpQuestionRequestBody followUpQuestionRequestBody = new FollowUpQuestionRequestBody(list, str, this.workspaceKeyProvider.getWorkspaceKey());
                FollowUpQuestionApi followUpQuestionApi = this.followUpQuestionApi;
                c84121.label = 1;
                objRequestFollowUpQuestion = followUpQuestionApi.requestFollowUpQuestion(followUpQuestionRequestBody, c84121);
                if (objRequestFollowUpQuestion == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objRequestFollowUpQuestion);
            }
            return ((FollowUpQuestionResponse) objRequestFollowUpQuestion).getData().getQuestion();
        } catch (HttpException e) {
            JobKt.ensureActive(c84121.getContext());
            logFollowUpSendingError(e);
            return null;
        } catch (Exception e2) {
            JobKt.ensureActive(c84121.getContext());
            logFollowUpSendingError(e2);
            return null;
        }
    }

    private final void logFollowUpSendingError(Exception exception) {
        this.logger.error(LogTags.RESPONDENT, "Error sending follow-up question", exception);
    }
}
