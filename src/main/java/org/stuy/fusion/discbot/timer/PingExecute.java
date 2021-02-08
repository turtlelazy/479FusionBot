package org.stuy.fusion.discbot.timer;

import static java.util.concurrent.TimeUnit.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class PingExecute {
    private ArrayList<ConstantMessages> x = new ArrayList<ConstantMessages>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void loop() {
        final Runnable pinger = new Runnable() {
            public void run() {
                for (int i = 0; i < x.size(); i++) {
                    Date date = new Date();

                    if (x.get(i).getDay() == date.getDay() && x.get(i).getHour() == date.getHours()
                            && x.get(i).getMinutes() == date.getMinutes()) {
                        Main.defaultChannel.sendMessage("It's time for a meet, " + x.get(i).getUserName()).queue();
                    }
                }
            }
        };

        final ScheduledFuture<?> pingerHandle = scheduler.scheduleAtFixedRate(pinger, 0, 1, MINUTES);
        scheduler.schedule(new Runnable() {
            public void run() {
                pingerHandle.cancel(true);
            }
        }, 1000000, MINUTES);
    }

    public void addPing(ConstantMessages i) {
        x.add(i);
    }

    public ArrayList<ConstantMessages> getPingsList() {
        return x;
    }

    public ConstantMessages get(int i) {
        return x.get(i);
    }

    public void remove(int i) {
        x.remove(i);
    }

}
