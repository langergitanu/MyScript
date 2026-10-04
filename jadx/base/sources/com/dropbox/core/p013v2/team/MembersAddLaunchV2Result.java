package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.MemberAddV2Result;
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
public final class MembersAddLaunchV2Result {
    public static final MembersAddLaunchV2Result OTHER = new MembersAddLaunchV2Result().withTag(Tag.OTHER);
    private Tag _tag;
    private String asyncJobIdValue;
    private List<MemberAddV2Result> completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE,
        OTHER
    }

    private MembersAddLaunchV2Result() {
    }

    private MembersAddLaunchV2Result withTag(Tag tag) {
        MembersAddLaunchV2Result membersAddLaunchV2Result = new MembersAddLaunchV2Result();
        membersAddLaunchV2Result._tag = tag;
        return membersAddLaunchV2Result;
    }

    private MembersAddLaunchV2Result withTagAndAsyncJobId(Tag tag, String str) {
        MembersAddLaunchV2Result membersAddLaunchV2Result = new MembersAddLaunchV2Result();
        membersAddLaunchV2Result._tag = tag;
        membersAddLaunchV2Result.asyncJobIdValue = str;
        return membersAddLaunchV2Result;
    }

    private MembersAddLaunchV2Result withTagAndComplete(Tag tag, List<MemberAddV2Result> list) {
        MembersAddLaunchV2Result membersAddLaunchV2Result = new MembersAddLaunchV2Result();
        membersAddLaunchV2Result._tag = tag;
        membersAddLaunchV2Result.completeValue = list;
        return membersAddLaunchV2Result;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static MembersAddLaunchV2Result asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MembersAddLaunchV2Result().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static MembersAddLaunchV2Result complete(List<MemberAddV2Result> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<MemberAddV2Result> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddLaunchV2Result().withTagAndComplete(Tag.COMPLETE, list);
    }

    public List<MemberAddV2Result> getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue, this.completeValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersAddLaunchV2Result)) {
            return false;
        }
        MembersAddLaunchV2Result membersAddLaunchV2Result = (MembersAddLaunchV2Result) obj;
        if (this._tag != membersAddLaunchV2Result._tag) {
            return false;
        }
        int i = C43701.$SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = membersAddLaunchV2Result.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return i == 3;
        }
        List<MemberAddV2Result> list = this.completeValue;
        List<MemberAddV2Result> list2 = membersAddLaunchV2Result.completeValue;
        return list == list2 || list.equals(list2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersAddLaunchV2Result$1 */
    static /* synthetic */ class C43701 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<MembersAddLaunchV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersAddLaunchV2Result membersAddLaunchV2Result, JsonGenerator jsonGenerator) throws IOException {
            int i = C43701.$SwitchMap$com$dropbox$core$v2$team$MembersAddLaunchV2Result$Tag[membersAddLaunchV2Result.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(membersAddLaunchV2Result.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                jsonGenerator.writeFieldName("complete");
                StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).serialize(membersAddLaunchV2Result.completeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersAddLaunchV2Result deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersAddLaunchV2Result membersAddLaunchV2ResultComplete;
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
                membersAddLaunchV2ResultComplete = MembersAddLaunchV2Result.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                expectField("complete", jsonParser);
                membersAddLaunchV2ResultComplete = MembersAddLaunchV2Result.complete((List) StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).deserialize(jsonParser));
            } else {
                membersAddLaunchV2ResultComplete = MembersAddLaunchV2Result.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersAddLaunchV2ResultComplete;
        }
    }
}
