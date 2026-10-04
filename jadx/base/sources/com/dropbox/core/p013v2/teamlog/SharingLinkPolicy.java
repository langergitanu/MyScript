package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharingLinkPolicy {
    DEFAULT_NO_ONE,
    DEFAULT_PRIVATE,
    DEFAULT_PUBLIC,
    ONLY_PRIVATE,
    OTHER;

    static class Serializer extends UnionSerializer<SharingLinkPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingLinkPolicy sharingLinkPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45181.$SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy[sharingLinkPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("default_no_one");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("default_private");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("default_public");
            } else if (i == 4) {
                jsonGenerator.writeString("only_private");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingLinkPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingLinkPolicy sharingLinkPolicy;
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
            if ("default_no_one".equals(tag)) {
                sharingLinkPolicy = SharingLinkPolicy.DEFAULT_NO_ONE;
            } else if ("default_private".equals(tag)) {
                sharingLinkPolicy = SharingLinkPolicy.DEFAULT_PRIVATE;
            } else if ("default_public".equals(tag)) {
                sharingLinkPolicy = SharingLinkPolicy.DEFAULT_PUBLIC;
            } else if ("only_private".equals(tag)) {
                sharingLinkPolicy = SharingLinkPolicy.ONLY_PRIVATE;
            } else {
                sharingLinkPolicy = SharingLinkPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingLinkPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharingLinkPolicy$1 */
    static /* synthetic */ class C45181 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy;

        static {
            int[] iArr = new int[SharingLinkPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy = iArr;
            try {
                iArr[SharingLinkPolicy.DEFAULT_NO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy[SharingLinkPolicy.DEFAULT_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy[SharingLinkPolicy.DEFAULT_PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingLinkPolicy[SharingLinkPolicy.ONLY_PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
