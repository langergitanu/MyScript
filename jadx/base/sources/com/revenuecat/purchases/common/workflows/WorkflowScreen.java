package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig$$serializer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocaleId$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfigSerializer;
import com.revenuecat.purchases.paywalls.components.common.StateDeclaration;
import com.revenuecat.purchases.paywalls.components.common.StateDeclarationMapSerializer;
import com.revenuecat.purchases.utils.serializers.DefaultLocaleIdSerializer;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 h2\u00020\u0001:\u0002ghBã\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\"\b\u0001\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r\u0018\u00010\r\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u001c\u0012\u0016\b\u0001\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!B½\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r0\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r¢\u0006\u0002\u0010\"J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010M\u001a\u00020\u001cHÆ\u0003J\u0017\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\rHÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\tHÆ\u0003J\t\u0010R\u001a\u00020\u000bHÆ\u0003J!\u0010S\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r0\rHÆ\u0003J\u0016\u0010T\u001a\u00020\u000eHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bU\u00105J\t\u0010V\u001a\u00020\u0013HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÓ\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\rHÆ\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u0013\u0010[\u001a\u00020\u001c2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0003HÖ\u0001J\t\u0010^\u001a\u00020\u0005HÖ\u0001J&\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eHÁ\u0001¢\u0006\u0002\bfR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010$\u001a\u0004\b(\u0010)R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010$\u001a\u0004\b+\u0010,R4\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r0\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010$\u001a\u0004\b.\u0010/R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010$\u001a\u0004\b1\u00102R$\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u00106\u0012\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010$\u001a\u0004\b8\u00109R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00105R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010$\u001a\u0004\b<\u00105R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010$\u001a\u0004\b>\u0010?R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR*\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010$\u001a\u0004\bC\u0010/R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010$\u001a\u0004\bE\u00105R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010$\u001a\u0004\bG\u0010H\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "", "seen1", "", "name", "", "templateName", "revision", "assetBaseURL", "Ljava/net/URL;", "componentsConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;", "componentsLocalizations", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "defaultLocaleIdentifier", "config", "Lkotlinx/serialization/json/JsonObject;", "offeringIdentifier", "zeroDecimalPlaceCountries", "", "exitOffers", "Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "automaticallyScaleFontSize", "", "stateDeclarations", "Lcom/revenuecat/purchases/paywalls/components/common/StateDeclaration;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/net/URL;Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;ZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/net/URL;Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;ZLjava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetBaseURL$annotations", "()V", "getAssetBaseURL", "()Ljava/net/URL;", "getAutomaticallyScaleFontSize$annotations", "getAutomaticallyScaleFontSize", "()Z", "getComponentsConfig$annotations", "getComponentsConfig", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;", "getComponentsLocalizations$annotations", "getComponentsLocalizations", "()Ljava/util/Map;", "getConfig$annotations", "getConfig", "()Lkotlinx/serialization/json/JsonObject;", "getDefaultLocaleIdentifier-uqtKvyA$annotations", "getDefaultLocaleIdentifier-uqtKvyA", "()Ljava/lang/String;", "Ljava/lang/String;", "getExitOffers$annotations", "getExitOffers", "()Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "getName", "getOfferingIdentifier$annotations", "getOfferingIdentifier", "getProductChangeConfig$annotations", "getProductChangeConfig", "()Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "getRevision", "()I", "getStateDeclarations$annotations", "getStateDeclarations", "getTemplateName$annotations", "getTemplateName", "getZeroDecimalPlaceCountries$annotations", "getZeroDecimalPlaceCountries", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component7-uqtKvyA", "component8", "component9", "copy", "copy-lZK2qHg", "(Ljava/lang/String;Ljava/lang/String;ILjava/net/URL;Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;Ljava/util/Map;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;ZLjava/util/Map;)Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class WorkflowScreen {
    private final URL assetBaseURL;
    private final boolean automaticallyScaleFontSize;
    private final ComponentsConfig componentsConfig;
    private final Map<LocaleId, Map<LocalizationKey, LocalizationData>> componentsLocalizations;
    private final JsonObject config;
    private final String defaultLocaleIdentifier;
    private final ExitOffers exitOffers;
    private final String name;
    private final String offeringIdentifier;
    private final ProductChangeConfig productChangeConfig;
    private final int revision;
    private final Map<String, StateDeclaration> stateDeclarations;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new LinkedHashMapSerializer(LocaleId$$serializer.INSTANCE, new LinkedHashMapSerializer(LocalizationKey$$serializer.INSTANCE, LocalizationData.INSTANCE.serializer())), null, null, null, null, null, null, null, null};

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WorkflowScreen(int i, String str, @SerialName("template_name") String str2, int i2, @SerialName("asset_base_url") @Serializable(with = URLSerializer.class) URL url, @SerialName("components_config") ComponentsConfig componentsConfig, @SerialName("components_localizations") Map map, @SerialName("default_locale") @Serializable(with = DefaultLocaleIdSerializer.class) String str3, @SerialName("config") JsonObject jsonObject, @SerialName(CheckpointWorkflowResolverImpl.OFFERING_IDENTIFIER_PARAM) String str4, @SerialName("zero_decimal_place_countries") @Serializable(with = GoogleListSerializer.class) List list, @SerialName("exit_offers") ExitOffers exitOffers, @SerialName("play_store_product_change_mode") @Serializable(with = ProductChangeConfigSerializer.class) ProductChangeConfig productChangeConfig, @SerialName("automatically_scale_font_size") boolean z, @SerialName("state_declarations") @Serializable(with = StateDeclarationMapSerializer.class) Map map2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, url, componentsConfig, (Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>>) map, str3, jsonObject, str4, (List<String>) list, exitOffers, productChangeConfig, z, (Map<String, StateDeclaration>) map2, serializationConstructorMarker);
    }

    public /* synthetic */ WorkflowScreen(String str, String str2, int i, URL url, ComponentsConfig componentsConfig, Map map, String str3, JsonObject jsonObject, String str4, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, boolean z, Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, url, componentsConfig, map, str3, jsonObject, str4, list, exitOffers, productChangeConfig, z, map2);
    }

    @SerialName("asset_base_url")
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName("automatically_scale_font_size")
    public static /* synthetic */ void getAutomaticallyScaleFontSize$annotations() {
    }

    @SerialName("components_config")
    public static /* synthetic */ void getComponentsConfig$annotations() {
    }

    @SerialName("components_localizations")
    public static /* synthetic */ void getComponentsLocalizations$annotations() {
    }

    @SerialName("config")
    public static /* synthetic */ void getConfig$annotations() {
    }

    @SerialName("default_locale")
    @Serializable(with = DefaultLocaleIdSerializer.class)
    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA$annotations, reason: not valid java name */
    public static /* synthetic */ void m13743getDefaultLocaleIdentifieruqtKvyA$annotations() {
    }

    @SerialName("exit_offers")
    public static /* synthetic */ void getExitOffers$annotations() {
    }

    @SerialName(CheckpointWorkflowResolverImpl.OFFERING_IDENTIFIER_PARAM)
    public static /* synthetic */ void getOfferingIdentifier$annotations() {
    }

    @SerialName("play_store_product_change_mode")
    @Serializable(with = ProductChangeConfigSerializer.class)
    public static /* synthetic */ void getProductChangeConfig$annotations() {
    }

    @SerialName("state_declarations")
    @Serializable(with = StateDeclarationMapSerializer.class)
    public static /* synthetic */ void getStateDeclarations$annotations() {
    }

    @SerialName("template_name")
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    @SerialName("zero_decimal_place_countries")
    @Serializable(with = GoogleListSerializer.class)
    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component10() {
        return this.zeroDecimalPlaceCountries;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ExitOffers getExitOffers() {
        return this.exitOffers;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ProductChangeConfig getProductChangeConfig() {
        return this.productChangeConfig;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getAutomaticallyScaleFontSize() {
        return this.automaticallyScaleFontSize;
    }

    public final Map<String, StateDeclaration> component14() {
        return this.stateDeclarations;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTemplateName() {
        return this.templateName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final Map<LocaleId, Map<LocalizationKey, LocalizationData>> component6() {
        return this.componentsLocalizations;
    }

    /* JADX INFO: renamed from: component7-uqtKvyA, reason: not valid java name and from getter */
    public final String getDefaultLocaleIdentifier() {
        return this.defaultLocaleIdentifier;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final JsonObject getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    /* JADX INFO: renamed from: copy-lZK2qHg, reason: not valid java name */
    public final WorkflowScreen m13745copylZK2qHg(String name, String templateName, int revision, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, JsonObject config, String offeringIdentifier, List<String> zeroDecimalPlaceCountries, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, boolean automaticallyScaleFontSize, Map<String, StateDeclaration> stateDeclarations) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        return new WorkflowScreen(name, templateName, revision, assetBaseURL, componentsConfig, componentsLocalizations, defaultLocaleIdentifier, config, offeringIdentifier, zeroDecimalPlaceCountries, exitOffers, productChangeConfig, automaticallyScaleFontSize, stateDeclarations, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowScreen)) {
            return false;
        }
        WorkflowScreen workflowScreen = (WorkflowScreen) other;
        return Intrinsics.areEqual(this.name, workflowScreen.name) && Intrinsics.areEqual(this.templateName, workflowScreen.templateName) && this.revision == workflowScreen.revision && Intrinsics.areEqual(this.assetBaseURL, workflowScreen.assetBaseURL) && Intrinsics.areEqual(this.componentsConfig, workflowScreen.componentsConfig) && Intrinsics.areEqual(this.componentsLocalizations, workflowScreen.componentsLocalizations) && LocaleId.m13800equalsimpl0(this.defaultLocaleIdentifier, workflowScreen.defaultLocaleIdentifier) && Intrinsics.areEqual(this.config, workflowScreen.config) && Intrinsics.areEqual(this.offeringIdentifier, workflowScreen.offeringIdentifier) && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, workflowScreen.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.exitOffers, workflowScreen.exitOffers) && Intrinsics.areEqual(this.productChangeConfig, workflowScreen.productChangeConfig) && this.automaticallyScaleFontSize == workflowScreen.automaticallyScaleFontSize && Intrinsics.areEqual(this.stateDeclarations, workflowScreen.stateDeclarations);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + Integer.hashCode(this.revision)) * 31) + this.assetBaseURL.hashCode()) * 31) + this.componentsConfig.hashCode()) * 31) + this.componentsLocalizations.hashCode()) * 31) + LocaleId.m13801hashCodeimpl(this.defaultLocaleIdentifier)) * 31) + this.config.hashCode()) * 31;
        String str2 = this.offeringIdentifier;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        ExitOffers exitOffers = this.exitOffers;
        int iHashCode3 = (iHashCode2 + (exitOffers == null ? 0 : exitOffers.hashCode())) * 31;
        ProductChangeConfig productChangeConfig = this.productChangeConfig;
        int iHashCode4 = (((iHashCode3 + (productChangeConfig == null ? 0 : productChangeConfig.hashCode())) * 31) + Boolean.hashCode(this.automaticallyScaleFontSize)) * 31;
        Map<String, StateDeclaration> map = this.stateDeclarations;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkflowScreen(name=");
        sb.append(this.name).append(", templateName=").append(this.templateName).append(", revision=").append(this.revision).append(", assetBaseURL=").append(this.assetBaseURL).append(", componentsConfig=").append(this.componentsConfig).append(", componentsLocalizations=").append(this.componentsLocalizations).append(", defaultLocaleIdentifier=").append((Object) LocaleId.m13802toStringimpl(this.defaultLocaleIdentifier)).append(", config=").append(this.config).append(", offeringIdentifier=").append(this.offeringIdentifier).append(", zeroDecimalPlaceCountries=").append(this.zeroDecimalPlaceCountries).append(", exitOffers=").append(this.exitOffers).append(", productChangeConfig=");
        sb.append(this.productChangeConfig).append(", automaticallyScaleFontSize=").append(this.automaticallyScaleFontSize).append(", stateDeclarations=").append(this.stateDeclarations).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: WorkflowModels.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowScreen$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkflowScreen> serializer() {
            return WorkflowScreen$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WorkflowScreen(int i, String str, String str2, int i2, URL url, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> map, String str3, JsonObject jsonObject, String str4, List<String> list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, boolean z, Map<String, StateDeclaration> map2, SerializationConstructorMarker serializationConstructorMarker) {
        if (58 != (i & 58)) {
            PluginExceptionsKt.throwMissingFieldException(i, 58, WorkflowScreen$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        this.templateName = str2;
        if ((i & 4) == 0) {
            this.revision = 0;
        } else {
            this.revision = i2;
        }
        this.assetBaseURL = url;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = map;
        if ((i & 64) == 0) {
            this.defaultLocaleIdentifier = DefaultLocaleIdSerializer.INSTANCE.m14319getFALLBACKuqtKvyA();
        } else {
            this.defaultLocaleIdentifier = str3;
        }
        if ((i & 128) == 0) {
            this.config = new JsonObject(MapsKt.emptyMap());
        } else {
            this.config = jsonObject;
        }
        if ((i & 256) == 0) {
            this.offeringIdentifier = null;
        } else {
            this.offeringIdentifier = str4;
        }
        if ((i & 512) == 0) {
            this.zeroDecimalPlaceCountries = CollectionsKt.emptyList();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i & 1024) == 0) {
            this.exitOffers = null;
        } else {
            this.exitOffers = exitOffers;
        }
        if ((i & 2048) == 0) {
            this.productChangeConfig = null;
        } else {
            this.productChangeConfig = productChangeConfig;
        }
        this.automaticallyScaleFontSize = (i & 4096) == 0 ? true : z;
        if ((i & 8192) == 0) {
            this.stateDeclarations = null;
        } else {
            this.stateDeclarations = map2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WorkflowScreen(String str, String templateName, int i, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, JsonObject config, String str2, List<String> zeroDecimalPlaceCountries, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, boolean z, Map<String, StateDeclaration> map) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.name = str;
        this.templateName = templateName;
        this.revision = i;
        this.assetBaseURL = assetBaseURL;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = componentsLocalizations;
        this.defaultLocaleIdentifier = defaultLocaleIdentifier;
        this.config = config;
        this.offeringIdentifier = str2;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.exitOffers = exitOffers;
        this.productChangeConfig = productChangeConfig;
        this.automaticallyScaleFontSize = z;
        this.stateDeclarations = map;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(WorkflowScreen self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        output.encodeStringElement(serialDesc, 1, self.templateName);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.revision != 0) {
            output.encodeIntElement(serialDesc, 2, self.revision);
        }
        output.encodeSerializableElement(serialDesc, 3, URLSerializer.INSTANCE, self.assetBaseURL);
        output.encodeSerializableElement(serialDesc, 4, ComponentsConfig$$serializer.INSTANCE, self.componentsConfig);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.componentsLocalizations);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !LocaleId.m13800equalsimpl0(self.defaultLocaleIdentifier, DefaultLocaleIdSerializer.INSTANCE.m14319getFALLBACKuqtKvyA())) {
            output.encodeSerializableElement(serialDesc, 6, DefaultLocaleIdSerializer.INSTANCE, LocaleId.m13797boximpl(self.defaultLocaleIdentifier));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.config, new JsonObject(MapsKt.emptyMap()))) {
            output.encodeSerializableElement(serialDesc, 7, JsonObjectSerializer.INSTANCE, self.config);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.offeringIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.offeringIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.zeroDecimalPlaceCountries, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, GoogleListSerializer.INSTANCE, self.zeroDecimalPlaceCountries);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.exitOffers != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, ExitOffers$$serializer.INSTANCE, self.exitOffers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.productChangeConfig != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, ProductChangeConfigSerializer.INSTANCE, self.productChangeConfig);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !self.automaticallyScaleFontSize) {
            output.encodeBooleanElement(serialDesc, 12, self.automaticallyScaleFontSize);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 13) && self.stateDeclarations == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 13, StateDeclarationMapSerializer.INSTANCE, self.stateDeclarations);
    }

    public final String getName() {
        return this.name;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final Map<LocaleId, Map<LocalizationKey, LocalizationData>> getComponentsLocalizations() {
        return this.componentsLocalizations;
    }

    public /* synthetic */ WorkflowScreen(String str, String str2, int i, URL url, ComponentsConfig componentsConfig, Map map, String str3, JsonObject jsonObject, String str4, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, boolean z, Map map2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, str2, (i2 & 4) != 0 ? 0 : i, url, componentsConfig, map, (i2 & 64) != 0 ? DefaultLocaleIdSerializer.INSTANCE.m14319getFALLBACKuqtKvyA() : str3, (i2 & 128) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list, (i2 & 1024) != 0 ? null : exitOffers, (i2 & 2048) != 0 ? null : productChangeConfig, (i2 & 4096) != 0 ? true : z, (i2 & 8192) != 0 ? null : map2, null);
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA, reason: not valid java name */
    public final String m13746getDefaultLocaleIdentifieruqtKvyA() {
        return this.defaultLocaleIdentifier;
    }

    public final JsonObject getConfig() {
        return this.config;
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final List<String> getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public final ExitOffers getExitOffers() {
        return this.exitOffers;
    }

    public final ProductChangeConfig getProductChangeConfig() {
        return this.productChangeConfig;
    }

    public final boolean getAutomaticallyScaleFontSize() {
        return this.automaticallyScaleFontSize;
    }

    public final Map<String, StateDeclaration> getStateDeclarations() {
        return this.stateDeclarations;
    }
}
