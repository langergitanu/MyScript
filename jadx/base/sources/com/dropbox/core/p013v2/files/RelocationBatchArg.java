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
class RelocationBatchArg extends RelocationBatchArgBase {
    protected final boolean allowOwnershipTransfer;
    protected final boolean allowSharedFolder;

    public RelocationBatchArg(@Nonnull List<RelocationPath> list, boolean z, boolean z2, boolean z3) {
        super(list, z);
        this.allowSharedFolder = z2;
        this.allowOwnershipTransfer = z3;
    }

    public RelocationBatchArg(@Nonnull List<RelocationPath> list) {
        this(list, false, false, false);
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    @Nonnull
    public List<RelocationPath> getEntries() {
        return this.entries;
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    public boolean getAutorename() {
        return this.autorename;
    }

    public boolean getAllowSharedFolder() {
        return this.allowSharedFolder;
    }

    public boolean getAllowOwnershipTransfer() {
        return this.allowOwnershipTransfer;
    }

    public static Builder newBuilder(List<RelocationPath> list) {
        return new Builder(list);
    }

    public static class Builder {
        protected boolean allowOwnershipTransfer;
        protected boolean allowSharedFolder;
        protected boolean autorename;
        protected final List<RelocationPath> entries;

        protected Builder(List<RelocationPath> list) {
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
            this.autorename = false;
            this.allowSharedFolder = false;
            this.allowOwnershipTransfer = false;
        }

        public Builder withAutorename(Boolean bool) {
            if (bool != null) {
                this.autorename = bool.booleanValue();
                return this;
            }
            this.autorename = false;
            return this;
        }

        public Builder withAllowSharedFolder(Boolean bool) {
            if (bool != null) {
                this.allowSharedFolder = bool.booleanValue();
                return this;
            }
            this.allowSharedFolder = false;
            return this;
        }

        public Builder withAllowOwnershipTransfer(Boolean bool) {
            if (bool != null) {
                this.allowOwnershipTransfer = bool.booleanValue();
                return this;
            }
            this.allowOwnershipTransfer = false;
            return this;
        }

        public RelocationBatchArg build() {
            return new RelocationBatchArg(this.entries, this.autorename, this.allowSharedFolder, this.allowOwnershipTransfer);
        }
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Boolean.valueOf(this.allowSharedFolder), Boolean.valueOf(this.allowOwnershipTransfer)});
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RelocationBatchArg relocationBatchArg = (RelocationBatchArg) obj;
            if ((this.entries == relocationBatchArg.entries || this.entries.equals(relocationBatchArg.entries)) && this.autorename == relocationBatchArg.autorename && this.allowSharedFolder == relocationBatchArg.allowSharedFolder && this.allowOwnershipTransfer == relocationBatchArg.allowOwnershipTransfer) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.RelocationBatchArgBase
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RelocationBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RelocationBatchArg relocationBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            StoneSerializers.list(RelocationPath.Serializer.INSTANCE).serialize(relocationBatchArg.entries, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(relocationBatchArg.autorename), jsonGenerator);
            jsonGenerator.writeFieldName("allow_shared_folder");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(relocationBatchArg.allowSharedFolder), jsonGenerator);
            jsonGenerator.writeFieldName("allow_ownership_transfer");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(relocationBatchArg.allowOwnershipTransfer), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RelocationBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Boolean boolDeserialize2 = false;
                Boolean boolDeserialize3 = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (RemoteConfigConstants.ResponseFieldKey.ENTRIES.equals(currentName)) {
                        list = (List) StoneSerializers.list(RelocationPath.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("autorename".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("allow_shared_folder".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("allow_ownership_transfer".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"entries\" missing.");
                }
                RelocationBatchArg relocationBatchArg = new RelocationBatchArg(list, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(relocationBatchArg, relocationBatchArg.toStringMultiline());
                return relocationBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
