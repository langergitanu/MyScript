package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.p013v2.filerequests.FileRequestDeadline;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateFileRequestDeadline {
    public static final UpdateFileRequestDeadline NO_UPDATE = new UpdateFileRequestDeadline().withTag(Tag.NO_UPDATE);
    public static final UpdateFileRequestDeadline OTHER = new UpdateFileRequestDeadline().withTag(Tag.OTHER);
    private Tag _tag;
    private FileRequestDeadline updateValue;

    public enum Tag {
        NO_UPDATE,
        UPDATE,
        OTHER
    }

    private UpdateFileRequestDeadline() {
    }

    private UpdateFileRequestDeadline withTag(Tag tag) {
        UpdateFileRequestDeadline updateFileRequestDeadline = new UpdateFileRequestDeadline();
        updateFileRequestDeadline._tag = tag;
        return updateFileRequestDeadline;
    }

    private UpdateFileRequestDeadline withTagAndUpdate(Tag tag, FileRequestDeadline fileRequestDeadline) {
        UpdateFileRequestDeadline updateFileRequestDeadline = new UpdateFileRequestDeadline();
        updateFileRequestDeadline._tag = tag;
        updateFileRequestDeadline.updateValue = fileRequestDeadline;
        return updateFileRequestDeadline;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isNoUpdate() {
        return this._tag == Tag.NO_UPDATE;
    }

    public boolean isUpdate() {
        return this._tag == Tag.UPDATE;
    }

    public static UpdateFileRequestDeadline update(FileRequestDeadline fileRequestDeadline) {
        return new UpdateFileRequestDeadline().withTagAndUpdate(Tag.UPDATE, fileRequestDeadline);
    }

    public static UpdateFileRequestDeadline update() {
        return update(null);
    }

    public FileRequestDeadline getUpdateValue() {
        if (this._tag != Tag.UPDATE) {
            throw new IllegalStateException("Invalid tag: required Tag.UPDATE, but was Tag." + this._tag.name());
        }
        return this.updateValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.updateValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateFileRequestDeadline)) {
            return false;
        }
        UpdateFileRequestDeadline updateFileRequestDeadline = (UpdateFileRequestDeadline) obj;
        if (this._tag != updateFileRequestDeadline._tag) {
            return false;
        }
        int i = C41391.f689x29b1cca2[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i == 3;
            }
            FileRequestDeadline fileRequestDeadline = this.updateValue;
            FileRequestDeadline fileRequestDeadline2 = updateFileRequestDeadline.updateValue;
            if (fileRequestDeadline != fileRequestDeadline2 && (fileRequestDeadline == null || !fileRequestDeadline.equals(fileRequestDeadline2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.filerequests.UpdateFileRequestDeadline$1 */
    static /* synthetic */ class C41391 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$filerequests$UpdateFileRequestDeadline$Tag */
        static final /* synthetic */ int[] f689x29b1cca2;

        static {
            int[] iArr = new int[Tag.values().length];
            f689x29b1cca2 = iArr;
            try {
                iArr[Tag.NO_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f689x29b1cca2[Tag.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f689x29b1cca2[Tag.OTHER.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<UpdateFileRequestDeadline> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UpdateFileRequestDeadline updateFileRequestDeadline, JsonGenerator jsonGenerator) throws IOException {
            int i = C41391.f689x29b1cca2[updateFileRequestDeadline.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("no_update");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("update", jsonGenerator);
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(updateFileRequestDeadline.updateValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UpdateFileRequestDeadline deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UpdateFileRequestDeadline updateFileRequestDeadlineUpdate;
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
            if ("no_update".equals(tag)) {
                updateFileRequestDeadlineUpdate = UpdateFileRequestDeadline.NO_UPDATE;
            } else if ("update".equals(tag)) {
                FileRequestDeadline fileRequestDeadline = jsonParser.getCurrentToken() != JsonToken.END_OBJECT ? (FileRequestDeadline) StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(jsonParser, true) : null;
                if (fileRequestDeadline == null) {
                    updateFileRequestDeadlineUpdate = UpdateFileRequestDeadline.update();
                } else {
                    updateFileRequestDeadlineUpdate = UpdateFileRequestDeadline.update(fileRequestDeadline);
                }
            } else {
                updateFileRequestDeadlineUpdate = UpdateFileRequestDeadline.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return updateFileRequestDeadlineUpdate;
        }
    }
}
