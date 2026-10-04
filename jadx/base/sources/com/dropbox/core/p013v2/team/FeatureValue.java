package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.HasTeamFileEventsValue;
import com.dropbox.core.p013v2.team.HasTeamSelectiveSyncValue;
import com.dropbox.core.p013v2.team.HasTeamSharedDropboxValue;
import com.dropbox.core.p013v2.team.UploadApiRateLimitValue;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class FeatureValue {
    public static final FeatureValue OTHER = new FeatureValue().withTag(Tag.OTHER);
    private Tag _tag;
    private HasTeamFileEventsValue hasTeamFileEventsValue;
    private HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue;
    private HasTeamSharedDropboxValue hasTeamSharedDropboxValue;
    private UploadApiRateLimitValue uploadApiRateLimitValue;

    public enum Tag {
        UPLOAD_API_RATE_LIMIT,
        HAS_TEAM_SHARED_DROPBOX,
        HAS_TEAM_FILE_EVENTS,
        HAS_TEAM_SELECTIVE_SYNC,
        OTHER
    }

    private FeatureValue() {
    }

    private FeatureValue withTag(Tag tag) {
        FeatureValue featureValue = new FeatureValue();
        featureValue._tag = tag;
        return featureValue;
    }

    private FeatureValue withTagAndUploadApiRateLimit(Tag tag, UploadApiRateLimitValue uploadApiRateLimitValue) {
        FeatureValue featureValue = new FeatureValue();
        featureValue._tag = tag;
        featureValue.uploadApiRateLimitValue = uploadApiRateLimitValue;
        return featureValue;
    }

    private FeatureValue withTagAndHasTeamSharedDropbox(Tag tag, HasTeamSharedDropboxValue hasTeamSharedDropboxValue) {
        FeatureValue featureValue = new FeatureValue();
        featureValue._tag = tag;
        featureValue.hasTeamSharedDropboxValue = hasTeamSharedDropboxValue;
        return featureValue;
    }

    private FeatureValue withTagAndHasTeamFileEvents(Tag tag, HasTeamFileEventsValue hasTeamFileEventsValue) {
        FeatureValue featureValue = new FeatureValue();
        featureValue._tag = tag;
        featureValue.hasTeamFileEventsValue = hasTeamFileEventsValue;
        return featureValue;
    }

    private FeatureValue withTagAndHasTeamSelectiveSync(Tag tag, HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue) {
        FeatureValue featureValue = new FeatureValue();
        featureValue._tag = tag;
        featureValue.hasTeamSelectiveSyncValue = hasTeamSelectiveSyncValue;
        return featureValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUploadApiRateLimit() {
        return this._tag == Tag.UPLOAD_API_RATE_LIMIT;
    }

    public static FeatureValue uploadApiRateLimit(UploadApiRateLimitValue uploadApiRateLimitValue) {
        if (uploadApiRateLimitValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndUploadApiRateLimit(Tag.UPLOAD_API_RATE_LIMIT, uploadApiRateLimitValue);
    }

    public UploadApiRateLimitValue getUploadApiRateLimitValue() {
        if (this._tag != Tag.UPLOAD_API_RATE_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.UPLOAD_API_RATE_LIMIT, but was Tag." + this._tag.name());
        }
        return this.uploadApiRateLimitValue;
    }

    public boolean isHasTeamSharedDropbox() {
        return this._tag == Tag.HAS_TEAM_SHARED_DROPBOX;
    }

    public static FeatureValue hasTeamSharedDropbox(HasTeamSharedDropboxValue hasTeamSharedDropboxValue) {
        if (hasTeamSharedDropboxValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamSharedDropbox(Tag.HAS_TEAM_SHARED_DROPBOX, hasTeamSharedDropboxValue);
    }

    public HasTeamSharedDropboxValue getHasTeamSharedDropboxValue() {
        if (this._tag != Tag.HAS_TEAM_SHARED_DROPBOX) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SHARED_DROPBOX, but was Tag." + this._tag.name());
        }
        return this.hasTeamSharedDropboxValue;
    }

    public boolean isHasTeamFileEvents() {
        return this._tag == Tag.HAS_TEAM_FILE_EVENTS;
    }

    public static FeatureValue hasTeamFileEvents(HasTeamFileEventsValue hasTeamFileEventsValue) {
        if (hasTeamFileEventsValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamFileEvents(Tag.HAS_TEAM_FILE_EVENTS, hasTeamFileEventsValue);
    }

    public HasTeamFileEventsValue getHasTeamFileEventsValue() {
        if (this._tag != Tag.HAS_TEAM_FILE_EVENTS) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_FILE_EVENTS, but was Tag." + this._tag.name());
        }
        return this.hasTeamFileEventsValue;
    }

    public boolean isHasTeamSelectiveSync() {
        return this._tag == Tag.HAS_TEAM_SELECTIVE_SYNC;
    }

    public static FeatureValue hasTeamSelectiveSync(HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue) {
        if (hasTeamSelectiveSyncValue == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamSelectiveSync(Tag.HAS_TEAM_SELECTIVE_SYNC, hasTeamSelectiveSyncValue);
    }

    public HasTeamSelectiveSyncValue getHasTeamSelectiveSyncValue() {
        if (this._tag != Tag.HAS_TEAM_SELECTIVE_SYNC) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SELECTIVE_SYNC, but was Tag." + this._tag.name());
        }
        return this.hasTeamSelectiveSyncValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.uploadApiRateLimitValue, this.hasTeamSharedDropboxValue, this.hasTeamFileEventsValue, this.hasTeamSelectiveSyncValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof FeatureValue)) {
            return false;
        }
        FeatureValue featureValue = (FeatureValue) obj;
        if (this._tag != featureValue._tag) {
            return false;
        }
        int i = C43321.$SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[this._tag.ordinal()];
        if (i == 1) {
            UploadApiRateLimitValue uploadApiRateLimitValue = this.uploadApiRateLimitValue;
            UploadApiRateLimitValue uploadApiRateLimitValue2 = featureValue.uploadApiRateLimitValue;
            return uploadApiRateLimitValue == uploadApiRateLimitValue2 || uploadApiRateLimitValue.equals(uploadApiRateLimitValue2);
        }
        if (i == 2) {
            HasTeamSharedDropboxValue hasTeamSharedDropboxValue = this.hasTeamSharedDropboxValue;
            HasTeamSharedDropboxValue hasTeamSharedDropboxValue2 = featureValue.hasTeamSharedDropboxValue;
            return hasTeamSharedDropboxValue == hasTeamSharedDropboxValue2 || hasTeamSharedDropboxValue.equals(hasTeamSharedDropboxValue2);
        }
        if (i == 3) {
            HasTeamFileEventsValue hasTeamFileEventsValue = this.hasTeamFileEventsValue;
            HasTeamFileEventsValue hasTeamFileEventsValue2 = featureValue.hasTeamFileEventsValue;
            return hasTeamFileEventsValue == hasTeamFileEventsValue2 || hasTeamFileEventsValue.equals(hasTeamFileEventsValue2);
        }
        if (i != 4) {
            return i == 5;
        }
        HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue = this.hasTeamSelectiveSyncValue;
        HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue2 = featureValue.hasTeamSelectiveSyncValue;
        return hasTeamSelectiveSyncValue == hasTeamSelectiveSyncValue2 || hasTeamSelectiveSyncValue.equals(hasTeamSelectiveSyncValue2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.FeatureValue$1 */
    static /* synthetic */ class C43321 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag = iArr;
            try {
                iArr[Tag.UPLOAD_API_RATE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[Tag.HAS_TEAM_SHARED_DROPBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[Tag.HAS_TEAM_FILE_EVENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[Tag.HAS_TEAM_SELECTIVE_SYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<FeatureValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FeatureValue featureValue, JsonGenerator jsonGenerator) throws IOException {
            int i = C43321.$SwitchMap$com$dropbox$core$v2$team$FeatureValue$Tag[featureValue.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("upload_api_rate_limit", jsonGenerator);
                jsonGenerator.writeFieldName("upload_api_rate_limit");
                UploadApiRateLimitValue.Serializer.INSTANCE.serialize(featureValue.uploadApiRateLimitValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("has_team_shared_dropbox", jsonGenerator);
                jsonGenerator.writeFieldName("has_team_shared_dropbox");
                HasTeamSharedDropboxValue.Serializer.INSTANCE.serialize(featureValue.hasTeamSharedDropboxValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("has_team_file_events", jsonGenerator);
                jsonGenerator.writeFieldName("has_team_file_events");
                HasTeamFileEventsValue.Serializer.INSTANCE.serialize(featureValue.hasTeamFileEventsValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("has_team_selective_sync", jsonGenerator);
                jsonGenerator.writeFieldName("has_team_selective_sync");
                HasTeamSelectiveSyncValue.Serializer.INSTANCE.serialize(featureValue.hasTeamSelectiveSyncValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FeatureValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FeatureValue featureValueHasTeamSelectiveSync;
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
            if ("upload_api_rate_limit".equals(tag)) {
                expectField("upload_api_rate_limit", jsonParser);
                featureValueHasTeamSelectiveSync = FeatureValue.uploadApiRateLimit(UploadApiRateLimitValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("has_team_shared_dropbox".equals(tag)) {
                expectField("has_team_shared_dropbox", jsonParser);
                featureValueHasTeamSelectiveSync = FeatureValue.hasTeamSharedDropbox(HasTeamSharedDropboxValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("has_team_file_events".equals(tag)) {
                expectField("has_team_file_events", jsonParser);
                featureValueHasTeamSelectiveSync = FeatureValue.hasTeamFileEvents(HasTeamFileEventsValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("has_team_selective_sync".equals(tag)) {
                expectField("has_team_selective_sync", jsonParser);
                featureValueHasTeamSelectiveSync = FeatureValue.hasTeamSelectiveSync(HasTeamSelectiveSyncValue.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                featureValueHasTeamSelectiveSync = FeatureValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return featureValueHasTeamSelectiveSync;
        }
    }
}
