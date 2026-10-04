package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExcludedUsersUpdateStatus {
    SUCCESS,
    OTHER;

    static class Serializer extends UnionSerializer<ExcludedUsersUpdateStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExcludedUsersUpdateStatus excludedUsersUpdateStatus, JsonGenerator jsonGenerator) throws IOException {
            if (C43301.$SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateStatus[excludedUsersUpdateStatus.ordinal()] == 1) {
                jsonGenerator.writeString(FirebaseAnalytics.Param.SUCCESS);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExcludedUsersUpdateStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExcludedUsersUpdateStatus excludedUsersUpdateStatus;
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
                excludedUsersUpdateStatus = ExcludedUsersUpdateStatus.SUCCESS;
            } else {
                excludedUsersUpdateStatus = ExcludedUsersUpdateStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return excludedUsersUpdateStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ExcludedUsersUpdateStatus$1 */
    static /* synthetic */ class C43301 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateStatus;

        static {
            int[] iArr = new int[ExcludedUsersUpdateStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersUpdateStatus = iArr;
            try {
                iArr[ExcludedUsersUpdateStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
