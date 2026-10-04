package com.survicate.surveys.utils;

import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormPointSettings;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings;
import com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.SurveyPointRatingSettings;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings;
import com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings;
import com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixAnswerItem;
import com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixColumnItem;
import com.survicate.surveys.presentation.multiple.micro.MicroSurveyPointMultipleAnswerItem;
import com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleAnswerItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QuestionValidationStateBuilder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ,\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ.\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\tJ$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\r2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tJ\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\tJ$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001dH\u0002J&\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tJ.\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ&\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tJ.\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ&\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tJ\u001e\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020+2\u0006\u0010$\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020+2\u0006\u0010$\u001a\u00020\tJ\u001e\u0010,\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\tJ\u0018\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\t¨\u00065"}, m1599d2 = {"Lcom/survicate/surveys/utils/QuestionValidationStateBuilder;", "", "<init>", "()V", "buildCtaValidationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "pointSettings", "Lcom/survicate/surveys/entities/survey/questions/cta/CtaSettings;", "isDisclaimerAccepted", "", "buildSingleChoiceValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "answerItems", "", "Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleAnswerItem;", "wasAnswerWithCommentSelectedFirst", "isAnswerProvided", "isCommentAvailableForSelected", "commentForSelected", "", "buildMultipleChoiceValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "Lcom/survicate/surveys/presentation/multiple/micro/MicroSurveyPointMultipleAnswerItem;", "isAnyAnswerSelected", "hasCommentsForSelectedAnswers", "buildTextValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "buildMatrixValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixAnswerItem;", "areAllAnswersProvided", "hasCommentsForAnsweredRows", "isCommentProvidedFor", "matrixItem", "buildNpsValidationState", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "isCommentProvided", "buildSmileyScaleValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;", "isAddingCommentAvailable", "buildRatingValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/rating/SurveyPointRatingSettings;", "buildDateValidationState", "Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "buildFormInitialValidationState", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormPointSettings;", "areRequiredFieldFilled", "buildFormValidationState", "areRequiredFieldsFilled", "isDisclaimerSatisfied", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "isAccepted", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class QuestionValidationStateBuilder {
    public static final QuestionValidationStateBuilder INSTANCE = new QuestionValidationStateBuilder();

    private QuestionValidationStateBuilder() {
    }

    public final QuestionValidationState buildCtaValidationState(CtaSettings pointSettings, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        return new QuestionValidationState(isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false);
    }

    public final QuestionValidationState buildSingleChoiceValidationState(SurveyPointSingleSettings pointSettings, List<MicroSurveyPointSingleAnswerItem> answerItems, boolean wasAnswerWithCommentSelectedFirst, boolean isDisclaimerAccepted) {
        Object next;
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        Intrinsics.checkNotNullParameter(answerItems, "answerItems");
        Iterator<T> it = answerItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MicroSurveyPointSingleAnswerItem) next).getIsSelected()) {
                break;
            }
        }
        MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem = (MicroSurveyPointSingleAnswerItem) next;
        boolean z = microSurveyPointSingleAnswerItem != null;
        boolean z2 = microSurveyPointSingleAnswerItem != null && microSurveyPointSingleAnswerItem.getIsCommentAvailable();
        String comment = microSurveyPointSingleAnswerItem != null ? microSurveyPointSingleAnswerItem.getComment() : null;
        if (comment == null) {
            comment = "";
        }
        QuestionValidationState questionValidationStateBuildSingleChoiceValidationState = buildSingleChoiceValidationState(pointSettings, z, z2, comment, wasAnswerWithCommentSelectedFirst);
        boolean zIsDisclaimerSatisfied = isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted);
        DisclaimerSettings disclaimerSettings = pointSettings.getDisclaimerSettings();
        return questionValidationStateBuildSingleChoiceValidationState.copy(questionValidationStateBuildSingleChoiceValidationState.isSuccess() && zIsDisclaimerSatisfied, questionValidationStateBuildSingleChoiceValidationState.getHideDefaultSubmitButton() && !(disclaimerSettings != null && disclaimerSettings.getCheckboxVisible()));
    }

    public final QuestionValidationState buildSingleChoiceValidationState(SurveyPointSingleSettings pointSettings, boolean isAnswerProvided, boolean isCommentAvailableForSelected, String commentForSelected, boolean wasAnswerWithCommentSelectedFirst) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        Intrinsics.checkNotNullParameter(commentForSelected, "commentForSelected");
        boolean isMandatory = pointSettings.getIsMandatory();
        return new QuestionValidationState((isAnswerProvided || !isMandatory) && (!isAnswerProvided || !isCommentAvailableForSelected || Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) false) || !StringsKt.isBlank(commentForSelected)), isMandatory && !wasAnswerWithCommentSelectedFirst);
    }

    public final QuestionValidationState buildMultipleChoiceValidationState(SurveyPointMultipleSettings pointSettings, List<MicroSurveyPointMultipleAnswerItem> answerItems, boolean isDisclaimerAccepted) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        Intrinsics.checkNotNullParameter(answerItems, "answerItems");
        List<MicroSurveyPointMultipleAnswerItem> list = answerItems;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((MicroSurveyPointMultipleAnswerItem) it.next()).getIsSelected()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            MicroSurveyPointMultipleAnswerItem microSurveyPointMultipleAnswerItem = (MicroSurveyPointMultipleAnswerItem) obj;
            if (microSurveyPointMultipleAnswerItem.getIsSelected() && microSurveyPointMultipleAnswerItem.getIsCommentAvailable()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            z2 = true;
        } else {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (StringsKt.isBlank(((MicroSurveyPointMultipleAnswerItem) it2.next()).getComment())) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        QuestionValidationState questionValidationStateBuildMultipleChoiceValidationState = buildMultipleChoiceValidationState(pointSettings, z, z2);
        return QuestionValidationState.copy$default(questionValidationStateBuildMultipleChoiceValidationState, questionValidationStateBuildMultipleChoiceValidationState.isSuccess() && isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false, 2, null);
    }

    public final QuestionValidationState buildMultipleChoiceValidationState(SurveyPointMultipleSettings pointSettings, boolean isAnyAnswerSelected, boolean hasCommentsForSelectedAnswers) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        return new QuestionValidationState((isAnyAnswerSelected || !pointSettings.getIsMandatory()) && (!Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) true) || hasCommentsForSelectedAnswers), false);
    }

    public final QuestionValidationState buildTextValidationState(SurveyPointTextSettings pointSettings, boolean isAnswerProvided, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildTextValidationState = buildTextValidationState(pointSettings, isAnswerProvided);
        return QuestionValidationState.copy$default(questionValidationStateBuildTextValidationState, questionValidationStateBuildTextValidationState.isSuccess() && isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false, 2, null);
    }

    public final QuestionValidationState buildTextValidationState(SurveyPointTextSettings pointSettings, boolean isAnswerProvided) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        return new QuestionValidationState(isAnswerProvided || !pointSettings.getIsMandatory(), false);
    }

    public final QuestionValidationState buildMatrixValidationState(SurveyPointMatrixSettings pointSettings, List<MicroSurveyPointMatrixAnswerItem> answerItems, boolean isDisclaimerAccepted) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        Intrinsics.checkNotNullParameter(answerItems, "answerItems");
        List<MicroSurveyPointMatrixAnswerItem> list = answerItems;
        boolean z3 = list instanceof Collection;
        if (z3 && list.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((MicroSurveyPointMatrixAnswerItem) it.next()).getSelectedColumn() == null) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (z3 && list.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!INSTANCE.isCommentProvidedFor((MicroSurveyPointMatrixAnswerItem) it2.next())) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        QuestionValidationState questionValidationStateBuildMatrixValidationState = buildMatrixValidationState(pointSettings, z, z2);
        return QuestionValidationState.copy$default(questionValidationStateBuildMatrixValidationState, questionValidationStateBuildMatrixValidationState.isSuccess() && isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false, 2, null);
    }

    public final QuestionValidationState buildMatrixValidationState(SurveyPointMatrixSettings pointSettings, boolean areAllAnswersProvided, boolean hasCommentsForAnsweredRows) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        boolean z = false;
        boolean z2 = areAllAnswersProvided || !pointSettings.getMandatory();
        boolean z3 = !pointSettings.isCommentMandatory() || hasCommentsForAnsweredRows;
        if (z2 && z3) {
            z = true;
        }
        return new QuestionValidationState(z, !z2);
    }

    private final boolean isCommentProvidedFor(MicroSurveyPointMatrixAnswerItem matrixItem) {
        MicroSurveyPointMatrixColumnItem selectedColumn = matrixItem.getSelectedColumn();
        return (selectedColumn != null && matrixItem.getIsCommentAvailable() && StringsKt.isBlank(selectedColumn.getComment())) ? false : true;
    }

    public final QuestionValidationState buildNpsValidationState(SurveyNpsPointSettings pointSettings, boolean isAnswerProvided, boolean isCommentProvided, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildNpsValidationState = buildNpsValidationState(pointSettings, isAnswerProvided, isCommentProvided);
        boolean zIsDisclaimerSatisfied = isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted);
        DisclaimerSettings disclaimerSettings = pointSettings.getDisclaimerSettings();
        return questionValidationStateBuildNpsValidationState.copy(questionValidationStateBuildNpsValidationState.isSuccess() && zIsDisclaimerSatisfied, questionValidationStateBuildNpsValidationState.getHideDefaultSubmitButton() && !(disclaimerSettings != null && disclaimerSettings.getCheckboxVisible()));
    }

    public final QuestionValidationState buildNpsValidationState(SurveyNpsPointSettings pointSettings, boolean isAnswerProvided, boolean isCommentProvided) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        boolean mandatory = pointSettings.getMandatory();
        boolean z = false;
        boolean z2 = isAnswerProvided || !mandatory;
        boolean z3 = pointSettings.getAddComment() && isAnswerProvided;
        boolean z4 = z2 && (isCommentProvided || !(z3 && Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) true)));
        if (mandatory && !z3) {
            z = true;
        }
        return new QuestionValidationState(z4, z);
    }

    public final QuestionValidationState buildSmileyScaleValidationState(SurveyPointSmileyScaleSettings pointSettings, boolean isAddingCommentAvailable, boolean isAnswerProvided, boolean isCommentProvided, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildSmileyScaleValidationState = buildSmileyScaleValidationState(pointSettings, isAddingCommentAvailable, isAnswerProvided, isCommentProvided);
        boolean zIsDisclaimerSatisfied = isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted);
        DisclaimerSettings disclaimerSettings = pointSettings.getDisclaimerSettings();
        return questionValidationStateBuildSmileyScaleValidationState.copy(questionValidationStateBuildSmileyScaleValidationState.isSuccess() && zIsDisclaimerSatisfied, questionValidationStateBuildSmileyScaleValidationState.getHideDefaultSubmitButton() && !(disclaimerSettings != null && disclaimerSettings.getCheckboxVisible()));
    }

    public final QuestionValidationState buildSmileyScaleValidationState(SurveyPointSmileyScaleSettings pointSettings, boolean isAddingCommentAvailable, boolean isAnswerProvided, boolean isCommentProvided) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        boolean isMandatory = pointSettings.getIsMandatory();
        boolean z = false;
        boolean z2 = isAnswerProvided || !isMandatory;
        boolean z3 = isAddingCommentAvailable && isAnswerProvided;
        boolean z4 = z2 && (isCommentProvided || !(z3 && Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) true)));
        if (isMandatory && !z3) {
            z = true;
        }
        return new QuestionValidationState(z4, z);
    }

    public final QuestionValidationState buildRatingValidationState(SurveyPointRatingSettings pointSettings, boolean isAnswerProvided, boolean isAddingCommentAvailable, boolean isCommentProvided, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildRatingValidationState = buildRatingValidationState(pointSettings, isAnswerProvided, isAddingCommentAvailable, isCommentProvided);
        boolean zIsDisclaimerSatisfied = isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted);
        DisclaimerSettings disclaimerSettings = pointSettings.getDisclaimerSettings();
        return questionValidationStateBuildRatingValidationState.copy(questionValidationStateBuildRatingValidationState.isSuccess() && zIsDisclaimerSatisfied, questionValidationStateBuildRatingValidationState.getHideDefaultSubmitButton() && !(disclaimerSettings != null && disclaimerSettings.getCheckboxVisible()));
    }

    public final QuestionValidationState buildRatingValidationState(SurveyPointRatingSettings pointSettings, boolean isAnswerProvided, boolean isAddingCommentAvailable, boolean isCommentProvided) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        boolean isMandatory = pointSettings.getIsMandatory();
        boolean z = false;
        boolean z2 = isAnswerProvided || !isMandatory;
        boolean z3 = isAddingCommentAvailable && isAnswerProvided;
        boolean z4 = z2 && (isCommentProvided || !(z3 && Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) true)));
        if (isMandatory && !z3) {
            z = true;
        }
        return new QuestionValidationState(z4, z);
    }

    public final QuestionValidationState buildDateValidationState(SurveyPointDateSettings pointSettings, boolean isCommentProvided, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildDateValidationState = buildDateValidationState(pointSettings, isCommentProvided);
        return QuestionValidationState.copy$default(questionValidationStateBuildDateValidationState, questionValidationStateBuildDateValidationState.isSuccess() && isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false, 2, null);
    }

    public final QuestionValidationState buildDateValidationState(SurveyPointDateSettings pointSettings, boolean isCommentProvided) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        boolean z = true;
        boolean z2 = pointSettings.getAddComment() && Intrinsics.areEqual((Object) pointSettings.isCommentMandatory(), (Object) true);
        if (!isCommentProvided && z2) {
            z = false;
        }
        return new QuestionValidationState(z, false);
    }

    public final QuestionValidationState buildFormInitialValidationState(SurveyFormPointSettings pointSettings, boolean areRequiredFieldFilled, boolean isDisclaimerAccepted) {
        Intrinsics.checkNotNullParameter(pointSettings, "pointSettings");
        QuestionValidationState questionValidationStateBuildFormValidationState = buildFormValidationState(areRequiredFieldFilled);
        return QuestionValidationState.copy$default(questionValidationStateBuildFormValidationState, questionValidationStateBuildFormValidationState.isSuccess() && isDisclaimerSatisfied(pointSettings.getDisclaimerSettings(), isDisclaimerAccepted), false, 2, null);
    }

    public final QuestionValidationState buildFormValidationState(boolean areRequiredFieldsFilled) {
        return new QuestionValidationState(areRequiredFieldsFilled, false);
    }

    public final boolean isDisclaimerSatisfied(DisclaimerSettings disclaimerSettings, boolean isAccepted) {
        return disclaimerSettings == null || isAccepted || !disclaimerSettings.getCheckboxVisible() || !disclaimerSettings.getCheckboxRequired();
    }
}
