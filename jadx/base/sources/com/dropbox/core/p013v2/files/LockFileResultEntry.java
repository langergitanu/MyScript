package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LockFileError;
import com.dropbox.core.p013v2.files.LockFileResult;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LockFileResultEntry {
    private Tag _tag;
    private LockFileError failureValue;
    private LockFileResult successValue;

    public enum Tag {
        SUCCESS,
        FAILURE
    }

    private LockFileResultEntry() {
    }

    private LockFileResultEntry withTag(Tag tag) {
        LockFileResultEntry lockFileResultEntry = new LockFileResultEntry();
        lockFileResultEntry._tag = tag;
        return lockFileResultEntry;
    }

    private LockFileResultEntry withTagAndSuccess(Tag tag, LockFileResult lockFileResult) {
        LockFileResultEntry lockFileResultEntry = new LockFileResultEntry();
        lockFileResultEntry._tag = tag;
        lockFileResultEntry.successValue = lockFileResult;
        return lockFileResultEntry;
    }

    private LockFileResultEntry withTagAndFailure(Tag tag, LockFileError lockFileError) {
        LockFileResultEntry lockFileResultEntry = new LockFileResultEntry();
        lockFileResultEntry._tag = tag;
        lockFileResultEntry.failureValue = lockFileError;
        return lockFileResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static LockFileResultEntry success(LockFileResult lockFileResult) {
        if (lockFileResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileResultEntry().withTagAndSuccess(Tag.SUCCESS, lockFileResult);
    }

    public LockFileResult getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static LockFileResultEntry failure(LockFileError lockFileError) {
        if (lockFileError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileResultEntry().withTagAndFailure(Tag.FAILURE, lockFileError);
    }

    public LockFileError getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return this.failureValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.failureValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LockFileResultEntry)) {
            return false;
        }
        LockFileResultEntry lockFileResultEntry = (LockFileResultEntry) obj;
        if (this._tag != lockFileResultEntry._tag) {
            return false;
        }
        int i = C41731.$SwitchMap$com$dropbox$core$v2$files$LockFileResultEntry$Tag[this._tag.ordinal()];
        if (i == 1) {
            LockFileResult lockFileResult = this.successValue;
            LockFileResult lockFileResult2 = lockFileResultEntry.successValue;
            return lockFileResult == lockFileResult2 || lockFileResult.equals(lockFileResult2);
        }
        if (i != 2) {
            return false;
        }
        LockFileError lockFileError = this.failureValue;
        LockFileError lockFileError2 = lockFileResultEntry.failureValue;
        return lockFileError == lockFileError2 || lockFileError.equals(lockFileError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.LockFileResultEntry$1 */
    static /* synthetic */ class C41731 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$LockFileResultEntry$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$LockFileResultEntry$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$LockFileResultEntry$Tag[Tag.FAILURE.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<LockFileResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LockFileResultEntry lockFileResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41731.$SwitchMap$com$dropbox$core$v2$files$LockFileResultEntry$Tag[lockFileResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                LockFileResult.Serializer.INSTANCE.serialize(lockFileResultEntry.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                LockFileError.Serializer.INSTANCE.serialize(lockFileResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + lockFileResultEntry.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LockFileResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LockFileResultEntry lockFileResultEntryFailure;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                lockFileResultEntryFailure = LockFileResultEntry.success(LockFileResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                lockFileResultEntryFailure = LockFileResultEntry.failure(LockFileError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return lockFileResultEntryFailure;
        }
    }
}
