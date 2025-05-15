import Command from "../interface/Command";

class CommandManager {
    private history: Command[] = [];
  
    executeCommand(command: Command) {
      command.execute();
      this.history.push(command);
    }
  
    undoLastCommand() {
      const lastCommand = this.history.pop();
      if (lastCommand) {
        lastCommand.undo();
      } else {
        console.log("No commands to undo.");
      }
    }
  }
  
export default CommandManager;