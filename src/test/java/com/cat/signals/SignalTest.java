package com.cat.signals;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignalTest {
    @Test
    public void doSignal() throws Exception {
        //GIVEN
        String trueString = "{\"Id\":3805," +
                "\"ActualTime\":1479915393," +
                "\"Comment\":\"H1, Trend channel\"," +
                "\"Pair\":\"GBPUSD\"," +
                "\"Cmd\":4," +
                "\"TradingSystem\":3," +
                "\"Period\":\"\"," +
                "\"Price\":1.2387299537658691," +
                "\"Sl\":1.2213599681854248," +
                "\"Tp\":1.256100058555603}";
        //WHEN
        Signal signal = mock(Signal.class);
        when(signal.doSignal(SignalsList.EURUSD, SignalsList.GBPUSD)).thenReturn(trueString);
        //THEN
        String result = signal.doSignal(SignalsList.EURUSD, SignalsList.GBPUSD);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, trueString);
    }

}