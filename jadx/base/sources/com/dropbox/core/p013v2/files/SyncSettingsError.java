package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class SyncSettingsError {
    private Tag _tag;
    private LookupError pathValue;
    public static final SyncSettingsError UNSUPPORTED_COMBINATION = new SyncSettingsError().withTag(Tag.UNSUPPORTED_COMBINATION);
    public static final SyncSettingsError UNSUPPORTED_CONFIGURATION = new SyncSettingsError().withTag(Tag.UNSUPPORTED_CONFIGURATION);
    public static final SyncSettingsError OTHER = new SyncSettingsError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        UNSUPPORTED_COMBINATION,
        UNSUPPORTED_CONFIGURATION,
        OTHER
    }

    private SyncSettingsError() {
    }

    private SyncSettingsError withTag(Tag tag) {
        SyncSettingsError syncSettingsError = new SyncSettingsError();
        syncSettingsError._tag = tag;
        return syncSettingsError;
    }

    private SyncSettingsError withTagAndPath(Tag tag, LookupError lookupError) {
        SyncSettingsError syncSettingsError = new SyncSettingsError();
        syncSettingsError._tag = tag;
        syncSettingsError.pathValue = lookupError;
        return syncSettingsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static SyncSettingsError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SyncSettingsError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isUnsupportedCombination() {
        return this._tag == Tag.UNSUPPORTED_COMBINATION;
    }

    public boolean isUnsupportedConfiguration() {
        return this._tag == Tag.UNSUPPORTED_CONFIGURATION;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SyncSettingsError)) {
            return false;
        }
        SyncSettingsError syncSettingsError = (SyncSettingsError) obj;
        if (this._tag != syncSettingsError._tag) {
            return false;
        }
        int i = C42051.$SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = syncSettingsError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.SyncSettingsError$1 */
    static /* synthetic */ class C42051 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag[Tag.UNSUPPORTED_COMBINATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag[Tag.UNSUPPORTED_CONFIGURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag[Tag.OTHER.ordinal()] = 4;
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

    public static class Serializer extends UnionSerializer<SyncSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SyncSettingsError syncSettingsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42051.$SwitchMap$com$dropbox$core$v2$files$SyncSettingsError$Tag[syncSettingsError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(syncSettingsError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("unsupported_combination");
            } else if (i == 3) {
                jsonGenerator.writeString("unsupported_configuration");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SyncSettingsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SyncSettingsError syncSettingsErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                syncSettingsErrorPath = SyncSettingsError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_combination".equals(tag)) {
                syncSettingsErrorPath = SyncSettingsError.UNSUPPORTED_COMBINATION;
            } else if ("unsupported_configuration".equals(tag)) {
                syncSettingsErrorPath = SyncSettingsError.UNSUPPORTED_CONFIGURATION;
            } else {
                syncSettingsErrorPath = SyncSettingsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return syncSettingsErrorPath;
        }
    }
}
