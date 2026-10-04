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
public final class HasTeamSelectiveSyncValue {
    public static final HasTeamSelectiveSyncValue OTHER = new HasTeamSelectiveSyncValue().withTag(Tag.OTHER);
    private Tag _tag;
    private Boolean hasTeamSelectiveSyncValue;

    public enum Tag {
        HAS_TEAM_SELECTIVE_SYNC,
        OTHER
    }

    private HasTeamSelectiveSyncValue() {
    }

    private HasTeamSelectiveSyncValue withTag(Tag tag) {
        HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue = new HasTeamSelectiveSyncValue();
        hasTeamSelectiveSyncValue._tag = tag;
        return hasTeamSelectiveSyncValue;
    }

    private HasTeamSelectiveSyncValue withTagAndHasTeamSelectiveSync(Tag tag, Boolean bool) {
        HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue = new HasTeamSelectiveSyncValue();
        hasTeamSelectiveSyncValue._tag = tag;
        hasTeamSelectiveSyncValue.hasTeamSelectiveSyncValue = bool;
        return hasTeamSelectiveSyncValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isHasTeamSelectiveSync() {
        return this._tag == Tag.HAS_TEAM_SELECTIVE_SYNC;
    }

    public static HasTeamSelectiveSyncValue hasTeamSelectiveSync(boolean z) {
        return new HasTeamSelectiveSyncValue().withTagAndHasTeamSelectiveSync(Tag.HAS_TEAM_SELECTIVE_SYNC, Boolean.valueOf(z));
    }

    public boolean getHasTeamSelectiveSyncValue() {
        if (this._tag != Tag.HAS_TEAM_SELECTIVE_SYNC) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SELECTIVE_SYNC, but was Tag." + this._tag.name());
        }
        return this.hasTeamSelectiveSyncValue.booleanValue();
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.hasTeamSelectiveSyncValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof HasTeamSelectiveSyncValue)) {
            HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue = (HasTeamSelectiveSyncValue) obj;
            if (this._tag != hasTeamSelectiveSyncValue._tag) {
                return false;
            }
            int i = C43501.f748x28e70b2e[this._tag.ordinal()];
            if (i != 1) {
                return i == 2;
            }
            if (this.hasTeamSelectiveSyncValue == hasTeamSelectiveSyncValue.hasTeamSelectiveSyncValue) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.HasTeamSelectiveSyncValue$1 */
    static /* synthetic */ class C43501 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$HasTeamSelectiveSyncValue$Tag */
        static final /* synthetic */ int[] f748x28e70b2e;

        static {
            int[] iArr = new int[Tag.values().length];
            f748x28e70b2e = iArr;
            try {
                iArr[Tag.HAS_TEAM_SELECTIVE_SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f748x28e70b2e[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<HasTeamSelectiveSyncValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue, JsonGenerator jsonGenerator) throws IOException {
            if (C43501.f748x28e70b2e[hasTeamSelectiveSyncValue.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("has_team_selective_sync", jsonGenerator);
                jsonGenerator.writeFieldName("has_team_selective_sync");
                StoneSerializers.boolean_().serialize(hasTeamSelectiveSyncValue.hasTeamSelectiveSyncValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public HasTeamSelectiveSyncValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            HasTeamSelectiveSyncValue hasTeamSelectiveSyncValueHasTeamSelectiveSync;
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
            if ("has_team_selective_sync".equals(tag)) {
                expectField("has_team_selective_sync", jsonParser);
                hasTeamSelectiveSyncValueHasTeamSelectiveSync = HasTeamSelectiveSyncValue.hasTeamSelectiveSync(StoneSerializers.boolean_().deserialize(jsonParser).booleanValue());
            } else {
                hasTeamSelectiveSyncValueHasTeamSelectiveSync = HasTeamSelectiveSyncValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return hasTeamSelectiveSyncValueHasTeamSelectiveSync;
        }
    }
}
