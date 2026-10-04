package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberStatus {
    ACTIVE,
    INVITED,
    MOVED_TO_ANOTHER_TEAM,
    NOT_JOINED,
    REMOVED,
    SUSPENDED,
    OTHER;

    static class Serializer extends UnionSerializer<MemberStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberStatus memberStatus, JsonGenerator jsonGenerator) throws IOException {
            switch (C44961.$SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[memberStatus.ordinal()]) {
                case 1:
                    jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                    break;
                case 2:
                    jsonGenerator.writeString("invited");
                    break;
                case 3:
                    jsonGenerator.writeString("moved_to_another_team");
                    break;
                case 4:
                    jsonGenerator.writeString("not_joined");
                    break;
                case 5:
                    jsonGenerator.writeString("removed");
                    break;
                case 6:
                    jsonGenerator.writeString("suspended");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberStatus memberStatus;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                memberStatus = MemberStatus.ACTIVE;
            } else if ("invited".equals(tag)) {
                memberStatus = MemberStatus.INVITED;
            } else if ("moved_to_another_team".equals(tag)) {
                memberStatus = MemberStatus.MOVED_TO_ANOTHER_TEAM;
            } else if ("not_joined".equals(tag)) {
                memberStatus = MemberStatus.NOT_JOINED;
            } else if ("removed".equals(tag)) {
                memberStatus = MemberStatus.REMOVED;
            } else if ("suspended".equals(tag)) {
                memberStatus = MemberStatus.SUSPENDED;
            } else {
                memberStatus = MemberStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberStatus;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MemberStatus$1 */
    static /* synthetic */ class C44961 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus;

        static {
            int[] iArr = new int[MemberStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus = iArr;
            try {
                iArr[MemberStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[MemberStatus.INVITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[MemberStatus.MOVED_TO_ANOTHER_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[MemberStatus.NOT_JOINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[MemberStatus.REMOVED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberStatus[MemberStatus.SUSPENDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
