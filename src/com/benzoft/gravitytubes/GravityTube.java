package com.benzoft.gravitytubes;

import com.benzoft.gravitytubes.utils.LocationUtil;
import com.benzoft.gravitytubes.utils.ParticleUtil;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;

import java.util.concurrent.ThreadLocalRandom;

public class GravityTube {

    private final Location source;
    private final ConfigurationSection configurationSection;
    private int height;
    private int power;
    private ParticleUtil.GTParticleColor color;


    public GravityTube(final Location source, final ConfigurationSection configurationSection) {
        this.source = source;
        this.configurationSection = configurationSection;
        height = configurationSection.getInt("height", 256 - source.getBlockY());
        power = configurationSection.getInt("power", 10);
        color = ParticleUtil.getFromColor(configurationSection.getString("color", "white"));
        color = color == null ? ParticleUtil.GTParticleColor.WHITE : color;
    }

    boolean isInTube(final Entity entity) {
        return entity.getLocation().getBlockX() == source.getBlockX() &&
                entity.getLocation().getBlockZ() == source.getBlockZ() &&
                entity.getLocation().getY() >= source.getBlockY() && entity.getLocation().getY() <= source.getBlockY() + height;
    }

    void spawnParticles() {
        for (int y = source.getBlockY(); y < source.getBlockY() + height; y += 2) {
            final double xOffset, zOffset;
            xOffset = ThreadLocalRandom.current().nextDouble(1);
            zOffset = ThreadLocalRandom.current().nextDouble(1);
            if (ThreadLocalRandom.current().nextDouble(1) >= 0.2) //TODO Particle density setting.
                ParticleUtil.spawnParticle(new Location(source.getWorld(), source.getBlockX() + xOffset, y, source.getBlockZ() + zOffset), color);
        }
    }

    public Location getLocation() {
        return source;
    }

    int getPower() {
        return power;
    }

    public void setPower(final int power) {
        this.power = power;
        configurationSection.set("power", power);
    }

    public void setHeight(final int height) {
        this.height = height;
        configurationSection.set("height", height);
    }

    public void setColor(final String color) {
        this.color = ParticleUtil.getFromColor(color);
        configurationSection.set("color", color);
    }

    public String getInfo() {
        return String.join("&r\n",
                "&9&m&l---&e Gravity Tube Info &9&m&l--------",
                " &7- &eLocation: &a" + LocationUtil.locationToString(source),
                " &7- &eHeight: &a" + height,
                " &7- &ePower: &a" + power,
                " &7- &eColor: &a" + color.getName()
        );
    }
}
