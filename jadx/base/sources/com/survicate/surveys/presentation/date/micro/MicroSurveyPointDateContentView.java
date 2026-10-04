package com.survicate.surveys.presentation.date.micro;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.utils.SurvicateLocalDate;
import com.survicate.surveys.utils.SurvicateLocalDateFormatter;
import com.survicate.surveys.utils.SurvicateViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointDateContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 O2\u00020\u0001:\u0003OPQB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010=\u001a\u00020\fH\u0002J\u0016\u0010>\u001a\u00020\f2\u0006\u0010;\u001a\u00020<2\u0006\u00109\u001a\u00020:J\u0018\u0010?\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010@\u001a\u0004\u0018\u00010AJ\u0014\u0010B\u001a\u0004\u0018\u00010\u001c2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0014\u0010C\u001a\u0004\u0018\u00010D2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010E\u001a\u00020\fH\u0002J\u000e\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u001cJ\b\u0010H\u001a\u00020\fH\u0002J\u0012\u0010I\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010J\u001a\u00020\u00132\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010K\u001a\u00020\"H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010L\u001a\u00020\fH\u0002J\b\u0010M\u001a\u00020\fH\u0002J\f\u0010N\u001a\u00020\f*\u000202H\u0002R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000¨\u0006R"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSelectDateClick", "Lkotlin/Function0;", "", "getOnSelectDateClick", "()Lkotlin/jvm/functions/Function0;", "setOnSelectDateClick", "(Lkotlin/jvm/functions/Function0;)V", "onCommentChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", "getOnCommentChanged", "()Lkotlin/jvm/functions/Function1;", "setOnCommentChanged", "(Lkotlin/jvm/functions/Function1;)V", "selectedDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "value", "commentFieldText", "getCommentFieldText", "()Ljava/lang/String;", "wasCommentFieldFocused", "", "bindingData", "Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$BindingData;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "selectedDateContainer", "Landroid/view/View;", "yearTextView", "Landroid/widget/TextView;", "yearMonthDivider", "monthTextView", "monthDayDivider", "dayTextView", "commentField", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "setupListeners", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "restoreSelectedDate", "readSavedState", "Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$SavedState;", "bindHeader", "updateSelectedDate", QuestionSurveyAnswerType.DATE, "showSelectedDate", "bindCommentField", "restoreComment", "isCommentAvailable", "setupScrollOnCommentFocus", "restoreCommentFocus", "setupAsDateComponent", "Companion", "BindingData", "SavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointDateContentView extends FrameLayout {
    public static final String SAVED_STATE = "SAVED_STATE";
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private final MicroSurvicateCommentField commentField;
    private String commentFieldText;
    private final TextView dayTextView;
    private final TextView monthDayDivider;
    private final TextView monthTextView;
    private Function1<? super String, Unit> onCommentChanged;
    private Function0<Unit> onSelectDateClick;
    private final MicroQuestionHeader questionHeaderView;
    private SurvicateLocalDate selectedDate;
    private final View selectedDateContainer;
    private ViewDependencies viewDependencies;
    private boolean wasCommentFieldFocused;
    private final TextView yearMonthDivider;
    private final TextView yearTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointDateContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointDateContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointDateContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointDateContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.commentFieldText = "";
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_date_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_selected_date_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.selectedDateContainer = viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_selected_year);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.yearTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_year_month_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.yearMonthDivider = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_selected_month);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.monthTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_month_day_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.monthDayDivider = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_selected_day);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.dayTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_date_content_comment);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.commentField = (MicroSurvicateCommentField) viewFindViewById8;
        setupListeners();
    }

    public final Function0<Unit> getOnSelectDateClick() {
        return this.onSelectDateClick;
    }

    public final void setOnSelectDateClick(Function0<Unit> function0) {
        this.onSelectDateClick = function0;
    }

    public final Function1<String, Unit> getOnCommentChanged() {
        return this.onCommentChanged;
    }

    public final void setOnCommentChanged(Function1<? super String, Unit> function1) {
        this.onCommentChanged = function1;
    }

    public final String getCommentFieldText() {
        return this.commentFieldText;
    }

    private final SurveyQuestionSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyPointDateSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings");
        return (SurveyPointDateSettings) settings;
    }

    private final void setupListeners() {
        this.selectedDateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicroSurveyPointDateContentView.setupListeners$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0(MicroSurveyPointDateContentView microSurveyPointDateContentView, View view) {
        Function0<Unit> function0 = microSurveyPointDateContentView.onSelectDateClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
        View view = this.selectedDateContainer;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        view.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, false));
        setupAsDateComponent(this.yearTextView);
        setupAsDateComponent(this.yearMonthDivider);
        setupAsDateComponent(this.monthTextView);
        setupAsDateComponent(this.monthDayDivider);
        setupAsDateComponent(this.dayTextView);
        this.commentField.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        SurvicateLocalDate survicateLocalDateRestoreSelectedDate = restoreSelectedDate(savedState);
        if (survicateLocalDateRestoreSelectedDate == null) {
            survicateLocalDateRestoreSelectedDate = bindingData.getInitialDate();
        }
        this.selectedDate = survicateLocalDateRestoreSelectedDate;
        this.wasCommentFieldFocused = false;
        bindHeader();
        showSelectedDate();
        bindCommentField(savedState);
        setupScrollOnCommentFocus();
    }

    private final SurvicateLocalDate restoreSelectedDate(Bundle savedState) {
        SavedState savedState2 = readSavedState(savedState);
        if (savedState2 != null) {
            return savedState2.getSelectedDate();
        }
        return null;
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

    public final void updateSelectedDate(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.selectedDate = date;
        showSelectedDate();
    }

    private final void showSelectedDate() {
        TextView textView = this.yearTextView;
        SurvicateLocalDateFormatter survicateLocalDateFormatter = SurvicateLocalDateFormatter.INSTANCE;
        SurvicateLocalDate survicateLocalDate = this.selectedDate;
        SurvicateLocalDate survicateLocalDate2 = null;
        if (survicateLocalDate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedDate");
            survicateLocalDate = null;
        }
        textView.setText(survicateLocalDateFormatter.formatYear(survicateLocalDate));
        TextView textView2 = this.monthTextView;
        SurvicateLocalDateFormatter survicateLocalDateFormatter2 = SurvicateLocalDateFormatter.INSTANCE;
        SurvicateLocalDate survicateLocalDate3 = this.selectedDate;
        if (survicateLocalDate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedDate");
            survicateLocalDate3 = null;
        }
        textView2.setText(survicateLocalDateFormatter2.formatMonth(survicateLocalDate3));
        TextView textView3 = this.dayTextView;
        SurvicateLocalDateFormatter survicateLocalDateFormatter3 = SurvicateLocalDateFormatter.INSTANCE;
        SurvicateLocalDate survicateLocalDate4 = this.selectedDate;
        if (survicateLocalDate4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedDate");
            survicateLocalDate4 = null;
        }
        textView3.setText(survicateLocalDateFormatter3.formatDay(survicateLocalDate4));
        View view = this.selectedDateContainer;
        SurvicateLocalDateFormatter survicateLocalDateFormatter4 = SurvicateLocalDateFormatter.INSTANCE;
        SurvicateLocalDate survicateLocalDate5 = this.selectedDate;
        if (survicateLocalDate5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedDate");
        } else {
            survicateLocalDate2 = survicateLocalDate5;
        }
        view.setContentDescription(survicateLocalDateFormatter4.formatAsContentDescription(survicateLocalDate2));
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
            commentHint = getContext().getString(C8369R.string.survicate_input_text_placeholder);
            Intrinsics.checkNotNullExpressionValue(commentHint, "getString(...)");
        }
        this.commentField.setInputHint(commentHint);
        this.commentField.setVisibility(isCommentAvailable() ? 0 : 8);
        this.commentField.bindTextInput(this.commentFieldText, new C84351(this));
        this.commentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointDateContentView.bindCommentField$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView$bindCommentField$1 */
    /* JADX INFO: compiled from: MicroSurveyPointDateContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84351 extends FunctionReferenceImpl implements Function1<String, Unit> {
        C84351(Object obj) {
            super(1, obj, MicroSurveyPointDateContentView.class, "onCommentChanged", "onCommentChanged(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MicroSurveyPointDateContentView) this.receiver).onCommentChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$2(MicroSurveyPointDateContentView microSurveyPointDateContentView) {
        microSurveyPointDateContentView.wasCommentFieldFocused = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCommentChanged(String text) {
        this.commentFieldText = text;
        Function1<? super String, Unit> function1 = this.onCommentChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
    }

    private final void setupScrollOnCommentFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointDateContentView.setupScrollOnCommentFocus$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$3(MicroSurveyPointDateContentView microSurveyPointDateContentView) {
        microSurveyPointDateContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        if (this.wasCommentFieldFocused && this.commentField.isAttachedToWindow()) {
            this.commentField.scrollTo();
        }
    }

    private final void setupAsDateComponent(TextView textView) {
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

    /* JADX INFO: compiled from: MicroSurveyPointDateContentView.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "initialDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;Lcom/survicate/surveys/utils/SurvicateLocalDate;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "getInitialDate", "()Lcom/survicate/surveys/utils/SurvicateLocalDate;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final String commentHint;
        private final SurvicateLocalDate initialDate;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyQuestionSurveyPoint surveyPoint;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String str, SurvicateLocalDate survicateLocalDate, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyQuestionSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 4) != 0) {
                str = bindingData.commentHint;
            }
            if ((i & 8) != 0) {
                survicateLocalDate = bindingData.initialDate;
            }
            return bindingData.copy(surveyQuestionSurveyPoint, questionHeaderBindingData, str, survicateLocalDate);
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

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SurvicateLocalDate getInitialDate() {
            return this.initialDate;
        }

        public final BindingData copy(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint, SurvicateLocalDate initialDate) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            Intrinsics.checkNotNullParameter(initialDate, "initialDate");
            return new BindingData(surveyPoint, questionHeaderBindingData, commentHint, initialDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData) && Intrinsics.areEqual(this.commentHint, bindingData.commentHint) && Intrinsics.areEqual(this.initialDate, bindingData.initialDate);
        }

        public int hashCode() {
            return (((((this.surveyPoint.hashCode() * 31) + this.questionHeaderBindingData.hashCode()) * 31) + this.commentHint.hashCode()) * 31) + this.initialDate.hashCode();
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ", commentHint=" + this.commentHint + ", initialDate=" + this.initialDate + ')';
        }

        public BindingData(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String commentHint, SurvicateLocalDate initialDate) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            Intrinsics.checkNotNullParameter(initialDate, "initialDate");
            this.surveyPoint = surveyPoint;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.commentHint = commentHint;
            this.initialDate = initialDate;
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

        public final SurvicateLocalDate getInitialDate() {
            return this.initialDate;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointDateContentView.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$SavedState;", "Landroid/os/Parcelable;", "selectedDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "commentFieldText", "", "<init>", "(Lcom/survicate/surveys/utils/SurvicateLocalDate;Ljava/lang/String;)V", "getSelectedDate", "()Lcom/survicate/surveys/utils/SurvicateLocalDate;", "getCommentFieldText", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final String commentFieldText;
        private final SurvicateLocalDate selectedDate;

        /* JADX INFO: compiled from: MicroSurveyPointDateContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavedState(SurvicateLocalDate.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public static /* synthetic */ SavedState copy$default(SavedState savedState, SurvicateLocalDate survicateLocalDate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                survicateLocalDate = savedState.selectedDate;
            }
            if ((i & 2) != 0) {
                str = savedState.commentFieldText;
            }
            return savedState.copy(survicateLocalDate, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurvicateLocalDate getSelectedDate() {
            return this.selectedDate;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCommentFieldText() {
            return this.commentFieldText;
        }

        public final SavedState copy(SurvicateLocalDate selectedDate, String commentFieldText) {
            Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            return new SavedState(selectedDate, commentFieldText);
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
            return Intrinsics.areEqual(this.selectedDate, savedState.selectedDate) && Intrinsics.areEqual(this.commentFieldText, savedState.commentFieldText);
        }

        public int hashCode() {
            return (this.selectedDate.hashCode() * 31) + this.commentFieldText.hashCode();
        }

        public String toString() {
            return "SavedState(selectedDate=" + this.selectedDate + ", commentFieldText=" + this.commentFieldText + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            this.selectedDate.writeToParcel(dest, flags);
            dest.writeString(this.commentFieldText);
        }

        public SavedState(SurvicateLocalDate selectedDate, String commentFieldText) {
            Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
            Intrinsics.checkNotNullParameter(commentFieldText, "commentFieldText");
            this.selectedDate = selectedDate;
            this.commentFieldText = commentFieldText;
        }

        public final SurvicateLocalDate getSelectedDate() {
            return this.selectedDate;
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
