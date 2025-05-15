package concrete

import player.Player

class Party(private var partyPlayer: MutableList<Player>, private var partyName: String) : Observer {

    override lateinit var messageFromPublisher: String

    override fun update(message: String) {
        this.messageFromPublisher = message
        showMessages()
    }

    fun getPlayerParty() {
        return this.partyPlayer.forEach { it.showDetailPlayer() }
    }

    fun getPlayer(index: Int): Player {
        return this.partyPlayer[index]
    }

    fun getPartyName(): String {
        return this.partyName
    }

    private fun showMessages() {
        println("\n====================================")
        println("🏰 Party Name: $partyName")
        if (messageFromPublisher.isNotBlank()) {
            partyPlayer.forEach {
                println("${it.getName()} => Receive Notification")
                println(messageFromPublisher)
            }
        } else {
            println("ℹ️ No new messages for this party.")
        }
        println("====================================")
    }
}