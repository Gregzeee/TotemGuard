package de.outdev.totemguardv2.settings;

import de.outdev.totemguardv2.TotemGuardV2;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public final class ConfigHandler {

	private String prefix;

	private String checkPrefix;

	private String commandPermission;

	private String checkPermission;

	private String alertPermission;

	private boolean webhookEnabled;

	private String webhookUrl;

	private String webhookName;

	private String webhookColor;

	private String webhookTitle;

	private String webhookDescription;

	private String webhookImage;

	private String webhookProfileImage;

	private boolean webhookTimestampEnabled;

	private boolean extraFlagsEnabled;

	private boolean automaticNormalChecks;

	private int checkTimeMs;

	private int normalCheckTime;

	private boolean advancedSystemCheckEnabled;

	private int triggerAmountMs;

	private boolean damageOnCheckEnabled;

	private int damageAmountOnCheck;

	private double minTps;

	private int maxPing;

	private boolean punishEnabled;

	private int punishAfter;

	private int removeFlagsMin;

	private String punishCommand;

	public static YamlConfiguration configuration;

	public void load() {
		TotemGuardV2 instance = TotemGuardV2.getInstance();

		String path = "config.yml";
		File file = new File(instance.getDataFolder(), path);

		if (!file.exists()) {
			instance.saveResource(path, false);
		}

		configuration = YamlConfiguration.loadConfiguration(file);

		prefix = configuration.getString("prefix");
		checkPrefix = configuration.getString("check_prefix");
		commandPermission = configuration.getString("command_permissions");
		checkPermission = configuration.getString("check_permission");
		alertPermission = configuration.getString("alert_permission");
	}

	// No lombok :(
	public String getPrefix() {
		return prefix;
	}

	public String getCheckPrefix() {
		return checkPrefix;
	}

	public String getCommandPermission() {
		return commandPermission;
	}

	public String getCheckPermission() {
		return checkPermission;
	}

	public String getAlertPermission() {
		return alertPermission;
	}
}
