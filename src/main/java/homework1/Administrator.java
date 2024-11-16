package homework1;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private final String name;
    private final String password;
    protected List<Reader> blacklistedReaders;

    public Administrator(String name, String password) {
        this.name = name;
        this.password = password;
        this.blacklistedReaders = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getPassword() { return password; }

    public void blacklistReader(Reader reader) {

        if (!blacklistedReaders.contains(reader)) {
            blacklistedReaders.add(reader);
            System.out.println("The reader " + reader.getName() + " has been addded to the blacklist.");
        } else {
            System.out.println("The reader " + reader.getName() + " is already in the blacklist.");
        }
    }

    public void unblacklistReader(Reader reader) {
        if (blacklistedReaders.contains(reader)) {
            blacklistedReaders.remove(reader);
            System.out.println("The reader " + reader.getName() + " has been removed from the blacklist.");
        } else {
            System.out.println("The reader " + reader.getName() + " was not in the blacklist");
        }
    }

    public boolean isReaderBlacklisted(Reader reader) {
        return blacklistedReaders.contains(reader);
    }

    public void displayBlacklist() {
        System.out.println("Blacklisted readers:");
        for (Reader reader : blacklistedReaders) {
            System.out.println(reader);
        }
    }
}