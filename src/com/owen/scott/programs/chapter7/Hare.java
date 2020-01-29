package com.owen.scott.programs.chapter7;

import java.util.Random;

public class Hare implements Advanceable {
    public static final String HARE_TOKEN = "H";
    private static final byte BIG_HOP_ADVANCEMENT = 0x9;
    private static final byte BIG_SLIP_ADVANCEMENT = -0xC;
    private static final byte SMALL_HOP_ADVANCEMENT = 0x1;
    private static final byte SMALL_SLIP_ADVANCEMENT = -0x2;

    private int position = 0;

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void advance(String[] track, String trackToken) {
        track[position] = trackToken;
        int chance = new Random().nextInt(10);
        switch (chance) {
            case 0:
                position = Math.max(position + BIG_SLIP_ADVANCEMENT, 0);
                track[position] = HARE_TOKEN;
                break;
            case 1:
            case 2:
                position = Math.max(position + SMALL_SLIP_ADVANCEMENT, 0);
                track[position] = HARE_TOKEN;
                break;
            case 3:
            case 4:
                track[position] = HARE_TOKEN;
                break;
            case 5:
            case 6:
            case 7:
                position = Math.min(position + SMALL_HOP_ADVANCEMENT, track.length - 1);
                track[position] = HARE_TOKEN;
                break;
            case 8:
            case 9:
                position = Math.min(position + BIG_HOP_ADVANCEMENT, track.length - 1);
                track[position] = HARE_TOKEN;
                break;
        }
    }
}
