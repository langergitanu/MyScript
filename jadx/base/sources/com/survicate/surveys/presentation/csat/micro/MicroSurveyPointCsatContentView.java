package com.survicate.surveys.presentation.csat.micro;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.rating.csat.SurveyPointCsatSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.SurvicateViewUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 T2\u00020\u0001:\u0003TUVB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010:\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010;\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u00020\u0019H\u0002J\u0012\u0010?\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020AH\u0002J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010D\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010F\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0014\u0010G\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0014\u0010H\u001a\u0004\u0018\u00010I2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010J\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010K\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u000bH\u0002J\b\u0010M\u001a\u00020#H\u0002J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u000e\u0010P\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020\u0019H\u0002J\b\u0010S\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fH\u0002R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b09X\u0082.¢\u0006\u0002\n\u0000¨\u0006W"}, m1599d2 = {"Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "selectedAnswer", "getSelectedAnswer", "()Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "", "commentFieldText", "getCommentFieldText", "()Ljava/lang/String;", "onAnswerSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "answerId", "", "getOnAnswerSelected", "()Lkotlin/jvm/functions/Function1;", "setOnAnswerSelected", "(Lkotlin/jvm/functions/Function1;)V", "onCommentChanged", "text", "getOnCommentChanged", "setOnCommentChanged", "wasCommentFieldFocused", "", "bindingData", "Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView$BindingData;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "answerContainer", "Landroid/widget/LinearLayout;", "commentField", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "orderedAnswers", "", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "bindHeader", "setupList", "createAnswerItemView", "Landroid/view/View;", "answer", "setupAnswerItemView", "itemView", "bindAnswerItem", "rebindAnswerItem", "restoreSelectedAnswer", "readSavedState", "Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView$SavedState;", "bindCommentField", "restoreComment", "onAnswerItemClick", "isCommentAvailable", "showCommentField", "Lkotlinx/coroutines/Job;", "scrollToCommentField", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupScrollOnCommentFocus", "restoreCommentFocus", "Companion", "BindingData", "SavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointCsatContentView extends FrameLayout {
    public static final String SAVED_STATE = "SAVED_STATE";
    private static final long SHOW_COMMENT_DELAY = 250;
    private final LinearLayout answerContainer;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private final MicroSurvicateCommentField commentField;
    private String commentFieldText;
    private Function1<? super Long, Unit> onAnswerSelected;
    private Function1<? super String, Unit> onCommentChanged;
    private List<QuestionPointAnswer> orderedAnswers;
    private final MicroQuestionHeader questionHeaderView;
    private QuestionPointAnswer selectedAnswer;
    private ViewDependencies viewDependencies;
    private boolean wasCommentFieldFocused;

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$scrollToCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView", m1609f = "MicroSurveyPointCsatContentView.kt", m1610i = {}, m1611l = {PsExtractor.AUDIO_STREAM}, m1612m = "scrollToCommentField", m1613n = {}, m1615s = {})
    static final class C84291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84291(Continuation<? super C84291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MicroSurveyPointCsatContentView.this.scrollToCommentField(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCsatContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCsatContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointCsatContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCsatContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.commentFieldText = "";
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_csat_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_csat_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_csat_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.answerContainer = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_csat_content_comment_field);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.commentField = (MicroSurvicateCommentField) viewFindViewById3;
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

    private final SurveyPointCsatSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.rating.csat.SurveyPointCsatSettings");
        return (SurveyPointCsatSettings) settings;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
        this.commentField.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        this.wasCommentFieldFocused = false;
        bindHeader();
        setupList(savedState);
        bindCommentField(savedState);
        setupScrollOnCommentFocus();
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

    private final void setupList(Bundle savedState) {
        this.orderedAnswers = CollectionsKt.asReversed(getSurveyPoint().getAnswers());
        this.selectedAnswer = restoreSelectedAnswer(savedState);
        this.answerContainer.removeAllViews();
        List<QuestionPointAnswer> list = this.orderedAnswers;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderedAnswers");
            list = null;
        }
        Iterator<QuestionPointAnswer> it = list.iterator();
        while (it.hasNext()) {
            this.answerContainer.addView(createAnswerItemView(it.next()));
        }
    }

    private final View createAnswerItemView(QuestionPointAnswer answer) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_csat, (ViewGroup) this.answerContainer, false);
        Intrinsics.checkNotNull(viewInflate);
        setupAnswerItemView(viewInflate);
        bindAnswerItem(viewInflate, answer);
        return viewInflate;
    }

    private final void setupAnswerItemView(View itemView) {
        TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_csat_label);
        ViewDependencies viewDependencies = this.viewDependencies;
        ColorScheme colorScheme = null;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = itemView.getContext();
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

    private final void bindAnswerItem(View itemView, final QuestionPointAnswer answer) {
        TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_csat_label);
        boolean zAreEqual = Intrinsics.areEqual(this.selectedAnswer, answer);
        itemView.setSelected(zAreEqual);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        itemView.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, zAreEqual));
        textView.setText(answer.getPossibleAnswer());
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onAnswerItemClick(answer);
            }
        });
    }

    private final void rebindAnswerItem(QuestionPointAnswer answer) {
        List<QuestionPointAnswer> list = this.orderedAnswers;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderedAnswers");
            list = null;
        }
        View childAt = this.answerContainer.getChildAt(list.indexOf(answer));
        if (childAt == null) {
            return;
        }
        bindAnswerItem(childAt, answer);
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
        this.commentField.bindTextInput(this.commentFieldText, new C84281(this));
        this.commentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointCsatContentView.bindCommentField$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$bindCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84281 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C84281(Object obj) {
            super(1, obj, MicroSurveyPointCsatContentView.class, "onCommentChanged", "onCommentChanged(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MicroSurveyPointCsatContentView) this.receiver).onCommentChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$3(MicroSurveyPointCsatContentView microSurveyPointCsatContentView) {
        microSurveyPointCsatContentView.wasCommentFieldFocused = true;
        return Unit.INSTANCE;
    }

    private final String restoreComment(Bundle savedState) {
        SavedState savedState2 = readSavedState(savedState);
        String commentFieldText = savedState2 != null ? savedState2.getCommentFieldText() : null;
        return commentFieldText == null ? "" : commentFieldText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnswerItemClick(QuestionPointAnswer answer) {
        QuestionPointAnswer questionPointAnswer = this.selectedAnswer;
        this.selectedAnswer = answer;
        if (questionPointAnswer != null) {
            rebindAnswerItem(questionPointAnswer);
        }
        rebindAnswerItem(answer);
        if (isCommentAvailable()) {
            showCommentField();
        }
        Function1<? super Long, Unit> function1 = this.onAnswerSelected;
        if (function1 != null) {
            function1.invoke(Long.valueOf(answer.getId()));
        }
    }

    private final boolean isCommentAvailable() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.isCommentAvailable();
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$showCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$showCommentField$1", m1609f = "MicroSurveyPointCsatContentView.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_1}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84301(Continuation<? super C84301> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MicroSurveyPointCsatContentView.this.new C84301(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MicroSurveyPointCsatContentView.this.commentField.setVisibility(0);
                MicroSurveyPointCsatContentView.this.commentField.clearInputFocus();
                MicroSurveyPointCsatContentView.this.wasCommentFieldFocused = false;
                this.label = 1;
                if (MicroSurveyPointCsatContentView.this.scrollToCommentField(this) == coroutine_suspended) {
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
        return BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new C84301(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollToCommentField(Continuation<? super Unit> continuation) {
        C84291 c84291;
        if (continuation instanceof C84291) {
            c84291 = (C84291) continuation;
            if ((c84291.label & Integer.MIN_VALUE) != 0) {
                c84291.label -= Integer.MIN_VALUE;
            } else {
                c84291 = new C84291(continuation);
            }
        }
        Object obj = c84291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84291.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (AccessibilityUtils.isTalkbackEnabled(context)) {
                return Unit.INSTANCE;
            }
            c84291.label = 1;
            if (DelayKt.delay(250L, c84291) == coroutine_suspended) {
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
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointCsatContentView.setupScrollOnCommentFocus$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$4(MicroSurveyPointCsatContentView microSurveyPointCsatContentView) {
        microSurveyPointCsatContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        if (this.wasCommentFieldFocused && this.commentField.isAttachedToWindow()) {
            this.commentField.scrollTo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCommentChanged(String text) {
        this.commentFieldText = text;
        Function1<? super String, Unit> function1 = this.onCommentChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "isCommentAvailable", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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

    /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView$SavedState;", "Landroid/os/Parcelable;", "selectedAnswerId", "", "commentFieldText", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getSelectedAnswerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommentFieldText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView$SavedState;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final String commentFieldText;
        private final Long selectedAnswerId;

        /* JADX INFO: compiled from: MicroSurveyPointCsatContentView.kt */
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
