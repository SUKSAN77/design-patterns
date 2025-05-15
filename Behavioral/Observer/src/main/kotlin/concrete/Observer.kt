package concrete

interface Observer {
    fun update(message: String)
    var messageFromPublisher :String
}

