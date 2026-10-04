package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ResellerRole {
    NOT_RESELLER,
    RESELLER_ADMIN,
    OTHER;

    static class Serializer extends UnionSerializer<ResellerRole> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ResellerRole resellerRole, JsonGenerator jsonGenerator) throws IOException {
            int i = C45091.$SwitchMap$com$dropbox$core$v2$teamlog$ResellerRole[resellerRole.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("not_reseller");
            } else if (i == 2) {
                jsonGenerator.writeString("reseller_admin");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ResellerRole deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ResellerRole resellerRole;
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
            if ("not_reseller".equals(tag)) {
                resellerRole = ResellerRole.NOT_RESELLER;
            } else if ("reseller_admin".equals(tag)) {
                resellerRole = ResellerRole.RESELLER_ADMIN;
            } else {
                resellerRole = ResellerRole.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return resellerRole;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ResellerRole$1 */
    static /* synthetic */ class C45091 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ResellerRole;

        static {
            int[] iArr = new int[ResellerRole.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ResellerRole = iArr;
            try {
                iArr[ResellerRole.NOT_RESELLER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ResellerRole[ResellerRole.RESELLER_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
