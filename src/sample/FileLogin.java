package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLogin {
    private List<String> logins = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private List<String> mails = new ArrayList<>();



    public List<String> getLogins() {
        return logins;
    }

    public void setLogins(List<String> logins) {
        this.logins = logins;
    }

    public List<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<String> passwords) {
        this.passwords = passwords;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    public void fileLogin() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("file.txt"));

        for (String line: lines){
            if (line.startsWith("login")){
                logins.add(line.substring(6));
            }
            if (line.startsWith("password")){
                passwords.add(line.substring(9));
            }
            if (line.startsWith("mail")){
                mails.add(line.substring(6));
            }
            if (line.startsWith("name")){
                names.add(line.substring(6));
            }
        }

    }
}

