package com.survicate.surveys.entities.survey.surveyLogic.display;

import android.os.Parcelable;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.infrastructure.serialization.DisplayLogicSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: DisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "Landroid/os/Parcelable;", "<init>", "()V", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "groupOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getGroupOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "Companion", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DateDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MultipleChoiceDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/RangeDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/SingleChoiceDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogic;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable(with = DisplayLogicSerializer.class)
public abstract class DisplayLogic implements Parcelable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ DisplayLogic(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract SurveyAnswerType getAnswerType();

    public abstract SurveyLogicOperator getGroupOperator();

    public abstract long getPointId();

    /* JADX INFO: compiled from: DisplayLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DisplayLogic> serializer() {
            return DisplayLogicSerializer.INSTANCE;
        }
    }

    private DisplayLogic() {
    }
}
