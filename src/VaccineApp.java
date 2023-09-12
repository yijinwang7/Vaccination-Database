import java.sql.* ;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class VaccineApp {
    private static ResultSet rs;
    private static Connection con;
    private static Statement statement;

    private static void start() throws SQLException{
        boolean exits = true;
        while (exits) {
            Scanner s = new Scanner(System.in);
            System.out.println("VaccineApp Main Menu");
            System.out.println("1 Add a Person ");
            System.out.println("2 Assign a slot to a Person");
            System.out.println("3 Enter Vaccination information ");
            System.out.println("4 Exit Application ");
            System.out.println("Please Enter Your Option (1, 2, 3 or 4):");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    assignSlot();
                    break;
                case 3:
                    vaccinationInfo();
                    break;
                case 4:
                    System.out.println("You exit this application");
                    exits = false;
                    terminate();
                    break;
                default:
                    System.out.println("Invalid input");
                    start();
            }

        }
    }

    /*
    asks the user tp enter information for new person
     */
    private static void addPerson() throws SQLException {
        //String tableName = "Person";
        Scanner scanner = new Scanner(System.in);
        String hinum;
        String n;
        String gen;
        String dd;
        String phonenum;
        String c;
        String post;
        String street;
        String regd;
        String ctype;
        try {
            System.out.println("please enter the health insurance number:");
            hinum = scanner.nextLine();

            System.out.println("Please enter the name:");
            n = scanner.nextLine();

            System.out.println("Please enter the gender:");
            gen = scanner.nextLine().toLowerCase();

            System.out.println("Please enter the date of birth:");
            dd = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date = null;
            try {
                date = sdf.parse(dd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long time = date.getTime();
            java.sql.Date d = new Date(time);

            System.out.println("Please enter the phone number:");
            phonenum = scanner.nextLine();

            System.out.println("Please enter the city:");
            c = scanner.nextLine();

            System.out.println("Please enter the postalcd:");
            post = scanner.nextLine();

            System.out.println("Please enter the streetaddr:");
            street = scanner.nextLine();

            System.out.println("Please enter the registering date:");
            regd = scanner.nextLine();
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date2 = null;
            try {
                date2 = sdf2.parse(regd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long time2 = date2.getTime();
            java.sql.Date d2 = new Date(time2);

            System.out.println("Please enter the cname:");
            ctype = scanner.nextLine();

            if (check(hinum)) {
                System.out.println("This person is already exits, you could choose update the " +
                        "existing Person information with the newly entered details (yes/no) : ");
                String decision  = scanner.nextLine();

                if (decision.equals("yes")) {

                   //name
                    String updateSQL77 = "UPDATE Person" + " SET name = " + " '"+n+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL77);
                    statement.executeUpdate(updateSQL77);
                    System.out.println("DONE");

                    //gender
                    String updateSQL = "UPDATE Person" + " SET gender = " + " '"+gen+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL);
                    statement.executeUpdate(updateSQL);
                    System.out.println("DONE");

                    //date of birth
                    String updateSQL_0 = "UPDATE Person" + " SET dob = " + " '"+d+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_0);
                    statement.executeUpdate(updateSQL_0);
                    System.out.println("DONE");

                    //phone
                    String updateSQL_1 = "UPDATE Person" + " SET phone = " + " '"+phonenum+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_1);
                    statement.executeUpdate(updateSQL_1);
                    System.out.println("DONE");

                    //city
                    String updateSQL_2 = "UPDATE Person" + " SET city = " + " '"+c+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_2);
                    statement.executeUpdate(updateSQL_2);
                    System.out.println("DONE");

                    //postal code
                    String updateSQL_4 = "UPDATE Person" + " SET postalcd = " + " '"+post+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_4);
                    statement.executeUpdate(updateSQL_4);
                    System.out.println("DONE");

                    //street address
                    String updateSQL_5 = "UPDATE Person" + " SET streetaddr = " + " '"+street+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_5);
                    statement.executeUpdate(updateSQL_5);
                    System.out.println("DONE");

                    //register date
                    String updateSQL_6 = "UPDATE Person" + " SET regdate = " + " '"+d2+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_6);
                    statement.executeUpdate(updateSQL_6);
                    System.out.println("DONE");

                    //cname
                    String updateSQL_7 = "UPDATE Person" + " SET cname = " + " '"+ctype+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
                    System.out.println(updateSQL_7);
                    statement.executeUpdate(updateSQL_7);
                    System.out.println("DONE");

                }else{
                    return;
                }

            }else {

                //hinsurnum
                String insertSQL = "INSERT INTO Person" +
                        "(hinsurnum, name, gender, dob, phone, city, postalcd, streetaddr, regdate, cname)"
                        + " VALUES ( " + " '"+hinum+"'" + ", " + " '"+n+"'" + ", "
                        + " '"+gen+"'" + ", " + " '"+d+"'" + ", " + " '"+phonenum+"'" + "," + " '"+c+"'" + ", "
                        + " '"+post+"'" + ", " + " '"+street+"'" + ", " + " '"+d2+"'" + ", " + " '"+ctype+"'" + " )" ;
                System.out.println ( insertSQL ) ;
                statement.executeUpdate ( insertSQL ) ;
                System.out.println ( "DONE" ) ;


            }
        } catch (SQLException e) {
            // Variable to hold SQLCODE
            int sqlCode = e.getErrorCode(); // Get SQLCODE
            // Variable to hold SQLSTATE
            String sqlState = e.getSQLState(); // Get SQLSTATE

            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }
    public static boolean check(String hinum) throws SQLException {
        boolean exist = true;
        rs = statement.executeQuery("SELECT * FROM Person WHERE hinsurnum =" + " '"+hinum+"'");
        if (!rs.next()) {
            System.out.println("This person does not have any record.");
            exist = false;
        }
        rs.close();
        return exist;
    }


    private static void assignSlot() throws SQLException {
        /*
        System.out.println("Slot info:");
        String vSlot = sc.nextLine();
         */
        Scanner sc = new Scanner(System.in);
        String ln;
        String vaccDate;
        //locanme
        System.out.println("Please enter the Vaccination location name:");
        ln = sc.nextLine();

        //vdate
        System.out.println("Please enter the Vaccination date:");
        vaccDate = sc.nextLine();
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date3 = null;
        try {
            date3 = sdf3.parse(vaccDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time3 = date3.getTime();
        java.sql.Date d3 = new Date(time3);
        //check if the current input date is valid.
        try {
            if (d3.compareTo(sdf3.parse(sdf3.format(new java.util.Date()))) < 0) {
                System.out.println("This date is in the past. Please enter a valid date.");
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //vtime
        System.out.println("Please enter the Vaccination time:");
        String vt = sc.nextLine();
        //Time vt = Time.valueOf(tt);

        //vslot
        System.out.println("Please enter the Vaccination slot number:");
        int vsl = sc.nextInt();
        sc.nextLine();
        //check if this slot is valid
        if(!checkSlot(ln, d3, vt,vsl)){
            System.out.println("This is slot is already assigned.");
            return;
        }

        //hinsurnum
        System.out.println("Please enter the health insurance number:");
        String hin = sc.nextLine();

        //check if this person has enough doses
        if(checkEnough(hin)){
            System.out.println("This person can not be assign more doses.");
            return;
        }

        //assigndate
        System.out.println("Please enter the assigning date:");
        String aD = sc.nextLine();
        SimpleDateFormat sdf4 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date4 = null;
        try {
            date4 = sdf4.parse(aD);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time4 = date4.getTime();
        java.sql.Date d4 = new Date(time4);


        String insertSQL = "INSERT INTO VaccSlot" +
                "(locname,vdate,vtime,vslot, hinsurnum,asgndate)"
                + " VALUES ( " + " '" + ln + "'" + ", " + " '" + d3 + "'" + ", "
                + " '" + vt + "'" + ", " + vsl + ", " + " '" + hin + "'" + "," + " '" + d4 + "'"  + " )";
        System.out.println(insertSQL);
        try {
            statement.executeUpdate(insertSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("DONE");
    }

    public static boolean checkSlot(String lname, java.util.Date d3, String vt, int vsl) {
        boolean valid = false;
        try {
            rs = statement.executeQuery("SELECT * FROM VaccSlot WHERE locname =" + " '" + lname + "'"
                    + " AND vdate =" + " '" + d3 + "'" + " AND vtime =" + " '" + vt + "'" +
                    " AND vslot = " + vsl);
            if (!rs.next()) {
                //System.out.println("This is slot is already assigned.");
                valid = true;
            }
            rs.close();
        }catch (SQLException e)
        {
            int sqlCode = e.getErrorCode(); // Get SQLCODE
            String sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
        return valid;
    }

    public static boolean checkEnough(String hinum) {
        boolean enough = false;
        try {
            String query = "SELECT count(*) FROM VaccSlot WHERE hinsurnum =" + " '" + hinum + "'";
            int count = 0;
            //System.out.println(query);
            java.sql.ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                count = rs.getInt(1);
            }
            //get the brand of that vaccine
            String query1 = "SELECT vname FROM VaccSlot WHERE hinsurnum =" + " '" + hinum + "'";
            java.sql.ResultSet rs1 = statement.executeQuery(query1);
            String brand = null;
            if(rs1.next()) {
                brand = rs1.getString(1);
            }
            //get the number of doses needed for that vaccine
            String query2 = "SELECT doses FROM Vaccine WHERE vname =" + " '" + brand + "'";
            java.sql.ResultSet rs2 = statement.executeQuery(query2);
            int dose = 0;
            if(rs2.next()) {
                dose = rs2.getInt(1);
            }
            if (count == dose && count != 0) {
                enough = true;
            }
            rs.close();
        }  catch (SQLException e)
            {
                int sqlCode = e.getErrorCode(); // Get SQLCODE
                String sqlState = e.getSQLState(); // Get SQLSTATE

                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }

        return enough;
    }



    private static void vaccinationInfo() throws SQLException {
        Scanner ss = new Scanner(System.in);
        //hinsurnum
        System.out.println("Please enter the health insurance number:");
        String hinum = ss.nextLine();

        // nurse license num
        System.out.println("Please enter the nurse license number:");
        String linum = ss.nextLine();

        //vname
        System.out.println("Please enter the vaccine brand:");
        String vn = ss.nextLine();
        //check if the vaccine brand are the same

        if(!checkBrand(hinum, vn)){
            System.out.println("The brands of vaccine are not the same.");
            return;
        }

        //batchno
        System.out.println("Please enter the batch number:");
        String batch = ss.nextLine();

        //vialid
        System.out.println("Please enter the vial id:");
        String vial = ss.nextLine();

        //update license number
        String updateSQL10 = "UPDATE VaccSlot" + " SET licensenum = " + " '"+linum+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
        System.out.println(updateSQL10);
        statement.executeUpdate(updateSQL10);
        System.out.println("DONE");

        //update vname
        String updateSQL11 = "UPDATE VaccSlot" + " SET vname = " + " '"+vn+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
        System.out.println(updateSQL11);
        statement.executeUpdate(updateSQL11);
        System.out.println("DONE");

        //update batchno
        String updateSQL12 = "UPDATE VaccSlot" + " SET batchno = " + " '"+batch+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
        System.out.println(updateSQL12);
        statement.executeUpdate(updateSQL12);
        System.out.println("DONE");

        //update vialid
        String updateSQL17 = "UPDATE VaccSlot" + " SET vialid = " + " '"+vial+"'" + " WHERE hinsurnum = " + " '"+hinum+"'";
        System.out.println(updateSQL17);
        statement.executeUpdate(updateSQL17);
        System.out.println("DONE");


    }
    public static boolean checkBrand(String hinum, String vaccName) {
        boolean Brand_exist = false;
        String nnn = null;
        try {
            String query7 = "SELECT vname FROM VaccSlot WHERE hinsurnum =" + " '" + hinum + "'";
            //int count = 0;
            //System.out.println(query);
            java.sql.ResultSet rs7 = statement.executeQuery(query7);
            if(rs7.next()) {
                nnn = rs7.getString(1);
            }
            if(nnn != null && nnn.equals(vaccName)){
                Brand_exist = true;
            }
            rs7.close();
        }catch (SQLException e)
        {
            int sqlCode = e.getErrorCode(); // Get SQLCODE
            String sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
        return Brand_exist;
    }


    private static void terminate(){
        try {
            statement.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args){
        try{
            // Register the driver.  You must register the driver before you can use it.
            try { DriverManager.registerDriver ( new com.ibm.db2.jcc.DB2Driver() ) ; }
            catch (Exception cnfe){ System.out.println("Class not found"); }

            // This is the url you must use for DB2.
            //Note: This url may not valid now !
            String url = "jdbc:db2://winter2021-comp421.cs.mcgill.ca:50000/cs421";

            //REMEMBER to remove your user id and password before submitting your code!!
            String your_userid = "";
            String your_password = "";
            //AS AN ALTERNATIVE, you can just set your password in the shell environment in the Unix (as shown below) and read it from there.
            //$  export SOCSPASSWD=yoursocspasswd
            if(your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null)
            {
                System.err.println("Error!! do not have a password to connect to the database!");
                System.exit(1);
            }
            if(your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null)
            {
                System.err.println("Error!! do not have a password to connect to the database!");
                System.exit(1);
            }
            con = DriverManager.getConnection (url,your_userid,your_password) ;
            statement = con.createStatement ( ) ;
            start();
        }
        catch(Exception e) {
            System.err.println("Fail to connect to database");
            System.exit(1);
        }
    }
}