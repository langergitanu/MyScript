package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ListRevisionsResult {

    @Nonnull
    protected final List<FileMetadata> entries;
    protected final boolean isDeleted;

    @Nullable
    protected final Date serverDeleted;

    public ListRevisionsResult(boolean z, @Nonnull List<FileMetadata> list, @Nullable Date date) {
        this.isDeleted = z;
        this.serverDeleted = LangUtil.truncateMillis(date);
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        Iterator<FileMetadata> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = list;
    }

    public ListRevisionsResult(boolean z, @Nonnull List<FileMetadata> list) {
        this(z, list, null);
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    @Nonnull
    public List<FileMetadata> getEntries() {
        return this.entries;
    }

    @Nullable
    public Date getServerDeleted() {
        return this.serverDeleted;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.isDeleted), this.serverDeleted, this.entries});
    }

    public boolean equals(Object obj) {
        List<FileMetadata> list;
        List<FileMetadata> list2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ListRevisionsResult listRevisionsResult = (ListRevisionsResult) obj;
            if (this.isDeleted == listRevisionsResult.isDeleted && (((list = this.entries) == (list2 = listRevisionsResult.entries) || list.equals(list2)) && ((date = this.serverDeleted) == (date2 = listRevisionsResult.serverDeleted) || (date != null && date.equals(date2))))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListRevisionsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListRevisionsResult listRevisionsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("is_deleted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listRevisionsResult.isDeleted), jsonGenerator);
            jsonGenerator.writeFieldName(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            StoneSerializers.list(FileMetadata.Serializer.INSTANCE).serialize(listRevisionsResult.entries, jsonGenerator);
            if (listRevisionsResult.serverDeleted != null) {
                jsonGenerator.writeFieldName("server_deleted");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(listRevisionsResult.serverDeleted, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListRevisionsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_deleted".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if (RemoteConfigConstants.ResponseFieldKey.ENTRIES.equals(currentName)) {
                        list = (List) StoneSerializers.list(FileMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("server_deleted".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"is_deleted\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"entries\" missing.");
                }
                ListRevisionsResult listRevisionsResult = new ListRevisionsResult(boolDeserialize.booleanValue(), list, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listRevisionsResult, listRevisionsResult.toStringMultiline());
                return listRevisionsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
