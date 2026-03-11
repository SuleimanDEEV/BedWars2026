package com.suleimandev.bedwars2026.sidebar.version;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class LegacySidebarVersionAdapter implements SidebarVersionAdapter {

    private final String nmsVersion;

    public LegacySidebarVersionAdapter(@NotNull String nmsVersion) {
        this.nmsVersion = nmsVersion;
    }

    @Override
    public void sendHeaderFooter(@NotNull Player player, @NotNull String header, @NotNull String footer) {
        try {
            Class<?> craftPlayerClass = Class.forName(Bukkit.getServer().getClass().getPackage().getName() + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);
            Method getHandle = craftPlayerClass.getMethod("getHandle");
            Object entityPlayer = getHandle.invoke(craftPlayer);

            Field connectionField = entityPlayer.getClass().getField("playerConnection");
            Object playerConnection = connectionField.get(entityPlayer);

            Class<?> packetClass = Class.forName("net.minecraft.server." + nmsVersion + ".PacketPlayOutPlayerListHeaderFooter");
            Class<?> packetBaseClass = Class.forName("net.minecraft.server." + nmsVersion + ".Packet");
            Class<?> componentClass = Class.forName("net.minecraft.server." + nmsVersion + ".IChatBaseComponent");
            Class<?> serializerClass = Class.forName("net.minecraft.server." + nmsVersion + ".IChatBaseComponent$ChatSerializer");

            Object headerComponent = serializerClass.getMethod("a", String.class).invoke(null, jsonText(header));
            Object footerComponent = serializerClass.getMethod("a", String.class).invoke(null, jsonText(footer));

            Object packet = packetClass.getConstructor().newInstance();
            Field headerField = packetClass.getDeclaredField("a");
            Field footerField = packetClass.getDeclaredField("b");
            headerField.setAccessible(true);
            footerField.setAccessible(true);
            headerField.set(packet, componentClass.cast(headerComponent));
            footerField.set(packet, componentClass.cast(footerComponent));

            Method sendPacket = playerConnection.getClass().getMethod("sendPacket", packetBaseClass);
            sendPacket.invoke(playerConnection, packet);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Override
    public int getTeamTextLimit() {
        return 16;
    }

    @Override
    public int getTitleLimit() {
        return 32;
    }

    @NotNull
    private String jsonText(@NotNull String content) {
        return "{\"text\":\"" + content
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n") + "\"}";
    }
}

