package com.suleimandev.bedwars2026.api.exceptions;

import com.suleimandev.bedwars2026.api.server.VersionSupport;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class InvalidMaterialException extends Exception {

    public InvalidMaterialException(String s) {
        super(s + " is not a valid " + VersionSupport.getName() + " material! Using defaults..");
    }
}

