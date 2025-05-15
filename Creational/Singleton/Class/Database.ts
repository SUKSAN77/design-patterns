import mysql, { Pool } from "mysql2/promise";

export class Database {
  private static instance: Database;
  private connection: any;

  private constructor() {
    this.connection = mysql.createPool({
      host: "your_localhost",
      user: "your_user",
      password: "your_password",
      database: "your_database",
      port: 3306,
    });
  }

  public static getInstance(): Database {
    if (!Database.instance) {
      Database.instance = new Database();
    }

    return Database.instance;
  }

  public connect = async () => {
    try {
      await this.connection.getConnection();
      console.log("MySQL connected...");
    } catch (error) {
      console.error("Error connecting to MySQL: ", error);
    }
  };

  public query = async (sql: string, values: any[] = []) => {
    try {
      const [result] = await this.connection.query(sql, values);
      return result;
    } catch (error) {
      console.error("Error executing query: ", error);
    }
  };
}
