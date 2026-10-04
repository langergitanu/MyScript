package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum AclUpdatePolicy {
    OWNER,
    EDITORS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AclUpdatePolicy$1 */
    static /* synthetic */ class C42481 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AclUpdatePolicy;

        static {
            int[] iArr = new int[AclUpdatePolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AclUpdatePolicy = iArr;
            try {
                iArr[AclUpdatePolicy.OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AclUpdatePolicy[AclUpdatePolicy.EDITORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<AclUpdatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AclUpdatePolicy aclUpdatePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42481.$SwitchMap$com$dropbox$core$v2$sharing$AclUpdatePolicy[aclUpdatePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("owner");
            } else if (i == 2) {
                jsonGenerator.writeString("editors");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AclUpdatePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AclUpdatePolicy aclUpdatePolicy;
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
            if ("owner".equals(tag)) {
                aclUpdatePolicy = AclUpdatePolicy.OWNER;
            } else if ("editors".equals(tag)) {
                aclUpdatePolicy = AclUpdatePolicy.EDITORS;
            } else {
                aclUpdatePolicy = AclUpdatePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return aclUpdatePolicy;
        }
    }
}
