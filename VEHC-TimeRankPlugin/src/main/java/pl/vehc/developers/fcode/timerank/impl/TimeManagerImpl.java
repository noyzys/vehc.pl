package pl.vehc.developers.fcode.timerank.impl;

import pl.vehc.developers.fcode.timerank.impl.managers.TimeManager;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import java.util.Arrays;
import java.util.List;

public class TimeManagerImpl implements TimeManager {

    @Override
    public String getGroup(String name) {
        final PermissionUser permissionsEx = PermissionsEx.getPermissionManager().getUser(name);

        if (permissionsEx == null) return null;

        return permissionsEx.getGroupNames()[0];
    }

    @Override
    public List<String> getGroups(String name) {
        final PermissionUser permissionUser = PermissionsEx.getPermissionManager().getUser(name);

        if (permissionUser == null) return null;

        return Arrays.asList(permissionUser.getGroupNames());
    }

    @Override
    public String getPrefix(String name) {
        final PermissionUser permissionUser = PermissionsEx.getPermissionManager().getUser(name);

        if (permissionUser == null) return "";

        return permissionUser.getPrefix();
    }

    @Override
    public String getSuffix(String name) {
        final PermissionUser permissionUser = PermissionsEx.getPermissionManager().getUser(name);

        if (permissionUser == null) return  "";

        return permissionUser.getSuffix();
    }

    @Override
    public boolean isGroup(String group) {
        final PermissionGroup permissionGroup = PermissionsEx.getPermissionManager().getGroup(group);

        return permissionGroup != null;
    }

    @Override
    public void addGroup(String name, String group) {
        final PermissionUser permissionUser = PermissionsEx.getPermissionManager().getUser(name);

        if (permissionUser == null) return;

        permissionUser.addGroup(group);
    }

    @Override
    public PermissionUser getUser(String player) {
        return this.getUser(player);
    }

    @Override
    public void removeGroup(String name, String group) {
        final PermissionUser permissionUser = PermissionsEx.getPermissionManager().getUser(name);

    if (permissionUser == null) return;

    permissionUser.removeGroup(group);


    }
}
