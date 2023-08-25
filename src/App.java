import java.util.HashMap;
import java.util.Scanner;

//todo figure out when to close the resource leaks

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Here are your current applications: ");

        HashMap<String, String> appList = new HashMap<String, String>();

        addInitialApps(appList);

        for (String i : appList.keySet()) {
            System.out.println("Company: " + i + " -- Status: " + appList.get(i));
        }

        boolean validAction = true;

        while (validAction) {

            Scanner whatsNext = new Scanner(System.in);
            System.out.println("Next Action (Add, Remove, Update): ");
            String action = whatsNext.nextLine();

            if (action.toLowerCase().equals("add")) {
                addApps(appList);
            } else if (action.toLowerCase().equals("remove")) {
                removeApps(appList);
            } else if (action.toLowerCase().equals("update")) {
                System.out.println("UPDATE");
            } else {
                validAction = false;
                whatsNext.close();
            }
        }

        printAppList(appList);

    }

    public static void printAppList(HashMap<String, String> appList) {
        System.out.println("---Current Application List---");
        for (String i : appList.keySet()) {
            System.out.println("Company: " + i + " -- Status: " + appList.get(i));
        }
    }

    public static void addInitialApps(HashMap<String, String> appList) {
        appList.put("Thrivent", "2nd Interview");
        appList.put("Dick's Sporting Goods", "Interview");
        appList.put("Royal Bank of Canada", "2nd Interview");
        appList.put("Travelers", "Rejected");
        appList.put("HP", "Rejected");
        appList.put("Slack", "Pending");
    }

    public static void addApps(HashMap<String, String> appList) {
        Scanner companyNameInput = new Scanner(System.in);
        System.out.println("Company Name: ");
        String companyName = companyNameInput.nextLine();

        Scanner status = new Scanner(System.in);
        System.out.println("Status: ");
        String companyStatus = status.nextLine();

        appList.put(companyName, companyStatus);
        printAppList(appList);
        // companyNameInput.close();
        // status.close();
    }

    public static void removeApps(HashMap<String, String> appList) {
        Scanner companyNameInput = new Scanner(System.in);
        System.out.println("Company Name: ");
        String companyName = companyNameInput.nextLine();
        appList.remove(companyName);
        printAppList(appList);
        // companyNameInput.close();

    }
}
