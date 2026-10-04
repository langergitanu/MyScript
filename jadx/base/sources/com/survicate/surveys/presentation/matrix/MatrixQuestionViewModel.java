package com.survicate.surveys.presentation.matrix;

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
import com.survicate.surveys.entities.survey.questions.question.matrix.MatrixColumn;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.base.micro.QuestionOptionsShuffler;
import com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: MatrixQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u00101\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0.2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\rJ\u001e\u00105\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\r2\u0006\u00106\u001a\u000207J\u0016\u00108\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\r2\u0006\u00109\u001a\u00020:J$\u0010;\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\r2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0=H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020:H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u00103\u001a\u00020\rH\u0002J\u0012\u0010B\u001a\u0004\u0018\u0001072\u0006\u00103\u001a\u00020\rH\u0002J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020D0+H\u0016J\b\u0010E\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/MatrixQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "bindingData", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$BindingData;", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "orderedAnswers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "rowStateByAnswerId", "", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$AnswerItemState;", "createOrderedAnswers", "createInitialRowStates", "onColumnSelected", "answerId", "columnId", "onCommentChanged", ClientCookie.COMMENT_ATTR, "", "onExpandedChanged", "isExpanded", "", "updateRowState", "transform", "Lkotlin/Function1;", "computeValidationState", "areAllAnswersProvided", "selectedColumnFor", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/MatrixColumn;", "commentForSelectedColumn", "getAnswer", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MatrixQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final List<QuestionPointAnswer> orderedAnswers;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private final Map<Long, MicroSurveyPointMatrixContentView.AnswerItemState> rowStateByAnswerId;
    private final SurveyQuestionSurveyPoint surveyPoint;

    public MatrixQuestionViewModel(SurveyQuestionSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.MATRIX;
        this.orderedAnswers = createOrderedAnswers(bundle);
        this.rowStateByAnswerId = createInitialRowStates(bundle);
    }

    public /* synthetic */ MatrixQuestionViewModel(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final MicroSurveyPointMatrixContentView.BindingData getBindingData() {
        return new MicroSurveyPointMatrixContentView.BindingData(getSurveyPoint(), this.orderedAnswers, QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint());
    }

    private final SurveyPointMatrixSettings getSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings");
        return (SurveyPointMatrixSettings) settings;
    }

    public final void onColumnSelected(long answerId, final long columnId) {
        updateRowState(answerId, new Function1() { // from class: com.survicate.surveys.presentation.matrix.MatrixQuestionViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatrixQuestionViewModel.onColumnSelected$lambda$1(columnId, (MicroSurveyPointMatrixContentView.AnswerItemState) obj);
            }
        });
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MicroSurveyPointMatrixContentView.AnswerItemState onColumnSelected$lambda$1(long j, MicroSurveyPointMatrixContentView.AnswerItemState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MicroSurveyPointMatrixContentView.AnswerItemState.copy$default(it, Long.valueOf(j), false, null, 6, null);
    }

    public final void onCommentChanged(long answerId, final long columnId, final String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        updateRowState(answerId, new Function1() { // from class: com.survicate.surveys.presentation.matrix.MatrixQuestionViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatrixQuestionViewModel.onCommentChanged$lambda$2(columnId, comment, (MicroSurveyPointMatrixContentView.AnswerItemState) obj);
            }
        });
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MicroSurveyPointMatrixContentView.AnswerItemState onCommentChanged$lambda$2(long j, String str, MicroSurveyPointMatrixContentView.AnswerItemState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MicroSurveyPointMatrixContentView.AnswerItemState.copy$default(it, null, false, MapsKt.plus(it.getColumnComments(), TuplesKt.m1606to(Long.valueOf(j), str)), 3, null);
    }

    public final void onExpandedChanged(long answerId, final boolean isExpanded) {
        updateRowState(answerId, new Function1() { // from class: com.survicate.surveys.presentation.matrix.MatrixQuestionViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatrixQuestionViewModel.onExpandedChanged$lambda$3(isExpanded, (MicroSurveyPointMatrixContentView.AnswerItemState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MicroSurveyPointMatrixContentView.AnswerItemState onExpandedChanged$lambda$3(boolean z, MicroSurveyPointMatrixContentView.AnswerItemState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MicroSurveyPointMatrixContentView.AnswerItemState.copy$default(it, null, z, null, 5, null);
    }

    private final void updateRowState(long answerId, Function1<? super MicroSurveyPointMatrixContentView.AnswerItemState, MicroSurveyPointMatrixContentView.AnswerItemState> transform) {
        MicroSurveyPointMatrixContentView.AnswerItemState answerItemState = this.rowStateByAnswerId.get(Long.valueOf(answerId));
        if (answerItemState == null) {
            return;
        }
        this.rowStateByAnswerId.put(Long.valueOf(answerId), transform.invoke(answerItemState));
    }

    private final QuestionValidationState computeValidationState() {
        boolean z;
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) next;
            if (selectedColumnFor(questionPointAnswer.getId()) != null && Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (commentForSelectedColumn(((QuestionPointAnswer) it2.next()).getId()) == null || !(!StringsKt.isBlank(r1))) {
                    z = false;
                    break;
                }
            }
        }
        return QuestionValidationStateBuilder.INSTANCE.buildMatrixValidationState(getSettings(), areAllAnswersProvided(), z);
    }

    private final boolean areAllAnswersProvided() {
        List<QuestionPointAnswer> list = this.orderedAnswers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (selectedColumnFor(((QuestionPointAnswer) it.next()).getId()) == null) {
                return false;
            }
        }
        return true;
    }

    private final MatrixColumn selectedColumnFor(long answerId) {
        Long selectedColumnId;
        MicroSurveyPointMatrixContentView.AnswerItemState answerItemState = this.rowStateByAnswerId.get(Long.valueOf(answerId));
        Object obj = null;
        if (answerItemState == null || (selectedColumnId = answerItemState.getSelectedColumnId()) == null) {
            return null;
        }
        long jLongValue = selectedColumnId.longValue();
        Iterator<T> it = getSettings().getScale().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MatrixColumn) next).getId() == jLongValue) {
                obj = next;
                break;
            }
        }
        return (MatrixColumn) obj;
    }

    private final String commentForSelectedColumn(long answerId) {
        Map<Long, String> columnComments;
        MatrixColumn matrixColumnSelectedColumnFor = selectedColumnFor(answerId);
        if (matrixColumnSelectedColumnFor != null) {
            long id = matrixColumnSelectedColumnFor.getId();
            MicroSurveyPointMatrixContentView.AnswerItemState answerItemState = this.rowStateByAnswerId.get(Long.valueOf(answerId));
            if (answerItemState != null && (columnComments = answerItemState.getColumnComments()) != null) {
                return columnComments.get(Long.valueOf(id));
            }
        }
        return null;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        if (!areAllAnswersProvided()) {
            return CollectionsKt.emptyList();
        }
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (QuestionPointAnswer questionPointAnswer : list) {
            MicroSurveyPointMatrixContentView.AnswerItemState answerItemState = (MicroSurveyPointMatrixContentView.AnswerItemState) MapsKt.getValue(this.rowStateByAnswerId, Long.valueOf(questionPointAnswer.getId()));
            MatrixColumn matrixColumnSelectedColumnFor = selectedColumnFor(questionPointAnswer.getId());
            Intrinsics.checkNotNull(matrixColumnSelectedColumnFor);
            boolean zAreEqual = Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true);
            String str = answerItemState.getColumnComments().get(Long.valueOf(matrixColumnSelectedColumnFor.getId()));
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (StringsKt.isBlank(str) || !zAreEqual) {
                str = null;
            }
            SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
            surveyAnswer.setQuestionAnswerId(Long.valueOf(questionPointAnswer.getId()));
            surveyAnswer.setContent(String.valueOf(matrixColumnSelectedColumnFor.getId()));
            surveyAnswer.setComment(str);
            String possibleAnswer = questionPointAnswer.getPossibleAnswer();
            if (possibleAnswer != null) {
                str2 = possibleAnswer;
            }
            surveyAnswer.setMatrixGroupName(str2);
            surveyAnswer.setMatrixColumnName(matrixColumnSelectedColumnFor.getName());
            arrayList.add(surveyAnswer);
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        Map map = MapsKt.toMap(this.rowStateByAnswerId);
        List<QuestionPointAnswer> list = this.orderedAnswers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((QuestionPointAnswer) it.next()).getId()));
        }
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointMatrixContentView.SavedState(map, arrayList)));
    }

    private final List<QuestionPointAnswer> createOrderedAnswers(Bundle savedState) {
        Parcelable parcelable;
        List<Long> answerOrder = null;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointMatrixContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointMatrixContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointMatrixContentView.SavedState) parcelable2;
            }
            MicroSurveyPointMatrixContentView.SavedState savedState2 = (MicroSurveyPointMatrixContentView.SavedState) parcelable;
            if (savedState2 != null) {
                answerOrder = savedState2.getAnswerOrder();
            }
        }
        return QuestionOptionsShuffler.shuffleListIfNecessary$default(QuestionOptionsShuffler.INSTANCE, getSurveyPoint(), answerOrder, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<Long, MicroSurveyPointMatrixContentView.AnswerItemState> createInitialRowStates(Bundle savedState) {
        Map<Long, MicroSurveyPointMatrixContentView.AnswerItemState> mapEmptyMap;
        Parcelable parcelable;
        if (savedState == null) {
            mapEmptyMap = null;
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointMatrixContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointMatrixContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointMatrixContentView.SavedState) parcelable2;
            }
            MicroSurveyPointMatrixContentView.SavedState savedState2 = (MicroSurveyPointMatrixContentView.SavedState) parcelable;
            if (savedState2 != null) {
                mapEmptyMap = savedState2.getAnswerItemStates();
            }
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (QuestionPointAnswer questionPointAnswer : this.orderedAnswers) {
            int i2 = i + 1;
            Long lValueOf = Long.valueOf(questionPointAnswer.getId());
            MicroSurveyPointMatrixContentView.AnswerItemState answerItemState = mapEmptyMap.get(Long.valueOf(questionPointAnswer.getId()));
            if (answerItemState == null) {
                answerItemState = new MicroSurveyPointMatrixContentView.AnswerItemState(null, i == 0, MapsKt.emptyMap());
            }
            linkedHashMap.put(lValueOf, answerItemState);
            i = i2;
        }
        return linkedHashMap;
    }
}
