package com.survicate.surveys.presentation.multiple;

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
import com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.base.micro.QuestionOptionsShuffler;
import com.survicate.surveys.presentation.multiple.micro.MicroSurveyPointMultipleContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

/* JADX INFO: compiled from: MultipleChoiceQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00106\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\rJ\u0010\u00109\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\u001aH\u0002J\u0016\u0010<\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\r2\u0006\u0010=\u001a\u000205J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u0002000/2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010?\u001a\u00020\u0015H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A0/H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\r02X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m1599d2 = {"Lcom/survicate/surveys/presentation/multiple/MultipleChoiceQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "bindingData", "Lcom/survicate/surveys/presentation/multiple/micro/MicroSurveyPointMultipleContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/multiple/micro/MicroSurveyPointMultipleContentView$BindingData;", "selectedAnswerIds", "", "getSelectedAnswerIds", "()Ljava/util/Set;", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "orderedAnswers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "selectedIds", "", "commentsByAnswerId", "", "", "restoreFromSavedState", "onAnswerToggled", "answerId", "toggleSingleSelectionAnswer", "toggleRegularAnswer", "deselectSingleSelectionAnswer", "onCommentChanged", ClientCookie.COMMENT_ATTR, "createOrderedAnswers", "computeValidationState", "getAnswer", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MultipleChoiceQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private final Map<Long, String> commentsByAnswerId;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final List<QuestionPointAnswer> orderedAnswers;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private final Set<Long> selectedIds;
    private final SurveyQuestionSurveyPoint surveyPoint;

    public MultipleChoiceQuestionViewModel(SurveyQuestionSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.MULTIPLE;
        this.orderedAnswers = createOrderedAnswers(bundle);
        this.selectedIds = new LinkedHashSet();
        this.commentsByAnswerId = new LinkedHashMap();
        restoreFromSavedState(bundle);
    }

    public /* synthetic */ MultipleChoiceQuestionViewModel(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final MicroSurveyPointMultipleContentView.BindingData getBindingData() {
        return new MicroSurveyPointMultipleContentView.BindingData(getSurveyPoint(), this.orderedAnswers, QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint());
    }

    public final Set<Long> getSelectedAnswerIds() {
        return CollectionsKt.toSet(this.selectedIds);
    }

    private final SurveyPointMultipleSettings getSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings");
        return (SurveyPointMultipleSettings) settings;
    }

    public final void onAnswerToggled(long answerId) {
        Object next;
        Iterator<T> it = this.orderedAnswers.iterator();
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
        if (questionPointAnswer != null ? Intrinsics.areEqual((Object) questionPointAnswer.getSingleSelection(), (Object) true) : false) {
            toggleSingleSelectionAnswer(answerId);
        } else {
            toggleRegularAnswer(answerId);
        }
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    private final void toggleSingleSelectionAnswer(long answerId) {
        if (this.selectedIds.contains(Long.valueOf(answerId))) {
            this.selectedIds.remove(Long.valueOf(answerId));
        } else {
            this.selectedIds.clear();
            this.selectedIds.add(Long.valueOf(answerId));
        }
    }

    private final void toggleRegularAnswer(long answerId) {
        if (this.selectedIds.contains(Long.valueOf(answerId))) {
            this.selectedIds.remove(Long.valueOf(answerId));
        } else {
            deselectSingleSelectionAnswer();
            this.selectedIds.add(Long.valueOf(answerId));
        }
    }

    private final void deselectSingleSelectionAnswer() {
        Object next;
        Iterator<T> it = this.orderedAnswers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) next;
            if (this.selectedIds.contains(Long.valueOf(questionPointAnswer.getId())) && Intrinsics.areEqual((Object) questionPointAnswer.getSingleSelection(), (Object) true)) {
                break;
            }
        }
        QuestionPointAnswer questionPointAnswer2 = (QuestionPointAnswer) next;
        if (questionPointAnswer2 != null) {
            this.selectedIds.remove(Long.valueOf(questionPointAnswer2.getId()));
        }
    }

    public final void onCommentChanged(long answerId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.commentsByAnswerId.put(Long.valueOf(answerId), comment);
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    private final QuestionValidationState computeValidationState() {
        boolean z;
        List<QuestionPointAnswer> answers = getSurveyPoint().getAnswers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : answers) {
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) obj;
            if (this.selectedIds.contains(Long.valueOf(questionPointAnswer.getId())) && Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            z = true;
        } else {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (this.commentsByAnswerId.get(Long.valueOf(((QuestionPointAnswer) it.next()).getId())) == null || !(!StringsKt.isBlank(r1))) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return QuestionValidationStateBuilder.INSTANCE.buildMultipleChoiceValidationState(getSettings(), true ^ this.selectedIds.isEmpty(), z);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (this.selectedIds.contains(Long.valueOf(((QuestionPointAnswer) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList<QuestionPointAnswer> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (QuestionPointAnswer questionPointAnswer : arrayList2) {
            boolean zAreEqual = Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true);
            String str = this.commentsByAnswerId.get(Long.valueOf(questionPointAnswer.getId()));
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (StringsKt.isBlank(str) || !zAreEqual) {
                str = null;
            }
            SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
            surveyAnswer.setQuestionAnswerId(Long.valueOf(questionPointAnswer.getId()));
            String possibleAnswer = questionPointAnswer.getPossibleAnswer();
            if (possibleAnswer != null) {
                str2 = possibleAnswer;
            }
            surveyAnswer.setAnswer(str2);
            surveyAnswer.setComment(str);
            arrayList3.add(surveyAnswer);
        }
        return arrayList3;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        List<QuestionPointAnswer> answers = getSurveyPoint().getAnswers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(answers, 10)), 16));
        for (QuestionPointAnswer questionPointAnswer : answers) {
            Long lValueOf = Long.valueOf(questionPointAnswer.getId());
            boolean zContains = this.selectedIds.contains(Long.valueOf(questionPointAnswer.getId()));
            String str = this.commentsByAnswerId.get(Long.valueOf(questionPointAnswer.getId()));
            if (str == null) {
                str = "";
            }
            Pair pairM1606to = TuplesKt.m1606to(lValueOf, new MicroSurveyPointMultipleContentView.AnswerItemState(zContains, str));
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((QuestionPointAnswer) it.next()).getId()));
        }
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointMultipleContentView.SavedState(linkedHashMap, arrayList)));
    }

    private final void restoreFromSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointMultipleContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointMultipleContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointMultipleContentView.SavedState) parcelable2;
            }
            MicroSurveyPointMultipleContentView.SavedState savedState2 = (MicroSurveyPointMultipleContentView.SavedState) parcelable;
            if (savedState2 == null) {
                return;
            }
            for (Map.Entry<Long, MicroSurveyPointMultipleContentView.AnswerItemState> entry : savedState2.getAnswerItemStates().entrySet()) {
                long jLongValue = entry.getKey().longValue();
                MicroSurveyPointMultipleContentView.AnswerItemState value = entry.getValue();
                if (value.isSelected()) {
                    this.selectedIds.add(Long.valueOf(jLongValue));
                }
                if (value.getComment().length() > 0) {
                    this.commentsByAnswerId.put(Long.valueOf(jLongValue), value.getComment());
                }
            }
        }
    }

    private final List<QuestionPointAnswer> createOrderedAnswers(Bundle savedState) {
        Parcelable parcelable;
        List<Long> answerOrder = null;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointMultipleContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointMultipleContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointMultipleContentView.SavedState) parcelable2;
            }
            MicroSurveyPointMultipleContentView.SavedState savedState2 = (MicroSurveyPointMultipleContentView.SavedState) parcelable;
            if (savedState2 != null) {
                answerOrder = savedState2.getAnswerOrder();
            }
        }
        return QuestionOptionsShuffler.shuffleListIfNecessary$default(QuestionOptionsShuffler.INSTANCE, getSurveyPoint(), answerOrder, null, 4, null);
    }
}
