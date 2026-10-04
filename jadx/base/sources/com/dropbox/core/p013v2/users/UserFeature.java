package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum UserFeature {
    PAPER_AS_FILES,
    FILE_LOCKING,
    OTHER;

    static class Serializer extends UnionSerializer<UserFeature> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserFeature userFeature, JsonGenerator jsonGenerator) throws IOException {
            int i = C45661.$SwitchMap$com$dropbox$core$v2$users$UserFeature[userFeature.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("paper_as_files");
            } else if (i == 2) {
                jsonGenerator.writeString("file_locking");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserFeature deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserFeature userFeature;
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
            if ("paper_as_files".equals(tag)) {
                userFeature = UserFeature.PAPER_AS_FILES;
            } else if ("file_locking".equals(tag)) {
                userFeature = UserFeature.FILE_LOCKING;
            } else {
                userFeature = UserFeature.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userFeature;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.UserFeature$1 */
    static /* synthetic */ class C45661 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$UserFeature;

        static {
            int[] iArr = new int[UserFeature.values().length];
            $SwitchMap$com$dropbox$core$v2$users$UserFeature = iArr;
            try {
                iArr[UserFeature.PAPER_AS_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$UserFeature[UserFeature.FILE_LOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
