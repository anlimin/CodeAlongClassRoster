package ca.limin.controller;

import ca.limin.Exception.ClassRosterDaoException;
import ca.limin.dao.ClassRosterDao;
import ca.limin.dao.ClassRosterDaoFileImpl;
import ca.limin.dto.Student;
import ca.limin.ui.ClassRosterView;
import ca.limin.ui.UserIO;
import ca.limin.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
   // private final ClassRosterView view = new ClassRosterView();
    private final UserIO io = new UserIOConsoleImpl();
    //private final ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private ClassRosterView view;
    private ClassRosterDao dao;

    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws ClassRosterDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1 -> listStudents();
                case 2 -> createStudent();
                case 3 -> viewStudent();
                case 4 -> removeStudent();
                case 5 -> keepGoing = false;
                default -> unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterDaoException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
