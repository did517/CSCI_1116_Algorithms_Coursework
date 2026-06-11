import java.util.Scanner;
public class Exercise08_37 {
public static void main(String[] args) {
String[][] stateCapital = {
{"Alabama", "Montgomery"},
{"Alaska", "Juneau"},
{"Arizona", "Phoenix"},
{"Arkansas", "Little Rock"},
{"California", "Sacramento"},
{"Colorado", "Denver"},
{"Connecticut", "Hartford"},
{"Delaware", "Dover"},
{"Florida", "Tallahassee"},
{"Georgia", "Atlanta"},
{"Hawaii", "Honolulu"},
{"Idaho", "Boise"},
{"Illinois", "Springfield"},
{"Indiana", "Indianapolis"},
{"Iowa", "Des Moines"},
{"Kansas", "Topeka"},
{"Kentucky", "Frankfort"},
{"Louisiana", "Baton Rouge"},
{"Maine", "Augusta"},
{"Maryland", "Annapolis"},
{"Massachusettes", "Boston"},
{"Michigan", "Lansing"},
{"Minnesota", "Saint Paul"},
{"Mississippi", "Jackson"},
{"Missouri", "Jefferson City"},
{"Montana", "Helena"},
{"Nebraska", "Lincoln"},
{"Nevada", "Carson City"},
{"New Hampshire", "Concord"},
{"New Jersey", "Trenton"},
{"New York", "Albany"},
{"New Mexico", "Santa Fe"},
{"North Carolina", "Raleigh"},
{"North Dakota", "Bismarck"},
{"Ohio", "Columbus"},
{"Oklahoma", "Oklahoma City"},
{"Oregon", "Salem"},
{"Pennsylvania", "Harrisburg"},
{"Rhode Island", "Providence"},
{"South Carolina", "Columbia"},
{"South Dakota", "Pierre"},
{"Tennessee", "Nashville"},
{"Texas", "Austin"},
{"Utah", "Salt Lake City"},
{"Vermont", "Montpelier"},
{"Virginia", "Richmond"},
{"Washington", "Olympia"},
{"West Virginia", "Charleston"},
{"Wisconsin", "Madison"},
{"Wyoming", "Cheyenne"}
};
Scanner input = new Scanner(System.in);
System.out.println("Enter a state: ");
String state =input.nextLine();
boolean found = false;
for (int i = 0; i < stateCapital.length; i++){
    if (stateCapital[i][0].equalsIgnoreCase(state)){
        System.out.println("The capital of" + stateCapital[i][0] + "is" + stateCapital[i][1]);
        found = true;
        break;
    }
}
if (! found){
    System.out.println("state not found");
}
input.close();
}
}


