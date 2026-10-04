package com.survicate.surveys.presentation.single.micro;

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
import android.widget.RadioButton;
import android.widget.TextView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateSelectionType;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.theming.MicroSelectionDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.SurvicateViewUtils;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0004QRSTB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010:\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010/\u001a\u0002002\b\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u00020\u0016H\u0002J\u0012\u0010?\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\fH\u0002J\u0010\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020BH\u0002J\u0018\u0010F\u001a\u00020\u00162\u0006\u0010E\u001a\u00020B2\u0006\u0010C\u001a\u00020\fH\u0002J\u0018\u0010G\u001a\u00020\u00162\u0006\u0010E\u001a\u00020B2\u0006\u0010C\u001a\u00020\fH\u0002J\u0018\u0010H\u001a\u00020\u00162\u0006\u0010E\u001a\u00020B2\u0006\u0010C\u001a\u00020\fH\u0002J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\fH\u0002J\u0010\u0010J\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\fH\u0002J\b\u0010K\u001a\u00020\u0016H\u0002J\b\u0010L\u001a\u00020\u0016H\u0002J\b\u0010M\u001a\u00020\u0016H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020\fH\u0002R*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRL\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u00020#2\u0006\u0010\n\u001a\u00020#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleAnswerItem;", "answerItems", "getAnswerItems", "()Ljava/util/List;", "onAnswerSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "answerId", "", "getOnAnswerSelected", "()Lkotlin/jvm/functions/Function1;", "setOnAnswerSelected", "(Lkotlin/jvm/functions/Function1;)V", "onCommentChanged", "Lkotlin/Function2;", "", ClientCookie.COMMENT_ATTR, "getOnCommentChanged", "()Lkotlin/jvm/functions/Function2;", "setOnCommentChanged", "(Lkotlin/jvm/functions/Function2;)V", "", "wasAnswerWithCommentSelectedFirst", "getWasAnswerWithCommentSelectedFirst", "()Z", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "answerContainer", "Landroid/widget/LinearLayout;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindingData", "Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$BindingData;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/single/SurveyPointSingleSettings;", "itemOfLastFocusedComment", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "bindHeader", "setupList", "buildAnswerItems", "createAnswerItemView", "Landroid/view/View;", "answerItem", "setupAnswerItemView", "itemView", "bindAnswerItem", "bindAnswer", "bindCommentField", "onAnswerItemClick", "rebindAnswerItem", "setupScrollOnCommentFocus", "restoreCommentFocus", "clearCommentFieldFocus", "findCommentFieldForItem", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "item", "Companion", "BindingData", "SavedState", "AnswerItemState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointSingleContentView extends FrameLayout {
    public static final String SAVED_STATE = "SAVED_STATE";
    private final LinearLayout answerContainer;
    private List<MicroSurveyPointSingleAnswerItem> answerItems;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private MicroSurveyPointSingleAnswerItem itemOfLastFocusedComment;
    private Function1<? super Long, Unit> onAnswerSelected;
    private Function2<? super Long, ? super String, Unit> onCommentChanged;
    private final MicroQuestionHeader questionHeaderView;
    private ViewDependencies viewDependencies;
    private boolean wasAnswerWithCommentSelectedFirst;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSingleContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSingleContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointSingleContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointSingleContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.answerItems = CollectionsKt.emptyList();
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_single_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_single_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_single_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.answerContainer = (LinearLayout) viewFindViewById2;
    }

    public final List<MicroSurveyPointSingleAnswerItem> getAnswerItems() {
        return this.answerItems;
    }

    public final Function1<Long, Unit> getOnAnswerSelected() {
        return this.onAnswerSelected;
    }

    public final void setOnAnswerSelected(Function1<? super Long, Unit> function1) {
        this.onAnswerSelected = function1;
    }

    public final Function2<Long, String, Unit> getOnCommentChanged() {
        return this.onCommentChanged;
    }

    public final void setOnCommentChanged(Function2<? super Long, ? super String, Unit> function2) {
        this.onCommentChanged = function2;
    }

    public final boolean getWasAnswerWithCommentSelectedFirst() {
        return this.wasAnswerWithCommentSelectedFirst;
    }

    private final SurveyQuestionSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyPointSingleSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings");
        return (SurveyPointSingleSettings) settings;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        this.itemOfLastFocusedComment = null;
        bindHeader();
        setupList(savedState);
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupList(Bundle savedState) {
        boolean wasAnswerWithCommentSelectedFirst;
        Parcelable parcelable;
        this.answerItems = buildAnswerItems(savedState);
        if (savedState == null) {
            wasAnswerWithCommentSelectedFirst = false;
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (SavedState) parcelable2;
            }
            SavedState savedState2 = (SavedState) parcelable;
            if (savedState2 != null) {
                wasAnswerWithCommentSelectedFirst = savedState2.getWasAnswerWithCommentSelectedFirst();
            }
        }
        this.wasAnswerWithCommentSelectedFirst = wasAnswerWithCommentSelectedFirst;
        this.answerContainer.removeAllViews();
        Iterator<MicroSurveyPointSingleAnswerItem> it = this.answerItems.iterator();
        while (it.hasNext()) {
            this.answerContainer.addView(createAnswerItemView(it.next()));
        }
    }

    private final View createAnswerItemView(MicroSurveyPointSingleAnswerItem answerItem) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_single, (ViewGroup) this.answerContainer, false);
        Intrinsics.checkNotNull(viewInflate);
        setupAnswerItemView(viewInflate);
        bindAnswerItem(viewInflate, answerItem);
        return viewInflate;
    }

    private final void setupAnswerItemView(View itemView) {
        RadioButton radioButton = (RadioButton) itemView.findViewById(C8369R.id.item_micro_single_radio_button);
        radioButton.setSaveEnabled(false);
        MicroSelectionDrawableFactory microSelectionDrawableFactory = MicroSelectionDrawableFactory.INSTANCE;
        ColorScheme colorScheme = this.colorScheme;
        ColorScheme colorScheme2 = null;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        radioButton.setBackground(microSelectionDrawableFactory.createRipple(colorScheme));
        MicroSelectionDrawableFactory microSelectionDrawableFactory2 = MicroSelectionDrawableFactory.INSTANCE;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme3 = this.colorScheme;
        if (colorScheme3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme3 = null;
        }
        radioButton.setButtonDrawable(microSelectionDrawableFactory2.createDrawable(context, colorScheme3, MicroSurvicateSelectionType.Radio));
        MicroSurvicateCommentField microSurvicateCommentField = (MicroSurvicateCommentField) itemView.findViewById(C8369R.id.item_micro_single_comment_field);
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        ColorScheme colorScheme4 = this.colorScheme;
        if (colorScheme4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme2 = colorScheme4;
        }
        microSurvicateCommentField.inject(viewDependencies, colorScheme2);
        ViewExtensionsKt.clipChildrenToBackground(itemView);
    }

    private final void bindAnswerItem(View itemView, MicroSurveyPointSingleAnswerItem answerItem) {
        bindAnswer(itemView, answerItem);
        bindCommentField(itemView, answerItem);
    }

    private final void bindAnswer(View itemView, final MicroSurveyPointSingleAnswerItem answerItem) {
        RadioButton radioButton = (RadioButton) itemView.findViewById(C8369R.id.item_micro_single_radio_button);
        TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_single_answer_text);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        ViewDependencies viewDependencies = null;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        itemView.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, answerItem.getIsSelected()));
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onAnswerItemClick(answerItem);
            }
        });
        Intrinsics.checkNotNull(textView);
        boolean isSelected = answerItem.getIsSelected();
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme2 = null;
        }
        ViewDependencies viewDependencies2 = this.viewDependencies;
        if (viewDependencies2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
        } else {
            viewDependencies = viewDependencies2;
        }
        TextViewExtensionsKt.applyQuestionOptionStyle(textView, isSelected, colorScheme2, viewDependencies.getFontProvider());
        textView.setText(answerItem.getTitle());
        Context context2 = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setContentDescription(answerItem.getContentDescription(context2));
        radioButton.setChecked(answerItem.getIsSelected());
    }

    private final void bindCommentField(View itemView, final MicroSurveyPointSingleAnswerItem answerItem) {
        MicroSurvicateCommentField microSurvicateCommentField = (MicroSurvicateCommentField) itemView.findViewById(C8369R.id.item_micro_single_comment_field);
        microSurvicateCommentField.setLabel(answerItem.getCommentLabel());
        microSurvicateCommentField.setInputHint(answerItem.getCommentHint());
        microSurvicateCommentField.bindTextInput(answerItem.getComment(), new Function1() { // from class: com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyPointSingleContentView.bindCommentField$lambda$3(answerItem, this, (String) obj);
            }
        });
        Intrinsics.checkNotNull(microSurvicateCommentField);
        microSurvicateCommentField.setVisibility(answerItem.getIsSelected() && answerItem.getIsCommentAvailable() ? 0 : 8);
        microSurvicateCommentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointSingleContentView.bindCommentField$lambda$4(this.f$0, answerItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$3(MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem, MicroSurveyPointSingleContentView microSurveyPointSingleContentView, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        microSurveyPointSingleAnswerItem.setComment(value);
        Function2<? super Long, ? super String, Unit> function2 = microSurveyPointSingleContentView.onCommentChanged;
        if (function2 != null) {
            function2.invoke(Long.valueOf(microSurveyPointSingleAnswerItem.getId()), value);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$4(MicroSurveyPointSingleContentView microSurveyPointSingleContentView, MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem) {
        microSurveyPointSingleContentView.itemOfLastFocusedComment = microSurveyPointSingleAnswerItem;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnswerItemClick(MicroSurveyPointSingleAnswerItem answerItem) {
        Object next;
        Iterator<T> it = this.answerItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((MicroSurveyPointSingleAnswerItem) next).getIsSelected()) {
                    break;
                }
            }
        }
        MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem = (MicroSurveyPointSingleAnswerItem) next;
        if (microSurveyPointSingleAnswerItem != null) {
            clearCommentFieldFocus();
            microSurveyPointSingleAnswerItem.setSelected(false);
            rebindAnswerItem(microSurveyPointSingleAnswerItem);
        }
        answerItem.setSelected(true);
        rebindAnswerItem(answerItem);
        if (answerItem.getIsCommentAvailable()) {
            this.wasAnswerWithCommentSelectedFirst = true;
        }
        Function1<? super Long, Unit> function1 = this.onAnswerSelected;
        if (function1 != null) {
            function1.invoke(Long.valueOf(answerItem.getId()));
        }
    }

    private final void rebindAnswerItem(MicroSurveyPointSingleAnswerItem answerItem) {
        View childAt = this.answerContainer.getChildAt(this.answerItems.indexOf(answerItem));
        if (childAt == null) {
            return;
        }
        bindAnswerItem(childAt, answerItem);
    }

    private final void setupScrollOnCommentFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointSingleContentView.setupScrollOnCommentFocus$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$6(MicroSurveyPointSingleContentView microSurveyPointSingleContentView) {
        microSurveyPointSingleContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        MicroSurvicateCommentField microSurvicateCommentFieldFindCommentFieldForItem;
        MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem = this.itemOfLastFocusedComment;
        if (microSurveyPointSingleAnswerItem == null || (microSurvicateCommentFieldFindCommentFieldForItem = findCommentFieldForItem(microSurveyPointSingleAnswerItem)) == null || !microSurvicateCommentFieldFindCommentFieldForItem.isAttachedToWindow()) {
            return;
        }
        microSurvicateCommentFieldFindCommentFieldForItem.scrollTo();
    }

    private final void clearCommentFieldFocus() {
        MicroSurvicateCommentField microSurvicateCommentFieldFindCommentFieldForItem;
        MicroSurveyPointSingleAnswerItem microSurveyPointSingleAnswerItem = this.itemOfLastFocusedComment;
        if (microSurveyPointSingleAnswerItem == null || (microSurvicateCommentFieldFindCommentFieldForItem = findCommentFieldForItem(microSurveyPointSingleAnswerItem)) == null) {
            return;
        }
        microSurvicateCommentFieldFindCommentFieldForItem.clearInputFocus();
        this.itemOfLastFocusedComment = null;
    }

    private final MicroSurvicateCommentField findCommentFieldForItem(MicroSurveyPointSingleAnswerItem item) {
        View childAt = this.answerContainer.getChildAt(this.answerItems.indexOf(item));
        if (childAt == null) {
            return null;
        }
        return (MicroSurvicateCommentField) childAt.findViewById(C8369R.id.item_micro_single_comment_field);
    }

    /* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "orderedAnswers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Ljava/util/List;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getOrderedAnswers", "()Ljava/util/List;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final String commentHint;
        private final List<QuestionPointAnswer> orderedAnswers;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyQuestionSurveyPoint surveyPoint;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, List list, QuestionHeaderBindingData questionHeaderBindingData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyQuestionSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                list = bindingData.orderedAnswers;
            }
            if ((i & 4) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 8) != 0) {
                str = bindingData.commentHint;
            }
            return bindingData.copy(surveyQuestionSurveyPoint, list, questionHeaderBindingData, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyQuestionSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final List<QuestionPointAnswer> component2() {
            return this.orderedAnswers;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCommentHint() {
            return this.commentHint;
        }

        public final BindingData copy(SurveyQuestionSurveyPoint surveyPoint, List<QuestionPointAnswer> orderedAnswers, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(orderedAnswers, "orderedAnswers");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            return new BindingData(surveyPoint, orderedAnswers, questionHeaderBindingData, commentHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.orderedAnswers, bindingData.orderedAnswers) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData) && Intrinsics.areEqual(this.commentHint, bindingData.commentHint);
        }

        public int hashCode() {
            return (((((this.surveyPoint.hashCode() * 31) + this.orderedAnswers.hashCode()) * 31) + this.questionHeaderBindingData.hashCode()) * 31) + this.commentHint.hashCode();
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", orderedAnswers=" + this.orderedAnswers + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ", commentHint=" + this.commentHint + ')';
        }

        public BindingData(SurveyQuestionSurveyPoint surveyPoint, List<QuestionPointAnswer> orderedAnswers, QuestionHeaderBindingData questionHeaderBindingData, String commentHint) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(orderedAnswers, "orderedAnswers");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(commentHint, "commentHint");
            this.surveyPoint = surveyPoint;
            this.orderedAnswers = orderedAnswers;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.commentHint = commentHint;
        }

        public final SurveyQuestionSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final List<QuestionPointAnswer> getOrderedAnswers() {
            return this.orderedAnswers;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final String getCommentHint() {
            return this.commentHint;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$SavedState;", "Landroid/os/Parcelable;", "answerItemStates", "", "", "Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$AnswerItemState;", "wasAnswerWithCommentSelectedFirst", "", "answerOrder", "", "<init>", "(Ljava/util/Map;ZLjava/util/List;)V", "getAnswerItemStates", "()Ljava/util/Map;", "getWasAnswerWithCommentSelectedFirst", "()Z", "getAnswerOrder", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final Map<Long, AnswerItemState> answerItemStates;
        private final List<Long> answerOrder;
        private final boolean wasAnswerWithCommentSelectedFirst;

        /* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap.put(Long.valueOf(parcel.readLong()), AnswerItemState.CREATOR.createFromParcel(parcel));
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                boolean z = parcel.readInt() != 0;
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i3 = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i3);
                    for (int i4 = 0; i4 != i3; i4++) {
                        arrayList2.add(Long.valueOf(parcel.readLong()));
                    }
                    arrayList = arrayList2;
                }
                return new SavedState(linkedHashMap2, z, arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SavedState copy$default(SavedState savedState, Map map, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                map = savedState.answerItemStates;
            }
            if ((i & 2) != 0) {
                z = savedState.wasAnswerWithCommentSelectedFirst;
            }
            if ((i & 4) != 0) {
                list = savedState.answerOrder;
            }
            return savedState.copy(map, z, list);
        }

        public final Map<Long, AnswerItemState> component1() {
            return this.answerItemStates;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getWasAnswerWithCommentSelectedFirst() {
            return this.wasAnswerWithCommentSelectedFirst;
        }

        public final List<Long> component3() {
            return this.answerOrder;
        }

        public final SavedState copy(Map<Long, AnswerItemState> answerItemStates, boolean wasAnswerWithCommentSelectedFirst, List<Long> answerOrder) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            return new SavedState(answerItemStates, wasAnswerWithCommentSelectedFirst, answerOrder);
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
            return Intrinsics.areEqual(this.answerItemStates, savedState.answerItemStates) && this.wasAnswerWithCommentSelectedFirst == savedState.wasAnswerWithCommentSelectedFirst && Intrinsics.areEqual(this.answerOrder, savedState.answerOrder);
        }

        public int hashCode() {
            int iHashCode = ((this.answerItemStates.hashCode() * 31) + Boolean.hashCode(this.wasAnswerWithCommentSelectedFirst)) * 31;
            List<Long> list = this.answerOrder;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "SavedState(answerItemStates=" + this.answerItemStates + ", wasAnswerWithCommentSelectedFirst=" + this.wasAnswerWithCommentSelectedFirst + ", answerOrder=" + this.answerOrder + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            Map<Long, AnswerItemState> map = this.answerItemStates;
            dest.writeInt(map.size());
            for (Map.Entry<Long, AnswerItemState> entry : map.entrySet()) {
                dest.writeLong(entry.getKey().longValue());
                entry.getValue().writeToParcel(dest, flags);
            }
            dest.writeInt(this.wasAnswerWithCommentSelectedFirst ? 1 : 0);
            List<Long> list = this.answerOrder;
            if (list == null) {
                dest.writeInt(0);
                return;
            }
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                dest.writeLong(it.next().longValue());
            }
        }

        public SavedState(Map<Long, AnswerItemState> answerItemStates, boolean z, List<Long> list) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            this.answerItemStates = answerItemStates;
            this.wasAnswerWithCommentSelectedFirst = z;
            this.answerOrder = list;
        }

        public /* synthetic */ SavedState(Map map, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, z, (i & 4) != 0 ? null : list);
        }

        public final Map<Long, AnswerItemState> getAnswerItemStates() {
            return this.answerItemStates;
        }

        public final boolean getWasAnswerWithCommentSelectedFirst() {
            return this.wasAnswerWithCommentSelectedFirst;
        }

        public final List<Long> getAnswerOrder() {
            return this.answerOrder;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/single/micro/MicroSurveyPointSingleContentView$AnswerItemState;", "Landroid/os/Parcelable;", "isSelected", "", ClientCookie.COMMENT_ATTR, "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getComment", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class AnswerItemState implements Parcelable {
        public static final Parcelable.Creator<AnswerItemState> CREATOR = new Creator();
        private final String comment;
        private final boolean isSelected;

        /* JADX INFO: compiled from: MicroSurveyPointSingleContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<AnswerItemState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AnswerItemState(parcel.readInt() != 0, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState[] newArray(int i) {
                return new AnswerItemState[i];
            }
        }

        public static /* synthetic */ AnswerItemState copy$default(AnswerItemState answerItemState, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = answerItemState.isSelected;
            }
            if ((i & 2) != 0) {
                str = answerItemState.comment;
            }
            return answerItemState.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getComment() {
            return this.comment;
        }

        public final AnswerItemState copy(boolean isSelected, String comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            return new AnswerItemState(isSelected, comment);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnswerItemState)) {
                return false;
            }
            AnswerItemState answerItemState = (AnswerItemState) other;
            return this.isSelected == answerItemState.isSelected && Intrinsics.areEqual(this.comment, answerItemState.comment);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isSelected) * 31) + this.comment.hashCode();
        }

        public String toString() {
            return "AnswerItemState(isSelected=" + this.isSelected + ", comment=" + this.comment + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.isSelected ? 1 : 0);
            dest.writeString(this.comment);
        }

        public AnswerItemState(boolean z, String comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            this.isSelected = z;
            this.comment = comment;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final String getComment() {
            return this.comment;
        }
    }

    private final List<MicroSurveyPointSingleAnswerItem> buildAnswerItems(Bundle savedState) {
        SavedState savedState2;
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (SavedState) parcelable2;
            }
            savedState2 = (SavedState) parcelable;
        } else {
            savedState2 = null;
        }
        String commentLabel = getSurveyPointSettings().getCommentLabel();
        String str = commentLabel == null ? "" : commentLabel;
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
        String str2 = commentHint;
        Map<Long, AnswerItemState> answerItemStates = savedState2 != null ? savedState2.getAnswerItemStates() : null;
        if (answerItemStates == null) {
            answerItemStates = MapsKt.emptyMap();
        }
        BindingData bindingData2 = this.bindingData;
        if (bindingData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData2 = null;
        }
        List<QuestionPointAnswer> orderedAnswers = bindingData2.getOrderedAnswers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(orderedAnswers, 10));
        for (QuestionPointAnswer questionPointAnswer : orderedAnswers) {
            AnswerItemState answerItemState = answerItemStates.get(Long.valueOf(questionPointAnswer.getId()));
            long id = questionPointAnswer.getId();
            String possibleAnswer = questionPointAnswer.getPossibleAnswer();
            if (possibleAnswer == null) {
                possibleAnswer = "";
            }
            boolean zAreEqual = Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true);
            Boolean boolIsCommentMandatory = getSurveyPointSettings().isCommentMandatory();
            boolean zIsSelected = false;
            boolean zBooleanValue = boolIsCommentMandatory != null ? boolIsCommentMandatory.booleanValue() : false;
            String comment = answerItemState != null ? answerItemState.getComment() : null;
            if (comment == null) {
                comment = "";
            }
            if (answerItemState != null) {
                zIsSelected = answerItemState.isSelected();
            }
            arrayList.add(new MicroSurveyPointSingleAnswerItem(id, possibleAnswer, zAreEqual, zBooleanValue, str, str2, comment, zIsSelected));
        }
        return arrayList;
    }
}
