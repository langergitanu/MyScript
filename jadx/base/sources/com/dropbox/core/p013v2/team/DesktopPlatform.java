package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DesktopPlatform {
    WINDOWS,
    MAC,
    LINUX,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.DesktopPlatform$1 */
    static /* synthetic */ class C43261 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$DesktopPlatform;

        static {
            int[] iArr = new int[DesktopPlatform.values().length];
            $SwitchMap$com$dropbox$core$v2$team$DesktopPlatform = iArr;
            try {
                iArr[DesktopPlatform.WINDOWS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$DesktopPlatform[DesktopPlatform.MAC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$DesktopPlatform[DesktopPlatform.LINUX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<DesktopPlatform> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DesktopPlatform desktopPlatform, JsonGenerator jsonGenerator) throws IOException {
            int i = C43261.$SwitchMap$com$dropbox$core$v2$team$DesktopPlatform[desktopPlatform.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("windows");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("mac");
            } else if (i == 3) {
                jsonGenerator.writeString("linux");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DesktopPlatform deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DesktopPlatform desktopPlatform;
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
            if ("windows".equals(tag)) {
                desktopPlatform = DesktopPlatform.WINDOWS;
            } else if ("mac".equals(tag)) {
                desktopPlatform = DesktopPlatform.MAC;
            } else if ("linux".equals(tag)) {
                desktopPlatform = DesktopPlatform.LINUX;
            } else {
                desktopPlatform = DesktopPlatform.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return desktopPlatform;
        }
    }
}
