package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DeviceType {
    DESKTOP,
    MOBILE,
    OTHER;

    static class Serializer extends UnionSerializer<DeviceType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeviceType deviceType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44571.$SwitchMap$com$dropbox$core$v2$teamlog$DeviceType[deviceType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("desktop");
            } else if (i == 2) {
                jsonGenerator.writeString(NetworkTargetingEvent.TYPE_MOBILE);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeviceType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeviceType deviceType;
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
            if ("desktop".equals(tag)) {
                deviceType = DeviceType.DESKTOP;
            } else if (NetworkTargetingEvent.TYPE_MOBILE.equals(tag)) {
                deviceType = DeviceType.MOBILE;
            } else {
                deviceType = DeviceType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deviceType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DeviceType$1 */
    static /* synthetic */ class C44571 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DeviceType;

        static {
            int[] iArr = new int[DeviceType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DeviceType = iArr;
            try {
                iArr[DeviceType.DESKTOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DeviceType[DeviceType.MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
