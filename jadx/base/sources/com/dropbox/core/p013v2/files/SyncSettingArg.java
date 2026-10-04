package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SyncSettingArg {
    DEFAULT,
    NOT_SYNCED,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SyncSettingArg$1 */
    static /* synthetic */ class C42041 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SyncSettingArg;

        static {
            int[] iArr = new int[SyncSettingArg.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SyncSettingArg = iArr;
            try {
                iArr[SyncSettingArg.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSettingArg[SyncSettingArg.NOT_SYNCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SyncSettingArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SyncSettingArg syncSettingArg, JsonGenerator jsonGenerator) throws IOException {
            int i = C42041.$SwitchMap$com$dropbox$core$v2$files$SyncSettingArg[syncSettingArg.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default");
            } else if (i == 2) {
                jsonGenerator.writeString("not_synced");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SyncSettingArg deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SyncSettingArg syncSettingArg;
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
            if ("default".equals(tag)) {
                syncSettingArg = SyncSettingArg.DEFAULT;
            } else if ("not_synced".equals(tag)) {
                syncSettingArg = SyncSettingArg.NOT_SYNCED;
            } else {
                syncSettingArg = SyncSettingArg.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return syncSettingArg;
        }
    }
}
