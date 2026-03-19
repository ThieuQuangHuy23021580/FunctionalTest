package Testing;

public class CoffeeDiscount {

    public static int getDiscount(int hour, String userType) {

        if (hour < 1 || hour > 24) {
            throw new IllegalArgumentException("Input không hợp lệ");
        }

        if (!userType.equals("REGULAR") &&
                !userType.equals("MEMBER") &&
                !userType.equals("VIP")) {
            throw new IllegalArgumentException("Input không hợp lệ");
        }

        if (hour >=1 && hour <= 3) {
            switch (userType) {
                case "REGULAR": return 0;
                case "MEMBER": return 5;
                case "VIP": return 10;
            }
        }
        else if (hour >=4 && hour <= 6) {
            switch (userType) {
                case "REGULAR": return 5;
                case "MEMBER": return 10;
                case "VIP": return 15;
            }
        }
        else {
            switch (userType) {
                case "REGULAR": return 10;
                case "MEMBER": return 15;
                case "VIP": return 20;
            }
        }

        return 0;
    }
}
