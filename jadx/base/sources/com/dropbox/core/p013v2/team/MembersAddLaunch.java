package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberAddResult;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class MembersAddLaunch {
    private Tag _tag;
    private String asyncJobIdValue;
    private List<MemberAddResult> completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private MembersAddLaunch() {
    }

    private MembersAddLaunch withTag(Tag tag) {
        MembersAddLaunch membersAddLaunch = new MembersAddLaunch();
        membersAddLaunch._tag = tag;
        return membersAddLaunch;
    }

    private MembersAddLaunch withTagAndAsyncJobId(Tag tag, String str) {
        MembersAddLaunch membersAddLaunch = new MembersAddLaunch();
        membersAddLaunch._tag = tag;
        membersAddLaunch.asyncJobIdValue = str;
        return membersAddLaunch;
    }

    private MembersAddLaunch withTagAndComplete(Tag tag, List<MemberAddResult> list) {
        MembersAddLaunch membersAddLaunch = new MembersAddLaunch();
        membersAddLaunch._tag = tag;
        membersAddLaunch.completeValue = list;
        return membersAddLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static MembersAddLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MembersAddLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
    }

    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
        }
        return this.asyncJobIdValue;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static MembersAddLaunch complete(List<MemberAddResult> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<MemberAddResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddLaunch().withTagAndComplete(Tag.COMPLETE, list);
    }

    public List<MemberAddResult> getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersAddLaunch)) {
            return false;
        }
        MembersAddLaunch membersAddLaunch = (MembersAddLaunch) obj;
        if (this._tag != membersAddLaunch._tag) {
            return false;
        }
        int i = C43691.$SwitchMap$com$dropbox$core$v2$team$MembersAddLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = membersAddLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        List<MemberAddResult> list = this.completeValue;
        List<MemberAddResult> list2 = membersAddLaunch.completeValue;
        return list == list2 || list.equals(list2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersAddLaunch$1 */
    static /* synthetic */ class C43691 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MembersAddLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersAddLaunch membersAddLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C43691.$SwitchMap$com$dropbox$core$v2$team$MembersAddLaunch$Tag[membersAddLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(membersAddLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                jsonGenerator.writeFieldName("complete");
                StoneSerializers.list(MemberAddResult.Serializer.INSTANCE).serialize(membersAddLaunch.completeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + membersAddLaunch.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersAddLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersAddLaunch membersAddLaunchComplete;
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
            if ("async_job_id".equals(tag)) {
                expectField("async_job_id", jsonParser);
                membersAddLaunchComplete = MembersAddLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                expectField("complete", jsonParser);
                membersAddLaunchComplete = MembersAddLaunch.complete((List) StoneSerializers.list(MemberAddResult.Serializer.INSTANCE).deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersAddLaunchComplete;
        }
    }
}
