package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminEmailRemindersPolicy {
    DEFAULT,
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<AdminEmailRemindersPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminEmailRemindersPolicy adminEmailRemindersPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44421.$SwitchMap$com$dropbox$core$v2$teamlog$AdminEmailRemindersPolicy[adminEmailRemindersPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("disabled");
            } else if (i == 3) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminEmailRemindersPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminEmailRemindersPolicy adminEmailRemindersPolicy;
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
                adminEmailRemindersPolicy = AdminEmailRemindersPolicy.DEFAULT;
            } else if ("disabled".equals(tag)) {
                adminEmailRemindersPolicy = AdminEmailRemindersPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                adminEmailRemindersPolicy = AdminEmailRemindersPolicy.ENABLED;
            } else {
                adminEmailRemindersPolicy = AdminEmailRemindersPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminEmailRemindersPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminEmailRemindersPolicy$1 */
    static /* synthetic */ class C44421 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminEmailRemindersPolicy;

        static {
            int[] iArr = new int[AdminEmailRemindersPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminEmailRemindersPolicy = iArr;
            try {
                iArr[AdminEmailRemindersPolicy.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminEmailRemindersPolicy[AdminEmailRemindersPolicy.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminEmailRemindersPolicy[AdminEmailRemindersPolicy.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
