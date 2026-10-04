package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.TeamMemberStatus;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldHeldRevisionMetadata {

    @Nonnull
    protected final String authorEmail;

    @Nonnull
    protected final String authorMemberId;

    @Nonnull
    protected final TeamMemberStatus authorMemberStatus;

    @Nonnull
    protected final String contentHash;

    @Nonnull
    protected final String fileType;

    @Nonnull
    protected final String newFilename;

    @Nonnull
    protected final String originalFilePath;

    @Nonnull
    protected final String originalRevisionId;

    @Nonnull
    protected final Date serverModified;
    protected final long size;

    public LegalHoldHeldRevisionMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull Date date, @Nonnull String str4, @Nonnull TeamMemberStatus teamMemberStatus, @Nonnull String str5, @Nonnull String str6, long j, @Nonnull String str7) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'newFilename' is null");
        }
        this.newFilename = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'originalRevisionId' is null");
        }
        if (str2.length() < 9) {
            throw new IllegalArgumentException("String 'originalRevisionId' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", str2)) {
            throw new IllegalArgumentException("String 'originalRevisionId' does not match pattern");
        }
        this.originalRevisionId = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'originalFilePath' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?", str3)) {
            throw new IllegalArgumentException("String 'originalFilePath' does not match pattern");
        }
        this.originalFilePath = str3;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = LangUtil.truncateMillis(date);
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'authorMemberId' is null");
        }
        this.authorMemberId = str4;
        if (teamMemberStatus == null) {
            throw new IllegalArgumentException("Required value for 'authorMemberStatus' is null");
        }
        this.authorMemberStatus = teamMemberStatus;
        if (str5 == null) {
            throw new IllegalArgumentException("Required value for 'authorEmail' is null");
        }
        if (str5.length() > 255) {
            throw new IllegalArgumentException("String 'authorEmail' is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str5)) {
            throw new IllegalArgumentException("String 'authorEmail' does not match pattern");
        }
        this.authorEmail = str5;
        if (str6 == null) {
            throw new IllegalArgumentException("Required value for 'fileType' is null");
        }
        this.fileType = str6;
        this.size = j;
        if (str7 == null) {
            throw new IllegalArgumentException("Required value for 'contentHash' is null");
        }
        if (str7.length() < 64) {
            throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
        }
        if (str7.length() > 64) {
            throw new IllegalArgumentException("String 'contentHash' is longer than 64");
        }
        this.contentHash = str7;
    }

    @Nonnull
    public String getNewFilename() {
        return this.newFilename;
    }

    @Nonnull
    public String getOriginalRevisionId() {
        return this.originalRevisionId;
    }

    @Nonnull
    public String getOriginalFilePath() {
        return this.originalFilePath;
    }

    @Nonnull
    public Date getServerModified() {
        return this.serverModified;
    }

    @Nonnull
    public String getAuthorMemberId() {
        return this.authorMemberId;
    }

    @Nonnull
    public TeamMemberStatus getAuthorMemberStatus() {
        return this.authorMemberStatus;
    }

    @Nonnull
    public String getAuthorEmail() {
        return this.authorEmail;
    }

    @Nonnull
    public String getFileType() {
        return this.fileType;
    }

    public long getSize() {
        return this.size;
    }

    @Nonnull
    public String getContentHash() {
        return this.contentHash;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newFilename, this.originalRevisionId, this.originalFilePath, this.serverModified, this.authorMemberId, this.authorMemberStatus, this.authorEmail, this.fileType, Long.valueOf(this.size), this.contentHash});
    }

    public boolean equals(Object obj) {
        LegalHoldHeldRevisionMetadata legalHoldHeldRevisionMetadata;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Date date;
        Date date2;
        String str7;
        String str8;
        TeamMemberStatus teamMemberStatus;
        TeamMemberStatus teamMemberStatus2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.newFilename) == (str2 = (legalHoldHeldRevisionMetadata = (LegalHoldHeldRevisionMetadata) obj).newFilename) || str.equals(str2)) && (((str3 = this.originalRevisionId) == (str4 = legalHoldHeldRevisionMetadata.originalRevisionId) || str3.equals(str4)) && (((str5 = this.originalFilePath) == (str6 = legalHoldHeldRevisionMetadata.originalFilePath) || str5.equals(str6)) && (((date = this.serverModified) == (date2 = legalHoldHeldRevisionMetadata.serverModified) || date.equals(date2)) && (((str7 = this.authorMemberId) == (str8 = legalHoldHeldRevisionMetadata.authorMemberId) || str7.equals(str8)) && (((teamMemberStatus = this.authorMemberStatus) == (teamMemberStatus2 = legalHoldHeldRevisionMetadata.authorMemberStatus) || teamMemberStatus.equals(teamMemberStatus2)) && (((str9 = this.authorEmail) == (str10 = legalHoldHeldRevisionMetadata.authorEmail) || str9.equals(str10)) && (((str11 = this.fileType) == (str12 = legalHoldHeldRevisionMetadata.fileType) || str11.equals(str12)) && this.size == legalHoldHeldRevisionMetadata.size && ((str13 = this.contentHash) == (str14 = legalHoldHeldRevisionMetadata.contentHash) || str13.equals(str14)))))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldHeldRevisionMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldHeldRevisionMetadata legalHoldHeldRevisionMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_filename");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.newFilename, jsonGenerator);
            jsonGenerator.writeFieldName("original_revision_id");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.originalRevisionId, jsonGenerator);
            jsonGenerator.writeFieldName("original_file_path");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.originalFilePath, jsonGenerator);
            jsonGenerator.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(legalHoldHeldRevisionMetadata.serverModified, jsonGenerator);
            jsonGenerator.writeFieldName("author_member_id");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.authorMemberId, jsonGenerator);
            jsonGenerator.writeFieldName("author_member_status");
            TeamMemberStatus.Serializer.INSTANCE.serialize(legalHoldHeldRevisionMetadata.authorMemberStatus, jsonGenerator);
            jsonGenerator.writeFieldName("author_email");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.authorEmail, jsonGenerator);
            jsonGenerator.writeFieldName("file_type");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.fileType, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            StoneSerializers.uInt64().serialize(Long.valueOf(legalHoldHeldRevisionMetadata.size), jsonGenerator);
            jsonGenerator.writeFieldName("content_hash");
            StoneSerializers.string().serialize(legalHoldHeldRevisionMetadata.contentHash, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldHeldRevisionMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                Date dateDeserialize = null;
                String strDeserialize4 = null;
                TeamMemberStatus teamMemberStatusDeserialize = null;
                String strDeserialize5 = null;
                String strDeserialize6 = null;
                String strDeserialize7 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_filename".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("original_revision_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("original_file_path".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("server_modified".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("author_member_id".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("author_member_status".equals(currentName)) {
                        teamMemberStatusDeserialize = TeamMemberStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("author_email".equals(currentName)) {
                        strDeserialize5 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("file_type".equals(currentName)) {
                        strDeserialize6 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("size".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        strDeserialize7 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_filename\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"original_revision_id\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"original_file_path\" missing.");
                }
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"server_modified\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"author_member_id\" missing.");
                }
                if (teamMemberStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"author_member_status\" missing.");
                }
                if (strDeserialize5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"author_email\" missing.");
                }
                if (strDeserialize6 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file_type\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"size\" missing.");
                }
                if (strDeserialize7 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"content_hash\" missing.");
                }
                LegalHoldHeldRevisionMetadata legalHoldHeldRevisionMetadata = new LegalHoldHeldRevisionMetadata(strDeserialize, strDeserialize2, strDeserialize3, dateDeserialize, strDeserialize4, teamMemberStatusDeserialize, strDeserialize5, strDeserialize6, lDeserialize.longValue(), strDeserialize7);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldHeldRevisionMetadata, legalHoldHeldRevisionMetadata.toStringMultiline());
                return legalHoldHeldRevisionMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
