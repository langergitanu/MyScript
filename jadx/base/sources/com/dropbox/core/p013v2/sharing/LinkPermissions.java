package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkAccessLevel;
import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.LinkAudienceOption;
import com.dropbox.core.p013v2.sharing.RequestedVisibility;
import com.dropbox.core.p013v2.sharing.ResolvedVisibility;
import com.dropbox.core.p013v2.sharing.SharedLinkAccessFailureReason;
import com.dropbox.core.p013v2.sharing.VisibilityPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LinkPermissions {
    protected final boolean allowComments;
    protected final boolean allowDownload;

    @Nullable
    protected final List<LinkAudienceOption> audienceOptions;
    protected final boolean canAllowDownload;
    protected final boolean canDisallowDownload;
    protected final boolean canRemoveExpiry;

    @Nullable
    protected final Boolean canRemovePassword;
    protected final boolean canRevoke;
    protected final boolean canSetExpiry;

    @Nullable
    protected final Boolean canSetPassword;

    @Nullable
    protected final Boolean canUseExtendedSharingControls;

    @Nullable
    protected final LinkAudience effectiveAudience;

    @Nullable
    protected final LinkAccessLevel linkAccessLevel;

    @Nullable
    protected final RequestedVisibility requestedVisibility;

    @Nullable
    protected final Boolean requirePassword;

    @Nullable
    protected final ResolvedVisibility resolvedVisibility;

    @Nullable
    protected final SharedLinkAccessFailureReason revokeFailureReason;
    protected final boolean teamRestrictsComments;

    @Nonnull
    protected final List<VisibilityPolicy> visibilityPolicies;

    public LinkPermissions(boolean z, @Nonnull List<VisibilityPolicy> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable ResolvedVisibility resolvedVisibility, @Nullable RequestedVisibility requestedVisibility, @Nullable SharedLinkAccessFailureReason sharedLinkAccessFailureReason, @Nullable LinkAudience linkAudience, @Nullable LinkAccessLevel linkAccessLevel, @Nullable List<LinkAudienceOption> list2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4) {
        this.resolvedVisibility = resolvedVisibility;
        this.requestedVisibility = requestedVisibility;
        this.canRevoke = z;
        this.revokeFailureReason = sharedLinkAccessFailureReason;
        this.effectiveAudience = linkAudience;
        this.linkAccessLevel = linkAccessLevel;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'visibilityPolicies' is null");
        }
        Iterator<VisibilityPolicy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'visibilityPolicies' is null");
            }
        }
        this.visibilityPolicies = list;
        this.canSetExpiry = z2;
        this.canRemoveExpiry = z3;
        this.allowDownload = z4;
        this.canAllowDownload = z5;
        this.canDisallowDownload = z6;
        this.allowComments = z7;
        this.teamRestrictsComments = z8;
        if (list2 != null) {
            Iterator<LinkAudienceOption> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
                }
            }
        }
        this.audienceOptions = list2;
        this.canSetPassword = bool;
        this.canRemovePassword = bool2;
        this.requirePassword = bool3;
        this.canUseExtendedSharingControls = bool4;
    }

    public LinkPermissions(boolean z, @Nonnull List<VisibilityPolicy> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this(z, list, z2, z3, z4, z5, z6, z7, z8, null, null, null, null, null, null, null, null, null, null);
    }

    public boolean getCanRevoke() {
        return this.canRevoke;
    }

    @Nonnull
    public List<VisibilityPolicy> getVisibilityPolicies() {
        return this.visibilityPolicies;
    }

    public boolean getCanSetExpiry() {
        return this.canSetExpiry;
    }

    public boolean getCanRemoveExpiry() {
        return this.canRemoveExpiry;
    }

    public boolean getAllowDownload() {
        return this.allowDownload;
    }

    public boolean getCanAllowDownload() {
        return this.canAllowDownload;
    }

    public boolean getCanDisallowDownload() {
        return this.canDisallowDownload;
    }

    public boolean getAllowComments() {
        return this.allowComments;
    }

    public boolean getTeamRestrictsComments() {
        return this.teamRestrictsComments;
    }

    @Nullable
    public ResolvedVisibility getResolvedVisibility() {
        return this.resolvedVisibility;
    }

    @Nullable
    public RequestedVisibility getRequestedVisibility() {
        return this.requestedVisibility;
    }

    @Nullable
    public SharedLinkAccessFailureReason getRevokeFailureReason() {
        return this.revokeFailureReason;
    }

    @Nullable
    public LinkAudience getEffectiveAudience() {
        return this.effectiveAudience;
    }

    @Nullable
    public LinkAccessLevel getLinkAccessLevel() {
        return this.linkAccessLevel;
    }

    @Nullable
    public List<LinkAudienceOption> getAudienceOptions() {
        return this.audienceOptions;
    }

    @Nullable
    public Boolean getCanSetPassword() {
        return this.canSetPassword;
    }

    @Nullable
    public Boolean getCanRemovePassword() {
        return this.canRemovePassword;
    }

    @Nullable
    public Boolean getRequirePassword() {
        return this.requirePassword;
    }

    @Nullable
    public Boolean getCanUseExtendedSharingControls() {
        return this.canUseExtendedSharingControls;
    }

    public static Builder newBuilder(boolean z, List<VisibilityPolicy> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        return new Builder(z, list, z2, z3, z4, z5, z6, z7, z8);
    }

    public static class Builder {
        protected final boolean allowComments;
        protected final boolean allowDownload;
        protected List<LinkAudienceOption> audienceOptions;
        protected final boolean canAllowDownload;
        protected final boolean canDisallowDownload;
        protected final boolean canRemoveExpiry;
        protected Boolean canRemovePassword;
        protected final boolean canRevoke;
        protected final boolean canSetExpiry;
        protected Boolean canSetPassword;
        protected Boolean canUseExtendedSharingControls;
        protected LinkAudience effectiveAudience;
        protected LinkAccessLevel linkAccessLevel;
        protected RequestedVisibility requestedVisibility;
        protected Boolean requirePassword;
        protected ResolvedVisibility resolvedVisibility;
        protected SharedLinkAccessFailureReason revokeFailureReason;
        protected final boolean teamRestrictsComments;
        protected final List<VisibilityPolicy> visibilityPolicies;

        protected Builder(boolean z, List<VisibilityPolicy> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
            this.canRevoke = z;
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'visibilityPolicies' is null");
            }
            Iterator<VisibilityPolicy> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'visibilityPolicies' is null");
                }
            }
            this.visibilityPolicies = list;
            this.canSetExpiry = z2;
            this.canRemoveExpiry = z3;
            this.allowDownload = z4;
            this.canAllowDownload = z5;
            this.canDisallowDownload = z6;
            this.allowComments = z7;
            this.teamRestrictsComments = z8;
            this.resolvedVisibility = null;
            this.requestedVisibility = null;
            this.revokeFailureReason = null;
            this.effectiveAudience = null;
            this.linkAccessLevel = null;
            this.audienceOptions = null;
            this.canSetPassword = null;
            this.canRemovePassword = null;
            this.requirePassword = null;
            this.canUseExtendedSharingControls = null;
        }

        public Builder withResolvedVisibility(ResolvedVisibility resolvedVisibility) {
            this.resolvedVisibility = resolvedVisibility;
            return this;
        }

        public Builder withRequestedVisibility(RequestedVisibility requestedVisibility) {
            this.requestedVisibility = requestedVisibility;
            return this;
        }

        public Builder withRevokeFailureReason(SharedLinkAccessFailureReason sharedLinkAccessFailureReason) {
            this.revokeFailureReason = sharedLinkAccessFailureReason;
            return this;
        }

        public Builder withEffectiveAudience(LinkAudience linkAudience) {
            this.effectiveAudience = linkAudience;
            return this;
        }

        public Builder withLinkAccessLevel(LinkAccessLevel linkAccessLevel) {
            this.linkAccessLevel = linkAccessLevel;
            return this;
        }

        public Builder withAudienceOptions(List<LinkAudienceOption> list) {
            if (list != null) {
                Iterator<LinkAudienceOption> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
                    }
                }
            }
            this.audienceOptions = list;
            return this;
        }

        public Builder withCanSetPassword(Boolean bool) {
            this.canSetPassword = bool;
            return this;
        }

        public Builder withCanRemovePassword(Boolean bool) {
            this.canRemovePassword = bool;
            return this;
        }

        public Builder withRequirePassword(Boolean bool) {
            this.requirePassword = bool;
            return this;
        }

        public Builder withCanUseExtendedSharingControls(Boolean bool) {
            this.canUseExtendedSharingControls = bool;
            return this;
        }

        public LinkPermissions build() {
            return new LinkPermissions(this.canRevoke, this.visibilityPolicies, this.canSetExpiry, this.canRemoveExpiry, this.allowDownload, this.canAllowDownload, this.canDisallowDownload, this.allowComments, this.teamRestrictsComments, this.resolvedVisibility, this.requestedVisibility, this.revokeFailureReason, this.effectiveAudience, this.linkAccessLevel, this.audienceOptions, this.canSetPassword, this.canRemovePassword, this.requirePassword, this.canUseExtendedSharingControls);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.resolvedVisibility, this.requestedVisibility, Boolean.valueOf(this.canRevoke), this.revokeFailureReason, this.effectiveAudience, this.linkAccessLevel, this.visibilityPolicies, Boolean.valueOf(this.canSetExpiry), Boolean.valueOf(this.canRemoveExpiry), Boolean.valueOf(this.allowDownload), Boolean.valueOf(this.canAllowDownload), Boolean.valueOf(this.canDisallowDownload), Boolean.valueOf(this.allowComments), Boolean.valueOf(this.teamRestrictsComments), this.audienceOptions, this.canSetPassword, this.canRemovePassword, this.requirePassword, this.canUseExtendedSharingControls});
    }

    public boolean equals(Object obj) {
        List<VisibilityPolicy> list;
        List<VisibilityPolicy> list2;
        ResolvedVisibility resolvedVisibility;
        ResolvedVisibility resolvedVisibility2;
        RequestedVisibility requestedVisibility;
        RequestedVisibility requestedVisibility2;
        SharedLinkAccessFailureReason sharedLinkAccessFailureReason;
        SharedLinkAccessFailureReason sharedLinkAccessFailureReason2;
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        LinkAccessLevel linkAccessLevel;
        LinkAccessLevel linkAccessLevel2;
        List<LinkAudienceOption> list3;
        List<LinkAudienceOption> list4;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            LinkPermissions linkPermissions = (LinkPermissions) obj;
            if (this.canRevoke == linkPermissions.canRevoke && (((list = this.visibilityPolicies) == (list2 = linkPermissions.visibilityPolicies) || list.equals(list2)) && this.canSetExpiry == linkPermissions.canSetExpiry && this.canRemoveExpiry == linkPermissions.canRemoveExpiry && this.allowDownload == linkPermissions.allowDownload && this.canAllowDownload == linkPermissions.canAllowDownload && this.canDisallowDownload == linkPermissions.canDisallowDownload && this.allowComments == linkPermissions.allowComments && this.teamRestrictsComments == linkPermissions.teamRestrictsComments && (((resolvedVisibility = this.resolvedVisibility) == (resolvedVisibility2 = linkPermissions.resolvedVisibility) || (resolvedVisibility != null && resolvedVisibility.equals(resolvedVisibility2))) && (((requestedVisibility = this.requestedVisibility) == (requestedVisibility2 = linkPermissions.requestedVisibility) || (requestedVisibility != null && requestedVisibility.equals(requestedVisibility2))) && (((sharedLinkAccessFailureReason = this.revokeFailureReason) == (sharedLinkAccessFailureReason2 = linkPermissions.revokeFailureReason) || (sharedLinkAccessFailureReason != null && sharedLinkAccessFailureReason.equals(sharedLinkAccessFailureReason2))) && (((linkAudience = this.effectiveAudience) == (linkAudience2 = linkPermissions.effectiveAudience) || (linkAudience != null && linkAudience.equals(linkAudience2))) && (((linkAccessLevel = this.linkAccessLevel) == (linkAccessLevel2 = linkPermissions.linkAccessLevel) || (linkAccessLevel != null && linkAccessLevel.equals(linkAccessLevel2))) && (((list3 = this.audienceOptions) == (list4 = linkPermissions.audienceOptions) || (list3 != null && list3.equals(list4))) && (((bool = this.canSetPassword) == (bool2 = linkPermissions.canSetPassword) || (bool != null && bool.equals(bool2))) && (((bool3 = this.canRemovePassword) == (bool4 = linkPermissions.canRemovePassword) || (bool3 != null && bool3.equals(bool4))) && (((bool5 = this.requirePassword) == (bool6 = linkPermissions.requirePassword) || (bool5 != null && bool5.equals(bool6))) && ((bool7 = this.canUseExtendedSharingControls) == (bool8 = linkPermissions.canUseExtendedSharingControls) || (bool7 != null && bool7.equals(bool8)))))))))))))) {
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

    static class Serializer extends StructSerializer<LinkPermissions> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LinkPermissions linkPermissions, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("can_revoke");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.canRevoke), jsonGenerator);
            jsonGenerator.writeFieldName("visibility_policies");
            StoneSerializers.list(VisibilityPolicy.Serializer.INSTANCE).serialize(linkPermissions.visibilityPolicies, jsonGenerator);
            jsonGenerator.writeFieldName("can_set_expiry");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.canSetExpiry), jsonGenerator);
            jsonGenerator.writeFieldName("can_remove_expiry");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.canRemoveExpiry), jsonGenerator);
            jsonGenerator.writeFieldName("allow_download");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.allowDownload), jsonGenerator);
            jsonGenerator.writeFieldName("can_allow_download");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.canAllowDownload), jsonGenerator);
            jsonGenerator.writeFieldName("can_disallow_download");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.canDisallowDownload), jsonGenerator);
            jsonGenerator.writeFieldName("allow_comments");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.allowComments), jsonGenerator);
            jsonGenerator.writeFieldName("team_restricts_comments");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkPermissions.teamRestrictsComments), jsonGenerator);
            if (linkPermissions.resolvedVisibility != null) {
                jsonGenerator.writeFieldName("resolved_visibility");
                StoneSerializers.nullable(ResolvedVisibility.Serializer.INSTANCE).serialize(linkPermissions.resolvedVisibility, jsonGenerator);
            }
            if (linkPermissions.requestedVisibility != null) {
                jsonGenerator.writeFieldName("requested_visibility");
                StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).serialize(linkPermissions.requestedVisibility, jsonGenerator);
            }
            if (linkPermissions.revokeFailureReason != null) {
                jsonGenerator.writeFieldName("revoke_failure_reason");
                StoneSerializers.nullable(SharedLinkAccessFailureReason.Serializer.INSTANCE).serialize(linkPermissions.revokeFailureReason, jsonGenerator);
            }
            if (linkPermissions.effectiveAudience != null) {
                jsonGenerator.writeFieldName("effective_audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(linkPermissions.effectiveAudience, jsonGenerator);
            }
            if (linkPermissions.linkAccessLevel != null) {
                jsonGenerator.writeFieldName("link_access_level");
                StoneSerializers.nullable(LinkAccessLevel.Serializer.INSTANCE).serialize(linkPermissions.linkAccessLevel, jsonGenerator);
            }
            if (linkPermissions.audienceOptions != null) {
                jsonGenerator.writeFieldName("audience_options");
                StoneSerializers.nullable(StoneSerializers.list(LinkAudienceOption.Serializer.INSTANCE)).serialize(linkPermissions.audienceOptions, jsonGenerator);
            }
            if (linkPermissions.canSetPassword != null) {
                jsonGenerator.writeFieldName("can_set_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(linkPermissions.canSetPassword, jsonGenerator);
            }
            if (linkPermissions.canRemovePassword != null) {
                jsonGenerator.writeFieldName("can_remove_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(linkPermissions.canRemovePassword, jsonGenerator);
            }
            if (linkPermissions.requirePassword != null) {
                jsonGenerator.writeFieldName("require_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(linkPermissions.requirePassword, jsonGenerator);
            }
            if (linkPermissions.canUseExtendedSharingControls != null) {
                jsonGenerator.writeFieldName("can_use_extended_sharing_controls");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(linkPermissions.canUseExtendedSharingControls, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LinkPermissions deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize2 = null;
                Boolean boolDeserialize3 = null;
                List list = null;
                Boolean boolDeserialize4 = null;
                Boolean boolDeserialize5 = null;
                Boolean boolDeserialize6 = null;
                Boolean boolDeserialize7 = null;
                Boolean boolDeserialize8 = null;
                ResolvedVisibility resolvedVisibility = null;
                RequestedVisibility requestedVisibility = null;
                SharedLinkAccessFailureReason sharedLinkAccessFailureReason = null;
                LinkAudience linkAudience = null;
                LinkAccessLevel linkAccessLevel = null;
                List list2 = null;
                Boolean bool = null;
                Boolean bool2 = null;
                Boolean bool3 = null;
                Boolean bool4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("can_revoke".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("visibility_policies".equals(currentName)) {
                        list = (List) StoneSerializers.list(VisibilityPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("can_set_expiry".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("can_remove_expiry".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("allow_download".equals(currentName)) {
                        boolDeserialize4 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("can_allow_download".equals(currentName)) {
                        boolDeserialize5 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("can_disallow_download".equals(currentName)) {
                        boolDeserialize6 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("allow_comments".equals(currentName)) {
                        boolDeserialize7 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("team_restricts_comments".equals(currentName)) {
                        boolDeserialize8 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("resolved_visibility".equals(currentName)) {
                        resolvedVisibility = (ResolvedVisibility) StoneSerializers.nullable(ResolvedVisibility.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("requested_visibility".equals(currentName)) {
                        requestedVisibility = (RequestedVisibility) StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("revoke_failure_reason".equals(currentName)) {
                        sharedLinkAccessFailureReason = (SharedLinkAccessFailureReason) StoneSerializers.nullable(SharedLinkAccessFailureReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("effective_audience".equals(currentName)) {
                        linkAudience = (LinkAudience) StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("link_access_level".equals(currentName)) {
                        linkAccessLevel = (LinkAccessLevel) StoneSerializers.nullable(LinkAccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("audience_options".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(LinkAudienceOption.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("can_set_password".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("can_remove_password".equals(currentName)) {
                        bool2 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("require_password".equals(currentName)) {
                        bool3 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("can_use_extended_sharing_controls".equals(currentName)) {
                        bool4 = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"can_revoke\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"visibility_policies\" missing.");
                }
                if (boolDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"can_set_expiry\" missing.");
                }
                if (boolDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"can_remove_expiry\" missing.");
                }
                if (boolDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow_download\" missing.");
                }
                if (boolDeserialize5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"can_allow_download\" missing.");
                }
                if (boolDeserialize6 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"can_disallow_download\" missing.");
                }
                if (boolDeserialize7 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow_comments\" missing.");
                }
                if (boolDeserialize8 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"team_restricts_comments\" missing.");
                }
                LinkPermissions linkPermissions = new LinkPermissions(boolDeserialize.booleanValue(), list, boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), boolDeserialize4.booleanValue(), boolDeserialize5.booleanValue(), boolDeserialize6.booleanValue(), boolDeserialize7.booleanValue(), boolDeserialize8.booleanValue(), resolvedVisibility, requestedVisibility, sharedLinkAccessFailureReason, linkAudience, linkAccessLevel, list2, bool, bool2, bool3, bool4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(linkPermissions, linkPermissions.toStringMultiline());
                return linkPermissions;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
