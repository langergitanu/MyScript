package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.p013v2.sharing.RemoveFolderMemberError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoveMemberJobStatus {
    public static final RemoveMemberJobStatus IN_PROGRESS = new RemoveMemberJobStatus().withTag(Tag.IN_PROGRESS);
    private Tag _tag;
    private MemberAccessLevelResult completeValue;
    private RemoveFolderMemberError failedValue;

    public enum Tag {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private RemoveMemberJobStatus() {
    }

    private RemoveMemberJobStatus withTag(Tag tag) {
        RemoveMemberJobStatus removeMemberJobStatus = new RemoveMemberJobStatus();
        removeMemberJobStatus._tag = tag;
        return removeMemberJobStatus;
    }

    private RemoveMemberJobStatus withTagAndComplete(Tag tag, MemberAccessLevelResult memberAccessLevelResult) {
        RemoveMemberJobStatus removeMemberJobStatus = new RemoveMemberJobStatus();
        removeMemberJobStatus._tag = tag;
        removeMemberJobStatus.completeValue = memberAccessLevelResult;
        return removeMemberJobStatus;
    }

    private RemoveMemberJobStatus withTagAndFailed(Tag tag, RemoveFolderMemberError removeFolderMemberError) {
        RemoveMemberJobStatus removeMemberJobStatus = new RemoveMemberJobStatus();
        removeMemberJobStatus._tag = tag;
        removeMemberJobStatus.failedValue = removeFolderMemberError;
        return removeMemberJobStatus;
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

    public static RemoveMemberJobStatus complete(MemberAccessLevelResult memberAccessLevelResult) {
        if (memberAccessLevelResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveMemberJobStatus().withTagAndComplete(Tag.COMPLETE, memberAccessLevelResult);
    }

    public MemberAccessLevelResult getCompleteValue() {
        if (this._tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + this._tag.name());
        }
        return this.completeValue;
    }

    public boolean isFailed() {
        return this._tag == Tag.FAILED;
    }

    public static RemoveMemberJobStatus failed(RemoveFolderMemberError removeFolderMemberError) {
        if (removeFolderMemberError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveMemberJobStatus().withTagAndFailed(Tag.FAILED, removeFolderMemberError);
    }

    public RemoveFolderMemberError getFailedValue() {
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
        if (obj == null || !(obj instanceof RemoveMemberJobStatus)) {
            return false;
        }
        RemoveMemberJobStatus removeMemberJobStatus = (RemoveMemberJobStatus) obj;
        if (this._tag != removeMemberJobStatus._tag) {
            return false;
        }
        int i = C42911.$SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                RemoveFolderMemberError removeFolderMemberError = this.failedValue;
                RemoveFolderMemberError removeFolderMemberError2 = removeMemberJobStatus.failedValue;
                return removeFolderMemberError == removeFolderMemberError2 || removeFolderMemberError.equals(removeFolderMemberError2);
            }
            MemberAccessLevelResult memberAccessLevelResult = this.completeValue;
            MemberAccessLevelResult memberAccessLevelResult2 = removeMemberJobStatus.completeValue;
            if (memberAccessLevelResult != memberAccessLevelResult2 && !memberAccessLevelResult.equals(memberAccessLevelResult2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RemoveMemberJobStatus$1 */
    static /* synthetic */ class C42911 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag = iArr;
            try {
                iArr[Tag.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag[Tag.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag[Tag.FAILED.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RemoveMemberJobStatus> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemoveMemberJobStatus removeMemberJobStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C42911.$SwitchMap$com$dropbox$core$v2$sharing$RemoveMemberJobStatus$Tag[removeMemberJobStatus.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                MemberAccessLevelResult.Serializer.INSTANCE.serialize(removeMemberJobStatus.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("failed", jsonGenerator);
                jsonGenerator.writeFieldName("failed");
                RemoveFolderMemberError.Serializer.INSTANCE.serialize(removeMemberJobStatus.failedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + removeMemberJobStatus.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemoveMemberJobStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemoveMemberJobStatus removeMemberJobStatusFailed;
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
                removeMemberJobStatusFailed = RemoveMemberJobStatus.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                removeMemberJobStatusFailed = RemoveMemberJobStatus.complete(MemberAccessLevelResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failed".equals(tag)) {
                expectField("failed", jsonParser);
                removeMemberJobStatusFailed = RemoveMemberJobStatus.failed(RemoveFolderMemberError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removeMemberJobStatusFailed;
        }
    }
}
