import java.io.*;

public class CheckTemp {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "\\sample.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", "Input", "Temperature", "Target Unit", "Student Response", "Grade");
            while ((line = br.readLine()) != null) {
                String[] token = line.split("\\s+");
                stringChk(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Taking all the input temperature, target unit and student's numeric response and prints out table like grading sheet.
     *
     * @param token Token of Input Temperature, Target Unit and Student's Numeric response
     */
    public static void stringChk (String[] token) {
        if(token.length == 4) {
            try {
                double temp = Double.parseDouble(token[0]);
                String tempUnit = token[1].toLowerCase();
                String targUnit = token[2].toLowerCase();
                double ans = Double.parseDouble(token[3]);

                if(tempUnit.equals("fahrenheit")) {
                    if(fahrenheit(temp, ans, targUnit)) {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "correct");
                    } else {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "incorrect");
                    }
                } else if(tempUnit.equals("celsius")) {
                    if(celsius(temp, ans, targUnit)) {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "correct");
                    } else {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "incorrect");
                    }
                } else if(tempUnit.equals("kelvin")) {
                    if(kelvin(temp, ans, targUnit)) {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "correct");
                    } else {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "incorrect");
                    }
                } else if(tempUnit.equals("rankine")) {
                    if(rankine(temp, ans, targUnit)) {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "correct");
                    } else {
                        System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "incorrect");
                    }
                } else {
                    System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "invalid");
                }
            } catch (NumberFormatException nfe) {
                System.out.printf("%-13s %-13s %-13s %-18s %-9s \n", token[0], token[1], token[2], token[3], "incorrect");
            }
        } else {
            for(int i = 0; i < token.length; i++) {
                if(i == token.length - 1) {
                    System.out.printf("%-18s %-9s \n", token[i], "invalid");
                } else if(i == 0) {
                    System.out.printf("%-28s", token[i]);
                } else {
                    System.out.printf("%-14s", token[i]);
                }
            }
        }
    }

    /**
     * This method checks if the student converted Fahrenheit to Celsius, Kelvin or Rankine correctly
     *
     * @param temp Input Temperature
     * @param ans Student Response
     * @param unit Target Units
     * @return true when unit-conversion done correctly. false when unit-conversion done incorrectly
     */
    public static boolean fahrenheit (double temp, double ans, String unit) {
        if (unit.equals("celsius")) {
            double celsius = (temp - 32) * (5f/9f);
            if(Math.round(celsius) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("kelvin")) {
            double kelvin = (temp - 32) * (5f/9f) + 273.15;
            if(Math.round(kelvin) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("rankine")) {
            double rankine = temp + 459.67;
            if(Math.round(rankine) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("fahrenheit")) {
            return Math.round(temp) == Math.round(ans);
        }
        return false;
    }

    /**
     * This method checks if the student converted Celsius to Fahrenheit, Kelvin or Rankine correctly
     *
     * @param temp Input Temperature
     * @param ans Student Response
     * @param unit Target Units
     * @return true when unit-conversion done correctly. false when unit-conversion done incorrectly
     */
    public static boolean celsius (double temp, double ans, String unit) {
        if (unit.equals("fahrenheit")) {
            double fahrenheit = (temp * (9f/5f)) + 32;
            if(Math.round(fahrenheit) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("kelvin")) {
            double kelvin = temp + 273.15;
            if(Math.round(kelvin) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("rankine")) {
            double rankine = temp * (9f/5f) + 491.67;
            if(Math.round(rankine) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("celsius")) {
            return Math.round(temp) == Math.round(ans);
        }
        return false;
    }

    /**
     * This method checks if the student converted Kelvin to Fahrenheit, Celsius, or Rankine correctly
     *
     * @param temp Input Temperature
     * @param ans Student Response
     * @param unit Target Units
     * @return true when unit-conversion done correctly. false when unit-conversion done incorrectly
     */
    public static boolean kelvin (double temp, double ans, String unit) {
        if (unit.equals("celsius")) {
            double celsius = temp - 273.15;
            if(Math.round(celsius) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("fahrenheit")) {
            double fahrenheit = (temp - 273.15) * (9f/5f) + 32;
            if(Math.round(fahrenheit) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("rankine")) {
            double rankine = temp * (9f/5f);
            if(Math.round(rankine) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("kelvin")) {
            return Math.round(temp) == Math.round(ans);
        }
        return false;
    }

    /**
     * This method checks if the student converted Rankine to Celsius, Fahrenheit or Kelvin correctly
     *
     * @param temp Input Temperature
     * @param ans Student Response
     * @param unit Target Units
     * @return true when unit-conversion done correctly. false when unit-conversion done incorrectly
     */
    public static boolean rankine (double temp, double ans, String unit) {
        if (unit.equals("celsius")) {
            double celsius = (temp - 491.67) * (5f/9f);
            if(Math.round(celsius) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("fahrenheit")) {
            double fahrenheit = temp - 459.67;
            if(Math.round(fahrenheit) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("kelvin")) {
            double kelvin = temp * (5f/9f);
            if(Math.round(kelvin) == Math.round(ans)) {
                return true;
            }
        }
        if (unit.equals("rankine")) {
            return Math.round(temp) == Math.round(ans);
        }
        return false;
    }
}
