import concrete.LogBattle
import concrete.Party
import concrete.ServerNotificationSystem
import player.Player
import player.RolePlayer
import publisher.DungeonPublisher

fun dungeonRaid(server: ServerNotificationSystem, party: Party, log: LogBattle, dungeon: DungeonPublisher) {
    dungeon.subscribe(party)
    dungeon.subscribe(server)
    dungeon.subscribe(log)
    server.setParty(party)
    dungeon.bossDefeated()
}

fun main() {
    val player1 = Player("Arthur", RolePlayer.WARRIOR, 20)
    val player2 = Player("Elina", RolePlayer.ARCHER, 18)
    val player3 = Player("Merlin", RolePlayer.MAGE, 30)

    val newParty = Party(mutableListOf(player1, player2, player3), "LnwZa007")
    val server = ServerNotificationSystem()
    val log = LogBattle("Dungeon")

    val dungeon = DungeonPublisher()

    dungeon.setBoss("Dark Lord")

    dungeonRaid(server, newParty, log, dungeon)
}