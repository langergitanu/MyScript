package com.survicate.surveys.presentation.smileyscale;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SmileyScaleStyleType;
import com.survicate.surveys.surveys.SmileyScaleType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmileyScaleUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0014\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/smileyscale/SmileyScaleUtils;", "", "<init>", "()V", "SMILEY_SCALE_3_OPTIONS", "", "VALID_POSSIBLE_ANSWERS", "", "", "isThreeOptionsSmileyScale", "", "size", "validateAnswerOptions", "answers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "getEmojiDrawableRes", "possibleAnswer", "answerCount", "getDrawableRes", "styleType", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SmileyScaleStyleType;", "getOutlinedDrawableRes", "getFilledDrawableRes", "createScaleStyleColorFilter", "Landroid/graphics/ColorFilter;", "colorHex", "getContentDescription", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getContentDescriptionRes", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SmileyScaleUtils {
    private static final int SMILEY_SCALE_3_OPTIONS = 3;
    public static final SmileyScaleUtils INSTANCE = new SmileyScaleUtils();
    private static final Set<String> VALID_POSSIBLE_ANSWERS = SetsKt.setOf((Object[]) new String[]{SmileyScaleType.EXTREMELY_UNSATISFIED, SmileyScaleType.UNSATISFIED, SmileyScaleType.NEUTRAL, SmileyScaleType.HAPPY, SmileyScaleType.EXTREMELY_HAPPY});

    /* JADX INFO: compiled from: SmileyScaleUtils.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SmileyScaleStyleType.values().length];
            try {
                iArr[SmileyScaleStyleType.OUTLINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SmileyScaleStyleType.FILLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SmileyScaleStyleType.EMOJIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean isThreeOptionsSmileyScale(int size) {
        return size == 3;
    }

    private SmileyScaleUtils() {
    }

    public final boolean validateAnswerOptions(List<QuestionPointAnswer> answers) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        if (answers.isEmpty()) {
            return false;
        }
        List<QuestionPointAnswer> list = answers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!CollectionsKt.contains(VALID_POSSIBLE_ANSWERS, ((QuestionPointAnswer) it.next()).getPossibleAnswer())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getEmojiDrawableRes(String possibleAnswer, int answerCount) {
        Intrinsics.checkNotNullParameter(possibleAnswer, "possibleAnswer");
        boolean zIsThreeOptionsSmileyScale = isThreeOptionsSmileyScale(answerCount);
        switch (possibleAnswer.hashCode()) {
            case -1378955470:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_UNSATISFIED)) {
                    return C8369R.drawable.ic_extremely_unhappy_micro;
                }
                break;
            case -785992281:
                if (possibleAnswer.equals(SmileyScaleType.NEUTRAL)) {
                    return C8369R.drawable.ic_neutral_micro;
                }
                break;
            case -379088103:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_HAPPY)) {
                    return C8369R.drawable.ic_extremely_happy_micro;
                }
                break;
            case 69494464:
                if (possibleAnswer.equals(SmileyScaleType.HAPPY)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_happy_micro : C8369R.drawable.ic_happy_micro;
                }
                break;
            case 278006169:
                if (possibleAnswer.equals(SmileyScaleType.UNSATISFIED)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_unhappy_micro : C8369R.drawable.ic_unhappy_micro;
                }
                break;
        }
        return C8369R.drawable.ic_neutral_micro;
    }

    public final int getDrawableRes(String possibleAnswer, int answerCount, SmileyScaleStyleType styleType) {
        Intrinsics.checkNotNullParameter(possibleAnswer, "possibleAnswer");
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        int i = WhenMappings.$EnumSwitchMapping$0[styleType.ordinal()];
        if (i == 1) {
            return getOutlinedDrawableRes(possibleAnswer, answerCount);
        }
        if (i == 2) {
            return getFilledDrawableRes(possibleAnswer, answerCount);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return getEmojiDrawableRes(possibleAnswer, answerCount);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final int getOutlinedDrawableRes(String possibleAnswer, int answerCount) {
        boolean zIsThreeOptionsSmileyScale = isThreeOptionsSmileyScale(answerCount);
        switch (possibleAnswer.hashCode()) {
            case -1378955470:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_UNSATISFIED)) {
                    return C8369R.drawable.ic_extremely_unhappy_outlined_micro;
                }
                break;
            case -785992281:
                if (possibleAnswer.equals(SmileyScaleType.NEUTRAL)) {
                    return C8369R.drawable.ic_neutral_outlined_micro;
                }
                break;
            case -379088103:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_HAPPY)) {
                    return C8369R.drawable.ic_extremely_happy_outlined_micro;
                }
                break;
            case 69494464:
                if (possibleAnswer.equals(SmileyScaleType.HAPPY)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_happy_outlined_micro : C8369R.drawable.ic_happy_outlined_micro;
                }
                break;
            case 278006169:
                if (possibleAnswer.equals(SmileyScaleType.UNSATISFIED)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_unhappy_outlined_micro : C8369R.drawable.ic_unhappy_outlined_micro;
                }
                break;
        }
        return C8369R.drawable.ic_neutral_outlined_micro;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final int getFilledDrawableRes(String possibleAnswer, int answerCount) {
        boolean zIsThreeOptionsSmileyScale = isThreeOptionsSmileyScale(answerCount);
        switch (possibleAnswer.hashCode()) {
            case -1378955470:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_UNSATISFIED)) {
                    return C8369R.drawable.ic_extremely_unhappy_filled_micro;
                }
                break;
            case -785992281:
                if (possibleAnswer.equals(SmileyScaleType.NEUTRAL)) {
                    return C8369R.drawable.ic_neutral_filled_micro;
                }
                break;
            case -379088103:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_HAPPY)) {
                    return C8369R.drawable.ic_extremely_happy_filled_micro;
                }
                break;
            case 69494464:
                if (possibleAnswer.equals(SmileyScaleType.HAPPY)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_happy_filled_micro : C8369R.drawable.ic_happy_filled_micro;
                }
                break;
            case 278006169:
                if (possibleAnswer.equals(SmileyScaleType.UNSATISFIED)) {
                    return zIsThreeOptionsSmileyScale ? C8369R.drawable.ic_extremely_unhappy_filled_micro : C8369R.drawable.ic_unhappy_filled_micro;
                }
                break;
        }
        return C8369R.drawable.ic_neutral_filled_micro;
    }

    public final ColorFilter createScaleStyleColorFilter(SmileyScaleStyleType styleType, String colorHex) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        if (styleType == SmileyScaleStyleType.EMOJIS) {
            return null;
        }
        String str = colorHex;
        int color = -16777216;
        if (str != null && str.length() != 0) {
            try {
                color = Color.parseColor(colorHex);
            } catch (IllegalArgumentException unused) {
            }
        }
        return BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_IN);
    }

    public final String getContentDescription(Context context, String possibleAnswer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(possibleAnswer, "possibleAnswer");
        int contentDescriptionRes = getContentDescriptionRes(possibleAnswer);
        if (contentDescriptionRes != 0) {
            return context.getString(contentDescriptionRes);
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int getContentDescriptionRes(String possibleAnswer) {
        Intrinsics.checkNotNullParameter(possibleAnswer, "possibleAnswer");
        switch (possibleAnswer.hashCode()) {
            case -1378955470:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_UNSATISFIED)) {
                    return C8369R.string.f2255xb0650c4f;
                }
                return 0;
            case -785992281:
                if (possibleAnswer.equals(SmileyScaleType.NEUTRAL)) {
                    return C8369R.string.survicate_micro_smiley_scale_neutral_content_description;
                }
                return 0;
            case -379088103:
                if (possibleAnswer.equals(SmileyScaleType.EXTREMELY_HAPPY)) {
                    return C8369R.string.survicate_micro_smiley_scale_extremely_happy_content_description;
                }
                return 0;
            case 69494464:
                if (possibleAnswer.equals(SmileyScaleType.HAPPY)) {
                    return C8369R.string.survicate_micro_smiley_scale_happy_content_description;
                }
                return 0;
            case 278006169:
                if (possibleAnswer.equals(SmileyScaleType.UNSATISFIED)) {
                    return C8369R.string.survicate_micro_smiley_scale_unsatisfied_content_description;
                }
                return 0;
            default:
                return 0;
        }
    }
}
