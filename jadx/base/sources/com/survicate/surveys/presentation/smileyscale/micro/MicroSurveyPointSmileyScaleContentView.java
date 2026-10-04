package com.survicate.surveys.presentation.smileyscale.micro;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SmileyScaleStyle;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.smileyscale.SmileyScaleUtils;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.ScreenUtils;
import com.survicate.surveys.utils.SurvicateViewUtils;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u0000 j2\u00020\u0001:\u0003jklB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010@\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0018\u0010A\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u00020\u0019H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\b\u0010F\u001a\u00020GH\u0002J \u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020GH\u0002J0\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020G2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0002J \u0010T\u001a\u00020\u00192\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020G2\u0006\u0010S\u001a\u00020\u0007H\u0002J\u0018\u0010U\u001a\u00020\u00192\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020GH\u0002J\u0014\u0010V\u001a\u0004\u0018\u00010\u000b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010W\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0014\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010Z\u001a\u00020\u0019H\u0002J\b\u0010[\u001a\u00020\u0019H\u0002J\u0012\u0010\\\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010\u0013\u001a\u00020\u00192\u0006\u0010]\u001a\u00020\u000bH\u0002J\u0010\u0010^\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u000bH\u0002J\b\u0010_\u001a\u00020?H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0002J\u000e\u0010b\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010cJ\b\u0010d\u001a\u00020\u0019H\u0002J\b\u0010e\u001a\u00020\u0019H\u0002J\u0014\u0010f\u001a\u00020\u0019*\u00020<2\u0006\u0010g\u001a\u00020hH\u0002J\f\u0010i\u001a\u00020\u0019*\u000205H\u0002R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R \u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0;0:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, m1599d2 = {"Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "selectedAnswer", "getSelectedAnswer", "()Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "", "commentFieldText", "getCommentFieldText", "()Ljava/lang/String;", "onAnswerSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "answerId", "", "getOnAnswerSelected", "()Lkotlin/jvm/functions/Function1;", "setOnAnswerSelected", "(Lkotlin/jvm/functions/Function1;)V", "onCommentChanged", "text", "getOnCommentChanged", "setOnCommentChanged", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindingData", "Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView$BindingData;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;", "containerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "leftDescriptionTextView", "Landroid/widget/TextView;", "rightDescriptionTextView", "commentField", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "smileyOptions", "", "Lkotlin/Pair;", "Landroid/widget/ImageView;", "barrierId", "wasCommentFieldFocused", "", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "createSmileyIcons", "removeOldIcons", "addIconViews", "", "createSmileyImageView", "possibleAnswer", "answerCount", "answer", "constrainIcons", "iconIds", "constrainIconPositions", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "iconTopMargin", "iconSpacing", "chainStyle", "constrainHorizontalChain", "constrainLegendBelowIcons", "restoreSelectedAnswer", "restoreComment", "readSavedState", "Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView$SavedState;", "bindHeader", "setDescriptionTexts", "bindCommentField", "questionPointAnswer", "updateSelectedAnswer", "isCommentAvailable", "showCommentField", "Lkotlinx/coroutines/Job;", "scrollToCommentField", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupScrollOnCommentFocus", "restoreCommentFocus", "setScale", "scale", "", "setupAsLegendText", "Companion", "BindingData", "SavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointSmileyScaleContentView extends FrameLayout {
    private static final float DEFAULT_ICON_SCALE = 1.0f;
    public static final String SAVED_STATE = "SAVED_STATE";
    private static final float SELECTED_ICON_SCALE = 1.2f;
    private static final long SHOW_COMMENT_DELAY = 250;
    private int barrierId;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private final MicroSurvicateCommentField commentField;
    private String commentFieldText;
    private final ConstraintLayout containerView;
    private final TextView leftDescriptionTextView;
    private Function1<? super Long, Unit> onAnswerSelected;
    private Function1<? super String, Unit> onCommentChanged;
    private final MicroQuestionHeader questionHeaderView;
    private final TextView rightDescriptionTextView;
    private QuestionPointAnswer selectedAnswer;
    private List<? extends Pair<? extends ImageView, String>> smileyOptions;
    private ViewDependencies viewDependencies;
    private boolean wasCommentFieldFocused;

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$scrollToCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView", m1609f = "MicroSurveyPointSmileyScaleContentView.kt", m1610i = {}, m1611l = {295}, m1612m = "scrollToCommentField", m1613n = {}, m1615s = {})
    static final class C84641 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84641(Continuation<? super C84641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MicroSurveyPointSmileyScaleContentView.this.scrollToCommentField(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSmileyScaleContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSmileyScaleContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointSmileyScaleContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSmileyScaleContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.commentFieldText = "";
        this.smileyOptions = CollectionsKt.emptyList();
        this.barrierId = View.generateViewId();
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_smiley_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_smiley_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.containerView = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_smiley_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_question_legend_label_left);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.leftDescriptionTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_question_legend_label_right);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.rightDescriptionTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_smiley_content_comment_field);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.commentField = (MicroSurvicateCommentField) viewFindViewById5;
    }

    public final QuestionPointAnswer getSelectedAnswer() {
        return this.selectedAnswer;
    }

    public final String getCommentFieldText() {
        return this.commentFieldText;
    }

    public final Function1<Long, Unit> getOnAnswerSelected() {
        return this.onAnswerSelected;
    }

    public final void setOnAnswerSelected(Function1<? super Long, Unit> function1) {
        this.onAnswerSelected = function1;
    }

    public final Function1<String, Unit> getOnCommentChanged() {
        return this.onCommentChanged;
    }

    public final void setOnCommentChanged(Function1<? super String, Unit> function1) {
        this.onCommentChanged = function1;
    }

    private final SurveyQuestionSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyPointSmileyScaleSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings");
        return (SurveyPointSmileyScaleSettings) settings;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
        setupAsLegendText(this.leftDescriptionTextView);
        setupAsLegendText(this.rightDescriptionTextView);
        this.commentField.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        this.wasCommentFieldFocused = false;
        createSmileyIcons();
        QuestionPointAnswer questionPointAnswerRestoreSelectedAnswer = restoreSelectedAnswer(savedState);
        this.selectedAnswer = questionPointAnswerRestoreSelectedAnswer;
        if (questionPointAnswerRestoreSelectedAnswer != null) {
            Intrinsics.checkNotNull(questionPointAnswerRestoreSelectedAnswer);
            updateSelectedAnswer(questionPointAnswerRestoreSelectedAnswer);
        }
        bindHeader();
        setDescriptionTexts();
        bindCommentField(savedState);
        setupScrollOnCommentFocus();
    }

    private final void createSmileyIcons() {
        removeOldIcons();
        constrainIcons(addIconViews());
    }

    private final void removeOldIcons() {
        Iterator<? extends Pair<? extends ImageView, String>> it = this.smileyOptions.iterator();
        while (it.hasNext()) {
            this.containerView.removeView(it.next().component1());
        }
        this.smileyOptions = CollectionsKt.emptyList();
    }

    private final int[] addIconViews() {
        List<QuestionPointAnswer> answers = getSurveyPoint().getAnswers();
        int size = answers.size();
        int dimensionPx = ViewExtensionsKt.getDimensionPx(this, C8369R.dimen.survicate_micro_question_smiley_scale_icon_size);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[answers.size()];
        int i = 0;
        for (QuestionPointAnswer questionPointAnswer : answers) {
            int i2 = i + 1;
            String possibleAnswer = questionPointAnswer.getPossibleAnswer();
            if (possibleAnswer == null) {
                possibleAnswer = "";
            }
            ImageView imageViewCreateSmileyImageView = createSmileyImageView(possibleAnswer, size, questionPointAnswer);
            this.containerView.addView(imageViewCreateSmileyImageView, new ConstraintLayout.LayoutParams(dimensionPx, dimensionPx));
            arrayList.add(TuplesKt.m1606to(imageViewCreateSmileyImageView, possibleAnswer));
            iArr[i] = imageViewCreateSmileyImageView.getId();
            i = i2;
        }
        this.smileyOptions = arrayList;
        return iArr;
    }

    private final ImageView createSmileyImageView(String possibleAnswer, int answerCount, final QuestionPointAnswer answer) {
        SmileyScaleStyle scaleStyle = getSurveyPointSettings().getScaleStyle();
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setId(FrameLayout.generateViewId());
        appCompatImageView.setFocusable(true);
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        appCompatImageView.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(microDrawableFactory, context, 0.0f, 2, null));
        appCompatImageView.setImageResource(SmileyScaleUtils.INSTANCE.getDrawableRes(possibleAnswer, answerCount, scaleStyle.getType()));
        appCompatImageView.setColorFilter(SmileyScaleUtils.INSTANCE.createScaleStyleColorFilter(scaleStyle.getType(), scaleStyle.getColor()));
        SmileyScaleUtils smileyScaleUtils = SmileyScaleUtils.INSTANCE;
        Context context2 = appCompatImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        appCompatImageView.setContentDescription(smileyScaleUtils.getContentDescription(context2, possibleAnswer));
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onAnswerSelected(answer);
            }
        });
        return appCompatImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void constrainIcons(int[] iconIds) {
        boolean z;
        if (!SmileyScaleUtils.INSTANCE.isThreeOptionsSmileyScale(getSurveyPoint().getAnswers().size())) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            z = ScreenUtils.isWideScreen(resources);
        }
        MicroSurveyPointSmileyScaleContentView microSurveyPointSmileyScaleContentView = this;
        int dimensionPx = ViewExtensionsKt.getDimensionPx(microSurveyPointSmileyScaleContentView, C8369R.dimen.f2254x89bcd39e);
        int dimensionPx2 = z ? ViewExtensionsKt.getDimensionPx(microSurveyPointSmileyScaleContentView, C8369R.dimen.survicate_micro_question_smiley_scale_spacing_between_icons) : 0;
        int i = z ? 2 : 1;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.containerView);
        constrainIconPositions(constraintSet, iconIds, dimensionPx, dimensionPx2, i);
        constrainLegendBelowIcons(constraintSet, iconIds);
        constraintSet.applyTo(this.containerView);
    }

    private final void constrainIconPositions(ConstraintSet constraintSet, int[] iconIds, int iconTopMargin, int iconSpacing, int chainStyle) {
        int i = C8369R.id.view_micro_survey_point_smiley_content_header;
        int length = iconIds.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iconIds[i2];
            ConstraintSet constraintSet2 = constraintSet;
            constraintSet2.connect(i3, 3, i, 4, iconTopMargin);
            constraintSet2.setMargin(i3, 6, iconSpacing);
            constraintSet2.setMargin(i3, 7, iconSpacing);
            i2++;
            constraintSet = constraintSet2;
        }
        constrainHorizontalChain(constraintSet, iconIds, chainStyle);
    }

    private final void constrainHorizontalChain(ConstraintSet constraintSet, int[] iconIds, int chainStyle) {
        int length = iconIds.length;
        int i = 0;
        while (i < length) {
            int i2 = 6;
            constraintSet.connect(iconIds[i], 6, i == 0 ? 0 : iconIds[i - 1], i == 0 ? 6 : 7);
            int i3 = i == ArraysKt.getLastIndex(iconIds) ? 0 : iconIds[i + 1];
            if (i == ArraysKt.getLastIndex(iconIds)) {
                i2 = 7;
            }
            constraintSet.connect(iconIds[i], 7, i3, i2);
            i++;
        }
        if (iconIds.length == 0) {
            return;
        }
        constraintSet.setHorizontalChainStyle(iconIds[0], chainStyle);
    }

    private final void constrainLegendBelowIcons(ConstraintSet constraintSet, int[] iconIds) {
        constraintSet.createBarrier(this.barrierId, 3, 0, Arrays.copyOf(iconIds, iconIds.length));
        constraintSet.connect(C8369R.id.view_micro_survey_point_smiley_content_legend, 3, this.barrierId, 4);
    }

    private final QuestionPointAnswer restoreSelectedAnswer(Bundle savedState) {
        Long selectedAnswerId;
        SavedState savedState2 = readSavedState(savedState);
        Object obj = null;
        if (savedState2 == null || (selectedAnswerId = savedState2.getSelectedAnswerId()) == null) {
            return null;
        }
        long jLongValue = selectedAnswerId.longValue();
        Iterator<T> it = getSurveyPoint().getAnswers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((QuestionPointAnswer) next).getId() == jLongValue) {
                obj = next;
                break;
            }
        }
        return (QuestionPointAnswer) obj;
    }

    private final String restoreComment(Bundle savedState) {
        SavedState savedState2 = readSavedState(savedState);
        String commentFieldText = savedState2 != null ? savedState2.getCommentFieldText() : null;
        return commentFieldText == null ? "" : commentFieldText;
    }

    private final void bindHeader() {
        MicroQuestionHeader microQuestionHeader = this.questionHeaderView;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        microQuestionHeader.bindData(bindingData.getQuestionHeaderBindingData());
    }

    private final void setDescriptionTexts() {
        TextView textView = this.leftDescriptionTextView;
        String leftText = getSurveyPointSettings().getLeftText();
        if (leftText == null) {
            leftText = "";
        }
        textView.setText(leftText);
        TextView textView2 = this.leftDescriptionTextView;
        String leftText2 = getSurveyPointSettings().getLeftText();
        boolean z = true;
        textView2.setVisibility(!(leftText2 == null || StringsKt.isBlank(leftText2)) ? 0 : 8);
        TextView textView3 = this.rightDescriptionTextView;
        String rightText = getSurveyPointSettings().getRightText();
        textView3.setText(rightText != null ? rightText : "");
        TextView textView4 = this.rightDescriptionTextView;
        String rightText2 = getSurveyPointSettings().getRightText();
        if (rightText2 != null && !StringsKt.isBlank(rightText2)) {
            z = false;
        }
        textView4.setVisibility(z ? 8 : 0);
    }

    private final void bindCommentField(Bundle savedState) {
        this.commentFieldText = restoreComment(savedState);
        MicroSurvicateCommentField microSurvicateCommentField = this.commentField;
        String commentLabel = getSurveyPointSettings().getCommentLabel();
        if (commentLabel == null) {
            commentLabel = "";
        }
        microSurvicateCommentField.setLabel(commentLabel);
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        String commentHint = bindingData.getCommentHint();
        if (commentHint.length() == 0) {
            commentHint = getResources().getString(C8369R.string.survicate_input_text_placeholder);
            Intrinsics.checkNotNullExpressionValue(commentHint, "getString(...)");
        }
        this.commentField.setInputHint(commentHint);
        this.commentField.setVisibility(isCommentAvailable() && restoreSelectedAnswer(savedState) != null ? 0 : 8);
        this.commentField.bindTextInput(this.commentFieldText, new C84631(this));
        this.commentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointSmileyScaleContentView.bindCommentField$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$bindCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84631 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C84631(Object obj) {
            super(1, obj, MicroSurveyPointSmileyScaleContentView.class, "onCommentChanged", "onCommentChanged(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MicroSurveyPointSmileyScaleContentView) this.receiver).onCommentChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$4(MicroSurveyPointSmileyScaleContentView microSurveyPointSmileyScaleContentView) {
        microSurveyPointSmileyScaleContentView.wasCommentFieldFocused = true;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnswerSelected(QuestionPointAnswer questionPointAnswer) {
        updateSelectedAnswer(questionPointAnswer);
        if (isCommentAvailable()) {
            showCommentField();
        }
        Function1<? super Long, Unit> function1 = this.onAnswerSelected;
        if (function1 != null) {
            function1.invoke(Long.valueOf(questionPointAnswer.getId()));
        }
    }

    private final void updateSelectedAnswer(QuestionPointAnswer answer) {
        Object next;
        Object next2;
        QuestionPointAnswer questionPointAnswer = this.selectedAnswer;
        if (questionPointAnswer != null) {
            Iterator<T> it = this.smileyOptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                } else {
                    next2 = it.next();
                    if (Intrinsics.areEqual(((Pair) next2).getSecond(), questionPointAnswer.getPossibleAnswer())) {
                        break;
                    }
                }
            }
            Pair pair = (Pair) next2;
            ImageView imageView = pair != null ? (ImageView) pair.getFirst() : null;
            if (imageView != null) {
                setScale(imageView, 1.0f);
            }
            if (imageView != null) {
                imageView.setSelected(false);
            }
        }
        Iterator<T> it2 = this.smileyOptions.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual(((Pair) next).getSecond(), answer.getPossibleAnswer())) {
                    break;
                }
            }
        }
        Pair pair2 = (Pair) next;
        ImageView imageView2 = pair2 != null ? (ImageView) pair2.getFirst() : null;
        if (imageView2 != null) {
            setScale(imageView2, SELECTED_ICON_SCALE);
        }
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
        this.selectedAnswer = answer;
    }

    private final boolean isCommentAvailable() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.isCommentAvailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCommentChanged(String text) {
        this.commentFieldText = text;
        Function1<? super String, Unit> function1 = this.onCommentChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$showCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$showCommentField$1", m1609f = "MicroSurveyPointSmileyScaleContentView.kt", m1610i = {}, m1611l = {284}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84651(Continuation<? super C84651> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MicroSurveyPointSmileyScaleContentView.this.new C84651(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MicroSurveyPointSmileyScaleContentView.this.commentField.setVisibility(0);
                MicroSurveyPointSmileyScaleContentView.this.commentField.clearInputFocus();
                MicroSurveyPointSmileyScaleContentView.this.wasCommentFieldFocused = false;
                this.label = 1;
                if (MicroSurveyPointSmileyScaleContentView.this.scrollToCommentField(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Job showCommentField() {
        LifecycleCoroutineScope lifecycleScope;
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return null;
        }
        return BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new C84651(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollToCommentField(Continuation<? super Unit> continuation) {
        C84641 c84641;
        if (continuation instanceof C84641) {
            c84641 = (C84641) continuation;
            if ((c84641.label & Integer.MIN_VALUE) != 0) {
                c84641.label -= Integer.MIN_VALUE;
            } else {
                c84641 = new C84641(continuation);
            }
        }
        Object obj = c84641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84641.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (AccessibilityUtils.isTalkbackEnabled(context)) {
                return Unit.INSTANCE;
            }
            c84641.label = 1;
            if (DelayKt.delay(250L, c84641) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.commentField.scrollTo();
        return Unit.INSTANCE;
    }

    private final void setupScrollOnCommentFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointSmileyScaleContentView.setupScrollOnCommentFocus$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$7(MicroSurveyPointSmileyScaleContentView microSurveyPointSmileyScaleContentView) {
        microSurveyPointSmileyScaleContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        if (this.wasCommentFieldFocused && this.commentField.isAttachedToWindow()) {
            this.commentField.scrollTo();
        }
    }

    private final void setScale(ImageView imageView, float f) {
        imageView.setScaleX(f);
        imageView.setScaleY(f);
    }

    private final void setupAsLegendText(TextView textView) {
        ViewDependencies viewDependencies = this.viewDependencies;
        ColorScheme colorScheme = null;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setTypeface(fontProvider.provideFont(context, FontType.REGULAR));
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme2;
        }
        textView.setTextColor(colorScheme.getAnswer());
    }

    /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "isCommentAvailable", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final String commentHint;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyQuestionSurveyPoint surveyPoint;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyQuestionSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 4) != 0) {
                str = bindingData.commentHint;
            }
            return bindingData.copy(surveyQuestionSurveyPoint, questionHeaderBindingData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyQuestionSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCommentHint() {
            return this.commentHint;
        }

        public final BindingData copy(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            return new BindingData(surveyPoint, questionHeaderBindingData, commentHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData) && Intrinsics.areEqual(this.commentHint, bindingData.commentHint);
        }

        public int hashCode() {
            return (((this.surveyPoint.hashCode() * 31) + this.questionHeaderBindingData.hashCode()) * 31) + this.commentHint.hashCode();
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ", commentHint=" + this.commentHint + ')';
        }

        public BindingData(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            this.surveyPoint = surveyPoint;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.commentHint = commentHint;
        }

        public final SurveyQuestionSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final String getCommentHint() {
            return this.commentHint;
        }

        public final boolean isCommentAvailable() {
            List<QuestionPointAnswer> answers = this.surveyPoint.getAnswers();
            if ((answers instanceof Collection) && answers.isEmpty()) {
                return false;
            }
            Iterator<T> it = answers.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual((Object) ((QuestionPointAnswer) it.next()).getAddingCommentAvailable(), (Object) true)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView$SavedState;", "Landroid/os/Parcelable;", "selectedAnswerId", "", "commentFieldText", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getSelectedAnswerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommentFieldText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView$SavedState;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final String commentFieldText;
        private final Long selectedAnswerId;

        /* JADX INFO: compiled from: MicroSurveyPointSmileyScaleContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public static /* synthetic */ SavedState copy$default(SavedState savedState, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = savedState.selectedAnswerId;
            }
            if ((i & 2) != 0) {
                str = savedState.commentFieldText;
            }
            return savedState.copy(l, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getSelectedAnswerId() {
            return this.selectedAnswerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCommentFieldText() {
            return this.commentFieldText;
        }

        public final SavedState copy(Long selectedAnswerId, String commentFieldText) {
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            return new SavedState(selectedAnswerId, commentFieldText);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SavedState)) {
                return false;
            }
            SavedState savedState = (SavedState) other;
            return Intrinsics.areEqual(this.selectedAnswerId, savedState.selectedAnswerId) && Intrinsics.areEqual(this.commentFieldText, savedState.commentFieldText);
        }

        public int hashCode() {
            Long l = this.selectedAnswerId;
            return ((l == null ? 0 : l.hashCode()) * 31) + this.commentFieldText.hashCode();
        }

        public String toString() {
            return "SavedState(selectedAnswerId=" + this.selectedAnswerId + ", commentFieldText=" + this.commentFieldText + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            Long l = this.selectedAnswerId;
            if (l == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeLong(l.longValue());
            }
            dest.writeString(this.commentFieldText);
        }

        public SavedState(Long l, String commentFieldText) {
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            this.selectedAnswerId = l;
            this.commentFieldText = commentFieldText;
        }

        public final Long getSelectedAnswerId() {
            return this.selectedAnswerId;
        }

        public final String getCommentFieldText() {
            return this.commentFieldText;
        }
    }

    private final SavedState readSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", SavedState.class);
        } else {
            Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
            parcelable = (SavedState) (parcelable2 instanceof SavedState ? parcelable2 : null);
        }
        return (SavedState) parcelable;
    }
}
