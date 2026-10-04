package com.survicate.surveys.presentation.matrix.micro;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateSelectionType;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.matrix.MatrixColumn;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.theming.MicroSelectionDrawableFactory;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateCommentField;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 k2\u00020\u0001:\u0004klmnB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010<\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0018\u0010=\u001a\u00020\u00172\u0006\u00101\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010?J\b\u0010@\u001a\u00020\u0017H\u0002J\u0012\u0010A\u001a\u00020\u00172\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020DH\u0002J\u0018\u0010H\u001a\u00020\u00172\u0006\u0010G\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0002J\u0018\u0010I\u001a\u00020\u00172\u0006\u0010G\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0002J\u0014\u0010J\u001a\u00020\u0017*\u00020K2\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010L\u001a\u00020\u00172\u0006\u0010G\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020,H\u0002J\u0010\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020DH\u0002J \u0010Q\u001a\u00020\u00172\u0006\u0010P\u001a\u00020D2\u0006\u0010R\u001a\u00020S2\u0006\u0010E\u001a\u00020\fH\u0002J(\u0010T\u001a\u00020\u00172\u0006\u0010P\u001a\u00020D2\u0006\u0010R\u001a\u00020S2\u0006\u0010E\u001a\u00020\f2\u0006\u0010U\u001a\u00020%H\u0002J\u0010\u0010V\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010X\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010Y\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\u0010\u0010Z\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\u0018\u0010[\u001a\u00020\u00172\u0006\u0010R\u001a\u00020S2\u0006\u0010E\u001a\u00020\fH\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\f2\u0006\u0010]\u001a\u00020\fH\u0002J\u0010\u0010^\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\fH\u0002J\b\u0010_\u001a\u00020\u0017H\u0002J\b\u0010`\u001a\u00020\u0017H\u0002J\b\u0010a\u001a\u00020\u0017H\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010E\u001a\u00020\fH\u0002J \u0010d\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\u0006\u0010E\u001a\u00020\f2\u0006\u0010U\u001a\u00020%H\u0002J\n\u0010e\u001a\u0004\u0018\u00010fH\u0002J\u0012\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020jH\u0002R*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRa\u0010\u001c\u001aI\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RL\u0010$\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006o"}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixAnswerItem;", "answerItems", "getAnswerItems", "()Ljava/util/List;", "onColumnSelected", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "answerId", "columnId", "", "getOnColumnSelected", "()Lkotlin/jvm/functions/Function2;", "setOnColumnSelected", "(Lkotlin/jvm/functions/Function2;)V", "onCommentChanged", "Lkotlin/Function3;", "", ClientCookie.COMMENT_ATTR, "getOnCommentChanged", "()Lkotlin/jvm/functions/Function3;", "setOnCommentChanged", "(Lkotlin/jvm/functions/Function3;)V", "onExpandedChanged", "", "isExpanded", "getOnExpandedChanged", "setOnExpandedChanged", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "answerContainer", "Landroid/widget/LinearLayout;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindingData", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$BindingData;", "itemOfLastFocusedComment", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "surveyPointSettings", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "getSurveyPointSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "bindHeader", "setupList", "buildAnswerItems", "createAnswerItemView", "Landroid/view/View;", "answerItem", "setupAnswerItemView", "itemView", "bindAnswerItem", "bindAnswerHeader", "configureMaxLines", "Landroid/widget/TextView;", "bindColumns", "createColumnView", "columnsContainer", "setupColumnView", "columnView", "bindColumnView", "columnItem", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixColumnItem;", "bindCommentField", "isSelected", "onHeaderClick", "collapseItem", "expandItem", "focusHeaderOf", "scrollToAnswerItem", "onColumnClick", "findNextUnansweredItem", "currentItem", "rebindAnswerItem", "setupScrollOnCommentFocus", "restoreCommentFocus", "clearCommentFieldFocus", "findCommentFieldForSelectedColumn", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "buildColumnContentDescription", "getRadioButtonDrawable", "Landroid/graphics/drawable/Drawable;", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "Companion", "BindingData", "SavedState", "AnswerItemState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointMatrixContentView extends FrameLayout {
    public static final String SAVED_STATE = "SAVED_STATE";
    private final LinearLayout answerContainer;
    private List<MicroSurveyPointMatrixAnswerItem> answerItems;
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private MicroSurveyPointMatrixAnswerItem itemOfLastFocusedComment;
    private Function2<? super Long, ? super Long, Unit> onColumnSelected;
    private Function3<? super Long, ? super Long, ? super String, Unit> onCommentChanged;
    private Function2<? super Long, ? super Boolean, Unit> onExpandedChanged;
    private final MicroQuestionHeader questionHeaderView;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointMatrixContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointMatrixContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointMatrixContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointMatrixContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.answerItems = CollectionsKt.emptyList();
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_matrix_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_matrix_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_matrix_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.answerContainer = (LinearLayout) viewFindViewById2;
    }

    public final List<MicroSurveyPointMatrixAnswerItem> getAnswerItems() {
        return this.answerItems;
    }

    public final Function2<Long, Long, Unit> getOnColumnSelected() {
        return this.onColumnSelected;
    }

    public final void setOnColumnSelected(Function2<? super Long, ? super Long, Unit> function2) {
        this.onColumnSelected = function2;
    }

    public final Function3<Long, Long, String, Unit> getOnCommentChanged() {
        return this.onCommentChanged;
    }

    public final void setOnCommentChanged(Function3<? super Long, ? super Long, ? super String, Unit> function3) {
        this.onCommentChanged = function3;
    }

    public final Function2<Long, Boolean, Unit> getOnExpandedChanged() {
        return this.onExpandedChanged;
    }

    public final void setOnExpandedChanged(Function2<? super Long, ? super Boolean, Unit> function2) {
        this.onExpandedChanged = function2;
    }

    private final SurveyQuestionSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    private final SurveyPointMatrixSettings getSurveyPointSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings");
        return (SurveyPointMatrixSettings) settings;
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

    private final void setupList(Bundle savedState) {
        this.answerItems = buildAnswerItems(savedState);
        this.answerContainer.removeAllViews();
        Iterator<MicroSurveyPointMatrixAnswerItem> it = this.answerItems.iterator();
        while (it.hasNext()) {
            this.answerContainer.addView(createAnswerItemView(it.next()));
        }
    }

    private final View createAnswerItemView(MicroSurveyPointMatrixAnswerItem answerItem) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_matrix_answer, (ViewGroup) this.answerContainer, false);
        Intrinsics.checkNotNull(viewInflate);
        setupAnswerItemView(viewInflate);
        bindAnswerItem(viewInflate, answerItem);
        return viewInflate;
    }

    private final void setupAnswerItemView(View itemView) {
        View viewFindViewById = itemView.findViewById(C8369R.id.item_micro_matrix_answer_header);
        TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_matrix_answer_header_subtitle);
        ImageView imageView = (ImageView) itemView.findViewById(C8369R.id.item_micro_matrix_answer_header_toggle);
        ViewCompat.setAccessibilityDelegate(viewFindViewById, new AccessibilityUtils.ExpandableViewAccessibilityDelegate());
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExtensionsKt.clipChildrenToBackground(viewFindViewById);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        ColorScheme colorScheme2 = null;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        viewFindViewById.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, false));
        ColorScheme colorScheme3 = this.colorScheme;
        if (colorScheme3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme3 = null;
        }
        textView.setTextColor(colorScheme3.getButton());
        ColorScheme colorScheme4 = this.colorScheme;
        if (colorScheme4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme2 = colorScheme4;
        }
        imageView.setImageTintList(ColorStateList.valueOf(colorScheme2.getAnswer()));
    }

    private final void bindAnswerItem(View itemView, MicroSurveyPointMatrixAnswerItem answerItem) {
        bindAnswerHeader(itemView, answerItem);
        bindColumns(itemView, answerItem);
    }

    private final void bindAnswerHeader(View itemView, final MicroSurveyPointMatrixAnswerItem answerItem) {
        String name;
        View viewFindViewById = itemView.findViewById(C8369R.id.item_micro_matrix_answer_header);
        TextView textView = (TextView) itemView.findViewById(C8369R.id.item_micro_matrix_answer_header_title);
        TextView textView2 = (TextView) itemView.findViewById(C8369R.id.item_micro_matrix_answer_header_subtitle);
        ImageView imageView = (ImageView) itemView.findViewById(C8369R.id.item_micro_matrix_answer_header_toggle);
        textView.setTypeface(provideFont(FontType.REGULAR));
        textView.setText(answerItem.getTitle());
        Intrinsics.checkNotNull(textView);
        configureMaxLines(textView, answerItem.getIsExpanded());
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        textView.setTextColor(colorScheme.getAnswer());
        textView2.setTypeface(provideFont(FontType.REGULAR));
        MicroSurveyPointMatrixColumnItem selectedColumn = answerItem.getSelectedColumn();
        if (selectedColumn == null || (name = selectedColumn.getName()) == null) {
            name = "";
        }
        textView2.setText(name);
        Intrinsics.checkNotNull(textView2);
        configureMaxLines(textView2, answerItem.getIsExpanded());
        textView2.setVisibility(answerItem.getSelectedColumn() != null ? 0 : 8);
        imageView.setRotation(answerItem.getIsExpanded() ? 90.0f : 270.0f);
        AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
        Intrinsics.checkNotNull(viewFindViewById);
        accessibilityUtils.setExpandedState(viewFindViewById, answerItem.getIsExpanded());
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onHeaderClick(answerItem);
            }
        });
    }

    private final void configureMaxLines(TextView textView, boolean z) {
        textView.setMaxLines(z ? Integer.MAX_VALUE : 1);
        textView.setEllipsize(z ? null : TextUtils.TruncateAt.END);
    }

    private final void bindColumns(View itemView, MicroSurveyPointMatrixAnswerItem answerItem) {
        View viewCreateColumnView;
        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(C8369R.id.item_micro_matrix_answer_columns_container);
        if (!answerItem.getIsExpanded()) {
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(8);
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
        int size = answerItem.getColumns().size();
        for (int i = 0; i < size; i++) {
            MicroSurveyPointMatrixColumnItem microSurveyPointMatrixColumnItem = answerItem.getColumns().get(i);
            if (i < linearLayout.getChildCount()) {
                viewCreateColumnView = linearLayout.getChildAt(i);
            } else {
                viewCreateColumnView = createColumnView(linearLayout);
                linearLayout.addView(viewCreateColumnView);
            }
            Intrinsics.checkNotNull(viewCreateColumnView);
            bindColumnView(viewCreateColumnView, microSurveyPointMatrixColumnItem, answerItem);
        }
    }

    private final View createColumnView(LinearLayout columnsContainer) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8369R.layout.item_micro_matrix_column, (ViewGroup) columnsContainer, false);
        Intrinsics.checkNotNull(viewInflate);
        setupColumnView(viewInflate);
        return viewInflate;
    }

    private final void setupColumnView(View columnView) {
        ((RadioButton) columnView.findViewById(C8369R.id.item_micro_matrix_column_radio_button)).setSaveEnabled(false);
        View viewFindViewById = columnView.findViewById(C8369R.id.item_micro_matrix_comment_field);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        MicroSurvicateCommentField microSurvicateCommentField = (MicroSurvicateCommentField) viewFindViewById;
        ViewDependencies viewDependencies = this.viewDependencies;
        ColorScheme colorScheme = null;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme2;
        }
        microSurvicateCommentField.inject(viewDependencies, colorScheme);
    }

    private final void bindColumnView(View columnView, final MicroSurveyPointMatrixColumnItem columnItem, final MicroSurveyPointMatrixAnswerItem answerItem) {
        View viewFindViewById = columnView.findViewById(C8369R.id.item_micro_matrix_column_radio_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RadioButton radioButton = (RadioButton) viewFindViewById;
        View viewFindViewById2 = columnView.findViewById(C8369R.id.item_micro_matrix_column_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        boolean zAreEqual = Intrinsics.areEqual(answerItem.getSelectedColumn(), columnItem);
        columnView.setSelected(zAreEqual);
        columnView.setContentDescription(buildColumnContentDescription(columnItem, answerItem, zAreEqual));
        ViewExtensionsKt.clipChildrenToBackground(columnView);
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        ColorScheme colorScheme2 = null;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        columnView.setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, zAreEqual));
        columnView.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onColumnClick(columnItem, answerItem);
            }
        });
        ColorScheme colorScheme3 = this.colorScheme;
        if (colorScheme3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme3 = null;
        }
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        TextViewExtensionsKt.applyQuestionOptionStyle(textView, zAreEqual, colorScheme3, viewDependencies.getFontProvider());
        textView.setText(columnItem.getName());
        MicroSelectionDrawableFactory microSelectionDrawableFactory = MicroSelectionDrawableFactory.INSTANCE;
        ColorScheme colorScheme4 = this.colorScheme;
        if (colorScheme4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme2 = colorScheme4;
        }
        radioButton.setBackground(microSelectionDrawableFactory.createRipple(colorScheme2));
        radioButton.setButtonDrawable(getRadioButtonDrawable());
        radioButton.setChecked(zAreEqual);
        bindCommentField(columnView, columnItem, answerItem, zAreEqual);
    }

    private final void bindCommentField(View columnView, final MicroSurveyPointMatrixColumnItem columnItem, final MicroSurveyPointMatrixAnswerItem answerItem, boolean isSelected) {
        View viewFindViewById = columnView.findViewById(C8369R.id.item_micro_matrix_comment_field);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        MicroSurvicateCommentField microSurvicateCommentField = (MicroSurvicateCommentField) viewFindViewById;
        microSurvicateCommentField.setVisibility(answerItem.getIsCommentAvailable() && isSelected ? 0 : 8);
        microSurvicateCommentField.setLabel(answerItem.getCommentLabel());
        microSurvicateCommentField.setInputHint(answerItem.getCommentHint());
        microSurvicateCommentField.bindTextInput(columnItem.getComment(), new Function1() { // from class: com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyPointMatrixContentView.bindCommentField$lambda$5(columnItem, this, answerItem, (String) obj);
            }
        });
        microSurvicateCommentField.setOnInputFocus(new Function0() { // from class: com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointMatrixContentView.bindCommentField$lambda$6(this.f$0, answerItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$5(MicroSurveyPointMatrixColumnItem microSurveyPointMatrixColumnItem, MicroSurveyPointMatrixContentView microSurveyPointMatrixContentView, MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        microSurveyPointMatrixColumnItem.setComment(comment);
        Function3<? super Long, ? super Long, ? super String, Unit> function3 = microSurveyPointMatrixContentView.onCommentChanged;
        if (function3 != null) {
            function3.invoke(Long.valueOf(microSurveyPointMatrixAnswerItem.getId()), Long.valueOf(microSurveyPointMatrixColumnItem.getId()), comment);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCommentField$lambda$6(MicroSurveyPointMatrixContentView microSurveyPointMatrixContentView, MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem) {
        microSurveyPointMatrixContentView.itemOfLastFocusedComment = microSurveyPointMatrixAnswerItem;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHeaderClick(MicroSurveyPointMatrixAnswerItem answerItem) {
        if (answerItem.getIsExpanded()) {
            clearCommentFieldFocus();
            collapseItem(answerItem);
        } else {
            expandItem(answerItem);
            focusHeaderOf(answerItem);
        }
    }

    private final void collapseItem(MicroSurveyPointMatrixAnswerItem answerItem) {
        answerItem.setExpanded(false);
        Function2<? super Long, ? super Boolean, Unit> function2 = this.onExpandedChanged;
        if (function2 != null) {
            function2.invoke(Long.valueOf(answerItem.getId()), false);
        }
        rebindAnswerItem(answerItem);
    }

    private final void expandItem(MicroSurveyPointMatrixAnswerItem answerItem) {
        answerItem.setExpanded(true);
        Function2<? super Long, ? super Boolean, Unit> function2 = this.onExpandedChanged;
        if (function2 != null) {
            function2.invoke(Long.valueOf(answerItem.getId()), true);
        }
        rebindAnswerItem(answerItem);
        scrollToAnswerItem(answerItem);
    }

    private final void focusHeaderOf(MicroSurveyPointMatrixAnswerItem answerItem) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (AccessibilityUtils.isTalkbackEnabled(context)) {
            return;
        }
        View childAt = this.answerContainer.getChildAt(this.answerItems.indexOf(answerItem));
        if (childAt == null) {
            return;
        }
        childAt.findViewById(C8369R.id.item_micro_matrix_answer_header).requestFocus();
    }

    private final void scrollToAnswerItem(MicroSurveyPointMatrixAnswerItem answerItem) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (AccessibilityUtils.isTalkbackEnabled(context)) {
            return;
        }
        View childAt = this.answerContainer.getChildAt(this.answerItems.indexOf(answerItem));
        if (childAt == null) {
            return;
        }
        ViewExtensionsKt.requestOnScreen(childAt, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColumnClick(MicroSurveyPointMatrixColumnItem columnItem, MicroSurveyPointMatrixAnswerItem answerItem) {
        clearCommentFieldFocus();
        answerItem.setSelectedColumnId(Long.valueOf(columnItem.getId()));
        Function2<? super Long, ? super Long, Unit> function2 = this.onColumnSelected;
        if (function2 != null) {
            function2.invoke(Long.valueOf(answerItem.getId()), Long.valueOf(columnItem.getId()));
        }
        if (!answerItem.getIsCommentAvailable()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (!AccessibilityUtils.isTalkbackEnabled(context)) {
                MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItemFindNextUnansweredItem = findNextUnansweredItem(answerItem);
                if (microSurveyPointMatrixAnswerItemFindNextUnansweredItem != null) {
                    collapseItem(answerItem);
                    expandItem(microSurveyPointMatrixAnswerItemFindNextUnansweredItem);
                    focusHeaderOf(microSurveyPointMatrixAnswerItemFindNextUnansweredItem);
                    return;
                } else {
                    collapseItem(answerItem);
                    focusHeaderOf(answerItem);
                    return;
                }
            }
        }
        rebindAnswerItem(answerItem);
    }

    private final MicroSurveyPointMatrixAnswerItem findNextUnansweredItem(MicroSurveyPointMatrixAnswerItem currentItem) {
        int size = this.answerItems.size();
        for (int iIndexOf = this.answerItems.indexOf(currentItem) + 1; iIndexOf < size; iIndexOf++) {
            MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem = this.answerItems.get(iIndexOf);
            if (microSurveyPointMatrixAnswerItem.getSelectedColumn() == null) {
                return microSurveyPointMatrixAnswerItem;
            }
        }
        return null;
    }

    private final void rebindAnswerItem(MicroSurveyPointMatrixAnswerItem answerItem) {
        View childAt = this.answerContainer.getChildAt(this.answerItems.indexOf(answerItem));
        if (childAt == null) {
            return;
        }
        bindAnswerItem(childAt, answerItem);
    }

    private final void setupScrollOnCommentFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointMatrixContentView.setupScrollOnCommentFocus$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnCommentFocus$lambda$7(MicroSurveyPointMatrixContentView microSurveyPointMatrixContentView) {
        microSurveyPointMatrixContentView.restoreCommentFocus();
        return Unit.INSTANCE;
    }

    private final void restoreCommentFocus() {
        MicroSurvicateCommentField microSurvicateCommentFieldFindCommentFieldForSelectedColumn;
        MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem = this.itemOfLastFocusedComment;
        if (microSurveyPointMatrixAnswerItem != null && (microSurvicateCommentFieldFindCommentFieldForSelectedColumn = findCommentFieldForSelectedColumn(microSurveyPointMatrixAnswerItem)) != null && microSurveyPointMatrixAnswerItem.getIsExpanded() && microSurvicateCommentFieldFindCommentFieldForSelectedColumn.isAttachedToWindow()) {
            microSurvicateCommentFieldFindCommentFieldForSelectedColumn.scrollTo();
        }
    }

    private final void clearCommentFieldFocus() {
        MicroSurvicateCommentField microSurvicateCommentFieldFindCommentFieldForSelectedColumn;
        MicroSurveyPointMatrixAnswerItem microSurveyPointMatrixAnswerItem = this.itemOfLastFocusedComment;
        if (microSurveyPointMatrixAnswerItem == null || (microSurvicateCommentFieldFindCommentFieldForSelectedColumn = findCommentFieldForSelectedColumn(microSurveyPointMatrixAnswerItem)) == null) {
            return;
        }
        microSurvicateCommentFieldFindCommentFieldForSelectedColumn.clearInputFocus();
        this.itemOfLastFocusedComment = null;
    }

    private final MicroSurvicateCommentField findCommentFieldForSelectedColumn(MicroSurveyPointMatrixAnswerItem answerItem) {
        View childAt;
        MicroSurveyPointMatrixColumnItem selectedColumn = answerItem.getSelectedColumn();
        if (selectedColumn == null) {
            return null;
        }
        View childAt2 = this.answerContainer.getChildAt(this.answerItems.indexOf(answerItem));
        if (childAt2 == null || (childAt = ((LinearLayout) childAt2.findViewById(C8369R.id.item_micro_matrix_answer_columns_container)).getChildAt(answerItem.getColumns().indexOf(selectedColumn))) == null) {
            return null;
        }
        return (MicroSurvicateCommentField) childAt.findViewById(C8369R.id.item_micro_matrix_comment_field);
    }

    private final String buildColumnContentDescription(MicroSurveyPointMatrixColumnItem columnItem, MicroSurveyPointMatrixAnswerItem answerItem, boolean isSelected) {
        StringBuilder sb = new StringBuilder();
        sb.append(columnItem.getName());
        sb.append(": ");
        sb.append(answerItem.getTitle());
        if (answerItem.getIsCommentAvailable() && isSelected && !StringsKt.isBlank(answerItem.getCommentLabel())) {
            sb.append(". ");
            sb.append(answerItem.getCommentLabel());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final Drawable getRadioButtonDrawable() {
        MicroSelectionDrawableFactory microSelectionDrawableFactory = MicroSelectionDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        return microSelectionDrawableFactory.createDrawable(context, colorScheme, MicroSurvicateSelectionType.Radio);
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

    /* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "orderedAnswers", "", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "commentHint", "", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Ljava/util/List;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;Ljava/lang/String;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "getOrderedAnswers", "()Ljava/util/List;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getCommentHint", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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

    /* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
    @Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$SavedState;", "Landroid/os/Parcelable;", "answerItemStates", "", "", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$AnswerItemState;", "answerOrder", "", "<init>", "(Ljava/util/Map;Ljava/util/List;)V", "getAnswerItemStates", "()Ljava/util/Map;", "getAnswerOrder", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final Map<Long, AnswerItemState> answerItemStates;
        private final List<Long> answerOrder;

        /* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
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
                return new SavedState(linkedHashMap2, arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SavedState copy$default(SavedState savedState, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                map = savedState.answerItemStates;
            }
            if ((i & 2) != 0) {
                list = savedState.answerOrder;
            }
            return savedState.copy(map, list);
        }

        public final Map<Long, AnswerItemState> component1() {
            return this.answerItemStates;
        }

        public final List<Long> component2() {
            return this.answerOrder;
        }

        public final SavedState copy(Map<Long, AnswerItemState> answerItemStates, List<Long> answerOrder) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            return new SavedState(answerItemStates, answerOrder);
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
            return Intrinsics.areEqual(this.answerItemStates, savedState.answerItemStates) && Intrinsics.areEqual(this.answerOrder, savedState.answerOrder);
        }

        public int hashCode() {
            int iHashCode = this.answerItemStates.hashCode() * 31;
            List<Long> list = this.answerOrder;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "SavedState(answerItemStates=" + this.answerItemStates + ", answerOrder=" + this.answerOrder + ')';
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

        public SavedState(Map<Long, AnswerItemState> answerItemStates, List<Long> list) {
            Intrinsics.checkNotNullParameter(answerItemStates, "answerItemStates");
            this.answerItemStates = answerItemStates;
            this.answerOrder = list;
        }

        public /* synthetic */ SavedState(Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i & 2) != 0 ? null : list);
        }

        public final Map<Long, AnswerItemState> getAnswerItemStates() {
            return this.answerItemStates;
        }

        public final List<Long> getAnswerOrder() {
            return this.answerOrder;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, m1599d2 = {"Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$AnswerItemState;", "Landroid/os/Parcelable;", "selectedColumnId", "", "isExpanded", "", "columnComments", "", "", "<init>", "(Ljava/lang/Long;ZLjava/util/Map;)V", "getSelectedColumnId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getColumnComments", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;ZLjava/util/Map;)Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView$AnswerItemState;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class AnswerItemState implements Parcelable {
        public static final Parcelable.Creator<AnswerItemState> CREATOR = new Creator();
        private final Map<Long, String> columnComments;
        private final boolean isExpanded;
        private final Long selectedColumnId;

        /* JADX INFO: compiled from: MicroSurveyPointMatrixContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<AnswerItemState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
                boolean z = parcel.readInt() != 0;
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap.put(Long.valueOf(parcel.readLong()), parcel.readString());
                }
                return new AnswerItemState(lValueOf, z, linkedHashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnswerItemState[] newArray(int i) {
                return new AnswerItemState[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnswerItemState copy$default(AnswerItemState answerItemState, Long l, boolean z, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                l = answerItemState.selectedColumnId;
            }
            if ((i & 2) != 0) {
                z = answerItemState.isExpanded;
            }
            if ((i & 4) != 0) {
                map = answerItemState.columnComments;
            }
            return answerItemState.copy(l, z, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getSelectedColumnId() {
            return this.selectedColumnId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsExpanded() {
            return this.isExpanded;
        }

        public final Map<Long, String> component3() {
            return this.columnComments;
        }

        public final AnswerItemState copy(Long selectedColumnId, boolean isExpanded, Map<Long, String> columnComments) {
            Intrinsics.checkNotNullParameter(columnComments, "columnComments");
            return new AnswerItemState(selectedColumnId, isExpanded, columnComments);
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
            return Intrinsics.areEqual(this.selectedColumnId, answerItemState.selectedColumnId) && this.isExpanded == answerItemState.isExpanded && Intrinsics.areEqual(this.columnComments, answerItemState.columnComments);
        }

        public int hashCode() {
            Long l = this.selectedColumnId;
            return ((((l == null ? 0 : l.hashCode()) * 31) + Boolean.hashCode(this.isExpanded)) * 31) + this.columnComments.hashCode();
        }

        public String toString() {
            return "AnswerItemState(selectedColumnId=" + this.selectedColumnId + ", isExpanded=" + this.isExpanded + ", columnComments=" + this.columnComments + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            Long l = this.selectedColumnId;
            if (l == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeLong(l.longValue());
            }
            dest.writeInt(this.isExpanded ? 1 : 0);
            Map<Long, String> map = this.columnComments;
            dest.writeInt(map.size());
            for (Map.Entry<Long, String> entry : map.entrySet()) {
                dest.writeLong(entry.getKey().longValue());
                dest.writeString(entry.getValue());
            }
        }

        public AnswerItemState(Long l, boolean z, Map<Long, String> columnComments) {
            Intrinsics.checkNotNullParameter(columnComments, "columnComments");
            this.selectedColumnId = l;
            this.isExpanded = z;
            this.columnComments = columnComments;
        }

        public final Long getSelectedColumnId() {
            return this.selectedColumnId;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final Map<Long, String> getColumnComments() {
            return this.columnComments;
        }
    }

    private final List<MicroSurveyPointMatrixAnswerItem> buildAnswerItems(Bundle savedState) {
        SavedState savedState2;
        boolean z;
        boolean z2;
        Map<Long, String> columnComments;
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
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        List<QuestionPointAnswer> orderedAnswers = bindingData.getOrderedAnswers();
        String commentLabel = getSurveyPointSettings().getCommentLabel();
        BindingData bindingData2 = this.bindingData;
        if (bindingData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData2 = null;
        }
        String commentHint = bindingData2.getCommentHint();
        if (commentHint.length() == 0) {
            commentHint = getContext().getString(C8369R.string.survicate_input_text_placeholder);
            Intrinsics.checkNotNullExpressionValue(commentHint, "getString(...)");
        }
        String str = commentHint;
        Map<Long, AnswerItemState> answerItemStates = savedState2 != null ? savedState2.getAnswerItemStates() : null;
        if (answerItemStates == null) {
            answerItemStates = MapsKt.emptyMap();
        }
        List<QuestionPointAnswer> list = orderedAnswers;
        int i = 10;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            QuestionPointAnswer questionPointAnswer = (QuestionPointAnswer) obj;
            AnswerItemState answerItemState = answerItemStates.get(Long.valueOf(questionPointAnswer.getId()));
            List<MatrixColumn> scale = getSurveyPointSettings().getScale();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(scale, i));
            Iterator<T> it = scale.iterator();
            while (true) {
                String str2 = "";
                if (!it.hasNext()) {
                    break;
                }
                MatrixColumn matrixColumn = (MatrixColumn) it.next();
                String str3 = (answerItemState == null || (columnComments = answerItemState.getColumnComments()) == null) ? null : columnComments.get(Long.valueOf(matrixColumn.getId()));
                if (str3 != null) {
                    str2 = str3;
                }
                arrayList2.add(new MicroSurveyPointMatrixColumnItem(matrixColumn.getId(), matrixColumn.getName(), str2));
                i2 = i2;
            }
            int i4 = i2;
            ArrayList arrayList3 = arrayList2;
            long id = questionPointAnswer.getId();
            String possibleAnswer = questionPointAnswer.getPossibleAnswer();
            if (possibleAnswer == null) {
                possibleAnswer = "";
            }
            boolean zIsExpanded = true;
            boolean zAreEqual = Intrinsics.areEqual((Object) questionPointAnswer.getAddingCommentAvailable(), (Object) true);
            Long selectedColumnId = answerItemState != null ? answerItemState.getSelectedColumnId() : null;
            if (answerItemState != null) {
                zIsExpanded = answerItemState.isExpanded();
            } else {
                if (i4 != 0) {
                    z = zAreEqual;
                    z2 = false;
                }
                arrayList.add(new MicroSurveyPointMatrixAnswerItem(id, possibleAnswer, arrayList3, z, commentLabel, str, selectedColumnId, z2));
                i2 = i3;
                i = 10;
            }
            z2 = zIsExpanded;
            z = zAreEqual;
            arrayList.add(new MicroSurveyPointMatrixAnswerItem(id, possibleAnswer, arrayList3, z, commentLabel, str, selectedColumnId, z2));
            i2 = i3;
            i = 10;
        }
        return arrayList;
    }
}
