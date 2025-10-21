package use_case.logout;
import data_access.DBUserDataAccessObject;
/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        // TODO: save the DAO and Presenter in the instance variables.
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // TODO: implement the logic of the Logout Use Case
        String username = userDataAccessObject.getCurrentUsername();
        // * set the current username to null in the DAO
        userDataAccessObject.setCurrentUsername(null);
        // * instantiate the `LogoutOutputData`, which needs to contain the username.
        LogoutOutputData outputData = new LogoutOutputData(username);
        // * tell the presenter to prepare a success view.
        logoutPresenter.prepareSuccessView(outputData);
    }
}

