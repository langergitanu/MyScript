package com.survicate.surveys.presentation.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView;
import com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaContentView;
import com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView;
import com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView;
import com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView;
import com.survicate.surveys.presentation.multiple.micro.MicroSurveyPointMultipleContentView;
import com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView;
import com.survicate.surveys.presentation.numerical.micro.MicroSurveyPointNumericalContentView;
import com.survicate.surveys.presentation.page.PageItem;
import com.survicate.surveys.presentation.page.viewholder.CsatViewHolder;
import com.survicate.surveys.presentation.page.viewholder.CtaViewHolder;
import com.survicate.surveys.presentation.page.viewholder.DateViewHolder;
import com.survicate.surveys.presentation.page.viewholder.DisclaimerViewHolder;
import com.survicate.surveys.presentation.page.viewholder.FooterViewHolder;
import com.survicate.surveys.presentation.page.viewholder.FormViewHolder;
import com.survicate.surveys.presentation.page.viewholder.MatrixViewHolder;
import com.survicate.surveys.presentation.page.viewholder.MultipleViewHolder;
import com.survicate.surveys.presentation.page.viewholder.NpsViewHolder;
import com.survicate.surveys.presentation.page.viewholder.NumericalViewHolder;
import com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder;
import com.survicate.surveys.presentation.page.viewholder.ShapeViewHolder;
import com.survicate.surveys.presentation.page.viewholder.SingleViewHolder;
import com.survicate.surveys.presentation.page.viewholder.SmileyScaleViewHolder;
import com.survicate.surveys.presentation.page.viewholder.SubmitViewHolder;
import com.survicate.surveys.presentation.page.viewholder.TextViewHolder;
import com.survicate.surveys.presentation.shape.micro.MicroSurveyPointShapeContentView;
import com.survicate.surveys.presentation.single.micro.MicroSurveyPointSingleContentView;
import com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView;
import com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView;
import com.survicate.surveys.presentation.widget.MicroDisclaimerView;
import com.survicate.surveys.presentation.widget.MicroSubmitView;
import com.survicate.surveys.presentation.widget.MicroSubmitViewKt;
import com.survicate.surveys.presentation.widget.MicroSurveyFooter;
import com.survicate.surveys.presentation.widget.SubmitViewState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageAdapter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010 \u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'H\u0016J\u0018\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000202H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00107\u001a\u0002082\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010G\u001a\u00020H2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010M\u001a\u00020N2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u0010S\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010T\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006U"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "<init>", "(Lcom/survicate/surveys/helpers/ViewDependencies;Lcom/survicate/surveys/entities/survey/theme/ColorScheme;)V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/survicate/surveys/presentation/page/PageItem;", "onSubmitClick", "Lkotlin/Function0;", "", "getOnSubmitClick", "()Lkotlin/jvm/functions/Function0;", "setOnSubmitClick", "(Lkotlin/jvm/functions/Function0;)V", "onBackClick", "getOnBackClick", "setOnBackClick", "onPoweredByClick", "getOnPoweredByClick", "setOnPoweredByClick", "onDisclaimerToggle", "Lkotlin/Function1;", "", "getOnDisclaimerToggle", "()Lkotlin/jvm/functions/Function1;", "setOnDisclaimerToggle", "(Lkotlin/jvm/functions/Function1;)V", "submitList", "pageItems", "updateSubmitValidationState", "state", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "isQuestionPosition", "position", "", "getItemCount", "getItemViewType", "questionViewType", "item", "Lcom/survicate/surveys/presentation/page/PageItem$Question;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "createQuestionViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "applyPageMargins", "holder", "createSingleViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/SingleViewHolder;", "createMultipleViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/MultipleViewHolder;", "createNpsViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/NpsViewHolder;", "createSmileyScaleViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/SmileyScaleViewHolder;", "createCsatViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/CsatViewHolder;", "createNumericalViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/NumericalViewHolder;", "createShapeViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/ShapeViewHolder;", "createDateViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/DateViewHolder;", "createTextViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/TextViewHolder;", "createMatrixViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/MatrixViewHolder;", "createFormViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/FormViewHolder;", "createCtaViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/CtaViewHolder;", "createDisclaimerViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/DisclaimerViewHolder;", "createSubmitViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/SubmitViewHolder;", "createFooterViewHolder", "Lcom/survicate/surveys/presentation/page/viewholder/FooterViewHolder;", "onBindViewHolder", "onViewRecycled", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ColorScheme colorScheme;
    private List<? extends PageItem> items;
    private Function0<Unit> onBackClick;
    private Function1<? super Boolean, Unit> onDisclaimerToggle;
    private Function0<Unit> onPoweredByClick;
    private Function0<Unit> onSubmitClick;
    private final ViewDependencies viewDependencies;

    /* JADX INFO: compiled from: SurveyPageAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyAnswerType.values().length];
            try {
                iArr[SurveyAnswerType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyAnswerType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyAnswerType.NPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyAnswerType.SMILEY_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyAnswerType.CSAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SurveyAnswerType.NUMERICAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SurveyAnswerType.SHAPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SurveyAnswerType.DATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SurveyAnswerType.TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SurveyAnswerType.MATRIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SurveyAnswerType.FORM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_NEXT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_LINK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_CLOSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SurveyPageAdapter(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.items = CollectionsKt.emptyList();
    }

    public final Function0<Unit> getOnSubmitClick() {
        return this.onSubmitClick;
    }

    public final void setOnSubmitClick(Function0<Unit> function0) {
        this.onSubmitClick = function0;
    }

    public final Function0<Unit> getOnBackClick() {
        return this.onBackClick;
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        this.onBackClick = function0;
    }

    public final Function0<Unit> getOnPoweredByClick() {
        return this.onPoweredByClick;
    }

    public final void setOnPoweredByClick(Function0<Unit> function0) {
        this.onPoweredByClick = function0;
    }

    public final Function1<Boolean, Unit> getOnDisclaimerToggle() {
        return this.onDisclaimerToggle;
    }

    public final void setOnDisclaimerToggle(Function1<? super Boolean, Unit> function1) {
        this.onDisclaimerToggle = function1;
    }

    public final void submitList(List<? extends PageItem> pageItems) {
        Intrinsics.checkNotNullParameter(pageItems, "pageItems");
        this.items = pageItems;
        notifyDataSetChanged();
    }

    public final void updateSubmitValidationState(QuestionValidationState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Iterator<? extends PageItem> it = this.items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next() instanceof PageItem.Submit) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        PageItem pageItem = this.items.get(i);
        Intrinsics.checkNotNull(pageItem, "null cannot be cast to non-null type com.survicate.surveys.presentation.page.PageItem.Submit");
        List<? extends PageItem> mutableList = CollectionsKt.toMutableList((Collection) this.items);
        mutableList.set(i, PageItem.Submit.copy$default((PageItem.Submit) pageItem, null, state, 1, null));
        this.items = mutableList;
        notifyItemChanged(i);
    }

    public final boolean isQuestionPosition(int position) {
        return CollectionsKt.getOrNull(this.items, position) instanceof PageItem.Question;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        PageItem pageItem = this.items.get(position);
        if (pageItem instanceof PageItem.Question) {
            return questionViewType((PageItem.Question) pageItem);
        }
        if (pageItem instanceof PageItem.Disclaimer) {
            return -1;
        }
        if (pageItem instanceof PageItem.Submit) {
            return -2;
        }
        if (pageItem instanceof PageItem.Footer) {
            return -3;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int questionViewType(PageItem.Question item) {
        return item.getViewModel().getAnswerType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == -3) {
            return createFooterViewHolder(parent);
        }
        if (viewType == -2) {
            return createSubmitViewHolder(parent);
        }
        if (viewType == -1) {
            return createDisclaimerViewHolder(parent);
        }
        return createQuestionViewHolder(parent, viewType);
    }

    private final QuestionViewHolder createQuestionViewHolder(ViewGroup parent, int viewType) {
        SingleViewHolder singleViewHolderCreateSingleViewHolder;
        SurveyAnswerType surveyAnswerType = SurveyAnswerType.getEntries().get(viewType);
        switch (WhenMappings.$EnumSwitchMapping$0[surveyAnswerType.ordinal()]) {
            case 1:
                singleViewHolderCreateSingleViewHolder = createSingleViewHolder(parent);
                break;
            case 2:
                singleViewHolderCreateSingleViewHolder = createMultipleViewHolder(parent);
                break;
            case 3:
                singleViewHolderCreateSingleViewHolder = createNpsViewHolder(parent);
                break;
            case 4:
                singleViewHolderCreateSingleViewHolder = createSmileyScaleViewHolder(parent);
                break;
            case 5:
                singleViewHolderCreateSingleViewHolder = createCsatViewHolder(parent);
                break;
            case 6:
                singleViewHolderCreateSingleViewHolder = createNumericalViewHolder(parent);
                break;
            case 7:
                singleViewHolderCreateSingleViewHolder = createShapeViewHolder(parent);
                break;
            case 8:
                singleViewHolderCreateSingleViewHolder = createDateViewHolder(parent);
                break;
            case 9:
                singleViewHolderCreateSingleViewHolder = createTextViewHolder(parent);
                break;
            case 10:
                singleViewHolderCreateSingleViewHolder = createMatrixViewHolder(parent);
                break;
            case 11:
                singleViewHolderCreateSingleViewHolder = createFormViewHolder(parent);
                break;
            case 12:
            case 13:
            case 14:
                singleViewHolderCreateSingleViewHolder = createCtaViewHolder(parent);
                break;
            default:
                throw new IllegalArgumentException("Unsupported view type: " + surveyAnswerType);
        }
        applyPageMargins(singleViewHolderCreateSingleViewHolder);
        return singleViewHolderCreateSingleViewHolder;
    }

    private final void applyPageMargins(QuestionViewHolder holder) {
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        int dimensionPixelSize = holder.getProvidesOwnHorizontalPadding() ? 0 : itemView.getContext().getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_page_padding);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        marginLayoutParams.setMarginEnd(dimensionPixelSize);
        itemView.setLayoutParams(marginLayoutParams);
    }

    private final SingleViewHolder createSingleViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointSingleContentView microSurveyPointSingleContentView = new MicroSurveyPointSingleContentView(context, null, 0, 6, null);
        microSurveyPointSingleContentView.inject(this.viewDependencies, this.colorScheme);
        return new SingleViewHolder(microSurveyPointSingleContentView);
    }

    private final MultipleViewHolder createMultipleViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointMultipleContentView microSurveyPointMultipleContentView = new MicroSurveyPointMultipleContentView(context, null, 0, 6, null);
        microSurveyPointMultipleContentView.inject(this.viewDependencies, this.colorScheme);
        return new MultipleViewHolder(microSurveyPointMultipleContentView);
    }

    private final NpsViewHolder createNpsViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointNpsContentView microSurveyPointNpsContentView = new MicroSurveyPointNpsContentView(context, null, 0, 6, null);
        microSurveyPointNpsContentView.inject(this.viewDependencies, this.colorScheme);
        return new NpsViewHolder(microSurveyPointNpsContentView);
    }

    private final SmileyScaleViewHolder createSmileyScaleViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointSmileyScaleContentView microSurveyPointSmileyScaleContentView = new MicroSurveyPointSmileyScaleContentView(context, null, 0, 6, null);
        microSurveyPointSmileyScaleContentView.inject(this.viewDependencies, this.colorScheme);
        return new SmileyScaleViewHolder(microSurveyPointSmileyScaleContentView);
    }

    private final CsatViewHolder createCsatViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointCsatContentView microSurveyPointCsatContentView = new MicroSurveyPointCsatContentView(context, null, 0, 6, null);
        microSurveyPointCsatContentView.inject(this.viewDependencies, this.colorScheme);
        return new CsatViewHolder(microSurveyPointCsatContentView);
    }

    private final NumericalViewHolder createNumericalViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointNumericalContentView microSurveyPointNumericalContentView = new MicroSurveyPointNumericalContentView(context, null, 0, 6, null);
        microSurveyPointNumericalContentView.inject(this.viewDependencies, this.colorScheme);
        return new NumericalViewHolder(microSurveyPointNumericalContentView);
    }

    private final ShapeViewHolder createShapeViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointShapeContentView microSurveyPointShapeContentView = new MicroSurveyPointShapeContentView(context, null, 0, 6, null);
        microSurveyPointShapeContentView.inject(this.viewDependencies, this.colorScheme);
        return new ShapeViewHolder(microSurveyPointShapeContentView);
    }

    private final DateViewHolder createDateViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointDateContentView microSurveyPointDateContentView = new MicroSurveyPointDateContentView(context, null, 0, 6, null);
        microSurveyPointDateContentView.inject(this.viewDependencies, this.colorScheme);
        return new DateViewHolder(microSurveyPointDateContentView);
    }

    private final TextViewHolder createTextViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointTextContentView microSurveyPointTextContentView = new MicroSurveyPointTextContentView(context, null, 0, 6, null);
        microSurveyPointTextContentView.inject(this.viewDependencies, this.colorScheme);
        return new TextViewHolder(microSurveyPointTextContentView);
    }

    private final MatrixViewHolder createMatrixViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointMatrixContentView microSurveyPointMatrixContentView = new MicroSurveyPointMatrixContentView(context, null, 0, 6, null);
        microSurveyPointMatrixContentView.inject(this.viewDependencies, this.colorScheme);
        return new MatrixViewHolder(microSurveyPointMatrixContentView);
    }

    private final FormViewHolder createFormViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointFormContentView microSurveyPointFormContentView = new MicroSurveyPointFormContentView(context, null, 0, 6, null);
        microSurveyPointFormContentView.inject(this.viewDependencies, this.colorScheme);
        return new FormViewHolder(microSurveyPointFormContentView);
    }

    private final CtaViewHolder createCtaViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyPointCtaContentView microSurveyPointCtaContentView = new MicroSurveyPointCtaContentView(context, null, 0, 6, null);
        microSurveyPointCtaContentView.inject(this.viewDependencies, this.colorScheme);
        return new CtaViewHolder(microSurveyPointCtaContentView);
    }

    private final DisclaimerViewHolder createDisclaimerViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final MicroDisclaimerView microDisclaimerView = new MicroDisclaimerView(context, null, 0, 6, null);
        microDisclaimerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        microDisclaimerView.inject(this.viewDependencies, this.colorScheme);
        microDisclaimerView.setOnCheckboxToggle(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageAdapter.createDisclaimerViewHolder$lambda$2(this.f$0, microDisclaimerView);
            }
        });
        return new DisclaimerViewHolder(microDisclaimerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDisclaimerViewHolder$lambda$2(SurveyPageAdapter surveyPageAdapter, MicroDisclaimerView microDisclaimerView) {
        Function1<? super Boolean, Unit> function1 = surveyPageAdapter.onDisclaimerToggle;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(microDisclaimerView.isChecked()));
        }
        return Unit.INSTANCE;
    }

    private final SubmitViewHolder createSubmitViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSubmitView microSubmitView = new MicroSubmitView(context, null, 0, 6, null);
        microSubmitView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        microSubmitView.inject(this.viewDependencies, this.colorScheme);
        microSubmitView.setOnSubmitClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageAdapter.createSubmitViewHolder$lambda$3(this.f$0);
            }
        });
        microSubmitView.setOnBackClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageAdapter.createSubmitViewHolder$lambda$4(this.f$0);
            }
        });
        return new SubmitViewHolder(microSubmitView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSubmitViewHolder$lambda$3(SurveyPageAdapter surveyPageAdapter) {
        Function0<Unit> function0 = surveyPageAdapter.onSubmitClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSubmitViewHolder$lambda$4(SurveyPageAdapter surveyPageAdapter) {
        Function0<Unit> function0 = surveyPageAdapter.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final FooterViewHolder createFooterViewHolder(ViewGroup parent) {
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MicroSurveyFooter microSurveyFooter = new MicroSurveyFooter(context, null, 0, 6, null);
        microSurveyFooter.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        microSurveyFooter.inject(this.colorScheme);
        microSurveyFooter.setOnPoweredByClick(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyPageAdapter.createFooterViewHolder$lambda$5(this.f$0);
            }
        });
        return new FooterViewHolder(microSurveyFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createFooterViewHolder$lambda$5(SurveyPageAdapter surveyPageAdapter) {
        Function0<Unit> function0 = surveyPageAdapter.onPoweredByClick;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof QuestionViewHolder) {
            PageItem pageItem = this.items.get(position);
            Intrinsics.checkNotNull(pageItem, "null cannot be cast to non-null type com.survicate.surveys.presentation.page.PageItem.Question");
            ((QuestionViewHolder) holder).bind(((PageItem.Question) pageItem).getViewModel());
        } else {
            if (holder instanceof DisclaimerViewHolder) {
                PageItem pageItem2 = this.items.get(position);
                Intrinsics.checkNotNull(pageItem2, "null cannot be cast to non-null type com.survicate.surveys.presentation.page.PageItem.Disclaimer");
                PageItem.Disclaimer disclaimer = (PageItem.Disclaimer) pageItem2;
                ((DisclaimerViewHolder) holder).getDisclaimerView().bindData(new MicroDisclaimerView.BindingData(disclaimer.getSettings()), BundleKt.bundleOf(TuplesKt.m1606to(MicroDisclaimerView.IS_CHECKBOX_CHECKED, Boolean.valueOf(disclaimer.getAccepted()))));
                return;
            }
            if (holder instanceof SubmitViewHolder) {
                PageItem pageItem3 = this.items.get(position);
                Intrinsics.checkNotNull(pageItem3, "null cannot be cast to non-null type com.survicate.surveys.presentation.page.PageItem.Submit");
                PageItem.Submit submit = (PageItem.Submit) pageItem3;
                ((SubmitViewHolder) holder).getSubmitView().setState(MicroSubmitViewKt.create(SubmitViewState.INSTANCE, submit.getConfig(), submit.getValidationState()));
                return;
            }
            boolean z = holder instanceof FooterViewHolder;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof QuestionViewHolder) {
            ((QuestionViewHolder) holder).unbind();
        }
    }
}
