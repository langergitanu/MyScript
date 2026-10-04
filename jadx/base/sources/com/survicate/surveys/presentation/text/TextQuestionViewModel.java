package com.survicate.surveys.presentation.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.network.SurveyAnswerFollowUp;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpDialog;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRepository;
import com.survicate.surveys.presentation.page.DisposableQuestion;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.page.SubmitInterceptingQuestion;
import com.survicate.surveys.presentation.text.FollowUpResult;
import com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: TextQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010G\u001a\u00020%2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000bJ\b\u0010K\u001a\u00020DH\u0016J\b\u0010L\u001a\u00020DH\u0002J\u000e\u0010M\u001a\u00020NH\u0082@¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0<H\u0002J\u0010\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u000bH\u0002J\b\u0010T\u001a\u00020 H\u0002J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020V0<H\u0016J\u0010\u0010W\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010<H\u0002J\b\u0010Y\u001a\u00020\u0011H\u0016J\b\u0010Z\u001a\u00020%H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u00100\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006["}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/TextQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "Lcom/survicate/surveys/presentation/page/DisposableQuestion;", "Lcom/survicate/surveys/presentation/page/SubmitInterceptingQuestion;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "followUpQuestionRepository", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "surveyLanguage", "", "followUpLimit", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "Ljava/lang/Integer;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "onSubmitRequested", "getOnSubmitRequested", "setOnSubmitRequested", "onFollowUpStateChanged", "getOnFollowUpStateChanged", "setOnFollowUpStateChanged", "bindingData", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$BindingData;", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "answerItemStates", "", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$AnswerItemState;", "followUpEditsRemaining", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "followUpJob", "Lkotlinx/coroutines/Job;", "value", "", "isRequestingFollowUp", "()Z", "restoreFromSavedState", "onAnswerChanged", FirebaseAnalytics.Param.INDEX, "text", "interceptSubmit", "isFollowUpAvailable", "requestFollowUp", "Lcom/survicate/surveys/presentation/text/FollowUpResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildDialogs", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpDialog;", "appendFollowUp", "question", "computeValidationState", "getAnswer", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "buildFollowUpAnswers", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswerFollowUp;", "toSavedState", "dispose", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextQuestionViewModel implements QuestionViewModel, DisposableQuestion, SubmitInterceptingQuestion {
    private List<MicroSurveyPointTextContentView.AnswerItemState> answerItemStates;
    private final SurveyAnswerType answerType;
    private final CoroutineScope coroutineScope;
    private Integer followUpEditsRemaining;
    private Job followUpJob;
    private final Integer followUpLimit;
    private final FollowUpQuestionRepository followUpQuestionRepository;
    private boolean isRequestingFollowUp;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onFollowUpStateChanged;
    private Function0<Unit> onSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private final String surveyLanguage;
    private final SurveyQuestionSurveyPoint surveyPoint;

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.text.TextQuestionViewModel$requestFollowUp$1 */
    /* JADX INFO: compiled from: TextQuestionViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.text.TextQuestionViewModel", m1609f = "TextQuestionViewModel.kt", m1610i = {}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m1612m = "requestFollowUp", m1613n = {}, m1615s = {})
    static final class C84691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84691(Continuation<? super C84691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextQuestionViewModel.this.requestFollowUp(this);
        }
    }

    public TextQuestionViewModel(SurveyQuestionSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, FollowUpQuestionRepository followUpQuestionRepository, String str, Integer num, CoroutineDispatcher mainDispatcher, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        Intrinsics.checkNotNullParameter(followUpQuestionRepository, "followUpQuestionRepository");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.followUpQuestionRepository = followUpQuestionRepository;
        this.surveyLanguage = str;
        this.followUpLimit = num;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.TEXT;
        this.answerItemStates = CollectionsKt.listOf(new MicroSurveyPointTextContentView.AnswerItemState("", null));
        this.followUpEditsRemaining = num;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        restoreFromSavedState(bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyQuestionSurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    public /* synthetic */ TextQuestionViewModel(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, FollowUpQuestionRepository followUpQuestionRepository, String str, Integer num, MainCoroutineDispatcher mainCoroutineDispatcher, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyQuestionSurveyPoint, resolvedQuestionTexts, followUpQuestionRepository, str, num, (i & 32) != 0 ? Dispatchers.getMain().getImmediate() : mainCoroutineDispatcher, (i & 64) != 0 ? null : bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public long getPointId() {
        return this.pointId;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyAnswerType getAnswerType() {
        return this.answerType;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public QuestionValidationState getValidationState() {
        return computeValidationState();
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Function0<Unit> getOnValidationChanged() {
        return this.onValidationChanged;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public void setOnValidationChanged(Function0<Unit> function0) {
        this.onValidationChanged = function0;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Function0<Unit> getOnAutoSubmitRequested() {
        return this.onAutoSubmitRequested;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public void setOnAutoSubmitRequested(Function0<Unit> function0) {
        this.onAutoSubmitRequested = function0;
    }

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public Function0<Unit> getOnSubmitRequested() {
        return this.onSubmitRequested;
    }

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public void setOnSubmitRequested(Function0<Unit> function0) {
        this.onSubmitRequested = function0;
    }

    public final Function0<Unit> getOnFollowUpStateChanged() {
        return this.onFollowUpStateChanged;
    }

    public final void setOnFollowUpStateChanged(Function0<Unit> function0) {
        this.onFollowUpStateChanged = function0;
    }

    public final MicroSurveyPointTextContentView.BindingData getBindingData() {
        return new MicroSurveyPointTextContentView.BindingData(getSurveyPoint(), QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint(), this.followUpLimit, null, 16, null);
    }

    private final SurveyPointTextSettings getSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings");
        return (SurveyPointTextSettings) settings;
    }

    /* JADX INFO: renamed from: isRequestingFollowUp, reason: from getter */
    public final boolean getIsRequestingFollowUp() {
        return this.isRequestingFollowUp;
    }

    public final void onAnswerChanged(int index, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (index < 0 || index >= this.answerItemStates.size()) {
            return;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) this.answerItemStates);
        mutableList.set(index, MicroSurveyPointTextContentView.AnswerItemState.copy$default((MicroSurveyPointTextContentView.AnswerItemState) mutableList.get(index), text, null, 2, null));
        this.answerItemStates = CollectionsKt.take(mutableList, index + 1);
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public boolean interceptSubmit() {
        Job job = this.followUpJob;
        if (job != null && job.isActive()) {
            return true;
        }
        if (!isFollowUpAvailable()) {
            return false;
        }
        this.followUpJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84681(null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.text.TextQuestionViewModel$interceptSubmit$1 */
    /* JADX INFO: compiled from: TextQuestionViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.text.TextQuestionViewModel$interceptSubmit$1", m1609f = "TextQuestionViewModel.kt", m1610i = {}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84681(Continuation<? super C84681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextQuestionViewModel.this.new C84681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function0<Unit> onSubmitRequested;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TextQuestionViewModel.this.requestFollowUp(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if ((((FollowUpResult) obj) instanceof FollowUpResult.Error) && (onSubmitRequested = TextQuestionViewModel.this.getOnSubmitRequested()) != null) {
                onSubmitRequested.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean isFollowUpAvailable() {
        TextFollowUpRules textFollowUpRules = TextFollowUpRules.INSTANCE;
        Integer num = this.followUpLimit;
        Integer followUpQuestionCount = getSettings().getFollowUpQuestionCount();
        int size = this.answerItemStates.size();
        List<MicroSurveyPointTextContentView.AnswerItemState> list = this.answerItemStates;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.isBlank(((MicroSurveyPointTextContentView.AnswerItemState) it.next()).getInput())) {
                    z = false;
                    break;
                }
            }
        }
        return textFollowUpRules.isFollowUpAvailable(num, followUpQuestionCount, size, z, this.followUpEditsRemaining);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestFollowUp(Continuation<? super FollowUpResult> continuation) {
        C84691 c84691;
        if (continuation instanceof C84691) {
            c84691 = (C84691) continuation;
            if ((c84691.label & Integer.MIN_VALUE) != 0) {
                c84691.label -= Integer.MIN_VALUE;
            } else {
                c84691 = new C84691(continuation);
            }
        }
        Object objRequestFollowUpQuestion = c84691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84691.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRequestFollowUpQuestion);
            this.isRequestingFollowUp = true;
            Function0<Unit> function0 = this.onFollowUpStateChanged;
            if (function0 != null) {
                function0.invoke();
            }
            FollowUpQuestionRepository followUpQuestionRepository = this.followUpQuestionRepository;
            List<FollowUpDialog> listBuildDialogs = buildDialogs();
            String str = this.surveyLanguage;
            c84691.label = 1;
            objRequestFollowUpQuestion = followUpQuestionRepository.requestFollowUpQuestion(listBuildDialogs, str, c84691);
            if (objRequestFollowUpQuestion == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRequestFollowUpQuestion);
        }
        String str2 = (String) objRequestFollowUpQuestion;
        this.isRequestingFollowUp = false;
        String str3 = str2;
        if (str3 == null || StringsKt.isBlank(str3)) {
            Function0<Unit> function02 = this.onFollowUpStateChanged;
            if (function02 != null) {
                function02.invoke();
            }
            return FollowUpResult.Error.INSTANCE;
        }
        appendFollowUp(str2);
        Function0<Unit> function03 = this.onFollowUpStateChanged;
        if (function03 != null) {
            function03.invoke();
        }
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
        return FollowUpResult.Success.INSTANCE;
    }

    private final List<FollowUpDialog> buildDialogs() {
        String followUpQuestion;
        List<MicroSurveyPointTextContentView.AnswerItemState> list = this.answerItemStates;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MicroSurveyPointTextContentView.AnswerItemState answerItemState = (MicroSurveyPointTextContentView.AnswerItemState) obj;
            if (i == 0) {
                followUpQuestion = this.resolvedTexts.getTitle();
            } else {
                followUpQuestion = answerItemState.getFollowUpQuestion();
                if (followUpQuestion == null) {
                    followUpQuestion = "";
                }
            }
            arrayList.add(new FollowUpDialog(followUpQuestion, answerItemState.getInput()));
            i = i2;
        }
        return arrayList;
    }

    private final void appendFollowUp(String question) {
        this.answerItemStates = CollectionsKt.plus((Collection<? extends MicroSurveyPointTextContentView.AnswerItemState>) this.answerItemStates, new MicroSurveyPointTextContentView.AnswerItemState("", question));
        this.followUpEditsRemaining = this.followUpEditsRemaining != null ? Integer.valueOf(r4.intValue() - 1) : null;
    }

    private final QuestionValidationState computeValidationState() {
        QuestionValidationStateBuilder questionValidationStateBuilder = QuestionValidationStateBuilder.INSTANCE;
        SurveyPointTextSettings settings = getSettings();
        List<MicroSurveyPointTextContentView.AnswerItemState> list = this.answerItemStates;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.isBlank(((MicroSurveyPointTextContentView.AnswerItemState) it.next()).getInput())) {
                    z = false;
                    break;
                }
            }
        }
        return questionValidationStateBuilder.buildTextValidationState(settings, z);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        MicroSurveyPointTextContentView.AnswerItemState answerItemState = (MicroSurveyPointTextContentView.AnswerItemState) CollectionsKt.firstOrNull((List) this.answerItemStates);
        if (answerItemState == null) {
            return CollectionsKt.emptyList();
        }
        if (StringsKt.isBlank(answerItemState.getInput())) {
            return CollectionsKt.emptyList();
        }
        SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
        surveyAnswer.setContent(answerItemState.getInput());
        surveyAnswer.setAnswer(answerItemState.getInput());
        surveyAnswer.setFollowUp(buildFollowUpAnswers());
        return CollectionsKt.listOf(surveyAnswer);
    }

    private final List<SurveyAnswerFollowUp> buildFollowUpAnswers() {
        if (!TextFollowUpRules.INSTANCE.isFollowUpEnabled(this.followUpLimit, getSettings().getFollowUpQuestionCount())) {
            return null;
        }
        List<MicroSurveyPointTextContentView.AnswerItemState> listDrop = CollectionsKt.drop(this.answerItemStates, 1);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop, 10));
        for (MicroSurveyPointTextContentView.AnswerItemState answerItemState : listDrop) {
            String followUpQuestion = answerItemState.getFollowUpQuestion();
            if (followUpQuestion == null) {
                followUpQuestion = "";
            }
            arrayList.add(new SurveyAnswerFollowUp(followUpQuestion, answerItemState.getInput()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((SurveyAnswerFollowUp) obj).getAnswer() != null && (!StringsKt.isBlank(r5))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return null;
        }
        return arrayList3;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointTextContentView.SavedState(this.answerItemStates, this.followUpEditsRemaining)));
    }

    @Override // com.survicate.surveys.presentation.page.DisposableQuestion
    public void dispose() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
    }

    private final void restoreFromSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointTextContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointTextContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointTextContentView.SavedState) parcelable2;
            }
            MicroSurveyPointTextContentView.SavedState savedState2 = (MicroSurveyPointTextContentView.SavedState) parcelable;
            if (savedState2 == null) {
                return;
            }
            this.answerItemStates = savedState2.getAnswerItemStates();
            this.followUpEditsRemaining = savedState2.getFollowUpEditsRemaining();
        }
    }
}
