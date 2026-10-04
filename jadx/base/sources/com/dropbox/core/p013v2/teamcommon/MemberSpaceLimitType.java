package com.dropbox.core.p013v2.teamcommon;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberSpaceLimitType {
    OFF,
    ALERT_ONLY,
    STOP_SYNC,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamcommon.MemberSpaceLimitType$1 */
    static /* synthetic */ class C44271 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamcommon$MemberSpaceLimitType;

        static {
            int[] iArr = new int[MemberSpaceLimitType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamcommon$MemberSpaceLimitType = iArr;
            try {
                iArr[MemberSpaceLimitType.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamcommon$MemberSpaceLimitType[MemberSpaceLimitType.ALERT_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamcommon$MemberSpaceLimitType[MemberSpaceLimitType.STOP_SYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<MemberSpaceLimitType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberSpaceLimitType memberSpaceLimitType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44271.$SwitchMap$com$dropbox$core$v2$teamcommon$MemberSpaceLimitType[memberSpaceLimitType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("alert_only");
            } else if (i == 3) {
                jsonGenerator.writeString("stop_sync");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberSpaceLimitType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberSpaceLimitType memberSpaceLimitType;
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
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(tag)) {
                memberSpaceLimitType = MemberSpaceLimitType.OFF;
            } else if ("alert_only".equals(tag)) {
                memberSpaceLimitType = MemberSpaceLimitType.ALERT_ONLY;
            } else if ("stop_sync".equals(tag)) {
                memberSpaceLimitType = MemberSpaceLimitType.STOP_SYNC;
            } else {
                memberSpaceLimitType = MemberSpaceLimitType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberSpaceLimitType;
        }
    }
}
