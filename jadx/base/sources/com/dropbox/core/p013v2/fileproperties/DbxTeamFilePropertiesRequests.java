package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.fileproperties.AddTemplateArg;
import com.dropbox.core.p013v2.fileproperties.AddTemplateResult;
import com.dropbox.core.p013v2.fileproperties.GetTemplateArg;
import com.dropbox.core.p013v2.fileproperties.GetTemplateResult;
import com.dropbox.core.p013v2.fileproperties.ListTemplateResult;
import com.dropbox.core.p013v2.fileproperties.ModifyTemplateError;
import com.dropbox.core.p013v2.fileproperties.RemoveTemplateArg;
import com.dropbox.core.p013v2.fileproperties.TemplateError;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateResult;
import com.dropbox.core.stone.StoneSerializers;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxTeamFilePropertiesRequests {
    private final DbxRawClientV2 client;

    public DbxTeamFilePropertiesRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    AddTemplateResult templatesAddForTeam(AddTemplateArg addTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (AddTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/add_for_team", addTemplateArg, false, AddTemplateArg.Serializer.INSTANCE, AddTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/add_for_team", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    public AddTemplateResult templatesAddForTeam(String str, String str2, List<PropertyFieldTemplate> list) throws DbxException {
        return templatesAddForTeam(new AddTemplateArg(str, str2, list));
    }

    GetTemplateResult templatesGetForTeam(GetTemplateArg getTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/get_for_team", getTemplateArg, false, GetTemplateArg.Serializer.INSTANCE, GetTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/get_for_team", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    public GetTemplateResult templatesGetForTeam(String str) throws DbxException {
        return templatesGetForTeam(new GetTemplateArg(str));
    }

    public ListTemplateResult templatesListForTeam() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/list_for_team", null, false, StoneSerializers.void_(), ListTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/list_for_team", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    void templatesRemoveForTeam(RemoveTemplateArg removeTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/remove_for_team", removeTemplateArg, false, RemoveTemplateArg.Serializer.INSTANCE, StoneSerializers.void_(), TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/file_properties/templates/remove_for_team", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    public void templatesRemoveForTeam(String str) throws DbxException {
        templatesRemoveForTeam(new RemoveTemplateArg(str));
    }

    UpdateTemplateResult templatesUpdateForTeam(UpdateTemplateArg updateTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UpdateTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_properties/templates/update_for_team", updateTemplateArg, false, UpdateTemplateArg.Serializer.INSTANCE, UpdateTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/update_for_team", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    public UpdateTemplateResult templatesUpdateForTeam(String str) throws DbxException {
        return templatesUpdateForTeam(new UpdateTemplateArg(str));
    }

    public TemplatesUpdateForTeamBuilder templatesUpdateForTeamBuilder(String str) {
        return new TemplatesUpdateForTeamBuilder(this, UpdateTemplateArg.newBuilder(str));
    }
}
