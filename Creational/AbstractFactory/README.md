#🧩 AbstractFactory

**AbstractFactory**  
- เป็น Creational Design Pattern ที่ใช้สร้างกลุ่มของวัตถุ (Objects) ที่เกี่ยวข้องกันโดยไม่ต้องระบุ class ที่ใช้งานจริง (Concrete Class)
---
**แนวคิด**
- เรามีรถยนต์หลายยี่ห้อ เช่น Toyota, Honda, Hyundai และแต่ละยี่ห้อสามารถผลิตรถได้หลายประเภท เช่น
รถไฟฟ้า (EV)
รถดีเซล (Diesel)
รถ Hybrid (EV + Diesel)
ปัญหาที่เกิดขึ้นเมื่อไม่ใช้ Design Pattern คือ
โค้ดจะซ้ำซ้อน เพราะต้องสร้างคลาสแยกกันสำหรับทุกยี่ห้อและทุกประเภทของรถ
ยากต่อการดูแลหรือขยายระบบ เช่น ถ้าต้องเพิ่มยี่ห้อใหม่หรือประเภทพลังงานใหม่ ต้องไปแก้หลายไฟล์
มีการผูก logic เข้ากับ class จริง (Concrete Class) มากเกินไป ทำให้ยากต่อการเปลี่ยนหรือทดสอบ
ทางแก้คือ ใช้ Abstract Factory Pattern เพื่อ
แยกการสร้างวัตถุของรถแต่ละประเภทออกจากระบบหลัก
ลดการเขียนซ้ำ และทำให้รองรับการเพิ่มยี่ห้อหรือพลังงานใหม่ๆ ได้ง่าย
ทำให้โค้ดมีความยืดหยุ่นสูง สามารถเปลี่ยนประเภทหรือยี่ห้อของรถได้โดยไม่ต้องแก้หลายจุดในระบบ

---
## 📈 Diagram

![Factory Method Diagram](./factory-method-diagram.jpg)

## องค์ประกอบหลักของ Abstract Factory Pattern

Abstract Factory (โรงงานนามธรรม)
- คือ interface หรือ abstract class ที่กำหนดเมธอดสำหรับสร้างผลิตภัณฑ์แต่ละประเภท
```kotlin
abstract class CarFactory(private var brand: String, private var name: String) {
    abstract fun createHonda(): Honda
    abstract fun createToyota(): Toyota
    abstract fun createHyundai(): Hyundai
}
```

Concrete Factory (โรงงานยี่ห้อเฉพาะ)
- คือ class จริงที่สืบทอด (implement) จาก Abstract Factory เพื่อสร้างผลิตภัณฑ์ของแต่ละยี่ห้อ
```kotlin
class EVFactory(private val brand: String, private val name: String) : CarFactory(brand, name) {

    override fun createHonda(): Honda {
        return HondaEV()
    }

    override fun createHyundai(): Hyundai {
        return HyundaiEV()
    }

    override fun createToyota(): Toyota {
        return ToyotaEV()
    }
}
```

Abstract Product (ผลิตภัณฑ์นามธรรม)
- คือ interface หรือ abstract class ของวัตถุแต่ละประเภทที่โรงงานจะผลิต
```kotlin
interface Honda {
    fun installEngine()
    fun createCar()
}
```


 Concrete Product (ผลิตภัณฑ์จริง)
- คือ class จริงที่สืบทอดจาก Abstract Product ซึ่งถูกสร้างขึ้นโดย Concrete Factory
```kotlin
class HondaEV : Honda {

    override fun installEngine() {
        println("Install Engine EV")
    }

    override fun createCar() {
        println("Crate Honda EV success!!")
    }
}
```
implement
```kotlin
fun saleCar(fac: CarFactory) {
    when (fac.getBrand().lowercase()) {
        "honda" -> {
            val car: Honda = fac.createHonda()
            fac.show()
            car.installEngine()
            car.createCar()
        }

        "toyota" -> {
            val car: Toyota = fac.createToyota()
            fac.show()
            car.installEngine()
            car.createCar()
        }

        "hyundai" -> {
            val car: Hyundai = fac.createHyundai()
            fac.show()
            car.installEngine()
            car.createCar()
        }
        else -> {
            println("No preferred brand!")
        }
    }
}


fun main() {
    println("Brand Car : Toyota, Honda, Hyundai")
    println("------Sale Toyota EV------")
    var car: CarFactory = EVFactory("Toyota", "Toyota Cross")
    saleCar(car)
    println("------Sale Honda Hybrid------")
    car = HybridFactory("Honda", "Accord Hybrid")
    saleCar(car)
    println("------Sale Hyundai Diesel------")
    car = DieselFactory("Hyundai","H1")
    saleCar(car)
}
```

