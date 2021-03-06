package com.benzoft.gravitytubes.files;

public final class MessagesFile extends AbstractFile {

    private static MessagesFile file;

    //General
    private String prefix;
    private String invalidPermission;
    private String noCommands;
    private String playerOnly;
    private String invalidArguments;

    //Normal
    private String tubeCreated;
    private String tubeRemoved;
    private String cantCreate;
    private String noTube;
    private String settingReset;
    private String settingSet;

    //Admin
    private String configReload;
    private String unsafeTeleport;

    private MessagesFile() {
        super("messages.yml");
        setDefaults();
    }

    @Override
    public void setDefaults() {
        setHeader(
                "This is the Message file for all Gravity Tubes messages.",
                "",
                "All messages are fully customizable and support color codes, formatting and ASCII symbols.",
                "Set the Prefix and use %prefix% to add the corresponding prefix to a message.",
                "Leave a message blank ('') to disable it.",
                "",
                "You can also create messages with Hover and Click events. Syntax options: (Space between comma and quote is NOT allowed)",
                " - [\"Message\",\"/Command\"]",
                " - [\"Message\",\"Hover\"]",
                " - [\"Message\",\"/Command\",\"Hover\"]",
                " - [\"Message\",\"/Command\",\"Suggest\"]",
                " - [\"Message\",\"/Command\",\"Hover\",\"Suggest\"]",
                "You can add as many events to a message as you want. Example:",
                "'%prefix% &cInvalid arguments! [\"&c&n&oHelp\",\"/gravitytubes help\",\"&aClick to get help!\"]'",
                "The \"Suggest\" tag is used if the click event should suggest the command. Default is Run.",
                "");

        prefix = (String) add("Prefix", "&7[&eGravity Tubes&7]");
        invalidPermission = (String) add("Messages.General.InvalidPermission", "%prefix% &cYou do not have permission to do this!");
        noCommands = (String) add("Messages.General.NoCommands", "Unknown command. Type \"/help\" for help.");
        playerOnly = (String) add("Messages.General.PlayerOnly", "%prefix% &cCommand can only be used as a Player!");
        invalidArguments = (String) add("Messages.General.InvalidArguments", "%prefix% &cInvalid arguments! [\"&c&n&oHelp\",\"/gravitytubes help\",\"&aClick to get help!\"]");

        tubeCreated = (String) add("Messages.GravityTubes.TubeCreated", "%prefix% &aGravity tube created!");
        tubeRemoved = (String) add("Messages.GravityTubes.TubeRemoved", "%prefix% &aGravity tube removed!");
        cantCreate = (String) add("Messages.GravityTubes.CantCreate", "%prefix% &cCan't create a gravity tube here!");
        noTube = (String) add("Messages.GravityTubes.NoTube", "%prefix% &cNo gravity tube found at the targeted location!");
        settingReset = (String) add("Messages.GravityTubes.SettingReset", "%prefix% &aThe setting was set to the default!");
        settingSet = (String) add("Messages.GravityTubes.SettingSet", "%prefix% &aThe setting was successfully set to the specified value!");

        configReload = (String) add("Messages.Admin.ConfigurationsReloaded", "%prefix% &aConfiguration files successfully reloaded!");
        unsafeTeleport = (String) add("Messages.Admin.UnsafeTeleport", "%prefix% &cThere is no safe destination at the gravity tube!");
        save();
    }

    public String getPrefix() {
        return prefix;
    }

    public String getInvalidPermission() {
        return invalidPermission;
    }

    public String getNoCommands() {
        return noCommands;
    }

    public String getPlayerOnly() {
        return playerOnly;
    }

    public String getInvalidArguments() {
        return invalidArguments;
    }

    public String getConfigReload() {
        return configReload;
    }

    public String getCantCreate() {
        return cantCreate;
    }

    public String getNoTube() {
        return noTube;
    }

    public String getSettingReset() {
        return settingReset;
    }

    public String getSettingSet() {
        return settingSet;
    }

    public String getTubeCreated() {
        return tubeCreated;
    }

    public String getTubeRemoved() {
        return tubeRemoved;
    }

    public static MessagesFile getInstance() {
        file = file == null ? new MessagesFile() : file;
        return file;
    }

    public static void reload() {
        file = new MessagesFile();
        file.setDefaults();
    }

    public String getUnsafeTeleport() {
        return unsafeTeleport;
    }
}
