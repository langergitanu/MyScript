package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.users.FileLockingValue;
import com.dropbox.core.p013v2.users.PaperAsFilesValue;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class UserFeatureValue {
    public static final UserFeatureValue OTHER = new UserFeatureValue().withTag(Tag.OTHER);
    private Tag _tag;
    private FileLockingValue fileLockingValue;
    private PaperAsFilesValue paperAsFilesValue;

    public enum Tag {
        PAPER_AS_FILES,
        FILE_LOCKING,
        OTHER
    }

    private UserFeatureValue() {
    }

    private UserFeatureValue withTag(Tag tag) {
        UserFeatureValue userFeatureValue = new UserFeatureValue();
        userFeatureValue._tag = tag;
        return userFeatureValue;
    }

    private UserFeatureValue withTagAndPaperAsFiles(Tag tag, PaperAsFilesValue paperAsFilesValue) {
        UserFeatureValue userFeatureValue = new UserFeatureValue();
        userFeatureValue._tag = tag;
        userFeatureValue.paperAsFilesValue = paperAsFilesValue;
        return userFeatureValue;
    }

    private UserFeatureValue withTagAndFileLocking(Tag tag, FileLockingValue fileLockingValue) {
        UserFeatureValue userFeatureValue = new UserFeatureValue();
        userFeatureValue._tag = tag;
        userFeatureValue.fileLockingValue = fileLockingValue;
        return userFeatureValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPaperAsFiles() {
        return this._tag == Tag.PAPER_AS_FILES;
    }

    public static UserFeatureValue paperAsFiles(PaperAsFilesValue paperAsFilesValue) {
        if (paperAsFilesValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserFeatureValue().withTagAndPaperAsFiles(Tag.PAPER_AS_FILES, paperAsFilesValue);
    }

    public PaperAsFilesValue getPaperAsFilesValue() {
        if (this._tag != Tag.PAPER_AS_FILES) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_AS_FILES, but was Tag." + this._tag.name());
        }
        return this.paperAsFilesValue;
    }

    public boolean isFileLocking() {
        return this._tag == Tag.FILE_LOCKING;
    }

    public static UserFeatureValue fileLocking(FileLockingValue fileLockingValue) {
        if (fileLockingValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserFeatureValue().withTagAndFileLocking(Tag.FILE_LOCKING, fileLockingValue);
    }

    public FileLockingValue getFileLockingValue() {
        if (this._tag != Tag.FILE_LOCKING) {
            throw new IllegalStateException("Invalid tag: required Tag.FILE_LOCKING, but was Tag." + this._tag.name());
        }
        return this.fileLockingValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.paperAsFilesValue, this.fileLockingValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UserFeatureValue)) {
            return false;
        }
        UserFeatureValue userFeatureValue = (UserFeatureValue) obj;
        if (this._tag != userFeatureValue._tag) {
            return false;
        }
        int i = C45671.$SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag[this._tag.ordinal()];
        if (i == 1) {
            PaperAsFilesValue paperAsFilesValue = this.paperAsFilesValue;
            PaperAsFilesValue paperAsFilesValue2 = userFeatureValue.paperAsFilesValue;
            return paperAsFilesValue == paperAsFilesValue2 || paperAsFilesValue.equals(paperAsFilesValue2);
        }
        if (i != 2) {
            return i == 3;
        }
        FileLockingValue fileLockingValue = this.fileLockingValue;
        FileLockingValue fileLockingValue2 = userFeatureValue.fileLockingValue;
        return fileLockingValue == fileLockingValue2 || fileLockingValue.equals(fileLockingValue2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.UserFeatureValue$1 */
    static /* synthetic */ class C45671 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag = iArr;
            try {
                iArr[Tag.PAPER_AS_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag[Tag.FILE_LOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UserFeatureValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserFeatureValue userFeatureValue, JsonGenerator jsonGenerator) throws IOException {
            int i = C45671.$SwitchMap$com$dropbox$core$v2$users$UserFeatureValue$Tag[userFeatureValue.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("paper_as_files", jsonGenerator);
                jsonGenerator.writeFieldName("paper_as_files");
                PaperAsFilesValue.Serializer.INSTANCE.serialize(userFeatureValue.paperAsFilesValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("file_locking", jsonGenerator);
                jsonGenerator.writeFieldName("file_locking");
                FileLockingValue.Serializer.INSTANCE.serialize(userFeatureValue.fileLockingValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserFeatureValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserFeatureValue userFeatureValueFileLocking;
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
            if ("paper_as_files".equals(tag)) {
                expectField("paper_as_files", jsonParser);
                userFeatureValueFileLocking = UserFeatureValue.paperAsFiles(PaperAsFilesValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("file_locking".equals(tag)) {
                expectField("file_locking", jsonParser);
                userFeatureValueFileLocking = UserFeatureValue.fileLocking(FileLockingValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                userFeatureValueFileLocking = UserFeatureValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userFeatureValueFileLocking;
        }
    }
}
