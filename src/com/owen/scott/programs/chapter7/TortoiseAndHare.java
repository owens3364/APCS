package com.owen.scott.programs.chapter7;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class TortoiseAndHare implements Runnable {
    private static final String TRACK_TOKEN = "=";
    private static final byte TRACK_LENGTH = 0x46;

    @Override
    public void run() {
        String[] tortoiseTrack = new String[TRACK_LENGTH];
        String[] hareTrack = new String[TRACK_LENGTH];
        Arrays.fill(tortoiseTrack, TRACK_TOKEN);
        Arrays.fill(hareTrack, TRACK_TOKEN);
        Advanceable tortoise = new Tortoise();
        Advanceable hare = new Hare();
        tortoiseTrack[0] = Tortoise.TORTOISE_TOKEN;
        hareTrack[0] = Hare.HARE_TOKEN;
        System.out.println("Press any key and then return to start the race.");
        InputUtils.getInputString(new Scanner((System.in)), (String str) -> true);
        System.out.println("BANG !!!!!\nAND THEY'RE OFF !!!!!");
        boolean raceComplete = false;
        RaceStatus hareResult = RaceStatus.TIE;
        while (!raceComplete) {
            System.out.println(getTrackAsString(tortoiseTrack));
            System.out.println(getTrackAsString(hareTrack));
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.exit(1);
            }
            tortoise.advance(tortoiseTrack, TRACK_TOKEN);
            hare.advance(hareTrack, TRACK_TOKEN);
            if (tortoise.getPosition() == tortoiseTrack.length - 1) {
                hareResult = hare.getPosition() == tortoise.getPosition() ? RaceStatus.TIE : RaceStatus.LOSE;
                raceComplete = true;
            } else if (hare.getPosition() == hareTrack.length - 1) {
                hareResult = hare.getPosition() == tortoise.getPosition() ? RaceStatus.TIE : RaceStatus.WIN;
                raceComplete = true;
            } else if (tortoise.getPosition() == hare.getPosition()) {
                System.out.println("OUCH!");
            }
        }
        System.out.println(getTrackAsString(tortoiseTrack));
        System.out.println(getTrackAsString(hareTrack));
        System.out.println(hareResult.equals(RaceStatus.WIN) ? "Hare wins!" : hareResult == RaceStatus.TIE ? "It's a tie!" : "Tortoise wins!");
    }

    private String getTrackAsString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}

enum RaceStatus {
    WIN, LOSE, TIE
}