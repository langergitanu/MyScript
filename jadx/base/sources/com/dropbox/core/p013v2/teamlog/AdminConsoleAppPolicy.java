package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminConsoleAppPolicy {
    ALLOW,
    BLOCK,
    DEFAULT,
    OTHER;

    static class Serializer extends UnionSerializer<AdminConsoleAppPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminConsoleAppPolicy adminConsoleAppPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44411.$SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPolicy[adminConsoleAppPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("allow");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("block");
            } else if (i == 3) {
                jsonGenerator.writeString("default");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminConsoleAppPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminConsoleAppPolicy adminConsoleAppPolicy;
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
            if ("allow".equals(tag)) {
                adminConsoleAppPolicy = AdminConsoleAppPolicy.ALLOW;
            } else if ("block".equals(tag)) {
                adminConsoleAppPolicy = AdminConsoleAppPolicy.BLOCK;
            } else if ("default".equals(tag)) {
                adminConsoleAppPolicy = AdminConsoleAppPolicy.DEFAULT;
            } else {
                adminConsoleAppPolicy = AdminConsoleAppPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminConsoleAppPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminConsoleAppPolicy$1 */
    static /* synthetic */ class C44411 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPolicy;

        static {
            int[] iArr = new int[AdminConsoleAppPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPolicy = iArr;
            try {
                iArr[AdminConsoleAppPolicy.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPolicy[AdminConsoleAppPolicy.BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPolicy[AdminConsoleAppPolicy.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
