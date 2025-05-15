# Factory Method

**Factory Method**  เป็นหนึ่งใน Creational Design Patterns ที่ใช้เพื่อสร้างอ็อบเจกต์ โดยไม่ผูกโค้ดเข้ากับคลาสคอนกรีตโดยตรง ผมได้ยกตัวอย่างการสร้าง มอนเตอร์ จากเกม Minecarft

---

## องค์ประกอบหลักของ Factory Method Pattern

Product (Interface/Abstract Class) 

- ทำหน้าที่เป็นสัญญา (Contract) ให้กับอ็อบเจกต์ทั้งหมดที่ถูกสร้างโดย 
- เป็นคลาสฐานที่กำหนดพฤติกรรมร่วมของอ็อบเจกต์ที่ถูกสร้าง ในตัวอย่างใช้ (BaseMonster)

ConcreteProduct 
- คลาสจริงที่ implement หรือสืบทอดจาก Product
- มีพฤติกรรมเฉพาะของตัวเองก็คือการสร้าง Piglin, Zombie, EnderDragon

Creator (Abstract Class หรือ Interface)
- ประกาศเมธอด factoryMethod() ซึ่ง return Product
- อาจมีเมธอดอื่น ๆ ที่ใช้ factoryMethod() ภายในเพื่อหลีกเลี่ยงการผูกกับคลาสคอนกรีต
- บางครั้งเรียกว่า Factory
- ในที่นี้เรากำหนดเป็น Monster โดยมีเมธอด spawnMonster() ที่จะเป็น factoryMethod() ในการ return BaseMonster หรือ Product ออกมา

ConcreteCreator
- เป็นคลาสที่สืบทอดจาก Creator
- Override เมธอด factoryMethod() เพื่อคืนค่าเป็น ConcreteProduct ที่เหมาะสม
- ตัวอย่างคลาส spawnZombie เรีกยใช้ spawnMonster() ก็ได้จะ Zombie ที่เป็น ConcreteProduct
- ผู้ใช้จะเรียกใช้ ConcreteCreator โดยไม่รู้ว่าอ็อบเจกต์จริงคืออะไร

![Factory Method Diagram](factory-method-diagram.png)
