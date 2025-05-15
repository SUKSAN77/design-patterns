import PrismaProxy from "./Service/PrismaProxy";

const dbProxy = PrismaProxy.getInstance();

const createUser = async () => {
    await dbProxy.addUser("Alice", "alice@example.com");
    await dbProxy.addUser("Bob", "bob@example.com");
}

const testGetUsers = async () => {
    const users = await dbProxy.getUsers();
    console.log("Users:", users);
}

const testGetUserByEmail = async () => {
    const user = await dbProxy.getUserByEmail("alice@example.com");
    console.log("User:", user);
}

const clearUsers = async () => {
    await dbProxy.deleteUserByEmail("alice@example.com");
    await dbProxy.deleteUserByEmail("bob@example.com");
}
  

const main = () => {
    createUser().then(() => {
        testGetUsers().then(() => {
            dbProxy.close();
        })
    })

    // testGetUserByEmail()
    // clearUsers()
    
}

main()