package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFolderMetadata;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ShareFolderLaunch {
    private Tag _tag;
    private String asyncJobIdValue;
    private SharedFolderMetadata completeValue;

    public enum Tag {
        ASYNC_JOB_ID,
        COMPLETE
    }

    private ShareFolderLaunch() {
    }

    private ShareFolderLaunch withTag(Tag tag) {
        ShareFolderLaunch shareFolderLaunch = new ShareFolderLaunch();
        shareFolderLaunch._tag = tag;
        return shareFolderLaunch;
    }

    private ShareFolderLaunch withTagAndAsyncJobId(Tag tag, String str) {
        ShareFolderLaunch shareFolderLaunch = new ShareFolderLaunch();
        shareFolderLaunch._tag = tag;
        shareFolderLaunch.asyncJobIdValue = str;
        return shareFolderLaunch;
    }

    private ShareFolderLaunch withTagAndComplete(Tag tag, SharedFolderMetadata sharedFolderMetadata) {
        ShareFolderLaunch shareFolderLaunch = new ShareFolderLaunch();
        shareFolderLaunch._tag = tag;
        shareFolderLaunch.completeValue = sharedFolderMetadata;
        return shareFolderLaunch;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static ShareFolderLaunch asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new ShareFolderLaunch().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
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

    public static ShareFolderLaunch complete(SharedFolderMetadata sharedFolderMetadata) {
        if (sharedFolderMetadata == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderLaunch().withTagAndComplete(Tag.COMPLETE, sharedFolderMetadata);
    }

    public SharedFolderMetadata getCompleteValue() {
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
        if (obj == null || !(obj instanceof ShareFolderLaunch)) {
            return false;
        }
        ShareFolderLaunch shareFolderLaunch = (ShareFolderLaunch) obj;
        if (this._tag != shareFolderLaunch._tag) {
            return false;
        }
        int i = C42991.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderLaunch$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.asyncJobIdValue;
            String str2 = shareFolderLaunch.asyncJobIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i != 2) {
            return false;
        }
        SharedFolderMetadata sharedFolderMetadata = this.completeValue;
        SharedFolderMetadata sharedFolderMetadata2 = shareFolderLaunch.completeValue;
        return sharedFolderMetadata == sharedFolderMetadata2 || sharedFolderMetadata.equals(sharedFolderMetadata2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ShareFolderLaunch$1 */
    static /* synthetic */ class C42991 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderLaunch$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderLaunch$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$ShareFolderLaunch$Tag[Tag.COMPLETE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<ShareFolderLaunch> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ShareFolderLaunch shareFolderLaunch, JsonGenerator jsonGenerator) throws IOException {
            int i = C42991.$SwitchMap$com$dropbox$core$v2$sharing$ShareFolderLaunch$Tag[shareFolderLaunch.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(shareFolderLaunch.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("complete", jsonGenerator);
                SharedFolderMetadata.Serializer.INSTANCE.serialize(shareFolderLaunch.completeValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + shareFolderLaunch.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ShareFolderLaunch deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ShareFolderLaunch shareFolderLaunchComplete;
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
                shareFolderLaunchComplete = ShareFolderLaunch.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("complete".equals(tag)) {
                shareFolderLaunchComplete = ShareFolderLaunch.complete(SharedFolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return shareFolderLaunchComplete;
        }
    }
}
