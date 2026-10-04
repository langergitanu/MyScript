package com.survicate.surveys;

import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurvicateAnswerFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\nH\u0002J&\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u0018\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\u001b\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateAnswerFactory;", "", "<init>", "()V", "createSurvicateAnswer", "Lcom/survicate/surveys/SurvicateAnswer;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "includeInputFields", "", "buildCtaAnswer", "buildFormAnswer", "joinFormFieldsWithValues", "", "buildNoIdAnswerWithComment", "buildQuestionSurveyTypeAnswer", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "buildSingleIdAnswer", "joinAnswerWithComment", "answer", "buildMultipleIdAnswer", "joinAnswers", "buildTextAnswer", "buildMatrixAnswer", "joinMatrixGroupsWithColumns", "buildDefaultAnswer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateAnswerFactory {
    public static final SurvicateAnswerFactory INSTANCE = new SurvicateAnswerFactory();

    private SurvicateAnswerFactory() {
    }

    public final SurvicateAnswer createSurvicateAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(answers, "answers");
        if (answers.isEmpty()) {
            throw new IllegalArgumentException("The answers list must contain at least one item, even if it's an empty fallback answer.".toString());
        }
        if (surveyPoint instanceof SurveyCtaSurveyPoint) {
            return buildCtaAnswer(surveyPoint);
        }
        if (surveyPoint instanceof SurveyFormSurveyPoint) {
            return buildFormAnswer(surveyPoint, answers, includeInputFields);
        }
        if (surveyPoint instanceof SurveyNpsSurveyPoint) {
            return buildNoIdAnswerWithComment(surveyPoint, answers, includeInputFields);
        }
        if (surveyPoint instanceof SurveyQuestionSurveyPoint) {
            return buildQuestionSurveyTypeAnswer((SurveyQuestionSurveyPoint) surveyPoint, answers, includeInputFields);
        }
        return buildDefaultAnswer(surveyPoint);
    }

    private final SurvicateAnswer buildCtaAnswer(SurveyPoint surveyPoint) {
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, null);
    }

    private final SurvicateAnswer buildFormAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String str;
        if (includeInputFields) {
            String strJoinFormFieldsWithValues = joinFormFieldsWithValues(answers);
            if (strJoinFormFieldsWithValues.length() == 0) {
                strJoinFormFieldsWithValues = null;
            }
            str = strJoinFormFieldsWithValues;
        } else {
            str = null;
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, str);
    }

    private final String joinFormFieldsWithValues(List<SurveyAnswer> answers) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : answers) {
            String content = ((SurveyAnswer) obj).getContent();
            if (content != null && !StringsKt.isBlank(content)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, new Function1() { // from class: com.survicate.surveys.SurvicateAnswerFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SurvicateAnswerFactory.joinFormFieldsWithValues$lambda$3((SurveyAnswer) obj2);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence joinFormFieldsWithValues$lambda$3(SurveyAnswer answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        return answer.getAnswerType() + ": " + answer.getContent();
    }

    private final SurvicateAnswer buildNoIdAnswerWithComment(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String answer;
        if (includeInputFields) {
            String strJoinAnswerWithComment = joinAnswerWithComment(answers.get(0));
            if (strJoinAnswerWithComment.length() == 0) {
                strJoinAnswerWithComment = null;
            }
            answer = strJoinAnswerWithComment;
        } else {
            answer = answers.get(0).getAnswer();
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, answer);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (r0.equals(com.survicate.surveys.surveys.QuestionSurveyAnswerType.CSAT) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r0.equals(com.survicate.surveys.surveys.QuestionSurveyAnswerType.SINGLE) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r0.equals(com.survicate.surveys.surveys.QuestionSurveyAnswerType.SHAPE) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
    
        if (r0.equals(com.survicate.surveys.surveys.QuestionSurveyAnswerType.NUMERICAL) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
    
        return buildSingleIdAnswer(r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0.equals(com.survicate.surveys.surveys.QuestionSurveyAnswerType.SMILEY_SCALE) != false) goto L40;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SurvicateAnswer buildQuestionSurveyTypeAnswer(SurveyQuestionSurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String answerType = surveyPoint.getAnswerType();
        switch (answerType.hashCode()) {
            case -1710937533:
                break;
            case -1081239615:
                if (answerType.equals(QuestionSurveyAnswerType.MATRIX)) {
                    return buildMatrixAnswer(surveyPoint, answers, includeInputFields);
                }
                return buildDefaultAnswer(surveyPoint);
            case -938102371:
                break;
            case -902265784:
                break;
            case 3062947:
                break;
            case 3076014:
                if (answerType.equals(QuestionSurveyAnswerType.DATE)) {
                    return buildNoIdAnswerWithComment(surveyPoint, answers, includeInputFields);
                }
                return buildDefaultAnswer(surveyPoint);
            case 3556653:
                if (answerType.equals("text")) {
                    return buildTextAnswer(surveyPoint, answers, includeInputFields);
                }
                return buildDefaultAnswer(surveyPoint);
            case 653829648:
                if (answerType.equals(QuestionSurveyAnswerType.MULTIPLE)) {
                    return buildMultipleIdAnswer(surveyPoint, answers, includeInputFields);
                }
                return buildDefaultAnswer(surveyPoint);
            case 1047773692:
                break;
            default:
                return buildDefaultAnswer(surveyPoint);
        }
    }

    private final SurvicateAnswer buildSingleIdAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String answer;
        if (includeInputFields) {
            String strJoinAnswerWithComment = joinAnswerWithComment(answers.get(0));
            if (strJoinAnswerWithComment.length() == 0) {
                strJoinAnswerWithComment = null;
            }
            answer = strJoinAnswerWithComment;
        } else {
            answer = answers.get(0).getAnswer();
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), answers.get(0).getQuestionAnswerId(), null, answer);
    }

    private final String joinAnswerWithComment(SurveyAnswer answer) {
        String comment = answer.getComment();
        StringBuilder sb = new StringBuilder();
        String answer2 = answer.getAnswer();
        if (answer2 == null) {
            answer2 = "";
        }
        return sb.append(answer2).append(comment != null ? ": " + comment : "").toString();
    }

    private final SurvicateAnswer buildMultipleIdAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = answers.iterator();
        while (it.hasNext()) {
            Long questionAnswerId = ((SurveyAnswer) it.next()).getQuestionAnswerId();
            if (questionAnswerId != null) {
                arrayList.add(questionAnswerId);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        String strJoinAnswers = joinAnswers(answers, includeInputFields);
        if (strJoinAnswers.length() == 0) {
            strJoinAnswers = null;
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, set, strJoinAnswers);
    }

    private final String joinAnswers(List<SurveyAnswer> answers, final boolean includeInputFields) {
        return CollectionsKt.joinToString$default(answers, " | ", null, null, 0, null, new Function1() { // from class: com.survicate.surveys.SurvicateAnswerFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SurvicateAnswerFactory.joinAnswers$lambda$8(includeInputFields, (SurveyAnswer) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence joinAnswers$lambda$8(boolean z, SurveyAnswer answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (z) {
            return INSTANCE.joinAnswerWithComment(answer);
        }
        String answer2 = answer.getAnswer();
        if (answer2 == null) {
            answer2 = "";
        }
        return answer2;
    }

    private final SurvicateAnswer buildTextAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String answer = answers.get(0).getAnswer();
        if (!includeInputFields) {
            answer = null;
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, answer);
    }

    private final SurvicateAnswer buildMatrixAnswer(SurveyPoint surveyPoint, List<SurveyAnswer> answers, boolean includeInputFields) {
        String strJoinMatrixGroupsWithColumns = joinMatrixGroupsWithColumns(answers, includeInputFields);
        if (strJoinMatrixGroupsWithColumns.length() == 0) {
            strJoinMatrixGroupsWithColumns = null;
        }
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, strJoinMatrixGroupsWithColumns);
    }

    private final String joinMatrixGroupsWithColumns(List<SurveyAnswer> answers, final boolean includeInputFields) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : answers) {
            String matrixColumnName = ((SurveyAnswer) obj).getMatrixColumnName();
            if (matrixColumnName != null && !StringsKt.isBlank(matrixColumnName)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, new Function1() { // from class: com.survicate.surveys.SurvicateAnswerFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SurvicateAnswerFactory.joinMatrixGroupsWithColumns$lambda$14(includeInputFields, (SurveyAnswer) obj2);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence joinMatrixGroupsWithColumns$lambda$14(boolean z, SurveyAnswer answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        String comment = answer.getComment();
        String str = null;
        if (comment != null) {
            if (!z) {
                comment = null;
            }
            if (comment != null) {
                str = " (" + comment + ')';
            }
        }
        if (str == null) {
            str = "";
        }
        return answer.getMatrixGroupName() + ": " + answer.getMatrixColumnName() + str;
    }

    private final SurvicateAnswer buildDefaultAnswer(SurveyPoint surveyPoint) {
        return new SurvicateAnswer(surveyPoint.getAnswerType(), null, null, null);
    }
}
