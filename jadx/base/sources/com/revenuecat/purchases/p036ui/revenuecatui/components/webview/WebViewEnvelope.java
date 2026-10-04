package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import com.google.api.client.http.HttpMethods;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Required;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: WebViewEnvelope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0003:;<Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BW\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ja\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0006\u00100\u001a\u00020\u0005J\t\u00101\u001a\u00020\u0005HÖ\u0001J&\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÁ\u0001¢\u0006\u0002\b9R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u0006="}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope;", "", "seen1", "", "channel", "", "protocolVersion", "kind", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;", "componentId", "type", "id", "payload", "Lkotlinx/serialization/json/JsonObject;", "error", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)V", "getChannel$annotations", "()V", "getChannel", "()Ljava/lang/String;", "getComponentId$annotations", "getComponentId", "getError", "getId", "getKind", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;", "getPayload", "()Lkotlinx/serialization/json/JsonObject;", "getProtocolVersion$annotations", "getProtocolVersion", "()I", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toJsonString", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$revenuecatui_defaultsRelease", "$serializer", "Companion", "Kind", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class WebViewEnvelope {
    public static final String CHANNEL = "rc-web-components";
    public static final int DEFAULT_PROTOCOL_VERSION = 1;
    public static final String NATIVE_OBJECT_NAME = "rcWebComponents";
    public static final String RECEIVE_FUNCTION = "__rcWebComponentsReceive";
    private final String channel;
    private final String componentId;
    private final String error;
    private final String id;
    private final Kind kind;
    private final JsonObject payload;
    private final int protocolVersion;
    private final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, Kind.INSTANCE.serializer(), null, null, null, null, null};
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewEnvelope$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setExplicitNulls(false);
        }
    }, 1, null);

    public static /* synthetic */ WebViewEnvelope copy$default(WebViewEnvelope webViewEnvelope, String str, int i, Kind kind, String str2, String str3, String str4, JsonObject jsonObject, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = webViewEnvelope.channel;
        }
        if ((i2 & 2) != 0) {
            i = webViewEnvelope.protocolVersion;
        }
        if ((i2 & 4) != 0) {
            kind = webViewEnvelope.kind;
        }
        if ((i2 & 8) != 0) {
            str2 = webViewEnvelope.componentId;
        }
        if ((i2 & 16) != 0) {
            str3 = webViewEnvelope.type;
        }
        if ((i2 & 32) != 0) {
            str4 = webViewEnvelope.id;
        }
        if ((i2 & 64) != 0) {
            jsonObject = webViewEnvelope.payload;
        }
        if ((i2 & 128) != 0) {
            str5 = webViewEnvelope.error;
        }
        JsonObject jsonObject2 = jsonObject;
        String str6 = str5;
        String str7 = str3;
        String str8 = str4;
        return webViewEnvelope.copy(str, i, kind, str2, str7, str8, jsonObject2, str6);
    }

    @Required
    public static /* synthetic */ void getChannel$annotations() {
    }

    @SerialName("component_id")
    public static /* synthetic */ void getComponentId$annotations() {
    }

    @SerialName("protocol_version")
    public static /* synthetic */ void getProtocolVersion$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final JsonObject getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final WebViewEnvelope copy(String channel, int protocolVersion, Kind kind, String componentId, String type, String id, JsonObject payload, String error) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        return new WebViewEnvelope(channel, protocolVersion, kind, componentId, type, id, payload, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewEnvelope)) {
            return false;
        }
        WebViewEnvelope webViewEnvelope = (WebViewEnvelope) other;
        return Intrinsics.areEqual(this.channel, webViewEnvelope.channel) && this.protocolVersion == webViewEnvelope.protocolVersion && this.kind == webViewEnvelope.kind && Intrinsics.areEqual(this.componentId, webViewEnvelope.componentId) && Intrinsics.areEqual(this.type, webViewEnvelope.type) && Intrinsics.areEqual(this.id, webViewEnvelope.id) && Intrinsics.areEqual(this.payload, webViewEnvelope.payload) && Intrinsics.areEqual(this.error, webViewEnvelope.error);
    }

    public int hashCode() {
        int iHashCode = ((((((this.channel.hashCode() * 31) + Integer.hashCode(this.protocolVersion)) * 31) + this.kind.hashCode()) * 31) + this.componentId.hashCode()) * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonObject jsonObject = this.payload;
        int iHashCode4 = (iHashCode3 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str3 = this.error;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "WebViewEnvelope(channel=" + this.channel + ", protocolVersion=" + this.protocolVersion + ", kind=" + this.kind + ", componentId=" + this.componentId + ", type=" + this.type + ", id=" + this.id + ", payload=" + this.payload + ", error=" + this.error + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WebViewEnvelope(int i, @Required String str, @SerialName("protocol_version") int i2, Kind kind, @SerialName("component_id") String str2, String str3, String str4, JsonObject jsonObject, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, WebViewEnvelope$$serializer.INSTANCE.getDescriptor());
        }
        this.channel = str;
        this.protocolVersion = i2;
        this.kind = kind;
        this.componentId = str2;
        if ((i & 16) == 0) {
            this.type = null;
        } else {
            this.type = str3;
        }
        if ((i & 32) == 0) {
            this.id = null;
        } else {
            this.id = str4;
        }
        if ((i & 64) == 0) {
            this.payload = null;
        } else {
            this.payload = jsonObject;
        }
        if ((i & 128) == 0) {
            this.error = null;
        } else {
            this.error = str5;
        }
    }

    public WebViewEnvelope(String channel, int i, Kind kind, String componentId, String str, String str2, JsonObject jsonObject, String str3) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.channel = channel;
        this.protocolVersion = i;
        this.kind = kind;
        this.componentId = componentId;
        this.type = str;
        this.id = str2;
        this.payload = jsonObject;
        this.error = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$revenuecatui_defaultsRelease(WebViewEnvelope self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.channel);
        output.encodeIntElement(serialDesc, 1, self.protocolVersion);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.kind);
        output.encodeStringElement(serialDesc, 3, self.componentId);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.payload != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, JsonObjectSerializer.INSTANCE, self.payload);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.error == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.error);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ WebViewEnvelope(java.lang.String r2, int r3, com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewEnvelope.Kind r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, kotlinx.serialization.json.JsonObject r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L6
            java.lang.String r2 = "rc-web-components"
        L6:
            r11 = r10 & 16
            r0 = 0
            if (r11 == 0) goto Lc
            r6 = r0
        Lc:
            r11 = r10 & 32
            if (r11 == 0) goto L11
            r7 = r0
        L11:
            r11 = r10 & 64
            if (r11 == 0) goto L16
            r8 = r0
        L16:
            r10 = r10 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L24
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L24:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewEnvelope.<init>(java.lang.String, int, com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewEnvelope$Kind, java.lang.String, java.lang.String, java.lang.String, kotlinx.serialization.json.JsonObject, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getChannel() {
        return this.channel;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public final JsonObject getPayload() {
        return this.payload;
    }

    public final String getError() {
        return this.error;
    }

    /* JADX INFO: compiled from: WebViewEnvelope.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;", "", "(Ljava/lang/String;I)V", HttpMethods.CONNECT, "INIT", "REJECT", "MESSAGE", "REQUEST", "RESPONSE", "ERROR", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    public enum Kind {
        CONNECT,
        INIT,
        REJECT,
        MESSAGE,
        REQUEST,
        RESPONSE,
        ERROR;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewEnvelope.Kind.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewEnvelope.Kind", Kind.values(), new String[]{"connect", "init", "reject", "message", "request", "response", "error"}, new Annotation[][]{null, null, null, null, null, null, null}, null);
            }
        });

        /* JADX INFO: compiled from: WebViewEnvelope.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Kind;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Kind.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Kind> serializer() {
                return get$cachedSerializer();
            }
        }
    }

    public final String toJsonString() {
        return json.encodeToString(INSTANCE.serializer(), this);
    }

    /* JADX INFO: compiled from: WebViewEnvelope.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope$Companion;", "", "()V", "CHANNEL", "", "DEFAULT_PROTOCOL_VERSION", "", "NATIVE_OBJECT_NAME", "RECEIVE_FUNCTION", "json", "Lkotlinx/serialization/json/Json;", "parse", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope;", "rawJson", "serializer", "Lkotlinx/serialization/KSerializer;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WebViewEnvelope> serializer() {
            return WebViewEnvelope$$serializer.INSTANCE;
        }

        public final WebViewEnvelope parse(String rawJson) {
            Intrinsics.checkNotNullParameter(rawJson, "rawJson");
            try {
                Object objDecodeFromString = WebViewEnvelope.json.decodeFromString(serializer(), rawJson);
                if (!Intrinsics.areEqual(((WebViewEnvelope) objDecodeFromString).getChannel(), WebViewEnvelope.CHANNEL)) {
                    objDecodeFromString = null;
                }
                return (WebViewEnvelope) objDecodeFromString;
            } catch (SerializationException unused) {
                return null;
            }
        }
    }
}
