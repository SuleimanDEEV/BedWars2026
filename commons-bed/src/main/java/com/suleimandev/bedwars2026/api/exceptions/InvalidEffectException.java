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

public class InvalidEffectException extends Throwable {

    public InvalidEffectException(String message) {
        super(message + " is not a valid " + VersionSupport.getName() + " effect! Using defaults..");
    }
}

