package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: PresentedPartial.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aQ\u0010\b\u001a\u0004\u0018\u0001H\t\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\f0\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0015\u001a\u0004\u0018\u0001H\t\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n*\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u0001H\tH\u0002¢\u0006\u0002\u0010\u0017\u001a,\u0010\u0018\u001a\u00020\u0019*\u00020\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002\u001a\"\u0010\u0018\u001a\u00020\u0019*\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0002\u001a \u0010\u0018\u001a\u00020\u0019*\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020&0%H\u0002\u001a\u0014\u0010'\u001a\u00020\u0019*\u00020\u001f2\u0006\u0010(\u001a\u00020\"H\u0002\u001a\u0014\u0010'\u001a\u00020\u0019*\u00020#2\u0006\u0010)\u001a\u00020&H\u0002\u001aB\u0010*\u001a\u00020\u0019\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n*\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001az\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\f0\u000b\u0012\u0004\u0012\u00020.0,\"\b\b\u0000\u0010\t*\u00020/\"\u000e\b\u0001\u0010-*\b\u0012\u0004\u0012\u0002H-0\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t000\u000b2\b\b\u0002\u00101\u001a\u00020\u00192$\u00102\u001a \u0012\u0004\u0012\u0002H\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H-\u0012\n\u0012\b\u0012\u0004\u0012\u00020.030,0!H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00064"}, m1599d2 = {"STATE_NUMBER_COMPARISON_EPSILON", "", "applicableConditions", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition;", "getApplicableConditions", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition;)Ljava/util/Set;", "buildPresentedPartial", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "windowSize", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ComponentViewState;", "conditionContext", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ConditionContext;", "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Lcom/revenuecat/purchases/ui/revenuecatui/components/ComponentViewState;Lcom/revenuecat/purchases/ui/revenuecatui/components/ConditionContext;)Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "combineOrReplace", "with", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;)Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "evaluate", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$SelectedPackage;", "selectedPackageId", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$State;", "stateReader", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonPrimitive;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Variable;", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "matchesValue", "current", "variableValue", "shouldApply", "toPresentedOverrides", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "P", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "stripRules", "transform", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PresentedPartialKt {
    private static final double STATE_NUMBER_COMPARISON_EPSILON = 1.0E-10d;

    /* JADX INFO: compiled from: PresentedPartial.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ComponentOverride.EqualityOperator.values().length];
            try {
                iArr[ComponentOverride.EqualityOperator.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ComponentOverride.EqualityOperator.NOT_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ComponentOverride.ArrayOperator.values().length];
            try {
                iArr2[ComponentOverride.ArrayOperator.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ComponentOverride.ArrayOperator.NOT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ScreenCondition.values().length];
            try {
                iArr3[ScreenCondition.COMPACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[ScreenCondition.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ScreenCondition.EXPANDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private static final <T extends PresentedPartial<T>> T combineOrReplace(PresentedPartial<T> presentedPartial, T t) {
        T t2;
        return (presentedPartial == null || (t2 = (T) presentedPartial.combine(t)) == null) ? t : t2;
    }

    public static /* synthetic */ Result toPresentedOverrides$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toPresentedOverrides(list, z, function1);
    }

    public static final /* synthetic */ Result toPresentedOverrides(List list, boolean z, Function1 transform) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                List<ComponentOverride.Condition> conditions = ((ComponentOverride) obj).getConditions();
                if (!(conditions instanceof Collection) || !conditions.isEmpty()) {
                    for (ComponentOverride.Condition condition : conditions) {
                        if (condition.isRule() || (condition instanceof ComponentOverride.Condition.Unsupported)) {
                            break;
                        }
                    }
                }
                arrayList.add(obj);
            }
            list = arrayList;
        }
        List<ComponentOverride> list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ComponentOverride componentOverride : list2) {
            Result result = (Result) transform.invoke(componentOverride.getProperties());
            if (result instanceof Result.Success) {
                arrayList2.add(new PresentedOverride(componentOverride.getConditions(), (PresentedPartial) ((Result.Success) result).getValue()));
            } else {
                if (result instanceof Result.Error) {
                    return new Result.Error(((NonEmptyList) ((Result.Error) result).getValue()).getHead());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Result.Success(arrayList2);
    }

    public static /* synthetic */ PresentedPartial buildPresentedPartial$default(List list, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext, int i, Object obj) {
        if ((i & 8) != 0) {
            conditionContext = new ConditionContext(null, MapsKt.emptyMap(), null, 4, null);
        }
        return buildPresentedPartial(list, screenCondition, offerEligibility, componentViewState, conditionContext);
    }

    public static final /* synthetic */ PresentedPartial buildPresentedPartial(List list, ScreenCondition windowSize, OfferEligibility offerEligibility, ComponentViewState state, ConditionContext conditionContext) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(windowSize, "windowSize");
        Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(conditionContext, "conditionContext");
        Iterator it = list.iterator();
        PresentedPartial presentedPartialCombineOrReplace = null;
        while (it.hasNext()) {
            PresentedOverride presentedOverride = (PresentedOverride) it.next();
            if (shouldApply(presentedOverride, windowSize, offerEligibility, state, conditionContext)) {
                presentedPartialCombineOrReplace = combineOrReplace(presentedPartialCombineOrReplace, presentedOverride.getProperties());
            }
        }
        return presentedPartialCombineOrReplace;
    }

    private static final <T extends PresentedPartial<T>> boolean shouldApply(PresentedOverride<T> presentedOverride, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext) {
        List conditions = presentedOverride.getConditions();
        if ((conditions instanceof Collection) && conditions.isEmpty()) {
            return true;
        }
        Iterator it = conditions.iterator();
        while (it.hasNext()) {
            if (!evaluate((ComponentOverride.Condition) it.next(), screenCondition, offerEligibility, componentViewState, conditionContext)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean evaluate(ComponentOverride.Condition condition, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext) {
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Compact.INSTANCE) ? true : Intrinsics.areEqual(condition, ComponentOverride.Condition.Medium.INSTANCE) ? true : Intrinsics.areEqual(condition, ComponentOverride.Condition.Expanded.INSTANCE)) {
            return getApplicableConditions(screenCondition).contains(condition);
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.MultiplePhaseOffers.INSTANCE)) {
            return offerEligibility.getHasMultipleDiscountedPhases();
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.IntroOffer.INSTANCE)) {
            return offerEligibility.isIntroOffer();
        }
        if (condition instanceof ComponentOverride.Condition.IntroOfferRule) {
            return evaluate((ComponentOverride.Condition.IntroOfferRule) condition, offerEligibility);
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Selected.INSTANCE)) {
            return componentViewState == ComponentViewState.SELECTED;
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.PromoOffer.INSTANCE)) {
            return offerEligibility.isPromoOffer();
        }
        if (condition instanceof ComponentOverride.Condition.PromoOfferRule) {
            return evaluate((ComponentOverride.Condition.PromoOfferRule) condition, offerEligibility);
        }
        if (condition instanceof ComponentOverride.Condition.SelectedPackage) {
            return evaluate((ComponentOverride.Condition.SelectedPackage) condition, conditionContext.getSelectedPackageId());
        }
        if (condition instanceof ComponentOverride.Condition.Variable) {
            return evaluate((ComponentOverride.Condition.Variable) condition, conditionContext.getCustomVariables());
        }
        if (condition instanceof ComponentOverride.Condition.State) {
            return evaluate((ComponentOverride.Condition.State) condition, conditionContext.getStateReader());
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Unsupported.INSTANCE)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.IntroOfferRule introOfferRule, OfferEligibility offerEligibility) {
        boolean zIsIntroOffer = offerEligibility.isIntroOffer();
        int i = WhenMappings.$EnumSwitchMapping$0[introOfferRule.getOperator().ordinal()];
        if (i == 1) {
            return zIsIntroOffer == introOfferRule.getValue();
        }
        if (i == 2) {
            return zIsIntroOffer != introOfferRule.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.PromoOfferRule promoOfferRule, OfferEligibility offerEligibility) {
        boolean zIsPromoOffer = offerEligibility.isPromoOffer();
        int i = WhenMappings.$EnumSwitchMapping$0[promoOfferRule.getOperator().ordinal()];
        if (i == 1) {
            return zIsPromoOffer == promoOfferRule.getValue();
        }
        if (i == 2) {
            return zIsPromoOffer != promoOfferRule.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.SelectedPackage selectedPackage, String str) {
        if (str == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[selectedPackage.getOperator().ordinal()];
        if (i == 1) {
            return selectedPackage.getPackages().contains(str);
        }
        if (i == 2) {
            return !selectedPackage.getPackages().contains(str);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.Variable variable, Map<String, ? extends CustomVariableValue> map) {
        CustomVariableValue customVariableValue = map.get(variable.getVariable());
        if (customVariableValue == null) {
            return variable.getOperator() == ComponentOverride.EqualityOperator.NOT_EQUALS;
        }
        boolean zMatchesValue = matchesValue(variable, customVariableValue);
        int i = WhenMappings.$EnumSwitchMapping$0[variable.getOperator().ordinal()];
        if (i == 1) {
            return zMatchesValue;
        }
        if (i == 2) {
            return !zMatchesValue;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean matchesValue(ComponentOverride.Condition.Variable variable, CustomVariableValue customVariableValue) {
        return variable.getValue().getIsString() ? (customVariableValue instanceof CustomVariableValue.String) && Intrinsics.areEqual(((CustomVariableValue.String) customVariableValue).getValue(), variable.getValue().getContent()) : JsonElementKt.getBooleanOrNull(variable.getValue()) != null ? (customVariableValue instanceof CustomVariableValue.Boolean) && Intrinsics.areEqual(Boolean.valueOf(((CustomVariableValue.Boolean) customVariableValue).getValue()), JsonElementKt.getBooleanOrNull(variable.getValue())) : JsonElementKt.getDoubleOrNull(variable.getValue()) != null && (customVariableValue instanceof CustomVariableValue.Number) && Intrinsics.areEqual(((CustomVariableValue.Number) customVariableValue).getValue(), JsonElementKt.getDoubleOrNull(variable.getValue()));
    }

    private static final boolean evaluate(ComponentOverride.Condition.State state, Function1<? super String, ? extends JsonPrimitive> function1) {
        JsonPrimitive jsonPrimitiveInvoke = function1.invoke(state.getName());
        if (jsonPrimitiveInvoke == null) {
            return false;
        }
        boolean zMatchesValue = matchesValue(state, jsonPrimitiveInvoke);
        int i = WhenMappings.$EnumSwitchMapping$0[state.getOperator().ordinal()];
        if (i == 1) {
            return zMatchesValue;
        }
        if (i == 2) {
            return !zMatchesValue;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean matchesValue(ComponentOverride.Condition.State state, JsonPrimitive jsonPrimitive) {
        if (state.getValue().getIsString() || jsonPrimitive.getIsString()) {
            return state.getValue().getIsString() && jsonPrimitive.getIsString() && Intrinsics.areEqual(state.getValue().getContent(), jsonPrimitive.getContent());
        }
        if (JsonElementKt.getBooleanOrNull(state.getValue()) != null || JsonElementKt.getBooleanOrNull(jsonPrimitive) != null) {
            return Intrinsics.areEqual(JsonElementKt.getBooleanOrNull(state.getValue()), JsonElementKt.getBooleanOrNull(jsonPrimitive));
        }
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(state.getValue());
        Double doubleOrNull2 = JsonElementKt.getDoubleOrNull(jsonPrimitive);
        return (doubleOrNull == null || doubleOrNull2 == null || Math.abs(doubleOrNull.doubleValue() - doubleOrNull2.doubleValue()) >= STATE_NUMBER_COMPARISON_EPSILON) ? false : true;
    }

    private static final Set<ComponentOverride.Condition> getApplicableConditions(ScreenCondition screenCondition) {
        int i = WhenMappings.$EnumSwitchMapping$2[screenCondition.ordinal()];
        if (i == 1) {
            return SetsKt.setOf(ComponentOverride.Condition.Compact.INSTANCE);
        }
        if (i == 2) {
            return SetsKt.setOf((Object[]) new ComponentOverride.Condition[]{ComponentOverride.Condition.Compact.INSTANCE, ComponentOverride.Condition.Medium.INSTANCE});
        }
        if (i == 3) {
            return SetsKt.setOf((Object[]) new ComponentOverride.Condition[]{ComponentOverride.Condition.Compact.INSTANCE, ComponentOverride.Condition.Medium.INSTANCE, ComponentOverride.Condition.Expanded.INSTANCE});
        }
        throw new NoWhenBranchMatchedException();
    }
}
