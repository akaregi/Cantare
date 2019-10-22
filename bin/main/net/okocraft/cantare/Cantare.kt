package net.okocraft.cantare

import org.bukkit.event.HandlerList
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

import net.okocraft.cantare.listener.ChatListener

class Cantare : JavaPlugin() {
    private val pm: PluginManager = server.pluginManager

    override fun onEnable() {
        registerEvents()
    }

    override fun onDisable() {
        unregisterEvents()
    }

    private fun registerEvents() {
        unregisterEvents()

        pm.registerEvents(ChatListener(), this)
    }

    private fun unregisterEvents() = HandlerList.unregisterAll(this)
}