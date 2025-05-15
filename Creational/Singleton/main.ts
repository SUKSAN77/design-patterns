import { Database } from "./Class/Database";

function main() {
  
  console.log("Connected to MySQL");

  const db = Database.getInstance();
  
  db.connect();

  const userQuery = () => {
    db.query("SELECT * FROM users")
      .then((result) => {
        console.log(result);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  userQuery();
}

main();
