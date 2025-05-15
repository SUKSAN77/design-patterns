package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

abstract class Skill : SkillHandler {
    protected abstract fun process(player: Player, skill: SkillData): Boolean

    private var nextHandle: SkillHandler? = null

    override fun setNext(skill: SkillHandler): SkillHandler {
        this.nextHandle = skill
        return skill
    }

    override fun handle(player: Player, skillData: SkillData): Boolean {
        return if (process(player, skillData)) {
            nextHandle?.handle(player, skillData) ?: true
        } else {
            false
        }
    }
}
// process(player, skillStatus)
// เมธอด process เป็นเมธอดที่ตรวจสอบเงื่อนไขบางอย่าง (เช่น ตรวจสอบว่า Player มี Mana เพียงพอหรือไม่, Skill ยังไม่อยู่ใน Cooldown, ฯลฯ)
// หาก process ส่งกลับค่า true แสดงว่าเงื่อนไขผ่าน และจะดำเนินการในบล็อก if
// หาก process ส่งกลับค่า false แสดงว่าเงื่อนไขไม่ผ่าน และจะส่งกลับค่า false จากเมธอด handle ทันที
// nextHandle?.handle(player, skillStatus) คือการเรียกเมธอด handle บน nextHandle (ถ้ามี) โดยส่ง player และ skillStatus เข้าไป
// หาก nextHandle ไม่เป็น null ค่าที่ส่งกลับจาก nextHandle.handle(player, skillStatus) จะถูกใช้เป็นผลลัพธ์
// หาก nextHandle เป็น null จะใช้ค่า true แทน (เนื่องจาก ?: true เป็น Elvis operator ที่กำหนดค่า default เป็น true)
// ในกรณีที่ nextHandle เป็น null แล้วใช้ ?: true แทนการคืนค่า false มีเหตุผลหลัก ๆ ดังนี้:
// ให้การประมวลผลสำเร็จถ้าไม่มีเงื่อนไขเพิ่มเติม
// เมื่อ nextHandle เป็น null หมายความว่าถึงจุดสิ้นสุดของ Chain-of-Responsibility แล้ว
// หากถึงจุดสิ้นสุดและไม่มีปัญหา (เช่น ไม่มีเงื่อนไขอื่นที่ต้องตรวจสอบต่อ) ก็ถือว่าการใช้สกิลสำเร็จ ดังนั้นคืนค่า true
// ป้องกันการหยุดทำงานโดยไม่จำเป็น
// ถ้า process(player, skillData) คืนค่า true แสดงว่าผ่านเงื่อนไขของสกิลปัจจุบัน
// จากนั้นถ้าไม่มี nextHandle แล้วคืนค่า false จะทำให้การเรียกใช้สกิลล้มเหลว ทั้งที่จริง ๆ แล้วเงื่อนไขผ่านหมด