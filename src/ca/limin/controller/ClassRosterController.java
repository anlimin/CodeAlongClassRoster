package ca.limin.controller;

import ca.limin.dao.ClassRosterDao;
import ca.limin.dao.ClassRosterDaoFileImpl;
import ca.limin.dto.Student;
import ca.limin.ui.ClassRosterView;
import ca.limin.ui.UserIO;
import ca.limin.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
    private final ClassRosterView view = new ClassRosterView();
    private final UserIO io = new UserIOConsoleImpl();
    private final ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1 -> listStudents();
                case 2 -> createStudent();
                case 3 -> io.print("VIEW STUDENT");
                case 4 -> io.print("REMOVE STUDENT");
                case 5 -> keepGoing = false;
                default -> io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

}
