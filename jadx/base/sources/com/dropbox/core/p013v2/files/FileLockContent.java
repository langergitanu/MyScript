package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.SingleUserLock;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class FileLockContent {
    private Tag _tag;
    private SingleUserLock singleUserValue;
    public static final FileLockContent UNLOCKED = new FileLockContent().withTag(Tag.UNLOCKED);
    public static final FileLockContent OTHER = new FileLockContent().withTag(Tag.OTHER);

    public enum Tag {
        UNLOCKED,
        SINGLE_USER,
        OTHER
    }

    private FileLockContent() {
    }

    private FileLockContent withTag(Tag tag) {
        FileLockContent fileLockContent = new FileLockContent();
        fileLockContent._tag = tag;
        return fileLockContent;
    }

    private FileLockContent withTagAndSingleUser(Tag tag, SingleUserLock singleUserLock) {
        FileLockContent fileLockContent = new FileLockContent();
        fileLockContent._tag = tag;
        fileLockContent.singleUserValue = singleUserLock;
        return fileLockContent;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUnlocked() {
        return this._tag == Tag.UNLOCKED;
    }

    public boolean isSingleUser() {
        return this._tag == Tag.SINGLE_USER;
    }

    public static FileLockContent singleUser(SingleUserLock singleUserLock) {
        if (singleUserLock == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileLockContent().withTagAndSingleUser(Tag.SINGLE_USER, singleUserLock);
    }

    public SingleUserLock getSingleUserValue() {
        if (this._tag != Tag.SINGLE_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.SINGLE_USER, but was Tag." + this._tag.name());
        }
        return this.singleUserValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.singleUserValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FileLockContent)) {
            return false;
        }
        FileLockContent fileLockContent = (FileLockContent) obj;
        if (this._tag != fileLockContent._tag) {
            return false;
        }
        int i = C41591.$SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i == 3;
            }
            SingleUserLock singleUserLock = this.singleUserValue;
            SingleUserLock singleUserLock2 = fileLockContent.singleUserValue;
            if (singleUserLock != singleUserLock2 && !singleUserLock.equals(singleUserLock2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.FileLockContent$1 */
    static /* synthetic */ class C41591 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag = iArr;
            try {
                iArr[Tag.UNLOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag[Tag.SINGLE_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<FileLockContent> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileLockContent fileLockContent, JsonGenerator jsonGenerator) throws IOException {
            int i = C41591.$SwitchMap$com$dropbox$core$v2$files$FileLockContent$Tag[fileLockContent.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("unlocked");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("single_user", jsonGenerator);
                SingleUserLock.Serializer.INSTANCE.serialize(fileLockContent.singleUserValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileLockContent deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileLockContent fileLockContentSingleUser;
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
            if ("unlocked".equals(tag)) {
                fileLockContentSingleUser = FileLockContent.UNLOCKED;
            } else if ("single_user".equals(tag)) {
                fileLockContentSingleUser = FileLockContent.singleUser(SingleUserLock.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                fileLockContentSingleUser = FileLockContent.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileLockContentSingleUser;
        }
    }
}
