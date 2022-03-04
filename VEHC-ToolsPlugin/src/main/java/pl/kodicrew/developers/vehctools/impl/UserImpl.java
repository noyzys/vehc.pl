package pl.kodicrew.developers.vehctools.impl;

import pl.kodicrew.developers.vehctools.impl.objects.User;

public class UserImpl implements User {

    private String name;

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }
}
