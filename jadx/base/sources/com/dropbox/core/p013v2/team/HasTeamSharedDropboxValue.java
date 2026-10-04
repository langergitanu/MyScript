package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class HasTeamSharedDropboxValue {
    public static final HasTeamSharedDropboxValue OTHER = new HasTeamSharedDropboxValue().withTag(Tag.OTHER);
    private Tag _tag;
    private Boolean hasTeamSharedDropboxValue;

    public enum Tag {
        HAS_TEAM_SHARED_DROPBOX,
        OTHER
    }

    private HasTeamSharedDropboxValue() {
    }

    private HasTeamSharedDropboxValue withTag(Tag tag) {
        HasTeamSharedDropboxValue hasTeamSharedDropboxValue = new HasTeamSharedDropboxValue();
        hasTeamSharedDropboxValue._tag = tag;
        return hasTeamSharedDropboxValue;
    }

    private HasTeamSharedDropboxValue withTagAndHasTeamSharedDropbox(Tag tag, Boolean bool) {
        HasTeamSharedDropboxValue hasTeamSharedDropboxValue = new HasTeamSharedDropboxValue();
        hasTeamSharedDropboxValue._tag = tag;
        hasTeamSharedDropboxValue.hasTeamSharedDropboxValue = bool;
        return hasTeamSharedDropboxValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isHasTeamSharedDropbox() {
        return this._tag == Tag.HAS_TEAM_SHARED_DROPBOX;
    }

    public static HasTeamSharedDropboxValue hasTeamSharedDropbox(boolean z) {
        return new HasTeamSharedDropboxValue().withTagAndHasTeamSharedDropbox(Tag.HAS_TEAM_SHARED_DROPBOX, Boolean.valueOf(z));
    }

    public boolean getHasTeamSharedDropboxValue() {
        if (this._tag != Tag.HAS_TEAM_SHARED_DROPBOX) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SHARED_DROPBOX, but was Tag." + this._tag.name());
        }
        return this.hasTeamSharedDropboxValue.booleanValue();
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.hasTeamSharedDropboxValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof HasTeamSharedDropboxValue)) {
            HasTeamSharedDropboxValue hasTeamSharedDropboxValue = (HasTeamSharedDropboxValue) obj;
            if (this._tag != hasTeamSharedDropboxValue._tag) {
                return false;
            }
            int i = C43511.f749xede91ee[this._tag.ordinal()];
            if (i != 1) {
                return i == 2;
            }
            if (this.hasTeamSharedDropboxValue == hasTeamSharedDropboxValue.hasTeamSharedDropboxValue) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.HasTeamSharedDropboxValue$1 */
    static /* synthetic */ class C43511 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$HasTeamSharedDropboxValue$Tag */
        static final /* synthetic */ int[] f749xede91ee;

        static {
            int[] iArr = new int[Tag.values().length];
            f749xede91ee = iArr;
            try {
                iArr[Tag.HAS_TEAM_SHARED_DROPBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f749xede91ee[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<HasTeamSharedDropboxValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(HasTeamSharedDropboxValue hasTeamSharedDropboxValue, JsonGenerator jsonGenerator) throws IOException {
            if (C43511.f749xede91ee[hasTeamSharedDropboxValue.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("has_team_shared_dropbox", jsonGenerator);
                jsonGenerator.writeFieldName("has_team_shared_dropbox");
                StoneSerializers.boolean_().serialize(hasTeamSharedDropboxValue.hasTeamSharedDropboxValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public HasTeamSharedDropboxValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            HasTeamSharedDropboxValue hasTeamSharedDropboxValueHasTeamSharedDropbox;
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
            if ("has_team_shared_dropbox".equals(tag)) {
                expectField("has_team_shared_dropbox", jsonParser);
                hasTeamSharedDropboxValueHasTeamSharedDropbox = HasTeamSharedDropboxValue.hasTeamSharedDropbox(StoneSerializers.boolean_().deserialize(jsonParser).booleanValue());
            } else {
                hasTeamSharedDropboxValueHasTeamSharedDropbox = HasTeamSharedDropboxValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return hasTeamSharedDropboxValueHasTeamSharedDropbox;
        }
    }
}
