package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SyncSetting {
    DEFAULT,
    NOT_SYNCED,
    NOT_SYNCED_INACTIVE,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SyncSetting$1 */
    static /* synthetic */ class C42031 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SyncSetting;

        static {
            int[] iArr = new int[SyncSetting.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SyncSetting = iArr;
            try {
                iArr[SyncSetting.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSetting[SyncSetting.NOT_SYNCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSetting[SyncSetting.NOT_SYNCED_INACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<SyncSetting> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SyncSetting syncSetting, JsonGenerator jsonGenerator) throws IOException {
            int i = C42031.$SwitchMap$com$dropbox$core$v2$files$SyncSetting[syncSetting.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("not_synced");
            } else if (i == 3) {
                jsonGenerator.writeString("not_synced_inactive");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SyncSetting deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SyncSetting syncSetting;
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
                syncSetting = SyncSetting.DEFAULT;
            } else if ("not_synced".equals(tag)) {
                syncSetting = SyncSetting.NOT_SYNCED;
            } else if ("not_synced_inactive".equals(tag)) {
                syncSetting = SyncSetting.NOT_SYNCED_INACTIVE;
            } else {
                syncSetting = SyncSetting.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return syncSetting;
        }
    }
}
