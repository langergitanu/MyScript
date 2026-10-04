package com.survicate.surveys.presentation.text.micro;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.text.TextFollowUpRules;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.widget.MicroDotsProgressBar;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateTextInput;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.SurvicateViewUtils;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 ]2\u00020\u0001:\u0004]^_`B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u00105\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0018\u00106\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;H\u0016J\u0012\u0010<\u001a\u00020\u00172\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\fH\u0002J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u000201H\u0002J\u0018\u0010B\u001a\u00020\u00172\u0006\u0010A\u001a\u0002012\u0006\u0010?\u001a\u00020\fH\u0002J\u0012\u0010C\u001a\u0002012\b\b\u0002\u0010D\u001a\u00020/H\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010F\u001a\u00020\u0015H\u0002J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u000bH\u0002J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\fH\u0002J\u0010\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020/H\u0002J\b\u0010P\u001a\u00020/H\u0002J\b\u0010Q\u001a\u00020/H\u0002J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u0015H\u0007J\b\u0010T\u001a\u00020\u0017H\u0002J\b\u0010U\u001a\u00020\u0017H\u0002J\u0006\u0010V\u001a\u00020\u0017J\b\u0010W\u001a\u00020\u0017H\u0002J\b\u0010X\u001a\u00020\u0017H\u0002J\b\u0010Y\u001a\u00020\u0017H\u0002J\u0006\u0010Z\u001a\u00020\u0017J\b\u0010[\u001a\u00020\u0017H\u0002J\b\u0010\\\u001a\u00020\u0017H\u0002R*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextItem;", "answerItems", "getAnswerItems", "()Ljava/util/List;", "onAnswerChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "text", "", "getOnAnswerChanged", "()Lkotlin/jvm/functions/Function2;", "setOnAnswerChanged", "(Lkotlin/jvm/functions/Function2;)V", "answerContainer", "Landroid/widget/LinearLayout;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindingData", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$BindingData;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "followUpEditsRemaining", "Ljava/lang/Integer;", "isTouchInputEnabled", "", "progressDividerView", "Landroid/view/View;", "progressView", "notificationSpacerView", "notificationView", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setupList", "rebuildAnswerViews", "createAnswerItemView", "item", "setupAnswerItemView", "itemView", "bindAnswerItem", "createDividerView", "showBackground", "buildAnswerItems", "getInputHint", "rebuildAnswerItems", "savedItemStates", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$AnswerItemState;", "getMaxCharacterCountForAnswer", "idx", "onItemTextChanged", "removeTrailingAnswerViews", "keepItemCount", "isAiFollowUpAvailable", "isFollowUpEnabled", "hasFollowUpEditsRemaining", "addFollowUpQuestion", "question", "addNotificationViewIfShould", "removeNotificationView", "showProgressAnimation", "removeProgressView", "disableTouchInput", "enableTouchInput", "scrollToEnd", "setupScrollOnInputFocus", "scrollFocusedInputIntoView", "Companion", "BindingData", "SavedState", "AnswerItemState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointTextContentView extends FrameLayout {
    private static final String ANSWER_ITEM_TAG = "answer_item";
    private static final int MAX_FOLLOW_UP_ANSWER_CHARACTER_COUNT = 1000;
    public static final String SAVED_STATE = "SAVED_STATE";
    private final LinearLayout answerContainer;
    private List<MicroSurveyPointTextItem> answerItems;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private Integer followUpEditsRemaining;
    private boolean isTouchInputEnabled;
    private View notificationSpacerView;
    private View notificationView;
    private Function2<? super Integer, ? super String, Unit> onAnswerChanged;
    private View progressDividerView;
    private View progressView;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointTextContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointTextContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointTextContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointTextContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.answerItems = CollectionsKt.emptyList();
        this.isTouchInputEnabled = true;
        View viewFindViewById = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_text_content, this).findViewById(C8369R.id.view_micro_survey_point_text_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.answerContainer = (LinearLayout) viewFindViewById;
        setupScrollOnInputFocus();
    }

    public final List<MicroSurveyPointTextItem> getAnswerItems() {
        return this.answerItems;
    }

    public final Function2<Integer, String, Unit> getOnAnswerChanged() {
        return this.onAnswerChanged;
    }

    public final void setOnAnswerChanged(Function2<? super Integer, ? super String, Unit> function2) {
        this.onAnswerChanged = function2;
    }

    private final SurveyQuestionSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyPointTextSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings");
        return (SurveyPointTextSettings) settings;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        setupList(savedState);
        enableTouchInput();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.isTouchInputEnabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return true;
    }

    private final void rebuildAnswerViews() {
        this.answerContainer.removeAllViews();
        this.progressDividerView = null;
        this.progressView = null;
        this.notificationSpacerView = null;
        this.notificationView = null;
        int i = 0;
        for (MicroSurveyPointTextItem microSurveyPointTextItem : this.answerItems) {
            int i2 = i + 1;
            if (i > 0) {
                this.answerContainer.addView(createDividerView$default(this, false, 1, null));
            }
            this.answerContainer.addView(createAnswerItemView(microSurveyPointTextItem));
            i = i2;
        }
        addNotificationViewIfShould();
    }

    private final View createAnswerItemView(MicroSurveyPointTextItem item) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_text, (ViewGroup) this.answerContainer, false);
        viewInflate.setTag(ANSWER_ITEM_TAG);
        Intrinsics.checkNotNull(viewInflate);
        setupAnswerItemView(viewInflate);
        bindAnswerItem(viewInflate, item);
        return viewInflate;
    }

    private final void setupAnswerItemView(View itemView) {
        MicroQuestionHeader microQuestionHeader = (MicroQuestionHeader) itemView.findViewById(C8369R.id.item_micro_text_header);
        MicroSurvicateTextInput microSurvicateTextInput = (MicroSurvicateTextInput) itemView.findViewById(C8369R.id.item_micro_text_input);
        ViewDependencies viewDependencies = this.viewDependencies;
        ColorScheme colorScheme = null;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme2 = null;
        }
        microQuestionHeader.inject(viewDependencies, colorScheme2);
        ViewDependencies viewDependencies2 = this.viewDependencies;
        if (viewDependencies2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies2 = null;
        }
        ColorScheme colorScheme3 = this.colorScheme;
        if (colorScheme3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme3;
        }
        microSurvicateTextInput.inject(viewDependencies2, colorScheme);
        microSurvicateTextInput.setInputType(131073);
        microSurvicateTextInput.setImeActionDone();
        microSurvicateTextInput.setAutoSaveEnabled(false);
    }

    private final void bindAnswerItem(View itemView, final MicroSurveyPointTextItem item) {
        MicroQuestionHeader microQuestionHeader = (MicroQuestionHeader) itemView.findViewById(C8369R.id.item_micro_text_header);
        MicroSurvicateTextInput microSurvicateTextInput = (MicroSurvicateTextInput) itemView.findViewById(C8369R.id.item_micro_text_input);
        microQuestionHeader.bindData(item.getHeader());
        microSurvicateTextInput.bindTextInput(item.getAnswer().getInput(), item.getMaxAnswerCharacterCount(), new Function1() { // from class: com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyPointTextContentView.bindAnswerItem$lambda$0(item, this, (String) obj);
            }
        });
        microSurvicateTextInput.setInputHint(item.getAnswer().getInputHint());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindAnswerItem$lambda$0(MicroSurveyPointTextItem microSurveyPointTextItem, MicroSurveyPointTextContentView microSurveyPointTextContentView, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        microSurveyPointTextItem.getAnswer().setInput(it);
        microSurveyPointTextContentView.onItemTextChanged(microSurveyPointTextItem);
        return Unit.INSTANCE;
    }

    static /* synthetic */ View createDividerView$default(MicroSurveyPointTextContentView microSurveyPointTextContentView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return microSurveyPointTextContentView.createDividerView(z);
    }

    private final View createDividerView(boolean showBackground) {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_divider_height));
        layoutParams.topMargin = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_question_text_divider_top_spacing);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_question_text_divider_bottom_spacing);
        view.setLayoutParams(layoutParams);
        if (showBackground) {
            ColorScheme colorScheme = this.colorScheme;
            if (colorScheme == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
                colorScheme = null;
            }
            view.setBackgroundColor(ColorHelper.getArgbValue(colorScheme.getQuestion(), MicroColorControlOpacity.AnswerBackground.getOpacityValue()));
        }
        return view;
    }

    private final List<MicroSurveyPointTextItem> buildAnswerItems() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return CollectionsKt.listOf(new MicroSurveyPointTextItem(bindingData.getQuestionHeaderBindingData(), new MicroSurveyPointTextAnswer("", getInputHint()), isFollowUpEnabled() ? 1000 : 0));
    }

    private final String getInputHint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        String textPlaceholder = bindingData.getTextPlaceholder();
        if (textPlaceholder.length() == 0) {
            textPlaceholder = getContext().getString(C8369R.string.survicate_input_text_placeholder);
            Intrinsics.checkNotNullExpressionValue(textPlaceholder, "getString(...)");
        }
        return textPlaceholder;
    }

    private final List<MicroSurveyPointTextItem> rebuildAnswerItems(List<AnswerItemState> savedItemStates) {
        QuestionHeaderBindingData questionHeaderBindingDataCopy$default;
        List<AnswerItemState> list = savedItemStates;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AnswerItemState answerItemState = (AnswerItemState) obj;
            BindingData bindingData = null;
            if (i == 0) {
                BindingData bindingData2 = this.bindingData;
                if (bindingData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindingData");
                } else {
                    bindingData = bindingData2;
                }
                questionHeaderBindingDataCopy$default = bindingData.getQuestionHeaderBindingData();
            } else {
                BindingData bindingData3 = this.bindingData;
                if (bindingData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindingData");
                } else {
                    bindingData = bindingData3;
                }
                QuestionHeaderBindingData questionHeaderBindingData = bindingData.getQuestionHeaderBindingData();
                String followUpQuestion = answerItemState.getFollowUpQuestion();
                if (followUpQuestion == null) {
                    followUpQuestion = "";
                }
                questionHeaderBindingDataCopy$default = QuestionHeaderBindingData.copy$default(questionHeaderBindingData, "", followUpQuestion, null, false, null, 12, null);
            }
            arrayList.add(new MicroSurveyPointTextItem(questionHeaderBindingDataCopy$default, new MicroSurveyPointTextAnswer(answerItemState.getInput(), getInputHint()), getMaxCharacterCountForAnswer(i)));
            i = i2;
        }
        return arrayList;
    }

    private final int getMaxCharacterCountForAnswer(int idx) {
        Integer followUpQuestionCount = getSurveyPointSettings().getFollowUpQuestionCount();
        return (!isFollowUpEnabled() || followUpQuestionCount == null || idx >= followUpQuestionCount.intValue()) ? 0 : 1000;
    }

    private final void onItemTextChanged(MicroSurveyPointTextItem item) {
        int iIndexOf = this.answerItems.indexOf(item);
        if (iIndexOf < 0) {
            return;
        }
        if (isFollowUpEnabled() && iIndexOf < this.answerItems.size() - 1) {
            List<MicroSurveyPointTextItem> listSubList = this.answerItems.subList(0, iIndexOf + 1);
            this.answerItems = listSubList;
            removeTrailingAnswerViews(listSubList.size());
        }
        Function2<? super Integer, ? super String, Unit> function2 = this.onAnswerChanged;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(iIndexOf), item.getAnswer().getInput());
        }
    }

    private final void removeTrailingAnswerViews(int keepItemCount) {
        int index;
        removeNotificationView();
        removeProgressView();
        IndexedValue indexedValue = (IndexedValue) SequencesKt.elementAtOrNull(SequencesKt.filter(SequencesKt.withIndex(ViewGroupKt.getChildren(this.answerContainer)), new Function1() { // from class: com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MicroSurveyPointTextContentView.removeTrailingAnswerViews$lambda$4((IndexedValue) obj));
            }
        }), keepItemCount - 1);
        if (indexedValue == null || (index = indexedValue.getIndex() + 1) >= this.answerContainer.getChildCount()) {
            return;
        }
        LinearLayout linearLayout = this.answerContainer;
        linearLayout.removeViews(index, linearLayout.getChildCount() - index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeTrailingAnswerViews$lambda$4(IndexedValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(((View) it.getValue()).getTag(), ANSWER_ITEM_TAG);
    }

    private final boolean isAiFollowUpAvailable() {
        TextFollowUpRules textFollowUpRules = TextFollowUpRules.INSTANCE;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        Integer followUpLimit = bindingData.getFollowUpLimit();
        Integer followUpQuestionCount = getSurveyPointSettings().getFollowUpQuestionCount();
        int size = this.answerItems.size();
        List<MicroSurveyPointTextItem> list = this.answerItems;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.isBlank(((MicroSurveyPointTextItem) it.next()).getAnswer().getInput())) {
                    z = false;
                    break;
                }
            }
        }
        return textFollowUpRules.isFollowUpAvailable(followUpLimit, followUpQuestionCount, size, z, this.followUpEditsRemaining);
    }

    private final boolean isFollowUpEnabled() {
        TextFollowUpRules textFollowUpRules = TextFollowUpRules.INSTANCE;
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return textFollowUpRules.isFollowUpEnabled(bindingData.getFollowUpLimit(), getSurveyPointSettings().getFollowUpQuestionCount());
    }

    private final boolean hasFollowUpEditsRemaining() {
        Integer num = this.followUpEditsRemaining;
        return (num != null ? num.intValue() : 0) > 0;
    }

    public final void addFollowUpQuestion(String question) {
        Intrinsics.checkNotNullParameter(question, "question");
        if (isAiFollowUpAvailable()) {
            BindingData bindingData = this.bindingData;
            if (bindingData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindingData");
                bindingData = null;
            }
            this.answerItems = CollectionsKt.plus((Collection<? extends MicroSurveyPointTextItem>) this.answerItems, new MicroSurveyPointTextItem(QuestionHeaderBindingData.copy$default(bindingData.getQuestionHeaderBindingData(), "", question, null, false, null, 12, null), new MicroSurveyPointTextAnswer("", getInputHint()), getMaxCharacterCountForAnswer(this.answerItems.size())));
            removeNotificationView();
            this.answerContainer.addView(createDividerView$default(this, false, 1, null));
            this.answerContainer.addView(createAnswerItemView((MicroSurveyPointTextItem) CollectionsKt.last((List) this.answerItems)));
            Integer num = this.followUpEditsRemaining;
            this.followUpEditsRemaining = num != null ? Integer.valueOf(num.intValue() - 1) : null;
            addNotificationViewIfShould();
            scrollToEnd();
        }
    }

    private final void addNotificationViewIfShould() {
        String str;
        if (isFollowUpEnabled() && !hasFollowUpEditsRemaining()) {
            removeNotificationView();
            View viewCreateDividerView = createDividerView(false);
            this.notificationSpacerView = viewCreateDividerView;
            this.answerContainer.addView(viewCreateDividerView);
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_notification, (ViewGroup) this.answerContainer, false);
            TextView textView = (TextView) viewInflate.findViewById(C8369R.id.item_micro_notification_label);
            ViewDependencies viewDependencies = this.viewDependencies;
            BindingData bindingData = null;
            if (viewDependencies == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
                viewDependencies = null;
            }
            FontProvider fontProvider = viewDependencies.getFontProvider();
            Context context = viewInflate.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTypeface(fontProvider.provideFont(context, FontType.REGULAR));
            BindingData bindingData2 = this.bindingData;
            if (bindingData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            } else {
                bindingData = bindingData2;
            }
            String followUpLimitReachedNotification = bindingData.getFollowUpLimitReachedNotification();
            if (followUpLimitReachedNotification != null) {
                str = followUpLimitReachedNotification;
            } else {
                String string = getContext().getString(C8369R.string.survicate_micro_follow_up_limit_reached);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
            }
            textView.setText(str);
            this.notificationView = viewInflate;
            this.answerContainer.addView(viewInflate);
        }
    }

    private final void removeNotificationView() {
        View view = this.notificationSpacerView;
        if (view != null) {
            this.answerContainer.removeView(view);
            this.notificationSpacerView = null;
        }
        View view2 = this.notificationView;
        if (view2 != null) {
            this.answerContainer.removeView(view2);
            this.notificationView = null;
        }
    }

    public final void showProgressAnimation() {
        if (isAiFollowUpAvailable() && this.progressView == null) {
            ColorScheme colorScheme = null;
            View viewCreateDividerView$default = createDividerView$default(this, false, 1, null);
            this.progressDividerView = viewCreateDividerView$default;
            this.answerContainer.addView(viewCreateDividerView$default);
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_dots_progress_bar, (ViewGroup) this.answerContainer, false);
            MicroDotsProgressBar microDotsProgressBar = (MicroDotsProgressBar) viewInflate.findViewById(C8369R.id.item_micro_dots_progress_bar);
            ColorScheme colorScheme2 = this.colorScheme;
            if (colorScheme2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            } else {
                colorScheme = colorScheme2;
            }
            microDotsProgressBar.inject(colorScheme);
            microDotsProgressBar.startAnimation();
            this.progressView = viewInflate;
            this.answerContainer.addView(viewInflate);
            this.answerContainer.clearFocus();
            disableTouchInput();
            scrollToEnd();
        }
    }

    private final void removeProgressView() {
        View view = this.progressDividerView;
        if (view != null) {
            this.answerContainer.removeView(view);
            this.progressDividerView = null;
        }
        View view2 = this.progressView;
        if (view2 != null) {
            this.answerContainer.removeView(view2);
            this.progressView = null;
        }
    }

    private final void disableTouchInput() {
        this.isTouchInputEnabled = false;
    }

    private final void enableTouchInput() {
        this.isTouchInputEnabled = true;
    }

    public final void scrollToEnd() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (AccessibilityUtils.isTalkbackEnabled(context)) {
            return;
        }
        View childAt = this.answerContainer.getChildAt(r0.getChildCount() - 1);
        if (childAt != null) {
            ViewExtensionsKt.requestOnScreen(childAt, false);
        }
    }

    private final void setupScrollOnInputFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointTextContentView.setupScrollOnInputFocus$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnInputFocus$lambda$6(MicroSurveyPointTextContentView microSurveyPointTextContentView) {
        microSurveyPointTextContentView.scrollFocusedInputIntoView();
        return Unit.INSTANCE;
    }

    private final void scrollFocusedInputIntoView() {
        View viewFindFocus;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (AccessibilityUtils.isTalkbackEnabled(context) || (viewFindFocus = findFocus()) == null) {
            return;
        }
        ViewExtensionsKt.requestOnScreen$default(viewFindFocus, false, 1, null);
    }

    /* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006#"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "textPlaceholder", "", "followUpLimit", "", "followUpLimitReachedNotification", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getTextPlaceholder", "()Ljava/lang/String;", "getFollowUpLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFollowUpLimitReachedNotification", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$BindingData;", "equals", "", "other", "hashCode", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final Integer followUpLimit;
        private final String followUpLimitReachedNotification;
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyQuestionSurveyPoint surveyPoint;
        private final String textPlaceholder;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyQuestionSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            if ((i & 4) != 0) {
                str = bindingData.textPlaceholder;
            }
            if ((i & 8) != 0) {
                num = bindingData.followUpLimit;
            }
            if ((i & 16) != 0) {
                str2 = bindingData.followUpLimitReachedNotification;
            }
            String str3 = str2;
            String str4 = str;
            return bindingData.copy(surveyQuestionSurveyPoint, questionHeaderBindingData, str4, num, str3);
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
        public final String getTextPlaceholder() {
            return this.textPlaceholder;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getFollowUpLimit() {
            return this.followUpLimit;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFollowUpLimitReachedNotification() {
            return this.followUpLimitReachedNotification;
        }

        public final BindingData copy(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String textPlaceholder, Integer followUpLimit, String followUpLimitReachedNotification) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(textPlaceholder, "textPlaceholder");
            return new BindingData(surveyPoint, questionHeaderBindingData, textPlaceholder, followUpLimit, followUpLimitReachedNotification);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData) && Intrinsics.areEqual(this.textPlaceholder, bindingData.textPlaceholder) && Intrinsics.areEqual(this.followUpLimit, bindingData.followUpLimit) && Intrinsics.areEqual(this.followUpLimitReachedNotification, bindingData.followUpLimitReachedNotification);
        }

        public int hashCode() {
            int iHashCode = ((((this.surveyPoint.hashCode() * 31) + this.questionHeaderBindingData.hashCode()) * 31) + this.textPlaceholder.hashCode()) * 31;
            Integer num = this.followUpLimit;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.followUpLimitReachedNotification;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ", textPlaceholder=" + this.textPlaceholder + ", followUpLimit=" + this.followUpLimit + ", followUpLimitReachedNotification=" + this.followUpLimitReachedNotification + ')';
        }

        public BindingData(SurveyQuestionSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String textPlaceholder, Integer num, String str) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            Intrinsics.checkNotNullParameter(textPlaceholder, "textPlaceholder");
            this.surveyPoint = surveyPoint;
            this.questionHeaderBindingData = questionHeaderBindingData;
            this.textPlaceholder = textPlaceholder;
            this.followUpLimit = num;
            this.followUpLimitReachedNotification = str;
        }

        public /* synthetic */ BindingData(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(surveyQuestionSurveyPoint, questionHeaderBindingData, str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str2);
        }

        public final SurveyQuestionSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final String getTextPlaceholder() {
            return this.textPlaceholder;
        }

        public final Integer getFollowUpLimit() {
            return this.followUpLimit;
        }

        public final String getFollowUpLimitReachedNotification() {
            return this.followUpLimitReachedNotification;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$SavedState;", "Landroid/os/Parcelable;", "answerItemStates", "", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$AnswerItemState;", "followUpEditsRemaining", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getAnswerItemStates", "()Ljava/util/List;", "getFollowUpEditsRemaining", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$SavedState;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final List<AnswerItemState> answerItemStates;
        private final Integer followUpEditsRemaining;

        /* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(AnswerItemState.CREATOR.createFromParcel(parcel));
                }
                return new SavedState(arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SavedState copy$default(SavedState savedState, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = savedState.answerItemStates;
            }
            if ((i & 2) != 0) {
                num = savedState.followUpEditsRemaining;
            }
            return savedState.copy(list, num);
        }

        public final List<AnswerItemState> component1() {
            return this.answerItemStates;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getFollowUpEditsRemaining() {
            return this.followUpEditsRemaining;
        }

        public final SavedState copy(List<AnswerItemState> answerItemStates, Integer followUpEditsRemaining) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            return new SavedState(answerItemStates, followUpEditsRemaining);
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
            return Intrinsics.areEqual(this.answerItemStates, savedState.answerItemStates) && Intrinsics.areEqual(this.followUpEditsRemaining, savedState.followUpEditsRemaining);
        }

        public int hashCode() {
            int iHashCode = this.answerItemStates.hashCode() * 31;
            Integer num = this.followUpEditsRemaining;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "SavedState(answerItemStates=" + this.answerItemStates + ", followUpEditsRemaining=" + this.followUpEditsRemaining + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            int iIntValue;
            Intrinsics.checkNotNullParameter(dest, "dest");
            List<AnswerItemState> list = this.answerItemStates;
            dest.writeInt(list.size());
            Iterator<AnswerItemState> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
            Integer num = this.followUpEditsRemaining;
            if (num == null) {
                iIntValue = 0;
            } else {
                dest.writeInt(1);
                iIntValue = num.intValue();
            }
            dest.writeInt(iIntValue);
        }

        public SavedState(List<AnswerItemState> answerItemStates, Integer num) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            this.answerItemStates = answerItemStates;
            this.followUpEditsRemaining = num;
        }

        public final List<AnswerItemState> getAnswerItemStates() {
            return this.answerItemStates;
        }

        public final Integer getFollowUpEditsRemaining() {
            return this.followUpEditsRemaining;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView$AnswerItemState;", "Landroid/os/Parcelable;", "input", "", "followUpQuestion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getInput", "()Ljava/lang/String;", "getFollowUpQuestion", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class AnswerItemState implements Parcelable {
        public static final Parcelable.Creator<AnswerItemState> CREATOR = new Creator();
        private final String followUpQuestion;
        private final String input;

        /* JADX INFO: compiled from: MicroSurveyPointTextContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<AnswerItemState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AnswerItemState(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState[] newArray(int i) {
                return new AnswerItemState[i];
            }
        }

        public static /* synthetic */ AnswerItemState copy$default(AnswerItemState answerItemState, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answerItemState.input;
            }
            if ((i & 2) != 0) {
                str2 = answerItemState.followUpQuestion;
            }
            return answerItemState.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInput() {
            return this.input;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFollowUpQuestion() {
            return this.followUpQuestion;
        }

        public final AnswerItemState copy(String input, String followUpQuestion) {
            Intrinsics.checkNotNullParameter(input, "input");
            return new AnswerItemState(input, followUpQuestion);
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
            return Intrinsics.areEqual(this.input, answerItemState.input) && Intrinsics.areEqual(this.followUpQuestion, answerItemState.followUpQuestion);
        }

        public int hashCode() {
            int iHashCode = this.input.hashCode() * 31;
            String str = this.followUpQuestion;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "AnswerItemState(input=" + this.input + ", followUpQuestion=" + this.followUpQuestion + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.input);
            dest.writeString(this.followUpQuestion);
        }

        public AnswerItemState(String input, String str) {
            Intrinsics.checkNotNullParameter(input, "input");
            this.input = input;
            this.followUpQuestion = str;
        }

        public final String getInput() {
            return this.input;
        }

        public final String getFollowUpQuestion() {
            return this.followUpQuestion;
        }
    }

    private final void setupList(Bundle savedState) {
        SavedState savedState2;
        Integer followUpLimit;
        List<MicroSurveyPointTextItem> listBuildAnswerItems;
        Parcelable parcelable;
        BindingData bindingData = null;
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
        if (savedState2 == null || (followUpLimit = savedState2.getFollowUpEditsRemaining()) == null) {
            BindingData bindingData2 = this.bindingData;
            if (bindingData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            } else {
                bindingData = bindingData2;
            }
            followUpLimit = bindingData.getFollowUpLimit();
        }
        this.followUpEditsRemaining = followUpLimit;
        if (savedState2 != null) {
            listBuildAnswerItems = rebuildAnswerItems(savedState2.getAnswerItemStates());
        } else {
            listBuildAnswerItems = buildAnswerItems();
        }
        this.answerItems = listBuildAnswerItems;
        rebuildAnswerViews();
    }
}
