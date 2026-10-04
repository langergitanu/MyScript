package com.survicate.surveys.presentation.single;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.base.micro.QuestionOptionsShuffler;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: SingleChoiceQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00107\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\rJ\u0016\u0010:\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\r2\u0006\u0010;\u001a\u000205J\u0018\u0010<\u001a\b\u0012\u0004\u0012\u0002000/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010=\u001a\u00020\u0015H\u0002J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020?0/H\u0016J\b\u0010@\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/SingleChoiceQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "bindingData", "Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$BindingData;", "canSubmitImmediately", "", "getCanSubmitImmediately", "()Z", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "orderedAnswers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "selectedAnswerId", "Ljava/lang/Long;", "commentsByAnswerId", "", "", "wasAnswerWithCommentSelectedFirst", "restoreFromSavedState", "onAnswerSelected", "answerId", "onCommentChanged", ClientCookie.COMMENT_ATTR, "createOrderedAnswers", "computeValidationState", "getAnswer", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SingleChoiceQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private final Map<Long, String> commentsByAnswerId;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final List<QuestionPointAnswer> orderedAnswers;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private Long selectedAnswerId;
    private final SurveyQuestionSurveyPoint surveyPoint;
    private boolean wasAnswerWithCommentSelectedFirst;

    public SingleChoiceQuestionViewModel(SurveyQuestionSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.SINGLE;
        this.orderedAnswers = createOrderedAnswers(bundle);
        this.commentsByAnswerId = new LinkedHashMap();
        restoreFromSavedState(bundle);
    }

    public /* synthetic */ SingleChoiceQuestionViewModel(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyQuestionSurveyPoint, resolvedQuestionTexts, (i & 4) != 0 ? null : bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyQuestionSurveyPoint getSurveyPoint() {
        return this.surveyPoint;
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

    public final MicroSurveyPointSingleContentView.BindingData getBindingData() {
        return new MicroSurveyPointSingleContentView.BindingData(getSurveyPoint(), this.orderedAnswers, QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint());
    }

    private final boolean getCanSubmitImmediately() {
        return !this.wasAnswerWithCommentSelectedFirst;
    }

    private final SurveyPointSingleSettings getSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings");
        return (SurveyPointSingleSettings) settings;
    }

    public final void onAnswerSelected(long answerId) {
        Object next;
        Function0<Unit> onAutoSubmitRequested;
        this.selectedAnswerId = Long.valueOf(answerId);
        Iterator<T> it = getSurveyPoint().getAnswers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((QuestionPointAnswer) next).getId() == answerId) {
                    break;
                }
            }
        }
        QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) next;
        boolean z = true;
        boolean zAreEqual = questionPointAnswer != null ? Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true) : false;
        if (!this.wasAnswerWithCommentSelectedFirst && !zAreEqual) {
            z = false;
        }
        this.wasAnswerWithCommentSelectedFirst = z;
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
        if (!getCanSubmitImmediately() || (onAutoSubmitRequested = getOnAutoSubmitRequested()) == null) {
            return;
        }
        onAutoSubmitRequested.invoke();
    }

    public final void onCommentChanged(long answerId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.commentsByAnswerId.put(Long.valueOf(answerId), comment);
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final QuestionValidationState computeValidationState() {
        boolean z;
        Object next;
        Long l = this.selectedAnswerId;
        if (l != null) {
            Iterator<T> it = getSurveyPoint().getAnswers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (l != null && ((QuestionPointAnswer) next).getId() == l.longValue()) {
                    break;
                }
            }
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) next;
            z = questionPointAnswer != null ? Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true) : false;
        }
        QuestionValidationStateBuilder questionValidationStateBuilder = QuestionValidationStateBuilder.INSTANCE;
        SurveyPointSingleSettings settings = getSettings();
        boolean z2 = l != null;
        String str = this.commentsByAnswerId.get(l);
        if (str == null) {
            str = "";
        }
        return questionValidationStateBuilder.buildSingleChoiceValidationState(settings, z2, z, str, this.wasAnswerWithCommentSelectedFirst);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        String str;
        Object next;
        Long l = this.selectedAnswerId;
        if (l == null) {
            return CollectionsKt.emptyList();
        }
        long jLongValue = l.longValue();
        Iterator<T> it = getSurveyPoint().getAnswers().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((QuestionPointAnswer) next).getId() == jLongValue) {
                break;
            }
        }
        QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) next;
        if (questionPointAnswer == null) {
            return CollectionsKt.emptyList();
        }
        boolean zAreEqual = Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true);
        String str2 = this.commentsByAnswerId.get(Long.valueOf(jLongValue));
        if (str2 == null) {
            str2 = "";
        }
        if (!StringsKt.isBlank(str2) && zAreEqual) {
            str = str2;
        }
        SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
        surveyAnswer.setQuestionAnswerId(Long.valueOf(jLongValue));
        String possibleAnswer = questionPointAnswer.getPossibleAnswer();
        surveyAnswer.setAnswer(possibleAnswer != null ? possibleAnswer : "");
        surveyAnswer.setComment(str);
        return CollectionsKt.listOf(surveyAnswer);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        List<QuestionPointAnswer> answers = getSurveyPoint().getAnswers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(answers, 10)), 16));
        Iterator<T> it = answers.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) it.next();
            Long lValueOf = Long.valueOf(questionPointAnswer.getId());
            long id = questionPointAnswer.getId();
            Long l = this.selectedAnswerId;
            if (l != null && id == l.longValue()) {
                z = true;
            }
            String str = this.commentsByAnswerId.get(Long.valueOf(questionPointAnswer.getId()));
            if (str == null) {
                str = "";
            }
            Pair pairM1606to = TuplesKt.m1606to(lValueOf, new MicroSurveyPointSingleContentView.AnswerItemState(z, str));
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        boolean z2 = this.wasAnswerWithCommentSelectedFirst;
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Long.valueOf(((QuestionPointAnswer) it2.next()).getId()));
        }
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointSingleContentView.SavedState(linkedHashMap, z2, arrayList)));
    }

    private final void restoreFromSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointSingleContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointSingleContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointSingleContentView.SavedState) parcelable2;
            }
            MicroSurveyPointSingleContentView.SavedState savedState2 = (MicroSurveyPointSingleContentView.SavedState) parcelable;
            if (savedState2 == null) {
                return;
            }
            for (Map.Entry<Long, MicroSurveyPointSingleContentView.AnswerItemState> entry : savedState2.getAnswerItemStates().entrySet()) {
                long jLongValue = entry.getKey().longValue();
                MicroSurveyPointSingleContentView.AnswerItemState value = entry.getValue();
                if (value.isSelected()) {
                    this.selectedAnswerId = Long.valueOf(jLongValue);
                }
                if (value.getComment().length() > 0) {
                    this.commentsByAnswerId.put(Long.valueOf(jLongValue), value.getComment());
                }
            }
            this.wasAnswerWithCommentSelectedFirst = savedState2.getWasAnswerWithCommentSelectedFirst();
        }
    }

    private final List<QuestionPointAnswer> createOrderedAnswers(Bundle savedState) {
        Parcelable parcelable;
        List<Long> answerOrder = null;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointSingleContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointSingleContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointSingleContentView.SavedState) parcelable2;
            }
            MicroSurveyPointSingleContentView.SavedState savedState2 = (MicroSurveyPointSingleContentView.SavedState) parcelable;
            if (savedState2 != null) {
                answerOrder = savedState2.getAnswerOrder();
            }
        }
        return QuestionOptionsShuffler.shuffleListIfNecessary$default(QuestionOptionsShuffler.INSTANCE, getSurveyPoint(), answerOrder, null, 4, null);
    }
}
