package classes;

import classes.database.*;
import classes.exceptions.*;

import java.io.*;
import java.nio.file.Paths;

public class CredentialsHandler {
    private static final String currentWorkingDirectory = Paths.get("").toAbsolutePath().toString();

    private static Admin currentWorkingAdmin;
    private static User currentWorkingUser;

    public static void initialize(){    //This function is to be called everytime the application is launched
        File adminsDirectory = new File(currentWorkingDirectory + "/admins");
        if (!adminsDirectory.exists()) {
            adminsDirectory.mkdirs();
        }

        File usersDirectory = new File(currentWorkingDirectory + "/users");
        if (!usersDirectory.exists()) {
            usersDirectory.mkdirs();
        }

        File imagesDirectory = new File(currentWorkingDirectory + "/images");
        if(!imagesDirectory.exists()){
            imagesDirectory.mkdirs();
        }
    }

    public static Admin getAdmin(){
        return currentWorkingAdmin;
    }

    public static User getUser(){return currentWorkingUser;}

    public static boolean checkCompanyAlreadyExists(String company, boolean isAdmin) {        //This function is used to check if there exists a database manager file with the same name. Returns true if it exists, else false
        try {
            if (isAdmin) {
                new FileReader(company + ".adm");
                return true;
            } else {
                new FileReader(company + ".usrm");
                return true;
            }
        } catch (FileNotFoundException e) {
            return true;
        }
    }

    public static boolean checkUsernameIsUnique(String username, boolean isAdmin) {       //This function is used to check if there exists a user with the same username. Returns true if unique, else false
        try {
            if (isAdmin) {
                new FileReader(currentWorkingDirectory + "/admins/" + username + ".ad");
                return false;
            } else {
                new FileReader(currentWorkingDirectory + "/users/" + username + ".usr");
                return false;
            }
        } catch (FileNotFoundException e) {
            return true;
        }
    }

    public static void initializeImageFolderFor(String carID, String carName){
        File carDirectory = new File(currentWorkingDirectory + "/images/" + carID + "_" + carName);
        if(!carDirectory.exists()){
            carDirectory.mkdirs();
        }
    }

    public static void updateImageFolderFor(String carID, String carNameIn, String carNameOut){
        File oldCarDirectory = new File(currentWorkingDirectory + "/images/" + carID + "_" + carNameIn);
        File newCarDirectory = new File(currentWorkingDirectory + "/images/" + carID + "_" + carNameOut);
        oldCarDirectory.renameTo(newCarDirectory);
    }

    public static void signUpAsAdmin(Admin admin) {        //This function is used to create .ad files for admins and register their entries onto the .adm file
        File adminFile = new File(currentWorkingDirectory + "/admins/" + admin.Username + ".ad");

        try {
            FileOutputStream fout = new FileOutputStream(adminFile);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(admin);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateAdmin(Admin admin) throws IOException{
        FileOutputStream fw = new FileOutputStream(currentWorkingDirectory + "/admins/" + getAdmin() + ".ad");
        ObjectOutputStream in = new ObjectOutputStream(fw);
        in.writeObject(admin);
        in.close();
    }

    public static void signUpAsUser(User user) {         //This function is used to login as User by checking the user files and the user manager file
        File userFile = new File(currentWorkingDirectory + "/users/" + user.Username + ".usr");

        try {
            FileOutputStream fout = new FileOutputStream(userFile);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String login(String username, String password) throws InvalidCredentialsException, AccountNotFoundException {       //This function is used to login to the desired account. If admin account, it returns 0. If user account, it returns 1. If account was not found, an AccountNotFoundException is thrown. If a password mismatch is found, an InvalidCredentialsException is thrown. If any exceptions, -1 is returned.
        boolean canBeUser = false;
        if (!canBeUser) {
            try {
                FileInputStream fin = new FileInputStream(currentWorkingDirectory + "/admins/" + username + ".ad");
                ObjectInputStream in = new ObjectInputStream(fin);
                Admin admin = (Admin) in.readObject();

                if (admin.Password.equals(password)) {
                    currentWorkingAdmin = admin;
                    return admin.CompanyName;
                }
                else {
                    throw new InvalidCredentialsException();
                }
            }
            catch (FileNotFoundException e) {
                canBeUser = true;
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (canBeUser) {
            try {
                FileInputStream fin = new FileInputStream(currentWorkingDirectory + "/users/" + username + ".usr");
                ObjectInputStream out = new ObjectInputStream(fin);
                User user = (User)out.readObject();

                if (user.Password.equals(password)) {
                    currentWorkingUser = user;
                    return user.CompanyName;
                }
                else {
                    throw new InvalidCredentialsException();
                }
            }
            catch (FileNotFoundException e) {
                throw new AccountNotFoundException();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}