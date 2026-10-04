package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DeviceUnlinkPolicy {
    KEEP,
    REMOVE,
    OTHER;

    static class Serializer extends UnionSerializer<DeviceUnlinkPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeviceUnlinkPolicy deviceUnlinkPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44581.$SwitchMap$com$dropbox$core$v2$teamlog$DeviceUnlinkPolicy[deviceUnlinkPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("keep");
            } else if (i == 2) {
                jsonGenerator.writeString("remove");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeviceUnlinkPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeviceUnlinkPolicy deviceUnlinkPolicy;
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
            if ("keep".equals(tag)) {
                deviceUnlinkPolicy = DeviceUnlinkPolicy.KEEP;
            } else if ("remove".equals(tag)) {
                deviceUnlinkPolicy = DeviceUnlinkPolicy.REMOVE;
            } else {
                deviceUnlinkPolicy = DeviceUnlinkPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deviceUnlinkPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DeviceUnlinkPolicy$1 */
    static /* synthetic */ class C44581 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$DeviceUnlinkPolicy;

        static {
            int[] iArr = new int[DeviceUnlinkPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$DeviceUnlinkPolicy = iArr;
            try {
                iArr[DeviceUnlinkPolicy.KEEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$DeviceUnlinkPolicy[DeviceUnlinkPolicy.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
