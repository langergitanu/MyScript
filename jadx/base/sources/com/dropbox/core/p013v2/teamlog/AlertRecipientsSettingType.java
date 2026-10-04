package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AlertRecipientsSettingType {
    CUSTOM_LIST,
    INVALID,
    NONE,
    TEAM_ADMINS,
    OTHER;

    static class Serializer extends UnionSerializer<AlertRecipientsSettingType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AlertRecipientsSettingType alertRecipientsSettingType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44441.f782x704aa0df[alertRecipientsSettingType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("custom_list");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invalid");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("none");
            } else if (i == 4) {
                jsonGenerator.writeString("team_admins");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AlertRecipientsSettingType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AlertRecipientsSettingType alertRecipientsSettingType;
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
            if ("custom_list".equals(tag)) {
                alertRecipientsSettingType = AlertRecipientsSettingType.CUSTOM_LIST;
            } else if ("invalid".equals(tag)) {
                alertRecipientsSettingType = AlertRecipientsSettingType.INVALID;
            } else if ("none".equals(tag)) {
                alertRecipientsSettingType = AlertRecipientsSettingType.NONE;
            } else if ("team_admins".equals(tag)) {
                alertRecipientsSettingType = AlertRecipientsSettingType.TEAM_ADMINS;
            } else {
                alertRecipientsSettingType = AlertRecipientsSettingType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return alertRecipientsSettingType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AlertRecipientsSettingType$1 */
    static /* synthetic */ class C44441 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AlertRecipientsSettingType */
        static final /* synthetic */ int[] f782x704aa0df;

        static {
            int[] iArr = new int[AlertRecipientsSettingType.values().length];
            f782x704aa0df = iArr;
            try {
                iArr[AlertRecipientsSettingType.CUSTOM_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f782x704aa0df[AlertRecipientsSettingType.INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f782x704aa0df[AlertRecipientsSettingType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f782x704aa0df[AlertRecipientsSettingType.TEAM_ADMINS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
