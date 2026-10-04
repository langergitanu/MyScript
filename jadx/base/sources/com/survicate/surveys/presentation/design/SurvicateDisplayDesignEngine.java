package com.survicate.surveys.presentation.design;

import androidx.fragment.app.Fragment;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.theme.ThemeType;
import com.survicate.surveys.presentation.page.SurveyPageFragment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateDisplayDesignEngine.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/design/SurvicateDisplayDesignEngine;", "Lcom/survicate/surveys/presentation/design/DisplayDesignEngine;", "<init>", "()V", "createSurveyPointFragment", "Landroidx/fragment/app/Fragment;", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "themeType", "Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateDisplayDesignEngine implements DisplayDesignEngine {

    /* JADX INFO: compiled from: SurvicateDisplayDesignEngine.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SurveyAnswerType.values().length];
            try {
                iArr[SurveyAnswerType.BUTTON_NEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyAnswerType.SINGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyAnswerType.MULTIPLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SurveyAnswerType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SurveyAnswerType.TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SurveyAnswerType.DATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SurveyAnswerType.SMILEY_SCALE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SurveyAnswerType.NPS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SurveyAnswerType.SHAPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SurveyAnswerType.NUMERICAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SurveyAnswerType.CSAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SurveyAnswerType.FORM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ThemeType.values().length];
            try {
                iArr2[ThemeType.MICRO.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.survicate.surveys.presentation.design.DisplayDesignFactory
    public Fragment createSurveyPointFragment(SurveyAnswerType answerType, ThemeType themeType) {
        SurveyPageFragment surveyPageFragment;
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(themeType, "themeType");
        if (WhenMappings.$EnumSwitchMapping$1[themeType.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[answerType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 4:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 5:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 6:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 7:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 8:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 9:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 10:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 11:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 12:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 13:
                surveyPageFragment = new SurveyPageFragment();
                break;
            case 14:
                surveyPageFragment = new SurveyPageFragment();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return surveyPageFragment;
    }
}
