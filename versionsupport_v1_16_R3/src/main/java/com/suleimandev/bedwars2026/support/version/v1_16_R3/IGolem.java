package com.suleimandev.bedwars2026.support.version.v1_16_R3;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.support.version.common.VersionCommon;
import net.minecraft.server.v1_16_R3.*;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class IGolem extends EntityIronGolem {
    private ITeam team;

    private IGolem(EntityTypes<? extends EntityIronGolem> entitytypes, World world, ITeam bedWarsTeam) {
        super(entitytypes, world);
        this.team = bedWarsTeam;
    }

    public IGolem(EntityTypes entityTypes, World world) {
        super(entityTypes, world);
    }

    @Override
    protected void initPathfinder() {
        this.goalSelector.a(1, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.5D, false));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this));
        this.goalSelector.a(3, new PathfinderGoalRandomStroll(this, 1D));
        this.goalSelector.a(4, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<>(this, EntityHuman.class, 20, true, false, player -> {
            return player.isAlive() && !team.wasMember(player.getUniqueID()) && !team.getArena().isReSpawning(player.getUniqueID())
                    && !team.getArena().isSpectator(player.getUniqueID());
        }));
        this.targetSelector.a(3, new PathfinderGoalNearestAttackableTarget<>(this, IGolem.class, 20, true, false, golem -> ((IGolem)golem).getTeam() != team));
        this.targetSelector.a(4, new PathfinderGoalNearestAttackableTarget<>(this, Silverfish.class, 20, true, false, sf -> ((Silverfish)sf).getTeam() != team));
    }

    public ITeam getTeam() {
        return team;
    }

    public static LivingEntity spawn(Location loc, ITeam bedWarsTeam, double speed, double health, int despawn) {
        WorldServer mcWorld = ((CraftWorld) loc.getWorld()).getHandle();
        IGolem customEnt = new IGolem(EntityTypes.IRON_GOLEM, mcWorld, bedWarsTeam);
        customEnt.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        ((CraftLivingEntity) customEnt.getBukkitEntity()).setRemoveWhenFarAway(false);
        customEnt.setCustomNameVisible(true);
        customEnt.setPersistent();
        customEnt.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(health);
        customEnt.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(speed);
        mcWorld.addEntity(customEnt, CreatureSpawnEvent.SpawnReason.CUSTOM);
        customEnt.getBukkitEntity().setCustomName(Language.getDefaultLanguage().m(Messages.SHOP_UTILITY_NPC_IRON_GOLEM_NAME)
                .replace("{despawn}", String.valueOf(despawn)
                        .replace("{health}", StringUtils.repeat(Language.getDefaultLanguage().m(Messages.FORMATTING_DESPAWNABLE_UTILITY_NPC_HEALTH) + " ", 10))
                        .replace("{TeamColor}", bedWarsTeam.getColor().chat().toString())));
        return (LivingEntity) customEnt.getBukkitEntity();
    }

    @Override
    public void die() {
        super.die();
        team = null;
        VersionCommon.api.getVersionSupport().getDespawnablesList().remove(this.getUniqueID());
    }

    @Override
    public void die(DamageSource damagesource) {
        super.die(damagesource);
        team = null;
        VersionCommon.api.getVersionSupport().getDespawnablesList().remove(this.getUniqueID());
    }
}

