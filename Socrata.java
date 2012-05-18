/**
 * Created by IntelliJ IDEA.
 * User: Balaji
 * Date: 5/5/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */

/*
Allow the user to enter two times of the format “[H]H:MM AM”. Mentally picture these times on two analog clocks, each
having an hour hand and a minute hand. Without using any built-in date or time routines, calculate the number of degrees
the minute hand on the first clock must travel in order to have the second clock show the exact same time as the first
clock. Assume that when you move the minute hand, the hour hand moves automatically. The minute hand may only move in
the clockwise direction. You may assume that the minute hand always ends up on a perfect minute boundary.

**** Not using any of the time utils in java. ****
 */
public class Socrata {

    public static void main(String[] args){
        String time1, time2;
        int hh1, hh2, mm1, mm2;
        float out;
        String timeRegex = "([0]?[1-9]|1[012]):[0-5][0-9] ?(AM|PM)";

        if(args.length != 4){
            System.out.println("Not enough parameters. Please enter time in the 12 hour format [H]H:MM AM/PM");
            System.exit(1);
        }
        time1 = args[0]+" "+args[1].toUpperCase();
        time2 = args[2]+" "+args[3].toUpperCase();
        System.out.println(time1 + " " + time2);

        if(!time1.matches(timeRegex) || !time2.matches(timeRegex) ){
            System.out.println("Incorrect input format. Please enter time in the 12 hour format [H]H:MM AM/PM");
            System.exit(1);
        }

        hh1 = Integer.parseInt(args[0].split(":")[0]);
        mm1 = Integer.parseInt(args[0].split(":")[1]);
        hh2 = Integer.parseInt(args[2].split(":")[0]);
        mm2 = Integer.parseInt(args[2].split(":")[1]);

        // computation becomes easier if we convert the time to 24 hour format
        if("PM".equalsIgnoreCase(args[1])){
            hh1 = hh1 == 12 ? hh1 : hh1 + 12;
        }
        else {
            hh1 = hh1 == 12 ? 0 : hh1;
        }
        if("PM".equalsIgnoreCase(args[3])){
            hh2 = hh2 == 12 ? hh2 : hh2 + 12;
        }
        else {
            hh2 = hh2 == 12 ? 0 : hh2;
        }

        out = hh2 - hh1 + (float)(mm2-mm1)/60;
        if(out < 0)
            out = 24 + out;

        System.out.println("No of rotations: "+out);
        System.out.println("Degrees: "+out*360);
    }
}

