package com.owen.scott.programs.chapter7;

import java.util.Random;

public class Tortoise implements Advanceable {
    public static final String TORTOISE_TOKEN = "T";
    private static final byte FAST_PLOD_ADVANCEMENT = 0x3;
    private static final byte SLIP_ADVANCEMENT = -0x6;
    private static final byte SLOW_PLOD_ADVANCEMENT = 0x1;

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
            case 1:
                position = Math.max(position + SLIP_ADVANCEMENT, 0);
                track[position] = TORTOISE_TOKEN;
                break;
            case 2:
            case 3:
            case 4:
                position = Math.min(position + SLOW_PLOD_ADVANCEMENT, track.length - 1);
                track[position] = TORTOISE_TOKEN;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                position = Math.min(position + FAST_PLOD_ADVANCEMENT, track.length - 1);
                track[position] = TORTOISE_TOKEN;
                break;
        }
    }
}
