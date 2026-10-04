package com.revenuecat.purchases.paywalls.components;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: WebViewComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@SerialName("web_view")
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-Bk\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\u0002\u0010\u0014J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"¨\u0006."}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/WebViewComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", ImagesContract.URL, "", "id", "name", "visible", "", "protocolVersion", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "overrides", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialWebViewComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "getOverrides", "()Ljava/util/List;", "getProtocolVersion$annotations", "()V", "getProtocolVersion", "()I", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getUrl", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final class WebViewComponent implements PaywallComponent {
    public static final int SUPPORTED_PROTOCOL_VERSION = 1;
    private final String id;
    private final String name;
    private final List<ComponentOverride<PartialWebViewComponent>> overrides;
    private final int protocolVersion;
    private final Size size;
    private final String url;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialWebViewComponent$$serializer.INSTANCE))};

    @SerialName("protocol_version")
    public static /* synthetic */ void getProtocolVersion$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewComponent)) {
            return false;
        }
        WebViewComponent webViewComponent = (WebViewComponent) obj;
        return Intrinsics.areEqual(this.url, webViewComponent.url) && Intrinsics.areEqual(this.id, webViewComponent.id) && Intrinsics.areEqual(this.name, webViewComponent.name) && Intrinsics.areEqual(this.visible, webViewComponent.visible) && this.protocolVersion == webViewComponent.protocolVersion && Intrinsics.areEqual(this.size, webViewComponent.size) && Intrinsics.areEqual(this.overrides, webViewComponent.overrides);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.id.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.visible;
        return ((((((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + this.protocolVersion) * 31) + this.size.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "WebViewComponent(url=" + this.url + ", id=" + this.id + ", name=" + this.name + ", visible=" + this.visible + ", protocolVersion=" + this.protocolVersion + ", size=" + this.size + ", overrides=" + this.overrides + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WebViewComponent(int i, String str, String str2, String str3, Boolean bool, @SerialName("protocol_version") int i2, Size size, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (51 != (i & 51)) {
            PluginExceptionsKt.throwMissingFieldException(i, 51, WebViewComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.url = str;
        this.id = str2;
        if ((i & 4) == 0) {
            this.name = null;
        } else {
            this.name = str3;
        }
        if ((i & 8) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        this.protocolVersion = i2;
        this.size = size;
        if ((i & 64) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list;
        }
    }

    public WebViewComponent(String url, String id, String str, Boolean bool, int i, Size size, List<ComponentOverride<PartialWebViewComponent>> overrides) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.url = url;
        this.id = id;
        this.name = str;
        this.visible = bool;
        this.protocolVersion = i;
        this.size = size;
        this.overrides = overrides;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(WebViewComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.url);
        output.encodeStringElement(serialDesc, 1, self.id);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.visible);
        }
        output.encodeIntElement(serialDesc, 4, self.protocolVersion);
        output.encodeSerializableElement(serialDesc, 5, Size$$serializer.INSTANCE, self.size);
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.overrides);
    }

    public final /* synthetic */ String getUrl() {
        return this.url;
    }

    public final /* synthetic */ String getId() {
        return this.id;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public final /* synthetic */ int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public /* synthetic */ WebViewComponent(String str, String str2, String str3, Boolean bool, int i, Size size, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : bool, i, size, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    /* JADX INFO: compiled from: WebViewComponent.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/WebViewComponent$Companion;", "", "()V", "SUPPORTED_PROTOCOL_VERSION", "", "getSUPPORTED_PROTOCOL_VERSION$annotations", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/WebViewComponent;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getSUPPORTED_PROTOCOL_VERSION$annotations() {
        }

        private Companion() {
        }

        public final KSerializer<WebViewComponent> serializer() {
            return WebViewComponent$$serializer.INSTANCE;
        }
    }
}
