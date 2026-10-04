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
public final class MembersAddJobStatus {
    public static final MembersAddJobStatus IN_PROGRESS = new MembersAddJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private List<MemberAddResult> completeValue;
    private String failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private MembersAddJobStatus() {
    }

    private MembersAddJobStatus withTag(Tag tag) {
        MembersAddJobStatus membersAddJobStatus = new MembersAddJobStatus();
        membersAddJobStatus._tag = tag;
        return membersAddJobStatus;
    }

    private MembersAddJobStatus withTagAndComplete(Tag tag, List<MemberAddResult> list) {
        MembersAddJobStatus membersAddJobStatus = new MembersAddJobStatus();
        membersAddJobStatus._tag = tag;
        membersAddJobStatus.completeValue = list;
        return membersAddJobStatus;
    }

    private MembersAddJobStatus withTagAndFailed(Tag tag, String str) {
        MembersAddJobStatus membersAddJobStatus = new MembersAddJobStatus();
        membersAddJobStatus._tag = tag;
        membersAddJobStatus.failedValue = str;
        return membersAddJobStatus;
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

    public static MembersAddJobStatus complete(List<MemberAddResult> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        Iterator<MemberAddResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new MembersAddJobStatus().withTagAndComplete(Tag.COMPLETE, list);
    }

    public List<MemberAddResult> getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static MembersAddJobStatus failed(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersAddJobStatus().withTagAndFailed(Tag.FAILED, str);
    }

    public String getFailedValue() {
        if (this._tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + this._tag.name());
        }
        return this.failedValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.completeValue, this.failedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersAddJobStatus)) {
            return false;
        }
        MembersAddJobStatus membersAddJobStatus = (MembersAddJobStatus) obj;
        if (this._tag != membersAddJobStatus._tag) {
            return false;
        }
        int i = C43671.$SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                String str = this.failedValue;
                String str2 = membersAddJobStatus.failedValue;
                return str == str2 || str.equals(str2);
            }
            List<MemberAddResult> list = this.completeValue;
            List<MemberAddResult> list2 = membersAddJobStatus.completeValue;
            if (list != list2 && !list.equals(list2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersAddJobStatus$1 */
    static /* synthetic */ class C43671 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<MembersAddJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersAddJobStatus membersAddJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C43671.$SwitchMap$com$dropbox$core$v2$team$MembersAddJobStatus$Tag[membersAddJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                jsonGenerator.writeFieldName("complete");
                StoneSerializers.list(MemberAddResult.Serializer.INSTANCE).serialize(membersAddJobStatus.completeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                StoneSerializers.string().serialize(membersAddJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + membersAddJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersAddJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersAddJobStatus membersAddJobStatusFailed;
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
                membersAddJobStatusFailed = MembersAddJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                expectField("complete", jsonParser);
                membersAddJobStatusFailed = MembersAddJobStatus.complete((List) StoneSerializers.list(MemberAddResult.Serializer.INSTANCE).deserialize(jsonParser));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                membersAddJobStatusFailed = MembersAddJobStatus.failed(StoneSerializers.string().deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersAddJobStatusFailed;
        }
    }
}
