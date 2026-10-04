package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminConsoleAppPermission {
    DEFAULT_FOR_LISTED_APPS,
    DEFAULT_FOR_UNLISTED_APPS,
    OTHER;

    static class Serializer extends UnionSerializer<AdminConsoleAppPermission> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminConsoleAppPermission adminConsoleAppPermission, JsonGenerator jsonGenerator) throws IOException {
            int i = C44401.$SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPermission[adminConsoleAppPermission.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default_for_listed_apps");
            } else if (i == 2) {
                jsonGenerator.writeString("default_for_unlisted_apps");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminConsoleAppPermission deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminConsoleAppPermission adminConsoleAppPermission;
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
            if ("default_for_listed_apps".equals(tag)) {
                adminConsoleAppPermission = AdminConsoleAppPermission.DEFAULT_FOR_LISTED_APPS;
            } else if ("default_for_unlisted_apps".equals(tag)) {
                adminConsoleAppPermission = AdminConsoleAppPermission.DEFAULT_FOR_UNLISTED_APPS;
            } else {
                adminConsoleAppPermission = AdminConsoleAppPermission.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminConsoleAppPermission;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminConsoleAppPermission$1 */
    static /* synthetic */ class C44401 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPermission;

        static {
            int[] iArr = new int[AdminConsoleAppPermission.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPermission = iArr;
            try {
                iArr[AdminConsoleAppPermission.DEFAULT_FOR_LISTED_APPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminConsoleAppPermission[AdminConsoleAppPermission.DEFAULT_FOR_UNLISTED_APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
