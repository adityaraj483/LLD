package ParkingLotLLD.Enum;

public enum Command {
    create_parking_lot("create_parking_lot"),
    park_vehicle("park_vehicle"),
    unpark_vehicle("unpark_vehicle"),
    display("display"),
    free_count("free_count"),
    free_slots("free_slots"),
    exit("exit"),
    occupied_slots("occupied_slots");

    public final String cmd;
    Command(String cmd){
        this.cmd = cmd;
    }
    public static Command getCommand(String cmdType){
        for(Command command : Command.values()){
            if(command.cmd.equalsIgnoreCase(cmdType))
                return command;
        }
        return null;
    }
}
