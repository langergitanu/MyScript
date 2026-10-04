package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RolloutMethod {
    UNLINK_ALL,
    UNLINK_MOST_INACTIVE,
    ADD_MEMBER_TO_EXCEPTIONS;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.RolloutMethod$1 */
    static /* synthetic */ class C45511 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$RolloutMethod;

        static {
            int[] iArr = new int[RolloutMethod.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$RolloutMethod = iArr;
            try {
                iArr[RolloutMethod.UNLINK_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$RolloutMethod[RolloutMethod.UNLINK_MOST_INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$RolloutMethod[RolloutMethod.ADD_MEMBER_TO_EXCEPTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<RolloutMethod> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RolloutMethod rolloutMethod, JsonGenerator jsonGenerator) throws IOException {
            int i = C45511.$SwitchMap$com$dropbox$core$v2$teampolicies$RolloutMethod[rolloutMethod.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("unlink_all");
            } else if (i == 2) {
                jsonGenerator.writeString("unlink_most_inactive");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("add_member_to_exceptions");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + rolloutMethod);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RolloutMethod deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RolloutMethod rolloutMethod;
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
            if ("unlink_all".equals(tag)) {
                rolloutMethod = RolloutMethod.UNLINK_ALL;
            } else if ("unlink_most_inactive".equals(tag)) {
                rolloutMethod = RolloutMethod.UNLINK_MOST_INACTIVE;
            } else if ("add_member_to_exceptions".equals(tag)) {
                rolloutMethod = RolloutMethod.ADD_MEMBER_TO_EXCEPTIONS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return rolloutMethod;
        }
    }
}
