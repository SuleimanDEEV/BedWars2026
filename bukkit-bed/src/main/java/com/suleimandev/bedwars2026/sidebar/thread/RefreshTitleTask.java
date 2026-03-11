package com.suleimandev.bedwars2026.sidebar.thread;

import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class RefreshTitleTask implements Runnable {
    @Override
    public void run() {
        MatchSidebarService.getInstance().refreshTitles();
    }
}

