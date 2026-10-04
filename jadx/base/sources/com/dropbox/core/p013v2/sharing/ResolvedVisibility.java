package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum ResolvedVisibility {
    PUBLIC,
    TEAM_ONLY,
    PASSWORD,
    TEAM_AND_PASSWORD,
    SHARED_FOLDER_ONLY,
    NO_ONE,
    ONLY_YOU,
    OTHER;

    static class Serializer extends UnionSerializer<ResolvedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ResolvedVisibility resolvedVisibility, JsonGenerator jsonGenerator) throws IOException {
            switch (C42941.$SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[resolvedVisibility.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("public");
                    break;
                case 2:
                    jsonGenerator.writeString("team_only");
                    break;
                case 3:
                    jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                    break;
                case 4:
                    jsonGenerator.writeString("team_and_password");
                    break;
                case 5:
                    jsonGenerator.writeString("shared_folder_only");
                    break;
                case 6:
                    jsonGenerator.writeString("no_one");
                    break;
                case 7:
                    jsonGenerator.writeString("only_you");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ResolvedVisibility deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ResolvedVisibility resolvedVisibility;
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
            if ("public".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.PUBLIC;
            } else if ("team_only".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.TEAM_ONLY;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                resolvedVisibility = ResolvedVisibility.PASSWORD;
            } else if ("team_and_password".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.TEAM_AND_PASSWORD;
            } else if ("shared_folder_only".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.SHARED_FOLDER_ONLY;
            } else if ("no_one".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.NO_ONE;
            } else if ("only_you".equals(tag)) {
                resolvedVisibility = ResolvedVisibility.ONLY_YOU;
            } else {
                resolvedVisibility = ResolvedVisibility.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return resolvedVisibility;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ResolvedVisibility$1 */
    static /* synthetic */ class C42941 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility;

        static {
            int[] iArr = new int[ResolvedVisibility.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility = iArr;
            try {
                iArr[ResolvedVisibility.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.TEAM_AND_PASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.SHARED_FOLDER_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.NO_ONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ResolvedVisibility[ResolvedVisibility.ONLY_YOU.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
