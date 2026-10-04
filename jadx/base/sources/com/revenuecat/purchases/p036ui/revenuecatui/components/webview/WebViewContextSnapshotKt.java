package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowScreenContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: WebViewContextSnapshot.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0012\u001a\u00020\n*\u00020\u0013H\u0002\u001a\u0014\u0010\u0012\u001a\u00020\n*\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0012\u001a\u00020\n*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\u001a"}, m1599d2 = {"asJsonPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "getAsJsonPrimitive", "(Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;)Lkotlinx/serialization/json/JsonPrimitive;", "isAutoRenewing", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/Boolean;", "webViewContextSnapshot", "Lkotlinx/serialization/json/JsonObject;", "input", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewContextInput;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "darkMode", "asJson", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/Package;", "putWorkflow", "", "Lkotlinx/serialization/json/JsonObjectBuilder;", "workflowScreen", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WebViewContextSnapshotKt {

    /* JADX INFO: compiled from: WebViewContextSnapshot.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecurrenceMode.values().length];
            try {
                iArr[RecurrenceMode.INFINITE_RECURRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecurrenceMode.NON_RECURRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ JsonObject webViewContextSnapshot(PaywallState.Loaded.Components state, WebViewComponentStyle style, boolean z) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
        Package rcPackage = selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null;
        Map<String, CustomVariableValue> mergedCustomVariables = state.getMergedCustomVariables();
        Offering offering = state.getOffering();
        Package rcPackage2 = style.getRcPackage();
        return webViewContextSnapshot(new WebViewContextInput(mergedCustomVariables, offering, rcPackage2 == null ? rcPackage : rcPackage2, rcPackage, state.getStore(), state.getStorefrontCountryCode(), state.getWorkflowScreen(), state.getLocale().toLanguageTag(), z));
    }

    private static final void putWorkflow(JsonObjectBuilder jsonObjectBuilder, final WorkflowScreenContext workflowScreenContext) {
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, Keys.WORKFLOW, new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt.putWorkflow.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, Keys.WORKFLOW_ID, workflowScreenContext.getWorkflowId());
                JsonElementBuildersKt.put(putJsonObject, Keys.STEP_ID, workflowScreenContext.getStepId());
                JsonElementBuildersKt.put(putJsonObject, Keys.STEP_TYPE, workflowScreenContext.getStepType());
                final WorkflowScreenContext workflowScreenContext2 = workflowScreenContext;
                JsonElementBuildersKt.putJsonArray(putJsonObject, "screen_type", new Function1<JsonArrayBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt.putWorkflow.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JsonArrayBuilder jsonArrayBuilder) {
                        invoke2(jsonArrayBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(JsonArrayBuilder putJsonArray) {
                        Intrinsics.checkNotNullParameter(putJsonArray, "$this$putJsonArray");
                        List<String> screenType = workflowScreenContext2.getScreenType();
                        if (screenType != null) {
                            Iterator<T> it = screenType.iterator();
                            while (it.hasNext()) {
                                JsonElementBuildersKt.add(putJsonArray, (String) it.next());
                            }
                        }
                    }
                });
            }
        });
    }

    private static final Boolean isAutoRenewing(StoreProduct storeProduct) {
        PricingPhase fullPricePhase;
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        RecurrenceMode recurrenceMode = (defaultOption == null || (fullPricePhase = defaultOption.getFullPricePhase()) == null) ? null : fullPricePhase.getRecurrenceMode();
        int i = recurrenceMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[recurrenceMode.ordinal()];
        if (i != 1) {
            return i != 2 ? null : false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonPrimitive getAsJsonPrimitive(CustomVariableValue customVariableValue) {
        return (JsonPrimitive) customVariableValue.map$revenuecatui_defaultsRelease(new Function1<String, JsonPrimitive>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJsonPrimitive$1
            @Override // kotlin.jvm.functions.Function1
            public final JsonPrimitive invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return JsonElementKt.JsonPrimitive(it);
            }
        }, new Function1<Double, JsonPrimitive>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJsonPrimitive$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ JsonPrimitive invoke(Double d) {
                return invoke(d.doubleValue());
            }

            public final JsonPrimitive invoke(double d) {
                if (Math.abs(d) > Double.MAX_VALUE) {
                    return JsonElementKt.JsonPrimitive(String.valueOf(d));
                }
                long j = (long) d;
                return d == ((double) j) ? JsonElementKt.JsonPrimitive(Long.valueOf(j)) : JsonElementKt.JsonPrimitive(Double.valueOf(d));
            }
        }, new Function1<Boolean, JsonPrimitive>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJsonPrimitive$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ JsonPrimitive invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final JsonPrimitive invoke(boolean z) {
                return JsonElementKt.JsonPrimitive(Boolean.valueOf(z));
            }
        });
    }

    public static final /* synthetic */ JsonObject webViewContextSnapshot(final WebViewContextInput input) {
        JsonElement jsonElementAsJson;
        JsonElement jsonElementAsJson2;
        JsonElement jsonElementAsJson3;
        Intrinsics.checkNotNullParameter(input, "input");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, Keys.CUSTOM, new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$webViewContextSnapshot$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                for (Map.Entry<String, CustomVariableValue> entry : input.getCustomVariables().entrySet()) {
                    putJsonObject.put(entry.getKey(), WebViewContextSnapshotKt.getAsJsonPrimitive(entry.getValue()));
                }
            }
        });
        Offering offering = input.getOffering();
        if (offering == null || (jsonElementAsJson = asJson(offering)) == null) {
            jsonElementAsJson = JsonNull.INSTANCE;
        }
        jsonObjectBuilder.put("offering", jsonElementAsJson);
        JsonElementBuildersKt.putJsonArray(jsonObjectBuilder, Keys.PACKAGES, new Function1<JsonArrayBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$webViewContextSnapshot$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonArrayBuilder jsonArrayBuilder) {
                invoke2(jsonArrayBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonArrayBuilder putJsonArray) {
                List<Package> availablePackages;
                Intrinsics.checkNotNullParameter(putJsonArray, "$this$putJsonArray");
                Offering offering2 = input.getOffering();
                if (offering2 == null || (availablePackages = offering2.getAvailablePackages()) == null) {
                    return;
                }
                WebViewContextInput webViewContextInput = input;
                Iterator<T> it = availablePackages.iterator();
                while (it.hasNext()) {
                    putJsonArray.add(WebViewContextSnapshotKt.asJson((Package) it.next(), webViewContextInput));
                }
            }
        });
        Package componentPackage = input.getComponentPackage();
        if (componentPackage == null || (jsonElementAsJson2 = asJson(componentPackage, input)) == null) {
            jsonElementAsJson2 = JsonNull.INSTANCE;
        }
        jsonObjectBuilder.put(Keys.PACKAGE, jsonElementAsJson2);
        Package selectedPackage = input.getSelectedPackage();
        if (selectedPackage == null || (jsonElementAsJson3 = asJson(selectedPackage, input)) == null) {
            jsonElementAsJson3 = JsonNull.INSTANCE;
        }
        jsonObjectBuilder.put(Keys.SELECTED_PACKAGE, jsonElementAsJson3);
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, Keys.INPUTS, new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$webViewContextSnapshot$1$3
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }
        });
        WorkflowScreenContext workflowScreen = input.getWorkflowScreen();
        if (workflowScreen != null) {
            putWorkflow(jsonObjectBuilder, workflowScreen);
        }
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, Keys.DEVICE_META, new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$webViewContextSnapshot$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, Keys.IS_PREVIEW, (Boolean) false);
                JsonElementBuildersKt.put(putJsonObject, "locale", input.getLocale());
                JsonElementBuildersKt.put(putJsonObject, Keys.DARK_MODE, Boolean.valueOf(input.getDarkMode()));
                JsonElementBuildersKt.put(putJsonObject, Keys.UPDATED_AT, Long.valueOf(System.currentTimeMillis()));
            }
        });
        return jsonObjectBuilder.build();
    }

    private static final JsonObject asJson(Offering offering) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.IDENTIFIER, offering.getIdentifier());
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.DISPLAY_NAME, offering.getServerDescription());
        return jsonObjectBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject asJson(final Package r3, final WebViewContextInput webViewContextInput) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.IDENTIFIER, r3.getIdentifier());
        JsonElementBuildersKt.putJsonArray(jsonObjectBuilder, Keys.PRODUCTS, new Function1<JsonArrayBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJson$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonArrayBuilder jsonArrayBuilder) {
                invoke2(jsonArrayBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonArrayBuilder putJsonArray) {
                Intrinsics.checkNotNullParameter(putJsonArray, "$this$putJsonArray");
                putJsonArray.add(WebViewContextSnapshotKt.asJson(r3.getProduct(), webViewContextInput));
            }
        });
        return jsonObjectBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject asJson(final StoreProduct storeProduct, final WebViewContextInput webViewContextInput) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.IDENTIFIER, storeProduct.getId());
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "store", new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJson$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, Keys.STORE_TYPE, webViewContextInput.getStore().getStringValue());
                String storefrontCountryCode = webViewContextInput.getStorefrontCountryCode();
                if (storefrontCountryCode != null) {
                    JsonElementBuildersKt.put(putJsonObject, "country", storefrontCountryCode);
                }
            }
        });
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.DISPLAY_NAME, storeProduct.getName());
        JsonElementBuildersKt.put(jsonObjectBuilder, Keys.IS_SUBSCRIPTION, Boolean.valueOf(storeProduct.getPeriod() != null));
        Period period = storeProduct.getPeriod();
        if (period != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, "period", period.getIso8601());
        }
        Boolean boolIsAutoRenewing = isAutoRenewing(storeProduct);
        if (boolIsAutoRenewing != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, Keys.IS_AUTO_RENEWING, Boolean.valueOf(boolIsAutoRenewing.booleanValue()));
        }
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "price", new Function1<JsonObjectBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewContextSnapshotKt$asJson$3$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, Keys.AMOUNT, Double.valueOf(storeProduct.getPrice().getAmountMicros() / 1000000.0d));
                JsonElementBuildersKt.put(putJsonObject, "currency", storeProduct.getPrice().getCurrencyCode());
            }
        });
        return jsonObjectBuilder.build();
    }
}
