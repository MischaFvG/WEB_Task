package com.cat.command;

public class Switch {
    private Command doAuthorization;
    private Command doSignal;

    public Switch(Command doAuthorization, Command doSignal) {
        this.doAuthorization = doAuthorization;
        this.doSignal = doSignal;
    }

    public void doAuthorization() {
        doAuthorization.execute();
    }

    public void doSignal() {
        doSignal.execute();
    }
}
