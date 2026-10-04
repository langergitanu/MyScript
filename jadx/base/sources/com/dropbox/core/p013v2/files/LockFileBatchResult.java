package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LockFileResultEntry;
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
public class LockFileBatchResult extends FileOpsResult {

    @Nonnull
    protected final List<LockFileResultEntry> entries;

    public LockFileBatchResult(@Nonnull List<LockFileResultEntry> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        Iterator<LockFileResultEntry> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = list;
    }

    @Nonnull
    public List<LockFileResultEntry> getEntries() {
        return this.entries;
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.entries});
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<LockFileResultEntry> list = this.entries;
        List<LockFileResultEntry> list2 = ((LockFileBatchResult) obj).entries;
        return list == list2 || list.equals(list2);
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.FileOpsResult
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LockFileBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LockFileBatchResult lockFileBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            StoneSerializers.list(LockFileResultEntry.Serializer.INSTANCE).serialize(lockFileBatchResult.entries, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LockFileBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (RemoteConfigConstants.ResponseFieldKey.ENTRIES.equals(currentName)) {
                        list = (List) StoneSerializers.list(LockFileResultEntry.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"entries\" missing.");
                }
                LockFileBatchResult lockFileBatchResult = new LockFileBatchResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(lockFileBatchResult, lockFileBatchResult.toStringMultiline());
                return lockFileBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
