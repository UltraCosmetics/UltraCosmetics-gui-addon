<!-- markdownlint-disable-next-line -->
![Logo](.github/ASSETS/logo.png)

[![Version](https://img.shields.io/spiget/version/117279?label=version)][spigotmc-link]
[![Discord](https://img.shields.io/discord/185055040036143104?color=404eed&label=Discord&logo=discord&logoColor=ffffff)][discord-invite]
[![View on SpigotMC](https://img.shields.io/badge/view%20on-SpigotMC-orange.svg)][spigotmc-link]
[![Downloads](https://img.shields.io/spiget/downloads/117279?color=blue)][spigotmc-link]

# UltraCosmetics GUI Addon

UltraCosmetics GUI Addon is an addon for [UltraCosmetics](https://github.com/datatags/UltraCosmetics) that customizes the main and purchase menus with custom textures.
Thanks to @dennishzg for creating the resource pack!
- Aseprite source files are in `/aseprite/`.
- Resource pack/GUI textures are in `/resourcepack/`.
- Plugin files are in `/src/`.

---

## 🖼️ Preview

### Main menu

![Main menu](.github/readme-assets/preview-bg_main.png)

### Buy menu (keys, cosmetics etc.)

![Buy menu](.github/readme-assets/preview-bg_buy.png)

## 🛠️ How to use

### Add server resource pack

By default, once the plugin is installed, it will suggest to clients to install the resource pack.
Alternatively, you can disable that in the config and distribute the resource pack yourself; it can be downloaded in the Releases tab.

### Create menu

If you have a custom menu for UC, you can also use these textures there. Example menu using DeluxeMenus:

#### GUI texture

- 🏠 = Main menu texture
- 🪙 = Buy menu texture

```yaml
size: 54
menu_title: "&f🎲🎲🎲🎲🎲🎲🎲🎲🏠"
```

#### Custom items

Example:

```
/minecraft:give @p minecraft:brick[minecraft:item_model="ucgui:uc_items/key"]
```

| Image         | Item model                 | Description                                                                   |
|---------------|----------------------------|-------------------------------------------------------------------------------|
| invisible     | `ucgui:guis/invisibleitem` | Invisible items are necessary to make the buttons/icons in the GUI clickable. |
| ![Key][p-key] | `ucgui:uc_items/key`       | Treasure chest key                                                            |

## ✅ Compatibility

UltraCosmetics GUI Addon officially supports both **Spigot** and **Paper**.

The resource pack is designed for clients 1.21.4 and up.

## 📥 Download

You can download the latest stable release of UltraCosmetics GUI Addon from our official links:

- [SpigotMC][spigotmc-link]
- [GitHub][github-releases-link]

## 🐛 Report a Bug

Please use the [Issues](https://github.com/UltraCosmetics/UltraCosmetics-gui-addon/issues) on GitHub to report a bug.

When creating an issue, please make sure you're using the bug report issue template!

## ❓ Support

For questions and support please visit our [Discord][discord-invite].
The Issues page of this repository is **exclusively** for bug reports and feature requests.

## 💻 Development

[![CI Status](https://github.com/UltraCosmetics/UltraCosmetics-gui-addon/actions/workflows/gradle.yml/badge.svg)](https://github.com/UltraCosmetics/UltraCosmetics/actions/workflows/gradle.yml)
[![CodeQL Status](https://github.com/UltraCosmetics/UltraCosmetics-gui-addon/actions/workflows/codeql.yml/badge.svg)](https://github.com/UltraCosmetics/UltraCosmetics/actions/workflows/codeql.yml)

## 📄 License

[GNU Affero General Public License v3.0](./LICENSE)

```text
UltraCosmetics - Lightweight, Fun and Easy-to-Use Spigot Cosmetics plugin.
Copyright (C) 2025 Datatags

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
```

[discord-invite]: https://discord.gg/PgSXZT37JV
[spigotmc-link]: https://www.spigotmc.org/resources/117279
[github-releases-link]: https://github.com/UltraCosmetics/UltraCosmetics-gui-addon/releases
[p-key]: .github/readme-assets/preview-key.png
