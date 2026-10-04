package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DesktopDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.LegacyDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.MobileDeviceSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.WebDeviceSessionLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class LinkedDeviceLogInfo {
    public static final LinkedDeviceLogInfo OTHER = new LinkedDeviceLogInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private DesktopDeviceSessionLogInfo desktopDeviceSessionValue;
    private LegacyDeviceSessionLogInfo legacyDeviceSessionValue;
    private MobileDeviceSessionLogInfo mobileDeviceSessionValue;
    private WebDeviceSessionLogInfo webDeviceSessionValue;

    public enum Tag {
        DESKTOP_DEVICE_SESSION,
        LEGACY_DEVICE_SESSION,
        MOBILE_DEVICE_SESSION,
        WEB_DEVICE_SESSION,
        OTHER
    }

    private LinkedDeviceLogInfo() {
    }

    private LinkedDeviceLogInfo withTag(Tag tag) {
        LinkedDeviceLogInfo linkedDeviceLogInfo = new LinkedDeviceLogInfo();
        linkedDeviceLogInfo._tag = tag;
        return linkedDeviceLogInfo;
    }

    private LinkedDeviceLogInfo withTagAndDesktopDeviceSession(Tag tag, DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo) {
        LinkedDeviceLogInfo linkedDeviceLogInfo = new LinkedDeviceLogInfo();
        linkedDeviceLogInfo._tag = tag;
        linkedDeviceLogInfo.desktopDeviceSessionValue = desktopDeviceSessionLogInfo;
        return linkedDeviceLogInfo;
    }

    private LinkedDeviceLogInfo withTagAndLegacyDeviceSession(Tag tag, LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo) {
        LinkedDeviceLogInfo linkedDeviceLogInfo = new LinkedDeviceLogInfo();
        linkedDeviceLogInfo._tag = tag;
        linkedDeviceLogInfo.legacyDeviceSessionValue = legacyDeviceSessionLogInfo;
        return linkedDeviceLogInfo;
    }

    private LinkedDeviceLogInfo withTagAndMobileDeviceSession(Tag tag, MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo) {
        LinkedDeviceLogInfo linkedDeviceLogInfo = new LinkedDeviceLogInfo();
        linkedDeviceLogInfo._tag = tag;
        linkedDeviceLogInfo.mobileDeviceSessionValue = mobileDeviceSessionLogInfo;
        return linkedDeviceLogInfo;
    }

    private LinkedDeviceLogInfo withTagAndWebDeviceSession(Tag tag, WebDeviceSessionLogInfo webDeviceSessionLogInfo) {
        LinkedDeviceLogInfo linkedDeviceLogInfo = new LinkedDeviceLogInfo();
        linkedDeviceLogInfo._tag = tag;
        linkedDeviceLogInfo.webDeviceSessionValue = webDeviceSessionLogInfo;
        return linkedDeviceLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isDesktopDeviceSession() {
        return this._tag == Tag.DESKTOP_DEVICE_SESSION;
    }

    public static LinkedDeviceLogInfo desktopDeviceSession(DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo) {
        if (desktopDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndDesktopDeviceSession(Tag.DESKTOP_DEVICE_SESSION, desktopDeviceSessionLogInfo);
    }

    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionValue() {
        if (this._tag != Tag.DESKTOP_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.DESKTOP_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return this.desktopDeviceSessionValue;
    }

    public boolean isLegacyDeviceSession() {
        return this._tag == Tag.LEGACY_DEVICE_SESSION;
    }

    public static LinkedDeviceLogInfo legacyDeviceSession(LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo) {
        if (legacyDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndLegacyDeviceSession(Tag.LEGACY_DEVICE_SESSION, legacyDeviceSessionLogInfo);
    }

    public LegacyDeviceSessionLogInfo getLegacyDeviceSessionValue() {
        if (this._tag != Tag.LEGACY_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.LEGACY_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return this.legacyDeviceSessionValue;
    }

    public boolean isMobileDeviceSession() {
        return this._tag == Tag.MOBILE_DEVICE_SESSION;
    }

    public static LinkedDeviceLogInfo mobileDeviceSession(MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo) {
        if (mobileDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndMobileDeviceSession(Tag.MOBILE_DEVICE_SESSION, mobileDeviceSessionLogInfo);
    }

    public MobileDeviceSessionLogInfo getMobileDeviceSessionValue() {
        if (this._tag != Tag.MOBILE_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.MOBILE_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return this.mobileDeviceSessionValue;
    }

    public boolean isWebDeviceSession() {
        return this._tag == Tag.WEB_DEVICE_SESSION;
    }

    public static LinkedDeviceLogInfo webDeviceSession(WebDeviceSessionLogInfo webDeviceSessionLogInfo) {
        if (webDeviceSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndWebDeviceSession(Tag.WEB_DEVICE_SESSION, webDeviceSessionLogInfo);
    }

    public WebDeviceSessionLogInfo getWebDeviceSessionValue() {
        if (this._tag != Tag.WEB_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.WEB_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return this.webDeviceSessionValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.desktopDeviceSessionValue, this.legacyDeviceSessionValue, this.mobileDeviceSessionValue, this.webDeviceSessionValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LinkedDeviceLogInfo)) {
            return false;
        }
        LinkedDeviceLogInfo linkedDeviceLogInfo = (LinkedDeviceLogInfo) obj;
        if (this._tag != linkedDeviceLogInfo._tag) {
            return false;
        }
        int i = C44901.$SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[this._tag.ordinal()];
        if (i == 1) {
            DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo = this.desktopDeviceSessionValue;
            DesktopDeviceSessionLogInfo desktopDeviceSessionLogInfo2 = linkedDeviceLogInfo.desktopDeviceSessionValue;
            return desktopDeviceSessionLogInfo == desktopDeviceSessionLogInfo2 || desktopDeviceSessionLogInfo.equals(desktopDeviceSessionLogInfo2);
        }
        if (i == 2) {
            LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo = this.legacyDeviceSessionValue;
            LegacyDeviceSessionLogInfo legacyDeviceSessionLogInfo2 = linkedDeviceLogInfo.legacyDeviceSessionValue;
            return legacyDeviceSessionLogInfo == legacyDeviceSessionLogInfo2 || legacyDeviceSessionLogInfo.equals(legacyDeviceSessionLogInfo2);
        }
        if (i == 3) {
            MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo = this.mobileDeviceSessionValue;
            MobileDeviceSessionLogInfo mobileDeviceSessionLogInfo2 = linkedDeviceLogInfo.mobileDeviceSessionValue;
            return mobileDeviceSessionLogInfo == mobileDeviceSessionLogInfo2 || mobileDeviceSessionLogInfo.equals(mobileDeviceSessionLogInfo2);
        }
        if (i != 4) {
            return i == 5;
        }
        WebDeviceSessionLogInfo webDeviceSessionLogInfo = this.webDeviceSessionValue;
        WebDeviceSessionLogInfo webDeviceSessionLogInfo2 = linkedDeviceLogInfo.webDeviceSessionValue;
        return webDeviceSessionLogInfo == webDeviceSessionLogInfo2 || webDeviceSessionLogInfo.equals(webDeviceSessionLogInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.LinkedDeviceLogInfo$1 */
    static /* synthetic */ class C44901 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag = iArr;
            try {
                iArr[Tag.DESKTOP_DEVICE_SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[Tag.LEGACY_DEVICE_SESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[Tag.MOBILE_DEVICE_SESSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[Tag.WEB_DEVICE_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<LinkedDeviceLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkedDeviceLogInfo linkedDeviceLogInfo, JsonGenerator jsonGenerator) throws IOException {
            int i = C44901.$SwitchMap$com$dropbox$core$v2$teamlog$LinkedDeviceLogInfo$Tag[linkedDeviceLogInfo.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("desktop_device_session", jsonGenerator);
                DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(linkedDeviceLogInfo.desktopDeviceSessionValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("legacy_device_session", jsonGenerator);
                LegacyDeviceSessionLogInfo.Serializer.INSTANCE.serialize(linkedDeviceLogInfo.legacyDeviceSessionValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("mobile_device_session", jsonGenerator);
                MobileDeviceSessionLogInfo.Serializer.INSTANCE.serialize(linkedDeviceLogInfo.mobileDeviceSessionValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("web_device_session", jsonGenerator);
                WebDeviceSessionLogInfo.Serializer.INSTANCE.serialize(linkedDeviceLogInfo.webDeviceSessionValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkedDeviceLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkedDeviceLogInfo linkedDeviceLogInfoWebDeviceSession;
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
            if ("desktop_device_session".equals(tag)) {
                linkedDeviceLogInfoWebDeviceSession = LinkedDeviceLogInfo.desktopDeviceSession(DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("legacy_device_session".equals(tag)) {
                linkedDeviceLogInfoWebDeviceSession = LinkedDeviceLogInfo.legacyDeviceSession(LegacyDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("mobile_device_session".equals(tag)) {
                linkedDeviceLogInfoWebDeviceSession = LinkedDeviceLogInfo.mobileDeviceSession(MobileDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("web_device_session".equals(tag)) {
                linkedDeviceLogInfoWebDeviceSession = LinkedDeviceLogInfo.webDeviceSession(WebDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                linkedDeviceLogInfoWebDeviceSession = LinkedDeviceLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return linkedDeviceLogInfoWebDeviceSession;
        }
    }
}
