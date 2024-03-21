package Newsletters;

import Users.User;

interface Subject {
    void registerObserver(User observer);
    void unregisterObserver(User observer);
    void notifyObservers();
}