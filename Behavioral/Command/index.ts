import AttackCommand from "./ConcreteCommands/AttackCommand";
import BuildUnitCommand from "./ConcreteCommands/BuildUnitCommand";
import DefendCommand from "./ConcreteCommands/DefendCommand";
import MoveCommand from "./ConcreteCommands/MoveCommand";
import StopCommand from "./ConcreteCommands/StopCommand";
import CommandManager from "./Invoker/CommandManager";
import Unit from "./Receiver/Unit";

const soldier = new Unit("Soldier", { x: 0, y: 0 });
const enemy = new Unit("Enemy", { x: 10, y: 10 });

const moveToEnemy = new MoveCommand(soldier, 10, 10);
const attackEnemy = new AttackCommand(soldier, enemy);
const defendCommand = new DefendCommand(soldier);
const stopCommand = new StopCommand(soldier);
const buildUnit = new BuildUnitCommand("Archer", { x: 5, y: 5 });

const gameManager = new CommandManager();

// ✅ คำสั่งที่ทำได้
gameManager.executeCommand(moveToEnemy);
gameManager.executeCommand(attackEnemy);
gameManager.executeCommand(defendCommand);
gameManager.executeCommand(stopCommand);
gameManager.executeCommand(buildUnit);

// 🔄 Undo คำสั่งล่าสุด
gameManager.undoLastCommand();
gameManager.undoLastCommand();
