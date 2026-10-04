package com.survicate.surveys.core.logic.display.groups;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DisplayLogicTextGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Text;", "condition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroupCondition;", "value", "", "", "valueOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "<init>", "(Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroupCondition;Ljava/util/List;Lcom/survicate/surveys/core/logic/core/AndOrOperator;)V", "getCondition", "()Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroupCondition;", "getValue", "()Ljava/util/List;", "getValueOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "isSatisfiedBy", "", "answer", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class DisplayLogicTextGroup implements DisplayLogicGroup<QuestionAnswered.Text> {
    private final DisplayLogicTextGroupCondition condition;
    private final List<String> value;
    private final AndOrOperator valueOperator;

    /* JADX INFO: compiled from: DisplayLogicTextGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AndOrOperator.values().length];
            try {
                iArr[AndOrOperator.f2260OR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AndOrOperator.AND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DisplayLogicTextGroupCondition.values().length];
            try {
                iArr2[DisplayLogicTextGroupCondition.ANSWER_CONTAINS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DisplayLogicTextGroupCondition.ANSWER_DOES_NOT_CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DisplayLogicTextGroupCondition.QUESTION_IS_ANSWERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DisplayLogicTextGroupCondition.QUESTION_IS_NOT_ANSWERED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DisplayLogicTextGroupCondition.HAS_ANY_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DisplayLogicTextGroup copy$default(DisplayLogicTextGroup displayLogicTextGroup, DisplayLogicTextGroupCondition displayLogicTextGroupCondition, List list, AndOrOperator andOrOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            displayLogicTextGroupCondition = displayLogicTextGroup.condition;
        }
        if ((i & 2) != 0) {
            list = displayLogicTextGroup.value;
        }
        if ((i & 4) != 0) {
            andOrOperator = displayLogicTextGroup.valueOperator;
        }
        return displayLogicTextGroup.copy(displayLogicTextGroupCondition, list, andOrOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DisplayLogicTextGroupCondition getCondition() {
        return this.condition;
    }

    public final List<String> component2() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AndOrOperator getValueOperator() {
        return this.valueOperator;
    }

    public final DisplayLogicTextGroup copy(DisplayLogicTextGroupCondition condition, List<String> value, AndOrOperator valueOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(valueOperator, "valueOperator");
        return new DisplayLogicTextGroup(condition, value, valueOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayLogicTextGroup)) {
            return false;
        }
        DisplayLogicTextGroup displayLogicTextGroup = (DisplayLogicTextGroup) other;
        return this.condition == displayLogicTextGroup.condition && Intrinsics.areEqual(this.value, displayLogicTextGroup.value) && this.valueOperator == displayLogicTextGroup.valueOperator;
    }

    public int hashCode() {
        return (((this.condition.hashCode() * 31) + this.value.hashCode()) * 31) + this.valueOperator.hashCode();
    }

    public String toString() {
        return "DisplayLogicTextGroup(condition=" + this.condition + ", value=" + this.value + ", valueOperator=" + this.valueOperator + ')';
    }

    public DisplayLogicTextGroup(DisplayLogicTextGroupCondition condition, List<String> value, AndOrOperator valueOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(valueOperator, "valueOperator");
        this.condition = condition;
        this.value = value;
        this.valueOperator = valueOperator;
    }

    public final DisplayLogicTextGroupCondition getCondition() {
        return this.condition;
    }

    public final List<String> getValue() {
        return this.value;
    }

    public final AndOrOperator getValueOperator() {
        return this.valueOperator;
    }

    @Override // com.survicate.surveys.core.logic.display.groups.DisplayLogicGroup
    public boolean isSatisfiedBy(QuestionAnswered.Text answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        int i = WhenMappings.$EnumSwitchMapping$1[this.condition.ordinal()];
        if (i == 1) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.valueOperator.ordinal()];
            if (i2 == 1) {
                List<String> list = this.value;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return false;
                }
                for (String str : list) {
                    String lowerCase = answer.getAnswer().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                        return true;
                    }
                }
                return false;
            }
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            List<String> list2 = this.value;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return true;
            }
            for (String str2 : list2) {
                String lowerCase3 = answer.getAnswer().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                String lowerCase4 = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    return false;
                }
            }
            return true;
        }
        if (i != 2) {
            if (i == 3) {
                return !StringsKt.isBlank(answer.getAnswer());
            }
            if (i == 4) {
                return StringsKt.isBlank(answer.getAnswer());
            }
            if (i == 5) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.valueOperator.ordinal()];
        if (i3 == 1) {
            List<String> list3 = this.value;
            if ((list3 instanceof Collection) && list3.isEmpty()) {
                return false;
            }
            for (String str3 : list3) {
                String lowerCase5 = answer.getAnswer().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                String lowerCase6 = str3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                if (!StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) lowerCase6, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
        if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<String> list4 = this.value;
        if ((list4 instanceof Collection) && list4.isEmpty()) {
            return true;
        }
        for (String str4 : list4) {
            String lowerCase7 = answer.getAnswer().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
            String lowerCase8 = str4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase8, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) lowerCase8, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
