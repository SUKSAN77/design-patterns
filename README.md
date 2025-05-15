# 🎓 Design Patterns

**Design Patterns** (รูปแบบการออกแบบซอฟต์แวร์) คือ แนวทางแก้ปัญหาที่เกิดขึ้นซ้ำ ๆ ในการออกแบบโปรแกรม โดยเป็นแนวทางที่ได้รับการพิสูจน์แล้วว่ามีประสิทธิภาพ ช่วยให้นักพัฒนาสามารถสร้างระบบที่ **มีโครงสร้างดี ยืดหยุ่น และดูแลรักษาง่าย**

---

## 🧱 ประเภทของ Design Patterns

### 🔨 Creational Patterns  
> มุ่งเน้นที่กระบวนการสร้างอ็อบเจกต์ให้มีความยืดหยุ่นและลดการผูกติดของโค้ดกับคลาสที่ใช้งานโดยตรง

- [Factory Method](/Creational/FactoryMethod/) - สร้างอ็อบเจกต์ผ่านเมธอดแทนการใช้ `new` โดยตรง
- [Abstract Factory](/Creational/AbstractFactory/) - สร้างชุดของอ็อบเจกต์ที่เกี่ยวข้องกันโดยไม่ผูกติดกับคลาสคอนกรีต
- [Builder](/Creational/Builder) - แยกกระบวนการสร้างอ็อบเจกต์ที่ซับซ้อนออกเป็นหลายขั้นตอน
- [Prototype](/Creational/Prototype/) - สร้างอ็อบเจกต์ใหม่โดยการ clone จากอ็อบเจกต์ต้นแบบ
- [Singleton](/Creational/Singleton/) - จำกัดการสร้างอ็อบเจกต์ให้มีเพียงหนึ่ง instance เท่านั้น

---

### 🧩 Structural Patterns  
> จัดการกับโครงสร้างของคลาสและอ็อบเจกต์ เพื่อให้สามารถประกอบเข้ากันได้ง่ายและยืดหยุ่น

- [Adapter](/Structural/Adapter/) - แปลงอินเทอร์เฟซของคลาสหนึ่งให้เข้ากับอีกอินเทอร์เฟซที่คาดหวัง
- [Bridge](/Structural/Bridge/) - แยกส่วน abstraction และ implementation ออกจากกันเพื่อให้พัฒนาแยกได้
- [Composite](/Structural/Composite/) - จัดกลุ่มวัตถุให้มีโครงสร้างเป็นต้นไม้ ใช้การทำงานในลักษณะเดียวกันทั้ง object เดี่ยวและกลุ่ม
- [Decorator](/Structural/Decorator/) - เพิ่มความสามารถให้กับอ็อบเจกต์โดยไม่เปลี่ยนโครงสร้างเดิม
- [Facade](/Structural/Facade/) - ซ่อนความซับซ้อนของระบบไว้หลังอินเทอร์เฟซที่ง่ายต่อการใช้งาน
- [Flyweight](/Structural/Flyweight/) - ลดการใช้หน่วยความจำด้วยการใช้ object ร่วมกัน
- [Proxy](/Structural/Proxy/) - ใช้อ็อบเจกต์ตัวแทนควบคุมการเข้าถึงอ็อบเจกต์จริง

---

### 🔄 Behavioral Patterns  
> มุ่งเน้นที่พฤติกรรมการสื่อสารและความรับผิดชอบระหว่างอ็อบเจกต์

- [Chain of Responsibility](/Behavioral/ChainOfResponsibility/) - ส่งคำขอผ่านสายของ handler จนกว่าจะมีตัวใดตัวหนึ่งรับผิดชอบ
- [Command](/Behavioral/Command/) - แยกคำสั่งออกจาก object ที่เรียกใช้ เพื่อรองรับ queue, undo, logging
- [Iterator](/Behavioral/Iterator/) - เข้าถึง element ของ collection โดยไม่เปิดเผยโครงสร้างภายใน
- [Mediator](/Bbehavioral/Mediator/) - ควบคุมการสื่อสารระหว่างอ็อบเจกต์โดยผ่านตัวกลาง (Mediator)
- [Memento](/Behavioral/Memento/) - เก็บสถานะของอ็อบเจกต์เพื่อให้สามารถย้อนกลับได้โดยไม่ละเมิด encapsulation
- [Observer](/Behavioral/Observer/) - กระจายการเปลี่ยนแปลงสถานะไปยังอ็อบเจกต์ที่เกี่ยวข้อง
- [State](/Behavioral/State/) - เปลี่ยนพฤติกรรมของอ็อบเจกต์เมื่อสถานะภายในเปลี่ยนไป
- [Strategy](/Behavioral/Strategy/) - สลับพฤติกรรม (algorithm) ได้ขณะรันไทม์ โดยไม่ต้องแก้โค้ดหลัก
- [Template Method](/behavioral/TemplateMethod/) - กำหนดโครงสร้างของอัลกอริธึมไว้ใน superclass แต่ปล่อยให้ subclass กำหนดรายละเอียด
- [Visitor](/Behavioral/Visitor/) - เพิ่มพฤติกรรมใหม่ให้กับ object โดยไม่เปลี่ยน class ของมัน

---

## 📚 Reference

- [Refactoring Guru – Design Patterns](https://refactoring.guru/design-patterns)
