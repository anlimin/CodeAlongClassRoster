package ca.limin;

import ca.limin.controller.ClassRosterController;
import ca.limin.dao.ClassRosterDao;
import ca.limin.dao.ClassRosterDaoFileImpl;
import ca.limin.ui.ClassRosterView;
import ca.limin.ui.UserIO;
import ca.limin.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller =
                new ClassRosterController(myDao, myView);
        controller.run();
    }
}
