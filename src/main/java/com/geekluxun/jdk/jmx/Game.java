package com.geekluxun.jdk.jmx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game implements GameMBean {

    private static final Logger LOG = LoggerFactory.getLogger(Game.class);

    private String playerName;

    @Override
    public void playFootball(String clubName) {
        LOG.info(this.playerName + " playing football for " + clubName);
    }

    @Override
    public String getPlayerName() {
        LOG.info("Return playerName " + this.playerName);
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        LOG.info("Set playerName to value " + playerName);
        this.playerName = playerName;
    }

}
