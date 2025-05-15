import { prisma } from "../lib/prisma"
import { RegisterParams } from "../types/line-user"

export abstract class LineUserService {
  
    static async register(request: RegisterParams) {
        const existingUser = await prisma.lineUser.findUnique({
          where: {
            uuid: request.uuid,
          },
        })
    
        if (existingUser) {
          return { message: 'User already exists' }
        }
        return await prisma.lineUser.create({
          data: {
            uuid: request.uuid,
            nickName: request.nickName,
            imageUrl: request.imageUrl,
          },
        })
      }

      static async getUserByUuid(uuid: string) {
        return await prisma.lineUser.findUnique({
          where: {
            uuid,
          },  
      })}

      static async deleteUserByUuid(uuid: string) {
        return await prisma.lineUser.delete({
          where: {
            uuid,
          },
        })
      }
  }