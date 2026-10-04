package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.GroupLogInfo;
import com.dropbox.core.p013v2.teamlog.UserLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class ParticipantLogInfo {
    public static final ParticipantLogInfo OTHER = new ParticipantLogInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private GroupLogInfo groupValue;
    private UserLogInfo userValue;

    public enum Tag {
        GROUP,
        USER,
        OTHER
    }

    private ParticipantLogInfo() {
    }

    private ParticipantLogInfo withTag(Tag tag) {
        ParticipantLogInfo participantLogInfo = new ParticipantLogInfo();
        participantLogInfo._tag = tag;
        return participantLogInfo;
    }

    private ParticipantLogInfo withTagAndGroup(Tag tag, GroupLogInfo groupLogInfo) {
        ParticipantLogInfo participantLogInfo = new ParticipantLogInfo();
        participantLogInfo._tag = tag;
        participantLogInfo.groupValue = groupLogInfo;
        return participantLogInfo;
    }

    private ParticipantLogInfo withTagAndUser(Tag tag, UserLogInfo userLogInfo) {
        ParticipantLogInfo participantLogInfo = new ParticipantLogInfo();
        participantLogInfo._tag = tag;
        participantLogInfo.userValue = userLogInfo;
        return participantLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isGroup() {
        return this._tag == Tag.GROUP;
    }

    public static ParticipantLogInfo group(GroupLogInfo groupLogInfo) {
        if (groupLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ParticipantLogInfo().withTagAndGroup(Tag.GROUP, groupLogInfo);
    }

    public GroupLogInfo getGroupValue() {
        if (this._tag != Tag.GROUP) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP, but was Tag." + this._tag.name());
        }
        return this.groupValue;
    }

    public boolean isUser() {
        return this._tag == Tag.USER;
    }

    public static ParticipantLogInfo user(UserLogInfo userLogInfo) {
        if (userLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ParticipantLogInfo().withTagAndUser(Tag.USER, userLogInfo);
    }

    public UserLogInfo getUserValue() {
        if (this._tag != Tag.USER) {
            throw new IllegalStateException("Invalid tag: required Tag.USER, but was Tag." + this._tag.name());
        }
        return this.userValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.groupValue, this.userValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ParticipantLogInfo)) {
            return false;
        }
        ParticipantLogInfo participantLogInfo = (ParticipantLogInfo) obj;
        if (this._tag != participantLogInfo._tag) {
            return false;
        }
        int i = C45051.$SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag[this._tag.ordinal()];
        if (i == 1) {
            GroupLogInfo groupLogInfo = this.groupValue;
            GroupLogInfo groupLogInfo2 = participantLogInfo.groupValue;
            return groupLogInfo == groupLogInfo2 || groupLogInfo.equals(groupLogInfo2);
        }
        if (i != 2) {
            return i == 3;
        }
        UserLogInfo userLogInfo = this.userValue;
        UserLogInfo userLogInfo2 = participantLogInfo.userValue;
        return userLogInfo == userLogInfo2 || userLogInfo.equals(userLogInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ParticipantLogInfo$1 */
    static /* synthetic */ class C45051 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag = iArr;
            try {
                iArr[Tag.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag[Tag.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ParticipantLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ParticipantLogInfo participantLogInfo, JsonGenerator jsonGenerator) throws IOException {
            int i = C45051.$SwitchMap$com$dropbox$core$v2$teamlog$ParticipantLogInfo$Tag[participantLogInfo.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("group", jsonGenerator);
                GroupLogInfo.Serializer.INSTANCE.serialize(participantLogInfo.groupValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("user", jsonGenerator);
                jsonGenerator.writeFieldName("user");
                UserLogInfo.Serializer.INSTANCE.serialize(participantLogInfo.userValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ParticipantLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ParticipantLogInfo participantLogInfoUser;
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
            if ("group".equals(tag)) {
                participantLogInfoUser = ParticipantLogInfo.group(GroupLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("user".equals(tag)) {
                expectField("user", jsonParser);
                participantLogInfoUser = ParticipantLogInfo.user(UserLogInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                participantLogInfoUser = ParticipantLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return participantLogInfoUser;
        }
    }
}
