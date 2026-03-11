package com.suleimandev.bedwars2026.sidebar.api;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.function.Supplier;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class PlaceholderProvider {

    private final String placeholder;
    private final Supplier<String> supplier;

    public PlaceholderProvider(@NotNull String placeholder, @NotNull Supplier<String> supplier) {
        this.placeholder = Objects.requireNonNull(placeholder, "placeholder");
        this.supplier = Objects.requireNonNull(supplier, "supplier");
    }

    @NotNull
    public String getPlaceholder() {
        return placeholder;
    }

    @NotNull
    public String resolve() {
        String value = supplier.get();
        return value == null ? "" : value;
    }
}

