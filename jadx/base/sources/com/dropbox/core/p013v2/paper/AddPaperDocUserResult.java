package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum AddPaperDocUserResult {
    SUCCESS,
    UNKNOWN_ERROR,
    SHARING_OUTSIDE_TEAM_DISABLED,
    DAILY_LIMIT_REACHED,
    USER_IS_OWNER,
    FAILED_USER_DATA_RETRIEVAL,
    PERMISSION_ALREADY_GRANTED,
    OTHER;

    static class Serializer extends UnionSerializer<AddPaperDocUserResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddPaperDocUserResult addPaperDocUserResult, JsonGenerator jsonGenerator) throws IOException {
            switch (C42261.$SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[addPaperDocUserResult.ordinal()]) {
                case 1:
                    jsonGenerator.writeString(FirebaseAnalytics.Param.SUCCESS);
                    break;
                case 2:
                    jsonGenerator.writeString("unknown_error");
                    break;
                case 3:
                    jsonGenerator.writeString("sharing_outside_team_disabled");
                    break;
                case 4:
                    jsonGenerator.writeString("daily_limit_reached");
                    break;
                case 5:
                    jsonGenerator.writeString("user_is_owner");
                    break;
                case 6:
                    jsonGenerator.writeString("failed_user_data_retrieval");
                    break;
                case 7:
                    jsonGenerator.writeString("permission_already_granted");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddPaperDocUserResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddPaperDocUserResult addPaperDocUserResult;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.SUCCESS;
            } else if ("unknown_error".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.UNKNOWN_ERROR;
            } else if ("sharing_outside_team_disabled".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.SHARING_OUTSIDE_TEAM_DISABLED;
            } else if ("daily_limit_reached".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.DAILY_LIMIT_REACHED;
            } else if ("user_is_owner".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.USER_IS_OWNER;
            } else if ("failed_user_data_retrieval".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.FAILED_USER_DATA_RETRIEVAL;
            } else if ("permission_already_granted".equals(tag)) {
                addPaperDocUserResult = AddPaperDocUserResult.PERMISSION_ALREADY_GRANTED;
            } else {
                addPaperDocUserResult = AddPaperDocUserResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addPaperDocUserResult;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.AddPaperDocUserResult$1 */
    static /* synthetic */ class C42261 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult;

        static {
            int[] iArr = new int[AddPaperDocUserResult.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult = iArr;
            try {
                iArr[AddPaperDocUserResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.UNKNOWN_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.SHARING_OUTSIDE_TEAM_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.DAILY_LIMIT_REACHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.USER_IS_OWNER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.FAILED_USER_DATA_RETRIEVAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$AddPaperDocUserResult[AddPaperDocUserResult.PERMISSION_ALREADY_GRANTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
