package org.example

import org.example.com.builder.NoteBookBuilder
import org.example.com.builder.PCBuilder
import org.example.com.product.Director
import org.example.com.product.NoteBook
import org.example.com.product.PC

fun client(director: Director, series: String = "New Computer") {
    val noteBookBuilder = NoteBookBuilder()

    val computer = PCBuilder()
    println("------Create NotebookGaming------")
    director.makeComputerGaming(computer, series)
    val noteBook: NoteBook = noteBookBuilder.getProduct()
    noteBook.show()

    val com : PC = computer.getProduct()
    com.show()
}

fun main() {
    val direct = Director()
    client(direct, "AcerNitro v15")

    println("------Create PC ------")
    val computerPCBuilder = PCBuilder()
    direct.makeComputerWithOutTouchpad(computerPCBuilder,"New")
    val computerPC : PC = computerPCBuilder.getProduct()
    computerPC.show()

    println("------Create PC Gaming------")
    val pcBuilder = PCBuilder()
    pcBuilder.setSeries("Tuff PC Gaming")
    pcBuilder.installMainboard()
    pcBuilder.installCPU("AMD Ryzen 7 5600x")
    pcBuilder.installGPU("RTX4080Ti")
    pcBuilder.installRAM("32GB DDR5")
    pcBuilder.installSSD(1024)
    val pc: PC = pcBuilder.getProduct()
    pc.show()

}