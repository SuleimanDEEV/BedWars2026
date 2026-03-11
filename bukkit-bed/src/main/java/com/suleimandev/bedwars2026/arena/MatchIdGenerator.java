package com.suleimandev.bedwars2026.arena;

import java.text.SimpleDateFormat;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class MatchIdGenerator {

    private int gid = 0;
    private String day = "", month = "";


    public String generateGameID() {
        SimpleDateFormat y = new SimpleDateFormat("yy"), m = new SimpleDateFormat("MM"), d = new SimpleDateFormat("dd");
        String m2 = m.format(System.currentTimeMillis()), d2 = d.format(System.currentTimeMillis());
        if (!(m2.equals(this.month) || d2.equalsIgnoreCase(this.day))) {
            this.month = m2;
            this.day = d2;
            this.gid = 0;
        }
        return "bw_temp_y" + y.format(System.currentTimeMillis()) + "m" + this.month + "d" + this.day + "g" + gid++;
    }

}

