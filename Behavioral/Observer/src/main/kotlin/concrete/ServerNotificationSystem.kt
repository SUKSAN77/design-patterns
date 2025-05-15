package concrete


class ServerNotificationSystem : Observer {

    private lateinit var party: Party
    override lateinit var messageFromPublisher: String

    override fun update(message: String) {
        messageFromPublisher = message
        showServerNotification()
    }

    fun setParty(party: Party) {
        this.party = party
    }

    private fun showServerNotification() {
        println("\n====================================")
        if (messageFromPublisher.isNotBlank()) {
            println("Server => Receive Notification")
            println("🏆Server updated: $messageFromPublisher 🎉")
            println("🏅 Party Last KillBoss ${party.getPartyName()}")
            party.getPlayerParty()
        } else {
            println("ℹ️ No new messages for this party.")
        }
        println("====================================")
    }
}