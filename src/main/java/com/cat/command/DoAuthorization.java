package com.cat.command;

import com.cat.authorization.Authorization;

import java.io.IOException;

public class DoAuthorization implements Command {
    private Authorization authorization;

    public DoAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public void execute() {
        try {
            authorization.doAuthorization();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
