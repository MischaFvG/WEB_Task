package com.cat.command;

import com.cat.Signals.Signal;
import com.cat.authorization.Authorization;

public class SwitchWork {
    public static void main(String[] args) {
        Authorization authorization = new Authorization();
        Command doAuthorization = new DoAuthorization(authorization);
        Signal signal = new Signal();
        Command doSignal = new DoSignal(signal);
        Switch switcher = new Switch(doAuthorization, doSignal);
        switcher.doAuthorization();
        switcher.doSignal();
    }
}
