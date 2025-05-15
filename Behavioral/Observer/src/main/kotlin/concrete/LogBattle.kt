package concrete

class LogBattle(private val logName: String) : Observer {
    private val battleLogs = mutableListOf<String>()
    override lateinit var messageFromPublisher: String

    override fun update(message: String) {
        this.messageFromPublisher = message
        battleLogs.add("[$logName] $message")
        showLastLog()
    }

    private fun showLastLog() {
        println("===== Battle Logs: $logName Receive Update =====")
        if (battleLogs.isEmpty()) {
            println("No battle logs recorded.")
        } else {
            println("UpdateLog: ${battleLogs.last()}")
        }
        println("=================================")
    }

    fun showLogs() {
        println("===== Battle Logs: $logName =====")
        if (battleLogs.isEmpty()) {
            println("No battle logs recorded.")
        } else {
            battleLogs.forEach { println(it) }
        }
        println("=================================")
    }
}
