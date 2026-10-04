package com.survicate.surveys.presentation.nps.micro;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.models.SurvicateNpsAnswerOption;
import com.survicate.surveys.entities.survey.questions.nps.AnswerLayout;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.nps.micro.MicroNpsUtils;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.ScreenUtils;
import com.survicate.surveys.utils.SurvicateViewUtils;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
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

/* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 m2\u00020\u0001:\u0003mnoB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010@\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0018\u0010A\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u00020\u0018H\u0002J\u0012\u0010E\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010F\u001a\u00020\u0018H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020\u0018H\u0002J\b\u0010I\u001a\u00020\u0018H\u0002J&\u0010J\u001a\u0002032\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u00020=2\u0006\u0010Q\u001a\u00020\u000bH\u0002J\u0010\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020=H\u0002J\u0018\u0010T\u001a\u00020\u00182\u0006\u0010S\u001a\u00020=2\u0006\u0010Q\u001a\u00020\u000bH\u0002J\u0010\u0010U\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u000bH\u0002J\u0010\u0010V\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u000bH\u0002J\b\u0010W\u001a\u00020\u0018H\u0002J\u0012\u0010X\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010Y\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010Z\u001a\u00020?H\u0002J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u000e\u0010]\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\u0018H\u0002J\b\u0010`\u001a\u00020\u0018H\u0002J\u0010\u0010a\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010b\u001a\u00020:H\u0002J\b\u0010c\u001a\u00020\u0007H\u0002J\u0014\u0010d\u001a\u0004\u0018\u00010\u000b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0014\u0010e\u001a\u0004\u0018\u00010f2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010g\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000bH\u0002J\f\u0010h\u001a\u00020\u0018*\u000205H\u0002J\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020lH\u0002R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR7\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006p"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "selectedAnswer", "getSelectedAnswer", "()Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "", "commentFieldText", "getCommentFieldText", "()Ljava/lang/String;", "onAnswerSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "option", "", "getOnAnswerSelected", "()Lkotlin/jvm/functions/Function1;", "setOnAnswerSelected", "(Lkotlin/jvm/functions/Function1;)V", "onCommentChanged", "text", "getOnCommentChanged", "setOnCommentChanged", "bindingData", "Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$BindingData;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "answersHost", "answerContainer", "Landroid/widget/LinearLayout;", "leftDescriptionTextView", "Landroid/widget/TextView;", "rightDescriptionTextView", "commentField", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "answerStyle", "Lcom/survicate/surveys/presentation/nps/micro/NpsAnswerStyle;", "answerItemViews", "", "Landroid/view/View;", "wasCommentFieldFocused", "", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "bindHeader", "setupList", "inflateAnswerContainer", "setupVerticalItems", "setupHorizontalItems", "setupPortraitHorizontalItems", "createPortraitRow", FirebaseAnalytics.Param.ITEMS, "", "itemMetrics", "Lcom/survicate/surveys/presentation/nps/micro/MicroNpsUtils$NpsItemMetrics;", "rowStartIndent", "createAnswerItemView", "answer", "setupAnswerItemView", "itemView", "bindAnswerItem", "rebindAnswerItem", "onAnswerItemClick", "bindDescriptionTexts", "bindCommentField", "restoreComment", "isCommentAvailable", "showCommentField", "Lkotlinx/coroutines/Job;", "scrollToCommentField", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupScrollOnCommentFocus", "restoreCommentFocus", "onCommentTextChanged", "resolveAnswerStyle", "resolveScreenWidth", "restoreSelectedAnswer", "readSavedState", "Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$SavedState;", "getLabelTextWithDescription", "setupAsLegendText", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "Companion", "BindingData", "SavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointNpsContentView extends FrameLayout {
    private static final int PORTRAIT_TOP_ROW_SIZE = 6;
    public static final String SAVED_STATE = "SAVED_STATE";
    private static final long SHOW_COMMENT_DELAY = 250;
    private LinearLayout answerContainer;
    private final Map<SurvicateNpsAnswerOption, View> answerItemViews;
    private NpsAnswerStyle answerStyle;
    private final FrameLayout answersHost;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private final MicroSurvicateCommentField commentField;
    private String commentFieldText;
    private final TextView leftDescriptionTextView;
    private Function1<? super SurvicateNpsAnswerOption, Unit> onAnswerSelected;
    private Function1<? super String, Unit> onCommentChanged;
    private final MicroQuestionHeader questionHeaderView;
    private final TextView rightDescriptionTextView;
    private SurvicateNpsAnswerOption selectedAnswer;
    private ViewDependencies viewDependencies;
    private boolean wasCommentFieldFocused;

    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NpsAnswerStyle.values().length];
            try {
                iArr[NpsAnswerStyle.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NpsAnswerStyle.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NpsAnswerStyle.PortraitHorizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SurvicateNpsAnswerOption.values().length];
            try {
                iArr2[SurvicateNpsAnswerOption.Zero.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SurvicateNpsAnswerOption.Ten.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$scrollToCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView", m1609f = "MicroSurveyPointNpsContentView.kt", m1610i = {}, m1611l = {310}, m1612m = "scrollToCommentField", m1613n = {}, m1615s = {})
    static final class C84461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C84461(Continuation<? super C84461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MicroSurveyPointNpsContentView.this.scrollToCommentField(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointNpsContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointNpsContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointNpsContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointNpsContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.commentFieldText = "";
        this.answerItemViews = new LinkedHashMap();
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_nps_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_nps_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_nps_content_answers_host);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.answersHost = (FrameLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_question_legend_label_left);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.leftDescriptionTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_question_legend_label_right);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.rightDescriptionTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_nps_content_comment_field);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.commentField = (MicroSurvicateCommentField) viewFindViewById5;
    }

    public final SurvicateNpsAnswerOption getSelectedAnswer() {
        return this.selectedAnswer;
    }

    public final String getCommentFieldText() {
        return this.commentFieldText;
    }

    public final Function1<SurvicateNpsAnswerOption, Unit> getOnAnswerSelected() {
        return this.onAnswerSelected;
    }

    public final void setOnAnswerSelected(Function1<? super SurvicateNpsAnswerOption, Unit> function1) {
        this.onAnswerSelected = function1;
    }

    public final Function1<String, Unit> getOnCommentChanged() {
        return this.onCommentChanged;
    }

    public final void setOnCommentChanged(Function1<? super String, Unit> function1) {
        this.onCommentChanged = function1;
    }

    private final SurveyNpsSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyNpsPointSettings getSurveyPointSettings() {
        return getSurveyPoint().getSettings();
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
        this.commentField.inject(viewDependencies, colorScheme);
        setupAsLegendText(this.leftDescriptionTextView);
        setupAsLegendText(this.rightDescriptionTextView);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        this.wasCommentFieldFocused = false;
        bindHeader();
        setupList(savedState);
        bindDescriptionTexts();
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
        this.answerStyle = resolveAnswerStyle();
        this.selectedAnswer = restoreSelectedAnswer(savedState);
        inflateAnswerContainer();
        this.answerItemViews.clear();
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[npsAnswerStyle.ordinal()];
        if (i == 1) {
            setupVerticalItems();
        } else if (i == 2) {
            setupHorizontalItems();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            setupPortraitHorizontalItems();
        }
    }

    private final void inflateAnswerContainer() {
        int i;
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[npsAnswerStyle.ordinal()];
        if (i2 == 1) {
            i = C8369R.layout.view_micro_survey_point_nps_answers_vertical;
        } else if (i2 == 2) {
            i = C8369R.layout.view_micro_survey_point_nps_answers_horizontal;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = C8369R.layout.view_micro_survey_point_nps_answers_portrait_horizontal;
        }
        this.answersHost.removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.answersHost, true);
        this.answerContainer = (LinearLayout) this.answersHost.findViewById(C8369R.id.view_micro_survey_point_nps_content_container);
    }

    private final void setupVerticalItems() {
        for (SurvicateNpsAnswerOption survicateNpsAnswerOption : CollectionsKt.reversed(SurvicateNpsAnswerOption.getEntries())) {
            View viewCreateAnswerItemView = createAnswerItemView(survicateNpsAnswerOption);
            LinearLayout linearLayout = this.answerContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("answerContainer");
                linearLayout = null;
            }
            linearLayout.addView(viewCreateAnswerItemView);
            this.answerItemViews.put(survicateNpsAnswerOption, viewCreateAnswerItemView);
        }
    }

    private final void setupHorizontalItems() {
        EnumEntries<SurvicateNpsAnswerOption> entries = SurvicateNpsAnswerOption.getEntries();
        int dimensionPx = ViewExtensionsKt.getDimensionPx(this, C8369R.dimen.survicate_micro_question_nps_horizontal_item_spacing) / 2;
        int i = 0;
        for (SurvicateNpsAnswerOption survicateNpsAnswerOption : entries) {
            int i2 = i + 1;
            View viewCreateAnswerItemView = createAnswerItemView(survicateNpsAnswerOption);
            int i3 = i == 0 ? 0 : dimensionPx;
            int i4 = i == CollectionsKt.getLastIndex(entries) ? 0 : dimensionPx;
            ViewGroup.LayoutParams layoutParams = viewCreateAnswerItemView.getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                LinearLayout.LayoutParams layoutParams3 = layoutParams2;
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                layoutParams3.setMarginStart(i3);
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = i5;
                layoutParams3.setMarginEnd(i4);
                ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = i6;
                viewCreateAnswerItemView.setLayoutParams(layoutParams2);
                LinearLayout linearLayout = this.answerContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("answerContainer");
                    linearLayout = null;
                }
                linearLayout.addView(viewCreateAnswerItemView);
                this.answerItemViews.put(survicateNpsAnswerOption, viewCreateAnswerItemView);
                i = i2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
        }
    }

    private final void setupPortraitHorizontalItems() {
        MicroNpsUtils microNpsUtils = MicroNpsUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroNpsUtils.NpsItemMetrics npsItemMetricsComputePortraitHorizontalSizes = microNpsUtils.computePortraitHorizontalSizes(context, resolveScreenWidth());
        EnumEntries<SurvicateNpsAnswerOption> entries = SurvicateNpsAnswerOption.getEntries();
        List<SurvicateNpsAnswerOption> listSubList = entries.subList(0, 6);
        List<SurvicateNpsAnswerOption> listSubList2 = entries.subList(6, entries.size());
        int itemSizePx = (npsItemMetricsComputePortraitHorizontalSizes.getItemSizePx() + npsItemMetricsComputePortraitHorizontalSizes.getInnerSpacingPx()) / 2;
        LinearLayout linearLayoutCreatePortraitRow = createPortraitRow(listSubList, npsItemMetricsComputePortraitHorizontalSizes, 0);
        LinearLayout linearLayoutCreatePortraitRow2 = createPortraitRow(listSubList2, npsItemMetricsComputePortraitHorizontalSizes, itemSizePx);
        LinearLayout linearLayout = linearLayoutCreatePortraitRow;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = npsItemMetricsComputePortraitHorizontalSizes.getInnerSpacingPx();
            linearLayout.setLayoutParams(layoutParams2);
            LinearLayout linearLayout2 = linearLayoutCreatePortraitRow2;
            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
            if (layoutParams3 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                layoutParams4.bottomMargin = npsItemMetricsComputePortraitHorizontalSizes.getInnerSpacingPx();
                linearLayout2.setLayoutParams(layoutParams4);
                LinearLayout linearLayout3 = this.answerContainer;
                LinearLayout linearLayout4 = null;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("answerContainer");
                    linearLayout3 = null;
                }
                linearLayout3.addView(linearLayout);
                LinearLayout linearLayout5 = this.answerContainer;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("answerContainer");
                } else {
                    linearLayout4 = linearLayout5;
                }
                linearLayout4.addView(linearLayout2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final LinearLayout createPortraitRow(List<? extends SurvicateNpsAnswerOption> items, MicroNpsUtils.NpsItemMetrics itemMetrics, int rowStartIndent) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int i = 0;
        for (SurvicateNpsAnswerOption survicateNpsAnswerOption : items) {
            int i2 = i + 1;
            View viewCreateAnswerItemView = createAnswerItemView(survicateNpsAnswerOption);
            NpsAnswerStyle npsAnswerStyle = this.answerStyle;
            if (npsAnswerStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
                npsAnswerStyle = null;
            }
            TextView textView = (TextView) viewCreateAnswerItemView.findViewById(npsAnswerStyle.getItemTemplate().getLabelId());
            Intrinsics.checkNotNull(textView);
            TextView textView2 = textView;
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = itemMetrics.getItemSizePx();
                layoutParams.height = itemMetrics.getItemSizePx();
                textView2.setLayoutParams(layoutParams);
                int innerSpacingPx = i == 0 ? rowStartIndent : itemMetrics.getInnerSpacingPx();
                ViewGroup.LayoutParams layoutParams2 = viewCreateAnswerItemView.getLayoutParams();
                if (layoutParams2 != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                    LinearLayout.LayoutParams layoutParams4 = layoutParams3;
                    int i3 = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
                    layoutParams4.setMarginStart(innerSpacingPx);
                    ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = i3;
                    layoutParams4.setMarginEnd(0);
                    ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i4;
                    viewCreateAnswerItemView.setLayoutParams(layoutParams3);
                    linearLayout.addView(viewCreateAnswerItemView);
                    this.answerItemViews.put(survicateNpsAnswerOption, viewCreateAnswerItemView);
                    i = i2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        return linearLayout;
    }

    private final View createAnswerItemView(SurvicateNpsAnswerOption answer) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        LinearLayout linearLayout = null;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        int layoutRes = npsAnswerStyle.getItemTemplate().getLayoutRes();
        LinearLayout linearLayout2 = this.answerContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerContainer");
        } else {
            linearLayout = linearLayout2;
        }
        View viewInflate = layoutInflaterFrom.inflate(layoutRes, (ViewGroup) linearLayout, false);
        Intrinsics.checkNotNull(viewInflate);
        setupAnswerItemView(viewInflate);
        bindAnswerItem(viewInflate, answer);
        return viewInflate;
    }

    private final void setupAnswerItemView(View itemView) {
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        ColorScheme colorScheme = null;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        TextView textView = (TextView) itemView.findViewById(npsAnswerStyle.getItemTemplate().getLabelId());
        textView.setTypeface(provideFont(FontType.REGULAR));
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme2;
        }
        textView.setTextColor(colorScheme.getAnswer());
    }

    private final void bindAnswerItem(View itemView, final SurvicateNpsAnswerOption answer) {
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        ColorScheme colorScheme = null;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        NpsAnswerItemTemplate itemTemplate = npsAnswerStyle.getItemTemplate();
        TextView textView = (TextView) itemView.findViewById(itemTemplate.getLabelId());
        boolean z = this.selectedAnswer == answer;
        itemView.setSelected(z);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme2;
        }
        itemView.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, z));
        if (itemTemplate.getUseContentDescriptionForLabel()) {
            textView.setText(String.valueOf(answer.getValue()));
            textView.setContentDescription(getLabelTextWithDescription(answer));
        } else {
            textView.setText(getLabelTextWithDescription(answer));
        }
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onAnswerItemClick(answer);
            }
        });
    }

    private final void rebindAnswerItem(SurvicateNpsAnswerOption answer) {
        View view = this.answerItemViews.get(answer);
        if (view == null) {
            return;
        }
        bindAnswerItem(view, answer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnswerItemClick(SurvicateNpsAnswerOption answer) {
        SurvicateNpsAnswerOption survicateNpsAnswerOption = this.selectedAnswer;
        this.selectedAnswer = answer;
        if (survicateNpsAnswerOption != null) {
            rebindAnswerItem(survicateNpsAnswerOption);
        }
        rebindAnswerItem(answer);
        if (isCommentAvailable()) {
            showCommentField();
        }
        Function1<? super SurvicateNpsAnswerOption, Unit> function1 = this.onAnswerSelected;
        if (function1 != null) {
            function1.invoke(answer);
        }
    }

    private final void bindDescriptionTexts() {
        NpsAnswerStyle npsAnswerStyle = this.answerStyle;
        NpsAnswerStyle npsAnswerStyle2 = null;
        if (npsAnswerStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
            npsAnswerStyle = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String textOnTheLeft = getSurveyPointSettings().getTextOnTheLeft();
        if (textOnTheLeft == null) {
            textOnTheLeft = "";
        }
        TextViewExtensionsKt.setTextOrHide(this.leftDescriptionTextView, npsAnswerStyle.getLeftDescription(context, textOnTheLeft));
        NpsAnswerStyle npsAnswerStyle3 = this.answerStyle;
        if (npsAnswerStyle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("answerStyle");
        } else {
            npsAnswerStyle2 = npsAnswerStyle3;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String textOnTheRight = getSurveyPointSettings().getTextOnTheRight();
        TextViewExtensionsKt.setTextOrHide(this.rightDescriptionTextView, npsAnswerStyle2.getRightDescription(context2, textOnTheRight != null ? textOnTheRight : ""));
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
        this.commentField.bindTextInput(this.commentFieldText, new C84451(this));
        this.commentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointNpsContentView.bindCommentField$lambda$8(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$bindCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84451 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C84451(Object obj) {
            super(1, obj, MicroSurveyPointNpsContentView.class, "onCommentTextChanged", "onCommentTextChanged(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MicroSurveyPointNpsContentView) this.receiver).onCommentTextChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$8(MicroSurveyPointNpsContentView microSurveyPointNpsContentView) {
        microSurveyPointNpsContentView.wasCommentFieldFocused = true;
        return Unit.INSTANCE;
    }

    private final String restoreComment(Bundle savedState) {
        SavedState savedState2 = readSavedState(savedState);
        String commentFieldText = savedState2 != null ? savedState2.getCommentFieldText() : null;
        return commentFieldText == null ? "" : commentFieldText;
    }

    private final boolean isCommentAvailable() {
        return getSurveyPointSettings().getAddComment();
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$showCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$showCommentField$1", m1609f = "MicroSurveyPointNpsContentView.kt", m1610i = {}, m1611l = {AIContainerViewModel.SUMMARIZE_MIN_LIMIT}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84471(Continuation<? super C84471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MicroSurveyPointNpsContentView.this.new C84471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MicroSurveyPointNpsContentView.this.commentField.setVisibility(0);
                MicroSurveyPointNpsContentView.this.commentField.clearInputFocus();
                MicroSurveyPointNpsContentView.this.wasCommentFieldFocused = false;
                this.label = 1;
                if (MicroSurveyPointNpsContentView.this.scrollToCommentField(this) == coroutine_suspended) {
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
        return BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new C84471(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scrollToCommentField(Continuation<? super Unit> continuation) {
        C84461 c84461;
        if (continuation instanceof C84461) {
            c84461 = (C84461) continuation;
            if ((c84461.label & Integer.MIN_VALUE) != 0) {
                c84461.label -= Integer.MIN_VALUE;
            } else {
                c84461 = new C84461(continuation);
            }
        }
        Object obj = c84461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c84461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (AccessibilityUtils.isTalkbackEnabled(context)) {
                return Unit.INSTANCE;
            }
            c84461.label = 1;
            if (DelayKt.delay(250L, c84461) == coroutine_suspended) {
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
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointNpsContentView.setupScrollOnCommentFocus$lambda$9(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$9(MicroSurveyPointNpsContentView microSurveyPointNpsContentView) {
        microSurveyPointNpsContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        if (this.wasCommentFieldFocused && this.commentField.isAttachedToWindow()) {
            this.commentField.scrollTo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCommentTextChanged(String text) {
        this.commentFieldText = text;
        Function1<? super String, Unit> function1 = this.onCommentChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
    }

    private final NpsAnswerStyle resolveAnswerStyle() {
        AnswerLayout answersLayout = getSurveyPointSettings().getAnswersLayout();
        if (answersLayout == null) {
            answersLayout = AnswerLayout.Default;
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return NpsAnswerStyle.INSTANCE.fromLayoutAndScreenWidth(answersLayout, ScreenUtils.isWideScreen(resources));
    }

    private final int resolveScreenWidth() {
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ScreenUtils.getScreenWidth((WindowManager) systemService);
    }

    private final SurvicateNpsAnswerOption restoreSelectedAnswer(Bundle savedState) {
        SavedState savedState2 = readSavedState(savedState);
        if (savedState2 != null) {
            return savedState2.getSelectedAnswer();
        }
        return null;
    }

    private final String getLabelTextWithDescription(SurvicateNpsAnswerOption answer) {
        String str;
        String str2;
        String textOnTheRight;
        String str3;
        String strValueOf = String.valueOf(answer.getValue());
        SurveyNpsPointSettings surveyPointSettings = getSurveyPointSettings();
        int i = WhenMappings.$EnumSwitchMapping$1[answer.ordinal()];
        if (i == 1) {
            String textOnTheLeft = surveyPointSettings.getTextOnTheLeft();
            if (textOnTheLeft != null) {
                str = StringsKt.isBlank(textOnTheLeft) ? null : textOnTheLeft;
                if (str != null && (str2 = strValueOf + " - " + str) != null) {
                    return str2;
                }
            }
        } else if (i == 2 && (textOnTheRight = surveyPointSettings.getTextOnTheRight()) != null) {
            str = StringsKt.isBlank(textOnTheRight) ? null : textOnTheRight;
            if (str != null && (str3 = strValueOf + " - " + str) != null) {
                return str3;
            }
        }
        return strValueOf;
    }

    private final void setupAsLegendText(TextView textView) {
        textView.setTypeface(provideFont(FontType.REGULAR));
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        textView.setTextColor(colorScheme.getAnswer());
    }

    private final Typeface provideFont(FontType fontType) {
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return fontProvider.provideFont(context, fontType);
    }

    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final String commentHint;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyNpsSurveyPoint surveyPoint;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyNpsSurveyPoint surveyNpsSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyNpsSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 4) != 0) {
                str = bindingData.commentHint;
            }
            return bindingData.copy(surveyNpsSurveyPoint, questionHeaderBindingData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyNpsSurveyPoint getSurveyPoint() {
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

        public final BindingData copy(SurveyNpsSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
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

        public BindingData(SurveyNpsSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            this.surveyPoint = surveyPoint;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.commentHint = commentHint;
        }

        public final SurveyNpsSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final String getCommentHint() {
            return this.commentHint;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$SavedState;", "Landroid/os/Parcelable;", "selectedAnswer", "Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "commentFieldText", "", "<init>", "(Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;Ljava/lang/String;)V", "getSelectedAnswer", "()Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "getCommentFieldText", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final String commentFieldText;
        private final SurvicateNpsAnswerOption selectedAnswer;

        /* JADX INFO: compiled from: MicroSurveyPointNpsContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(parcel.readInt() == 0 ? null : SurvicateNpsAnswerOption.valueOf(parcel.readString()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public static /* synthetic */ SavedState copy$default(SavedState savedState, SurvicateNpsAnswerOption survicateNpsAnswerOption, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                survicateNpsAnswerOption = savedState.selectedAnswer;
            }
            if ((i & 2) != 0) {
                str = savedState.commentFieldText;
            }
            return savedState.copy(survicateNpsAnswerOption, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurvicateNpsAnswerOption getSelectedAnswer() {
            return this.selectedAnswer;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCommentFieldText() {
            return this.commentFieldText;
        }

        public final SavedState copy(SurvicateNpsAnswerOption selectedAnswer, String commentFieldText) {
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            return new SavedState(selectedAnswer, commentFieldText);
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
            return this.selectedAnswer == savedState.selectedAnswer && Intrinsics.areEqual(this.commentFieldText, savedState.commentFieldText);
        }

        public int hashCode() {
            SurvicateNpsAnswerOption survicateNpsAnswerOption = this.selectedAnswer;
            return ((survicateNpsAnswerOption == null ? 0 : survicateNpsAnswerOption.hashCode()) * 31) + this.commentFieldText.hashCode();
        }

        public String toString() {
            return "SavedState(selectedAnswer=" + this.selectedAnswer + ", commentFieldText=" + this.commentFieldText + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            SurvicateNpsAnswerOption survicateNpsAnswerOption = this.selectedAnswer;
            if (survicateNpsAnswerOption == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeString(survicateNpsAnswerOption.name());
            }
            dest.writeString(this.commentFieldText);
        }

        public SavedState(SurvicateNpsAnswerOption survicateNpsAnswerOption, String commentFieldText) {
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            this.selectedAnswer = survicateNpsAnswerOption;
            this.commentFieldText = commentFieldText;
        }

        public final SurvicateNpsAnswerOption getSelectedAnswer() {
            return this.selectedAnswer;
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
