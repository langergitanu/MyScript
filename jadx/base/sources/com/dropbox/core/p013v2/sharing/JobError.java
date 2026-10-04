package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.RelinquishFolderMembershipError;
import com.dropbox.core.p013v2.sharing.RemoveFolderMemberError;
import com.dropbox.core.p013v2.sharing.UnshareFolderError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class JobError {
    public static final JobError OTHER = new JobError().withTag(Tag.OTHER);
    private Tag _tag;
    private RelinquishFolderMembershipError relinquishFolderMembershipErrorValue;
    private RemoveFolderMemberError removeFolderMemberErrorValue;
    private UnshareFolderError unshareFolderErrorValue;

    public enum Tag {
        UNSHARE_FOLDER_ERROR,
        REMOVE_FOLDER_MEMBER_ERROR,
        RELINQUISH_FOLDER_MEMBERSHIP_ERROR,
        OTHER
    }

    private JobError() {
    }

    private JobError withTag(Tag tag) {
        JobError jobError = new JobError();
        jobError._tag = tag;
        return jobError;
    }

    private JobError withTagAndUnshareFolderError(Tag tag, UnshareFolderError unshareFolderError) {
        JobError jobError = new JobError();
        jobError._tag = tag;
        jobError.unshareFolderErrorValue = unshareFolderError;
        return jobError;
    }

    private JobError withTagAndRemoveFolderMemberError(Tag tag, RemoveFolderMemberError removeFolderMemberError) {
        JobError jobError = new JobError();
        jobError._tag = tag;
        jobError.removeFolderMemberErrorValue = removeFolderMemberError;
        return jobError;
    }

    private JobError withTagAndRelinquishFolderMembershipError(Tag tag, RelinquishFolderMembershipError relinquishFolderMembershipError) {
        JobError jobError = new JobError();
        jobError._tag = tag;
        jobError.relinquishFolderMembershipErrorValue = relinquishFolderMembershipError;
        return jobError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUnshareFolderError() {
        return this._tag == Tag.UNSHARE_FOLDER_ERROR;
    }

    public static JobError unshareFolderError(UnshareFolderError unshareFolderError) {
        if (unshareFolderError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndUnshareFolderError(Tag.UNSHARE_FOLDER_ERROR, unshareFolderError);
    }

    public UnshareFolderError getUnshareFolderErrorValue() {
        if (this._tag != Tag.UNSHARE_FOLDER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.UNSHARE_FOLDER_ERROR, but was Tag." + this._tag.name());
        }
        return this.unshareFolderErrorValue;
    }

    public boolean isRemoveFolderMemberError() {
        return this._tag == Tag.REMOVE_FOLDER_MEMBER_ERROR;
    }

    public static JobError removeFolderMemberError(RemoveFolderMemberError removeFolderMemberError) {
        if (removeFolderMemberError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndRemoveFolderMemberError(Tag.REMOVE_FOLDER_MEMBER_ERROR, removeFolderMemberError);
    }

    public RemoveFolderMemberError getRemoveFolderMemberErrorValue() {
        if (this._tag != Tag.REMOVE_FOLDER_MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.REMOVE_FOLDER_MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return this.removeFolderMemberErrorValue;
    }

    public boolean isRelinquishFolderMembershipError() {
        return this._tag == Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR;
    }

    public static JobError relinquishFolderMembershipError(RelinquishFolderMembershipError relinquishFolderMembershipError) {
        if (relinquishFolderMembershipError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new JobError().withTagAndRelinquishFolderMembershipError(Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR, relinquishFolderMembershipError);
    }

    public RelinquishFolderMembershipError getRelinquishFolderMembershipErrorValue() {
        if (this._tag != Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR, but was Tag." + this._tag.name());
        }
        return this.relinquishFolderMembershipErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.unshareFolderErrorValue, this.removeFolderMemberErrorValue, this.relinquishFolderMembershipErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JobError)) {
            return false;
        }
        JobError jobError = (JobError) obj;
        if (this._tag != jobError._tag) {
            return false;
        }
        int i = C42651.$SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag[this._tag.ordinal()];
        if (i == 1) {
            UnshareFolderError unshareFolderError = this.unshareFolderErrorValue;
            UnshareFolderError unshareFolderError2 = jobError.unshareFolderErrorValue;
            return unshareFolderError == unshareFolderError2 || unshareFolderError.equals(unshareFolderError2);
        }
        if (i == 2) {
            RemoveFolderMemberError removeFolderMemberError = this.removeFolderMemberErrorValue;
            RemoveFolderMemberError removeFolderMemberError2 = jobError.removeFolderMemberErrorValue;
            return removeFolderMemberError == removeFolderMemberError2 || removeFolderMemberError.equals(removeFolderMemberError2);
        }
        if (i != 3) {
            return i == 4;
        }
        RelinquishFolderMembershipError relinquishFolderMembershipError = this.relinquishFolderMembershipErrorValue;
        RelinquishFolderMembershipError relinquishFolderMembershipError2 = jobError.relinquishFolderMembershipErrorValue;
        return relinquishFolderMembershipError == relinquishFolderMembershipError2 || relinquishFolderMembershipError.equals(relinquishFolderMembershipError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.JobError$1 */
    static /* synthetic */ class C42651 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag = iArr;
            try {
                iArr[Tag.UNSHARE_FOLDER_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag[Tag.REMOVE_FOLDER_MEMBER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag[Tag.RELINQUISH_FOLDER_MEMBERSHIP_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<JobError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(JobError jobError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42651.$SwitchMap$com$dropbox$core$v2$sharing$JobError$Tag[jobError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("unshare_folder_error", jsonGenerator);
                jsonGenerator.writeFieldName("unshare_folder_error");
                UnshareFolderError.Serializer.INSTANCE.serialize(jobError.unshareFolderErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("remove_folder_member_error", jsonGenerator);
                jsonGenerator.writeFieldName("remove_folder_member_error");
                RemoveFolderMemberError.Serializer.INSTANCE.serialize(jobError.removeFolderMemberErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("relinquish_folder_membership_error", jsonGenerator);
                jsonGenerator.writeFieldName("relinquish_folder_membership_error");
                RelinquishFolderMembershipError.Serializer.INSTANCE.serialize(jobError.relinquishFolderMembershipErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public JobError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            JobError jobErrorRelinquishFolderMembershipError;
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
            if ("unshare_folder_error".equals(tag)) {
                expectField("unshare_folder_error", jsonParser);
                jobErrorRelinquishFolderMembershipError = JobError.unshareFolderError(UnshareFolderError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("remove_folder_member_error".equals(tag)) {
                expectField("remove_folder_member_error", jsonParser);
                jobErrorRelinquishFolderMembershipError = JobError.removeFolderMemberError(RemoveFolderMemberError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("relinquish_folder_membership_error".equals(tag)) {
                expectField("relinquish_folder_membership_error", jsonParser);
                jobErrorRelinquishFolderMembershipError = JobError.relinquishFolderMembershipError(RelinquishFolderMembershipError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                jobErrorRelinquishFolderMembershipError = JobError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return jobErrorRelinquishFolderMembershipError;
        }
    }
}
