package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.RelocationPath;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class RelocationBatchArgBase {
    protected final boolean autorename;

    @Nonnull
    protected final List<RelocationPath> entries;

    public RelocationBatchArgBase(@Nonnull List<RelocationPath> list, boolean z) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        if (list.size() < 1) {
            throw new IllegalArgumentException("List 'entries' has fewer than 1 items");
        }
        if (list.size() > 1000) {
            throw new IllegalArgumentException("List 'entries' has more than 1000 items");
        }
        Iterator<RelocationPath> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = list;
        this.autorename = z;
    }

    public RelocationBatchArgBase(@Nonnull List<RelocationPath> list) {
        this(list, false);
    }

    @Nonnull
    public List<RelocationPath> getEntries() {
        return this.entries;
    }

    public boolean getAutorename() {
        return this.autorename;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.entries, Boolean.valueOf(this.autorename)});
    }

    public boolean equals(Object obj) {
        RelocationBatchArgBase relocationBatchArgBase;
        List<RelocationPath> list;
        List<RelocationPath> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.entries) == (list2 = (relocationBatchArgBase = (RelocationBatchArgBase) obj).entries) || list.equals(list2)) && this.autorename == relocationBatchArgBase.autorename;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RelocationBatchArgBase> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RelocationBatchArgBase relocationBatchArgBase, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            StoneSerializers.list(RelocationPath.Serializer.INSTANCE).serialize(relocationBatchArgBase.entries, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(relocationBatchArgBase.autorename), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RelocationBatchArgBase deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (RemoteConfigConstants.ResponseFieldKey.ENTRIES.equals(currentName)) {
                        list = (List) StoneSerializers.list(RelocationPath.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("autorename".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"entries\" missing.");
                }
                RelocationBatchArgBase relocationBatchArgBase = new RelocationBatchArgBase(list, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(relocationBatchArgBase, relocationBatchArgBase.toStringMultiline());
                return relocationBatchArgBase;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
