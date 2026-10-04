package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SpaceLimitsStatus {
    NEAR_QUOTA,
    OVER_QUOTA,
    WITHIN_QUOTA,
    OTHER;

    static class Serializer extends UnionSerializer<SpaceLimitsStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SpaceLimitsStatus spaceLimitsStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C45251.$SwitchMap$com$dropbox$core$v2$teamlog$SpaceLimitsStatus[spaceLimitsStatus.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("near_quota");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("over_quota");
            } else if (i == 3) {
                jsonGenerator.writeString("within_quota");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SpaceLimitsStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SpaceLimitsStatus spaceLimitsStatus;
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
            if ("near_quota".equals(tag)) {
                spaceLimitsStatus = SpaceLimitsStatus.NEAR_QUOTA;
            } else if ("over_quota".equals(tag)) {
                spaceLimitsStatus = SpaceLimitsStatus.OVER_QUOTA;
            } else if ("within_quota".equals(tag)) {
                spaceLimitsStatus = SpaceLimitsStatus.WITHIN_QUOTA;
            } else {
                spaceLimitsStatus = SpaceLimitsStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return spaceLimitsStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SpaceLimitsStatus$1 */
    static /* synthetic */ class C45251 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SpaceLimitsStatus;

        static {
            int[] iArr = new int[SpaceLimitsStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SpaceLimitsStatus = iArr;
            try {
                iArr[SpaceLimitsStatus.NEAR_QUOTA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SpaceLimitsStatus[SpaceLimitsStatus.OVER_QUOTA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SpaceLimitsStatus[SpaceLimitsStatus.WITHIN_QUOTA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
