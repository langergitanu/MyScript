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
public final class MembersAddJobStatusV2Result {
    public static final MembersAddJobStatusV2Result IN_PROGRESS = new MembersAddJobStatusV2Result().withTag(Tag.IN_PROGRESS);
    public static final MembersAddJobStatusV2Result OTHER = new MembersAddJobStatusV2Result().withTag(Tag.OTHER);
    private Tag _tag;
    private List<MemberAddV2Result> completeValue;
    private String failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED,
        OTHER
    }

    private MembersAddJobStatusV2Result() {
    }

    private MembersAddJobStatusV2Result withTag(Tag tag) {
        MembersAddJobStatusV2Result membersAddJobStatusV2Result = new MembersAddJobStatusV2Result();
        membersAddJobStatusV2Result._tag = tag;
        return membersAddJobStatusV2Result;
    }

    private MembersAddJobStatusV2Result withTagAndComplete(Tag tag, List<MemberAddV2Result> list) {
        MembersAddJobStatusV2Result membersAddJobStatusV2Result = new MembersAddJobStatusV2Result();
        membersAddJobStatusV2Result._tag = tag;
        membersAddJobStatusV2Result.completeValue = list;
        return membersAddJobStatusV2Result;
    }

    private MembersAddJobStatusV2Result withTagAndFailed(Tag tag, String str) {
        MembersAddJobStatusV2Result membersAddJobStatusV2Result = new MembersAddJobStatusV2Result();
        membersAddJobStatusV2Result._tag = tag;
        membersAddJobStatusV2Result.failedValue = str;
        return membersAddJobStatusV2Result;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInProgress() {
        return this._tag == Tag.IN_PROGRESS;
    }

    public boolean isComplete() {
        return this._tag == Tag.COMPLETE;
    }

    public static MembersAddJobStatusV2Result complete(List<MemberAddV2Result> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<MemberAddV2Result> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddJobStatusV2Result().withTagAndComplete(Tag.COMPLETE, list);
    }

    public List<MemberAddV2Result> getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static MembersAddJobStatusV2Result failed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersAddJobStatusV2Result().withTagAndFailed(Tag.FAILED, str);
    }

    public String getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersAddJobStatusV2Result)) {
            return false;
        }
        MembersAddJobStatusV2Result membersAddJobStatusV2Result = (MembersAddJobStatusV2Result) obj;
        if (this._tag != membersAddJobStatusV2Result._tag) {
            return false;
        }
        int i = C43681.f759x30b2d5dd[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i == 4;
                }
                String str = this.failedValue;
                String str2 = membersAddJobStatusV2Result.failedValue;
                return str == str2 || str.equals(str2);
            }
            List<MemberAddV2Result> list = this.completeValue;
            List<MemberAddV2Result> list2 = membersAddJobStatusV2Result.completeValue;
            if (list != list2 && !list.equals(list2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersAddJobStatusV2Result$1 */
    static /* synthetic */ class C43681 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatusV2Result$Tag */
        static final /* synthetic */ int[] f759x30b2d5dd;

        static {
            int[] iArr = new int[Tag.values().length];
            f759x30b2d5dd = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f759x30b2d5dd[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f759x30b2d5dd[Tag.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f759x30b2d5dd[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MembersAddJobStatusV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersAddJobStatusV2Result membersAddJobStatusV2Result, JsonGenerator jsonGenerator) throws IOException {
            int i = C43681.f759x30b2d5dd[membersAddJobStatusV2Result.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                jsonGenerator.writeFieldName("complete");
                StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).serialize(membersAddJobStatusV2Result.completeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                StoneSerializers.string().serialize(membersAddJobStatusV2Result.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersAddJobStatusV2Result deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersAddJobStatusV2Result membersAddJobStatusV2ResultFailed;
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
            if ("in_progress".equals(tag)) {
                membersAddJobStatusV2ResultFailed = MembersAddJobStatusV2Result.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                expectField("complete", jsonParser);
                membersAddJobStatusV2ResultFailed = MembersAddJobStatusV2Result.complete((List) StoneSerializers.list(MemberAddV2Result.Serializer.INSTANCE).deserialize(jsonParser));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                membersAddJobStatusV2ResultFailed = MembersAddJobStatusV2Result.failed(StoneSerializers.string().deserialize(jsonParser));
            } else {
                membersAddJobStatusV2ResultFailed = MembersAddJobStatusV2Result.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersAddJobStatusV2ResultFailed;
        }
    }
}
