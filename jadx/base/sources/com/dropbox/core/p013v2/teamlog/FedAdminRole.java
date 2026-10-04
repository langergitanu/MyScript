package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FedAdminRole {
    ENTERPRISE_ADMIN,
    NOT_ENTERPRISE_ADMIN,
    OTHER;

    static class Serializer extends UnionSerializer<FedAdminRole> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FedAdminRole fedAdminRole, JsonGenerator jsonGenerator) throws IOException {
            int i = C44721.$SwitchMap$com$dropbox$core$v2$teamlog$FedAdminRole[fedAdminRole.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("enterprise_admin");
            } else if (i == 2) {
                jsonGenerator.writeString("not_enterprise_admin");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FedAdminRole deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FedAdminRole fedAdminRole;
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
            if ("enterprise_admin".equals(tag)) {
                fedAdminRole = FedAdminRole.ENTERPRISE_ADMIN;
            } else if ("not_enterprise_admin".equals(tag)) {
                fedAdminRole = FedAdminRole.NOT_ENTERPRISE_ADMIN;
            } else {
                fedAdminRole = FedAdminRole.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fedAdminRole;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FedAdminRole$1 */
    static /* synthetic */ class C44721 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FedAdminRole;

        static {
            int[] iArr = new int[FedAdminRole.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FedAdminRole = iArr;
            try {
                iArr[FedAdminRole.ENTERPRISE_ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedAdminRole[FedAdminRole.NOT_ENTERPRISE_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
