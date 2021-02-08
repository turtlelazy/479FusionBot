package org.stuy.fusion.discbot;

import org.stuy.fusion.discbot.botsystems.Commands;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(PrivateVals.token); // your token as a string goes in
                                                                          // PrivateVals.token
        Commands commands = new Commands();

        builder.addEventListeners(commands);
        builder.build();
    }
}
