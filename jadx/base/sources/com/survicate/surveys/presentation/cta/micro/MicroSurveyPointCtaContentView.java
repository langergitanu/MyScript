package com.survicate.surveys.presentation.cta.micro;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyPointCtaContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "inject", "", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "bindingData", "Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView$BindingData;", "BindingData", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointCtaContentView extends FrameLayout {
    private final MicroQuestionHeader questionHeaderView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyPointCtaContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointCtaContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewFindViewById = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_cta_content, this).findViewById(C8369R.id.view_micro_survey_point_cta_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.questionHeaderView.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.questionHeaderView.bindData(bindingData.getQuestionHeaderBindingData());
    }

    /* JADX INFO: compiled from: MicroSurveyPointCtaContentView.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView$BindingData;", "", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "<init>", "(Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;)V", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final QuestionHeaderBindingData questionHeaderBindingData;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, QuestionHeaderBindingData questionHeaderBindingData, int i, Object obj) {
            if ((i & 1) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            return bindingData.copy(questionHeaderBindingData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final BindingData copy(QuestionHeaderBindingData questionHeaderBindingData) {
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            return new BindingData(questionHeaderBindingData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BindingData) && Intrinsics.areEqual(this.questionHeaderBindingData, ((BindingData) other).questionHeaderBindingData);
        }

        public int hashCode() {
            return this.questionHeaderBindingData.hashCode();
        }

        public String toString() {
            return "BindingData(questionHeaderBindingData=" + this.questionHeaderBindingData + ')';
        }

        public BindingData(QuestionHeaderBindingData questionHeaderBindingData) {
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            this.questionHeaderBindingData = questionHeaderBindingData;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }
    }
}
