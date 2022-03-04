package pl.vehc.developers.fcode.timerank.impl.managers;

import ru.tehkode.permissions.PermissionUser;

import java.util.List;

public interface TimeManager {

    String getGroup(String name);

    List<String> getGroups(String name);

    String getPrefix(String name);

    String getSuffix(String name);

    boolean isGroup(String group);

    void addGroup(String name, String group);

    void removeGroup(String name, String group);

    PermissionUser getUser(final String player);

}
