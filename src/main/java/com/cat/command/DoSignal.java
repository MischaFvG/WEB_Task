package com.cat.command;

import com.cat.signals.Signal;
import com.cat.signals.SignalsList;

import java.io.IOException;

public class DoSignal implements Command {
    private Signal signal;

    public DoSignal(Signal signal) {
        this.signal = signal;
    }

    public void execute() {
        try {
            signal.doSignal(SignalsList.EURUSD, SignalsList.GBPUSD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
