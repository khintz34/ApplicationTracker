import java.util.HashMap;
import java.util.Scanner;

//todo figure out when to close the resource leaks
//todo add google firebase

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
            System.out.println("Next Action (Add, Remove, Update, Search, End): ");
            String action = whatsNext.nextLine();

            if (action.toLowerCase().equals("add")) {
                addApps(appList);
            } else if (action.toLowerCase().equals("remove")) {
                removeApps(appList);
            } else if (action.toLowerCase().equals("update")) {
                updateStatus(appList);
            } else if (action.toLowerCase().equals("search")) {
                searchForCompany(appList);
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
        String name = getCompanyName();
        String status = getStatus();

        appList.put(name, status);
        printAppList(appList);
    }

    public static void removeApps(HashMap<String, String> appList) {
        String name = getCompanyName();
        appList.remove(name);
        printAppList(appList);

    }

    public static void updateStatus(HashMap<String, String> appList) {
        String name = getCompanyName();
        System.out.println("Current Status: " + appList.get(name));
        String status = getStatus();
        appList.put(name, status);
        printAppList(appList);
    }

    public static void searchForCompany(HashMap<String, String> appList) {
        String name = getCompanyName();

        System.out.println("Company: " + name + " -- Status: " + appList.get(name));

    }

    public static String getCompanyName() {
        Scanner companyNameInput = new Scanner(System.in);
        System.out.println("Company Name: ");
        String companyName = companyNameInput.nextLine();

        return companyName;
    }

    public static String getStatus() {
        Scanner statusInput = new Scanner(System.in);
        System.out.println("New Status: ");
        String statusValue = statusInput.nextLine();

        return statusValue;
    }
}
