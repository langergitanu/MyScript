package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DeviceSessionArg;
import com.dropbox.core.p013v2.team.RevokeDesktopClientArg;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class RevokeDeviceSessionArg {
    private Tag _tag;
    private RevokeDesktopClientArg desktopClientValue;
    private DeviceSessionArg mobileClientValue;
    private DeviceSessionArg webSessionValue;

    public enum Tag {
        WEB_SESSION,
        DESKTOP_CLIENT,
        MOBILE_CLIENT
    }

    private RevokeDeviceSessionArg() {
    }

    private RevokeDeviceSessionArg withTag(Tag tag) {
        RevokeDeviceSessionArg revokeDeviceSessionArg = new RevokeDeviceSessionArg();
        revokeDeviceSessionArg._tag = tag;
        return revokeDeviceSessionArg;
    }

    private RevokeDeviceSessionArg withTagAndWebSession(Tag tag, DeviceSessionArg deviceSessionArg) {
        RevokeDeviceSessionArg revokeDeviceSessionArg = new RevokeDeviceSessionArg();
        revokeDeviceSessionArg._tag = tag;
        revokeDeviceSessionArg.webSessionValue = deviceSessionArg;
        return revokeDeviceSessionArg;
    }

    private RevokeDeviceSessionArg withTagAndDesktopClient(Tag tag, RevokeDesktopClientArg revokeDesktopClientArg) {
        RevokeDeviceSessionArg revokeDeviceSessionArg = new RevokeDeviceSessionArg();
        revokeDeviceSessionArg._tag = tag;
        revokeDeviceSessionArg.desktopClientValue = revokeDesktopClientArg;
        return revokeDeviceSessionArg;
    }

    private RevokeDeviceSessionArg withTagAndMobileClient(Tag tag, DeviceSessionArg deviceSessionArg) {
        RevokeDeviceSessionArg revokeDeviceSessionArg = new RevokeDeviceSessionArg();
        revokeDeviceSessionArg._tag = tag;
        revokeDeviceSessionArg.mobileClientValue = deviceSessionArg;
        return revokeDeviceSessionArg;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isWebSession() {
        return this._tag == Tag.WEB_SESSION;
    }

    public static RevokeDeviceSessionArg webSession(DeviceSessionArg deviceSessionArg) {
        if (deviceSessionArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndWebSession(Tag.WEB_SESSION, deviceSessionArg);
    }

    public DeviceSessionArg getWebSessionValue() {
        if (this._tag != Tag.WEB_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.WEB_SESSION, but was Tag." + this._tag.name());
        }
        return this.webSessionValue;
    }

    public boolean isDesktopClient() {
        return this._tag == Tag.DESKTOP_CLIENT;
    }

    public static RevokeDeviceSessionArg desktopClient(RevokeDesktopClientArg revokeDesktopClientArg) {
        if (revokeDesktopClientArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndDesktopClient(Tag.DESKTOP_CLIENT, revokeDesktopClientArg);
    }

    public RevokeDesktopClientArg getDesktopClientValue() {
        if (this._tag != Tag.DESKTOP_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.DESKTOP_CLIENT, but was Tag." + this._tag.name());
        }
        return this.desktopClientValue;
    }

    public boolean isMobileClient() {
        return this._tag == Tag.MOBILE_CLIENT;
    }

    public static RevokeDeviceSessionArg mobileClient(DeviceSessionArg deviceSessionArg) {
        if (deviceSessionArg == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndMobileClient(Tag.MOBILE_CLIENT, deviceSessionArg);
    }

    public DeviceSessionArg getMobileClientValue() {
        if (this._tag != Tag.MOBILE_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.MOBILE_CLIENT, but was Tag." + this._tag.name());
        }
        return this.mobileClientValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.webSessionValue, this.desktopClientValue, this.mobileClientValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RevokeDeviceSessionArg)) {
            return false;
        }
        RevokeDeviceSessionArg revokeDeviceSessionArg = (RevokeDeviceSessionArg) obj;
        if (this._tag != revokeDeviceSessionArg._tag) {
            return false;
        }
        int i = C43911.$SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag[this._tag.ordinal()];
        if (i == 1) {
            DeviceSessionArg deviceSessionArg = this.webSessionValue;
            DeviceSessionArg deviceSessionArg2 = revokeDeviceSessionArg.webSessionValue;
            return deviceSessionArg == deviceSessionArg2 || deviceSessionArg.equals(deviceSessionArg2);
        }
        if (i == 2) {
            RevokeDesktopClientArg revokeDesktopClientArg = this.desktopClientValue;
            RevokeDesktopClientArg revokeDesktopClientArg2 = revokeDeviceSessionArg.desktopClientValue;
            return revokeDesktopClientArg == revokeDesktopClientArg2 || revokeDesktopClientArg.equals(revokeDesktopClientArg2);
        }
        if (i != 3) {
            return false;
        }
        DeviceSessionArg deviceSessionArg3 = this.mobileClientValue;
        DeviceSessionArg deviceSessionArg4 = revokeDeviceSessionArg.mobileClientValue;
        return deviceSessionArg3 == deviceSessionArg4 || deviceSessionArg3.equals(deviceSessionArg4);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RevokeDeviceSessionArg$1 */
    static /* synthetic */ class C43911 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag = iArr;
            try {
                iArr[Tag.WEB_SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag[Tag.DESKTOP_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag[Tag.MOBILE_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RevokeDeviceSessionArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeDeviceSessionArg revokeDeviceSessionArg, JsonGenerator jsonGenerator) throws IOException {
            int i = C43911.$SwitchMap$com$dropbox$core$v2$team$RevokeDeviceSessionArg$Tag[revokeDeviceSessionArg.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("web_session", jsonGenerator);
                DeviceSessionArg.Serializer.INSTANCE.serialize(revokeDeviceSessionArg.webSessionValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("desktop_client", jsonGenerator);
                RevokeDesktopClientArg.Serializer.INSTANCE.serialize(revokeDeviceSessionArg.desktopClientValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("mobile_client", jsonGenerator);
                DeviceSessionArg.Serializer.INSTANCE.serialize(revokeDeviceSessionArg.mobileClientValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + revokeDeviceSessionArg.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeDeviceSessionArg deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RevokeDeviceSessionArg revokeDeviceSessionArgMobileClient;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("web_session".equals(tag)) {
                revokeDeviceSessionArgMobileClient = RevokeDeviceSessionArg.webSession(DeviceSessionArg.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("desktop_client".equals(tag)) {
                revokeDeviceSessionArgMobileClient = RevokeDeviceSessionArg.desktopClient(RevokeDesktopClientArg.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("mobile_client".equals(tag)) {
                revokeDeviceSessionArgMobileClient = RevokeDeviceSessionArg.mobileClient(DeviceSessionArg.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeDeviceSessionArgMobileClient;
        }
    }
}
