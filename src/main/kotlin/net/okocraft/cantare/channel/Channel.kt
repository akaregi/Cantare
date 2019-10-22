package net.okocraft.cantare.channel

import org.bukkit.entity.Player

abstract class Channel {
    /**
     * このチャンネルの名前
     */
    var name = ""

    /**
     * このチャンネルの代替名
     */
    var alias = ""

    /**
     * このチャンネルの説明
     */
    var description = ""

    /**
     * このチャンネルに属するプレイヤー
     */
    private val members: MutableSet<Player> = mutableSetOf()

    /**
     * このチャンネルを管理するプレイヤー
     */
    private val moderators: MutableSet<Player> = mutableSetOf()

    /**
     * このチャンネルから追放されたプレイヤー
     */
    private val banned: MutableSet<Player> = mutableSetOf()

    /**
     * このチャンネルにメンバーを追加する
     *
     * @param player プレイヤー
     */
    fun addMember(player: Player) = members.add(player)

    /**
     * このチャンネルからメンバーを削除する
     *
     * @param player プレイヤー
     */
    fun removeMember(player: Player) = members.remove(player)

    /**
     * このチャンネルにモデレータを追加する
     *
     * @param player プレイヤー
     */
    fun addModerator(player: Player) = moderators.add(player)

    /**
     * このチャンネルからモデレータを削除する
     *
     * @param player プレイヤー
     */
    fun removeModerator(player: Player) = moderators.remove(player)

    /**
     * このチャンネルからプレイヤーを追放する
     *
     * @param player プレイヤー
     */
    fun ban(player: Player) = banned.add(player)

    /**
     * 追放したプレイヤーを再び入れるようにする
     *
     * @param player プレイヤー
     */
    fun unban(player: Player) = banned.remove(player)

    /**
     * このチャンネルにチャットする
     *
     * @param player  発信元プレイヤー
     * @param message メッセージ
     */
    abstract fun chat(player: Player, message: String)
}